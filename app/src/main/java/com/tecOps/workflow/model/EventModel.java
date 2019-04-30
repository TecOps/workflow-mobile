

package com.tecOps.workflow.model;

import android.app.TabActivity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    private List<Object> eventCoordinatorDetails = null;
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
    public EventModel(Integer eventId, String eventName, String eventDate, String eventStartTime, String eventEndTime, String eventStatus, String eventLocation, List<Object> eventCoordinatorDetails, String eventParticipants, String eventBudget, String eventDescription, String eventApprovedStatus, String eventCreatedAt, String eventUpdatedAt) {
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

    public List<Object> getEventCoordinatorDetails() {
        return eventCoordinatorDetails;
    }

    public void setEventCoordinatorDetails(List<Object> eventCoordinatorDetails) {
        this.eventCoordinatorDetails = eventCoordinatorDetails;
    }

    public String getEventParticipants() {
        return eventParticipants;
    }
    @Bindable
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


}