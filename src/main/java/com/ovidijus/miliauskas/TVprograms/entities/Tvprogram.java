package com.ovidijus.miliauskas.TVprograms.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Tvprogram.findAll", query = "select t from Tvprogram as t")
})
@Table(name = "TVPROGRAM")
@Getter
@Setter
@AllArgsConstructor
public class Tvprogram {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "TITLE")
    private String title;

    @Basic
    @Column(name = "VIEWS")
    private String views;

    @ManyToMany(mappedBy = "tvprograms")
    private List<Person> persons;

    @OneToMany(mappedBy = "tvprogram")
    private List<Comments> comments = new ArrayList<>();

    public Tvprogram() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tvprogram user = (Tvprogram) o;
        return Objects.equals(id, user.id) && Objects.equals(title, user.title) && Objects.equals(views, user.views);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, views);
    }
}