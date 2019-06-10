<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Martial arts</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/coach">Coaches</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/student">Students</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/art">Art</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/competition">Competition</a>
            </li>
            <c:if test="${user eq 'admin'}">
                <li class="nav-item">
                    <a class="nav-link" href="/log">Log</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="/schedule">Schedule</a>
            </li>
        </ul>
        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit" onclick="location.href='/personal'">Personal Area</button>
        <form class="form-inline my-2 my-lg-0" action=/logout method="post">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign out</button>
        </form></p>
    </div>
</nav>

