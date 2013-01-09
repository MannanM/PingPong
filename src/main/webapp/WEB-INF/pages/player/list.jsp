<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>View Players</title>
    </head>
    <body>
        <form:form method="post" action="player/add">
            <form:label path="name">Name</form:label>
            <form:input path="name" />
            <input type="submit" value="Add Player"/>
            <a href="game/add">Add Game</a>
        </form:form>
        <table>
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
    </body>
</html>