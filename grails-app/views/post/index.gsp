
<html>

<head></head>

<body>

<g:each in="${posts}" var="post">

    <h1>${post.title}</h1>
    <p class="lead">By <span class="text-info">${post.email}</span> on <g:formatDate format="dd/MM/yyyy @ HH:mm" date="${post.dateCreated}"/></p>

    ${post.content}

    <hr/>

</g:each>

</body>

</html>