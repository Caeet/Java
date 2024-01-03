package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridLayout;

public class Main {
	public static int rows = 12;
	public static int cols = 20; 
	public static int sizeSquare = 48;
	public static int width = cols*sizeSquare;
	public static int height = rows*sizeSquare;
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Grid Test - Version: 1.0.0");
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));

		JLabel[][] squares = new JLabel[rows][cols];
		panel.setLayout(new GridLayout(rows, cols));
		
		for(int r = 0; r < rows; r++)
		{
			for(int c = 0; c < cols; c++)
			{
				Squares square = new Squares(r, c, sizeSquare);
				squares[r][c] = square;
				panel.add(square);
			}
		}
		
		window.add(panel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}