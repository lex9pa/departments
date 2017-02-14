<jsp:useBean id="department" scope="request" type="com.skobeev.model.Department"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set var="main" value="/"/>
<c:set var="save" value="/department/save"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>edit</title>
    <style>
        .R1 {
            font-size: small;
            color: red;
        }
    </style>
</head>
<body>
<p></p>
<a href=${main}>
    <button>Main</button>
</a>
<form method="post" action=${save}>
    <input id="id" type="hidden" name="id" value="${department.id}">
    <p></p>
    <div>
        <label for="name">Name</label>
        <input id="name" type="text" name="name" value="${department.name}"/>
        <div class="R1">
            ${error.name}
        </div>
    </div>
    <p></p>
    <input type="submit"/>
</form>
</body>
</html>
