package com.project.model;

public class NetBanking {
    private int transId;
    private String accountNumber;
    private String userId;
    private String password;

    public NetBanking() {

    }

    public NetBanking(int transId, String accountNumber, String userId, String password) {
        super();
        this.transId = transId;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.password = password;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public NetBanking(String accountNumber, String userId, String password) {
        super();
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
        return "NetBanking [transId=" + transId + ", accountNumber=" + accountNumber + ", userId="
                + userId + ", password=" + password + "]";
    }

}
