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

import com.project.bo.AdminBO;
import com.project.bo.CustomerBO;
import com.project.bo.VendorBO;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Admin;
import com.project.model.Customer;
import com.project.model.Vendor;
import com.project.utils.CustomerUtil;
import com.project.utils.VendorUtil;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(UserController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String action1 = request.getParameter("action1");
        String type = request.getParameter("type");
        RequestDispatcher dispatcher = null;
        CustomerBO customerBo = new CustomerBO();
        VendorBO vendorBo = new VendorBO();
        Customer customer;
        Vendor vendor;
        Admin admin;
        if ("Register".equals(action)) {
            try {
                vendor = VendorUtil.createVendor(request);
                vendorBo.registerVendor(vendor);
                request.setAttribute("RegisterStatus", true);
                dispatcher = request.getRequestDispatcher("vendor-registration.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException | ParseException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("vendor-registration.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("Register".equals(action1)) {
            try {
                customer = CustomerUtil.createCustomer(request);
                customerBo.registerCustomer(customer);
                request.setAttribute("RegisterStatus", true);
                dispatcher = request.getRequestDispatcher("customer-registration.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectBusinessException | ProjectApplicationException | ParseException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("customer-registration.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("Login".equals(action)) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            if (type.contains("Admin")) {
                admin = new Admin();
                admin.setUserName(userName);
                admin.setPassword(password);
                AdminBO adminBo = new AdminBO();
                dispatcher = null;
                List<Vendor> vendorList;
                try {
                    adminBo.validateAdmin(admin);
                } catch (ProjectApplicationException | ProjectBusinessException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
                try {
                    vendorList = adminBo.getVendorListAdmin();
                    request.setAttribute("vendorList", vendorList);
                    dispatcher = request.getRequestDispatcher("admin-view.jsp");
                    dispatcher.forward(request, response);
                } catch (ProjectApplicationException | ProjectBusinessException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("admin-view.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
            } else if (type.contains("Customer")) {
                customer = new Customer();
                customer.setUserId(userName);
                customer.setPassword(password);
                try {
                    customerBo.validateCustomer(customer);
                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userName);
                } catch (ProjectBusinessException | ProjectApplicationException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
                List<Vendor> vendorList;
                try {
                    vendorList = customerBo.getVendorListCustomer();
                    request.setAttribute("vendorList", vendorList);
                    dispatcher = request.getRequestDispatcher("search.jsp");
                    dispatcher.forward(request, response);
                } catch (ProjectApplicationException | ProjectBusinessException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("search.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
            } else if (type.contains("Vendor")) {
                vendor = new Vendor();
                vendor.setUserName(userName);
                vendor.setPassword(password);
                try {
                    vendorBo.validateVendor(vendor);
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", userName);
                    vendor = vendorBo.getVendor(userName);
                    session.setAttribute("vendor", vendor);
                    dispatcher = request.getRequestDispatcher("vendor-login.jsp");
                    dispatcher.forward(request, response);
                } catch (ProjectApplicationException | ProjectBusinessException e) {
                    LOG.error("Exception...." + e);
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    request.setAttribute("errMsg", e.getMessage());
                    dispatcher.forward(request, response);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        AdminBO adminBo = new AdminBO();
        VendorBO vendorBo = new VendorBO();
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        try {
            if ("Approve".equals(status)) {
                adminBo.vendorApproval(status, Integer.parseInt(id));
                List<Vendor> vendorList;
                vendorList = adminBo.getVendorListAdmin();
                request.setAttribute("vendorList", vendorList);
                dispatcher = request.getRequestDispatcher("admin-view.jsp");
                dispatcher.forward(request, response);
            } else if ("Deny".equals(status)) {
                adminBo.vendorApproval(status, Integer.parseInt(id));
                List<Vendor> vendorList;
                vendorList = adminBo.getVendorListAdmin();
                request.setAttribute("vendorList", vendorList);
                dispatcher = request.getRequestDispatcher("admin-view.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NumberFormatException | ProjectApplicationException | ProjectBusinessException e) {
            LOG.error("Exception...." + e);
            dispatcher = request.getRequestDispatcher("admin-view.jsp");
            request.setAttribute("errMsg", e.getMessage());
            dispatcher.forward(request, response);
        }
        if ("Edit".equals(request.getParameter("action"))) {
            String userName = request.getParameter("userName");
            Vendor vendor;
            try {
                vendor = vendorBo.getVendor(userName);
                request.setAttribute("vendor", vendor);
                dispatcher = request.getRequestDispatcher("vendor-edit.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException e) {
                LOG.error("Exception...." + e);
                dispatcher = request.getRequestDispatcher("vendor-registration.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        }
    }

}
