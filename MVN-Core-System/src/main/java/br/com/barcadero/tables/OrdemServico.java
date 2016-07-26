package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumNotaAtendimento;
import br.com.barcadero.core.enums.EnumTipoOS;
import br.com.barcadero.core.util.GlobalNameParam;

/**
 * Classe para salvar a OS
 * @author antoniorafael
 */
@Entity
@Table(name="ORDEM_SERVICO")
public class OrdemServico extends EntidadeLoja {

	
	public OrdemServico(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}
	private static final long serialVersionUID = 8721539366117609577L;
	@Column(name="DT_ENTRADA")
	private Date dtEntrada;
	@Column(name="HR_ENTRADA")
	private Date hrEntrada;
	@Column(name="DT_SAIDA")
	private Date dtSaida;
	@Column(name="HR_SAIDA")
	private Date hrSaida;
	@Column(name="DT_PREVISAO_ENTREGA")
	private Date dtPrevisaoEntrega;
	@Column(name="NOTA_ATENDIMENTO")
	private EnumNotaAtendimento notaAtendimento;
	@Column(name="PLACA_VEICULO", length=10)
	private String placaVeiculo = "";
	@Column(name="RESPONSAVEL", length=60)
	private String responsavel  = "";
	@Column(name="MEDIA_KM_DIA")
	private int mediaKMDia 		= 0;
	@Column(name="KM_ATUAL")
	private int kmAtual			= 0;
	@Column(name="DESCRICAO", length=60)
	private String descricao	= "";
	@Column(name="NUM_NFE")
	private long numNFe			= 0L;
	@Column(name="NUM_NFSE")
	private long numNFSe		= 0L;
	@Column(name="CONTRATO", length=20)
	private String contrato		= "";
	@Column(name="CONTATO", length=15)
	private String contato		= "";
	
	@ManyToOne
	@JoinColumn(name=GlobalNameParam.PARAM_CLIENTE,referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Cliente cliente;
	@Column(name="TIPO_OS",length=14)
	@Enumerated(EnumType.STRING)
	private EnumTipoOS tipoOS = EnumTipoOS.ORCAMENTO;
	@ManyToOne
	@JoinColumn(name=GlobalNameParam.PARAM_VENDEDOR,referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Vendedor vendedor;
	
	public Date getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public Date getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(Date hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public Date getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	public Date getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(Date hrSaida) {
		this.hrSaida = hrSaida;
	}
	public Date getDtPrevisaoEntrega() {
		return dtPrevisaoEntrega;
	}
	public void setDtPrevisaoEntrega(Date dtPrevisaoEntrega) {
		this.dtPrevisaoEntrega = dtPrevisaoEntrega;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public EnumNotaAtendimento getNotaAtendimento() {
		return notaAtendimento;
	}
	public void setNotaAtendimento(EnumNotaAtendimento notaAtendimento) {
		this.notaAtendimento = notaAtendimento;
	}
	public EnumTipoOS getTipoOS() {
		return tipoOS;
	}
	public void setTipoOS(EnumTipoOS tipoOS) {
		this.tipoOS = tipoOS;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public int getMediaKMDia() {
		return mediaKMDia;
	}
	public void setMediaKMDia(int mediaKMDia) {
		this.mediaKMDia = mediaKMDia;
	}
	public int getKmAtual() {
		return kmAtual;
	}
	public void setKmAtual(int kmAtual) {
		this.kmAtual = kmAtual;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getNumNFe() {
		return numNFe;
	}
	public void setNumNFe(long numNFe) {
		this.numNFe = numNFe;
	}
	public long getNumNFSe() {
		return numNFSe;
	}
	public void setNumNFSe(long numNFSe) {
		this.numNFSe = numNFSe;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	
}
