<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Product Create</title>
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
        <h2>New Product</h2>
        <form action="ProductCreate" method="POST">
            <div>
                <label for="id">id</label>
                <input type="text" name="id" id="id">
            </div>
            <div>
                <label for="name">name</label>
                <input type="text" name="name" id="name">
            </div>
            <div>
                <label for="description">description</label>
                <input type="text" name="description" id="description">
            </div>
            <div>
                <label for="price">price</label>
                <input type="text" name="price" id="price">
            </div>
            <div>
                <label for="quantity">quantity</label>
                <input type="text" name="quantity" id="quantity">
            </div>
            <div>
                <input type="submit" value="Create">
            </div>
        </form>
    </body>
</html>
