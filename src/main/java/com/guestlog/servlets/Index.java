package com.guestlog.servlets;

import com.guestlog.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/Index", loadOnStartup = 1)
public class Index extends HttpServlet{

	@Override
    public void init() throws ServletException {
        // This runs ON SERVER STARTUP
        FlatDAO fdao = new FlatDAOImpl();
        int count = fdao.countFlats();
        getServletContext().setAttribute("flatCount", count);
        int rent=fdao.toRent();
        getServletContext().setAttribute("rentCount", rent);
        int sale=fdao.toSale();
        getServletContext().setAttribute("saleCount", sale);
    }
}
