package com.ovidijus.miliauskas.TVprograms.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Comments.findAll", query = "select t from Comments as t")
})
@Table(name = "COMMENTS")
@Getter
@Setter
@AllArgsConstructor
public class Comments {

    public Comments() {

    }

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "TEXT")
    private String text;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="PERSONID")
    private Person person;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="TVPROGRAMID")
    private Tvprogram tvprogram;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments user = (Comments) o;
        return Objects.equals(id, user.id) && Objects.equals(text, user.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}