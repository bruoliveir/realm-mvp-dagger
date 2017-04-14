package com.example.android.realmmvpdagger.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Base class for views that extend Activity (or AppCompatActivity etc.).
 *
 * Created by Bruno Oliveira on 13/04/17.
 * Copyright © 2017. All rights reserved.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureDagger();
    }

    @Override
    protected void onDestroy() {
        closeRealm();
        super.onDestroy();
    }

    protected abstract void configureDagger();

    protected abstract void closeRealm();
}
