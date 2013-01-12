<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>Game Statistics of ${player.name}</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h2>${player.name}'s Statistics</h2>
            </div>
            <div class="row">
                <div class="btn-toolbar">
                    <div class="btn-group">
                        <a class="btn" href="../../../player"><i class="icon-arrow-left"></i> Back</a>
                        <a class="btn" href="history"><i class="icon-list-alt"></i> History</a>
                        <a class="btn" href="chart"><i class="icon-signal"></i> Chart</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="span2">
                    <span class="lead">
                        Overall
                    </span>
                    <div class="row">
                        <div class="span1">Won</div>
                        <div class="span1 text-success">${stats.wins}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Lost</div>
                        <div class="span1 text-error">${stats.losses}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Total</div>
                        <div class="span1">${stats.wins + stats.losses}</div>
                    </div>
                </div>
                <div class="span2">
                    <span class="lead">
                        Tie-Break
                    </span>
                    <div class="row">
                        <div class="span1">Won</div>
                        <div class="span1 text-success">${stats.tieBreakWins}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Lost</div>
                        <div class="span1 text-error">${stats.tieBreakLosses}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Total</div>
                        <div class="span1">${stats.tieBreakWins + stats.tieBreakLosses}</div>
                    </div>
                </div>
                <c:if test = "${stats.wins > 0}">
                    <div class="span2">
                        <span class="lead">
                            Win Scores
                        </span>
                        <div class="row">
                            <div class="span1">Max</div>
                            <div class="span1 text-success">${stats.winMaxScore}</div>
                        </div>
                        <div class="row">
                            <div class="span1">Min</div>
                            <div class="span1">${stats.winMinScore}</div>
                        </div>
                        <div class="row">
                            <div class="span1">Avg</div>
                            <div class="span1">${stats.winTotalScore / stats.wins}</div>
                        </div>
                    </div>
                </c:if>
                <c:if test = "${stats.losses > 0}">
                    <div class="span2">
                        <span class="lead">
                            Loss Scores
                        </span>
                        <div class="row">
                            <div class="span1">Max</div>
                            <div class="span1">${stats.lossMaxScore}</div>
                        </div>
                        <div class="row">
                            <div class="span1">Min</div>
                            <div class="span1 text-success">${stats.lossMinScore}</div>
                        </div>
                        <div class="row">
                            <div class="span1">Avg</div>
                            <div class="span1">${stats.lossTotalScore / stats.losses}</div>
                        </div>
                    </div>
                </c:if>
                <div class="span3">
                    <span class="lead">
                        Relations
                    </span>
                    <div class="row">
                        <div class="span1">Victim</div>
                        <div class="span1 text-success">${stats.victim.name}</div>
                        <div class="span1">${stats.victimScore}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Nemesis</div>
                        <div class="span1 text-error">${stats.nemesis.name}</div>
                        <div class="span1">${stats.nemesisScore}</div>
                    </div>
                    <div class="row">
                        <div class="span1">Bully</div>
                        <div class="span1 text-error">${stats.victim.name}</div>
                        <div class="span1">${stats.victimScore}</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>