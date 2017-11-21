package br.com.barcadero.module.sat.devices.integrador;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.barcadero.module.sat.devices.integrador.vfpe.Integrador;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeEnviarPagamento;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidador;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorDadosParaEnviar;
import br.com.barcadero.module.sat.devices.integrador.vfpe.VFPeVerificarStatusValidadorResposta;
import br.com.barcadero.module.sat.devices.integrador.xml.Componente;
import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.IntegradorRoot;
import br.com.barcadero.module.sat.devices.integrador.xml.Metodo;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametro;
import br.com.barcadero.module.sat.devices.integrador.xml.Parametros;
import br.com.barcadero.module.sat.devices.integrador.xml.HandleXML;
import br.com.barcadero.module.sat.handle.InterfaceSAT;

public class IntegradorMFeImpl implements InterfaceSAT{

	private final String METODO_ENVIAR_DADOS_VENDA 					= "EnviarDadosVenda";
	private final String METODO_ASSOCIAR_ASSINATURA 				= "AssociarAssinatura"; 
	private final String METODO_ATUALIZAR_SOFTWAREMFE 				= "AtualizarSoftwareMFe";
	private final String METODO_BLOQUEAR_MFE 						= "BloquearMFe";
	private final String METODO_CANCELAR_ULTIMA_VENDA 				= "CancelarUltimaVenda";
	private final String METODO_CONSULTAR_STATUS_OPERACIONAL 		= "ConsultarStatusOperacional";
	private final String METODO_CONSULTAR_MFE 						= "ConsultarMFe";
	private final String METODO_CONSULTAR_NUMERO_SESSAO 			= "ConsultarNumeroSessao";
	private final String METODO_DESBLOQUEAR_MFE 					= "DesbloquearMFe";
	private final String METODO_EXTRAIR_LOGS 						= "ExtrairLogs";
	private final String METODO_TESTE_FIMAFIM 						= "TesteFimAFim";
	private final String METODO_TROCAR_CODIGO_DE_ATIVACAO 			= "TrocarCodigoDeAtivacao";
	
	private static final String ERROR_CODE = "88888";
	private File dirInputIntegrador;
	private File dirOutputIntegrador;
	public IntegradorMFeImpl(File dirInputIntegrador, File dirOutputIntegrador ) {
		setDirInputIntegrador(dirInputIntegrador);
		setDirOutputIntegrador(dirOutputIntegrador);
	}
	
