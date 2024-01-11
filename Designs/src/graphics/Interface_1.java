package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;

public class Interface_1 extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public static JFrame window = new JFrame("Interface Design - Versão 1.0.0");
	public static Interface_1 panel = new Interface_1();
	
	public static void main(String[] args)
	{
		window.setSize(900, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawLine(450, 100, 550, 200);
		g.drawLine(450, 100, 350, 200);
		g.drawLine(350, 200, 550, 200);
		g.drawLine(350, 200, 350, 500);
		g.drawLine(350, 500, 550, 500);
		g.drawLine(550, 500, 550, 200);
	}
}