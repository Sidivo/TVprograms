package com.ovidijus.miliauskas.TVprograms.persistence;

import com.ovidijus.miliauskas.TVprograms.entities.Tvprogram;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class TvprogramDAO {

    @Inject
    private EntityManager em;

    public List<Tvprogram> loadAll() {
        return em.createNamedQuery("Tvprogram.findAll", Tvprogram.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Tvprogram tvprogram){
        this.em.persist(tvprogram);
    }

    public Tvprogram findOne(Integer id) {
        return em.find(Tvprogram.class, id);
    }
}
