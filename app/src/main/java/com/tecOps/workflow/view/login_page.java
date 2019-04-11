package com.tecOps.workflow.view;


import android.app.Activity;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.Toast;


import com.tecOps.workflow.databinding.ActivityLoginPageBinding;
import com.tecOps.workflow.R;
import com.tecOps.workflow.viewModel.LoginViewModel;



public class login_page extends AppCompatActivity {
    private Activity activity;
    private TextView linkForgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginPageBinding activityLoginPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_page);
        activity = this;
        LoginViewModel loginViewModel=new LoginViewModel (activity);
        activityLoginPageBinding.setViewModel(loginViewModel);
        activityLoginPageBinding.executePendingBindings();
        onLinkClick();

    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }


    protected void onLinkClick() {
       linkForgotPass=(TextView)findViewById(R.id.link_fogot);
       linkForgotPass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(login_page.this, forgot_pw.class));
           }
       });

    }


}