package br.com.barcadero.module.sat.handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HendleFile {
	
	/**	 * Caminho onde deve ser gravado o numero de sessao do SAT-MFe*/
	public final String dirFileNumeroSessao = obterCaminhoRaiz() + "recursos" + File.separator + "arquivos" + File.separator + "sessaoSAT" + File.separator;
	/**	 * Nome do arquivo onde foi gravado o ultimo numero de sessao */
	public final String sessionFileName =  "session.txt";
	
	/**
	 * Obtem o caminho ons a aplicacao esta sendo executada.
	 * @return
	 * @author Rafael Rocha
	 */
	public static String obterCaminhoRaiz(){
		String result	= "";
		try {
			result = System.getProperty("user.dir") + File.separator ;
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * Grava a ultima sessao SAT no arquivo de texto.
	 * @throws Exception
	 */
	public void gravarUltimaSessao(long numSessao) throws Exception{
		File file 			= null;
		FileWriter writer	= null;
		PrintWriter printer	= null;
		try {
			file = new File(dirFileNumeroSessao);
			if(!file.exists()){
				file.mkdirs();
			}
			file 		= new File(dirFileNumeroSessao + sessionFileName);
			writer 		= new FileWriter(file,false);  
			printer 	= new PrintWriter(writer);
			printer.print(numSessao);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(writer  != null){writer.flush(); writer.close();}
			if(printer != null){printer.flush(); printer.close();}
		}
	}
	
	/**
	 * Obtem a ultima sessao SAT gravada no arquivo
	 * @return
	 * @throws Exception
	 */
	public String obterUltimaSessaoGravada() throws Exception{
		String line				= "";
		File file				= null;
		FileReader reader		= null;
		BufferedReader bfReader	= null;
		try {
			file = new File(dirFileNumeroSessao + sessionFileName);
			if(file.exists()){
				reader   = new FileReader(file);
				bfReader = new BufferedReader(reader);
				while ((line = bfReader.readLine()) != null) {
					return line;
				}
			}
			return line;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}finally{
			if(reader != null){
				reader.close();
			}
			if(bfReader != null){
				bfReader.close();
			}
		}
	}
	
	/**
	 * Substitui os caracteres especiais em forma UTF-8
	 * @param toTransforme
	 * @return
	 * @throws Exception
	 */
	public String transformarCaracteresEspeciais(String toTransforme) throws Exception{
		return  new String(toTransforme.getBytes(),"UTF-8");
	}
}
