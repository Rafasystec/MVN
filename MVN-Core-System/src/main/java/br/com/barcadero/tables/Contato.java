package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe criada para persistir os contatos dos Filiados, funcionarios ou qualquer outra pressoa do sistema
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta 24/09/2013 06:30
 */
@Entity
public class Contato extends Entidade{
	@Column(name="cod_pessoa",nullable=false)
	private long codPessoa;
	private int dddCel01;
	private int dddCel02;
	private int dddTel01;
	private int dddTel02;
	private int dddTelComerc;
	private String cell01;
	private String cell02;
	private String tel01;
	private String tel02;
	private String telComerc;
	private String email01;
	private String email02;
	
	public long getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}
	public int getDddCel01() {
		return dddCel01;
	}
	public void setDddCel01(int dddCel01) {
		this.dddCel01 = dddCel01;
	}
	public int getDddCel02() {
		return dddCel02;
	}
	public void setDddCel02(int dddCel02) {
		this.dddCel02 = dddCel02;
	}
	public int getDddTel01() {
		return dddTel01;
	}
	public void setDddTel01(int dddTel01) {
		this.dddTel01 = dddTel01;
	}
	public int getDddTel02() {
		return dddTel02;
	}
	public void setDddTel02(int dddTel02) {
		this.dddTel02 = dddTel02;
	}
	public int getDddTelComerc() {
		return dddTelComerc;
	}
	public void setDddTelComerc(int dddTelComerc) {
		this.dddTelComerc = dddTelComerc;
	}
	public String getCell01() {
		return cell01;
	}
	public void setCell01(String cell01) {
		this.cell01 = cell01;
	}
	public String getCell02() {
		return cell02;
	}
	public void setCell02(String cell02) {
		this.cell02 = cell02;
	}
	public String getTel01() {
		return tel01;
	}
	public void setTel01(String tel01) {
		this.tel01 = tel01;
	}
	public String getTel02() {
		return tel02;
	}
	public void setTel02(String tel02) {
		this.tel02 = tel02;
	}
	public String getTelComerc() {
		return telComerc;
	}
	public void setTelComerc(String telComerc) {
		this.telComerc = telComerc;
	}
	public String getEmail01() {
		return email01;
	}
	public void setEmail01(String email01) {
		this.email01 = email01;
	}
	public String getEmail02() {
		return email02;
	}
	public void setEmail02(String email02) {
		this.email02 = email02;
	}
	
}
