package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import br.com.barcadero.rule.RuleBairro;
import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;

/**
 * Atencao: Usar esse bean somente para a popup de bairro
 * @author Rafael Rocha
 *
 */
@RequestScoped
@ManagedBean(name="popBairro")
public class BeanPopBairro extends SuperBean{
	
	private static final long serialVersionUID = 8270960627163947540L;
	private long codigo;
	private long codCidade;
	private String codIbge;
	private String descricao;
	private Date dtCadastro;
	private List<Cidade> cidades;
	private List<Bairro> bairros;
	private List<String> params;
	@ManagedProperty("#{ruleBairro}")
	private RuleBairro ruleBairro;
	@ManagedProperty("#{ruleCidade}")
	private RuleCidade ruleCidade;
	
	public List<Cidade> getCidades() {
		try{
			this.cidades = ruleCidade.getCidadesByCodEstado(GlobalVariables.codEstado);
			return cidades;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Bairro> getBairros() {
		try{
			if(getCodCidade() != 0 ){
				this.bairros = this.ruleBairro.getBairrosByCodCidade(getCodCidade());
			}
			return bairros;
		}catch(Exception e){
			e.printStackTrace();
			return bairros;
		}
	}
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodCidade() {
		return codCidade;
	}
	public void setCodCidade(long codCidade) {
		System.out.println("Setando codigo cidade: " + codCidade);
		this.codCidade = codCidade;
	}
	public String getCodIbge() {
		return codIbge;
	}
	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	//NOTE: Metodos que serao envocados na pagina
	public String inserir() {
		try{
			String msg		= "";
			Bairro bairro	= new Bairro(getSession().getUsuarioLogado());
			Cidade cidade	= null;
			bairro.setCodigo(getCodigo());
			bairro.setDescricao(getDescricao());
			bairro.setCodIbge(getCodIbge());
			
			cidade = (Cidade) ruleCidade.find(getCodCidade());
			if(cidade != null){
				bairro.setCidade(cidade);
				this.ruleBairro.insert(bairro);
				exibirMensagem(msg);
			}else{
				exibirErroGrave("Não foi possível encontrar a cidade para o relacionamento.");
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public String inserirOnPopup() {
		inserir();
		RequestContext.getCurrentInstance().closeDialog(null);
		return null;
	}
	
	public String cancelar() {
		RequestContext.getCurrentInstance().closeDialog(null);
		return null;
	}
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
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
	
	private void getParametros() {
//		 @SuppressWarnings("unchecked")
//		List<String> parans = (List<String>) RequestContext.getCurrentInstance().getAttributes().get(Attributs.POP_BAIRRO_PARAMS);
//		for (String string : parans) {
//			System.out.println(string);
//		}
	}
	public List<String> getParams() {
		return params;
	}
	public void setParams(List<String> params) {
		System.out.println("Parametros ...");
		if(params != null){
			for (String string : params) {
				System.out.println("Parametro: " + string);
			}
		}
		this.params = params;
	}
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleBairro getRuleBairro() {
		return ruleBairro;
	}

	public void setRuleBairro(RuleBairro ruleBairro) {
		this.ruleBairro = ruleBairro;
	}

	public RuleCidade getRuleCidade() {
		return ruleCidade;
	}

	public void setRuleCidade(RuleCidade ruleCidade) {
		this.ruleCidade = ruleCidade;
	}
}
