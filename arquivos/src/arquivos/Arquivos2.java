package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos2 {

	public static void main(String[] args) throws IOException {
		
		File arquivo = new File(
				"C:\\Users\\pedro\\Desktop\\ProjetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo.txt");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escreverNoArquivo = new FileWriter(arquivo);
		
		escreverNoArquivo.write("Meu texto no arquivo");
		escreverNoArquivo.write("\nSegunda linha\n");
		
		for(int i = 1; i <= 10; i++) {
			
			escreverNoArquivo.write("Texto da minha linha " + i + "\n");
		}
		
		escreverNoArquivo.flush();
		escreverNoArquivo.close();
	}
}
