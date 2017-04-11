package com.example.android.realmmvpdagger.module;

import com.example.android.realmmvpdagger.ui.BooksPresenterImpl;
import com.example.android.realmmvpdagger.ui.presenter.BooksPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * BooksModule defines what objects should be included as dependencies in a BooksView
 * implementation.
 *
 * Created by Bruno Oliveira on 08/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Module
public class BooksModule {

    @Provides
    BooksPresenter provideBooksPresenter() {
        return new BooksPresenterImpl();
    }
}
