package com.tecOps.workflow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventCoordinatorDetail {

    @SerializedName("imNumber")
    @Expose
    private String imNumber;



    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coordinatorUId")
    @Expose
    private Integer coordinatorUId;


    public EventCoordinatorDetail(String imNumber, String name) {
        this.imNumber = imNumber;
        this.name = name;
    }


    public String getImNumber() {
        return imNumber;
    }

    public void setImNumber(String imNumber) {
        this.imNumber = imNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoordinatorUId() {
        return coordinatorUId;
    }

    public void setCoordinatorUId(Integer coordinatorUId) {
        this.coordinatorUId = coordinatorUId;
    }

}
