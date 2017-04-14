package com.example.android.realmmvpdagger.component;

import com.example.android.realmmvpdagger.App;
import com.example.android.realmmvpdagger.module.AppModule;
import com.example.android.realmmvpdagger.realm.RealmService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent is the injector class that assigns references in activities, services or fragments
 * giving access to singletons.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);

    RealmService realmService();
}
