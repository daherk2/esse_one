package Solid.model;

import Solid.controller.BancoDados;
import Solid.view.Login;

@SuppressWarnings("unused")
public class ModelLogin {
	
	private static String	usuario;
	private static String	senha;
	static BancoDados		x	= new BancoDados();
	
	public static String getUsuario() {
		return Login.textUsuario.getText();
	}
	
	public static void setUsuario(String usuario) {
		Login.textUsuario.setText(usuario);
	}
	
	public static String getSenha() {
		return Login.passwordField.getText();
	}
	
	public static void setSenha(String senha) {
		Login.passwordField.setText(senha);
	}
}
