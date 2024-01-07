package Interfaces;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main implements ActionListener {
	public JFrame window = new JFrame("Cadastro de Clientes");
	public JLabel label_1 = new JLabel("Nome:");
	public JTextField tfield_1 = new JTextField();
	public JLabel label_2 = new JLabel("Email:");
	public JTextField tfield_2 = new JTextField();
	public JLabel label_3 = new JLabel("CPF:");
	public JTextField tfield_3 = new JTextField();
	public JLabel label_4 = new JLabel("Data-N: ");
	public JTextField tfield_4 = new JTextField();
	public JButton send = new JButton("Enviar");
	public JButton exit = new JButton("Sair");
	
	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		window.setSize(550, 250);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setLayout(null);
		
		label_1.setBounds(30, 20, 50, 10);
		tfield_1.setBounds(80, 17, 400, 20);
		
		label_2.setBounds(30, 50, 50, 10);
		tfield_2.setBounds(80, 47, 400, 20);
		
		label_3.setBounds(30, 80, 50, 10);
		tfield_3.setBounds(80, 77, 400, 20);
		
		label_4.setBounds(30, 110, 50, 10);
		tfield_4.setBounds(80, 107, 400, 20);
		
		send.setBounds(160, 170, 100, 20);
		exit.setBounds(290, 170, 100, 20);
		
		exit.addActionListener(this);
		send.addActionListener(this);
		
		addToFrame();
		
		window.setVisible(true);
	}
	
	public void addToFrame()
	{
		window.add(exit);
		window.add(send);
		window.add(tfield_1);
		window.add(label_1);
		window.add(tfield_2);
		window.add(label_2);
		window.add(tfield_3);
		window.add(label_3);
		window.add(tfield_4);
		window.add(label_4);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
		else if(e.getSource() == send)
		{
			if(tfield_1.getText().equals("") || tfield_2.getText().equals("") || tfield_3.getText().equals("") || tfield_4.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				System.out.printf("[ CLIENTE ] Nome: %s\n", tfield_1.getText());
				System.out.printf("[ CLIENTE ] Email: %s\n", tfield_2.getText());
				System.out.printf("[ CLIENTE ] CPF: %s\n", tfield_3.getText());
				System.out.printf("[ CLIENTE ] Data de nascimento: %s\n", tfield_4.getText());
				
				System.exit(0);
			}
		}
	}
}