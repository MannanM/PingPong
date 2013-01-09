<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Add Game</title>
    </head>
    <body>
        <h2>Add Player</h2>
        <form:form method="post" action="./add">
            <table>
                <tr>
                    <td><form:label path="played">Played</form:label></td>
                    <td><form:input path="played" /></td>
                </tr>
                <tr>
                    <td><form:label path="player1">Player 1</form:label></td>
                    <td>
                        <form:select path="player1">
                            <form:options items="${players}" itemValue="identifier" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="player1Score">Player 1 Score</form:label></td>
                    <td><form:input path="player1Score" /></td>
                </tr>
                <tr>
                    <td><form:label path="player2">Player 2</form:label></td>
                    <td>
                        <form:select path="player2" >
                            <form:options items="${players}" itemValue="identifier" />
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><form:label path="player2Score">Player 2 Score</form:label></td>
                    <td><form:input path="player2Score" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Add Game"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>