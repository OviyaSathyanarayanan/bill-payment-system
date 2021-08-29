package com.project.model;

public class Phone {
    private int phoneId;
    private long upi;

    public Phone() {

    }

    public Phone(int phoneId, long upi) {
        super();
        this.phoneId = phoneId;
        this.upi = upi;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public long getUpi() {
        return upi;
    }

    public void setUpi(long upi) {
        this.upi = upi;
    }

    @Override
    public String toString() {
        return "Phone [phoneId=" + phoneId + ", upi=" + upi + "]";
    }

}
