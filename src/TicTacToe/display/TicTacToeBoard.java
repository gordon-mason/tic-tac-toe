package TicTacToe.display;

import TicTacToe.model.Model;

import java.awt.*;

public class TicTacToeBoard extends Canvas {



    private Model model;

    public TicTacToeBoard(Model model) {
        this.model = model;
        int P = TicTacToe.display.TicTacToeWindow.CELL_PX;
        Dimension canvasSize = new Dimension(3 * P, 3 * P);
        setSize(canvasSize);
    }

    @Override
    public void paint(Graphics g) {
        int P = TicTacToe.display.TicTacToeWindow.CELL_PX;
        Graphics2D g2 = (Graphics2D) g;
        //draw grid
        g2.setColor(Color.BLACK);
        int canvasHeight = this.getHeight();
        for (int i = 1; i < 3; i++) {
            Rectangle up = new Rectangle(i*P, 0, 3, canvasHeight);
            Rectangle across = new Rectangle(0, i*P, canvasHeight, 3);
            g2.draw(up);
            g2.fill(up);
            g2.draw(across);
            g2.fill(across);
        }
        //draw board
        int[][] board = model.getBoard();
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                if (board[x][y] == 1){
                    //draw nought
                    int offset = (P/10);
                    int xCoord = x * P + offset/2;
                    int yCoord = y * P + offset/2;
                    int diam = P - offset;
                    Shape s = new Circle(xCoord,yCoord,diam, diam);
                    g2.draw(s);
                }
                if (board[x][y] == 2){
                    int thickness = 5;
                    //draw cross
                    int offset = (P/10);
                    int size = P - offset;
                    int left = x * P + offset/2;
                    int top = y * P + offset/2;
                    int[] xPoints = {
                            //top left
                            left, left + thickness,
                            //middle
                            left + size/2,
                            //top right
                            left + size -thickness, left + size,
                            //middle
                            left + size/2,
                            //bottom right
                            left + size -thickness, left + size,
                            //middle
                            left + size/2,
                            //bottom left
                            left + thickness, left,
                            //middle
                            left + size/2,
                            //back to start
                            left};
                    int[] yPoints = {
                            //top left
                            top,  top,
                            //middle
                            top + size/2,
                            //top right
                            top, top,
                            //middle
                            top + size/2,
                            //bottom right
                            top + size, top + size,
                            //middle
                            top + size/2,
                            //bottom left
                            top + size, top + size,
                            //middle
                            top + size/2,
                            //back to start
                            top
                        };
                    Shape s = new Polygon(xPoints, yPoints, xPoints.length);
                    g2.fill(s);
                    g2.draw(s);
                }
            }
        }
    }

    private void drawShapeAtGameCoords(Shape shape, int x, int y){

    }
}
