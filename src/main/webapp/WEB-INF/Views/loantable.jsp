<%--
  Created by IntelliJ IDEA.
  User: alanr
  Date: 8/19/2021
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Alan Contreras Final 300330244</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        h1{
            text-align: center;
        }
    </style>
</head>

<body>
<h1>Alan Contreras 300330244 - Loan Records</h1>
<div class="container">
    <form method="GET">
    </form>
</div>

<h1 id="mes">${errorMessage}</h1>
<div class="container">
    <p>The following are the loan records...</p>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client Number</th>
            <th>Client Name</th>
            <th>Loan Amount</th>
            <th>Number of Years</th>
            <th>Loan Type</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">



            <tr>
                <td>${todo.clientno}</td>
                <td>${todo.clientname}</td>
                <td>${todo.loanamount}</td>
                <td>${todo.years}</td>
                <td>${todo.loantype}</td>


                <td class="d-flex flex-row">
                    <a type="button" class="btn btn-primary w-100"
                           href="update-todo?id=${todo.clientno}" >Edit</a>
                    <a type="button" class="btn btn-warning w-100"
                       href="delete-todo?id=${todo.clientno}" >Delete</a>
                </td>



                <td>    <a type="button" class="btn btn-primary w-100"
                           href="amortizate-todo?id=${todo.clientno}" >Amortization Table</a> </td>





            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>
<a href="add-todo" class="btn btn-success w-100">Add</a>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
    function myFunction(){
        document.getElementById("mes").innerHTML = "";
    }
</script>
</body>
</html>

