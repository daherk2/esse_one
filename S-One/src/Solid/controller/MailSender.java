package Solid.controller;



import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
//import org.apache.commons.mail.SimpleEmail;

public class MailSender{

	public void enviar(String para, String nome, String titulo, String conteudo ) {

		final String username = "sebastiaoqlz1234@bol.com.br"; 
		final String password = "q1234567890";

		
		HtmlEmail email = new HtmlEmail(); 
		email.setHostName("smtps.bol.com.br");  

		try {
			email.addTo(para, nome);
		
		email.setSmtpPort(587);  
		
			email.setFrom(username, "SOLID ERP  S-ONE");
		
		email.setSubject(titulo);

		email.setHtmlMsg(conteudo);		

		email.setAuthentication(username, password);
		email.setSSL(false);  
		email.setTLS(false);  

		
		email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Email enviado!");     
	}
}