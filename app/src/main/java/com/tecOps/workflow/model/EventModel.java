

package com.tecOps.workflow.model;

import android.app.TabActivity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tecOps.workflow.R;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;


import java.util.List;



public class EventModel extends BaseObservable {

    @SerializedName("eventId")
    @Expose
    private Integer eventId;
    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("eventDate")
    @Expose
    private String eventDate;
    @SerializedName("eventStartTime")
    @Expose
    private String eventStartTime;
    @SerializedName("eventEndTime")
    @Expose
    private String eventEndTime;
    @SerializedName("eventStatus")
    @Expose
    private String eventStatus;
    @SerializedName("eventLocation")
    @Expose
    private String eventLocation;
    @SerializedName("eventCoordinatorDetails")
    @Expose
    private List<EventCoordinatorDetail> eventCoordinatorDetails = null;
    @SerializedName("eventParticipants")
    @Expose
    private String eventParticipants;
    @SerializedName("eventBudget")
    @Expose
    private String eventBudget;
    @SerializedName("eventDescription")
    @Expose
    private String eventDescription;
    @SerializedName("eventApprovedStatus")
    @Expose
    private String eventApprovedStatus;
    @SerializedName("eventCreatedAt")
    @Expose
    private String eventCreatedAt;
    @SerializedName("eventUpdatedAt")
    @Expose
    private String eventUpdatedAt;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("year")
    @Expose
    private String year;


    private String eventlocationdate;
    private String textyear;
    private String textmonth;
    private static String status="PENDING";
    private boolean showConstraint=false;
    private boolean showbuffer=true;
    private String day;

    public void setEventlocationdate(String eventlocationdate) {
        this.eventlocationdate = eventlocationdate;
    }


    /**
     * No args constructor for use in serialization
     *
     */
    public EventModel() {
    }

    /**
     *
     * @param eventUpdatedAt
     * @param eventLocation
     * @param eventDate
     * @param eventDescription
     * @param eventParticipants
     * @param eventId
     * @param eventEndTime
     * @param eventBudget
     * @param eventCreatedAt
     * @param eventStartTime
     * @param eventName
     * @param eventApprovedStatus
     * @param eventCoordinatorDetails
     * @param eventStatus
     */
    public EventModel(Integer eventId, String eventName, String eventDate, String eventStartTime, String eventEndTime, String eventStatus, String eventLocation, List<EventCoordinatorDetail> eventCoordinatorDetails, String eventParticipants, String eventBudget, String eventDescription, String eventApprovedStatus, String eventCreatedAt, String eventUpdatedAt) {
        super();
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventStatus = eventStatus;
        this.eventLocation = eventLocation;
        this.eventCoordinatorDetails = eventCoordinatorDetails;
        this.eventParticipants = eventParticipants;
        this.eventBudget = eventBudget;
        this.eventDescription = eventDescription;
        this.eventApprovedStatus = eventApprovedStatus;
        this.eventCreatedAt = eventCreatedAt;
        this.eventUpdatedAt = eventUpdatedAt;
    }
    public EventModel(String month, String year) {
        this.month = month;
        this.year = year;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    @Bindable
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
        notifyPropertyChanged(BR.eventName);
    }
    @Bindable
    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
        notifyPropertyChanged(BR.eventDate);
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
    @Bindable
    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
        notifyPropertyChanged(BR.eventStatus);

    }
    @Bindable
    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;

    }
    @Bindable
    public String getEventCoordinators() {
        String Cordinators="";
        if (eventCoordinatorDetails!=null){


        for(EventCoordinatorDetail ev:eventCoordinatorDetails){
            Cordinators=Cordinators+" "+ev.getName()+"-"+ev.getImNumber();
        }
        }
        return Cordinators;
    }

    public List<EventCoordinatorDetail>getEventCoordinatorDetails(){
            return eventCoordinatorDetails;
    }
    public void setEventCoordinatorDetails(List<EventCoordinatorDetail> eventCoordinatorDetails) {
        this.eventCoordinatorDetails = eventCoordinatorDetails;
        notifyPropertyChanged(BR.eventCoordinators);
    }
    @Bindable
    public String getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(String eventParticipants) {
        this.eventParticipants = eventParticipants;
        notifyPropertyChanged(BR.eventParticipants);
    }

    public String getEventBudget() {
        return eventBudget;
    }

    public void setEventBudget(String eventBudget) {
        this.eventBudget = eventBudget;
    }
    @Bindable
    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
        notifyPropertyChanged(BR.eventDescription);
    }

    public String getEventApprovedStatus() {
        return eventApprovedStatus;
    }

    public void setEventApprovedStatus(String eventApprovedStatus) {
        this.eventApprovedStatus = eventApprovedStatus;
    }

    public String getEventCreatedAt() {
        return eventCreatedAt;
    }

    public void setEventCreatedAt(String eventCreatedAt) {
        this.eventCreatedAt = eventCreatedAt;
    }

    public String getEventUpdatedAt() {
        return eventUpdatedAt;
    }

    public void setEventUpdatedAt(String eventUpdatedAt) {
        this.eventUpdatedAt = eventUpdatedAt;
    }
    @Bindable
    public String getEventlocationdate()
    {
        return eventlocationdate;
    }

    public void seteventlocationdate(String eventlocationdate)
    {
        this.eventlocationdate=eventlocationdate;
        notifyPropertyChanged(BR.eventlocationdate);
    }

    public void setTextYear(String textyear)
    {
        this.textyear=textyear;
        notifyPropertyChanged(BR.textYear);
    }
    @Bindable
    public String getTextYear()
    {
        return textyear;
    }
    public void onYearincrease(String year)
    {
        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel();
        eventDetailsViewModel.increaseYear(year);
    }

    public void onYeardecrease(String year)
    {
        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel();
        eventDetailsViewModel.decreaseYear(year);
    }
    public void onMonthdecrease(String month)
    {
        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel();
        eventDetailsViewModel.decreaseMonth(month);
    }

    public void onMonthincrease(String month)
    {
        EventDetailsViewModel eventDetailsViewModel=new EventDetailsViewModel();
        eventDetailsViewModel.increaseMonth(month);
    }
    @Bindable
    public String getTextMonth() {
        return textmonth;
    }

    public void setTextMonth(String textmonth) {
        this.textmonth = textmonth;
        notifyPropertyChanged(BR.textMonth);
    }


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setStatus(String status){
        this.status=status;
        notifyPropertyChanged(BR.status);
    }
    @Bindable
    public int getStatus(){

        if (status.equals("PENDING"))
        {
            return R.drawable.pending;
        }
        if (status.equals("PUBLISHED"))
        {
            return R.drawable.tick;
        }
        if (status.equals("CONFIRMED"))
        {
            return R.drawable.singletick;
        }
        else
            return R.drawable.pending;

    }
    @Bindable
    public int getShowConstraint() {
        return showConstraint ? View.VISIBLE : View.GONE;
    }
    public void setShowConstraint(boolean showConstraint)
    {
        this.showConstraint=showConstraint;
        notifyPropertyChanged(BR.showConstraint);
    }
    @Bindable
    public int getShowbuffer()
    {
        return showbuffer ? View.VISIBLE : View.GONE;
    }

    public void setShowbuffer(boolean showbuffer)
    {
        this.showbuffer=showbuffer;
        notifyPropertyChanged(BR.showbuffer);
    }
}