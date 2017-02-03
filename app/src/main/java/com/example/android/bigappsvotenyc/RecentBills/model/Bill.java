package com.example.android.bigappsvotenyc.RecentBills.model;

/**
 * Created by catwong on 2/2/17.
 */

public class Bill {

    private String number;
    private String bill_uri;
    private String title;
    private String sponsor_uri;
    private String introduced_date;
    private String cosponsors;
    private String committees;
    private String primary_subject;
    private String latest_major_action_date;
    private String latest_major_action;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBill_uri() {
        return bill_uri;
    }

    public void setBill_uri(String bill_uri) {
        this.bill_uri = bill_uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSponsor_uri() {
        return sponsor_uri;
    }

    public void setSponsor_uri(String sponsor_uri) {
        this.sponsor_uri = sponsor_uri;
    }

    public String getIntroduced_date() {
        return introduced_date;
    }

    public void setIntroduced_date(String introduced_date) {
        this.introduced_date = introduced_date;
    }

    public String getCosponsors() {
        return cosponsors;
    }

    public void setCosponsors(String cosponsors) {
        this.cosponsors = cosponsors;
    }

    public String getCommittees() {
        return committees;
    }

    public void setCommittees(String committees) {
        this.committees = committees;
    }

    public String getLatest_major_action_date() {
        return latest_major_action_date;
    }

    public void setLatest_major_action_date(String latest_major_action_date) {
        this.latest_major_action_date = latest_major_action_date;
    }

    public String getPrimary_subject() {
        return primary_subject;
    }

    public void setPrimary_subject(String primary_subject) {
        this.primary_subject = primary_subject;
    }

    public String getLatest_major_action() {
        return latest_major_action;
    }

    public void setLatest_major_action(String latest_major_action) {
        this.latest_major_action = latest_major_action;
    }
}
