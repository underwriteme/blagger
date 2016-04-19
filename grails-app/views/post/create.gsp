
<html>

<r:script>

    $('input[name=title]').focus();

</r:script>

<head></head>

<body>

    <g:form controller="post" action="savePost" class="form-horizontal">

        <fieldset>
        <legend>Blag about something new!</legend>

            <div class="form-group ${hasErrors(bean:post, field:'title', 'has-error')}">
                <label class="col-sm-2 control-label" for="title">Title</label>
                <div class="col-sm-10">
                    <g:textField name="title" value="${post?.title}" placeholder="My first blag post..." class="form-control"/>

                    <g:eachError bean="${post}" field="title">
                        <span class="help-block"><g:message error="${it}"/></span>
                    </g:eachError>
                </div>
            </div>
            <div class="form-group ${hasErrors(bean:post, field:'email', 'has-error')}">
                <label class="col-sm-2 control-label" for="title">Your email</label>
                <div class="col-sm-10">
                    <g:textField name="email" value="${post?.email}" placeholder="test@test.com" class="form-control"/>

                    <g:eachError bean="${post}" field="email">
                        <span class="help-block"><g:message error="${it}"/></span>
                    </g:eachError>
                </div>
            </div>
            <div class="form-group ${hasErrors(bean:post, field:'content', 'has-error')}">
                <label class="col-sm-2 control-label" for="content">The blag</label>
                <div class="col-sm-10">
                    <g:textArea name="content" value="${post?.content}" placeholder="The blag..." class="form-control" rows="10"/>

                    <g:eachError bean="${post}" field="content">
                        <span class="help-block"><g:message error="${it}"/></span>
                    </g:eachError>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>

        </fieldset>

    </g:form>

</body>

</html>