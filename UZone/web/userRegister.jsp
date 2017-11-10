<%@ taglib prefix="s" uri="/struts-tags" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Usuario</title>
</head>
<body>
<h3>Te tomara solo un par de minutos registrarte</h3>
<div>Haznos llegar todos aquellos vídeos que crees que pueden ser interesantes para publicar. </div>
<s:form action="dataUser">

    <s:textfield id="email" name="email" placeholder="Correo Electronico"/> <!-- texfield para el correo , no hay labels -->
    <s:textfield id="Name" name="Name" placeholder="Nombres" />
    <s:textfield id="LastName" name="Lastname" placeholder="Apellidos" />
    <s:textfield id="Username" name="Username" placeholder="Nombre de Usuario" />
    <s:textfield id="Password" name="Password" placeholder="Contraseña" type="password"/>
    <s:label for="Birthdate" value="Fecha de Nacimiento"/>
    <s:date name="Birthdate"/>
    <s:label for="Gnre" value="Genero"/>
    <s:combobox list="Masculino,Femenino"/>
    <s:label for="UserType" value="¿Eres artista o Worker?"/>
    <s:combobox list="Artista,Worker"/>
    <s:submit value="Registrarse"/>
</s:form>
</body>
</html>