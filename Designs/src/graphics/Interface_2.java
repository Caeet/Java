package graphics;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Color;

public class Interface_2 extends JPanel {

	private static final long serialVersionUID = -7774056629275595949L;
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		Interface_2 panel = new Interface_2();
		
		window.setSize(900, 600);
		window.setTitle("Interface Design - Versão: 1.0.1");
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.setColor(Color.BLUE);
		g.drawLine(450, 100, 450, 500);
	
		g.setColor(Color.GREEN);
		g.drawLine(250, 300, 650, 300);
		
		g.setColor(Color.MAGENTA);
		g.drawLine(650, 300, 450, 100);
		
		g.setColor(Color.DARK_GRAY);
		g.drawLine(250, 300, 450, 100);
		
		g.setColor(Color.ORANGE);
		g.drawLine(250, 300, 450, 500);
		
		g.setColor(Color.PINK);
		g.drawLine(450, 500, 650, 300);
	}
}