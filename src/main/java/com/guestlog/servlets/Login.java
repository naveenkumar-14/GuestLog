package com.guestlog.servlets;

import java.io.IOException;

import com.guestlog.dao.AdminDAO;
import com.guestlog.dao.AdminDAOImpl;
import com.guestlog.dto.Admin;
import com.mysql.cj.Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin a=new Admin();
		HttpSession hs=req.getSession(true);
		AdminDAO adao=new AdminDAOImpl();
		a=adao.getAdmin(req.getParameter("username"), req.getParameter("password"));
		if(a!=null) {
			hs.setAttribute("activeAdmin", a);
			req.setAttribute("success", "Login Successful");
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("error", "Login Unsuccessfull");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
					
		}
	}

}
