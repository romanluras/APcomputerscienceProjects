import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    JLabel label;

    private final int WindowWidth = 580;
    private final int WindowHeight = 1000;

    private final int oneUnitHeight = WindowHeight / 20;
    private final int oneUnitWidth = WindowWidth / 10;

    private final int PieceNumber = 0;

    MyFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //WindowHeight = (int) screenSize.getHeight();

        System.out.println(WindowHeight);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WindowWidth, WindowHeight);
        this.setLayout(null);
        this.addKeyListener(this);

        int[] PieceStorage;

        label = new JLabel();
        label.setBounds((WindowWidth / 2) - (WindowWidth / 10), 0, oneUnitWidth, oneUnitHeight);
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
                label.setLocation(label.getX() - oneUnitWidth, label.getY()); //47
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + oneUnitHeight); //47
                break;
            case 'd':
                label.setLocation(label.getX() + oneUnitWidth, label.getY()); //47
                break;

        }

        PlaceAndRegenerate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                label.setLocation(label.getX() - oneUnitWidth, label.getY()); //47
                break;
            case 40:
                label.setLocation(label.getX(), label.getY() + oneUnitHeight); //47
                break;
            case 39:
                label.setLocation(label.getX() + oneUnitWidth, label.getY()); //47
                break;
        }

        PlaceAndRegenerate();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("You released key char: " + e.getKeyChar());
    }

    public void Physics() {
        while(true) {
            label.setLocation(label.getX(), label.getY() + oneUnitHeight);

            System.out.println("Piece X position: " + label.getX() + "Piece Y position: " + label.getY());

            PlaceAndRegenerate();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void PlaceAndRegenerate(){
        if (label.getY() == WindowHeight - oneUnitHeight) {
            System.out.println("STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP");

            label.setLocation(label.getX(), WindowHeight);

            label = new JLabel();
            label.setBounds((WindowWidth / 2) - (WindowWidth / 10), 0, oneUnitWidth, oneUnitHeight);
            label.setBackground(Color.cyan);
            label.setOpaque(true);

            this.add(label);
        }
    }
}
