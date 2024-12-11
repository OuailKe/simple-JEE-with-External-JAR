<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Enteties.Employe" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Employee</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      color: #333;
      text-align: center;
      margin: 0;
      padding: 0;
    }

    h1 {
      color: #f3f4f4;
      margin: 0;
      padding: 20px;
      background-color: #427ec8;
    }

    .form-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .form-box {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      width: 500px;
    }

    .form-box input[type="text"], .form-box input[type="submit"] {
      width: 80%;
      padding: 10px;
      margin: 25px 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-box input[type="submit"] {
      background-color: #427ec8;
      color: #fff;
      border: none;
      cursor: pointer;
    }

    .form-box input[type="submit"]:hover {
      background-color: #365f9c;
    }
    form{
      text-align: center;
      align-items: center;
    }
  </style>
</head>
<body>
<h1>Add Employee</h1>
<div class="form-container">
  <div class="form-box">
    <form action="/employe/updateEmploye" method="POST">
      <input type="hidden" name="id" value="${employee.id}" required>
      <input type="text" name="nom" value="${employee.nom}" required>
      <input type="text" name="prenom" value="${employee.prenom}" required>
      <input type="text" name="adresse" value="${employee.adresse}" required>
      <input type="text" name="numTel" value="${employee.numTel}" required>
      <input type="submit" value="Update Employee">
    </form>
  </div>
</div>
</body>
</html>