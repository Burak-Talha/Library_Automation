package com.example.libraryautomation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "id", nullable = true)
    private Author author;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Library> libraries;

    void setLibraries(List<Library> libraries){
        this.libraries = libraries;
    }

}