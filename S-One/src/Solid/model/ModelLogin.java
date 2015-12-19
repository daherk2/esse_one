package Solid.model;

import Solid.controller.*;
import Solid.view.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class ModelLogin {
	
	private static String usuario;
	private static String senha;	
	static BancoDados x	= new BancoDados();
	
	public static String getUsuario() {
		return Login.cusuario.getText();
	}
	public static void setUsuario(String usuario) {
		 Login.cusuario.setText(usuario);
	}
	public static String getSenha() {
		return   Login.csenha.getText();
	}
	public static void setSenha(String senha) {
		 Login.csenha.setText(senha);
	}	
}
