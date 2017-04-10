package com.example.android.realmmvpdagger.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.realmmvpdagger.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BooksActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private BookListAdapter mBookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ButterKnife.bind(this);

        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.fab)
    public void onAddNewBookClick() {

    }

}
