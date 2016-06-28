package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import br.com.barcadero.core.enums.EnumTipoCombustivel;
import br.com.barcadero.core.enums.EnumTracaoVeiculo;

@MappedSuperclass
public abstract class VeiculoSuperClass extends EntidadeEmpresa{

	public VeiculoSuperClass(){
		
	}
	public VeiculoSuperClass(Empresa empresa,Usuario usuario) {
		super(empresa,usuario);
	}
	
	private static final long serialVersionUID = 1758235854026841356L;
	@Column(name="PLACA")
	private String placa;
	@Column(name="ANO_MODELO")
	private String anoModelo;
	@Column(name="ANO_FABRICACAO")
	private String anoFabricacao;
	@Column(name="TRACAO")
	@Enumerated(EnumType.STRING)
	private EnumTracaoVeiculo tracao;
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="OBSERVACAO")
	private String observacao;
	@Column(name="COMBUSTIVEL")
	@Enumerated(EnumType.STRING)
	private EnumTipoCombustivel combustivel;
	@Column(name="MEDIA_KM_DIA")
	private int mediaKmDia;
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public EnumTracaoVeiculo getTracao() {
		return tracao;
	}
	public void setTracao(EnumTracaoVeiculo tracao) {
		this.tracao = tracao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public EnumTipoCombustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(EnumTipoCombustivel combustivel) {
		this.combustivel = combustivel;
	}
	public int getMediaKmDia() {
		return mediaKmDia;
	}
	public void setMediaKmDia(int mediaKmDia) {
		this.mediaKmDia = mediaKmDia;
	}
}
