package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.barcadero.core.enums.EnumTipoMeioPgto;
import br.com.barcadero.core.util.GlobalNameParam;

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

	@Column(name="VALOR",nullable=false)
	private BigDecimal valor;
	@Column(name="QT_PARCELAS",nullable=false)
	private int qtParcelas;
	@Column(name="CD_ADMINISTRADORA",nullable=false)
	private int cdAdministradora;
	@Column(name="MEIO_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private EnumTipoMeioPgto tipoMeioPgto;
	@Transient
	private long codMeioPgto;	
	@ManyToOne
	@JoinColumn(name=GlobalNameParam.PARAM_NOTA,referencedColumnName="codigo")
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

	public EnumTipoMeioPgto getTipoMeioPgto() {
		return tipoMeioPgto;
	}

	public void setTipoMeioPgto(EnumTipoMeioPgto tipoMeioPgto) {
		this.tipoMeioPgto = tipoMeioPgto;
	}
	
}
