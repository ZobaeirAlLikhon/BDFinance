package com.example.bdfinance.model;

public class VisitModel {
    private String name,mobile,address,profetion,amount,birthDate,image;

    public VisitModel() {
    }

    public VisitModel(String name, String mobile, String address, String profetion, String amount, String birthDate, String image) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.profetion = profetion;
        this.amount = amount;
        this.birthDate = birthDate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfetion() {
        return profetion;
    }

    public void setProfetion(String profetion) {
        this.profetion = profetion;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
