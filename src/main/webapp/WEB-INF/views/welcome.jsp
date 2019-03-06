<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
    Greeting : ${greeting}
    This is a welcome page.

<h3>bookingService.getTicketsForEvent</h3>
<p><a href="booking/purchasedtickets?event=Kvitka Concert&auditorium=Yellow hall&date=2019-02-27T10:00:00.000">Get purchased tickets</a></p>

<br/>
<br/>
<hr/>

<h3>bookingService.getTicketsForEvent in PDF format</h3>
<form method="get" action="booking-pdf/purchasedtickets">
    <label>Event name:</label><input type="text" value="Kvitka Concert" name="event">
    <label>Auditorium:</label><input type="text" value="Yellow hall" name="auditorium">
    <label>Event Date:</label><input type="" value="2019-02-27T10:00:00" name="date">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="submit" value="Book ticket">
</form>



<br/>
<br/>
<hr/>


<h3>bookingService.bookTicket</h3>
<form method="post" action="/booking/bookticket">
    <label>Event name:</label><input type="text" value="Kvitka Concert" name="eventName">
    <label>Auditorium:</label><input type="text" value="Yellow hall" name="auditoriumName">
    <label>Event Date:</label><input type="" value="2019-02-27T10:00:00" name="date">
    <br/>
    <label>Ordered seats:</label><input type="text" value="33,35" name="seats"><br/>
    <label>Price:</label><input type="text" value="65.8" name="price"><br/>
    <label>User Id:</label><input type="text" value="1" name="userId"><br/><br/>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="submit" value="Book ticket">
</form>
<br/>
<br/>
<hr/>

<h3>bookingService.getTicketPrice</h3>
<h4>Freemarker template</h4>
<form method="get" action="/booking/ticketprice">
    <label>Event name:</label><input type="text" value="Kvitka Concert" name="eventName">
    <label>Auditorium:</label><input type="text" value="Yellow hall" name="auditoriumName">
    <label>Event Date:</label><input type="" value="2019-02-27T10:00:00" name="date">
    <br/>
    <label>Ordered seats:</label><input type="text" value="33,35" name="seats"><br/>
    <label>User Id:</label><input type="text" value="1" name="userId"><br/><br/>
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="submit" value="Get ticket price">
</form>
<br/>
<br/>
<hr/>
<h3>Multipart support: load users</h3>
<form method="post" action="/upload" enctype="multipart/form-data">
    <input type="file" name="users">
    <input type="file" name="users">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="submit">
</form>
<p>
Files to Download first: <br/>
    <a href="http://localhost:8080/resources/files/user1.json">File 1</a><br/>
    <a href="http://localhost:8080/resources/files/user2.json">File 2</a>
</p>


</body>
</html>