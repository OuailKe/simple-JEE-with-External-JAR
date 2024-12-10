<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 100%;
            margin: 0 auto;
            padding: 0 ;
            background-color: #f4f4f9;
            color: #333;
            text-align: center;
        }

        h1 {
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

        .card {
            display: inline-block;
            width: 250px;
            padding: 20px;
            margin: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-decoration: none;
            color: #333;
            background-color: #fff;
            transition: box-shadow 0.3s ease, transform 0.3s ease;
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
    </style>
</head>
<body>
<h1>Welcome</h1>

<a href="/JeeVersion_war_exploded/employe" class="card">
    <h2>Employe Management</h2>
<%--    <p>Go to Page 1</p>--%>
</a>

<a href="SalaryManagement.jsp" class="card">
    <h2>FicheSalaire Management</h2>
<%--    <p>Go to Page 2</p>--%>
</a>

</body>
</html>