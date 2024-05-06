package com.aisha.Project_backEnd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
        System.out.println("Hello world !");

        // Create session factory
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        // Create session
        Session session = sf.openSession();
        session.beginTransaction();

          System.out.println("Successfuly");
            
            session.getTransaction().commit();
            session.close();
            sf.close();
      
        }
    

}
