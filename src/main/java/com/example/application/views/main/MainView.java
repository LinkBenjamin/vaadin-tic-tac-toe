package com.example.application.views.main;

import com.example.application.models.Game;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("") 
public class MainView extends VerticalLayout { 

  Game game = new Game();
  H3 turn = new H3("Click a button to play an X");

  public MainView() {
    
    VerticalLayout buttonBoard = createButtonBoard();

    add( 
      new H1("Tic-Tac-Toe!"),
      turn,
      buttonBoard
    );
  }

  private VerticalLayout createButtonBoard() {
    Button[] buttons = new Button[9];
    
    for(int x=0;x<9;x++) {
      buttons[x] = new Button();
      buttons[x].setId(String.valueOf(x));
      buttons[x].addClickListener(event -> {
        event.getSource().setText(game.whoseTurn());
        game.play(Integer.parseInt(event.getSource().getId().get()));
        turn.setText("Click a button to play an " + game.whoseTurn());
        event.getSource().setEnabled(false);
        if(game.isGameOver()){
          for (int y = 0; y < 9; y++){
            buttons[y].setEnabled(false);
          }
          if(game.whoWon() == "X" || game.whoWon() == "O") 
            Notification.show("Game is over - " + game.whoWon() + " wins!  Refresh the screen to play again!");
          else  
            Notification.show("Game is over - outcome is a draw! Refresh the screen to play again!");
        }
      });
    }

    HorizontalLayout row1 = new HorizontalLayout(
      buttons[0],
      buttons[1],
      buttons[2]
    );

    HorizontalLayout row2 = new HorizontalLayout(
      buttons[3],
      buttons[4],
      buttons[5]
    );

    HorizontalLayout row3= new HorizontalLayout(
      buttons[6],
      buttons[7],
      buttons[8]
    );
    
    return new VerticalLayout(
      row1,
      row2,
      row3);
  }
}