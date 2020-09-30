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
        <form action="" method="POST">
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
                <input type="number" name="price" id="price" min="0" step="0.01">
            </div>
            <div>
                <label for="quantity">quantity</label>
                <input type="number" name="quantity" id="quantity" min="0">
            </div>
            <div>
                <input type="submit" value="Create">
            </div>
        </form>
    </body>
</html>
