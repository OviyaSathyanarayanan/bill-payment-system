package com.project.dao;

import java.util.List;

import com.project.exceptions.ProjectApplicationException;
import com.project.model.Bill;
import com.project.model.Card;
import com.project.model.Customer;
import com.project.model.NetBanking;
import com.project.model.Phone;
import com.project.model.Vendor;

public interface CustomerDAO {
    public void registerCustomer(Customer customer) throws ProjectApplicationException;

    public boolean validateCustomer(Customer customer) throws ProjectApplicationException;

    public boolean isContactExist(String contact) throws ProjectApplicationException;

    public boolean isUserIdExist(String userName) throws ProjectApplicationException;

    public boolean isPanExist(String panNumber) throws ProjectApplicationException;

    public boolean isAadharExist(String aadharNumber) throws ProjectApplicationException;

    public List<Vendor> searchVendor(String name) throws ProjectApplicationException;

    public List<Vendor> getVendorListCustomer() throws ProjectApplicationException;

    public void enterBillDetails(Bill bill) throws ProjectApplicationException;

    public boolean isCardExist(Card card) throws ProjectApplicationException;

    public boolean isMobileNumberExist(Phone phone) throws ProjectApplicationException;

    public boolean isAccountExist(NetBanking netBanking) throws ProjectApplicationException;

    public List<Bill> getBillDetails(Bill bill) throws ProjectApplicationException;

}
