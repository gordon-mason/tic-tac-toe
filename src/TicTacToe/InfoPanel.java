package TicTacToe;

import javax.swing.*;

public class InfoPanel extends JPanel {
    private Model model;
    private JLabel message;

    public InfoPanel(Model model) {
        this.model = model;
        message = new JLabel("O goes first");
    }

    public void update(){
        if (model.isGameOver()){
            int winner = model.getWinner();
            String s;
            if (winner == 0)
                s = "It's a draw";
            else
                s = "Player " + winner + " won (" + ((winner==1) ? "noughts" : "crosses") + ")";
            System.out.println(s);
            message.setText(s);
        }
    }
}
