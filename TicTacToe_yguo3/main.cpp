/**************************************************
        Author: Yang Guo
        Project: Tic Tac Toe MVC

**************************************************/

#include "controller/TTTController.h"


using namespace std;

int main(){
  cout << "**************************************************" << endl;
  cout << "**************************************************" << endl;
  cout << "          Welcome to play TicTacToe !" << endl;
  cout << "**************************************************" << endl;
  cout << "          S: Start Game" << endl;
  cout << "          Q: Quit" << endl;
  cout << "**************************************************" << endl;

  cout << "Press S/s to start or Q/q to quit: ";
  char c;
  cin >> c;
  // check selection
  while(c != 's' && c != 'S' && c != 'Q' && c != 'q'){
    cout << "Please retype the selection: ";
    cin >> c;
  }

  // start game
  // This is the main part of game View;
  if(c == 's' || c == 'S'){
    TTTController controller;
    controller.startNewGame();

    // // output the status of controller
    // controller.getGameDisplay();

    string str1, str2;
    //input name and marker of each player;
    cout << "Please write the name of first player: ";
    cin >> str1;
    cout << "Please choose the marker of first player (just one character): ";
    cin >> str2;
    controller.createPlayer(str1,str2,1);
    cout << "Please write the name of second player: ";
    cin >> str1;
    cout << "Please choose the marker of second player (just one character): ";
    cin >> str2;
    controller.createPlayer(str1,str2,2);

    cout << "**************************************************" << endl;
    cout << "          Game Begin !" << endl;
    cout << "**************************************************" << endl;

    int currentPlayer = 1;
    while(currentPlayer == 1 || currentPlayer == 2){
      cout << controller.getGameDisplay();
      int row, col;
      int result = 0;
      bool flag_selection = false;
      // input selection and check
      while(!flag_selection){
      cout << "Now let player " << currentPlayer << " select the position." << endl;
      cout << "Input row number: ";
      cin >> row;
      cout << "Input column number: ";
      cin >> col;
      flag_selection = controller.setSelection(row, col, currentPlayer);
      if(!flag_selection)
        cout << "You should reselect!" << endl;
      }

      // every cycle controller determine who is the winner
      result = controller.determineWinner();
      if(result == 1){
        cout << controller.getGameDisplay();
        cout << "Player 1 Wins! Congratulation!" << endl;
        return 1;
      }
      else if(result == 2){
        cout << controller.getGameDisplay();
        cout << "Player 2 Wins! Congratulation!" << endl;
        return 2;
      }
      else if(result == 3){
        cout << controller.getGameDisplay();
        cout << "Tie! No Winner!" << endl;
        return 3;
      }

      if(currentPlayer == 1)
        currentPlayer = 2;
      else if(currentPlayer == 2)
        currentPlayer = 1;
    }


  }

  // quit game
  else{
    cout << "Bye! Good luck with you!" << endl;
  }

  return 0;
}
