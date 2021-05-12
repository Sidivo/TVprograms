package com.ovidijus.miliauskas.TVprograms.usecases.mybatis;

import com.ovidijus.miliauskas.TVprograms.mybatis.dao.CommentsMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.PersonMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.TvprogramMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Comments;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Person;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Tvprogram;
import com.ovidijus.miliauskas.TVprograms.usecases.MapperBuilder;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
public class PersonDetails {

    private final PersonMapper personMapper = MapperBuilder.buildMapper(PersonMapper.class);
    private final TvprogramMapper tvProgramMapper = MapperBuilder.buildMapper(TvprogramMapper.class);
    private final CommentsMapper commentsMapper = MapperBuilder.buildMapper(CommentsMapper.class);

    @Getter
    private List<Tvprogram> myTvPrograms;

    @Getter
    private List<Tvprogram> allTvPrograms;

    @Getter
    private List<Comments> myComments;

    public PersonDetails() throws IOException {
    }

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(requestParameters.get("id"));
        Person person = personMapper.selectByPrimaryKey(id);
        this.allTvPrograms = tvProgramMapper.selectAll();
        this.myTvPrograms = this.allTvPrograms.stream()
                .filter((tvprogram) -> tvprogram.getPersonid() == id)
                .collect(Collectors.toList());
        this.myComments = commentsMapper.selectAll().stream()
                .filter((cmt) -> (cmt.getPersonid() == id))
                .collect(Collectors.toList());
        for(Comments comm : myComments) {
            if(this.allTvPrograms.stream().anyMatch((prog) -> (prog.getId().equals(comm.getTvprogramid()))))
            this.allTvPrograms.get(this.allTvPrograms.stream().filter((prog) -> (prog.getId().equals(comm.getTvprogramid()))).collect(Collectors.toList()).get(0).getId())
                    .addComment(comm);
        }

    }
}