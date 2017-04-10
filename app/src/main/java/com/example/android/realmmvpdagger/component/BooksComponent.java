package com.example.android.realmmvpdagger.component;

import com.example.android.realmmvpdagger.BooksApplication;
import com.example.android.realmmvpdagger.module.BooksModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * BooksComponent is the injector class. It assigns references in activities,
 * services or fragments giving access to singletons.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Singleton
@Component(modules = BooksModule.class)
public interface BooksComponent {
    void inject(BooksApplication booksApplication);
}
