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

public class ApachePoiEditando {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\wwwfe\\eclipse-workspace\\arquivos\\teste_xls.xls");

		FileInputStream entrada = new FileInputStream(file);

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* Prepara a entrada do arquivo xls do excel */
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0);

		Iterator<Row> linhaIterator = planilha.iterator();

		while (linhaIterator.hasNext()) { /* Enquanto tiver linha */
			Row linha = linhaIterator.next(); /* Dados da pessoa na linha */

			int numCells = linha.getPhysicalNumberOfCells(); /* Quantidade de Colunas */

			Cell cell = linha.createCell(numCells); /* Cria nova celula na linha */
			cell.setCellValue("5.487,20");
		}
		entrada.close();
		
		FileOutputStream fos = new FileOutputStream(file);
		hssfWorkbook.write(fos);
		fos.flush();
		fos.close();
		
		System.out.println("Planilha atualizada!");
	}

}
