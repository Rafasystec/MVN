package br.com.barcadero.rule;

//import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import br.com.barcadero.commons.util.HandleString;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.core.enums.EnumRegimeISSQN;
import br.com.barcadero.core.enums.EnumStatusCFeNota;
import br.com.barcadero.core.enums.EnumTipoMeioPgto;
import br.com.barcadero.core.enums.EnumTipoPessoa;
import br.com.barcadero.core.enums.EnumUnidadeMedida;
import br.com.barcadero.core.handles.HandleNumericFormat;
import br.com.barcadero.module.sat.enums.EnumCFeCSTPISAliq;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSNT;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSOutr;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSSN;
import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumCSTICMS40;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumMeioPagamento;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.xml.envio.CFe;
import br.com.barcadero.module.sat.xml.envio.COFINS;
import br.com.barcadero.module.sat.xml.envio.COFINSAliq;
import br.com.barcadero.module.sat.xml.envio.COFINSNT;
import br.com.barcadero.module.sat.xml.envio.COFINSOutr;
import br.com.barcadero.module.sat.xml.envio.COFINSQtde;
import br.com.barcadero.module.sat.xml.envio.COFINSSN;
import br.com.barcadero.module.sat.xml.envio.Dest;
import br.com.barcadero.module.sat.xml.envio.Det;
import br.com.barcadero.module.sat.xml.envio.Emit;
import br.com.barcadero.module.sat.xml.envio.Entrega;
import br.com.barcadero.module.sat.xml.envio.ICMS;
import br.com.barcadero.module.sat.xml.envio.ICMS00;
import br.com.barcadero.module.sat.xml.envio.ICMS40;
import br.com.barcadero.module.sat.xml.envio.ICMSSN102;
import br.com.barcadero.module.sat.xml.envio.ICMSSN900;
import br.com.barcadero.module.sat.xml.envio.Ide;
import br.com.barcadero.module.sat.xml.envio.Imposto;
import br.com.barcadero.module.sat.xml.envio.InfCFe;
import br.com.barcadero.module.sat.xml.envio.MP;
import br.com.barcadero.module.sat.xml.envio.PIS;
import br.com.barcadero.module.sat.xml.envio.PISAliq;
import br.com.barcadero.module.sat.xml.envio.PISNT;
import br.com.barcadero.module.sat.xml.envio.PISOutr;
import br.com.barcadero.module.sat.xml.envio.PISQtde;
import br.com.barcadero.module.sat.xml.envio.PISSN;
import br.com.barcadero.module.sat.xml.envio.Pgto;
import br.com.barcadero.module.sat.xml.envio.Prod;
import br.com.barcadero.module.sat.xml.envio.Total;
import br.com.barcadero.module.sat.xml.util.CNPJ;
import br.com.barcadero.module.sat.xml.util.CPF;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.NotaMeioPgto;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.Usuario;

public class RuleGenarateCFe {
	
	public static final int CODE_NAO_TEM_NOTA 		= 13;
	public static final int CODE_STATUS_INVALIDO 	= 14;
	public static final int CODE_STATUS_OK 			= 0;
	private Empresa empresa = null;
	private RuleCFeComandos ruleCFeComandos			= null;
	private Loja loja = null;
	
	public static void main(String[] args) {
		EnumUnidadeMedida enumMedido = EnumUnidadeMedida.UNIDADE;
		String unidade = String.valueOf(enumMedido);
		System.out.println(unidade);
	}
	
	public RuleGenarateCFe(Empresa empresa, Loja loja, Caixa caixa) {
		// TODO Auto-generated constructor stub
		setEmpresa(empresa);
		setLoja(loja);
		ruleCFeComandos = new RuleCFeComandos(caixa);
	}
	/**
	 * 
	 * @param nota
	 * @param usuario
	 * @return
	 * @throws SATException
	 * @throws Exception
	 */
	public CFeResult execute(Nota nota, Usuario usuario) throws SATException, Exception {
		CFeResult cfeResult = new CFeResult();
		if(nota != null){
			if(nota.getStatusCFe().equals(EnumStatusCFeNota.XML_NAO_GERADO) || nota.getStatusCFe().equals(EnumStatusCFeNota.REJEITADO)){
				String xml 		= genarateXML(nota);
				String result 	= ruleCFeComandos.enviarDadosVenda(nota.getCaixa().getCodAtivCfe(), xml);
				System.out.println("Resultado >>>> " + result);
				cfeResult.setCodeExecution(CODE_STATUS_OK);
				cfeResult.setDescription(result);
			}else{
				cfeResult.setCodeExecution(CODE_STATUS_INVALIDO);
				cfeResult.setDescription("Staus permitido para emitir CF-e : " + EnumStatusCFeNota.XML_NAO_GERADO + " ou " + EnumStatusCFeNota.REJEITADO + " mas veio " + nota.getStatusCFe());
			}
		}else{
			cfeResult.setCodeExecution(CODE_NAO_TEM_NOTA);
			cfeResult.setDescription("Nota veio nulo.");
		}
		
		return cfeResult;
	}
	
