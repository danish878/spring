package com.danish.jpa.hibernate;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danish.jpa.hibernate.repository.CourseRepository;
import com.danish.jpa.hibernate.repository.EmployeeRepository;
import com.danish.jpa.hibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 -> {}", course);
//		courseRepository.deleteById(10001L);
//		logger.info("Inserting -> {}", courseRepository.save(new Course("Docker in 10 steps")));
//
//		studentRepository.saveStudentWithPassport();
//		studentRepository.someTest();
//
//		List<Review> reviews = new ArrayList<>();
//		reviews.add(new Review(ReviewRating.THREE, "bas thek hy"));
//		reviews.add(new Review(ReviewRating.ONE, "ghatiya course tha"));
//
//		courseRepository.addReviewsForCourse(10003L, reviews);
//
//		Student student = new Student("Jack");
//		course = new Course("Microservices in 100 steps");
//		
//		studentRepository.insertStudentAndCourse(student, course);
//
//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//
//		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
    }

}
