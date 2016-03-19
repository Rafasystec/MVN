package br.com.systeconline.core.enums;

public enum EnumOrigemCSTICMS {
	
	NACIONAL("Nacional"),
	ESTRANGEIRA_IMP("Estrangeira - Importação direta"),
	ESTRANGEIRA_INT("Estrangeira - Adquirida no mercado interno"),
	NACIONAL_40("Nacional, conteudo superior 40% e inferior ou igual a 70%"),
	NACIONAL_BASICO("Nacional, processos produtivos básicos"),
	NACIONAL_INF_40("Nacional, conteudo inferior 40%"),
	ESTRANGEIRA_SIMILAR("Estrangeira - Importação direta, com similar nacional, lista CAMEX"),
	ESTRANGEIRA_N_SIMILAR("Estrangeira - mercado interno, sem simular,lista CAMEX"),
	NACIONAL_SUP_70("Nacional, Conteúdo de Importação superior a 70%");
	
	private final String label;
	EnumOrigemCSTICMS(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

