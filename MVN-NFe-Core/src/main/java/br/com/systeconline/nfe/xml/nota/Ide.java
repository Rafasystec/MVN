package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.systeconline.nfe.core.util.enumarations.EFinalidadeNFe;

//B01
@XmlRootElement(name="ide")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"cUF","cNF","natOp","indPag","mod","serie","nNF","dhEmi","dhSaiEnt","tpNF","idDest","cMunFG","tpImp","tpEmis","cDV","tpAmb","finNFe","indFinal","indPres","procEmi","verProc","nFref"})
public class Ide {

	//-----------------------------------
	//Constates
	//-----------------------------------
	//Identificador de Local de destino da operacao 
	public static final String OP_INTERANA 		= "1";
	public static final String OP_INTERESTADUAL = "2";
	public static final String OP_EXTERIOR		= "3";
	//------------------------------------
	//Operacao com consumidor final
	public static final String CONSUMIDOR_N_FINAL = "0";
	public static final String CONSUMIDOR_S_FINAL = "1";
	//------------------------------------
	@XmlElement(name="cUF", required=true)
	private String cUF;
	@XmlElement(name="cNF", required=true)
	private String cNF;
	@XmlElement(name="natOp", required=true)
	private String natOp;
	@XmlElement(name="indPag", required=true)
	private String indPag;
	@XmlElement(name="mod", required=true)
	private String mod;
	@XmlElement(name="serie", required=true)
	private String serie;
	@XmlElement(name="nNF", required=true)
	private String nNF;
	@XmlElement(name="dhEmi", required=true)
	private String dhEmi;
	@XmlElement(name="dhSaiEnt", required=true)
	private String dhSaiEnt;
	@XmlElement(name="tpNF", required=true)
	private String tpNF;
	@XmlElement(name="cMunFG", required=true)
	private String cMunFG;
	@XmlElement(name="NFref", required=true)
	private List<NFref> nFref;
	@XmlElement(name="tpImp",required=true)
	private String tpImp;
	@XmlElement(name="tpEmis",required=true)
	private String tpEmis;
	@XmlElement(name="cDV",required=true)
	private String cDV;
	@XmlElement(name="tpAmb",required=true)
	private String tpAmb;
	@XmlElement(name="finNFe",required=true)
	private String finNFe;
	@XmlElement(name="procEmi",required=true)
	private String procEmi;
	@XmlElement(name="verProc",required=true)
	private String verProc;
	@XmlElement
	private String indPres;
	
