package com.example.restservice.controllers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "name", nullable = false, length = 255)
    public String name;

    @Column(name = "bio", length = 32767)
    public String bio;
}
