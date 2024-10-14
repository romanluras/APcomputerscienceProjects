import java.awt.Robot;
import java.awt.AWTException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Main {
    public static int piecey = 0;
    public static int piecex = 0;

    public static void main(String[] args) {
        int width = 580; //10 wide | one piece block = 58
        int height = 940; //20 tall | 47 one piece block

        Tetris_Pieces tetrisPieces = new Tetris_Pieces();

        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();

        panel.setBackground(Color.BLACK);

        do {
            Create_Piece(piecex, piecey,58, 47, g, "rectangle");

            wait(1000);

            Clear_Piece(piecex, piecey,58, 47, g, "rectangle");

            piecey += 47;

        } while (true);
    }

    public void KeyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                piecex -= 58;
                break;
            case KeyEvent.VK_RIGHT:
                piecex += 58;
                break;
            case KeyEvent.VK_DOWN:
                piecey -= 47;
                break;
        }
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    static public void Create_Piece(int x, int y, int width, int height, Graphics g, String piece_name) {
        if (piece_name == "rectangle") {
            g.setColor(Color.BLUE);
            g.fillRect(x,y,width,height);
        }
    }

    static public void Clear_Piece(int x, int y, int width, int height, Graphics g, String piece_name) {
        if (piece_name == "rectangle") {
            g.setColor(Color.BLACK);
            g.fillRect(x,y,width,height);
        }
    }
}