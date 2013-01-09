<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>Games Played by Player</title>
    </head>
    <body>
        <table>
            <tr>
                <th>#</th>
                <th>Played</th>
                <th>Game</th>
                <th>Result</th>
            </tr>
        <c:forEach var="game" items="${games}" varStatus="theCount">
            <tr>
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
    </body>
</html>