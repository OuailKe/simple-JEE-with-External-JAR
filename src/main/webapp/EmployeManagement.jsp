<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Enteties.Employe" %>
<%@ page import="java.util.List" %>
<% List<Employe> employees = (List<Employe>) session.getAttribute("employees"); %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management</title>
<%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
<%--    <script>--%>
<%--        $(document).ready(function() {--%>
<%--            $.get("/employe", function(data) {--%>
<%--                $("#dataContainer").html(data);--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .table{
            margin: 0 auto;
            width: 80%;
        }
        .head {
            color: #f3f4f4;
            margin-bottom: 0;
            margin-top: 0;
            padding: 0;
            background-color: #427ec8;
            display: flex;
            justify-content: center;
            text-align: center;
            align-items: center;
            width: 100%;
            height: 65px;
        }
        table {
            width: 80%;
            margin: 80px auto 20px;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .titre{
            color: #000000;
            margin-bottom: 0;
            margin-top: 80px;
            padding: 0;

            display: flex;
            justify-content: center;
            text-align: center;
            align-items: center;

        }

        .card {
            display: inline-block;
            width: 250px;
            padding: 20px 20px 5px 20px;
            margin: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-decoration: none;
            color: #333;
            background-color: #fff;
            transition: box-shadow 0.3s ease, transform 0.3s ease;
            text-align: center;
            justify-content: center;
        }

        .card:hover {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transform: translateY(-5px);
        }

        .card h2 {
            margin: 0 0 10px;
            font-size: 1.5em;
            color: #333;
        }

        .card p {
            margin: 0;
            font-size: 1em;
            color: #666;
        }
        .container{
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 30px;
        }

    </style>
</head>
<body>

<h1 class="head"> Employee Management </h1>
<div class="container">
    <a href="/employe/addEmploye" class="card">
        <h2>Add Employee </h2>
        <%--    <p>Go to Page 1</p>--%>
    </a>

    <a href="/employe/updateEmploye" class="card">
        <h2>Modify Employee</h2>
        <%--    <p>Go to Page 2</p>--%>
    </a>
</div>

<div class="table">
    <h1 class="titre">Employees List</h1>
    <table border="1">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.nom}</td>
                <td>${employee.prenom}</td>
                <td>${employee.adresse}</td>
                <td>${employee.numTel}</td>
                <td><a href="/employe/updateEmploye?id=${employee.id}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>