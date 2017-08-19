package br.com.barcadero.module.sat.devices.integrador.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class IntegradorRoot {
	private final static String MFE_PRODUCAO 	= "MF-e";
	//private final static String MFE_DEBUG_MODE 	= "MF-e-T";//Por enquanto usar somente em homologacao.
	public static String componentName = MFE_PRODUCAO;
	
	@XmlTransient
	private String numeroDeSessao = "";
	
	@XmlElement(name="Erro",required=false)
	private Erro erro;
	@XmlElement(name="Identificador")
	private Identificador identificado;
	@XmlElement(name="Componente")
	private Componente componente;
	@XmlElement(name="IntegradorResposta",required=false)
	private IntegradorResposta integradorResposta = null;
	@XmlElement(name="Resposta",required=false)
	private Resposta resposta = null;
	@XmlElement(name="retorno",required=false)
	private String retorno = null;
	
	public Identificador getIdentificado() {
		return identificado;
	}
	public void setIdentificado(Identificador identificado) {
		this.identificado = identificado;
	}
	public Componente getComponente() {
		return componente;
	}
	public void setComponente(Componente componente) {
		this.componente = componente;
	}
	public IntegradorResposta getIntegradorResposta() {
		return integradorResposta;
	}
	public void setIntegradorResposta(IntegradorResposta integradorResposta) {
		this.integradorResposta = integradorResposta;
	}
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	public Erro getErro() {
		return erro;
	}
	public void setErro(Erro erro) {
		this.erro = erro;
	}
	public String getNumeroDeSessao() {
		return numeroDeSessao;
	}
	public void setNumeroDeSessao(String numeroDeSessao) {
		this.numeroDeSessao = numeroDeSessao;
	}

}

