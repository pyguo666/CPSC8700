/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe GUI

**************************************************/

#include "Player.h"

void Player::setPlayer(int row, int col, int value){
  playerBoard[row][col] = value;
}
int Player::getPlayer(int row, int col){
  return playerBoard[row][col];
}

void Player::setNamePlayer(string name){
  namePlayer = name;
}
string Player::getNamePlayer(){
  return namePlayer;
}

void Player::setMarkerPlayer(string marker){
  markerPlayer = marker;
}
string Player::getMarkerPlayer(){
  return markerPlayer;
}

void Player::setPlayerNum(int num){
  playerNum = num;
}
int Player::getPlayerNum(){
  return playerNum;
}
