<%@ page import="org.apache.logging.log4j.Logger" %>
<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Logger LOGGER = LogManager.getLogger("index.jsp");
    LOGGER.info("index.jsp downloading");
%>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Quest DenVilmont</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-end">
        <div class="row">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="shadow p-4 mb-5 rounded">
                    <h2>Цитадель Мёртвых</h2>
                    <br>
                    <p>
                        Вы — Патологоанатом. У Вас даже есть имя — Джек, более того, фамилия — Радзинский.<br>
                        Хотя, последнее, не шибко понадобится.<br>
                        Вам предстоит пережить(или не пережить) начало типичного зомби-апокалипсиса.<br>
                        Пред Вами глава интерактивной книги, с четырьмя вариациями прочтения, где главному действующему лицу, удастся выжить.<br>
                        И четырьмя десятками смертей оного.<br>
                        Смерть, тоже конец. Но, на сколько длинной или короткой, будет эта глава, каждый волен решает сам.
                    </p>
                </div>
                <form action="enter" method="post">
                    <div class="form-group">
                        <label for="inputLogin">Login</label>
                        <input type="text" name="Login" class="form-control" id="inputLogin" placeholder="Enter login">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-success">Начинаем</button>
                </form>
                <br>
            </div>

            <div class="col-3">
                <div class="shadow p-4 mb-5 rounded">
                    <p>Information</p>
                    <form action="renovar" method="get">
                        <br>
                        <button type="submit" class="btn btn-success">Начать заново</button>
                        <br>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
