<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchased tickets</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <b>Purchased tickets:</b>
            <br>

<table border="1">
<tr>
    <th>Id</th>
    <th>dateTime</th>
    <th>seats</th>
    <th>price</th>
</tr>
    <c:forEach items="${tickets}" var="ticket">
        <tr>
            <td>${ticket.id}</td>
            <td>${ticket.dateTime}</td>
            <td>${ticket.seats}</td>
            <td>${ticket.price}</td>
        </tr>
    </c:forEach>
</table>

    </body>
</html>