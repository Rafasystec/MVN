package br.com.barcadero.module.ecf.impressoras;

import java.math.BigDecimal;
import java.util.Collection;

import br.com.barcadero.module.ecf.dados.Aliquotas;
import br.com.barcadero.module.ecf.dados.Item;
import br.com.barcadero.module.ecf.dados.MapaResumo;
import br.com.barcadero.module.ecf.exceptions.ECFException;
import br.com.daruma.jna.ECF;

/**
 * Classe para interagir com o ECF daruma atraves da daruma framework
 * @author Rafael Rocha
 * @since dia 28/08/2015 as 21:05
 */
public final class ECFDaruma extends ECFSuperClass {

	private final String MSG_ERRO_COMANDO = "Erro na execucao da funcao: ";
	@Override
	public int abrirCupom(String cpfCnpj) throws ECFException {
		if(cpfCnpj.isEmpty()){
			return ECF.iCFAbrirPadrao_ECF_Daruma();
		}
		return ECF.iCFAbrir(cpfCnpj, "", "");
	}

	@Override
	public int venderItem(Item item) throws ECFException {
		/*
		 ---------------------------------------------------------------
		Para a aliquota
		A alíquota do item pode ser informada através da posição dela cadastrada com o comando confCadastrar_ECF_Daruma.  
		Exemplo: 01
		 
		Ou o valor da alíquota pode ser informado diretamente, com a vírgula (I07,00) ou sem a vírgula (I0700).   
		Exemplos:
		
		ICMS Não tributado: ("II" - Isento, "I1" - Isento, "I2" - Isento, "FF"- Substituição tributária, "F1"- Substituição tributária, "F2"- Substituição tributária, "NN" - Não Tributária, "N1" - Não Tributária, "N2" - Não Tributária).
		ICMS Tributado:( I07,00 , I18,00,  I0700 , I1800 ou T07,00 , T18,00,  T0700 , T1800)
		ISSQN Não tributado: ("ISS" - Isento, "IS1" - Isento, , "IS2" - Isento, "FS"- Substituição tributária, "FS1"- Substituição tributária, "FS2"- Substituição tributária, "NS" - Não Tributária, "NS1" - Não Tributária, "NS2" - Não Tributária).
		ISSQN Tributado: (S07,00 , S18,00, S0700 , S1800)
		 ---------------------------------------------------------------
		 */
		String precoUnitario 	= item.getValorUnitario().toString();
		String tpDesconto		= item.getTipoDesconto();
		String vlDescAcresc 	= item.getValorDesconto().toString();
		String codigo 			= item.getCodigo();
		String unidade		 	= item.getUnidade();
		String descricao 		= item.getDescricao();
		String quantidade		= String.valueOf(item.getQuantidade());
		return ECF.iCFVender(item.getAliquota(), quantidade, precoUnitario, tpDesconto, vlDescAcresc, codigo, unidade, descricao);
	}

