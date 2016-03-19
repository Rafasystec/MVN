package br.com.barcadero.module.ecf.impressoras.interfaceDllSo;

class Bematech

{

   // Funções de Inicialização

   public static native int AlteraSimboloMoeda( String cSimboloMoeda );

   public static native int EspacoEntreLinhas( int iDots );

   public static native int ForcaImpactoAgulhas( int iValorImpacto );

   public static native int LinhasEntreCupons( int iLinhas );

   public static native int NomeiaDepartamento( int iIndice, String cDepartamento );

   public static native int NomeiaTotalizadorNaoSujeitoIcms( int iIndice, String cTotalizador );

   public static native int ProgramaAliquota( String cAliquota, int iVinculo );

   public static native int ProgramaArredondamento();

   public static native int ProgramaTruncamento();

   public static native int ProgramaHorarioVerao();

 

   // Funções do Cupom Fiscal

   public static native int AbreCupom( String CPF_CGC );

   public static native int AumentaDescricaoItem( String cDescricao );

   public static native int VendeItem( String cCodigo, String cDescricao, String cAliquota, String cTipoQuantidade, String cQuantidade, int iCasasDecimais, String cUnitario,String cTipoDesconto, String cDesconto );

   public static native int VendeItemDepartamento( String cCodigo, String cDescricao, String cAliquota, String cValorUnitario, String cQuantidade, String cValorAcrescimo, String cValorDesconto, String cIndiceDepartamento, String cUnidadeMedida);

   public static native int CancelaItemAnterior();

   public static native int CancelaItemGenerico( String cNumeroItem );

   public static native int CancelaCupom();

   public static native int FechaCupom( String formaPagamento,String cAcrescimoDesconto, String cTipoAcrescimoDesconto,String cValorAcrescimoDesconto, String cValorPago,String cMensagem );

   public static native int FechaCupomResumido( String formaPagamento,String cMensagem );

   public static native int IniciaFechamentoCupom( String cAcrescimoDesconto,String cTipoAcrescimoDesconto, String cValorAcrescimoDesconto );

   public static native int EfetuaFormaPagamento( String formaPagamento, String valorFormaPagamento );

   public static native int EfetuaFormaPagamentoDescricaoForma( String formaPagamento, String valorFormaPagamento, String cDescricaoForma );

   public static native int EstornoFormasPagamento( String cFormaOrigem, String cFormaDestino, String cValor );

   public static native int TerminaFechamentoCupom( String cMensagem );

   public static native int UsaUnidadeMedida( String cUnidadeMedida );

 

   // Funções de Relatórios Fiscais

   public static native int LeituraMemoriaFiscalData( String cDataInicial, String cDataFinal );

   public static native int LeituraMemoriaFiscalReducao( String cReducaoInicial, String cReducaoFinal );

   public static native int LeituraMemoriaFiscalSerialData( String cDataInicial, String cDataFinal );

   public static native int LeituraMemoriaFiscalSerialReducao( String cReducaoInicial, String cReducaoFinal );

   public static native int LeituraX();

   public static native int LeituraXSerial();

   public static native int ReducaoZ( String cData, String cHora );

 

   // Funções de Operações Não Fiscais

   public static native int AbreComprovanteNaoFiscalVinculado( String formaPagamento, String cValor, String cNumeroCupom );

   public static native int UsaComprovanteNaoFiscalVinculado( String cTexto );

   public static native int FechaComprovanteNaoFiscalVinculado();

   public static native int FechaRelatorioGerencial();

   public static native int RelatorioGerencial( String cTexto );

   public static native int RecebimentoNaoFiscal( String cIndiceTotalizador, String cValorRecebimento, String formaPagamento );

   public static native int Sangria( String cValor );

   public static native int Suprimento( String cValor, String formaPagamento );

 

   // Funções de Autenticação

   public static native int Autenticacao();

   public static native int ProgramaCaracterAutenticacao( String cCaracter );

 

   // Função de Gaveta

   public static native int VerificaEstadoGaveta( BemaInteger estado );

 

   // Funções de Cheque

   public static native int CancelaImpressaCheque();

   public static native int ImprimeCheque( String cNumeroBanco, String cValor, String cFavorecido,String cCidade,String cData, String cMensagem );

   public static native int ImprimeCopiaCheque();

   public static native int IncluiCidadeFavorecido( String cCidade, String cFavorecido );

   public static native int ProgramaMoedaPlural( String cMoedaPlural );

   public static native int ProgramaMoedaSingular( String cMoedaSingular );

