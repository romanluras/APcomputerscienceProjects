import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Movement extends JFrame implements KeyListener {
    private Main draw;

    public void Movement() {
        this.draw = new Main();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                draw.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                draw.moveRight();
                break;
            case KeyEvent.VK_DOWN:
                draw.moveDown();
                break;
            case KeyEvent.VK_UP:
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Movement frame = new Movement();
                frame.setTitle("Tetris");
                frame.setResizable(false);
                frame.setSize(600, 600);
                frame.setMinimumSize(new Dimension(600, 600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }



}
