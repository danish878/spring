package com.danish.jpa.hibernate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danish.jpa.hibernate.entity.Address;
import com.danish.jpa.hibernate.entity.Course;
import com.danish.jpa.hibernate.entity.Passport;
import com.danish.jpa.hibernate.entity.Student;
import com.danish.jpa.hibernate.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentWithPassportDetails() {
        Student student = em.find(Student.class, 20001);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void setAddressDetails() {
        Student student = em.find(Student.class, 20001L);
        student.setAddress(new Address("Line 1", "Line 2", "City"));
        em.flush();
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001);
        logger.info("Passport -> {}", passport);
        logger.info("Associated Student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = em.find(Student.class, 20001L);
        logger.info("Student -> {}", student);
        logger.info("Courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    public void retrieveCourseAndStudents() {
        Course course = em.find(Course.class, 10001L);
        logger.info("Course -> {}", course);
        logger.info("Students -> {}", course.getStudents());
    }

    @Test
    @Transactional
    public void someTest() {
        // Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);

        // Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();

        // Database Operation 3 - Update passport
        passport.setNumber("E123456");

        // Database Operation 4 - Update student
        student.setName("Danish - Updated");

    }

}
