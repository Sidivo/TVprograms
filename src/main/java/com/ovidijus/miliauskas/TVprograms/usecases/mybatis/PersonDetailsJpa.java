package com.ovidijus.miliauskas.TVprograms.usecases.mybatis;

import com.ovidijus.miliauskas.TVprograms.entities.Comments;
import com.ovidijus.miliauskas.TVprograms.entities.Person;
import com.ovidijus.miliauskas.TVprograms.entities.Tvprogram;
import com.ovidijus.miliauskas.TVprograms.persistence.CommentsDAO;
import com.ovidijus.miliauskas.TVprograms.persistence.PersonDAO;
import com.ovidijus.miliauskas.TVprograms.persistence.TvprogramDAO;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Model
public class PersonDetailsJpa {

    @Inject
    private PersonDAO personDAO;

    @Inject
    private TvprogramDAO tvprogramDAO;

    @Inject
    private CommentsDAO commentsDAO;

    @Getter
    private List<Tvprogram> myTvPrograms;

    @Getter
    private List<Tvprogram> allTvPrograms;

    @Getter
    private List<Comments> myComments;

    public PersonDetailsJpa() throws IOException {
    }

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(requestParameters.get("id"));
        Person person = personDAO.findOne(id);
        this.allTvPrograms = tvprogramDAO.loadAll();
        this.myTvPrograms = person.getTvprograms();
        this.myComments = person.getComments();

    }
}