import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class MyFrame extends JFrame implements KeyListener {
    //JLabel label;

    private final int WindowWidth = 580;
    private final int WindowHeight = 1000;

    private final int oneUnitHeight = WindowHeight / 20;
    private final int oneUnitWidth = WindowWidth / 10;

    private int PieceNumber = 0;

    private HashMap<String, JLabel> PieceStorage = new HashMap<>();
    private JFrame frame = new JFrame(); //create new frame

    MyFrame() {
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //WindowHeight = (int) screenSize.getHeight();

        System.out.println(WindowHeight);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WindowWidth, WindowHeight);
        this.setLayout(null);
        this.addKeyListener(this);

        createPiece("label" + PieceNumber, (WindowWidth / 2) - (WindowWidth / 10), 0);

        movePiece("label" + PieceNumber, (WindowWidth / 2) - (WindowWidth / 10), 0);

        this.setVisible(true);

        Physics();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                movePiece("label" + PieceNumber,("label" + PieceNumber).getX() , 0);
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX() - oneUnitWidth, PieceStorage.get("label" + PieceNumber).getY()); //47
                break;
            case 's':
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX(), PieceStorage.get("label" + PieceNumber).getY() + oneUnitHeight); //47
                break;
            case 'd':
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX() + oneUnitWidth, PieceStorage.get("label" + PieceNumber).getY()); //47
                break;

        }

        PlaceAndRegenerate();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX() - oneUnitWidth, PieceStorage.get("label" + PieceNumber).getY()); //47
                break;
            case 40:
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX(), PieceStorage.get("label" + PieceNumber).getY() + oneUnitHeight); //47
                break;
            case 39:
                PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX() + oneUnitWidth, PieceStorage.get("label" + PieceNumber).getY()); //47
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
            PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX(), PieceStorage.get("label" + PieceNumber).getY() + oneUnitHeight);

            System.out.println("Piece X position: " + PieceStorage.get("label" + PieceNumber).getX() + "Piece Y position: " + PieceStorage.get("label" + PieceNumber).getY());

            PlaceAndRegenerate();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void PlaceAndRegenerate(){
        if (PieceStorage.get("label" + PieceNumber).getY() == WindowHeight - oneUnitHeight) {
            System.out.println("STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP");

            PieceStorage.get("label" + PieceNumber).setLocation(PieceStorage.get("label" + PieceNumber).getX(), WindowHeight);

            createPiece("label" + PieceNumber, (WindowWidth / 2) - (WindowWidth / 10), 0);
        }
    }

    public void createPiece(String name, int x, int y) {
        JLabel label = new JLabel(name);
        label.setBounds(x, y, 100, 30);
        PieceStorage.put(name, label);
        frame.add(label);

        PieceNumber = PieceNumber + 1;
    }

    public void movePiece(String name, int newX, int newY) {
        JLabel label = PieceStorage.get(name);
        if (label != null) {
            label.setLocation(newX, newY);
            System.out.println(name + " moved to new location: (" + newX + ", " + newY + ")");
        } else {
            System.out.println("Label not found: " + name);
        }
    }
}
