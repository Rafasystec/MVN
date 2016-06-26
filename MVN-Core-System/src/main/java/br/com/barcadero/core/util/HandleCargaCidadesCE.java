package br.com.barcadero.core.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCidade;
import br.com.barcadero.dao.DaoEstado;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Usuario;

public class HandleCargaCidadesCE {

	private DaoEstado daoEstado;
	private DaoCidade daoCidade;
	private Estado ceara   = null; 
	private Usuario usuario= null;
	public HandleCargaCidadesCE(Session session, Usuario usuario) {
		// TODO Auto-generated constructor stub
		daoEstado 	 = new DaoEstado(session);
		daoCidade	 = new DaoCidade(session);
		this.usuario = usuario;
	}
	
	public void loadCeara() throws Exception {
		ceara = daoEstado.findByCodeIBGE("23");
		if(ceara != null){
			loadCidadesCeara();
		}else {
			System.out.println("Nao sera possivel realizar a carga para o CEARA - codigo IBGE 23 nao encontrado");
		}
	}
	
	private void loadCidadesCeara() throws Exception {
		List<Cidade> cidades = new ArrayList<Cidade>();
		Cidade cidade 		 = new Cidade(usuario);
		daoCidade.deleteCidadesByEstado(ceara.getCodIbge());
		
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2300101");
		cidade.setDescricao("ABAIARA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2300150");
		cidade.setDescricao("ACARAPE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		
		cidades.add(cidade);

		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2300200");
		cidade.setDescricao("ACARAU");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2300000");
		cidade.setDescricao("AQUIRAZ");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2300150");
		cidade.setDescricao("ARACATI");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2302107");
		cidade.setDescricao("BATURITE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2302206");
		cidade.setDescricao("BEBERIBE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2302602");
		cidade.setDescricao("CAMOCIM");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2302800");
		cidade.setDescricao("CANINDE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2303501");
		cidade.setDescricao("CASCAVEL");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2303790");
		cidade.setDescricao("CAUCAIA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2304202");
		cidade.setDescricao("CRATO");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2304285");
		cidade.setDescricao("EUSEBIO");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2304400");
		cidade.setDescricao("FORTALEZA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2305233");
		cidade.setDescricao("HORIZONTE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2306256");
		cidade.setDescricao("ITAITINGA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2306405");
		cidade.setDescricao("ITAPIPOCA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2307650");
		cidade.setDescricao("MARACANAU");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2309607");
		cidade.setDescricao("PACAJUS");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2311306");
		cidade.setDescricao("QUIXADA");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2312403");
		cidade.setDescricao("SAO GONÇALO DO AMARANTE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2312908");
		cidade.setDescricao("SOBRAL");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		cidade = new Cidade(usuario);
		cidade.setBairros(new ArrayList<Bairro>());
		cidade.setCodIbge("2302800");
		cidade.setDescricao("CANINDE");
		cidade.setEstado(ceara);
		cidade.setUsuario(usuario);
		cidades.add(cidade);
		
		
		ceara.setCidades(cidades);	
		System.out.println("Result insert carga:" + daoEstado.insert(ceara));
	}
}
