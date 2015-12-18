package Solid.controller;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class MailSender{

	public void enviar(String para, String nome, String titulo, String conteudo ) throws EmailException{

		final String username = "email"; 
		final String password = "senha";

		String texto = "";

		MultiPartEmail email = new MultiPartEmail();  
		email.setHostName("smtps.bol.com.br");  

		email.addTo(para, nome); 
		email.setSmtpPort(465);  
		email.setFrom(username, "SOLID ERP  S-ONE");
		email.setSubject(titulo);

		texto = "";
		texto += conteudo;
		email.setMsg(texto);

		email.setAuthentication(username, password);
		email.setSSL(true);  
		email.setTLS(true);  

		email.send();


		System.out.println("Email enviado!");     
	}
}