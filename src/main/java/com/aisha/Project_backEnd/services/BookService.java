package com.aisha.Project_backEnd.services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	
    private SessionFactory sessionFactory;
    
    public BookService(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}



