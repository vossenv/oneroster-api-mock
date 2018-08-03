$(document).ready(function(){

    var converter = new showdown.Converter();
    $.ajax({
        type: "GET",
        url: '/static/readme.md',
        success: function (response) {
            $(".markmedown").empty().append(converter.makeHtml(response));
        },
        error: function () {
            $(".markmedown").empty().append("<p>Something went wrong</p>");
        }
    });
});

