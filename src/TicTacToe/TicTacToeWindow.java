package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class TicTacToeWindow implements Observer{


    public static final int CELL_PX = 100;

    private JFrame window;
    private TicTacToeBoard canvas;
    private InfoPanel infoPanel;
    private Model model;

    public TicTacToeWindow(Model model){
        this.model = model;
        canvas = new TicTacToeBoard(model);
        infoPanel = new InfoPanel(model);
        canvas.addMouseListener(new BoardListener(model));
        model.addObserver(this);

        window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // window.setResizable(false);
        window.setContentPane(makeContentPane());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        update(null, null);
    }

    private Container makeContentPane() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(canvas);
        panel.add(infoPanel);
        return panel;
    }


    @Override
    public void update(Observable o, Object arg) {
        canvas.repaint();
        infoPanel.update();
    }
}
