package com.example.android.bigappsvotenyc.RecentBills.model;

import java.util.List;

/**
 * Created by catwong on 2/2/17.
 */

public class Result {

    private String congress;
    private String chameber;
    private String num_Results;
    private String offset;
    private List<Bill> bills;

    public String getCongress() {
        return congress;
    }

    public void setCongress(String congress) {
        this.congress = congress;
    }

    public String getChameber() {
        return chameber;
    }

    public void setChameber(String chameber) {
        this.chameber = chameber;
    }

    public String getNum_Results() {
        return num_Results;
    }

    public void setNum_Results(String num_Results) {
        this.num_Results = num_Results;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
