package br.com.barcadero.module.sat.handle;

import java.util.*;



public class HendleCodesFromModule
{

private HashMap<String, String> tabela;



public HendleCodesFromModule() {
	this.carregaTabela();
}

public void carregaTabela() {
	HashMap<String, String> tabela = new HashMap<String, String>();
	tabela.put("04000", "Ativado corretamente.");
	tabela.put("04001", "Erro na criacao do certificado.");
	tabela.put("04002", "SEFAZ nao reconhece este SAT (CNPJ invalido).");
	tabela.put("04003", "SAT ja ativado.");
	tabela.put("04004", "SAT com posse cessada.");
	tabela.put("04005", "Erro de comunicao com a SEFAZ.");
	tabela.put("04098", "SAT em processamento. Tente novamente.");
	tabela.put("04099", "Erro desconhecido na ativacao.");
	tabela.put("05001", "Certificado transmitido com Sucesso.");
	tabela.put("05002", "Erro de comunicacao com a SEFAZ.");
	tabela.put("05003", "Certificado Invalido.");
	tabela.put("05098", "SAT em processamento. Tente novamente.");
	tabela.put("05099", "Erro desconhecido.");
	tabela.put("06000", "Emitido com sucesso + conteudo notas.");
	tabela.put("06001", "Codigo de ativacao invalido.");
	tabela.put("06002", "SAT ainda nao ativado.");
	tabela.put("06003", "SAT nao vinculado ao AC.");
	tabela.put("06004", "Vinculacao do AC nao confere.");
	tabela.put("06005", "Tamanho do CF-e-SAT superior a 1.500Kb.");
	tabela.put("06006", "SAT bloqueado pelo contribuinte.");
	tabela.put("06007", "SAT bloqueado pela SEFAZ.");
	tabela.put("06008", "SAT bloqueado por falta de comunicacao.");
	tabela.put("06009", "SAT bloqueado, c�digo de ativa��o incorreto.");
	tabela.put("06010", "Erro de valida��o do conte�do.");
	tabela.put("06098", "SAT em processamento. Tente novamente.");
	tabela.put("06099", "Erro desconhecido na emiss�o.");
	tabela.put("07000", "Cupom cancelado com sucesso + conte�do CF-e- SAT cancelado.");
	tabela.put("07001", "C�digo ativa��o inv�lido.");
	tabela.put("07002", "Cupom inv�lido.");
	tabela.put("07003", "SAT bloqueado pelo contribuinte.");
	tabela.put("07004", "SAT bloqueado pela SEFAZ.");
	tabela.put("07005", "SAT bloqueado por falta de comunica��o.");
	tabela.put("07006", "SAT bloqueado, c�digo de ativa��o incorreto.");
	tabela.put("07007", "Erro de valida��o do conte�do.");
	tabela.put("07098", "SAT em processamento. Tente novamente.");
	tabela.put("07099", "Erro desconhecido no cancelamento.");
	tabela.put("08000", "SAT em opera��o.");
	tabela.put("08098", "SAT em processamento. Tente novamente.");
	tabela.put("08099", "Erro desconhecido.");
	tabela.put("09000", "Emitido com sucesso");
	tabela.put("09001", "C�digo ativa��o inv�lido");
	tabela.put("09002", "SAT ainda n�o ativado.");
	tabela.put("09098", "SAT em processamento. Tente novamente.");
	tabela.put("09099", "Erro desconhecido.");
	tabela.put("10000", "Resposta com Sucesso.");
	tabela.put("10098", "SAT em processamento. Tente novamente.");
	tabela.put("10099", "Erro desconhecido.");
	tabela.put("11000", "Emitido com sucesso.");
	tabela.put("11001", "C�digo ativa��o inv�lido");
	tabela.put("11002", "SAT ainda n�o ativado.");
	tabela.put("11003", "Sess�o n�o existe.");
	tabela.put("11098", "SAT em processamento. Tente novamente.");
	tabela.put("11099", "Erro desconhecido.");
	tabela.put("12000", "Rede Configurada com Sucesso.");
	tabela.put("12001", "Dados fora do padr�o a ser informado.");
	tabela.put("12098", "SAT em processamento. Tente novamente.");
	tabela.put("12099", "Erro desconhecido.");
	tabela.put("13000", "Assinatura do AC Registrada.");
	tabela.put("13001", "Erro de comunica��o com a SEFAZ.");
	tabela.put("13002", "Assinatura fora do padr�o informado.");
	tabela.put("13098", "SAT em processamento. Tente novamente.");
	tabela.put("13099", "Erro desconhecido.");
	tabela.put("14000", "Software Atualizado com Sucesso.");
	tabela.put("14001", "Atualiza��o em Andamento.");
	tabela.put("14002", "Erro na atualiza��o.");
	tabela.put("14098", "SAT em processamento. Tente novamente.");
	tabela.put("14099", "Erro desconhecido");
	tabela.put("15000", "Transfer�ncia completa.");
	tabela.put("15001", "Transfer�ncia em andamento.");
	tabela.put("15098", "SAT em processamento. Tente novamente.");
	tabela.put("15099", "Erro desconhecido.");
	tabela.put("16000", "Equipamento SAT bloqueado com sucesso.");
	tabela.put("16001", "Equipamento SAT j� est� bloqueado.");
	tabela.put("16002", "Erro de comunica��o com a SEFAZ.");
	tabela.put("16098", "SAT em processamento. Tente novamente.");
	tabela.put("16099", "Erro desconhecido.");
	tabela.put("17000", "Equipamento SAT desbloqueado com sucesso.");
	tabela.put("17001", "SAT bloqueado pelo contribuinte.");
	tabela.put("17002", "SAT bloqueado pela SEFAZ.");
	tabela.put("17003", "Erro de comunica��o com a SEFAZ.");
	tabela.put("17098", "SAT em processamento. Tente novamente.");
	tabela.put("17099", "Erro desconhecido.");
	tabela.put("18000", "C�digo de ativa��o alterado com sucesso.");
	tabela.put("18001", "C�digo de ativa��o Incorreto.");
	tabela.put("18002", "C�digo de ativa��o de emerg�ncia Incorreto.");
	tabela.put("18098", "SAT em processamento. Tente novamente.");
	tabela.put("18099", "Erro desconhecido");
	this.tabela = tabela;
}

public String getDescricao(String codigo) {
	String retorno = "";
	if (codigo != null && codigo.trim().length() > 0) {
		retorno = this.tabela.get(codigo);
	}
	return retorno;
}



} /** End Class */
