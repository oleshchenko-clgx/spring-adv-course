<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boooked ticket</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body>
        <b>Booked ticket:</b>
            <br>


            Id: ${ticket.id} <br/>
            dateTime: ${ticket.dateTime} <br/>
            seats: ${ticket.seats} <br/>
            price: ${ticket.price} <br/>

    </body>
</html>