package br.com.barcadero.module.ecf.impressoras;

import java.math.BigDecimal;
import java.util.Collection;

import bemajava.Bematech;
import br.com.barcadero.module.ecf.dados.Aliquotas;
import br.com.barcadero.module.ecf.dados.Item;
import br.com.barcadero.module.ecf.dados.MapaResumo;
import br.com.barcadero.module.ecf.exceptions.ECFException;

public final class ECFBematech extends ECFSuperClass {

	@Override
	public int abrirCupom(String cpfCnpj) throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.AbreCupom(cpfCnpj);
	}

	@Override
	public int venderItem(Item item) throws ECFException {
		String codigo 			= item.getCodigo();
		String descricao		= item.getDescricao();
		String aliquota			= item.getAliquota();
		String tipoQuantidade 	= item.getTpQuantidade();
		String quantidade		= String.valueOf(item.getQuantidade());
		int casasDecimais		= item.getCasaDecimais();
		String valorUnitario 	= item.getValorUnitario().toString();
		String tipoDesconto 	= item.getTipoDesconto();
		String ValorDesconto 	= item.getValorDesconto().toString();
		return Bematech.VendeItem(codigo, descricao, aliquota, tipoQuantidade, quantidade, casasDecimais, valorUnitario, tipoDesconto, ValorDesconto);
	}

	@Override
	public int cancelarUltimoItem() throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.CancelaItemAnterior();
	}

	@Override
	public int cancelarItem(long codigo) throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.CancelaItemGenerico(String.valueOf(codigo));
	}

	@Override
	public int iniciarFechamentoCupom(String acrescimoDesconto,	String tpAcrescimoDesconto, BigDecimal valorAcrescimoDesconto)
			throws ECFException {
		/*
		 	AcrescimoDesconto: Indica se haverá acréscimo ou desconto no cupom. 'A' para acréscimo e 'D' para desconto.
			TipoAcrescimoDesconto: Indica se o acréscimo ou desconto é por valor ou por percentual. '$' para desconto por valor e '%' para percentual.
			ValorAcrescimoDesconto: STRING com no máximo 14 dígitos para acréscimo ou desconto por valor e 4 dígitos para acréscimo ou desconto por percentual.
		*/
		
		return Bematech.IniciaFechamentoCupom(acrescimoDesconto, tpAcrescimoDesconto, valorAcrescimoDesconto.toString());
	}

	@Override
	public int efetuarFormaPagamento(String descricaoFormPgto, BigDecimal valorFormaPgto) throws ECFException {
		
		return Bematech.EfetuaFormaPagamento(descricaoFormPgto, valorFormaPgto.toString());
	}

	@Override
	public int efetuarFormaPgtoPorIndice(long indice, BigDecimal valorFormaPgto)
			throws ECFException {
		
		return Bematech.EfetuaFormaPagamentoIndice(String.valueOf(indice), valorFormaPgto.toString());
	}

	@Override
	public int terminarFechamentoCupom(String mensagemPromocional)	throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.TerminaFechamentoCupom(mensagemPromocional);
	}

	@Override
	public int cancelarCupom() throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.CancelaCupom();
	}

	@Override
	public int leituraX() throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.LeituraX();
	}

	@Override
	public int lerMemoriaFiscal(String dataInicial, String dataFinal)throws ECFException {
		
		return Bematech.LeituraMemoriaFiscalData(dataInicial, dataFinal);
	}

	@Override
	public int lerMemoriaFiscal(long iniReducaoZ, long fimReducaoZ)	throws ECFException {
		
		return Bematech.LeituraMemoriaFiscalReducao(String.valueOf(iniReducaoZ), String.valueOf(fimReducaoZ));
	}

	@Override
	public int lerMemoriaFiscalESalvaArquivo(String dataInicial, String dataFinal) throws ECFException {
		// TODO Auto-generated method stub
		return Bematech.LeituraMemoriaFiscalSerialData(dataInicial, dataFinal);
	}

	@Override
	public int reducaoZ() throws ECFException {
		// TODO Auto-generated method stub
		String dtAtualECF = "dd/mm/aaaa";
		String hrAtualECF = "HH:mm:ss";	
		return Bematech.ReducaoZ(dtAtualECF, hrAtualECF);
	}

	@Override
	public int abrirComprovanteNaoFiscalVinculado(String descFormaPgto,
			BigDecimal valorPgto, long nrCupom) throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int usarComprovanteNaoFiscalVinculado(String textoParaImprimir)
			throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fecharComprovanteNaoFiscalVinculado() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int imprimirRealatorioGerencial(int indice, String textoParaImprimir)
			throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fecharRelatorioGerencial() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int imprimirNaoFiscalNaoVinculado(long indice,
			BigDecimal valorRecebido, String formaPagamento)
			throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fazerSangria(String texto, BigDecimal valor) throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fazerSuprimento(String texto, BigDecimal valor) throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int acionarGaveta() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isGavetaAberta() throws ECFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String dadosUltimaReducaoZ(String dadosReducao) throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dataHoraECF() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dataHoraReducao() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCupomAberto() throws ECFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BigDecimal getGrandeTotal() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelo() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumeroCaixa() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNumeroCupom() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSerieECF() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Aliquotas> getAliquotasCadastradas() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int verificarReducaoZPendente() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int abrirComunicao() throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MapaResumo getMapaResumo() throws ECFException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isECFLigado() throws ECFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int abrirCupom(String cpfCnpj, String nome, String endereco)
			throws ECFException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
