package Solid.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.EdgedBalloonStyle;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

@SuppressWarnings("unused")
public class ConfiguraçãoSoftware extends JFrame {

    /**
     * 
     * @author Rafael Miranda
     * @author Luiz Gustavo Silvestre
     * @author Silvio Luiz
     * @author Jhone Eleuterio
     * @author Sandra Correa
     * @author Gleice Maiara
     * 
     */

    private static final long       serialVersionUID = 2611013467580060132L;

    static byte		     tamanhomatriz;
    static String[][]	       matriz;
    public static DefaultTableModel modelo;
    static DefaultTableCellRenderer central	  = new DefaultTableCellRenderer();
    JLabel			  lblAbrir;
    JLabel			  lblEmail;
    JLabel			  lblCobrança;
    JLabel			  lblEstágio;
    JLabel			  lblFecharSistema;
    JSeparator		      separator1, separator2;
    private JLabel		  lblBancoDados;
    private JLabel		  lblUpdate;
    private JSeparator	      separator3;
    private JPanel		  panel1;
    private JTextField txtContato;
    private JLabel lblIconeSenha;
    private JLabel lblSenha;
    private JPasswordField txtSenha;
    private JTextField txt1;
    private JTextField txt2;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JPanel panel3;
    private JTextField txtURLServidor;
    private JPasswordField passwordField;
    private JLabel lblUrlDoServidor;
    private JLabel lblIcone1;
    private JLabel lblIcone3;
    private JLabel lblNomeDoBanco;
    private JButton btSalvar3;
    private JButton btCancelar3;
    private JTextField txtNomeBanco;
    private JLabel lblNomeDoBanco_1;
    private JTextField txtPortaAcesso;
    private JLabel lblPortaDeAcesso;
    private JLabel lblIcone4;
    private JLabel lblIcone2;
    private JPanel panel4;
    private JButton btSalvar4;
    private JButton btCancelar4;
    private JLabel lblReceberAtualizaesAutomticamente;
    private JLabel lblIcone;



