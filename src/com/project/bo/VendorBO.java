package com.project.bo;

import org.apache.log4j.Logger;

import com.project.constant.ErrorConstant;
import com.project.dao.VendorDAO;
import com.project.dao.VendorDAOImpl;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Vendor;

public class VendorBO {
    public static final Logger LOG = Logger.getLogger(AdminBO.class);

    public void registerVendor(Vendor vendor)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor register...");
        VendorDAO vendorDao = new VendorDAOImpl();
        boolean isContactExists = vendorDao.isContactExist(vendor.getContact());
        boolean isEmailExists = vendorDao.isEmailExist(vendor.getEmail());
        boolean isWebsiteExists = vendorDao.isSiteExist(vendor.getWebsite());
        boolean isUserNameExists = vendorDao.isUserNameExist(vendor.getUserName());
        if (isContactExists == true) {
            throw new ProjectBusinessException(ErrorConstant.CONTACT_ALREADY_EXISTS);
        }
        if (isEmailExists == true) {
            throw new ProjectBusinessException(ErrorConstant.EMAIL_ALREADY_EXISTS);
        }
        if (isWebsiteExists == true) {
            throw new ProjectBusinessException(ErrorConstant.WEBSITE_ALREADY_EXISTS);
        }
        if (isUserNameExists == true) {
            throw new ProjectBusinessException(ErrorConstant.USER_NAME_ALREADY_EXISTS);
        }
        vendorDao.registerVendor(vendor);
        LOG.info("End of info...");
    }

    public void validateVendor(Vendor vendor)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor validation...");
        VendorDAO vendorDao = new VendorDAOImpl();
        boolean vendorExist = vendorDao.validateVendor(vendor);
        if (vendorExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INVALID_USER);
        }
        LOG.info("End of info...");
    }

    public void modifyVendor(Vendor vendor)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor modification...");
        VendorDAO vendordao = new VendorDAOImpl();
        vendordao.modifyVendor(vendor);
        LOG.info("End of info...");
    }

    public Vendor getVendor(String userName)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor retrival...");
        VendorDAO vendordao = new VendorDAOImpl();
        LOG.info("End of info...");
        return vendordao.getVendor(userName);
    }

}
