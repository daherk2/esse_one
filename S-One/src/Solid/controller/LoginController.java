package Solid.controller;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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
		Random rd = new Random();
		String novasenha = "";		
		String alfabeto[] = {"a","b","C","d","e","F","g","h","i","J","k","l","M","n","o","p","Q","r","s","T","1","2","3","4","5","6","7","8","9"}; 
		for(int i=0; i<6; i++){
			novasenha += alfabeto[rd.nextInt(alfabeto.length)];
		}
		BancoDados su = new BancoDados();
		su.conecta();
		
		String sql = "Update login1 set senha = '"+novasenha+"' WHERE usuario = '"+user+"';";
		//System.out.println(sql);
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
				"<br>Não se esqueça de ALTERAR sua senha no PRÓXIMO USO.</br>"+
				"<br> </br>"+
				"<br>Atenciosamente</br>,<br> Equipe SOLID - Software and Consulting</br>"+
				"</html>");
		
		String corta[] = email.split("@");
		String nickname = corta[0];
		nickname = nickname.replace("a", "*");
		nickname = nickname.replace("e", "*");
		nickname = nickname.replace("i", "*");
		nickname = nickname.replace("o", "*");
		nickname = nickname.replace("u", "*");
		nickname = nickname.replace("_", "*");
		nickname = nickname.replace(".", "*");
		JOptionPane.showMessageDialog(null, "Prezado "+user+",\n"+"Verifique seu email : "+nickname+"@"+corta[1]+".\n Enviamos uma nova senha para seu acesso.");
		
	}
	
}
