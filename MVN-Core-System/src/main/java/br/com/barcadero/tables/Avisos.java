package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

import br.com.barcadero.core.enums.EnumTipoAviso;

@NamedQueries({
	@NamedQuery(name=Avisos.FIND_ALL	,query="FROM Avisos a WHERE a.dtValidade >= :dtValidade AND a.dtExibir <= :dtExibir")
})
@Audited
@Entity
public class Avisos extends EntidadeLoja {
	
	private static final long serialVersionUID = -7290199595751693187L;
	public Avisos() {
		// TODO Auto-generated constructor stub
	}
	public Avisos(Loja loja, Usuario usuario) {
		super(loja, usuario);
	}
	public final static String FIND_ALL			 = "Avisos.findAll";
	//public final static String FIND_BY_EMP		 = "Avisos.findByEmp";
	public final static String PARAM_DT_VALIDADE = "dtValidade";
	public final static String PARAM_CD_EMP		 = "empresa";
	public final static String PARAM_DT_EXIBIR	 = "dtExibir";
	
	
	@Column(name="descricao")
	private String descricao;
	@Column(name="fl_tipo")
	@Enumerated(EnumType.STRING)
	private EnumTipoAviso flTipo;
	@Column(name="dt_validade")
	@Temporal(TemporalType.DATE)
	private Date dtValidade;
	@Column(name="dt_exibir")
	@Temporal(TemporalType.DATE)
	private Date dtExibir;
	@Transient
	private String imgSrc;
	@Transient
	private String htmlColor;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public EnumTipoAviso getFlTipo() {
		return flTipo;
	}
	public void setFlTipo(EnumTipoAviso flTipo) {
		this.flTipo = flTipo;
	}
	public Date getDtValidade() {
		return dtValidade;
	}
	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}
	/**
	 * Data em que o aviso comecara a aparecer
	 */
	public Date getDtExibir() {
		return dtExibir;
	}
	/**
	 * Data em que o aviso comecara a aparecer
	 * @param dtExibir
	 */
	public void setDtExibir(Date dtExibir) {
		this.dtExibir = dtExibir;
	}
	/**
	 * Imagem que sera exibida na grid dependendo do tipo de aviso
	 * @return
	 */
	public String getImgSrc() {
		if(flTipo == EnumTipoAviso.E){
			imgSrc = "/resources/Imagens/error.png";
		}else if(flTipo == EnumTipoAviso.I){
			imgSrc = "/resources/Imagens/inforIcon.png";
		}else if(flTipo == EnumTipoAviso.W){
			imgSrc = "/resources/Imagens/iconAlert.png";
		}
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getHtmlColor() {
		if(flTipo == EnumTipoAviso.E){
			htmlColor = "#FA5858";
		}else if(flTipo == EnumTipoAviso.I){
			htmlColor = "#A9E2F3";
		}else if(flTipo == EnumTipoAviso.W){
			htmlColor = "#F5DA81";
		}
		return htmlColor;
	}
	public void setHtmlColor(String htmlColor) {
		this.htmlColor = htmlColor;
	}

	
}
