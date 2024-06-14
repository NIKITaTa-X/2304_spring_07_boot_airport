<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Airplanes Page</title>
</head>
<body>
    <h1>Airplanes:</h1>
    <table border="1">
        <tr>
            <th>Model</th>
            <th>Places</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="airplane" items="${planes}">
            <tr>
                <td>${airplane.model}</td>
                <td>${airplane.places}</td>
                <td>
                    <c:if test="${empty airplane.flights}">
                        <a href="/delPlane/${airplane.id}">Delete</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/pages/add-plane.jsp">Buy new Airplane</a>
    </p>
    <p>
        <a href="/">Back to main</a>
    </p>
</body>
</html>