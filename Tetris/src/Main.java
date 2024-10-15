import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Main extends JComponent{

    public int piecey = 0;
    public int piecex = 0;

    public void startGame(Graphics g){


        int width = 580; //10 wide | one piece block = 58
        int height = 940; //20 tall | 47 one piece block

        //DrawingPanel panel = new DrawingPanel(width, height);

        //g.setBackground(Color.BLACK);

        do {
            Create_Piece(piecex, piecey,58, 47, g, "rectangle");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Clear_Piece(piecex, piecey,58, 47, g, "rectangle");

            piecey += 47;

        } while (true);
    }

    public void moveRight() {
        piecex = piecex + 58;

    }

    public void moveLeft() {
        piecex = piecex - 58;

    }

    public void moveDown() {
        piecey = piecey + 47;

    }

    public void moveUp() {

    }

    static public void Create_Piece(int x, int y, int width, int height, Graphics g, String piece_name) {
        if (piece_name.equals("rectangle")) {
            g.setColor(Color.BLUE);
            g.fillRect(x,y,width,height);
        }
    }

    static public void Clear_Piece(int x, int y, int width, int height, Graphics g, String piece_name) {
        if (piece_name.equals("rectangle")) {
            g.setColor(Color.BLACK);
            g.fillRect(x,y,width,height);
        }
    }

}