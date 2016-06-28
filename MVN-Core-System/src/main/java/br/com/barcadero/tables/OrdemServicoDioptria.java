package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import br.com.barcadero.core.enums.EnumEstadoArmacao;
import br.com.barcadero.core.enums.EnumSimNao;
import br.com.barcadero.core.enums.EnumTpMaterial;

@Entity
@Table(name="ORDEM_SERVICO_DIOPT")
public class OrdemServicoDioptria extends Entidade {
	

	private static final long serialVersionUID = 3124057695509352220L;
	@Column(name="ADICAO_OD")
	private String adicaoOD;
	@Column(name="ADICAO_OE")
	private String adicaoOE;
	@Column(name="ALTURA")
	private String altura;
	@Column(name="COLINDRO_OD_LONGE")
	private String cilindroODLonge;
	@Column(name="COLINDRO_OD_PERTO")
	private String cilindroODPerto;
	@Column(name="COLINDRO_OE_LONGE")
	private String cilindroOELonge;
	@Column(name="COLINDRO_OE_PERTO")
	private String cilindroOEPerto;
	@Column(name="CO_OD_LONGE")
	private String coODLonge;
	@Column(name="CO_OD_PERTO")
	private String coODPerto;
	@Column(name="CO_OE_LONGE")
	private String coOELonge;
	@Column(name="CO_OE_PERTO")
	private String coOEPerto;
	@Column(name="DNP_OD_LONGE")
	private String dnpODLonge;
	@Column(name="DNP_OD_PERTO")
	private String dnpODPerto;
	@Column(name="DNP_OE_LONGE")
	private String dnpOELonge;
	@Column(name="DNP_OE_PERTO")
	private String dnpOEPerto;
	@Column(name="EIXO_OD_LONGE")
	private String eixoODLonge;
	@Column(name="EIXO_OD_PERTO")
	private String eixoODPerto;
	@Column(name="EIXO_OE_LONGE")
	private String eixoOELonge;
	@Column(name="EIXO_OE_PERTO")
	private String eixoOEPerto;
	@Column(name="ESFERICO_OD_LONGE")
	private String esfericoODLonge;
	@Column(name="ESFERICO_OD_PERTO")
	private String esfericoODPerto;
	@Column(name="ESFERICO_OE_LONGE")
	private String esfericoOELonge;
	@Column(name="ESFERICO_OE_PERTO")
	private String espericoOEPerto;
	@Column(name="ESTADO_ARMACAO")
	@Enumerated(EnumType.STRING)
	private EnumEstadoArmacao estadoArmacao;
	@Column(name="PELICULA_OD")
	private String peliculaODLonge;
	@Column(name="PELICULA_OD_PERTO")
	private String peliculaODPerto;
	@Column(name="PELICULA_OE_LONGE")
	private String peliculaOELonge;
	@Column(name="PELICULA_OE_PERTO")
	private String peliculaOEPerto;
	@Column(name="PRISMA_OD_HORIZONTAL")
	private String prismaODHorizontal;
	@Column(name="PRISMA_OD_VERTICAL")
	private String prismaODVertical;
	@Column(name="PRISMA_OE_HORIZONTAL")
	private String prismaOEHorizontal;
	@Column(name="PRISMA_OE_VERTICAL")
	private String prismaOEVertical;
	@Column(name="PONTE")
	private String ponte;
	@Column(name="TIPO_MATERIAL")
	@Enumerated(EnumType.STRING)
	private EnumTpMaterial tipoMaterial;
	@Column(name="DEIXOU_ARMACAO")
	@Enumerated(EnumType.STRING)
	private EnumSimNao deixouArmacao;
	
