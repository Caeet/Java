package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Interface_3 extends JPanel {

	private static final long serialVersionUID = 7852523957885674874L;

	public static void main(String[] args)
	{
		Interface_3 panel = new Interface_3();
		JFrame window = new JFrame("Interface Design- Versão: 1.0.2");
		window.setSize(435, 600);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawLine(10, 10, 110, 110);
		g.drawRect(160, 10, 100, 100);
		g.drawOval(310, 10, 100, 100);
		
		g.setColor(Color.GREEN);
		g.fillRect(160, 210, 100, 200);
	
		g.setColor(Color.RED);
		g.fillOval(310,  210, 100, 100);
	}
}