package com.tecOps.workflow.repository;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;



import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.remote.APIService;
import com.tecOps.workflow.remote.ApiUtils;
import com.tecOps.workflow.utils.ConvertDateAndTime;
import com.tecOps.workflow.view.Calender;
import com.tecOps.workflow.view.EventDetails;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class EventRepository extends Observable {
    private static APIService mAPIService;
    private static Context context;
    private static EventModel eventModel;
   static ConvertDateAndTime dateAndTime;

    public EventRepository(Context context, EventModel eventModel) {
        this.context = context;
        this.eventModel = eventModel;
        dateAndTime = new ConvertDateAndTime();

    }

    public static void sendPost(String id) {

        mAPIService = ApiUtils.getEventAPIService();
        Call<EventModel> call = mAPIService.eventGet(id);
        call.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                if (response.code() == 403) {
                    //login_page.HideAnimation();
                    Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 200) {
                    //login_page.HideAnimation();
                    EventModel event = response.body();
                    EventDetailsViewModel eventDetailsViewModel = new EventDetailsViewModel(context, eventModel);
                    eventModel.setEventDescription(event.getEventDescription());
                    eventModel.seteventlocationdate(dateAndTime.convertDate(event.getEventDate()) + " | " + dateAndTime.convertTime(event.getEventStartTime()) + " onwards | " + event.getEventLocation());
                    eventModel.setEventName(event.getEventName());
                    eventModel.setEventParticipants(event.getEventParticipants());
                    eventModel.setEventCoordinatorDetails(event.getEventCoordinatorDetails());
                    eventModel.setStatus(event.getEventStatus());
                    eventModel.setShowConstraint(true);
                    eventModel.setShowbuffer(false);
                }

                if (response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {
                //login_page.HideAnimation();
                Toast.makeText(context, "Somthing went wrong!", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public static void searchMonthEvents(String year, String month) {




        mAPIService = ApiUtils.getEventAPIService();
        Call<List<EventModel>> call = mAPIService.filter(year,month);
        call.enqueue(new Callback<List<EventModel>>() {
            @Override
             public void onResponse(Call <List<EventModel>> call, Response  <List<EventModel>> response) {
                if (response.code() == 403) {
                    //login_page.HideAnimation();
                    Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
                }
                else if (response.code() == 200) {
                    //login_page.HideAnimation();
                    List <EventModel>  event = response.body();
                    if (!event.isEmpty()) {
                        Calender calender =new Calender();
                        calender.showEvents(event);
                    }


                }

                if (response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call <List<EventModel>>call, Throwable t) {
                Toast.makeText(context, "Somthing went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}



