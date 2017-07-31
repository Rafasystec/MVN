package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoSystemProperties;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.SystemProperties;
@Service
public class RuleSystemProperties extends RuleModelo<SystemProperties> {

	@Autowired
	private DaoSystemProperties daoSystemProperties;
	
//	@Autowired
//	public RuleSystemProperties(DaoSystemProperties daoSystemProperties) {
//		// TODO Auto-generated constructor stub
//		this.daoSystemProperties = daoSystemProperties;
//	}

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		SystemProperties properties 	= (SystemProperties) entidade;
//		SystemProperties propertiesAtu	= find();
//		
//		if(propertiesAtu != null){
//			//Ja existe um registro
//			SystemHistory history = new SystemHistory();
//			history.setCnpjSoftwareHouse(propertiesAtu.getCnpjSoftwareHouse());
//			history.setNomeComercial(propertiesAtu.getNomeComercial());
//			history.setSystem(propertiesAtu);
//			history.setVersao(propertiesAtu.getVersaoSistema());
//			daoSystemProperties.insert(history);
//			List<SystemHistory> histos = Arrays.asList(history);
//			propertiesAtu.setCnpjSoftwareHouse(properties.getCnpjSoftwareHouse());
//			propertiesAtu.setHistories(histos);
//			propertiesAtu.setNomeComercial(properties.getNomeComercial());
//			propertiesAtu.setVersaoSistema(properties.getVersaoSistema());
//			daoSystemProperties.update(propertiesAtu);
//		}else{
//			daoSystemProperties.insert(properties);
//		}
//		return "Inclusão efetuada";
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemProperties find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemProperties> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SystemProperties find() throws Exception {
		return daoSystemProperties.find();
	}

	@Override
	public List<SystemProperties> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemProperties> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemProperties insert(SystemProperties entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemProperties update(SystemProperties entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
