package Solid.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Solid.controller.BancoDados;
import Solid.controller.LoginController;
import Solid.controller.Metodos;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class Login extends JFrame {
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	private static final long	serialVersionUID	= -1388076347187950995L;
	
	// instancia a classe do banco para conexão
	Solid.controller.BancoDados	x			= new Solid.controller.BancoDados();
	
	// variaveis do sistema
	
	private JPanel			tabbedPaneLogin;
	public static JTextField	cusuario;
	public static JTextField	csenha;
	int					v			= 0;
	public static String		ncont, bc, ag;
	public static String		nclient;
	public static double		sald, sald1, lim, saq;
	private JLabel			labelUsuario;
	private JLabel			labelSenha;
	private JLabel			labelIconeSenha;
	private JLabel			labelIconeUsuario;
	private JLabel			labelFundoLogin;
	private JButton			btEntrar;
	private JButton			btSair;
	private JButton			btEsqueceuSuaSenha;
	private JLabel			labelIconeSolid;
	private JTextField		textSenha;
	static SimpleDateFormat		simpleDate;
	public static String User;
	
	public Login() {
		
		try {
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		setFont(new Font("Kalinga", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Login.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		
		setName("login");
		setResizable(false);
		setTitle("LOGIN");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 760, 460);
		
		tabbedPaneLogin = new JPanel();
		tabbedPaneLogin.setBackground(Color.WHITE);
		tabbedPaneLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabbedPaneLogin);
		tabbedPaneLogin.setLayout(null);
		
		cusuario = new JTextField();
		cusuario.setForeground(Color.BLACK);
		cusuario.setCaretColor(Color.BLACK);
		cusuario.setBackground(UIManager.getColor("TextField.background"));
		cusuario.setSelectionColor(SystemColor.textHighlight);
		cusuario.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		cusuario.setHorizontalAlignment(SwingConstants.CENTER);
		cusuario.setFont(new Font("Kalinga", Font.PLAIN, 16));
		cusuario.setBounds(380, 107, 256, 32);
		tabbedPaneLogin.add(cusuario);
		cusuario.setColumns(10);
		
		csenha = new JPasswordField();
		csenha.setForeground(Color.BLACK);
		csenha.setCaretColor(Color.BLACK);
		csenha.setBackground(UIManager.getColor("TextField.background"));
		csenha.setSelectionColor(SystemColor.textHighlight);
		csenha.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		csenha.setHorizontalAlignment(SwingConstants.CENTER);
		csenha.setFont(new Font("Kalinga", Font.PLAIN, 16));
		csenha.setBounds(380, 184, 256, 32);
		csenha.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (Toolkit.getDefaultToolkit().getLockingKeyState(
						java.awt.event.KeyEvent.VK_CAPS_LOCK)) {
					
					JOptionPane.showMessageDialog(null, "CAPS LOCK ATIVADO!", "Atenção",
							JOptionPane.INFORMATION_MESSAGE);
					
					csenha.setText(null);
				}
			}
		});
		tabbedPaneLogin.add(csenha);
		
		btSair = new JButton("Sair");
		btSair.setToolTipText("alt + End");
		btSair.setBackground(UIManager.getColor("Button.background"));
		btSair.setIcon(new ImageIcon(Login.class.getResource("/icones1_24px/desliga24px.png")));
		btSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSair.setMnemonic(KeyEvent.VK_END);
		btSair.setForeground(Color.BLACK);
		btSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodos.formWindowClosing(null);
			}
		});
		
		btEntrar = new JButton("Entrar");
		btEntrar.setToolTipText("alt + Enter");
		btEntrar.setIcon(new ImageIcon(Login.class
				.getResource("/icones1_24px/1425606546_678134-sign-check-128.png")));
		btEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEntrar.setForeground(Color.BLACK);
		btEntrar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btEntrar.setMnemonic(KeyEvent.VK_ENTER);
		// atalho de teclado sem usar o ALT
		// getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"),
		// "fireDoFindNext");
		// getRootPane().getActionMap().put("fireDoFindNext",new
		// AbstractAction("fireDoFindNext") {
		
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {				
				LoginController.verificarSenha();				
				if (LoginController.janela == true){
					User = cusuario.getText().toString();
					Login.this.dispose();
				}
			}
		});
		csenha.setVisible(true);
		
		textSenha = new JTextField();
		textSenha.setSelectionColor(SystemColor.textHighlight);
		textSenha.setHorizontalAlignment(SwingConstants.CENTER);
		textSenha.setFont(new Font("Kalinga", Font.PLAIN, 16));
		textSenha.setColumns(10);
		textSenha.setCaretColor(Color.BLACK);
		textSenha.setBackground(Color.WHITE);
		textSenha.setBounds(380, 184, 256, 32);
		tabbedPaneLogin.add(textSenha);
		
		btEntrar.setBounds(380, 268, 120, 40);
		tabbedPaneLogin.add(btEntrar);
		btSair.setBounds(516, 268, 120, 40);
		tabbedPaneLogin.add(btSair);
		
		btEsqueceuSuaSenha = new JButton("Esqueceu sua senha?");
		btEsqueceuSuaSenha.setToolTipText("alt + Space");
		btEsqueceuSuaSenha.setBackground(UIManager.getColor("Button.background"));
		btEsqueceuSuaSenha.setIcon(new ImageIcon(Login.class
				.getResource("/icones1_24px/1425606841_678056-wrench-128.png")));
		btEsqueceuSuaSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEsqueceuSuaSenha.setMnemonic(KeyEvent.VK_SPACE);
		btEsqueceuSuaSenha.setForeground(Color.BLACK);
		btEsqueceuSuaSenha.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btEsqueceuSuaSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				LoginController.Esqueci();				
				//Login.this.setVisible(false);
				//new UserSenha().setVisible(true);
			}
		});
		btEsqueceuSuaSenha.setBounds(380, 315, 256, 40);
		tabbedPaneLogin.add(btEsqueceuSuaSenha);
		
		JButton btnVisualizarSenha = new JButton("Visualizar Senha");
		btnVisualizarSenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnVisualizarSenha.setFont(new Font("Kalinga", Font.PLAIN, 12));
		btnVisualizarSenha.setIcon(new ImageIcon(Login.class
				.getResource("/icones1_24px/1425606561_search-128.png")));
		btnVisualizarSenha.setBorder(null);
		btnVisualizarSenha.setForeground(new Color(0, 0, 0));
		btnVisualizarSenha.setContentAreaFilled(false);
		btnVisualizarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				String senha = csenha.getText();
				csenha.setVisible(false);
				textSenha.setVisible(true);
				textSenha.setText(senha);
				
				labelIconeSenha
						.setIcon(new ImageIcon(
								Login.class.getResource("/icones1_32px/1425606776_678115-lock-open-128.png")));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				csenha.setVisible(true);
				textSenha.setVisible(false);
				
				labelIconeSenha.setIcon(new ImageIcon(Login.class
						.getResource("/icones1_32px/1425606681_lock-128.png")));
			}
		});
		btnVisualizarSenha.setBounds(380, 227, 138, 24);
		tabbedPaneLogin.add(btnVisualizarSenha);
		
		labelUsuario = new JLabel("Usuario *");
		labelUsuario.setBorder(null);
		labelUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		labelUsuario.setForeground(new Color(0, 0, 0));
		labelUsuario.setFont(new Font("Kalinga", Font.BOLD, 14));
		labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelUsuario.setBounds(380, 75, 82, 32);
		tabbedPaneLogin.add(labelUsuario);
		
		labelSenha = new JLabel("Senha *");
		labelSenha.setBorder(null);
		labelSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		labelSenha.setForeground(new Color(0, 0, 0));
		labelSenha.setFont(new Font("Kalinga", Font.BOLD, 14));
		labelSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelSenha.setBounds(380, 152, 82, 32);
		tabbedPaneLogin.add(labelSenha);
		
		labelIconeUsuario = new JLabel("");
		labelIconeUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
		labelIconeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconeUsuario.setIcon(new ImageIcon(Login.class
				.getResource("/icones1_32px/1425606610_678099-profile-filled-128.png")));
		labelIconeUsuario.setBounds(641, 106, 33, 32);
		tabbedPaneLogin.add(labelIconeUsuario);
		
		labelIconeSenha = new JLabel("");
		labelIconeSenha.setHorizontalTextPosition(SwingConstants.CENTER);
		labelIconeSenha.setHorizontalAlignment(SwingConstants.CENTER);
		labelIconeSenha.setIcon(new ImageIcon(Login.class
				.getResource("/icones1_32px/1425606681_lock-128.png")));
		labelIconeSenha.setBounds(641, 184, 33, 32);
		tabbedPaneLogin.add(labelIconeSenha);
		
		labelIconeSolid = new JLabel("");
		labelIconeSolid.setIcon(new ImageIcon(Login.class
				.getResource("/logos_solid/LogoPSemFundo.png")));
		labelIconeSolid.setBounds(47, 170, 250, 93);
		tabbedPaneLogin.add(labelIconeSolid);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(347, 58, 1, 315);
		tabbedPaneLogin.add(separator);
		
		labelFundoLogin = new JLabel("");
		labelFundoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		labelFundoLogin.setBackground(SystemColor.inactiveCaptionBorder);
		labelFundoLogin.setOpaque(true);
		labelFundoLogin.setIcon(new ImageIcon(Login.class
				.getResource("/papel_parede/low-poly-texture-6.png")));
		labelFundoLogin.setBounds(0, 0, 754, 431);
		tabbedPaneLogin.add(labelFundoLogin);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
