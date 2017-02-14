<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" scope="request" type="com.skobeev.model.User"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<c:set var="main" value="/"/>
<c:set var="save" value="/user/save"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>edit</title>
    <style>
        .R1 {
            font-size: small;
            color: red;
            margin-left: 5px;
        }
    </style>
</head>
<body>
<p></p>
<a href=${main}>
    <button>Main</button>
</a>
<form method="post" action=${save}>
    <input id="id" type="hidden" name="id" value="${user.id}">
    <div>
        <label for="firstName">Name</label>
        <input type="text" id="firstName" name="firstName" value="${user.firstName}"/>
        <div class="R1">
        ${error.firstName}
        </div>
    </div>
    <div>
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" name="lastName" value="${user.lastName}"/>
        <div class="R1">
            ${error.lastName}
        </div>
    </div>
    <div>
        <label for="mail">e-mail</label>
        <input type="email" id="mail"  name="mail" value="${user.mail}"/>
        <div class="R1">
            ${error.mail}
        </div>
    </div>
    <div>
        <label for="birthDay">Birth Day</label>
        <input type="date" id="birthDay" name="birthDay" value="${user.birthDay}"/>
        <div class="R1">
            ${error.birthDay}
        </div>
    </div>
    <div>
        <label for="salary">Salary</label>
        <input type="number" id="salary" name="salary" value="${user.salary}"/>
        <div class="R1">
            ${error.salary}
        </div>
    </div>
    <div>
        <label for="depId">Department's id</label>
        <input type="number" id="depId" name="depId" value="${user.depId}"/>
    </div>
    <input type="submit"/>
</form>
</body>
</html>
