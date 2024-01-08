package main;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {
	public static int checkPlayer = 0;
	public static int gameBox[][] = new int[3][3];
	public static Squares[][] sq = new Squares[3][3];
	public static int clicks = 0;
	
	public static void main(String[] args)
	{
		loadScreen();
	}
	
	public static void newPlayer()
	{
		if(checkPlayer == 0)
			checkPlayer = 1;
		else if(checkPlayer == 1)
			checkPlayer = 0;
	}
	
	public static void loadScreen()
	{
		JFrame window = new JFrame();
		window.setTitle("TicTacToe - Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setSize(500, 500);
		window.setLocationRelativeTo(null);
		window.setLayout(new GridLayout(3, 3));
		
		for(int i = 0; i < 3; i++)
		{	
			for(int x = 0; x < 3; x++)
			{
				sq[i][x] = new Squares(window, i, x);		
			}
		}
		
		window.setVisible(true);
	}
}