package TicTacToe.display;

import TicTacToe.controller.AIBoardListener;
import TicTacToe.controller.BoardListener;
import TicTacToe.controller.TwoPlayerBoardListener;
import TicTacToe.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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
        model.addObserver(this);
        window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(makeContentPane());
        window.pack();
        window.setLocationRelativeTo(null);
        JDialog modeSelector = new JDialog(window, "Select mode");
        Container cp = modeSelector.getContentPane();
        cp.setLayout(new GridLayout(1,2));
        JButton button = new JButton("Two Player");
        button.addActionListener(e -> {
            initialise(new TwoPlayerBoardListener(model));
            modeSelector.dispose();
        });
        cp.add(button);
        button = new JButton("One Player (v AI)");
        button.addActionListener(e -> {
            initialise(new AIBoardListener(model));
            modeSelector.dispose();
        });
        cp.add(button);

        modeSelector.pack();
        modeSelector.setLocationRelativeTo(null);
        modeSelector.setVisible(true);
    }

    private void initialise(BoardListener canvasListener){
        for (MouseListener ml : canvas.getMouseListeners()){
            canvas.removeMouseListener(ml);
        }
        canvas.addMouseListener(canvasListener);
        window.setVisible(true);
    }

    private Container makeContentPane() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(canvas, BorderLayout.CENTER);
        panel.add(infoPanel, BorderLayout.EAST);
        return panel;
    }


    @Override
    public void update(Observable o, Object arg) {
        canvas.repaint();
        infoPanel.update();
    }
}
