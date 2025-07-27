<%@page import="com.guestlog.dto.Resident"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.guestlog.dao.ResidentDAOImpl"%>
<%@page import="com.guestlog.dao.ResidentDAO"%>
<%@page import="com.guestlog.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Residents</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<%Admin a=(Admin)session.getAttribute("activeAdmin"); %>
<%if(a != null ){ %>
<div class="button-container" style="margin: 10px;">
        <a href="dashboard.jsp" class="button">Back to Dashboard</a>
    </div>
	<h1 align="center">Residents</h1>
	<table border="1" align="center" cellpadding="10" cellspacing="0">
			<thead>
                <tr>
                   
                    <th>Full Name</th>
                    <th>Flat Number</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Type</th>
                    <th>Move In Date</th>
                    <th>Status</th>
                </tr>
            </thead>
            
            <%ResidentDAO rdao=new ResidentDAOImpl(); %>
            <%ArrayList<Resident> al=rdao.viewResidents(); %>
            
            <tbody>
            	<%for(Resident r:al){ %>
            		<tr>
            		<td><%=r.getFullName() %></td>
            		<td><%=r.getFlatNumber() %></td>
            		<td><%=r.getMobileNumber() %></td>
            		<td><%=r.getEmail() %></td>
            		<td><%=r.getGender() %></td>
            		<td><%=r.getResidentType() %></td>
            		<td><%=r.getMoveInDate() %></td>
            		<td><%=r.isActive() %></td>
            		</tr>
            	 <%} %>
            </tbody>
           
            
	</table>
	<%}else{ %>
        	<%request.setAttribute("error", "Login again"); %>
        	<%RequestDispatcher rd=request.getRequestDispatcher("login.jsp");%>
        	<%rd.forward(request, response); %>
        <%} %>
</body>
</html>