CC		= g++
C		= cpp

CFLAGS		= -g

PROJECT		= ttt

all:
	${CC} -c ./controller/TTTController.cpp -o TTTController.o
	${CC} -c ./model/TTTModel.cpp -o TTTModel.o
	${CC} -c main.cpp -o Main.o
	${CC} -o ${PROJECT} TTTController.o TTTModel.o Main.o

clean:
	rm -f core.* *.o *~ ${PROJECT}

