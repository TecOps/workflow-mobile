package com.tecOps.workflow.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.tecOps.workflow.model.LoginModel;
import com.tecOps.workflow.remote.APIService;
import com.tecOps.workflow.remote.AppStatus;
import com.tecOps.workflow.repository.LoginReository;
import com.tecOps.workflow.view.MainActivity;
import com.tecOps.workflow.view.login_page;

public class LoginViewModel extends BaseObservable {
    private LoginModel user;

    private LoginModel loginModel;
    private Context context;
    private AppStatus AppStatus;
    private  login_page login_page;

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    public void setUserEmail(String userName) {
        user.setUsername(userName);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getUsername();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel(Context context) {
        this.context=context;
        this.loginModel=new LoginModel();
        user = new LoginModel("","","");
        this.AppStatus=new AppStatus();
        this.login_page=new login_page();
    }

    public void onLoginClicked() {

      if ( AppStatus.isOnline(context)) {
          if (getUserEmail() == "")
              setToastMessage("Please Enter Your UserName");
          else if (getUserPassword() == "")
              setToastMessage("Please Enter Your Password");
          else {
              LoginReository loginReository = new LoginReository(context, loginModel);
              loginReository.sendPost(getUserEmail().trim(), getUserPassword().trim());
            //  login_page.ShowAnimation();
          }
      }else {
          Toast.makeText(context,"Please check your Internet Connection", Toast.LENGTH_SHORT).show();

      }

    }


}
