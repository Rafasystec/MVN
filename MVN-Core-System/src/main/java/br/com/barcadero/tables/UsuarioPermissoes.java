package br.com.barcadero.tables;

import javax.persistence.Column;
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
	public UsuarioPermissoes() {	
	}
	public UsuarioPermissoes(Usuario usuario) {
		super(usuario);
	}
	@Column(name="ACESSA_CADASTROS",nullable=false)
	private boolean podeAcessarCadastros = true;
	@Column(name="ACESSA_FINANCEIRO",nullable=false)
	private boolean podeAcessarFinanceiro = false;
	@Column(name="ACESSA_COLABORADORES",nullable=false)
	private boolean podeAcessarColaboradores = false;
	@Column(name="ACESSA_OPERACIONAL",nullable=false)
	private boolean podeAcessarOperacional = true;
	@Column(name="ACESSA_CRM",nullable=false)
	private boolean podeAcessarCRM = false;
	@Column(name="ACESSA_RECEBIMENTO",nullable=false)
	private boolean podeAcessarRecebimento = true;
	@Column(name="ACESSA_PAGAMENTO",nullable=false)
	private boolean podeAcessarPagamentos = false;
	@Column(name="ACESSA_CONFIGURACOES",nullable=false)
	private boolean podeAcessarConfiguracoes = false;
	@Column(name="ACESSA_RELATORIO",nullable=false)
	private boolean podeAcessarRelatorio = false;
	
	
	public boolean isPodeAcessarCadastros() {
		return podeAcessarCadastros;
	}
	public void setPodeAcessarCadastros(boolean podeAcessarCadastros) {
		this.podeAcessarCadastros = podeAcessarCadastros;
	}
	public boolean isPodeAcessarFinanceiro() {
		return podeAcessarFinanceiro;
	}
	public void setPodeAcessarFinanceiro(boolean podeAcessarFinanceiro) {
		this.podeAcessarFinanceiro = podeAcessarFinanceiro;
	}
	public boolean isPodeAcessarColaboradores() {
		return podeAcessarColaboradores;
	}
	public void setPodeAcessarColaboradores(boolean podeAcessarColaboradores) {
		this.podeAcessarColaboradores = podeAcessarColaboradores;
	}
	public boolean isPodeAcessarOperacional() {
		return podeAcessarOperacional;
	}
	public void setPodeAcessarOperacional(boolean podeAcessarOperacional) {
		this.podeAcessarOperacional = podeAcessarOperacional;
	}
	public boolean isPodeAcessarCRM() {
		return podeAcessarCRM;
	}
	public void setPodeAcessarCRM(boolean podeAcessarCRM) {
		this.podeAcessarCRM = podeAcessarCRM;
	}
	public boolean isPodeAcessarRecebimento() {
		return podeAcessarRecebimento;
	}
	public void setPodeAcessarRecebimento(boolean podeAcessarRecebimento) {
		this.podeAcessarRecebimento = podeAcessarRecebimento;
	}
	public boolean isPodeAcessarPagamentos() {
		return podeAcessarPagamentos;
	}
	public void setPodeAcessarPagamentos(boolean podeAcessarPagamentos) {
		this.podeAcessarPagamentos = podeAcessarPagamentos;
	}
	public boolean isPodeAcessarConfiguracoes() {
		return podeAcessarConfiguracoes;
	}
	public void setPodeAcessarConfiguracoes(boolean podeAcessarConfiguracoes) {
		this.podeAcessarConfiguracoes = podeAcessarConfiguracoes;
	}
	public boolean isPodeAcessarRelatorio() {
		return podeAcessarRelatorio;
	}
	public void setPodeAcessarRelatorio(boolean podeAcessarRelatorio) {
		this.podeAcessarRelatorio = podeAcessarRelatorio;
	}
	
	
	
	
}
