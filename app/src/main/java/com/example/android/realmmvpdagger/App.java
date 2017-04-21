package com.example.android.realmmvpdagger;

import android.app.Application;
import android.content.Context;

import com.example.android.realmmvpdagger.component.AppComponent;
import com.example.android.realmmvpdagger.component.DaggerAppComponent;
import com.example.android.realmmvpdagger.module.AppModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * App class provides configuration for the entire scope.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class App extends Application {

    private static AppComponent appComponent;
    private App app;
    private Context context;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        context = getApplicationContext();
        configureRealm();
        configureDagger();
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        appComponent.inject(this);
    }

    private void configureRealm() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public App getApp() {
        return app;
    }

    public Context getContext() {
        return this.context;
    }
}
