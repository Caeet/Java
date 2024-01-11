package graphics;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;

public class Interface_5 extends JPanel {
	
	private static final long serialVersionUID = -6373041135269355844L;

	public static void main(String[] args)
	{
		Interface_5 panel = new Interface_5();
		JFrame window = new JFrame();
		window.setTitle("Interface Design - Versão: 1.0.5");
		window.setSize(525, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.add(panel);
		window.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		int[] pontos_x = {50, 250, 450};
		int[] pontos_y = {370, 30, 370};
		g.fillPolygon(pontos_x, pontos_y, 3);
	}
}