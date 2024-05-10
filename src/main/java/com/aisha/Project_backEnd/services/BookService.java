package com.aisha.Project_backEnd.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aisha.Project_backEnd.model.Book;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;

@Service
public class BookService {

	
    private SessionFactory sessionFactory;
    
    public BookService(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book create(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        transaction.commit();

        session.close();

        return book;
    }
    
    public List<Book> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Book> allBooks = session.createQuery("FROM Book", Book.class).list();

        transaction.commit();
        session.close();

        return allBooks;
    }
    
    public Book getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);
        transaction.commit();
        session.close();

        return (book);
    }

    public List<Book> searchBooks(String keyword) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder(); // Import added
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            Root<Book> root = criteriaQuery.from(Book.class);

            criteriaQuery.select(root)
                    .where(criteriaBuilder.or(
                            criteriaBuilder.like(root.get("title"), "%" + keyword + "%"),
                            criteriaBuilder.like(root.get("author"), "%" + keyword + "%")
                    ));

            List<Book> matchingBooks = session.createQuery(criteriaQuery).getResultList();

            transaction.commit();

            return matchingBooks;
        }
    }
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book bookToDelete = session.get(Book.class, id);

        if (bookToDelete != null) {
            session.remove(bookToDelete); // Using the preferred delete method
        }

        transaction.commit();
        session.close();
          }
}



