<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>

    <div class="container">
    
        <h2>Admin Login</h2>
        <%if(request.getAttribute("success")!=null){ %>
			<h4><%=request.getAttribute("success") %></h4>
		<%} %>
		<%if(request.getAttribute("error")!=null){ %>
			<h4><%=request.getAttribute("error") %></h4>
		<%} %>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />
            <input type="submit" value="Login" />
        </form>
    </div>
</body>
</html>
