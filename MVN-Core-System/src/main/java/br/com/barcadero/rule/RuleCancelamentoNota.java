package br.com.barcadero.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.retornos.RetCancelarUltimaVenda;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CupomEletronico;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Nota;

@Service
public class RuleCancelamentoNota {
	public RuleCancelamentoNota() {
		System.out.println("Auto-generated constructor stub for class " + RuleCancelamentoNota.class.getName());
	}
	@Autowired
	private RuleGenarateCFeCancel genarateCFeCancel;
	@Autowired
	private RuleCupomEletronico ruleCupomEletronico;
	@Autowired
	private RuleNota ruleNota;
	
	public String cancelarNotaNoSistema(Empresa empresa, Loja loja, Caixa caixa, Nota nota) {
		if(caixa != null){
			switch (caixa.getTipoNota()) {
			case MOD_55:
				return "Nota fiscal eletrônica ainda não implementada";
			case MOD_57:
				return "CT-e ainda não suportado";
			case MOD_59:
				return cancelarCFeModelo59(empresa, loja, caixa, nota);
			case MOD_65:
				//NFC-e
				return "NFC-e ainda não implementado.";
			default:
				break;
			}
		}
		return "Cancelamento não executado";
	}
	
	private String cancelarCFeModelo59(Empresa empresa, Loja loja, Caixa caixa, Nota nota) {
		try {
			return cancelarCFe(empresa, loja, caixa, nota);
		} catch (SATException e) {
			return "Erro ao tentar cancelar CF-e: "+ e.getMessage();
		}
	}
	@Transactional(rollbackFor=SATException.class)
	private String cancelarCFe(Empresa empresa, Loja loja, Caixa caixa, Nota nota) throws SATException {
		String result    = "";
		RuleCFeComandos cfeComandos;
		try {
			String xmlCancel = genarateCFeCancel.gerarXMLdeCancelamento(empresa, loja, caixa, nota);
			System.out.println("XML cancelamento gerado: " + xmlCancel);
			cfeComandos		= new RuleCFeComandos(nota.getCaixa());
			String retorno  = cfeComandos.cancelarUltimaVenda(caixa.getCodAtivCfe(), nota.getCfe().getChvAcesso(), xmlCancel);
			RetCancelarUltimaVenda retCancelarUltimaVenda = RetCancelarUltimaVenda.getRetorno(retorno);
			registrarCancelamentoCupomEletronico(nota, retCancelarUltimaVenda);
		} catch (SATException e) {
			throw e;
		}catch (Exception e) {
			throw new SATException("Erro na emissão do CF-e : "+ e.getMessage());
		}
		try{
			imprimirExtratoDeCancelamentoCFe();
		}catch(Exception e){
			result = result + " . Apenas erro na impressão " + e.getMessage();
		}
		return result;
	}
	private void registrarCancelamentoCupomEletronico(Nota nota, RetCancelarUltimaVenda retCancelarUltimaVenda) throws Exception {
		if(retCancelarUltimaVenda.getCodigoRetSAT().equals(RetCancelarUltimaVenda.RETORNO_COM_SUCESSO)){
			CupomEletronico cupomEletronico = nota.getCfe();
			cupomEletronico.setChvAcessoCancel(retCancelarUltimaVenda.getChaveConsulta());
			cupomEletronico.setMensagemCancel(retCancelarUltimaVenda.getMsgModulo());
			cupomEletronico.setNrSessaoSatCancel(retCancelarUltimaVenda.getNumeroSessao());
			cupomEletronico = ruleCupomEletronico.update(cupomEletronico);
			nota.setFlNotaCancelada(true);
			nota = ruleNota.update(nota);
		}
	}
	
	private void imprimirExtratoDeCancelamentoCFe() {
		
	}

}
