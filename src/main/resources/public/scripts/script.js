function searchListSongsArtist() {
    var artist = document.getElementById("artist").value;
    $.ajax({
        url:"http://localhost:8080/artist/" + artist,
        type:"GET",
        dataType:"json"
    }).done(function (data) {
        $("#content").html(
          "<span style='color: blue;font-size: 17px'>Песни артиста: " + "</span>" + data.artistName
            + "<pre id='listSong'></pre>");
        $.each(data.songs, function (idx, column) {
            var song = column.songName;
            $("#listSong").append("<a id='" + column.id + "' href='javascript:void(0)' onclick='getSongArtist()'>" + song + "</a>" + "</br>");
        })
    });
}

function getSongArtist() {
    $("#listSong").on('click', function (event) {
        $.ajax({
            url:"http://localhost:8080/song/" + event.target.id,
            type:"GET",
            dataType:"json"
        }).done(function (data) {
            $("#content").html("<p><span style='color: blue;font-size: 17px'>Название песни: </span>" + data.songName + "</p>"
                +"<p><span style='color: blue;font-size: 17px'>Текст песни:</span>" + "</p>"
                + data.text.replace(/\n/gi,"</br>") +"</br></br>");
        });
    });
}

function searchSong() {
    var song = document.getElementById("song").value;
    $.ajax({
        url:"http://localhost:8080/songName/" + song,
        type:"GET",
        dataType:"json"
    }).done(function (data) {
            $("#content").html("<p><span style='color: blue;font-size: 17px'>Название песни: </span>"+data.songName+"</p>"
                +"<p><span style='color: blue;font-size: 17px'>Текст песни:</span>"+"</p>"
                + data.text.replace(/\n/gi,"</br>") +"</br></br>");
        });
}

$( function() {
    $("#artist").keyup(function (event) {
        var arrayArtist = [];
        $.ajax({
            url: "http://localhost:8080/artistLike/" + event.target.value,
            type: "GET",
            async: false,
            setTimeout: 5000,
            dataType: "json",
            success: artistSearchPart
        });
        function artistSearchPart(data) {
            $.each(data, function (idx, column) {
                arrayArtist.push(column.artistName);
            });
            $("#artist").autocomplete({
                minLength:3,
                source: function(request, response) {
                    var results = $.ui.autocomplete.filter(arrayArtist, request.term);
                    response(results.slice(0, 20));
                }
            });
        }
    });
});

$( function() {
    $("#song").keyup(function (event) {
        var arraySong  = [];
        $.ajax({
            url: "http://localhost:8080/songLike/" + event.target.value,
            type: "GET",
            async: false,
            setTimeout: 5000,
            dataType: "json",
            success: songSearchPart
        });
        function songSearchPart(data) {
            $.each(data, function (idx, column) {
                arraySong.push(column.songName);
            });
            $("#song").autocomplete({
                minLength:3,
                source: function(request, response) {
                    var results = $.ui.autocomplete.filter(arraySong, request.term);
                    response(results.slice(0, 20));
                }
            });
        }
    });
});