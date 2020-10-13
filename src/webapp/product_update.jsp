<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Update</title>
        <style>
            form {
                display: table;
            }
            form div {
                display: table-row;
            }
            label, input {
                display: table-cell;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <a href="/productinventory/products">Home</a>
        <h2>Modify product</h2>
        <div>
            <p>Id: ${product.id}</p>
        </div> 
        <form action="/productinventory/product/update?id=${product.id}" method="POST">
            <div>
                <label for="name">name</label>
                <input type="text" name="name" id="name" value="${product.name}">
            </div>
            <div>
                <label for="description">description</label>
                <input type="text" name="description" id="description" value="${product.description}" >
            </div>
            <div>
                <label for="price">price</label>
                <input type="number" name="price" id="price" min="0" step="0.01" value="${product.price}">
            </div>
            <div>
                <label for="quantity">quantity</label>
                <input type="number" name="quantity" id="quantity" min="0" value="${product.quantity}">
            </div>
            <div>
                <input type="submit" value="Update">
            </div>
        </form>
    </body>
</html>
