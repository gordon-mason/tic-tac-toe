package TicTacToe.model;


import TicTacToe.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Transition {

    /**
     * Get a list of all states that can be reached by making one move by either player
     * @param game
     * @return empty list if no moves available, else one state for each move available
     */
    public static List<Model> nextStates(Model game){
        List<Model> nextStates = new ArrayList<>();
        if (game.isGameOver()){
            return nextStates;
        }
        int[][] board = game.getBoard();
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                if (board[x][y] == 0){
                    Model m = game.copy();
                    m.makeMove(x,y);
                    nextStates.add(m);
                }
            }
        }
        return nextStates;
    }
}
