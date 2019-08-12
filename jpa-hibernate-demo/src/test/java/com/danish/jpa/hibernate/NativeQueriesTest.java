package com.danish.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.danish.jpa.hibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NativeQueriesTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    EntityManager em;

    @Test
    public void native_queries_basic() {
        Query query = em.createNativeQuery("SELECT * FROM course", Course.class);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM course -> {}", resultList);
    }

    @Test
    public void native_queries_with_parameter() {
        Query query = em.createNativeQuery("SELECT * FROM course WHERE id = ?", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("SELECT * FROM course WHERE id = ? -> {}", resultList);
    }

    @Test
    @Transactional
    public void native_queries_to_update() {
        Query query = em.createNativeQuery("UPDATE course SET last_updated_date = sysdate()", Course.class);
        int noOfRowsUpdated = query.executeUpdate();
        logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
    }


}
