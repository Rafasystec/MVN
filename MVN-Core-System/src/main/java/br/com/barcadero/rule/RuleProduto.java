package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.barcadero.core.xml.entities.XMLProduto;
import br.com.barcadero.dao.DaoProduto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Produto;

@Component
public class RuleProduto extends RuleModelo<Produto> {

	private DaoProduto daoProduto;
	
	public RuleProduto() {
		System.out.println(">>>>>>>>>>Criando Rule Produto<<<<<<<<<<<<<<<<<<<");
	}
	
	@Autowired
	public RuleProduto(DaoProduto daoProduto){
		this.daoProduto = daoProduto;
		System.out.println(">>>>>>>>>>Criando Rule Produto com a dao produto <<<<<<<<<<<<<<<<<<<");
	}

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		return daoProduto.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoProduto.delete(codigo);
	}

//	@Override
//	public String update(Entidade entidade) throws Exception {
//		return daoProduto.update(entidade);
//	}

	@Override
	public Produto find(long codigo) throws Exception {
		return daoProduto.find(codigo);
	}
	
	public List<Produto> findByDataCadastro(Date date) throws Exception {
		return daoProduto.findByDataCadastro(date);
	}
	
	public List<Produto> findAll() throws Exception {
		return daoProduto.findAll();
	}
	
	/**
	 * Procura pelo codigo ou pela descricao
	 * @param codigoOrDesc
	 * @return
	 * @throws Exception
	 */
	public List<Produto> findByCodOrDesc(String codigoOrDesc) throws Exception{
		return daoProduto.findByCodOrDesc(codigoOrDesc);
	}
	
	/**
	 * 
	 * @param codigoOrDesc
	 * @return
	 * @throws Exception
	 */
	public List<String> getAutoComplete(String codigoOrDesc) throws Exception{
		List<Produto> produtos 	= daoProduto.findByCodOrDesc(codigoOrDesc);
		List<String> list 		= new ArrayList<String>();
		for (Produto produto : produtos) {
			String description = produto.getCodigo() + " -|- " + produto.getDescricao();
			list.add(description);
		}
		return list;
	}
	/**
	 * Extrair o codigo do produto quando gerado pelo metodo getAutoComplete(String codigoOrDesc)
	 * @param selected
	 * @return
	 */
	public long extrairCodigo(String selected) {
		if(selected != null && !selected.isEmpty()){
			String[] parts = selected.split(" -|- ");
			if(parts != null && parts.length > 1){
				try {
					return Long.parseLong(parts[0]);
				} catch (Exception e) {
					// TODO: handle exception
					return 0;
				}
			}
		}
		return 0;
	}
	
	public BigDecimal getPreco(Produto produto) {
		if(produto != null){
			return produto.getPrecoVenda();
		}
		return new BigDecimal(0.00);
	}
	/**
	 * 
	 * @param produto
	 * @return
	 */
	public XMLProduto parseToXMLProduto(Produto produto) {
		XMLProduto xmlProduto = null;
		if(produto != null){
			xmlProduto = new XMLProduto();
			xmlProduto.setAliqISSQN( produto.getAliqISSQN());
			xmlProduto.setAliquota( produto.getAliquota());
			xmlProduto.setCdFornecedor(produto.getCdFornecedor());
			xmlProduto.setCdNcm(produto.getCdNcm());
			xmlProduto.setCdProd(produto.getCdProd());
			xmlProduto.setCest(produto.getCest());
			xmlProduto.setCfop(produto.getCfop());
			xmlProduto.setCodigo(produto.getCodigo());
			xmlProduto.setCstCOFINS(produto.getCstCOFINS());
			xmlProduto.setCstIcms(produto.getCstIcms());
			xmlProduto.setCstIpi(produto.getCstIpi());
			xmlProduto.setCstPis( produto.getCstPis());
			xmlProduto.setDescricao(produto.getDescricao());
			xmlProduto.setDtInicioPromo( produto.getDtInicioPromo());
			xmlProduto.setDtTerminPromo(produto.getDtTerminPromo());
			xmlProduto.setEan(produto.getEan());
			xmlProduto.setFator(produto.getFator());
			xmlProduto.setMsgPromocional(produto.getMsgPromocional());
			xmlProduto.setNaturezaOperacaoIssqn(produto.getNaturezaOperacaoIssqn());
			xmlProduto.setNmAduaneiro(produto.getNmAduaneiro());
			xmlProduto.setOrigemIcms(produto.getOrigemIcms());
			xmlProduto.setPrecoCusto(produto.getPrecoCusto());
			xmlProduto.setPrecoVenda(produto.getPrecoVenda());
			xmlProduto.setPrecoPromo(produto.getPrecoPromo());
			xmlProduto.setSitTributaria(produto.getSitTributaria());
			xmlProduto.setTipoCofins(produto.getTipoCofins());
			xmlProduto.setTipoICMS(produto.getTipoICMS());
			xmlProduto.setTipoPis(produto.getTipoPis());
			xmlProduto.setTipoProduto(produto.getTipoProduto());
			xmlProduto.setUnidade(produto.getUnidade());
		}
		return xmlProduto;
	}

	@Override
	public List<Produto> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto insert(Produto entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto update(Produto entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
