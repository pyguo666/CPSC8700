/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe MVC

**************************************************/

#include "TTTModel.h"

void TTTModel::setBoard(int row, int col, int value){
  board[row][col] = value;
}
int TTTModel::getBoard(int row, int col){
  return board[row][col];
}

void TTTModel::setPlayer1(int row, int col, int value){
  player1[row][col] = value;
}
int TTTModel::getPlayer1(int row, int col){
  return player1[row][col];
}

void TTTModel::setPlayer2(int row, int col, int value){
  player2[row][col] = value;
}
int TTTModel::getPlayer2(int row, int col){
  return player2[row][col];
}

void TTTModel::setNamePlayer1(string name){
  namePlayer1 = name;
}
string TTTModel::getNamePlayer1(){
  return namePlayer1;
}

void TTTModel::setNamePlayer2(string name){
  namePlayer2 = name;
}
string TTTModel::getNamePlayer2(){
  return namePlayer2;
}

void TTTModel::setMarkerPlayer1(string marker){
  markerPlayer1 = marker;
}
string TTTModel::getMarkerPlayer1(){
  return markerPlayer1;
}
void TTTModel::setMarkerPlayer2(string marker){
  markerPlayer2 = marker;
}
string TTTModel::getMarkerPlayer2(){
  return markerPlayer2;
}

int TTTModel::checkBoard(){
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
