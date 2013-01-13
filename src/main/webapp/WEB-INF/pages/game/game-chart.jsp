<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<html>
    <head>
        <title>Game Statistics of ${player.name}</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
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
                        <a class="btn" href="stats"><i class="icon-tasks"></i> Stats</a>
                    </div>
                </div>
            </div>
            <div class="row">
                <div id="chartArea" style='span12'>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var scores = [];
            var games;
            var chart;
            scores.push([0, 1000.0]);
            $(function() {
                var options = {
                            chart: { renderTo: 'chartArea' },
                            title: { text: "${player.name}'s Ranking History" },
                            xAxis: {
                                tickInterval: 1,
                                tickWidth: 0,
                                gridLineWidth: 1
                            },
                            yAxis: [{
                                title: {
                                    text: 'Ranking Points'
                                },
                                labels: {
                                    formatter: function() {
                                        return Highcharts.numberFormat(this.value, 0);
                                    }
                                }
                            }],
                            legend: {
                                enabled: false
                            },
                            tooltip: {
                                formatter: function() {
                                    if (this.x == 0) {
                                        return "Player added into the system";
                                    }
                                    var game = games[this.x - 1];
                                    var played = new Date(game.played);
                                    return game.winner.name + ' vs ' + game.loser.name + '<br />' +
                                            game.winningScore + ':' + game.losingScore + ' - ' + this.y.toFixed(0) + '<br />' +
                                            played.getDate() + '/' + (played.getMonth() + 1) + '/' + played.getFullYear();
                                }
                            },
                            series: [{
                                lineWidth: 4,
                                marker: {
                                    radius: 4
                                }
                            }]
                        };

                jQuery.get('http://localhost:8080/ping-mate/game/player/2/json', null, function(data, state, xhr) {
                    games = data;
                    for (var i = 0; i < data.length; i++) {
                        var score = data[i].losingPlayerRanking;
                        if (data[i].winner.identifier == ${player.identifier}) {
                            score = data[i].winningPlayerRanking;
                        }
                        scores.push([i+1, score])
                    }
                    options.series[0].data = scores;
                    chart = new Highcharts.Chart(options);
                });
            });
        </script>
    </body>
</html>