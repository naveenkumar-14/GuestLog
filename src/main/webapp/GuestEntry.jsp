<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Guest Entry</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="container">
        <h2>Guest Entry</h2>
        <form action="GuestServlet" method="post">
            <input type="text" name="name" placeholder="Guest Name" required />
            <input type="text" name="contact" placeholder="Contact Number" required />
            <textarea name="purpose" placeholder="Purpose of Visit" required></textarea>
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>
