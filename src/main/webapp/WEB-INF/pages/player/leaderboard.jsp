<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>Leaderboard</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <form>
                    <div class="btn-group">
                        <a class="btn" href="../player"><i class='icon-list-alt'></i> All Players</a>
                        <a class="btn btn-success" href="../game/add"><i class='icon-plus icon-white'></i> Add Game</a>
                    </div>
                    <span style='line-height:40px'>
                        Minimum Games Required: <b><%= au.com.pingmate.service.DefaultPlayerService.minimumGamesRequired() %></b>
                        <attr title='<%= au.com.pingmate.service.DefaultPlayerService.INITIAL_REQUIRED_GAMES %> initial games plus <%= au.com.pingmate.service.DefaultPlayerService.GAMES_PER_WEEK %> per week since competition start.'>
                            <i class='icon-question-sign'></i>
                        </attr>
                    </span>
                </form>
                <table class="table table-hover">
                    <tr>
                        <th>Rank</th>
                        <th>Name</th>
                        <th>Score</th>
                        <th>Wins</th>
                        <th>Losses</th>
                        <th>Total</th>
                    </tr>
                    <c:forEach var="record" items="${players}" varStatus="theCount">
                        <tr>
                           <td>${theCount.count}</td>
                           <td><a href='../game/player/${record.player.identifier}/history'>${record.player.name}</a></td>
                           <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${record.player.ranking}" /></td>
                           <td>${record.wins} (${record.winPercent}%)</td>
                           <td>${record.losses} (${record.lossPercent}%)</td>
                           <td>${record.total}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>