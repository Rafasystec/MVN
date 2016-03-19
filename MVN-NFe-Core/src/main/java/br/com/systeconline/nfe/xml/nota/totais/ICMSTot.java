package br.com.systeconline.nfe.xml.nota.totais;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Totais referentes ao ICMS
 * @author Rafael Rocha
 * @since dia 18/03/2016 as 22:18
 */

//W02
@XmlRootElement(name="ICMSTot")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMSTot {

	private String vBC;
	private String vICMS;
	private String vICMSDeson;
	private String vFCPUFDest;
	private String vICMSUFDest;
	private String vICMSUFRemet;
	private String vBCST;
	private String vST;
	private String vProd;
	private String vFrete;
	private String vSeg;
	private String vDesc;
	private String vII;
	private String vIPI;
	private String vPIS;
	private String vCOFINS;
	private String vOutro;
	private String vNF;
	private String vTotTrib;
	
	/**
	 * Base de Calculo do ICMS
	 * @return
	 */
	public String getvBC() {
		return vBC;
	}
	/**
	 * Base de Calculo do ICMS
	 * @param vBC
	 */
	public void setvBC(String vBC) {
		this.vBC = vBC;
	}
	/**
	 * Valor Total do ICMS
	 * @return
	 */
	public String getvICMS() {
		return vICMS;
	}
	/**
	 * Valor Total do ICMS
	 * @param vICMS
	 */
	public void setvICMS(String vICMS) {
		this.vICMS = vICMS;
	}
	/**
	 * Valor Total do ICMS desonerado
	 * @return
	 */
	public String getvICMSDeson() {
		return vICMSDeson;
	}
	/**
	 * Valor Total do ICMS desonerado
	 * @param vICMSDeson
	 */
	public void setvICMSDeson(String vICMSDeson) {
		this.vICMSDeson = vICMSDeson;
	}
	/**
	 * Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino.
	 * @return
	 */
	public String getvFCPUFDest() {
		return vFCPUFDest;
	}
	/**
	 * Valor total do ICMS relativo ao Fundo de Combate à Pobreza (FCP) para a UF de destino.
	 * @param vFCPUFDest
	 */
	public void setvFCPUFDest(String vFCPUFDest) {
		this.vFCPUFDest = vFCPUFDest;
	}
	/**
	 * Valor total do ICMS de partilha para a UF do remetente
	 * @return
	 */
	public String getvICMSUFRemet() {
		return vICMSUFRemet;
	}
	/**
	 * Valor total do ICMS de partilha para a UF do remetente
	 * @param vICMSUFRemet
	 */
	public void setvICMSUFRemet(String vICMSUFRemet) {
		this.vICMSUFRemet = vICMSUFRemet;
	}
	/**
	 * Base de Calculo do ICMS ST
	 * @return
	 */
	public String getvBCST() {
		return vBCST;
	}
	/**
	 * Base de Calculo do ICMS ST
	 * @param vBCST
	 */
	public void setvBCST(String vBCST) {
		this.vBCST = vBCST;
	}
	/**
	 * Valor Total do ICMS Substituicao Tributaria
	 * @return
	 */
	public String getvST() {
		return vST;
	}
	/**
	 * Valor Total do ICMS Substituicao Tributaria
	 * @param vST
	 */
	public void setvST(String vST) {
		this.vST = vST;
	}
	/**
	 * Valor Total dos produtos e servicos
	 * @return
	 */
	public String getvProd() {
		return vProd;
	}
	/**
	 * Valor Total dos produtos e servicos
	 * @param vProd
	 */
	public void setvProd(String vProd) {
		this.vProd = vProd;
	}
	/**
	 * Valor Total do Frete
	 * @return
	 */
	public String getvFrete() {
		return vFrete;
	}
	/**
	 * Valor Total do Frete
	 * @param vFrete
	 */
	public void setvFrete(String vFrete) {
		this.vFrete = vFrete;
	}
	/**
	 * Valor Total do Seguro
	 * @return
	 */
	public String getvSeg() {
		return vSeg;
	}
	/**
	 * Valor Total do Seguro
	 * @param vSeg
	 */
	public void setvSeg(String vSeg) {
		this.vSeg = vSeg;
	}
	/**
	 * Valor Total do Desconto
	 * @return
	 */
	public String getvDesc() {
		return vDesc;
	}
	/**
	 * Valor Total do Desconto
	 * @param vDesc
	 */
	public void setvDesc(String vDesc) {
		this.vDesc = vDesc;
	}
	/**
	 * Valor Total do II
	 * @return
	 */
	public String getvII() {
		return vII;
	}
	/**
	 * Valor Total do II
	 * @param vII
	 */
	public void setvII(String vII) {
		this.vII = vII;
	}
	/**
	 * Valor Total do IPI
	 * @return
	 */
	public String getvIPI() {
		return vIPI;
	}
	/**
	 * Valor Total do IPI
	 * @param vIPI
	 */
	public void setvIPI(String vIPI) {
		this.vIPI = vIPI;
	}
	/**
	 * Valor do PIS
	 * @return
	 */
	public String getvPIS() {
		return vPIS;
	}
	/**
	 * Valor do PIS
	 * @param vPIS
	 */
	public void setvPIS(String vPIS) {
		this.vPIS = vPIS;
	}
	/**
	 * Valor do COFINS
	 * @return
	 */
	public String getvCOFINS() {
		return vCOFINS;
	}
	/**
	 * Valor do COFINS
	 * @param vCOFINS
	 */
	public void setvCOFINS(String vCOFINS) {
		this.vCOFINS = vCOFINS;
	}
	/**
	 * Outras Despesas acessórias
	 * @return
	 */
	public String getvOutro() {
		return vOutro;
	}
	/**
	 * Outras Despesas acessórias
	 * @param vOutro
	 */
	public void setvOutro(String vOutro) {
		this.vOutro = vOutro;
	}
	/**
	 * Valor Total da NF-e
	 * @return
	 */
	public String getvNF() {
		return vNF;
	}
	/**
	 * Valor Total da NF-e
	 * @param vNF
	 */
	public void setvNF(String vNF) {
		this.vNF = vNF;
	}
	/**
	 * Valor estimado total de impostos federais, estaduais e municipais
	 * @return
	 */
	public String getvTotTrib() {
		return vTotTrib;
	}
	/**
	 * Valor estimado total de impostos federais, estaduais e municipais
	 * @param vTotTrib
	 */
	public void setvTotTrib(String vTotTrib) {
		this.vTotTrib = vTotTrib;
	}
	public String getvICMSUFDest() {
		return vICMSUFDest;
	}
	public void setvICMSUFDest(String vICMSUFDest) {
		this.vICMSUFDest = vICMSUFDest;
	}

}
