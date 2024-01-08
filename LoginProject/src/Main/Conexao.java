package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	public static Connection connection;
	String URL, User, Pass;
	
	public Conexao(String URL, String User, String Pass)
	{
		this.URL = URL;
		this.User = User;
		this.Pass = Pass;
		
		try {
			connection = DriverManager.getConnection(URL, User, Pass);
			
			Statement stmn = connection.createStatement();
			stmn.execute("CREATE DATABASE IF NOT EXISTS LoginProject");
			stmn.execute("CREATE TABLE IF NOT EXISTS Usuarios (Nome VARCHAR(30), Senha VARCHAR(30), ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY)");
		}
		catch (SQLException e)
		{
			System.out.println("[ PROGRAMA ] Falha ao estabelecer conexão com o banco de dados!");
		}
	}
}