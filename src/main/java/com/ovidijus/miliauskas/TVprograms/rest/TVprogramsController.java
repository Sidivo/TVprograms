package com.ovidijus.miliauskas.TVprograms.rest;

import com.ovidijus.miliauskas.TVprograms.mybatis.dao.CommentsMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.PersonMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.dao.TvprogramMapper;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Comments;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Person;
import com.ovidijus.miliauskas.TVprograms.mybatis.model.Tvprogram;
import com.ovidijus.miliauskas.TVprograms.persistence.PersonDAO;
import com.ovidijus.miliauskas.TVprograms.rest.contracts.CommentDto;
import com.ovidijus.miliauskas.TVprograms.rest.contracts.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/")
public class TVprogramsController {

    @Inject
    @Setter
    @Getter
    // JPA
    private PersonDAO personDAO;
    // MyBatis
    private final PersonMapper personMapper;
    private final TvprogramMapper tvprogramMapper;
    private final CommentsMapper commentsMapper;

    public TVprogramsController() throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("MyBatisConfig.xml")).openSession();
        personMapper = session.getMapper(PersonMapper.class);
        tvprogramMapper = session.getMapper(TvprogramMapper.class);
        commentsMapper = session.getMapper(CommentsMapper.class);
    }

    @Path("/login")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDto loginDto) {
        if(personMapper.selectAll().stream()
                .filter(person -> person.getUsername().equals(loginDto.getUsername())).collect(Collectors.toList())
                .get(0).getPassword().equals(loginDto.getPassword()))
        {
            return Response.ok().build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    @Path("/tvprogram")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTvprograms() {
        return Response.ok(tvprogramMapper.selectAll()).build();
    }

    @Path("/tvprogram/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTvprogram(@PathParam("id") final Integer id) {
        return Response.ok(tvprogramMapper.selectByPrimaryKey(id)).build();
    }

    @Path("/tvprogram/{id}/comments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTvprogramComments(@PathParam("id") final Integer id) {
        List<Comments> comments = commentsMapper.selectAll().stream()
                .filter(comment -> comment.getTvprogramid().equals(id))
                .collect(Collectors.toList());

        return Response.ok(comments).build();
    }

    @Path("/person/{id}/tvprogram")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonTvprogram(@PathParam("id") final Integer id) {
        List<Tvprogram> tvprograms = tvprogramMapper.selectAll().stream()
                .filter(tvprogram -> tvprogram.getPersonid().equals(id))
                .collect(Collectors.toList());
        return Response.ok(tvprograms).build();
    }

    @Path("/comments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments() {

        return Response.ok(commentsMapper.selectAll()).build();
    }


    @Path("/person/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Person person = personMapper.selectByPrimaryKey(id);
        if (person == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(person).build();
    }

    @Path("/tvprogram/{id}/comment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id, CommentDto commentDto) {
        Comments comment = new Comments();
        comment.setId(commentsMapper.selectAll().get(commentsMapper.selectAll().size()-1).getId()+1);
        comment.setPersonid(commentDto.getPersonId());
        comment.setTvprogramid(id);
        comment.setText(commentDto.getText());

        return Response.ok().build();
    }


}