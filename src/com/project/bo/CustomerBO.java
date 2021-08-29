package com.project.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.constant.ErrorConstant;
import com.project.dao.CustomerDAO;
import com.project.dao.CustomerDAOImpl;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Bill;
import com.project.model.Card;
import com.project.model.Customer;
import com.project.model.NetBanking;
import com.project.model.Phone;
import com.project.model.Vendor;

public class CustomerBO {
    public static final Logger LOG = Logger.getLogger(AdminBO.class);

    public void registerCustomer(Customer customer)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Customer register...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        boolean isPanExist = customerDao.isPanExist(customer.getPanNo());
        boolean isAadharExist = customerDao.isAadharExist(customer.getAadharNo());
        boolean isUserNameExists = customerDao.isUserIdExist(customer.getUserId());
        if (isPanExist == true) {
            throw new ProjectBusinessException(ErrorConstant.PAN_ALREADY_EXIST);
        }

        if (isAadharExist == true) {
            throw new ProjectBusinessException(ErrorConstant.AADHAR_ALREADY_EXIST);
        }
        if (isUserNameExists == true) {
            throw new ProjectBusinessException(ErrorConstant.USER_NAME_ALREADY_EXISTS);
        }
        customerDao.registerCustomer(customer);
        LOG.info("End of info...");
    }

    public void validateCustomer(Customer customer)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Customer validation...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        boolean userExist = customerDao.validateCustomer(customer);
        if (userExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INVALID_USER);
        }
        LOG.info("End of info...");
    }

    public List<Vendor> searchVendor(String name)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Searching for vendor...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        LOG.info("End of info...");
        return customerDao.searchVendor(name);
    }

    public List<Vendor> getVendorListCustomer()
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Getting vendor list customer...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        List<Vendor> vendorList = customerDao.getVendorListCustomer();
        if (vendorList.isEmpty()) {
            throw new ProjectBusinessException(ErrorConstant.VENDOR_LIST_EMPTY);
        }
        LOG.info("End of info...");
        return vendorList;
    }

    public void enterBill(Bill bill) throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Entering bill details...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        customerDao.enterBillDetails(bill);
        LOG.info("End of info...");
    }

    public List<Bill> getBillDetails(Bill bill)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Getting bill details...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        List<Bill> billList = customerDao.getBillDetails(bill);
        if (billList.isEmpty()) {
            throw new ProjectBusinessException(ErrorConstant.BILL_LIST_EMPTY);
        }
        LOG.info("End of info...");
        return billList;
    }

    public void validateCardPayment(Card card)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Validating Card Payment...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        boolean cardExist = customerDao.isCardExist(card);
        if (cardExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INCORRECT_CARD);
        }
        LOG.info("End of info...");
    }

    public void validatePhonePayment(Phone phone)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Validating phone payment...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        boolean upiExist = customerDao.isMobileNumberExist(phone);
        if (upiExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INCORRECT_UPI);
        }
        LOG.info("End of info...");
    }

    public void validateNetBankingPayment(NetBanking netBanking)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Validating net banking payment...");
        CustomerDAO customerDao = new CustomerDAOImpl();
        boolean accountExist = customerDao.isAccountExist(netBanking);
        if (accountExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INCORRECT_ACCOUNT);
        }
        LOG.info("End of info...");
    }

}
