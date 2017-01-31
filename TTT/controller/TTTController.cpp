/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include "TTTController.h"


vector<string> TTTController::readJsonString(string json){
  /*
  vector<string> vectorRT;
  int i = 0;
  while(i < json.length()){
    if(json[i] == '{' || json[i] == '}' || json[i] == '\\' || json[i] == '"' || json[i] == ',' || json[i] == '[' || json[i] == ']' || json[i] == ':'){
      i++;
      break;
    }
    int j = 0;
    while(json[i+j] != '{' || json[i+j] != '}' || json[i+j] != '\\' || json[i+j] != '"' || json[i+j] != ',' || json[i+j] != '[' || json[i+j] != ']' || json[i+j] != ':'){
      j++;
    }
    string tmp = json.substr(i,j);
    vectorRT.push_back(tmp);
    i = i + j;
  }
  return vectorRT;
  */
           vector<string> jsonVector;
         char * cstr = new char[json.length() + 1];
         std::strcpy(cstr, json.c_str());
        char * pch;
        pch = strtok(cstr, "\":{,}");
        while (pch != NULL)
        {
                string temp(pch);
                jsonVector.push_back(temp);
                pch = strtok(NULL, "\":{,}");
        }
        return jsonVector;
}

void  TTTController::createPlayer(string name, string marker, int playerNum){
  if(playerNum == 1){
    player1.setNamePlayer(name);
    player1.setMarkerPlayer(marker);
  }
  else if(playerNum == 2){
    player2.setNamePlayer(name);
    player2.setMarkerPlayer(marker);
  }
}

void TTTController::startNewGame(){
  for(int i = 0; i <3 ; i++)
    {
      for(int j = 0; j < 3; j++){
        board.setBoard(i, j, 0);
        player1.setPlayer(i, j, 0);
        player2.setPlayer(i, j, 0);
      }
    }
}


void TTTController::createPlayer(string playerJsonObject){
  vector<string> jsonVector = readJsonString(playerJsonObject);
  string name = jsonVector[1];
  string marker = jsonVector[3];
  string::size_type sz; //alias
  int playerNum = stoi(jsonVector[5], &sz);
  createPlayer(name, marker, playerNum);
}

string TTTController::getAllSavedPlayers(){
  string players = "{\"players\":[{\"name\":\""+player1.getNamePlayer() + "\",\"marker\":"+"\""+player1.getMarkerPlayer() + "\"," + "\"playerNum\":"+"\""+to_string(player1.getPlayerNum()) + "\"}," + "{\"name\":"+"\""+player2.getNamePlayer() + "\","  + "\"marker\":"+"\""+player2.getMarkerPlayer() + "\"," + "\"playerNum\":"+"\""+to_string(player2.getPlayerNum()) + "\"}]}";
  return players;

}

bool TTTController::setSelection(string gameJsonObject){
  vector<string> jsonVector = readJsonString(gameJsonObject);
  string::size_type sz;
  int row = stoi(jsonVector[1], &sz);
  int col = stoi(jsonVector[3], &sz);
  int currentPlayer = stoi(jsonVector[5], &sz);
  return setSelection(row, col, currentPlayer);
}

string TTTController::getGameDisplay(bool isJson){
  if(!isJson){
    return getGameDisplay();
  }
  string str[3];
  str[0] = " ";
  str[1] = player1.getMarkerPlayer();
  str[2] = player2.getMarkerPlayer();
  string boardDisplay = "{\"gameBoard\":[";
  for(int i = 0; i<8; i++){
    boardDisplay = boardDisplay + "{\"row\":"+to_string(i/3)+",\"col\":"+to_string(i%3)+",\"marker\":\""+str[board.getBoard(i/3, i%3)]+"\"},";
  }
  boardDisplay = boardDisplay + "{\"row\":"+to_string(2)+",\"col\":"+to_string(2)+",\"marker\":\""+str[board.getBoard(2, 2)]+"\"}]}";
  return boardDisplay;
}


bool TTTController::setSelection(int row, int col, int currentPlayer){
  // check if this position is occupied.
  if(board.getBoard(row, col) == 1 || board.getBoard(row, col) == 2)
    return false;
  if(currentPlayer == 1){
    player1.setPlayer(row, col, 1);
    board.setBoard(row, col, 1);
  }
  else if(currentPlayer == 2){
    player2.setPlayer(row, col, 2);
    board.setBoard(row, col, 2);
  }
  // sync to the file
  ifstream iFile("../boardInfo.txt");
  if(iFile.fail()){
    iFile.close();
    int a[9] = {0};
    a[3*row + col] = currentPlayer;
    ofstream oFile("../boardInfo.txt");
    for(int i = 0; i<9; i++){
      oFile << a[i] << "  ";
    }
    oFile.close();
  }
  else{
    int a[9];
    for(int i = 0; i<9; i++){
      iFile >> a[i];
    }
    a[3*row + col] = currentPlayer;
    iFile.close();
    ofstream oFile("../boardInfo.txt");
    for(int i = 0; i<9; i++){
      oFile << a[i] << "  ";
    }
    oFile.close();
  }

  return true;

}

int TTTController::determineWinner(){
  ifstream iFile("../boardInfo.txt");
  if(iFile.fail()){
    iFile.close();
    return 0;
  }
  for(int i = 0; i<3; i++){
    for(int j = 0; j < 3; j++){
      int tmp;
      iFile >> tmp;
      board.setBoard(i,j,tmp);
    }
  }
  return board.checkBoard();
}

// mark for change.  string type
string TTTController::getGameDisplay(){
  string str_return;
  string str[3];
  str[0] = " ";
  str[1] = player1.getMarkerPlayer();
  str[2] = player2.getMarkerPlayer();
  /*    test
  cout << model.getBoard(1,1)<<endl;
  cout << model.getPlayer1(1,1)<<endl;
  cout << model.getPlayer2(1,1) <<endl;
  cout << model.getNamePlayer1() <<endl;
  str[1] = "X";
  str[2] = "O";
  */

  /*   first void return type edition
  cout << """****************" << endl;
  cout << "   0   1   2  " << endl;
  cout << "  -------------" << endl;
  cout << "0 | " << str[model.getBoard(0,0)] << " | " << str[model.getBoard(0,1)] << " | " << str[model.getBoard(0,2)]  << " |" << endl;
  cout << "  -------------" << endl;
  cout << "1 | " << str[model.getBoard(1,0)] << " | " << str[model.getBoard(1,1)]  << " | " << str[model.getBoard(1,2)] << " |" << endl;
  cout << "  -------------" << endl;
  cout << "2 | " << str[model.getBoard(2,0)] << " | " << str[model.getBoard(2,1)] << " | " << str[model.getBoard(2,2)] << " |" << endl;
  cout << "  -------------" << endl;
  cout << """****************" << endl;
  */

  str_return = "****************\n    0   1   2  \n  -------------\n0 | "+ str[board.getBoard(0,0)]+ " | "+ str[board.getBoard(0,1)]+ " | "+ str[board.getBoard(0,2)] + " |\n" +  "  -------------\n"
    "1 | " + str[board.getBoard(1,0)] + " | " + str[board.getBoard(1,1)] + " | " +  str[board.getBoard(1,2)] + " |\n" + "  -------------\n" +
    "2 | " + str[board.getBoard(2,0)] + " | " + str[board.getBoard(2,1)] + " | " + str[board.getBoard(2,2)] + " |\n" +  "  -------------\n" + "****************\n";

  return str_return;
}
