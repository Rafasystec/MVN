package br.com.systeconline.controller;
/**
 * @author Rafael Rocha
 * Criada dia 09/11/2013 as 18:23
 */

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.systeconline.rule.FacadePlanoConta;
import br.com.systeconline.tables.financeiro.ModelPlanoConta;
import br.com.systeconline.tables.financeiro.PlanoConta;
@ManagedBean
@RequestScoped
public class BeanPlanoContas extends BeanSuperClass {
	private ModelPlanoConta modelConta		= null;
	private FacadePlanoConta fcPlanoConta	= null;
	private long codigo;
	private long codEmp;
	private int nivel0;
	private int nivel1;
	private int nivel2;
	private int mesmov;
	private String descricao;
	private String tpConta;
	private String localP;
	private String resultP;
	private String resumeP;
	private String destaqueP;
	private double saldoAtual;
	private double saldoAnterior;
	private double taxaP;
	private String codConta; //Variavel para acumular o codigo digitado pelo cliente
	private List<PlanoConta> contas;
	
	
	public String getCodConta() {
		return codConta;
	}
	public void setCodConta(String codConta) {
		this.codConta = codConta;
	}
	public List<PlanoConta> getContas() {
		try {
			return fcPlanoConta.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public void setContas(List<PlanoConta> contas) {
		this.contas = contas;
	}
	public ModelPlanoConta getModelConta() {
		return modelConta;
	}
	public void setModelConta(ModelPlanoConta modelConta) {
		this.modelConta = modelConta;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public int getNivel0() {
		return nivel0;
	}
	public void setNivel0(int nivel0) {
		this.nivel0 = nivel0;
	}
	public int getNivel1() {
		return nivel1;
	}
	public void setNivel1(int nivel1) {
		this.nivel1 = nivel1;
	}
	public int getNivel2() {
		return nivel2;
	}
	public void setNivel2(int nivel2) {
		this.nivel2 = nivel2;
	}
	public int getMesmov() {
		return mesmov;
	}
	public void setMesmov(int mesmov) {
		this.mesmov = mesmov;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTpConta() {
		return tpConta;
	}
	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}
	public String getLocalP() {
		return localP;
	}
	public void setLocalP(String localP) {
		this.localP = localP;
	}
	public String getResultP() {
		return resultP;
	}
	public void setResultP(String resultP) {
		this.resultP = resultP;
	}
	public String getResumeP() {
		return resumeP;
	}
	public void setResumeP(String resumeP) {
		this.resumeP = resumeP;
	}
	public String getDestaqueP() {
		return destaqueP;
	}
	public void setDestaqueP(String destaqueP) {
		this.destaqueP = destaqueP;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	public double getSaldoAnterior() {
		return saldoAnterior;
	}
	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}
	public double getTaxaP() {
		return taxaP;
	}
	public void setTaxaP(double taxaP) {
		this.taxaP = taxaP;
	}
	public BeanPlanoContas() throws Exception{
		super();
		//modelConta = new ModelPlanoConta(getManager());
		fcPlanoConta = new FacadePlanoConta(getManager());
	}
	//Metodos das regras de negocio
	public String salvar() throws Exception {
		String retorno 		= "";
		String target		= null;
		PlanoConta conta	= null;
		try {
			
			exibirMensagem(retorno);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			chamaPagErro(e);
		}
		return target;
	}
	/**
	 * metodo para separar os niveis que virao do campo codigo.
	 */
	public String getNiveis() throws Exception{
		String niveis[] = null;
		String msg		= "";
		int intNivel0	= 0;
		int intNivel1	= 0;
		int intNivel2	= 0;
		try {
			if(getCodConta().equals("") == false){
				niveis = getCodConta().replace(".", "@").split("@");
				if(niveis != null && niveis.length == 3){
					String nivel0 = "";
					String nivel1 = "";
					String nivel2 = "";
					for(int i = 0; i < niveis.length; i++){
						if(i == 0){
							nivel0 = niveis[i].toString();
						}else if(i == 1){
							nivel1 = niveis[i].toString();
						}else if(i == 2){
							nivel2 = niveis[i].toString();
						}
					}
					intNivel0 = Integer.parseInt(nivel0);
					intNivel1 = Integer.parseInt(nivel1);
					intNivel2 = Integer.parseInt(nivel2);
					setNivel0(intNivel0);
					setNivel1(intNivel1);
					setNivel2(intNivel2);
					//Iremos agora identificar se a conta eh analitica ou sintética
					if(intNivel0 == 0 && intNivel1 == 0 && intNivel2 == 0){
						return "O código na conta não pode ficar 0 (zero)";
					}
					if(intNivel1 == 0 || intNivel2 == 0){
						//Conta sistetica
						setTpConta("S");
					}else{
						//Conta analítica
						setTpConta("A");
					}
				}
			}else{
				msg += "Os níveis não foram preenchidos corretamente.";
			}
			return msg;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
	}
}
