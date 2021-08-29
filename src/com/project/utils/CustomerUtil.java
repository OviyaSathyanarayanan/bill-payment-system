package com.project.utils;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import com.project.model.Customer;

public class CustomerUtil {

    public static Customer createCustomer(HttpServletRequest request) throws ParseException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String contact = request.getParameter("contact");
        String panNo = request.getParameter("pan");
        String aadharNo = request.getParameter("aadhar");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Customer customer = new Customer(firstName, lastName, age, gender, contact, panNo, aadharNo,
                userName, password);
        return customer;
    }

}
