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
    <title>Person area</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="../fragments/header.jsp" />
<body>
<div class="container">
    <br>
    <br>
    <h2>Welcome to your personal area, ${name}</h2>
    <br />

    <b>
        <div class="row">
            <label class="col-sm-2">Future events: </label>
        </div>
    </b>
    <div class="row">
        <c:forEach items="${FutureEvent.competitions}" var ="event">
            <div class="col-sm-10">${event.t} ${event.name}</div>
            <br>
        </c:forEach>
    </div>
    <br>
    <c:if test="${role eq 'USER'}">
        <b>
            <div class="row">
                <label class="col-sm-2">Your training: </label>
            </div>
        </b>
    </c:if>
    <c:if test="${role eq 'ADMIN'}">
        <b>
            <div class="row">
                <label class="col-sm-2">Your training: </label>
            </div>
        </b>
    </c:if>
    <c:if test="${role eq 'COACH'}">
            <b><h5>Applies</h5></b>
            <table class="table table-striped">
                <c:forEach items="${Apply}" var ="apply">
                    <c:forEach items="${apply.schedules}" var ="sch">
                        <tr>
                            <td>${sch.day}</td>
                            <td>${sch.timeClass} </td>
                            <td>${apply.name}</td>
                            <td>
                                <c:if test="${role eq 'COACH'}">
                                    <form class="form-inline my-2 my-lg-0" action=/person/confirm/${apply.id} method="post">
                                        <button class="btn btn-warning" type="submit">Confirm</button>
                                    </form>
                                    <form class="form-inline my-2 my-lg-0" action=/person/reject/${apply.id} method="post">
                                        <button class="btn btn-danger" type="submit">Reject</button>
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                        <br>
                    </c:forEach>
                </c:forEach>
            </table>
    </c:if>
    <div class="row">
        <c:forEach items="${FutureEvent.schedules}" var ="schedule">
            <div class="col-sm-10">${schedule.day} ${schedule.timeClass} - ${schedule.coach.name} ${schedule.coach.surname}</div>
            <br>
        </c:forEach>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-sm-10">

            <c:if test="${role eq 'USER'}">
                <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#examp">Write on training</button>
            </c:if>

            <c:if test="${role eq 'ADMIN'}">
                <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#examp">Write on training</button>
            </c:if>
            <button type="button"  class="btn btn-info" data-toggle="modal" data-target="#example">Write on competition</button>


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
                    <h5 class="modal-title" id="exampleModalLongTitle">Apply</h5>
                </div>
                <form method="POST" action="/personal/create">
                    <div class="modal-body">
                        <b>Competitions:</b>
                        <br>
                        <div class="form-group">
                            <c:forEach items="${ListCompetition}" var ="competition">
                                <label for="competition" id="competition" class="col-form-label">${competition.t} ${competition.name}</label>
                                <input type="checkbox" name="${competition.id}">
                                <br>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary"  type="submit">Write</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<div class="col-10 offset-1">
    <div class="modal fade" id="examp" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" >Apply</h5>
                </div>
                <form method="POST" action="/person/create">
                    <div class="modal-body">
                        <b>Schedule and coach:</b>
                        <div class="form-group">
                            <c:forEach items="${ListLesson}" var ="lesson">
                                <label for="coach" id="coach" class="col-form-label">${lesson.day} ${lesson.timeClass} - ${lesson.coach.name}
                                ${lesson.coach.surname}</label>
                                <input type="radio" name="lessonId" value="${lesson.id}">
                                <br>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button class="btn btn-primary"  type="submit">Write</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>