package com.tecOps.workflow.remote;




import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.model.LoginModel;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {
   @POST("auth/signin")
   Call<LoginModel> loginPost(@Body LoginModel task);

   @GET("/event/{id}")
   Call <EventModel> eventGet(@Path("id") String id);

   @GET("/event/filter")
   Call<List<EventModel>>filter(@Query("year") String year,@Query("month") String month);
}