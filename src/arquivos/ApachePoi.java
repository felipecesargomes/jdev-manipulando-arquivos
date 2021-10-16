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

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\wwwfe\\eclipse-workspace\\arquivos\\teste_xls.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(31);
		pessoa1.setNome("Felipe C�sar");
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(50);
		pessoa2.setNome("Carlos");
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(50);
		pessoa3.setNome("Tadeu");

		List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		listaPessoa.add(pessoa1);
		listaPessoa.add(pessoa2);
		listaPessoa.add(pessoa3);
		
		/* Vai ser usado para escrever a planilha */
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		/* Criar planilha */
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas JDEV Treinamento");
		
		int numeroLinha = 0;
		for(Pessoa p : listaPessoa) {
			Row linha = linhasPessoa.createRow(numeroLinha++);
		
			int celula = 0;
			
			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);
			celIdade.setCellValue(p.getIdade());
		}/* Termina de montar a planilha */
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida); /* Escreve a planilha em arquivo */
		saida.flush();
		saida.close();
		System.out.println("Planilha foi criada!");
	}

}
