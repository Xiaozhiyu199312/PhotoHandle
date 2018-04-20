package com.wqdata.pojo;


import java.util.Date;

public class FaceInfo {
    private Integer id;

    private String realname;

    private String idcard;

    private String result;

    private String checkInformation;

    private String city;

    private String location;

    private String applicationNo;

    private String seriesNo;

    private String face1;

    private String face2;

    private String idcardFront;

    private String idcardBack;

    private Date identifyAt;

    private Date createAt;

    private String mobile;

    private String inputOrgid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getCheckInformation() {
        return checkInformation;
    }

    public void setCheckInformation(String checkInformation) {
        this.checkInformation = checkInformation == null ? null : checkInformation.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo == null ? null : applicationNo.trim();
    }

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo == null ? null : seriesNo.trim();
    }

    public String getFace1() {
        return face1;
    }

    public void setFace1(String face1) {
        this.face1 = face1 == null ? null : face1.trim();
    }

    public String getFace2() {
        return face2;
    }

    public void setFace2(String face2) {
        this.face2 = face2 == null ? null : face2.trim();
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront == null ? null : idcardFront.trim();
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack == null ? null : idcardBack.trim();
    }

    public Date getIdentifyAt() {
        return identifyAt;
    }

    public void setIdentifyAt(Date identifyAt) {
        this.identifyAt = identifyAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getInputOrgid() {
        return inputOrgid;
    }

    public void setInputOrgid(String inputOrgid) {
        this.inputOrgid = inputOrgid == null ? null : inputOrgid.trim();
    }
}