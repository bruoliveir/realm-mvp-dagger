package com.example.android.realmmvpdagger.ui;

import android.util.Log;

import com.example.android.realmmvpdagger.realm.RealmService;
import com.example.android.realmmvpdagger.ui.presenter.BooksPresenter;
import com.example.android.realmmvpdagger.ui.view.BooksView;

/**
 * BooksPresenter implementation handles actions received through a BooksView implementation.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class BooksPresenterImpl implements BooksPresenter {

    private final RealmService mRealmService;
    private BooksView mBooksView = new BooksView.EmptyView();

    private boolean booksWereShown = false;

    public BooksPresenterImpl(final RealmService realmService) {
        mRealmService = realmService;
    }

    @Override
    public void setView(Object view) {
        mBooksView = (BooksView) view;
        showBooksIfNeeded();
    }

    private void showBooksIfNeeded() {
        if (!booksWereShown) {
            mBooksView.showBooks(mRealmService.getAllBooks());
            booksWereShown = true;
        }
    }

    @Override
    public void clearView() {
        mBooksView = new BooksView.EmptyView();
    }

    @Override
    public void onBookClick(int id) {
        mBooksView.showBookDetailView(id);
    }

    @Override
    public void onAddNewBookClick() {
//        mBooksView.showAddNewBookView();

        // TODO: 14/04/17 Remove fake content after implementation of AddNewBookViewImpl
        mRealmService.addBookAsync("Title " + mRealmService.getAllBooks().size(), "987-12-34567-89",
                new RealmService.OnTransactionCallback() {
                    @Override public void onRealmSuccess() {
                        Log.w("MVP", "Added a book.");
                    }

                    @Override public void onRealmError(Throwable t) {
                        Log.w("MVP", "Failed to add a book because " + t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void closeRealm() {
        mRealmService.closeRealm();
    }
}