	public String getAdicaoOD() {
		return adicaoOD;
	}
	public void setAdicaoOD(String adicaoOD) {
		this.adicaoOD = adicaoOD;
	}
	public String getAdicaoOE() {
		return adicaoOE;
	}
	public void setAdicaoOE(String adicaoOE) {
		this.adicaoOE = adicaoOE;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getCilindroODLonge() {
		return cilindroODLonge;
	}
	public void setCilindroODLonge(String cilindroODLonge) {
		this.cilindroODLonge = cilindroODLonge;
	}
	public String getCilindroODPerto() {
		return cilindroODPerto;
	}
	public void setCilindroODPerto(String cilindroODPerto) {
		this.cilindroODPerto = cilindroODPerto;
	}
	public String getCilindroOELonge() {
		return cilindroOELonge;
	}
	public void setCilindroOELonge(String cilindroOELonge) {
		this.cilindroOELonge = cilindroOELonge;
	}
	public String getCilindroOEPerto() {
		return cilindroOEPerto;
	}
	public void setCilindroOEPerto(String cilindroOEPerto) {
		this.cilindroOEPerto = cilindroOEPerto;
	}
	public String getCoODLonge() {
		return coODLonge;
	}
	public void setCoODLonge(String coODLonge) {
		this.coODLonge = coODLonge;
	}
	public String getCoODPerto() {
		return coODPerto;
	}
	public void setCoODPerto(String coODPerto) {
		this.coODPerto = coODPerto;
	}
	public String getCoOELonge() {
		return coOELonge;
	}
	public void setCoOELonge(String coOELonge) {
		this.coOELonge = coOELonge;
	}
	public String getCoOEPerto() {
		return coOEPerto;
	}
	public void setCoOEPerto(String coOEPerto) {
		this.coOEPerto = coOEPerto;
	}
	public String getDnpODLonge() {
		return dnpODLonge;
	}
	public void setDnpODLonge(String dnpODLonge) {
		this.dnpODLonge = dnpODLonge;
	}
	public String getDnpODPerto() {
		return dnpODPerto;
	}
	public void setDnpODPerto(String dnpODPerto) {
		this.dnpODPerto = dnpODPerto;
	}
	public String getDnpOELonge() {
		return dnpOELonge;
	}
	public void setDnpOELonge(String dnpOELonge) {
		this.dnpOELonge = dnpOELonge;
	}
	public String getDnpOEPerto() {
		return dnpOEPerto;
	}
	public void setDnpOEPerto(String dnpOEPerto) {
		this.dnpOEPerto = dnpOEPerto;
	}
	public String getEixoODLonge() {
		return eixoODLonge;
	}
	public void setEixoODLonge(String eixoODLonge) {
		this.eixoODLonge = eixoODLonge;
	}
	public String getEixoODPerto() {
		return eixoODPerto;
	}
	public void setEixoODPerto(String eixoODPerto) {
		this.eixoODPerto = eixoODPerto;
	}
	public String getEixoOELonge() {
		return eixoOELonge;
	}
	public void setEixoOELonge(String eixoOELonge) {
		this.eixoOELonge = eixoOELonge;
	}
	public String getEixoOEPerto() {
		return eixoOEPerto;
	}
	public void setEixoOEPerto(String eixoOEPerto) {
		this.eixoOEPerto = eixoOEPerto;
	}
	public String getEsfericoODLonge() {
		return esfericoODLonge;
	}
	public void setEsfericoODLonge(String esfericoODLonge) {
		this.esfericoODLonge = esfericoODLonge;
	}
	public String getEsfericoODPerto() {
		return esfericoODPerto;
	}
	public void setEsfericoODPerto(String esfericoODPerto) {
		this.esfericoODPerto = esfericoODPerto;
	}
	public String getPeliculaODLonge() {
		return peliculaODLonge;
	}
	public void setPeliculaODLonge(String peliculaODLonge) {
		this.peliculaODLonge = peliculaODLonge;
	}
	public String getPeliculaODPerto() {
		return peliculaODPerto;
	}
	public void setPeliculaODPerto(String peliculaODPerto) {
		this.peliculaODPerto = peliculaODPerto;
	}
	public String getPeliculaOELonge() {
		return peliculaOELonge;
	}
	public void setPeliculaOELonge(String peliculaOELonge) {
		this.peliculaOELonge = peliculaOELonge;
	}
	public String getPeliculaOEPerto() {
		return peliculaOEPerto;
	}
	public void setPeliculaOEPerto(String peliculaOEPerto) {
		this.peliculaOEPerto = peliculaOEPerto;
	}
	public String getPrismaODHorizontal() {
		return prismaODHorizontal;
	}
	public void setPrismaODHorizontal(String prismaODHorizontal) {
		this.prismaODHorizontal = prismaODHorizontal;
	}
	public String getPrismaODVertical() {
		return prismaODVertical;
	}
	public void setPrismaODVertical(String prismaODVertical) {
		this.prismaODVertical = prismaODVertical;
	}
	public String getPrismaOEHorizontal() {
		return prismaOEHorizontal;
	}
	public void setPrismaOEHorizontal(String prismaOEHorizontal) {
		this.prismaOEHorizontal = prismaOEHorizontal;
	}
	public String getPrismaOEVertical() {
		return prismaOEVertical;
	}
	public void setPrismaOEVertical(String prismaOEVertical) {
		this.prismaOEVertical = prismaOEVertical;
	}
	public String getPonte() {
		return ponte;
	}
	public void setPonte(String ponte) {
		this.ponte = ponte;
	}
	public EnumTpMaterial getTipoMaterial() {
		return tipoMaterial;
	}
	public void setTipoMaterial(EnumTpMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}
	public EnumSimNao getDeixouArmacao() {
		return deixouArmacao;
	}
	public void setDeixouArmacao(EnumSimNao deixouArmacao) {
		this.deixouArmacao = deixouArmacao;
	}
	public String getEsfericoOELonge() {
		return esfericoOELonge;
	}
	public void setEsfericoOELonge(String esfericoOELonge) {
		this.esfericoOELonge = esfericoOELonge;
	}
	public String getEspericoOEPerto() {
		return espericoOEPerto;
	}
	public void setEspericoOEPerto(String espericoOEPerto) {
		this.espericoOEPerto = espericoOEPerto;
	}
	public EnumEstadoArmacao getEstadoArmacao() {
		return estadoArmacao;
	}
	public void setEstadoArmacao(EnumEstadoArmacao estadoArmacao) {
		this.estadoArmacao = estadoArmacao;
	}
	
}
