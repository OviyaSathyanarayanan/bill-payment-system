package com.project.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.project.constant.QueryConstant;
import com.project.exceptions.ProjectApplicationException;
import com.project.model.Vendor;
import com.project.utils.ConnectionHandler;

public class VendorDAOImpl implements VendorDAO {
    public static final Logger LOG = Logger.getLogger(VendorDAOImpl.class);

    @Override
    public void registerVendor(Vendor vendor) throws ProjectApplicationException {
        LOG.info("Registering Vendor...");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.REGISTER_VENDOR_QUERY)) {
            pstmt.setString(1, vendor.getName());
            pstmt.setString(2, vendor.getRegisterNumber());
            pstmt.setString(3, vendor.getTypeName());
            pstmt.setString(4, vendor.getAddress());
            pstmt.setString(5, vendor.getCountry());
            pstmt.setString(6, vendor.getState());
            pstmt.setString(7, vendor.getEmail());
            pstmt.setString(8, vendor.getContact());
            pstmt.setString(9, vendor.getWebsite());
            pstmt.setDate(10, new Date(vendor.getCertificateDate().getTime()));
            pstmt.setDate(11, new Date(vendor.getValidityDate().getTime()));
            pstmt.setString(12, vendor.getYear());
            pstmt.setString(13, vendor.getPaymentType());
            pstmt.setString(14, vendor.getUserName());
            pstmt.setString(15, vendor.getPassword());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while registering vendor" + e.getMessage());
        }
    }

    @Override
    public boolean validateVendor(Vendor vendor) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateVendor ... Vendor.. = " + vendor.getUserName());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VALIDATE_VENDOR_QUERY)) {
            pstmt.setString(1, vendor.getUserName());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("ve_password");
                isValid = password.equals(vendor.getPassword()) ? true : false;
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while validating vendor" + e.getMessage());
        }
        LOG.info("isValid = " + isValid);
        return isValid;
    }

    @Override
    public boolean isContactExist(String contact) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateContact ... Vendor.. = " + contact);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VENDOR_CONTACT_EXIST_QUERY)) {
            pstmt.setString(1, contact);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of vendor contact" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isEmailExist(String email) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateEmail ... Vendor.. = " + email);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VENDOR_EMAIL_EXIST_QUERY)) {
            pstmt.setString(1, email);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of vendor email" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isSiteExist(String site) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateSite ... Vendor.. = " + site);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VENDOR_SITE_EXIST_QUERY)) {
            pstmt.setString(1, site);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    @Override
    public boolean isUserNameExist(String userName) throws ProjectApplicationException {
        boolean isExist = false;
        LOG.info("validateUserName ... Vendor.. = " + userName);
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VENDOR_USER_NAME_EXIST_QUERY)) {
            pstmt.setString(1, userName);
            ResultSet resultSet = pstmt.executeQuery();
            isExist = (resultSet.next()) ? true : false;
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while checking existance of vendor username" + e.getMessage());
        }
        LOG.info("isExist = " + isExist);
        return isExist;
    }

    public void modifyVendor(Vendor vendor) throws ProjectApplicationException {
        LOG.info("Modifying Vendor...");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.UPDATE_VENDOR_QUERY)) {
            pstmt.setString(1, vendor.getEmail());
            pstmt.setString(2, vendor.getContact());
            pstmt.setString(3, vendor.getWebsite());
            pstmt.setDate(4, new Date(vendor.getValidityDate().getTime()));
            pstmt.setString(5, vendor.getPaymentType());
            pstmt.setString(6, vendor.getPassword());
            pstmt.setInt(7, vendor.getVendorId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while updating vendor details" + e.getMessage());
        }
    }

    public Vendor getVendor(String userName) throws ProjectApplicationException {
        Vendor vendor = null;
        LOG.info("Getting Vendor...");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.RETRIVE_VENDOR_QUERY)) {
            pstmt.setString(1, userName);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
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
                Date vDate = resultSet.getDate("ve_cer_validity_date");
                String year = resultSet.getString("ve_year");
                String payment = resultSet.getString("ve_payment");
                String username = resultSet.getString("ve_user_name");
                String password = resultSet.getString("ve_password");
                vendor = new Vendor(id, name, registrationNum, typeId, address, country, state,
                        email, contact, site, cDate, vDate, year, payment, username, password);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while retriving vendor" + e.getMessage());
        }
        return vendor;
    }
}
