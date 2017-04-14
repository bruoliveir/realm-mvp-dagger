package com.example.android.realmmvpdagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Dagger activity scope.
 *
 * Created by Bruno Oliveira on 14/04/17.
 * Copyright © 2017. All rights reserved.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
