<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<head>
    <jsp:include page="../fragments/header.jsp" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Coach page</title>
</head>
<body>

<div class="container">
    <br>
    <br>
    <h2>All coaches</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Rank</th>
            <th>Action</th>

        </tr>
        </thead>
        <c:forEach items="${ListCoaches}" var ="coach">
            <tr>
                <td>${coach.name}</td>
                <td>${coach.surname}</td>
                <td>${coach.rank}</td>
                    <td>
                        <button type="button" class="${color.name}" onclick="location.href='/coach/${coach.id}'">Details</button>
                        <c:if test="${user eq 'admin'}">
                            <button type="button" class="btn btn-danger" onclick="location.href='/coach/delete/${coach.id}'">Delete</button>
                        </c:if>
                    </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<br>
<c:if test="${user eq 'admin'}">
    <button type="button" class="btn btn-success btn-lg my-2 col-2 offset-5" data-toggle="modal" data-target="#exampleModalCenter">Create</button>
</c:if>
<div class="col-10 offset-1">
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Add a new coach</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="POST" action="/coach/create" name="input">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" name="name" class="form-control" id="name">
                        </div>
                        <div class="form-group">
                            <label for="surname" class="col-form-label">Surname:</label>
                            <input type="text" name="surname" class="form-control" id="surname">
                        </div>
                        <div class="form-group">
                            <label for="rank" class="col-form-label">Rank:</label>
                            <input type="text" name="rank" class="form-control" id="rank">
                        </div>
                        <div class="form-group">
                            <label for="mail" class="col-form-label">Mail:</label>
                            <input type="text" name="mail" class="form-control" id="mail">
                        </div>
                        <div class="form-group">
                            <label for="age" class="col-form-label">Age:</label>
                            <input type="number" name="age" class="form-control" id="age">
                        </div>
                        Arts:
                        <div class="form-group">
                                <c:forEach items="${ListArts}" var ="art">
                                    <input type="radio" name="indArt" value="${art.id}">
                                    <label  class="col-form-label">${art.name}</label>

                                    <br>
                                </c:forEach>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary"  type="submit">Add</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<script>

</script>
</body>
</html>