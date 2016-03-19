package br.com.barcadero.module.sat.handle;

import com.sun.jna.Library;

public abstract interface InterfaceGeneralSAT extends Library {
	public abstract String EnviarDadosVenda(int numeroSessao, String codigoDeAtivacao, String dadosVenda);
	public abstract String CancelarUltimaVenda(int numeroSessao, String codigoDeAtivacao, String chave, String dadosCancelamento);
    public abstract String ConsultarSAT(int numeroSessao);
    public abstract String TesteFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda);
    public abstract String ConsultarNumeroSessao(int numeroSessao, String codigoDeAtivacao, int cNumeroDeSessao);
    public abstract String AtivarSAT(int numeroSessao, int subComando, String codigoDeAtivacao, String cnpj, int cUF);
    public abstract String ComunicarCertificadoICPBRASIL(int numeroSessao, String codigoDeAtivacao, String certificado);
    public abstract String ConsultarStatusOperacional(int numeroSessao, String codigoDeAtivacao);
    public abstract String ConfigurarInterfaceDeRede(int numeroSessao, String codigoDeAtivacao, String dadosConfiguracao);
    public abstract String AssociarAssinatura(int numeroSessao, String codigoDeAtivacao, String cnpjValue, String assinaturaCNPJs);
    public abstract String AtualizarSoftwareSAT(int numeroSessao, String codigoDeAtivacao);
    public abstract String ExtrairLogs(int numeroSessao, String codigoDeAtivacao);
    public abstract String BloquearSAT(int numeroSessao, String codigoDeAtivacao);
    public abstract String DesbloquearSAT(int numeroSessao, String codigoDeAtivacao);
    public abstract String TrocarCodigoDeAtivacao(int numeroSessao, String codigoDeAtivacao, int opcao, String novoCodigo, String confNovoCodigo);
}
