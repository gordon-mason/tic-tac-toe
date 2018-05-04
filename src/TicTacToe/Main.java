package TicTacToe;

import TicTacToe.display.TicTacToeWindow;
import TicTacToe.model.Model;

public class Main {

    public static void main(String[] args){
        Model m = new Model();
        TicTacToeWindow v = new TicTacToeWindow(m);
    }
}
