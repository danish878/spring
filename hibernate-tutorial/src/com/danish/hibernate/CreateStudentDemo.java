package com.danish.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.danish.hibernate.entity.Student;

public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration().configure()
                .addAnnotatedClass(Student.class).buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            /************ use the session object to save Java object **************/

            // create a student object
            System.out.println("Creating new student object...");
            Student student = new Student("Paul", "Wall", "paulwall@abc.com");

            // start a transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }

    }

}
