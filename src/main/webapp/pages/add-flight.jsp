<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Flight Page</title>
</head>
<body>
<form method="post" action="/saveFlight">
    <input name="number" placeholder="Flight Number"><br>
    <input name="direction" placeholder="Flight Direction"><br>
    <select name="planeId">
        <c:forEach var="plane" items="${currentPlanes}">
            <option value="${plane.id}">${plane.model}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Add Flight">
</form>
</body>
</html>