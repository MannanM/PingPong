<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>Games Played by Player</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    </head>
    <body>
           <div class="container">
            <div class="row">
        <table class="table table-hover">
            <tr>
                <th>#</th>
                <th>Played</th>
                <th>Game</th>
                <th>Result</th>
            </tr>
        <c:forEach var="game" items="${games}" varStatus="theCount">
            <c:choose>
                <c:when test="${playerId == game.winner.identifier}">
                    <tr class="success">
                </c:when>
                <c:otherwise>
                    <tr class="error">
                </c:otherwise>
            </c:choose>
               <td>${fn:length(games) - theCount.index}</td>
               <td><fmt:formatDate pattern="d/M/yy" value="${game.played}" /></td>
               <td>${game.winner.name}
                    (<fmt:formatNumber type="number" maxFractionDigits="0" value="${game.winningPlayerRanking}" />)
                     vs
                     ${game.loser.name}
                     (<fmt:formatNumber type="number" maxFractionDigits="0" value="${game.losingPlayerRanking}" />)
                </td>
               <td>${game.winningScore}:${game.losingScore}</td>
            </tr>
        </c:forEach>
        </div>
        </div>
    </body>
</html>