package com.example.android.bigappsvotenyc.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mathcore on 1/29/17.
 */

public class VoterInfo {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("election")
    @Expose
    private Election election;
    @SerializedName("normalizedInput")
    @Expose
    private NormalizedInput normalizedInput;
    @SerializedName("pollingLocations")
    @Expose
    private List<PollingLocation> pollingLocations = null;
    @SerializedName("contests")
    @Expose
    private List<Object> contests = null;
    @SerializedName("state")
    @Expose
    private List<Object> state = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public VoterInfo withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public VoterInfo withElection(Election election) {
        this.election = election;
        return this;
    }

    public NormalizedInput getNormalizedInput() {
        return normalizedInput;
    }

    public void setNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
    }

    public VoterInfo withNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
        return this;
    }

    public List<PollingLocation> getPollingLocations() {
        return pollingLocations;
    }

    public void setPollingLocations(List<PollingLocation> pollingLocations) {
        this.pollingLocations = pollingLocations;
    }

    public VoterInfo withPollingLocations(List<PollingLocation> pollingLocations) {
        this.pollingLocations = pollingLocations;
        return this;
    }

    public List<Object> getContests() {
        return contests;
    }

    public void setContests(List<Object> contests) {
        this.contests = contests;
    }

    public VoterInfo withContests(List<Object> contests) {
        this.contests = contests;
        return this;
    }

    public List<Object> getState() {
        return state;
    }

    public void setState(List<Object> state) {
        this.state = state;
    }

    public VoterInfo withState(List<Object> state) {
        this.state = state;
        return this;
    }




}
