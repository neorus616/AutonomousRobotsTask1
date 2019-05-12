import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyGui extends JPanel implements KeyListener {

    private static final File f = new File("p11.png");
    private static Structure s = new Structure(f);
    private BufferedImage canvas;
    private Drone drone;

    private MyGui(int width, int height) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.LIGHT_GRAY);
        drone = new Drone(this);
        drone.init();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Direct draw demo");

        MyGui panel = new MyGui(s.getWidth(), s.getHeight());
        frame.addKeyListener(panel);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel.fillCanvas(Color.BLACK);
        //		panel.drawRect(Color.RED, 90, 60,15, 15);
        //		panel.drawLine(Color.BLUE, 0, 0, 500, 500);

        panel.drawDrone();

    }

    private void drawDrone() {
        drawRect(Color.RED, drone.location.x, drone.location.y, 3, 3);
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }

    private void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                if (s.readMap(x, y) == 0)
                    canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawPoint(Color c, int x, int y) {
        int color = c.getRGB();
        canvas.setRGB(x, y, color);
        repaint();
    }

    public void drawLine(Color c, int x1, int y1, int x2, int y2) {
        int color = c.getRGB();
        double m = (y1 - y2) / (x1 - x2);
        for (int x = x1; x <= x2; x++) {
            int y = (int) ((m * x) - (m * x1) + y1);
            //	y-y1=m(x-x1)
            //	y=mx-mx1+y1
            canvas.setRGB(x, y, color);

        }
        repaint();
    }

    public void drawRect(Color c, int x1, int y1, int width, int height) {
        int color = c.getRGB();
        for (int x = x1; x < x1 + width; x++) {
            for (int y = y1; y < y1 + height; y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case 65:
                drone.moveLeft();
                break;
            case 68:
                drone.moveRight();
            case 87:
                drone.acceleration();
            case 83:
                drone.deceleration();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}