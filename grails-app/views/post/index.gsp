
<html>

<head>

<style type="text/css" media="screen">

 hr {
	color: #123455 !important;
	background-color: #123455 !important;
	display: block !important;
	height: 0px !important;
	border: 0 !important;
	border-top: 1px solid #ccc !important;
	margin:  10 !important;
	padding: 0 !important;
}

pre {
	white-space: pre-wrap !important;      /* CSS3 browsers  */
	white-space: -moz-pre-wrap !important; /* 1999+ Mozilla  */
	white-space: -pre-wrap !important;     /* Opera 4 thru 6 */
	white-space: -o-pre-wrap !important;   /* Opera 7 and up */
	word-wrap: normal !important;      /* IE 5.5+ and up */
	word-break: normal !important;
	/* overflow-x: auto; */                /* Firefox 2 only */
	width: 99% !important;     			   /* only if needed */
	display: inline-block !important;
	margin: 0 !important;
	font-family: helvetica !important;
	font-size: 16px !important;
	border:none !important;
	margin:0 !important;
	padding:0 !important;
	line-height:normal !important;
	background-color: #FFFFFF !important;	/* #f5f5f5  #EBF4FA; */
	}

::-webkit-scrollbar {
	width: 12px;
}

::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

::-webkit-scrollbar-thumb {
	background-color: #1A5276;
	outline: 1px solid slategrey;
}  

 

</style>

</head>

<body>

<g:each in="${posts}" var="post">
    
    <strong><font color='#5D6D7E' face='Helvetica' size='4'> ${post.title} </font></strong>
    
    <p class="lead">By 
    <span class="text-info">
    ${post.email}</span> on <g:formatDate format="dd/MM/yyyy @ HH:mm" date="${post.dateCreated}"/>
    
    <font size="2" style="float:right; text-align:right; background-color: #A9CCE3">
    <g:link controller="post" action="indexByTag" params="${[tag: post.tag]}">${post.tag}</g:link> 
    </font>
    
    
    </p>

     <font size="3" face="Helvetica"><pre>${post.content}</pre></font>

    <hr/>

</g:each>

<g:paginate total="${total}" max="5"/>

</body>

</html>