	public String getIndPres() {
		return indPres;
	}
	public void setIndPres(String indPres) {
		this.indPres = indPres;
	}
	/**
	 * Data e Hora da saída ou de entrada da mercadoria / produto (AAAA-MM-DDTHH:mm:ssTZD)
	 * @param dSaiEnt
	 */
	public void setDhSaiEnt(String dhSaiEnt) {
		this.dhSaiEnt = dhSaiEnt;
	}
	//	@XmlElement(name="dhCont",required=false)
//	private String dhCont;
//	@XmlElement(name="xJust",required=false)
//	private String xJust;
	@XmlElement(name="idDest", required=true)
	private String idDest;
	@XmlElement(required=false)
	private String indFinal;
	/**
	 * Codigo da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE.
	 * @return
	 */
	public String getcUF() {
		return cUF;
	}
	/**
	 * Codigo da UF do emitente do Documento Fiscal. Utilizar a Tabela do IBGE.
	 * @param cUF
	 */
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	/**
	 * Código numérico que compõe a Chave de Acesso. Número aleatório gerado pelo emitente para cada NF-e.
	 * @return
	 */
	public String getcNF() {
		return cNF;
	}
	/**
	 * Código numérico que compõe a Chave de Acesso. Número aleatório gerado pelo emitente para cada NF-e.
	 * @param cNF
	 */
	public void setcNF(String cNF) {
		this.cNF = cNF;
	}
	/**
	 * Descrição da Natureza da Operação
	 * @return
	 */
	public String getNatOp() {
		return natOp;
	}
	/**
	 * Descrição da Natureza da Operação
	 * @param natOp
	 */
	public void setNatOp(String natOp) {
		this.natOp = natOp;
	}
	/**
	 * Indicador da forma de pagamento:
		0 – pagamento à vista;
		1 – pagamento à prazo;
		2 – outros.
	 * @return
	 */
	public String getIndPag() {
		return indPag;
	}
	/**
	 * Indicador da forma de pagamento:
		0 – pagamento à vista;
		1 – pagamento à prazo;
		2 – outros.
	 * @param indPag
	 */
	public void setIndPag(String indPag) {
		this.indPag = indPag;
	}
	/**
	 * Código do modelo do Documento Fiscal. 55 = NF-e; 65 = NFC-e.
	 * @return
	 */
	public String getMod() {
		return mod;
	}
	/**
	 * Código do modelo do Documento Fiscal. 55 = NF-e; 65 = NFC-e.
	 * @param mod
	 */
	public void setMod(String mod) {
		this.mod = mod;
	}
	/**
	 * Série do Documento Fiscal
		série normal 0-889
		Avulsa Fisco 890-899
		SCAN 900-99
	 * @return
	 */
	public String getSerie() {
		return serie;
	}
	/**
	 * Série do Documento Fiscal
		série normal 0-889
		Avulsa Fisco 890-899
		SCAN 900-999
	 * @param serie
	 */
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getnNF() {
		return nNF;
	}
	/**
	 * Número do Documento Fiscal
	 * @param nNF
	 */
	public void setnNF(String nNF) {
		this.nNF = nNF;
	}
	public String getDhEmi() {
		return dhEmi;
	}
	/**
	 * Data e Hora de emissão do Documento Fiscal (AAAA-MM-DDThh:mm:ssTZD) ex.: 2012-09-01T13:00:00-03:00
	 * @param dEmi
	 */
	public void setDhEmi(String dhEmi) {
		this.dhEmi = dhEmi;
	}
	public String getDhSaiEnt() {
		return dhSaiEnt;
	}
	/**
	 * Data e Hora da saída ou de entrada da mercadoria / produto (AAAA-MM-DDTHH:mm:ssTZD)
	 * @param dSaiEnt
	 */
//	public void setDhSaiEnt(String dhSaiEnt) {
//		this.dhSaiEnt = dhSaiEnt;
//	}
//	
	public String getTpNF() {
		return tpNF;
	}
	/**
	 * Tipo do Documento Fiscal (0 - entrada; 1 - saída)
	 * @param tpNF
	 */
	public void setTpNF(String tpNF) {
		this.tpNF = tpNF;
	}
	public String getcMunFG() {
		return cMunFG;
	}
	public void setcMunFG(String cMunFG) {
		this.cMunFG = cMunFG;
	}
	public List<NFref> getnFref() {
		return nFref;
	}
	public void setnFref(List<NFref> nFref) {
		this.nFref = nFref;
	}
	public String getTpImp() {
		return tpImp;
	}
	/**
	 * Formato de impressão do DANFE
	 * 0-sem DANFE;
	 * 1-DANFe Retrato; 
	 * 2-DANFe Paisagem;
	 * 3-DANFe Simplificado;
	 * 4-DANFe NFC-e;
	 * 5-DANFe NFC-e em mensagem eletrônica
	 * @param tpImp
	 */
	public void setTpImp(String tpImp) {
		this.tpImp = tpImp;
	}
	public String getTpEmis() {
		return tpEmis;
	}
	/**
	 * Forma de emissão da NF-e
		1 - Normal;
		2 - Contingência FS
		3 - Contingência SCAN
		4 - Contingência DPEC
		5 - Contingência FSDA
		6 - Contingência SVC - AN
		7 - Contingência SVC - RS
		9 - Contingência off-line NFC-e
	 * @param tpEmis
	 */
	public void setTpEmis(String tpEmis) {
		this.tpEmis = tpEmis;
	}
	public String getcDV() {
		return cDV;
	}
	/**
	 * Digito Verificador da Chave de Acesso da NF-e
	 * @param cDV
	 */
	public void setcDV(String cDV) {
		this.cDV = cDV;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}
	public String getFinNFe() {
		return finNFe;
	}
	/**
	 * Finalidade da emissão da NF-e:
		1 - NFe normal
		2 - NFe complementar
		3 - NFe de ajuste
		4 - Devolução/Retorno
	 * {@link EFinalidadeNFe}
	 * @param finNFe
	 */
	public void setFinNFe(String finNFe) {
		this.finNFe = finNFe;
	}
	public String getProcEmi() {
		return procEmi;
	}
	public void setProcEmi(String procEmi) {
		this.procEmi = procEmi;
	}
	public String getVerProc() {
		return verProc;
	}
	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}
//	public String getDhCont() {
//		return dhCont;
//	}
//	public void setDhCont(String dhCont) {
//		this.dhCont = dhCont;
//	}
//	public String getxJust() {
//		return xJust;
//	}
//	public void setxJust(String xJust) {
//		this.xJust = xJust;
//	}
	public String getIdDest() {
		return idDest;
	}
	/**
	 * Identificador de Local de destino da operação (1-Interna;2-Interestadual;3-Exterior)
	 * @param idDest
	 */
	public void setIdDest(String idDest) {
		this.idDest = idDest;
	}
	public String getIndFinal() {
		return indFinal;
	}
	/**
	 * Indica operação com consumidor final (0-Não;1-Consumidor Final)
	 * @param indFinal
	 */
	public void setIndFinal(String indFinal) {
		this.indFinal = indFinal;
	}
}
