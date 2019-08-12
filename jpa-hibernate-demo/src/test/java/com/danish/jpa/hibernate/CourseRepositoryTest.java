package com.danish.jpa.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.danish.jpa.hibernate.entity.Course;
import com.danish.jpa.hibernate.entity.Review;
import com.danish.jpa.hibernate.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

    @Test
    public void findById_basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    @DirtiesContext
    public void deleteById_basic() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    public void save_basic() {
        // Get a course
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 steps", course.getName());

        //update details
        course.setName("JPA in 50 steps - Updated");
        repository.save(course);

        // Check the value
        Course course1 = repository.findById(10001L);
        assertEquals("JPA in 50 steps - Updated", course1.getName());
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10001L);

        System.out.println("*******************************************");
        for (Review review : course.getReviews()) {
            System.out.println(review.getDescription());
        }
        System.out.println("*******************************************");
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 50001L);

        System.out.println("*******************************************");
        System.out.println(review.getCourse().getName());
        System.out.println("*******************************************");
    }
}