   public static native int VerificaStatusCheque( BemaInteger status );

 

   // Outras Funções

   public static native int AberturaDoDia( String cValorAux, String formaPagamento );

   public static native int AbrePortaSerial();

   public static native int AbrePorta( int numero );

   public static native int FechamentoDoDia();

   public static native int FechaPortaSerial();

   public static native int ImprimeConfiguracoesImpressora();

   public static native int ImprimeDepartamentos();

   public static native int MapaResumo();

   public static native int RelatorioTipo60Analitico();

   public static native int RelatorioTipo60Mestre();

   public static native int ResetaImpressora();

   public static native int RetornoImpressora( BemaInteger ACK, BemaInteger ST1, BemaInteger ST2 );

   public static native int VerificaImpressoraLigada();

 

   // Funções de Bilhete de Passagem

   public static native int AbreBilhetePassagem( String cImprimeValorFim, String cImprimeEnfatizado, String cEmbarque, String cDestino, String cLinha, String cPrefixo, String cAgente, String cAgencia, String cData, String cHora, String cPoltrona, String cPlataforma );

   public static native int ContadorBilhetePassagem( BemaString contador );

   public static native int ImpressaoCarne( String cTitulo, String cParcela, String cDatas, int iQuantidade, String cTexto, String cCliente, String cRGCPF, String cCupom, int iVias, int iAssina );

 

   // Funções de Informação da Impressora

   public static native int Acrescimos( BemaString valorAcrescimo );

   public static native int Cancelamentos( BemaString cancelamentos );

   public static native int CGC_IE( BemaString CGC, BemaString IE );

   public static native int ClicheProprietario( BemaString clicheProprietario );

   public static native int ContadoresTotalizadoresNaoFiscais( BemaString Contadores );

   public static native int DadosUltimaReducao( BemaString dadosReducao );

   public static native int DataHoraImpressora( BemaString data, BemaString hora );

   public static native int DataHoraReducao( BemaString data, BemaString hora );

   public static native int DataMovimento( BemaString dataMovimento );

   public static native int Descontos( BemaString descontos );

   public static native int FlagsFiscais( BemaInteger flagFiscal );

   public static native int FlagsVinculacaoIss( BemaInteger flag1, BemaInteger flag2 );

   public static native int GrandeTotal( BemaString grandeTotal );

   public static native int MinutosImprimindo( BemaString minutosImprimindo );

   public static native int MinutosLigada( BemaString minutosLigada );

   public static native int ModeloImpressora( BemaString modeloImpressora );

   public static native int MonitoramentoPapel( BemaInteger linhasImpressas );

   public static native int NumeroCaixa( BemaString numeroCaixa );

   public static native int NumeroCupom( BemaString numeroCupom );

   public static native int NumeroCuponsCancelados( BemaString numeroCuponsCancelados );

   public static native int NumeroIntervencoes( BemaString numeroIntervencoes );

   public static native int NumeroLoja( BemaString numeroLoja );

   public static native int NumeroOperacoesNaoFiscais( BemaString operacoes );

   public static native int NumeroReducoes( BemaString numeroReducoes );

   public static native int NumeroSerie( BemaString numeroSerie );

   public static native int NumeroSubstituicoesProprietario( BemaString substituicoes );

   public static native int RetornoAliquotas( BemaString aliquotas );

   public static native int SimboloMoeda( BemaString simboloMoeda );

   public static native int SubTotal( BemaString subTotal );

   public static native int UltimoItemVendido( BemaString ultimoItemVendido );

   public static native int VendaBruta( BemaString valor );

   public static native int ValorFormaPagamento( String forma, BemaString valorForma );

   public static native int ValorPagoUltimoCupom( BemaString valorUltimoCupom );

   public static native int ValorTotalizadorNaoFiscal( String totalizador, BemaString valor );

   public static native int VerificaAliquotasISS( BemaString aliquotasISS );

   public static native int VerificaDepartamentos( BemaString departamentos );

   public static native int VerificaEpromConectada( BemaString flagEprom );

   public static native int VerificaEstadoImpressora( BemaInteger ACK,BemaInteger ST1,BemaInteger ST2 );

   public static native int VerificaFormasPagamento( BemaString formasPagamento );

   public static native int VerificaIndiceAliquotasIss( BemaString indiceAliquotas );

   public static native int VerificaModoOperacao( BemaString modoOperacao );

   public static native int VerificaRecebimentoNaoFiscal( BemaString recebimentos );

