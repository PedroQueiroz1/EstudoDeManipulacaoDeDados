package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 * Escrever uma planilha
 */
public class ApachePoi {

	public static void main(String[] args) throws IOException {
		 
		File file = new File("C:\\Users\\pedro\\Desktop\\ProjetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo.xls");
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
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
		
		HSSFWorkbook hssfWorkBook = new HSSFWorkbook(); // Usado para escrever a planilha excel
		HSSFSheet linhasPessoa = hssfWorkBook.createSheet("Planilha de pessoas JDev Treinamento"); // Criar a planilha
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			Row linha = linhasPessoa.createRow(numeroLinha ++); // Criando a linha na planilha
			
			int celula = 0;
			
			Cell celNome = linha.createCell(celula ++); // Celula 1
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula ++); // Celula 2
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula ++); // Celula 3
			celIdade.setCellValue(p.getIdade());
		} // Termina de montar a planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkBook.write(saida); // Escreve a planilha em arquivo
		
		saida.flush();
		saida.close();
		
		System.out.println("Planilha criada!");
	}
}
