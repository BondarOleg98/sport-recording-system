<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student's page</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="../fragments/header.jsp" />
<body>
<div class="container">

    <br>
    <br>

    <h2>Student's detail</h2>
    <br />
    <div class="row">
        <label class="col-sm-2">Name </label>
        <div class="col-sm-10">${detailStudents.name}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Surname </label>
        <div class="col-sm-10">${detailStudents.surname}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Age </label>
        <div class="col-sm-10">${detailStudents.age}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Belt </label>
        <div class="col-sm-10">${detailStudents.belt}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Count wins </label>
        <div class="col-sm-10">${detailStudents.countWins}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Status </label>
        <div class="col-sm-10">${detailStudents.status}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Art </label>
        <div class="col-sm-10">${detailStudents.artStyle.name}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Coach </label>
        <div class="col-sm-10">${detailStudents.coach.name} ${detailStudents.coach.surname}</div>
    </div>

    <br>
    <br>
    <div class="row">
        <div class="col-sm-10">
            <c:if test="${user eq 'admin'}">
                <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#example">Update</button>
            </c:if>

            <button type="button"  class="btn btn-info" onclick="location.href='/student/'">Back</button>
        </div>
    </div>

</div>
<br>
<br>
<div class="col-10 offset-1">
    <div class="modal fade" id="example" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Update a student</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="POST" action="/student/update/${detailStudents.id}">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" name="name" class="form-control" id="name" value=${detailStudents.name}>
                        </div>
                        <div class="form-group">
                            <label for="surname" class="col-form-label">Surname:</label>
                            <input type="text" name="surname" class="form-control" id="surname" value=${detailStudents.surname}>
                        </div>
                        <div class="form-group">
                            <label for="age" class="col-form-label">Age:</label>
                            <input type="number" name="age" class="form-control" id="age"  value=${detailStudents.age}>
                        </div>
                        <div class="form-group">
                            <label for="belt" class="col-form-label">Belt:</label>
                            <input type="text" name="belt" class="form-control" id="belt" value=${detailStudents.belt}>
                        </div>
                        <div class="form-group">
                            <label for="countWins" class="col-form-label">Count wins:</label>
                            <input type="number" name="countWins" class="form-control" id="countWins" value=${detailStudents.countWins}>
                        </div>
                        <div class="form-group">
                            <label for="status" class="col-form-label">Status:</label>
                            <input type="text" name="status" class="form-control" id="status" value=${detailStudents.status}>
                        </div>
                        Coaches
                        <div class="form-group">
                            <c:forEach items="${ListCoaches}" var ="coach">
                                <label class="col-form-label">${coach.name} ${coach.surname}</label>
                                <input type="radio" name="indCoach" value="${coach.id}">
                                <br>
                            </c:forEach>
                        </div>
                        Arts
                        <div class="form-group">
                            <c:forEach items="${ListArts}" var ="art">
                                <label class="col-form-label">${art.name}</label>
                                <input type="radio" name="indArt" value="${art.id}">
                                <br>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary"  type="submit">Update</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>