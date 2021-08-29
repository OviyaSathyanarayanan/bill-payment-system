package com.project.model;

import java.util.Date;

public class Bill {
    private int billId;
    private int amount;
    private Date date;
    private int vendorId;
    private int paymentId;
    private String payment;
    private String customerId;

    public Bill() {

    }

    public Bill(int amount, Date date, String payment, String customerId, int vendorId) {
        super();
        this.amount = amount;
        this.date = date;
        this.payment = payment;
        this.customerId = customerId;
        this.vendorId = vendorId;
    }

    public Bill(int billId, int amount, Date date, int paymentId) {
        super();
        this.billId = billId;
        this.amount = amount;
        this.date = date;
        this.paymentId = paymentId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Bill [billId=" + billId + ", amount=" + amount + ", date=" + date + ", vendorId="
                + vendorId + ", paymentId=" + paymentId + ", customerId=" + customerId + "]";
    }

}
