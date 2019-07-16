package com.example.test.mvvmsampleapp.view.ui;

/*
 *  Created by Umang Kamboj on 15-07-2019.
 */

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.test.mvvmsampleapp.R;
import com.example.test.mvvmsampleapp.databinding.ActivityLoginBinding;
import com.example.test.mvvmsampleapp.service.model.UserLoginModel;
import com.example.test.mvvmsampleapp.viewmodel.login.UserViewModel;
import com.example.test.mvvmsampleapp.viewmodel.login.UserViewModelFactory;


public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        UserViewModel userViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new UserLoginModel())).get(UserViewModel.class);
        binding.setUserViewModel(userViewModel);

    }
}