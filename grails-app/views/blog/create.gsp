
<html>

<g:javascript>
    $('input[name=title]').focus();
</g:javascript>

<head></head>

<body>

    <g:form controller="blog" action="createPost" class="form-horizontal">

        <fieldset>
        <legend>Blag about something new!</legend>

            <div class="control-group">
                <label class="control-label" for="title">Title</label>
                <div class="controls">
                    <g:textField name="title" value="${post?.title}" placeholder="My first blag post..." class="input-block-level"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="title">Your email</label>
                <div class="controls">
                    <g:textField name="email" value="${post?.email}" placeholder="test@test.com" class="input-block-level"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="content">The blag</label>
                <div class="controls">
                    <g:textArea name="content" value="${post?.content}" placeholder="The blag..." class="input-block-level" rows="10"/>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn">Submit</button>
                </div>
            </div>

        </fieldset>

    </g:form>

</body>

</html>