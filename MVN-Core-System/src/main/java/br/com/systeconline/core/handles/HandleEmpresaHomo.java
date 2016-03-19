package br.com.systeconline.core.handles;

import java.util.Date;

import br.com.systeconline.core.enums.EnumAtividadeEmp;
import br.com.systeconline.core.enums.EnumRegimeTributario;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.PessoaJuridica;

public class HandleEmpresaHomo {

	public static Empresa getEmpresaHomo() {
		Empresa emp	 		= new Empresa(null);
		PessoaJuridica pj	= new PessoaJuridica(null);
		Date dtCad 	 		= new Date();
		pj.setCnpj("12345678908765");
		pj.setCodRegTribut(EnumRegimeTributario.INDEFINIDO);
		pj.setCodigo(1L);
		pj.setEmail("pj.padrao.barcadero");
		pj.setFantasia("EMPRESA HOMOLOGACAO");
		pj.setFone("3909487757");
		pj.setIe("IE");
		pj.setIeSubsTributaria("IE");
		pj.setIm("IM");
		pj.setRazaoSocial("RAZAO SOCIAL HOMO");
		pj.setUf("CE");
		pj.setWebSite("WWW.HOMO.COM.BR");
		pj.setDtUltAlteracao(dtCad);
		
		emp.setCodigo(1L);
		emp.setDtCadastro(dtCad);
		emp.setAtividade(EnumAtividadeEmp.TECNOLOGIA);
		emp.setDtFundacao(dtCad);
		emp.setHrCadastro(dtCad);
		emp.setImgLogo("");
		emp.setObservacoes("EMPRESA APENAS PARA HOMOLOGACAO");
		emp.setPessoaJuridica(pj);

		return emp;
	}
}
