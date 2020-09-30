<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product View</title>
    </head>
    <body>
        <a href="/productinventory/products">Home</a>
        <h2>Product details</h2>
        <div>
            <p>Id: ${product.id}</p>
            <p>Name: ${product.name}</p>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Quantity: ${product.quantity}</p>
        </div>
    </body>
</html>
