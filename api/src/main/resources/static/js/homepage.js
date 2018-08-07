$(document).ready(function(){

    loadReadme();


});


function renderInfo (data) {


    let infotable = "<table><tbody>";

    $.each( data, function( key, value ) {
        infotable += "<tr><td class='row-name'>" + key + "</td>"
                    + "<td class='value'>" + value + "</td></tr>"
    });

    infotable += "</tbody></table>";

    $("#infotable").html(infotable);

}

function changePage(newPage) {

    $(".menu-link").removeClass("selected");
    $(".page").hide();

    $("#" + newPage + "-link").addClass("selected");
    $("#"+ newPage).show();

}

function loadReadme() {

    const converter = new showdown.Converter();
    const markmedown = $(".markmedown");

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

function loadInfo() {
    changePage('info');
    $.ajax({
        type: "GET",
        url: '/info',
        success: function (response) {
            renderInfo(response);
        },
        error: function () {
            $("#info").html("<p>Something went wrong</p>");
        }
    });

}



