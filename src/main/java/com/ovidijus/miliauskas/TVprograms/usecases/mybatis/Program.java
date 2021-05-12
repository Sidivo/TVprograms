package com.ovidijus.miliauskas.TVprograms.usecases.mybatis;

import com.ovidijus.miliauskas.TVprograms.mybatis.dao.CommentsMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.PersonMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.TvprogramMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Comments;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Person;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Tvprogram;
import com.ovidijus.miliauskas.TVprograms.usecases.MapperBuilder;
import lombok.Getter;
import lombok.Setter;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Model
public class Program {

    private final PersonMapper personMapper = MapperBuilder.buildMapper(PersonMapper.class);
    private final TvprogramMapper tvProgramMapper = MapperBuilder.buildMapper(TvprogramMapper.class);
    private final CommentsMapper commentsMapper = MapperBuilder.buildMapper(CommentsMapper.class);

    @Getter
    private Tvprogram myTvProgram;

    @Getter
    private List<Comments> comments;

    @Getter
    @Setter
    private Comments comment = new Comments();

    public Program() throws IOException {
    }

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer id = Integer.parseInt(requestParameters.get("id"));
        this.myTvProgram = tvProgramMapper.selectByPrimaryKey(id);
        this.comments = commentsMapper.selectAll().stream()
                .filter((comm) -> (comm.getTvprogramid().equals(this.myTvProgram.getId())))
                .collect(Collectors.toList());
        for (Comments value : this.comments) {
            value.setUsername(personMapper.selectByPrimaryKey(value.getPersonid()).getUsername());
        }
    }

    @Transactional
    public void addComment() {
        Comments newComment = new Comments();
        newComment.setPersonid(this.myTvProgram.getPersonid());
        newComment.setTvprogramid(this.myTvProgram.getId());
        newComment.setText(comment.getText());
        commentsMapper.insert(newComment);
    }
}
