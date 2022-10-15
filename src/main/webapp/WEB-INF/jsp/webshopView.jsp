<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebShop</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/static.css/simple.css">
</head>
<body>
    <p>You are logged in as <c:out value="${username}"/><br>
    Total in cart: NOK ${cart.total}</p>
    <table>
        <tr>
            <th>Item</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Sum</th>
        </tr>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.price * item.quantity}</td>
        </tr></c:forEach>
    </table>

    <form action="webshop" method="post">
        <fieldset><legend>Shop</legend>
            <input type="checkbox" name="item" value="Pants"/>Pants<br/>
            <input type="checkbox" name="item" value="Sweater"/>Sweater<br/>
            <p><input type="submit" value="Add to cart"></p>
        </fieldset>
    </form>

    <form action="logout" method="post">
        <fieldset>
            <p><input type="submit" value="Log out"></p>
        </fieldset>
    </form>
</body>