   public static native int VerificaReducaoZAutomatica( BemaInteger flag );

   public static native int VerificaTipoImpressora( BemaInteger tipo );

   public static native int VerificaTotalizadoresNaoFiscais( BemaString totalizadores );

   public static native int VerificaTotalizadoresParciais( BemaString totalizadores );

   public static native int VerificaTruncamento( BemaString flagTruncamento );

   public static native int VersaoFirmware( BemaString versaoFirmware );

 

   // Funções da Impressora Fiscal Convênio ICMS 85/01 (matriciais e térmicas)

   public static native int AbreBilhetePassagemMFD( String cEmbarque, String cDestino, String cLinha, String cAgencia, String cData, String cHora, String cPoltrona, String cPlataforma, String cTipoPassagem, String cRG, String cNome, String cEndereco, String cUF );

   public static native int AbreComprovanteNaoFiscalVinculadoMFD( String formaPagamento, String cValor, String cNumeroCupom, String cCPF, String cNome, String cEndereco );

   public static native int AbreCupomMFD( String cCPF, String cNome, String cEndereco );

   public static native int AbreRecebimentoNaoFiscalMFD( String cCPF, String cNome, String cEndereco );

   public static native int AbreRelatorioGerencialMFD( String cTotalizador );

   public static native int AcionaGuilhotinaMFD( int modo );

   public static native int AcrescimoDescontoItemMFD( String cItem, String cAcrescimoDesconto, String cTipoAcrescimoDesconto, String cValorAcrescimoDesconto );

   public static native int AcrescimoDescontoSubtotalRecebimentoMFD( String cFlag, String cTipo, String cValor );

   public static native int AcrescimoDescontoSubtotalMFD( String cFlag, String cTipo, String cValor );

   public static native int AutenticacaoMFD( String cLinhas, String cTexto );

   public static native int CancelaAcrescimoDescontoItemMFD( String cFlag, String cItem );

   public static native int CancelaAcrescimoDescontoSubtotalMFD( String cFlag );

   public static native int CancelaAcrescimoDescontoSubtotalRecebimentoMFD( String cFlag );

   public static native int CancelaCupomMFD( String cCPF, String cNome, String cEndereco );

   public static native int CancelaRecebimentoNaoFiscalMFD( String cCPF, String cNome, String cEndereco );

   public static native int ComprovantesNaoFiscaisNaoEmitidosMFD( BemaString cComprovantes );

   public static native int CNPJMFD( BemaString cCNPJ );

   public static native int ContadorComprovantesCreditoMFD( BemaString cContador );

   public static native int ContadorCupomFiscalMFD( BemaString cContador );

   public static native int ContadorFitaDetalheMFD( BemaString cContador );

   public static native int ContadorOperacoesNaoFiscaisCanceladasMFD( BemaString cContador );

   public static native int ContadorRelatoriosGerenciaisMFD( BemaString cContador );

   public static native int ContadoresTotalizadoresNaoFiscaisMFD( BemaString cContador );

   public static native int CupomAdicionalMFD();

   public static native int DadosUltimaReducaoMFD( BemaString cDadosUltReducao );

   public static native int DataHoraUltimoDocumentoMFD( BemaString cDataHora );

   public static native int EfetuaFormaPagamentoMFD( String formaPagamento, String valorFormaPagamento, String cParcelas, String cDescricaoFormaPagto );

   public static native int EfetuaRecebimentoNaoFiscalMFD( String cIndiceTotalizador, String cValorRecebimento );

   public static native int EstornoNaoFiscalVinculadoMFD( String cCPF, String cNome, String cEndereco );

   public static native int FechaRecebimentoNaoFiscalMFD( String cMensagem );

   public static native int HabilitaDesabilitaRetornoEstendidoMFD( String cFlagRetorno );

   public static native int ImprimeChequeMFD( String cNumeroBanco, String cValor, String cFavorecido, String cCidade, String cData,String cMsg,String cImpressaoVerso, String cLinhas );

   public static native int IniciaFechamentoCupomMFD( String cAcrescimoDesconto, String cTipoAcrescimoDesconto, String cValorAcrescimo, String cValorDesconto );

   public static native int IniciaFechamentoRecebimentoNaoFiscalMFD( String cAcrescimoDesconto, String cTipoAcrescimoDesconto, String cValorAcrescimo, String cValorDesconto );

   public static native int InscricaoEstadualMFD( BemaString IE );

   public static native int InscricaoMunicipalMFD( BemaString IM );

   public static native int LeituraChequeMFD( BemaString cCMC7 );

