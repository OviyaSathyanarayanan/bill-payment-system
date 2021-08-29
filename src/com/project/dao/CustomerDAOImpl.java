package com.project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.project.constant.QueryConstant;
import com.project.exceptions.ProjectApplicationException;
import com.project.model.Bill;
import com.project.model.Card;
import com.project.model.Customer;
import com.project.model.NetBanking;
import com.project.model.Phone;
import com.project.model.Vendor;
import com.project.utils.ConnectionHandler;

public class CustomerDAOImpl implements CustomerDAO {
    public static final Logger LOG = Logger.getLogger(CustomerDAOImpl.class);

    public CustomerDAOImpl() {

    }

    @Override
    public void registerCustomer(Customer customer) throws ProjectApplicationException {
        LOG.info("Registering Customer...");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.REGISTER_USER_QUERY);) {
            pstmt.setString(1, customer.getFisrtName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getAge());
            pstmt.setString(4, customer.getGender());
            pstmt.setString(5, customer.getContactNo());
            pstmt.setString(6, customer.getPanNo());
            pstmt.setString(7, customer.getAadharNo());
            pstmt.setString(8, customer.getUserId());
            pstmt.setString(9, customer.getPassword());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while registering customer" + e.getMessage());
        }
    }

    @Override
    public boolean validateCustomer(Customer customer) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateCustomer ... Customer.. = " + customer.getUserId());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VALIDATE_USER_QUERY);) {
            pstmt.setString(1, customer.getUserId());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String pass = resultSet.getString("cu_password");
                isValid = pass.equals(customer.getPassword()) ? true : false;
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProjectApplicationException(
                    "Exception while validating customer" + e.getMessage());
        }
        LOG.info("isValid = " + isValid);
        return isValid;
    }

    @Override
    public boolean isContactExist(String contact) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateContact ... Customer.. = " + contact);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.USER_CONTACT_EXIST_QUERY);) {
            pstmt.setString(1, contact);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of customer contact" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isUserIdExist(String userName) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateUserId ... Customer.. = " + userName);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.USER_NAME_EXIST_QUERY);) {
            pstmt.setString(1, userName);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of customer username" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isPanExist(String panNumber) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validatePan ... Customer.. = " + panNumber);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.PAN_EXIST_QUERY);) {
            pstmt.setString(1, panNumber);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;

        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of customer pan" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isAadharExist(String aadharNumber) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateAadhar ... Customer.. = " + aadharNumber);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.AADHAR_EXIST_QUERY);) {
            pstmt.setString(1, aadharNumber);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of customer aadhar" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    public List<Vendor> searchVendor(String name) throws ProjectApplicationException {
        LOG.info("Searching vendor...");
        List<Vendor> vendorList = new ArrayList<Vendor>();
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.SEARCH_VENDOR_QUERY)) {
            pstmt.setString(1, name);
            pstmt.setString(2, name);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ve_id");
                String vname = resultSet.getString("ve_name");
                String site = resultSet.getString("ve_site");
                String email = resultSet.getString("ve_email");
                String contact = resultSet.getString("ve_contact");
                Vendor vendor = new Vendor(id, vname, site, email, contact);
                vendorList.add(vendor);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while searching for vendors" + e.getMessage());
        }
        return vendorList;
    }

    @Override
    public List<Vendor> getVendorListCustomer() throws ProjectApplicationException {
        LOG.info("Getting Vendor List Customer...");
        List<Vendor> vendorList = new ArrayList<Vendor>();
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.GET_VENDOR_LIST_CUSTOMER)) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ve_id");
                String name = resultSet.getString("ve_name");
                String registrationNum = resultSet.getString("ve_reg_num");
                String typeId = resultSet.getString("ve_type_id");
                String address = resultSet.getString("ve_address");
                String country = resultSet.getString("ve_country");
                String state = resultSet.getString("ve_state");
                String email = resultSet.getString("ve_email");
                String contact = resultSet.getString("ve_contact");
                String site = resultSet.getString("ve_site");
                Date cDate = resultSet.getDate("ve_cer_issue_date");
                java.util.Date cerIssueDate = new java.util.Date(cDate.getTime());
                Date vDate = resultSet.getDate("ve_cer_validity_date");
                java.util.Date cerValidDate = new java.util.Date(vDate.getTime());
                String year = resultSet.getString("ve_year");
                String payment = resultSet.getString("ve_payment");
                String userName = resultSet.getString("ve_user_name");
                String password = resultSet.getString("ve_password");
                Vendor vendor = new Vendor(id, name, registrationNum, typeId, address, country,
                        state, email, contact, site, cerIssueDate, cerValidDate, year, payment,
                        userName, password);
                vendorList.add(vendor);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while retriving vendor list customer" + e.getMessage());
        }
        return vendorList;
    }

    @Override
    public void enterBillDetails(Bill bill) throws ProjectApplicationException {
        LOG.info("Entering Bill Details");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.ENTER_BILL_DETAILS)) {
            pstmt.setInt(1, bill.getAmount());
            pstmt.setDate(2, new Date(bill.getDate().getTime()));
            pstmt.setInt(3, bill.getVendorId());
            pstmt.setString(4, bill.getPayment());
            pstmt.setString(5, bill.getCustomerId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while entering bill details" + e.getMessage());
        }
    }

    public boolean isCardExist(Card card) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateCard ... Customer.. = " + card.getCardNumber());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.IS_CARD_EXIST)) {
            pstmt.setLong(1, card.getCardNumber());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int cvv = resultSet.getInt("ca_cvv");
                if (cvv == card.getCvv()) {
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of card" + e.getMessage());
        }
        LOG.info("isValid = " + isValid);
        return isValid;
    }

    public boolean isMobileNumberExist(Phone phone) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateMobile ... Customer.. = " + phone.getUpi());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.IS_MOBILE_EXIST)) {
            pstmt.setLong(1, phone.getUpi());
            ResultSet resultSet = pstmt.executeQuery();
            isValid = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of mobile number" + e.getMessage());
        }
        return isValid;
    }

    @Override
    public boolean isAccountExist(NetBanking netBanking) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateAccount ... Customer.. = " + netBanking.getAccountNumber());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.IS_ACCOUNT_EXIST)) {
            pstmt.setString(1, netBanking.getAccountNumber());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String userId = resultSet.getString("nb_user_id");
                isValid = userId.equals(netBanking.getUserId()) ? true : false;
                String pass = resultSet.getString("nb_password");
                isValid = pass.equals(netBanking.getPassword()) ? true : false;
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of net banking account" + e.getMessage());
        }
        LOG.info("isValid = " + isValid);
        return isValid;
    }

    @Override
    public List<Bill> getBillDetails(Bill bill) throws ProjectApplicationException {
        LOG.info("Getting Bill Details...");
        List<Bill> billList = new ArrayList<Bill>();
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.GET_BILL_DETAILS)) {
            pstmt.setString(1, bill.getCustomerId());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("bi_id");
                int amount = resultSet.getInt("bi_amount");
                Date date = resultSet.getDate("bi_date");
                int payment = resultSet.getInt("bi_pt_id");
                Bill thisBill = new Bill(id, amount, date, payment);
                billList.add(thisBill);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while getting bill details" + e.getMessage());
        }
        return billList;
    }

}
