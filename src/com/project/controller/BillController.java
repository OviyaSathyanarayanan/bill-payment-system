package com.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.project.bo.CustomerBO;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Bill;
import com.project.model.Card;
import com.project.model.NetBanking;
import com.project.model.Phone;
import com.project.utils.BillUtil;

/**
 * Servlet implementation class BillController
 */
@WebServlet("/BillController")
public class BillController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(BillController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher dispatcher = null;
        Bill bill = new Bill();
        Card card = new Card();
        Phone phone = new Phone();
        NetBanking netBanking = new NetBanking();
        List<Bill> billDetail;
        CustomerBO customerBo = new CustomerBO();
        HttpSession session = request.getSession();
        if ("Proceed".equals(action)) {
            try {
                bill = BillUtil.createBill(request);
                customerBo.enterBill(bill);
                String userId = (String) session.getAttribute("userId");
                int vendorId = (int) session.getAttribute("vendorId");
                bill.setCustomerId(userId);
                bill.setVendorId(vendorId);
                String payment = request.getParameter("paymentType");
                int payId = Integer.parseInt(payment);
                try {
                    billDetail = customerBo.getBillDetails(bill);
                    session.setAttribute("billDetail", billDetail);
                    if (payId == 1) {
                        session.setAttribute("userId", userId);
                        session.setAttribute("vendorId", session.getAttribute("vendorId"));
                        dispatcher = request.getRequestDispatcher("card-payment.jsp");
                        dispatcher.forward(request, response);
                    } else if (payId == 2) {
                        session.setAttribute("userId", userId);
                        dispatcher = request.getRequestDispatcher("phone-payment.jsp");
                        dispatcher.forward(request, response);
                    } else if (payId == 3) {
                        session.setAttribute("userId", userId);
                        dispatcher = request.getRequestDispatcher("net-banking-payment.jsp");
                        dispatcher.forward(request, response);
                    }
                } catch (ProjectApplicationException | ProjectBusinessException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("bill-payment.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
            } catch (ParseException | ProjectApplicationException | ProjectBusinessException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("bill-payment.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("paybill".equals(action)) {
            session = request.getSession();
            session.setAttribute("userId", (String) session.getAttribute("userId"));
            String vendor = request.getParameter("vendorId");
            int vendorId = Integer.parseInt(vendor);
            session.setAttribute("vendorId", vendorId);
            dispatcher = request.getRequestDispatcher("bill-payment.jsp");
            dispatcher.forward(request, response);
        } else if ("Pay".equals(action)) {
            session = request.getSession();
            session.setAttribute("userId", (String) session.getAttribute("userId"));
            String cardNumber = request.getParameter("cardNum");
            String cvv = request.getParameter("number");
            long cardNum = Long.parseLong(cardNumber);
            int cvvNum = Integer.parseInt(cvv);
            card.setCardNumber(cardNum);
            card.setCvv(cvvNum);
            try {
                customerBo.validateCardPayment(card);
                dispatcher = request.getRequestDispatcher("payment-status.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("card-payment.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("phonePay".equals(action)) {
            String phoneNum = request.getParameter("number");
            long mobileNum = Long.parseLong(phoneNum);
            phone.setUpi(mobileNum);
            try {
                customerBo.validatePhonePayment(phone);
                dispatcher = request.getRequestDispatcher("payment-status.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException
                    | NumberFormatException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("phone-payment.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("netPay".equals(action)) {
            String accountNum = request.getParameter("accountNumber");
            String userName = request.getParameter("userName");
            netBanking.setUserId(userName);
            String password = request.getParameter("password");
            netBanking.setPassword(password);
            netBanking.setAccountNumber(accountNum);
            try {
                customerBo.validateNetBankingPayment(netBanking);
                dispatcher = request.getRequestDispatcher("payment-status.jsp" + "");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("net-banking-payment.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        }
    }
}
