package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

	public static void main(String[] args) throws IOException {
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("email@email.com");
		pessoa1.setNome("Manoel");
		pessoa1.setIdade(15);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("eeeemail@email.com");
		pessoa2.setNome("nao Manoel");
		pessoa2.setIdade(15);
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("emaaaaail@email.com");
		pessoa3.setNome("Manoel talvez");
		pessoa3.setIdade(15);
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		
		File arquivo = new File(
				"C:\\Users\\pedro\\Desktop\\projetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo2.txt");
		
		if(!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escreverNoArquivo = new FileWriter(arquivo);
		
		for(Pessoa p : pessoas) {
			escreverNoArquivo.write("\n"+p.getNome());
			escreverNoArquivo.write("\n"+p.getIdade());
			escreverNoArquivo.write("\n"+p.getEmail());
			escreverNoArquivo.write("\n------------\n");
		}

		escreverNoArquivo.flush();
		escreverNoArquivo.close();
	
	}
}
