$(document).ready(function(){

    var converter = new showdown.Converter();
    $.ajax({
        type: "GET",
        url: '/static/readme.md',
        success: function (response) {
            var text = response;
            var html = converter.makeHtml(text);
            $(".markmedown").empty().append(html);
        },
        error: function () {
            var html = "<p>Something went wrong</p>";
            $(".markmedown").empty().append(html);
        }
    });
});