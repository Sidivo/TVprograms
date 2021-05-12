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
        @NamedQuery(name = "Person.findAll", query = "select t from Person as t")
})
@Table(name = "PERSON", schema = "PUBLIC")
@Getter
@Setter
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "USERNAME")
    private String username;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "COMMENTS",
            joinColumns =  @JoinColumn(name = "PERSONID"),
            inverseJoinColumns = @JoinColumn(name = "TVPROGRAMID")
    )
    List<Tvprogram> tvprograms;

    @OneToMany(mappedBy = "person")
    private List<Comments> comments = new ArrayList<>();

    public Person() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person account = (Person) o;
        return Objects.equals(id, account.id) && Objects.equals(username, account.username) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}