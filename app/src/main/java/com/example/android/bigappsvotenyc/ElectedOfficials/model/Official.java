package com.example.android.bigappsvotenyc.ElectedOfficials.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by catwong on 1/29/17.
 */
public class Official implements Parcelable {

    private String name;
    private List<Address> address;
    private String party;
    private List<String> phones;
    private List<String> urls;
    private String photoUrl;
    private List<Channel> channels;
    private List<String> emails;
    Office office;

    protected Official(Parcel in) {
        name = in.readString();
        party = in.readString();
        phones = in.createStringArrayList();
        urls = in.createStringArrayList();
        photoUrl = in.readString();
        emails = in.createStringArrayList();
    }

    public static final Creator<Official> CREATOR = new Creator<Official>() {
        @Override
        public Official createFromParcel(Parcel in) {
            return new Official(in);
        }

        @Override
        public Official[] newArray(int size) {
            return new Official[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(party);
        dest.writeStringList(phones);
        dest.writeStringList(urls);
        dest.writeString(photoUrl);
        dest.writeStringList(emails);
    }
}
