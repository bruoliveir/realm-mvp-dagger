package com.example.android.realmmvpdagger.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Book model.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class Book extends RealmObject {

    @PrimaryKey private int id;

    private String isbn;
    private String title;
    private Author author;
    private Publisher publisher;

    public Book() {
        // required
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
