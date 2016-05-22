package br.com.systeconline.tables.nota;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.systeconline.core.enums.nfe.EnumNFeFinalidadeEmissao;
import br.com.systeconline.core.enums.nfe.EnumNFeIdDestino;
import br.com.systeconline.core.enums.nfe.EnumNFeIndPresencaComprador;
import br.com.systeconline.core.enums.nfe.EnumNFeTipoNota;
import br.com.systeconline.core.enums.nfe.EnumNFeTpAmbiente;
import br.com.systeconline.core.enums.nfe.EnumNFeTpDANFE;
import br.com.systeconline.core.enums.nfe.EnumNFeTpEmissao;
import br.com.systeconline.core.enums.nfe.EnumNFeTpProcessoEmissao;
import br.com.systeconline.tables.basicos.EntidadeLoja;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.Usuario;

@Entity
@Table(name="NOTA_ELETRONICA")
public class NotaEletronica extends EntidadeLoja {

	private static final long serialVersionUID = -1522782328874457579L;

	public NotaEletronica() {
		// TODO Auto-generated constructor stub
	}
	
	public NotaEletronica(Loja loja, Usuario usuario) {
		super(loja, usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="CHV_ACESSO", nullable=false)
	private String chvAcesso;
	@Column(name="XML_BASE_64", nullable=false)
	private String xmlBase64;
	@Column(name="PROTOC_AUTORIZ", nullable=false)
	private String protocAutoriz;
	@Column(name="LOTE_ENV", nullable=false)
	private String loteEnv;
	@Column(name="ID_DESTINO", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeIdDestino idDestino = EnumNFeIdDestino.INDEFINIDO;
	@Column(name="TP_IMP_DANFE", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeTpDANFE tpImpDanfe;
	@Column(name="TP_EMISSAO", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeTpEmissao tpEmissao;
	@Column(name="TP_NOTA_FISCAL")
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeTipoNota tpNotaFiscal = EnumNFeTipoNota.SAIDA;
	@Column(name="DG_CHV_ACESSO", nullable=false)
	private int dgChvAcesso;
	@Column(name="TP_AMBIENTE", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeTpAmbiente tpAmbiente;
	@Column(name="FINALIDADE", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeFinalidadeEmissao finalidade;
	@Column(name="IND_PRESENCA_COMPR", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumNFeIndPresencaComprador indPresenCompr;
	@Column(name="TP_PROC_EMIT", nullable=false)
	@Enumerated
	private EnumNFeTpProcessoEmissao tpProcEmit;
	@Column(name="VERSAO_APP", nullable=false)
	private String versaoApp;
	@Column(name="DT_HR_CONTINGENCIA", nullable=false)
	private Date dtHrContingencia;
	@Column(name="JUST_CONTINGENCIA", nullable=false)
	private String justContingencia;

	public String getChvAcesso() {
		return chvAcesso;
	}
	public void setChvAcesso(String chvAcesso) {
		this.chvAcesso = chvAcesso;
	}
	public String getXmlBase64() {
		return xmlBase64;
	}
	public void setXmlBase64(String xmlBase64) {
		this.xmlBase64 = xmlBase64;
	}
	public String getProtocAutoriz() {
		return protocAutoriz;
	}
	public void setProtocAutoriz(String protocAutoriz) {
		this.protocAutoriz = protocAutoriz;
	}
	public String getLoteEnv() {
		return loteEnv;
	}
	public void setLoteEnv(String loteEnv) {
		this.loteEnv = loteEnv;
	}
	/**
	 * Identificador de Local de destino da operação (1-Interna;2-Interestadual;3-Exterior)
	 * @return
	 */
	public EnumNFeIdDestino getIdDestino() {
		return idDestino;
	}
	/**
	 * Identificador de Local de destino da operação (1-Interna;2-Interestadual;3-Exterior)
	 * @param idDestino
	 * {@link EnumNFeIdDestino}
	 */
	public void setIdDestino(EnumNFeIdDestino idDestino) {
		this.idDestino = idDestino;
	}
	/**
	 * Formato de impressão do DANFE (0-sem DANFE;1-DANFe Retrato; 2-DANFe Paisagem;3-DANFe Simplificado;
	 * 4-DANFe NFC-e;5-DANFe NFC-e em mensagem eletrônica)
	 * @return
	 */
	public EnumNFeTpDANFE getTpImpDanfe() {
		return tpImpDanfe;
	}
	/**
	 * Formato de impressão do DANFE (0-sem DANFE;1-DANFe Retrato; 2-DANFe Paisagem;3-DANFe Simplificado;
	 * 4-DANFe NFC-e;5-DANFe NFC-e em mensagem eletrônica)
	 * @param tpImpDanfe
	 * {@link EnumNFeTpDANFE}
	 */
	public void setTpImpDanfe(EnumNFeTpDANFE tpImpDanfe) {
		this.tpImpDanfe = tpImpDanfe;
	}
	/**
	 * Forma de emissão da NF-e
	 *	1 - Normal;
	 *	2 - Contingência FS
	 *	3 - Contingência SCAN
	 *	4 - Contingência DPEC
	 *	5 - Contingência FSDA
	 *	6 - Contingência SVC - AN
	 *	7 - Contingência SVC - RS
	 *	9 - Contingência off-line NFC-e
	 * @return
	 */
	public EnumNFeTpEmissao getTpEmissao() {
		return tpEmissao;
	}
	/**
	 * Forma de emissão da NF-e
	 *	1 - Normal;
	 *	2 - Contingência FS
	 *	3 - Contingência SCAN
	 *	4 - Contingência DPEC
	 *	5 - Contingência FSDA
	 *	6 - Contingência SVC - AN
	 *	7 - Contingência SVC - RS
	 *	9 - Contingência off-line NFC-e
	 * @param tpEmissao
	 */
	public void setTpEmissao(EnumNFeTpEmissao tpEmissao) {
		this.tpEmissao = tpEmissao;
	}
	public int getDgChvAcesso() {
		return dgChvAcesso;
	}
	public void setDgChvAcesso(int dgChvAcesso) {
		this.dgChvAcesso = dgChvAcesso;
	}
	/**
	 * Identificação do Ambiente:
	 *	1 - Produção
	 *	2 - Homologação
	 * @return
	 */
	public EnumNFeTpAmbiente getTpAmbiente() {
		return tpAmbiente;
	}
	/**
	 * Identificação do Ambiente:
	 *	1 - Produção
	 *	2 - Homologação
	 * @param tpAmbiente
	 */
	public void setTpAmbiente(EnumNFeTpAmbiente tpAmbiente) {
		this.tpAmbiente = tpAmbiente;
	}
	/**
	 * Finalidade da emissão da NF-e:
	 *	1 - NFe normal
	 *	2 - NFe complementar
	 *	3 - NFe de ajuste
	 *	4 - Devolução/Retorno 
	 * @return
	 */
	public EnumNFeFinalidadeEmissao getFinalidade() {
		return finalidade;
	}
	/**
	 * Finalidade da emissão da NF-e:
	 *	1 - NFe normal
	 *	2 - NFe complementar
	 *	3 - NFe de ajuste
	 *	4 - Devolução/Retorno
	 * @param finalidade
	 */
	public void setFinalidade(EnumNFeFinalidadeEmissao finalidade) {
		this.finalidade = finalidade;
	}
	/**
	  Indicador de presença do comprador no estabelecimento comercial no momento da oepração
	 (0-Não se aplica - ex.: Nota Fiscal complementar ou de ajuste;
	  1-Operação presencial;
	  2-Não presencial, internet;
	  3-Não presencial, teleatendimento;
	  4-NFC-e entrega em domicílio;
	  9-Não presencial, 
	  outros
	 * @return
	 */
	public EnumNFeIndPresencaComprador getIndPresenCompr() {
		return indPresenCompr;
	}
	/**
	  Indicador de presença do comprador no estabelecimento comercial no momento da oepração
	 (0-Não se aplica - ex.: Nota Fiscal complementar ou de ajuste;
	  1-Operação presencial;
	  2-Não presencial, internet;
	  3-Não presencial, teleatendimento;
	  4-NFC-e entrega em domicílio;
	  9-Não presencial, 
	  outros
	 * @param indPresenCompr
	 */
	public void setIndPresenCompr(EnumNFeIndPresencaComprador indPresenCompr) {
		this.indPresenCompr = indPresenCompr;
	}
	/**
	 * Processo de emissão utilizado com a seguinte codificação:
	 *	0 - emissão de NF-e com aplicativo do contribuinte;
	 *	1 - emissão de NF-e avulsa pelo Fisco;
	 *	2 - emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
	 *	3- emissão de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
	 * @return
	 */
	public EnumNFeTpProcessoEmissao getTpProcEmit() {
		return tpProcEmit;
	}
	/**
	 * * Processo de emissão utilizado com a seguinte codificação:
	 *	0 - emissão de NF-e com aplicativo do contribuinte;
	 *	1 - emissão de NF-e avulsa pelo Fisco;
	 *	2 - emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
	 *	3- emissão de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
	 * @param tpProcEmit
	 */
	public void setTpProcEmit(EnumNFeTpProcessoEmissao tpProcEmit) {
		this.tpProcEmit = tpProcEmit;
	}
	public String getVersaoApp() {
		return versaoApp;
	}
	public void setVersaoApp(String versaoApp) {
		this.versaoApp = versaoApp;
	}
	public Date getDtHrContingencia() {
		return dtHrContingencia;
	}
	public void setDtHrContingencia(Date dtHrContingencia) {
		this.dtHrContingencia = dtHrContingencia;
	}
	public String getJustContingencia() {
		return justContingencia;
	}
	public void setJustContingencia(String justContingencia) {
		this.justContingencia = justContingencia;
	}
	/**
	 * Tipo do Documento Fiscal (0 - entrada; 1 - saída)
	 * @return
	 * {@link EnumNFeTipoNota}
	 */
	public EnumNFeTipoNota getTpNotaFiscal() {
		return tpNotaFiscal;
	}
	/**
	 * Tipo do Documento Fiscal (0 - entrada; 1 - saída)
	 * @param tpNotaFiscal
	 * {@link EnumNFeTipoNota}
	 */
	public void setTpNotaFiscal(EnumNFeTipoNota tpNotaFiscal) {
		this.tpNotaFiscal = tpNotaFiscal;
	}
}
