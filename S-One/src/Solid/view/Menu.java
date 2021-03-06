package Solid.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.java.balloontip.BalloonTip;
import net.java.balloontip.BalloonTip.AttachLocation;
import net.java.balloontip.BalloonTip.Orientation;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.EdgedBalloonStyle;
import net.java.balloontip.utils.ToolTipUtils;
import Solid.controller.BancoDados;
import Solid.controller.LogisticaController;
import Solid.controller.Metodos;
import Solid.controller.RHController;
import Solid.controller.SuprimentosController;
import Solid.controller.VendasController;

import com.jtattoo.plaf.fast.FastLookAndFeel;







import javax.swing.JSeparator;

@SuppressWarnings("unused")
public class Menu extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long        serialVersionUID = 2611013467580060132L;

	// instancia a classe do banco para conexão
	static BancoDados                x                = new BancoDados();

	// instancia a classe para impressao

	// variaveis do sistema
	private static JMenu             MenuRH;
	private static JMenu             MenuSupri;
	private static JMenu             MenuVendas;
	private static JMenu             MenuFinanceiro;
	private static JMenu             menuArquivo;
	private static JMenu             menuConfiguracao;
	private static JMenuItem         CadastrarFuncionario;
	private static JMenuItem         ImpressaoHolerite;
	private static JMenuItem         CadastrarProduto, mntmFornecedor;
	private static JMenuItem         AdicionaProdutoEstoque;
	private static JMenuItem         PainelVendas;
	private static JMenuItem         Clientes;
	private static JMenuItem         Caixa;
	private static JMenuItem         menuSair;
	private static JMenuItem         Fluxo;
	private static JMenuItem         menuDefinirPapelParede;	
	private static JMenuBar          menuBarra;
	private static JMenuBar          menuRH;
	private static JMenuBar          menuSuprimentos;
	private static JMenuBar          menuFinanceiro;
	private static JMenuBar          menuVendas;
	
	private static JLabel            btRH;
	private static JLabel            brSuprimentos;
	private static JLabel            brVendas;
	private static JLabel            brFinanceiro;
	private static JLabel            labelFundoMenuPrincipal;
	private static JLabel            labelIcone_2;
	private static JTextField        caminho;
	static int                       tb               = 0;
	private JMenuBar                 menuLogistica;
	private JMenu                    mnLogistica;
	private JMenuItem                Veiculo;
	private JMenuItem                Motorista;
	private JMenuItem                Delivery;
	private JMenuItem                MapaMesas;
	private JLabel                   labelIcone_1;
	private JMenuItem                menuAbrirAjuda;
	private JMenuItem                menuAbrirBatePapo;
	private JMenu                    menuLogout;
	private JMenu                    menuAjuda;
	private JLabel                   brLogistica;
	private JMenuItem                GiroEstoque;
	private JMenuItem                Contas;
	private JMenuItem                Transportadora;
	private JMenuItem                GerencEntrega;
	public static int                painel           = 0;
	private JMenuItem                mntmTreinamento;
	private JMenuItem                mntmRelatrios;
	private JMenuItem                menuItem;
	private JMenuItem                Relatorios;
	private JMenu                    menuCaixa;
	private JMenuItem                menu;
	public static int                quantMin;
	public static ArrayList<String> Produtos         = new ArrayList<String>();
	public static ArrayList<String> MateriaPrima         = new ArrayList<String>();
	public JLabel lblNewLabel;
	private JMenuItem GerencPedidos;
	public static Properties props;
	private JMenuItem mntmNewMenuItem;

	public Menu() {
		super();
		setResizable(false);
		try {
			// here you can put the selected theme class name in JTattoo
			props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setName("");

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		setTitle("MENU PRINCIPAL");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(UIManager.getColor("window"));
		getContentPane().setLayout(null);

		/*
		 * 
		 * Menu Janela
		 */
		menuBarra = new JMenuBar();
		menuBarra.setFocusTraversalKeysEnabled(true);
		menuBarra.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarra.setForeground(SystemColor.desktop);
		menuBarra.setBounds(0, 0, 1356, 32);
		getContentPane().add(menuBarra);
		menuBarra.setBackground(SystemColor.menu);
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setFocusPainted(true);
		menuArquivo.setFocusTraversalPolicyProvider(true);
		menuArquivo.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
		menuArquivo.setForeground(Color.BLACK);
		menuArquivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuArquivo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBarra.add(menuArquivo);

		menuSair = new JMenuItem("Sair");
		menuSair.setFocusPainted(true);
		menuSair.setFocusable(true);
		menuSair.setFocusTraversalPolicyProvider(true);
		menuSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuSair.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/desliga24px.png")));
		menuArquivo.add(menuSair);
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodos.formWindowClosing(null);
			}
		});

		menuConfiguracao = new JMenu("Configura\u00E7\u00E3o");
		menuConfiguracao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuConfiguracao.setFocusPainted(true);
		menuConfiguracao.setFocusTraversalPolicyProvider(true);
		menuConfiguracao.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
		menuConfiguracao.setForeground(Color.BLACK);
		menuConfiguracao.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBarra.add(menuConfiguracao);

		menuAbrirBatePapo = new JMenuItem("Abrir Bate-Papo");
		menuAbrirBatePapo.setFocusPainted(true);
		menuAbrirBatePapo.setFocusable(true);
		menuAbrirBatePapo.setFocusTraversalPolicyProvider(true);
		menuAbrirBatePapo.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
		menuAbrirBatePapo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuAbrirBatePapo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// PPChat.main(null);
			}
		});

		menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
		menuDefinirPapelParede.setFocusPainted(true);
		menuDefinirPapelParede.setFocusable(true);
		menuDefinirPapelParede.setFocusTraversalPolicyProvider(true);
		menuDefinirPapelParede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.SelecionarPapelParedeMenu();
			}
		});
		menuDefinirPapelParede.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606663_image-128.png")));
		menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuConfiguracao.add(menuDefinirPapelParede);
		menuConfiguracao.add(menuAbrirBatePapo);
		
		mntmNewMenuItem = new JMenuItem("Gerenciador de Configuração");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				JPasswordField pf = new JPasswordField();
				String senha = null;
				int okCxl = JOptionPane.showConfirmDialog(null, pf, "Insira a senha de Consultor : ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				if (okCxl == JOptionPane.OK_OPTION) {
				  senha = new String(pf.getPassword());
				  if(senha.equals("ontemeucomiarroz")){
					  ConfiguraçãoSoftware cnso = new ConfiguraçãoSoftware();
					  cnso.setVisible(true);
					  dispose();
				}
				}
			
			
			
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606642_678122-cogs-128.png")));
		mntmNewMenuItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuConfiguracao.add(mntmNewMenuItem);

		menuLogout = new JMenu("Logout");
		menuLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuLogout.setFocusPainted(true);
		menuLogout.setFocusTraversalPolicyProvider(true);
		menuLogout.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
		menuLogout.setForeground(Color.BLACK);
		menuLogout.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBarra.add(menuLogout);

		JMenuItem menuLogout2 = new JMenuItem("Logout");
		menuLogout2.setFocusPainted(true);
		menuLogout2.setFocusable(true);
		menuLogout2.setFocusTraversalPolicyProvider(true);
		menuLogout2.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
		menuLogout2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuLogout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.this.dispose();
				new Login().setVisible(true);
			}
		});
		menuLogout.add(menuLogout2);

		menuCaixa = new JMenu("Caixa");
		menuCaixa.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606602_678131-money-128.png")));
		menuCaixa.setForeground(Color.BLACK);
		menuCaixa.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuCaixa.setFocusTraversalPolicyProvider(true);
		menuCaixa.setFocusPainted(true);
		menuBarra.add(menuCaixa);

		menu = new JMenuItem("Abrir / Fechar Caixa");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Inicio.janelaCaixa==0){
				Inicio.janelaCaixa=1;
				new Caixa();
				}
			}
		});
		menu.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")));
		menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menu.setFocusable(true);
		menu.setFocusTraversalPolicyProvider(true);
		menu.setFocusPainted(true);
		menuCaixa.add(menu);

		menuAjuda = new JMenu("Ajuda");
		menuAjuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuAjuda.setFocusPainted(true);
		menuAjuda.setFocusTraversalPolicyProvider(true);
		menuAjuda.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
		menuAjuda.setForeground(Color.BLACK);
		menuAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBarra.add(menuAjuda);

		menuAbrirAjuda = new JMenuItem("Abrir Ajuda");
		menuAbrirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajuda ajuda = new Ajuda();
				ajuda.contentPaneAjuda.setVisible(true);
			}
		});
		menuAbrirAjuda.setFocusPainted(true);
		menuAbrirAjuda.setFocusable(true);
		menuAbrirAjuda.setFocusTraversalPolicyProvider(true);
		menuAbrirAjuda.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
		menuAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuAjuda.add(menuAbrirAjuda);

		menuRH = new JMenuBar();
		menuRH.setToolTipText("alt + 1");
		menuRH.setFocusTraversalKeysEnabled(true);
		menuRH.setBackground(SystemColor.menu);
		menuRH.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP,null, null));
		menuRH.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuRH.setForeground(Color.BLACK);
		menuRH.setBounds(157, 130, 139, 35);
		// menuBar_1.setVisible(false);
		menuRH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuRH.setFont(new Font("Kalinga", Font.PLAIN, 14));
		getContentPane().add(menuRH);

		MenuRH = new JMenu("         R.H      ");
		MenuRH.setFocusTraversalPolicyProvider(true);
		MenuRH.setFocusPainted(true);
		MenuRH.setPreferredSize(new Dimension(139, 35));
		MenuRH.setHorizontalTextPosition(SwingConstants.CENTER);
		MenuRH.setIcon(null);
		MenuRH.setMnemonic(KeyEvent.VK_1);
		MenuRH.setHorizontalAlignment(SwingConstants.CENTER);
		menuRH.add(MenuRH);

		MenuRH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuRH.setBorder(null);
		MenuRH.setFont(new Font("Kalinga", Font.BOLD, 16));

		CadastrarFuncionario = new JMenuItem("Funcionário");
		CadastrarFuncionario.setFont(new Font("Kalinga", Font.PLAIN, 14));
		CadastrarFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CadastrarFuncionario.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606608_pencil-128.png")));
		CadastrarFuncionario.setBackground(SystemColor.menu);
		CadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 1;
				RHController.AbrirRH();
				Menu.this.dispose();
			}
		});
		MenuRH.add(CadastrarFuncionario);

		ImpressaoHolerite = new JMenuItem("Cargos e Salários");
		ImpressaoHolerite.setFont(new Font("Kalinga", Font.PLAIN, 14));
		ImpressaoHolerite.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		ImpressaoHolerite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ImpressaoHolerite.setBackground(SystemColor.menu);
		ImpressaoHolerite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 2;
				RHController.AbrirRH();
				Menu.this.dispose();
			}
		});
		MenuRH.add(ImpressaoHolerite);

		mntmTreinamento = new JMenuItem("Treinamento");
		mntmTreinamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 3;
				RHController.AbrirRH();
				Menu.this.dispose();
			}
		});
		mntmTreinamento.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606809_wrench-128.png")));
		mntmTreinamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		mntmTreinamento.setBackground(SystemColor.menu);
		MenuRH.add(mntmTreinamento);

		mntmRelatrios = new JMenuItem("Relatórios");
		mntmRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				painel = 4;
				RHController.AbrirRH();
				Menu.this.dispose();
			}
		});
		mntmRelatrios.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")));
		mntmRelatrios.setFont(new Font("Kalinga", Font.PLAIN, 14));
		mntmRelatrios.setBackground(SystemColor.menu);
		MenuRH.add(mntmRelatrios);

		menuSuprimentos = new JMenuBar();
		menuSuprimentos.setToolTipText("alt + 2");
		menuSuprimentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuSuprimentos.setFocusTraversalKeysEnabled(true);
		menuSuprimentos.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuSuprimentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuSuprimentos.setBorder(new TitledBorder(new TitledBorder(null, "",
		            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)), "",
		            TitledBorder.CENTER, TitledBorder.TOP, null, null));
		menuSuprimentos.setBounds(393, 130, 139, 35);
		menuSuprimentos.setBackground(SystemColor.menu);
		menuSuprimentos.setForeground(Color.BLACK);
		getContentPane().add(menuSuprimentos);

		MenuSupri = new JMenu("SUPRIMENTOS   ");
		MenuSupri.setFocusTraversalPolicyProvider(true);
		MenuSupri.setFocusPainted(true);
		MenuSupri.setPreferredSize(new Dimension(139, 35));
		MenuSupri.setMnemonic(KeyEvent.VK_2);
		MenuSupri.setHorizontalTextPosition(SwingConstants.LEADING);
		menuSuprimentos.add(MenuSupri);
		MenuSupri.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuSupri.setFont(new Font("Kalinga", Font.BOLD, 16));
		// MenuSupri.setVisible(false);

		CadastrarProduto = new JMenuItem("Produto");
		CadastrarProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
		CadastrarProduto.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")));
		CadastrarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CadastrarProduto.setBackground(SystemColor.menu);
		CadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 1;
				SuprimentosController.AbrirSuprimentos();
				Menu.this.dispose();
			}
		});
		MenuSupri.add(CadastrarProduto);

		JMenuItem MateriaPrima = new JMenuItem("Mat\u00E9ria Prima");
		MateriaPrima.setFont(new Font("Kalinga", Font.PLAIN, 14));
		MateriaPrima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MateriaPrima.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")));
		MateriaPrima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 2;
				SuprimentosController.AbrirSuprimentos();
				Menu.this.dispose();
			}
		});
		MenuSupri.add(MateriaPrima);

		mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 3;
				SuprimentosController.AbrirSuprimentos();
				Menu.this.dispose();
			}
		});
		mntmFornecedor.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606601_book-128.png")));
		mntmFornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		mntmFornecedor.setBackground(SystemColor.menu);
		MenuSupri.add(mntmFornecedor);

		AdicionaProdutoEstoque = new JMenuItem(" Estoque");
		AdicionaProdutoEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
		AdicionaProdutoEstoque.setBackground(SystemColor.menu);
		AdicionaProdutoEstoque.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")));
		AdicionaProdutoEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AdicionaProdutoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				painel = 4;
				SuprimentosController.AbrirSuprimentos();
				Menu.this.dispose();
			}
		});
		MenuSupri.add(AdicionaProdutoEstoque);

		menuItem = new JMenuItem("Relatórios");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				painel = 5;
				SuprimentosController.AbrirSuprimentos();
				Menu.this.dispose();
			}
		});
		menuItem.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")));
		menuItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuItem.setBackground(SystemColor.menu);
		MenuSupri.add(menuItem);

		menuVendas = new JMenuBar();
		menuVendas.setToolTipText("alt + 3");
		menuVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuVendas.setFocusTraversalKeysEnabled(true);
		menuVendas.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuVendas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuVendas.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		            TitledBorder.TOP, null, new Color(59, 59, 59)), "", TitledBorder.CENTER,
		            TitledBorder.TOP, null, null));
		menuVendas.setBounds(617, 130, 139, 35);
		menuVendas.setForeground(Color.WHITE);
		menuVendas.setBackground(SystemColor.menu);
		getContentPane().add(menuVendas);

		MenuVendas = new JMenu("     VENDAS          ");
		MenuVendas.setFocusTraversalPolicyProvider(true);
		MenuVendas.setFocusPainted(true);
		MenuVendas.setPreferredSize(new Dimension(139, 35));
		MenuVendas.setHorizontalTextPosition(SwingConstants.CENTER);
		MenuVendas.setHorizontalAlignment(SwingConstants.CENTER);
		MenuVendas.setMnemonic(KeyEvent.VK_3);
		menuVendas.add(MenuVendas);
		MenuVendas.setBackground(SystemColor.menu);
		MenuVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuVendas.setFont(new Font("Kalinga", Font.BOLD, 16));

		PainelVendas = new JMenuItem("Painel de Vendas");
		PainelVendas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		PainelVendas.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606602_678131-money-128.png")));
		PainelVendas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PainelVendas.setBackground(SystemColor.menu);
		MenuVendas.add(PainelVendas);
		PainelVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 1;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});

		MapaMesas = new JMenuItem("Mapa de Mesas");
		MapaMesas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		MapaMesas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MapaMesas.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606605_678077-computer-128.png")));
		MapaMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 2;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});
		MenuVendas.add(MapaMesas);

		Clientes = new JMenuItem("Clientes");
		Clientes.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Clientes.setBackground(SystemColor.menu);
		Clientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Clientes.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")));
		Clientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 3;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});
		MenuVendas.add(Clientes);

		Delivery = new JMenuItem("Delivery");
		Delivery.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Delivery.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Delivery.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606557_678111-map-marker-128.png")));
		Delivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 4;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});
		MenuVendas.add(Delivery);

		JMenuItem menuItem_1 = new JMenuItem("Relatórios");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();
				painel = 5;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});
		menuItem_1.setIcon(new ImageIcon(Menu.class
	            .getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")));
		menuItem_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuItem_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuItem_1.setBackground(SystemColor.menu);
		MenuVendas.add(menuItem_1);
		
		GerencPedidos = new JMenuItem("Gerenciar Pedidos");
		GerencPedidos.setIcon(new ImageIcon(Menu.class.getResource("/icones1_24px/1425606844_file-zip-128.png")));
		GerencPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		GerencPedidos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		GerencPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 6;
				VendasController.AbrirVendas();
				Menu.this.dispose();				
			}
		});
		MenuVendas.add(GerencPedidos);		

		menuLogistica = new JMenuBar();
		menuLogistica.setToolTipText("alt + 4");
		menuLogistica.setFocusTraversalKeysEnabled(true);
		menuLogistica.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuLogistica.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuLogistica.setBorder(new TitledBorder(new TitledBorder(null, "",
		            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)), "",
		            TitledBorder.CENTER, TitledBorder.TOP, null, null));
		menuLogistica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuLogistica.setForeground(Color.WHITE);
		menuLogistica.setBackground(SystemColor.menu);
		menuLogistica.setBounds(839, 130, 139, 35);
		getContentPane().add(menuLogistica);

		mnLogistica = new JMenu("   LOGISTICA         ");
		mnLogistica.setFocusTraversalPolicyProvider(true);
		mnLogistica.setFocusPainted(true);
		mnLogistica.setPreferredSize(new Dimension(139, 35));
		mnLogistica.setHorizontalTextPosition(SwingConstants.CENTER);
		mnLogistica.setHorizontalAlignment(SwingConstants.CENTER);
		mnLogistica.setMnemonic(KeyEvent.VK_4);
		mnLogistica.setFont(new Font("Kalinga", Font.BOLD, 16));
		mnLogistica.setBorder(null);
		mnLogistica.setBackground(SystemColor.menu);
		menuLogistica.add(mnLogistica);

		Veiculo = new JMenuItem("Veículo");
		Veiculo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Veiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 1;
				LogisticaController.AbrirLogistica();
				Menu.this.dispose();				
			}
		});
		Veiculo.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606739_678100-tachometer-128.png")));
		Veiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Veiculo.setBackground(SystemColor.menu);
		mnLogistica.add(Veiculo);

		Motorista = new JMenuItem("Motorista");
		Motorista.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Motorista.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606657_user-128.png")));
		Motorista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Motorista.setBackground(SystemColor.menu);
		mnLogistica.add(Motorista);
		Motorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 2;
				LogisticaController.AbrirLogistica();
				Menu.this.dispose();				
			}
		});

		Transportadora = new JMenuItem("Transportadora");
		Transportadora.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606630_clock-128.png")));
		Transportadora.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Transportadora.setBackground(SystemColor.menu);
		mnLogistica.add(Transportadora);
		Transportadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 3;
				LogisticaController.AbrirLogistica();
				Menu.this.dispose();
			}
		});

		GerencEntrega = new JMenuItem("Gerenciar Entregas");
		GerencEntrega.setVisible(false);
		GerencEntrega.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606563_map-128.png")));
		GerencEntrega.setFont(new Font("Kalinga", Font.PLAIN, 14));
		GerencEntrega.setBackground(SystemColor.menu);
		mnLogistica.add(GerencEntrega);

		JMenuItem Relatorio = new JMenuItem("Relatórios");
		Relatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Relatorio.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")));
		Relatorio.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Relatorio.setBackground(SystemColor.menu);
		mnLogistica.add(Relatorio);
		GerencEntrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();
				painel = 4;
				LogisticaController.AbrirLogistica();
				Menu.this.dispose();				
			}
		});

		menuFinanceiro = new JMenuBar();
		menuFinanceiro.setToolTipText("alt + 5");
		menuFinanceiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuFinanceiro.setFocusTraversalKeysEnabled(true);
		menuFinanceiro.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuFinanceiro.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuFinanceiro.setBorder(new TitledBorder(new TitledBorder(null, "",
		            TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)), "",
		            TitledBorder.CENTER, TitledBorder.TOP, null, null));
		menuFinanceiro.setBounds(1059, 130, 140, 35);
		menuFinanceiro.setForeground(Color.BLACK);
		menuFinanceiro.setBackground(SystemColor.menu);
		getContentPane().add(menuFinanceiro);

		MenuFinanceiro = new JMenu("  FINANCEIRO");
		MenuFinanceiro.setFocusTraversalPolicyProvider(true);
		MenuFinanceiro.setFocusPainted(true);
		MenuFinanceiro.setPreferredSize(new Dimension(139, 35));
		MenuFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		MenuFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		MenuFinanceiro.setMnemonic(KeyEvent.VK_5);
		menuFinanceiro.add(MenuFinanceiro);
		MenuFinanceiro.setBackground(SystemColor.menu);
		MenuFinanceiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		MenuFinanceiro.setFont(new Font("Kalinga", Font.BOLD, 16));
		MenuFinanceiro.setVisible(true);

		Caixa = new JMenuItem("Abrir / Fechar Caixa");
		Caixa.setVisible(false);
		Caixa.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Caixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				new Financeiro();
				Menu.this.dispose();
				// ob.SetarPaineis(1);
			}
		});
		Caixa.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606602_678131-money-128.png")));
		Caixa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Caixa.setBackground(SystemColor.menu);
		MenuFinanceiro.add(Caixa);

		Fluxo = new JMenuItem("Fluxo de Caixa");
		Fluxo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BancoDados.conecta();				
				new Financeiro();
				Menu.this.dispose();
				// ob.SetarPaineis(1);
			}
		});
		Fluxo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Fluxo.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606683_678091-box-out-128.png")));
		Fluxo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Fluxo.setBackground(SystemColor.menu);
		MenuFinanceiro.add(Fluxo);

		GiroEstoque = new JMenuItem("Giro de Estoque");
		GiroEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				new Financeiro();
				Menu.this.dispose();
				// ob.SetarPaineis(1);
			}
		});
		GiroEstoque.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606696_678121-cloud-sync-128.png")));
		GiroEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
		GiroEstoque.setBackground(SystemColor.menu);
		MenuFinanceiro.add(GiroEstoque);

		Contas = new JMenuItem("Contas");
		Contas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				new Financeiro();
				Menu.this.dispose();
				// ob.SetarPaineis(1);
			}
		});
		Contas.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606559_678120-calendar-clock-128.png")));
		Contas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Contas.setBackground(SystemColor.menu);
		MenuFinanceiro.add(Contas);

		Relatorios = new JMenuItem("Relatórios");
		Relatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BancoDados.conecta();				
				new Financeiro();
				Menu.this.dispose();
				// ob.SetarPaineis(1);
			}
		});
		Relatorios.setIcon(new ImageIcon(Menu.class
		            .getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")));
		Relatorios.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Relatorios.setBackground(SystemColor.menu);
		MenuFinanceiro.add(Relatorios);

		/*
		 * 
		 * imagens do menu
		 */
		btRH = new JLabel("");
		btRH.setEnabled(false);
		btRH.setAlignmentX(Component.CENTER_ALIGNMENT);
		btRH.setFocusTraversalPolicyProvider(true);
		btRH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btRH.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btRH.setEnabled(false);
			}
		});

		btRH.setBounds(157, 162, 139, 362);
		BalloonTipStyle edgedLook = new EdgedBalloonStyle(Color.WHITE, Color.ORANGE);
		BalloonTip rh = new BalloonTip(
		            btRH,
		            new JLabel(
		                        "Com o modulo de R.H. será posivel fazer cadastro e consulta de funcionários."),
		            edgedLook, Orientation.RIGHT_BELOW, AttachLocation.ALIGNED, 0, 20, false);
		ToolTipUtils.balloonToToolTip(rh, 300, 5000);

		btRH.setHorizontalTextPosition(SwingConstants.CENTER);
		btRH.setFont(new Font("Tahoma", Font.BOLD, 15));
		btRH.setForeground(new Color(0, 0, 0));
		btRH.setIcon(new ImageIcon(Menu.class.getResource("/imagens_principais/rh_menu.jpg")));
		getContentPane().add(btRH);		

		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(Inicio.janelaLista);				
				if(Inicio.janelaLista==0){
				int sair = JOptionPane.showConfirmDialog(null, "Gostaria de abrir a Lista de compra ?.", "Compras",
						 JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					Inicio.janelaLista=1;					
					new ListaCompra();
									
				}
				UIManager.put("OptionPane.yesButtonText", "Sim");
				UIManager.put("OptionPane.noButtonText", "Não");
				}
				
			}
		});

		lblNewLabel.setVisible(false);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/gifs/alerta100.gif")));
		lblNewLabel.setBounds(413, 364, 100, 100);
		getContentPane().add(lblNewLabel);

		brSuprimentos = new JLabel("");
		brSuprimentos.setEnabled(false);
		brSuprimentos.setForeground(new Color(0, 0, 0));
		brSuprimentos.setAlignmentX(Component.CENTER_ALIGNMENT);
		brSuprimentos.setFocusTraversalPolicyProvider(true);
		brSuprimentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				brSuprimentos.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				brSuprimentos.setEnabled(false);
			}
		});
		brSuprimentos.setBounds(393, 162, 139, 362);
		brSuprimentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		brSuprimentos.setHorizontalTextPosition(SwingConstants.CENTER);
		brSuprimentos.setIcon(new ImageIcon(Menu.class
		            .getResource("/imagens_principais/suprimentos_menu.jpg")));
		getContentPane().add(brSuprimentos);
		BalloonTip sp = new BalloonTip(brSuprimentos, new JLabel(
		            "Com o modulo de Suprimentos é posivel controlar todo o estoque."),
		            edgedLook, Orientation.RIGHT_BELOW, AttachLocation.ALIGNED, 0, 20, false);
		ToolTipUtils.balloonToToolTip(sp, 300, 5000);

		brVendas = new JLabel("");
		brVendas.setEnabled(false);
		brVendas.setAlignmentX(Component.CENTER_ALIGNMENT);
		brVendas.setFocusTraversalPolicyProvider(true);
		brVendas.setBounds(617, 162, 139, 362);
		brVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				brVendas.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				brVendas.setEnabled(false);
			}
		});
		brVendas.setFont(new Font("Tahoma", Font.BOLD, 15));
		brVendas.setForeground(new Color(0, 0, 0));
		brVendas.setHorizontalTextPosition(SwingConstants.CENTER);
		brVendas.setIcon(new ImageIcon(Menu.class
		            .getResource("/imagens_principais/vendas2_menu.jpg")));
		getContentPane().add(brVendas);
		BalloonTip vd = new BalloonTip(
		            brVendas,
		            new JLabel(
		                        "Com o modulo de Vendas é posivel efetuar vendas e consultar/cadastrar clientes."),
		            edgedLook, Orientation.RIGHT_BELOW, AttachLocation.ALIGNED, 0, 20, false);
		ToolTipUtils.balloonToToolTip(vd, 300, 5000);

		brLogistica = new JLabel("");
		brLogistica.setEnabled(false);
		brLogistica.setAlignmentX(Component.CENTER_ALIGNMENT);
		brLogistica.setFocusTraversalPolicyProvider(true);
		brLogistica.setIcon(new ImageIcon(Menu.class
		            .getResource("/imagens_principais/logistica_menu.jpg")));
		brLogistica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				brLogistica.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				brLogistica.setEnabled(false);
			}
		});
		brLogistica.setHorizontalTextPosition(SwingConstants.CENTER);
		brLogistica.setForeground(new Color(0, 0, 0));
		brLogistica.setFont(new Font("Tahoma", Font.BOLD, 15));
		brLogistica.setBounds(839, 162, 138, 362);
		getContentPane().add(brLogistica);
		BalloonTip lg = new BalloonTip(brLogistica, new JLabel("Em desenvolvimento  !!."),
		            edgedLook, Orientation.RIGHT_BELOW, AttachLocation.ALIGNED, 0, 20, false);
		ToolTipUtils.balloonToToolTip(lg, 300, 5000);

		brFinanceiro = new JLabel("");
		brFinanceiro.setEnabled(false);
		brFinanceiro.setAlignmentX(Component.CENTER_ALIGNMENT);
		brFinanceiro.setFocusTraversalPolicyProvider(true);
		brFinanceiro.setBounds(1060, 162, 138, 362);
		brFinanceiro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				brFinanceiro.setEnabled(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				brFinanceiro.setEnabled(false);
			}
		});
		brFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		brFinanceiro.setForeground(new Color(0, 0, 0));
		brFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		brFinanceiro.setIcon(new ImageIcon(Menu.class
		            .getResource("/imagens_principais/financeiro_menu.jpg")));
		getContentPane().add(brFinanceiro);
		BalloonTip ct = new BalloonTip(brFinanceiro, new JLabel("Em desenvolvimento!!."),
		            edgedLook, Orientation.RIGHT_BELOW, AttachLocation.ALIGNED, 0, 20, false);
		ToolTipUtils.balloonToToolTip(ct, 300, 5000);

		labelIcone_1 = new JLabel("");
		labelIcone_1.setIcon(new ImageIcon(Menu.class
		            .getResource("/logos_solid/LogoPSemFundo.png")));
		labelIcone_1.setBounds(550, 579, 250, 93);
		getContentPane().add(labelIcone_1);

		labelIcone_2 = new JLabel("");
		labelIcone_2.setIcon(new ImageIcon(Menu.class.getResource("/gifs/cubo.GIF")));
		labelIcone_2.setBounds(716, 662, 32, 32);
		getContentPane().add(labelIcone_2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/gifs/S_one.GIF")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label.setBounds(643, 670, 63, 24);
		getContentPane().add(label);

		labelFundoMenuPrincipal = new JLabel("");
		labelFundoMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoMenuPrincipal.setBackground(SystemColor.inactiveCaptionBorder);
		labelFundoMenuPrincipal.setOpaque(true);
		labelFundoMenuPrincipal.setFont(new Font("Rockwell Condensed", Font.BOLD, 14));
		labelFundoMenuPrincipal.setHorizontalTextPosition(SwingConstants.CENTER);

		labelFundoMenuPrincipal.setBounds(0, 0, 1356, 739);
		labelFundoMenuPrincipal.setIcon(new ImageIcon(Menu.class.getResource("/papel_parede/low-poly-texture-13.png")));
		getContentPane().add(labelFundoMenuPrincipal);

		ConferirEstoqueMin();
		

		// this.setSize(new Dimension(1366, 768));
		this.setSize(toolkit.getScreenSize());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Menu.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
	}
	
	private void ConferirEstoqueMin() {
		quantMin = 0;
		Produtos.clear();
		MateriaPrima.clear();
		String sql5 = "select * from produtos order by nome";
		ResultSet rs5 = x.Consultar(sql5);
		try {
			while (rs5.next()) {
				if (Double.parseDouble(rs5.getString("estoqueAtual")) < Double.parseDouble(rs5.getString("estoqueMinimo"))) {
					Produtos.add(rs5.getString("nome"));
					quantMin++;
				}
			}
			
			sql5 = "select * from materia_p order by nome";
			rs5 = x.Consultar(sql5);			
				while (rs5.next()) {
					if (Double.parseDouble(rs5.getString("estoqueAtual")) < Double.parseDouble(rs5.getString("estoqueMinimo"))) {
						MateriaPrima.add(rs5.getString("nome"));
						quantMin++;
					}
				}
				
			if (quantMin > 0) {
				lblNewLabel.setVisible(true);
				lblNewLabel.setToolTipText("HÁ " + quantMin+ " ITENS QUE ESTÃO ABAIXO DO ESTOQUE MINIMO ESTIPULADO!");
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	protected static void SelecionarPapelParedeMenu() {
		JFileChooser selecionarArquivo = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG E BMP","jpg", "gif", "png", "bmp");
		selecionarArquivo.setFileFilter(filter);
		selecionarArquivo.setDialogTitle("Selecione a Imagem");

		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);

		int retorno = selecionarArquivo.showOpenDialog(null);

		if (retorno == JFileChooser.APPROVE_OPTION) {			
			labelFundoMenuPrincipal.setIcon(new javax.swing.ImageIcon(diretorio));
			caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
			System.out.print(diretorio);
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
