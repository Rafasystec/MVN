package br.com.barcadero.commons.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.commons.xml.HandleXML;
import sun.misc.BASE64Decoder;
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
	public void writFile(String fileName, String filePath, String value, boolean skipLine) throws IOException {
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

	/**
	 * Grava um arquivo em base 64
	 * @param fileBase64
	 * @param filePath
	 * @param fileName
	 * @throws Exception
	 */
	public static void writFileBase64(String fileBase64, String filePath, String fileName) throws Exception
	{	
		String arquivo 				= "";
		FileWriter fileWriter 		= null;
		try
		{
			arquivo = new String(new BASE64Decoder().decodeBuffer(fileBase64), "UTF-8");	
			try	{			
				File file = new File(filePath);
				if (!file.exists())	{
					file.mkdirs();
				}
				fileWriter = new FileWriter(filePath + fileName);		
				fileWriter.write(HandleXML.normalize(arquivo));
			}finally{		
				if (fileWriter != null)	{
					fileWriter.close();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param valueBase64
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String decodeBase64(String valueBase64) throws UnsupportedEncodingException, IOException {
		return  normalize(new String(new BASE64Decoder().decodeBuffer(valueBase64), "UTF-8"));	
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String normalize(String value) {		
		return Normalizer.normalize(value, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("&amp;quot;", "&quot;").replaceAll("&amp;#39;", "&#39;");
	}
}
