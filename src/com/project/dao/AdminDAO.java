package com.project.dao;

import java.util.List;

import com.project.exceptions.ProjectApplicationException;
import com.project.model.Admin;
import com.project.model.Vendor;

public interface AdminDAO {
    public boolean validateAdmin(Admin admin) throws ProjectApplicationException;

    List<Vendor> getVendorListAdmin() throws ProjectApplicationException;

    void vendorApproval(String action, int id) throws ProjectApplicationException;

}
