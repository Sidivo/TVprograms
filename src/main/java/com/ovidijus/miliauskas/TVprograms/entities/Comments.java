package com.ovidijus.miliauskas.TVprograms.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Comments {
    private Integer id;
    private Integer personid;
    private Integer tvprogramid;
    private String text;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PERSONID", nullable = true, length = 255)
    public Integer getPersonid() {
        return personid;
    }

    public void setPersonid(Integer personid) {
        this.personid = personid;
    }

    @Basic
    @Column(name = "TVPROGRAMID", nullable = true, length = 255)
    public Integer getTvprogramid() {
        return tvprogramid;
    }

    public void setTvprogramid(Integer tvprogramid) {
        this.tvprogramid = tvprogramid;
    }

    @Basic
    @Column(name = "TEXT", nullable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments user = (Comments) o;
        return Objects.equals(id, user.id) && Objects.equals(personid, user.personid) && Objects.equals(tvprogramid, user.tvprogramid) && Objects.equals(text, user.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personid, tvprogramid, text);
    }
}