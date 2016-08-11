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
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleCupomEletronico extends RuleModelo<CupomEletronico> {

	private DaoCupomEletronico daoCupomEletronico;
	
	@Autowired
	public RuleCupomEletronico(DaoCupomEletronico daoCupomEletronico) {
		// TODO Auto-generated constructor stub
		this.daoCupomEletronico = daoCupomEletronico;
	}
//	public RuleCupomEletronico(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoCupomEletronico = new DaoCupomEletronico(empresa, loja, session);
//	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return daoCupomEletronico.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoCupomEletronico.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		return daoCupomEletronico.update(entidade);
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
	public void insert(HandleRetornoSAT retornoSAT,Usuario usuario) throws SATException, Exception{
		CupomEletronico cupomEletronico = null;
		if(retornoSAT != null){
			cupomEletronico = new CupomEletronico(getLoja(), usuario);
			cupomEletronico.setChvAcesso(retornoSAT.getChaveDeConsulta());
			cupomEletronico.setCodRetModulo(HandleNumericFormat.parseInt(retornoSAT.getCodigoRetorno1()));
			cupomEletronico.setCodSefaz(HandleNumericFormat.parseInt(retornoSAT.getCodigoRetorno2()));
			cupomEletronico.setDtEmissao(new Date());
			cupomEletronico.setEmpresa(getEmpresa());
			cupomEletronico.setMensagem(retornoSAT.getMensagem());
			cupomEletronico.setMsgSefaz(retornoSAT.getMensagemSEFAZ());
			cupomEletronico.setNrExtrato(HandleNumericFormat.parseLong(retornoSAT.getUltimoCFeSat()));
			//cupomEletronico.setNrSerieEquipamento(retornoSAT.getNSerie());
			cupomEletronico.setNrSessaoSat(retornoSAT.getNumeroSessao());
			cupomEletronico.setXmlBase64(retornoSAT.getArquivoCFeSAT());
			cupomEletronico.setValorTotal(HandleNumericFormat.parseBigDecimal(retornoSAT.getValorTotaldoCupom()));
			cupomEletronico.setAssinaturaQRCode(retornoSAT.getSignatureValue());
			insert(cupomEletronico);
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

}
