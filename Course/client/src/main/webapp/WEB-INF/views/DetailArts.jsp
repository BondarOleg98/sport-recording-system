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
    <h2>Art detail</h2>
    <br />
    <div class="row">
        <label class="col-sm-2">Name </label>
        <div class="col-sm-10">${detailArts.name}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Coaches:</label>
    </div>
    <div class="row">
        <c:forEach items="${chooseCoaches}" var ="coach">
            <div class="col-sm-10">${coach.name} ${coach.surname}</div>
        </c:forEach>
    </div>
    <br>
    <div class="row">
        <label class="col-sm-2">Students:</label>
    </div>
    <div class="row">
        <c:forEach items="${chooseStudents}" var ="student">
            <div class="col-sm-10">${student.name} ${student.surname}</div>
        </c:forEach>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-sm-10">
            <c:if test="${user eq 'admin'}">
                <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#example">Update</button>
            </c:if>
            <button type="button"  class="btn btn-info" onclick="location.href='/art/'">Back</button>
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
                    <h5 class="modal-title" id="exampleModalLongTitle">Update a coach</h5>
                </div>
                <form method="POST" action="/art/update/${detailArts.id}">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" name="name" class="form-control" id="name" value=${detailArts.name}>
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