package com.danish.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danish.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    //@Test
    public void jpql_courses_without_students() {
        System.out.println("**************************START***************************************");
        TypedQuery<Course> query =
                em.createQuery("Select c from Course c where c.students is empty",
                        Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c from Course c where c.students is empty -> {}", resultList);
        System.out.println("***************************END**************************************");
    }

    //@Test
    public void jpql_courses_ordered_by_students() {
        System.out.println("**************************START***************************************");
        TypedQuery<Course> query =
                em.createQuery("Select c from Course c order by size(c.students) desc",
                        Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Select c from Course c where c.students is empty -> {}", resultList);
        System.out.println("***************************END**************************************");
    }

    @Test
    public void join() {
        Query query = em.createQuery("Select c, s From Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();

        logger.info("Result Size -> {}", resultList.size());

        for (Object[] result : resultList) {
            logger.info("Course {} Student {}", result[0], result[1]);
        }
    }

}
