package com.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.project.bo.VendorBO;
import com.project.exceptions.ProjectApplicationException;
import com.project.exceptions.ProjectBusinessException;
import com.project.model.Vendor;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(EditController.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        if ("Save".equals(request.getParameter("action"))) {
            String id = request.getParameter("id");
            VendorBO vendorBo = new VendorBO();
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String website = request.getParameter("website");
            String validityDate = request.getParameter("validityDate");
            String payment = request.getParameter("payment");
            String password = request.getParameter("password");
            Vendor vendor;
            try {
                vendor = new Vendor(Integer.parseInt(id), email, contact, website,
                        sdf.parse(validityDate), payment, password);
                vendorBo.modifyVendor(vendor);
                vendor = vendorBo.getVendor(userName);
                session.setAttribute("vendor", vendor);
                RequestDispatcher dispatcher = request
                        .getRequestDispatcher("edit-vendor-status.jsp");
                dispatcher.forward(request, response);
            } catch (ProjectApplicationException | ProjectBusinessException | ParseException e) {
                LOG.error("Exception...." + e);
                RequestDispatcher dispatcher = request.getRequestDispatcher("vendor-edit.jsp");
                request.setAttribute("errMsg", e.getMessage());
                dispatcher.forward(request, response);
            }
        } else if ("Cancel".equals(request.getParameter("action"))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("cancelation-status.jsp");
            dispatcher.forward(request, response);
        }
    }

}
