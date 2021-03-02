<%--
  Created by IntelliJ IDEA.
  User: xuant
  Date: 3/2/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Edit Customer Information</h2>
<form action="/home/edit/${customer.id}" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" value="${customer.id}" disabled> </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${customer.name}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.address}"></td>
        </tr>

    </table>

    <button type="submit">Edit</button>
</form>
</body>
</html>
