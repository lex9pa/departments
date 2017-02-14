<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<c:set var="department" value="/department"/>
<c:set var="user" value="/user"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Main</title>
</head>
<body>
<div>Main page</div>
<a href=${department}><button>departments</button></a>
<a href=${user}><button>users</button></a>
</body>
</html>