	@Override
	public String EnviarDadosVenda(int numeroSessao, String codigoDeAtivacao, String dadosVenda) {
		String fileName = "EnviarDadosVenda.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("dadosVenda");
		parametro3.setValor("<![CDATA["+dadosVenda+"]]>");
		
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		

		IntegradorRoot integradorRoot = getIntegrador(METODO_ENVIAR_DADOS_VENDA, Listparametros);
		integradorRoot.setNumeroDeSessao(""+numeroSessao);
		integradorRoot.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integradorRoot, fileName);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_CODE+" EnviarDadosVenda resultou em erro: " + e.getMessage();
		}
	}

	@Override
	public String CancelarUltimaVenda(int numeroSessao, String codigoDeAtivacao, String chave,
			String dadosCancelamento) {
		String fileName = "CancelarUltimaVenda.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("chave");
		parametro3.setValor(chave);
		Parametro parametro4 = new Parametro();
		parametro4.setNome("dadosCancelamento");
		parametro4.setValor(dadosCancelamento);
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		Listparametros.add(parametro4);
		IntegradorRoot integradorRoot = getIntegrador(METODO_CANCELAR_ULTIMA_VENDA, Listparametros);
		integradorRoot.setNumeroDeSessao(""+numeroSessao);
		integradorRoot.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integradorRoot, fileName);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_CODE+" CancelarUltimaVenda resultou em erro: "+e.getMessage();
		}
	}

	@Override
	public String ConsultarSAT(int numeroSessao) {
		String fileName = "ConsultarMFe.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);		
		Listparametros.add(parametro1);
		IntegradorRoot integrador = getIntegrador(METODO_CONSULTAR_MFE, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao ConsultarMFe : " + e.getMessage();
		}
	}

	@Override
	public String TesteFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda) {
		String fileName = "TesteFimAFim.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("dadosVenda");
		parametro3.setValor("<![CDATA["+dadosVenda+"]]>");
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		IntegradorRoot integrador = getIntegrador(METODO_TESTE_FIMAFIM, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_CODE+" Erro ao TesteFimAFim: " +e.getMessage();
		}
	}

	@Override
	public String ConsultarNumeroSessao(int numeroSessao, String codigoDeAtivacao, int cNumeroDeSessao) {
		String fileName = "ConsultarNumeroSessao.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("cNumeroDeSessao");
		parametro3.setValor(""+cNumeroDeSessao);
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		IntegradorRoot integrador = getIntegrador(METODO_CONSULTAR_NUMERO_SESSAO, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao ConsultarNumeroSessao com Integrador: " + e.getMessage();
		}
	}

	@Override
	public String AtivarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF) {
		// TODO Auto-generated method stub
		return "0000|Metodo nao implementado";
	}

	@Override
	public String ComunicarCertificadoICPBRASIL(int numeroSessao, String codigoDeAtivacao, String certificado) {
		return "0000|Metodo nao implementado";
	}

	@Override
	public String ConsultarStatusOperacional(int numeroSessao, String codigoDeAtivacao) {
		String fileName = "ConsultarStatusOperacional.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		IntegradorRoot integrador = getIntegrador(METODO_CONSULTAR_STATUS_OPERACIONAL, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao ConsultarStatusOperacional: " +e.getMessage();
		}
	}

	@Override
	public String ConfigurarInterfaceDeRede(int numeroSessao, String codigoDeAtivacao, String dadosConfiguracao) {
		// TODO Auto-generated method stub
		return "0000|Metodo nao implementado";
	}

	@Override
	public String AssociarAssinatura(int numeroSessao, String codigoDeAtivacao, String cnpjValue,
			String assinaturaCNPJs) {
		String fileName = "AssociarAssinatura.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("dadosVenda");
		parametro3.setValor(cnpjValue);
		Parametro parametro4 = new Parametro();
		parametro4.setNome("assinaturaCNPJs");
		parametro4.setValor(assinaturaCNPJs);

		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		Listparametros.add(parametro4);
		IntegradorRoot integrador = getIntegrador(METODO_ASSOCIAR_ASSINATURA, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao AssociarAssinatura: "+e.getMessage();
		}
	}
 	
	/**
	 * 
	 */
	public String AtualizarSoftwareSAT(int numeroSessao, String codigoDeAtivacao) {
		String fileName = "AtualizarSoftwareMFe.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		IntegradorRoot integrador = getIntegrador(METODO_ATUALIZAR_SOFTWAREMFE, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao AtualizarSoftwareMFe: " + e.getMessage();
		}
	}

	
	public String ExtrairLogs(int numeroSessao, String codigoDeAtivacao) {
		String fileName = "ExtrairLogs.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		IntegradorRoot integrador = getIntegrador(METODO_EXTRAIR_LOGS, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao ExtrairLogs: " + e.getMessage();
		}
	}

	@Override
	public String BloquearSAT(int numeroSessao, String codigoDeAtivacao) {
		String fileName = "BloquearMFe.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();
		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("codigoDeAtivacao");
		parametro3.setValor(codigoDeAtivacao);
		Listparametros.add(parametro1);
		Listparametros.add(parametro3);
		IntegradorRoot integrador = getIntegrador(METODO_BLOQUEAR_MFE, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_CODE+" Erro ao BloquearMFe: "+e.getMessage();
		}
	}

	@Override
	public String DesbloquearSAT(int numeroSessao, String codigoDeAtivacao) {
		String fileName = "DesbloquearMFe.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);

		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		IntegradorRoot integrador = getIntegrador(METODO_DESBLOQUEAR_MFE, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			String result = writeAndRead(integrador, fileName);
			return result;
		} catch (Exception e) {
			return ERROR_CODE+" Erro ao executar DesbloquearMFe: " + e.getMessage();
		}
	}

	@Override
	public String TrocarCodigoDeAtivacao(int numeroSessao, String codigoDeAtivacao, int opcao, String novoCodigo,
			String confNovoCodigo) {
		String fileName = "TrocarCodigoDeAtivacao.xml";
		List<Parametro> Listparametros = new ArrayList<Parametro>();

		Parametro parametro1 = new Parametro();
		parametro1.setNome("numeroSessao");
		parametro1.setValor(""+numeroSessao);
		Parametro parametro2 = new Parametro();
		parametro2.setNome("codigoDeAtivacao");
		parametro2.setValor(codigoDeAtivacao);
		Parametro parametro3 = new Parametro();
		parametro3.setNome("opcao");
		parametro3.setValor(""+opcao);
		Parametro parametro4 = new Parametro();
		parametro4.setNome("novoCodigo");
		parametro4.setValor(novoCodigo);
		Parametro parametro5 = new Parametro();
		parametro5.setNome("confNovoCodigo");
		parametro5.setValor(confNovoCodigo);

		Listparametros.add(parametro1);
		Listparametros.add(parametro2);
		Listparametros.add(parametro3);
		Listparametros.add(parametro4);
		Listparametros.add(parametro5);
		IntegradorRoot integrador = getIntegrador(METODO_TROCAR_CODIGO_DE_ATIVACAO, Listparametros);
		integrador.setNumeroDeSessao(""+numeroSessao);
		integrador.getIdentificado().setValor(""+numeroSessao);
		try {
			return writeAndRead(integrador, fileName);
		} catch (Exception e) {
			return ERROR_CODE+" TrocarCodigoDeAtivacao " + e.getMessage();
		}
	}
	/**
	 * 
	 * @param enviarPagamento
	 * @return
	 */
	public String EnviarPagamento(VFPeEnviarPagamento enviarPagamento) {
		String fileName = "EnviarPagamento.xml";
		String result 	= writeAndRead(enviarPagamento.getIntegrador(), fileName );
		return result;
	}

	public File getDirInputIntegrador() {
		return dirInputIntegrador;
	}

	public void setDirInputIntegrador(File dirInputIntegrador) {
		this.dirInputIntegrador = dirInputIntegrador;
	}

	public File getDirOutputIntegrador() {
		return dirOutputIntegrador;
	}

	public void setDirOutputIntegrador(File dirOutputIntegrador) {
		this.dirOutputIntegrador = dirOutputIntegrador;
	}
	
	
	private String writeAndRead(Object integradorRoot,String fileName) {
		try {
			deleteFiles(getDirInputIntegrador().getAbsolutePath(), "xml");
			if(!getDirInputIntegrador().exists()){
				if(!getDirInputIntegrador().mkdirs()){
					return "Diretório input não foi criado pelo Integrador e nem a aplicação conseguiu cria-lo. Diretorio: " + getDirInputIntegrador().getAbsolutePath();
				}
			}
			if(!getDirOutputIntegrador().exists()){
				if(getDirOutputIntegrador().mkdirs()){
					return "Diretório output não foi criado pelo Integrador e nem a aolicação conseguiu. Diretorio " + getDirOutputIntegrador().getAbsolutePath();
				}
			}
			HandleXML.writeXMLToAFile(getDirInputIntegrador().getAbsolutePath() + File.separator + fileName, integradorRoot);
			int qtdTentativas = 0;
			boolean isIntegradorRespondeu = false;
			do {
				if(isIntegradorRespondeu(getDirOutputIntegrador().getAbsolutePath(), "xml")){
					isIntegradorRespondeu = true;
					System.out.println(">>>INTEGRADOR respondeu <<<");
					return readFileResponse(getDirOutputIntegrador().getAbsolutePath());
				}else{
					Thread.sleep(600);
				}
				qtdTentativas++;
				if(qtdTentativas > 60){
					System.out.println("Time Out : Integrador SEFAZ não responde.Por favor verifique se o mesmo está funcionando corretamente.");
					if(integradorRoot instanceof IntegradorRoot){
						return handleTimeOut((IntegradorRoot)integradorRoot);
					}
				}
			} while (isIntegradorRespondeu == false);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			deleteFiles(getDirOutputIntegrador().getAbsolutePath(), "xml");
			deleteFiles(getDirInputIntegrador().getAbsolutePath(), "xml");
		}
		return "";
	}
	/**
	 * Manipula o Time out do Integrador
	 * @param integradorRoot
	 * @return
	 */
	private String handleTimeOut(IntegradorRoot integradorRoot) {
		System.out.println("ENCERRAR O LOOP");
		System.out.println("Time Out : Integrador SEFAZ não responde.Por favor verifique se o mesmo está funcionando.");
		String result = "Time Out : Integrador SEFAZ não responde.Por favor verifique se o mesmo está funcionando.||";
		if(integradorRoot != null){
			if(integradorRoot.getComponente()!=null){
				if(integradorRoot.getComponente().getMetodo() != null){
					if(integradorRoot.getComponente().getMetodo().getNome() != null){
						return ERROR_CODE + "|Erro TimeOut Integrador não responde"; 
					}
				}
			}
		}
		return result;
	}
	
	private static boolean deleteFiles(String dirName,String type){
		boolean verificar = false;
		try {
			String arq = ".+\\." + type;     
			File pasta = new File(dirName);
			if(pasta.exists()){
				File[] arquivos = pasta.listFiles();      
				for(int i=0;i<arquivos.length;i++){     
				   if(arquivos[i].getName().matches(arq.trim())){     
				      arquivos[i].delete();     
				   }     
				}
			}
			System.out.println("verificar: " + verificar);
			return verificar = true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isIntegradorRespondeu(String diretorio,String extensao)
	{	
		boolean verificar = false;
		try {
			String arq = ".+\\." + extensao;     
			File pasta = new File(diretorio);     
			File[] arquivos = pasta.listFiles();     
			     
			for(int i=0;i<arquivos.length;i++){     
			   if(arquivos[i].getName().matches(arq.trim())){     
				   verificar = true;
			   }     
			}
			return verificar ;
		} catch (Exception e) {
			return false;
		}
	}
	
	public String readFileResponse(String diretorio) throws Exception{
		String arq = ".+\\." + "xml";     
		File pasta = new File(diretorio);     
		File[] arquivos = pasta.listFiles();     
		     
		for(int i=0;i<arquivos.length;i++){     
		   if(arquivos[i].getName().matches(arq.trim())){     
			   HandleXML.backupXMLIntegradorResponse(arquivos[i], diretorio);
			   IntegradorRoot integrador = (IntegradorRoot) HandleXML.unMarshalFromFile(arquivos[i].getAbsolutePath(), IntegradorMFeImpl.class);
			   if(integrador != null){
				   String retErro = processErrorResponse(integrador);
				   String response = "";
				   if(retErro.trim().isEmpty()){
					   response = integrador.getResposta().getRetorno();
					   if(response==null){
						   response = integrador.getIdentificado().getValor()+"|6099|0000|O Integrador informou que a venda foi processada, porém não enviou o retorno do Módulo";
					   }
				   }else{
					   response = retErro;
				   }
				   return response;
			   }
		   }     
		}
		return "Não foi encontrado nenhum arquivo de resposta em formato xml.";
	}
	
	private String processErrorResponse(IntegradorRoot integradorRoot) {
		if(integradorRoot!=null){
			if(integradorRoot.getErro() != null){
				String codErro 	= integradorRoot.getErro().getCodigo();
				String valor	= integradorRoot.getErro().getValor();
				if(!codErro.trim().isEmpty()){
					return ERROR_CODE + "|" + codErro + "|" + valor;
				}
			}
		}
		return "";
	}
	
	private IntegradorRoot getIntegrador(String methodNameIntegrador, List<Parametro> Listparametros) {
		IntegradorRoot integradorRoot 		= new IntegradorRoot();
		Identificador identificador = new Identificador();
		integradorRoot.setIdentificado(identificador);
		Componente componente 		= new Componente();
		Metodo metodo = new Metodo();
		metodo.setNome(methodNameIntegrador);
		Parametros parametros 		= new Parametros();
		parametros.setParametro(Listparametros );
		metodo.setParametros(parametros );
		componente.setMetodo(metodo );
		integradorRoot.setComponente(componente );
		return integradorRoot;
	}
	/**
	 * Neste método o PDV/AC poderá consultar no Validador Fiscal de
     * Pagamentos Eletrônicos se a sua solicitação de pagamento realizada
     * anteriormente já foi processada pelo POS, caso afirmativo o PDV/AC
     * receberá os dados de pagamento para gravação em seu banco de dados e
     * utilização para seus registros e envios ao documento fiscal. Para realização
     * da consulta é necessário que o PDV/AC informe ao Validador Fiscal de
     * Pagamentos Eletrônicos o número do IDPAGAMENTO recebido na
     * solicitação de pagamento realizada no método “EnviarPagamento”.
     * Não havendo internet este processo retornará um arquivo com um
     * IDPAGAMENTO local gerado pelo Integrador Fiscal, estritamente para que
     * o AC/PDV possa seguir seu fluxo de trabalho, porém ao retornar a internet
     * deverá ser reenviado a solicitação ao VFP-e através da interface
     * ENVIARPAGAMENTO e recuperar o IDPAGAMENTO gerado pela
     * SEFAZ, o qual será utilizado para cumprimento dos requisitos estipulados.
	 * @param dadosParaEnviar
	 * @return
	 * @throws JAXBException
	 * @throws Exception
	 */
	public String executarVerificarStatusValidador(VFPeVerificarStatusValidadorDadosParaEnviar dadosParaEnviar) throws JAXBException, Exception {
		String result = "";//new VFPeVerificarStatusValidadorResposta();
		Integrador integrador = VFPeVerificarStatusValidador.montarXMLVerificarStatusValidador(dadosParaEnviar);
		String xmlReturned = writeAndRead(integrador, "verificarStatusValidador");
		result = xmlReturned;
		return result;
	}

	@Override
	public int openPort(int canal) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void closePort() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCodModule() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getModuleName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModuleClass() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
