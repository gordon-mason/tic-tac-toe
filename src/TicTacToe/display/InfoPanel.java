package TicTacToe.display;

import TicTacToe.model.Model;

import javax.swing.*;

public class InfoPanel extends JPanel {
    private Model model;
    private JLabel message;

    public InfoPanel(Model model) {
        this.model = model;
        message = new JLabel("O goes first");
        this.add(message);
    }

    public void update(){
        String msg;
        if (model.isGameOver()){
            int winner = model.getWinner();
            if (winner == 0)
                msg = "It's a draw";
            else
                msg = "Player " + winner + " won (" + ((winner==1) ? "noughts" : "crosses") + ")";
        }
        else {
            if (model.isFirstPlayersTurn()){
                //noughts plays first
                msg = "O's turn";
            }
            else {
                msg = "X's turn";
            }
        }
        message.setText(msg);
    }
}
