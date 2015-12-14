package Solid.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Solid.controller.BancoDados;
import Solid.controller.Metodos;
import javax.swing.JSeparator;

public class UserSenha extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long	serialVersionUID	= 1L;

	// instancia a classe do banco para conexão
	static BancoDados					x				= new BancoDados();

	// variaveis do sistema
	private JPanel				tabbedPaneAlterarSenha;
	private JTextField			textUsuario;
	private JPasswordField		textSenha;
	int						v				= 0;

	// variaveis que receberão a nova senha e novo usuario
	String					novaSenha;

	public UserSenha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				UserSenha.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setBackground(SystemColor.inactiveCaptionBorder);
		setVisible(true);
		setName("mudar senha");
		setResizable(false);
		setTitle("ALTERAR SENHA");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 460);

		/*
		 * 
		 * Panel Alterar Senha
		 */

		tabbedPaneAlterarSenha = new JPanel();
		tabbedPaneAlterarSenha.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPaneAlterarSenha.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabbedPaneAlterarSenha);
		tabbedPaneAlterarSenha.setLayout(null);

		textUsuario = new JTextField();
		textUsuario.setSelectionColor(SystemColor.scrollbar);
		textUsuario.setDisabledTextColor(SystemColor.textText);
		textUsuario.setFont(new Font("Kalinga", Font.PLAIN, 14));
		textUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		textUsuario.setBounds(380, 109, 250, 32);
		tabbedPaneAlterarSenha.add(textUsuario);
		textUsuario.setColumns(10);

		textSenha = new JPasswordField();
		textSenha.setSelectionColor(SystemColor.scrollbar);
		textSenha.setDisabledTextColor(SystemColor.textText);
		textSenha.setFont(new Font("Kalinga", Font.PLAIN, 14));
		textSenha.setHorizontalAlignment(SwingConstants.CENTER);
		textSenha.setBounds(380, 186, 250, 32);
		textSenha.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (Toolkit.getDefaultToolkit().getLockingKeyState(java.awt.event.KeyEvent.VK_CAPS_LOCK)) {

					JOptionPane.showMessageDialog(null, "CAPS LOCK ATIVADO!");
					textSenha.setText(null);
				}
			}
		});
		tabbedPaneAlterarSenha.add(textSenha);

		textSenha.setColumns(10);

		// bot�o voltar
		JButton Voltar = new JButton("Inicio");
		Voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Voltar.setBorder(null);
		Voltar.setMnemonic(KeyEvent.VK_BACK_SPACE);
		Voltar.setForeground(new Color(0, 0, 0));
		Voltar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Voltar.setIcon(new ImageIcon(UserSenha.class.getResource("/icones1_24px/1425606621_678085-house-128.png")));
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserSenha.this.setVisible(false);
				new Login().setVisible(true);

			}
		});
		Voltar.setBounds(380, 269, 120, 40);
		tabbedPaneAlterarSenha.add(Voltar);

		// bot�o atualizar
		JButton Atualizar = new JButton("Atualizar");
		Atualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Atualizar.setBorder(null);
		Atualizar.setIcon(new ImageIcon(UserSenha.class
				.getResource("/icones1_24px/1425606696_678121-cloud-sync-128.png")));
		Atualizar.setForeground(new Color(0, 0, 0));
		Atualizar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Atualizar.setMnemonic(KeyEvent.VK_ENTER);
		Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//UserSenha.EnviarEmail();
				JOptionPane.showMessageDialog(null, "Dentro de instantes você receberá um e-mail com uma nova senha.","Mensagem do sistema",JOptionPane.INFORMATION_MESSAGE);
				UserSenha.this.setVisible(false);
				new Login().setVisible(true);
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodos.formWindowClosing(null);
			}
		});
		btnSair.setIcon(new ImageIcon(UserSenha.class.getResource("/icones1_24px/desliga24px.png")));
		btnSair.setMnemonic(KeyEvent.VK_BACK_SPACE);
		btnSair.setForeground(new Color(0, 0, 0));
		btnSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btnSair.setBorder(null);
		btnSair.setBounds(511, 269, 120, 40);
		tabbedPaneAlterarSenha.add(btnSair);
		Atualizar.setActionCommand("Atualizar");
		Atualizar.setBounds(381, 316, 250, 40);
		tabbedPaneAlterarSenha.add(Atualizar);
		
		JButton button = new JButton("Visualizar Senha");
		button.setIcon(new ImageIcon(UserSenha.class.getResource("/icones1_24px/1425606561_search-128.png")));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Dialog", Font.PLAIN, 12));
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(380, 229, 138, 24);
		tabbedPaneAlterarSenha.add(button);

		JLabel Usuario = new JLabel("Usuario *");
		Usuario.setHorizontalTextPosition(SwingConstants.CENTER);
		Usuario.setIcon(null);
		Usuario.setForeground(new Color(0, 0, 0));
		Usuario.setFont(new Font("Kalinga", Font.BOLD, 14));
		Usuario.setBounds(381, 75, 82, 32);
		tabbedPaneAlterarSenha.add(Usuario);

		JLabel Senha = new JLabel("Senha *");
		Senha.setHorizontalTextPosition(SwingConstants.CENTER);
		Senha.setIcon(null);
		Senha.setForeground(new Color(0, 0, 0));
		Senha.setFont(new Font("Kalinga", Font.BOLD, 14));
		Senha.setBounds(381, 155, 59, 32);
		tabbedPaneAlterarSenha.add(Senha);

		JLabel img = new JLabel("");
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setIcon(new ImageIcon(UserSenha.class.getResource("/icones1_32px/1425606610_678099-profile-filled-128.png")));
		img.setBounds(640, 109, 32, 32);
		tabbedPaneAlterarSenha.add(img);

		JLabel img_1 = new JLabel("");
		img_1.setIcon(new ImageIcon(UserSenha.class.getResource("/icones1_32px/1425606776_678115-lock-open-128.png")));
		img_1.setBounds(640, 186, 32, 32);
		tabbedPaneAlterarSenha.add(img_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UserSenha.class.getResource("/logos_solid/LogoPSemFundo.png")));
		label.setBounds(63, 169, 250, 93);
		tabbedPaneAlterarSenha.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(339, 55, 1, 315);
		tabbedPaneAlterarSenha.add(separator);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setIcon(new ImageIcon(UserSenha.class.getResource("/papel_parede/low-poly-texture-6.png")));
		lblNewLabel.setBounds(0, 0, 754, 429);
		tabbedPaneAlterarSenha.add(lblNewLabel);

		// janelza centralizada
		this.setLocationRelativeTo(null);
	}

	protected static void EnviarEmail() {
		Properties props = new Properties();

		/** Par�metros de conex�o com servidor Gmail */
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("solid.brasil1@gmail.com@gmail.com", "solid321");
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		// pergunta de segurança
		JOptionPane.showMessageDialog(null, "Informe seu CPF", "Atenção", JOptionPane.INFORMATION_MESSAGE);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("solid.brasil1@gmail.com")); // Remetente

			Address[] toUser = InternetAddress // Destinat�rio(s)
					.parse("heliomsolivas@gmail.com, ontemeucomi.arroz@hotmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);

			message.setSubject("SOLID ERP: Recuperação de senha!! ");// Assunto
			message.setText("Foi solicitado uma nova senha p/ acesso ao Software!"); // Mensagem

			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!!", null,
					JOptionPane.INFORMATION_MESSAGE);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}