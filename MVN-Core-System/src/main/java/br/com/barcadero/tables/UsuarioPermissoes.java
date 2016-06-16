package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:35
 */
@Entity
@Table(name="USUARIO_PERMISSOES")
public class UsuarioPermissoes extends Entidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3413518513189485701L;
	public UsuarioPermissoes(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	private long codigo;
	private String descricao;
	private String permsToCadEntidade; //Permissoes para o cadastro de Entidade
	private String permsToFiliado; //Permissoes para o cadastro de Filiados
	private String permsToCadGeral; //Permissoes para todos os cadastros 
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPermsToCadEntidade() {
		return permsToCadEntidade;
	}
	public void setPermsToCadEntidade(String permsToCadEntidade) {
		this.permsToCadEntidade = permsToCadEntidade;
	}
	public String getPermsToFiliado() {
		return permsToFiliado;
	}
	public void setPermsToFiliado(String permsToFiliado) {
		this.permsToFiliado = permsToFiliado;
	}
	public String getPermsToCadGeral() {
		return permsToCadGeral;
	}
	public void setPermsToCadGeral(String permsToCadGeral) {
		this.permsToCadGeral = permsToCadGeral;
	}
	
}
