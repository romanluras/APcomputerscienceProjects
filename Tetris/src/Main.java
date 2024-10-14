import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main {
    private static int piecey = 0;
    private static int piecex = 0;

    public class TetrisGame extends JFrame implements KeyListener {
        private boolean leftPressed = false;
        private boolean rightPressed = false;
        private boolean downPressed = false;
        private boolean rotatePressed = false;

        public TetrisGame() {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    leftPressed = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightPressed = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downPressed = true;
                    break;
                case KeyEvent.VK_UP:
                    rotatePressed = true;
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    leftPressed = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightPressed = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downPressed = false;
                    break;
                case KeyEvent.VK_UP:
                    rotatePressed = false;
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        public void startGame(){
            int width = 580; //10 wide | one piece block = 58
            int height = 940; //20 tall | 47 one piece block

            Tetris_Pieces tetrisPieces = new Tetris_Pieces();

            DrawingPanel panel = new DrawingPanel(width, height);
            Graphics g = panel.getGraphics();

            panel.setBackground(Color.BLACK);

            do {
                if (leftPressed) {
                    piecex -= 58;
                }
                if (rightPressed) {
                    piecex += 58;
                }
                if (downPressed) {
                    piecey -= 47;
                }
                if (rotatePressed) {
                    piecex -= 58;
                }

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

        public void main(String[] args) {
            TetrisGame game = new TetrisGame();
            game.startGame();
        }
    }



    static public void Create_Piece(int x, int y, int width, int
height, Graphics g, String piece_name) {
        if (piece_name == "rectangle") {
            g.setColor(Color.BLUE);
            g.fillRect(x,y,width,height);
        }
    }

    static public void Clear_Piece(int x, int y, int width, int
height, Graphics g, String piece_name) {
        if (piece_name == "rectangle") {
            g.setColor(Color.BLACK);
            g.fillRect(x,y,width,height);
        }
    }
}
