package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.barcadero.rule.RuleBairro;
import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.rule.RuleEstado;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Estado;

/**
 * Atencao: Usar esse bean somente para a popup de bairro
 * @author Rafael Rocha
 *
 */
@ViewScoped
@ManagedBean(name="popBairro")
public class BeanPopBairro extends SuperBean<Bairro>{
	
	private static final long serialVersionUID = 8270960627163947540L;
	private long codigo;
	private long codCidade;
	private long codEstado;
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
	@ManagedProperty("#{ruleEstado}")
	private RuleEstado ruleEstado;
	private Bairro bairro;
	
	public List<Cidade> getCidades() {
		try{
			if(getCodEstado() != 0){
				Estado estado = ruleEstado.find(getCodEstado());
				if(estado != null){
					this.cidades = ruleCidade.getCidadeByEstado(estado);
				}
			}
			
			return cidades;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@PostConstruct
	public void init() {
		novoBairro();
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
	
//	//NOTE: Metodos que serao envocados na pagina
//	public String inserir() {
//		try{
//			String msg		= "";
//			Bairro bairro	= new Bairro(getSession().getUsuarioLogado());
//			Cidade cidade	= null;
//			bairro.setCodigo(getCodigo());
//			bairro.setDescricao(getDescricao());
//			bairro.setCodIbge(getCodIbge());
//			
//			cidade = (Cidade) ruleCidade.find(getCodCidade());
//			if(cidade != null){
//				bairro.setCidade(cidade);
//				this.ruleBairro.insert(bairro);
//				exibirMensagem(msg);
//			}else{
//				exibirErroGrave("Não foi possível encontrar a cidade para o relacionamento.");
//			}
//			return null;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public String inserirOnPopup() {
		try {
			salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().closeDialog(null);
		return null;
	}
	
	public String cancelar() {
		RequestContext.getCurrentInstance().closeDialog(null);
		return null;
	}
	@Override
	public String salvar() throws Exception {
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
			novoBairro();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
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
		novoBairro();
		return null;
	}
	private void novoBairro() {
		this.bairro = new Bairro(getUsuarioLogado());
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

	@Override
	public boolean validar(Bairro entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
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

	public RuleEstado getRuleEstado() {
		return ruleEstado;
	}

	public void setRuleEstado(RuleEstado ruleEstado) {
		this.ruleEstado = ruleEstado;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
}
