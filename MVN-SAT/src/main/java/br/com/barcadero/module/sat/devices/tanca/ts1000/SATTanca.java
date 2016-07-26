package br.com.barcadero.module.sat.devices.tanca.ts1000;

import java.io.File;

import br.com.barcadero.module.sat.handle.AbstractSATSuperClass;
import br.com.barcadero.module.sat.handle.HendleFile;
import br.com.barcadero.module.sat.handle.HandleSAT;

import com.sun.jna.Native;


public class SATTanca extends AbstractSATSuperClass {

	private Functions library							 = null;

	public  SATTanca(String porta) throws Exception {
		try {
			initialize();
			detectOS();
			verifyLibrary();
			library = (Functions)Native.loadLibrary(getLibraryName(), Functions.class);
			setLibrary(library);
		} catch (Exception e) {
			// TODO: handle exception
			//Logfactory.adicionar(e);
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Construtor padrao. Nao colocar nada pois ele servira para iniciar a enumeracao dos modulos
	 */
	public SATTanca(){
		
	}
	
	
	@Override
	public String TipoDoModulo() throws Exception {
		// TODO Auto-generated method stub
		return HandleSAT.SAT;
	}

	@Override
	public int getCodModule(){
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String getModuleName()  {
		// TODO Auto-generated method stub
		return "SAT - Tanca TS-1000";
	}

	@Override
	public int openPort(int canal) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Verifica se as bibliotecas estao no local.
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLibrary() throws Exception{
		File file 			= null;
		String osName		= getOsName();
		try {
			//Logfactory.adicionar("Verificando as bibliotecas necessarias.");
			if(osName.equalsIgnoreCase(OS_LINUX)){
				//Logfactory.adicionar("Verificando para o Linux " + osName);
				//Logfactory.adicionar("Nao foi implementado para o Linux. Nao funcionara. Favor nao insistir.");
				return false;
			}else{
				file 		= new File(getLibraryPath() + getRealLibNameWindows());
				if(!file.exists()){
					//Logfactory.adicionar("Erro - Biblioteca " + getRealLibNameWindows()  + " nao foram encontradas.");
					//Logfactory.adicionar("Elas devem ficar neste local: " + getLibraryPath());
					return false;
				}else{
					//Logfactory.adicionar("OK - Bibliotecas e suas dependecias foram encontradas.");
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//Logfactory.adicionar(e);
			throw e;
		}
	}
	
	@Override
	public String toString(){
		return "Modulo SAT Tanca TS-1000";
	}
	
	public static SATTanca getInstance(){
		return new SATTanca();
	}

	@Override
	public void closePort() throws Exception {
		// TODO Auto-generated method stub
	}
	
//	@Override
//	public String CancelarUltimaVenda(int numeroSessao,	String codigoDeAtivacao, String chave, String dadosCancelamento)throws Exception {
//		return super.CancelarUltimaVenda(numeroSessao, codigoDeAtivacao, "CFe" + chave, dadosCancelamento);
//	}
//	@Override
//	public String TesteFimAFim(int numeroSessao, String codigoDeAtivacao, String dadosVenda) throws Exception {
//		dadosVenda = "<CFe><infCFe versaoDadosEnt=\"0.06\"><ide><CNPJ>16716114000172</CNPJ><signAC>SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT</signAC><numeroCaixa>062</numeroCaixa></ide><emit><CNPJ>08723218000186</CNPJ><IE>149626224113</IE><IM>021522</IM><indRatISSQN>N</indRatISSQN></emit><dest><CPF></CPF></dest><det nItem=\"1\"><prod><cProd>000001</cProd><xProd>PRODUTO MARCO</xProd><NCM>01012100</NCM><CFOP>5102</CFOP><uCom>und</uCom><qCom>1.0000</qCom><vUnCom>11.00</vUnCom><indRegra>A</indRegra></prod><imposto><vItem12741>2.33</vItem12741><ICMS><ICMS00><Orig>0</Orig><CST>00</CST><pICMS>12.00</pICMS></ICMS00></ICMS><PIS><PISAliq><CST>01</CST><vBC>11.00</vBC><pPIS>0.1700</pPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>11.00</vBC><pCOFINS>0.0900</pCOFINS></COFINSAliq></COFINS></imposto></det><total><vCFeLei12741>2.33</vCFeLei12741></total><pgto><MP><cMP>01</cMP><vMP>11.00</vMP></MP></pgto><infAdic><infCpl>Vendedor :ANTONIOJOSE DOS SANTOS,Cond. Pgto.:VENDA A VISTA .</infCpl></infAdic></infCFe></CFe>";
//		return super.TesteFimAFim(numeroSessao, codigoDeAtivacao, dadosVenda);
//	}
	private void initialize() throws Exception {
		//String libPath = HendleFile.obterCaminhoRaiz() + "lib" + File.separator + "tanca" + File.separator;
		String libPath = "";
		setLibraryNameLinux("sat");
		setLibraryNameWindows("SAT");
		setLibraryPath(libPath);
		setRealLibNameLinux("libsat.so");
		setRealLibNameWindows("SAT.dll");
	}

}
