<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

<style type="text/css" media="screen">

.typewriter h3 {
    font-size:150%;
    width:9.3em;
    white-space:nowrap;
    overflow:hidden;
    border-right: .1em solid black;
    
    -webkit-animation: typing 2s steps(2, end), /* # of steps = # of characters */
                        blink-caret 1s step-end infinite;
    -moz-animation: typing 2s steps(2, end), /* # of steps = # of characters */
                        blink-caret 1s step-end infinite;
}

/* The typing effect */
@keyframes typing {
  from { width: 0 }
  to { width: 100% }
}

/* The typewriter cursor effect */
@keyframes blink-caret {
  from, to { border-color: transparent }
  50% { border-color: orange }
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}
  
  
</style>


    <title><g:layoutTitle default="Blagger" /></title>
    <g:layoutHead />

    <r:require module="blog"/>

    <r:layoutResources/>
</head>
<body>

<header class="jumbotron subhead" id="overview">
    <div class="container">
        <g:link controller="post" action="index"><h1>Blagger</h1></g:link>
        <p class="lead">Blogging for blaggers; it's what people think you know that matters</p>

		<div class="typewriter">
		<h3> 
		<g:link controller="post" action="create" class="btn btn-lg btn-primary">Blag something...</g:link>
		</h3>
		</div>
        
    </div>
</header>

<div class="container">

    <g:layoutBody />

</div>

<r:layoutResources/>
</body>
</html>