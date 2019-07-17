package com.tecOps.workflow.repository;

import android.arch.lifecycle.MutableLiveData;

import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.remote.APIService;
import com.tecOps.workflow.remote.ApiUtils;
import com.tecOps.workflow.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNewEventRepository {

    private static AddNewEventRepository addNewEventRepository;

    public static AddNewEventRepository getInstance(){
        if (addNewEventRepository == null){
            addNewEventRepository = new AddNewEventRepository();
        }
        return addNewEventRepository;
    }

    private APIService mAPIService;

    public AddNewEventRepository(){
        mAPIService = ApiUtils.getEventAPIService();
    }

    public MutableLiveData<EventModel> getNews(EventModel source){
        MutableLiveData<EventModel> newsData = new MutableLiveData<>();
        mAPIService.addNewEvent(source).enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {

                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
