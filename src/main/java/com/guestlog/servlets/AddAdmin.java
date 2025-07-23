package com.guestlog.servlets;

import java.io.IOException;

import com.guestlog.dao.*;
import com.guestlog.dto.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addAdmin")
public class AddAdmin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin a=new Admin();
		AdminDAO adao=new AdminDAOImpl();
		a.setFullName(req.getParameter("fullName"));
		a.setUsername(req.getParameter("username"));
		a.setPassword(req.getParameter("password"));
		a.setEmail(req.getParameter("email"));
		a.setRole(req.getParameter("role"));
		if(adao.insertAdmin(a)) {
			req.setAttribute("success", "added successfully");
			RequestDispatcher rd=req.getRequestDispatcher("manageAdmins.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("error", "Failed to add");
			RequestDispatcher rd=req.getRequestDispatcher("manageAdmins.jsp");
			rd.forward(req, resp);
		}
	}

}
