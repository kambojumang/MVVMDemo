package com.example.test.mvvmsampleapp.viewmodel.login;

/*
 *  Created by Umang Kamboj on 15-07-2019.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.test.mvvmsampleapp.service.model.UserLoginModel;
import com.example.test.mvvmsampleapp.view.ui.MainActivity;


public class UserViewModel extends ViewModel
{

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> welcome = new MutableLiveData<>();

    private MutableLiveData<Integer> busy;

    private UserLoginModel userLoginModel;
    private Context context;


    /**
     * Constructor for UserViewModel
     * @param context
     * @param userLoginModel
     */
    public UserViewModel(Context context, UserLoginModel userLoginModel)
    {
        this.userLoginModel = userLoginModel;
        this.context = context;

        this.welcome.setValue(userLoginModel.getWelcomeMessage());
    }


    /**
     * Get Mutable Data instance for progress bar
     * @return
     */
    public MutableLiveData<Integer> getBusy() {

        if (busy == null)
        {
            busy = new MutableLiveData<>();
            busy.setValue(View.GONE);
        }

        return busy;
    }


    /**
     * Event generated for login button
     * @return
     */
    public void onLoginClick()
    {
        userLoginModel.setEmail(email.getValue());
        userLoginModel.setPassword(password.getValue());

        if(!userLoginModel.isValidEmail())
        {
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show();
        }

        else if(!userLoginModel.isValidPassword())
        {
            Toast.makeText(context, "Password Should be Minimum 6 Characters", Toast.LENGTH_SHORT).show();
        }

        else if(userLoginModel.isValidCredential())
        {
            getBusy().setValue(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run()
                {
                    getBusy().setValue(View.GONE);

                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, MainActivity.class);
                    intent.putExtra("USER_OBJ", userLoginModel);
                    context.startActivity(intent);

                    ((Activity) context).finish();
                }
            }, 500);
        }

        else
        {
            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}