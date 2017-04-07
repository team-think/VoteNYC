package com.example.android.bigappsvotenyc.NextElection.model;

import java.util.List;

/**
 * Created by catwong on 4/6/17.
 */

public class ElectionResponse {

    private Election election;
    private List<Contest> contests;

    public Election getElection() {

        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public List<Contest> getContests() {
        return contests;
    }

    public void setContests(List<Contest> contests) {
        this.contests = contests;
    }
}
