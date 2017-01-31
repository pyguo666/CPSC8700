/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include "controller/TTTController.h"
#include <iostream>
#include <sstream>

using namespace std;

int main(){
  cout << "content-type: text/html\n\n";

  stringstream post;
  post << std::cin.rdbuf();
  string incomingJsonObjectString = post.str();

  TTTController controller;
  vector<string> jsonVector = controller.readJsonString(incomingJsonObjectString);

  string method = jsonVector[1];
  if(method == "createPlayer"){
    string name = jsonVector[4];
    string marker = jsonVector[6];
    int currentPlayer = stoi(jsonVector[8]);
    controller.createPlayer(name, marker, currentPlayer);
  }
  if (method == "setSelection"){
    string gameObject;
    for (int i = 3; i < jsonVector.size(); i++)
      {
        gameObject = gameObject + jsonVector[i]+",";
      }
    bool setResult = controller.setSelection(gameObject);
    cout << setResult;
  }
  else if (method == "determineWinner") {
    cout << controller.determineWinner();
  }
  else if (method == "startNewGame") {
    controller.startNewGame();
  }
  else if (method=="getAllPlayers") {
    string players = controller.getAllSavedPlayers();
    cout << players;
  }

}
