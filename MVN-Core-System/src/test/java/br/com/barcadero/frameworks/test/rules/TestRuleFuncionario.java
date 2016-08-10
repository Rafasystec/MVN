package br.com.barcadero.frameworks.test.rules;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.fail;
import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleFuncionario;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.PessoaFisica;

public class TestRuleFuncionario extends TesteSuperClass {

	private RuleFuncionario ruleFuncionario;
	public TestRuleFuncionario() {
		//ruleFuncionario = new RuleFuncionario(null, null, getSession());
	}
	
	//@Test
	public void inserir() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCartTrabalho("16168165165465");
		funcionario.setCodCentroCusto(1);
		funcionario.setCodInterno(1);
		funcionario.setFgts("2165546156165");
		funcionario.setNomeConjuge("ELLEN DANIELE MADY");
		funcionario.setNomeMae("MARIA DE FÁTIMA DOS SANTOS");
		funcionario.setNomePai("JOÃO BATISTA");
		funcionario.setObservacoes("FUNCIONÁRIO INSERIDO EM TESTES AUTOMÁTICOS");
		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setCategoria("CATEG");
		pessoaFisica.setCelular("(85)96585475");
		pessoaFisica.setCpf("03403903625");
		pessoaFisica.setInstrucao("SEPERIOR COMPLETO");
		pessoaFisica.setEmail("rafasystec@yahoo.com.br");
		pessoaFisica.setEmissorRg("SSP-CE");
		pessoaFisica.setEstCivil(EnumEstadoCivil.CASADO);
		pessoaFisica.setMatricula(12345678);
		pessoaFisica.setNacionalidade("BRASILEIRO");
		pessoaFisica.setNome("ANTONIO RAFAEL R. S");
		pessoaFisica.setObservacao("FUNCIONÁRIO INSERIDO EM TESTES AUTOMÁTICOS");
		pessoaFisica.setDtNascimento(new Date(1988, 03, 05));
		funcionario.setPessoaFisica(pessoaFisica);
		funcionario.setPis("332215165422");
		funcionario.setSalarioInicial(new BigDecimal(3500.85));
		try {
			ruleFuncionario.insert(funcionario);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void cargaNaTabela() {
		for (int i = 0; i < 1000; i++) {
			
			Funcionario funcionario = new Funcionario();
			funcionario.setCartTrabalho("16168165"+i);
			funcionario.setCodCentroCusto(1);
			funcionario.setCodInterno(1);
			funcionario.setFgts("216554"+i);
			funcionario.setNomeConjuge(getNomesMulheres());
			funcionario.setNomeMae("MARIA DE FÁTIMA DOS SANTOS");
			funcionario.setNomePai("JOÃO BATISTA");
			funcionario.setObservacoes("FUNCIONÁRIO INSERIDO EM TESTES AUTOMÁTICOS");
			PessoaFisica pessoaFisica = new PessoaFisica();
			pessoaFisica.setCategoria("CATEG");
			pessoaFisica.setCelular("(85)965"+i);
			pessoaFisica.setCpf("0340"+i);
			pessoaFisica.setInstrucao("SEPERIOR COMPLETO");
			pessoaFisica.setEmail("rafasystec@yahoo.com.br");
			pessoaFisica.setEmissorRg("SSP-CE");
			pessoaFisica.setEstCivil(EnumEstadoCivil.CASADO);
			pessoaFisica.setMatricula(12345678);
			pessoaFisica.setNacionalidade("BRASILEIRO");
			pessoaFisica.setNome(getNomeAleatorioHomens());
			pessoaFisica.setObservacao("FUNCIONÁRIO INSERIDO EM TESTES AUTOMÁTICOS");
			pessoaFisica.setDtNascimento(new Date(1988, 03, 02));
			funcionario.setPessoaFisica(pessoaFisica);
			funcionario.setPis(""+i);
			funcionario.setSalarioInicial(new BigDecimal(3500.85).add(new BigDecimal(i*10)));
			try {
				ruleFuncionario.insert(funcionario);
				
			} catch (Exception e) {
				System.out.println("Indice que estourou " +i);
				fail(e.getMessage());
				
			}
		}
	}
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getNomeAleatorioHomens() {
		int random = new Random().nextInt(76);
		String[] nomes = {
				"ARTHUR FELIPE R. COSTA",
				"DIOGO FERNANDES DE SOUZA",
				"ELIVELTON COSTA DA SILVA				  ",
				"GENILDSON ALVEZ DE OLIVEIRA			"  ,
				"GERDON ADLER RIBEIRO MAFRA				  ",
				"GILBERTO OLIVEIRA				          ",
				"GUILHERME AZEVEDO REIS				      ",
				"IGOR JEFFERSON DO NASCIMENTO			"  ,
				"JHONY KLEYTON DO NASCIMENTO			"  ,
				"JOSÉ LUCAS FERREIRA E SILVA			"  ,
				"MATHEUS ANDRÉ DA SILVA				      ",
				"MATHEUS LUIZ DA S. CÂMARA			      ",
				"PAULO HOLANDA RIBEIRO NETTO			  ",
				"RAFAEL VICTOR				              ",
				"RAMON DOUGLAS NEVES DE ANDRADE			"  ,
				"RUBENS RAUEN                             ",
				"RUY ARRUDA CASSIANO                      ",
				"ALANA MONTEIRO BISPO DA SILVA            ",
				"ALEXSSANDRO OLIVERIA DE ALMEIDA ROCHA    ",
				"AMANDA C. MOREIRA                        ",
				"ANA TEREZA DE ABREU VASQUEZ              ",
				"ANGÉLICA AUGUSTA LINHARES DO MONTE       ",
				"ANNE MARIE ALVES TRINDADE                ",
				"CAROLINA NEVES                           ",
				"CAYO RODRIGUES NUNES MORAES              ",
				"CRISTIANO RODRIGUES ALEXANDRE DA SILVA   ",
				"CYNTHIA PATRÍCIA DE SOUZA SANTOS         ",
				"EDILEUZA MARIA AMORIM TORRES             ",
				"EDILMARA DAS NEVES SILVA                 ",
				"ELZA CAMELO DA SILVA                     ",
				"EWERTOM MASCENA DE ARAÚJO                ",
				"EXPEDITA MARIA                           ",
				"FRANCINALVA ALVES DA SILVA               ",
				"GABRIELY BASILIO DE F. CARDOSO           ",
				"GESUINO CARLOS C. SILVA                  ",
				"GLAUCIA ADRIANA DANTAS PEREIRA           ",
				"GLENDA DE BRITO CUNHA                    ",
				"HELOUISE THAINÁ DA SILVA MACÊDO          ",
				"HOSANA EMANNUELE                         ",
				"ÍTALO NATHAN DA SILVA                    ",
				"IVAMASTK MARIA PEDROSA                   ",
				"JANE GARDÊNIA GOMES DA SILVA             ",
				"JÉSSICA DO VALE SOARES                   ",
				"JHONY KLEYTON DO NASCIMENTO              ",
				"JOACI NASCIMENTO DE PAULA                ",
				"JOANE MARIA DA SILVA CARVALHO            ",
				"JOYCE AMANCIO DE LIMA                    ",
				"JOYCE RAISSA DE SOUSA SANTOS             ",
				"LARISSA LUCENA DE ARAÚJO                 ",
				"LEILIANNE D. GURGEL D’ÁVILA              ",
				"LORENA ALCÂNTARA DE FARIA                ",
				"LORENA FREIRE ALVES DE OLIVEIRA          ",
				"MARIA CONCEIÇÃO DA S. SOUZA              ",
				"MARIA EDILMA DE ABREU                    ",
				"MARIA ISABEL AZEVEDO GOMES               ",
				"MARYANE CHRISTINE TEIXEIRA DA COSTA      ",
				"MATHEUS LUIZ DA SILVA CÂMARA             ",
				"MAYRA PATRÍCIA TEIXEIRA DA COSTA         ",
				"MILKA TEIXEIRA DA COSTA                  ",
				"MÍRIAM SÍRIA R. DE SOUZA                 ",
				"MIRNA SOUZA DA SILVA                     ",
				"MONALISA DA SILVA GODEIRO                ",
				"NOELE GURGEL D’ÁVILA                     ",
				"PATRICIA KALLYANE DO VALE PEIXOTO        ",
				"PEDRO HENRIQUE GOUVEIA DE LIMA           ",
				"RAFAEL FELIPE DE LIMA MIRANDA            ",
				"RAFAELA LAUREANA WANDERLEI               ",
				"RAFAELA SOUZA TEIXEIRA                   ",
				"RAMILE SOUZA TEIXEIRA                    ",
				"RAMON DOUGLAS NUNES DE ANDRADE           ",
				"SALVIANA O. FORTE                        ",
				"SARA DA G. FERREIRA                      ",
				"SAULO MATHEUS DE OLIVEIRA L. CAVALCANTE  ",
				"SILVANA MEDEIROS DE ARAUJO               ",
				"SIMONE KARLA COSTA DA SILVA              ",
				"THAÍS NEPOMUCENO                         ",
				"VERA LUCIA DA SILVA                      ",
				"VICTOR STHÉFANO DE MOURA QUEIROZ         "	};
		return nomes[random];
	}
	/**
	 * 
	 * @param index
	 * @return
	 */
	private String getNomesMulheres() {
		int random = new Random().nextInt(65);
		String[] nomes = {
				"ANA TEREZA DE A. VASQUES                ",
				"BRISA SILVA BRACCHI                     ",
				"DEBORA KAYNARA PATRICIO DA SILVA        ",
				"GLAUCIA ADRIANA DANTAS PEREIRA          ",
				"ISABELE ACCIOLO P. LIMA                 ",
				"IVAUSCK MARIA L. DA COSTA               ",
				"JOANE MARIA DA SILVA CARVALHO           ",
				"KALYNE RIBEIRO DANTAS Q. DE VASCONCELOS ",
				"KÊNIA STEPHANIE NUNES ARRUDA            ",
				"LORENA ALCÂNTARA DE FARIAS              ",
				"LUANA NASCIMENTO DOS SANTOS             ",
				"LUCICLEIDE SILVA FREIRE ALVES DE OLIVEIRA",
				"LUISA RAQUEL TEIXEIRA DE ARAÚJO         ",
				"MARIA CONCEIÇÃO DA S. SOUZA             ",
				"MARIA GISELE DA SILVA DE OLIVEIRA       ",
				"MARLI RODRIGUES FÉLIX                   ",
				"MILENA ROLIM DA SILVA                   ",
				"MÍRIAM SÍRIA R. DE SOUZA                ",
				"MOEMA IRIS SOARES DA SILVA              ",
				"MONIQUE GURGEL AGUIAR                   ",
				"PRISCILA RAMOS DE MELO                  ",
				"SIMONE KARLA COSTA DA SILVA             ",
				"ALEXSANDRA SANTANA DOS SANTOS           ",
				"ALINE APRÍGIO DA SILVA                  ",
				"AMANDA C. MOREIRA                       ",
				"ANA PRISCILA DE MEIRELES DE MELO        ",
				"ANNE MARIA DE ALVES                     ",
				"ANNY KAROLINY OLIVEIRA LIMA             ",
				"ARACELLY MARIA GUERRA AZEVEDO           ",
				"DEBORA KAYNARA PATRICIO DA SILVA        ",
				"DÉBORA LARISSA SILVA DE SOUZA           ",
				"DINARA REGINA AZEVEDO GADELHA           ",
				"EDILMARA DAS NEVES SILVA                ",
				"GABRIELA FREIRE CORDEIRO DE OLIVEIRA    ",
				"GLENDA ELOÍSE DE P. FEITOSA             ",
				"HELOUISE THAINÁ DA S. MÂCEDO            ",
				"IRENE HAMARA DA COSTA OLIVEIRA          ",
				"IVAMASTK MARIA PEDROSA                  ",
				"JÉSSICA DO VALE SOARES                  ",
				"JÉSSICA KETLEN SOARES DE OLIVEIRA       ",
				"KALYNE RIBEIRO DANTAS Q. DE VASCONCELOS ",
				"KELINE PINHEIRO ARAUJO                  ",
				"KÊNIA STEPHANIE NUNES ARRUDA            ",
				"LARISSI ARAUJO DA SILVA                 ",
				"LORENA ALCÂNTARA DE FARIAS              ",
				"LORENA FREIRE ALVES DE OLIVEIRA         ",
				"LOUISE MARIANE ABREU DE PAIVA           ",
				"LUANA PRISCILA FERNANDES                ",
				"MARIA GISELE DA SILVA DE OLIVEIRA       ",
				"MARIA ISABEL AZEVEDO GOMES              ",
				"MARIA ISABEL PAIVA GOMES                ",
				"MARIA JOSÉ SANTANA DOS SANTOS           ",
				"MARIA LUISA CAVALCANTE DE MORAES        ",
				"MARIANA SALLES FRANCO TORRES            ",
				"MIRIAM SÍRIA R. DE SOUZA                ",
				"MIRNA SOUZA DA SILVA                    ",
				"NATHÁLIA ALCÂNTARA DE FARIAS            ",
				"PATRÍCIA KALLYANE DO VALE PEIXOTO       ",
				"PRISCILA RAMOS DE MELO                  ",
				"RAFAELA LAUREANO WANDERLEY              ",
				"RAFAELA SOUZA TEIXEIRA                  ",
				"RAILMA R. MEDEIROS DA SILVA             ",
				"RAMILE SOUZA TEIXEIRA                   ",
				"SANDRIELLY DO PRADO JUVENCIO            ",
				"SARA DA G. FERREIRA                     ",
				"SIMONE KARLA COSTA DA SILVA             ",
				"SUELEN DA SILVA SOUSA                   "
		};
		return nomes[random];
	}
}
