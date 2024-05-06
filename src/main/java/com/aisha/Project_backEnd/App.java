package com.aisha.Project_backEnd;

import java.util.List;

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

        // Fetch all students
        List<Student> students = session.createQuery("from Student", Student.class).getResultList();

        // Print retrieved students
        System.out.println("Retrieved students:");
        for (Student student : students) {
            System.out.println(student);
        }
            
            session.getTransaction().commit();
            session.close();
            sf.close();
      
        }
    

}
