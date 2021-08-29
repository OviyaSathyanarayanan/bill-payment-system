package com.project.dao;

import com.project.exceptions.ProjectApplicationException;
import com.project.model.Vendor;

public interface VendorDAO {
    public void registerVendor(Vendor vendor) throws ProjectApplicationException;

    public boolean validateVendor(Vendor vendor) throws ProjectApplicationException;

    public boolean isContactExist(String contact) throws ProjectApplicationException;

    public boolean isEmailExist(String email) throws ProjectApplicationException;

    public boolean isSiteExist(String site) throws ProjectApplicationException;

    public boolean isUserNameExist(String userName) throws ProjectApplicationException;

    public void modifyVendor(Vendor vendor) throws ProjectApplicationException;

    public Vendor getVendor(String userName) throws ProjectApplicationException;

}
