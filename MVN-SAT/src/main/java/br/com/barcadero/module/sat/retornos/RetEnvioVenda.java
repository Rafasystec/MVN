package br.com.barcadero.module.sat.retornos;

public class RetEnvioVenda extends SuperSATRetorno {

	/*Exemplo de retorno de venda
	 * 
	 * 463462|06000|0000|Emitido com sucesso + conteudo notas.|||PENGZT48aW5mQ0ZlIElkPSJDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDkwMDk3MjEzOCIgdmVyc2FvPSIwLjA2IiB2ZXJzYW9EYWRvc0VudD0iMC4wNiIgdmVyc2FvU0I9IjAxMDEwMSI+PGlkZT48Y1VGPjM1PC9jVUY+PGNORj4wOTcyMTM8L2NORj48bW9kPjU5PC9tb2Q+PG5zZXJpZVNBVD45MDAwMDI1OTE8L25zZXJpZVNBVD48bkNGZT4wMDA0OTA8L25DRmU+PGRFbWk+MjAxNjA2MTA8L2RFbWk+PGhFbWk+MTc1NjM2PC9oRW1pPjxjRFY+ODwvY0RWPjx0cEFtYj4yPC90cEFtYj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPjAvSDJtVVc2STBwcXFPb1F5M2NVWXUrQU1uMWRBcFZQQjdJY0lWUGxEZW1mOUxpNUMrREZQSk1BV3J4Y1JERnowd0tGUGlMRXhwTEhqTDdFS25Kei9tNFI5eWw4OVp5VzNXMTAvRnVzVjBRb3l5VFJqU0RUQ3o2Y3dmYXN3MHFHTUZMSjBZbnRsMzVQMHJPdnJGcTF0T1lUQWxXVnVkdlY1WmpJWHowTFh4MExTQjZmSXdFUi84VXIvR2FMOHcyUzk1UzJ3WHBXWVZ2RzRZbTk1MjY2N1FkU2gzWFRkT1FLL0NmN3JrWGlGdkVEUzJuZkpBVXYyNzJPMHU4eTNnb0VBOHA5czFha05Dd1BZL0NmSHROR0VCbDk1UFdZc3NBRVpLdGxpR0g3Z3N0aXZpTVFTUUxHR0Z3dGU3VUN0S25QTmJqMUpFR3FybFN6UWphc25WZUpxdz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PGNSZWdUcmliPjM8L2NSZWdUcmliPjxjUmVnVHJpYklTU1FOPjE8L2NSZWdUcmliSVNTUU4+PGluZFJhdElTU1FOPk48L2luZFJhdElTU1FOPjwvZW1pdD48ZGVzdD48Q05QSj40NjU0MTY3MzAwMDE1MDwvQ05QSj48eE5vbWU+UkFaQU8gU09DSUFMPC94Tm9tZT48L2Rlc3Q+PGVudHJlZ2E+PHhMZ3I+TG9ncmFkb3VybzwveExncj48bnJvPjEyMzwvbnJvPjx4Q3BsPmNvbXBsZW1lbnRvPC94Q3BsPjx4QmFpcnJvPkJhaXJybzwveEJhaXJybz48eE11bj5NdW5pY2lwaW88L3hNdW4+PFVGPkNFPC9VRj48L2VudHJlZ2E+PGRldCBuSXRlbT0iMSI+PHByb2Q+PGNQcm9kPjAwOTA5ODA8L2NQcm9kPjx4UHJvZD5QUk9EIEhPTU9MT0c8L3hQcm9kPjxOQ00+MDEwMzEwMDA8L05DTT48Q0ZPUD41MTAyPC9DRk9QPjx1Q29tPlVOPC91Q29tPjxxQ29tPjEuMDAwMDwvcUNvbT48dlVuQ29tPjEwLjk5PC92VW5Db20+PHZQcm9kPjEwLjk5PC92UHJvZD48aW5kUmVncmE+QTwvaW5kUmVncmE+PHZJdGVtPjEwLjk5PC92SXRlbT48dlJhdERlc2M+MC4wMDwvdlJhdERlc2M+PHZSYXRBY3I+MC4wMDwvdlJhdEFjcj48L3Byb2Q+PGltcG9zdG8+PHZJdGVtMTI3NDE+Mi41MDwvdkl0ZW0xMjc0MT48SUNNUz48SUNNUzAwPjxPcmlnPjA8L09yaWc+PENTVD4wMDwvQ1NUPjxwSUNNUz41LjMzPC9wSUNNUz48dklDTVM+MC41OTwvdklDTVM+PC9JQ01TMDA+PC9JQ01TPjxQSVM+PFBJU0FsaXE+PENTVD4wMTwvQ1NUPjx2QkM+MTAuOTk8L3ZCQz48cFBJUz4wLjE3MDA8L3BQSVM+PHZQSVM+MS44NzwvdlBJUz48L1BJU0FsaXE+PC9QSVM+PENPRklOUz48Q09GSU5TQWxpcT48Q1NUPjAxPC9DU1Q+PHZCQz4xMC45OTwvdkJDPjxwQ09GSU5TPjAuMDkwMDwvcENPRklOUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjwvQ09GSU5TQWxpcT48L0NPRklOUz48L2ltcG9zdG8+PGluZkFkUHJvZD5JbmZvcm1hY2FvIGFkaWNpb25hbDwvaW5mQWRQcm9kPjwvZGV0Pjx0b3RhbD48SUNNU1RvdD48dklDTVM+MC41OTwvdklDTVM+PHZQcm9kPjEwLjk5PC92UHJvZD48dkRlc2M+MC4wMDwvdkRlc2M+PHZQSVM+MS44NzwvdlBJUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjx2UElTU1Q+MC4wMDwvdlBJU1NUPjx2Q09GSU5TU1Q+MC4wMDwvdkNPRklOU1NUPjx2T3V0cm8+MC4wMDwvdk91dHJvPjwvSUNNU1RvdD48dkNGZT4xMC45OTwvdkNGZT48dkNGZUxlaTEyNzQxPjEuMDU8L3ZDRmVMZWkxMjc0MT48L3RvdGFsPjxwZ3RvPjxNUD48Y01QPjAxPC9jTVA+PHZNUD4xMC45OTwvdk1QPjwvTVA+PHZUcm9jbz4wLjAwPC92VHJvY28+PC9wZ3RvPjxpbmZBZGljPjxvYnNGaXNjbyB4Q2FtcG89InhDYW1wbzEiPjx4VGV4dG8+eFRleHRvMTwveFRleHRvPjwvb2JzRmlzY28+PC9pbmZBZGljPjwvaW5mQ0ZlPjxTaWduYXR1cmUgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxTaWduZWRJbmZvPjxDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvQ2Fub25pY2FsaXphdGlvbk1ldGhvZD48U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiI+PC9TaWduYXR1cmVNZXRob2Q+PFJlZmVyZW5jZSBVUkk9IiNDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDkwMDk3MjEzOCI+PFRyYW5zZm9ybXM+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIj48L1RyYW5zZm9ybT48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvVHJhbnNmb3JtPjwvVHJhbnNmb3Jtcz48RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxlbmMjc2hhMjU2Ij48L0RpZ2VzdE1ldGhvZD48RGlnZXN0VmFsdWU+dW1MNWpxY2VGY1drZ0NWMDFkMnFnbloyU2Fnckdqbm0yTVJwT1RUdkxJdz08L0RpZ2VzdFZhbHVlPjwvUmVmZXJlbmNlPjwvU2lnbmVkSW5mbz48U2lnbmF0dXJlVmFsdWU+UVNqekpOTllXbTFVdlRvWlcxQWQ1SUE2bzUweEREUkd0Um1wQ24yclhKSUVlWmZpSUEzNFNoZFhZUVBnSjJMOFpFNVQvMXlweFR2Um96YmlsUkxuT1FQSXcrMTdjc3R3NWJkWDFLMVEyZFlSUTFLQlRUbGU3eXdFcEZxL0JDdWJXNVVQQnptOTJWQ1NZUGs4eHB4SGdKNmV6ODRlaTZ6a1RuM3FlQXZmVVdMOCtJbFFYNE5oUUhTcnRmWjJsVnVOaE1xcWZKaWdYSmFGTlUvb0h2QkZLcklVc2FWWEkwaUFBOTRWQzk5SDF5dDdrWGI2UnA0TngvYjZuQU95YlhKbmNZbzN4cGpwa0p4UVl4bndHMFdJUy96d25HcFJHN0loTnV3N29VN2N5TXFHTlBiUEZnekN5OFpLRWpUTHhCU3hvUTdUY0N3ME92MEcyOWFQVVZQZk1RPT08L1NpZ25hdHVyZVZhbHVlPjxLZXlJbmZvPjxYNTA5RGF0YT48WDUwOUNlcnRpZmljYXRlPk1JSUcxakNDQkw2Z0F3SUJBZ0lRTmthMjlqRVRQU2Z1TWZ2eGxOUXE1ekFOQmdrcWhraUc5dzBCQVFzRkFEQm5NUXN3Q1FZRFZRUUdFd0pDVWpFMU1ETUdBMVVFQ2hNc1UyVmpjbVYwWVhKcFlTQmtZU0JHWVhwbGJtUmhJR1J2SUVWemRHRmtieUJrWlNCVFlXOGdVR0YxYkc4eElUQWZCZ05WQkFNVEdFRkRJRk5CVkNCa1pTQlVaWE4wWlNCVFJVWkJXaUJUVURBZUZ3MHhOVEEwTWpJd01EQXdNREJhRncweU1EQTBNVGt5TXpVNU5UbGFNSUhUTVFzd0NRWURWUVFHRXdKQ1VqRVNNQkFHQTFVRUNCTUpVMEZQSUZCQlZVeFBNUkV3RHdZRFZRUUtGQWhUUlVaQldpMVRVREVQTUEwR0ExVUVDeFFHUVVNdFUwRlVNU2d3SmdZRFZRUUxGQjlCZFhSbGJuUnBZMkZrYnlCd2IzSWdRVklnVTBWR1FWb2dVMUFnVTBGVU1Sd3dHZ1lEVlFRTEZCTXhOREk1TnpFM01ETXdNVE0xTmpNeE1ESXhNUkl3RUFZRFZRUUZFd2s1TURBd01ESTFPVEV4TURBdUJnTlZCQU1USjFSQlRrTkJJRWxPUms5U1RVRlVTVU5CSUVWSlVrVk1TVG93T0RjeU16SXhPREF3TURFNE5qQ0NBU0l3RFFZSktvWklodmNOQVFFQkJRQURnZ0VQQURDQ0FRb0NnZ0VCQU5lSm1Ebm9XSldtZHkvNkV0YXVSRE1MenZxZnlnbzJlVm16blh2L1FnL3pVdU5TNU53VUxkaGNWc2dIRjB4U3k4ZE9Ga1hPWHBUaG5YWDdES284eDJNSXFOdGtLUW5Uck9FS2J3ZGt5MHdhajdmQ2xIelBodThEOVoybyt2Um9ycmxiZ1RZRmlROG0yZzhKQWNYU3lGay9Fc1hYUm5CUE9NTktKR0hHOWxkNDkyMG56YU1WakxFbldwZVdNNUtaSnV4eWlCNUhFdnJLUXRzU3BOWHQxQUtwa2d4SGdZOC8wUGxwamp5Zjlmb2NDM2ZURDAwRzRxMEU5K0VNTGhiT0dPRlVNYVE0RzZxMDhJWXZlWHhCSGVCOVU4clIvU1JBRjB1RmxOR2gvM2ZhdUdGYjRFTmxmZjlNalpTUHhLUEtWdTlkSGZwWGdHd1FROENzV1lTTDJ0VUNBd0VBQWFPQ0FnOHdnZ0lMTUNRR0ExVWRFUVFkTUJ1Z0dRWUZZRXdCQXdPZ0VBUU9NRGczTWpNeU1UZ3dNREF4T0RZd0NRWURWUjBUQkFJd0FEQU9CZ05WSFE4QkFmOEVCQU1DQmVBd0h3WURWUjBqQkJnd0ZvQVVqamxCQUZ6eXVBWGFxRzJZdVFGR2JXNWozd0l3YXdZRFZSMGZCR1F3WWpCZ29GNmdYSVphYUhSMGNEb3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2YkdOeUwyRmpjMkYwYzJWbVlYcHpjQzloWTNOaGRITmxabUY2YzNCamNtd3VZM0pzTUhzR0ExVWRJQVIwTUhJd2NBWUpLd1lCQkFHQjdDMERNR013WVFZSUt3WUJCUVVIQWdFV1ZXaDBkSEE2THk5aFkzTmhkQzVwYlhCeVpXNXpZVzltYVdOcFlXd3VZMjl0TG1KeUwzSmxjRzl6YVhSdmNtbHZMMlJ3WXk5aFkzTmhkSE5sWm1GNmMzQXZaSEJqWDJGamMyRjBjMlZtWVhwemNDNXdaR1l3RXdZRFZSMGxCQXd3Q2dZSUt3WUJCUVVIQXdJd2dhY0dDQ3NHQVFVRkJ3RUJCSUdhTUlHWE1GOEdDQ3NHQVFVRkJ6QUNobE5vZEhSd2N6b3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2WTJWeWRHbG1hV05oWkc5ekwyRmpjMkYwTFhSbGMzUmxMbkEzWXpBMEJnZ3JCZ0VGQlFjd0FZWW9hSFIwY0RvdkwyOWpjM0F0Y0dsc2IzUXVhVzF3Y21WdWMyRnZabWxqYVdGc0xtTnZiUzVpY2pBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQWdFQUcwNFlxdFIrZFVmY3cra2MzNWNHdHpUd3l4WnV4TlErdUI3Q2NvNXgwM0I3OE5GZXQ0VFZqaEFWay9hNGVJKzduVUpyRjZ2L1Zxdjd6NFZyckRjV3pJVGptVDIzam5VZ3c3Zjh1K0p0Wk5Nb1MzdlFLRmNLRDZxNHptOVJnZ0pQb1NsdWx0TXJNMDN1MmdnRVJocG4xc3AwK0hackUxaVZNRjY5OGs3WWhWS0szaWtRdWFKVTdlRW1OVjdyRE1iWHFieUJpSHZJcVA5OFNnTWFBbnBDM2V1RWVycUlxQ1dEbmNZbVMranplWWRlV3NMLzUvbXQ1OXhnTDhyYUY1NE80bFNKRE1UREVRYXVZMkZYRmxGeCt2UHRlb1g0STdPUDc5eThjUTJVT3FrQ2E2aFVKUzdjWVNib3RCRFg4dm5aQVZjbWRtc3BrNHFyR3EzUWZXR0pHSDdHT2NKcGgxdmFzOXVoaXhROGxUNmphR0UwTlhqZms4elc2MjdwaE5sNktFL3RIZ2RLUTZMWW4xRkIxN1JsVnhiVy8vK2NocHAzRTNQUTY3dGs5MmxUTExXayt6ZWxLd0lpcXhGSkRhbm01NjZKRUkydlg5SUZxY0FhaXpyd0lQa0o4ZmVkRzQvNzRUemxjUXQ1bmNDa3dyY0dGcjBSTXlJaEJBQ1ZxWkVPZnVNeWgrODdybTFGeDN6QTNoMG5PbHZTeC83N09xazdsNkpmY29tbGVsckFZYmJZbDdNR0t3ZVRWNW5YaHRiZjZGZ3I4bmhEMGZpd3BkL1ZPRWd0Vk0rNnp6QXlsem5XckdJSzB6cENKandYNnZnMHZzQldUS0xzeklEQkY3ODhtOHgxUW9NMC9FZVlTQUR4MEpHTEo5d1p2MVpIVGhYUTF5RnlCWjYrR3ZZPTwvWDUwOUNlcnRpZmljYXRlPjwvWDUwOURhdGE+PC9LZXlJbmZvPjwvU2lnbmF0dXJlPjwvQ0ZlPg==|20160610175636|CFe35160608723218000186599000025910004900972138|10.99|46541673000150|0/H2mUW6I0pqqOoQy3cUYu+AMn1dApVPB7IcIVPlDemf9Li5C+DFPJMAWrxcRDFz0wKFPiLExpLHjL7EKnJz/m4R9yl89ZyW3W10/FusV0QoyyTRjSDTCz6cwfasw0qGMFLJ0Yntl35P0rOvrFq1tOYTAlWVudvV5ZjIXz0LXx0LSB6fIwER/8Ur/GaL8w2S95S2wXpWYVvG4Ym952667QdSh3XTdOQK/Cf7rkXiFvEDS2nfJAUv272O0u8y3goEA8p9s1akNCwPY/CfHtNGEBl95PWYssAEZKtliGH7gstiviMQSQLGGFwte7UCtKnPNbj1JEGqrlSzQjasnVeJqw==
	 * 
	 */
	private String codigoAlerta;
	private String arquivoBase64;
	private String dataHoraTransm;
	private String chaveConsulta;
	private String valorTotal;
	private String cpfCnpjValue;
	private String assinaturaQRCode;
	
