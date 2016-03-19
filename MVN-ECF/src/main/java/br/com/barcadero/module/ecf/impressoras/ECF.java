package br.com.barcadero.module.ecf.impressoras;

import java.math.BigDecimal;
import java.util.Collection;

import br.com.barcadero.module.ecf.dados.Aliquotas;
import br.com.barcadero.module.ecf.dados.Item;
import br.com.barcadero.module.ecf.dados.MapaResumo;
import br.com.barcadero.module.ecf.exceptions.ECFException;


public interface ECF {
	
	public int abrirCupom(String cpfCnpj) throws ECFException;
	public int abrirCupom(String cpfCnpj, String nome, String endereco) throws ECFException;
	public int venderItem(Item item)throws ECFException;	
	public int cancelarUltimoItem()throws ECFException;
	public int cancelarItem(long codigo)throws ECFException;
	public int iniciarFechamentoCupom(String acrescimoDesconto, String tpAcrescimoDesconto, BigDecimal valorAcrescimoDesconto)throws ECFException;
	public int efetuarFormaPagamento(String descricaoFormPgto, BigDecimal valorFormaPgto)throws ECFException;
	public int efetuarFormaPgtoPorIndice(long indice, BigDecimal valorFormaPgto)throws ECFException;
	public int terminarFechamentoCupom(String mensagemPromocional)throws ECFException;
	public int cancelarCupom()throws ECFException;
	public int leituraX()throws ECFException;
	public int lerMemoriaFiscal(String dataInicial, String dataFinal)throws ECFException;
	public int lerMemoriaFiscal(long iniReducaoZ, long fimReducaoZ )throws ECFException;
	public int lerMemoriaFiscalESalvaArquivo(String dataInicial, String dataFinal)throws ECFException;
	public int reducaoZ()throws ECFException;
	/**
	 * Eh usado para o cartao de credito - CCD - Comprovante de credito e debito
	 * @param descFormaPgto
	 * @param valorPgto
	 * @param nrCupom
	 * @return
	 * @throws ECFException
	 */
	public int abrirComprovanteNaoFiscalVinculado(String descFormaPgto, BigDecimal valorPgto, long nrCupom)throws ECFException;
	public int usarComprovanteNaoFiscalVinculado(String textoParaImprimir) throws ECFException;
	public int fecharComprovanteNaoFiscalVinculado() throws ECFException;
	public int imprimirRealatorioGerencial(int indice, String textoParaImprimir) throws ECFException;
	public int fecharRelatorioGerencial() throws ECFException;
	public int imprimirNaoFiscalNaoVinculado(long indice, BigDecimal valorRecebido, String formaPagamento) throws ECFException;
	public int fazerSangria(String texto, BigDecimal valor) throws ECFException;
	public int fazerSuprimento(String texto, BigDecimal valor) throws ECFException;
	public int acionarGaveta() throws ECFException;
	public boolean isGavetaAberta() throws ECFException;
	public String dadosUltimaReducaoZ(String dadosReducao) throws ECFException;
	public String dataHoraECF() throws ECFException;
	public String dataHoraReducao()  throws ECFException;
	public boolean isCupomAberto()  throws ECFException;
	public BigDecimal getGrandeTotal()  throws ECFException;
	public String getModelo()  throws ECFException;
	public long getNumeroCaixa()  throws ECFException;
	public long getNumeroCupom()  throws ECFException;
	public String getSerieECF()  throws ECFException;
	public Collection<Aliquotas> getAliquotasCadastradas()  throws ECFException;
	public int verificarReducaoZPendente()  throws ECFException;
	public int abrirComunicao() throws ECFException;
	public MapaResumo getMapaResumo()  throws ECFException;
	public boolean isECFLigado()  throws ECFException;
}
