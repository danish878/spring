package com.danish.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.danish.jpa.hibernate.entity.Course;
import com.danish.jpa.hibernate.entity.Review;
import com.danish.jpa.hibernate.entity.ReviewRating;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public Course save(Course course) {
        if (course.getId() == null)
            em.persist(course);
        else
            em.merge(course);

        return course;
    }

    public void addHardCodedReviewsForCourse() {
        // get course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}", course.getReviews());

        // add 2 reviews to it
        Review review1 = new Review(ReviewRating.THREE, "bas thek hy");
        Review review2 = new Review(ReviewRating.ONE, "ghatiya course tha");

        // setting the relationship
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        // save it to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {
        // Get course
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());

        // Add reviews to it
        for (Review review : reviews) {
            // Setting the relationship
            course.addReview(review);
            review.setCourse(course);

            // save it to the database
            em.persist(review);
        }
    }

}
