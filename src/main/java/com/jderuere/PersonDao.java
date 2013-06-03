package com.jderuere;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Home object for domain model class Person.
 * 
 * @see com.jderuere.Person
 * @author DERUERE Julien
 */
@Repository
public class PersonDao {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;

	public Person persist(Person transientInstance) {
        try {
            return entityManager.merge(transientInstance);
        } catch (RuntimeException re) {
            throw re;
        }
	}

    public Person findById(Long id) {
        try {
            Person instance = entityManager.find(Person.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }
}