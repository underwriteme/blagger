
<html>

<head></head>

<body>

<g:each in="${posts}" var="post">

    <h1>${post.title}</h1>
    <p class="lead">By <span class="text-info">${post.email}</span> on <g:formatDate format="dd/MM/yyyy @ HH:mm" date="${post.dateCreated}"/></p>

    <p>Category: ${post.category}</p>
    ${post.content}

    <hr/>

</g:each>
<g:paginate controller="blog" action="list" max="5" total="${postCount}" />

</body>

</html>