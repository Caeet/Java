package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Squares implements MouseListener {
	private ImageIcon X =  new ImageIcon("C:\\Users\\Guilherme Caetano\\eclipse-workspace\\TicTacToe\\res\\x.png");
	private ImageIcon O = new ImageIcon("C:\\Users\\Guilherme Caetano\\eclipse-workspace\\TicTacToe\\res\\O.png");
	private JLabel squares = new JLabel();
	private boolean isSquareUsed = false;
	private int x, y;
	private JFrame frame;
	
	public Squares(JFrame frame, int x, int y)
	{ 
		
		squares.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		squares.addMouseListener(this);
		frame.add(squares);
		this.frame = frame;
		
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
		if(!isSquareUsed)
		{
			if(Main.checkPlayer == 0)
			{
				X.setImage(X.getImage().getScaledInstance(squares.getWidth(), squares.getHeight(), 1));
				squares.setIcon(X);
				Main.newPlayer();
				Main.gameBox[x][y] = 1; 
			}
			else if(Main.checkPlayer == 1)
			{
				O.setImage(O.getImage().getScaledInstance(squares.getWidth(), squares.getHeight(), 1));
				squares.setIcon(O);
				Main.newPlayer();
				Main.gameBox[x][y] = 2;
			}
			
			isSquareUsed = true;
			
			for(int i = 0; i < 3; i++)
			{
				if(Main.gameBox[i][0] == 1 && Main.gameBox[i][1] == 1 && Main.gameBox[i][2] == 1 || Main.gameBox[0][i] == 1 && Main.gameBox[1][i] == 1 && Main.gameBox[2][i] == 1)
				{
					JOptionPane.showMessageDialog(null, "O Jogador 'X' ganhou o game!");
					frame.dispose();
					resetVars();
					Main.loadScreen();
				}
				else if(Main.gameBox[i][0] == 2 && Main.gameBox[i][1] == 2 && Main.gameBox[i][2] == 2 || Main.gameBox[0][i] == 2 && Main.gameBox[1][i] == 2 && Main.gameBox[2][i] == 2)
				{
					JOptionPane.showMessageDialog(null, "O Jogador 'O' ganhou o game!");
					frame.dispose();
					resetVars();
					Main.loadScreen();
				}
			}
			
			if(Main.gameBox[0][0] == 1 && Main.gameBox[1][1] == 1 && Main.gameBox[2][2] == 1 || Main.gameBox[0][2] == 1 && Main.gameBox[1][1] == 1 && Main.gameBox[2][0] == 1)
			{
				JOptionPane.showMessageDialog(null, "O Jogador 'X' ganhou o game!");
				frame.dispose();
				resetVars();
				Main.loadScreen();			
			}
			else if(Main.gameBox[0][0] == 2 && Main.gameBox[1][1] == 2 && Main.gameBox[2][2] == 2 || Main.gameBox[0][2] == 2 && Main.gameBox[1][1] == 2 && Main.gameBox[2][0] == 2)
			{
				JOptionPane.showMessageDialog(null, "O Jogador 'O' ganhou o game!");
				frame.dispose();
				resetVars();
				Main.loadScreen();			
			}
			
			Main.clicks++; 
			
			if(Main.clicks == 10)
			{
				JOptionPane.showMessageDialog(null, "Infelizmente ninguém ganhou o jogo!");
				frame.dispose();
				resetVars();
				Main.loadScreen();	
			}
		}
	}
	
	public void resetVars()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int a = 0; a < 3; a++)
			{
				Main.gameBox[i][a] = 0;
			}
		}
		
		Main.clicks = 0;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}