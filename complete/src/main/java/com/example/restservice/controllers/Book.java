package com.example.restservice.controllers;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Book {

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "title", nullable = false, length = 255)
    public String title;

    @Column(name = "isbn", nullable = false, length = 13)
    public String isbn;

    @Column(name = "publishedDate")
    @Temporal(TemporalType.DATE)
    public Date publishedDate;

    @ManyToOne()
    public Author author;
}
