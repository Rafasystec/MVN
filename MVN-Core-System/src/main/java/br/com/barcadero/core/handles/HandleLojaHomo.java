package br.com.barcadero.core.handles;

import java.util.Date;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.tables.Loja;

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
		Date dtCad 	 		= new Date();
		loja.setCnpj("12345678908765");
		loja.setCodRegTribut(EnumRegimeTributario.INDEFINIDO);
		loja.setCodigo(1);
		loja.setEmail("pj.padrao.matriz.barcadero");
		loja.setFantasia("LOJA HOMOLOGACAO");
		loja.setFone("3909487757");
		loja.setIe("IE");
		loja.setIeSubsTributaria("IE");
		loja.setIm("IM");
		loja.setRazaoSocial("RAZAO SOCIAL HOMO");
		loja.setUf("CE");
		loja.setWebSite("WWW.HOMO.MATRIZ.COM.BR");
		loja.setDtUltAlteracao(dtCad);
		loja.setCodigo(1);
		loja.setEmpresa(HandleEmpresaHomo.getEmpresaHomo());
		loja.setDtInauguracao(dtCad);
		return loja;
	}

}
