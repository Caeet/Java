package main;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Squares implements MouseListener {
	
	public boolean squareUtilizado = false;
	public JLabel squares = new JLabel();
	public String identificarSprite = "nulo";
	public static ImageIcon x_icon = new ImageIcon("C:\\Users\\Guilherme Caetano\\Documents\\Meus Arquivos\\Eclipse Projetos\\TicTacToe\\res\\00000011.png");
	public static ImageIcon o_icon = new ImageIcon("C:\\Users\\Guilherme Caetano\\Documents\\Meus Arquivos\\Eclipse Projetos\\TicTacToe\\res\\00000100.png");
	public JFrame window;
	public static int tentativasGame = 0;
	public static boolean botJogando = false;
	public static boolean isTrocarJogadaActived = false; 
	
	public Squares(JPanel panel, JFrame window)
	{
		squares.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		squares.addMouseListener(this);
		panel.add(squares);
		this.window = window;
	}

	public void mouseClicked(MouseEvent e) {
		if(isTrocarJogadaActived)
		{
			if(identificarSprite.equals("X"))
			{
				squares.setIcon(o_icon);
				identificarSprite = "O";
			}
			else if(identificarSprite.equals("O"))
			{
				squares.setIcon(x_icon);
				identificarSprite = "X";
			}
			
			verificarPartida();
			isTrocarJogadaActived = false;
		}
		else if(!squareUtilizado && !botJogando)
		{
			tentativasGame++;
			o_icon.setImage(o_icon.getImage().getScaledInstance(squares.getWidth(), squares.getHeight(), 1));
			x_icon.setImage(x_icon.getImage().getScaledInstance(squares.getWidth(), squares.getHeight(), 1));
			
			
			if(Main.verificarJogador == 1)
			{
				squares.setIcon(x_icon);
				identificarSprite = "X";
				Main.verificarJogador++;
			}
			else if(Main.verificarJogador == 2)
			{
				squares.setIcon(o_icon);
				identificarSprite = "O";
				Main.verificarJogador--;
			}
			
			verificarPartida();
			squareUtilizado = true;
			
			if(Main.isContraPC && Main.verificarJogador == 2)
			{
				botJogando = true;
				new Bot().start();
			}
			
			if(tentativasGame == 9)
			{
				JOptionPane.showMessageDialog(null, "Nenhum dos jogadores ganhou a partida!");
				window.dispose();
				new Main();
				tentativasGame = 0;
			}
		}
	}
	
	public void jogadorDoisVencer()
	{
		JOptionPane.showMessageDialog(null, "O jogador dois venceu a partida!");
		Main.PontosJ2++;
		Main.verificarJogador = 1;
		window.dispose();
		tentativasGame = 0;
		new Main();
	}
	
	public void jogadorUmVencer()
	{
		JOptionPane.showMessageDialog(null, "O jogador um venceu a partida!");
		Main.PontosJ1++;
		Main.verificarJogador = 1;
		window.dispose();
		tentativasGame = 0;
		new Main();
	}

	public void verificarPartida()
	{
		for(int i = 0; i < 3; i++)
		{
			if(Main.squares[i][0].identificarSprite.equals("X"))
			if(Main.squares[i][1].identificarSprite.equals("X"))
			if(Main.squares[i][2].identificarSprite.equals("X"))
			{
				jogadorUmVencer();
				break;
			}
			
			if(Main.squares[i][0].identificarSprite.equals("O"))
			if(Main.squares[i][1].identificarSprite.equals("O"))
			if(Main.squares[i][2].identificarSprite.equals("O"))
			{
				jogadorDoisVencer();
				break;
			}	
			
			if(Main.squares[0][i].identificarSprite.equals("O"))
			if(Main.squares[1][i].identificarSprite.equals("O"))
			if(Main.squares[2][i].identificarSprite.equals("O"))
			{
				jogadorDoisVencer();
				break;
			}	
			
			if(Main.squares[0][i].identificarSprite.equals("X"))
			if(Main.squares[1][i].identificarSprite.equals("X"))
			if(Main.squares[2][i].identificarSprite.equals("X"))
			{
				jogadorUmVencer();
				break;
			}
		}
		
		if(Main.squares[0][0].identificarSprite.equals("X"))
		if(Main.squares[1][1].identificarSprite.equals("X"))
		if(Main.squares[2][2].identificarSprite.equals("X"))
		{
			jogadorUmVencer();
		}
		
		if(Main.squares[0][0].identificarSprite.equals("O"))
		if(Main.squares[1][1].identificarSprite.equals("O"))
		if(Main.squares[2][2].identificarSprite.equals("O")) 
		{
			jogadorDoisVencer();
		}
		
		if(Main.squares[0][2].identificarSprite.equals("X"))
		if(Main.squares[1][1].identificarSprite.equals("X"))
		if(Main.squares[2][0].identificarSprite.equals("X"))
		{
			jogadorUmVencer();
		}
		
		if(Main.squares[0][2].identificarSprite.equals("O"))
		if(Main.squares[1][1].identificarSprite.equals("O"))
		if(Main.squares[2][0].identificarSprite.equals("O"))
		{
			jogadorDoisVencer();
		}
	}
	
	public class Bot extends Thread {		
		public void run()
		{
			o_icon.setImage(o_icon.getImage().getScaledInstance(squares.getWidth(), squares.getHeight(), 1));
			try { Thread.sleep(1000); } catch (InterruptedException exception) {}
			Random gerador = new Random();
			int row = gerador.nextInt(3);
			int col = gerador.nextInt(3);
		
			while(Main.squares[row][col].squareUtilizado == true)
			{
				row = gerador.nextInt(3);
				col = gerador.nextInt(3);
			}
			
			Main.squares[row][col].squares.setIcon(o_icon);
			Main.squares[row][col].identificarSprite = "O";
			Main.squares[row][col].squareUtilizado = true;
			Squares.tentativasGame++;
			Main.verificarJogador--;
			Squares.botJogando = false;
			verificarPartida();
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}