    public ConfiguraçãoSoftware() {

	super();
	setUndecorated(true);

	setFocusCycleRoot(false);
	setIconImage(Toolkit.getDefaultToolkit().getImage(ConfiguraçãoSoftware.class.getResource("/logotipo/logo48.png")));
	setResizable(false);

	setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	setName("");

	Toolkit toolkit = Toolkit.getDefaultToolkit();

	setTitle("SOLID Map");
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	getContentPane().setBackground(Color.WHITE);

	lblFecharSistema = new JLabel("SAIR");
	lblFecharSistema.setBounds(1308, 0, 48, 70);
	lblFecharSistema.setForeground(new Color(119, 136, 153));
	lblFecharSistema.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblFecharSistema.setHorizontalTextPosition(SwingConstants.CENTER);
	lblFecharSistema.setFont(new Font("Verdana", Font.BOLD, 11));
	lblFecharSistema.setToolTipText("Sair do Programa");
	lblFecharSistema.setHorizontalAlignment(SwingConstants.CENTER);
	lblFecharSistema.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		System.exit(0);
		// Menu.this.dispose();
	    }
	});
	getContentPane().setLayout(null);
	
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(102, 81, 1254, 668);
	getContentPane().add(tabbedPane);

	central.setHorizontalAlignment(SwingConstants.CENTER);
	
		panel1 = new JPanel();
		panel1.setFont(new Font("Kalinga", Font.PLAIN, 11));
		panel1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Informações via E-mail", new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606806_678108-address-book-128.png")), panel1, null);
		panel1.setLayout(null);
		
		txtContato = new JTextField();
		txtContato.setBounds(449, 160, 350, 42);
		txtContato.setText("exemplo@exemplo.com");
		txtContato.setFont(new Font("Kalinga", Font.PLAIN, 14));
		txtContato.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if (txtContato.getText().equalsIgnoreCase("exemplo@exemplo.com"))
					txtContato.setText("");
				txtContato.requestFocus(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (txtContato.getText().equalsIgnoreCase(""))
					txtContato.setText("exemplo@exemplo.com");
				txtContato.requestFocus(false);
			}

		});
		
		panel1.add(txtContato);
		txtContato.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(449, 266, 350, 42);
		txtSenha.setFont(new Font("Kalinga", Font.PLAIN, 14));
		txtSenha.setColumns(10);
		panel1.add(txtSenha);
		
		JLabel lblContato = new JLabel("E-mail p/ Contato");
		lblContato.setBounds(449, 126, 350, 32);
		lblContato.setFont(new Font("Kalinga", Font.PLAIN, 12));
		panel1.add(lblContato);
		
		JLabel lblIconeEmail = new JLabel("");
		lblIconeEmail.setBounds(769, 126, 30, 32);
		lblIconeEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconeEmail.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606717_enveloppe-alt-128.png")));
		lblIconeEmail.setFont(new Font("Kalinga", Font.PLAIN, 12));
		panel1.add(lblIconeEmail);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(449, 232, 350, 32);
		lblSenha.setFont(new Font("Kalinga", Font.PLAIN, 12));
		panel1.add(lblSenha);
		
		lblIconeSenha = new JLabel("");
		lblIconeSenha.setBounds(769, 232, 30, 32);
		lblIconeSenha.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606681_lock-128.png")));
		lblIconeSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconeSenha.setFont(new Font("Kalinga", Font.PLAIN, 12));
		panel1.add(lblIconeSenha);
		
		JButton btSalvar1 = new JButton("Salvar");
		btSalvar1.setBounds(649, 359, 150, 42);
		btSalvar1.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606570_floppy-128.png")));
		btSalvar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panel1.add(btSalvar1);
		
		JButton btCancelar1 = new JButton("Cancelar");
		btCancelar1.setBounds(449, 359, 150, 42);
		btCancelar1.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
		btCancelar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panel1.add(btCancelar1);
	
	JPanel panel2 = new JPanel();
	panel2.setOpaque(false);
	tabbedPane.addTab("Licença do Software", new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606644_678064-star-128.png")), panel2, null);
	panel2.setLayout(null);
	
	txt1 = new JTextField();
	txt1.setText("1111");
	txt1.setHorizontalAlignment(SwingConstants.CENTER);
	txt1.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txt1.setColumns(10);
	txt1.setBounds(449, 266, 60, 42);
	txt1.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txt1.getText().equalsIgnoreCase("1111"))
				txt1.setText("");
			txt1.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txt1.getText().equalsIgnoreCase(""))
				txt1.setText("1111");
			txt1.requestFocus(false);
		}

	});
	panel2.add(txt1);
	
	txt2 = new JTextField();
	txt2.setText("1111");
	txt2.setHorizontalAlignment(SwingConstants.CENTER);
	txt2.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txt2.setColumns(10);
	txt2.setBounds(519, 266, 60, 42);
	txt2.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txt2.getText().equalsIgnoreCase("1111"))
				txt2.setText("");
			txt2.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txt2.getText().equalsIgnoreCase(""))
				txt2.setText("1111");
			txt2.requestFocus(false);
		}

	});
	panel2.add(txt2);
	
	txt3 = new JTextField();
	txt3.setText("1111");
	txt3.setHorizontalAlignment(SwingConstants.CENTER);
	txt3.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txt3.setColumns(10);
	txt3.setBounds(589, 266, 60, 42);
	txt3.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txt3.getText().equalsIgnoreCase("1111"))
				txt3.setText("");
			txt3.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txt3.getText().equalsIgnoreCase(""))
				txt3.setText("1111");
			txt3.requestFocus(false);
		}

	});
	panel2.add(txt3);
	
	txt4 = new JTextField();
	txt4.setText("1111");
	txt4.setHorizontalAlignment(SwingConstants.CENTER);
	txt4.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txt4.setColumns(10);
	txt4.setBounds(659, 266, 60, 42);
	txt4.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txt4.getText().equalsIgnoreCase("1111"))
				txt4.setText("");
			txt4.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txt4.getText().equalsIgnoreCase(""))
				txt4.setText("1111");
			txt4.requestFocus(false);
		}

	});
	panel2.add(txt4);
	
	txt5 = new JTextField();
	txt5.setText("1111");
	txt5.setHorizontalAlignment(SwingConstants.CENTER);
	txt5.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txt5.setColumns(10);
	txt5.setBounds(729, 266, 60, 42);
	txt5.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txt5.getText().equalsIgnoreCase("1111"))
				txt5.setText("");
			txt5.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txt5.getText().equalsIgnoreCase(""))
				txt5.setText("1111");
			txt5.requestFocus(false);
		}

	});
	panel2.add(txt5);
	
	JButton btSalvar2 = new JButton("Salvar");
	btSalvar2.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606570_floppy-128.png")));
	btSalvar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btSalvar2.setBounds(649, 359, 150, 42);
	panel2.add(btSalvar2);
	
	JButton btCancelar2 = new JButton("Cancelar");
	btCancelar2.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
	btCancelar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btCancelar2.setBounds(449, 359, 150, 42);
	panel2.add(btCancelar2);
	
	JLabel lblIdDoCliente = new JLabel("Chave de Licença");
	lblIdDoCliente.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIdDoCliente.setBounds(449, 223, 350, 32);
	panel2.add(lblIdDoCliente);
	
	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606715_678129-lock-128.png")));
	label_1.setHorizontalAlignment(SwingConstants.CENTER);
	label_1.setFont(new Font("Kalinga", Font.PLAIN, 12));
	label_1.setBounds(759, 223, 30, 32);
	panel2.add(label_1);
	
	panel3 = new JPanel();
	panel3.setLayout(null);
	panel3.setFont(new Font("Kalinga", Font.PLAIN, 11));
	panel3.setBackground(Color.WHITE);
	tabbedPane.addTab("Configurações do Banco", new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606661_678113-database-128.png")), panel3, null);
	
	txtNomeBanco = new JTextField();
	txtNomeBanco.setText("Escolha um Nome p/ o Banco");
	txtNomeBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txtNomeBanco.setColumns(10);
	txtNomeBanco.setBounds(276, 167, 350, 42);
	txtNomeBanco.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txtNomeBanco.getText().equalsIgnoreCase("Escolha um Nome p/ o Banco"))
				txtNomeBanco.setText("");
			txtNomeBanco.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txtNomeBanco.getText().equalsIgnoreCase(""))
				txtNomeBanco.setText("Escolha um Nome p/ o Banco");
			txtNomeBanco.requestFocus(false);
		}

	});
	panel3.add(txtNomeBanco);
	
	txtURLServidor = new JTextField();
	txtURLServidor.setText("www.servidor.com/s-one");
	txtURLServidor.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txtURLServidor.setColumns(10);
	txtURLServidor.setBounds(652, 167, 350, 42);
	txtNomeBanco.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (txtNomeBanco.getText().equalsIgnoreCase("Escolha um Nome p/ o Banco"))
				txtNomeBanco.setText("");
			txtNomeBanco.requestFocus(true);

		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (txtNomeBanco.getText().equalsIgnoreCase(""))
				txtNomeBanco.setText("Escolha um Nome p/ o Banco");
			txtNomeBanco.requestFocus(false);
		}

	});
	panel3.add(txtURLServidor);
	
	passwordField = new JPasswordField();
	passwordField.setFont(new Font("Kalinga", Font.PLAIN, 14));
	passwordField.setColumns(10);
	passwordField.setBounds(276, 266, 350, 42);
	panel3.add(passwordField);
	
	txtPortaAcesso = new JTextField();
	txtPortaAcesso.setText("192.168.405.32");
	txtPortaAcesso.setFont(new Font("Kalinga", Font.PLAIN, 14));
	txtPortaAcesso.setColumns(10);
	txtPortaAcesso.setBounds(652, 266, 350, 42);
	panel3.add(txtPortaAcesso);
	
	btSalvar3 = new JButton("Salvar");
	btSalvar3.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606570_floppy-128.png")));
	btSalvar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btSalvar3.setBounds(649, 359, 150, 42);
	panel3.add(btSalvar3);
	
	btCancelar3 = new JButton("Cancelar");
	btCancelar3.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
	btCancelar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btCancelar3.setBounds(449, 359, 150, 42);
	panel3.add(btCancelar3);
	
	lblUrlDoServidor = new JLabel("URL do Servidor");
	lblUrlDoServidor.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblUrlDoServidor.setBounds(652, 134, 350, 32);
	panel3.add(lblUrlDoServidor);
	
	lblNomeDoBanco_1 = new JLabel("Nome do Banco de Dados");
	lblNomeDoBanco_1.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblNomeDoBanco_1.setBounds(276, 134, 350, 32);
	panel3.add(lblNomeDoBanco_1);
	
	lblNomeDoBanco = new JLabel("Usuário do Banco");
	lblNomeDoBanco.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblNomeDoBanco.setBounds(276, 233, 350, 32);
	panel3.add(lblNomeDoBanco);
	
	lblPortaDeAcesso = new JLabel("Porta de Acesso");
	lblPortaDeAcesso.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblPortaDeAcesso.setBounds(652, 233, 350, 32);
	panel3.add(lblPortaDeAcesso);
	
	lblIcone1 = new JLabel("");
	lblIcone1.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606661_678113-database-128.png")));
	lblIcone1.setHorizontalAlignment(SwingConstants.CENTER);
	lblIcone1.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIcone1.setBounds(596, 134, 30, 32);
	panel3.add(lblIcone1);
	
	lblIcone2 = new JLabel("");
	lblIcone2.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606870_terminal-128.png")));
	lblIcone2.setHorizontalAlignment(SwingConstants.CENTER);
	lblIcone2.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIcone2.setBounds(972, 134, 30, 32);
	panel3.add(lblIcone2);
	
	lblIcone3 = new JLabel("");
	lblIcone3.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606550_user-group-128.png")));
	lblIcone3.setHorizontalAlignment(SwingConstants.CENTER);
	lblIcone3.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIcone3.setBounds(596, 233, 30, 32);
	panel3.add(lblIcone3);
	
	lblIcone4 = new JLabel("");
	lblIcone4.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606779_file-zip-alt2-128.png")));
	lblIcone4.setHorizontalAlignment(SwingConstants.CENTER);
	lblIcone4.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIcone4.setBounds(972, 233, 30, 32);
	panel3.add(lblIcone4);
	
	panel4 = new JPanel();
	panel4.setLayout(null);
	panel4.setFont(new Font("Kalinga", Font.PLAIN, 11));
	panel4.setBackground(Color.WHITE);
	tabbedPane.addTab("Versão do Software", new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606696_678121-cloud-sync-128.png")), panel4, null);
	
	btSalvar4 = new JButton("Salvar");
	btSalvar4.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606570_floppy-128.png")));
	btSalvar4.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btSalvar4.setBounds(649, 359, 150, 42);
	panel4.add(btSalvar4);
	
	btCancelar4 = new JButton("Cancelar");
	btCancelar4.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
	btCancelar4.setFont(new Font("Kalinga", Font.PLAIN, 14));
	btCancelar4.setBounds(449, 359, 150, 42);
	panel4.add(btCancelar4);
	
	lblReceberAtualizaesAutomticamente = new JLabel("Receber Atualizações Automáticamente?");
	lblReceberAtualizaesAutomticamente.setHorizontalAlignment(SwingConstants.CENTER);
	lblReceberAtualizaesAutomticamente.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblReceberAtualizaesAutomticamente.setBounds(449, 221, 350, 32);
	panel4.add(lblReceberAtualizaesAutomticamente);
	
	lblIcone = new JLabel("");
	lblIcone.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_24px/1425606721_678127-cloud-down-128.png")));
	lblIcone.setHorizontalAlignment(SwingConstants.CENTER);
	lblIcone.setFont(new Font("Kalinga", Font.PLAIN, 12));
	lblIcone.setBounds(769, 221, 30, 32);
	panel4.add(lblIcone);
	
	JCheckBox chckbxSim = new JCheckBox("Sim");
	chckbxSim.setHorizontalAlignment(SwingConstants.CENTER);
	chckbxSim.setOpaque(false);
	chckbxSim.setFont(new Font("Kalinga", Font.PLAIN, 12));
	chckbxSim.setBounds(525, 266, 97, 32);
	panel4.add(chckbxSim);
	
	JCheckBox chckbxNo = new JCheckBox("Não");
	chckbxNo.setHorizontalAlignment(SwingConstants.CENTER);
	chckbxNo.setOpaque(false);
	chckbxNo.setFont(new Font("Kalinga", Font.PLAIN, 12));
	chckbxNo.setBounds(629, 266, 97, 32);
	panel4.add(chckbxNo);

	lblFecharSistema.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblFecharSistema.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606572_678069-sign-error-128.png")));
	getContentPane().add(lblFecharSistema);

	lblEstágio = new JLabel("");
	lblEstágio.setHorizontalAlignment(SwingConstants.CENTER);
	lblEstágio.setHorizontalTextPosition(SwingConstants.CENTER);
	lblEstágio.setBounds(190, 0, 1108, 81);
	lblEstágio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblEstágio.setToolTipText("Configuração");
	lblEstágio.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/imagens_principais/andrew-beckwith-design-freebieflat-ui-elements-psd-1396298673n8g4k.jpg")));
	lblEstágio.setForeground(new Color(119, 136, 153));
	lblEstágio.setFont(new Font("Verdana", Font.PLAIN, 26));
	lblEstágio.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		
	    }
	});
	getContentPane().add(lblEstágio);
	

	

	lblAbrir = new JLabel("MENU");
	lblAbrir.setBounds(10, 11, 70, 70);
	lblAbrir.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606621_678085-house-128.png")));
	lblAbrir.setDisplayedMnemonic(KeyEvent.VK_SPACE);
	lblAbrir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblAbrir.setForeground(new Color(119, 136, 153));
	lblAbrir.setFont(new Font("Montserrat", Font.BOLD, 11));
	lblAbrir.setHorizontalAlignment(SwingConstants.CENTER);
	lblAbrir.setHorizontalTextPosition(SwingConstants.CENTER);
	lblAbrir.setVerticalTextPosition(SwingConstants.BOTTOM);
	lblAbrir.setToolTipText("Abrir Menu");
	lblAbrir.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		new Menu();
		
		ConfiguraçãoSoftware.this.dispose();

	    }
	});
	getContentPane().add(lblAbrir);

	lblEmail = new JLabel("");
	lblEmail.setBounds(20, 115, 48, 48);
	lblEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblEmail.setEnabled(false);
	lblEmail.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606665_678071-address-book-alt-128.png")));
	lblEmail.setToolTipText("Dados para o envio de informações via e-mail");
	lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
	lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
	lblEmail.setDisplayedMnemonic(KeyEvent.VK_5);
	lblEmail.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		lblEmail.setEnabled(true);

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		lblEmail.setEnabled(false);
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		
	    }
	});
	getContentPane().add(lblEmail);

	lblCobrança = new JLabel("");
	lblCobrança.setBounds(20, 278, 48, 48);
	lblCobrança.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblCobrança.setEnabled(false);
	lblCobrança.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606555_star-128.png")));
	lblCobrança.setToolTipText("Dados de cobrança do software");
	lblCobrança.setHorizontalTextPosition(SwingConstants.CENTER);
	lblCobrança.setHorizontalAlignment(SwingConstants.CENTER);
	lblCobrança.setDisplayedMnemonic(KeyEvent.VK_5);
	lblCobrança.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		lblCobrança.setEnabled(true);

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		lblCobrança.setEnabled(false);
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		
	    }
	});
	getContentPane().add(lblCobrança);

	lblBancoDados = new JLabel("");
	lblBancoDados.setBounds(20, 441, 48, 48);
	lblBancoDados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblBancoDados.setEnabled(false);
	lblBancoDados.setToolTipText("Dados do banco de dados");
	lblBancoDados.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606661_678113-database-128.png")));
	lblBancoDados.setHorizontalAlignment(SwingConstants.CENTER);
	lblBancoDados.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		lblBancoDados.setEnabled(true);

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		lblBancoDados.setEnabled(false);
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		
	    }
	});
	getContentPane().add(lblBancoDados);

	lblUpdate = new JLabel("");
	lblUpdate.setBounds(20, 604, 48, 48);
	lblUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblUpdate.setEnabled(false);
	lblUpdate.setToolTipText("Dados de update");
	lblUpdate.setIcon(new ImageIcon(ConfiguraçãoSoftware.class.getResource("/icones1_32px/1425606696_678121-cloud-sync-128.png")));
	lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
	lblUpdate.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		lblUpdate.setEnabled(true);

	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
		lblUpdate.setEnabled(false);
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
		
	    }
	});
	getContentPane().add(lblUpdate);

	separator1 = new JSeparator();
	separator1.setBounds(10, 81, 70, 2);
	separator1.setForeground(new Color(153, 153, 153));
	getContentPane().add(separator1);

	separator2 = new JSeparator();
	separator2.setBounds(10, 748, 70, 1);
	separator2.setForeground(new Color(153, 153, 153));
	getContentPane().add(separator2);

	separator3 = new JSeparator();
	separator3.setBounds(90, 11, 2, 746);
	separator3.setOrientation(SwingConstants.VERTICAL);
	separator3.setForeground(new Color(153, 153, 153));
	getContentPane().add(separator3);

	BalloonTipStyle edgedLook = new EdgedBalloonStyle(Color.WHITE, Color.ORANGE);

	
	//Dimension screenSize = this.getToolkit().getScreenSize();

	//this.setSize(new Dimension(1366, 752));	
	this.setSize(new Dimension(1366, 768));
	this.setVisible(true);
	this.setLocationRelativeTo(null);

	/**
	 * --------------------------------------------------------------------
	 * ---------------
	 */

	new Thread(new Runnable() {
	    public void run() {
		try {
		    for (int i = 0; i <= 100; i++) {
			Thread.sleep(10);
		    }
		} catch (InterruptedException e) {
		    JOptionPane.showMessageDialog(null, "Erro na thread" + e.getMessage());
		}
	    }
	}).start();
    }


    private static void addPopup(Component component, final JPopupMenu popup) {
    }
}
