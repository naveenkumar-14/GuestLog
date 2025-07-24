package com.guestlog.servlets;

import java.io.IOException;

import com.guestlog.dao.ResidentDAO;
import com.guestlog.dao.ResidentDAOImpl;
import com.guestlog.dto.Resident;

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

	}
}
