package com.tecOps.workflow.viewModel;

import android.app.DatePickerDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.icu.text.DateFormatSymbols;
import android.os.Build;
import android.support.annotation.RequiresApi;


import com.android.databinding.library.baseAdapters.BR;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.Calender;
import com.tecOps.workflow.view.fragments.AddEventFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class EventDetailsViewModel extends BaseObservable {
private static EventModel eventModel;
public Context context;
public static String month;
public static String year;
private static EventRepository eventRepository;
private static final String[] dfs =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
private static List months;


    public EventDetailsViewModel(Context context,EventModel eventModel) {
          this.eventModel=eventModel;
          this.context=context;
          months = Arrays.asList(dfs);
          eventRepository=new EventRepository(context,eventModel);
          Calendar c = Calendar.getInstance();
        this.year =String.valueOf(c.get(Calendar.YEAR)) ;
         int monthInt =c.get(Calendar.MONTH) ;

          eventModel.setTextYear(this.year);
          eventModel.setTextMonth(months.get(monthInt).toString());


    }
    public EventDetailsViewModel()
    {}



    public void increaseYear(String year){

       int nextYear= Integer.valueOf(year)+1;
       eventModel.setTextYear(String.valueOf(nextYear));
       this.year=String.valueOf(nextYear);
    }
    public void decreaseYear(String year){

        int nextYear= Integer.valueOf(year)-1;
        eventModel.setTextYear(String.valueOf(nextYear));
        this.year=String.valueOf(nextYear);

    }

    public void decreaseMonth(String month)
    {

        if (months.indexOf(month)==11){
            eventModel.setTextMonth("December");
        }else {
            int monthIndex= months.indexOf(month)+1;
            String nextMonrh= months.get(monthIndex).toString();
            eventModel.setTextMonth(nextMonrh);
            this.month= "0"+String.valueOf(monthIndex+1);
        }

        searchMonthEvents();

    }
    public void increaseMonth(String month)
    {

        if (months.indexOf(month)==0){
            eventModel.setTextMonth("January");
        }
        else {
            int monthIndex= months.indexOf(month)-1;
            String preMonth= months.get(monthIndex).toString();
            eventModel.setTextMonth(preMonth);
            this.month= "0"+String.valueOf(monthIndex+1);
        }

        searchMonthEvents();


    }

    public void searchMonthEvents()
    {
        eventRepository.searchMonthEvents(this.year,this.month);

    }



}
