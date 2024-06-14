<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UPD Flight Page</title>
</head>
<body>
<p>
    You try to change flight number: ${updatedFlight.number}<br>
    You can only change an airplane!!!
</p>
<form method="post" action="/saveFlight">
    <input name="id" type="hidden" value="${updatedFlight.id}">
    <input name="number" type="hidden" value="${updatedFlight.number}">
    <input name="direction" type="hidden" value="${updatedFlight.direction}">
    <select name="planeId">
        <c:forEach var="plane" items="${currentPlanes}">
            <option value="${plane.id}" ${plane.id eq updatedFlight.airplane.id
            ? ' selected' : ''}>${plane.model}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Update Flight">
</form>
</body>
</html>