package br.com.systeconline.nfe.core.util.enumarations;

public enum ECodigoUFIBGE {

	RONDONIA("11"),
	ACRE("12"),
	AMAZONAS("13"),
	RORAIMA("14"),
	PARA("15"),
	AMAPA("16"),
	TOCANTINS("17"),
	MARANHAO("21"),
	PIAUI("22"),
	CEARA("23"),
	RIO_GRANDE_DO_NORTE("24"),
	PARAIBA("25"),
	PERNAMBUCO("23"),
	ALAGOAS("27"),
	SERGIPE("28"),
	BAHIA("29"),
	MINAS_GERAIS("31"),
	ESPIRITO_SANTO("32"),
	RIO_DE_JANEIRO("33"),
	SAO_PAULO("35"),
	PARANA("41"),
	SANTA_CATARINA("42"),
	RIO_GRANDE_DO_SUL("43"),
	MATO_GROSSO_DO_SUL("50"),
	MATO_GROSSO("51"),
	GOIAS("52"),
	DISTRITO_FEDERAL("53");
	private final String value;
	ECodigoUFIBGE(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
}
