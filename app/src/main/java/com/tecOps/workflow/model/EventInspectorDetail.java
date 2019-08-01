package com.tecOps.workflow.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventInspectorDetail extends BaseObservable {

    @SerializedName("inspecEventId")
    @Expose
    private Integer inspecEventId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("designation")
    @Expose
    private String designation;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getInspecEventId() {
        return inspecEventId;
    }

    public void setInspecEventId(Integer inspecEventId) {
        this.inspecEventId = inspecEventId;
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Bindable
    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
        notifyPropertyChanged(BR.designation);
    }
    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

}