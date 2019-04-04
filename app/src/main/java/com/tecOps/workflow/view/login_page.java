package com.tecOps.workflow.view;


import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.tecOps.workflow.databinding.ActivityLoginPageBinding;
import com.tecOps.workflow.R;
import com.tecOps.workflow.viewModel.LoginViewModel;


public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginPageBinding activityLoginPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_page);
        activityLoginPageBinding.setViewModel(new LoginViewModel());
        activityLoginPageBinding.executePendingBindings();

    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}