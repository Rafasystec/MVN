package br.com.barcadero.sat.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.enums.EnumModulosSAT;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.retornos.RetCancelarUltimaVenda;
import br.com.barcadero.module.sat.xml.cancelamento.CFeCanc;
import br.com.barcadero.module.sat.xml.cancelamento.Dest;
import br.com.barcadero.module.sat.xml.cancelamento.Emit;
import br.com.barcadero.module.sat.xml.cancelamento.Ide;
import br.com.barcadero.module.sat.xml.cancelamento.InfCFe;
import br.com.barcadero.module.sat.xml.cancelamento.Total;
import br.com.barcadero.module.sat.xml.util.CNPJ;

public class TestCancelamento {

	@Test
	public void testarCancelamento() {
		CFeCanc cFeCanc = new CFeCanc();
		InfCFe infCFe	= new InfCFe();
		infCFe.setChCanc("CFe35160608723218000186599000025910004973807404");
		//--------------------------------------------------------
		//NOTE: B - Identificacao do Cupom Fiscal Eletronico
		//--------------------------------------------------------
		Ide ide = new Ide();
		ide.setCNPJ("16716114000172");
		ide.setNumeroCaixa("001");
		ide.setSignAC("SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT");
		infCFe.setIde(ide);
		//---------------------------------------------------------------
		//NOTE: C - Identificacao do Emitente do Cupom Fiscal eletronico
		//---------------------------------------------------------------
		Emit emit = new Emit();
		infCFe.setEmit(emit);
		//---------------------------------------------------------------
		//NOTE: E - Identificacao do Destinatario do Cupom Fiscal eletronco
		//---------------------------------------------------------------
		Dest dest = new Dest();
		dest.setCpfCnpj(new CNPJ("46541673000150"));
		infCFe.setDest(dest);
		//---------------------------------------------------------------
		//NOTE: W - Valores Totais do CF-e
		//---------------------------------------------------------------
		Total total = new Total();
		infCFe.setTotal(total);
		//---------------------------------------------------------------
		//Z - Informacoes Adicionais do CF-e
		//---------------------------------------------------------------
//		InfAdic infAdic = new InfAdic();
//		infCFe.setInfAdic(infAdic);
		
		cFeCanc.setInfCFe(infCFe);
		try {
			String xml = HandleXML.normalize(HandleXML.getXMLFromObject(cFeCanc));
			assertEquals("O xml gerado nao corresponde com o esperado", getXMLEsperado(), xml);
//			System.out.println(xml);
//			transmitirCancelamento(xml);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	public void transmitirCancelamento(String xml) throws Exception {
		HandleSAT sat = new HandleSAT();
		sat.definirModulo(EnumTipoModuloSAT.TANCA);
		String result = sat.cancelarUltimaVenda(151351531,"CFe35160608723218000186599000025910004973807404","12345678", xml );
		System.out.println(result);
	}
	
	public String getXMLEsperado() {
		return "<?xml version=\"1.0\" ?><CFeCanc><infCFe chCanc=\"CFe35160608723218000186599000025910004973807404\"><ide><CNPJ>16716114000172</CNPJ><signAC>SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT</signAC><numeroCaixa>001</numeroCaixa></ide><emit></emit><dest><CNPJ>46541673000150</CNPJ></dest><total></total></infCFe></CFeCanc>";
	}
	
	@Test
	public void retornoCancelamento() {
		//788568|07000|0000|Cupom cancelado com sucesso + conteudo CF-E-SAT cancelado.|||PENGZUNhbmM+PGluZkNGZSBJZD0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiIGNoQ2FuYz0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5NzM4MDc0MDQiIHZlcnNhbz0iMC4wNiI+PGRFbWk+MjAxNjA2MTM8L2RFbWk+PGhFbWk+MTEyOTM3PC9oRW1pPjxpZGU+PGNVRj4zNTwvY1VGPjxjTkY+NjYzOTg4PC9jTkY+PG1vZD41OTwvbW9kPjxuc2VyaWVTQVQ+OTAwMDAyNTkxPC9uc2VyaWVTQVQ+PG5DRmU+MDAwNDk4PC9uQ0ZlPjxkRW1pPjIwMTYwNjEzPC9kRW1pPjxoRW1pPjExMzAzMTwvaEVtaT48Y0RWPjI8L2NEVj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPnN0ci9WcjdiODh4ZnNMTUswbWJqKzR4cElrRDhpTzl1cCtsWFJ1NkdRK2trNW1aMVUxNE9ueEMzUU5hVW0wSjkzVldxQjNaaWkyWmp6MTRhdEZlZGIxb3NMN2xpNWRBdVZEMm5vVSs3K1ZDdTBHK0NnWEFZRnc3aDlCcmdYdjh5RktnalNaNG9EUk5rQytQcmxyMGdGZ21DU1JaemdHQnU3VzBIMFBPWkROTEtSV3d2cHlUZmJRV1FYOWVOdlRxY05QMVRVS1JtT1hZOXMrQnRpY0ZJN29vMEdlMnY2bFQ3dHIxK3k5Rmd5U2JGbG9zeDdJdkpnT29iWXRIRnhYNXVIYVQ0WjZMYk5UYTE0Sm5qVC95SXZRa2NBNWpIaWFqa215YmFOQnFKMEJhKzJSbzdiM25XYWpZZng3TmRwOHZGbVAxWFozQjJaazBFUmw1RE9LdjFoZz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PC9lbWl0PjxkZXN0PjxDTlBKPjQ2NTQxNjczMDAwMTUwPC9DTlBKPjwvZGVzdD48dG90YWw+PHZDRmU+MTAuOTk8L3ZDRmU+PC90b3RhbD48aW5mQWRpYz48b2JzRmlzY28geENhbXBvPSJ4Q2FtcG8xIj48eFRleHRvPnhUZXh0bzE8L3hUZXh0bz48L29ic0Zpc2NvPjwvaW5mQWRpYz48L2luZkNGZT48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L0Nhbm9uaWNhbGl6YXRpb25NZXRob2Q+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZHNpZy1tb3JlI3JzYS1zaGEyNTYiPjwvU2lnbmF0dXJlTWV0aG9kPjxSZWZlcmVuY2UgVVJJPSIjQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiPjxUcmFuc2Zvcm1zPjxUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSI+PC9UcmFuc2Zvcm0+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L1RyYW5zZm9ybT48L1RyYW5zZm9ybXM+PERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiI+PC9EaWdlc3RNZXRob2Q+PERpZ2VzdFZhbHVlPk5kZHcyd1ZtSjFNYlI1UVdBVTV3eCtDckxQM0ZQeUQ0am5IYmpNeXZlY289PC9EaWdlc3RWYWx1ZT48L1JlZmVyZW5jZT48L1NpZ25lZEluZm8+PFNpZ25hdHVyZVZhbHVlPkVRaTZIRUhXdTE5dVhHVnFGaE5KQWlLUFhwdWR4dWhiUllHUjRlUWVsUVVhdUU1MXRuZVYxcEpHQ1ZFQVgxT29BQ0pieFhDT1pKbGprc0w5WURWbmw2YVR3N084NEVEYkZUSlE2dFR1a3lzaERST2g3SHBWTWxTU0h2Mnhzck5wSCtWTWZYNGFJRlVLREl6cGxBRkNJMnB1YlIxbVFodkpQWE1jdi9BUVJSWVc0ekVQZXQyblNtUWtDR21EZHR6Umk3VVpKakYxaWZ2UzkzYXBrejArbGFkREx0UjdHTWk2TWFxT0NURldGMVZVUWFOb05xYmdtcW1hdHpTcmNKVEIyU2xvbEZkY0RnS3hlb3p5dVRHK2M1U0RlQ1VnWDdHMFhnU2U5a3kzaDZ3MXZYY3BqYno3MlZSQXlPU0FHaUFuUHpsRUlFSTA3eW9HVUNPbTFmZW42Zz09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlHMWpDQ0JMNmdBd0lCQWdJUU5rYTI5akVUUFNmdU1mdnhsTlFxNXpBTkJna3Foa2lHOXcwQkFRc0ZBREJuTVFzd0NRWURWUVFHRXdKQ1VqRTFNRE1HQTFVRUNoTXNVMlZqY21WMFlYSnBZU0JrWVNCR1lYcGxibVJoSUdSdklFVnpkR0ZrYnlCa1pTQlRZVzhnVUdGMWJHOHhJVEFmQmdOVkJBTVRHRUZESUZOQlZDQmtaU0JVWlhOMFpTQlRSVVpCV2lCVFVEQWVGdzB4TlRBME1qSXdNREF3TURCYUZ3MHlNREEwTVRreU16VTVOVGxhTUlIVE1Rc3dDUVlEVlFRR0V3SkNVakVTTUJBR0ExVUVDQk1KVTBGUElGQkJWVXhQTVJFd0R3WURWUVFLRkFoVFJVWkJXaTFUVURFUE1BMEdBMVVFQ3hRR1FVTXRVMEZVTVNnd0pnWURWUVFMRkI5QmRYUmxiblJwWTJGa2J5QndiM0lnUVZJZ1UwVkdRVm9nVTFBZ1UwRlVNUnd3R2dZRFZRUUxGQk14TkRJNU56RTNNRE13TVRNMU5qTXhNREl4TVJJd0VBWURWUVFGRXdrNU1EQXdNREkxT1RFeE1EQXVCZ05WQkFNVEoxUkJUa05CSUVsT1JrOVNUVUZVU1VOQklFVkpVa1ZNU1Rvd09EY3lNekl4T0RBd01ERTROakNDQVNJd0RRWUpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFOZUptRG5vV0pXbWR5LzZFdGF1UkRNTHp2cWZ5Z28yZVZtem5Ydi9RZy96VXVOUzVOd1VMZGhjVnNnSEYweFN5OGRPRmtYT1hwVGhuWFg3REtvOHgyTUlxTnRrS1FuVHJPRUtid2RreTB3YWo3ZkNsSHpQaHU4RDlaMm8rdlJvcnJsYmdUWUZpUThtMmc4SkFjWFN5RmsvRXNYWFJuQlBPTU5LSkdIRzlsZDQ5MjBuemFNVmpMRW5XcGVXTTVLWkp1eHlpQjVIRXZyS1F0c1NwTlh0MUFLcGtneEhnWTgvMFBscGpqeWY5Zm9jQzNmVEQwMEc0cTBFOStFTUxoYk9HT0ZVTWFRNEc2cTA4SVl2ZVh4QkhlQjlVOHJSL1NSQUYwdUZsTkdoLzNmYXVHRmI0RU5sZmY5TWpaU1B4S1BLVnU5ZEhmcFhnR3dRUThDc1dZU0wydFVDQXdFQUFhT0NBZzh3Z2dJTE1DUUdBMVVkRVFRZE1CdWdHUVlGWUV3QkF3T2dFQVFPTURnM01qTXlNVGd3TURBeE9EWXdDUVlEVlIwVEJBSXdBREFPQmdOVkhROEJBZjhFQkFNQ0JlQXdId1lEVlIwakJCZ3dGb0FVampsQkFGenl1QVhhcUcyWXVRRkdiVzVqM3dJd2F3WURWUjBmQkdRd1lqQmdvRjZnWElaYWFIUjBjRG92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dmJHTnlMMkZqYzJGMGMyVm1ZWHB6Y0M5aFkzTmhkSE5sWm1GNmMzQmpjbXd1WTNKc01Ic0dBMVVkSUFSME1ISXdjQVlKS3dZQkJBR0I3QzBETUdNd1lRWUlLd1lCQlFVSEFnRVdWV2gwZEhBNkx5OWhZM05oZEM1cGJYQnlaVzV6WVc5bWFXTnBZV3d1WTI5dExtSnlMM0psY0c5emFYUnZjbWx2TDJSd1l5OWhZM05oZEhObFptRjZjM0F2WkhCalgyRmpjMkYwYzJWbVlYcHpjQzV3WkdZd0V3WURWUjBsQkF3d0NnWUlLd1lCQlFVSEF3SXdnYWNHQ0NzR0FRVUZCd0VCQklHYU1JR1hNRjhHQ0NzR0FRVUZCekFDaGxOb2RIUndjem92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dlkyVnlkR2xtYVdOaFpHOXpMMkZqYzJGMExYUmxjM1JsTG5BM1l6QTBCZ2dyQmdFRkJRY3dBWVlvYUhSMGNEb3ZMMjlqYzNBdGNHbHNiM1F1YVcxd2NtVnVjMkZ2Wm1samFXRnNMbU52YlM1aWNqQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FnRUFHMDRZcXRSK2RVZmN3K2tjMzVjR3R6VHd5eFp1eE5RK3VCN0NjbzV4MDNCNzhORmV0NFRWamhBVmsvYTRlSSs3blVKckY2di9WcXY3ejRWcnJEY1d6SVRqbVQyM2puVWd3N2Y4dStKdFpOTW9TM3ZRS0ZjS0Q2cTR6bTlSZ2dKUG9TbHVsdE1yTTAzdTJnZ0VSaHBuMXNwMCtIWnJFMWlWTUY2OThrN1loVktLM2lrUXVhSlU3ZUVtTlY3ckRNYlhxYnlCaUh2SXFQOThTZ01hQW5wQzNldUVlcnFJcUNXRG5jWW1TK2p6ZVlkZVdzTC81L210NTl4Z0w4cmFGNTRPNGxTSkRNVERFUWF1WTJGWEZsRngrdlB0ZW9YNEk3T1A3OXk4Y1EyVU9xa0NhNmhVSlM3Y1lTYm90QkRYOHZuWkFWY21kbXNwazRxckdxM1FmV0dKR0g3R09jSnBoMXZhczl1aGl4UThsVDZqYUdFME5YamZrOHpXNjI3cGhObDZLRS90SGdkS1E2TFluMUZCMTdSbFZ4YlcvLytjaHBwM0UzUFE2N3RrOTJsVExMV2sremVsS3dJaXF4RkpEYW5tNTY2SkVJMnZYOUlGcWNBYWl6cndJUGtKOGZlZEc0Lzc0VHpsY1F0NW5jQ2t3cmNHRnIwUk15SWhCQUNWcVpFT2Z1TXloKzg3cm0xRngzekEzaDBuT2x2U3gvNzdPcWs3bDZKZmNvbWxlbHJBWWJiWWw3TUdLd2VUVjVuWGh0YmY2RmdyOG5oRDBmaXdwZC9WT0VndFZNKzZ6ekF5bHpuV3JHSUswenBDSmp3WDZ2ZzB2c0JXVEtMc3pJREJGNzg4bTh4MVFvTTAvRWVZU0FEeDBKR0xKOXdadjFaSFRoWFExeUZ5Qlo2K0d2WT08L1g1MDlDZXJ0aWZpY2F0ZT48L1g1MDlEYXRhPjwvS2V5SW5mbz48L1NpZ25hdHVyZT48L0NGZUNhbmM+|20160613113031|CFe35160608723218000186599000025910004986639882|10.99|46541673000150|str/Vr7b88xfsLMK0mbj+4xpIkD8iO9up+lXRu6GQ+kk5mZ1U14OnxC3QNaUm0J93VWqB3Zii2Zjz14atFedb1osL7li5dAuVD2noU+7+VCu0G+CgXAYFw7h9BrgXv8yFKgjSZ4oDRNkC+Prlr0gFgmCSRZzgGBu7W0H0POZDNLKRWwvpyTfbQWQX9eNvTqcNP1TUKRmOXY9s+BticFI7oo0Ge2v6lT7tr1+y9FgySbFlosx7IvJgOobYtHFxX5uHaT4Z6LbNTa14JnjT/yIvQkcA5jHiajkmybaNBqJ0Ba+2Ro7b3nWajYfx7Ndp8vFmP1XZ3B2Zk0ERl5DOKv1hg==
		RetCancelarUltimaVenda retCan = RetCancelarUltimaVenda.getRetorno(getRetornoCancelamento());
		assertEquals("O objeto de retorno não é o esperado", getRetCancelamentoEsperado(),retCan);
		
	}
	
	public String getRetornoCancelamento() {
		return "788568|07000|0000|Cupom cancelado com sucesso + conteudo CF-E-SAT cancelado.|||PENGZUNhbmM+PGluZkNGZSBJZD0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiIGNoQ2FuYz0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5NzM4MDc0MDQiIHZlcnNhbz0iMC4wNiI+PGRFbWk+MjAxNjA2MTM8L2RFbWk+PGhFbWk+MTEyOTM3PC9oRW1pPjxpZGU+PGNVRj4zNTwvY1VGPjxjTkY+NjYzOTg4PC9jTkY+PG1vZD41OTwvbW9kPjxuc2VyaWVTQVQ+OTAwMDAyNTkxPC9uc2VyaWVTQVQ+PG5DRmU+MDAwNDk4PC9uQ0ZlPjxkRW1pPjIwMTYwNjEzPC9kRW1pPjxoRW1pPjExMzAzMTwvaEVtaT48Y0RWPjI8L2NEVj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPnN0ci9WcjdiODh4ZnNMTUswbWJqKzR4cElrRDhpTzl1cCtsWFJ1NkdRK2trNW1aMVUxNE9ueEMzUU5hVW0wSjkzVldxQjNaaWkyWmp6MTRhdEZlZGIxb3NMN2xpNWRBdVZEMm5vVSs3K1ZDdTBHK0NnWEFZRnc3aDlCcmdYdjh5RktnalNaNG9EUk5rQytQcmxyMGdGZ21DU1JaemdHQnU3VzBIMFBPWkROTEtSV3d2cHlUZmJRV1FYOWVOdlRxY05QMVRVS1JtT1hZOXMrQnRpY0ZJN29vMEdlMnY2bFQ3dHIxK3k5Rmd5U2JGbG9zeDdJdkpnT29iWXRIRnhYNXVIYVQ0WjZMYk5UYTE0Sm5qVC95SXZRa2NBNWpIaWFqa215YmFOQnFKMEJhKzJSbzdiM25XYWpZZng3TmRwOHZGbVAxWFozQjJaazBFUmw1RE9LdjFoZz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PC9lbWl0PjxkZXN0PjxDTlBKPjQ2NTQxNjczMDAwMTUwPC9DTlBKPjwvZGVzdD48dG90YWw+PHZDRmU+MTAuOTk8L3ZDRmU+PC90b3RhbD48aW5mQWRpYz48b2JzRmlzY28geENhbXBvPSJ4Q2FtcG8xIj48eFRleHRvPnhUZXh0bzE8L3hUZXh0bz48L29ic0Zpc2NvPjwvaW5mQWRpYz48L2luZkNGZT48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L0Nhbm9uaWNhbGl6YXRpb25NZXRob2Q+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZHNpZy1tb3JlI3JzYS1zaGEyNTYiPjwvU2lnbmF0dXJlTWV0aG9kPjxSZWZlcmVuY2UgVVJJPSIjQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiPjxUcmFuc2Zvcm1zPjxUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSI+PC9UcmFuc2Zvcm0+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L1RyYW5zZm9ybT48L1RyYW5zZm9ybXM+PERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiI+PC9EaWdlc3RNZXRob2Q+PERpZ2VzdFZhbHVlPk5kZHcyd1ZtSjFNYlI1UVdBVTV3eCtDckxQM0ZQeUQ0am5IYmpNeXZlY289PC9EaWdlc3RWYWx1ZT48L1JlZmVyZW5jZT48L1NpZ25lZEluZm8+PFNpZ25hdHVyZVZhbHVlPkVRaTZIRUhXdTE5dVhHVnFGaE5KQWlLUFhwdWR4dWhiUllHUjRlUWVsUVVhdUU1MXRuZVYxcEpHQ1ZFQVgxT29BQ0pieFhDT1pKbGprc0w5WURWbmw2YVR3N084NEVEYkZUSlE2dFR1a3lzaERST2g3SHBWTWxTU0h2Mnhzck5wSCtWTWZYNGFJRlVLREl6cGxBRkNJMnB1YlIxbVFodkpQWE1jdi9BUVJSWVc0ekVQZXQyblNtUWtDR21EZHR6Umk3VVpKakYxaWZ2UzkzYXBrejArbGFkREx0UjdHTWk2TWFxT0NURldGMVZVUWFOb05xYmdtcW1hdHpTcmNKVEIyU2xvbEZkY0RnS3hlb3p5dVRHK2M1U0RlQ1VnWDdHMFhnU2U5a3kzaDZ3MXZYY3BqYno3MlZSQXlPU0FHaUFuUHpsRUlFSTA3eW9HVUNPbTFmZW42Zz09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlHMWpDQ0JMNmdBd0lCQWdJUU5rYTI5akVUUFNmdU1mdnhsTlFxNXpBTkJna3Foa2lHOXcwQkFRc0ZBREJuTVFzd0NRWURWUVFHRXdKQ1VqRTFNRE1HQTFVRUNoTXNVMlZqY21WMFlYSnBZU0JrWVNCR1lYcGxibVJoSUdSdklFVnpkR0ZrYnlCa1pTQlRZVzhnVUdGMWJHOHhJVEFmQmdOVkJBTVRHRUZESUZOQlZDQmtaU0JVWlhOMFpTQlRSVVpCV2lCVFVEQWVGdzB4TlRBME1qSXdNREF3TURCYUZ3MHlNREEwTVRreU16VTVOVGxhTUlIVE1Rc3dDUVlEVlFRR0V3SkNVakVTTUJBR0ExVUVDQk1KVTBGUElGQkJWVXhQTVJFd0R3WURWUVFLRkFoVFJVWkJXaTFUVURFUE1BMEdBMVVFQ3hRR1FVTXRVMEZVTVNnd0pnWURWUVFMRkI5QmRYUmxiblJwWTJGa2J5QndiM0lnUVZJZ1UwVkdRVm9nVTFBZ1UwRlVNUnd3R2dZRFZRUUxGQk14TkRJNU56RTNNRE13TVRNMU5qTXhNREl4TVJJd0VBWURWUVFGRXdrNU1EQXdNREkxT1RFeE1EQXVCZ05WQkFNVEoxUkJUa05CSUVsT1JrOVNUVUZVU1VOQklFVkpVa1ZNU1Rvd09EY3lNekl4T0RBd01ERTROakNDQVNJd0RRWUpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFOZUptRG5vV0pXbWR5LzZFdGF1UkRNTHp2cWZ5Z28yZVZtem5Ydi9RZy96VXVOUzVOd1VMZGhjVnNnSEYweFN5OGRPRmtYT1hwVGhuWFg3REtvOHgyTUlxTnRrS1FuVHJPRUtid2RreTB3YWo3ZkNsSHpQaHU4RDlaMm8rdlJvcnJsYmdUWUZpUThtMmc4SkFjWFN5RmsvRXNYWFJuQlBPTU5LSkdIRzlsZDQ5MjBuemFNVmpMRW5XcGVXTTVLWkp1eHlpQjVIRXZyS1F0c1NwTlh0MUFLcGtneEhnWTgvMFBscGpqeWY5Zm9jQzNmVEQwMEc0cTBFOStFTUxoYk9HT0ZVTWFRNEc2cTA4SVl2ZVh4QkhlQjlVOHJSL1NSQUYwdUZsTkdoLzNmYXVHRmI0RU5sZmY5TWpaU1B4S1BLVnU5ZEhmcFhnR3dRUThDc1dZU0wydFVDQXdFQUFhT0NBZzh3Z2dJTE1DUUdBMVVkRVFRZE1CdWdHUVlGWUV3QkF3T2dFQVFPTURnM01qTXlNVGd3TURBeE9EWXdDUVlEVlIwVEJBSXdBREFPQmdOVkhROEJBZjhFQkFNQ0JlQXdId1lEVlIwakJCZ3dGb0FVampsQkFGenl1QVhhcUcyWXVRRkdiVzVqM3dJd2F3WURWUjBmQkdRd1lqQmdvRjZnWElaYWFIUjBjRG92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dmJHTnlMMkZqYzJGMGMyVm1ZWHB6Y0M5aFkzTmhkSE5sWm1GNmMzQmpjbXd1WTNKc01Ic0dBMVVkSUFSME1ISXdjQVlKS3dZQkJBR0I3QzBETUdNd1lRWUlLd1lCQlFVSEFnRVdWV2gwZEhBNkx5OWhZM05oZEM1cGJYQnlaVzV6WVc5bWFXTnBZV3d1WTI5dExtSnlMM0psY0c5emFYUnZjbWx2TDJSd1l5OWhZM05oZEhObFptRjZjM0F2WkhCalgyRmpjMkYwYzJWbVlYcHpjQzV3WkdZd0V3WURWUjBsQkF3d0NnWUlLd1lCQlFVSEF3SXdnYWNHQ0NzR0FRVUZCd0VCQklHYU1JR1hNRjhHQ0NzR0FRVUZCekFDaGxOb2RIUndjem92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dlkyVnlkR2xtYVdOaFpHOXpMMkZqYzJGMExYUmxjM1JsTG5BM1l6QTBCZ2dyQmdFRkJRY3dBWVlvYUhSMGNEb3ZMMjlqYzNBdGNHbHNiM1F1YVcxd2NtVnVjMkZ2Wm1samFXRnNMbU52YlM1aWNqQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FnRUFHMDRZcXRSK2RVZmN3K2tjMzVjR3R6VHd5eFp1eE5RK3VCN0NjbzV4MDNCNzhORmV0NFRWamhBVmsvYTRlSSs3blVKckY2di9WcXY3ejRWcnJEY1d6SVRqbVQyM2puVWd3N2Y4dStKdFpOTW9TM3ZRS0ZjS0Q2cTR6bTlSZ2dKUG9TbHVsdE1yTTAzdTJnZ0VSaHBuMXNwMCtIWnJFMWlWTUY2OThrN1loVktLM2lrUXVhSlU3ZUVtTlY3ckRNYlhxYnlCaUh2SXFQOThTZ01hQW5wQzNldUVlcnFJcUNXRG5jWW1TK2p6ZVlkZVdzTC81L210NTl4Z0w4cmFGNTRPNGxTSkRNVERFUWF1WTJGWEZsRngrdlB0ZW9YNEk3T1A3OXk4Y1EyVU9xa0NhNmhVSlM3Y1lTYm90QkRYOHZuWkFWY21kbXNwazRxckdxM1FmV0dKR0g3R09jSnBoMXZhczl1aGl4UThsVDZqYUdFME5YamZrOHpXNjI3cGhObDZLRS90SGdkS1E2TFluMUZCMTdSbFZ4YlcvLytjaHBwM0UzUFE2N3RrOTJsVExMV2sremVsS3dJaXF4RkpEYW5tNTY2SkVJMnZYOUlGcWNBYWl6cndJUGtKOGZlZEc0Lzc0VHpsY1F0NW5jQ2t3cmNHRnIwUk15SWhCQUNWcVpFT2Z1TXloKzg3cm0xRngzekEzaDBuT2x2U3gvNzdPcWs3bDZKZmNvbWxlbHJBWWJiWWw3TUdLd2VUVjVuWGh0YmY2RmdyOG5oRDBmaXdwZC9WT0VndFZNKzZ6ekF5bHpuV3JHSUswenBDSmp3WDZ2ZzB2c0JXVEtMc3pJREJGNzg4bTh4MVFvTTAvRWVZU0FEeDBKR0xKOXdadjFaSFRoWFExeUZ5Qlo2K0d2WT08L1g1MDlDZXJ0aWZpY2F0ZT48L1g1MDlEYXRhPjwvS2V5SW5mbz48L1NpZ25hdHVyZT48L0NGZUNhbmM+|20160613113031|CFe35160608723218000186599000025910004986639882|10.99|46541673000150|str/Vr7b88xfsLMK0mbj+4xpIkD8iO9up+lXRu6GQ+kk5mZ1U14OnxC3QNaUm0J93VWqB3Zii2Zjz14atFedb1osL7li5dAuVD2noU+7+VCu0G+CgXAYFw7h9BrgXv8yFKgjSZ4oDRNkC+Prlr0gFgmCSRZzgGBu7W0H0POZDNLKRWwvpyTfbQWQX9eNvTqcNP1TUKRmOXY9s+BticFI7oo0Ge2v6lT7tr1+y9FgySbFlosx7IvJgOobYtHFxX5uHaT4Z6LbNTa14JnjT/yIvQkcA5jHiajkmybaNBqJ0Ba+2Ro7b3nWajYfx7Ndp8vFmP1XZ3B2Zk0ERl5DOKv1hg==";
	}
	
	public RetCancelarUltimaVenda getRetCancelamentoEsperado() {
		RetCancelarUltimaVenda retCan = new RetCancelarUltimaVenda();
		retCan.setArquivoBase64("PENGZUNhbmM+PGluZkNGZSBJZD0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiIGNoQ2FuYz0iQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5NzM4MDc0MDQiIHZlcnNhbz0iMC4wNiI+PGRFbWk+MjAxNjA2MTM8L2RFbWk+PGhFbWk+MTEyOTM3PC9oRW1pPjxpZGU+PGNVRj4zNTwvY1VGPjxjTkY+NjYzOTg4PC9jTkY+PG1vZD41OTwvbW9kPjxuc2VyaWVTQVQ+OTAwMDAyNTkxPC9uc2VyaWVTQVQ+PG5DRmU+MDAwNDk4PC9uQ0ZlPjxkRW1pPjIwMTYwNjEzPC9kRW1pPjxoRW1pPjExMzAzMTwvaEVtaT48Y0RWPjI8L2NEVj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPnN0ci9WcjdiODh4ZnNMTUswbWJqKzR4cElrRDhpTzl1cCtsWFJ1NkdRK2trNW1aMVUxNE9ueEMzUU5hVW0wSjkzVldxQjNaaWkyWmp6MTRhdEZlZGIxb3NMN2xpNWRBdVZEMm5vVSs3K1ZDdTBHK0NnWEFZRnc3aDlCcmdYdjh5RktnalNaNG9EUk5rQytQcmxyMGdGZ21DU1JaemdHQnU3VzBIMFBPWkROTEtSV3d2cHlUZmJRV1FYOWVOdlRxY05QMVRVS1JtT1hZOXMrQnRpY0ZJN29vMEdlMnY2bFQ3dHIxK3k5Rmd5U2JGbG9zeDdJdkpnT29iWXRIRnhYNXVIYVQ0WjZMYk5UYTE0Sm5qVC95SXZRa2NBNWpIaWFqa215YmFOQnFKMEJhKzJSbzdiM25XYWpZZng3TmRwOHZGbVAxWFozQjJaazBFUmw1RE9LdjFoZz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PC9lbWl0PjxkZXN0PjxDTlBKPjQ2NTQxNjczMDAwMTUwPC9DTlBKPjwvZGVzdD48dG90YWw+PHZDRmU+MTAuOTk8L3ZDRmU+PC90b3RhbD48aW5mQWRpYz48b2JzRmlzY28geENhbXBvPSJ4Q2FtcG8xIj48eFRleHRvPnhUZXh0bzE8L3hUZXh0bz48L29ic0Zpc2NvPjwvaW5mQWRpYz48L2luZkNGZT48U2lnbmF0dXJlIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48U2lnbmVkSW5mbz48Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L0Nhbm9uaWNhbGl6YXRpb25NZXRob2Q+PFNpZ25hdHVyZU1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZHNpZy1tb3JlI3JzYS1zaGEyNTYiPjwvU2lnbmF0dXJlTWV0aG9kPjxSZWZlcmVuY2UgVVJJPSIjQ0ZlMzUxNjA2MDg3MjMyMTgwMDAxODY1OTkwMDAwMjU5MTAwMDQ5ODY2Mzk4ODIiPjxUcmFuc2Zvcm1zPjxUcmFuc2Zvcm0gQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjZW52ZWxvcGVkLXNpZ25hdHVyZSI+PC9UcmFuc2Zvcm0+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnL1RSLzIwMDEvUkVDLXhtbC1jMTRuLTIwMDEwMzE1Ij48L1RyYW5zZm9ybT48L1RyYW5zZm9ybXM+PERpZ2VzdE1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMDQveG1sZW5jI3NoYTI1NiI+PC9EaWdlc3RNZXRob2Q+PERpZ2VzdFZhbHVlPk5kZHcyd1ZtSjFNYlI1UVdBVTV3eCtDckxQM0ZQeUQ0am5IYmpNeXZlY289PC9EaWdlc3RWYWx1ZT48L1JlZmVyZW5jZT48L1NpZ25lZEluZm8+PFNpZ25hdHVyZVZhbHVlPkVRaTZIRUhXdTE5dVhHVnFGaE5KQWlLUFhwdWR4dWhiUllHUjRlUWVsUVVhdUU1MXRuZVYxcEpHQ1ZFQVgxT29BQ0pieFhDT1pKbGprc0w5WURWbmw2YVR3N084NEVEYkZUSlE2dFR1a3lzaERST2g3SHBWTWxTU0h2Mnhzck5wSCtWTWZYNGFJRlVLREl6cGxBRkNJMnB1YlIxbVFodkpQWE1jdi9BUVJSWVc0ekVQZXQyblNtUWtDR21EZHR6Umk3VVpKakYxaWZ2UzkzYXBrejArbGFkREx0UjdHTWk2TWFxT0NURldGMVZVUWFOb05xYmdtcW1hdHpTcmNKVEIyU2xvbEZkY0RnS3hlb3p5dVRHK2M1U0RlQ1VnWDdHMFhnU2U5a3kzaDZ3MXZYY3BqYno3MlZSQXlPU0FHaUFuUHpsRUlFSTA3eW9HVUNPbTFmZW42Zz09PC9TaWduYXR1cmVWYWx1ZT48S2V5SW5mbz48WDUwOURhdGE+PFg1MDlDZXJ0aWZpY2F0ZT5NSUlHMWpDQ0JMNmdBd0lCQWdJUU5rYTI5akVUUFNmdU1mdnhsTlFxNXpBTkJna3Foa2lHOXcwQkFRc0ZBREJuTVFzd0NRWURWUVFHRXdKQ1VqRTFNRE1HQTFVRUNoTXNVMlZqY21WMFlYSnBZU0JrWVNCR1lYcGxibVJoSUdSdklFVnpkR0ZrYnlCa1pTQlRZVzhnVUdGMWJHOHhJVEFmQmdOVkJBTVRHRUZESUZOQlZDQmtaU0JVWlhOMFpTQlRSVVpCV2lCVFVEQWVGdzB4TlRBME1qSXdNREF3TURCYUZ3MHlNREEwTVRreU16VTVOVGxhTUlIVE1Rc3dDUVlEVlFRR0V3SkNVakVTTUJBR0ExVUVDQk1KVTBGUElGQkJWVXhQTVJFd0R3WURWUVFLRkFoVFJVWkJXaTFUVURFUE1BMEdBMVVFQ3hRR1FVTXRVMEZVTVNnd0pnWURWUVFMRkI5QmRYUmxiblJwWTJGa2J5QndiM0lnUVZJZ1UwVkdRVm9nVTFBZ1UwRlVNUnd3R2dZRFZRUUxGQk14TkRJNU56RTNNRE13TVRNMU5qTXhNREl4TVJJd0VBWURWUVFGRXdrNU1EQXdNREkxT1RFeE1EQXVCZ05WQkFNVEoxUkJUa05CSUVsT1JrOVNUVUZVU1VOQklFVkpVa1ZNU1Rvd09EY3lNekl4T0RBd01ERTROakNDQVNJd0RRWUpLb1pJaHZjTkFRRUJCUUFEZ2dFUEFEQ0NBUW9DZ2dFQkFOZUptRG5vV0pXbWR5LzZFdGF1UkRNTHp2cWZ5Z28yZVZtem5Ydi9RZy96VXVOUzVOd1VMZGhjVnNnSEYweFN5OGRPRmtYT1hwVGhuWFg3REtvOHgyTUlxTnRrS1FuVHJPRUtid2RreTB3YWo3ZkNsSHpQaHU4RDlaMm8rdlJvcnJsYmdUWUZpUThtMmc4SkFjWFN5RmsvRXNYWFJuQlBPTU5LSkdIRzlsZDQ5MjBuemFNVmpMRW5XcGVXTTVLWkp1eHlpQjVIRXZyS1F0c1NwTlh0MUFLcGtneEhnWTgvMFBscGpqeWY5Zm9jQzNmVEQwMEc0cTBFOStFTUxoYk9HT0ZVTWFRNEc2cTA4SVl2ZVh4QkhlQjlVOHJSL1NSQUYwdUZsTkdoLzNmYXVHRmI0RU5sZmY5TWpaU1B4S1BLVnU5ZEhmcFhnR3dRUThDc1dZU0wydFVDQXdFQUFhT0NBZzh3Z2dJTE1DUUdBMVVkRVFRZE1CdWdHUVlGWUV3QkF3T2dFQVFPTURnM01qTXlNVGd3TURBeE9EWXdDUVlEVlIwVEJBSXdBREFPQmdOVkhROEJBZjhFQkFNQ0JlQXdId1lEVlIwakJCZ3dGb0FVampsQkFGenl1QVhhcUcyWXVRRkdiVzVqM3dJd2F3WURWUjBmQkdRd1lqQmdvRjZnWElaYWFIUjBjRG92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dmJHTnlMMkZqYzJGMGMyVm1ZWHB6Y0M5aFkzTmhkSE5sWm1GNmMzQmpjbXd1WTNKc01Ic0dBMVVkSUFSME1ISXdjQVlKS3dZQkJBR0I3QzBETUdNd1lRWUlLd1lCQlFVSEFnRVdWV2gwZEhBNkx5OWhZM05oZEM1cGJYQnlaVzV6WVc5bWFXTnBZV3d1WTI5dExtSnlMM0psY0c5emFYUnZjbWx2TDJSd1l5OWhZM05oZEhObFptRjZjM0F2WkhCalgyRmpjMkYwYzJWbVlYcHpjQzV3WkdZd0V3WURWUjBsQkF3d0NnWUlLd1lCQlFVSEF3SXdnYWNHQ0NzR0FRVUZCd0VCQklHYU1JR1hNRjhHQ0NzR0FRVUZCekFDaGxOb2RIUndjem92TDJGamMyRjBMWFJsYzNSbExtbHRjSEpsYm5OaGIyWnBZMmxoYkM1amIyMHVZbkl2Y21Wd2IzTnBkRzl5YVc4dlkyVnlkR2xtYVdOaFpHOXpMMkZqYzJGMExYUmxjM1JsTG5BM1l6QTBCZ2dyQmdFRkJRY3dBWVlvYUhSMGNEb3ZMMjlqYzNBdGNHbHNiM1F1YVcxd2NtVnVjMkZ2Wm1samFXRnNMbU52YlM1aWNqQU5CZ2txaGtpRzl3MEJBUXNGQUFPQ0FnRUFHMDRZcXRSK2RVZmN3K2tjMzVjR3R6VHd5eFp1eE5RK3VCN0NjbzV4MDNCNzhORmV0NFRWamhBVmsvYTRlSSs3blVKckY2di9WcXY3ejRWcnJEY1d6SVRqbVQyM2puVWd3N2Y4dStKdFpOTW9TM3ZRS0ZjS0Q2cTR6bTlSZ2dKUG9TbHVsdE1yTTAzdTJnZ0VSaHBuMXNwMCtIWnJFMWlWTUY2OThrN1loVktLM2lrUXVhSlU3ZUVtTlY3ckRNYlhxYnlCaUh2SXFQOThTZ01hQW5wQzNldUVlcnFJcUNXRG5jWW1TK2p6ZVlkZVdzTC81L210NTl4Z0w4cmFGNTRPNGxTSkRNVERFUWF1WTJGWEZsRngrdlB0ZW9YNEk3T1A3OXk4Y1EyVU9xa0NhNmhVSlM3Y1lTYm90QkRYOHZuWkFWY21kbXNwazRxckdxM1FmV0dKR0g3R09jSnBoMXZhczl1aGl4UThsVDZqYUdFME5YamZrOHpXNjI3cGhObDZLRS90SGdkS1E2TFluMUZCMTdSbFZ4YlcvLytjaHBwM0UzUFE2N3RrOTJsVExMV2sremVsS3dJaXF4RkpEYW5tNTY2SkVJMnZYOUlGcWNBYWl6cndJUGtKOGZlZEc0Lzc0VHpsY1F0NW5jQ2t3cmNHRnIwUk15SWhCQUNWcVpFT2Z1TXloKzg3cm0xRngzekEzaDBuT2x2U3gvNzdPcWs3bDZKZmNvbWxlbHJBWWJiWWw3TUdLd2VUVjVuWGh0YmY2RmdyOG5oRDBmaXdwZC9WT0VndFZNKzZ6ekF5bHpuV3JHSUswenBDSmp3WDZ2ZzB2c0JXVEtMc3pJREJGNzg4bTh4MVFvTTAvRWVZU0FEeDBKR0xKOXdadjFaSFRoWFExeUZ5Qlo2K0d2WT08L1g1MDlDZXJ0aWZpY2F0ZT48L1g1MDlEYXRhPjwvS2V5SW5mbz48L1NpZ25hdHVyZT48L0NGZUNhbmM+");
		retCan.setAssinaturaQRCode("str/Vr7b88xfsLMK0mbj+4xpIkD8iO9up+lXRu6GQ+kk5mZ1U14OnxC3QNaUm0J93VWqB3Zii2Zjz14atFedb1osL7li5dAuVD2noU+7+VCu0G+CgXAYFw7h9BrgXv8yFKgjSZ4oDRNkC+Prlr0gFgmCSRZzgGBu7W0H0POZDNLKRWwvpyTfbQWQX9eNvTqcNP1TUKRmOXY9s+BticFI7oo0Ge2v6lT7tr1+y9FgySbFlosx7IvJgOobYtHFxX5uHaT4Z6LbNTa14JnjT/yIvQkcA5jHiajkmybaNBqJ0Ba+2Ro7b3nWajYfx7Ndp8vFmP1XZ3B2Zk0ERl5DOKv1hg==");
		retCan.setChaveConsulta("CFe35160608723218000186599000025910004986639882");
		retCan.setCodigoAlerta("0000");
		retCan.setCodigoRetSAT("07000");
		retCan.setCodigoSEFAZ("");
		retCan.setCpfCnpjValue("46541673000150");
		retCan.setDataHoraTransm("20160613113031");
		retCan.setMsgModulo("Cupom cancelado com sucesso + conteudo CF-E-SAT cancelado.");
		retCan.setMsgSEFAZ("");
		retCan.setNumeroSessao("788568");
		retCan.setValorTotal("10.99");
		return retCan;
	}
}
