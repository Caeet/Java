package Main;

import javax.swing.JFrame;
import javax.swing.JTextField; 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.SQLException;
import java.sql.Statement; 
import java.sql.ResultSet;

public class WindowLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7883803474888262873L;
	
	public JLabel lab_user = new JLabel("Usuario:");
	public JTextField txtf_user = new JTextField();
	
	public JLabel lab_pass = new JLabel("Senha:");
	public JTextField txtf_pass = new JTextField();
	
	public JButton btn_send = new JButton("Enviar");
	public JButton btn_exit = new JButton("Sair");
	
	public JButton btn_newuser = new JButton("Nova conta");

	public WindowLogin()
	{
		setSize(470, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setComponents();
		setVisible(true);
	}
	
	public void setComponents()
	{
		lab_user.setBounds(20, 20, 50, 20);
		txtf_user.setBounds(80, 22, 350, 20);
		
		lab_pass.setBounds(20, 60, 50, 20);
		txtf_pass.setBounds(80, 62, 350, 20);
		
		btn_send.setBounds(20, 100, 200, 20);
		btn_newuser.setBounds(230, 100, 200, 20);
		
		btn_exit.setBounds(20, 130, 410, 25);
		addToFrame();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btn_exit)
		{
			System.exit(0);
		}
		else if(e.getSource() == btn_send)
		{
			if(txtf_user.getText().equals("") || txtf_pass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			}
			else {
				try {
					Statement stmnt = Conexao.connection.createStatement();
					String sql = "SELECT * FROM Usuarios WHERE Nome = '" + txtf_user.getText() + "'";
					ResultSet resultado = stmnt.executeQuery(sql);
					
					if(!resultado.next())
					{
						JOptionPane.showMessageDialog(null, "Nenhuma conta encontrada com o usuario informado");
					}
					else
					{
						if(!txtf_pass.getText().equals(resultado.getString("Senha")))
						{
							JOptionPane.showMessageDialog(null, "A senha informada é inválida");
						}
						else
						{
							dispose();
							
							JFrame window = new JFrame("Bem-vindo ao programa");
							window.setSize(500, 500);
							window.setResizable(false);
							window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							window.setLocationRelativeTo(null);
							window.setLayout(null);
							
							String text = "Seja bem-vindo(a) " + txtf_user.getText(); 
							JLabel label = new JLabel(text);
							label.setBounds(140, 210, 300, 20);
							
							window.add(label);
							window.setVisible(true);
						}
					}
				}
				catch (SQLException ex)
				{
					System.out.println("[ PROGRAMA ] Falha ao estabelecer conexão com o banco de dados!");
				}
			}
		}
		else if(e.getSource() == btn_newuser)
		{
			WindowRegister wRegister = new WindowRegister();
			wRegister.setTitle("Tela de Registro");
			dispose();
		}
	}
	
	public void addToFrame()
	{
		add(btn_newuser);
		add(lab_user);
		add(txtf_user);
		add(lab_pass);
		add(txtf_pass);
		add(btn_send);
		add(btn_exit);
	
		btn_exit.addActionListener(this);
		btn_send.addActionListener(this);
		btn_newuser.addActionListener(this);
	}
}