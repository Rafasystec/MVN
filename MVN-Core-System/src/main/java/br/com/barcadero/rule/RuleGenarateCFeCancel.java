package br.com.barcadero.rule;

import org.springframework.stereotype.Service;

import br.com.barcadero.commons.util.HandleString;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.xml.cancelamento.CFeCanc;
import br.com.barcadero.module.sat.xml.cancelamento.Dest;
import br.com.barcadero.module.sat.xml.cancelamento.Emit;
import br.com.barcadero.module.sat.xml.cancelamento.Ide;
import br.com.barcadero.module.sat.xml.cancelamento.InfCFe;
import br.com.barcadero.module.sat.xml.cancelamento.Total;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
@Service
public class RuleGenarateCFeCancel {

	public RuleGenarateCFeCancel() {
	}
	
	public String gerarXMLdeCancelamento(Empresa empresa, Loja loja, Caixa caixa, Nota nota) throws SATException {
		String xmlCancel  = "";
		CFeCanc cFeCanc   = new CFeCanc();
		InfCFe infCFe 	  = new InfCFe();
		Emit emit 	      = new Emit();
		Dest dest 	      = new Dest();
		Total total       = new Total();
		infCFe.setChCanc(nota.getCfe().getChvAcesso());
		Ide IdeCancel = new Ide();
		IdeCancel.setCNPJ(empresa.getCnpjSoftwareHouse());
		IdeCancel.setNumeroCaixa(HandleString.zerosLeft(String.valueOf(caixa.getCdCaixa()),3));
		IdeCancel.setSignAC(loja.getSignAC());
		infCFe.setTotal(total );
		infCFe.setDest(dest );
		infCFe.setEmit(emit );
		infCFe.setIde(IdeCancel);
		cFeCanc.setInfCFe(infCFe);
		try {
			xmlCancel = HandleXML.getXMLFromObject(cFeCanc);
System.out.println(xmlCancel);
		} catch (Exception e) {
			throw new SATException("Erro ao tentar gerar o XML: " + e.getMessage());
		}
		return xmlCancel.replace("<?xml version=\"1.0\" ?>", "");
	
	}
}
