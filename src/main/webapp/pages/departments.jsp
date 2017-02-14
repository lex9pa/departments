<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="main" value="/"/>
<c:set var="form" value="/department/form"/>
<c:set var="user" value="/user"/>
<c:set var="delete" value="/department/delete"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>departments</title>
</head>
<body>
<a href=${main}>
    <button>Main</button>
</a>
<p>
</p>
<a href="${form}">
    <button>Add</button>
</a>
<style>
    table {
        width: 30%;
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
        <td>id</td>
        <td>Name</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach var="department" items="${department}">
        <tr>
            <td><c:out value="${department.id}"/></td>
            <td><c:url value="${user}" var="showUser">
                <c:param name="id" value="${department.id}"/>
            </c:url>
                <a href="${showUser}"><c:out value="${department.name}"/></a></td>
            <td>
                <c:url value="${form}" var="edit">
                    <c:param name="id" value="${department.id}"/>
                </c:url>
                <a href="${edit}">Edit</a>
            </td>
            <td><c:url value="${delete}" var="del">
                <c:param name="id" value="${department.id}"/>
            </c:url>
                <a href="${del}">delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
