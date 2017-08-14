var temp = 0;
var limit = 10;
function load(){
    var root = 'https://jsonplaceholder.typicode.com';

    $.ajax({
      url: root + '/photos/',
      method: 'GET'
    }).then(function(data) {
      console.log(data);
        var photo_container = $("<div>", {id:"photo_container"});
            for(var i = temp; i < limit; i++){
              $(photo_container).append("<img src ='" + data[i].thumbnailUrl + "'  alt = 'SORRY'>");
            }
        $("#recent-photos").append(photo_container);
        $(photo_container).hide().show("slow");
        //
        temp = temp + 10;
        limit = limit + 10;
    });
}