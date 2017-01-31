/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <cstring>
#include <map>
#include "../model/Board.h"
#include "../model/Player.h"

using namespace std;

class TTTController{
 private:
  Board board;
  Player player1;
  Player player2;

 public:
  vector<string> readJsonString(string json);
  void createPlayer(string name, string marker, int playerNum);
  void createPlayer(string playerJsonObject);
  string getAllSavedPlayers();
  void startNewGame();
  int determineWinner();
  bool setSelection(int row, int col, int currentPlayer);
  bool setSelection(string gameJsonObject);
  string getGameDisplay(bool isJson);
  string getGameDisplay();
};
