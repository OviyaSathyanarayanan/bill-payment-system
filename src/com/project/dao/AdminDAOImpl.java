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
import com.project.model.Admin;
import com.project.model.Vendor;
import com.project.utils.ConnectionHandler;

public class AdminDAOImpl implements AdminDAO {
    public static final Logger LOG = Logger.getLogger(AdminDAOImpl.class);

    public AdminDAOImpl() {

    }

    @Override
    public boolean validateAdmin(Admin admin) throws ProjectApplicationException {
        boolean isValid = false;
        LOG.info("validateAdmin ... Admin.. = " + admin.getUserName());
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VALIDATE_ADMIN_QUERY);) {
            pstmt.setString(1, admin.getUserName());
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                String pass = resultSet.getString("ad_password");
                isValid = pass.equals(admin.getPassword()) ? true : false;
            }
        } catch (ClassNotFoundException | IOException | SQLException e) {
            throw new ProjectApplicationException(
                    "Exception while validating Admin" + e.getMessage());
        }
        LOG.info("isValid = " + isValid);
        return isValid;
    }

    @Override
    public List<Vendor> getVendorListAdmin() throws ProjectApplicationException {
        LOG.info("Vendor retrival...");
        List<Vendor> vendorList = new ArrayList<Vendor>();
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.GET_VENDOR_LIST_ADMIN)) {
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
                    "Exception while getting vendor list Admin" + e.getMessage());
        }
        return vendorList;
    }

    @Override
    public void vendorApproval(String action, int id) throws ProjectApplicationException {
        LOG.info("Vendor approval...");
        try (Connection connection = ConnectionHandler.getConnection();
                PreparedStatement pstmt = connection
                        .prepareStatement(QueryConstant.VENDOR_APPROVAL)) {
            pstmt.setString(1, action);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new ProjectApplicationException(
                    "Exception while approving vendors" + e.getMessage());
        }
        LOG.info("End of info...");
    }
}
