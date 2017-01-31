/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include <iostream>
#include <string>

using namespace std;

class Board{
 private:
  int board[3][3];

 public:
  void setBoard(int row, int col, int value);
  int getBoard(int row, int col);

  int checkBoard();
};
