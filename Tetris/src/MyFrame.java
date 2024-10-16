import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    JLabel label;

    private final int WindowWidth = 580;
    private final int WindowHeight;

    private final int PieceNumber = 0;

    MyFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        WindowHeight = (int) screenSize.getHeight();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WindowWidth, WindowHeight);
        this.setLayout(null);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds((WindowWidth / 2) - (WindowWidth / 10), 0, WindowWidth / 10, WindowHeight / 20);
        label.setBackground(Color.cyan);
        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);

        Physics();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX() - WindowWidth / 10, label.getY()); //47
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + WindowHeight / 20); //47
                break;
            case 'd':
                label.setLocation(label.getX() + WindowWidth / 10, label.getY()); //47
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                label.setLocation(label.getX() - WindowWidth / 10, label.getY()); //47
                break;
            case 40:
                label.setLocation(label.getX(), label.getY() + WindowHeight / 20); //47
                break;
            case 39:
                label.setLocation(label.getX() + WindowWidth / 10, label.getY()); //47
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("You released key char: " + e.getKeyChar());
    }

    public void Physics() {
        while(true) {
            label.setLocation(label.getX(), label.getY() + 47);

            PlaceAndRegenerate();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void PlaceAndRegenerate(){
        if (label.getY() >= WindowHeight) {
            label.setLocation(label.getX(), WindowHeight);

            label = new JLabel();
            label.setBounds((WindowWidth / 2) - (WindowWidth / 10), 0, WindowWidth / 10, WindowHeight / 20);
            label.setBackground(Color.cyan);
            label.setOpaque(true);

            this.add(label);
        }
    }
}
