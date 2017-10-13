
<html>

<r:script>
    $('input[name=title]').focus();
</r:script>

<head>

<asset:javascript src="jquery-ui.min.js" />

</head>

<body>

	<g:form controller="post" action="savePost" class="form-horizontal">

		<fieldset>
			<legend>Blag about something new!</legend>

			<div
				class="form-group ${hasErrors(bean:post, field:'title', 'has-error')}">
				<label class="col-sm-2 control-label" for="title">Title</label>
				<div class="col-sm-10">
					<g:textField name="title" value="${post?.title}"
						placeholder="My first blag post..." class="form-control" />

					<g:eachError bean="${post}" field="title">
						<span class="help-block"><g:message error="${it}" /></span>
					</g:eachError>
				</div>
			</div>
			<div
				class="form-group ${hasErrors(bean:post, field:'email', 'has-error')}">
				<label class="col-sm-2 control-label" for="title">Your email</label>
				<div class="col-sm-10">
					<g:textField name="email" value="${post?.email}"
						placeholder="test@test.com" class="form-control" />

					<g:eachError bean="${post}" field="email">
						<span class="help-block"><g:message error="${it}" /></span>
					</g:eachError>
				</div>
			</div>
			<div
				class="form-group ${hasErrors(bean:post, field:'content', 'has-error')}">
				<label class="col-sm-2 control-label" for="content">The blag</label>
				<div class="col-sm-10">
					<g:textArea name="content" value="${post?.content}"
						placeholder="The blag..." class="form-control" rows="10" />

					<g:eachError bean="${post}" field="content">
						<span class="help-block"><g:message error="${it}" /></span>
					</g:eachError>
				</div>
			</div>


			<div class="form-group">
				<label class="col-sm-2 control-label" for="content">Tag</label>
				<div class="col-sm-10">
					<g:textField name="tag" id="tag" class="form-control"
						autocomplete="off" onKeyPress="doLoadTags(this.value)" />
					<g:render template="searchResults" />
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="save" type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>


		</fieldset>

	</g:form>

<script type='text/javascript'>

    
function doLoadTags(requestParams) {

        var edValue = document.getElementById("tag");
        var stagVal = edValue.value;

		if (stagVal.length >=3){

		<g:remoteFunction controller="post" action="search" params="{tag:stagVal}" update="searchresults"/>	
		
		}
		  
    }
    
    
function fnSelectTag(evt, id, click) {

	var fname = document.getElementById(id).innerHTML.trim();
	
	document.getElementById("typeAheadList").style.display='none';	
	document.getElementById("tag").value = fname;
	
	$('html,body').animate({scrollTop: $('#tag').offset().top},'slow');

}

	$Tag = $("#tag" );
	$Tag.keydown(function(e) {
	
		var key = e.keyCode;	
		if ( key == 40 ) // Down key 
	    {
		$("ul > li:first").focus().select().addClass("highlight");      
	    }
	    else if ( key == 38 ) // Up key
	    {
	        $("ul > li:last").focus().select().addClass("highlight");
	    }
	              	    
	});
	
	$('div.container').on('focus', 'li', function() {
	    var $this = $(this);
	    $this.addClass('active').siblings().removeClass();
	    $this.closest('div.container').scrollTop($this.index() * $this.outerHeight());
	}).on('keydown', 'li', function(e) {
	    var $this = $(this);
	    if (e.keyCode === 40) {        
	        $this.next().focus();
	        return false;
	    } else if (e.keyCode === 38) {        
	        $this.prev().focus();
	        return false;
	    } else if (e.keyCode === 13) {        
			var litag = window.event.target.id;
			var atag = litag.replace("litag", "atag");
			fnSelectTag(e, atag, true);			
	    }	    
	    
	}).find('li').first().focus();

</script>

</body>

</html>