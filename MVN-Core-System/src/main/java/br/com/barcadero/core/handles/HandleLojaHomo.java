package br.com.barcadero.core.handles;

import java.util.Date;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;

public class HandleLojaHomo {
	private Session session;
	
	public HandleLojaHomo(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}
	
	public void merge(Loja loja) {
		session.merge(loja);
	}
	
	public static Loja getLojaHomo() {
		Loja loja = new Loja(null);
		PessoaJuridica pj	= new PessoaJuridica(null);
		Date dtCad 	 		= new Date();
		pj.setCnpj("12345678908765");
		pj.setCodRegTribut(EnumRegimeTributario.INDEFINIDO);
		pj.setCodigo(1);
		pj.setEmail("pj.padrao.matriz.barcadero");
		pj.setFantasia("LOJA HOMOLOGACAO");
		pj.setFone("3909487757");
		pj.setIe("IE");
		pj.setIeSubsTributaria("IE");
		pj.setIm("IM");
		pj.setRazaoSocial("RAZAO SOCIAL HOMO");
		pj.setUf("CE");
		pj.setWebSite("WWW.HOMO.MATRIZ.COM.BR");
		pj.setDtUltAlteracao(dtCad);
		loja.setCodigo(1);
		loja.setEmpresa(HandleEmpresaHomo.getEmpresaHomo());
		loja.setDtInauguracao(dtCad);
		loja.setPessoaJuridica(pj);
		return loja;
	}

}
