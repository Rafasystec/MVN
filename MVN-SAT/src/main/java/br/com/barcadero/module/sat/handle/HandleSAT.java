package br.com.barcadero.module.sat.handle;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.commons.loggin.LoggerFile;
import br.com.barcadero.commons.util.HandleFiles;
import br.com.barcadero.module.sat.devices.bematech.SATBematech;
import br.com.barcadero.module.sat.devices.compsis.MFeCompsis;
import br.com.barcadero.module.sat.devices.dimep.SATDimep;
import br.com.barcadero.module.sat.devices.emulador.SATEmulador;
//import br.com.secrel.sat.logs.LogFactory;
//import br.com.secrel.sat.properties.ConfigSat;
import br.com.barcadero.module.sat.devices.tanca.ts1000.SATTanca;
import br.com.barcadero.module.sat.enums.EnumModulosSAT;
import br.com.barcadero.module.sat.exceptions.SATException;
//import br.com.secrel.sat.util.FileHelper;



/**
 * Classe para comunicacao com os modulos SAT-MFe
 * @author Rafael Rocha
 * @since SAT-MFe vers�o beta dia 29/01/2015 09:00
 */
public class HandleSAT 
{

	private InterfaceSAT iSatMfe				= null;
	private AbstractSATSuperClass aSatMfe				= null;
	private static String charSeparator = "|";
	private static String patternPipe	= Pattern.quote("|");
	private static Integer timeout 		= 10000;
	private static Integer numberOfRetry = 3;
	
