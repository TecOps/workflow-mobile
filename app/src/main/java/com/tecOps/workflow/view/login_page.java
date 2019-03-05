package com.tecOps.workflow.view;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kalpa.workflow.R;

public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        TextView resetPassword= findViewById(R.id.textView2);

        resetPassword.setPaintFlags(resetPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


    }
}
