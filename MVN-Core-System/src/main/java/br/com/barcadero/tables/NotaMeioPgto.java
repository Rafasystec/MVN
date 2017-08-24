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
@Table(name="NOTA_MEIO_PGTO")
public class NotaMeioPgto extends SuperClassNota {

	private static final long serialVersionUID = 1L;

	public NotaMeioPgto() {
		
	}
	
	public NotaMeioPgto(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}

	@Column
	private BigDecimal valor;
	@Column
	private int qtParcelas;
	@Column
	private int cdAdministradora;
	@Column
	@Enumerated(EnumType.STRING)
	private EnumTipoMeioPgto tipoMeioPgto;
	@Transient
	private long codMeioPgto;	
	@ManyToOne
	@JoinColumn(name=GlobalNameParam.PARAM_NOTA,referencedColumnName="codigo")
	private Nota nota;
	
	@ManyToOne
	@JoinColumn(name="meiopagamento",referencedColumnName="codigo")
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
