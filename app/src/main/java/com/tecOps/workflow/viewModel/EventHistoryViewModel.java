package com.tecOps.workflow.viewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;

public class EventHistoryViewModel extends ViewModel
{
    private static EventModel eventModel;
    public Context context;
    private static EventRepository eventRepository;
    public String EventTitle, EventDetails;

    public EventHistoryViewModel(EventModel eventModel) {
//        this.eventModel=eventModel;
//        this.context=context;
//        eventRepository=new EventRepository(context,eventModel);
            this.EventTitle = eventModel.getEventName();
            this.EventDetails = eventModel.getEventDescription();
    }
}
