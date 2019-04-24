package pa3;

import java.awt.*;

/**
 * Name: Chaolun Feng
 * Programming Assignment: Draw Tic-Tac-Toe Boards
 */
public class TicTacToeBoards {
    private NscWindow windowForTicTacToeBoardAssignment;
    /**
     *This method is the constructor for the class.
     */
    public TicTacToeBoards(){
        windowForTicTacToeBoardAssignment = new NscWindow(10,10,300,330);
        drawTicTacToeBoard(40,40);
        drawTicTacToeBoard(40,170, Color.red);
        drawTicTacToeBoard(170,40);
        drawTicTacToeBoard(170,170);
    }

    /**
     * This method is responsible for draw one Tic-Tac-Toe board.
     * @param xCoord    The initial x coordination of the Tic-Tac-Toe board
     * @param yCoord    The initial y coordination of the Tic-Tac-Toe board
     */
    public void drawTicTacToeBoard(int xCoord, int yCoord){
        NscLine line1 = new NscLine(xCoord,yCoord + 30,xCoord + 90,yCoord + 30);
        NscLine line2 = new NscLine(xCoord,yCoord + 60,xCoord + 90,yCoord + 60);
        NscLine line3 = new NscLine(xCoord + 30,yCoord,xCoord + 30,yCoord + 90);
        NscLine line4 = new NscLine(xCoord + 60,yCoord,xCoord + 60,yCoord + 90);
        windowForTicTacToeBoardAssignment.add(line1);
        windowForTicTacToeBoardAssignment.add(line2);
        windowForTicTacToeBoardAssignment.add(line3);
        windowForTicTacToeBoardAssignment.add(line4);
    }

    /**
     * This method is responsible for draw one Tic-Tac-Toe board.
     * @param xCoord    The initial x coordination of the Tic-Tac-Toe board
     * @param yCoord    The initial y coordination of the Tic-Tac-Toe board
     * @param color     The color of the line for the Tic-Tac-Toe board
     */
    public void drawTicTacToeBoard(int xCoord, int yCoord, Color color) {
        NscLine line1 = new NscLine(xCoord,yCoord + 30,xCoord + 90,yCoord + 30);
        NscLine line2 = new NscLine(xCoord,yCoord + 60,xCoord + 90,yCoord + 60);
        NscLine line3 = new NscLine(xCoord + 30,yCoord,xCoord + 30,yCoord + 90);
        NscLine line4 = new NscLine(xCoord + 60,yCoord,xCoord + 60,yCoord + 90);

        line1.setForeground(color);
        line2.setForeground(color);
        line3.setForeground(color);
        line4.setForeground(color);
        windowForTicTacToeBoardAssignment.add(line1);
        windowForTicTacToeBoardAssignment.add(line2);
        windowForTicTacToeBoardAssignment.add(line3);
        windowForTicTacToeBoardAssignment.add(line4);
    }
}
