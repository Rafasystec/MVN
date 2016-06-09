package br.com.barcadero.module.sat.cancelamentoVenda;

public class Messages {
	
	public static String getMessage(int codigo) {
		String message = "";
		switch (codigo) {
		case 7000:
			message = "Cupom cancelado com sucesso + conteúdo CF-e-SAT cancelado.";
			break;
		case 7001:
			message = "Código ativação inválido.";
			break;
		case 7002:
			message = "Cupom inválido.";
			break;
		case 7003:
			message = "SAT bloqueado pelo contribuinte.";
			break;
		case 7004:
			message = "SAT bloqueado pela SEFAZ";
			break;
		case 7005:
			message = "SAT bloqueado por falta de comunicação.";
			break;
		case 7006:
			message = "SAT bloqueado, código de ativação incorreto.";
			break;
		case 7007:
			message = "Erro de validação de conteúdo";
			break;
		case 7098:
			message = "SAT em processamento. Tente novamente.";
			break;
		case 7099:
			message = "Erro desconhecido no cancelamento.";
			break;
		default:
			break;
		}
		return message;
	}

}
