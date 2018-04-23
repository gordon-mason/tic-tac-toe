package TicTacToe;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardListener implements MouseListener {

    private Model model;

    public BoardListener(Model model) {
        this.model = model;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (model.isGameOver()){
            model.resetGame();
            return;
        }
        int P = TicTacToeWindow.CELL_PX;
        int x = e.getX()/P;
        int y = e.getY()/P;
        model.makeMove(x, y);
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }

}
