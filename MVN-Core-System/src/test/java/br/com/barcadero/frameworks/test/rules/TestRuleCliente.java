package br.com.barcadero.frameworks.test.rules;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.fail;
import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.core.enums.EnumSexo;
import br.com.barcadero.core.enums.EnumTipoPessoa;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.PessoaFisica;

public class TestRuleCliente extends TesteSuperClass {
	
	private RuleCliente ruleCliente;
	public TestRuleCliente() {
		// TODO Auto-generated constructor stub
		ruleCliente = new RuleCliente(null, null, getSession());
	}
	
	@Test
	public void inserirCliente() {
		Cliente cliente = new Cliente();
		cliente.setNomeMae("MARIA");
		cliente.setNomePai("JOÃO");
		PessoaFisica fisica = new PessoaFisica();
		fisica.setCategoria("CLIEN");
		fisica.setCelular("(85)548574895");
		fisica.setCpf("02514595565");
		fisica.setDtNascimento(new Date(1980, 05, 11));
		fisica.setEmail("joaalmeida@gmail.com");
		fisica.setEmissorRg("SSP-CE");
		fisica.setEstCivil(EnumEstadoCivil.SOLTEIRO);
		fisica.setFlStatus(EnumAtivo.S);
		fisica.setHabilitacao("AB");
		fisica.setMatricula(2122);
		fisica.setNome("JOÃO FELIPE QUINTAS");
		fisica.setObservacao("CLIENTE GERADO EM TESTES AUTOMÁTICOS");
		fisica.setOcupacao("VENDEDOR CALÇADOS");
		fisica.setProfissao("VENDEDOR");
		fisica.setRg("2005002152");
		fisica.setSexo(EnumSexo.M);
		fisica.setUfNatural(EnumUF.CE);
		fisica.setZona(128);
		cliente.setPessoaFisica(fisica);
		cliente.setTipoPessoa(EnumTipoPessoa.FISICA);
		try {
			ruleCliente.insert(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
