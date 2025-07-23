<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Admin</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
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
