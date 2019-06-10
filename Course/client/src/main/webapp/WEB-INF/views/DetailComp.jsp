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
    <title>Competition page</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<jsp:include page="../fragments/header.jsp" />
<body>
<div class="container">
    <br>
    <br>
    <h2>Competition detail</h2>
    <br />
    <div class="row">
        <label class="col-sm-2">Name </label>
        <div class="col-sm-10">${detailComp.t}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Date </label>
        <div class="col-sm-10">${detailComp.name}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">Country </label>
        <div class="col-sm-10">${detailComp.country}</div>
    </div>
    <div class="row">
        <label class="col-sm-2">City </label>
        <div class="col-sm-10">${detailComp.city}</div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-sm-10">
            <c:if test="${user eq 'admin'}">
                <button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#example">Update</button>
            </c:if>
            <button type="button"  class="btn btn-info" onclick="location.href='/competition/'">Back</button>
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
                    <h5 class="modal-title" id="exampleModalLongTitle">Update a competition</h5>
                </div>
                <form method="POST" action="/competition/update/${detailComp.id}">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-form-label">Name:</label>
                            <input type="text" name="name" class="form-control" id="name" value=${detailComp.t}>
                        </div>
                        <div class="form-group">
                            <label for="country" class="col-form-label">Country:</label>
                            <input type="text" name="country" class="form-control" id="country" value=${detailComp.country}>
                        </div>
                        <div class="form-group">
                            <label for="city" class="col-form-label">City:</label>
                            <input type="text" name="city" class="form-control" id="city" value=${detailComp.city}>
                        </div>
                        <div class="form-group">
                            <label for="t">Start date:</label>
                            <input type="date" id="t" name="t"
                                   value="2019-07-22"
                                   min="2019-01-01" max="2019-12-31">
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