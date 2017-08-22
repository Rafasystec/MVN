package br.com.barcadero.web.beans;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.commons.enuns.EnumTipoComandoSocket;
import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.commons.socket.ClientSocket;
import br.com.barcadero.commons.socket.SocketCommand;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.web.functions.HandleFaceContext;
import br.com.barcadero.web.functions.HandleMessage;

/**
 * Para a configuracao do caixa
 * @author Rafael Rocha
 * @since versao 1.0 dia 24/02/2016 as 11:04
 */
@ManagedBean(name="configCaixa")
@ViewScoped
public class BeanConfigCaixa extends SuperBean<Caixa> {

	private static final long serialVersionUID = 2575309545374375876L;
	private Caixa caixa;
	private Caixa selectedCaixa;
	private List<Caixa> caixas;
	@ManagedProperty(name="ruleCaixa",value="#{ruleCaixa}")
	private RuleCaixa ruleCaixa;
	private EnumModeloNota[] tiposNota;
	
	@PostConstruct
	public void init() {
		caixa 		= new Caixa(getEmpresaLogada(),getLojaLogada(),getUsuarioLogado());
		//callClient();
	}
	
	@Override
	public String salvar() {
		try{
			caixa.setIp(getSession().getIpAddress());
			ruleCaixa.insert(caixa);			
		}catch(Exception e){
			HandleMessage.error("Erro ao tentar salvar o caixa: ", e.getMessage());
		}
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public EnumModeloNota[] getTiposNota() {
		this.tiposNota = EnumModeloNota.values();
		return tiposNota;
	}

	public void setTiposNota(EnumModeloNota[] tiposNota) {
		this.tiposNota = tiposNota;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Caixa> getCaixas() {
		try {
			System.out.println(HandleFaceContext.getIpAddress());
			this.caixas = ruleCaixa.findAll(getEmpresaLogada());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}

	public Caixa getSelectedCaixa() {
		return selectedCaixa;
	}

	public void setSelectedCaixa(Caixa selectedCaixa) {
		this.selectedCaixa = selectedCaixa;
	}

	public EnumTipoModuloSAT[] getModulosSAT() {
		return EnumTipoModuloSAT.values();
	}

	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}

	@Override
	public boolean validar(Caixa entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void callClient() {
		ClientSocket cliente = new ClientSocket();		
		
			cliente.setIpServidor("192.168.15.8");//ip do cliente a ser invocado
		
        
        SocketCommand cmd = new SocketCommand();
        cmd.setCommand("VetorComando");
        cmd.setTipoComando(EnumTipoComandoSocket.CMD_FOR_ECF);
        try {
        	cmd = cliente.sendAndReceive(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Resposta do servidor: " + cmd.getResponse());
	}

}
