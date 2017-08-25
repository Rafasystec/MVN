package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.handles.HandleNumericFormat;
import br.com.barcadero.dao.DaoCupomEletronico;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
import br.com.barcadero.tables.CupomEletronico;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleCupomEletronico extends RuleModelo<CupomEletronico> {

	@Autowired
	private DaoCupomEletronico daoCupomEletronico;
	@Autowired
	private RuleNota ruleNota;

	public RuleNota getRuleNota() {
		return ruleNota;
	}

	public void setRuleNota(RuleNota ruleNota) {
		this.ruleNota = ruleNota;
	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoCupomEletronico.delete(codigo);
	}

	@Override
	public CupomEletronico find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCupomEletronico.find(codigo);
	}

	@Override
	public List<CupomEletronico> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoCupomEletronico.findAll();
	}
	/**
	 * Realiza um insert de uma venda SAT com sucesso.
	 * @param retornoSAT
	 * @param usuario
	 * @throws SATException
	 * @throws Exception
	 */
	public void insert(Loja loja, Empresa empresa, HandleRetornoSAT retornoSAT,Nota nota,Usuario usuario) throws SATException, Exception{
		CupomEletronico cupomEletronico = null;
		if(retornoSAT != null){
			cupomEletronico = new CupomEletronico(empresa, loja, usuario);
			cupomEletronico.setChvAcesso(retornoSAT.getChaveDeConsulta());
			cupomEletronico.setCodRetModulo(HandleNumericFormat.parseInt(retornoSAT.getCodigoRetorno1()));
			cupomEletronico.setCodSefaz(HandleNumericFormat.parseInt(retornoSAT.getCodigoRetorno2()));
			cupomEletronico.setDtEmissao(new Date());
			cupomEletronico.setEmpresa(empresa);
			cupomEletronico.setMensagem(retornoSAT.getMensagem());
			cupomEletronico.setMsgSefaz(retornoSAT.getMensagemSEFAZ());
			cupomEletronico.setNrExtrato(HandleNumericFormat.parseLong(retornoSAT.getUltimoCFeSat()));
			cupomEletronico.setNrSessaoSat(retornoSAT.getNumeroSessao());
			cupomEletronico.setXmlBase64(retornoSAT.getArquivoCFeSAT());
			cupomEletronico.setValorTotal(HandleNumericFormat.parseBigDecimal(retornoSAT.getValorTotaldoCupom()));
			cupomEletronico.setAssinaturaQRCode(retornoSAT.getSignatureValue());
			cupomEletronico.setNota(nota);
			cupomEletronico = insert(cupomEletronico);
			nota.setCfe(cupomEletronico);
			ruleNota.update(nota);
		}
	}

	@Override
	public List<CupomEletronico> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CupomEletronico> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CupomEletronico insert(CupomEletronico cupomEletronico) throws Exception {
		
		return daoCupomEletronico.insert(cupomEletronico);
	}

	@Override
	public CupomEletronico update(CupomEletronico entidade) throws Exception {
		return daoCupomEletronico.update(entidade);
	}
	
	public void imprimirExtratoCFe(Nota nota) {
		
	}

}
