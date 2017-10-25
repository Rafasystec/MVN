package br.com.barcadero.module.sat.devices.integrador.vfpe;

/**
 * Este Método notifica o sistema Validador Fiscal de Pagamentos Eletrônicos que o PDV/AC 
 * irá iniciar um processo de pagamento enviando a solicitação para o POS, ele deverá ser 
 * precedido a conclusão da venda e seu retorno IDPAGAMENTO deverá ser guardado na base de 
 * dados para posterior utilização.
	Componente: VFP-e
	Método: EnviarPagamento
 * @author Rafael Rocha
 *
 */
public class VFPeEnviarPagamento {

	private Integrador integrador;

	public Integrador getIntegrador() {
		return integrador;
	}

	public void setIntegrador(Integrador integrador) {
		this.integrador = integrador;
	}
}

/*
 EXEMPLO XML DE ENVIO
 <?xml version="1.0" encoding="utf-8" standalone="yes"?>
<Integrador>
  <Identificador>
    <Valor></Valor>
  </Identificador>
  <Componente Nome="VFP-e">
    <Metodo Nome="EnviarPagamento">
      <Construtor>
        <Parametros>
          <Parametro>
            <Nome>chaveAcessoValidador</Nome>
            <!--String-->
            <Valor></Valor>
          </Parametro>
        </Parametros>
      </Construtor>
      <Parametros>
        <Parametro>
          <Nome>Id</Nome>
          <!--int-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>ChaveRequisicao</Nome>
          <!--Guid-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>Estabelecimento</Nome>
          <!--int-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>SerialPos</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>Cnpj</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>IcmsBase</Nome>
          <!--decimal-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>ValorTotalVenda</Nome>
          <!--decimal-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>IdFilaValidador</Nome>
          <!--int-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>TipoMaquina</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>HabilitarMultiplosPagamentos</Nome>
          <!--bool-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>HabilitarControleAntiFraude</Nome>
          <!--bool-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>CodigoMoeda</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>EnderecoIP</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>OrigemPagamento</Nome>
          <!--string-->
          <Valor></Valor>
        </Parametro>
        <Parametro>
          <Nome>EmitirCupomNFCE</Nome>
          <!--bool-->
          <Valor></Valor>
        </Parametro>
      </Parametros>
    </Metodo>
  </Componente>
</Integrador>
 */
