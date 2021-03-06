<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it" xmlns="http://www.w3.org/1999/html">
<head>
    <style>
        .bg-1 {
            background-color: #1abc9c; /* Green */
            color: #ffffff;
        }
    </style>
    <jsp:include page="/WEB-INF/views/partials/head.jsp">
        <jsp:param name="title" value="Modifica profilo"/>
        <jsp:param name="style" value="bootstrap"/>
        <jsp:param name="script" value=""/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body style="background-color: #141414; color: white; font-family: AlumniSans-Italic">

<header>
    <%@include file="/WEB-INF/views/partials/headerCustomer.jsp"%>
</header>

<div class="container mt-3">
    <br>
    <h2>Modifica le informazioni</h2>
    <br>
    <form action="${pageContext.request.contextPath}/autoreProfile/modifica" method="post">
        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="AuNickname" name="AuNickname" placeholder="Nickname">
            <label for="AuNickname">Nickname</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="AuNome" name="AuNome" placeholder="Nome">
            <label for="AuNome">Nome</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="AuCognome" name="AuCognome" placeholder="Cognome">
            <label for="AuCognome">Cognome</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="number" id="AuAvatar" name="AuAvatar" placeholder="Avatar">
            <label for="AuAvatar">Avatar</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="AuEmail" name="AuEmail" placeholder="Email">
            <label for="AuEmail">Email</label>
        </div>

        <div class="form-floating mb-3 mt-3">
            <input style="background-color: #141414; color:white" class="form-control" type="text" id="AuPW" name="AuPW" placeholder="Password">
            <label for="AuPW">Password</label>
        </div>

        <button class="btn" style="background-color: turquoise">Modifica profilo</button>

    </form>
</div>

<footer>
    <%@include file="/WEB-INF/views/partials/footerCustomer.jsp"%>
</footer>
</body>
</html>
