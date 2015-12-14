package Solid.view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ajuda extends JFrame {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1908718949326704455L;

	public JPanel            contentPaneAjuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajuda frame = new Ajuda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ajuda() {
		setResizable(false);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
		            Ajuda.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));

		setTitle("AJUDA");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(187, 71, 350, 350);
		contentPaneAjuda = new JPanel();
		contentPaneAjuda.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAjuda);
		contentPaneAjuda.setLayout(null);

		JTextArea txtrLoremIpsumDolor = new JTextArea();
		txtrLoremIpsumDolor.setOpaque(false);
		txtrLoremIpsumDolor
		            .setText("\r\nO Solid One ERP visa implementar \r\ntodas as ferramentas necessárias para uma\r\nboa gestão de negócio a um custo \r\ntotalmente acessivel ao pequeno \r\ne médio empresário.\r\n \r\n\t                 tel: 3144-7070\r\n\r\n");
		txtrLoremIpsumDolor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		txtrLoremIpsumDolor.setEditable(false);
		txtrLoremIpsumDolor.setBounds(24, 67, 296, 185);
		contentPaneAjuda.add(txtrLoremIpsumDolor);

		JSeparator separator = new JSeparator();
		separator.setBounds(22, 264, 300, 2);
		contentPaneAjuda.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 53, 300, 2);
		contentPaneAjuda.add(separator_1);

		JLabel label = new JLabel("Como Podemos Ajudar?");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Khmer UI", Font.BOLD, 14));
		label.setBounds(22, 11, 300, 32);
		contentPaneAjuda.add(label);

		JLabel lblAbrirFacebook = new JLabel("");
		lblAbrirFacebook.setDisplayedMnemonic(KeyEvent.VK_1);
		lblAbrirFacebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ajuda.abrirFacebook();
			}
		});
		lblAbrirFacebook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbrirFacebook.setIcon(new ImageIcon(Ajuda.class
		            .getResource("/icones1_32px/1425606726_678128-social-facebook-128.png")));
		lblAbrirFacebook
		            .setToolTipText("https://www.facebook.com/pages/SOLID-ERP/307309042789247?fref=ts");
		lblAbrirFacebook.setBounds(30, 277, 32, 32);
		contentPaneAjuda.add(lblAbrirFacebook);

		JLabel lblAbrirGoogle = new JLabel("");
		lblAbrirGoogle.setDisplayedMnemonic(KeyEvent.VK_2);
		lblAbrirGoogle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ajuda.abrirGoogle();
			}
		});
		lblAbrirGoogle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbrirGoogle
		            .setIcon(new ImageIcon(
		                        Ajuda.class.getResource("/icones1_32px/1425606820_678083-social-google-plus-128.png")));
		lblAbrirGoogle
		            .setToolTipText("https://plus.google.com/u/1/105763078862390055188/about");
		lblAbrirGoogle.setBounds(92, 277, 32, 32);
		contentPaneAjuda.add(lblAbrirGoogle);

		JLabel lblAbrirSite = new JLabel("");
		lblAbrirSite.setDisplayedMnemonic(KeyEvent.VK_3);
		lblAbrirSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ajuda.abrirSite();
			}
		});
		lblAbrirSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbrirSite.setIcon(new ImageIcon(Ajuda.class
		            .getResource("/icones1_32px/1425606628_globe-128.png")));
		lblAbrirSite.setToolTipText("http://www.soliderp.16mb.com");
		lblAbrirSite.setBounds(154, 277, 32, 32);
		contentPaneAjuda.add(lblAbrirSite);

		JLabel lblAbrirEmail = new JLabel("");
		lblAbrirEmail.setDisplayedMnemonic(KeyEvent.VK_4);
		lblAbrirEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ajuda.abrirEmail();
			}
		});
		lblAbrirEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbrirEmail.setIcon(new ImageIcon(Ajuda.class
		            .getResource("/icones1_32px/1425606717_enveloppe-alt-128.png")));
		lblAbrirEmail.setToolTipText("solid.brasil1@gmail.com | atendimento@soliderp.16mb.com");
		lblAbrirEmail.setBounds(216, 277, 32, 32);
		contentPaneAjuda.add(lblAbrirEmail);

		JLabel lblAbrirYoutube = new JLabel("");
		lblAbrirYoutube.setDisplayedMnemonic(KeyEvent.VK_5);
		lblAbrirYoutube.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ajuda.abrirYoutube();
			}
		});
		lblAbrirYoutube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAbrirYoutube.setIcon(new ImageIcon(Ajuda.class
		            .getResource("/icones1_32px/1425606645_678098-social-youtube-128.png")));
		lblAbrirYoutube
		            .setToolTipText("https://www.youtube.com/channel/UCp5ARZYDALSJo8NYO38viJA");
		lblAbrirYoutube.setBounds(278, 277, 32, 32);
		contentPaneAjuda.add(lblAbrirYoutube);

		this.setLocationRelativeTo(null);

	}

	protected static void abrirFacebook() {
		// TODO Auto-generated method stub
		try {
			java.awt.Desktop
			            .getDesktop()
			            .browse(new java.net.URI(
			                        "https://www.facebook.com/pages/SOLID-ERP/307309042789247"));
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected static void abrirSite() {
		// TODO Auto-generated method stub
		try {
			java.awt.Desktop.getDesktop().browse(
			            new java.net.URI("http://soliderp.16mb.com/"));
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected static void abrirEmail() {
		// TODO Auto-generated method stub
		try {
			java.awt.Desktop
			            .getDesktop()
			            .browse(new java.net.URI(
			                        "http://webmail1.hostinger.com.br/squirrelmail/src/webmail.php"));
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected static void abrirGoogle() {
		// TODO Auto-generated method stub
		try {
			java.awt.Desktop
			            .getDesktop()
			            .browse(new java.net.URI(
			                        "https://plus.google.com/u/1/105763078862390055188/posts"));
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	protected static void abrirYoutube() {
		// TODO Auto-generated method stub
		try {
			java.awt.Desktop
			            .getDesktop()
			            .browse(new java.net.URI(
			                        "https://www.youtube.com/channel/UCp5ARZYDALSJo8NYO38viJA?view_as=subscriber"));
		}
		catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}