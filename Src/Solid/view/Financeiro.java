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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Solid.controller.BancoDados;
import Solid.controller.Metodos;
import Solid.model.PPReport;
import Solid.model.Data;

import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;






public class Financeiro extends JFrame {
	
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	private static final long		serialVersionUID	= -3230871162203580407L;
	
	// instancia a classe do banco para conexão
	static BancoDados				x			= new BancoDados();
	
	// instancia a classe para impressao
	PPReport					report		= new PPReport();
	
	// variaveis do sistema
	public static JFormattedTextField	SaldoInicial;
	public static JFormattedTextField	SaldoFinal;
	public static JFormattedTextField	Entradas;
	public static JFormattedTextField	Saidas;
	public JLabel				lblSaldoInicial;
	public JLabel				lblSaldoFinal;
	public JLabel				lblPrimeiroMovimento;
	public JLabel				lblltimoMovimento;
	public JLabel				lblEntradas;
	public JLabel				lblSadas;
	public JLabel				lblData_1;
	public JLabel				lblRecebimentos;
	public JLabel				lblPagamentos;
	public JLabel				lblSaldo;
	public JLabel				label;
	public JLabel				lblAte;
	public JLabel				lblSelecione;
	public JMenu				menuArquivo;
	public JMenuBar				menuBar;
	public JMenuItem				menuPrincipal, menuSair;
	public static JTabbedPane		tabbedPaneFinanceiro;
	public JPanel				panelFluxoCaixa;
	public static JPanel			panelGiroEstoque;
	public JPanel				panelAbrirFecharCaixa;
	public static JLabel			labelFundoFluxoCaixa;
	public static JLabel			labelFundoAbrirCaixa;
	public static JButton			btLimpar2;
	public static JButton			btPesquisar;
	public static JButton			btConsultar3;
	public static ResultSet			dados;
	public JMenu				menuConfiguracao;
	public JMenu				menuLogout;
	public JMenuItem				menuLogout2;
	public JMenu				menuAjuda;
	public JMenuItem				menuAbrirAjuda;
	public JButton				btSalvar1;
	public JButton				btLimpar1;
	public JMenuItem				menuDefinirPapelParede;
	public JMenuItem				menuAbrirBatePapo;
	public static JTextField		Valor1;
	public static JFormattedTextField	Data1;
	public static JFormattedTextField	Hora1;
	public static JTextField		Vendedor1;
	public JLabel				labelHora;
	public JLabel				labelVendedor;
	public JLabel				labelValor;
	public JLabel				labelData;
	public JButton				btLimpar3;
	public static JLabel			labelFundoGiroEstoque;
	public static JTextField		caminho;
	public static String			caminhoUltimoArquivo;
	public JButton				btImprimir1;
	public JButton				button_1;
	public JButton				btImprimir;
	public JPanel				panelContas;
	public JButton				btLimpar;
	public JButton				btSalvar;
	public JButton				btImprimir2;
	public static JLabel			labelPlanoFundoContas;
	public JFormattedTextField		periodoInicio;
	public JFormattedTextField		periodoFim;
	public JComboBox<String>		escolhaPeriodo;
	public JFormattedTextField		Data;
	public JTextField				Recebimentos;
	public JTextField				Pagamentos;
	public JTextField				Saldo;
	public JComboBox<String>		comboQuem;
	public JRadioButton			apagar;
	public JRadioButton			areceber;
	public static JTable			Tabela_hist;
	public static DefaultTableModel	modelo2;
	public JRadioButton			radioAbrirCaixa, radioFecharCaixa;
	public static JFormattedTextField	PrimeiroMovimento;
	public static JFormattedTextField	UltimoMovimento;
	private JLabel lblNomerazoSocial;
	private final JTextField cc_nome = new JTextField();
	private final JButton btnNewButton = new JButton("Pesquisar");
	private final JTextField cc_ref = new JTextField();
	private JLabel lblReferente;
	private JLabel lblDataDaEmisso;
	private final JTextField cc_de = new JTextField();
	private final JTextField cc_bnc = new JTextField();
	private final JTextField cc_ent = new JTextField();
	private final JTextField cc_vt = new JTextField();
	private JTextField cc_np;
	private final JButton btnNewButton_1 = new JButton("Gerar Parcelas");
	private final JButton btnNewButton_2 = new JButton("Remover Conta");
	private final JButton btnNewButton_3 = new JButton("Limpar");
	private final JButton btn_Salvar = new JButton("Salvar");
	private final JButton btnNewButton_5 = new JButton("Inserir Cheque");
	private final JTable table = new JTable();
	private DefaultTableModel model;
	private JLabel lblIntervDias;
	private JTextField cc_id;
	private JComboBox<?> cc_doc;
	
	public Financeiro() {
		
		// metodo construtor
		super();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Financeiro.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setFont(new Font("Kalinga", Font.PLAIN, 14));
		setName("financeiro");
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setSize(new Dimension(1600, 900));
		setLocale(new Locale("pt"));
		setTitle("FINANCEIRO");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);
		
		/*
		 * 
		 * Menu Janela
		 */
		
