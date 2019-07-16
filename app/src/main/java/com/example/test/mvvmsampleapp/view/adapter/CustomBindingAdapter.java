package com.example.test.mvvmsampleapp.view.adapter;

/*
 *  Created by Umang Kamboj on 16-07-2019.
 */

import androidx.databinding.BindingAdapter;
import android.view.View;

public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}