package com.example.android.bigappsvotenyc.RecentBills.model;

import java.util.List;

/**
 * Created by catwong on 2/2/17.
 */

public class BillResponse {

    private String status;
    private String copyright;
    private List<Result> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
