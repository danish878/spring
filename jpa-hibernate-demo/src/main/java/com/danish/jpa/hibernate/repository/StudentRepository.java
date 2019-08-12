package com.danish.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.danish.jpa.hibernate.entity.Course;
import com.danish.jpa.hibernate.entity.Passport;
import com.danish.jpa.hibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public Student save(Student student) {
        if (student.getId() == null)
            em.persist(student);
        else
            em.merge(student);

        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");

        student.setPassport(passport);
        em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        student.addCourse(course);
        course.addStudent(student);

        em.persist(course);
        em.persist(student);
    }

    public void someTest() {
        // Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 2L);

        // Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();

        // Database Operation 3 - Update passport
        passport.setNumber("E123456 - updated");

        // Database Operation 4 - Update student
        student.setName("Danish - Updated");

    }
}
