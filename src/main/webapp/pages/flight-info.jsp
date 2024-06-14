<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flight Info</title>
</head>
<body>
<h1>Flight Number: ${flight.number}</h1>
<h2>Flight Direction: ${flight.direction}</h2>
<h2>Airplane Model: ${flight.airplane.model}</h2>
<h1>Passengers:</h1>
<table border="1">
    <tr>
        <th>FIO</th>
        <th>Place</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="passenger" items="${flight.passengers}">
        <tr>
            <td>${passenger.fio}</td>
            <td>${passenger.place}</td>
            <td>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>