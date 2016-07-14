package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;

import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.rule.RuleNotaItens;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;

@ManagedBean
@ViewScoped
public class BeanVendaRapida extends SuperBean {


	private static final long serialVersionUID = 1L;
	private List<NotaItens> itens;
	private NotaItens item;
	private List<NotaItens> itensSelecionados;
	private NotaItens notaItem;
	private Nota nota;
	private String codigoProduto;
	//Rules e facades utilizados
	private RuleNota ruleNota;
	private RuleNotaItens ruleItens;
	//--------------------------
	private BigDecimal vlTotal 		= new BigDecimal(0.00);
	private BigDecimal vlSubTotal 	= new BigDecimal(0.00);
	private BigDecimal vlDesconto 	= new BigDecimal(0.00);
	private BigDecimal vlTroco 		= new BigDecimal(0.00);
	//--------------------------
	private long codNota;
	private Session session;
	
	public BeanVendaRapida() {
		System.out.println("BeanVendaRapida was created!");
		this.session = getDBSessionForViewScope();
		ruleNota = new RuleNota(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		ruleItens= new RuleNotaItens(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		itens	 = new ArrayList<NotaItens>();
		item	 = new NotaItens(getSession().getLojaLogada(), getSession().getUsuarioLogado());
		itensSelecionados = new ArrayList<NotaItens>();
		notaItem = new NotaItens(getSession().getLojaLogada(), getSession().getUsuarioLogado());
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct method init");
		try {
			if(this.session != null){
				this.session.beginTransaction();
			}
			nota = createNota();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void flush() {
		System.out.println("@PreDestroy called");
		if(this.session != null){
			this.session.getTransaction().commit();
		}
	}
	
	
	public List<NotaItens> getItens() {
		if(nota != null){
			return ruleNota.getItensByCodeNota(nota.getCodigo());
		}else{
			return new ArrayList<NotaItens>();
		}
		
	}

	public void setItens(List<NotaItens> itens) {
		this.itens = itens;
	}

	public List<NotaItens> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(List<NotaItens> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}

	public NotaItens getNotaItem() {
		return notaItem;
	}

	public void setNotaItem(NotaItens notaItem) {
		this.notaItem = notaItem;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public RuleNota getRuleNota() {
		return ruleNota;
	}

	public void setRuleNota(RuleNota ruleNota) {
		this.ruleNota = ruleNota;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}


	public BigDecimal getVlSubTotal() {
		return vlSubTotal;
	}


	public void setVlSubTotal(BigDecimal vlSubTotal) {
		this.vlSubTotal = vlSubTotal;
	}

	public BigDecimal getVlDesconto() {
		return vlDesconto;
	}

	public void setVlDesconto(BigDecimal vlDesconto) {
		this.vlDesconto = vlDesconto;
	}


	public BigDecimal getVlTroco() {
		return vlTroco;
	}


	public void setVlTroco(BigDecimal vlTroco) {
		this.vlTroco = vlTroco;
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
	
	public void salvarItem() throws Exception {
		System.out.println("Save item called.");
		if(nota == null){
			nota	= createNota();
		}
		item = ruleItens.saveItemNotaFromProduto(nota, item);
		totalizarSubTotal(item);
	}
	
	private void totalizarSubTotal(NotaItens item) {
		setVlSubTotal(getVlSubTotal().add(item.getVlTotal()));
	}


	public NotaItens getItem() {
		return item;
	}


	public void setItem(NotaItens item) {
		this.item = item;
	}
	
	private Nota createNota() throws UnknownHostException, Exception {
		this.nota = ruleNota.createNota(getSession().getLojaLogada(), getSession().getUsuarioLogado(), getSession().getIpAddress());
		return nota;
	}


	public long getCodNota() {
		return codNota;
	}

	public void setCodNota(long codNota) {
		this.codNota = codNota;
	}
	
	public String fecharVenda() {
		if(this.session != null){
			try {
				this.session.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				this.session.getTransaction().rollback();
			}
		}
		return "";
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
}
