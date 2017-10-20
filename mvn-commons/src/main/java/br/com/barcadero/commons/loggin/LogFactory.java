package br.com.barcadero.commons.loggin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;




public class LogFactory implements ILogger{

	private static int contLinhasNaoSalvas 					= 0;
	private static final int NUM_LINHAS_DISPARA_GRAVACAO_LOG= 1;
	private static boolean gravarLogEventos 				= true;
	private static final String PREFIXO_ARQUIVO_LOG			= "LogDeEventos";
	private static final String EXTENSAO_ARQUIVO_LOG		= ".log";
	public static final String LOG_DIRECTORY				= obterCaminhoRaiz() + "logs" + File.separator;
	public static final String DEFAULT_MNEMO_SAT			= "MSF";
	public static String localLog							= "";
	private static String ulltimoLogGerado					= ""; //Guarda o valor do ultimo log gerado.
	
	public LogFactory(String realPath){
		LogFactory.localLog = realPath;
	}
	
	public static String getUlltimoLogGerado() {
		return ulltimoLogGerado;
	}

	public static void setUlltimoLogGerado(String ulltimoLogGerado) {
		LogFactory.ulltimoLogGerado = ulltimoLogGerado;
	}
	
	/**
	 * Adiciona uma informacao ao log.
	 * @param evento : O que se quer escrever no log
	 * @param mostrarHora : True - escreve a hora no log.
	 */
	private static void adicionar(String evento) {
		try {
			LogFactory.adicionar(evento, true, getFileName(), LOG_DIRECTORY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param mostrarHora
	 * @param exception
	 */
	private static void adicionar(Throwable exception) {
		StringBuilder erroGrave = null;
		String saltoLinha 		= "\n\r";
		try {
			erroGrave = new StringBuilder("***----------- ERRO GRAVE ------------***" ).append(saltoLinha);
			erroGrave.append("Causa: ").append(exception.getMessage()).append(saltoLinha);
			erroGrave.append(getStackTrace(exception.getStackTrace()));
			LogFactory.adicionar(erroGrave.toString(), true, getFileName(), LOG_DIRECTORY);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * Agora devemos utilizar esta implementacao para facilitar a reusabilidade dos scripts de log.
	 * @param evento
	 * @param mostrarHora
	 * @param fileName
	 * @param diretorio
	 */
	private static void adicionar(String evento, boolean mostrarHora, String fileName, String diretorio) {
		try {
			/**
			 * ---------------------------------------------------------------------------------
			 * Aconselhamos que seja feita uma abstracao da utilizacao de quem for utilizar,
			 * criando por exemplo um metodo adcicionar passando somente o evento e so no corpo
			 * passar o diretorio. Veja como foi utilizado na classe LogArqAtualizados.
			 * ----------------------------------------------------------------------------------
			 */
			String aux = evento;

			if (mostrarHora) {
				Calendar cal = Calendar.getInstance(TimeZone.getDefault());
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				sdf.setTimeZone(TimeZone.getDefault());
				String dateTime = "[" + sdf.format(cal.getTime()) + "] " + DEFAULT_MNEMO_SAT + " ";
				aux =  dateTime  + aux.replace("\n",  "\n" + dateTime);
			}
			if (gravarLogEventos) {
				contLinhasNaoSalvas++;
				if (contLinhasNaoSalvas == NUM_LINHAS_DISPARA_GRAVACAO_LOG) {
					contLinhasNaoSalvas = 0;
					String [] linhas = new String[NUM_LINHAS_DISPARA_GRAVACAO_LOG];
					for (int i = NUM_LINHAS_DISPARA_GRAVACAO_LOG, j = 0; i > 0; i--, j++) {
						linhas[j] = aux + "\r";
					}
					salvarLog(linhas,fileName,diretorio);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	private static void salvarLog(String [] linhasParaGravar, String fileName, String diretorio)throws  FileNotFoundException,IOException{
		String logFileName = diretorio + fileName;
		if(new File(diretorio).exists() == false){
			new File(diretorio).mkdirs();
		}
		BufferedWriter logFile = null;
		try {
			logFile = new BufferedWriter(new FileWriter(new File(logFileName), true));
			for (int i = 0; i < linhasParaGravar.length; i++) {
				logFile.write(linhasParaGravar[i]);
			}
		}catch (FileNotFoundException e) {
			throw new FileNotFoundException("Arquivo nao encontrado :" + e.getMessage());
		}catch (IOException e) {
			throw new IOException("Erro de entrada ou saida: " + e.getMessage());
		}finally{
			if(logFile != null){
				logFile.close();
			}
		}
	}
	
	/**
	 * Retorna o stacktrace completo da Excecao.
	 * @param element
	 * @return String
	 * @author Rafael Rocha
	 * @since NexgenPdv 3.0 dia 15/10/2013 as 11:02 
	 */
	private static String getStackTrace(StackTraceElement[] element) {
		String fullStackTrace = "";
		try {
			for (int i = 0; i < element.length; i++) {
				fullStackTrace += element[i].toString() + "\r\n";
			}
			return fullStackTrace;
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao obter o StackTrace da Excecao: " + e.getMessage() + " .";
		}
	}
	
	private static String getFileName() {
		String dtAtual  = "";
		String fileName = "";
		try {
			dtAtual  = obterDataOuHora("ddMMyyyy").trim();
			fileName = PREFIXO_ARQUIVO_LOG + dtAtual + EXTENSAO_ARQUIVO_LOG;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fileName;
	}
	
	/**
	 * Obtem o caminho ons a aplicacao esta sendo executada.
	 * @return
	 * @author Rafael Rocha
	 */
	private static String obterCaminhoRaiz(){
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
	 * Obtem data ou hora
	 * @param formato
	 * @return
	 * @author Rafael Rocha
	 */
	private static String obterDataOuHora(String formato) {
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(data);
	}


	public  void infor(String infor) {
		adicionar(infor);
	}
	
	public  static void addInfor(String infor) {
		adicionar(infor);
	}

	public void error(String error) {
		adicionar("ERROR --->>>> " + error);
	}

	public  static void addError(String error) {
		adicionar("ERROR --->>>> " + error);
	}
	
	public void error(Throwable throwable) {
		adicionar(throwable);
	}
	
	public static void addError(Throwable throwable) {
		adicionar(throwable);
	}
}
