package br.com.barcadero.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.core.enums.EnumTipoAviso;
import br.com.barcadero.rule.RuleAvisos;
import br.com.barcadero.tables.Avisos;
import br.com.barcadero.tables.Entidade;

@ManagedBean(name="avisos")
public class BeanAvisos extends SuperBean {

	private static final long serialVersionUID = -6995320689933365585L;
	private Avisos aviso;
	private List<Entidade> avisos;
	private EnumTipoAviso[] tipos;
	private RuleAvisos rulAvisos;
	public BeanAvisos() {
		rulAvisos 	= new RuleAvisos(getDataBaseSession());
		aviso 		= new Avisos(getSession().getLojaLogada(), getSession().getUsuarioLogado());
	}
	
	public Avisos getAviso() {
		return aviso;
	}

	public void setAviso(Avisos aviso) {
		this.aviso = aviso;
	}

	public List<Entidade> getAvisos() throws Exception {
		return rulAvisos.findAll();
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
		rulAvisos.insert(aviso);
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
