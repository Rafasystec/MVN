package br.com.barcadero.tables;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CUPOM_ELETRONICO")
public class CupomEletronico extends SuperClassNota {

	public CupomEletronico() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 7410077273026250384L;

	public CupomEletronico(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa,loja, usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="CHV_ACESSO", nullable=false)
	private String chvAcesso = "";
	@Column(name="NR_EXTATO", nullable=false)
	private long nrExtrato = 0L;
	@Column(name="NR_SERIE_EQUIPAMENTO", nullable=false)
	private String nrSerieEquipamento = "";
	@Column(name="XML_BASE_64", nullable=false, length=100000)
	private String xmlBase64 = "";
	@Column(name="DT_EMISSAO", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEmissao = new Date();
	@Column(name="HR_EMISSAO", nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrEmissao = new Date();
	@Column(name="MENSAGEM", nullable=false)
	private String mensagem = "";
	@Column(name="MENSAGEM_CANCEL", nullable=false)
	private String mensagemCancel = "";
	@Column(name="NR_SESSAO_SAT", nullable=false)
	private String nrSessaoSat = "";
	@Column(name="NR_SESSAO_SAT_CANCEL", nullable=false)
	private String nrSessaoSatCancel = "";
	@Column(name="CHV_ACESSO_CANCEL", nullable=false)
	private String chvAcessoCancel = "";
	@Column(name="MSG_SEFAZ", nullable=false)
	private String msgSefaz = "";
	@Column(name="COD_SEFAZ", nullable=false)
	private int codSefaz = 0;
	@Column(name="COD_RET_MODULO", nullable=false)
	private int codRetModulo = 0;
	@Column(name="INF_ADICIONAIS", nullable=false)
	private String infAdicionais="";
	@Column(name="VL_TOTAL_CFE")
	private BigDecimal valorTotal = new BigDecimal(0.00);
	@Column(name="ASSINATURA_QRCODE", length=10000)
	private String assinaturaQRCode = "";
	@Column(name="XML_BASE_64_CANCEL", length=100000)
	private String xmlBase64Cancel = "";
	
	public String getXmlBase64Cancel() {
		return xmlBase64Cancel;
	}
	public void setXmlBase64Cancel(String xmlBase64Cancel) {
		this.xmlBase64Cancel = xmlBase64Cancel;
	}
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="NOTA", referencedColumnName="CODIGO")
	private Nota nota;
	
	
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public String getChvAcesso() {
		return chvAcesso;
	}
	public void setChvAcesso(String chvAcesso) {
		this.chvAcesso = chvAcesso;
	}
	public long getNrExtrato() {
		return nrExtrato;
	}
	
	public String getNrSerieEquipamento() {
		return nrSerieEquipamento;
	}
	public void setNrSerieEquipamento(String nrSerieEquipamento) {
		this.nrSerieEquipamento = nrSerieEquipamento;
	}
	public String getXmlBase64() {
		return xmlBase64;
	}
	public void setXmlBase64(String xmlBase64) {
		this.xmlBase64 = xmlBase64;
	}
	public Date getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getMensagemCancel() {
		return mensagemCancel;
	}
	public void setMensagemCancel(String mensagemCancel) {
		this.mensagemCancel = mensagemCancel;
	}
	public String getNrSessaoSat() {
		return nrSessaoSat;
	}
	public void setNrSessaoSat(String nrSessaoSat) {
		this.nrSessaoSat = nrSessaoSat;
	}
	public String getNrSessaoSatCancel() {
		return nrSessaoSatCancel;
	}
	public void setNrSessaoSatCancel(String nrSessaoSatCancel) {
		this.nrSessaoSatCancel = nrSessaoSatCancel;
	}
	public String getChvAcessoCancel() {
		return chvAcessoCancel;
	}
	public void setChvAcessoCancel(String chvAcessoCancel) {
		this.chvAcessoCancel = chvAcessoCancel;
	}
	public String getMsgSefaz() {
		return msgSefaz;
	}
	public void setMsgSefaz(String msgSefaz) {
		this.msgSefaz = msgSefaz;
	}
	public int getCodSefaz() {
		return codSefaz;
	}
	public void setCodSefaz(int codSefaz) {
		this.codSefaz = codSefaz;
	}
	public int getCodRetModulo() {
		return codRetModulo;
	}
	public void setCodRetModulo(int codRetModulo) {
		this.codRetModulo = codRetModulo;
	}
	public void setNrExtrato(long nrExtrato) {
		this.nrExtrato = nrExtrato;
	}
	public String getInfAdicionais() {
		return infAdicionais;
	}
	public void setInfAdicionais(String infAdicionais) {
		this.infAdicionais = infAdicionais;
	}
	public Date getHrEmissao() {
		return hrEmissao;
	}
	public void setHrEmissao(Date hrEmissao) {
		this.hrEmissao = hrEmissao;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getAssinaturaQRCode() {
		return assinaturaQRCode;
	}
	public void setAssinaturaQRCode(String assinaturaQRCode) {
		this.assinaturaQRCode = assinaturaQRCode;
	}	
}