   public static native int LeituraMemoriaFiscalDataMFD( String cDataInicial,String cDataFinal,String cFlagLeitura );

   public static native int LeituraMemoriaFiscalReducaoMFD( String cReducaoInicial,String cReducaoFinal,String cFlagLeitura );

   public static native int LeituraMemoriaFiscalSerialDataMFD( String cDataInicial,String cDataFinal,String cFlagLeitura );

   public static native int LeituraMemoriaFiscalSerialReducaoMFD( String cReducaoInicial,String cReducaoFinal,String cFlagLeitura );

   public static native int MapaResumoMFD();

   public static native int MarcaModeloTipoImpressoraMFD( BemaString marca, BemaString modelo, BemaString tipo );

   public static native int MinutosEmitindoDocumentosFiscaisMFD( BemaString cMinutos );

   public static native int NomeiaRelatorioGerencialMFD( String indice, String descricao );

   public static native int NumeroSerieMFD( BemaString cNumeroSerie );

   public static native int NumeroSerieMemoriaMFD( BemaString cNumeroSerie );

   public static native int PercentualLivreMFD( BemaString cValor );

   public static native int ProgramaFormaPagamentoMFD( String formaPagamento, String cOperacaoTef );

   public static native int ReducoesRestantesMFD( BemaString cValor );

   public static native int ReimpressaoNaoFiscalVinculadoMFD();

   public static native int RetornoImpressoraMFD( BemaInteger ACK,BemaInteger ST1,BemaInteger ST2,BemaInteger ST3 );

   public static native int SegundaViaNaoFiscalVinculadoMFD();

   public static native int SubTotalizaCupomMFD();

   public static native int SubTotalizaRecebimentoMFD();

   public static native int TotalLivreMFD( BemaString cTamanho );

   public static native int TamanhoTotalMFD( BemaString cTamanho );

   public static native int TempoOperacionalMFD( BemaString cTempo );

   public static native int TotalizaCupomMFD();

   public static native int TotalizaRecebimentoMFD();

   public static native int UsaRelatorioGerencialMFD( String cTexto );

   public static native int ValorFormaPagamentoMFD( String formaPagamento, BemaString cValorForma );

   public static native int ValorTotalizadorNaoFiscalMFD( String cTotalizador, BemaString cValor );

   public static native int VerificaFormasPagamentoMFD( BemaString formasPagamento );

   public static native int VerificaRecebimentoNaoFiscalMFD( BemaString recebimentoNaoFiscal );

   public static native int VerificaRelatorioGerencialMFD( BemaString relatorio );

   public static native int VerificaTotalizadoresNaoFiscaisMFD( BemaString totalizadores );

   public static native int VerificaTotalizadoresParciaisMFD( BemaString totalizadores );

   public static native int VersaoFirmwareMFD( BemaString versao );

   public static native int CodigoBarrasCODABARMFD( String codigo );

   public static native int CodigoBarrasCODE39MFD( String codigo );

   public static native int CodigoBarrasCODE93MFD( String barcode );

   public static native int CodigoBarrasCODE128MFD( String barcode );

   public static native int CodigoBarrasEAN13MFD( String barcode );

   public static native int CodigoBarrasEAN8MFD( String barcode );

   public static native int CodigoBarrasISBNMFD( String barcode );

   public static native int CodigoBarrasITFMFD( String barcode );

   public static native int CodigoBarrasMSIMFD( String barcode );

   public static native int CodigoBarrasPDF417MFD( int NCE, int altura,int largura,int numColunas,String barcode );

   public static native int CodigoBarrasPLESSEYMFD( String barcode );

   public static native int CodigoBarrasUPCAMFD( String barcode );

   public static native int CodigoBarrasUPCEMFD( String barcode );

   public static native int ConfiguraCodigoBarrasMFD( int altura, int largura,int posicaoCaracteres,int fonte,int margem );

   public static native int DadosSintegra( String dataInicial ,String dataFinal );

   public static native int DownloadMF( String nomeArquivo );

   public static native int DownloadMFD( String nomeArquivo,String tipoDownload,String dadoInicial,String dadoFinal,String usuario );

   public static native int DownloadSB( String nomeArquivo );

   public static native int EfetuaFormaPagamentoImpAntiga( String formaPagamento, String valorFormaPagamento );

   public static native int EfetuaFormaPagamentoIndice( String cIndice,String cValorFormaPagamento );

   public static native int EfetuaFormaPagamentoIndiceMFD( String cIndice,String cValorFormaPagamento,String cParcelas, String cDescricaoForma);

