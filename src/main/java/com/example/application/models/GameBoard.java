package com.example.application.models;

public class GameBoard {
    private GameTile[] tiles = new GameTile[9];
    private Boolean gameOver;
    private String winner;
    private int playedTilesCount;

    public GameBoard() {
        tiles = new GameTile[9];

        for(int x=0; x<9; x++){
            tiles[x] = new GameTile();
        }

        gameOver = false;
        winner = "";
        playedTilesCount = 0;
    }

    public void play(int space, String player) {
        tiles[space].play(player);
        playedTilesCount++;

        evaluateBoard();
    }

    public int getPlayedTilesCount() {
        return playedTilesCount;
    }

    public boolean gameIsOver() {
        return gameOver;
    }

    public String declareWinner() {
        return winner;
    }

    private void evaluateBoard() {
        // If tiles 123, 147, 159, 258, 357, 456, 789, 369 match
        if (match(0,1,2) || 
            match(0,3,6) || 
            match(0,4,8)) {
                gameOver = true;
                winner = tiles[0].getDisplayValue();
            } else if (match(1,4,7) ||
            match(2,4,6) ||
            match(3,4,5)) {
                gameOver = true;
                winner = tiles[4].getDisplayValue();
            } else if (match(6,7,8) ||
            match(2,5,8)) {
                gameOver = true;
                winner = tiles[8].getDisplayValue();
            } else if (playedTilesCount == 9) {
                gameOver = true;
                winner = "";
            } else {
                gameOver = false;
                winner = "";
            }
    }

    private boolean match (int a, int b, int c) {
        boolean result = tiles[a].equals(tiles[b]) && 
            tiles[b].equals(tiles[c]) &&
            tiles[a].isPlayed();
        System.out.println(result);
        return result;
    }
}
