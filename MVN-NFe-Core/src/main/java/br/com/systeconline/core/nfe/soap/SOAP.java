package br.com.systeconline.core.nfe.soap;

public class SOAP {
	
	public static String getMessageEnveloped(String versaoDados, String nfedadosXml) throws Exception{
		
		try {
			return getEnveloper(versaoDados, nfedadosXml);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public static String getEnveloper(String versaoDados, String nfedadosXml) {
		StringBuilder enveloper = new StringBuilder();
		enveloper.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		enveloper.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance");
		enveloper.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema");
		enveloper.append("xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
		enveloper.append("<soap12:Header>");
		enveloper.append("<nfeCabecMsg xmlns=\"http://www.portalfiscal.inf.br/sce/wsdl/NfeRecepcao2\">");
		enveloper.append("<versaoDados>").append(versaoDados).append("</versaoDados>");
		enveloper.append("</nfeCabecMsg>");
		enveloper.append("</soap12:Header><soap12:Body>");
		enveloper.append("<nfeRecepcao xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao2\">");
		enveloper.append("<nfeDadosMsg>").append(nfedadosXml).append("</nfeDadosMsg>");
		enveloper.append("</nfeRecepcao>");
		enveloper.append("</soap12:Body></soap12:Envelope>");
		return enveloper.toString();
	}
}
