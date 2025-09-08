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

@WebServlet("/updateResident")
public class UpdateResident extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Resident r = new Resident();
        r.setResidentId(Integer.parseInt(req.getParameter("id")));
        r.setFullName(req.getParameter("fullName"));
        r.setFlatNumber(req.getParameter("flatNumber"));
        r.setMobileNumber(req.getParameter("mobileNumber"));
        r.setEmail(req.getParameter("email"));
        r.setGender(req.getParameter("gender"));
        r.setResidentType(req.getParameter("residentType"));
        r.setMoveInDate(req.getParameter("moveInDate"));
        r.setActive("true".equals(req.getParameter("isActive")));

        ResidentDAO rdao = new ResidentDAOImpl();
        if (rdao.updateResident(r)) {
        	req.setAttribute("success", "Update successful");
        	RequestDispatcher rd=req.getRequestDispatcher("viewResidents.jsp");
        	rd.forward(req, resp);
        } else {
            req.setAttribute("error", "Update failed");
            RequestDispatcher rd=req.getRequestDispatcher("viewResidents.jsp");
            rd.forward(req, resp);
        }
    }
}
