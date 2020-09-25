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
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </body>
</html>
