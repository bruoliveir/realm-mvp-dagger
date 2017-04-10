package com.example.android.realmmvpdagger.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.realmmvpdagger.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for the RecyclerView in BooksActivity.
 *
 * Created by Bruno Oliveira on 10/04/17.
 * Copyright © 2017. All rights reserved.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {


    @Override
    public BookListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout_item_container)
        LinearLayout mLayoutItemContainer;

        @BindView(R.id.text_title)
        TextView mTextTitle;

        @BindView(R.id.text_details)
        TextView mTextDetails;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
