/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe MVC

**************************************************/

#include "TTTController.h"

void  TTTController::createPlayer(string name, string marker, int playerNum){
  if(playerNum == 1){
    model.setNamePlayer1(name);
    model.setMarkerPlayer1(marker);
  }
  else if(playerNum == 2){
    model.setNamePlayer2(name);
    model.setMarkerPlayer2(marker);
  }
}

void TTTController::startNewGame(){
  for(int i = 0; i <3 ; i++)
    {
      for(int j = 0; j < 3; j++){
        model.setBoard(i, j, 0);
        model.setPlayer1(i, j, 0);
        model.setPlayer2(i, j, 0);
      }
    }
}

bool TTTController::setSelection(int row, int col, int currentPlayer){
  // check if this position is occupied.
  if(model.getBoard(row, col) == 1 || model.getBoard(row, col) == 2)
    return false;
  if(currentPlayer == 1){
    model.setPlayer1(row, col, 1);
    model.setBoard(row, col, 1);
  }
  else if(currentPlayer == 2){
    model.setPlayer2(row, col, 2);
    model.setBoard(row, col, 2);
  }

  return true;

}

int TTTController::determineWinner(){
  return model.checkBoard();
}

// mark for change.  string type
string TTTController::getGameDisplay(){
  string str_return;
  string str[3];
  str[0] = " ";
  str[1] = model.getMarkerPlayer1();
  str[2] = model.getMarkerPlayer2();
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

  str_return = "****************\n    0   1   2  \n  -------------\n0 | "+ str[model.getBoard(0,0)]+ " | "+ str[model.getBoard(0,1)]+ " | "+ str[model.getBoard(0,2)] + " |\n" +  "  -------------\n"
    "1 | " + str[model.getBoard(1,0)] + " | " + str[model.getBoard(1,1)] + " | " +  str[model.getBoard(1,2)] + " |\n" + "  -------------\n" +
    "2 | " + str[model.getBoard(2,0)] + " | " + str[model.getBoard(2,1)] + " | " + str[model.getBoard(2,2)] + " |\n" +  "  -------------\n" + "****************\n";

  return str_return;


}
