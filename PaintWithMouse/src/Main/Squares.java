package Main;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;

public class Squares extends JLabel {

	private static final long serialVersionUID = 1L;

	public Squares(int r, int c, int s)
	{
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		addMouseListener(new ClickChangeColor(this));
	}
}