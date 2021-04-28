package com.ovidijus.miliauskas.TVprograms.usecases;

import com.ovidijus.miliauskas.TVprograms.mybatis.model.Person;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.PersonMapper;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class PersonsMyBatis {
    @Inject
    private PersonMapper personMapper;

    @Getter
    private List<Person> allPersons;

    @Getter @Setter
    private Person personToCreate = new Person();

    @PostConstruct
    public void init() {
        this.loadAllPersons();
    }

    private void loadAllPersons() {
        this.allPersons = personMapper.selectAll();
    }

    @Transactional
    public String createPerson() {
        //teamMapper.selectByPrimaryKey(1).getTeams();
        personMapper.insert(personToCreate);
        return "/mybatispage/persons?faces-redirect=true";
    }
}