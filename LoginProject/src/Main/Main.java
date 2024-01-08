package Main;

public class Main {	
	public static void main(String[] args)
	{
		Conexao conexao = new Conexao("jdbc:mysql://localhost:3305/LoginProject", "root", "0000");
		
		WindowLogin window = new WindowLogin();
		window.setTitle("Tela de Login");
	}
}