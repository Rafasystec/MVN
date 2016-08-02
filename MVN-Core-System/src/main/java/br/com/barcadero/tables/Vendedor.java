package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumSimNao;

@NamedQueries({
	
	@NamedQuery(name=Vendedor.FIND_ALL				,query="FROM Vendedor WHERE empresa = :empresa"),
	@NamedQuery(name=Vendedor.FIND_BY_CODE			,query="FROM Vendedor WHERE empresa = :empresa AND codigo = :codigo"),
	@NamedQuery(name=Vendedor.FIND_BY_COD_OR_DESC	,query="FROM Vendedor WHERE empresa = :empresa AND (codigo = :codigo OR apelido LIKE :apelido)")
})

/**
 * Classe para persistir o vendedor
 * @author Rafael Rocha
 * @since versao 1.0 - dia 15/05/2016 as 17:28
 */
@Entity
@Table(name="VENDEDOR")
public class Vendedor extends EntidadeEmpresa{

	public final static String FIND_ALL 			= "Vendedor.findAll";
	public final static String FIND_BY_CODE 		= "Vendedor.findByCode";
	public final static String FIND_BY_COD_OR_DESC 	= "Vendedor.findByCodOrDesc";
	
	public Vendedor() {
		
	}
	
	private static final long serialVersionUID = -7368157567275782914L;
	
	@Column(name="APELIDO", nullable=false)
	private String apelido = "";
	@Column(name="PERCENT_COMISSAO", nullable=false)
	private BigDecimal percentComissao = new BigDecimal(0);
	@Column(name="FL_ATIVO", nullable=false)
	private EnumAtivo flAtivo = EnumAtivo.S;
	@Column(name="CANCELA_VENDA")
	private EnumSimNao candelaVenda = EnumSimNao.SIM;
	
	public Vendedor(Empresa empresa, Usuario usuario) {
		super(empresa, usuario);
	}
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_funcionario", referencedColumnName="codigo")
	private Funcionario funcionario = new Funcionario(getUsuario());

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public BigDecimal getPercentComissao() {
		return percentComissao;
	}

	public void setPercentComissao(BigDecimal percentComissao) {
		this.percentComissao = percentComissao;
	}

	public EnumAtivo getFlAtivo() {
		return flAtivo;
	}

	public void setFlAtivo(EnumAtivo flAtivo) {
		this.flAtivo = flAtivo;
	}

	public EnumSimNao getCandelaVenda() {
		return candelaVenda;
	}

	public void setCandelaVenda(EnumSimNao candelaVenda) {
		this.candelaVenda = candelaVenda;
	}
	
}
