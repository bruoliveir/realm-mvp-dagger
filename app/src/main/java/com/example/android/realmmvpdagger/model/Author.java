package com.example.android.realmmvpdagger.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Author model.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

class Author extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;
    private String lastName;
    private RealmList<Book> books;
}
