package com.example.android.realmmvpdagger.realm;

import com.example.android.realmmvpdagger.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Service handles Realm database modification and management.
 *
 * Created by Bruno Oliveira on 14/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class RealmService {

    private final Realm mRealm;

    public RealmService(final Realm mRealm) {
        this.mRealm = mRealm;
    }

    public void closeRealm() {
        mRealm.close();
    }

    public RealmResults<Book> getAllBooks() {
        return mRealm.where(Book.class).findAll();
    }
}
