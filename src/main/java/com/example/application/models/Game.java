package com.example.application.models;

public class Game {
    String player1, player2;
    GameBoard board;

    boolean p1turn;
    
    public Game() {
        player1 = "X";
        player2 = "O";
        board = new GameBoard();
        p1turn = true;
    }

    public void play(int space) {
        if (p1turn)
            board.play(space, player1);
        else 
            board.play(space, player2);
        
        p1turn = !p1turn;
        
    }

    public String whoseTurn() {
        return p1turn ? player1 : player2;
    }

    public boolean isGameOver() {
        return board.gameIsOver();
    }

    public String whoWon() {
        return board.declareWinner();
    }
}
