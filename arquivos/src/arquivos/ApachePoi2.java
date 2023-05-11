package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

 /*
  * Ler a planilha
  */
public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		 
		FileInputStream entrada = new FileInputStream(new File(
				"C:\\Users\\pedro\\Desktop\\ProjetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo.xls"));
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel para ler
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a primeira planilha do arquivo excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while (linhaIterator.hasNext()) { // Enquanto tiver linha no excel
			Row linha = linhaIterator.next(); // Dados da pessoa na linha
			
			Iterator<Cell> celula = linha.iterator();
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) {
				Cell cell = celula.next();
				
				switch (cell.getColumnIndex()) {
				case 0: 
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1: 
					pessoa.setEmail(cell.getStringCellValue());
					break;
				case 2: 
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				} // Fim das celulas da linha
			}
			pessoas.add(pessoa);
		}
		entrada.close(); // Terminou de ler o arquivo excel
		
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}
	}
}
