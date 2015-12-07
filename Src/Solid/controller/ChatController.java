package Solid.controller;

import javax.swing.JOptionPane;

import Solid.model.ChatModel;
import Solid.view.Chat;

public class ChatController {
	public static void main(String[] args) {
		chat();
	}
	
	/*
	 * Criar uma variavel IP e PORTA para cada computador (que serão os
	 * usuarios)
	 */
	
	// Integer IP = 123;
	// Integer PORTA = 123;
	
	private static void chat() {
		String ip = (String) JOptionPane.showInputDialog("Informe o IP", "192.168.0.");
		int porta = Integer.parseInt(JOptionPane.showInputDialog("Informe a Porta", "5000"));
		
		ChatModel c = new ChatModel(ip, porta);
		
		Chat j = new Chat(c);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
	}
}
