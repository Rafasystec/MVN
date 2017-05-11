package br.com.barcadero.commons.mail;

import br.com.barcadero.commons.util.HandleDateHour;

public class Sender {

	private ISender iSender;
	
	public Sender() {
		// TODO Auto-generated constructor stub
		iSender = new SenderMail();
		iSender.setPassword("rafa1>rafa2");
		iSender.setUserName("petshow@barcadero.com.br");
		iSender.setHostEmail("mail.barcadero.com.br");
		iSender.setSmtpPort(587);
	}
	
	public static void main(String[] args) {
		Sender sender = new Sender();
		try {

			sender.send("EMAIL PETSHOW TESTE \n Dia: " + HandleDateHour.getCurrentDay(), "PET SHOW TEST", "petshow@barcadero.com.br", "contato@barcadero.com.br");
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String content, String subject, String from, String to) throws MailException{
		iSender.sendEmail(content, subject, from, to);
	}

}
