<%@ page language="java" %>
<%@page import="com.guestlog.dto.Admin" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>

    <h1>Dashboard</h1>
    <%if(request.getAttribute("success")!=null){ %>
    <h3 align="center"><%=request.getAttribute("success") %></h3>
    <%} %>
    <div class="button-container">
    
    <% Admin a=(Admin)session.getAttribute("activeAdmin"); %>
    <% if(a != null && a.getAdminId() == 1) { %>
    <a href="manageAdmins.jsp" class="button">Manage Admins</a>
	<% } %>

    <a href="GuestEntry.jsp" class="button">Add Guest Entry</a>
    <a href="viewGuestRecords.jsp" class="button">View Guest Records</a>
    <a href="manageParking.jsp" class="button">Manage Parking</a>
    <a href="addServiceEntry.jsp" class="button">Add Service Entry</a>
    <a href="viewServices.jsp" class="button">View Services</a>
    
	</div>

    

     <div class="table-container">
        <h2 style="text-align:center;">Recent Guest Entries</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Contact</th>
                <th>Purpose</th>
                <th>In Time</th>
                <th>Out Time</th>
            </tr>
            
        </table>
        </div>
</body>
</html>
