<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="edit" value="/user/form"/>
<c:set var="delete" value="/user/delete"/>
<c:set var="main" value="/"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>users</title>
</head>
<body>
<p><a href=${main}>
    <button>Main</button>
</a>
</p>

<a href=${edit}>
    <button>Add</button>
</a>
<style>
    table {
        width: 40%;
        background: black;
        color: black;
        border-spacing: 1px;
    }

    td, th {
        background: white;
        padding: 5px;
    }
</style>
<table border="0.5">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Last name</td>
        <td>e-mail</td>
        <td>Birth Day</td>
        <td>Salary</td>
        <td>Department's id</td>
        <td></td><td></td>
    </tr>
    <jsp:useBean id="user" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${user}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.mail}"/></td>
            <td><c:out value="${user.birthDay}"/></td>
            <td><c:out value="${user.salary}"/></td>
            <td><c:out value="${user.depId}"/></td>
            <td>
                <c:url value="${edit}" var="edit">
                    <c:param name="id" value="${user.id}"/>
                </c:url>
                <a href="${edit}">Edit</a>
            </td>
            <td><c:url value="${delete}" var="del">
                <c:param name="id" value="${user.id}"/>
            </c:url>
                <a href="${del}">delete</a>

            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
