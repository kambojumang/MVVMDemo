package com.example.test.mvvmsampleapp.di;

/*
 *  Created by Umang Kamboj on 16-07-2019.
 */

import com.example.test.mvvmsampleapp.view.ui.ProjectFragment;
import com.example.test.mvvmsampleapp.view.ui.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProjectFragment contributeProjectFragment();

    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();
}
