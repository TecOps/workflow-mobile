package com.tecOps.workflow.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tecOps.workflow.R;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tm=new Timer();
        tm.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intt = new Intent(MainActivity.this,login_page.class);
                startActivity(intt);
                finish();
            }
        },3000);
    }


}
