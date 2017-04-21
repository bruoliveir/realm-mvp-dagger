package com.example.android.realmmvpdagger.component;

import com.example.android.realmmvpdagger.module.BooksModule;
import com.example.android.realmmvpdagger.scope.ActivityScope;
import com.example.android.realmmvpdagger.ui.BooksViewImpl;

import dagger.Subcomponent;

/**
 * BooksComponent is an injector class that assigns references in BooksView implementations.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

@ActivityScope
@Subcomponent(modules = BooksModule.class)
public interface BooksComponent {
    void inject(BooksViewImpl booksViewImpl);

    @Subcomponent.Builder
    interface Builder {
        Builder booksModule(BooksModule booksModule);
        BooksComponent build();
    }
}
