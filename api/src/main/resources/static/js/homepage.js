$(document).ready(function(){

    loadReadme();

});

function loadReadme() {

    var converter = new showdown.Converter();
    var markmedown = $(".markmedown");

    $.ajax({
        type: "GET",
        url: '/static/readme.md',
        success: function (response) {
            markmedown.html(converter.makeHtml(response));
        },
        error: function () {
            markmedown.html("<p>Something went wrong</p>");
        }
    });
}

function changePage(newPage) {

    $(".menu-link").removeClass("selected");
    $(".page").hide();

    $("#" + newPage + "-link").addClass("selected");
    $("#"+ newPage).show();

}

