package TicTacToe.model;

import java.util.Observable;

public class Model extends Observable {

    private int[][] board;
    private boolean playerOneTurn;
    private boolean gameOver;
    private int winner;

    public Model(){
        resetGame();
    }


    public int[][] getBoard(){
        return board;
    }

    /**
     * @return -1 if still in play, 0 for a draw, 1 for p1, 2 for p2
     */
    public int getWinner(){
        return winner;
    }


    public boolean isGameOver(){
        return gameOver;
    }

    public boolean isFirstPlayersTurn(){
        return playerOneTurn;
    }


    public boolean makeMove(int x, int y){
        if (gameOver){
            return false;
        }
        if (x < 0 || y < 0 || x > 3 || y > 3) throw new RuntimeException("Invalid x or y coordinates : " + x + ", " + y);
        if (board[x][y] == 0){
            int val = playerOneTurn ? 1 : 2;
            board[x][y] = val;

            if (isWinningMove())
                winner = val;
            else if (isDraw())
                winner = 0;

            if (winner > -1)
                gameOver = true;
            else
                playerOneTurn = !playerOneTurn;
            setChanged();
            notifyObservers();
            return true;
        }
        else return false;
    }


    private boolean isDraw() {
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                if (board[x][y] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isWinningMove() {
        for (int i = 0; i < 3; i ++){
            if (board[i][0] > 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return true;
            if (board[0][i] > 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return true;
        }
        if (board[0][0] > 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if (board[0][2] > 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
        return false;
    }


    public void resetGame(){
        board = new int[3][3];
        playerOneTurn = true;
        gameOver = false;
        winner = -1;
        setChanged();
        notifyObservers();
    }


    public Model copy(){
        Model model = new Model();
        int[][] newBoard = new int[3][3];
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                newBoard[x][y] = board[x][y];
            }
        }
        model.board = newBoard;
        model.gameOver = this.gameOver;
        model.playerOneTurn = this.playerOneTurn;
        model.winner = this.winner;
        return model;
    }

}
