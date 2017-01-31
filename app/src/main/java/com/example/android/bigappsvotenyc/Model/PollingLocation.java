package com.example.android.bigappsvotenyc.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mathcore on 1/29/17.
 */

public class PollingLocation {

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("pollingHours")
    @Expose
    private String pollingHours;
    @SerializedName("sources")
    @Expose
    private List<Object> sources = null;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public PollingLocation withAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PollingLocation withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getPollingHours() {
        return pollingHours;
    }

    public void setPollingHours(String pollingHours) {
        this.pollingHours = pollingHours;
    }

    public PollingLocation withPollingHours(String pollingHours) {
        this.pollingHours = pollingHours;
        return this;
    }

    public List<Object> getSources() {
        return sources;
    }

    public void setSources(List<Object> sources) {
        this.sources = sources;
    }

    public PollingLocation withSources(List<Object> sources) {
        this.sources = sources;
        return this;
    }
}
