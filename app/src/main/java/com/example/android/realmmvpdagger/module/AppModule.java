package com.example.android.realmmvpdagger.module;

import com.example.android.realmmvpdagger.component.BooksComponent;
import com.example.android.realmmvpdagger.realm.RealmService;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * AppModule defines what objects should be included as part of the dependency chain.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Module(subcomponents = BooksComponent.class)
public class AppModule {

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    RealmService provideRealmService(final Realm realm) {
        return new RealmService(realm);
    }
}
