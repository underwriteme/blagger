
<html>

<g:javascript>
    $('input[name=title]').focus();
</g:javascript>

<head></head>

<body>

<g:form controller="blog" action="createPost" class="form-horizontal">

    <fieldset>
        <legend>Blag about something new!</legend>

        <div class="row form-group">
            <div class="col-md-12">
                <label for="title">Title</label>
                <g:textField id="title" name="title" value="${post?.title}" placeholder="My first blag post..." class="form-control"/>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-12">
                <label for="email">Your email</label>
                <g:textField id="email" name="email" value="${post?.email}" placeholder="test@test.com" class="form-control"/>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-12">
                <label for="content">The blag</label>
                <g:textArea id="content" name="content" value="${post?.content}" placeholder="The blag..." class="form-control" rows="10"/>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-12">
                <button type="submit" class="btn">Submit</button>
            </div>
        </div>


    </fieldset>

</g:form>

</body>

</html>