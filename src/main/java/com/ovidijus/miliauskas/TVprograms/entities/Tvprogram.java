package com.ovidijus.miliauskas.TVprograms.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tvprogram {
    private Integer id;
    private String title;
    private String views;
    private Integer personid;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "VIEWS", nullable = true, length = 255)
    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    @Basic
    @Column(name = "PERSONID", nullable = true, length = 255)
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tvprogram user = (Tvprogram) o;
        return Objects.equals(id, user.id) && Objects.equals(title, user.title) && Objects.equals(views, user.views) && Objects.equals(personid, user.personid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, views, personid);
    }
}