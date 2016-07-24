package br.com.barcadero.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.resource.transaction.spi.TransactionStatus;

import br.com.barcadero.commons.util.HandleString;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.core.enums.EnumRegimeISSQN;
import br.com.barcadero.core.enums.EnumStatusCFeNota;
import br.com.barcadero.core.enums.EnumTipoPessoa;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;
import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumMeioPagamento;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.xml.envio.CFe;
import br.com.barcadero.module.sat.xml.envio.COFINS;
import br.com.barcadero.module.sat.xml.envio.COFINSAliq;
import br.com.barcadero.module.sat.xml.envio.Dest;
import br.com.barcadero.module.sat.xml.envio.Det;
import br.com.barcadero.module.sat.xml.envio.Emit;
import br.com.barcadero.module.sat.xml.envio.Entrega;
import br.com.barcadero.module.sat.xml.envio.ICMS;
import br.com.barcadero.module.sat.xml.envio.ICMS00;
import br.com.barcadero.module.sat.xml.envio.Ide;
import br.com.barcadero.module.sat.xml.envio.Imposto;
import br.com.barcadero.module.sat.xml.envio.InfCFe;
import br.com.barcadero.module.sat.xml.envio.MP;
import br.com.barcadero.module.sat.xml.envio.PIS;
import br.com.barcadero.module.sat.xml.envio.PISAliq;
import br.com.barcadero.module.sat.xml.envio.Pgto;
import br.com.barcadero.module.sat.xml.envio.Prod;
import br.com.barcadero.module.sat.xml.envio.Total;
import br.com.barcadero.module.sat.xml.util.CNPJ;
import br.com.barcadero.module.sat.xml.util.CPF;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.Usuario;

public class RuleGenarateCFe {
	
	public static final int CODE_NAO_TEM_NOTA 		= 13;
	public static final int CODE_STATUS_INVALIDO 	= 14;
	private Empresa empresa = null;
	private Loja loja = null;
	
	public RuleGenarateCFe(Empresa empresa, Loja loja) {
		// TODO Auto-generated constructor stub
		setEmpresa(empresa);
		setLoja(loja);
	}
	
