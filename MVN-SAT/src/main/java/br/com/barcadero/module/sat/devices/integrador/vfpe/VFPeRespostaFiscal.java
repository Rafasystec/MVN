package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;

/**
 * Este método é utilizado para finalizar a operação comercial e informar ao
Validador Fiscal de Pagamentos que um determinado pagamento já possui
sua correspondência fiscal, ele também é utilizado para enviar o Extrato do
CF-e ou Danfe para ser impresso no POS.
 * @author Rafael Rocha
 *
 */
@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class VFPeRespostaFiscal {
	//TODO: concluir a implementação assim que instalar o Integrador.
	@XmlElement(name="Identificador")
	private Identificador identificador;

	public Identificador getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Identificador identificador) {
		this.identificador = identificador;
	}
	

}
