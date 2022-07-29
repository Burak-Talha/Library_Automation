package com.example.libraryautomation.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name="Tag")
@Table(name="tag")
public class Tag {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

}
