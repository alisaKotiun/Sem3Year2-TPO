function callback(response){
    $("#date").html(response.date);
}

function ajax(){
    $.post(
        "/date",
        null,
        callback,
        "json"
    );
}

setInterval(ajax, 1000);