	/**
	 * Gera o XML do SAT.
	 * @param nota
	 * @return
	 * @throws SATException
	 */
	private String genarateXML(Nota nota) throws SATException {
		String xml 		= "";
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt(loja.getVerXMLCFe().getValue());
		//-------------------------------------------------
		//Identificacao SOFTWARE HOUSE
		//-------------------------------------------------
		Ide ide = new Ide();
		ide.setCNPJ(getEmpresa().getCnpjSoftwareHouse());
		ide.setNumeroCaixa(HandleString.zerosLeft(String.valueOf(nota.getCaixa().getCdCaixa()), 3) );
		//"SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT"
		ide.setSignAC(getLoja().getSignAC());
		infCFe.setIde(ide);
		//-------------------------------------------------
		//Identificacao do Emitente do Cupom fiscal
		//-------------------------------------------------
		Emit emit = new Emit();
		emit.setCNPJ(HandleString.cPFcNPJOnlyNumbers(loja.getPessoaJuridica().getCnpj()));
		emit.setIE(getLoja().getPessoaJuridica().getIe());
		//emit.setCRegTribISSQN(getRegimeISSQN(getEmpresa().getRegimeISSQN()));
		emit.setIndRatISSQN(getLoja().getIndRatISSQNSAT());
		emit.setIM(getLoja().getPessoaJuridica().getIm());
		infCFe.setEmit(emit);
		//-------------------------------------------------
		//Idetificacao do Destinatario do cupom fiscal
		//-------------------------------------------------
		infCFe.setDest(getDestinatario(nota));
		//-------------------------------------------------
		//Identificacao do local de entrega
		//-------------------------------------------------
		Entrega entrega = getEnderecoEntrega(nota);
		infCFe.setEntrega(entrega );
		//-------------------------------------------------
		//Detalhamento produtos e servicos da CF-e
		//-------------------------------------------------
		infCFe.setDets(getProdutos(nota));
		//------------------------
		Total total = new Total(); 
		total.setVCFeLei12741("1.05");
		infCFe.setTotal(total);
		//-------------------------------------------------
		//WA - Informacoes sobre Pagamento
		//-------------------------------------------------
		infCFe.setPgto(getMeiosDePagamento(nota));
		cfe.setInfCFe(infCFe);
		try {
			xml = HandleXML.getXMLFromObject(cfe);
			System.out.println(xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SATException("Erro ao tentar gerar o XML: " + e.getMessage());
			//fail(e.getMessage());
		}
		return xml.replace("<?xml version=\"1.0\" ?>", "");
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public class CFeResult{
		private int codeExecution 	= -1;
		private String description	= "Não houve execução. Apenas instanciado o retorno";
		
		public int getCodeExecution() {
			return codeExecution;
		}
		public void setCodeExecution(int codeExecution) {
			this.codeExecution = codeExecution;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}
	/**
	 * Transforma o tipo de tributacao de ISSQN da empresa para a do SAT.
	 * @param typeISSQN
	 * @return
	 */
	public EnumRegimeTributarioISSQN getRegimeISSQN(EnumRegimeISSQN typeISSQN) {
		if(typeISSQN == EnumRegimeISSQN.COOPERATIVA){
			return EnumRegimeTributarioISSQN.COOPERATIVA;
		}else if(typeISSQN == EnumRegimeISSQN.ESTIMATIVA){
			return EnumRegimeTributarioISSQN.ESTIMATIVA;
		}else if(typeISSQN == EnumRegimeISSQN.MICROEMPRESARIO_INDIVIDUAL){
			return EnumRegimeTributarioISSQN.MICROEMPRESARIO_INDIVIDUAL;
		}else if(typeISSQN == EnumRegimeISSQN.MIRCOEMPRESA_MUNICIPAL){
			return EnumRegimeTributarioISSQN.MIRCOEMPRESA_MUNICIPAL;
		}else if(typeISSQN == EnumRegimeISSQN.SOCIEDADE_DE_PROFISSIONAIS){
			return EnumRegimeTributarioISSQN.SOCIEDADE_DE_PROFISSIONAIS;
		}else{
			return EnumRegimeTributarioISSQN.MIRCOEMPRESA_MUNICIPAL;
		}
	}

	/**
	 * 
	 * @param nota
	 * @return
	 */
	public Dest getDestinatario(Nota nota) {
		Dest destinatario = new Dest();
		Cliente cliente = nota.getCliente();
		if(cliente != null){
			if(cliente.getTipoPessoa() == EnumTipoPessoa.FISICA){
				destinatario.setCpfCnpj(new CPF(cliente.getPessoaFisica().getCpf()));
				destinatario.setXNome(cliente.getPessoaFisica().getNome());
			}else{
				destinatario.setCpfCnpj(new CNPJ(cliente.getPessoaJuridica().getCnpj()));
				destinatario.setXNome(cliente.getPessoaJuridica().getFantasia());
			}
		}
		return destinatario;
	}
	/**
	 * 
	 * @param nota
	 * @return
	 */
	public Entrega getEnderecoEntrega(Nota nota) {
		Pedido pedido = nota.getPedido();
		Entrega entrega = null;
		if(pedido != null){
			Endereco ender = pedido.getEndereco();
			if(ender != null){
				entrega = new Entrega();
				entrega.setXLgr(ender.getLogradouro());
				entrega.setNro(ender.getNumero());
				entrega.setXCpl(ender.getComplemento());
				entrega.setXBairro(ender.getBairro().getDescricao());
				entrega.setXMun(ender.getBairro().getCidade().getDescricao());
				entrega.setUF(getUF(ender.getUf()));
			}
			
		}

		return entrega;
	}
	/**
	 * 
	 * @param enumUF
	 * @return
	 */
	public EnumUF getUF(br.com.barcadero.core.enums.EnumUF enumUF) {
		if(enumUF == br.com.barcadero.core.enums.EnumUF.AC){
			return EnumUF.AC;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.AL){
			return EnumUF.AL;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.AM){
			return EnumUF.AM;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.AP){
			return EnumUF.AP;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.BA){
			return EnumUF.BA;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.CE){
			return EnumUF.CE;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.DF){
			return EnumUF.DF;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.ES){
			return EnumUF.ES;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.GO){
			return EnumUF.GO;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.MA){
			return EnumUF.MA;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.MG){
			return EnumUF.MG;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.MS){
			return EnumUF.MS;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.MT){
			return EnumUF.MT;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.PA){
			return EnumUF.PA;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.PB){
			return EnumUF.PB;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.PE){
			return EnumUF.PE;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.PI){
			return EnumUF.PI;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.PR){
			return EnumUF.PR;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.RJ){
			return EnumUF.RJ;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.RN){
			return EnumUF.RN;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.RO){
			return EnumUF.RO;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.RR){
			return EnumUF.RR;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.RS){
			return EnumUF.RS;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.SC){
			return EnumUF.SC;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.SE){
			return EnumUF.SE;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.SP){
			return EnumUF.SP;
		}else if(enumUF == br.com.barcadero.core.enums.EnumUF.TO){
			return EnumUF.TO;
		}else{
			return EnumUF.AC;
		}
	}
	/**
	 * Extrai os produtos da nota para o formato que o XML do CFe exige.
	 * @param nota
	 * @return
	 * @throws SATException
	 */
	private List<Det> getProdutos(Nota nota) throws SATException{
		List<Det> dets = new ArrayList<Det>();
		int numItem = 0;
		for (NotaItens item : nota.getItens()) {
			++numItem;
			Det det = new Det();
			String strNumItem = String.valueOf(numItem);//HandleString.zerosLeft(String.valueOf(numItem), 3); 
			det.setNItem(strNumItem);
			String infAdProd = item.getInforAdicionais();
			if(infAdProd.trim().isEmpty()){
				det.setInfAdProd(null);
			}else{
				det.setInfAdProd(infAdProd);
			}
			
			Prod prod = new Prod();
			prod.setCProd(String.valueOf(item.getCodigo()));
			prod.setXProd(item.getDescricao());
			prod.setNCM(HandleString.zerosLeft(HandleString.parse(item.getProduto().getCdNcm()),8));
			prod.setCFOP(HandleString.parse(item.getProduto().getCfop())); // Faixa de 5000
			prod.setUCom(HandleString.parse(item.getProduto().getUnidade()).substring(0, 4));
			String quantidade = HandleNumericFormat.format(item.getQuantidade(), 4);
			prod.setQCom(quantidade);
			prod.setVUnCom(HandleString.parse(item.getVlUnidade()));
			prod.setIndRegra(EnumIndRegra.ARREDONDAMENTO);
			det.setProd(prod);
			//-------------------------------------------------
			//Tributos incidentes no Produto ou servico
			//-------------------------------------------------
			Imposto imposto = new Imposto();
			imposto.setVItem12741("2.50");
			//-------------------------------------------------
			//ICMS Normal e ST
			//-------------------------------------------------
			imposto.setICMS(getICMS(item));
			//-------------------------------------------------
			//PIS
			//-------------------------------------------------
			imposto.setPIS(getPIS(item));
			//-------------------------------------------------
			//Cofins
			//-------------------------------------------------
			imposto.setCOFINS(getCOFINS(item));
			det.setImposto(imposto );
			dets.add(det);
		}
		return dets;
	}
	
	/**
	 * Obter origem icms para o SAT na Nota
	 * @param item
	 * @return
	 */
	private ICMS getICMS(NotaItens item) {
		ICMS icms = new ICMS();
		//EnumTipoICMS typeICMS = item.getProduto().getTipoICMS();
		switch (item.getProduto().getTipoICMS()) {
		case ICMS00:
			ICMS00 icms00 	= new ICMS00();
			icms00.setOrig(getOrigemICMS(item));
			icms00.setCST(EnumCSTICMS00.TRIBUTADO_INTEGRALMENTE);
			icms00.setPICMS("5.33");
			icms.setiCMS(icms00);
			break;
		case ICMSSN102:
			ICMSSN102 icmssn102 = new ICMSSN102();
			icmssn102.setOrig(getOrigemICMS(item));
			icmssn102.setCSOSN(null);
			break;
		case ICMS40:
			ICMS40 icms40 = new ICMS40();
			icms40.setOrig(getOrigemICMS(item));
			icms40.setCST(EnumCSTICMS40.ICMS_COBRADO);
			break;
		case ICMSSN900:
			ICMSSN900 icmssn900 = new ICMSSN900();
			icmssn900.setOrig(getOrigemICMS(item));
			icmssn900.setCSOSN(null);
			icmssn900.setPICMS("");
			break;
		default:
			return null;
		}
		return icms;
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	private EnumOrigICMS getOrigemICMS(NotaItens item) {
		switch (item.getProduto().getOrigemIcms()) {
		case ESTRANGEIRA_IMP:
			return EnumOrigICMS.ESTRANGEIRA_IMPORT;
		case ESTRANGEIRA_N_SIMILAR:
			return EnumOrigICMS.ESTRANGEIRA_ADQ_CAMEX;
		case NACIONAL_40 :	
			return EnumOrigICMS.NACIONAL_40_70;
		case NACIONAL_BASICO:
			return EnumOrigICMS.NACIONAL_AJUSTES;
		case ESTRANGEIRA_INT:
			return EnumOrigICMS.ESTRANGEIRA_ADQUIR;
		case ESTRANGEIRA_SIMILAR:
			return EnumOrigICMS.ESTRANGEIRA_CAMEX;
		case NACIONAL_INF_40:
			return EnumOrigICMS.NACIONAL_INF_40;
		case NACIONAL_SUP_70:
			return EnumOrigICMS.NACIONAL_SUPER_70;
		default:
			return EnumOrigICMS.NACIONAL;
		}
	}
	/**
	 * Obtem uma instacia de pis conforme o produto
	 * @param item
	 * @return
	 */
	private PIS getPIS(NotaItens item) {
		PIS pis 		= new PIS();
		switch (item.getProduto().getTipoPis()) {
		case PIS_ALIQUOTA:
			PISAliq aliq	= new PISAliq();
			aliq.setCST(EnumCFeCSTPISAliq.CST_01);
			aliq.setPPIS("0.6500");
			aliq.setVBC(HandleString.parse(item.getVlTotal()));
			pis.setPisGroup(aliq);
			break;
		case PIS_NT:
			PISNT pisnt = new PISNT();
			pisnt.setCST("");
			pis.setPisGroup(pisnt);
			break;
		case PIS_OUTRO:
			PISOutr pisOutr = new PISOutr();
			pisOutr.setCST("");
			pisOutr.setPPIS("");
			pisOutr.setQBCProd("");
			pisOutr.setVAliqProd("");
			pisOutr.setVBC("");
			pis.setPisGroup(pisOutr);
			break;
		case PIS_QTDE:
			PISQtde pisQtde = new PISQtde();
			pisQtde.setCST("");
			pisQtde.setQBCProd("");
			pisQtde.setVAliqProd("");
			pis.setPisGroup(pisQtde);
			break;
		case PIS_SN:
			PISSN pissn = new PISSN();
			pissn.setCST("");
			pis.setPisGroup(pissn);
			break;
		default:
			break;
		}
		return pis;
	}
	
	/**
	 * Obtem o COFINS do produto
	 * @param item
	 * @return
	 */
	private COFINS getCOFINS(NotaItens item) {
		COFINS cofins 			= new COFINS();
		switch (item.getProduto().getTipoCofins()) {
		case COFINS_ALIQ:
			COFINSAliq cofinsAliq 	= new COFINSAliq();
			cofinsAliq.setCST(EnumCSTCOFINSAliq.OPER_TRIBUT_NORMAL);
			cofinsAliq.setPCOFINS("3.0000");
			cofinsAliq.setVBC(HandleString.parse(item.getVlTotal()));
			cofins.setCofins(cofinsAliq);
			break;
		case COFINS_NT:
			COFINSNT cofinsnt = new COFINSNT();
			cofinsnt.setCST(EnumCSTCOFINSNT.OPER_SEM_INCIDENCIA);
			cofins.setCofins(cofinsnt);
			break;
		case COFINS_OUTRO:
			COFINSOutr cofinsOutr = new COFINSOutr();
			cofinsOutr.setCST(EnumCSTCOFINSOutr.OUTRAS_OPERACOES);
			cofinsOutr.setPCOFINS("");
			cofinsOutr.setQBCProd("");
			cofinsOutr.setVAliqProd("");
			cofinsOutr.setVBC("");
			cofins.setCofins(cofinsOutr);
			break;
		case COFINS_QTDE:
			COFINSQtde cofinsQtde = new COFINSQtde();
			cofinsQtde.setCST("");
			cofinsQtde.setQBCProd("");
			cofinsQtde.setVAliqProd("");
			cofins.setCofins(cofinsQtde);
			break;
		case COFINS_SN:
			COFINSSN cofinssn = new COFINSSN();
			cofinssn.setCST(EnumCSTCOFINSSN.OUTRAS_OPERACOES);
			cofins.setCofins(cofinssn);
			break;
		default:
			break;
		}
		return cofins;
	}
	
	/**
	 * 
	 * @param nota
	 * @return
	 */
	private Pgto getMeiosDePagamento(Nota nota) {
		Pgto pgto = new Pgto();
		List<NotaMeioPgto> meiosPgto = nota.getMeiosPgto();
		List<MP> mps = new ArrayList<MP>();
		for (NotaMeioPgto notaMeioPgto : meiosPgto) {
			MP mp = new MP();
			mp.setCMP(getEnumMeioPagamentoSAT(notaMeioPgto.getTipoMeioPgto()));
			String vMP = HandleNumericFormat.format(HandleString.parse(notaMeioPgto.getValor()), 2);
			mp.setVMP(vMP);
			mps.add(mp);
		}
		pgto.setMPs(mps);
		return pgto;
	}
	
	/**
	 * Obter o tipo de pagamento que vem da nota 
	 * @param enumMeio
	 * @return
	 */
	private EnumMeioPagamento getEnumMeioPagamentoSAT(EnumTipoMeioPgto enumMeio) {
		switch (enumMeio) {
		case CHEQUE:
			return EnumMeioPagamento.CHEQUE;
		case DINHEIRO:
			return EnumMeioPagamento.DINHEIRO;
		case TEF:
			return EnumMeioPagamento.CARTAO_CREDITO;
		case FINANCIADO:
			return EnumMeioPagamento.OUTROS;
		case CREDIARIO:
			return EnumMeioPagamento.OUTROS;
		default:
			return EnumMeioPagamento.OUTROS;
		}
	}
	
}
