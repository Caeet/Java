package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Interface_6 extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		Interface_6 panel = new Interface_6();
		window.setSize(300, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		BasicStroke stroke = new BasicStroke(10);
		g2d.setStroke(stroke);
		g2d.drawRoundRect(10, 10, 100, 100, 30, 30);
	}
}