	public CFeResult execute(Nota nota, Usuario usuario) {
		CFeResult cfeResult = new CFeResult();
		if(nota != null){
			if(nota.getStatusCFe().equals(EnumStatusCFeNota.XML_NAO_GERADO) || nota.getStatusCFe().equals(EnumStatusCFeNota.REJEITADO)){
				
				
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
	
	private String genarateXML(Nota nota) throws SATException {
		
		
		String xml = "";
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt(loja.getVerXMLCFe().toString());
		//-------------------------------------------------
		//Identificacao SOFTWARE HOUSE
		//-------------------------------------------------
		Ide ide = new Ide();
		ide.setCNPJ(getEmpresa().getCnpjSoftwareHouse());
		ide.setNumeroCaixa(String.valueOf(nota.getCaixa().getCdCaixa()));
		//"SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT"
		ide.setSignAC(getLoja().getSignAC());
		infCFe.setIde(ide);
		//-------------------------------------------------
		//Identificacao do Emitente do Cupom fiscal
		//-------------------------------------------------
		Emit emit = new Emit();
		//"08723218000186" CNPJ da loja para testes com o TANCA
		emit.setCNPJ(HandleString.cPFcNPJOnlyNumbers(loja.getPessoaJuridica().getCnpj())); //CNPJ da loja
		//emit.setIE("149626224113");
		emit.setIE(getLoja().getPessoaJuridica().getIe());
		emit.setCRegTribISSQN(getRegimeISSQN(getEmpresa().getRegimeISSQN()));
		emit.setIndRatISSQN(getLoja().getIndRatISSQNSAT());
		//emit.setIM("123456789");
		emit.setIM(getLoja().getPessoaJuridica().getIm());
		infCFe.setEmit(emit);
		//-------------------------------------------------
		//Idetificacao do Destinatario do cupom fiscal
		//-------------------------------------------------
//		Dest destinatario = new Dest();
//		destinatario.setCpfCnpj(new CNPJ("46541673000150"));
//		destinatario.setXNome("RAZAO SOCIAL");
		infCFe.setDest(getDestinatario(nota));
		//-------------------------------------------------
		//Identificacao do local de entrega
		//-------------------------------------------------
		Entrega entrega = new Entrega();
		entrega.setXLgr("Logradouro");
		entrega.setNro("123");
		entrega.setXCpl("complemento");
		entrega.setXBairro("Bairro");
		entrega.setXMun("Municipio");
		entrega.setUF(EnumUF.CE);
		infCFe.setEntrega(entrega );
		//-------------------------------------------------
		//Detalhamento produtos e servicos da CF-e
		//-------------------------------------------------
		List<Det> dets = new ArrayList<Det>();
		Det det = new Det();
		det.setNItem("001");
		det.setInfAdProd("Informacao adicional");
		Prod prod = new Prod();
		prod.setCProd("0090980");
		prod.setXProd("PROD HOMOLOG");
		prod.setNCM("01031000");
		prod.setCFOP("5102"); // Faixa de 5000
		prod.setUCom("UN");
		prod.setQCom("1.0000");
		prod.setVUnCom("10.99");
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
		ICMS icms 		= new ICMS();
		ICMS00 icms00 	= new ICMS00();
		icms00.setOrig(EnumOrigICMS.NACIONAL);
		icms00.setCST(EnumCSTICMS00.TRIBUTADO_INTEGRALMENTE);
		icms00.setPICMS("5.33");
		icms.setiCMS(icms00);
		imposto.setICMS(icms );
		//-------------------------------------------------
		//PIS
		//-------------------------------------------------
		PIS pis 		= new PIS();
		PISAliq aliq	= new PISAliq();
		aliq.setCST("01");
		aliq.setPPIS("0.1700");
		aliq.setVBC("10.99");
		pis.setPISAliq(aliq);
		imposto.setPIS(pis );
		//-------------------------------------------------
		//Cofins
		//-------------------------------------------------
		COFINS cofins 			= new COFINS();
		COFINSAliq cofinsAliq 	= new COFINSAliq();
		cofinsAliq.setCST(EnumCSTCOFINSAliq.OPER_TRIBUT_NORMAL);
		cofinsAliq.setPCOFINS("0.0900");
		cofinsAliq.setVBC("10.99");
		cofins.setCofins(cofinsAliq);
		imposto.setCOFINS(cofins );
		det.setImposto(imposto );
		dets.add(det);
		infCFe.setDets(dets);
		//------------------------
		Total total = new Total(); 
		total.setVCFeLei12741("1.05");
		infCFe.setTotal(total);
		//-------------------------------------------------
		//WA - Informacoes sobre Pagamento
		//-------------------------------------------------
		Pgto pgto = new Pgto();
		List<MP> mps = new ArrayList<MP>();
		MP mp = new MP();
		mp.setCMP(EnumMeioPagamento.DINHEIRO);
		mp.setVMP("10.99");
		mps.add(mp);
		pgto.setMPs(mps );
		infCFe.setPgto(pgto);
		cfe.setInfCFe(infCFe);
		try {
			//HandleXML.toFile(cfe, "D://temp/", "cfe.xml");
			xml = HandleXML.getXMLFromObject(cfe);
			//System.out.println(xml);
			//assertEquals("O XML gerado nao foi igual ao esperado",getXMLVendaEmperado(),xml);
			//transmitirTanca(xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		return xml;
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
	
	public Entrega getEnderecoEntrega(Nota nota) {
		Pedido pedido = nota.getPedido();
		Entrega entrega = new Entrega();
		if(pedido != null){
			Endereco ender = pedido.getEndereco();
			if(ender != null){
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
	
	
}
