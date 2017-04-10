package com.example.android.realmmvpdagger.module;

import com.example.android.realmmvpdagger.BooksApplication;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * BooksModule defines what objects should be included
 * as part of the dependency chain.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Module
public class BooksModule {

    private BooksApplication booksApplication;

    public BooksModule(BooksApplication booksApplication) {
        this.booksApplication = booksApplication;
    }

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
