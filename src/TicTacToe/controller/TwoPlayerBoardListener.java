package TicTacToe.controller;

import TicTacToe.model.Model;

import java.awt.event.MouseEvent;

public class TwoPlayerBoardListener extends BoardListener {

    public TwoPlayerBoardListener(Model model) {
        super(model);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (model.isGameOver()){
            model.resetGame();
            return;
        }
        int P = TicTacToe.display.TicTacToeWindow.CELL_PX;
        int x = e.getX()/P;
        int y = e.getY()/P;
        model.makeMove(x, y);
    }



}
