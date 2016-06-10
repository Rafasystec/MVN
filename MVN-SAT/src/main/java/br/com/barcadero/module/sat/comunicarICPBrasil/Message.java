package br.com.barcadero.module.sat.comunicarICPBrasil;

public class Message {
	
	public static String getMessage(int codigo) {
		String message = "";
		switch (codigo) {
		case 5000:
			message = "Certificado transmitido com Sucesso.";
			break;
		case 5001:
			message = "Código de ativação inválido.";
			break;
		case 5002:
			message = "Erro de comunicação com a SEFAZ.";
			break;
		case 5003:
			message = "Certificado Inválido";
			break;
		case 5098:
			message = "SAT em processamento. Tente novamente.";
			break;
		case 5099:
			message = "Erro desconhecido.";
			break;
		default:
			break;
		}
		return message;
	}

}
