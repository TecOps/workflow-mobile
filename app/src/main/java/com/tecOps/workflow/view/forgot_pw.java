package com.tecOps.workflow.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import com.tecOps.workflow.R;


public class forgot_pw extends AppCompatActivity {
    private static Button b_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);
        onClickButtonListener();
    }

    public void onClickButtonListener(){
        b_button = (Button) findViewById(R.id.button4);
        b_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onBackPressed();
                    }
                }
        );
    }



}
