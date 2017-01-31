/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include <iostream>
#include <string>

using namespace std;

class Player{
 private:
  int playerBoard[3][3];
  string namePlayer;
  string markerPlayer;
  int playerNum;

 public:
  void setPlayer(int row, int col, int value);
  int getPlayer(int row, int col);
  void setNamePlayer(string name);
  string getNamePlayer();
  void setMarkerPlayer(string marker);
  string getMarkerPlayer();
  void setPlayerNum(int num);
  int getPlayerNum();
};
