<%@ page import="Model.Amministratore.Amministratore" %>
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
        <jsp:param name="title" value="inserisciAutore"/>
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
<%
    Amministratore amministratore = (Amministratore) request.getAttribute("amministratore");
%>

<header>
    <%@include file="/WEB-INF/views/admin/headerAdmin.jsp"%>
</header>

<section class="field">
    <form action="${pageContext.request.contextPath}/adminProfile/modifica" method="post">
        <label for="AmNickname">
            <input type="text" name="AmNickname" id="AmNickname" placeholder="Nickname">
        </label>
        <label for="AmNome">
            <input type="text" name="AmNome" id="AmNome" placeholder="Nome">
        </label>
        <label for="AmCognome">
            <input type="text" name="AmCognome" id="AmCognome" placeholder="Cognome">
        </label>
        <label for="AmAvatar">
            <input type="number" name="AmAvatar" id="AmAvatar" placeholder="Avatar">
        </label>
        <label for="AmEmail">
            <input type="text" name="AmEmail" id="AmEmail" placeholder="Email">
        </label>
        <label for="AmPW">
            <input type="text" name="AmPW" id="AmPW" placeholder="Password">
        </label>
        <label for="VideogiochiInseriti">
            <input type="number" name="VideogiochiInseriti" id="VideogiochiInseriti" placeholder="Videogiochi Inseriti">
        </label>
        <button class="premi">Modifica</button>
    </form>
</section>


<footer>
    <%@include file="/WEB-INF/views/admin/footerAdmin.jsp"%>
</footer>
</body>
</html>