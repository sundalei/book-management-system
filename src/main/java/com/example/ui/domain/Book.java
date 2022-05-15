package com.example.ui.domain;

import java.util.List;

import lombok.Data;

@Data
public class Book {

    private String id;

    private String title;

    private String author;

    private int publishYear;

    private List<String> tags;
}
