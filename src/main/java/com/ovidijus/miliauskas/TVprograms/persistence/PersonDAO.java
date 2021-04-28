package com.ovidijus.miliauskas.TVprograms.persistence;

import com.ovidijus.miliauskas.TVprograms.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonDAO {

    @Inject
    private EntityManager em;

    public List<Person> loadAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Person person){
        this.em.persist(person);
    }

    public Person findOne(Integer id) {
        return em.find(Person.class, id);
    }
}