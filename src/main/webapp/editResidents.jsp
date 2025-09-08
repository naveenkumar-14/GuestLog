<%@ page import="com.guestlog.dto.Resident" %>
<%
    Resident r = (Resident) request.getAttribute("resident");
    if (r == null) {
        out.println("<h3 style='color:red;'>No Resident found. Please go back.</h3>");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Resident</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="button-container" style="margin: 10px;">
		<a href="viewResidents.jsp" class="button">Back to Residents</a>
	</div>
<h1>Edit Resident</h1>

<form action="updateResident" method="post">
    <input type="hidden" name="id" value="<%=r.getResidentId()%>">

    <label>Full Name:</label>
    <input type="text" name="fullName" value="<%=r.getFullName()%>" required><br><br>

    <label>Flat Number:</label>
    <input type="text" name="flatNumber" value="<%=r.getFlatNumber()%>" required><br><br>

    <label>Mobile Number:</label>
    <input type="text" name="mobileNumber" value="<%=r.getMobileNumber()%>" required><br><br>

    <label>Email:</label>
    <input type="email" name="email" value="<%=r.getEmail()%>" required><br><br>

    <label>Gender:</label>
    <select name="gender" required>
        <option value="Male" <%= r.getGender().equals("Male") ? "selected" : "" %>>Male</option>
        <option value="Female" <%= r.getGender().equals("Female") ? "selected" : "" %>>Female</option>
        <option value="Other" <%= r.getGender().equals("Other") ? "selected" : "" %>>Other</option>
    </select><br><br>

    <label>Resident Type:</label>
    <select name="residentType" required>
        <option value="Owner" <%= r.getResidentType().equals("Owner") ? "selected" : "" %>>Owner</option>
        <option value="Tenant" <%= r.getResidentType().equals("Tenant") ? "selected" : "" %>>Tenant</option>
    </select><br><br>

    <label>Move-In Date:</label>
    <input type="date" name="moveInDate" value="<%=r.getMoveInDate()%>" required><br><br>

    <label>Active:</label>
    <select name="isActive">
        <option value="true" <%= r.isActive() ? "selected" : "" %>>Yes</option>
        <option value="false" <%= !r.isActive() ? "selected" : "" %>>No</option>
    </select><br><br>

    <button type="submit">Update Resident</button>
</form>

</body>
</html>