	@Override
	public int cancelarUltimoItem() throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iCFCancelarUltimoItem_ECF_Daruma();
	}

	@Override
	public int cancelarItem(long codigo) throws ECFException {
		// TODO Auto-generated method stub
		String strCodigo = String.valueOf(codigo);
		return ECF.iCFCancelarItem(strCodigo);
	}

	@Override
	public int iniciarFechamentoCupom(String acrescimoDesconto,	String tpAcrescimoDesconto, BigDecimal valorAcrescimoDesconto)	throws ECFException {
		return ECF.iCFTotalizarCupom(tpAcrescimoDesconto, acrescimoDesconto);
	}

	@Override
	public int efetuarFormaPagamento(String descricaoFormPgto, BigDecimal valorFormaPgto) throws ECFException {
		return ECF.iCFEfetuarPagamentoFormatado(descricaoFormPgto, valorFormaPgto.toString());
	}

	@Override
	public int efetuarFormaPgtoPorIndice(long indice, BigDecimal valorFormaPgto)throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int terminarFechamentoCupom(String mensagemPromocional)	throws ECFException {
		
		return ECF.iCFEncerrarConfigMsg(mensagemPromocional);
	}

	@Override
	public int cancelarCupom() throws ECFException {
		return ECF.iCFCancelar_ECF_Daruma();
	}

	@Override
	public int leituraX() throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iLeituraX_ECF_Daruma();
	}

	@Override
	public int lerMemoriaFiscal(String dataInicial, String dataFinal)throws ECFException {
		String tpLeitura = "DATAM";
		String fileName	 = "";
		return ECF.rEfetuarDownloadMFD(tpLeitura, dataInicial, dataFinal, fileName);
	}

	@Override
	public int lerMemoriaFiscal(long iniReducaoZ, long fimReducaoZ)	throws ECFException {
		String tpLeitura = "COO";
		String fileName	 = "";
		return ECF.rEfetuarDownloadMFD(tpLeitura, String.valueOf(iniReducaoZ), String.valueOf(fimReducaoZ), fileName);
	}

	@Override
	public int lerMemoriaFiscalESalvaArquivo(String dataInicial,
			String dataFinal) throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reducaoZ() throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iReducaoZ("ddmmaa", "hhmmss");
	}

	@Override
	public int abrirComprovanteNaoFiscalVinculado(String descFormaPgto,	BigDecimal valorPgto, long nrCupom) throws ECFException {
		String valor = valorPgto.toString();
		String COO   = String.valueOf(nrCupom);
		return ECF.iCCDAbrirSimplificado(descFormaPgto, "0", COO, valor);
	}

	@Override
	public int usarComprovanteNaoFiscalVinculado(String textoParaImprimir)	throws ECFException {
		return ECF.iCCDImprimirTexto(textoParaImprimir);
	}

	@Override
	public int fecharComprovanteNaoFiscalVinculado() throws ECFException {
		return ECF.iCCDFechar_ECF_Daruma();
	}

	@Override
	public int imprimirRealatorioGerencial(int indice, String textoParaImprimir)throws ECFException {
		int ret = ECF.iRGAbrirIndice(indice);
		if(ret == 0){
			throw new ECFException("Erro de comunicação, não foi possível enviar o método.");
		}
		ret = ECF.iRGImprimirTexto(textoParaImprimir);
		ret = ECF.iRGFechar_ECF_Daruma();
		return 0;
	}

	@Override
	public int fecharRelatorioGerencial() throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iRGFechar_ECF_Daruma();
	}

	@Override
	public int imprimirNaoFiscalNaoVinculado(long indice,BigDecimal valorRecebido, String formaPagamento) throws ECFException {
		// TODO Auto-generated method stub
		int ret = ECF.iCNFAbrirPadrao_ECF_Daruma();
		if(ret != 1){
			throw new ECFException("Erro na execucao da funcao: ");
		}
		return 0;
	}

	@Override
	public int fazerSangria(String texto, BigDecimal valor) throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iSangria(valor.toString(), texto);
	}

	@Override
	public int fazerSuprimento(String texto,BigDecimal valor) throws ECFException {
		// TODO Auto-generated method stub
		return ECF.iSuprimento(valor.toString(), texto);
	}

	@Override
	public int acionarGaveta() throws ECFException {
		// TODO Auto-generated method stub
		return ECF.eAbrirGaveta_ECF_Daruma();
	}

	@Override
	public boolean isGavetaAberta() throws ECFException {
		int[] status = new int[1];
		int ret 	= ECF.rStatusGaveta(status);
		if(ret != 1){
			throw new ECFException(MSG_ERRO_COMANDO);
		}
		if(status != null && status.length > 0){
			if(status[0] == 1) return true;
			else return false;
		}
		return false;
	}

	@Override
	public String dadosUltimaReducaoZ(String dadosReducao) throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dataHoraECF() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dataHoraReducao() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCupomAberto() throws ECFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigDecimal getGrandeTotal() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelo() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumeroCaixa() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNumeroCupom() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSerieECF() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Aliquotas> getAliquotasCadastradas() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int verificarReducaoZPendente() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int abrirComunicao() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MapaResumo getMapaResumo() throws ECFException {
		//NOTE: O arquivo gerado é salvo no caminho configurado na tag START\LocalArquivosRelatorios do arquivo de configuração DarumaFramework.xml 
		char[] resumo = null;
		int ret = ECF.rRetornarDadosReducaoZ(resumo);
		if(ret != 1){
			throw new ECFException(MSG_ERRO_COMANDO);
		}
		return null;
	}

	@Override
	public boolean isECFLigado() throws ECFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int abrirCupom(String cpfCnpj, String nome, String endereco)	throws ECFException {
		return ECF.iCFAbrir(cpfCnpj, nome, endereco);
	}

	
}
