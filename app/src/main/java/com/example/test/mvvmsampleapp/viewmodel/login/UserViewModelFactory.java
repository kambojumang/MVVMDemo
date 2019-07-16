package com.example.test.mvvmsampleapp.viewmodel.login;

/*
 *  Created by Umang Kamboj on 15-07-2019.
 */

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.mvvmsampleapp.service.model.UserLoginModel;


public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory
{
    private UserLoginModel userLoginModel;
    private Context context;


    public UserViewModelFactory(Context context, UserLoginModel userLoginModel)
    {
        this.context = context;
        this.userLoginModel = userLoginModel;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass)
    {
        return (T) new UserViewModel(context, userLoginModel);
    }
}