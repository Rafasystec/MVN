package br.com.barcadero.module.sat.ativacao;

public class Messages {

	public static String getMessage(int codigo) {
		String msg = "";
		switch (codigo) {
		case 4000:
			msg = "Ativado Corretamente";
			break;
		case 4001:
			msg = "Erro na criação do certificado";
			break;
		case 4002:
			msg = "SEFAZ não reconhece este SAT (CNPJ inválido). Verificar junto a SEFAZ o CNPJ cadastrado.";
			break;
		case 4003:
			msg = "SAT já ativado ou pendente de Vinculação do AC";
			break;
		case 4004:
			msg = "SAT com uso cessado";
			break;
		case 4005:
			msg = "Erro de comunicação com a SEFAZ";
			break;
		case 4006:
			msg = "CSR ICP-BRASIL criado com sucesso";
			break;
		case 4007:
			msg = "Erro na criação do CSR ICP-BRASIL";
			break;
		case 4098:
			msg = "SAT em processamento.Tente novamente.";
			break;
		case 4099:
			msg = "Erro desconhecido na ativação";
			break;
		case 4129:
			msg = "Rejeição: Solicitações emissão de certificados excedidas.";
			break;
		case 4200:
			msg = "Rejeição: Status do equipamento SAT difere do esperado.";
			break;
		case 4219:
			msg = "Rejeição: CNPJ não corresponde ao informado no processo de declaração de posse.";
			break;
		case 4239:
			msg = "Rejeição: Versão do XML não suportada.";
			break;
		case 4241:
			msg = "Rejeição: Diferença de transmissão e recebimento da mensagem superior a 5 minutos.";
			break;
		case 4250:
			msg = "Rejeição: UF informada pelo o SAT não é atendida pelo Web Service.";
			break;
		case 4251:
			msg = "Rejeição: Certificado enviado não confere com o escolhido na declaração de posse.";
			break;
		case 4255:
			msg = "Rejeição: CSR enviado inválido";
			break;
		default:
			break;
		}
		
		return msg;
	}
}
