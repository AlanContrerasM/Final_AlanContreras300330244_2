<%--
  Created by IntelliJ IDEA.
  User: alanr
  Date: 8/19/2021
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Loan</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h1>Add an entry</h1>
    <form method="POST">
        <fieldset class="form-group">
            <label> Client Number:</label>
            <input name="clientno" type="text" class="form-control" required />

        </fieldset>


        <fieldset class="form-group">
            <label> Client Name:</label>
            <input name="clientname" type="text" class="form-control" required />

        </fieldset>
        <fieldset class="form-group">
            <label> Loan Amount:</label>
            <input name="loanamount" type="Number" class="form-control" required />

        </fieldset>
        <fieldset class="form-group">
            <label> Number of Years:</label>
            <input name="years" type="Number" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Loan Type:</label>

           <select name="loantype" required>
                <option value="Business">Business</option>
                <option value="Personal">Personal</option>
            </select>

        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>

