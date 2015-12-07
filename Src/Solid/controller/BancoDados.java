package Solid.controller;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class BancoDados {
	
	// variáveis para conexão
	
	static Connection			con;									// conexão
	static Statement			stmt;								// Gravar
	static ResultSet			rs;									// Consulta
	static String			url		= "jdbc:mysql://localhost:3306/solid_one";	// banco
															// de
															// dados
	static String			user		= "root";						// usuario
	static String			password	= "f1234567";						// senha
	static String			driver	= "com.mysql.jdbc.Driver";			//
															
	public static JRadioButton	onoff;
	
	public static void conecta() {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/solid_one", "root", "f1234567");
			stmt = con.createStatement();
			System.out.printf("Conexão com o Banco de Dados estabelecida com sucesso!",
					"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
			
		}
		catch (Exception e) {
			
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,
					"Não foi possível conectar o Banco de Dados!", "Erro",
					JOptionPane.ERROR_MESSAGE);
			JOptionPane.showConfirmDialog(null, e);
		}
	}
	
	public static void desconecta() {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		try {
			
			con.close();
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, " O BD foi desconectado com sucesso !",
					"Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
			
		}
		catch (Exception e) {
			
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,
					"Não foi possível conectar o Banco de Dados!", "Erro",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showConfirmDialog(null, e);
		}
	}
	
	public void grava(String texto) {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		try {
			
			stmt = con.createStatement();
			stmt.execute(texto);
			
			// JOptionPane.showMessageDialog(null," Dados Salvos com sucesso!",
			// "Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
			
		}
		catch (SQLException erro) {
			
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Erro no comando SQL" + erro.getMessage(),
					"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public ResultSet Consultar(String comandosql) {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(comandosql);
			return rs;
		}
		catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null, "Erro no comando SQL" + erro.getMessage(),
					"Mensagem do Sistema", JOptionPane.ERROR_MESSAGE);
			
			System.exit(0);
			return null;
		}
		
	}
	
	public void DeletaDados(String SQL) {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BancoDados.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		try {
			
			stmt.execute(SQL);
			
		}
		catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "ERRO:" + e.getMessage());
		}
	}
}