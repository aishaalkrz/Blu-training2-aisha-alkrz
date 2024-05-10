package com.aisha.Project_backEnd;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;



import com.aisha.Project_backEnd.model.Book;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
    	Configuration config = new Configuration();
        config.configure(); 
        config.addAnnotatedClass(Book.class);
        
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory;

    }
}

