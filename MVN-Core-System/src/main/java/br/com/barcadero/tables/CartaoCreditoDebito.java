package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import br.com.barcadero.core.enums.EnumCartaoBandeira;
import br.com.barcadero.core.enums.EnumTipoCartao;
import br.com.barcadero.core.enums.EnumTipoContaCartao;

@NamedQueries({
	@NamedQuery(name=CartaoCreditoDebito.FIND_ALL,query="FROM CartaoCreditoDebito WHERE empresa = :empresa AND flAtivo = :flAtivo")
})
@Entity
@Table(name="CARTAO_CREDITO_DEBITO")
public class CartaoCreditoDebito extends EntidadeEmpresa {

	public final static String FIND_ALL = "br.com.barcadero.tables.CartaoCreditoDebito";
	/**
	 * 
	 */
	private static final long serialVersionUID = 288776254454461430L;
	public CartaoCreditoDebito() {
	}
	public CartaoCreditoDebito(Empresa empresa) {
		setEmpresa(empresa);
	}
	@Column(name="NUMERO", nullable=false,length=20)
	private String numero = "";
	@Column(name="NOME_TITULAR", nullable=false, length=60)
	private String nomeTitular 	= "";
	@Column(name="MES_VALIDADE", nullable=false)
	private int mesValidade 	= 0;
	@Column(name="ANO_VALIDADE", nullable=false)
	private int anoValidade 	= 0;
	@Column(name="NUM_CONTA", nullable=false)
	private int numConta 		= 0;
	@Column(name="DIGITO", nullable=false)
	private int digito   		= 0;
	@Column(name="TP_CONTA", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoContaCartao tipoConta = EnumTipoContaCartao.CONTA_CORRENTE;
	@Column(name="TP_CARTAO", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumTipoCartao tipoCartao	  = EnumTipoCartao.CREDITO;
	@Column(name="DIA_MELHOR_COMPRA", nullable=false)
	private int diaMelhorCompra = 1;
	@Column(name="DIA_PGTO_CARTAO", nullable=false)
	private int diaPagtoCartao  = 1;
	@Column(name="BANDEIRA",nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumCartaoBandeira bandeira = EnumCartaoBandeira.OUTRA;
	@Column(name="FL_ATIVO",nullable=false)
	@ColumnDefault("'t'")
	private boolean flAtivo = true;
	@Column(name="DESCRICAO",nullable=false,length=30)
	@ColumnDefault("''")
	private String descricao = "";

	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CODIGO_BANCO",unique=true, referencedColumnName="CODIGO")
	private Bancos banco;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public int getMesValidade() {
		return mesValidade;
	}
	public void setMesValidade(int mesValidade) {
		this.mesValidade = mesValidade;
	}
	public int getAnoValidade() {
		return anoValidade;
	}
	public void setAnoValidade(int anoValidade) {
		this.anoValidade = anoValidade;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public int getDigito() {
		return digito;
	}
	public void setDigito(int digito) {
		this.digito = digito;
	}
	public EnumTipoContaCartao getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(EnumTipoContaCartao tipoConta) {
		this.tipoConta = tipoConta;
	}
	public EnumTipoCartao getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(EnumTipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public int getDiaMelhorCompra() {
		return diaMelhorCompra;
	}
	public void setDiaMelhorCompra(int diaMelhorCompra) {
		this.diaMelhorCompra = diaMelhorCompra;
	}
	public int getDiaPagtoCartao() {
		return diaPagtoCartao;
	}
	public void setDiaPagtoCartao(int diaPagtoCartao) {
		this.diaPagtoCartao = diaPagtoCartao;
	}
	public EnumCartaoBandeira getBandeira() {
		return bandeira;
	}
	public void setBandeira(EnumCartaoBandeira bandeira) {
		this.bandeira = bandeira;
	}
	public Bancos getBanco() {
		return banco;
	}
	public void setBanco(Bancos banco) {
		this.banco = banco;
	}
	public boolean isFlAtivo() {
		return flAtivo;
	}
	public void setFlAtivo(boolean flAtivo) {
		this.flAtivo = flAtivo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
