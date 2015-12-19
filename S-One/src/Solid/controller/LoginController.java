package Solid.controller;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Solid.model.ModelLogin;
import Solid.view.*;

public class LoginController {
	static Solid.controller.BancoDados	x = new Solid.controller.BancoDados();
	public static boolean janela=false;
	static SimpleDateFormat	simpleDate;
	
	public static void IniciarLogin(){
		new Login();
				
	}
	
@SuppressWarnings("deprecation")
	public static void verificarSenha(){
		
		BancoDados.conecta();

		String usuario = ModelLogin.getUsuario();
		String senha = ModelLogin.getSenha();

		ResultSet dadosl = x.Consultar(" select * from login1 where usuario = '" + ModelLogin.getUsuario()
				+ "' and senha = '" + ModelLogin.getSenha() + "'");
		try {
			dadosl.next();			
			simpleDate = new SimpleDateFormat("HH:mm:ss");			

			String manha = ("12");
			String tarde = ("18");			 
			
			Date Agora= new Date();
			System.out.println(Agora.getHours());
			// compara o que o usuario digitou com os dados do
			// banco
			if (usuario.equals(dadosl.getString("usuario")) && senha.equals(dadosl.getString("senha"))) {		
				
				janela=true;
				// compara o horário do computador com o horario estabelecido
				MenuController.AbrirMenu();
				
				if (Agora.getHours() < Long.parseLong(manha)){
					JOptionPane.showMessageDialog(null, "Bom Dia, \nSeja bem-vindo sr(a) "
							+ ModelLogin.getUsuario(), "Boas Vindas", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if (Agora.getHours() >= Long.parseLong(manha) && Agora.getHours() <= Long.parseUnsignedLong(tarde)) {
					JOptionPane.showMessageDialog(null, "Boa Tarde, \nSeja bem-vindo sr(a) "+ ModelLogin.getUsuario(), "Boas Vindas", JOptionPane.INFORMATION_MESSAGE);
				}

				else if (Agora.getHours() > Long.parseLong(tarde)) {
					JOptionPane.showMessageDialog(null, "Boa Noite, \nSeja bem-vindo sr(a) "
							+ ModelLogin.getUsuario(), "Boas Vindas", JOptionPane.INFORMATION_MESSAGE);
				} 

				
			
			} else {
				JOptionPane.showMessageDialog(null, "Usuario e/ou Senha incorretos!!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				Login.cusuario.requestFocus();
				Login.cusuario.setText(null);
				Login.csenha.setText(null);
				janela=false;
			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Usuario e/ou Senha incorretos!!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			Login.cusuario.requestFocus();
			Login.cusuario.setText(null);
			Login.csenha.setText(null);
			
		}
		
	}



	public static void Esqueci(){
		
		String user = Login.cusuario.getText();
				
		BancoDados su = new BancoDados();
		su.conecta();
		String novasenha = "ontem";
		String sql = "Update login1 set senha = '"+novasenha+"' WHERE usuario = '"+user+"';";
		System.out.println(sql);
		su.grava(sql);
		//su.desconecta();
		
		BancoDados as = new BancoDados();
		as.conecta();
		String email = "";
		String comandosql = "SELECT * FROM login1 where usuario = '"+user+"'";
		ResultSet rest = as.Consultar(comandosql);
		try{
			rest.beforeFirst();
			while(rest.next()){
			//String var[] = rest.getString("referente").split(",");
			email = rest.getString("email");	
			}
			//as.desconecta();
		}catch(SQLException ert){}	
		
		MailSender ms = new MailSender();
		ms.enviar(email, user, "Recuparação de Senha",
				"<html><br>Prezado "+user+""+",</br>"+
				"<br>Sua senha foi alterada para: "+novasenha+" .</br>"+
				"<br> </br>"+
				"<br>Atenciosamente</br>,<br> Equipe SOLID - Software and Consulting</br>"+
				"</html>");
		
		
		
	}
	
}
