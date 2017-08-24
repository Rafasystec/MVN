package br.com.barcadero.core.handles;

import java.util.Date;

import br.com.barcadero.core.enums.EnumAtividadeEmp;
import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.tables.Empresa;

public class HandleEmpresaHomo {

	public static Empresa getEmpresaHomo() {
		Empresa emp	 		= new Empresa(null);
		Date dtCad 	 		= new Date();
		emp.setCnpj("12345678908765");
		emp.setCodRegTribut(EnumRegimeTributario.INDEFINIDO);
		emp.setCodigo(1L);
		emp.setEmail("pj.padrao.barcadero");
		emp.setFantasia("EMPRESA HOMOLOGACAO");
		emp.setFone("3909487757");
		emp.setIe("IE");
		emp.setIeSubsTributaria("IE");
		emp.setIm("IM");
		emp.setRazaoSocial("RAZAO SOCIAL HOMO");
		emp.setUf("CE");
		emp.setWebSite("WWW.HOMO.COM.BR");
		emp.setDtUltAlteracao(dtCad);
		
		emp.setCodigo(1L);
		emp.setDtCadastro(dtCad);
		emp.setAtividade(EnumAtividadeEmp.TECNOLOGIA);
		emp.setDtFundacao(dtCad);
		emp.setHrCadastro(dtCad);
		emp.setImgLogo("");
		emp.setObservacoes("EMPRESA APENAS PARA HOMOLOGACAO");
		
		return emp;
	}
}
