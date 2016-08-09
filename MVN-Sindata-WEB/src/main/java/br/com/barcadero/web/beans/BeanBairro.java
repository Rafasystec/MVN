package br.com.barcadero.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleBairro;
import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;

@ManagedBean
@RequestScoped
public class BeanBairro extends SuperBean {

	private static final long serialVersionUID = 5859355521669947983L;
	private Bairro bairro;
	private RuleBairro fcdBairro;
	private RuleCidade fcdCidade;
	private long codCidade;
	private List<Cidade> cidades;
	private List<Bairro> bairros;
	private long codEstado;
	
	public BeanBairro() {
		bairro 		= new Bairro(getUsuarioLogado());
		//fcdBairro	= new RuleBairro(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		fcdCidade	= new RuleCidade(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
	}
	
	public List<Cidade> getCidades() {
		try{
			this.cidades = fcdCidade.getCidadesByCodEstado(getCodEstado());
			return cidades;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Bairro> getBairros() {
		try{
			if(getCodCidade() != 0 ){
				this.bairros = this.fcdBairro.getBairrosByCodCidade(getCodCidade());
			}
			return bairros;
		}catch(Exception e){
			e.printStackTrace();
			return bairros;
		}
	}
	
	@Override
	public String salvar() throws Exception {
		String ret = fcdBairro.insert(bairro);
		System.out.println(ret);
		return null;
	}

	@Override
	public String alterar() throws Exception {
		String ret = fcdBairro.update(bairro);
		System.out.println(ret);
		return null;
	}

	@Override
	public String deletar() throws Exception {
		String ret = fcdBairro.delete(bairro.getCodigo());
		System.out.println(ret);
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Preparar o forme para um novo registro
		bairro = new Bairro(getUsuarioLogado());
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public long getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(long codCidade) {
		this.codCidade = codCidade;
	}

	public long getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(long codEstado) {
		this.codEstado = codEstado;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

}
