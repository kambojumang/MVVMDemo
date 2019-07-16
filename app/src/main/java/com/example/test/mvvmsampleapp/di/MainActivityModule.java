package com.example.test.mvvmsampleapp.di;

/*
 *  Created by Umang Kamboj on 16-07-2019.
 */

import com.example.test.mvvmsampleapp.view.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
