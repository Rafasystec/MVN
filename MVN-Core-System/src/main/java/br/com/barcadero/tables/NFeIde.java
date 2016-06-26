package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import br.com.barcadero.core.enums.EnumIndicadorPagamento;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNFeFinalidadeEmissao;
import br.com.barcadero.core.enums.EnumNFeIndPresencaComprador;
import br.com.barcadero.core.enums.EnumNFeTpEmissao;
import br.com.barcadero.core.enums.EnumNFeTpImpressao;
import br.com.barcadero.core.enums.EnumNFeTpProcessoEmissao;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;

@Entity
@Table(name="NFE_IDE")
public class NFeIde extends Entidade{

	@Transient
	private static final long serialVersionUID = 7347139889419877855L;
	
	@Column(name="UF")
	private String cUF;
	@Column(name="NF")
	private String cNF;
	@Column(name="NAT_OP")
	@Enumerated(EnumType.STRING)
	private EnumNaturezaOperacao natOp;
	@Column(name="IND_PAG")
	@Enumerated(EnumType.STRING)
	private EnumIndicadorPagamento indPag;
	@Column(name="MOD")
	@Enumerated(EnumType.STRING)
	private EnumModeloNota mod;
	@Column(name="SERIE")
	private String serie;
	@Column(name="N_NF")
	private String nNF;
	@Column(name="DH_EMI")
	@Enumerated(EnumType.STRING)
	@Temporal(TemporalType.TIMESTAMP)
	private String dhEmi;
	@Column(name="DH_SAIENT")
	private String dhSaiEnt;
	@Column(name="TP_NF")
	@Enumerated(EnumType.STRING)
	private EnumNaturezaOperacao tpNF;
	@Column(name="ID_DEST")
	private String idDest;
	@Column(name="MUN_FG")
	private String cMunFG;
	@Column(name="TP_IMP")
	@Enumerated(EnumType.STRING)
	private EnumNFeTpImpressao tpImp;
	@Column(name="TP_EMIS")
	@Enumerated(EnumType.STRING)
	private EnumNFeTpEmissao tpEmis;
	@Column(name="DV")
	private String cDV;
	@Column(name="TP_AMB")
	private String tpAmb;
	@Column(name="FIN_NFE")
	@Enumerated(EnumType.STRING)
	private EnumNFeFinalidadeEmissao finNfe;
	@Column(name="IND_PRES")
	@Enumerated(EnumType.STRING)
	private EnumNFeIndPresencaComprador indPres;
	@Column(name="PROC_EMI")
	@Enumerated(EnumType.STRING)
	private EnumNFeTpProcessoEmissao procEmi;
	@Column(name="VER_PROC")
	private String verProc;
	@Column(name="DH_CONT")
	private String dhCont;
	@Column(name="X_JUST")
	private String xJust;
	@Column(name="NR_ECF")
	private String nrECF;
	@Column(name="NR_COO")
	private String nrCOO;
	
	public String getcUF() {
		return cUF;
	}
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public String getcNF() {
		return cNF;
	}
	public void setcNF(String cNF) {
		this.cNF = cNF;
	}
	public EnumNaturezaOperacao getNatOp() {
		return natOp;
	}
	public void setNatOp(EnumNaturezaOperacao natOp) {
		this.natOp = natOp;
	}
	public EnumIndicadorPagamento getIndPag() {
		return indPag;
	}
	public void setIndPag(EnumIndicadorPagamento indPag) {
		this.indPag = indPag;
	}
	public EnumModeloNota getMod() {
		return mod;
	}
	public void setMod(EnumModeloNota mod) {
		this.mod = mod;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getnNF() {
		return nNF;
	}
	public void setnNF(String nNF) {
		this.nNF = nNF;
	}
	public String getDhEmi() {
		return dhEmi;
	}
	public void setDhEmi(String dhEmi) {
		this.dhEmi = dhEmi;
	}
	public String getDhSaiEnt() {
		return dhSaiEnt;
	}
	public void setDhSaiEnt(String dhSaiEnt) {
		this.dhSaiEnt = dhSaiEnt;
	}
	public EnumNaturezaOperacao getTpNF() {
		return tpNF;
	}
	public void setTpNF(EnumNaturezaOperacao tpNF) {
		this.tpNF = tpNF;
	}
	public String getIdDest() {
		return idDest;
	}
	public void setIdDest(String idDest) {
		this.idDest = idDest;
	}
	public String getcMunFG() {
		return cMunFG;
	}
	public void setcMunFG(String cMunFG) {
		this.cMunFG = cMunFG;
	}
	public EnumNFeTpImpressao getTpImp() {
		return tpImp;
	}
	public void setTpImp(EnumNFeTpImpressao tpImp) {
		this.tpImp = tpImp;
	}
	public EnumNFeTpEmissao getTpEmis() {
		return tpEmis;
	}
	public void setTpEmis(EnumNFeTpEmissao tpEmis) {
		this.tpEmis = tpEmis;
	}
	public String getcDV() {
		return cDV;
	}
	public void setcDV(String cDV) {
		this.cDV = cDV;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}
	public EnumNFeFinalidadeEmissao getFinNfe() {
		return finNfe;
	}
	public void setFinNfe(EnumNFeFinalidadeEmissao finNfe) {
		this.finNfe = finNfe;
	}
	public EnumNFeIndPresencaComprador getIndPres() {
		return indPres;
	}
	public void setIndPres(EnumNFeIndPresencaComprador indPres) {
		this.indPres = indPres;
	}
	public EnumNFeTpProcessoEmissao getProcEmi() {
		return procEmi;
	}
	public void setProcEmi(EnumNFeTpProcessoEmissao procEmi) {
		this.procEmi = procEmi;
	}
	public String getVerProc() {
		return verProc;
	}
	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}
	public String getDhCont() {
		return dhCont;
	}
	public void setDhCont(String dhCont) {
		this.dhCont = dhCont;
	}
	public String getxJust() {
		return xJust;
	}
	public void setxJust(String xJust) {
		this.xJust = xJust;
	}
	public String getNrECF() {
		return nrECF;
	}
	public void setNrECF(String nrECF) {
		this.nrECF = nrECF;
	}
	public String getNrCOO() {
		return nrCOO;
	}
	public void setNrCOO(String nrCOO) {
		this.nrCOO = nrCOO;
	}
	
	

}
