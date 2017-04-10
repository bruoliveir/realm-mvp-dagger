package com.example.android.realmmvpdagger;

import android.app.Application;
import android.content.Context;

import com.example.android.realmmvpdagger.component.BooksComponent;
import com.example.android.realmmvpdagger.component.DaggerBooksComponent;
import com.example.android.realmmvpdagger.module.BooksModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * BooksApplication class provides configuration for the entire scope.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class BooksApplication extends Application {

    private static BooksApplication booksApplication;
    private static BooksComponent booksComponent;
    private Context context;

    public static BooksComponent getComponent() {
        return booksComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        booksApplication = this;
        context = getApplicationContext();
        configureRealm();
        configureDagger();
    }

    private void configureDagger() {
        booksComponent = DaggerBooksComponent.builder()
                .booksModule(new BooksModule(this))
                .build();
        booksComponent.inject(this);
    }

    private void configureRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .inMemory()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public Context getContext() {
        return this.context;
    }
}
