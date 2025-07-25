<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resident Signup</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<form action="index.jsp" method="get">
        <button class="back-btn">Back to Home</button>
    </form>
    <h2>Resident Signup</h2>

    <form action="AddResident" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" name="fullName" required>

        <label for="flatNumber">Flat Number:</label>
        <input type="text" name="flatNumber" required>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" name="mobileNumber" required>

        <label for="email">Email:</label>
        <input type="email" name="email" required>

        <label for="gender">Gender:</label>
        <select name="gender" required>
            <option value="">--Select--</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>

        <label for="residentType">Resident Type:</label>
        <select name="residentType" required>
            <option value="">--Select--</option>
            <option value="Owner">Owner</option>
            <option value="Tenant">Tenant</option>
        </select>

        <label for="moveInDate">Move-In Date:</label>
        <input type="date" name="moveInDate" required>

        <label for="isActive">Is Active:</label>
        <select name="isActive">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>

        <button type="submit">Signup</button>
    </form>

    

</body>
</html>