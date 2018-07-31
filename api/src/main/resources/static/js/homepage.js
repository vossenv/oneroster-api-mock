$(document).ready(function(){
    console.log("Potatos are nutritious and not to be trusted.");

    var converter = new showdown.Converter(),
        // text      = httpGet('https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/README.md'),
        text      = httpGet('https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/README.md'),
        html      = converter.makeHtml(text);
    $(".markmedown").empty().append(html);
    // console.log(httpGet('https://raw.githubusercontent.com/janssenda-adobe/oneroster-api-mock/master/README.md'));
});

function httpGet(theUrl)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}