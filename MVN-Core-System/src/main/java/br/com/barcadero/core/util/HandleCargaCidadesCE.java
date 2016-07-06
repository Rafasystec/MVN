package br.com.barcadero.core.util;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.junit.validator.PublicClassValidator;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.dao.DaoBairro;
import br.com.barcadero.dao.DaoCidade;
import br.com.barcadero.dao.DaoEstado;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

public class HandleCargaCidadesCE {

	private DaoEstado daoEstado;
	private DaoCidade daoCidade;
	private DaoBairro daoBairro;
	private Estado ceara   	= null; 
	private Usuario usuario	= null;
	
	public HandleCargaCidadesCE(Empresa empresa, Loja loja, Session session, Usuario usuario) {
		daoEstado 	 = new DaoEstado(empresa, loja, session);
		daoCidade	 = new DaoCidade(empresa, loja, session);
		daoBairro	 = new DaoBairro(empresa, loja, session);
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
		Cidade fortaleza = daoCidade.findByDescricaoEUF("FORTALEZA", EnumUF.CE);
		if(fortaleza == null){
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
		System.out.println("Iniciando carga dos bairro de Fortaleza");
		loadBairrosFortaleza();
	}
	
	/**
	 * Carregar os bairros da cidade de fortaleza.
	 */
	public void loadBairrosFortaleza() {
		Cidade fortaleza = null;
		try {
			fortaleza = daoCidade.findByDescricaoEUF("FORTALEZA", EnumUF.CE);
			daoBairro.deleteTodosBairrosPorCidade(fortaleza);
			for (String bairroStr: getBairrosFortaleza()) {
				Bairro bairro = new Bairro(usuario);
				bairro.setCidade(fortaleza);
				bairro.setCodIbge("000");
				bairro.setDescricao(bairroStr);
				System.out.println("Inserindo o bairro " + bairroStr + " : " + daoBairro.insert(bairro));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Nao foi possivel carregar os bairros para FORTALEZA/CE: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<String> getBairrosFortaleza() {
		List<String> list = new ArrayList<String>();
		list.add("CENTRO");			
		list.add("ÁLVARO WEYNE");			
		list.add("BARRA");	
		list.add("CARLITO PAMPLONA");
		list.add("CRISTO REDENTOR");	
		list.add("FARIAS BRITO");	
		list.add("FLORESTA");			
		list.add("JACARECANGA");			
		list.add("JARDIM GUANABARA");	
		list.add("JARDIM IRACEMA");			
		list.add("MONTE CASTELO");			
		list.add("MOURA BRASIL");			
		list.add("PIRAMBÚ");			
		list.add("SÃO GERARDO");	
		list.add("VILA ELLERY");	
		list.add("VILA VELHA");			
		list.add("ALDEOTA");			
		list.add("CAIS DO PORTO");		
		list.add("CIDADE 2000");	
		list.add("COCÓ");			
		list.add("DE LOURDES");			
		list.add("DIONÍSIO TORRES");	
		list.add("ENGENHEIRO LUCIANO CAVALCANTE");
		list.add("GUARARAPES");			
		list.add("JOAQUIM TÁVORA");			
		list.add("MANUEL DIAS BRANCO");			
		list.add("MEIRELES");			
		list.add("MUCURIPE");			
		list.add("PAPICU");			
		list.add("PRAIA DE IRACEMA");		
		list.add("PRAIA DO FUTURO I");			
		list.add("PRAIA DO FUTURO II");			
		list.add("SALINAS");			
		list.add("SÃO JOÃO DO TAUAPE");		
		list.add("VARJOTA");		
		list.add("VICENTE PINZON");		
		list.add("AMADEU FURTADO");		
		list.add("ANTÔNIO BEZERRA");		
		list.add("AUTRAN NUNES");		
		list.add("BELA VISTA");			
		list.add("BONSUCESSO");			
		list.add("DOM LUSTOSA");	
		list.add("HENRIQUE JORGE");	
		list.add("JOÃO XXIII");	
		list.add("JÓQUEI CLUBE");			
		list.add("OLAVO OLIVEIRA");				
		list.add("PADRE ANDRADE");	
		list.add("PARQUE ARAXÁ");			
		list.add("PARQUELÂNDIA");	
		list.add("PICI");			
		list.add("PRESIDENTE KENNEDY");		
		list.add("QUINTINO CUNHA");		
		list.add("RODOLFO TEÓFILO");
		list.add("AEROPORTO");			
		list.add("BENFICA");	
		list.add("BOM FUTURO");	
		list.add("COUTO FERNANDES");	
		list.add("DAMAS");		
		list.add("DEMÓCRITO ROCHA");	
		list.add("DENDÊ");			
		list.add("FÁTIMA");	
		list.add("ITAOCA");		
		list.add("ITAPERI");	
		list.add("JARDIM AMÉRICA");		
		list.add("JOSÉ BONIFÁCIO");	
		list.add("MONTESE");
		list.add("PANAMERICANO");			
		list.add("PARANGABA");		
		list.add("PARREÃO");	
		list.add("SERRINHA");			
		list.add("VILA PERI");		
		list.add("VILA UNIÃO");		
		list.add("BOM JARDIM");		
		list.add("CANINDEZINHO");			
		list.add("CONJUNTO CEARÁ I");			
		list.add("CONJUNTO CEARÁ II");		
		list.add("CONJUNTO ESPERANÇA");	
		list.add("GENIBAÚ");	
		list.add("GRANJA LISBOA");		
		list.add("GRANJA PORTUGAL");			
		list.add("JARDIM CEARENSE");		
		list.add("MANOEL SÁTIRO	");	
		list.add("MARAPONGA");		
		list.add("MONDUBIM");	
		list.add("PLANALTO AYRTON SENNA");
		list.add("PREFEITO JOSÉ WALTER");			
		list.add("PRESIDENTE VARGAS");			
		list.add("SÃO JOSÉ");			
		list.add("SANTA ROSA");		
		list.add("SIQUEIRA");			
		list.add("AEROLÂNDIA");		
		list.add("ALTO DA BALANÇA");	
		list.add("ANCURI");		
		list.add("BARROSO");		
		list.add("BOA VISTA");		
		list.add("CAJAZEIRAS");		
		list.add("CAMBEBA");			
		list.add("CIDADE DOS FUNCIONÁRIOS");			
		list.add("COAÇU");	
		list.add("CURIÓ");	
		list.add("CONJUNTO PALMEIRAS");	
		list.add("DIAS MACEDO");
		list.add("EDSON QUEIROZ");
		list.add("GUAJERU");	
		list.add("JANGURUSSU");	
		list.add("JOSÉ DE ALENCAR");			
		list.add("JARDIM DAS OLIVEIRAS");		
		list.add("LAGOA REDONDA");		
		list.add("MESSEJANA");	
		list.add("PARQUE DOIS IRMÃOS");	
		list.add("PARQUE IRACEMA");			
		list.add("PARQUE MANIBURA");		
		list.add("PASSARÉ");		
		list.add("PAUPINA");		
		list.add("PEDRAS");		
		list.add("SABIAGUABA");		
		list.add("SÃO BENTO");		
		list.add("SANTA MARIA");				
		list.add("SAPIRANGA / COITÉ");
		return list;
	}
}
