package com.tecOps.workflow.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tecOps.workflow.repository.LoginReository;

public class LoginModel {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;



    @SerializedName("token")
    @Expose
    private String token;

    public LoginModel(){};
    public LoginModel(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token=token;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public String getToken() {return token; }

    public void setToken(String token) {this.token = token;}
}
