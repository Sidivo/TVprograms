package com.ovidijus.miliauskas.TVprograms.usecases.mybatis;

import com.ovidijus.miliauskas.TVprograms.entities.Person;
import com.ovidijus.miliauskas.TVprograms.entities.Tvprogram;
import com.ovidijus.miliauskas.TVprograms.persistence.PersonDAO;
import com.ovidijus.miliauskas.TVprograms.persistence.TvprogramDAO;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.stream.Collectors;

@Model
public class LoginJpa {

    @Inject
    private PersonDAO personDAO;

    @Inject
    private TvprogramDAO tvprogramDAO;

    @Getter
    @Setter
    private Person loginDetails = new Person();

    public LoginJpa() {
    }

    @Transactional
    public String login() {
        try {
            if (personDAO.loadAll().stream().filter(person -> person.getUsername().equals(loginDetails.getUsername())).collect(Collectors.toList()).get(0).getPassword()
                    .equals(loginDetails.getPassword())) {
                return "personDetailsJpa?faces-redirect=true&id=" + personDAO.loadAll().stream().filter(person -> person.getUsername().equals(loginDetails.getUsername())).collect(Collectors.toList()).get(0).getId();
            }
            return "indexJpa?faces-redirect=true";
        } catch(NullPointerException | IndexOutOfBoundsException ex) {
            Person person = new Person();
            person.setUsername("test1");
            person.setPassword("123a");
            personDAO.persist(person);
            Tvprogram prog = new Tvprogram();
            prog.setTitle("Avengers");
            prog.setViews("10");
            prog.setPersons(Collections.singletonList(person));
            tvprogramDAO.persist(prog);
            return login();
        }
    }
}