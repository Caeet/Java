package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Graphics;

public class Interface_4 extends JPanel {

	private static final long serialVersionUID = -7750814578132441348L;

	public static void main(String[] args)
	{
		Interface_4 panel = new Interface_4();
		JFrame window = new JFrame();
		window.setSize(400, 600);
		window.setTitle("Interface Design - Versão: 1.0.4");
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawArc(10, 10, 100, 100, 0, 270);
		g.fillArc(200, 10, 100, 100, 0, 180);
		g.drawRoundRect(10, 210, 100, 100, 30, 30);
		g.fillRoundRect(200, 210, 100, 100, 30, 30);
		
		g.setColor(Color.GREEN);
		g.draw3DRect(10, 410, 100, 100, true);
		g.fill3DRect(200, 410, 100, 100, true);
	}
}