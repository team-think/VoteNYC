package com.example.android.bigappsvotenyc.RecentBills.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by catwong on 2/2/17.
 */

public class Result implements Parcelable {

    private String congress;
    private String chameber;
    private String num_Results;
    private String offset;
    private List<Bill> bills;
    private Bill bill;

    protected Result(Parcel in) {
        congress = in.readString();
        chameber = in.readString();
        num_Results = in.readString();
        offset = in.readString();
        bills = in.createTypedArrayList(Bill.CREATOR);
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

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

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(congress);
        dest.writeString(chameber);
        dest.writeString(num_Results);
        dest.writeString(offset);
        dest.writeTypedList(bills);
    }
}
