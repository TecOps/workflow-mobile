package com.tecOps.workflow.repository;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.util.Log;
import android.widget.Toast;

import com.tecOps.workflow.model.LoginModel;
import com.tecOps.workflow.remote.APIService;
import com.tecOps.workflow.remote.ApiUtils;
import com.tecOps.workflow.remote.AppStatus;
import com.tecOps.workflow.view.Event_details;
import com.tecOps.workflow.view.login_page;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class LoginReository extends BaseObservable {
    private APIService mAPIService;
    private LoginModel loginModel;
    private Context context;
    private AppStatus AppStatus;
    private login_page login_page;
    public LoginReository(Context context,LoginModel loginModel){
        this.context=context;
        this.loginModel=loginModel;
        this.AppStatus=new AppStatus();
        this.login_page=new login_page();
    }
    public void sendPost(String userName,String passWord) {

        mAPIService = ApiUtils.getAPIService();
        LoginModel login=new LoginModel(userName,passWord,"");
        Call<LoginModel> call=mAPIService.savePost(login);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.code() == 403) {
                        //login_page.HideAnimation();
                        Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
                    } else if (response.code() == 200) {
                        //login_page.HideAnimation();
                        Toast.makeText(context, response.body().getToken(), Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(context, Event_details.class);
                        context.startActivity(i);
                    }

                    if (response.isSuccessful()) {
                        showResponse(response.body().toString());
                        Log.i(TAG, "post submitted to API." + response.body().toString());

                    }

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                //login_page.HideAnimation();
                Toast.makeText(context,"Request time out!", Toast.LENGTH_SHORT).show();

            }
        });


    }


    public void showResponse(String response) {
       // Toast.makeText(context,loginModel.getToken(), Toast.LENGTH_SHORT).show();
    }
}
