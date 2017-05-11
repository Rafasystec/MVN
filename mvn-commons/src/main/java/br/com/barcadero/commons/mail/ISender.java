package br.com.barcadero.commons.mail;

import javax.mail.Session;

public interface ISender {
	
	public void sendEmail(String content,String subject, String from, String to)throws MailException;
    public Session configure()throws MailException;
    public void setPassword (String value);
	public void setUserName (String value);
	public void setHostEmail(String value);
	public void setSmtpPort (int value);
}
