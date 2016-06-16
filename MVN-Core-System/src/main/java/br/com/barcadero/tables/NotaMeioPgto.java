package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Nota_meio_pgto")
public class NotaMeioPgto extends SuperClassNota {

	private static final long serialVersionUID = 1L;

	public NotaMeioPgto() {
		// TODO Auto-generated constructor stub
	}
	
	public NotaMeioPgto(Loja loja, Usuario usuario) {
		super(loja, usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="valor",nullable=false)
	private BigDecimal valor;
	@Column(name="qt_parcelas",nullable=false)
	private int qtParcelas;
	@Column(name="cd_administradora",nullable=false)
	private int cdAdministradora;
	@Transient
	private long codMeioPgto;	
	@ManyToOne
	@JoinColumn(name="cod_nota",referencedColumnName="codigo")
	private Nota nota;
	@ManyToOne
	@JoinColumn(name="cod_meio_pgto",referencedColumnName="codigo")
	private MeiosPagamento meioPagamento;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public int getQtParcelas() {
		return qtParcelas;
	}
	public void setQtParcelas(int qtParcelas) {
		this.qtParcelas = qtParcelas;
	}
	public int getCdAdministradora() {
		return cdAdministradora;
	}
	public void setCdAdministradora(int cdAdministradora) {
		this.cdAdministradora = cdAdministradora;
	}
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public MeiosPagamento getMeioPagamento() {
		return meioPagamento;
	}
	public void setMeioPagamento(MeiosPagamento meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
	public long getCodMeioPgto() {
		return codMeioPgto;
	}
	public void setCodMeioPgto(long codMeioPgto) {
		this.codMeioPgto = codMeioPgto;
	}
	
	

}
