CC		= g++
C		= cpp

CFLAGS		= -g
S		= -std=c++11

PROJECT		= ttt

all:
	${CC} ${S} -c ./controller/TTTController.cpp -o TTTController.o
	${CC} ${S} -c ./model/Board.cpp -o Board.o
	${CC} ${S} -c ./model/Player.cpp -o Player.o		
	${CC} ${S} -c main.cpp -o Main.o
	${CC} ${S} -o ${PROJECT} TTTController.o Board.o Player.o Main.o
	mv ${PROJECT} cgi-bin/ttt.cgi

clean:
	rm -f core.* *.o *~ ${PROJECT}

