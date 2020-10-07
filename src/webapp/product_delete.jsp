<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Delete</title>
    </head>
    <body>
        <a href="/productinventory/products">Home</a>
        <h2>Are you sure you want to delete this product?</h2>
        <div>
            <p>Id: ${product.id}</p>
            <p>Name: ${product.name}</p>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Quantity: ${product.quantity}</p>
        </div>
        <form action="" method="POST">
            <div>
                <input type="submit" value="Yes, delete it!">
            </div>
        </form>
    </body>
</html>
