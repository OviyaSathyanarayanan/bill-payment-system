package com.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.project.bo.CustomerBO;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(EditController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        CustomerBO customerBO = new CustomerBO();
        session.setAttribute("userId", (String) session.getAttribute("userId"));
        try {
            String searchValue = request.getParameter("search");
            if (searchValue != "") {
                if ("search".equals(request.getParameter("action"))) {
                    request.setAttribute("vendorList", customerBO.searchVendor(searchValue));
                    dispatcher = request.getRequestDispatcher("search.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("vendorList", customerBO.getVendorListCustomer());
                dispatcher = request.getRequestDispatcher("search.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            LOG.error("Exception...." + e);
            dispatcher = request.getRequestDispatcher("search.jsp");
            request.setAttribute("errMsg", e.getMessage());
            dispatcher.forward(request, response);
        }
    }
}
