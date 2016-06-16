package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import br.com.barcadero.tables.ComponentesGestao;


public class BeanFormaGestao {

	private String tpGestao;
	private String outraGestao;
	//NOTE: Indica 'S' se for filiado a uma federacao, caso contrario 'N' (nao)
	private String flFiliadoFeder;
	private String filiadoA;
	private String confederA;
	//NOTE: Indica 'S' se for filiado a uma Confederacao, caso contrario 'N' (nao)
	private String flFiliadoConfer;
	private Date dtEleicao;
	private Date dtPosse;
	private int duracaoMandato;
	private long codEntidade;
	private List<ComponentesGestao> componentes;
	private ComponentesGestao componente;
	
	public ComponentesGestao getComponente() {
		return componente;
	}
	public void setComponente(ComponentesGestao componente) {
		this.componente = componente;
	}
	public List<ComponentesGestao> getComponentes() {
		return componentes;
	}
	public void setComponentes(List<ComponentesGestao> componentes) {
		this.componentes = componentes;
	}
	public String getTpGestao() {
		return tpGestao;
	}
	public void setTpGestao(String tpGestao) {
		this.tpGestao = tpGestao;
	}
	public String getOutraGestao() {
		return outraGestao;
	}
	public void setOutraGestao(String outraGestao) {
		this.outraGestao = outraGestao;
	}
	public String getFlFiliadoFeder() {
		return flFiliadoFeder;
	}
	public void setFlFiliadoFeder(String flFiliadoFeder) {
		this.flFiliadoFeder = flFiliadoFeder;
	}
	public String getFiliadoA() {
		return filiadoA;
	}
	public void setFiliadoA(String filiadoA) {
		this.filiadoA = filiadoA;
	}
	public String getConfederA() {
		return confederA;
	}
	public void setConfederA(String confederA) {
		this.confederA = confederA;
	}
	public String getFlFiliadoConfer() {
		return flFiliadoConfer;
	}
	public void setFlFiliadoConfer(String flFiliadoConfer) {
		this.flFiliadoConfer = flFiliadoConfer;
	}
	public Date getDtEleicao() {
		return dtEleicao;
	}
	public void setDtEleicao(Date dtEleicao) {
		this.dtEleicao = dtEleicao;
	}
	public Date getDtPosse() {
		return dtPosse;
	}
	public void setDtPosse(Date dtPosse) {
		this.dtPosse = dtPosse;
	}
	public int getDuracaoMandato() {
		return duracaoMandato;
	}
	public void setDuracaoMandato(int duracaoMandato) {
		this.duracaoMandato = duracaoMandato;
	}
	public long getCodEntidade() {
		return codEntidade;
	}
	public void setCodEntidade(long codEntidade) {
		this.codEntidade = codEntidade;
	}
	
}
