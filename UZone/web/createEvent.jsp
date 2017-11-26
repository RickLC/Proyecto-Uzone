
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="Add-ons/vendor/bootstrap/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="Add-ons/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
<link href="Add-ons/css/creative.min.css" rel="stylesheet">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear evento</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <s:a class="navbar-brand" href="home">UZone</s:a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

                <li><a href="main.jsp">Inicio</a></li>
                <li><s:a href="contribution">Mis Aportaciones</s:a></li>
            </ul>
            <form class="navbar-form navbar-left">


            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><s:a href="self">${sessionScope.username}</s:a></li>
                <li><s:a href="logout">Cerrar sesión</s:a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="main.jsp">Últimos</a></li>
        <li role="presentation"><a href="main.jsp">Màs Videos</a></li>
        <s:if test="#session.userType==1"><li role="presentation"><a href="createPost.jsp">Enviar Video</a></li></s:if>
        <li role="presentation"><a href="#">Más Votados</a></li>
        <s:if test="#session.userType==2"><li role="presentation"><a href="createEvent.jsp">Crea un evento</a></li></s:if>
        <li role="presentation"><a href="listEvent.jsp">Eventos disponibles</a></li>
        <s:form class="navbar-form navbar-left" action="searchVideo">
            <div class="form-group">
                <s:textfield name="model.title"  class="form-control" placeholder="Buscar"/>
            </div>
            <s:submit type="submit" class="btn btn-default" value="Buscar"/>
        </s:form>
    </ul>
</div>
<h2>Publica un Evento</h2>
<h3>Publica un evento para poder capturar la atencion de los mejores artistas</h3>
<s:form action="createEvent" theme="bootstrap">
        <div class="form-group">
    <s:textfield id="title" name="model.title" placeholder="Ingresa un titulo" requerid="true" />
        </div>
        <div class="form-group">
    <s:textfield id="ubication" name="model.ubication" placeholder="¿Donde se realizara tu evento?" requerid="true" />
        </div>
        <div class="form-group">
    <s:textfield id="evntime" name="model.date" placeholder="Fecha incio" requerid="true" />
        </div>
        <div class="form-group">
    <s:textfield id="evntimelimit" name="model.dateLimit" placeholder="Fecha fin" requerid="true" />
        </div>
        <div class="form-group">
    <s:textarea id="description" name="model.description" placeholder="Describe lo que tendra tu publicacion" requerid="true" rows="3"/>
        </div>
        <div class="form-group">
    <s:textfield id="tags" name="model.tags" placeholder="Etiquetas" requerid="true"/>
        </div>
        <div class="form-group">
    <s:textfield id="websites" name="model.websites" placeholder="Ingresa algun sitio web asociado a tu evento" requerid="true"/>
        </div>
        <div class="form-group">
    <s:textfield id="salary" name="model.salary" placeholder="Ingrese una remuneracion para tu artista" />
        </div>

    <s:submit value="Publicar" cssClass="btn btn-default"/>
</s:form>
</body>
</html>