package com.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.project.model.Vendor;

public class VendorUtil {
    public static Vendor createVendor(HttpServletRequest request) throws ParseException {
        String name = request.getParameter("name");
        String registerNum = request.getParameter("registerNum");
        String id = request.getParameter("vendorType");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String website = request.getParameter("website");
        String issueDate = request.getParameter("issuedDate");
        String validity = request.getParameter("validityDate");
        String year = request.getParameter("year");
        String payment = request.getParameter("payment");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date isdate = sdf.parse(issueDate);
        Date validityDate = sdf.parse(validity);
        Vendor vendor = new Vendor(name, registerNum, id, address, country, state, email, contact,
                website, isdate, validityDate, year, payment, userName, password);
        return vendor;
    }

}
