<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static.css/simple.css">
</head>
<body>
    <p style="...">${redirectMessage}</p>

    <form action="login" method="post">
        <fieldset>
            <legend>Login</legend>
            Name: <input type="text" name="username"/><br>
            <input type="submit" value="Log in"/><br>
        </fieldset>
    </form>
</body>
</html>