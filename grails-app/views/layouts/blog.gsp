<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:layoutTitle default="Blagger" /></title>
    <g:layoutHead />

    <asset:stylesheet src="main.css"/>
    <asset:javascript src="main.js"/>

</head>
<body>

<header class="jumbotron subhead" id="overview">
    <div class="container">
        <g:link controller="blog" action="list"><h1>Blagger</h1></g:link>
        <p class="lead">Blogging for blaggers; it's what people think you know that matters</p>

        <g:link controller="blog" action="create" class="btn btn-large btn-primary">Blag something...</g:link>
    </div>
</header>

<div class="container">

    <g:layoutBody />

</div>

</body>
</html>