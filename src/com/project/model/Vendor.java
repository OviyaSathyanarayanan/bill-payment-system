package com.project.model;

import java.util.Date;

public class Vendor {
    private int vendorId;
    private String name;
    private String registerNumber;
    private String typeName;
    private String address;
    private String country;
    private String state;
    private String email;
    private String contact;
    private String website;
    private Date certificateDate;
    private Date validityDate;
    private String year;
    private String paymentType;
    private String userName;
    private String password;

    public Vendor() {

    }

    public Vendor(int vendorId, String name, String website, String email, String contact) {
        super();
        this.vendorId = vendorId;
        this.name = name;
        this.website = website;
        this.email = email;
        this.contact = contact;
    }

    public Vendor(int id, String name, String registerNumber, String typeName, String address,
            String country, String state, String email, String contact, String website,
            Date certificateDate, Date validityDate, String year, String paymentType,
            String userName, String password) {
        super();
        this.vendorId = id;
        this.name = name;
        this.registerNumber = registerNumber;
        this.typeName = typeName;
        this.address = address;
        this.country = country;
        this.state = state;
        this.email = email;
        this.contact = contact;
        this.website = website;
        this.certificateDate = certificateDate;
        this.validityDate = validityDate;
        this.year = year;
        this.paymentType = paymentType;
        this.userName = userName;
        this.password = password;
    }

    public Vendor(String name, String registerNumber, String typeName, String address,
            String country, String state, String email, String contact, String website,
            Date certificateDate, Date validityDate, String year, String paymentType,
            String userName, String password) {
        super();
        this.name = name;
        this.registerNumber = registerNumber;
        this.typeName = typeName;
        this.address = address;
        this.country = country;
        this.state = state;
        this.email = email;
        this.contact = contact;
        this.website = website;
        this.certificateDate = certificateDate;
        this.validityDate = validityDate;
        this.year = year;
        this.paymentType = paymentType;
        this.userName = userName;
        this.password = password;
    }

    public Vendor(int vendorId, String email, String contact, String website, Date validityDate,
            String paymentType, String password) {
        super();
        this.vendorId = vendorId;
        this.email = email;
        this.contact = contact;
        this.website = website;
        this.validityDate = validityDate;
        this.paymentType = paymentType;
        this.password = password;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vendor [vendorId=" + vendorId + ", name=" + name + ", registerNumber="
                + registerNumber + ", typeName=" + typeName + ", address=" + address + ", country="
                + country + ", state=" + state + ", email=" + email + ", contact=" + contact
                + ", website=" + website + ", certificateDate=" + certificateDate
                + ", validityDate=" + validityDate + ", year=" + year + ", paymentType="
                + paymentType + ", userName=" + userName + ", password=" + password + "]";
    }

}
