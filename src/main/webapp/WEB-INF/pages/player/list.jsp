<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>View Players</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    </head>
    <body>
    <div class="container">
        <div class="row">
        <form:form method="post" action="player/add">
            <form:input path="name" placeholder="Player Name..." style="height:25px;margin-top:10px;padding-bottom:0"/>
            <div class="btn-group">
                <input class="btn btn-primary" type="submit" value="Add Player" />
                <input class="btn btn-success" type="button" value="Add Game" onclick="window.location='game/add';return false" />
            </div>
        </form:form>
        <table class="table table-hover">
            <tr>
                <th>Rank</th>
                <th>Name</th>
                <th>Score</th>
            </tr>
        <c:forEach var="player" items="${players}" varStatus="theCount">
            <tr>
               <td>${theCount.count}</td>
               <td><a href='game/player/${player.identifier}'>${player.name}</a></td>
               <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${player.ranking}" /></td>
            </tr>
        </c:forEach>
        </div>
        </div>
    </body>
</html>