package br.com.systeconline.core.nfe.servicos;

import br.com.systeconline.nfe.core.util.enumarations.ETipoAmbiente;


public abstract class AGeneralService implements IGeneralService{
	
	public static final String AMB_HOMOLOGACAO = ETipoAmbiente.HOMOLOGACAO.getValue();
	public static final String AMB_NFEPRODUCAO = ETipoAmbiente.PRODUCAO.getValue();	
	
	protected String webServiceRecepcaoEvento 		= "RecepcaoEvento";
	protected String webServiceNfeRecepcao 			= "NfeRecepcao";
	protected String webServiceNfeInutilizacao 		= "NfeInutilizacao";
	protected String webServiceNfeConsultaProtocolo = "NfeConsulta2";
	protected String webServiceNfeRetRecepcao 		= "NfeRetRecepcao";
	protected String webServiceNfeConsultaCadastro 	= "NfeConsultaCadastro";
	protected String webServiceNfeStatusServico 	= "NfeStatusServico2";
	protected String webServiceNfeDownloadNF 		= "NfeDownloadNF";
	protected String webServiceNFeAutorizacao 		= "NFeAutorizacao";
	protected String webServiceNFeRetAutorizacao 	= "NFeRetAutorizacao";
	//Metodos
	protected String metodoNfeStatusServico = "nfeStatusServicoNF2";

}
