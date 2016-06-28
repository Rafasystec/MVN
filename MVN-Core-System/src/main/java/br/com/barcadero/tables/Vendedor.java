package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumSimNao;
/**
 * Classe para persistir o vendedor
 * @author Rafael Rocha
 * @since versao 1.0 - dia 15/05/2016 as 17:28
 */
@Entity
@Table(name="VENDEDOR")
public class Vendedor extends EntidadeLoja{

	public Vendedor() {
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = -7368157567275782914L;
	@Transient
	private Usuario usuario;
	@Column(name="APELIDO", nullable=false)
	private String apelido = "";
	@Column(name="PERCENT_COMISSAO", nullable=false)
	private BigDecimal percentComissao = new BigDecimal(0);
	@Column(name="FL_ATIVO", nullable=false)
	private EnumAtivo flAtivo = EnumAtivo.S;
	@Column(name="CANCELA_VENDA")
	private EnumSimNao candelaVenda = EnumSimNao.SIM;
	
	public Vendedor(Loja loja, Usuario usuario) {
		// TODO Auto-generated constructor stub
		super(loja, usuario);
		setUsuario(usuario);
	}
		
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_funcionario", referencedColumnName="codigo")
	private Funcionario funcionario = new Funcionario(getUsuario());

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

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
