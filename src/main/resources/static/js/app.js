var xmlHttp = new XMLHttpRequest();
xmlHttp.open( "POST", '/post', false ); // false for synchronous request

var json = JSON.stringify({
  name: "Виктор",
  surname: "Цой"
});

xmlHttp.send( json );
alert(xmlHttp.responseText);