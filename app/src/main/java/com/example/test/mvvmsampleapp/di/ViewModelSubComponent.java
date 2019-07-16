package com.example.test.mvvmsampleapp.di;

/*
 *  Created by Umang Kamboj on 16-07-2019.
 */

import com.example.test.mvvmsampleapp.viewmodel.ProjectListViewModel;
import com.example.test.mvvmsampleapp.viewmodel.ProjectViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link com.example.test.mvvmsampleapp.viewmodel.ProjectViewModelFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectViewModel projectViewModel();
}
