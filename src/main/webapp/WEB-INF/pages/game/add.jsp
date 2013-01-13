<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Add Game</title>
         <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
         <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <h2>Add Game</h2>
            <form:form method="post" action="./add">
                <div class="row">
                    <form:select path="player1" class="span3">
                        <form:options items="${players}" itemValue="identifier" />
                    </form:select>
                    <form:input path="player1Score" class="input-medium span1" style="height:30px"/>
                    VS.
                    <form:input path="player2Score" class="input-medium span1" style="height:30px"/>
                    <form:select path="player2" class="span3" >
                        <form:options items="${players}" itemValue="identifier" />
                    </form:select>
                    <form:input path="played"  class="input-small" style="height:30"/>
                    <input type="submit" value="Add Game" class="btn btn-success" style="margin-bottom:10px"/>
                </div>
            </form:form>
        </div>
    </body>
</html>