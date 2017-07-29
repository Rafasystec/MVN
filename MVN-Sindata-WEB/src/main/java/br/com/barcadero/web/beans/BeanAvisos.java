package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.core.enums.EnumTipoAviso;
import br.com.barcadero.rule.RuleAvisos;
import br.com.barcadero.tables.Avisos;
import br.com.barcadero.tables.Entidade;

@ManagedBean(name="avisos")
public class BeanAvisos extends SuperBean <Avisos>{

	private static final long serialVersionUID = -6995320689933365585L;
	private Avisos aviso;
	private List<Entidade> avisos;
	private EnumTipoAviso[] tipos;
	@ManagedProperty(value="#{ruleAvisos}")
	private RuleAvisos ruleAvisos;
	public BeanAvisos() {
		//rulAvisos 	= new RuleAvisos(getDataBaseSession());
		aviso 		= new Avisos(getSession().getLojaLogada(), getSession().getUsuarioLogado());
		testeAviso();
	}
	
	public void testeAviso() {
		Avisos avisos = new Avisos(getLojaLogada(),getUsuarioLogado());
		avisos.setDescricao("OK ALGUMA COISA");
		avisos.setDtExibir(new Date());
		avisos.setDtValidade(new Date());
		avisos.setFlTipo(EnumTipoAviso.I);
		
	
	}
	
	public Avisos getAviso() {
		return aviso;
	}

	public void setAviso(Avisos aviso) {
		this.aviso = aviso;
	}

	public List<Avisos> getAvisos() throws Exception {
		return ruleAvisos.findAll();
	}

	public void setAvisos(List<Entidade> avisos) {
		this.avisos = avisos;
	}

	public EnumTipoAviso[] getTipos() {
		return EnumTipoAviso.values();
	}

	public void setTipos(EnumTipoAviso[] tipos) {
		this.tipos = tipos;
	}

	@Override
	public String salvar() throws Exception {
		ruleAvisos.insert(aviso);
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
		Avisos avisos = ruleAvisos.find(1);
		if(avisos!=null){
			avisos.setDescricao("ATEREI PARA O AUDIT");
			ruleAvisos.update(avisos);
		}
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleAvisos getRuleAvisos() {
		return ruleAvisos;
	}

	public void setRuleAvisos(RuleAvisos ruleAvisos) {
		this.ruleAvisos = ruleAvisos;
	}

	@Override
	public boolean validar(Avisos entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
