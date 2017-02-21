package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@NamedQueries({
	@NamedQuery(name=CaixaAbertura.FIND_ALL,query="FROM CaixaAbertura WHERE empresa = :empresa"),
	@NamedQuery(name=CaixaAbertura.FIND_BY_CAIXA,query="FROM CaixaAbertura WHERE empresa = :empresa AND caixa = :caixa AND loja = :loja"),
	@NamedQuery(name=CaixaAbertura.FIND_BY_LOJA,query="FROM CaixaAbertura WHERE empresa = :empresa AND loja = :loja")
})
/**
 * Classe para salvar as aberturas de caixa que ocorrerem
 * @author Rafael Rocha
 * @since versao 1.0 dia 24/02/2016 as 10:20
 */
@Audited
@Entity
@Table(name="CAIXA_ABERTURA")
public class CaixaAbertura extends EntidadeLoja {
	private static final long serialVersionUID = -5256587585543120837L;
	public static final String FIND_ALL 		= "CaixaAbertura.findAll";
	public static final String FIND_BY_CAIXA 	= "CaixaAbertura.findByCaixa";
	public static final String FIND_BY_LOJA 	= "CaixaAbertura.findByLoja";
	
	public CaixaAbertura() {
		// TODO Auto-generated constructor stub
	}
	
	public CaixaAbertura(Empresa empresa, Loja loja, Usuario usuario){
		super(empresa,loja,usuario);
	}
	
	@Column(name="SUPRIMENTO")
	private BigDecimal suprimento;
	@ManyToOne
	@JoinColumn(name="caixa", referencedColumnName="codigo")
	private Caixa caixa;
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public BigDecimal getSuprimento() {
		return suprimento;
	}

	public void setSuprimento(BigDecimal suprimento) {
		this.suprimento = suprimento;
	}	
	
}
