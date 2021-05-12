package com.ovidijus.miliauskas.TVprograms.persistence;

import com.ovidijus.miliauskas.TVprograms.entities.Comments;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CommentsDAO {

    @Inject
    private EntityManager em;

    public List<Comments> loadAll() {
        return em.createNamedQuery("Comments.findAll", Comments.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Comments comments){
        this.em.persist(comments);
    }

    public Comments findOne(Integer id) {
        return em.find(Comments.class, id);
    }
}