	public String getCodigoAlerta() {
		return codigoAlerta;
	}
	public void setCodigoAlerta(String codigoAlerta) {
		this.codigoAlerta = codigoAlerta;
	}
	public String getArquivoBase64() {
		return arquivoBase64;
	}
	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}
	public String getDataHoraTransm() {
		return dataHoraTransm;
	}
	public void setDataHoraTransm(String dataHoraTransm) {
		this.dataHoraTransm = dataHoraTransm;
	}
	public String getChaveConsulta() {
		return chaveConsulta;
	}
	public void setChaveConsulta(String chaveConsulta) {
		this.chaveConsulta = chaveConsulta;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getCpfCnpjValue() {
		return cpfCnpjValue;
	}
	public void setCpfCnpjValue(String cpfCnpjValue) {
		this.cpfCnpjValue = cpfCnpjValue;
	}
	public String getAssinaturaQRCode() {
		return assinaturaQRCode;
	}
	public void setAssinaturaQRCode(String assinaturaQRCode) {
		this.assinaturaQRCode = assinaturaQRCode;
	}
	
	public static RetEnvioVenda getRetorno(String retornoSAT) {
		RetEnvioVenda retVen 	= new RetEnvioVenda();
		String[] listValues 	= toArray(retornoSAT); 
		if(listValues != null){
			//Note: aqui atenderemos tanto o retorno da venda como o do cancelamento
			retVen = (RetEnvioVenda) getDefault(retVen, listValues);
			if(retVen.getCodigoRetSAT().equals("06000")){
				retVen.setCodigoAlerta(listValues[2]);
				retVen.setArquivoBase64(listValues[6]);
				retVen.setDataHoraTransm(listValues[7]);
				retVen.setChaveConsulta(listValues[8]);
				retVen.setValorTotal(listValues[9]);
				retVen.setCpfCnpjValue(listValues[10]);
				retVen.setAssinaturaQRCode(listValues[11]);
			}
		}
		return retVen;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arquivoBase64 == null) ? 0 : arquivoBase64.hashCode());
		result = prime * result + ((assinaturaQRCode == null) ? 0 : assinaturaQRCode.hashCode());
		result = prime * result + ((chaveConsulta == null) ? 0 : chaveConsulta.hashCode());
		result = prime * result + ((codigoAlerta == null) ? 0 : codigoAlerta.hashCode());
		result = prime * result + ((cpfCnpjValue == null) ? 0 : cpfCnpjValue.hashCode());
		result = prime * result + ((dataHoraTransm == null) ? 0 : dataHoraTransm.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetEnvioVenda other = (RetEnvioVenda) obj;
		if (arquivoBase64 == null) {
			if (other.arquivoBase64 != null)
				return false;
		} else if (!arquivoBase64.equals(other.arquivoBase64))
			return false;
		if (assinaturaQRCode == null) {
			if (other.assinaturaQRCode != null)
				return false;
		} else if (!assinaturaQRCode.equals(other.assinaturaQRCode))
			return false;
		if (chaveConsulta == null) {
			if (other.chaveConsulta != null)
				return false;
		} else if (!chaveConsulta.equals(other.chaveConsulta))
			return false;
		if (codigoAlerta == null) {
			if (other.codigoAlerta != null)
				return false;
		} else if (!codigoAlerta.equals(other.codigoAlerta))
			return false;
		if (cpfCnpjValue == null) {
			if (other.cpfCnpjValue != null)
				return false;
		} else if (!cpfCnpjValue.equals(other.cpfCnpjValue))
			return false;
		if (dataHoraTransm == null) {
			if (other.dataHoraTransm != null)
				return false;
		} else if (!dataHoraTransm.equals(other.dataHoraTransm))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}
	
}
