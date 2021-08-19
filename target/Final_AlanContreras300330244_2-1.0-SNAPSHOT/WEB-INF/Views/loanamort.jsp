<%--
  Created by IntelliJ IDEA.
  User: alanr
  Date: 8/19/2021
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alan Contreras Amort</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Projected table of customer number: ${clientno}</h1>
    <h1>Name: ${clientname}</h1>
    <table class="table ">
        <thead>
        <tr>
            <th>Month</th>
            <th>Starting Amount</th>
            <th>Interest</th>
            <th>Monthly Payment</th>
            <th>Ending Balance</th>

        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">



            <tr>
                <td>${todo.month}</td>
                <td>${todo.startingAmount}</td>
                <td>${todo.interest}</td>
                <td>${todo.monthlyPayment}</td>
                <td>${todo.endingBalance}</td>


                


            </tr>


        </c:forEach>
        </tbody>
    </table>


</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
