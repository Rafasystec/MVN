package br.com.barcadero.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.core.enums.EnumTipoMeioPgto;
import br.com.barcadero.core.enums.EnumUsaTEF;
import br.com.barcadero.rule.RuleMeioPgto;
import br.com.barcadero.tables.MeiosPagamento;

@ManagedBean(name="meioPgto")
public class BeanMeiosPagamentos extends SuperBean {
	
	private static final long serialVersionUID = -4955803744749124467L;
	private MeiosPagamento meio;
	@ManagedProperty("#{ruleMeioPgto}")
	private RuleMeioPgto ruleMeioPgto;
	private boolean usaTEF;
	private List<MeiosPagamento> meios;
	private List<MeiosPagamento> meiosSelecionados;
	private String localImg = "../Imagens/tefIcon16.png";
	
	public String getLocalImg() {
		return localImg;
	}

	public void setLocalImg(String localImg) {
		this.localImg = localImg;
	}
	
	@PostConstruct
	private void init() {
		try {
			novo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public EnumTipoMeioPgto[] getTipoMeiosPgto() {
		return EnumTipoMeioPgto.values();
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		if(usaTEF){
			meio.setFlUsaTef(EnumUsaTEF.SIM);
		}else{
			meio.setFlUsaTef(EnumUsaTEF.NAO);
		}
		System.out.println("Chamou o metodo salvar");
		System.out.println(ruleMeioPgto.insert(meio));
		return null;
		
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return ruleMeioPgto.update(meio);
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		meio = new MeiosPagamento(getSession().getEmpresaLogada(), null);
		return null;
	}
	
	public MeiosPagamento getMeio() {
		return meio;
	}

	public void setMeio(MeiosPagamento meio) {
		this.meio = meio;
	}

	public boolean isUsaTEF() {
		return usaTEF;
	}

	public void setUsaTEF(boolean usaTEF) {
		this.usaTEF = usaTEF;
	}

	public List<MeiosPagamento> getMeios() {
		this.meios = ruleMeioPgto.getAll();
		return meios;
	}

	public void setMeios(List<MeiosPagamento> meios) {
		this.meios = meios;
	}

	public List<MeiosPagamento> getMeiosSelecionados() {
		return meiosSelecionados;
	}

	public void setMeiosSelecionados(List<MeiosPagamento> meiosSelecionados) {
		this.meiosSelecionados = meiosSelecionados;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleMeioPgto getRuleMeioPgto() {
		return ruleMeioPgto;
	}

	public void setRuleMeioPgto(RuleMeioPgto ruleMeioPgto) {
		this.ruleMeioPgto = ruleMeioPgto;
	}


}
