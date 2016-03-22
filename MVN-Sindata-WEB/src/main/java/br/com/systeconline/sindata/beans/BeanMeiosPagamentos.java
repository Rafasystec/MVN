package br.com.systeconline.sindata.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.rule.frontend.RuleMeioPgto;
import br.com.systeconline.core.enums.EnumTipoMeioPgto;
import br.com.systeconline.core.enums.EnumUsaTEF;
import br.com.systeconline.tables.frontend.MeiosPagamento;

@ManagedBean(name="meioPgto")
public class BeanMeiosPagamentos extends SuperBean {
	
	private static final long serialVersionUID = -4955803744749124467L;
	private MeiosPagamento meio;
	private RuleMeioPgto rulMeio;
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

	public BeanMeiosPagamentos() throws Exception {
		// TODO Auto-generated constructor stub
		rulMeio = new RuleMeioPgto(getDataBaseSession());
		novo();
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
		System.out.println(rulMeio.insert(meio));
		return null;
		
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return rulMeio.update(meio);
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
		this.meios = rulMeio.getAll();
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


}
