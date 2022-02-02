function call(response){
    $("#result").text(response.result);
}

function get(){
    $.get(
        "add",
        {
            integer1 : $("#integer1").val(),
            integer2 : $("#integer2").val(),
        },
        call,
        "json");
}

function post(){
    $.post(
        "add",
        {
            integer1 : $("#integer1").val(),
            integer2 : $("#integer2").val(),
        },
        call,
        "json");
}

$("#integer1").focusout(post);
$("#integer2").focusout(get);

