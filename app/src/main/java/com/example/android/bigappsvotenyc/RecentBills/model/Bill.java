package com.example.android.bigappsvotenyc.RecentBills.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by catwong on 2/2/17.
 */

public class Bill implements Parcelable {

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

    protected Bill(Parcel in) {
        number = in.readString();
        bill_uri = in.readString();
        title = in.readString();
        sponsor_uri = in.readString();
        introduced_date = in.readString();
        cosponsors = in.readString();
        committees = in.readString();
        primary_subject = in.readString();
        latest_major_action_date = in.readString();
        latest_major_action = in.readString();
    }

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(number);
        dest.writeString(bill_uri);
        dest.writeString(title);
        dest.writeString(sponsor_uri);
        dest.writeString(introduced_date);
        dest.writeString(cosponsors);
        dest.writeString(committees);
        dest.writeString(primary_subject);
        dest.writeString(latest_major_action_date);
        dest.writeString(latest_major_action);
    }
}
