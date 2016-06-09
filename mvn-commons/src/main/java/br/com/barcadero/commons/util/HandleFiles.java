package br.com.barcadero.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Manipular os arquivos da aplicação.
 * @author Rafael Rocha
 */
public class HandleFiles {
	/**
	 * Ler um arquivo e retorna uma lista de String onde cada elemento é uma linha
	 * @param fullFilePath
	 * @return
	 * @throws IOException
	 */
	public List<String> readFile(String fullFilePath) throws IOException {
		File file = new File(fullFilePath);
		if(!file.exists()){
			return new ArrayList<String>();
		}
		BufferedReader br = new BufferedReader(new FileReader(fullFilePath));
		List<String> list = new ArrayList<String>();
		try {
		    String line 		= br.readLine();
		    while (line != null) {
		        line = br.readLine();
		        list.add(line);
		    }
		} finally {
			if(br != null){br.close();}
		}
		return list;
	}
	
	/**
	 * Escreve uma linha em um determinado arquivo
	 * @param fileName: Nome do arquivo
	 * @param filePath: local do arquivo
	 * @param value : valor para escrever no arquivo
	 * @param skipLine: caso true sera feito um salto de linha, quando false sere scrito na mesma linha
	 * @throws IOException
	 */
	public void wrietFile(String fileName, String filePath, String value, boolean skipLine) throws IOException {
		File file		= new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		file				= new File(filePath + File.separator + fileName);
		FileWriter writer 	= new FileWriter(file,true);  
		PrintWriter printer = new PrintWriter(writer);
		try{
			if(skipLine){
				printer.println(value);
			}else{
				printer.print(value);
			}
		}finally{
			
			if(writer != null){
				writer.flush();
				writer.close();
			}
			
			if(printer != null){
				printer.flush();
				printer.close();
			}	
		}
	}

}
