package animation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Animation_001 implements MouseListener {
	
	public static JFrame window = new JFrame();
	public static Animation_001 panel = new Animation_001();
	public static JButton button_01 = new JButton("Clique aqui");
	public static JLabel square = new JLabel();
	
	public static void main(String[] args)
	{
		window.setSize(900, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setLayout(null);
		button_01.setBounds(10, 10, 100, 30);
		button_01.addMouseListener(panel);
		button_01.setContentAreaFilled(false);
		button_01.setFocusPainted(false);
		square.setOpaque(true);
		square.setBounds(10, 300, 100, 40);
		square.setBackground(Color.GRAY);
		window.add(button_01);
		window.add(square);
		window.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == button_01)
		{
			for(int i = 0; i < 100; i++)
			{
				try { Thread.sleep(100); } catch (InterruptedException exception) {}
				square.setBounds(10 + i, 300, 100, 40);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == button_01)
		{
			Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
			button_01.setCursor(cursor);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}