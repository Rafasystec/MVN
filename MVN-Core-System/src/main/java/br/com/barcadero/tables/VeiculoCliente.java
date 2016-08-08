package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEICULO_CLIENTE")
public class VeiculoCliente extends VeiculoSuperClass {
	
	public VeiculoCliente() {
		// TODO Auto-generated constructor stub
	}
	public VeiculoCliente(Empresa empresa,Usuario usuario) {
		super(empresa,usuario);
	}
	
	private static final long serialVersionUID = 590321629419981382L;

	
	@Column(name="RESPONSAVEL")
	private String responsavel;
	
	@ManyToOne(fetch=FetchType.LAZY,targetEntity=ProdutoLoja.class)
	@JoinColumn(name="cod_cliente",referencedColumnName="codigo")
	private Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
