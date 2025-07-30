<%@page import="com.guestlog.dto.Admin"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Service Entry</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<%Admin a=(Admin)session.getAttribute("activeAdmin"); %>
<%if(a != null ){ %>
    <div class="container">
        <h2>Service Entry</h2>
        <form action="ServiceServlet" method="post">
            <input type="text" name="name" placeholder="Service Person Name" required />
            <input type="text" name="contact" placeholder="Contact number" required />
            <input type="text" name="flatno" placeholder="Service flat number" required />
            <select name="type" required>
                <option value="">-- Select Service Type --</option>
                <option value="plumber">Plumber</option>
                
                <option value="electrician">Electrician</option>
                <option value="cleaner">Cleaner</option>
            </select>
            <input type="submit" value="Add Service" />
        </form>
    </div>
    <%}else{ %>
    		
        	<%request.setAttribute("error", "Login again"); %>
        	<%RequestDispatcher rd=request.getRequestDispatcher("login.jsp");%>
        	<%rd.forward(request, response); %>
        <%} %>
</body>
</html>
