package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main
{
	private static BufferedReader arquivo;

	public static void main(String[] args)
	{
		new Main();
	}
	
	public Main()
	{
		try
		{
			FileReader file = new FileReader("C:\\Users\\Guilherme Caetano\\Documents\\Meus Arquivos\\Eclipse Projetos\\JogoDaForca\\src\\main\\Palavras.txt");
			setArquivo(new BufferedReader(file));
			ArrayList<String> palavras = new ArrayList<String>();
			String linha = arquivo.readLine();
			
			while(linha != null)
			{
				palavras.add(linha);
				linha = arquivo.readLine();
			}
			
			comecarJogo(palavras);
			file.close();
		}
		catch (IOException e)
		{
			System.out.printf("[ PROGRAMA ] Erro ao localizar arquivos: %s", e.getMessage());
		}
	}
	
	public void comecarJogo(ArrayList<String> palavras)
	{
		String palavraSorteada = palavras.get(new Random().nextInt(palavras.size())), letra;		
		Scanner leitor = new Scanner(System.in);
		String palavraFormada[] = new String[palavraSorteada.length()];
		int vidas = 5;
		
		for(int i = 0; i < palavraSorteada.length(); i++)
		{
			palavraFormada[i] = "_";
		}
		
		while(vidas != 0)
		{
			String mostrarPalavra = "";
			for(int i = 0; i < palavraSorteada.length(); i++)
			{
				mostrarPalavra = String.format("%s %s", mostrarPalavra, palavraFormada[i]);
			}
			
			System.out.println("\n" + mostrarPalavra);
			System.out.printf("[ PROGRAMA ] Vidas: %d\n", vidas);
			System.out.print("[ PROGRAMA ] Informe uma letra: ");
			letra = leitor.nextLine();
			
			int acertouAlgumaLetra = 0;
			for(int i = 0; i < palavraSorteada.length(); i++)
			{
				String letraPalavra = String.format("%s", palavraSorteada.charAt(i));
				
				if(letraPalavra.equalsIgnoreCase(letra))
				{
					palavraFormada[i] = letra.toUpperCase();
					acertouAlgumaLetra = 1;
				}
				else if(acertouAlgumaLetra == 0 && i == (palavraSorteada.length()-1))
				{
					vidas--;
				}
				
				StringBuilder sb = new StringBuilder();
				for(String s : palavraFormada)
				{
					sb.append(s);
				}
				
				if(sb.toString().equalsIgnoreCase(palavraSorteada))
				{
					System.out.println("\n[ PROGRAMA ] Parabéns você acertou a palavra!!!");
					System.out.printf("[ PROGRAMA ] A palavra era: %s", palavraSorteada);
					System.exit(0);
				}
			}
			
			acertouAlgumaLetra = 0;
		}
		
		System.out.println("\n[ PROGRAMA ] Infelizmente você perdeu ! : (");
		System.out.println("[ PROGRAMA ] A palavra era: " + palavraSorteada);
		
		leitor.close();
	}

	public static BufferedReader getArquivo() {
		return arquivo;
	}

	public static void setArquivo(BufferedReader arquivo) {
		Main.arquivo = arquivo;
	}
}