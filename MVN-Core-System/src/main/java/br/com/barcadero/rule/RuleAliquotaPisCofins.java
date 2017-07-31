package br.com.barcadero.rule;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumRegimePISCOFINS;
import br.com.barcadero.dao.DaoAliquotaPisCofins;
import br.com.barcadero.tables.AliquotasPISCOFINS;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class RuleAliquotaPisCofins extends RuleModelo<AliquotasPISCOFINS> {

	
	private DaoAliquotaPisCofins daoAliquotaPisCofins;
	public RuleAliquotaPisCofins(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoAliquotaPisCofins = new DaoAliquotaPisCofins(empresa, loja, session);
	}

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		return daoAliquotaPisCofins.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoAliquotaPisCofins.delete(codigo);
	}

//	@Override
//	public String update(Entidade entidade) throws Exception {
//		return daoAliquotaPisCofins.update(entidade);
//	}

	@Override
	public AliquotasPISCOFINS find(long codigo) throws Exception {
		return daoAliquotaPisCofins.find(codigo);
	}

	@Override
	public List<AliquotasPISCOFINS> findAll() throws Exception {
		return daoAliquotaPisCofins.findAll();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void cargaInicial() throws Exception {
		List<String> values = Arrays.asList("RC-0.6500-3.000","RN-0.6500-4.000");
		for (String value : values) {
			String[] aliq = value.split("-");
			AliquotasPISCOFINS piscofins = new AliquotasPISCOFINS();
			piscofins.setPis(Float.parseFloat(aliq[1]));
			piscofins.setCofins(Float.parseFloat(aliq[2]));
			piscofins.setRegime(aliq[0].equalsIgnoreCase("RC") ? EnumRegimePISCOFINS.CUMULATIVO : EnumRegimePISCOFINS.NAO_CUMULATIVO);
			insert(piscofins);
		}
	}

	@Override
	public List<AliquotasPISCOFINS> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AliquotasPISCOFINS> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AliquotasPISCOFINS insert(AliquotasPISCOFINS entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AliquotasPISCOFINS update(AliquotasPISCOFINS entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	

}
