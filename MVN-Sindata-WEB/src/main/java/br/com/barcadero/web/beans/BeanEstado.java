package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.barcadero.rule.FacadeEstado;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;

@ManagedBean
@RequestScoped
public class BeanEstado extends SuperBean{

	private static final long serialVersionUID = 1469646686201259743L;
	List<Entidade> estados ;
	private long codigo;
	private String descricao;
	private String uf;
	private String codIbge;
	private Date dtCadastro;
	private FacadeEstado facadeEstado;

	public BeanEstado() {
		
		//this.facadeEstado = new FacadeEstado(session);
	}	
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public List<Entidade> getEstados() {
		try {
			this.estados = this.facadeEstado.findAll();
			return this.estados;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public void findAll() {
		try {
			this.estados = this.facadeEstado.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void setEstados(List<Entidade> estados) {
		this.estados = estados;
	}
	
	//NOTE: Metodos que serao envocados na pagina
	public String inserir() {
		try{
			String msg	= "";
			Estado estado = new Estado(getSession().getUsuarioLogado());
			estado.setCodigo(getCodigo());
			estado.setDescricao(getDescricao());
			//estado.setUf(getUf());
			estado.setCodIbge(getCodIbge());
			//estado.setDtCadastro(getDtCadastro());
			msg = this.facadeEstado.insert(estado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Infor:", msg));  
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "Erro a tentar inserir o estado. Verifique o log para maiores detalhes.";
		}
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
}