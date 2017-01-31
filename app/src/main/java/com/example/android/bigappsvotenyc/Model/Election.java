package com.example.android.bigappsvotenyc.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mathcore on 1/29/17.
 */

public class Election {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("electionDay")
    @Expose
    private String electionDay;
    @SerializedName("ocdDivisionId")
    @Expose
    private String ocdDivisionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Election withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Election withName(String name) {
        this.name = name;
        return this;
    }

    public String getElectionDay() {
        return electionDay;
    }

    public void setElectionDay(String electionDay) {
        this.electionDay = electionDay;
    }

    public Election withElectionDay(String electionDay) {
        this.electionDay = electionDay;
        return this;
    }

    public String getOcdDivisionId() {
        return ocdDivisionId;
    }

    public void setOcdDivisionId(String ocdDivisionId) {
        this.ocdDivisionId = ocdDivisionId;
    }

    public Election withOcdDivisionId(String ocdDivisionId) {
        this.ocdDivisionId = ocdDivisionId;
        return this;
    }

}
