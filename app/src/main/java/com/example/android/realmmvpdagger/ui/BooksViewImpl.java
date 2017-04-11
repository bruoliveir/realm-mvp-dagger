package com.example.android.realmmvpdagger.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.realmmvpdagger.R;
import com.example.android.realmmvpdagger.component.BooksComponent;
import com.example.android.realmmvpdagger.component.DaggerBooksComponent;
import com.example.android.realmmvpdagger.model.Book;
import com.example.android.realmmvpdagger.module.BooksModule;
import com.example.android.realmmvpdagger.ui.adapter.BookListAdapter;
import com.example.android.realmmvpdagger.ui.presenter.BooksPresenter;
import com.example.android.realmmvpdagger.ui.view.BooksView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;

/**
 * BooksView implementation renders UI components and handles user interaction.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class BooksViewImpl extends AppCompatActivity
        implements BooksView, BookListAdapter.OnBookClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @Inject
    BooksPresenter mBooksPresenter;
    private BooksComponent mBooksComponent;
    private BookListAdapter mBookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ButterKnife.bind(this);

        configureDagger();

        initToolbar();
        initList();
    }

    private void configureDagger() {
        mBooksComponent = DaggerBooksComponent.builder()
                .booksModule(new BooksModule())
                .build();
        mBooksComponent.inject(this);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    private void initList() {
        mBookListAdapter = new BookListAdapter();
        mBookListAdapter.setOnBookClickListener(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mBookListAdapter);
    }

    @OnClick(R.id.fab)
    public void onAddNewBookClick() {
        mBooksPresenter.onAddNewBookClick();
    }

    @Override
    public void onBookClick(int id) {
        mBooksPresenter.onBookClick(id);
    }

    @Override
    public void showBooks(RealmResults<Book> books) {
//        mBookListAdapter
    }

    @Override
    public void showBookDetailView(int id) {
//        startActivity();
    }

    @Override
    public void showAddNewBookView() {
//        startActivity();
    }
}
