package com.ovidijus.miliauskas.TVprograms.usecases.mybatis;

import com.ovidijus.miliauskas.TVprograms.mybatis.dao.PersonMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Person;
import com.ovidijus.miliauskas.TVprograms.usecases.MapperBuilder;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.inject.Model;
import java.io.IOException;
import java.util.stream.Collectors;

@Model
public class Login {

    private final PersonMapper personMapper = MapperBuilder.buildMapper(PersonMapper.class);

    @Getter
    @Setter
    private Person loginDetails = new Person();

    public Login() throws IOException {
    }

    public String login() {
        Person person = personMapper.selectAll().stream().filter((prs) -> (loginDetails.getUsername().equals(prs.getUsername())))
                .collect(Collectors.toList()).get(0);
        if(person.getPassword().equals(loginDetails.getPassword())) {
            return "personDetails?faces-redirect=true&id=" + person.getId();
        }
        return "index?faces-redirect=true";
    }
}