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
	<form action="addResident" method="post">
		<label for="fullName">Full Name:</label>
		 <input type="text"
			name="fullName" required> 
			<label for="flatNumber">Flat Number:</label> 
			<input type="text" name="flatNumber" required> <label
			for="mobileNumber">Mobile Number:</label> <input type="text"
			name="mobileNumber" required>
		<div>
			<label for="email">Email:</label> <input type="email" name="email"
				required>
		</div>

		<div>
			<label for="gender">Gender:</label> <select name="gender" required>
				<option value="">--Select--</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</select>
		</div>

		<label for="residentType">Resident Type:</label> <select
			name="residentType" required>
			<option value="">--Select--</option>
			<option value="Owner">Owner</option>
			<option value="Tenant">Tenant</option>
		</select> <label for="moveInDate">Move-In Date:</label> <input type="date"
			name="moveInDate" required> <label for="isActive">Is
			Active:</label> <select name="isActive">
			<option value="true">Yes</option>
			<option value="false">No</option>
		</select>

		<button type="submit">ADD RESIDENT</button>
	</form>
	<table border="1" align="center" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>Full Name</th>
				<th>Flat Number</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Type</th>
				<th>Move In Date</th>
				<th>Status</th>
				<th>Edit/Remove</th>
			</tr>
		</thead>

		<%ResidentDAO rdao=new ResidentDAOImpl(); %>
		<%ArrayList<Resident> rl=rdao.viewResidents(); %>

		<tbody>
			<%for(Resident r:rl){ %>
			<tr>
				<td><%=r.getResidentId() %></td>
				<td><%=r.getFullName() %></td>
				<td><%=r.getFlatNumber() %></td>
				<td><%=r.getMobileNumber() %></td>
				<td><%=r.getEmail() %></td>
				<td><%=r.getGender() %></td>
				<td><%=r.getResidentType() %></td>
				<td><%=r.getMoveInDate() %></td>
				<td><%if(r.isActive()){ %>
					<h5>Active</h5>
					<%}else{ %>
						<h5>Not Active</h5>
					<%} %>
				</td>
				<td>
				<form action="editResident" method="post">
					<input type="hidden" name="id" value="<%=r.getResidentId()%>">
				<button type="submit">Edit</button>
				</form>
				<form action="deleteResident" method="post">
					<input type="hidden" name="id" value="<%=r.getResidentId()%>">
				<button type="submit">Delete</button>
				</form>
				</td>
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