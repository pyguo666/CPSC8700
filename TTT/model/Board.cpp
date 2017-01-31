/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include "Board.h"

void Board::setBoard(int row, int col, int value){
  board[row][col] = value;
}
int Board::getBoard(int row, int col){
  return board[row][col];
}

int Board::checkBoard(){
  // check if there is a winner, there are 8 kinds.
  if ( (board[0][0] == board[0][1]) && (board[0][1] == board[0][2]) )
    if (board[0][0])
      return board[0][0];
  if ( (board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) )
    if (board[0][0])
      return board[0][0];
  if ( (board[0][0] == board[1][0]) && (board[1][0] == board[2][0]) )
    if (board[0][0])
      return board[0][0];
  if ( (board[0][1] == board[1][1]) && (board[1][1] == board[2][1]) )
    if (board[0][1])
      return board[0][1];
  if ( (board[0][2] == board[1][2]) && (board[1][2] == board[2][2]) )
    if (board[0][2])
      return board[0][2];
  if ( (board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) )
    if (board[0][2])
      return board[0][2];
  if ( (board[1][0] == board[1][1]) && (board[1][1] == board[1][2]) )
    if (board[1][0])
      return board[1][0];
  if ( (board[2][0] == board[2][1]) && (board[2][1] == board[2][2]) )
    if (board[2][0])
      return board[2][0];

  for(int i = 0; i <3; i++){
    for(int j = 0; j < 3; j++){
      if(board[i][j] == 0) return 0;
    }
  }

  // board is filled, so the result is tie
  return 3;
}
