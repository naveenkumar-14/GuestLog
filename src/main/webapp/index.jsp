<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>GuestLog</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="header">
        <h1>Welcome to GuestLog</h1>
        <div class="auth-buttons">
            <a href="login.jsp" class="btn">Login</a>
            <a href="residentSignup.jsp" class="btn">Signup</a>
        </div>
    </div>

    <div class="dashboard-grid">
        <div class="card">
            <h2>Total Flats</h2>
            <p>${flatCount}</p>

        </div>
        <div class="card">
            <h2>Available for Rent</h2>
            <p>${rentCount}</p>
        </div>
        <div class="card">
            <h2>Available for Sale</h2>
            <p>${saleCount }</p>
        </div>
        <div class="card">
            <h2>Book a Visit</h2>
            <a href="book_visit.jsp" class="btn">Book Now</a>
        </div>
        <div class="card">
            <h2>Live Visitors Count</h2>
            <p>15 Visitors Inside</p>
        </div>
    </div>

    <div class="section">
        <h2>Today's Services Available</h2>
        <ul class="service-list">
            <li>Plumber: Available</li>
            <li>Carpenter: Available</li>
            <li>Electrician: Not Available</li>
            <li>Cleaner: Available</li>
        </ul>
    </div>

    <div class="section">
        <h2>Feedback Form</h2>
        <form class="feedback-form">
            <input type="text" placeholder="Your Name" required>
            <input type="email" placeholder="Your Email" required>
            <textarea placeholder="Your Feedback..." rows="4" required></textarea>
            <button type="submit" class="btn">Submit Feedback</button>
        </form>
    </div>

    <footer class="footer">
        &copy; 2025 GuestLog. All rights reserved.
    </footer>
</body>
</html>
