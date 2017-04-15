package com.example.android.realmmvpdagger.realm;

import com.example.android.realmmvpdagger.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Service handles Realm database modification and management.
 *
 * Created by Bruno Oliveira on 14/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class RealmService {

    private final Realm mRealm;

    public RealmService(final Realm mRealm) {
        this.mRealm = mRealm;
    }

    public void closeRealm() {
        mRealm.close();
    }

    public RealmResults<Book> getAllBooks() {
        return mRealm.where(Book.class).findAll();
    }

    public void addBookAsync(final String title, final String isbn,
            final OnTransactionCallback onTransactionCallback) {

        mRealm.executeTransactionAsync(new Realm.Transaction() {
            @Override public void execute(Realm realm) {
                Book book = new Book();
                book.setId(realm.where(Book.class).findAll().size());
                book.setTitle(title);
                book.setIsbn(isbn);
                realm.copyToRealm(book);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override public void onSuccess() {
                onTransactionCallback.onRealmSuccess();
            }
        }, new Realm.Transaction.OnError() {
            @Override public void onError(Throwable error) {
                onTransactionCallback.onRealmError(error);
            }
        });
    }

    public interface OnTransactionCallback {
        void onRealmSuccess();
        void onRealmError(final Throwable t);
    }
}
