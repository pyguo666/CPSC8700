/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe MVC

**************************************************/

#include <iostream>
#include <string>

using namespace std;

class TTTModel{
 private:
  int board[3][3];
  int player1[3][3];
  int player2[3][3];

  string namePlayer1;
  string namePlayer2;
  string markerPlayer1;
  string markerPlayer2;


 public:
  void setBoard(int row, int col, int value);
  int getBoard(int row, int col);
  void setPlayer1(int row, int col, int value);
  int getPlayer1(int row, int col);
  void setPlayer2(int row, int col, int value);
  int getPlayer2(int row, int col);

  void setNamePlayer1(string name);
  string getNamePlayer1();
  void setNamePlayer2(string name);
  string getNamePlayer2();

  void setMarkerPlayer1(string marker);
  string getMarkerPlayer1();
  void setMarkerPlayer2(string marker);
  string getMarkerPlayer2();

  int checkBoard();

};
