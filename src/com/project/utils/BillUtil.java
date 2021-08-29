package com.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.project.model.Bill;

public class BillUtil {

    public static Bill createBill(HttpServletRequest request) throws ParseException {
        String amount = request.getParameter("amount");
        String payment = request.getParameter("paymentType");
        String date = request.getParameter("billDate");
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("userId");
        int vendorId = (int) session.getAttribute("vendorId");
        int billAmount = Integer.parseInt(amount);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date billDate = sdf.parse(date);
        Bill bill = new Bill(billAmount, billDate, payment, customerId, vendorId);
        return bill;
    }
}
