package com.example.android.realmmvpdagger.ui;

import com.example.android.realmmvpdagger.ui.presenter.BooksPresenter;
import com.example.android.realmmvpdagger.ui.view.BooksView;

/**
 * BooksPresenter implementation handles actions received through a BooksView implementation.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class BooksPresenterImpl implements BooksPresenter {

    private BooksView booksView = new BooksView.EmptyView();

    private boolean booksWereShown = false;

    @Override
    public void setView(Object view) {
        booksView = (BooksView) view;
        showBooksIfNeeded();
    }

    private void showBooksIfNeeded() {
        if (!booksWereShown) {
//            booksView.showBooks();
            booksWereShown = true;
        }
    }

    @Override
    public void clearView() {
        booksView = new BooksView.EmptyView();
    }

    @Override
    public void onBookClick(int id) {
        booksView.showBookDetailView(id);
    }

    @Override
    public void onAddNewBookClick() {
        booksView.showAddNewBookView();
    }
}
