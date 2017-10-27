package br.com.barcadero.module.sat.enums;

public enum EnumCodigoRetIntegrador {

	AP("Arquivo Processado"),
	EI("Identificador nao encontrado no XML"),
	EE("Erro geral do componente(ver tag <Erro>)"),
	EPO("Preencha todos os campos obrigatorios");
	
	private final String descricao;
	EnumCodigoRetIntegrador(final String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Código de retorno do Integrador Fiscal:
		AP-Arquivo Processado
		EI: identificador não encontrado no xml
		EE: Erro geral no componente( vem descrito na tag <Erro>)
		EPO: Preencha todos os campos obrigatórios
	 * @param description
	 * @return
	 */
	public static EnumCodigoRetIntegrador getByDescription(String description) {
		if(description != null){
			if(description.equalsIgnoreCase("AP")){
				return EnumCodigoRetIntegrador.AP;
			}else if(description.equalsIgnoreCase("EI")){
				return EnumCodigoRetIntegrador.EI;
			}else if(description.equalsIgnoreCase("EE")){
				return EnumCodigoRetIntegrador.EE;
			}else{
				return EnumCodigoRetIntegrador.EPO;
			}
		}else{
			return EnumCodigoRetIntegrador.EE;
		}
	}
}
