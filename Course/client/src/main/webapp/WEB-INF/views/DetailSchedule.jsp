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
    <title>Schedule page</title>
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
        <label class="col-sm-2">Day </label>
        <div class="col-sm-10">${detailSchedule.day}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Time </label>
        <div class="col-sm-10">${detailSchedule.timeClass}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Coach </label>
        <div class="col-sm-10">${detailSchedule.coach.name} ${detailSchedule.coach.surname}</div>
    </div>

    <br>
    <br>
    <div class="row">
        <div class="col-sm-10">
            <c:if test="${user eq 'admin'}">
                <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#example">Update</button>
            </c:if>

            <button type="button"  class="btn btn-info" onclick="location.href='/schedule/'">Back</button>
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
                    <h5 class="modal-title" id="exampleModalLongTitle">Update a schedule</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="POST" action="/schedule/update/${detailSchedule.id}">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="day" class="col-form-label">Name:</label>
                            <input type="text" name="day" class="form-control" id="day" value=${detailSchedule.day}>
                        </div>
                        Coaches
                        <div class="form-group">
                            <c:forEach items="${ListCoaches}" var ="coach">
                                <label class="col-form-label">${coach.name} ${coach.surname}</label>
                                <input type="radio" name="indCoach" value="${coach.id}">
                                <br>
                            </c:forEach>
                        </div>
                        Time:
                        <div class="form-group">
                            <input type="time" name="selected_time" value="${detailSchedule.timeClass}">
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