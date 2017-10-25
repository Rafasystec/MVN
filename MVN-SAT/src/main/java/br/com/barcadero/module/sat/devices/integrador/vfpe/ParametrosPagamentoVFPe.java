package br.com.barcadero.module.sat.devices.integrador.vfpe;

public class ParametrosPagamentoVFPe {
	/**
	 * Parâmetro utilizado para identificação do retorno realizado pelo Integrador, pois o nome do arquivo de retorno será sempre um nome randômico.
	 */
	private String Identificador                 ;
	/**
	 * Código de identificação do Estabelecimento junto a SEFAZ e ao módulo do Validador fiscal, futuramente esta chave estará disponível no integrador fiscal
	 */
	private String ChaveAcessoValidador          ;
	/**
	 * Chave Guid que poderá ser gerada pela PDV/AC, esta chave deve identificar de forma única o CNPJ + Adquirente que irá processar o pagamento.
	 */
	private String ChaveRequisicao               ;
	/**
	 * Código do Estabelecimento / MerchantID fornecido pela Adquirente contratada pelo Contribuinte.
	 */
	private String Estabelecimento               ;
	/**
	 * Número Serial do POS que será utilizado para o envio do Valor de cobrança para o equipamento POS, deverá existir no PDV/AC um cadastro de POS para que 
	 * seja selecionada na venda um determinado POS, ou para todos os POS, em casos de AC/PDV que não utilizam TEF pode ser vinculado a esse cadastro a CHAVEREQUISICAO
	 */
	private String SerialPOS                     ;
	/**
	 * Número do CNPJ do Contribuinte
	 */
	private String CNPJ                          ;
	/**
	 * Deverá ser informado o valor da Base de Cálculo do ICMS, incluindo Base Isenta, Tributável e etc., em casos de serviços que não possuam base de 
	 * ICMS não somar nesta TAG, vendas de produtos de recarga de celular, pagamento de contas, cartão vale presente que não estejam dentro de uma operação 
	 * de venda com ICMS não deverá ser
	 */
	private String IcmsBase                      ;
	/**
	 * Deverá ser informado o valor da venda que será cobrado, este valor poderá ser somado a valores de serviços, gorjeta, recarga de celular, e etc.
	 */
	private String ValorTotalVenda               ;
	/**
	 * Este recurso será usado para definir se haverá múltiplos pagamentos no processo de pagamento, muito comum quando é pago em múltiplos
	 * cartões e divisão de conta em restaurante. false ou true.
	 */
	private String HabilitarMultiplosPagamentos  ;
	/**
	 * Este processo será usado para validação de possíveis fraudes no pagamento, verificando uma base histórica.
false ou true
	 */
	private String habilitarControleAntiFraude;
	/**
	 * Informa a Moeda que será pago a venda.
Utilizar tabela ISO 4217
Real = BRL
	 */
	private String codigoMoeda;
	/**
	 * Permitirá que o NFC-e seja emitido diretamente por equipamentos POS ou MPOS.
false ou true
	 */
	private String emitirCupomNFCE;
	/**
	 * Esta informação servirá para que as informações apresentadas no equipamento de pagamento possa ser consultada em lista, 
	 * permitindo assim uma maior flexibilidade no processo de pagamento e um maior controle ao cliente e aos contribuintes
	 */
	private String origemPagamento;
	
	public String getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
	public String getChaveAcessoValidador() {
		return ChaveAcessoValidador;
	}
	public void setChaveAcessoValidador(String chaveAcessoValidador) {
		ChaveAcessoValidador = chaveAcessoValidador;
	}
	public String getChaveRequisicao() {
		return ChaveRequisicao;
	}
	public void setChaveRequisicao(String chaveRequisicao) {
		ChaveRequisicao = chaveRequisicao;
	}
	public String getEstabelecimento() {
		return Estabelecimento;
	}
	public void setEstabelecimento(String estabelecimento) {
		Estabelecimento = estabelecimento;
	}
	public String getSerialPOS() {
		return SerialPOS;
	}
	public void setSerialPOS(String serialPOS) {
		SerialPOS = serialPOS;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getIcmsBase() {
		return IcmsBase;
	}
	public void setIcmsBase(String icmsBase) {
		IcmsBase = icmsBase;
	}
	public String getValorTotalVenda() {
		return ValorTotalVenda;
	}
	public void setValorTotalVenda(String valorTotalVenda) {
		ValorTotalVenda = valorTotalVenda;
	}
	public String getHabilitarMultiplosPagamentos() {
		return HabilitarMultiplosPagamentos;
	}
	public void setHabilitarMultiplosPagamentos(String habilitarMultiplosPagamentos) {
		HabilitarMultiplosPagamentos = habilitarMultiplosPagamentos;
	}
	public String getHabilitarControleAntiFraude() {
		return habilitarControleAntiFraude;
	}
	public void setHabilitarControleAntiFraude(String habilitarControleAntiFraude) {
		this.habilitarControleAntiFraude = habilitarControleAntiFraude;
	}
	public String getCodigoMoeda() {
		return codigoMoeda;
	}
	public void setCodigoMoeda(String codigoMoeda) {
		this.codigoMoeda = codigoMoeda;
	}
	public String getEmitirCupomNFCE() {
		return emitirCupomNFCE;
	}
	public void setEmitirCupomNFCE(String emitirCupomNFCE) {
		this.emitirCupomNFCE = emitirCupomNFCE;
	}
	public String getOrigemPagamento() {
		return origemPagamento;
	}
	public void setOrigemPagamento(String origemPagamento) {
		this.origemPagamento = origemPagamento;
	}
	
	
}
