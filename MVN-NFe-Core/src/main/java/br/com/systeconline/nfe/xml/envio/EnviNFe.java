package br.com.systeconline.nfe.xml.envio;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.systeconline.nfe.xml.nota.NFe;
/**
 * Tipo Pedido de Concessão de Autorização da Nota Fiscal EletrOnica
 * @author Rafael Rocha
 */
@XmlRootElement(name="enviNFe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"idLote","indSinc","nfes"})
public class EnviNFe {
	
	public static final String ENVIO_ASSINCRONO = "0";
	public static final String ENVIO_SINCRONO 	= "1";
	
	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement(required=true)
	private String idLote;
	@XmlElement(required=false)
	private String indSinc;
	@XmlElement(name="NFe")
	private List<NFe> nfes;
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	/**
	 dentificador de controle do envio do lote.
	 Número seqüencial auto-incremental, de
	 controle correspondente ao identificador único
	 do lote enviado. A responsabilidade de gerar e
	 controlar esse número é exclusiva do
	 contribuinte.
 
	 * @return
	 */
	public String getIdLote() {
		return idLote;
	}
	/**
	 dentificador de controle do envio do lote.
	 Número seqüencial auto-incremental, de
	 controle correspondente ao identificador único
	 do lote enviado. A responsabilidade de gerar e
	 controlar esse número é exclusiva do
	 contribuinte.
	 */
	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}
	/**
	 * Conjunto de NF-e transmitidas (máximo de 50
	 NF-e), seguindo definição do Anexo I - Leiaute
	 da NF-e.
	 * @return
	 */
	public List<NFe> getNfes() {
		return nfes;
	}
	/**
	 * Conjunto de NF-e transmitidas (máximo de 50
	 NF-e), seguindo definição do Anexo I - Leiaute
	 da NF-e.
	 * @param nfes
	 */
	public void setNfes(List<NFe> nfes) {
		this.nfes = nfes;
	}
	public String getIndSinc() {
		return indSinc;
	}
	public void setIndSinc(String indSinc) {
		this.indSinc = indSinc;
	}
	

}
