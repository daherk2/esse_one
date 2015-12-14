package Solid.view;

import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;

import Solid.controller.BancoDados;
import Solid.model.ChatModel;

public class Chat extends javax.swing.JFrame implements Observer {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long serialVersionUID = -3323758574309285724L;

	// instancia a classe do banco para conexão
	BancoDados                x                = new BancoDados();

	private ChatModel         conexao;

	public Chat(ChatModel conexao) {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
		            Chat.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setTitle("CHAT");
		setName("chat");

		setResizable(false);
		this.conexao = conexao;
		initComponents();
		conexao.addObserver(this);
		escreve("Chat iniciado com " + conexao.getIp() + ":" + conexao.getPorta());
		mensagemjTextArea.requestFocusInWindow();
	}

	private void envia() {
		if (!mensagemjTextArea.getText().isEmpty()) {
			conexao.envia(mensagemjTextArea.getText());
			escreve("Você disse: " + mensagemjTextArea.getText());
			mensagemjTextArea.setText("");
		}
	}

	private void escreve(String texto) {
		chatjTextArea.append(texto + "\n");
		if (!chatjTextArea.getText().isEmpty() && !chatjTextArea.isFocusOwner()) {
			chatjTextArea.setCaretPosition(chatjTextArea.getText().length() - 1);
		}

	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		chatjTextArea = new javax.swing.JTextArea();
		chatjTextArea.setBackground(SystemColor.inactiveCaptionBorder);
		chatjTextArea.setWrapStyleWord(true);
		chatjTextArea.setEditable(false);
		jScrollPane2 = new javax.swing.JScrollPane();
		mensagemjTextArea = new javax.swing.JTextArea();
		mensagemjTextArea.setSelectionColor(SystemColor.scrollbar);
		mensagemjTextArea.setWrapStyleWord(true);
		enviarjButton = new javax.swing.JButton();
		enviarjButton.setToolTipText("alt + Enter");
		enviarjButton.setIcon(new ImageIcon(Chat.class
		            .getResource("/icones1_24px/1425606546_678134-sign-check-128.png")));
		enviarjButton.setBorder(null);
		enviarjButton.setMnemonic(KeyEvent.VK_ENTER);
		enviarjButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chatjTextArea.setColumns(20);
		chatjTextArea.setRows(5);
		jScrollPane1.setViewportView(chatjTextArea);

		mensagemjTextArea.setColumns(20);
		mensagemjTextArea.setRows(5);
		mensagemjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				mensagemjTextAreaKeyReleased(evt);
			}
		});
		jScrollPane2.setViewportView(mensagemjTextArea);

		enviarjButton.setText("Enviar");
		enviarjButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enviarjButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
		            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addComponent(jScrollPane1)
		            .addGroup(layout
		                        .createSequentialGroup()
		                        .addComponent(jScrollPane2,
		                                    javax.swing.GroupLayout.PREFERRED_SIZE, 386,
		                                    javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(
		                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addComponent(enviarjButton,
		                                    javax.swing.GroupLayout.DEFAULT_SIZE, 75,
		                                    Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
		            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
		            .addGroup(layout
		                        .createSequentialGroup()
		                        .addComponent(jScrollPane1,
		                                    javax.swing.GroupLayout.PREFERRED_SIZE, 349,
		                                    javax.swing.GroupLayout.PREFERRED_SIZE)
		                        .addPreferredGap(
		                                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
		                        .addGroup(layout
		                                    .createParallelGroup(
		                                                javax.swing.GroupLayout.Alignment.LEADING,
		                                                false)
		                                    .addComponent(jScrollPane2)
		                                    .addComponent(enviarjButton,
		                                                javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                javax.swing.GroupLayout.DEFAULT_SIZE,
		                                                Short.MAX_VALUE))
		                        .addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void enviarjButtonActionPerformed(java.awt.event.ActionEvent evt) {
		envia();
	}

	private void mensagemjTextAreaKeyReleased(java.awt.event.KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			envia();
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JTextArea   chatjTextArea;
	private javax.swing.JButton     enviarjButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea   mensagemjTextArea;

	// End of variables declaration

	@Override
	public void update(Observable o, Object arg) {
		escreve(conexao.getMensagem());
	}
}