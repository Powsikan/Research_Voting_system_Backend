package com.design_project.voting_system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {

    @Id
    private String id;
    private String fullname;
    private String address;
    private String nicNumber;
    private String ele_vol;
    private String ele_district;
    private String fingerPrint;
    private boolean hasVoted;

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getEle_vol() {
        return ele_vol;
    }

    public void setEle_vol(String ele_vol) {
        this.ele_vol = ele_vol;
    }

    public String getEle_district() {
        return ele_district;
    }

    public void setEle_district(String ele_district) {
        this.ele_district = ele_district;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoteed) {
        this.hasVoted = hasVoteed;
    }


}
