package com.example.libraryautomation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name="Author")
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    List<Book> books;

}
