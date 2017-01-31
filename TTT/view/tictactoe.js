/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

 **************************************************/


var controllerMethod = {};

var cgiPath = "cgi-bin/ttt.cgi";

var showTag = 0;

function populate(methodName, input){
  controllerMethod.name = methodName;
  controllerMethod.input= input;
  var jsonObjStringToSend = JSON.stringify(controllerMethod);
  console.log("controllerMethod ", controllerMethod);
  console.log("controllerMethod string to send to server", jsonObjStringToSend);
  
  var xhttp = new XMLHttpRequest();

  
  /**Handle the returned JSON string; after xhttp.send() finishes**/
  /*
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      var retJsonObj = JSON.parse(this.responseText);
      
      if(methodName == "setSelection")
      document.getElementById("dealer").innerHTML = retJsonObj.dealership.name;
      var vList = document.getElementById("vehicleList");
      var returnedVehicles = retJsonObj.vehicles;
      for(var i=0; i<returnedVehicles.length; i++){
	var listItem = document.createElement("li"); // Create a <li> node
	var v = returnedVehicles[i];
	var carDescr = document.createTextNode(v.year+" "+v.color+" "+ v.make);  
	listItem.appendChild(carDescr); 
	vList.appendChild(listItem);
       
      }
    }
  };
  */
  xhttp.open("POST", cgiPath, true);  
  xhttp.send(jsonObjStringToSend);
}


function toggleDisplay(divId){
  var divElement = document.getElementById(divId);
  if(divElement.style.display == 'block')
    divElement.style.display = 'none';
  else
    divElement.style.display = 'block';
}

var player1 = {};
var player2 = {};

function createPlayer(divID) {
  if(divID == 1){  
    player1.name = document.getElementById("name").value;
    player1.marker = document.getElementById("marker").value;
    player1.playerNum = 1;
    if(player2.name != null)
    shownotice();
    populate("createPlayer",player1);
  }
  else{
    player2.name = document.getElementById("name2").value;
    player2.marker = document.getElementById("marker2").value;
    player2.playerNum = 2;
    if(player1.name != null)
    shownotice();
    populate("createPlayer",player2);
  }
}

function shownotice(){
  if(showTag == 0){
    if(playerNum == 1){
      var showStr = "It is " + player1.name + "'s turn to select!";
      document.getElementById("notice").innerHTML = showStr;
    }
    else if(playerNum == 2){
      showStr = "It is " + player2.name + "'s turn to select!";
      document.getElementById("notice").innerHTML = showStr;
    }
  }
  else if(showTag == 5){
    showStr = "This position has been selected! Please select again!";
    document.getElementById("notice").innerHTML = showStr; 
  }
}

var playerNum = 1;
var boardArray = [0,0,0,0,0,0,0,0,0];
var selection = {};
function setSelection(row, col, playerNum){
  if(boardArray[3*row + col] != 0){
    showTag = 5;
    shownotice();
  }
  else{
    boardArray[3*row + col] = playerNum;
    var pId = "pos" + (3*row + col +1);
    if(playerNum == 1)
      document.getElementById(pId).innerHTML =player1.marker;
    else if(playerNum == 2)
      document.getElementById(pId).innerHTML = player2.marker;
    
    if(playerNum == 1)
     window.playerNum = 2;
    else window.playerNum = 1;
    showTag = 0;
    shownotice();
    selection.row = row;
    selection.col = col;
    selection.playerNum = playerNum;
    populate("setSelection",selection);
  }
}

function startNewgame(){
  window.showTag = 0;
  window.playerNum = 1;
  boardArray = [0,0,0,0,0,0,0,0,0];
  for(i = 1; i < 10; i++){
    var pId = "pos" + i;
    document.getElementById(pId).innerHTML = null;
  }
  var showStr = "It is " + player1.name + "'s turn to select!";
  document.getElementById("notice").innerHTML = showStr;
  populate("startNewgame",{});
}





