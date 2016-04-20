
$(function() {
    $("#tag").autocomplete({
        source: function(request, response) {
            $.ajax({
                url: "/blagger/tag/list",
                data: {
                    stem: request.term
                },
                success: function(data) {
                    response(data);
                }
            });
        },
        minLength: 3,
    });
});
