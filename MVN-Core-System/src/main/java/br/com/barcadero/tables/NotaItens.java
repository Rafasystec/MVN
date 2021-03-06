package br.com.barcadero.tables;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.com.barcadero.core.enums.EnumCSTCOFINS;
import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTIPI;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumCompeTotalNota;
import br.com.barcadero.core.enums.EnumItemCancelado;
import br.com.barcadero.core.util.GlobalNameParam;

@NamedQueries({	
	@NamedQuery(name=NotaItens.FIND_ALL			, query="FROM NotaItens WHERE empresa = :empresa AND loja = :loja"),
	@NamedQuery(name=NotaItens.FIND_BY_NOTA		, query="FROM NotaItens WHERE codigo = :codigo AND empresa = :empresa AND loja = :loja"),
	@NamedQuery(name=NotaItens.FIND_BY_CODE_NOTA, query="FROM NotaItens WHERE empresa = :empresa AND loja = :loja AND nota = :nota ORDER BY hrCadastro ASC")
})
@Entity
@Table(name="NOTA_ITENS")
public class NotaItens extends SuperClassNota {

	private static final long serialVersionUID = -4093202981241236920L;

	public NotaItens(){
		
	}
	
	
	public NotaItens(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
		setEmpresa(empresa);
	}
	
	public static final String FIND_ALL     	 = "NotaItens.findAll";
	public static final String FIND_BY_NOTA 	 = "NotaItens.findByNota";
	public static final String FIND_BY_CODE_NOTA = "NotaItens.findByCodeNota";
	public static final String PARAM_COD_NOTA    = "nota";
	
	@Column(nullable=false,precision=20,scale=3)
	private float quantidade;
	@Column(nullable=false)
	private BigDecimal pcDesc = new BigDecimal(0D);
	@Column(nullable=false)
	private BigDecimal vlDesc = new BigDecimal(0D);
	@Column(nullable=false)
	private BigDecimal vlTotal = new BigDecimal(0.00);
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumItemCancelado flCancelado = EnumItemCancelado.N;
	@Column
	private BigDecimal vlTotFrete = new BigDecimal(0);;
	@Column
	private BigDecimal vlTotSeguro = new BigDecimal(0);
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCompeTotalNota flCompoeTotNota = EnumCompeTotalNota.N;
	@Column
	private int nrItem 			 = 0;
	@Column
	private String cdProd 		 = "00000000000000";
	@Column
	private String descricao 	 = "";
	@Column
	private BigDecimal vlUnidade = new BigDecimal(0.00);
	@Column
	private String inforAdicionais = "";
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCSTIPI cstIPI;
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCSTPIS cstPIS;
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCSTCOFINS cstCOFINS;
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCSTICMS cstICMS;
	@Column
	private BigDecimal icms = new BigDecimal(0.00);
	@Column(precision=20, scale=4)
	private float pis = 0.0000f;
	@Column(precision=20, scale=4)
	private float cofins = 0.0000f;
	
	
	@ManyToOne
	@JoinColumn(name="nota",referencedColumnName="codigo")
	private Nota nota;
	
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_PRODUTO, referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Produto produto;
	
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPcDesc() {
		return pcDesc;
	}
	public void setPcDesc(BigDecimal pcDesc) {
		this.pcDesc = pcDesc;
	}
	public BigDecimal getVlDesc() {
		return vlDesc;
	}
	public void setVlDesc(BigDecimal vlDesc) {
		this.vlDesc = vlDesc;
	}
	public BigDecimal getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}
	public EnumItemCancelado getFlCancelado() {
		return flCancelado;
	}
	public void setFlCancelado(EnumItemCancelado flCancelado) {
		this.flCancelado = flCancelado;
	}
	public BigDecimal getVlTotFrete() {
		return vlTotFrete;
	}
	public void setVlTotFrete(BigDecimal vlTotFrete) {
		this.vlTotFrete = vlTotFrete;
	}
	public BigDecimal getVlTotSeguro() {
		return vlTotSeguro;
	}
	public void setVlTotSeguro(BigDecimal vlTotSeguro) {
		this.vlTotSeguro = vlTotSeguro;
	}
	public EnumCompeTotalNota getFlCompoeTotNota() {
		return flCompoeTotNota;
	}
	public void setFlCompoeTotNota(EnumCompeTotalNota flCompoeTotNota) {
		this.flCompoeTotNota = flCompoeTotNota;
	}
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public int getNrItem() {
		return nrItem;
	}
	public void setNrItem(int nrItem) {
		this.nrItem = nrItem;
	}
	public String getCdProd() {
		return cdProd;
	}
	public void setCdProd(String cdProd) {
		this.cdProd = cdProd;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getVlUnidade() {
		return vlUnidade;
	}
	public void setVlUnidade(BigDecimal vlUnidade) {
		this.vlUnidade = vlUnidade;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getInforAdicionais() {
		return inforAdicionais;
	}
	public void setInforAdicionais(String inforAdicionais) {
		this.inforAdicionais = inforAdicionais;
	}
	public EnumCSTIPI getCstIPI() {
		return cstIPI;
	}
	public void setCstIPI(EnumCSTIPI cstIPI) {
		this.cstIPI = cstIPI;
	}
	public EnumCSTPIS getCstPIS() {
		return cstPIS;
	}
	public void setCstPIS(EnumCSTPIS cstPIS) {
		this.cstPIS = cstPIS;
	}
	public EnumCSTCOFINS getCstCOFINS() {
		return cstCOFINS;
	}
	public void setCstCOFINS(EnumCSTCOFINS cstCOFINS) {
		this.cstCOFINS = cstCOFINS;
	}
	public EnumCSTICMS getCstICMS() {
		return cstICMS;
	}
	public void setCstICMS(EnumCSTICMS cstICMS) {
		this.cstICMS = cstICMS;
	}
	public BigDecimal getIcms() {
		return icms;
	}
	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}
	public float getPis() {
		return pis;
	}
	public void setPis(float pis) {
		this.pis = pis;
	}
	public float getCofins() {
		return cofins;
	}
	public void setCofins(float cofins) {
		this.cofins = cofins;
	}
}