		menuBar = new JMenuBar();
		getContentPane().add(menuBar);
		menuBar.setForeground(new Color(0, 0, 0));
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		menuArquivo.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
		menuArquivo.setForeground(Color.BLACK);
		menuArquivo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuArquivo);
		menuBar.setBounds(0, 0, 1364, 32);
		
		menuPrincipal = new JMenuItem("Menu Principal");
		menuPrincipal.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuPrincipal.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606621_678085-house-128.png")));
		menuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sair = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja sair?", "Fechamento de Programa",
						JOptionPane.YES_NO_OPTION);
				if (sair == 0) {
					BancoDados.desconecta();
					Financeiro.this.dispose();
					new Menu();
				}
				UIManager.put("OptionPane.yesButtonText", "Sim");
				UIManager.put("OptionPane.noButtonText", "Não");
			}
		});
		menuArquivo.add(menuPrincipal);
		
		menuSair = new JMenuItem("Sair");
		menuSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuSair.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/desliga24px.png")));
		menuArquivo.add(menuSair);
		
		menuConfiguracao = new JMenu("Configuração");
		menuConfiguracao
				.setIcon(new ImageIcon(
						Financeiro.class
								.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
		menuConfiguracao.setHorizontalAlignment(SwingConstants.CENTER);
		menuConfiguracao.setForeground(Color.BLACK);
		menuConfiguracao.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuConfiguracao);
		
		menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
		menuDefinirPapelParede.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606663_image-128.png")));
		menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuDefinirPapelParede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Financeiro.SelecionarPapelParedeFinanceiro();
			}
		});
		menuConfiguracao.add(menuDefinirPapelParede);
		
		menuAbrirBatePapo = new JMenuItem("Abrir Bate-Papo");
		menuAbrirBatePapo.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
		menuAbrirBatePapo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuAbrirBatePapo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// PPChat.main(null);
			}
		});
		menuConfiguracao.add(menuAbrirBatePapo);
		
		menuLogout = new JMenu("Logout");
		menuLogout.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
		menuLogout.setHorizontalAlignment(SwingConstants.CENTER);
		menuLogout.setForeground(Color.BLACK);
		menuLogout.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuLogout);
		
		menuLogout2 = new JMenuItem("Logout");
		menuLogout2.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
		menuLogout2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuLogout2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Financeiro.this.dispose();
				new Login().setVisible(true);
				
			}
		});
		menuLogout.add(menuLogout2);
		
		menuAjuda = new JMenu("Ajuda");
		menuAjuda.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
		menuAjuda.setHorizontalAlignment(SwingConstants.CENTER);
		menuAjuda.setForeground(Color.BLACK);
		menuAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuAjuda);
		
		menuAbrirAjuda = new JMenuItem("Abrir Ajuda");
		menuAbrirAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ajuda ajuda = new Ajuda();
				ajuda.contentPaneAjuda.setVisible(true);
			}
		});
		menuAbrirAjuda.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
		menuAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuAjuda.add(menuAbrirAjuda);
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Metodos.formWindowClosing(null);
			}
		});
		
		tabbedPaneFinanceiro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFinanceiro.setBackground(UIManager.getColor("window"));
		tabbedPaneFinanceiro.setFont(new Font("Kalinga", Font.PLAIN, 13));
		tabbedPaneFinanceiro.setBounds(0, 35, 1364, 708);
		tabbedPaneFinanceiro.setOpaque(true);
		getContentPane().add(tabbedPaneFinanceiro);
		
		/*
		 * 
		 * Panel Fluxo de Caixa
		 */
		
		panelFluxoCaixa = new JPanel();
		panelFluxoCaixa
				.setToolTipText("O Fluxo de Caixa apresenta um demonstrativo de resultados da empresa ");
		panelFluxoCaixa.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panelFluxoCaixa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelFluxoCaixa.setBackground(SystemColor.inactiveCaptionBorder);
		panelFluxoCaixa.setLayout(null);
		
		/*
		 * 
		 * Panel Patrimonio
		 */
		
		panelGiroEstoque = new JPanel();
		panelGiroEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panelGiroEstoque.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGiroEstoque.setBackground(SystemColor.inactiveCaptionBorder);
		
		Financeiro.TabelaHistorico();
		
		/*
		 * 
		 * Panel Abrir / Fechar Caixa
		 */
		
		panelAbrirFecharCaixa = new JPanel();
		panelAbrirFecharCaixa.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panelAbrirFecharCaixa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		panelAbrirFecharCaixa.setBackground(SystemColor.inactiveCaptionBorder);
		panelAbrirFecharCaixa.setLayout(null);
		
		radioAbrirCaixa = new JRadioButton("Abrir Caixa");
		radioAbrirCaixa.setSelected(true);
		radioAbrirCaixa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioAbrirCaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				radioAbrirCaixa.setSelected(true);
				radioFecharCaixa.setSelected(false);
				
				Valor1.setEditable(true);
				Valor1.setEnabled(true);
				
				SaldoInicial.setEditable(false);
				SaldoInicial.setEnabled(false);
				
				SaldoFinal.setEditable(false);
				SaldoFinal.setEnabled(false);
			}
		});
		radioAbrirCaixa.setBorder(null);
		radioAbrirCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		radioAbrirCaixa.setForeground(SystemColor.textText);
		radioAbrirCaixa.setFont(new Font("Khmer UI", Font.BOLD, 15));
		radioAbrirCaixa.setOpaque(false);
		radioAbrirCaixa.setAlignmentX(Component.CENTER_ALIGNMENT);
		radioAbrirCaixa.setBounds(550, 61, 120, 32);
		panelAbrirFecharCaixa.add(radioAbrirCaixa);
		
		radioFecharCaixa = new JRadioButton("Fechar Caixa");
		radioFecharCaixa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		radioFecharCaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioAbrirCaixa.setSelected(false);
				radioFecharCaixa.setSelected(true);
				
				Valor1.setEditable(true);
				Valor1.setEnabled(true);
				
				SaldoFinal.setEditable(true);
				SaldoFinal.setEnabled(true);
				
				SaldoInicial.setEditable(false);
				SaldoInicial.setEnabled(false);
			}
		});
		radioFecharCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		radioFecharCaixa.setForeground(SystemColor.textText);
		radioFecharCaixa.setFont(new Font("Khmer UI", Font.BOLD, 15));
		radioFecharCaixa.setOpaque(false);
		radioFecharCaixa.setAlignmentX(Component.CENTER_ALIGNMENT);
		radioFecharCaixa.setBounds(687, 61, 130, 32);
		panelAbrirFecharCaixa.add(radioFecharCaixa);
		
		Data1 = new JFormattedTextField();
		Data1.setEnabled(false);
		Data1.setEditable(false);
		Data1.setFocusTraversalPolicyProvider(true);
		Data1.setSelectionColor(SystemColor.scrollbar);
		Data1.setForeground(SystemColor.desktop);
		Data1.setAutoscrolls(false);
		Data1.setText("21/11/2014");
		Data1.setHorizontalAlignment(SwingConstants.CENTER);
		Data1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Data1.setDisabledTextColor(Color.BLACK);
		Data1.setColumns(10);
		Data1.setBounds(29, 190, 87, 32);
		panelAbrirFecharCaixa.add(Data1);
		
		Hora1 = new JFormattedTextField();
		Hora1.setEnabled(false);
		Hora1.setEditable(false);
		Hora1.setFocusTraversalPolicyProvider(true);
		Hora1.setSelectionColor(SystemColor.scrollbar);
		Hora1.setForeground(SystemColor.desktop);
		Hora1.setAutoscrolls(false);
		Hora1.setText("02:43:02");
		Hora1.setHorizontalAlignment(SwingConstants.CENTER);
		Hora1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Hora1.setDisabledTextColor(Color.BLACK);
		Hora1.setColumns(10);
		Hora1.setBounds(184, 190, 87, 32);
		panelAbrirFecharCaixa.add(Hora1);
		
		Vendedor1 = new JTextField("teste");
		Vendedor1.setEnabled(false);
		Vendedor1.setEditable(false);
		Vendedor1.setFocusTraversalPolicyProvider(true);
		Vendedor1.setSelectionColor(SystemColor.scrollbar);
		Vendedor1.setForeground(SystemColor.desktop);
		Vendedor1.setAutoscrolls(false);
		Vendedor1.setHorizontalAlignment(SwingConstants.CENTER);
		Vendedor1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Vendedor1.setDisabledTextColor(Color.BLACK);
		Vendedor1.setColumns(10);
		Vendedor1.setBounds(398, 190, 389, 32);
		panelAbrirFecharCaixa.add(Vendedor1);
		
		Valor1 = new JTextField();
		Valor1.setDisabledTextColor(Color.BLACK);
		Valor1.setEnabled(false);
		Valor1.setEditable(false);
		Valor1.setText("0,00");
		Valor1.setToolTipText("");
		Valor1.setFocusTraversalPolicyProvider(true);
		Valor1.setSelectionColor(SystemColor.scrollbar);
		Valor1.setForeground(SystemColor.desktop);
		Valor1.setAutoscrolls(false);
		Valor1.setHorizontalAlignment(SwingConstants.CENTER);
		Valor1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Valor1.setColumns(10);
		Valor1.setBounds(867, 190, 80, 32);
		panelAbrirFecharCaixa.add(Valor1);
		
		/*
		 * 
		 * labels
		 */
		
		/*
		 * panels com ícones
		 */
		
		tabbedPaneFinanceiro.addTab("Abrir / Fechar Caixa", new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606602_678131-money-128.png")),
				panelAbrirFecharCaixa, "");
		
		SaldoInicial = new JFormattedTextField();
		SaldoInicial.setEnabled(false);
		SaldoInicial.setEditable(false);
		SaldoInicial.setText("0,00");
		SaldoInicial.setSelectionColor(SystemColor.scrollbar);
		SaldoInicial.setHorizontalAlignment(SwingConstants.CENTER);
		SaldoInicial.setForeground(Color.BLACK);
		SaldoInicial.setFont(new Font("Kalinga", Font.PLAIN, 14));
		SaldoInicial.setFocusTraversalPolicyProvider(true);
		SaldoInicial.setDisabledTextColor(Color.BLACK);
		SaldoInicial.setColumns(10);
		SaldoInicial.setAutoscrolls(false);
		SaldoInicial.setBounds(29, 314, 87, 32);
		panelAbrirFecharCaixa.add(SaldoInicial);
		
		SaldoFinal = new JFormattedTextField();
		SaldoFinal.setEnabled(false);
		SaldoFinal.setEditable(false);
		SaldoFinal.setText("0,00");
		SaldoFinal.setSelectionColor(SystemColor.scrollbar);
		SaldoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		SaldoFinal.setForeground(Color.BLACK);
		SaldoFinal.setFont(new Font("Kalinga", Font.PLAIN, 14));
		SaldoFinal.setFocusTraversalPolicyProvider(true);
		SaldoFinal.setDisabledTextColor(Color.BLACK);
		SaldoFinal.setColumns(10);
		SaldoFinal.setAutoscrolls(false);
		SaldoFinal.setBounds(195, 314, 87, 32);
		panelAbrirFecharCaixa.add(SaldoFinal);
		
		PrimeiroMovimento = new JFormattedTextField();
		PrimeiroMovimento.setText("02:43:02");
		PrimeiroMovimento.setSelectionColor(SystemColor.scrollbar);
		PrimeiroMovimento.setHorizontalAlignment(SwingConstants.CENTER);
		PrimeiroMovimento.setForeground(Color.WHITE);
		PrimeiroMovimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		PrimeiroMovimento.setFocusTraversalPolicyProvider(true);
		PrimeiroMovimento.setEnabled(false);
		PrimeiroMovimento.setEditable(false);
		PrimeiroMovimento.setDisabledTextColor(Color.BLACK);
		PrimeiroMovimento.setColumns(10);
		PrimeiroMovimento.setAutoscrolls(false);
		PrimeiroMovimento.setBounds(365, 314, 87, 32);
		panelAbrirFecharCaixa.add(PrimeiroMovimento);
		
		UltimoMovimento = new JFormattedTextField();
		UltimoMovimento.setText("02:43:02");
		UltimoMovimento.setSelectionColor(SystemColor.scrollbar);
		UltimoMovimento.setHorizontalAlignment(SwingConstants.CENTER);
		UltimoMovimento.setForeground(Color.WHITE);
		UltimoMovimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		UltimoMovimento.setFocusTraversalPolicyProvider(true);
		UltimoMovimento.setEnabled(false);
		UltimoMovimento.setEditable(false);
		UltimoMovimento.setDisabledTextColor(Color.BLACK);
		UltimoMovimento.setColumns(10);
		UltimoMovimento.setAutoscrolls(false);
		UltimoMovimento.setBounds(520, 314, 87, 32);
		panelAbrirFecharCaixa.add(UltimoMovimento);
		
		Entradas = new JFormattedTextField();
		Entradas.setEnabled(false);
		Entradas.setEditable(false);
		Entradas.setText("0,00");
		Entradas.setSelectionColor(SystemColor.scrollbar);
		Entradas.setHorizontalAlignment(SwingConstants.CENTER);
		Entradas.setForeground(Color.BLACK);
		Entradas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Entradas.setFocusTraversalPolicyProvider(true);
		Entradas.setDisabledTextColor(Color.BLACK);
		Entradas.setColumns(10);
		Entradas.setAutoscrolls(false);
		Entradas.setBounds(29, 431, 87, 32);
		panelAbrirFecharCaixa.add(Entradas);
		
		Saidas = new JFormattedTextField();
		Saidas.setEnabled(false);
		Saidas.setEditable(false);
		Saidas.setText("0,00");
		Saidas.setSelectionColor(SystemColor.scrollbar);
		Saidas.setHorizontalAlignment(SwingConstants.CENTER);
		Saidas.setForeground(Color.BLACK);
		Saidas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Saidas.setFocusTraversalPolicyProvider(true);
		Saidas.setDisabledTextColor(Color.BLACK);
		Saidas.setColumns(10);
		Saidas.setAutoscrolls(false);
		Saidas.setBounds(184, 431, 87, 32);
		panelAbrirFecharCaixa.add(Saidas);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(414, 0, 531, 32);
		panelAbrirFecharCaixa.add(menuBar_1);
		
		btSalvar1 = new JButton("Salvar");
		menuBar_1.add(btSalvar1);
		btSalvar1.setToolTipText("alt + Enter");
		btSalvar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Financeiro.AbrirCaixa();
			}
		});
		btSalvar1.setFocusTraversalPolicyProvider(true);
		btSalvar1.setFocusCycleRoot(true);
		btSalvar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btSalvar1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btSalvar1.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606570_floppy-128.png")));
		btSalvar1.setMnemonic(KeyEvent.VK_ENTER);
		
		JButton btnExcluir = new JButton("Excluir");
		menuBar_1.add(btnExcluir);
		btnExcluir.setToolTipText("alt + Delete");
		btnExcluir.setEnabled(false);
		btnExcluir.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		btnExcluir.setMnemonic(KeyEvent.VK_DELETE);
		btnExcluir.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btnExcluir.setAlignmentX(0.5f);
		
		btLimpar1 = new JButton("Limpar");
		menuBar_1.add(btLimpar1);
		btLimpar1.setToolTipText("alt + Backspace");
		btLimpar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btLimpar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Financeiro.limpaDados();
			}
		});
		btLimpar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btLimpar1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btLimpar1.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/Gnome-edit-clear.png")));
		btLimpar1.setMnemonic(KeyEvent.VK_BACK_SPACE);
		
		JButton btnAlterar = new JButton("Alterar");
		menuBar_1.add(btnAlterar);
		btnAlterar.setToolTipText("alt + Space");
		btnAlterar.setEnabled(false);
		btnAlterar.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606608_pencil-128.png")));
		btnAlterar.setMnemonic(KeyEvent.VK_SPACE);
		btnAlterar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btnAlterar.setFocusTraversalPolicyProvider(true);
		btnAlterar.setFocusCycleRoot(true);
		btnAlterar.setAlignmentX(0.5f);
		
		btImprimir1 = new JButton("Imprimir");
		menuBar_1.add(btImprimir1);
		btImprimir1.setToolTipText("alt + P");
		btImprimir1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btImprimir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// report.FluxoCaixa();
			}
		});
		btImprimir1.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		btImprimir1.setMnemonic(KeyEvent.VK_P);
		btImprimir1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		labelData = new JLabel("Data");
		labelData.setForeground(SystemColor.textText);
		labelData.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelData.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelData.setBounds(29, 156, 64, 32);
		panelAbrirFecharCaixa.add(labelData);
		
		labelHora = new JLabel("Hora");
		labelHora.setForeground(SystemColor.textText);
		labelHora.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelHora.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelHora.setBounds(184, 156, 64, 32);
		panelAbrirFecharCaixa.add(labelHora);
		
		labelVendedor = new JLabel("Vendedor");
		labelVendedor.setForeground(SystemColor.textText);
		labelVendedor.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelVendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelVendedor.setBounds(398, 156, 87, 32);
		panelAbrirFecharCaixa.add(labelVendedor);
		
		labelValor = new JLabel("Valor");
		labelValor.setForeground(SystemColor.textText);
		labelValor.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelValor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelValor.setBounds(867, 156, 64, 32);
		panelAbrirFecharCaixa.add(labelValor);
		
		lblSaldoInicial = new JLabel("Saldo Inicial");
		lblSaldoInicial.setForeground(Color.BLACK);
		lblSaldoInicial.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblSaldoInicial.setAlignmentX(0.5f);
		lblSaldoInicial.setBounds(29, 280, 120, 32);
		panelAbrirFecharCaixa.add(lblSaldoInicial);
		
		lblSaldoFinal = new JLabel("Saldo Final");
		lblSaldoFinal.setForeground(Color.BLACK);
		lblSaldoFinal.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblSaldoFinal.setAlignmentX(0.5f);
		lblSaldoFinal.setBounds(195, 280, 120, 32);
		panelAbrirFecharCaixa.add(lblSaldoFinal);
		
		lblPrimeiroMovimento = new JLabel("Primeiro Movimento");
		lblPrimeiroMovimento.setForeground(Color.BLACK);
		lblPrimeiroMovimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblPrimeiroMovimento.setAlignmentX(0.5f);
		lblPrimeiroMovimento.setBounds(365, 280, 150, 32);
		panelAbrirFecharCaixa.add(lblPrimeiroMovimento);
		
		lblltimoMovimento = new JLabel("Último Movimento");
		lblltimoMovimento.setForeground(Color.BLACK);
		lblltimoMovimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblltimoMovimento.setAlignmentX(0.5f);
		lblltimoMovimento.setBounds(520, 280, 150, 32);
		panelAbrirFecharCaixa.add(lblltimoMovimento);
		
		lblEntradas = new JLabel("Entradas");
		lblEntradas.setForeground(Color.BLACK);
		lblEntradas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblEntradas.setAlignmentX(0.5f);
		lblEntradas.setBounds(29, 397, 120, 32);
		panelAbrirFecharCaixa.add(lblEntradas);
		
		lblSadas = new JLabel("Saídas");
		lblSadas.setForeground(Color.BLACK);
		lblSadas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblSadas.setAlignmentX(0.5f);
		lblSadas.setBounds(184, 397, 120, 32);
		panelAbrirFecharCaixa.add(lblSadas);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_1.setBounds(10, 43, 1325, 69);
		panelAbrirFecharCaixa.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_2.setBounds(10, 132, 1325, 109);
		panelAbrirFecharCaixa.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_3.setBounds(10, 252, 1325, 109);
		panelAbrirFecharCaixa.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_4.setBounds(10, 372, 1325, 109);
		panelAbrirFecharCaixa.add(label_4);
		
		labelFundoAbrirCaixa = new JLabel("");
		labelFundoAbrirCaixa.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoAbrirCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoAbrirCaixa.setVerticalAlignment(SwingConstants.TOP);
		labelFundoAbrirCaixa.setBounds(0, 0, 1359, 673);
		panelAbrirFecharCaixa.add(labelFundoAbrirCaixa);
		labelFundoAbrirCaixa.setIcon(new ImageIcon(Financeiro.class
				.getResource("/papel_parede/01.jpg")));
		
		tabbedPaneFinanceiro.addTab("Fluxo de Caixa", new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606730_678082-tag-128.png")),
				panelFluxoCaixa, null);
		
		escolhaPeriodo = new JComboBox<String>();
		escolhaPeriodo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		escolhaPeriodo.addItem("");
		escolhaPeriodo.addItem("Dia");
		escolhaPeriodo.addItem("Mês");
		escolhaPeriodo.addItem("Ano");
		escolhaPeriodo.setForeground(Color.BLACK);
		escolhaPeriodo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		escolhaPeriodo.setFocusTraversalPolicyProvider(true);
		escolhaPeriodo.setEditable(false);
		escolhaPeriodo.setAutoscrolls(false);
		escolhaPeriodo.setBounds(42, 61, 115, 32);
		panelFluxoCaixa.add(escolhaPeriodo);
		
		Data = new JFormattedTextField();
		Data.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Data.setEnabled(false);
		Data.setEditable(false);
		try {
			Data.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
					"##/##/####")));
		}
		catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Data.setSelectionColor(SystemColor.scrollbar);
		Data.setHorizontalAlignment(SwingConstants.CENTER);
		Data.setForeground(Color.BLACK);
		Data.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Data.setFocusTraversalPolicyProvider(true);
		Data.setDisabledTextColor(Color.BLACK);
		Data.setColumns(10);
		Data.setAutoscrolls(false);
		Data.setBounds(42, 221, 115, 32);
		panelFluxoCaixa.add(Data);
		
		Recebimentos = new JTextField("0,00");
		Recebimentos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Recebimentos.setEnabled(false);
		Recebimentos.setEditable(false);
		Recebimentos.setSelectionColor(SystemColor.scrollbar);
		Recebimentos.setHorizontalAlignment(SwingConstants.CENTER);
		Recebimentos.setForeground(Color.BLACK);
		Recebimentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Recebimentos.setFocusTraversalPolicyProvider(true);
		Recebimentos.setDisabledTextColor(Color.BLACK);
		Recebimentos.setColumns(10);
		Recebimentos.setAutoscrolls(false);
		Recebimentos.setBounds(368, 221, 115, 32);
		panelFluxoCaixa.add(Recebimentos);
		
		Pagamentos = new JTextField("0,00");
		Pagamentos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Pagamentos.setEnabled(false);
		Pagamentos.setEditable(false);
		Pagamentos.setSelectionColor(SystemColor.scrollbar);
		Pagamentos.setHorizontalAlignment(SwingConstants.CENTER);
		Pagamentos.setForeground(Color.BLACK);
		Pagamentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Pagamentos.setFocusTraversalPolicyProvider(true);
		Pagamentos.setDisabledTextColor(Color.BLACK);
		Pagamentos.setColumns(10);
		Pagamentos.setAutoscrolls(false);
		Pagamentos.setBounds(694, 221, 115, 32);
		panelFluxoCaixa.add(Pagamentos);
		
		Saldo = new JTextField("0,00");
		Saldo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Saldo.setEnabled(false);
		Saldo.setEditable(false);
		Saldo.setSelectionColor(SystemColor.scrollbar);
		Saldo.setHorizontalAlignment(SwingConstants.CENTER);
		Saldo.setForeground(Color.BLACK);
		Saldo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Saldo.setFocusTraversalPolicyProvider(true);
		Saldo.setDisabledTextColor(Color.BLACK);
		Saldo.setColumns(10);
		Saldo.setAutoscrolls(false);
		Saldo.setBounds(1020, 221, 115, 32);
		panelFluxoCaixa.add(Saldo);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(347, 0, 664, 32);
		panelFluxoCaixa.add(menuBar_2);
		
		JButton btGrafico = new JButton("Grafico");
		menuBar_2.add(btGrafico);
		btGrafico.setForeground(Color.BLACK);
		btGrafico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*
				DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
				
				barDataset.setValue(80, "Marks1", "teste1");
				barDataset.setValue(50, "Marks2", "teste2");
				barDataset.setValue(75, "Marks3", "teste3");
				barDataset.setValue(95, "Marks4", "teste4");
				JFreeChart chart = ChartFactory.createBarChart("student score",
						"student name", "Marks", barDataset, PlotOrientation.VERTICAL,
						false, true, false);
				
				CategoryPlot p = chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.black);
				ChartFrame frame = new ChartFrame("Bar Chart", chart);
				frame.setVisible(true);
				frame.setBounds(42, 200, 1160, 311);*/
			}
		});
		btGrafico.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606754_monitor-128.png")));
		btGrafico.setToolTipText("alt + G");
		btGrafico.setMnemonic(KeyEvent.VK_G);
		btGrafico.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		btPesquisar = new JButton("Pesquisar");
		menuBar_2.add(btPesquisar);
		btPesquisar.setToolTipText("alt + Enter");
		btPesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btPesquisar.setForeground(Color.BLACK);
		btPesquisar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btPesquisar.setMnemonic(KeyEvent.VK_ENTER);
		btPesquisar.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606561_search-128.png")));
		
		JButton button = new JButton("Excluir");
		menuBar_2.add(button);
		button.setForeground(Color.BLACK);
		button.setToolTipText("alt + Delete");
		button.setEnabled(false);
		button.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		button.setMnemonic(KeyEvent.VK_DELETE);
		button.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button.setAlignmentX(0.5f);
		
		btLimpar2 = new JButton("Limpar");
		menuBar_2.add(btLimpar2);
		btLimpar2.setToolTipText("alt + Backspace");
		btLimpar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btLimpar2.setForeground(Color.BLACK);
		btLimpar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btLimpar2.setMnemonic(KeyEvent.VK_BACK_SPACE);
		btLimpar2.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/Gnome-edit-clear.png")));
		
		JButton button_2 = new JButton("Alterar");
		menuBar_2.add(button_2);
		button_2.setForeground(Color.BLACK);
		button_2.setToolTipText("alt + Space");
		button_2.setEnabled(false);
		button_2.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606608_pencil-128.png")));
		button_2.setMnemonic(KeyEvent.VK_SPACE);
		button_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button_2.setFocusTraversalPolicyProvider(true);
		button_2.setFocusCycleRoot(true);
		button_2.setAlignmentX(0.5f);
		
		button_1 = new JButton("Imprimir");
		menuBar_2.add(button_1);
		button_1.setForeground(Color.BLACK);
		button_1.setToolTipText("alt + P");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// report.FluxoCaixa();
			}
		});
		button_1.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		button_1.setMnemonic(KeyEvent.VK_P);
		button_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		lblData_1 = new JLabel("Data");
		lblData_1.setForeground(Color.BLACK);
		lblData_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblData_1.setAlignmentX(0.5f);
		lblData_1.setBounds(42, 188, 115, 32);
		panelFluxoCaixa.add(lblData_1);
		
		lblRecebimentos = new JLabel("Recebimentos");
		lblRecebimentos.setForeground(Color.BLACK);
		lblRecebimentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblRecebimentos.setAlignmentX(0.5f);
		lblRecebimentos.setBounds(368, 188, 115, 32);
		panelFluxoCaixa.add(lblRecebimentos);
		
		lblPagamentos = new JLabel("Pagamentos");
		lblPagamentos.setForeground(Color.BLACK);
		lblPagamentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblPagamentos.setAlignmentX(0.5f);
		lblPagamentos.setBounds(694, 188, 115, 32);
		panelFluxoCaixa.add(lblPagamentos);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setForeground(Color.BLACK);
		lblSaldo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblSaldo.setAlignmentX(0.5f);
		lblSaldo.setBounds(1020, 188, 115, 32);
		panelFluxoCaixa.add(lblSaldo);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Khmer UI", Font.BOLD, 15));
		label.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"GRAFICO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		label.setBounds(10, 287, 1325, 372);
		panelFluxoCaixa.add(label);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_5.setBounds(10, 167, 1325, 109);
		panelFluxoCaixa.add(label_5);
		
		JLabel label_10 = new JLabel("");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_10.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_10.setBounds(10, 43, 1325, 69);
		panelFluxoCaixa.add(label_10);
		
		labelFundoFluxoCaixa = new JLabel("");
		labelFundoFluxoCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoFluxoCaixa.setForeground(SystemColor.desktop);
		labelFundoFluxoCaixa.setFont(new Font("Arial", Font.PLAIN, 12));
		labelFundoFluxoCaixa.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoFluxoCaixa.setBounds(0, 0, 1359, 673);
		labelFundoFluxoCaixa.setIcon(new ImageIcon(Financeiro.class
				.getResource("/papel_parede/01.jpg")));
		panelFluxoCaixa.add(labelFundoFluxoCaixa);
		
		tabbedPaneFinanceiro.addTab("Giro de Estoque", new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606771_678086-institution-128.png")),
				panelGiroEstoque, null);
		panelGiroEstoque.setLayout(null);
		
		periodoInicio = new JFormattedTextField();
		try {
			periodoInicio.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
					"##/##/####")));
		}
		catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		periodoInicio.setBounds(31, 61, 115, 32);
		periodoInicio.setSelectionColor(SystemColor.scrollbar);
		periodoInicio.setHorizontalAlignment(SwingConstants.CENTER);
		periodoInicio.setForeground(Color.BLACK);
		periodoInicio.setFont(new Font("Kalinga", Font.PLAIN, 14));
		periodoInicio.setDisabledTextColor(Color.BLACK);
		periodoInicio.setColumns(10);
		periodoInicio.setAutoscrolls(false);
		panelGiroEstoque.add(periodoInicio);
		
		periodoFim = new JFormattedTextField();
		try {
			periodoFim.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
					"##/##/####")));
		}
		catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		periodoFim.setBounds(189, 61, 115, 32);
		periodoFim.setSelectionColor(SystemColor.scrollbar);
		periodoFim.setHorizontalAlignment(SwingConstants.CENTER);
		periodoFim.setForeground(Color.BLACK);
		periodoFim.setFont(new Font("Kalinga", Font.PLAIN, 14));
		periodoFim.setDisabledTextColor(Color.BLACK);
		periodoFim.setColumns(10);
		periodoFim.setAutoscrolls(false);
		panelGiroEstoque.add(periodoFim);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(402, 0, 555, 32);
		panelGiroEstoque.add(menuBar_3);
		
		btConsultar3 = new JButton("Pesquisar");
		menuBar_3.add(btConsultar3);
		btConsultar3.setToolTipText("alt + Enter");
		btConsultar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btConsultar3.setForeground(Color.BLACK);
		btConsultar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btConsultar3.setMnemonic(KeyEvent.VK_ENTER);
		btConsultar3.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606561_search-128.png")));
		
		JButton button_4 = new JButton("Excluir");
		button_4.setForeground(Color.BLACK);
		menuBar_3.add(button_4);
		button_4.setToolTipText("alt + Delete");
		button_4.setEnabled(false);
		button_4.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		button_4.setMnemonic(KeyEvent.VK_DELETE);
		button_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button_4.setAlignmentX(0.5f);
		
		btLimpar3 = new JButton("Limpar");
		menuBar_3.add(btLimpar3);
		btLimpar3.setToolTipText("alt + Backspace");
		btLimpar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btLimpar3.setForeground(Color.BLACK);
		btLimpar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btLimpar3.setMnemonic(KeyEvent.VK_BACK_SPACE);
		btLimpar3.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/Gnome-edit-clear.png")));
		
		JButton button_3 = new JButton("Alterar");
		button_3.setForeground(Color.BLACK);
		menuBar_3.add(button_3);
		button_3.setToolTipText("alt + Space");
		button_3.setEnabled(false);
		button_3.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606608_pencil-128.png")));
		button_3.setMnemonic(KeyEvent.VK_SPACE);
		button_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button_3.setFocusTraversalPolicyProvider(true);
		button_3.setFocusCycleRoot(true);
		button_3.setAlignmentX(0.5f);
		
		btImprimir = new JButton("Imprimir");
		btImprimir.setForeground(Color.BLACK);
		menuBar_3.add(btImprimir);
		btImprimir.setToolTipText("alt + P");
		btImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// report.FluxoCaixa();
			}
		});
		btImprimir.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		btImprimir.setMnemonic(KeyEvent.VK_P);
		btImprimir.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		lblAte = new JLabel("Até");
		lblAte.setBounds(156, 63, 115, 32);
		lblAte.setForeground(Color.BLACK);
		lblAte.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblAte.setAlignmentX(0.5f);
		panelGiroEstoque.add(lblAte);
		
		JLabel label_11 = new JLabel("");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_11.setBounds(10, 43, 1325, 69);
		panelGiroEstoque.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_12.setBounds(20, 152, 1315, 490);
		panelGiroEstoque.add(label_12);
		
		labelFundoGiroEstoque = new JLabel("");
		labelFundoGiroEstoque.setBounds(0, 0, 1359, 673);
		labelFundoGiroEstoque.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoGiroEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoGiroEstoque.setIcon(new ImageIcon(Financeiro.class
				.getResource("/papel_parede/01.jpg")));
		labelFundoGiroEstoque.setVerticalAlignment(SwingConstants.TOP);
		panelGiroEstoque.add(labelFundoGiroEstoque);
		
		panelContas = new JPanel();
		panelContas.setLayout(null);
		panelContas.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panelContas.setBorder(new BevelBorder(BevelBorder.RAISED, null,
		
		null, null, null));
		panelContas.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPaneFinanceiro.addTab("Contas", new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606565_calendar-128.png")), panelContas,
				null);
		
		areceber = new JRadioButton("Contas a Receber");
		areceber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				areceber.setSelected(true);
				apagar.setSelected(false);
				
				
			}
		});
		
		cc_id = new JTextField();
		cc_id.setText("30");
		cc_id.setColumns(10);
		cc_id.setBounds(246, 281, 93, 31);
		panelContas.add(cc_id);
		
		lblIntervDias = new JLabel("Interv. Dias");
		lblIntervDias.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntervDias.setBounds(246, 257, 108, 24);
		panelContas.add(lblIntervDias);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 416, 968, 226);
		panelContas.add(scrollPane_1);
		scrollPane_1.setViewportView(table);
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lan\u00E7amento", "Tipo", "Valor", "Data Venc.", "Desconto(R$)", "Acr\u00E9simo(R$)", "Parcela", "Valor Parcela"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(99);
		table.getColumnModel().getColumn(5).setPreferredWidth(83);
		
		JLabel round1 = new JLabel("");
		round1.setForeground(Color.BLACK);
		round1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		round1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		round1.setBounds(10, 143, 1325, 516);
		panelContas.add(round1);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if((cc_doc.getSelectedItem()).equals("Cheque")){
					
					BancoDados h = new BancoDados();
					BancoDados.conecta();
					ResultSet ts = h.Consultar("SELECT MAX(cod) FROM contas ");
					String val=null;
					try {
						ts.beforeFirst();
						while(ts.next()){
						val = ts.getString("MAX(cod)");
						}
						int valin = Integer.parseInt(val)+1;
						val = valin+"";
					} catch (SQLException eghfh) {}
									
					
					System.out.println(cc_np.getText()+" "+val);
					Cheque ch = new Cheque(cc_np.getText(),""+val);
					ch.setVisible(true);
				}
			
			
			}
		});
		btnNewButton_5.setBounds(272, 362, 131, 31);
		panelContas.add(btnNewButton_5);
		btn_Salvar.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
			
			
				BancoDados m = new BancoDados();


				BancoDados.conecta();
				String tipo = "";
				
				ResultSet cons = null;
				if(apagar.isSelected()){tipo="Pagar";}else{tipo="Receber";}
				double vp = Double.parseDouble(cc_vt.getText())/Double.parseDouble(cc_np.getText()); 
				DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");  
				java.sql.Date data = null;
				try { data = new java.sql.Date(fmt.parse(cc_de.getText()).getTime());} catch (ParseException e1) {e1.printStackTrace();} 

				String comandosql = " INSERT INTO contas"
						+ "(nome, referente, data_emis, banco, doc, tipoc, valor_parcela, qnt_parcela, total)"
						+ " VALUES ('"
						+cc_nome.getText()+"','"+cc_ref.getText()+"','"+data.toString()+"','"+
						cc_bnc.getText()+"','"+cc_doc.getSelectedItem().toString()+"','"+
						tipo+"',"+vp+","+cc_np.getText()+","+cc_vt.getText()+
						");";
				m.grava(comandosql);
				System.out.println(comandosql);





				try {cons.close();} catch (SQLException et) {et.printStackTrace();}

				try {Thread.sleep(700);} catch (InterruptedException ety) {ety.printStackTrace();}

				BancoDados y = new BancoDados();


				BancoDados.conecta();

				System.out.println("contas");

				String consulta = "SELECT cod FROM contas WHERE nome = '"+cc_nome.getText()+"';"; 


				cons = y.Consultar(consulta);
				String cod = new String();
				try {
					cons.beforeFirst();
					while(cons.next()){
						cod = cons.getString("cod");
					}
					cons.close();
				} catch (SQLException erf) {
					// TODO Auto-generated catch block
					erf.printStackTrace();
				}

				System.out.println(cod);

				System.out.println("fim contas");

				try {Thread.sleep(100);} catch (InterruptedException elk) {elk.printStackTrace();}
				//"Lan\u00E7amento"," Tipo ", "Valor", "Data Venc.", "Descontos(R$)", "Acr\u00E9cimos(R$)", "Parcela", "Valor a pagar/receber"


				Data rd = new Data();



				//y.conecta();

				int c=1;
				String comandosql_1 = ""; 

				for(int i=0; i< table.getRowCount(); i++){
					
					y.conecta();

					String ndata = rd.mensal(model.getValueAt(i, 3).toString());	

					 //DecimalFormat f = new DecimalFormat("0.00");
					
					comandosql_1 = /*comandosql_1 +*/ " INSERT INTO cad_lancamentos ("
							+ "lancamento, tipo, valor_entrada,data_venc, valor_total, acrescimo, desconto, qnt_parc, valor_parc)"
							+ " VALUES ("
							+Integer.parseInt(cod)+",'"
							+model.getValueAt(i, 1)+"',"
							+cc_ent.getText().toString().replace(',', '.')+",'"
							+ndata+"',"
							+model.getValueAt(i, 2).toString().replace(',', '.')+","
							+model.getValueAt(i, 4).toString().replace(',', '.')+","
							+model.getValueAt(i, 5).toString().replace(',', '.')+",'"
							+c+"/"+cc_np.getText()+"',"
							+model.getValueAt(i, 7).toString().replace(',', '.')+") ; ";
					System.out.println(comandosql_1);	
					//}
					y.grava(comandosql_1);


					try {Thread.sleep(200);} catch (InterruptedException ehg) {ehg.printStackTrace();}	
					c++;
				}

				System.out.println("OK");	
				JOptionPane.showMessageDialog(null,"Salvo");

				cc_ent.setText("0");
				cc_nome.setText("");
				cc_ref.setText("");
				cc_bnc.setText("");
				cc_doc.setSelectedItem(0);
				cc_np.setText("1");
				cc_vt.setText("");



				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				
				
			
			
			}
		});
		btn_Salvar.setEnabled(false);
		btn_Salvar.setBounds(865, 362, 131, 31);
		panelContas.add(btn_Salvar);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
			
			}
		});
		btnNewButton_3.setBounds(718, 362, 131, 31);
		panelContas.add(btnNewButton_3);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int i = table.getSelectedRow();

				model.removeRow(i);
			
			}
		});
		btnNewButton_2.setBounds(414, 362, 131, 31);
		panelContas.add(btnNewButton_2);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
			
				btn_Salvar.setEnabled(true);


				int np = Integer.parseInt(cc_np.getText().replace(',', '.'));

				double vt = Double.parseDouble(cc_vt.getText().replace(',', '.'));

				if(!(cc_ent.getText()).equals("")){
					double entrada = Double.parseDouble(cc_ent.getText().replace(',', '.'));
					double rest  = vt - entrada;
					vt = rest;
				}			



				Date data = null;

				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				try {
					data = (Date)df.parse(cc_de.getText());
					//	dt = df.format(data);
				} catch (ParseException e45) {
					// TODO Auto-generated catch block
					e45.printStackTrace();
				}
				//System.out.println(dt);

				int inter = Integer.parseInt(cc_id.getText());
				Object cc_vet[] = new Object[8];

				for(int i=1; i<=np; i++){

					Date dataD = data;

					Calendar calendar = Calendar.getInstance();
					calendar.setTime(dataD);

					calendar.add(Calendar.DAY_OF_MONTH, inter*i); 

					//	System.out.println(df.format(calendar.getTime()).toString());

					/*"Lan\u00E7amento", "Valor", "Data Venc.", "Descontos(R$)", "Acr\u00E9cimos(R$)", "Parcela", "Valor a pagar"*/
					cc_vet[0] = i;
					String tipo;
					if(apagar.isSelected()){
						tipo="Pagar";
					}else{
						tipo="Receber";
					}
					
					 DecimalFormat fmt = new DecimalFormat("0.00");
					
					cc_vet[1] = tipo;
					cc_vet[2] = fmt.format(vt);
					cc_vet[3] = df.format(calendar.getTime());
					cc_vet[4] = "0";
					cc_vet[5] = "0";
					cc_vet[6] =	i+"/"+np;	
					cc_vet[7] = fmt.format(vt/np); 	 			

					model.addRow(cc_vet);


				}


				//System.out.println(data);
			
			
			
			
			
			}
		});
		btnNewButton_1.setBounds(572, 362, 131, 31);
		panelContas.add(btnNewButton_1);
		
		cc_doc = new JComboBox();
		cc_doc.setModel(new DefaultComboBoxModel(new String[] {"Cheque", "Duplicata", "Guia Pr\u00F3pria", "Cart\u00E3o"}));
		cc_doc.setBounds(28, 362, 219, 31);
		panelContas.add(cc_doc);
		
		JLabel lblDocumento = new JLabel("Documento : ");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDocumento.setBounds(28, 338, 145, 24);
		panelContas.add(lblDocumento);
		
		cc_np = new JTextField();
		cc_np.setColumns(10);
		cc_np.setBounds(888, 281, 108, 31);
		panelContas.add(cc_np);
		
		JLabel lblNDeParcelas = new JLabel("N\u00BA de Parcelas : ");
		lblNDeParcelas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNDeParcelas.setBounds(888, 257, 108, 24);
		panelContas.add(lblNDeParcelas);
		cc_vt.setBounds(739, 281, 108, 31);
		panelContas.add(cc_vt);
		cc_vt.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total : ");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorTotal.setBounds(739, 257, 108, 24);
		panelContas.add(lblValorTotal);
		cc_ent.setBounds(572, 281, 108, 31);
		panelContas.add(cc_ent);
		cc_ent.setColumns(10);
		
		JLabel lblEntrada = new JLabel("Entrada : ");
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEntrada.setBounds(572, 257, 108, 24);
		panelContas.add(lblEntrada);
		cc_bnc.setBounds(364, 281, 181, 31);
		panelContas.add(cc_bnc);
		cc_bnc.setColumns(10);
		
		JLabel lblBanco = new JLabel("Banco : ");
		lblBanco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBanco.setBounds(364, 257, 181, 24);
		panelContas.add(lblBanco);
		
		JCheckBox chckbxHoje = new JCheckBox("Hoje");
		chckbxHoje.setBackground(new Color(176, 224, 230));
		chckbxHoje.setBounds(187, 285, 60, 23);
		panelContas.add(chckbxHoje);
		cc_de.setBounds(28, 281, 159, 31);
		panelContas.add(cc_de);
		cc_de.setColumns(10);
		
		comboQuem = new JComboBox<String>();
		
		lblDataDaEmisso = new JLabel("Data da Emiss\u00E3o : ");
		lblDataDaEmisso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataDaEmisso.setBounds(28, 257, 243, 24);
		panelContas.add(lblDataDaEmisso);
		
		lblReferente = new JLabel("Referente : ");
		lblReferente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReferente.setBounds(572, 181, 243, 24);
		panelContas.add(lblReferente);
		cc_ref.setBounds(572, 204, 424, 31);
		panelContas.add(cc_ref);
		cc_ref.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String lista = comboQuem.getSelectedItem().toString().toLowerCase();
			
				if(lista.contains("lient")){
					lista+="s";
				}
				
				String comandosql = "SELECT * FROM "+lista;  //	"Modelo", "Placa", "Consumo", "Kilometragem", "Tipo"
				BancoDados x = new BancoDados();
				BancoDados.conecta();
				ResultSet conv;
				conv = x.Consultar(comandosql);
				ArrayList<String> mula = new ArrayList<String>();	
				try {
					conv.beforeFirst();
					
					
					while(conv.next()){
						
						mula.add(conv.getString("nome"));
					}
					conv.close();
				} catch (SQLException est) {}
									
				
				    String[] choices = (String[]) mula.toArray(new String[mula.size()]);
				    String input = (String) JOptionPane.showInputDialog(null, "Contas - Escolha",
				        "Escolha o Fornecedor : ", JOptionPane.QUESTION_MESSAGE, null, // Use
				                                                                        // default
				                                                                        // icon
				        choices, // Array of choices
				        choices[1]); // Initial choice
				    System.out.println(input);
				    cc_nome.setText(input);
			
			
			}
		});
		btnNewButton.setBounds(414, 204, 131, 31);
		panelContas.add(btnNewButton);
		cc_nome.setBounds(28, 204, 375, 31);
		panelContas.add(cc_nome);
		cc_nome.setColumns(10);
		
		lblNomerazoSocial = new JLabel("Nome/Raz\u00E3o Social : ");
		lblNomerazoSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomerazoSocial.setBounds(28, 181, 243, 24);
		panelContas.add(lblNomerazoSocial);
		areceber
				.setToolTipText("O Contas a Receber é utilizado para controlar todos os recebimentos da empresa.");
		areceber.setOpaque(false);
		areceber.setHorizontalAlignment(SwingConstants.CENTER);
		areceber.setFont(new Font("Khmer UI", Font.BOLD, 14));
		areceber.setBounds(544, 60, 173, 35);
		panelContas.add(areceber);
		
		apagar = new JRadioButton("Contas a Pagar");
		apagar.setSelected(true);
		apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				areceber.setSelected(false);
				
				
				
			}
		});
		apagar
				.setToolTipText("O Contas a Pagar é utilizado para controlar todos os pagamentos/despesas da empresa!");
		apagar.setOpaque(false);
		apagar.setHorizontalAlignment(SwingConstants.CENTER);
		apagar.setFont(new Font("Khmer UI", Font.BOLD, 14));
		apagar.setBounds(384, 60, 145, 35);
		panelContas.add(apagar);
		
		
		comboQuem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboQuem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		comboQuem.setBounds(857, 61, 139, 32);
		comboQuem.addItem("Cliente");
		comboQuem.addItem("Fornecedor");
		comboQuem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Object item = evt.getItem();
				String tipoConsulta = item.toString();
				if (tipoConsulta.equals("Cliente")) {
					//lblPessoa.setText("Cliente");
					
				}
				else if (tipoConsulta.equals("Fornecedor")) {
					//lblPessoa.setText("Fornecedor");
					
				}
			}
		});
		panelContas.add(comboQuem);
		
		
		JMenuBar menuBar_4 = new JMenuBar();
		menuBar_4.setBounds(414, 0, 531, 32);
		panelContas.add(menuBar_4);
		
		btSalvar = new JButton("Salvar");
		menuBar_4.add(btSalvar);
		btSalvar.setToolTipText("alt + Enter");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btSalvar.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606570_floppy-128.png")));
		btSalvar.setMnemonic(KeyEvent.VK_ENTER);
		btSalvar.setForeground(Color.BLACK);
		btSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		JButton button_5 = new JButton("Excluir");
		menuBar_4.add(button_5);
		button_5.setToolTipText("alt + Delete");
		button_5.setEnabled(false);
		button_5.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		button_5.setMnemonic(KeyEvent.VK_DELETE);
		button_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button_5.setAlignmentX(0.5f);
		
		btLimpar = new JButton("Limpar");
		menuBar_4.add(btLimpar);
		btLimpar.setToolTipText("alt + Backspace");
		btLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btLimpar.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/Gnome-edit-clear.png")));
		btLimpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
		btLimpar.setForeground(Color.BLACK);
		btLimpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		JButton button_6 = new JButton("Alterar");
		menuBar_4.add(button_6);
		button_6.setToolTipText("alt + Space");
		button_6.setEnabled(false);
		button_6.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606608_pencil-128.png")));
		button_6.setMnemonic(KeyEvent.VK_SPACE);
		button_6.setFont(new Font("Kalinga", Font.PLAIN, 14));
		button_6.setFocusTraversalPolicyProvider(true);
		button_6.setFocusCycleRoot(true);
		button_6.setAlignmentX(0.5f);
		
		btImprimir2 = new JButton("Imprimir");
		menuBar_4.add(btImprimir2);
		btImprimir2.setToolTipText("alt + P");
		btImprimir2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btImprimir2.setIcon(new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		btImprimir2.setMnemonic(KeyEvent.VK_P);
		btImprimir2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		lblSelecione = new JLabel("Selecione");
		lblSelecione.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblSelecione.setBounds(767, 61, 80, 32);
		panelContas.add(lblSelecione);
		
		JLabel label_13 = new JLabel("");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"SELECIONAR A\u00C7\u00C3O", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(64, 64, 64)));
		label_13.setBounds(10, 43, 1325, 69);
		panelContas.add(label_13);
		
		labelPlanoFundoContas = new JLabel("");
		labelPlanoFundoContas.setIcon(new ImageIcon(Financeiro.class
				.getResource("/papel_parede/01.jpg")));
		labelPlanoFundoContas.setVerticalAlignment(SwingConstants.TOP);
		labelPlanoFundoContas.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPlanoFundoContas.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlanoFundoContas.setBounds(0, 0, 1359, 673);
		panelContas.add(labelPlanoFundoContas);
		
		JPanel panelRelatorios = new JPanel();
		panelRelatorios.setLayout(null);
		panelRelatorios.setFont(new Font("Kalinga", Font.PLAIN, 14));
		panelRelatorios.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPaneFinanceiro.addTab("Relatorios", new ImageIcon(Financeiro.class
				.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
				panelRelatorios, null);
		
		JMenuBar menuBar_5 = new JMenuBar();
		menuBar_5.setBounds(602, 0, 146, 32);
		panelRelatorios.add(menuBar_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 65, 855, 238);
		panelRelatorios.add(scrollPane);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
		
		null), "RELA\u00C7\u00C3O MOTORISTA / VE\u00CDCULO",
		
		TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
		label_6.setBounds(10, 43, 878, 272);
		panelRelatorios.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
		
		null), "ENTREGAS", TitledBorder.LEFT, TitledBorder.TOP, null,
		
		new Color(64, 64, 64)));
		label_7.setBounds(10, 326, 1331, 320);
		panelRelatorios.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
		
		null), "ENTREGAS", TitledBorder.LEFT, TitledBorder.TOP, null,
		
		new Color(64, 64, 64)));
		label_8.setBounds(898, 43, 443, 272);
		panelRelatorios.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Financeiro.class.getResource("/papel_parede/01.jpg")));
		label_9.setVerticalAlignment(SwingConstants.TOP);
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Arial", Font.PLAIN, 12));
		label_9.setBounds(0, 0, 1348, 664);
		panelRelatorios.add(label_9);
		
		this.setSize(new Dimension(1366, 768));
		// this.setSize(toolkit.getScreenSize());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	protected static void limpaDados() {
		Data1.setText(null);
		Hora1.setText(null);
		Vendedor1.setText(null);
		Valor1.setText(null);
		SaldoInicial.setText(null);
		SaldoFinal.setText(null);
		PrimeiroMovimento.setText(null);
		UltimoMovimento.setText(null);
		Entradas.setText(null);
		Saidas.setText(null);
		
	}
	
	protected static void AbrirCaixa() {
		
		String comandosql = "INSERT INTO caixa (data, hora, usuario, valor, saldoInicial, saldoFinal, primeiroMovimento, ultimoMovimento, entradas, saidas) "
				+ "VALUES('"
				+ Data1.getText()
				+ "','"
				+ Hora1.getText()
				+ "','"
				+ Vendedor1.getText()
				+ "','"
				+ Valor1.getText()
				+ "','"
				+ SaldoInicial.getText()
				+ "','"
				+ SaldoFinal.getText()
				+ "','"
				+ PrimeiroMovimento.getText()
				+ "','"
				+ UltimoMovimento.getText()
				+ "','"
				+ Entradas.getText() + "','" + Saidas.getText() + "')";
		
		x.grava(comandosql);
		JOptionPane.showMessageDialog(null, " Dados Salvos com sucesso!",
				"Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
		// Financeiro.limpaDados();
	}
	
	private static void TabelaHistorico() {
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		scrollPane_1.setBounds(156, 169, 1060, 451);
		panelGiroEstoque.add(scrollPane_1);
		
		Tabela_hist = new JTable();
		Tabela_hist.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Tabela_hist.setSurrendersFocusOnKeystroke(true);
		Tabela_hist.setShowVerticalLines(true);
		Tabela_hist.setShowHorizontalLines(true);
		Tabela_hist.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null,
				null, null, null, null }, },
				new String[] { "Codigo Produto", "Produto", "Estoque Inicial ", "Entrada",
						"Saida", "Estoque Final", "Giro no Periodo" }) {
			
			private static final long	serialVersionUID	= 1L;
			boolean[]				columnEditables	= new boolean[] { true, false,
													true, true, true,
													true, true, true };
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tabela_hist.getColumnModel().getColumn(0).setMinWidth(20);
		Tabela_hist.getColumnModel().getColumn(3).setMinWidth(18);
		Tabela_hist.getColumnModel().getColumn(4).setPreferredWidth(207);
		Tabela_hist.getColumnModel().getColumn(5).setPreferredWidth(193);
		Tabela_hist.getColumnModel().getColumn(6).setPreferredWidth(99);
		scrollPane_1.setViewportView(Tabela_hist);
		modelo2 = (DefaultTableModel) Tabela_hist.getModel();
		modelo2.removeRow(0);
		
	}
	
	protected static void SelecionarPapelParedeFinanceiro() {
		
		JFileChooser selecionarArquivo = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG E BMP",
				"jpg", "gif", "png", "bmp");
		selecionarArquivo.setFileFilter(filter);
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		
		if (retorno == JFileChooser.APPROVE_OPTION) {
			
			// File pathInicial = new File(caminhoUltimoArquivo);
			// selecionarArquivo.setCurrentDirectory(pathInicial);
			
			// No exemplo que estou utilizando isso não irá funcionar, por
			// que
			// não possui um JFrame, Classe e nem ao menos um botão
			// controlando
			// a abertura do JFileChooser, então não existe uma classe
			// "Pai"
			// que
			// eu possa guardar a variável caminhoUltimoArquivo, mas se
			// você
			// está precisando utilizar o JFileChooser, obviamente tem
			// uma(s)
			// janela(s) pai(s) para fazer esse controle.
			
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			// caminhoUltimoArquivo =
			// diretorio.substring(0,diretorio.lastIndexOf("\\"));
			
			// estou fazendo um SubString, pegando esse caminho completo
			// da
			// primeira letra até a ultima barra encontrada,
			// desta forma conseguimos pegar somente a pasta do arquivo
			// selecionado.
			
			labelFundoAbrirCaixa.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoFluxoCaixa.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoGiroEstoque.setIcon(new javax.swing.ImageIcon(diretorio));
			labelPlanoFundoContas.setIcon(new javax.swing.ImageIcon(diretorio));
			
			caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
					.replace("\\", "~").toString());
			System.out.print(diretorio);
			
		}
	}
}
