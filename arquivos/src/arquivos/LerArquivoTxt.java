package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivoTxt {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Entrada de dados
		FileInputStream entradaArquivo = 
				new FileInputStream(new File(
						"C:\\Users\\pedro\\Desktop\\ProjetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo2.txt"));
	
		Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8");

		List<Pessoa> pessoas = new ArrayList<>();
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			//ignora as linhas que não tem texto
			if(linha != null && !linha.isEmpty()) {
			 
				String[] dados = linha.split("\\;");
			 
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setEmail(dados[1]);
				pessoa.setIdade(Integer.parseInt(dados[2]));
				
			 
				pessoas.add(pessoa);
			}
		}
		
		System.out.println(pessoas);
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		lerArquivo.close();
	}

}
