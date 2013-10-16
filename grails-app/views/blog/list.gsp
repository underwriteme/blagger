<html>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
<script src="${resource(plugin: 'jquery')}"></script>

<head>
    <r:script>
    function addToTagList(newTag,postId) {
        $.post('${createLink(action: 'addTag')}', {id: postId, tag:newTag },
                function (data) {
                    var tagsDiv = ('#tagsDiv-'+postId) ;
                    $(tagsDiv).fadeOut(200);
                    var html = '<a href="${createLink(action: 'listPaged')}/?tag=' + data.tag.name + '">' + data.tag.name + '</a>';
                    $(tagsDiv).html(html).fadeIn(200);
                });
    }

    $(document).ready(function () {

        $('.txttag').each(function() {
        var $this = $(this);
        $this.typeahead({
            minLength:3,
            source: function (query, process) {
                return $.get('${createLink(action: 'findTag')}', { term: query }, function (data) {
                    return process(data.options);
                });
            },
            limit: 10,
            updater: function (item) {
                var postId = $this.attr('data-ajax')
                addToTagList(item, postId);
                return item;
            }
         });
        });

        $("#btnAddTag").click(function () {
            $.post('${createLink(action: 'createTag')}', {txtTag:$('#txtTag').val()}, function (data) { });
        });

        $("#frmCreateTag").submit(function ( event) {
            $.post('${createLink(action: 'createTag')}', {txtTag:$('#txtTag').val()},  function (data) { });
             event.preventDefault();
        });

    });
    </r:script>

</head>

<body>
<blagger:paginate total="${postCount}" controller="blog" action="listPaged"/>
<form id="frmCreateTag">
    <input id="btnAddTag" type="button" value="Create Tag"/><br>
    <input id="txtTag" type="text" class="input-large"/>
</form>

<div id="divPosts" class="row span9">
    <g:each in="${posts}" var="post">
        <div id="tagsDiv-${post.id}">Tag: <a
                href="${createLink(action: 'listPaged')}/?tag=${post.tag?.name ?: 'none'}">${post.tag?.name ?: 'none'}</a>
            <input id="txtTag${post.id}" type="text" class="input-large txttag" data-ajax="${post.id}"/>
        </div>

        <h1>${post.title}</h1>

        <p class="lead">By <span class="text-info">${post.email}</span> on <g:formatDate format="dd/MM/yyyy @ HH:mm"
                                                                                         date="${post.dateCreated}"/>
        </p>

        ${post.content}

        <hr/>

    </g:each>

</div></body>
</html>
