package com.tecOps.workflow.remote;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.tecOps.workflow.model.EventModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BackgroundServices extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BackgroundServices(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        List<EventModel> tasks= new ArrayList<>();
       APIService mAPIService=

        mAPIService = ApiUtils.getEventAPIService();
        Call<List<EventModel>> call = mAPIService.filter("2019","05");
        try {
            Response<List<EventModel>> response = call.execute();
            int d=5;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
