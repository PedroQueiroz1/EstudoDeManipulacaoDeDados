package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*
 * Insere valores em uma nova celula da planilha
 */
public class ApachePoiEditando2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		File file = new File(
				"C:\\Users\\pedro\\Desktop\\ProjetosJava\\ManipulacaoDeDados\\EstudoDeManipulacaoDeDados\\arquivos\\src\\arquivos\\arquivo.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // Prepara a entrada do arquivo xsl excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pegando a planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) {
			Row linha = linhaIterator.next();
			
			int numeroCelulas = linha.getPhysicalNumberOfCells();
			
			Cell cell = linha.createCell(numeroCelulas);
			cell.setCellValue("5.487,20");
		}
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);
		
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}
}
