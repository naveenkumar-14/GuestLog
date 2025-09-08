package com.guestlog.servlets;

import java.io.IOException;

import com.guestlog.dao.ResidentDAO;
import com.guestlog.dao.ResidentDAOImpl;
import com.guestlog.dto.Resident;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addResident")
public class AddResident extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Resident r=new Resident();
		ResidentDAO rdao =new ResidentDAOImpl();
		r.setFullName(req.getParameter("fullName"));
		r.setFlatNumber(req.getParameter("flatNumber"));
		r.setMobileNumber(req.getParameter("mobileNumber"));
		r.setEmail(req.getParameter("email"));
		r.setGender(req.getParameter("gender"));
		r.setResidentType(req.getParameter("residentType"));
		r.setMoveInDate(req.getParameter("moveInDate"));
		if(req.getParameter("isActive")=="true") {
			r.setActive(true);
		}else {
			r.setActive(false);

		}
		if(rdao.insertResident(r)) {
			
			req.setAttribute("success", "added successfully");
			RequestDispatcher rd=req.getRequestDispatcher("viewResidents.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("error", "Failed to add");
			RequestDispatcher rd=req.getRequestDispatcher("viewResidents.jsp");
			rd.forward(req, resp);
		}

	}
}
