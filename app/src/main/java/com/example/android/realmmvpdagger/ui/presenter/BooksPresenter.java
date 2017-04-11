package com.example.android.realmmvpdagger.ui.presenter;

/**
 * Presenter interface interacts with a BooksView implementation.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public interface BooksPresenter {
    void setView(Object view);

    void clearView();

    void onBookClick(int id);

    void onAddNewBookClick();
}
