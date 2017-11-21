package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.devices.integrador.xml.Identificador;
import br.com.barcadero.module.sat.devices.integrador.xml.IntegradorResposta;


@XmlRootElement(name="Integrador")
@XmlAccessorType(XmlAccessType.FIELD)
public class VFPeVerificarStatusValidadorResposta {
	
	private Identificador identificador;
	private IntegradorResposta integradorResposta;
	private Resposta resposta;

}
