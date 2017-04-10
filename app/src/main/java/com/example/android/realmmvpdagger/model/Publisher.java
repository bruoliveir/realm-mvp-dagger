package com.example.android.realmmvpdagger.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Publisher model.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class Publisher extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;
    private RealmList<Book> books;

    public Publisher() {
        // required
    }
}
