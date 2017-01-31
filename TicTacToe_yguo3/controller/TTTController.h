/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe MVC

**************************************************/

#include <iostream>
#include <string>
#include "../model/TTTModel.h"

using namespace std;

class TTTController{
 private:
  TTTModel model;

 public:
  void createPlayer(string name, string marker, int playerNum);
  void startNewGame();
  bool setSelection(int row, int col, int currentPlayer);
  // row and col:between 0-2; currentPlayer: 1 for player1, 2for player2;
  int determineWinner();
  // 0 for no winner, 1 for player1 wins, 2 for player2 wins, 3 for tie;
  string getGameDisplay();
  //printable display of current selections and show each palyer's marker;
};
