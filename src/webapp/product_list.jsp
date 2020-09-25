<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <title>Product List</title>
            <style>
                table,
                td ,
                thead,
                th {
                    border: 1px solid black;
                }
            </style>
    </head>
    <body>
        <h2>Products</h2>
        <div>

            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>    
                        <td><a href="./product?id=${product.id}">${product.id}</a></td>
                        <td><a href="./product?id=${product.id}">${product.name}</a></td>
                        <td><a href="./product?id=${product.id}">${product.description}</a></td>
                        <td><a href="./product?id=${product.id}">${product.price}</a></td>
                        <td><a href="./product?id=${product.id}">${product.quantity}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
