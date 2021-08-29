package com.project.bo;

import java.util.List;

import org.apache.log4j.Logger;

import com.project.constant.ErrorConstant;
import com.project.dao.AdminDAO;
import com.project.dao.AdminDAOImpl;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Admin;
import com.project.model.Vendor;

public class AdminBO {
    public static final Logger LOG = Logger.getLogger(AdminBO.class);

    public void validateAdmin(Admin admin)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Admin..." + admin.getUserName());
        AdminDAO adminDao = new AdminDAOImpl();
        boolean adminExist = adminDao.validateAdmin(admin);
        if (adminExist == false) {
            throw new ProjectBusinessException(ErrorConstant.INVALID_USER);
        }
        LOG.info("End of info...");
    }

    public List<Vendor> getVendorListAdmin()
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor retrival...");
        AdminDAO adminDao = new AdminDAOImpl();
        List<Vendor> vendorList = adminDao.getVendorListAdmin();
        if (vendorList.isEmpty()) {
            throw new ProjectBusinessException(ErrorConstant.NEW_VENDOR_LIST_EMPTY);
        }
        return vendorList;
    }

    public void vendorApproval(String action, int id)
            throws ProjectApplicationException, ProjectBusinessException {
        LOG.info("Vendor approval...");
        AdminDAO adminDao = new AdminDAOImpl();
        adminDao.vendorApproval(action, id);
        LOG.info("End of info...");
    }
}