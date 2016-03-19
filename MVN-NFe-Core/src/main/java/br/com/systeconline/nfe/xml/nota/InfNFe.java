package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.systeconline.nfe.xml.Signature;
import br.com.systeconline.nfe.xml.nota.totais.Total;
import br.com.systeconline.nfe.xml.nota.transporte.Transp;
//A01
@XmlRootElement(name="infNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfNFe {

	@XmlAttribute(required=true)
	private String versao;
	@XmlAttribute(name="Id",required=true)
	private String id;
	@XmlElement(name="ide", required=true)
	private Ide ide;
	@XmlElement(name="emit", required=true)
	private Emitente emit;
	@XmlElement(name="avulsa", required=false)
	private Avulsa avulsa;
	@XmlElement(name="dest", required=true)
	private Destinatario dest;
	@XmlElement(name="retirada", required=false)
	private Retirada retirada;
	@XmlElement(name="det",required=true)
	private List<Det> det;
	@XmlElement(name="total",required=true)
	private Total total;
	@XmlElement(name="transp",required=true)
	private Transp transp;
	@XmlElement(required=false)
	private Cobranca cobr;
	@XmlElement(required=false)
	private InformacoesAdicionais infAdic;
	@XmlElement(required=false)
	private ComercioExterior exporta;
	@XmlElement(required=false)
	private InformacoesDeCompra compra;
	@XmlElement(required=false)
	private AquisicaoDeCana cana;
	@XmlElement(name="Signature")
	private Signature signature;
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Ide getIde() {
		return ide;
	}
	public void setIde(Ide ide) {
		this.ide = ide;
	}
	public Emitente getEmit() {
		return emit;
	}
	public void setEmit(Emitente emit) {
		this.emit = emit;
	}
	public Avulsa getAvulsa() {
		return avulsa;
	}
	public void setAvulsa(Avulsa avulsa) {
		this.avulsa = avulsa;
	}
	public Destinatario getDest() {
		return dest;
	}
	public void setDest(Destinatario dest) {
		this.dest = dest;
	}
	public Retirada getRetirada() {
		return retirada;
	}
	public void setRetirada(Retirada retirada) {
		this.retirada = retirada;
	}
	public List<Det> getDet() {
		return det;
	}
	public void setDet(List<Det> det) {
		this.det = det;
	}
	public Total getTotal() {
		return total;
	}
	public void setTotal(Total total) {
		this.total = total;
	}
	public Transp getTransp() {
		return transp;
	}
	public void setTransp(Transp transp) {
		this.transp = transp;
	}
	public Cobranca getCobr() {
		return cobr;
	}
	public void setCobr(Cobranca cobr) {
		this.cobr = cobr;
	}
	public InformacoesAdicionais getInfAdic() {
		return infAdic;
	}
	public void setInfAdic(InformacoesAdicionais infAdic) {
		this.infAdic = infAdic;
	}
	public ComercioExterior getExporta() {
		return exporta;
	}
	public void setExporta(ComercioExterior exporta) {
		this.exporta = exporta;
	}
	public InformacoesDeCompra getCompra() {
		return compra;
	}
	public void setCompra(InformacoesDeCompra compra) {
		this.compra = compra;
	}
	public AquisicaoDeCana getCana() {
		return cana;
	}
	public void setCana(AquisicaoDeCana cana) {
		this.cana = cana;
	}
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
