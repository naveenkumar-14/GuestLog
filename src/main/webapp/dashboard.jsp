<%@page import="com.guestlog.dao.ResidentDAOImpl"%>
<%@page import="com.guestlog.dao.ResidentDAO"%>
<%@ page language="java" %>
<%@page import="com.guestlog.dto.Admin" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<% Admin a=(Admin)session.getAttribute("activeAdmin"); %>
	<%if(a != null ){ %>
	<%ResidentDAO rdao=new ResidentDAOImpl(); %>
	<div class="top-bar">
    <form action="logout" method="post">
        <input type="submit" value="Logout" class="logout-button" />
    </form>
	</div>
	
    <h1>Dashboard</h1>
    <%if(request.getAttribute("success")!=null){ %>
    <h3 align="center"><%=request.getAttribute("success") %></h3>
    <%} %>
    
    <h3 align="center"><%=a.getFullName() %></h3>
    <div class="button-container">
    
    
    
    <% if(a.getAdminId() == 1) { %>
    <a href="manageAdmins.jsp" class="button">Manage Admins</a>
	<% } %>

    <a href="GuestEntry.jsp" class="button">Add Guest Entry</a>
    <a href="viewGuestRecords.jsp" class="button">View Guest Records</a>
    <a href="manageParking.jsp" class="button">Manage Parking</a>
    <a href="ServiceEntry.jsp" class="button">Add Service Entry</a>
    <a href="viewServices.jsp" class="button">View Services</a>
    <a href="viewResidents.jsp" class="button">View Residents</a>
    
	</div>

    

     <div class="table-container">
        <h2 style="text-align:center;">Recent Visitors</h2>
        <table>
            <tr>
                
                <th>Name</th>
                <th>Contact</th>
                <th>Purpose</th>
                <th>Flat</th>
                <th>In Time</th>
                <th>Out Time</th>
            </tr>
            
        </table>
        </div>
        <%}else{ %>
        	<%request.setAttribute("error", "Login again"); %>
        	<%RequestDispatcher rd=request.getRequestDispatcher("login.jsp");%>
        	<%rd.forward(request, response); %>
        <%} %>
</body>
</html>
