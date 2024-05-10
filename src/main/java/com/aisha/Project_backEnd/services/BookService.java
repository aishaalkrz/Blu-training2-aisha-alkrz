package com.aisha.Project_backEnd.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aisha.Project_backEnd.model.Book;

@Service
public class BookService {

	
    private SessionFactory sessionFactory;
    
    public BookService(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Book createBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book);
        transaction.commit();

        session.close();

        return book;
    }
    
    public List<Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Book> allBooks = session.createQuery("FROM Book", Book.class).list();

        transaction.commit();
        session.close();

        return allBooks;
    }
    
    public Book getBookById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Book book = session.get(Book.class, id);
        transaction.commit();
        session.close();

        return (book);
    }

}



