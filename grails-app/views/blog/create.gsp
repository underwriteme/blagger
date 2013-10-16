<html>

<r:script>

    $('input[name=title]').focus();

</r:script>

<head></head>

<body>

<g:form controller="blog" action="createPost" class="form-horizontal">
    <fieldset>
        <legend>Blag about something new!</legend>

        <div class="control-group">
            <label class="control-label" for="title">Title</label>
            <g:hasErrors bean="${post}" field="title">
                <div class="alert-danger">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<g:fieldError field="title" bean="${post}"
                                                                      message="post.title.blank"/><br><br>
                </div>
            </g:hasErrors>
            <div class="controls">
                <g:textField name="title" value="${post?.title}" placeholder="My first blag post..."
                             class="input-block-level"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="title">Your email</label>

            <div class="controls">
                <g:hasErrors bean="${post}" field="email">
                    <div class="alert-danger">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<g:fieldError field="email" bean="${post}"
                                                                          message="post.email.blank"/><br><br>
                    </div>
                </g:hasErrors>
            </div>

            <div class="controls">
                <g:textField name="email" value="${post?.email}" placeholder="test@test.com" class="input-block-level"/>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="content">The blag</label>

            <div class="controls">
                <g:hasErrors bean="${post}" field="content">
                    <div class="alert-danger">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<g:fieldError field="content" bean="${post}"
                                                                          message="post.content.blank"/><br><br>
                    </div>
                </g:hasErrors>
                <g:textArea name="content" value="${post?.content}" placeholder="The blag..." class="input-block-level"
                            rows="10"/>
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
