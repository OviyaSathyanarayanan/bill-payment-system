package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final Logger LOG = Logger.getLogger(EditController.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

}
