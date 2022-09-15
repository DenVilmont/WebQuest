<%@ page import="dev.webQuest.SQLiteHandler" %>
<%@ page import="dev.webQuest.Question" %>
<%@ page import="dev.webQuest.Answer" %>
<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page import="org.apache.logging.log4j.Logger" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Logger LOGGER = LogManager.getLogger("quest.jsp");
    LOGGER.info("quest.jsp downloading");
    SQLiteHandler sqLiteHandler = SQLiteHandler.getInstance();
    Question question;
    if (session.getAttribute("currentQuestion") == null){
        question = sqLiteHandler.getQuestion("38fa675e-3532-4433-84d8-9119a41d914d");
    }else {
        question = sqLiteHandler.getQuestion(String.valueOf(session.getAttribute("currentQuestion")));
    }




%>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-end">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="shadow p-4 mb-5 rounded">
                    <h2></h2><br>
                    <p>
                        <%=question.text%>
                    </p>
                </div>
                <%
                    if (!question.isFinish) {
                        for (Answer answer : question.answers) {
//                            out.println("<div class=\"shadow p-3 mb-3 rounded\">");
                            out.println("<form action=\"questEngine\" method=\"post\">");
//                            out.println(" <div class=\"form-group\">");
                            out.println("<input type=\"text\" name=\"answerID\" class=\"form-control invisible\" value=\"" + answer.id + "\">");
//                            out.println("</div>");
                            out.println("<button type=\"submit\" class=\"btn btn-success btn-lg btn-block shadow\">" + answer.text + "</button>");
                            out.println("</form>");
//                            out.println("</div>");
                        }
                    }else {
                        out.println("<div class=\"shadow p-3 mb-3 rounded\">");
                        out.println("<p>");
                        out.println("Игра окончена! ");
                        out.println("</p>");
                        out.println("</div>");
                    }
                %>

<%--                <form action="enter">--%>
<%--                    <div class="form-group">--%>
<%--                        <input type="text" name="answerID" class="form-control invisible" value="Mark">--%>

<%--                    </div>--%>
<%--                    <br>--%>
<%--                    <button type="submit" class="btn btn-success btn-block">Начинаем</button>--%>

<%--                </form>--%>
            </div>

            <div class="col-3">
                <div class="shadow p-4 mb-5 rounded">
                    <p>Information</p>
                    <form action="renovar" method="get">
                        <br>
                        <button type="submit" class="btn btn-success btn-lg btn-block">Начать заново</button>
                        <br>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
