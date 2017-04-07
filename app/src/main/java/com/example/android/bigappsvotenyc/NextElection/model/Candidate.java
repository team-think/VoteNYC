package com.example.android.bigappsvotenyc.NextElection.model;

import java.util.List;

/**
 * Created by catwong on 4/6/17.
 */

public class Candidate {

    private String name;
    private String party;
    private String candidateUrl;
    private List<Channel> channels;
    private String phone;
    private String email;
    private String photoUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCandidateUrl() {
        return candidateUrl;
    }

    public void setCandidateUrl(String candidateUrl) {
        this.candidateUrl = candidateUrl;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
