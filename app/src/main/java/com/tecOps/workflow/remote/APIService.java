package com.tecOps.workflow.remote;




import com.tecOps.workflow.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIService {

   @POST("signin")
   Call<LoginModel> savePost(@Body LoginModel task);
}