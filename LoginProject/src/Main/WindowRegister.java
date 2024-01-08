package Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowRegister extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2975610907769703433L;

	public JLabel lab_user = new JLabel("Informe um usuario:");
	public JTextField txtf_user = new JTextField();
	
	public JLabel lab_pass1 = new JLabel("Informe uma senha:");
	public JTextField txtf_pass1 = new JTextField();
	
	public JLabel lab_pass2 = new JLabel("Confirme a senha:");
	public JTextField txtf_pass2 = new JTextField();
	
	public JButton btn_send = new JButton("Cadastrar");
	public JButton btn_exit = new JButton("Sair");
	public JButton btn_back = new JButton("Voltar");
	
	public WindowRegister()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460, 340);
		setLocationRelativeTo(null);
		setLayout(null);
		setComponents();
		setVisible(true);
	}
	
	public void setComponents()
	{
		lab_user.setBounds(20, 20, 150, 20);
		txtf_user.setBounds(20, 50, 400, 20);
		lab_pass1.setBounds(20, 80, 150, 20);
		txtf_pass1.setBounds(20, 110, 400, 20);
		lab_pass2.setBounds(20, 140, 150, 20);
		txtf_pass2.setBounds(20, 170, 400, 20);
		btn_send.setBounds(20, 220, 198, 20);
		btn_back.setBounds(222, 220, 198, 20);
		btn_exit.setBounds(20, 250, 400, 30);
		addToFrame();
	}
	
	public void addToFrame()
	{
		btn_back.addActionListener(this);
		btn_exit.addActionListener(this);
		btn_send.addActionListener(this);
		
		add(lab_user);
		add(txtf_user);
		add(lab_pass1);
		add(txtf_pass1);
		add(lab_pass2);
		add(txtf_pass2);
		add(btn_send);
		add(btn_back);
		add(btn_exit);
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource() == btn_back)
		{
			WindowLogin window = new WindowLogin();
			window.setTitle("Tela de Login");
			dispose();
		}
		else if(e.getSource() == btn_exit)
		{
			System.exit(0);
		}
		else if(e.getSource() == btn_send)
		{
			if(txtf_user.getText().equals("") || txtf_pass1.getText().equals("") || txtf_pass2.getText().equals(""))
			{	
				JOptionPane.showMessageDialog(null,  "Preencha todos os campos!");
			}
			else if(!txtf_pass1.getText().equals(txtf_pass2.getText()))
			{
				JOptionPane.showMessageDialog(null, "As senhas são distintas");
			}
			else
			{			
				if(txtf_pass1.getText().length() > 30 || txtf_pass1.getText().length() < 5)
				{
					JOptionPane.showMessageDialog(null, "Informe uma senha de 5 até 30 caracteres");
				}
				else if(txtf_user.getText().length() > 30 || txtf_pass1.getText().length() < 3)
				{
					JOptionPane.showMessageDialog(null, "O nome de usuario deve ter entre 3 até 30 caracteres");
				}
				else
				{
					try {
						String sql = "INSERT INTO Usuarios (Nome, Senha) VALUES (?, ?)";
						PreparedStatement prepStat = Conexao.connection.prepareStatement(sql);
						prepStat.setString(1, txtf_user.getText());
						prepStat.setString(2, txtf_pass1.getText());
						prepStat.execute();
						
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						WindowLogin window = new WindowLogin();
						window.setTitle("Tela de Login");
						dispose();
					}
					catch(SQLException exception)
					{
						System.out.println("[ PROGRAMA ] Falha ao estabelecer conexão com o banco de dados!");
					}
				}
			}
		}
	}
}