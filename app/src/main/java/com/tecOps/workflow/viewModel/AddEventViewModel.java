package com.tecOps.workflow.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.tecOps.workflow.model.EventCoordinatorDetail;
import com.tecOps.workflow.model.EventModel;

import java.util.ArrayList;
import java.util.List;

public class AddEventViewModel extends ViewModel {
    public MutableLiveData<String> EventName = new MutableLiveData<>();
    public MutableLiveData<String> EventDate = new MutableLiveData<>();
    public MutableLiveData<String> EventStartTime = new MutableLiveData<>();
    public MutableLiveData<String> EventEndTime = new MutableLiveData<>();
    public MutableLiveData<String> EventLocation = new MutableLiveData<>();
    public MutableLiveData<String> EventBatch = new MutableLiveData<>();
    public MutableLiveData<String> EventParticipants = new MutableLiveData<>();
    public MutableLiveData<String> EventBudget = new MutableLiveData<>();
    public MutableLiveData<String> EventDescription = new MutableLiveData<>();
    public MutableLiveData<String> EventCoordinator1 = new MutableLiveData<>();
    public MutableLiveData<String> EventCoordinator2 = new MutableLiveData<>();
    public MutableLiveData<String> EventCoordinator1StuNo = new MutableLiveData<>();
    public MutableLiveData<String> EventCoordinator2StuNo = new MutableLiveData<>();


    private MutableLiveData<EventModel> EventMutableLiveData;

    public MutableLiveData<EventModel> getEvent() {

        if (EventMutableLiveData == null) {
            EventMutableLiveData = new MutableLiveData<>();
        }
        return EventMutableLiveData;

    }

    public void onClickSave(View view) {
        List<EventCoordinatorDetail> eventCoordinatorDetails=new ArrayList<>();

        EventCoordinatorDetail eventCoordinatorDetail1=new EventCoordinatorDetail(EventCoordinator1StuNo.getValue(),EventCoordinator1.getValue());
        EventCoordinatorDetail eventCoordinatorDetail2=new EventCoordinatorDetail(EventCoordinator2StuNo.getValue(),EventCoordinator2.getValue());
        eventCoordinatorDetails.add(eventCoordinatorDetail1);
        eventCoordinatorDetails.add(eventCoordinatorDetail2);
        EventModel EventDetails = new EventModel(EventName.getValue(), EventDate.getValue(), EventStartTime.getValue(), EventEndTime.getValue(), EventLocation.getValue(), EventParticipants.getValue(), EventBudget.getValue(), EventDescription.getValue(), EventBatch.getValue(),eventCoordinatorDetails);

        EventMutableLiveData.setValue(EventDetails);
    }


}
