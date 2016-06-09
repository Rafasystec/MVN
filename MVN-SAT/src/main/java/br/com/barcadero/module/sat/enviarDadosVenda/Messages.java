package br.com.barcadero.module.sat.enviarDadosVenda;

public class Messages {

	public static String getMessage(int codigo) {
		String message = "";
		switch (codigo) {
		case 6000:
			message = "Emitido com sucesso + conteúdo notas.";
			break;
		case 6001:
			message = "Código de ativação inválido.";
			break;
		case 6002:
			message = "SAT ainda não Ativado.";
			break;
		case 6003:
			message = "SAT não vinculado ao AC";
			break;
		case 6004:
			message = "Vinculação do AC não confere.";
			break;
		case 6005:
			message = "Tamanho do CF-e-SAT superior a 1.500KB";
			break;
		case 6006:
			message = "SAT bloqueado pelo contribuinte.";
			break;
		case 6007:
			message = "SAT bloqueado pela SEFAZ.";
			break;
		case 6008:
			message = "SAT bloqueado por falta de comunicação.";
			break;
		case 6009:
			message = "SAT bloqueado, código de ativação incorreto.";
			break;
		case 6010:
			message = "Erro de validação do conteúdo";
			break;
		case 6098:
			message = "SAT em processamento. Tente novamente";
			break;
		case 6099:
			message = "Erro desconhecido na emissão.";
			break;
		default:
			break;
		}
		return message;
	}
}
