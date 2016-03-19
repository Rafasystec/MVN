package br.com.systeconline.core.enums;

/**
 * Nao utilizar mais este enum use este: {@link EnumModeloNota}
 * @author Rafael Rocha
 *
 */
@Deprecated
public enum EnumTipoNota {

	CFE(59,"Cupom Eletrônico - CF-e"),
	NFCE(65,"Nota Fiscal Consumidor Eletrônica - NFC-e"),
	NFE(55,"Nota Fiscal Eletrônica - NF-e");
	
	private final int modelo;
	private final String label;
	private EnumTipoNota(int modelo, String label) {
		// TODO Auto-generated constructor stub
		this.modelo = modelo;
		this.label	= label;
	}
	public int getModelo() {
		return modelo;
	}
	public String getLabel() {
		return label;
	}

}
