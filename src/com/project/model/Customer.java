package com.project.model;

public class Customer {
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String contactNo;
    private String panNo;
    private String aadharNo;
    private String userId;
    private String password;

    public Customer() {

    }

    public Customer(String firstName, String lastName, String age, String gender, String contactNo,
            String panNo, String aadharNo, String userId, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.contactNo = contactNo;
        this.panNo = panNo;
        this.aadharNo = aadharNo;
        this.userId = userId;
        this.password = password;
    }

    public String getFisrtName() {
        return firstName;
    }

    public void setFisrtName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [fisrtName=" + firstName + ", lastName=" + lastName + ", age=" + age
                + ", gender=" + gender + ", contactNo=" + contactNo + ", panNo=" + panNo
                + ", aadharNo=" + aadharNo + ", userId=" + userId + ", password=" + password + "]";
    }

}
