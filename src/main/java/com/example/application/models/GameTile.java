package com.example.application.models;

import java.util.Objects;

public class GameTile {
    private String displayValue;
    private boolean played;

    public GameTile(){
        displayValue = " ";
        played = false;
    }

    public void play(String player){
        if (!played) {
            togglePlayed();
            setDisplayValue(player);
        }
    }

    public void togglePlayed() {
        played = !played;
    }

    public void setDisplayValue(String player) {
        displayValue = player;
    }

    public boolean isPlayed() {
        return played;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTile gameTile = (GameTile) o;
        return played == gameTile.played &&
            Objects.equals(displayValue, gameTile.displayValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(played, displayValue);
    }
}