   public static native int FechaRelatorioXouZ();

   public static native int FormatoDadosMFD( String cArquivoMFD,String cDestino,String cFormato,String cTipoDownload,String cDadoInicial,String cDadoFinal,String cUsuario);

   public static native int GeraRelatorioSintegraMFD( int iRelatorios,String cOrigem,String cDestino, String cMes,String cAno,String cRazaoSocial,String cEndereco,String cNumero,String cComplemento,String cBairro,String cCidade,String cCEP,String cTelefone,String cFax,String cContato);

   public static native int ImpressaoFitaDetalhe( String tipo, String dadoInicial, String dadoFinal, String usuario );

   public static native int LeArquivoRetorno( BemaString retorno);

   public static native int ProgramaIdAplicativoMFD( String cIdAplicativo);

   public static native int ReducaoZImpAntiga();

   public static native int RegistrosTipo60();

   public static native int RelatorioGerencialImpAntiga( String texto );

   public static native int RelatorioSintegraMFD( int relatorios, String arquivo,String mes,String ano,String razaoSocial,String endereco,String numero,String complemento,String bairro,String cidade,String CEP,String telefone,String fax,String contato );

   public static native int TerminaFechamentoCupomCodigoBarrasMFD( String cMensagem,String cTipoCodigo,String cCodigo,int iAltura,int iLargura,int iPosicaoCaracteres,int iFonte,int iMargem,int iCorrecaoErros,int iColunas );

   public static native int VersaoDll( BemaString versao );

   public static native int AtivaDesativaVendaUmaLinhaMFD( int flag );

   public static native int AtivaDesativaAlinhamentoEsquerdaMFD( int flag );

   public static native int AtivaDesativaTratamentoONOFFLineMFD( int flag );

   public static native int StatusEstendidoMFD( BemaInteger status );

   public static native int TempoRestanteComprovanteMFD( BemaString tempo );

   public static native int UFProprietarioMFD( BemaString UF );

   public static native int GrandeTotalUltimaReducaoMFD( BemaString grandeTotal );

   public static native int DataMovimentoUltimaReducaoMFD( BemaString dataMovimento );

   public static native int SubTotalComprovanteNaoFiscalMFD( BemaString subTotal );

   public static native int InicioFimCOOsMFD( BemaString COOInicial, BemaString COOFinal );

   public static native int InicioFimGTsMFD( BemaString GTInicial, BemaString GTFinal );

   public static native int VerificaFlagCorteMFD( BemaInteger flag );

   public static native int SelecionaIniLocal();

   public static native int CancelaItemNaoFiscalMFD( String numeroItem );

   public static native int AcrescimoItemNaoFiscalMFD( String numeroItem , String acrDesc , String tipoAcrDesc , String valorAcrDesc );

   public static native int CancelaAcrescimoNaoFiscalMFD( String numeroItem,String acrDesc );

   public static native int ImprimeClicheMFD();

   public static native int ImprimeInformacaoChequeMFD( int posicao, int linhas, String mensagem );

   public static native int VerificaAliquotasIssImpAntiga( BemaString aliquotasIss );

   public static native int VerificaIndiceAliquotasIssImpAntiga( BemaString indices );

   public static native int InfoBalanca( BemaString porta, BemaInteger modelo, BemaString peso,BemaString precoKg, BemaString total );

   public static native int VendeItemArredondamentoMFD( String Codigo, String Descricao, String Aliquota, String UnidadeMedida, String QtdFracionaria, String VlrUnitario, String Desconto, String Acrescimo, String Arredonda);

   public static native int IniciaModoTEF();

   public static native int FinalizaModoTEF();

   public static native int UsaRelatorioGerencialMFDTEF( String texto );

   public static native int RelatorioGerencialTEF( String texto );

   public static native int UsaComprovanteNaoFiscalVinculadoTEF( String texto );

   public static native int VerificaEstadoImpressoraMFD( BemaInteger ACK,BemaInteger ST1,BemaInteger ST2,BemaInteger ST3 );

   public static native int RelatorioTipo60AnaliticoMFD();

 

   public static native int GeraRegistrosSpedMFD( String arq_origem, String arq_destino, String data_inicial, String data_final, String perfil, String CFOP, String lac_fiscal, String pis, String cofins);

 

   static

   {

          System.loadLibrary( "BemaFI32" );

   }

}

class BemaInteger

{

   public int number;

}

class BemaString

{

   public String buffer;

}