	//------------------------------------------------
	//NOTE: Funcoes do modulo SAT-MFe
	//------------------------------------------------
	public static final int FUNC_ATIVAR_SAT_MFE 	= 1;
	public static final int FUNC_COMUNICAR_ICPB		= 2;
	public static final int FUNC_CONSULTAR_SAT_MFE	= 3;
	public static final int FUNC_TESTE_FIM_A_FIM	= 4;
	public static final int FUNC_CONSULTA_STATUS	= 5;
	public static final int FUNC_CONSULTA_SESSAO	= 6;
	public static final int FUNC_CONFIGURAR_REDE	= 7;
	public static final int FUNC_ASSOCIAR_ASSINATURA= 8;
	public static final int FUNC_ATUALIZAR_SAT		= 9;
	public static final int FUNC_EXTRAIR_LOGS		= 10;
	public static final int FUNC_BLOQUEAR_SAT_MFE	= 11;
	public static final int FUNC_DESBLOQUEAR_SAT_MFE= 12;
	public static final int FUNC_TROCAR_COD_ATIVACAO= 13;
	public static final int FUNC_CONFIG_ON_PDV		= 14;
	public static final int FUNC_OBTER_ULT_SESSAO	= 15;
	public static final int FUNC_OBTER_COD_ATIVACAO = 16;
	public static final int FUNC_TP_MODULO_EM_OPERAC= 17;
	public static final int FUNC_OBTER_CONFIGURACOES= 18;
	public static final int FUNC_REENVIAR_CF_SAT	= 19;
	//---------------------------------------------------
	public static final String SAT					= "SAT";
	public static final String MFE					= "MFE";
	static Logger log = LoggerFile.getLogForSAT(HandleSAT.class);

public static String getCharSeparator() {
	return charSeparator;
}

public static void setCharSeparator(String charSeparator) {
	HandleSAT.charSeparator = charSeparator;
}

public static String getPatternPipe() {
	return patternPipe;
}

/**
 * Construtor padrao para a RulHelperSat
 */
public HandleSAT() {
	
}

public HandleSAT(EnumTipoModuloSAT typeModule) {
	try {
		definirModulo(typeModule);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * Construtor apenas para realizar teste das funcionalidades nao SAT.
 * @param isOnlyForTest
 */
public HandleSAT(boolean isOnlyForTest) {
	
}

/**
 * Abrir a porta do Modulo
 * @param canal
 * @return
 * @throws Exception
 * @author Rafael Rocha
 */
public int openPort(int canal) throws Exception
{
	try {
		return this.iSatMfe.openPort(canal);
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Fechar porta de comunicacao com o Modulo
 * @throws Exception
 */
public  void closePort() throws Exception
{
	this.iSatMfe.closePort();
}



/**
 * Ativar o modulo SAT-MFe
 * @param subComando
 * @param cnpj
 * @param cUF
 * @return
 * @throws Exception
 * @throws SATException
 */
public String ativarSat(int subComando, String cnpj, int cUF) throws Exception, SATException
{
	int numeroSessao			= 0;
	String retorno 				= "";
	Thread thread  				= null;
	String codAtivacao			= "";
	try {
		numeroSessao = getNumeroSessao();
		thread  	 = iniciarTimeout(timeout);
		retorno 	 = this.iSatMfe.AtivarSAT(numeroSessao, subComando, codAtivacao, cnpj, cUF);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (Exception e) {
		throw e;
	}	
}


/**
 * Esta função faz parte do processo de envio dos dados de venda do AC para o Equipamento
 * SAT.
 * @param dadosVenda :
 * <p>Os campos obrigat�rios, bem como os tamanhos e formatos de cada um, devem seguir a</p>
 * <p>especificação do leiaute do arquivo de venda <strong>(vide Cap�tulo 4)</strong>. O AC deverão enviar os</p>
 * <p>dados em formato XML com suas respectivas tags.</p>
 * @return
 * @throws Exception
 * @author Rafael Rocha
 */
@Deprecated
public String enviarDadosVenda(String dadosVenda) throws Exception
{
	String retorno	 = "";
	int numeroSessao = 0;
	int retry        = 1;
	Thread thread	 = null;
	String codAtivacao="";
	try {
		numeroSessao = getNumeroSessao();	
		while (retry <= numberOfRetry) {
			thread 		 = iniciarTimeout(2000);
			retorno 	 = this.iSatMfe.EnviarDadosVenda(numeroSessao, codAtivacao, dadosVenda);
			if (!verificarTimeout(thread)) {
				try {					
					consultarNumeroSessao();
					break;
				} catch (SATException mfe) {								
					if (retry == numberOfRetry) {
						throw new SATException("N�mero de tentativas excedido - M�dulo n�o Responde");
					}					
					retry++;
					numeroSessao = getNumeroSessao();
				}						
			} else {
				break;
			}
		}
		verificarRetorno(retorno, thread);
		retorno = tratarRetornoCaracteresEspeciais(retorno);
		return retorno;
	} catch (Exception e) {
		
		throw e;
	}
	
}

/**
 * Enviar dados da venda para o SAT
 * @param dadosVenda
 * @param codigoAtivacao
 * @return
 * @throws Exception
 */
public String enviarDadosVenda(String dadosVenda, String codigoAtivacao) throws Exception{
	String retorno	 = "";
	int numeroSessao = 0;
	Thread thread	 = null;
	numeroSessao = getNumeroSessao();
	thread 		 = iniciarTimeout(2000);
	retorno 	 = this.iSatMfe.EnviarDadosVenda(numeroSessao, codigoAtivacao, dadosVenda);	
	verificarRetorno(retorno, thread);
	retorno = tratarRetornoCaracteresEspeciais(retorno);	
	return retorno;
	
}



/**
 * Pede para que o modulo SAT realize a atualizacao
 * @return
 * @throws Exception
 * @author Rafael Rocha
 */
public String atualizarSoftware() throws Exception
{
	int numeroSessao	= 0;
	String retorno		= "";
	Thread thread		= null;  
	String codAtivacao  = "";
	try {
		numeroSessao = getNumeroSessao();
		thread 		 = iniciarTimeout(1802000);		
		retorno 	 = this.iSatMfe.AtualizarSoftwareSAT(numeroSessao, codAtivacao);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (Exception e) {
		throw e;
	}
	
}

 
/**
 * O Aplicativo Comercial poderá extrair os arquivos de registro do Equipamento SAT por meio
 * da função ExtrairLogs.
 * @return
 * @throws Exception
 * @author Rafael Rocha
 */
public String extrairLogs() throws Exception {
	 int numeroSessao	= 0;
	 String codAtivacao	= ""; 
	 String retorno		= "";
	 Thread thread		= null;
	 try {
		numeroSessao	= getNumeroSessao();
		codAtivacao		= "";
		thread 			= iniciarTimeout(22000); // 20s + 2s de guarda	
	 	retorno 		= this.iSatMfe.ExtrairLogs(numeroSessao, codAtivacao);
	 	verificarRetorno(retorno, thread);
	 	return retorno;
	} catch (Exception e) {
		throw e;
	}
 	
}

 
 /**
  * Consultar os status do Modulo
  * @param numeroSessaoVenda
  * @param codigoDeAtivacao
  * @return
  * @throws Exception
  */
 public String consultarStatusOperacional() throws Exception, SATException{
	int numeroSessao		= 0;
	String codAtivacao		= "";
	String retorno			= "";
 	Thread thread 			= null;
 	try {
 		numeroSessao 	= getNumeroSessao();
 		thread 			= iniciarTimeout(4000);
 		retorno 		= this.iSatMfe.ConsultarStatusOperacional(numeroSessao, codAtivacao);
 		verificarRetorno(retorno, thread);
 		return retorno;
 	}catch (SATException e) {	
 		throw e;
 	} catch (Exception e) {
 		throw e;
 	}
 }


/**
 * Esta funcao consiste em um teste de comunicacao entre o AC, o Equipamento SAT e a
 * SEFAZ.
 * @param dadosVenda : Os campos obrigatorios, bem como os tamanhos e formatos de cada um, devem seguir a
 * especificaçãoo do leiaute do arquivo de venda
 * @return
 * @throws Exception
 * @throws SATException
 * @author Rafael Rocha
 */
 public String executarTesteFimAFim(String dadosVenda) throws Exception, SATException{
		int numeroSessao	= 0;
		String codAtivacao	= "";
	 	String retorno		= "";
		Thread thread 		= null;
		try {
			numeroSessao	= getNumeroSessao();
			thread 			= iniciarTimeout(22000);
			retorno 		= this.iSatMfe.TesteFimAFim(numeroSessao, codAtivacao, dadosVenda);
			verificarRetorno(retorno, thread);
			return retorno;
		} catch (SATException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
	}

/**
 * Esta funcao é usada para testes de comunicacao entre o AC e o Equipamento SAT.
 * @param numeroSessaoVenda
 * @return
 * @throws Exception
 * @throws SATException
 * @author Rafael Rocha
 */
public String consultarSAT() throws Exception, SATException {
	int numeroSessao = 0;
	String retorno 	 = "";
	Thread thread	 = null;
	try {
		numeroSessao = getNumeroSessao();
		thread 		 = iniciarTimeout(4000);
		retorno 	 = this.iSatMfe.ConsultarSAT(numeroSessao);	
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
}


/**
 * <p>O AC poderá verificar se a última sessão requisitada foi processada em caso de não
 * recebimento do retorno da operação. O equipamento SAT-CF-e retornará exatamente o
 * resultado da sessão consultada.</p>
 * @param cNumeroDeSessao
 * @return
 * @throws Exception
 */
public String consultarNumeroSessao() throws Exception{	
	int numeroSessao 	= 0;
	int ultNumeroSessao = 0;
	String codiAtivacao	= "";
	String retorno 		= "";
	Thread thread 		= null;
	try {
		numeroSessao 	= getNumeroSessao();
		thread 		 	= iniciarTimeout(2200);
		retorno 	 	= this.iSatMfe.ConsultarNumeroSessao(numeroSessao, codiAtivacao, ultNumeroSessao);
		verificarRetorno(retorno, thread);
		return retorno;
	}catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
}


/**
 * Bloquear modulo SAT-MFe
 * @return
 * @throws Exception
 * @throws SATException
 * @author antoniorafael
 */
public String bloquearSAT() throws Exception, SATException{
	int numeroSessao		= 0;
	String codAtivacao = "";
	String retorno			= "";
	Thread thread			= null;
	try {
		numeroSessao = getNumeroSessao();
		thread  	 = iniciarTimeout(302000);
		retorno = this.iSatMfe.BloquearSAT(numeroSessao, codAtivacao);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
	
}


/**
 * O Aplicativo Comercial ou outro software fornecido pelo Fabricante poder� realizar o
 * desbloqueio operacional do Equipamento SAT.
 * @return
 * @throws Exception
 * @throws SATException
 */
public String desbloquearSAT() throws Exception, SATException {
	int numeroSessao	= 0;
	String codAtivacao	= "";
	String retorno 		= "";
	Thread thread		= null;
	try {
		numeroSessao	= getNumeroSessao();
		thread 			= iniciarTimeout(22000);
		retorno			= this.iSatMfe.DesbloquearSAT(numeroSessao, codAtivacao);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
	
}


/**
 * O Aplicativo Comercial ou outro software fornecido pelo Fabricante poderá realizar a troca
 * do código de ativação a qualquer momento.
 * @param opcao :<p> Refere-se a opção do conteúdo do parâmetro 'codigoDeAtivacao'</p>
 * <p>sendo:</p>
 * <ul>
 * 		<li>1 - Código de Ativação</li>
 * 		<li>2 - Código de Ativação de Emergência </li>
 * </ul>
 * @param novoCodigo 		: Novo codigo de Ativacao
 * @param confNovoCodigo	: Confirmacao do novo codigo de ativacao
 * @return
 * @throws Exception
 * @throws SATException
 */
public String trocarCodigoDeAtivacao(int opcao, String novoCodigo, String confNovoCodigo) throws Exception, SATException
{
	int numeroSessao	= 0;
	String codAtivacao	= "";
	String retorno		= "";
	Thread thread		= null; 
	try {
		numeroSessao = getNumeroSessao();
		thread  	 = iniciarTimeout(22000);
		retorno 	 = this.iSatMfe.TrocarCodigoDeAtivacao(numeroSessao, codAtivacao, opcao, novoCodigo, confNovoCodigo);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Trata o retorno vindo do modulo SAT-MFe
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoAtivacaoSat(String pRetorno) throws Exception{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno))	{
			camposRetorno = ajustarRetorno(pRetorno);
			retornoSatVO  = tratarRetornoSat(camposRetorno);
			if (camposRetorno.length > 5){
				retornoSatVO.setCSR(ajustarCampoRetorno(camposRetorno, 5));
			}		
		}	
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Tratar retorno teste Fim-a-Fim
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoTesteFimAFim(String pRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno))	{		
			camposRetorno 	= ajustarRetorno(pRetorno);
			retornoSatVO 	= tratarRetornoSat(camposRetorno);
			if (camposRetorno.length > 5){			
				retornoSatVO.setArquivoCFeSAT(ajustarCampoRetorno(camposRetorno, 5));
				retornoSatVO.setTimeStamp(ajustarCampoRetorno(camposRetorno, 6));
				retornoSatVO.setNumDocFiscal(ajustarCampoRetorno(camposRetorno, 7));
				retornoSatVO.setChaveDeConsulta(ajustarCampoRetorno(camposRetorno, 8));
			}		
		}	
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Extrair o log vindo do retorno do modulo SAT-MFe
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoExtracaoLogs(String pRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno))	{		
			camposRetorno = ajustarRetorno(pRetorno);
			retornoSatVO  = tratarRetornoSat(camposRetorno);
			if (camposRetorno.length > 5)	{
				//--------------------------------------------------------------------------------------------------------------------
				// Arquivo de log em base64:
				// datahora|processo|erro/info|detalhamento
				// - datahora:  o carimbo de tempo no formato: AAAAMMDDhhmmss
				// - processo:  o autor ou os autores do processo, podendo ser: AC-SAT / SAT /  SAT-AC / SAT-SEFAZ / SEFAZ-SAT
				// - erro/info:  o tipo de log: "erro" significa erro de processo e "info" significa informa��o sobre o processo;
				// - detalhamento:  a descrição detalhada da ocorrência do processo.
				// - Exemplo: AAAAMMDDhhmmss|SAT-SEFAZ|erro|erro ao tentar transmitir lote para a SEFAZ
				//--------------------------------------------------------------------------------------------------------------------
				HandleLogSAT logSatVO 				= new HandleLogSAT();
				ArrayList<HandleLogSAT> logsSatVO 	= new ArrayList<HandleLogSAT>();
				String arquivoLog64 				= ajustarCampoRetorno(camposRetorno, 5);
				//String arquivoLog 				= new String(new BASE64Decoder().decodeBuffer(arquivoLog64), "UTF-8");
				String arquivoLog 					= HandleFiles.decodeBase64(arquivoLog64);
				String linhaArquivoLogSplitted[]= null;
				for (String linhaArquivoLog : arquivoLog.split("\n"))
				{
					linhaArquivoLogSplitted = linhaArquivoLog.replaceAll("\\r","").replaceAll("\\n","").replaceAll("\\t","").split("\\|");
					if(linhaArquivoLogSplitted != null && linhaArquivoLogSplitted.length > 3){				
						logSatVO.setDataHora(linhaArquivoLogSplitted[0]);
						logSatVO.setProcesso(linhaArquivoLogSplitted[1]);
						logSatVO.setErroInfo(linhaArquivoLogSplitted[2]);
						logSatVO.setDetalhamento(linhaArquivoLogSplitted[3]);
						
					}else{
						logSatVO.setDetalhamento(linhaArquivoLogSplitted[0]);
					}
					logsSatVO.add(logSatVO);
				}
				retornoSatVO.setLogsSatVO(logsSatVO);
			}
		}	
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Tratar o retorno quando vem a resposta de uma venda.
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoVenda(String pRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno)){
			retornoSatVO 	= new HandleRetornoSAT();
			camposRetorno 	= ajustarRetorno(pRetorno);
			// numeroSessao|EEEEE|CCCC|mensagem|cod|mensagemSEFAZ
			retornoSatVO.setNumeroSessao(ajustarCampoRetorno(camposRetorno, 0));
			retornoSatVO.setCodigoRetorno1(ajustarCampoRetorno(camposRetorno, 1));
			retornoSatVO.setCodigoRetorno2(ajustarCampoRetorno(camposRetorno, 2));
			retornoSatVO.setMensagem(ajustarCampoRetorno(camposRetorno, 3));
			retornoSatVO.setCod(ajustarCampoRetorno(camposRetorno, 4));
			retornoSatVO.setMensagemSEFAZ(ajustarCampoRetorno(camposRetorno, 5));
			if (camposRetorno.length > 6)	{
				// numeroSessao|EEEEE|CCCC|mensagem|cod|mensagemSEFAZ|arquivoCFeBase64|timeStamp|chaveConsulta|valorTotalCFe|CPFCNPJValue|assinaturaQRCODE
				retornoSatVO.setArquivoCFeSAT(ajustarCampoRetorno(camposRetorno, 6));			
				retornoSatVO.setTimeStamp(ajustarCampoRetorno(camposRetorno, 7));
				retornoSatVO.setChaveDeConsulta(ajustarCampoRetorno(camposRetorno, 8));			
				retornoSatVO.setValorTotaldoCupom(ajustarCampoRetorno(camposRetorno, 9));
				retornoSatVO.setDigestValue(ajustarCampoRetorno(camposRetorno, 10));
				retornoSatVO.setSignatureValue(ajustarCampoRetorno(camposRetorno, 11));				
			}
		}
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}
/**
 * Trata o retorno de status do Modulo SAT-MFe
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoStatusOperacional(String pRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno))	{
			// numeroSessao|EEEEE|mensagem|cod|mensagemSEFAZ
			camposRetorno = ajustarRetorno(pRetorno);
			retornoSatVO = tratarRetornoSat(camposRetorno);
			if (camposRetorno.length > 5){			
				// numeroSessao|EEEEE|mensagem|cod|mensagemSEFAZ|camposRetorno			
				retornoSatVO.setNSerie(ajustarCampoRetorno(camposRetorno, 5));
				retornoSatVO.setTipoLan(ajustarCampoRetorno(camposRetorno, 6 ));
				retornoSatVO.setLanIP(ajustarCampoRetorno(camposRetorno, 7));
				retornoSatVO.setLanMAC(ajustarCampoRetorno(camposRetorno, 8));
				retornoSatVO.setLanMask(ajustarCampoRetorno(camposRetorno, 9));
				retornoSatVO.setLanGateway(ajustarCampoRetorno(camposRetorno, 10));
				retornoSatVO.setLanDNS1(ajustarCampoRetorno(camposRetorno, 11));
				retornoSatVO.setLanDNS2(ajustarCampoRetorno(camposRetorno, 12));
				retornoSatVO.setStatusLan(ajustarCampoRetorno(camposRetorno, 13));
				retornoSatVO.setNivelBateria(ajustarCampoRetorno(camposRetorno, 14));
				retornoSatVO.setMtTotal(ajustarCampoRetorno(camposRetorno, 15));
				retornoSatVO.setMtUsada(ajustarCampoRetorno(camposRetorno, 16));
				retornoSatVO.setDhAtual(ajustarCampoRetorno(camposRetorno, 17));
				retornoSatVO.setVersaoSB(ajustarCampoRetorno(camposRetorno, 18));
				retornoSatVO.setVersaoLayout(ajustarCampoRetorno(camposRetorno, 19));
				retornoSatVO.setUltimoCFeSat(ajustarCampoRetorno(camposRetorno, 20));
				retornoSatVO.setListaInicial(ajustarCampoRetorno(camposRetorno, 21));
				retornoSatVO.setListaFinal(ajustarCampoRetorno(camposRetorno, 22));
				retornoSatVO.setDhCFe(ajustarCampoRetorno(camposRetorno, 23));
				retornoSatVO.setDhUltima(ajustarCampoRetorno(camposRetorno, 24));
				retornoSatVO.setCertificadoEmissao(ajustarCampoRetorno(camposRetorno, 25));
				retornoSatVO.setCertificadoVencimento(ajustarCampoRetorno(camposRetorno, 26));
				retornoSatVO.setEstadoOperacao(ajustarCampoRetorno(camposRetorno, 27));
			}		
		}	
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Trata o retorno da consulta do ao Modulo SAT-MFe
 * @param pRetorno
 * @return
 * @throws Exception
 */
public static HandleRetornoSAT tratarRetornoConsultaSat(String pRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO 	= null;
		String[] camposRetorno 		= null;
		if (temCamposRetorno(pRetorno))	{
			camposRetorno = ajustarRetorno(pRetorno);
			// numeroSessao|EEEEE|mensagem|cod|mensagemSEFAZ							
			return tratarRetornoSat(camposRetorno);
		}	
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Trata os retornos do Modulo SAT-MFe de forma Geral.
 * @param pCamposRetorno
 * @return
 * @throws Exception
 */
private static HandleRetornoSAT tratarRetornoSat(String[] pCamposRetorno) throws Exception
{	
	try {
		HandleRetornoSAT retornoSatVO = new HandleRetornoSAT();
		// numeroSessao|EEEEE|mensagem|cod|mensagemSEFAZ
		retornoSatVO.setNumeroSessao(ajustarCampoRetorno(pCamposRetorno, 0));
		retornoSatVO.setCodigoRetorno1(ajustarCampoRetorno(pCamposRetorno, 1));
		retornoSatVO.setMensagem(ajustarCampoRetorno(pCamposRetorno, 2));
		retornoSatVO.setCod(ajustarCampoRetorno(pCamposRetorno, 3));
		retornoSatVO.setMensagemSEFAZ(ajustarCampoRetorno(pCamposRetorno, 4));
		return retornoSatVO;
	} catch (Exception e) {
		throw e;
	}
}
/**
 * Ajusta o retorno para ser tratado
 * @param pRetorno
 * @return
 * @throws Exception
 */
private static String[] ajustarRetorno(String pRetorno) throws Exception
{
	return pRetorno.replace("|", " | ").split("\\" + charSeparator);
}

/**
 * Ajusta os campos de retorno
 * @param pCampoRetorno
 * @param pIndex
 * @return
 */
private static String ajustarCampoRetorno(String[] pCampoRetorno, Integer pIndex)
{
	return ( pCampoRetorno.length >= (pIndex + 1) ) ? pCampoRetorno[pIndex].trim() : "";
}
/**
 * Verifica se tem campos para o retorno
 * @param pRetorno
 * @return
 * @throws Exception
 */
private static boolean temCamposRetorno(String pRetorno) throws Exception
{
	if (pRetorno != null) 
	{
		if (pRetorno.trim().length() > 0 && pRetorno.indexOf(charSeparator) > -1)
		{
			return true;
		}
	}
	return false;
}
/**
 * Iniciar time-out para as respostas do Modulo
 * @param pTimeOut
 * @return
 */
private static Thread iniciarTimeout(final Integer pTimeOut) throws SATException
{
	Thread t = null;
	try {
		t = new Thread(){
		    public void run() {
		        try {
		            Thread.sleep(pTimeOut);
					if (!verificarTimeout(this)){
						throw new RuntimeException("Tempo excedido - MFE n�o Responde");
					}
		        }catch (InterruptedException e) {
		        	
		        }catch (RuntimeException e) {
		        	throw e;
				}
		    }
		};
		t.start();
	}catch(RuntimeException e){
		System.out.println("Lancar exce��o de tempo esgotado.");
		throw e;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return t;
}

private static void finalizarTimeout(Thread t)
{
	try	{
		if (!t.isInterrupted())	{
			throw new InterruptedException();
		}
	}catch (InterruptedException e)	{
		//e.printStackTrace();
	}
}

private static boolean verificarTimeout(Thread t)
{
	try {
		finalizarTimeout(t);
		if (t.getUncaughtExceptionHandler() == null){
			return false;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return true;
}

/**
 * Obtem o numero da sessao utilizado para comunicacao com o Modulo MFe.
 * Numero aleatorio de 6 posicoes.
 * @return
 */
public Integer getNumeroSessao()throws Exception{
	Integer numeroAleatorio = null;
	
	try {
		numeroAleatorio = new BigDecimal(Math.random()*10).intValue();
		if (numeroAleatorio == 0){
			return getNumeroSessao();
		}
		numeroAleatorio = new BigDecimal(numeroAleatorio*Math.pow(10, 5)).add(new BigDecimal(Math.random()*Math.pow(10, 5))).intValue();
		//guardarNumeroSessao(numeroAleatorio);
		return numeroAleatorio;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Cancela o ultimo cupom transmitido desde que o tempo de sua emissao n�o tenha ultrapassado 30 minutos.
 * @param chave
 * @param dadosCancelamento
 * @return
 * @throws Exception
 * @author Rafael Rocha
 */
public String cancelarUltimaVenda(String chave, String codigoAtivacao, String dadosCancelamento) throws Exception
{
	int numeroSessao	= 0;
	Thread thread  		= null;	
	String retorno		= "";
	int retry      		= 1;
	try {
		while (retry <= numberOfRetry) {
			numeroSessao = getNumeroSessao();
			thread  = iniciarTimeout(3000);
			retorno = this.iSatMfe.CancelarUltimaVenda(numeroSessao, codigoAtivacao, chave, dadosCancelamento);
			if (!verificarTimeout(thread)) {
				try {					
					consultarNumeroSessao();
					break;
				} catch (SATException mfe) {								
					if (retry == numberOfRetry) {
						String msg = "Número de tentativas excedido - Módulo não Responde";
						throw new SATException(msg);
					}					
					retry++;
					numeroSessao = getNumeroSessao();
				}						
			} else {
				break;
			}
		}
		verificarRetorno(retorno, thread);
		retorno = ajustarRetornoSatMfe(retorno);
		return retorno;
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}	
}


/**
 * Definir qual a classe que sera utilizada.
 * @param classe
 * @param porta
 * @throws Exception
 * @author Rafael Rocha
 */
@Deprecated
public void definirSatByClasse(String classe, String porta) throws Exception{
	try {
		classe = classe.trim();
		if(classe.equalsIgnoreCase(EnumModulosSAT.COMPSIS.getClassName())){
			configurarCompsis(porta);
		}else if(classe.equalsIgnoreCase(EnumModulosSAT.EMULADOR.getClassName())){
			configurarEmulador(porta);
		}else if(classe.equalsIgnoreCase(EnumModulosSAT.DIMEP.getClassName())){
			configurarDimep(porta);
		}else if(classe.equalsIgnoreCase(EnumModulosSAT.TANCA.getClassName())){
			configurarTancaTs1000(porta);
		}else if(classe.equalsIgnoreCase(EnumModulosSAT.BEMATECH.getClassName())){
			configurarBematechRB1000(porta);
		}else{
			log.info("Op��o de classe inv�lida >>> " + classe);
		}
		if(this.iSatMfe != null){
			log.info(this.iSatMfe.toString());
		}else{
			log.info("N�o foi poss�vel Classe: " + classe);
		}
		
	} catch (Exception e) {
		throw e;
	}
}
/**
 * 
 * @param typeMode
 * @throws Exception
 */
public void definirModulo(EnumTipoModuloSAT typeMode) throws Exception {
	switch (typeMode) {
	case BEMATECH:
		configurarBematechRB1000("");
		break;
	case DIMEP:
		configurarDimep("");
		break;
	case TANCA:
		configurarTancaTs1000("");
		break;
	default:
		configurarEmulador("");
		break;
	}
}

/**
 * Configurar o modulo para o MFe da compsis
 * @param porta
 * @throws Exception
 */
private void configurarCompsis(String porta) throws Exception{
	MFeCompsis satCompsis = null;
	try {
		satCompsis	 = new MFeCompsis(porta);
		this.iSatMfe = satCompsis;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Configurar para utilizar o emulador offiline da SEFAZ-SP
 * @param porta
 * @throws Exception
 */
private void configurarDimep(String porta) throws Exception{
	SATDimep satDimep = null;
	try {
		satDimep = new SATDimep("");
		this.iSatMfe = satDimep;
		this.aSatMfe = satDimep;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Configurar para o modulo SAT Simulador OFFLINE SEFAZ-SP
 * @param porta
 * @throws Exception
 */
private void configurarEmulador(String porta) throws Exception{
	SATEmulador satEmulador = null;
	try {
		satEmulador	 = new SATEmulador("");
		this.iSatMfe = satEmulador;
		this.aSatMfe = satEmulador;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Configurar SAT Tanca TS-1000
 * @param porta
 * @throws Exception
 */
private void configurarTancaTs1000(String porta) throws Exception{
	SATTanca satTanca = null;
	try {
		satTanca 	 = new SATTanca(porta);
		this.iSatMfe = satTanca;
		this.aSatMfe = satTanca;
	} catch (Exception e) {
		e.printStackTrace();
	}
}


private void configurarBematechRB1000(String porta) throws Exception{
	SATBematech satBema = null;
	try {
		satBema 	 = new SATBematech(porta);
		this.iSatMfe = satBema;
		this.aSatMfe = satBema;
	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Obtem data ou hora
 * @param formato
 * @return
 * @author Rafael Rocha
 */
public static String obterDataOuHora(String formato) {
	Date data = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat(formato);
	return sdf.format(data);
}

/**
 * Retorna o nome do modulo passando o codigo.
 * @param codigo
 * @return
 * @throws Exception
 */
public String getModuleNameByCodigo(String codigo) throws Exception{
	String moduleName = "";
	String codMudule  = "";
	try {
		for(EnumModulosSAT element : EnumModulosSAT.values()){
			moduleName 	= element.getModuleName().trim();
			codMudule	= String.valueOf(element.getCodModule());
			if(codigo.equals(codMudule)){
				break;
			}
		}
		return moduleName;
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Obtem o tipo de modulo que esta em operacao, se e SAT ou MFe
 * @return
 */
public String getTipoDeModuloEmOperacao() {
	String retorno = "";
	try {
		if(this.iSatMfe != null){
			retorno = this.iSatMfe.TipoDoModulo();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return retorno;
}

/**
 * Obtem a versao do XML.
 * @return
 */
public String getVersaoXML(){
	String tpModulo = "";
	String retorno	= "";
	try {
		tpModulo	= getTipoDeModuloEmOperacao();
		if(tpModulo.equalsIgnoreCase(MFE)){
			retorno = "0.02";
		}else {
			retorno = "0.06";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return retorno;
}

/**
 * Retira os caracteres especiais de uma String substituindo-as pelo seu valor em UTF-8.
 * @param value
 * @return
 */
private String tratarRetornoCaracteresEspeciais(String value) {
	String retorno 		= "";
	HendleFile flHelper = null;
	try {
		flHelper = new HendleFile();
		retorno = flHelper.transformarCaracteresEspeciais(value);
	} catch (Exception e) {
		e.printStackTrace();
		retorno = value;
	}
	return retorno;
}

/**
 * Retira os caracteres especiais
 * @param paraAjustar
 * @return
 */
private String ajustarRetornoSatMfe(String paraAjustar) {
	HendleFile helper = new HendleFile();
	try {
		return helper.transformarCaracteresEspeciais(paraAjustar);
	} catch (Exception e) {
		e.printStackTrace();
		return paraAjustar;
	}
}

/**
 * Verifica se o retorno foi OK, caso nao, retorno uma excecao.
 * @param retorno
 * @param timeout
 * @return
 * @throws SATException
 */
private String verificarRetorno(String retorno, Thread timeout) throws SATException{
	String[] campos = null;
	if (!verificarTimeout(timeout)){
		throw new SATException(this.aSatMfe.getMsgDefaulTimout());
	}
	if (retorno.isEmpty()) {
		throw new SATException(this.aSatMfe.getMsgNaoResponde());
	}
	campos = retorno.split(getPatternPipe());
	if(campos == null || campos.length == 1){
		throw new SATException("Erro: " + retorno);
	}
	return retorno;
}

/**
 * Trata o retorno de Erro do modulo SAT-MFe. Deve ser colocada nas paginas que podem receber uma MFeException.
 * @param mfeException
 * @return
 * @throws Exception
 */
public String tratarMFeException(SATException mfeException) throws Exception{
	StringBuilder retorno 	= null;
	HandleRetornoSAT sat		= null;
	try {
		sat 	= mfeException.getRetornoSatVO();
		retorno	= new StringBuilder("Erro: ");
		if(sat != null){
			retorno.append(sat.getCodigoRetorno1()).append(" - ").append(sat.getMensagem());
			retorno.append(" - ").append(sat.getCod());
		}else{
			retorno.append(mfeException.getMsg());
		}
		return retorno.toString();
	} catch (Exception e) {
		return e.getMessage();
	}
}

/**
 * Verifica se a ultima sessao foi uma venda e se deu ok. Se voltar vazio eh porque nao foi uma venda ou a venda nao foi ok.
 * @return
 * @throws Exception
 */
public String verificarSeVendaFoiOK()throws Exception {
	String retorno 	= "";
	String values[]	= null;
	try {
		retorno = consultarNumeroSessao();
		if(!retorno.trim().equals("")){
			values = retorno.split(patternPipe);
			if(values != null && values.length > 1){
				if(values[1].equals("06000")){
					return retorno;
				}
			}
		}
		return "";
	} catch (Exception e) {
		throw e;
	}
}

/**
 * Reenvia as informacoes para o SAT
 * @param dadosVenda
 * @return
 * @throws Exception
 */
public String reEnviarDadosVenda(String dadosVenda) throws Exception
{
	String retorno	 = "";
	int numeroSessao = 0;
	int retry        = 1;
	Thread thread	 = null;
	try {
		
		while (retry <= numberOfRetry) {
			try{
				String retVerificacao = verificarSeVendaFoiOK();
				if(retVerificacao.trim().equals("") == false){
					retVerificacao = tratarRetornoCaracteresEspeciais(retVerificacao);
					return retVerificacao;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			numeroSessao = getNumeroSessao();	
			thread 		 = iniciarTimeout(2000);
			retorno 	 = this.iSatMfe.EnviarDadosVenda(numeroSessao, "", dadosVenda);
			if (!verificarTimeout(thread)) {
				try {					
					consultarNumeroSessao();
					break;
				} catch (SATException mfe) {								
					if (retry == numberOfRetry) {
						throw new SATException("Número de tentativas excedido - Módulo não Responde");
					}					
					retry++;
					numeroSessao = getNumeroSessao();
				}						
			} else {
				break;
			}
		}
		verificarRetorno(retorno, thread);
		retorno = tratarRetornoCaracteresEspeciais(retorno);
		return retorno;
	} catch (Exception e) {
		throw e;
	}	
}

/**
 * A Associacao da assinatura do AC serah realizada atrav�s da funcao AssociarAssinatura.
 * Segue a estrutura da funcao.
 * @param cnpjSoftwareHouse
 * @param cnpjContribuinte
 * @param assinaturaSat
 * @return
 * @throws Exception
 * @throws SATException
 */
public String associarAssinatura(String cnpjSoftwareHouse, String cnpjContribuinte, String assinaturaSat) throws Exception, SATException
{
	int numeroSessao	= 0;
	String codAtivacao	= "";
	String retorno		= "";
	String cnpjValue	= "";
	Thread thread		= null; 
	try {
		numeroSessao = getNumeroSessao();
		cnpjContribuinte  = cnpjContribuinte.replace(".", "").replace("-", "").replace("/", "");
		cnpjSoftwareHouse = cnpjSoftwareHouse.replace(".", "").replace("-", "").replace("/", "");
		cnpjValue = cnpjSoftwareHouse + cnpjContribuinte;
		thread  	 = iniciarTimeout(22000);
		retorno 	 = this.aSatMfe.AssociarAssinatura(numeroSessao, codAtivacao, cnpjValue, assinaturaSat);
		verificarRetorno(retorno, thread);
		return retorno;
	} catch (SATException e) {
		throw e;
	} catch (Exception e) {
		throw e;
	}
}


} /** End Class */
