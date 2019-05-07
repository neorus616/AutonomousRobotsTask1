import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGui extends JPanel {

	private BufferedImage canvas;
	private static final File f=new File("C:\\Users\\arbel\\Downloads\\Ex1_code_maps(1)\\Ex1_code_maps\\p11.png");
	static Structure s= new Structure(f);
	public Drone drone;

	public MyGui(int width, int height) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		fillCanvas(Color.LIGHT_GRAY);
		drone=new Drone();
		drone.init();

	}

	public void drawDrone() {
		drawRect(Color.RED,drone.location.x, drone.location.y,3,3 );
	}

	public Dimension getPreferredSize() {
		return new Dimension(canvas.getWidth(), canvas.getHeight());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(canvas, null, null);
	}


	public void fillCanvas(Color c) {
		int color = c.getRGB();
		for (int x = 0; x < canvas.getWidth(); x++) {
			for (int y = 0; y < canvas.getHeight(); y++) {
				if(s.readMap(x, y)==0)
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
		double m=(y1-y2)/(x1-x2);
		for (int x=x1;x<=x2; x++) {
			int y=(int)((m*x)-(m*x1)+y1);
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




	public static void main(String[] args) {

		JFrame frame = new JFrame("Direct draw demo");

		MyGui panel = new MyGui( s.getWidth(),  s.getHeight());

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//panel.fillCanvas(Color.BLACK);
		//		panel.drawRect(Color.RED, 90, 60,15, 15);
		//		panel.drawLine(Color.BLUE, 0, 0, 500, 500);

		panel.drawDrone();

		
		
	}


}