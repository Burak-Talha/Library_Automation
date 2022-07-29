package com.example.libraryautomation.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name="Post")
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

}
