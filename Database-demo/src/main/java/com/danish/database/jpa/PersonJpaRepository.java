package com.danish.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.danish.database.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        Query namedQuery = entityManager.createNamedQuery("find_all_persons");
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }
}
