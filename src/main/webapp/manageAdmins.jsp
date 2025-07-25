<%@page import="com.guestlog.dto.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.guestlog.dao.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Admins</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<button type="button" onclick="window.location.href='dashboard.jsp'" class="back-btn">
		  Back to Dashboard
		</button>

    <div class="container">
        <h2>Manage Admins</h2>
				<%if(request.getAttribute("success")!=null){ %>
    <h3 align="center"><%=request.getAttribute("success") %></h3>
    <%} %>
        <!-- Admins Table -->
        <table class="styled-table">
            <thead>
                <tr>
                    <th>Admin ID</th>
                    <th>Full Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <%AdminDAO adao=new AdminDAOImpl(); %>
                <%ArrayList<Admin> admins=adao.getAdmins(); %>
            <tbody>
                <%for(Admin ad:admins){ %>
                <tr>
                	
                    <td><%=ad.getAdminId() %></td>
                    <td><%=ad.getFullName() %></td>
                    <td><%=ad.getUsername() %></td>
                    <td><%=ad.getEmail() %></td>
                    <td><%=ad.getRole() %></td>
                    <td>
                        <button class="btn">Edit</button>
                        <button class="btn danger">Delete</button>
                    </td>
                   
                </tr>
                 <%} %>
                <!-- Add more rows dynamically from backend -->
            </tbody>
        </table>
    </div>
    <div class="container">
        <h2>Add Admin</h2>
        <form action="addAdmin" method="post" class="form-box">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>
			<br>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
			<br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
			<br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
			<br>
            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="admin">Admin</option>
                <option value="manager">Manager</option>
                <option value="security">Security</option>
            </select>
			<br>
            <button type="submit">Add Admin</button>
        </form>
    </div>
</body>
</html>