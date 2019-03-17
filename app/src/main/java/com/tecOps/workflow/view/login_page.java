package com.tecOps.workflow.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kalpa.workflow.R;

public class login_page extends AppCompatActivity {

    public static TextView resetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        onClickTextViewListener();
    }


    public void onClickTextViewListener(){

             resetPassword =  findViewById(R.id.textView2);
             resetPassword.setOnClickListener(
                     new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             Intent intent = new Intent("com.tecOps.workflow.forgot_pw");
                             startActivity(intent);
                         }
                     }
             );


        }
    }

