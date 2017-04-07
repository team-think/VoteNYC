package com.example.android.bigappsvotenyc.NextElection.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by catwong on 4/6/17.
 */

public class Contest implements Parcelable{

    private String type;
    private String office;
    private List<String> level;
    private List<String> roles;
    private District district;
    private Candidate candidates;
    private Source sources;
    String referendumTitle;
    String referendumSubtitle;
    String referedumUrl;

    protected Contest(Parcel in) {
        type = in.readString();
        office = in.readString();
        level = in.createStringArrayList();
        roles = in.createStringArrayList();
        referendumTitle = in.readString();
        referendumSubtitle = in.readString();
        referedumUrl = in.readString();
    }

    public static final Parcelable.Creator<Contest> CREATOR = new Parcelable.Creator<Contest>() {
        @Override
        public Contest createFromParcel(Parcel in) {
            return new Contest(in);
        }

        @Override
        public Contest[] newArray(int size) {
            return new Contest[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<String> getLevel() {
        return level;
    }

    public void setLevel(List<String> level) {
        this.level = level;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Candidate getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidate candidates) {
        this.candidates = candidates;
    }

    public Source getSources() {
        return sources;
    }

    public void setSources(Source sources) {
        this.sources = sources;
    }

    public String getReferendumTitle() {
        return referendumTitle;
    }

    public void setReferendumTitle(String referendumTitle) {
        this.referendumTitle = referendumTitle;
    }

    public String getReferendumSubtitle() {
        return referendumSubtitle;
    }

    public void setReferendumSubtitle(String referendumSubtitle) {
        this.referendumSubtitle = referendumSubtitle;
    }

    public String getReferedumUrl() {
        return referedumUrl;
    }

    public void setReferedumUrl(String referedumUrl) {
        this.referedumUrl = referedumUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(office);
        dest.writeStringList(level);
        dest.writeStringList(roles);
        dest.writeString(referendumTitle);
        dest.writeString(referendumSubtitle);
        dest.writeString(referedumUrl);
    }
}

