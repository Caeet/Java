package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Main implements ActionListener {
	
	public JFrame window = new JFrame();
	
	public JPanel panel = new JPanel();
	
	public JButton resetGame = new JButton("Reiniciar Placar");
	public JButton vsComputer = new JButton("Contra o computador");
	public JButton vsUser = new JButton("Contra outro jogador");
	public JButton trocarJogada = new JButton("Trocar jogada");
	
	public static int PontosJ1 = 0;
	public static int PontosJ2 = 0;
	public static int verificarJogador = 1;
	
	public JLabel jogadorUm = new JLabel("Jogador (1): " + PontosJ1 + " pontos");
	public JLabel jogadorDois = new JLabel("Jogador (2): " + PontosJ2 + " pontos");
	public JLabel text_1 = new JLabel("TicTac");
	public JLabel text_2 = new JLabel("Toe");
	
	public static Squares[][] squares = new Squares[3][3];
	public static boolean isContraPC = false;
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		editLayout();
	}
	
	public void editLayout()
	{
		window.setSize(835, 600);
		window.setTitle("TicTacToe - Versão: 1.0.0");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setLayout(null);
		
		panel.setBounds(10, 15, 530, 530);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new GridLayout(3, 3));
		window.add(panel);
		
		for(int i = 0; i < 3; i++)
		{
			for(int a = 0; a < 3; a++)
			{
				squares[i][a] = new Squares(panel, window);
			}
		}
		
		resetGame.setBounds(560, 515, 250, 30);
		resetGame.addActionListener(this);
		window.add(resetGame);
		
		vsComputer.setBounds(560, 470, 250, 30);
		vsComputer.addActionListener(this);
		window.add(vsComputer);
		
		vsUser.setBounds(560, 425, 250, 30);
		vsUser.addActionListener(this);
		window.add(vsUser);
		
		trocarJogada.setBounds(560, 380, 250, 30);
		trocarJogada.addActionListener(this);
		window.add(trocarJogada);
		
		jogadorUm.setBounds(560, 240, 250, 30);
		jogadorUm.setFont(new Font("Sans Serif", Font.BOLD, 24));
		window.add(jogadorUm);
		
		jogadorDois.setBounds(560, 285, 250, 30);
		jogadorDois.setFont(new Font("Sans Serif", Font.BOLD, 24));
		window.add(jogadorDois);
		
		text_1.setBounds(550, 7, 270, 100);
		text_1.setFont(new Font("Sans Serif", Font.BOLD, 80));
		window.add(text_1);
		
		text_2.setBounds(600, 82, 270, 100);
		text_2.setFont(new Font("Sans Serif", Font.BOLD, 80));
		window.add(text_2);		
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == resetGame)
		{
			verificarJogador = 1;
			PontosJ1 = 0;
			PontosJ2 = 0;
			Squares.tentativasGame = 0;
			isContraPC = false;
			
			new Main();
			window.dispose();
		}
		else if(e.getSource() == vsComputer)
		{
			isContraPC = true;
		}
		else if(e.getSource() == vsUser)
		{
			if(isContraPC && !Squares.botJogando)
			{
				isContraPC = false;
			}
		}
		else if(e.getSource() == trocarJogada)
		{
			Squares.isTrocarJogadaActived = true;
		}
	}
}