package Main;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ClickChangeColor extends MouseAdapter {
	
	public JLabel label;
	
	public ClickChangeColor(JLabel label)
	{
		this.label = label;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		label.setBackground(Color.GREEN);
	}
}