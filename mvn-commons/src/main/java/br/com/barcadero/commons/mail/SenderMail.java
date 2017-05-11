package br.com.barcadero.commons.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * @author Rafael Rocha
 *
 */
class SenderMail implements ISender {

	private String fromEmail;
	private String destinationEmail;
	private String password;
	private String userName;
	private String hostEmail;
	private Session sessionEmail;
	private int smtpPort = 25;
	
	/**
	 * Send a message email.
	 * @param content : Conteudo do email
	 * @param subject : Assunto do email
	 * @param from : email de origente (remetente)
	 * @param to : email de destino (destinatario)
	 * @throws MailException
	 */
	public void sendEmail(String content, String subject,  String from, String to) throws MailException {
		// TODO Auto-generated method stub
		setFromEmail(from);
		setDestinationEmail(to);
		Message message = new MimeMessage(configure());
		try {
			//TODO: Set From: header field of the header.
			message.setFrom(new InternetAddress(getFromEmail()));
			//TODO: Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(getDestinationEmail()));
			//TODO: Set Subject: header field
			message.setSubject(subject);
			//TODO: Now set the actual message
			message.setText(content);
			//TODO: Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new MailException("Erro ao tentar enviar email para : " + getDestinationEmail() + " > " + e.getMessage());
		}

	}

	/**
	 * Realiza a configuração do email.
	 */
	public Session configure() throws MailException {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", getHostEmail());
		props.put("mail.smtp.port", getSmtpPort());
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(getUserName(), getPassword());
					}
				});
		
		setSessionEmail(sessionEmail);
		return session;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getDestinationEmail() {
		return destinationEmail;
	}

	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHostEmail() {
		return hostEmail;
	}

	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}

	public Session getSessionEmail() {
		return sessionEmail;
	}

	public void setSessionEmail(Session sessionEmail) {
		this.sessionEmail = sessionEmail;
	}

	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
	}

}
