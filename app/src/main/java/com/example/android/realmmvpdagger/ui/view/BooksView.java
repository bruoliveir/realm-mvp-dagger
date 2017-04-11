package com.example.android.realmmvpdagger.ui.view;

import com.example.android.realmmvpdagger.model.Book;

import io.realm.RealmResults;

/**
 * View interface shows list of Books and navigates to other views.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public interface BooksView {
    void showBooks(RealmResults<Book> books);

    void showBookDetailView(int id);

    void showAddNewBookView();

    class EmptyView implements BooksView {

        @Override
        public void showBooks(RealmResults<Book> books) {

        }

        @Override
        public void showBookDetailView(int id) {

        }

        @Override
        public void showAddNewBookView() {

        }
    }
}
