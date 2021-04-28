package com.ovidijus.miliauskas.TVprograms.usecases;

import lombok.Getter;
import lombok.Setter;
import com.ovidijus.miliauskas.TVprograms.persistence.PersonDAO;
import com.ovidijus.miliauskas.TVprograms.entities.Person;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Persons {

    @Inject
    private PersonDAO personDAO;

    @Getter @Setter
    private Person personToCreate = new Person();

    @Getter
    private List<Person> allPersons;

    @PostConstruct
    public void init(){
        loadAllPersons();
    }

    @Transactional
    public String createPerson(){
        this.personDAO.persist(personToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllPersons(){
        this.allPersons = personDAO.loadAll();
    }
}