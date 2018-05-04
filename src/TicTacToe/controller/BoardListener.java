package TicTacToe.controller;

import TicTacToe.model.Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class BoardListener implements MouseListener {

    protected Model model;

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
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }

}
