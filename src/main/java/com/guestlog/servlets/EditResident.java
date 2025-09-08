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

@WebServlet("/editResident")
public class EditResident extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		ResidentDAO rdao=new ResidentDAOImpl();
		Resident r=rdao.getResidentById(id);
		req.setAttribute("resident", r);
		RequestDispatcher rd=req.getRequestDispatcher("editResidents.jsp");
		rd.forward(req, resp);
		
	}

}
