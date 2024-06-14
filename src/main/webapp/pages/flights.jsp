<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights Page</title>
</head>
<body>
<h1>Flights:</h1>
<table border="1">
    <tr>
        <th>Number</th>
        <th>Direction</th>
        <th>Airplane</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="flight" items="${flights}">
        <tr>
            <td>${flight.number}</td>
            <td>${flight.direction}</td>
            <td>${flight.airplane.model}</td>
            <td>
                <a href="/viewFlight/${flight.id}">View</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p>
    <a href="/addFlight">Open new Direction</a>
</p>
<p>
    <a href="/">Back to main</a>
</p>
</body>
</html>