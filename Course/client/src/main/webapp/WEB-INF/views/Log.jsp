<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<jsp:include page="../fragments/header.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Coach page</title>
</head>
<body>
<div class="container">
    <br>
    <br>
    <h2>Logs</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Action</th>
            <th>Time</th>
        </tr>
        </thead>
        <c:forEach items="${ListLog}" var ="log">
            <tr>
                <td>${log.action}</td>
                <td>${log.date}</td>

            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<button type="button" class="btn btn-danger btn-lg my-2 col-2 offset-5" data-toggle="modal" data-target="#exampleModalCenter" onclick="location.href='/log/delete'">Clear</button>
</body>
</html>