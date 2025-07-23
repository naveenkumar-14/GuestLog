<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
    <h1>Dashboard</h1>
    <div class="card"><a href="GuestEntry.jsp">Add Guest Entry</a></div>
    <div class="card"><a href="viewGuests.jsp">View Guest Records</a></div>
    <div class="card"><a href="parkingSlots.jsp">Manage Parking</a></div>
    <div class="card"><a href="ServiceEntry.jsp">Add Service Entry</a></div>
    <div class="card"><a href="viewServices.jsp">View Services</a></div>
    <div class="card"><a href="ManageAdmins.jsp">Manage Admins</a></div>

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
