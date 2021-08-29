package com.project.model;

import java.util.Date;

public class Card {
    private int cardId;
    private long cardNumber;
    private int cvv;
    private Date expiryDate;

    public Card() {

    }

    public Card(long cardNumber, int cvv, Date expiryDate) {
        super();
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public Card(int cardId, long cardNumber, int cvv, Date expiryDate) {
        super();
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Card [cardId=" + cardId + ", cardNumber=" + cardNumber + ", cvv=" + cvv
                + ", expiryDate=" + expiryDate + "]";
    }

}
