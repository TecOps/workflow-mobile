package com.tecOps.workflow.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.exceptions.OutOfDateRangeException;
import com.tecOps.workflow.R;
import com.tecOps.workflow.model.EventCoordinatorDetail;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.adapter.EventAdapter;
import com.tecOps.workflow.view.adapter.InspectAdapter;
import com.tecOps.workflow.view.fragments.DashBordFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Calender extends DashBordFragment {
    private static Context context;
    private static CalendarView calendarView;
    private String TAG;
   private static List<EventModel> empty = new ArrayList<>();;
    @SuppressLint("ValidFragment")
    public Calender(Context context, CalendarView calendarView)
     {
         this.context=context;
         this.calendarView=calendarView;
         init();
     }
     public Calender(){}
     public void init(){

        calendarView.setHeaderVisibility(View.GONE);
             Calendar c = Calendar.getInstance();
             String year =String.valueOf(c.get(Calendar.YEAR)) ;
             String month ="0"+String.valueOf(c.get(Calendar.MONTH)+1) ;
             EventRepository.searchMonthEvents(year,month);



    }

    public void showEvents(List <EventModel>  event )
    {
        List<Calendar> calendars = new ArrayList<>();
        List<EventDay> events = new ArrayList<>();


        Calendar calendar = Calendar.getInstance();
        if(!event.isEmpty()){
            for(EventModel ev:event){
                String date = ev.getEventDate();
                String[] parts = date.split("-");
                String year = parts[0];
                String month = parts[1];
                String day = parts[2];

                calendar = Calendar.getInstance();
                if(ev.getEventStatus().equals("PUBLISHED")){
                    events.add(new EventDay(calendar, R.drawable.tick));}
                if(ev.getEventStatus().equals("CONFIRMED")){
                    events.add(new EventDay(calendar, R.drawable.singletick));}
                if (ev.getEventStatus().equals("PENDING")){
                    events.add(new EventDay(calendar, R.drawable.pending));}


                calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
                calendars.add(calendar);
            }
        }

        calendarView.setSelectedDates(calendars);
        calendarView.setEvents(events);
            try {
            calendarView.setDate(calendar);
            } catch (OutOfDateRangeException e) {
            e.printStackTrace();
            }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView=  binding.recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(new EventAdapter(context, event));


    }


}
