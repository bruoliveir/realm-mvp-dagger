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

    @PrimaryKey
    private int id;

    private String isbn;
    private String title;
    private Author author;
    private Publisher publisher;
}
