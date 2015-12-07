package Solid.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
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
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import Solid.controller.BancoDados;
import Solid.controller.ChatController;
import Solid.controller.Metodos;
import Solid.controller.SuprimentosController;
import Solid.model.LookAheadTextField;
import Solid.model.PPReport;
import Solid.model.StringArrayLookAhead;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class Suprimentos extends JFrame {
	
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	private static final long		serialVersionUID	= 3828356412266482145L;
	
	// instancia a classe do banco para conexÃ£o
	static BancoDados				x			= new BancoDados();
	
	// instancia a classe para impressao
	PPReport					report		= new PPReport();
	
	// variaveis do sistema
	
	private JMenu				menuArquivo;
	private JMenu				menuConfigurao;
	private JMenu				menuLogout;
	private JMenu				menuAjuda;
	private JMenuBar				menuBar;
	private JMenuItem				menuPrincipal;
	private JMenuItem				menuSair;
	private JMenuItem				menuDefinirPapelParede;
	private JMenuItem				menuLogout2;
	private JMenuItem				menuAbrirAjuda;
	public static JTabbedPane		tabbedPaneSuprimentos;
	public static JPanel			panelCadastrarProduto, panelFornecedor;
	public static JInternalFrame		internalFrame;
	public static JPanel			panelAddproduto;
	public static JPanel			panelCadastrarMateriaPrima;
	public static JComboBox<String>	comboUnidade2;
	public static JComboBox<String>	comboBox;
	public static JComboBox<String>	comboremoveItem1;
	public static JComboBox<String>	comboNomeEst;
	public static JComboBox<String>	comboLocalEstoque4, comboBox_3, comboBox_1;
	public static JComboBox<String>	comboDesejaAdicionar;
	public static JComboBox<String>	comboBox_2;
	public static JComboBox<String>	comboBox_cidade;
	public static JComboBox<String>	comboBox_estado;
	public static JComboBox<String>	comboBoxTipoProd, comboUnidade;
	public static JComboBox<String>	comboBox_4;
	
	static DefaultTableCellRenderer	central		= new DefaultTableCellRenderer();
	
	public static JFormattedTextField	validade1;
	public static JTextField		estoqueminconsulta;
	public static JTextField		unidadeconsulta;
	public static JTextField		codigo5;
	public static JTextField		endereco;
	public static JTextField		numero;
	public static JTextField		complemento;
	public static JTextField		bairro;
	public static JTextField		estoqueMinimoConsulta2;
	public static JTextField		unidadeconsulta2;
	public static JTextField		caminho2;
	public static JTextField		estado;
	public static JTextField		cidade;
	public static JTextField		caminho3;
	public static JTextField		ipi_1;
	public static JTextField		icms_1;
	public static JTextField		codigo1;
	public static JTextField		nome1;
	public static JTextField		numeroLote;
	public static JTextField		tipoConsultaProd;
	public static JTextField		localEstoque_1;
	public static JFormattedTextField	dataCompra_1;
	public static JTextField		precoCusto;
	public static JTextField		iss_1;
	public static JTextField		pis_1;
	public static JTextField		cofins_1;
	public static JTextField		margemLucro;
	public static JTextField		precoVenda;
	public static JTextField		numeroLote2;
	public static JTextField		codigo2;
	public static JTextField		nome2;
	public static JTextField		tipoConsultaMP;
	public static JTextField		localEstoque;
	public static JTextField		quantR;
	public static JTextField		codigoEst;
	public static JFormattedTextField	validadeEst;
	public static JTextField		notaFiscalEst;
	public static JFormattedTextField	dataCompraEst;
	public static JTextField		numeroLoteEst;
	public static JTextField		precoUnidadeEst;
	public static JTextField		estoqueMinimoEst;
	public static JTextField		unidadeEst, quantidadeAdicionada;
	public static JTextField		estoqueAtual;
	public static JTextArea			descricaoProduto;
	public static JFormattedTextField	telefone2;
	public static JFormattedTextField	celular2;
	public static JTextField		cnpj;
	public static JTextField		iE;
	public static JFormattedTextField	telefone1;
	public static JFormattedTextField	celular1;
	public static JTextField		vendedor;
	public static JTextField		precoPor2;
	public static JTextField		quantidade;
	public static JTextField		caminho;
	public static JFormattedTextField	cep;
	public static JTextField		dataEntrada;
	public static JTextField		nomeEst;
	public static JTextField		nomeItemEst;
	public static JTextField		localEstoqueEst;
	public static JButton			buttonConsultarMateriaPrima;
	public static JTextArea			descricaoMateriaPrima2, descricaoEst;
	public static LookAheadTextField	NomeFornecedor;
	
	public static JSpinner			estoqueMinimo1, estoqueMinimo2;
	
	public static NumberFormat		nf;
	public static JButton			btnAddItem, salvarMP, buttonAnteriorF, btnPrximoF;
	public static JButton			btnRemItem, button_4;
	public static JButton			atualizarImagem, btnAtualizr;
	private JButton				btDeletarItem;
	private JButton				btCancelar;
	public static JButton			btnAnterior2;
	public static JButton			btnProximo2;
	static private JButton			limpar;
	static private JButton			salvar, buttonConsultarFornecedor,
			buttonConsultarEstoque;
	static private JButton			btnCalcular;
	static private JButton			btImagem;
	static private JButton			btnSelecionar;
	static private JButton			buttonSalvarEst;
	public static JButton			btnAnterior;
	public static JButton			wbtnProximo;
	private static JButton			consultarProduto;
	public static JButton			btnImagem, atualizarImagemMP;
	public static JButton			button_1;
	public static JButton			button_2;
	public static JButton			button_5;
	public static JButton			button_6;
	public static JPanel			panelPedidoCompra;
	public static JButton			button;
	public static JButton			button_3;
	public static JButton			button_8;
	public static JButton			btnCancelar;
	public static JButton			AlterarProduto;
	public static JButton			btnCancelar_1;
	public static JButton			button_11;
	public static JButton			btnCancelar_2;
	public static JButton			button_13;
	public static JButton			button_14;
	public static JButton			button_15;
	public static JButton			button_16;
	public static JButton			button_17, btnProximo;
	
	public static JButton			button_atualizarImagemForn;
	static public JRadioButton		ipi;
	static public JRadioButton		iss;
	static public JRadioButton		rdbtnConsultarEstoque, rdbtnCadastrar;
	static public JRadioButton		pis;
	static public JRadioButton		icms;
	static public JRadioButton		cofins;
	static public JRadioButton		fichaSim;
	static public JRadioButton		fichaNao;
	static public JRadioButton		radioProduto;
	static public JRadioButton		radioMateriaPrima;
	static public JRadioButton		radioNovo;
	static public JRadioButton		radioCadastro;
	static public JRadioButton		rdbtnConsultarProduto;
	static public JRadioButton		rdbtnCadastrarProduto;
	public JRadioButton			rdbtnCadastrarFornecedor;
	public JRadioButton			rdbtnConsultarFornecedor;
	public JRadioButton			rdbtnCadastrarMp;
	public static JRadioButton		rdbtnConsultarMP;
	public static JRadioButton		radioButton;
	public JRadioButton			rdbtnNome;
	private static JLabel			lblUnidade_2;
	static private JLabel			Rg, lblPor2;
	public static JLabel			labelFotoMateriaPrima;
	private static JLabel			lblPor3;
	static private JLabel			piscaTipo;
	static private JLabel			labelficha;
	static private JLabel			Nom;
	static private JLabel			NumF;
	static private JLabel			ec;
	static private JLabel			email;
	static private JLabel			num;
	static private JLabel			Rsen;
	static private JLabel			labelFundoProduto;
	static private JLabel			labelFundoEstoque;
	static private JLabel			usu;
	static private JLabel			niv;
	static private JLabel			numlot;
	public static JLabel			labelFotoProduto;
	public static JLabel			lblUnidade;
	static private JLabel			lblQuantidade;
	static private JLabel			lblQuantidade_1;
	static private JLabel			lblMp;
	static private JLabel			labelCodigo;
	static private JLabel			labelFundoMateriaPrima;
	static private JLabel			labelValidade;
	static private JLabel			labelNotaFiscal;
	static private JLabel			labelUnidade;
	static private JLabel			labelLocalEstoque;
	static private JLabel			labelDataCompra;
	static private JLabel			labelNumeroLote;
	public static JLabel			labelFotoEstoque;
	static private JLabel			labelFornecedor;
	static private JLabel			labelPreco;
	static private JLabel			labelUnidade_1;
	static private JLabel			labelEstoqueMinimo;
	static private JLabel			labelQuantidade;
	static private JLabel			labelEstoqueAtual;
	static private JLabel			labelNome;
	private JLabel				lblOQueGostaria;
	private JLabel				lblPor_1;
	private JLabel				piscaTipo2;
	private JLabel				label_3;
	private JLabel				label_4;
	private JLabel				label_5;
	private JLabel				label_6;
	private JLabel				label_8;
	private JLabel				label_10;
	private JLabel				label_11;
	private JLabel				label_13;
	private static JLabel			labelFundoFornecedor;
	private JLabel				lblItem;
	private JLabel				label_2;
	public static JLabel			labelFotoFornecedor;
	private JLabel				lblDescrio;
	private JLabel				lblDescrio_1;
	private JLabel				lblPor;
	private JComboBox<String>		comboPor;
	
	static public String			codprod, unidade, ficha = "não", tipoConsulta = "",
			tipoConsulta2 = "", tipoConsulta3 = "", tipoInsereEstoque = "";
	
	public static int				sn			= 0, contLinha = 0, tipo,
			contLinhaEst = 0;
	
	public static double			pv			= 0, precoUnidade, PrCusto = 0;
	
	public static DefaultTableModel	modeloficha, modeloficha2;
	
	private static JTable			tabelaFichaTecnica, tabelaFichaTecnica2;
	
	private static SimpleDateFormat	formato;
	private static Date			data;
	
	public static JScrollPane		scrollPane, scrollPane_2;
	private JMenuItem				menuAbrirBatePapo;
	private static JLabel			labelFundoCompra;
	private JLabel				lblNumeroPedido;
	private JTextField			NumeroPedido;
	private JLabel				lblFornecedor;
	public static JTextField		Fornecedor;
	private JLabel				lblDataPedido;
	public static JFormattedTextField	DataPedido;
	public static JFormattedTextField	PrazoRecebimento;
	private JLabel				lblPrazoDeRecebimento;
	public static JComboBox<String>	Produtos;
	private JLabel				lblProdutos;
	public static JTextField		Quantidade;
	private JLabel				lblQuantidade_2;
	public static JTextField		PrecoUnitario;
	private JLabel				lblPreoUnitrio;
	private JLabel				label_17;
	public static JFormattedTextField	Vencimento;
	public static JTextField		ValorParcela;
	public static JTextField		Observacao;
	private JLabel				lblAdicionarImposto;
	private JLabel				label_18;
	private JLabel				label_19;
	private JLabel				label_20;
	public static JTextField		codigoFornecedorEst;
	private JLabel				label_28;
	private JLabel				label_29;
	private JLabel				label_30;
	private JLabel				label_31;
	private JTextField			ieEstoque;
	private JButton				btnAtualizar;
	private static JButton			btnAtualizar_1;
	private JMenuBar				menuBar_1;
	private JMenuBar				menuBar_2;
	private JMenuBar				menuBar_3;
	private JMenuBar				menuBar_4;
	private JMenuBar				menuBar_5;
	public static JPanel			panelRelatorios;
	private JLabel				label_49;
	private JLabel				label_50;
	private JLabel				label_34;
	private JLabel label_9;
	private JLabel label_12;
	private JLabel label_16;
	private JLabel label;
	private JLabel label_7;
	
	@SuppressWarnings("serial")
	public Suprimentos() {
		super();
		setResizable(false);
		try {
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			setIconImage(Toolkit
					.getDefaultToolkit()
					.getImage(Suprimentos.class
							.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			setName("suprimentos");
			
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			setTitle("SUPRIMENTOS");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			getContentPane().setBackground(new Color(245, 245, 245));
			getContentPane().setLayout(null);
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			@SuppressWarnings("unused")
			final Dimension scrnsize = toolkit.getScreenSize();
			
			nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			
			/*
			 * 
			 * Menu Janela
			 */
			
			menuBar = new JMenuBar();
			getContentPane().add(menuBar);
			menuBar.setForeground(new Color(0, 0, 0));
			menuBar.setBounds(0, 0, 1356, 32);
			
			menuArquivo = new JMenu("Arquivo");
			menuArquivo.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
			menuArquivo.setForeground(Color.BLACK);
			menuArquivo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuArquivo);
			
			menuPrincipal = new JMenuItem("Menu Principal");
			menuPrincipal.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuPrincipal.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606621_678085-house-128.png")));
			menuPrincipal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int sair = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja sair?", "Fechamento de Programa",
							JOptionPane.YES_NO_OPTION);
					if (sair == 0) {
						// BD.desconecta();
						contLinhaEst = 0;
						Suprimentos.this.dispose();
						new Menu();
					}
					UIManager.put("OptionPane.yesButtonText", "Sim");
					UIManager.put("OptionPane.noButtonText", "Não");
				}
			});
			menuArquivo.add(menuPrincipal);
			
			menuSair = new JMenuItem("Sair");
			menuSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuSair.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/desliga24px.png")));
			menuArquivo.add(menuSair);
			
			menuConfigurao = new JMenu("Configura\u00E7\u00E3o");
			menuConfigurao
					.setIcon(new ImageIcon(
							Suprimentos.class
									.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
			menuConfigurao.setForeground(Color.BLACK);
			menuConfigurao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuConfigurao);
			
			menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
			menuDefinirPapelParede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Suprimentos.SelecionarPapelParedeSuprimentos();
				}
			});
			menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuDefinirPapelParede.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606663_image-128.png")));
			menuConfigurao.add(menuDefinirPapelParede);
			
			menuAbrirBatePapo = new JMenuItem("Abrir Bate-Papo");
			menuAbrirBatePapo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ChatController.main(null);
				}
			});
			menuAbrirBatePapo.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
			menuAbrirBatePapo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuConfigurao.add(menuAbrirBatePapo);
			
			menuLogout = new JMenu("Logout");
			menuLogout.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
			menuLogout.setForeground(Color.BLACK);
			menuLogout.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuLogout);
			
			menuLogout2 = new JMenuItem("Logout");
			menuLogout2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuLogout2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
			menuLogout2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Suprimentos.this.dispose();
					new Login().setVisible(true);
				}
			});
			menuLogout.add(menuLogout2);
			
			menuAjuda = new JMenu("Ajuda");
			menuAjuda.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
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
			menuAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuAbrirAjuda.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
			menuAjuda.add(menuAbrirAjuda);
			menuSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Metodos.formWindowClosing(null);
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			tabbedPaneSuprimentos = new JTabbedPane(JTabbedPane.TOP);
			tabbedPaneSuprimentos.setFont(new Font("Kalinga", Font.PLAIN, 13));
			tabbedPaneSuprimentos.setBounds(0, 34, 1356, 695);
			getContentPane().add(tabbedPaneSuprimentos);
			
			/*
			 * 
			 * Panel Cadastrar Produto
			 */
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelCadastrarProduto = new JPanel();
			panelCadastrarProduto.setToolTipText("");
			panelCadastrarProduto.setBackground(SystemColor.inactiveCaptionBorder);
			panelCadastrarProduto.setBounds(new Rectangle(0, 0, 0, 500));
			
			margemLucro = new JTextField();
			margemLucro.setForeground(Color.BLACK);
			margemLucro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					margemLucro.setText(margemLucro.getText().replaceAll("[^0-9]", ""));
					// margemLucro.setText(margemLucro.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			margemLucro.setSelectionColor(SystemColor.textHighlight);
			margemLucro.setHorizontalAlignment(SwingConstants.CENTER);
			margemLucro.setBounds(817, 493, 184, 32);
			margemLucro.setFont(new Font("Kalinga", Font.BOLD, 15));
			margemLucro.setColumns(10);
			margemLucro.setText("0");
			
			// Inicio.rd=1;
			
			internalFrame = new JInternalFrame("Remover Mat\u00E9ria Prima");
			internalFrame.setFrameIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606795_678095-trashcan-128.png")));
			
			internalFrame.setClosable(true);
			internalFrame.setBounds(489, 321, 368, 175);
			panelCadastrarProduto.add(internalFrame);
			internalFrame.getContentPane().setLayout(null);
			
			comboremoveItem1 = new JComboBox<String>();
			comboremoveItem1.setForeground(Color.BLACK);
			comboremoveItem1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboremoveItem1.setEditable(true);
			comboremoveItem1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboremoveItem1.setBounds(17, 6, 317, 32);
			internalFrame.getContentPane().add(comboremoveItem1);
			comboremoveItem1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					// tipoConsulta = item.toString();
					String sql2 = "select * from materia_p where nome = '"
							+ item.toString() + "'";
					ResultSet rs3 = x.Consultar(sql2);
					try {
						while (rs3.next()) {
							lblUnidade_2.setText(rs3.getString("unidade"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
					nome1.requestFocus();
				}
			});
			
			btCancelar = new JButton("Cancelar");
			btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btCancelar.setForeground(Color.BLACK);
			btCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btCancelar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					quantR.setText("");
					internalFrame.setVisible(false);
				}
			});
			
			quantR = new JTextField();
			quantR.setSelectionColor(SystemColor.textHighlight);
			quantR.setForeground(Color.BLACK);
			quantR.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					quantR.setText(quantR.getText().replaceAll("[^0-9]", ""));
					// quantR.setText(quantR.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			quantR.setHorizontalAlignment(SwingConstants.CENTER);
			quantR.setFont(new Font("Kalinga", Font.PLAIN, 14));
			quantR.setBounds(141, 56, 70, 32);
			internalFrame.getContentPane().add(quantR);
			
			btCancelar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btCancelar.setBounds(202, 100, 140, 35);
			internalFrame.getContentPane().add(btCancelar);
			internalFrame.setVisible(true);
			internalFrame.setVisible(false);
			
			btDeletarItem = new JButton("Remover");
			btDeletarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btDeletarItem.setForeground(Color.BLACK);
			btDeletarItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btDeletarItem.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btDeletarItem.setBounds(9, 100, 140, 35);
			btDeletarItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					SuprimentosController.RemItem();
					SuprimentosController.CalcularPreco();
				}
			});
			internalFrame.getContentPane().add(btDeletarItem);
			
			lblQuantidade_1 = new JLabel("Quantidade");
			lblQuantidade_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuantidade_1.setIcon(null);
			lblQuantidade_1.setForeground(Color.BLACK);
			lblQuantidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblQuantidade_1.setBounds(43, 56, 99, 32);
			internalFrame.getContentPane().add(lblQuantidade_1);
			
			lblUnidade_2 = new JLabel("Unidade");
			lblUnidade_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblUnidade_2.setForeground(Color.BLACK);
			lblUnidade_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblUnidade_2.setBounds(206, 56, 99, 32);
			internalFrame.getContentPane().add(lblUnidade_2);
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPane.setVisible(false);
			scrollPane.setFont(new Font("Kalinga", Font.PLAIN, 14));
			scrollPane.setFocusable(false);
			scrollPane.setAutoscrolls(true);
			scrollPane.setBounds(30, 498, 721, 127);
			panelCadastrarProduto.add(scrollPane);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			central.setHorizontalAlignment(SwingConstants.CENTER);
			tabelaFichaTecnica = new JTable();
			tabelaFichaTecnica.setForeground(Color.BLACK);
			tabelaFichaTecnica.setModel(new DefaultTableModel(new Object[][] { { "", null,
					null, null, null, null, null }, },
					new String[] { "N\u00BA Item", "Cod MP", "Nome", "Unidade",
							"Pre\u00E7o", "Quant.", "Custo Agregado" }) {
				boolean[]	columnEditables	= new boolean[] { false, false, false, false,
											false, false, false };
				
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tabelaFichaTecnica.getColumnModel().getColumn(0).setPreferredWidth(35);
			tabelaFichaTecnica.getColumnModel().getColumn(1).setPreferredWidth(57);
			tabelaFichaTecnica.getColumnModel().getColumn(2).setPreferredWidth(272);
			tabelaFichaTecnica.getColumnModel().getColumn(3).setPreferredWidth(52);
			tabelaFichaTecnica.getColumnModel().getColumn(4).setPreferredWidth(43);
			tabelaFichaTecnica.getColumnModel().getColumn(5).setPreferredWidth(53);
			tabelaFichaTecnica.setShowVerticalLines(true);
			tabelaFichaTecnica.setShowHorizontalLines(true);
			tabelaFichaTecnica.setRowMargin(1);
			tabelaFichaTecnica.setRowHeight(24);
			tabelaFichaTecnica.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tabelaFichaTecnica.setColumnSelectionAllowed(true);
			tabelaFichaTecnica.setCellSelectionEnabled(true);
			tabelaFichaTecnica.setBackground(new Color(240, 255, 255));
			tabelaFichaTecnica.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tabelaFichaTecnica.setAutoCreateRowSorter(true);
			scrollPane.setViewportView(tabelaFichaTecnica);
			modeloficha = (DefaultTableModel) tabelaFichaTecnica.getModel();
			
			codigo1 = new JTextField();
			codigo1.setForeground(Color.BLACK);
			codigo1.setSelectionColor(SystemColor.textHighlight);
			codigo1.setDisabledTextColor(Color.BLACK);
			codigo1.setEnabled(false);
			codigo1.setHorizontalAlignment(SwingConstants.CENTER);
			codigo1.setBounds(30, 161, 173, 32);
			codigo1.setFont(new Font("Kalinga", Font.BOLD, 15));
			codigo1.setColumns(10);
			codigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			codigo1.setEditable(false);
			panelCadastrarProduto.add(codigo1);
			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				while (rs3.next()) {
					codigo1.setText(rs3.getString("codigoProduto"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			nome1 = new JTextField();
			nome1.setForeground(Color.BLACK);
			nome1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nome1.setText(nome1.getText().replaceAll("[^0-9]",
					// ""));
					nome1.setText(nome1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nome1.setSelectionColor(SystemColor.textHighlight);
			nome1.setHorizontalAlignment(SwingConstants.CENTER);
			nome1.setBounds(213, 161, 381, 32);
			nome1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nome1.setColumns(10);
			nome1.requestFocus();
			panelCadastrarProduto.add(nome1);
			nome1.requestFocus();
			
			ArrayList<String> valores = new ArrayList<String>();
			String sql21 = "SELECT * FROM `funcionarios`";
			ResultSet rs31 = x.Consultar(sql21);
			
			try {
				while (rs31.next()) {
					valores.add(rs31.getString("nome"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			numeroLote = new JTextField();
			numeroLote.setForeground(Color.BLACK);
			numeroLote.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroLote.setText(numeroLote.getText().replaceAll("[^0-9]", ""));
					// numeroLote.setText(numeroLote.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroLote.setSelectionColor(SystemColor.textHighlight);
			numeroLote.setHorizontalAlignment(SwingConstants.CENTER);
			numeroLote.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroLote.setColumns(10);
			numeroLote.setBounds(604, 161, 173, 32);
			panelCadastrarProduto.add(numeroLote);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			estoqueMinimo1 = new JSpinner();
			estoqueMinimo1.setForeground(Color.BLACK);
			estoqueMinimo1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			estoqueMinimo1.setModel(new SpinnerNumberModel(1, 1, 99999, 1));
			estoqueMinimo1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueMinimo1.setBounds(724, 231, 81, 32);
			panelCadastrarProduto.add(estoqueMinimo1);
			
			tipoConsultaProd = new JTextField();
			tipoConsultaProd.setForeground(Color.BLACK);
			tipoConsultaProd.setSelectionColor(SystemColor.textHighlight);
			tipoConsultaProd.setVisible(false);
			
			estoqueminconsulta = new JTextField();
			estoqueminconsulta.setForeground(Color.BLACK);
			estoqueminconsulta.setSelectionColor(SystemColor.textHighlight);
			estoqueminconsulta.setVisible(false);
			estoqueminconsulta.setDisabledTextColor(Color.BLACK);
			estoqueminconsulta.setEnabled(false);
			estoqueminconsulta.setEditable(false);
			estoqueminconsulta.setHorizontalAlignment(SwingConstants.CENTER);
			estoqueminconsulta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueminconsulta.setColumns(10);
			estoqueminconsulta.setBounds(725, 231, 80, 32);
			panelCadastrarProduto.add(estoqueminconsulta);
			
			comboBoxTipoProd = new JComboBox<String>();
			comboBoxTipoProd.setForeground(Color.BLACK);
			comboBoxTipoProd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBoxTipoProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBoxTipoProd.setEditable(false);
			comboBoxTipoProd.setBounds(30, 231, 172, 32);
			panelCadastrarProduto.add(comboBoxTipoProd);
			comboBoxTipoProd.addItem("");
			comboBoxTipoProd.addItem("Perecível");
			comboBoxTipoProd.addItem("Não Perecível");
			tipoConsultaProd.setEnabled(false);
			tipoConsultaProd.setHorizontalAlignment(SwingConstants.CENTER);
			tipoConsultaProd.setBounds(30, 231, 172, 32);
			tipoConsultaProd.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tipoConsultaProd.setColumns(10);
			panelCadastrarProduto.add(tipoConsultaProd);
			
			unidadeconsulta = new JTextField();
			unidadeconsulta.setForeground(Color.BLACK);
			unidadeconsulta.setSelectionColor(SystemColor.textHighlight);
			unidadeconsulta.setVisible(false);
			
			comboUnidade = new JComboBox<String>();
			comboUnidade.setForeground(Color.BLACK);
			comboUnidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboUnidade.setBounds(213, 231, 131, 32);
			panelCadastrarProduto.add(comboUnidade);
			comboUnidade.addItem("");
			comboUnidade.addItem("Caixa");
			comboUnidade.addItem("Duzia");
			comboUnidade.addItem("Litro");
			comboUnidade.addItem("Metro");
			comboUnidade.addItem("Metro quadrado");
			comboUnidade.addItem("Pacote");
			comboUnidade.addItem("Peça");
			comboUnidade.addItem("Quilo");
			comboUnidade.addItem("Unidade");
			unidadeconsulta.setDisabledTextColor(Color.BLACK);
			unidadeconsulta.setEnabled(false);
			unidadeconsulta.setEditable(false);
			unidadeconsulta.setHorizontalAlignment(SwingConstants.CENTER);
			unidadeconsulta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			unidadeconsulta.setColumns(10);
			unidadeconsulta.setBounds(213, 231, 131, 32);
			panelCadastrarProduto.add(unidadeconsulta);
			
			dataCompra_1 = new JFormattedTextField();
			dataCompra_1.setForeground(Color.BLACK);
			dataCompra_1.setSelectionColor(SystemColor.textHighlight);
			try {
				dataCompra_1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			dataCompra_1.setHorizontalAlignment(SwingConstants.CENTER);
			dataCompra_1.setBounds(354, 231, 100, 32);
			dataCompra_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			dataCompra_1.setColumns(10);
			panelCadastrarProduto.add(dataCompra_1);
			String aux1 = ("0");
			String sql = "select * from impostos";
			ResultSet rs = x.Consultar(sql);
			try {
				while (rs.next()) {
					aux1 = (rs.getString("ipi"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			final String imp1 = aux1;
			
			iss_1 = new JTextField();
			iss_1.setForeground(Color.BLACK);
			iss_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					iss_1.setText(iss_1.getText().replaceAll("[^0-9]", ""));
					// iss_1.setText(iss_1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			iss_1.setSelectionColor(SystemColor.textHighlight);
			iss_1.setEnabled(false);
			iss_1.setEditable(false);
			iss_1.setDisabledTextColor(Color.BLACK);
			iss_1.setHorizontalAlignment(SwingConstants.CENTER);
			iss_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			iss_1.setColumns(10);
			iss_1.setBounds(1177, 213, 120, 32);
			String aux2 = ("0");
			iss_1.setText("0");
			if (Inicio.rd == 0) {
				String sql1 = "select * from impostos";
				ResultSet rs1 = x.Consultar(sql1);
				try {
					while (rs1.next()) {
						aux2 = (rs1.getString("iss"));
					}
				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			
			validade1 = new JFormattedTextField();
			validade1.setForeground(Color.BLACK);
			validade1.setSelectionColor(SystemColor.textHighlight);
			try {
				validade1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			validade1.setHorizontalAlignment(SwingConstants.CENTER);
			validade1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			validade1.setColumns(10);
			validade1.setBounds(464, 231, 100, 32);
			panelCadastrarProduto.add(validade1);
			
			localEstoque_1 = new JTextField();
			localEstoque_1.setForeground(Color.BLACK);
			localEstoque_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// localEstoque_1.setText(localEstoque_1.getText().replaceAll("[^0-9]",
					// ""));
					localEstoque_1.setText(localEstoque_1.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			localEstoque_1.setSelectionColor(SystemColor.textHighlight);
			localEstoque_1.setHorizontalAlignment(SwingConstants.CENTER);
			localEstoque_1.setBounds(573, 231, 140, 32);
			localEstoque_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			localEstoque_1.setColumns(10);
			panelCadastrarProduto.add(localEstoque_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPane_1.setBounds(30, 294, 775, 59);
			panelCadastrarProduto.add(scrollPane_1);
			
			descricaoProduto = new JTextArea();
			descricaoProduto.setForeground(Color.BLACK);
			descricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// descricaoProduto.setText(descricaoProduto.getText().replaceAll("[^0-9]",
					// ""));
					descricaoProduto.setText(descricaoProduto.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			descricaoProduto.setFont(new Font("Kalinga", Font.ITALIC, 18));
			descricaoProduto.setLocation(0, 183);
			scrollPane_1.setViewportView(descricaoProduto);
			
			comboBox = new JComboBox<String>();
			comboBox.setForeground(Color.BLACK);
			comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox.setMaximumRowCount(100);
			comboBox.setVisible(false);
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBox.setBounds(30, 463, 309, 32);
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBox.setEditable(true);
			panelCadastrarProduto.add(comboBox);
			
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					
					try {
						String sql = "select * from materia_p where nome = '"
								+ item.toString() + "'";
						ResultSet rs1 = x.Consultar(sql);
						while (rs1.next()) {
							precoUnidade = Double.parseDouble(rs1.getString(
									"precoUnidade").replace(",", "."));
							codprod = (rs1.getString("codigo"));
							unidade = (rs1.getString("unidade"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			
			quantidade = new JTextField();
			quantidade.setForeground(Color.BLACK);
			quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					quantidade.setText(quantidade.getText().replaceAll("[^0-9]", ""));
					// quantidade.setText(quantidade.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			quantidade.setSelectionColor(SystemColor.textHighlight);
			quantidade.setHorizontalAlignment(SwingConstants.CENTER);
			quantidade.setText("0");
			quantidade.setVisible(false);
			quantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			quantidade.setColumns(10);
			quantidade.setBounds(349, 463, 86, 32);
			panelCadastrarProduto.add(quantidade);
			
			pis_1 = new JTextField();
			pis_1.setForeground(Color.BLACK);
			pis_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					pis_1.setText(pis_1.getText().replaceAll("[^0-9]", ""));
					// pis_1.setText(pis_1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			pis_1.setSelectionColor(SystemColor.textHighlight);
			pis_1.setEnabled(false);
			pis_1.setEditable(false);
			pis_1.setDisabledTextColor(Color.BLACK);
			pis_1.setHorizontalAlignment(SwingConstants.CENTER);
			pis_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			pis_1.setColumns(10);
			pis_1.setBounds(1177, 177, 120, 32);
			pis_1.setText("0");
			panelCadastrarProduto.add(pis_1);
			panelCadastrarProduto.add(iss_1);
			final String imp2 = aux2;
			String aux3 = ("0");
			if (Inicio.rd == 0) {
				String sql1 = "select * from impostos";
				ResultSet rs1 = x.Consultar(sql1);
				try {
					while (rs1.next()) {
						aux3 = (rs1.getString("pis"));
					}
				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			final String imp3 = aux3;
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			cofins_1 = new JTextField();
			cofins_1.setForeground(Color.BLACK);
			cofins_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					cofins_1.setText(cofins_1.getText().replaceAll("[^0-9]", ""));
					// cofins_1.setText(cofins_1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			cofins_1.setSelectionColor(SystemColor.textHighlight);
			cofins_1.setEnabled(false);
			cofins_1.setDisabledTextColor(Color.BLACK);
			cofins_1.setEditable(false);
			cofins_1.setHorizontalAlignment(SwingConstants.CENTER);
			cofins_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			cofins_1.setColumns(10);
			cofins_1.setText("0");
			String aux4 = ("0");
			cofins_1.setBounds(1177, 285, 120, 32);
			if (Inicio.rd == 0) {
				String sql1 = "select * from impostos";
				ResultSet rs1 = x.Consultar(sql1);
				try {
					while (rs1.next()) {
						aux4 = (rs1.getString("cofins"));
					}
				}
				catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			
			ipi_1 = new JTextField();
			ipi_1.setForeground(Color.BLACK);
			ipi_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					ipi_1.setText(ipi_1.getText().replaceAll("[^0-9]", ""));
					// ipi_1.setText(ipi_1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			ipi_1.setSelectionColor(SystemColor.textHighlight);
			ipi_1.setText("0");
			ipi_1.setHorizontalAlignment(SwingConstants.CENTER);
			ipi_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			ipi_1.setEnabled(false);
			ipi_1.setEditable(false);
			ipi_1.setDisabledTextColor(Color.BLACK);
			ipi_1.setColumns(10);
			ipi_1.setBounds(1177, 249, 120, 32);
			panelCadastrarProduto.add(ipi_1);
			panelCadastrarProduto.add(cofins_1);
			final String imp4 = aux4;
			String aux5 = ("0");
			String sql1 = "select * from impostos";
			ResultSet rs1 = x.Consultar(sql1);
			try {
				
				while (rs1.next()) {
					aux5 = (rs1.getString("icms"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			final String imp5 = aux5;
			
			icms_1 = new JTextField();
			icms_1.setForeground(Color.BLACK);
			icms_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					icms_1.setText(icms_1.getText().replaceAll("[^0-9]", ""));
					// icms_1.setText(icms_1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			icms_1.setSelectionColor(SystemColor.textHighlight);
			icms_1.setText("0");
			icms_1.setHorizontalAlignment(SwingConstants.CENTER);
			icms_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			icms_1.setEnabled(false);
			icms_1.setEditable(false);
			icms_1.setDisabledTextColor(Color.BLACK);
			icms_1.setColumns(10);
			icms_1.setBounds(1177, 321, 120, 32);
			panelCadastrarProduto.add(icms_1);
			
			precoCusto = new JTextField();
			precoCusto.setForeground(Color.BLACK);
			precoCusto.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					precoCusto.setText(precoCusto.getText().replaceAll("[^0-9]", ""));
					// precoCusto.setText(precoCusto.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			precoCusto.setSelectionColor(SystemColor.textHighlight);
			precoCusto.setText("0,00");
			precoCusto.setHorizontalAlignment(SwingConstants.CENTER);
			precoCusto.setBounds(817, 429, 184, 32);
			precoCusto.setFont(new Font("Kalinga", Font.BOLD, 15));
			precoCusto.setColumns(10);
			panelCadastrarProduto.add(precoCusto);
			try {
			}
			catch (Exception e) {
				System.out.println("error " + e.getMessage());
			}
			panelCadastrarProduto.setLayout(null);
			panelCadastrarProduto.add(margemLucro);
			
			Suprimentos.FichaTecnica();
			
			precoVenda = new JTextField();
			precoVenda.setForeground(Color.BLACK);
			precoVenda.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					precoVenda.setText(precoVenda.getText().replaceAll("[^0-9]", ""));
					// precoVenda.setText(precoVenda.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			precoVenda.setSelectionColor(SystemColor.textHighlight);
			precoVenda.setText("0,00");
			precoVenda.setHorizontalAlignment(SwingConstants.CENTER);
			precoVenda.setFont(new Font("Kalinga", Font.BOLD, 15));
			precoVenda.setColumns(10);
			precoVenda.setBounds(817, 556, 184, 32);
			panelCadastrarProduto.add(precoVenda);
			
			sql = "select * from materia_p order by nome";
			rs = x.Consultar(sql);
			try {
				if (Inicio.rd == 0) {
					comboBox.addItem("");
					while (rs.next()) {
						comboBox.addItem(rs.getString("nome"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setForeground(Color.BLACK);
			comboBox_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_2.setVisible(false);
			comboBox_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBox_2.setEditable(false);
			comboBox_2.setBounds(904, 61, 131, 32);
			panelCadastrarProduto.add(comboBox_2);
			comboBox_2.addItem("");
			comboBox_2.addItem("Código");
			comboBox_2.addItem("Nome");
			comboBox_2.addItem("Lote");
			comboBox_2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					tipoConsulta = item.toString();
					if (tipoConsulta.equals("Código")) {
						
						codigo1.setEnabled(true);
						codigo1.requestFocus();
						codigo1.setEditable(true);
						codigo1.setBorder(new LineBorder(Color.BLUE));
						
						nome1.setEnabled(false);
						nome1.setBorder(null);
						
						tipoConsultaProd.setEnabled(false);
						tipoConsultaProd.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Nome")) {
						
						nome1.setEnabled(true);
						nome1.requestFocus();
						nome1.setBorder(new LineBorder(Color.BLUE));
						
						codigo1.setEnabled(false);
						codigo1.setEditable(false);
						codigo1.setBorder(null);
						
						tipoConsultaProd.setEnabled(false);
						tipoConsultaProd.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Nota")) {
						
						tipoConsultaProd.setEnabled(true);
						tipoConsultaProd.requestFocus();
						tipoConsultaProd.setBorder(null);
						
						codigo1.setEnabled(false);
						codigo1.setEditable(false);
						codigo1.setBorder(null);
						
						nome1.setEnabled(false);
						nome1.setEditable(false);
						nome1.setBorder(null);
						
					}
					else if (tipoConsulta.equals(null)) {
						
						tipoConsultaProd.setBorder(null);
						codigo1.setBorder(null);
						nome1.setBorder(null);
					}
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			rdbtnCadastrarProduto = new JRadioButton("Cadastrar Produto");
			rdbtnCadastrarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnCadastrarProduto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					Suprimentos.SetarProdutoEditavel();
					
					rdbtnCadastrarProduto.setSelected(true);
					rdbtnConsultarProduto.setSelected(false);
					comboBoxTipoProd.setVisible(true);
					lblPor.setVisible(false);
					comboBox_2.setVisible(false);
					margemLucro.setText("00.00");
					fichaNao.setSelected(true);
					
					fichaSim.setSelected(false);
					scrollPane.setVisible(false);
					
					ipi_1.setText("0");
					iss_1.setText("0");
					pis_1.setText("0");
					cofins_1.setText("0");
					icms_1.setText("0");
					consultarProduto.setVisible(false);
					atualizarImagem.setVisible(false);
					btImagem.setVisible(true);
					salvar.setVisible(true);
					
					Suprimentos.limparProduto();
					
					codigo1.setEnabled(false);
					String sql2 = "select * from contadores";
					ResultSet rs3 = x.Consultar(sql2);
					try {
						codigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
						codigo1.setEditable(false);
						while (rs3.next()) {
							codigo1.setText(rs3.getString("codigoProduto"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
					
					precoCusto.setEnabled(true);
					precoCusto.setText("00.00");
					
					precoVenda.setEnabled(true);
					precoVenda.setText("00.00");
					try {
						// here you can put the selected theme class
						// name
						// in JTattoo
						Properties props = new Properties();
						props.put("logoString", "Solid - One");
						McWinLookAndFeel.setCurrentTheme(props);
						UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
						
					}
					catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
				}
			});
			rdbtnCadastrarProduto.setSelected(true);
			rdbtnCadastrarProduto.setOpaque(false);
			rdbtnCadastrarProduto.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnCadastrarProduto.setForeground(Color.BLACK);
			rdbtnCadastrarProduto.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnCadastrarProduto.setBounds(500, 61, 173, 32);
			panelCadastrarProduto.add(rdbtnCadastrarProduto);
			
			rdbtnConsultarProduto = new JRadioButton("Consultar Produto");
			rdbtnConsultarProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnConsultarProduto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					Suprimentos.SetarProdutoNaoEditavel();
					
					rdbtnCadastrarProduto.setSelected(false);
					rdbtnConsultarProduto.setSelected(true);
					salvar.setVisible(false);
					lblPor.setVisible(true);
					comboBox_2.setVisible(true);
					fichaNao.setSelected(true);
					fichaSim.setSelected(false);
					consultarProduto.setVisible(true);
					btImagem.setVisible(false);
					ficha = "não";
					
					Suprimentos.limparProduto();
					try {
						// here you can put the selected theme class
						// name
						// in JTattoo
						Properties props = new Properties();
						props.put("logoString", "Solid - One");
						McWinLookAndFeel.setCurrentTheme(props);
						UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
						
					}
					catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
					catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(Suprimentos.class.getName())
								.log(java.util.logging.Level.SEVERE, null, ex);
					}
				}
			});
			rdbtnConsultarProduto.setOpaque(false);
			rdbtnConsultarProduto.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarProduto.setForeground(Color.BLACK);
			rdbtnConsultarProduto.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnConsultarProduto.setBounds(685, 61, 166, 32);
			panelCadastrarProduto.add(rdbtnConsultarProduto);
			
			icms = new JRadioButton("ICMS");
			icms.setForeground(Color.BLACK);
			icms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			icms.setHorizontalAlignment(SwingConstants.LEFT);
			icms.setFont(new Font("Kalinga", Font.PLAIN, 14));
			icms.setOpaque(false);
			icms.setBounds(1087, 321, 84, 32);
			panelCadastrarProduto.add(icms);
			
			icms.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (icms.isSelected()) {
						icms_1.setEnabled(true);
						icms_1.setText(imp5);
					}
					else {
						icms_1.setEnabled(false);
						icms_1.setText("0");
					}
					SuprimentosController.CalcularCusto();
					SuprimentosController.CalcularPreco();
				}
			});
			
			cofins = new JRadioButton("COFINS");
			cofins.setForeground(Color.BLACK);
			cofins.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cofins.setHorizontalAlignment(SwingConstants.LEFT);
			cofins.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cofins.setOpaque(false);
			cofins.setBounds(1088, 285, 84, 32);
			panelCadastrarProduto.add(cofins);
			
			cofins.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (cofins.isSelected()) {
						cofins_1.setEnabled(true);
						cofins_1.setText(imp4);
					}
					else {
						cofins_1.setEnabled(false);
						cofins_1.setText("0");
					}
					SuprimentosController.CalcularCusto();
					SuprimentosController.CalcularPreco();
				}
			});
			
			pis = new JRadioButton("PIS");
			pis.setForeground(Color.BLACK);
			pis.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pis.setHorizontalAlignment(SwingConstants.LEFT);
			pis.setFont(new Font("Kalinga", Font.PLAIN, 14));
			pis.setOpaque(false);
			pis.setBounds(1089, 177, 84, 32);
			pis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (pis.isSelected()) {
						pis_1.setEnabled(true);
						pis_1.setText(imp3);
					}
					else {
						pis_1.setEnabled(false);
						pis_1.setText("0");
					}
					SuprimentosController.CalcularCusto();
					SuprimentosController.CalcularPreco();
				}
			});
			panelCadastrarProduto.add(pis);
			
			ipi = new JRadioButton("IPI");
			ipi.setForeground(Color.BLACK);
			ipi.setHorizontalAlignment(SwingConstants.LEFT);
			ipi.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ipi.setOpaque(false);
			ipi.setBounds(1088, 249, 84, 32);
			ipi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			ipi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (ipi.isSelected()) {
						ipi_1.setEnabled(true);
						ipi_1.setText(imp1);
					}
					else {
						ipi_1.setEnabled(false);
						ipi_1.setText("0");
					}
					SuprimentosController.CalcularCusto();
					SuprimentosController.CalcularPreco();
				}
			});
			panelCadastrarProduto.add(ipi);
			
			iss = new JRadioButton("ISS");
			iss.setForeground(Color.BLACK);
			iss.setHorizontalAlignment(SwingConstants.LEFT);
			iss.setFont(new Font("Kalinga", Font.PLAIN, 14));
			iss.setOpaque(false);
			iss.setBounds(1089, 213, 84, 32);
			iss.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			iss.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (iss.isSelected()) {
						iss_1.setEnabled(true);
						iss_1.setText(imp2);
					}
					else {
						iss_1.setEnabled(false);
						iss_1.setText("0");
					}
					SuprimentosController.CalcularCusto();
					SuprimentosController.CalcularPreco();
				}
			});
			panelCadastrarProduto.add(iss);
			
			fichaSim = new JRadioButton("Sim");
			fichaSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			fichaSim.setHorizontalAlignment(SwingConstants.CENTER);
			fichaSim.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					fichaNao.setSelected(false);
					fichaSim.setSelected(true);
					btnAddItem.setVisible(true);
					btnRemItem.setVisible(true);
					scrollPane.setVisible(true);
					quantidade.setVisible(true);
					lblQuantidade.setVisible(true);
					comboBox.setVisible(true);
					lblMp.setVisible(true);
					ficha = "sim";
				}
			});
			fichaSim.setOpaque(false);
			fichaSim.setForeground(Color.BLACK);
			fichaSim.setFont(new Font("Kalinga", Font.PLAIN, 14));
			fichaSim.setBounds(405, 400, 55, 32);
			panelCadastrarProduto.add(fichaSim);
			
			fichaNao = new JRadioButton("N\u00E3o");
			fichaNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			fichaNao.setHorizontalAlignment(SwingConstants.CENTER);
			fichaNao.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					fichaNao.setSelected(true);
					fichaSim.setSelected(false);
					btnAddItem.setVisible(false);
					btnRemItem.setVisible(false);
					scrollPane.setVisible(false);
					quantidade.setVisible(false);
					lblQuantidade.setVisible(false);
					comboBox.setVisible(false);
					lblMp.setVisible(false);
					ficha = "não";
				}
			});
			fichaNao.setSelected(true);
			fichaNao.setOpaque(false);
			fichaNao.setForeground(Color.BLACK);
			fichaNao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			fichaNao.setBounds(462, 400, 64, 32);
			panelCadastrarProduto.add(fichaNao);
			
			btnAddItem = new JButton("Adicionar");
			btnAddItem.setForeground(Color.BLACK);
			btnAddItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAddItem.setMnemonic(KeyEvent.VK_INSERT);
			btnAddItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAddItem.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			btnAddItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.addItem();
					SuprimentosController.CalcularPreco();
				}
			});
			btnAddItem.setVisible(false);
			
			menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(296, 0, 1012, 32);
			panelCadastrarProduto.add(menuBar_1);
			
			salvar = new JButton("Salvar");
			salvar.setForeground(Color.BLACK);
			menuBar_1.add(salvar);
			salvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			salvar.setToolTipText("alt + Enter");
			salvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			salvar.setMnemonic(KeyEvent.VK_ENTER);
			salvar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			
			btnAtualizr = new JButton("Atualizar");
			btnAtualizr.setForeground(Color.BLACK);
			menuBar_1.add(btnAtualizr);
			btnAtualizr.setVisible(false);
			btnAtualizr.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.AtualizarProduto();
				}
			});
			btnAtualizr.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnAtualizr.setToolTipText("alt + Enter");
			btnAtualizr.setMnemonic(KeyEvent.VK_ENTER);
			btnAtualizr.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			consultarProduto = new JButton("Consultar");
			consultarProduto.setForeground(Color.BLACK);
			menuBar_1.add(consultarProduto);
			consultarProduto.setMnemonic(KeyEvent.VK_ENTER);
			consultarProduto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SuprimentosController.ConsultarProduto();
				}
			});
			consultarProduto.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			consultarProduto.setVisible(false);
			consultarProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			menuBar_1.add(btnCancelar);
			btnCancelar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.AlterarProduto.setEnabled(false);
					Suprimentos.button_1.setEnabled(false);
					Suprimentos.btnAnterior.setEnabled(false);
					Suprimentos.btnProximo.setEnabled(false);
					btnAtualizr.setVisible(false);
					Suprimentos.SetarProdutoNaoEditavel();
					Suprimentos.limparProduto();
				}
			});
			btnCancelar.setToolTipText("alt + Delete");
			btnCancelar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar.setAlignmentX(0.5f);
			
			limpar = new JButton("Limpar");
			limpar.setForeground(Color.BLACK);
			menuBar_1.add(limpar);
			limpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			limpar.setToolTipText("alt + Backspace");
			limpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			limpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			limpar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			
			AlterarProduto = new JButton("Alterar");
			AlterarProduto.setForeground(Color.BLACK);
			menuBar_1.add(AlterarProduto);
			AlterarProduto.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.SetarProdutoEditavel();
					comboBoxTipoProd.setSelectedItem(tipoConsultaProd.getText());
					comboUnidade.setSelectedItem(unidadeconsulta.getText());
					estoqueMinimo1.setValue(Integer
							.parseInt(estoqueminconsulta.getText()));
					btnAtualizr.setVisible(true);
				}
			});
			AlterarProduto.setEnabled(false);
			AlterarProduto.setToolTipText("alt + Space");
			AlterarProduto.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			AlterarProduto.setMnemonic(KeyEvent.VK_SPACE);
			AlterarProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			AlterarProduto.setFocusTraversalPolicyProvider(true);
			AlterarProduto.setFocusCycleRoot(true);
			AlterarProduto.setAlignmentX(0.5f);
			
			button_1 = new JButton("Imprimir");
			button_1.setForeground(Color.BLACK);
			menuBar_1.add(button_1);
			button_1.setEnabled(false);
			button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// report.Suprimentos();
				}
			});
			button_1.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_1.setToolTipText("alt + P");
			button_1.setMnemonic(KeyEvent.VK_P);
			button_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnAnterior = new JButton("Anterior");
			btnAnterior.setForeground(Color.BLACK);
			menuBar_1.add(btnAnterior);
			btnAnterior.setEnabled(false);
			btnAnterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAnterior.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			btnAnterior.setMnemonic(KeyEvent.VK_P);
			btnAnterior.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnProximo = new JButton("Próximo");
			btnProximo.setForeground(Color.BLACK);
			menuBar_1.add(btnProximo);
			btnProximo.setEnabled(false);
			btnProximo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnProximo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
			btnProximo.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnProximo.setMnemonic(KeyEvent.VK_P);
			btnProximo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			limpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Suprimentos.limparProduto();
					String sql2 = "select * from contadores";
					ResultSet rs3 = x.Consultar(sql2);
					try {
						codigo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
						codigo1.setEditable(false);
						while (rs3.next()) {
							codigo1.setText(rs3.getString("codigoProduto"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
					if (rdbtnConsultarProduto.isSelected() == true)
						codigo1.setText("");
				}
			});
			salvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SuprimentosController.SalvarProduto();
				}
			});
			btnAddItem.setBounds(484, 462, 130, 35);
			panelCadastrarProduto.add(btnAddItem);
			
			btnRemItem = new JButton("Remover");
			btnRemItem.setForeground(Color.BLACK);
			btnRemItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRemItem.setMnemonic(KeyEvent.VK_DELETE);
			btnRemItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnRemItem.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnRemItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					
					comboremoveItem1.removeAllItems();
					comboremoveItem1.addItem("");
					for (int i = 0; i < contLinha; i++) {
						comboremoveItem1.addItem((String) modeloficha.getValueAt(i, 2));
					}
					
					internalFrame.setVisible(true);
				}
			});
			btnRemItem.setVisible(false);
			btnRemItem.setBounds(621, 462, 130, 35);
			panelCadastrarProduto.add(btnRemItem);
			
			// Selecionar Imagem
			btImagem = new JButton("Selecionar");
			btImagem.setForeground(Color.BLACK);
			btImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btImagem.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606659_678090-camera-128.png")));
			btImagem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btImagem.setBounds(839, 277, 145, 35);
			panelCadastrarProduto.add(btImagem);
			btImagem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SuprimentosController.SelecionarFotoProduto();
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			btnCalcular = new JButton("Calcular");
			btnCalcular.setForeground(Color.BLACK);
			btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnCalcular.setToolTipText("alt + =");
			btnCalcular.setMnemonic(KeyEvent.VK_EQUALS);
			btnCalcular.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606619_notepad-128.png")));
			btnCalcular.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SuprimentosController.CalcularPreco();
				}
			});
			btnCalcular.setBounds(830, 595, 159, 40);
			
			panelCadastrarProduto.add(btnCalcular);
			
			atualizarImagem = new JButton("Atualizar Imagem");
			atualizarImagem.setForeground(Color.BLACK);
			atualizarImagem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SuprimentosController.atualizarImagem();
				}
			});
			atualizarImagem.setVisible(false);
			atualizarImagem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			atualizarImagem.setBounds(839, 277, 145, 35);
			panelCadastrarProduto.add(atualizarImagem);
			
			num = new JLabel("Data Cadastro");
			num.setIcon(null);
			num.setFont(new Font("Kalinga", Font.PLAIN, 14));
			num.setBounds(354, 198, 107, 32);
			num.setForeground(Color.BLACK);
			panelCadastrarProduto.add(num);
			
			numlot = new JLabel("N\u00BA do Lote");
			numlot.setIcon(null);
			numlot.setForeground(Color.BLACK);
			numlot.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numlot.setBounds(604, 129, 80, 32);
			panelCadastrarProduto.add(numlot);
			
			labelFotoProduto = new JLabel("(165x115)");
			labelFotoProduto.setForeground(Color.BLACK);
			labelFotoProduto.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoProduto.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_48px/1425606804_pic-128.png")));
			labelFotoProduto.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoProduto.setOpaque(true);
			labelFotoProduto.setBackground(Color.WHITE);
			labelFotoProduto.setBounds(839, 177, 145, 95);
			panelCadastrarProduto.add(labelFotoProduto);
			
			NumF = new JLabel("C\u00F3digo");
			NumF.setIcon(null);
			NumF.setForeground(Color.BLACK);
			NumF.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumF.setBounds(30, 129, 80, 32);
			panelCadastrarProduto.add(NumF);
			
			Nom = new JLabel("Nome");
			Nom.setIcon(null);
			Nom.setForeground(Color.BLACK);
			Nom.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nom.setBounds(213, 129, 49, 32);
			panelCadastrarProduto.add(Nom);
			
			Rg = new JLabel("Tipo");
			Rg.setIcon(null);
			Rg.setForeground(Color.BLACK);
			Rg.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Rg.setBounds(30, 198, 80, 32);
			panelCadastrarProduto.add(Rg);
			
			ec = new JLabel("Unidade");
			ec.setIcon(null);
			ec.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ec.setBounds(213, 198, 80, 32);
			ec.setForeground(Color.BLACK);
			panelCadastrarProduto.add(ec);
			
			email = new JLabel("Local de Estoque");
			email.setIcon(null);
			email.setFont(new Font("Kalinga", Font.PLAIN, 14));
			email.setBounds(573, 198, 131, 32);
			email.setForeground(Color.BLACK);
			panelCadastrarProduto.add(email);
			
			labelficha = new JLabel("Ficha T\u00E9cnica do Produto");
			labelficha.setHorizontalAlignment(SwingConstants.CENTER);
			labelficha.setBounds(189, 399, 216, 32);
			labelficha.setForeground(Color.BLACK);
			labelficha.setFont(new Font("Kalinga", Font.BOLD, 15));
			panelCadastrarProduto.add(labelficha);
			
			usu = new JLabel("Pre\u00E7o de Custo");
			usu.setForeground(Color.BLACK);
			usu.setIcon(null);
			usu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			usu.setBounds(817, 396, 165, 32);
			panelCadastrarProduto.add(usu);
			
			Rsen = new JLabel("Margem de Lucro (%)");
			Rsen.setIcon(null);
			Rsen.setForeground(Color.BLACK);
			Rsen.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Rsen.setBounds(817, 463, 160, 32);
			panelCadastrarProduto.add(Rsen);
			
			niv = new JLabel("Pre\u00E7o de Venda");
			niv.setForeground(Color.BLACK);
			niv.setIcon(null);
			niv.setFont(new Font("Kalinga", Font.PLAIN, 14));
			niv.setBounds(817, 524, 160, 32);
			panelCadastrarProduto.add(niv);
			
			lblMp = new JLabel("Materia Prima");
			lblMp.setIcon(null);
			lblMp.setForeground(Color.BLACK);
			lblMp.setVisible(false);
			lblMp.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblMp.setBounds(30, 430, 120, 32);
			panelCadastrarProduto.add(lblMp);
			
			lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setIcon(null);
			lblQuantidade.setForeground(Color.BLACK);
			lblQuantidade.setVisible(false);
			lblQuantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblQuantidade.setBounds(343, 430, 94, 32);
			panelCadastrarProduto.add(lblQuantidade);
			
			label_13 = new JLabel("Estoque Minimo");
			label_13.setForeground(Color.BLACK);
			label_13.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_13.setBounds(716, 201, 120, 26);
			panelCadastrarProduto.add(label_13);
			
			lblPor = new JLabel("Por ?");
			lblPor.setVisible(false);
			lblPor.setHorizontalAlignment(SwingConstants.CENTER);
			lblPor.setForeground(Color.BLACK);
			lblPor.setFont(new Font("Kalinga", Font.BOLD, 15));
			lblPor.setBounds(859, 61, 38, 32);
			panelCadastrarProduto.add(lblPor);
			
			JLabel lblValidade = new JLabel("Validade");
			lblValidade.setForeground(Color.BLACK);
			lblValidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblValidade.setBounds(464, 198, 100, 32);
			panelCadastrarProduto.add(lblValidade);
			
			lblDescrio = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio.setForeground(Color.BLACK);
			lblDescrio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDescrio.setBounds(30, 264, 94, 32);
			panelCadastrarProduto.add(lblDescrio);
			
			lblAdicionarImposto = new JLabel("Adicionar Imposto");
			lblAdicionarImposto.setForeground(Color.BLACK);
			lblAdicionarImposto.setFont(new Font("Kalinga", Font.BOLD, 14));
			lblAdicionarImposto.setBounds(1124, 145, 160, 32);
			panelCadastrarProduto.add(lblAdicionarImposto);
			
			JLabel label_14 = new JLabel("");
			label_14.setForeground(Color.BLACK);
			label_14.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_14.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS DO PRODUTO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_14.setBounds(10, 116, 1012, 262);
			panelCadastrarProduto.add(label_14);
			
			label_18 = new JLabel("");
			label_18.setForeground(Color.BLACK);
			label_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_18.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "FICHA T\u00C9CNICA DO PRODUTO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_18.setBounds(10, 384, 775, 262);
			panelCadastrarProduto.add(label_18);
			
			label_19 = new JLabel("");
			label_19.setForeground(Color.BLACK);
			label_19.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_19.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "IMPOSTOS DO PRODUTO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_19.setBounds(1034, 116, 299, 262);
			panelCadastrarProduto.add(label_19);
			
			label_20 = new JLabel("");
			label_20.setForeground(Color.BLACK);
			label_20.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_20.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "VALORES DO PRODUTO", TitledBorder.LEFT, TitledBorder.TOP,
					null, new Color(255, 255, 255)));
			label_20.setBounds(798, 384, 223, 262);
			panelCadastrarProduto.add(label_20);
			
			label_9 = new JLabel("");
			label_9.setForeground(Color.BLACK);
			label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_9.setBounds(10, 43, 1325, 69);
			panelCadastrarProduto.add(label_9);
			
			labelFundoProduto = new JLabel("");
			labelFundoProduto.setForeground(Color.BLACK);
			labelFundoProduto.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoProduto.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoProduto.setVerticalAlignment(SwingConstants.TOP);
			labelFundoProduto.setBounds(0, 0, 1358, 674);
			labelFundoProduto.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			panelCadastrarProduto.add(labelFundoProduto);
			
			/*
			 * 
			 * Panel Adcionar Produto ao Estoque
			 */
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelAddproduto = new JPanel();
			panelAddproduto.setBackground(SystemColor.inactiveCaptionBorder);
			panelAddproduto.setLayout(null);
			
			comboDesejaAdicionar = new JComboBox<String>();
			comboDesejaAdicionar.setForeground(Color.BLACK);
			comboDesejaAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboDesejaAdicionar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			comboDesejaAdicionar.setBounds(26, 183, 308, 32);
			comboDesejaAdicionar.addItem("");
			panelAddproduto.add(comboDesejaAdicionar);
			
			comboDesejaAdicionar.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					Suprimentos.limparEstoque();
					if (contLinhaEst > 0) {
						for (int i = 0; i < contLinhaEst; i++) {
							modeloficha2.removeRow(0);
						}
						contLinhaEst = 0;
					}
					if (tipo == 1) {
						try {
							String sql11 = "select * from produtos where nome = '"
									+ item.toString() + "'";
							ResultSet rs11 = x.Consultar(sql11);
							while (rs11.next()) {
								codigoEst.setText(rs11.getString("codigoProduto"));
								precoUnidadeEst.setText(rs11
										.getString("precoVenda"));
								estoqueAtual.setText(rs11.getString("estoqueAtual"));
								estoqueMinimoEst.setText(rs11
										.getString("estoqueMinimo"));
								unidadeEst.setText(rs11.getString("unidade"));
								descricaoEst.setText(rs11
										.getString("descricaoProduto"));
								ImageIcon imagem = new ImageIcon(
										(rs11.getString("imagem").replace("~",
												"\\")));
								Image img = imagem.getImage().getScaledInstance(
										135, 100, Image.SCALE_AREA_AVERAGING);
								labelFotoEstoque.setIcon(new javax.swing.ImageIcon(
										img));
								labelFotoEstoque.setText("");
								
								if (rs11.getString("fichaTecnica").equals("sim")) {
									ResultSet dados2 = x
											.Consultar("select*from fichatecnica where codigoproduto = '"
													+ rs11.getString("codigoProduto")
													+ "'");
									while (dados2.next()) {
										modeloficha2.addRow(new String[] {
												dados2.getString("numeroitem"),
												dados2.getString("codigomp"),
												dados2.getString("nome"),
												dados2.getString("unidade"),
												dados2.getString("preco"),
												dados2.getString("quantidade"),
												dados2.getString("custoagregado") });
										contLinhaEst++;
									}
								}
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
					if (tipo == 2) {
						try {
							String sql11 = "select * from materia_p where nome = '"
									+ item.toString() + "'";
							ResultSet rs11 = x.Consultar(sql11);
							while (rs11.next()) {
								codigoEst.setText(rs11.getString("codigo"));
								precoUnidadeEst.setText(rs11
										.getString("precoUnidade"));
								estoqueAtual.setText(rs11.getString("estoqueAtual"));
								estoqueMinimoEst.setText(rs11
										.getString("estoqueMinimo"));
								unidadeEst.setText(rs11.getString("unidade"));
								descricaoEst.setText(rs11
										.getString("descricaoMateriaPrima"));
								ImageIcon imagem = new ImageIcon(
										(rs11.getString("imagem").replace("~",
												"\\")));
								Image img = imagem.getImage().getScaledInstance(
										135, 100, Image.SCALE_AREA_AVERAGING);
								labelFotoEstoque.setIcon(new javax.swing.ImageIcon(
										img));
								labelFotoEstoque.setText("");
								
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
						
					}
				}
			});
			
			nomeItemEst = new JTextField();
			nomeItemEst.setSelectionColor(SystemColor.textHighlight);
			nomeItemEst.setForeground(Color.BLACK);
			nomeItemEst.setVisible(false);
			nomeItemEst.setHorizontalAlignment(SwingConstants.CENTER);
			nomeItemEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nomeItemEst.setEnabled(false);
			nomeItemEst.setEditable(false);
			nomeItemEst.setDisabledTextColor(Color.BLACK);
			nomeItemEst.setBounds(26, 183, 304, 32);
			panelAddproduto.add(nomeItemEst);
			
			precoUnidadeEst = new JTextField();
			precoUnidadeEst.setForeground(Color.BLACK);
			precoUnidadeEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					precoUnidadeEst.setText(precoUnidadeEst.getText().replaceAll(
							"[^0-9]", ""));
					// precoUnidadeEst.setText(precoUnidadeEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			precoUnidadeEst.setSelectionColor(SystemColor.textHighlight);
			precoUnidadeEst.setEnabled(false);
			precoUnidadeEst.setText("0,00");
			precoUnidadeEst.setDisabledTextColor(Color.BLACK);
			precoUnidadeEst.setEditable(false);
			precoUnidadeEst.setHorizontalAlignment(SwingConstants.CENTER);
			precoUnidadeEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			precoUnidadeEst.setColumns(10);
			precoUnidadeEst.setBounds(344, 183, 117, 32);
			panelAddproduto.add(precoUnidadeEst);
			
			estoqueAtual = new JTextField();
			estoqueAtual.setForeground(Color.BLACK);
			estoqueAtual.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					estoqueAtual.setText(estoqueAtual.getText().replaceAll("[^0-9]", ""));
					// estoqueAtual.setText(estoqueAtual.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			estoqueAtual.setSelectionColor(SystemColor.textHighlight);
			estoqueAtual.setText("0");
			estoqueAtual.setHorizontalAlignment(SwingConstants.CENTER);
			estoqueAtual.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueAtual.setEnabled(false);
			estoqueAtual.setEditable(false);
			estoqueAtual.setDisabledTextColor(Color.BLACK);
			estoqueAtual.setColumns(10);
			estoqueAtual.setBounds(489, 183, 117, 32);
			panelAddproduto.add(estoqueAtual);
			
			estoqueMinimoEst = new JTextField();
			estoqueMinimoEst.setForeground(Color.BLACK);
			estoqueMinimoEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					estoqueMinimoEst.setText(estoqueMinimoEst.getText().replaceAll(
							"[^0-9]", ""));
					// estoqueMinimoEst.setText(estoqueMinimoEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			estoqueMinimoEst.setSelectionColor(SystemColor.textHighlight);
			estoqueMinimoEst.setText("0");
			estoqueMinimoEst.setDisabledTextColor(Color.BLACK);
			estoqueMinimoEst.setEnabled(false);
			estoqueMinimoEst.setEditable(false);
			estoqueMinimoEst.setHorizontalAlignment(SwingConstants.CENTER);
			estoqueMinimoEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueMinimoEst.setColumns(10);
			estoqueMinimoEst.setBounds(616, 183, 125, 32);
			panelAddproduto.add(estoqueMinimoEst);
			
			formato = new SimpleDateFormat("dd/MM/yyyy");
			data = new Date();
			
			dataEntrada = new JTextField("");
			dataEntrada.setForeground(Color.BLACK);
			dataEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					dataEntrada.setText(dataEntrada.getText().replaceAll("[^0-9]", ""));
					// dataEntrada.setText(dataEntrada.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			dataEntrada.setSelectionColor(SystemColor.textHighlight);
			dataEntrada.setDisabledTextColor(Color.BLACK);
			dataEntrada.setEnabled(false);
			dataEntrada.setEditable(false);
			dataEntrada.setHorizontalAlignment(SwingConstants.CENTER);
			dataEntrada.setFont(new Font("Kalinga", Font.PLAIN, 14));
			dataEntrada.setColumns(10);
			dataEntrada.setBounds(761, 183, 117, 32);
			dataEntrada.setText(formato.format(data));
			panelAddproduto.add(dataEntrada);
			
			dataCompraEst = new JFormattedTextField();
			dataCompraEst.setForeground(Color.BLACK);
			dataCompraEst.setSelectionColor(SystemColor.textHighlight);
			try {
				dataCompraEst.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			dataCompraEst.setDisabledTextColor(Color.BLACK);
			dataCompraEst.setHorizontalAlignment(SwingConstants.CENTER);
			dataCompraEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			dataCompraEst.setColumns(10);
			dataCompraEst.setBounds(888, 183, 117, 32);
			panelAddproduto.add(dataCompraEst);
			
			validadeEst = new JFormattedTextField();
			validadeEst.setForeground(Color.BLACK);
			validadeEst.setSelectionColor(SystemColor.textHighlight);
			try {
				validadeEst.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			validadeEst.setDisabledTextColor(Color.BLACK);
			validadeEst.setText("");
			validadeEst.setHorizontalAlignment(SwingConstants.CENTER);
			validadeEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			validadeEst.setColumns(10);
			validadeEst.setBounds(1018, 183, 117, 32);
			panelAddproduto.add(validadeEst);
			
			codigoEst = new JTextField();
			codigoEst.setForeground(Color.BLACK);
			codigoEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					codigoEst.setText(codigoEst.getText().replaceAll("[^0-9]", ""));
					// codigoEst.setText(codigoEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			codigoEst.setSelectionColor(SystemColor.textHighlight);
			codigoEst.setHorizontalAlignment(SwingConstants.CENTER);
			codigoEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codigoEst.setEnabled(false);
			codigoEst.setEditable(false);
			codigoEst.setDisabledTextColor(Color.BLACK);
			codigoEst.setColumns(10);
			codigoEst.setBounds(26, 253, 117, 32);
			panelAddproduto.add(codigoEst);
			
			numeroLoteEst = new JTextField();
			numeroLoteEst.setForeground(Color.BLACK);
			numeroLoteEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroLoteEst.setText(numeroLoteEst.getText()
							.replaceAll("[^0-9]", ""));
					// numeroLoteEst.setText(numeroLoteEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroLoteEst.setSelectionColor(SystemColor.textHighlight);
			numeroLoteEst.setDisabledTextColor(Color.BLACK);
			numeroLoteEst.setHorizontalAlignment(SwingConstants.CENTER);
			numeroLoteEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroLoteEst.setColumns(10);
			numeroLoteEst.setBounds(153, 253, 117, 32);
			panelAddproduto.add(numeroLoteEst);
			
			notaFiscalEst = new JTextField();
			notaFiscalEst.setForeground(Color.BLACK);
			notaFiscalEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					notaFiscalEst.setText(notaFiscalEst.getText()
							.replaceAll("[^0-9]", ""));
					// notaFiscalEst.setText(notaFiscalEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			notaFiscalEst.setSelectionColor(SystemColor.textHighlight);
			notaFiscalEst.setDisabledTextColor(Color.BLACK);
			notaFiscalEst.setHorizontalAlignment(SwingConstants.CENTER);
			notaFiscalEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			notaFiscalEst.setColumns(10);
			notaFiscalEst.setBounds(280, 253, 173, 32);
			panelAddproduto.add(notaFiscalEst);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			comboLocalEstoque4 = new JComboBox<String>();
			comboLocalEstoque4.setForeground(Color.BLACK);
			comboLocalEstoque4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboLocalEstoque4.setFont(new Font("SansSerif", Font.PLAIN, 14));
			comboLocalEstoque4.setBounds(463, 253, 197, 32);
			panelAddproduto.add(comboLocalEstoque4);
			comboLocalEstoque4.addItem("");
			comboLocalEstoque4.addItem("Freezer A");
			comboLocalEstoque4.addItem("Freezer B");
			comboLocalEstoque4.addItem("Geladira");
			comboLocalEstoque4.addItem("Setor A");
			comboLocalEstoque4.addItem("Setor B");
			
			localEstoqueEst = new JTextField();
			localEstoqueEst.setForeground(Color.BLACK);
			localEstoqueEst.setSelectionColor(SystemColor.textHighlight);
			localEstoqueEst.setVisible(false);
			localEstoqueEst.setHorizontalAlignment(SwingConstants.CENTER);
			localEstoqueEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			localEstoqueEst.setEnabled(false);
			localEstoqueEst.setEditable(false);
			localEstoqueEst.setDisabledTextColor(Color.BLACK);
			localEstoqueEst.setBounds(463, 253, 197, 32);
			panelAddproduto.add(localEstoqueEst);
			
			unidadeEst = new JTextField();
			unidadeEst.setForeground(Color.BLACK);
			unidadeEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					unidadeEst.setText(unidadeEst.getText().replaceAll("[^0-9]", ""));
					// unidadeEst.setText(unidadeEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			unidadeEst.setSelectionColor(SystemColor.textHighlight);
			unidadeEst.setHorizontalAlignment(SwingConstants.CENTER);
			unidadeEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			unidadeEst.setEnabled(false);
			unidadeEst.setEditable(false);
			unidadeEst.setDisabledTextColor(Color.BLACK);
			unidadeEst.setBounds(670, 253, 117, 32);
			panelAddproduto.add(unidadeEst);
			
			quantidadeAdicionada = new JTextField();
			quantidadeAdicionada.setForeground(Color.BLACK);
			quantidadeAdicionada.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					quantidadeAdicionada.setText(quantidadeAdicionada.getText()
							.replaceAll("[^0-9]", ""));
					// quantidadeAdicionada.setText(quantidadeAdicionada.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			quantidadeAdicionada.setSelectionColor(SystemColor.textHighlight);
			quantidadeAdicionada.setDisabledTextColor(Color.BLACK);
			quantidadeAdicionada.setText("0");
			quantidadeAdicionada.setHorizontalAlignment(SwingConstants.CENTER);
			quantidadeAdicionada.setFont(new Font("Kalinga", Font.PLAIN, 14));
			quantidadeAdicionada.setColumns(10);
			quantidadeAdicionada.setBounds(797, 253, 125, 32);
			panelAddproduto.add(quantidadeAdicionada);
			
			comboNomeEst = new JComboBox<String>();
			comboNomeEst.setForeground(Color.BLACK);
			comboNomeEst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboNomeEst.setFont(new Font("SansSerif", Font.PLAIN, 14));
			comboNomeEst.setBounds(363, 354, 285, 32);
			panelAddproduto.add(comboNomeEst);
			comboNomeEst.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String sql11 = "select * from fornecedor where nome = '"
							+ item.toString() + "'";
					
					ResultSet rs11 = x.Consultar(sql11);
					try {
						rs11.next();
						codigoFornecedorEst.setText(rs11.getString("codigoFornecedor"));
					}
					catch (SQLException e) {
						System.out.println(e);
					}
				}
			});
			
			nomeEst = new JTextField("");
			nomeEst.setForeground(Color.BLACK);
			nomeEst.setSelectionColor(SystemColor.textHighlight);
			nomeEst.setEnabled(false);
			nomeEst.setDisabledTextColor(Color.BLACK);
			nomeEst.setVisible(false);
			nomeEst.setHorizontalAlignment(SwingConstants.CENTER);
			nomeEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nomeEst.setColumns(10);
			nomeEst.setBounds(363, 354, 285, 32);
			panelAddproduto.add(nomeEst);
			
			codigoFornecedorEst = new JTextField();
			codigoFornecedorEst.setForeground(Color.BLACK);
			codigoFornecedorEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					codigoFornecedorEst.setText(codigoFornecedorEst.getText().replaceAll(
							"[^0-9]", ""));
					// codigoFornecedorEst.setText(codigoFornecedorEst.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			codigoFornecedorEst.setSelectionColor(SystemColor.textHighlight);
			codigoFornecedorEst.setHorizontalAlignment(SwingConstants.CENTER);
			codigoFornecedorEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codigoFornecedorEst.setEnabled(false);
			codigoFornecedorEst.setEditable(false);
			codigoFornecedorEst.setDisabledTextColor(Color.BLACK);
			codigoFornecedorEst.setColumns(10);
			codigoFornecedorEst.setBounds(670, 354, 117, 32);
			panelAddproduto.add(codigoFornecedorEst);
			
			ieEstoque = new JTextField();
			ieEstoque.setForeground(Color.BLACK);
			ieEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					ieEstoque.setText(ieEstoque.getText().replaceAll("[^0-9]", ""));
					// ieEstoque.setText(ieEstoque.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			ieEstoque.setSelectionColor(SystemColor.textHighlight);
			ieEstoque.setHorizontalAlignment(SwingConstants.CENTER);
			ieEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ieEstoque.setEnabled(false);
			ieEstoque.setEditable(false);
			ieEstoque.setDisabledTextColor(Color.BLACK);
			ieEstoque.setColumns(10);
			ieEstoque.setBounds(816, 354, 117, 32);
			panelAddproduto.add(ieEstoque);
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPane_3.setBounds(53, 432, 933, 59);
			panelAddproduto.add(scrollPane_3);
			
			descricaoEst = new JTextArea();
			descricaoEst.setForeground(Color.BLACK);
			descricaoEst.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// descricaoEst.setText(descricaoEst.getText().replaceAll("[^0-9]",
					// ""));
					descricaoEst.setText(descricaoEst.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			descricaoEst.setSelectionColor(SystemColor.scrollbar);
			descricaoEst.setDisabledTextColor(Color.BLACK);
			descricaoEst.setLocation(142, 0);
			descricaoEst.setEnabled(false);
			descricaoEst.setEditable(false);
			descricaoEst.setLineWrap(true);
			descricaoEst.setFont(new Font("Kalinga", Font.ITALIC, 18));
			scrollPane_3.setViewportView(descricaoEst);
			
			final JScrollPane scrollPaneEst = new JScrollPane();
			scrollPaneEst.setVisible(false);
			scrollPaneEst.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPaneEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			scrollPaneEst.setFocusable(false);
			scrollPaneEst.setAutoscrolls(true);
			scrollPaneEst.setBounds(132, 502, 785, 127);
			panelAddproduto.add(scrollPaneEst);
			
			tabelaFichaTecnica2 = new JTable();
			tabelaFichaTecnica2.setForeground(Color.BLACK);
			tabelaFichaTecnica2.setSelectionBackground(SystemColor.scrollbar);
			tabelaFichaTecnica2.setModel(new DefaultTableModel(new Object[][] { { null, null,
					null, null, null, null, null }, },
					new String[] { "N\u00BA Item", "Cod MP", "Nome", "Unidade",
							"Pre\u00E7o", "Quant.", "Custo Agregado" }));
			tabelaFichaTecnica2.getColumnModel().getColumn(0).setPreferredWidth(35);
			tabelaFichaTecnica2.getColumnModel().getColumn(1).setPreferredWidth(57);
			tabelaFichaTecnica2.getColumnModel().getColumn(2).setPreferredWidth(272);
			tabelaFichaTecnica2.getColumnModel().getColumn(3).setPreferredWidth(52);
			tabelaFichaTecnica2.getColumnModel().getColumn(4).setPreferredWidth(43);
			tabelaFichaTecnica2.getColumnModel().getColumn(5).setPreferredWidth(53);
			tabelaFichaTecnica2.setShowVerticalLines(true);
			tabelaFichaTecnica2.setShowHorizontalLines(true);
			tabelaFichaTecnica2.setRowMargin(1);
			tabelaFichaTecnica2.setRowHeight(24);
			tabelaFichaTecnica2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tabelaFichaTecnica2.setColumnSelectionAllowed(true);
			tabelaFichaTecnica2.setCellSelectionEnabled(true);
			tabelaFichaTecnica2.setBackground(new Color(240, 255, 255));
			tabelaFichaTecnica2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tabelaFichaTecnica2.setAutoCreateRowSorter(true);
			scrollPaneEst.setViewportView(tabelaFichaTecnica2);
			modeloficha2 = (DefaultTableModel) tabelaFichaTecnica2.getModel();
			modeloficha2.removeRow(0);
			
			radioProduto = new JRadioButton("Produto");
			radioProduto.setForeground(Color.BLACK);
			radioProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioProduto.setHorizontalAlignment(SwingConstants.CENTER);
			radioProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioProduto.setOpaque(false);
			radioProduto.setBounds(550, 101, 89, 23);
			panelAddproduto.add(radioProduto);
			radioProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFotoEstoque.setIcon(null);
					labelFotoEstoque.setText("Imagem (165x115)");
					scrollPaneEst.setVisible(true);
					tipoInsereEstoque = "produto";
					piscaTipo.setVisible(false);
					tipo = 1;
					sn = 1;
					if (sn == 1) {
						comboDesejaAdicionar.removeAllItems();
						String sql = "select * from produtos order by nome";
						ResultSet rs = x.Consultar(sql);
						try {
							comboDesejaAdicionar.setFont(new Font("Tahoma",
									Font.PLAIN, 14));
							comboDesejaAdicionar.setEditable(false);
							if (Inicio.rd == 0) {
								comboDesejaAdicionar.addItem("");
								while (rs.next()) {
									comboDesejaAdicionar.addItem(rs
											.getString("nome"));
								}
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
						radioMateriaPrima.setSelected(false);
						radioProduto.setSelected(true);
						comboNomeEst.removeAllItems();
						
						String sql10 = "select * from fornecedor order by nome";
						ResultSet rs10 = x.Consultar(sql10);
						try {
							
							while (rs10.next()) {
								comboNomeEst.addItem(rs10.getString("nome"));
							}
							if (rdbtnConsultarEstoque.isSelected() == true) {
								comboNomeEst.setVisible(false);
								
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			});
			
			radioMateriaPrima = new JRadioButton("Materia Prima");
			radioMateriaPrima.setForeground(Color.BLACK);
			radioMateriaPrima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioMateriaPrima.setHorizontalAlignment(SwingConstants.CENTER);
			radioMateriaPrima.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioMateriaPrima.setOpaque(false);
			radioMateriaPrima.setBounds(629, 101, 130, 23);
			panelAddproduto.add(radioMateriaPrima);
			radioMateriaPrima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelFotoEstoque.setIcon(null);
					labelFotoEstoque.setText("Imagem (165x115)");
					scrollPaneEst.setVisible(false);
					piscaTipo.setVisible(false);
					tipoInsereEstoque = "materiaPrima";
					tipo = 2;
					sn = 2;
					if (sn == 2) {
						comboDesejaAdicionar.removeAllItems();
						String sql = "select * from materia_p order by nome";
						ResultSet rs = x.Consultar(sql);
						try {
							comboDesejaAdicionar.setFont(new Font("Tahoma",
									Font.PLAIN, 14));
							comboDesejaAdicionar.setEditable(false);
							if (Inicio.rd == 0) {
								comboDesejaAdicionar.addItem("");
								while (rs.next()) {
									comboDesejaAdicionar.addItem(rs
											.getString("nome"));
								}
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
						radioProduto.setSelected(false);
						radioMateriaPrima.setSelected(true);
						comboNomeEst.removeAllItems();
						
						String sql10 = "select * from fornecedor order by nome";
						ResultSet rs10 = x.Consultar(sql10);
						try {
							comboDesejaAdicionar.setFont(new Font("Tahoma",
									Font.PLAIN, 14));
							comboDesejaAdicionar.setEditable(false);
							if (Inicio.rd == 0) {
								comboNomeEst.addItem("");
								while (rs10.next()) {
									comboNomeEst.addItem(rs10.getString("nome"));
								}
							}
							if (rdbtnConsultarEstoque.isSelected() == true) {
								comboNomeEst.setVisible(false);
								
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			radioNovo = new JRadioButton("Novo");
			radioNovo.setForeground(Color.BLACK);
			radioNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioNovo.setHorizontalAlignment(SwingConstants.CENTER);
			radioNovo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioNovo.setOpaque(false);
			radioNovo.setBounds(260, 360, 74, 23);
			panelAddproduto.add(radioNovo);
			radioNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// Suprimentos.SetarFornecedor();
					
					Suprimentos.LimparFornecedorEst();
					radioNovo.setSelected(true);
					radioCadastro.setSelected(false);
					
					nomeEst.setVisible(true);
					nomeEst.setEnabled(true);
					nomeEst.setEditable(true);
					comboNomeEst.setVisible(false);
					comboNomeEst.setSelectedItem("");
					String sql7 = "select * from contadores";
					@SuppressWarnings("unused")
					ResultSet rs7 = x.Consultar(sql7);
					
				}
			});
			
			radioCadastro = new JRadioButton("Cadastrado");
			radioCadastro.setForeground(Color.BLACK);
			radioCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioCadastro.setSelected(true);
			radioCadastro.setHorizontalAlignment(SwingConstants.CENTER);
			radioCadastro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioCadastro.setOpaque(false);
			radioCadastro.setBounds(139, 360, 121, 23);
			panelAddproduto.add(radioCadastro);
			radioCadastro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Suprimentos.OcultarFornecedor();
					comboNomeEst.setVisible(true);
				}
			});
			
			rdbtnCadastrar = new JRadioButton("Inserir no Estoque");
			rdbtnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnCadastrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Suprimentos.limparEstoque();
					rdbtnConsultarEstoque.setSelected(false);
					rdbtnCadastrar.setSelected(true);
					lblOQueGostaria.setText("O que gostaria de Inserir ?");
					dataEntrada.setText(formato.format(data));
					buttonConsultarEstoque.setVisible(false);
					buttonSalvarEst.setVisible(true);
					dataCompraEst.setEnabled(true);
					numeroLoteEst.setEnabled(true);
					validadeEst.setEnabled(true);
					notaFiscalEst.setEnabled(true);
					quantidadeAdicionada.setEnabled(true);
					radioCadastro.setVisible(true);
					radioNovo.setVisible(true);
					
					comboNomeEst.setVisible(true);
					scrollPaneEst.setVisible(false);
					lblPor_1.setVisible(false);
					radioButton.setVisible(false);
					rdbtnNome.setVisible(false);
					nomeEst.setVisible(false);
					nomeItemEst.setVisible(false);
					comboDesejaAdicionar.setVisible(true);
					radioProduto.setSelected(false);
					radioMateriaPrima.setSelected(false);
					rdbtnNome.setSelected(false);
					radioButton.setSelected(false);
					codigoEst.setEnabled(false);
					localEstoqueEst.setVisible(false);
					comboLocalEstoque4.setVisible(true);
				}
			});
			rdbtnCadastrar.setSelected(true);
			rdbtnCadastrar.setOpaque(false);
			rdbtnCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnCadastrar.setForeground(Color.BLACK);
			rdbtnCadastrar.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnCadastrar.setBounds(448, 61, 203, 32);
			panelAddproduto.add(rdbtnCadastrar);
			
			rdbtnConsultarEstoque = new JRadioButton("Consultar Estoque");
			rdbtnConsultarEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnConsultarEstoque.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.limparEstoque();
					rdbtnCadastrar.setSelected(false);
					rdbtnConsultarEstoque.setSelected(true);
					lblOQueGostaria.setText("O que gostaria de Consultar ?");
					dataEntrada.setText("");
					buttonConsultarEstoque.setVisible(true);
					buttonSalvarEst.setVisible(false);
					dataCompraEst.setEnabled(false);
					numeroLoteEst.setEnabled(false);
					validadeEst.setEnabled(false);
					notaFiscalEst.setEnabled(false);
					quantidadeAdicionada.setEnabled(false);
					radioCadastro.setVisible(false);
					scrollPaneEst.setVisible(false);
					radioNovo.setVisible(false);
					comboDesejaAdicionar.setVisible(false);
					comboLocalEstoque4.setVisible(false);
					comboLocalEstoque4.setSelectedItem("");
					lblPor_1.setVisible(true);
					radioButton.setVisible(true);
					rdbtnNome.setVisible(true);
					radioProduto.setSelected(false);
					radioMateriaPrima.setSelected(false);
					nomeItemEst.setVisible(true);
					localEstoqueEst.setVisible(true);
					Suprimentos.OcultarFornecedor();
					
					comboNomeEst.setVisible(false);
					comboNomeEst.setSelectedItem("");
					nomeEst.setVisible(true);
				}
			});
			rdbtnConsultarEstoque.setOpaque(false);
			rdbtnConsultarEstoque.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarEstoque.setForeground(Color.BLACK);
			rdbtnConsultarEstoque.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnConsultarEstoque.setBounds(644, 61, 203, 32);
			panelAddproduto.add(rdbtnConsultarEstoque);
			
			radioButton = new JRadioButton("Código");
			radioButton.setForeground(Color.BLACK);
			radioButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					codigoEst.setEnabled(true);
					codigoEst.setEditable(true);
					codigoEst.requestFocus();
					nomeItemEst.setEnabled(false);
					rdbtnNome.setSelected(false);
					radioButton.setSelected(true);
					piscaTipo2.setVisible(false);
				}
			});
			radioButton.setVisible(false);
			radioButton.setOpaque(false);
			radioButton.setHorizontalAlignment(SwingConstants.CENTER);
			radioButton.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioButton.setBounds(888, 70, 101, 23);
			panelAddproduto.add(radioButton);
			
			rdbtnNome = new JRadioButton("Nome");
			rdbtnNome.setForeground(Color.BLACK);
			rdbtnNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnNome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					codigoEst.setEnabled(false);
					nomeItemEst.setEnabled(true);
					nomeItemEst.setEditable(true);
					nomeItemEst.requestFocus();
					rdbtnNome.setSelected(true);
					radioButton.setSelected(false);
					piscaTipo2.setVisible(false);
				}
			});
			rdbtnNome.setVisible(false);
			rdbtnNome.setOpaque(false);
			rdbtnNome.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			rdbtnNome.setBounds(984, 70, 89, 23);
			panelAddproduto.add(rdbtnNome);
			
			menuBar_4 = new JMenuBar();
			menuBar_4.setBounds(235, 0, 881, 32);
			panelAddproduto.add(menuBar_4);
			
			buttonSalvarEst = new JButton("Inserir");
			buttonSalvarEst.setForeground(Color.BLACK);
			menuBar_4.add(buttonSalvarEst);
			buttonSalvarEst.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonSalvarEst.setToolTipText("alt + Enter");
			buttonSalvarEst.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.InserirEstoque();
				}
			});
			buttonSalvarEst.setFont(new Font("Kalinga", Font.PLAIN, 14));
			buttonSalvarEst.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			buttonSalvarEst.setMnemonic(KeyEvent.VK_ENTER);
			
			buttonConsultarEstoque = new JButton("Consultar");
			buttonConsultarEstoque.setForeground(Color.BLACK);
			menuBar_4.add(buttonConsultarEstoque);
			buttonConsultarEstoque.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			buttonConsultarEstoque.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (radioMateriaPrima.isSelected() == false
							&& radioProduto.isSelected() == false) {
						JOptionPane.showMessageDialog(null,
								"Selecione o que gostaria de consultar.",
								"Atenção", JOptionPane.WARNING_MESSAGE);
						piscaTipo.setVisible(true);
					}
					else if (radioButton.isSelected() == false
							&& rdbtnNome.isSelected() == false) {
						JOptionPane.showMessageDialog(null,
								"Selecione o parametro da consulta.", "Atenção",
								JOptionPane.WARNING_MESSAGE);
						piscaTipo2.setVisible(true);
					}
					else if (radioProduto.isSelected() == true)
						SuprimentosController.ConsultarProdEstoque();
					else {
						SuprimentosController.ConsultarMPEstoque();
					}
				}
			});
			buttonConsultarEstoque.setVisible(false);
			buttonConsultarEstoque.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			buttonConsultarEstoque.setMnemonic(KeyEvent.VK_P);
			buttonConsultarEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			button_14 = new JButton("Excluir");
			button_14.setForeground(Color.BLACK);
			menuBar_4.add(button_14);
			button_14.setToolTipText("alt + Delete");
			button_14.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_14.setMnemonic(KeyEvent.VK_DELETE);
			button_14.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_14.setAlignmentX(0.5f);
			
			JButton btnLimpar_1 = new JButton("Limpar");
			btnLimpar_1.setForeground(Color.BLACK);
			menuBar_4.add(btnLimpar_1);
			btnLimpar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLimpar_1.setToolTipText("alt + Backspace");
			btnLimpar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Suprimentos.limparEstoque();
					comboDesejaAdicionar.setSelectedItem("");
				}
			});
			btnLimpar_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
			btnLimpar_1.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btnLimpar_1.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btnLimpar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			button_15 = new JButton("Alterar");
			button_15.setForeground(Color.BLACK);
			menuBar_4.add(button_15);
			button_15.setToolTipText("alt + Space");
			button_15.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_15.setMnemonic(KeyEvent.VK_SPACE);
			button_15.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_15.setFocusTraversalPolicyProvider(true);
			button_15.setFocusCycleRoot(true);
			button_15.setAlignmentX(0.5f);
			
			button_6 = new JButton("Imprimir");
			button_6.setForeground(Color.BLACK);
			menuBar_4.add(button_6);
			button_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// report.Suprimentos();
				}
			});
			button_6.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_6.setToolTipText("alt + P");
			button_6.setMnemonic(KeyEvent.VK_P);
			button_6.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JButton button_7 = new JButton("Anterior");
			button_7.setForeground(Color.BLACK);
			menuBar_4.add(button_7);
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_7.setVisible(false);
			button_7.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			button_7.setMnemonic(KeyEvent.VK_P);
			button_7.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JButton btnPrximo_3 = new JButton("Pr\u00F3ximo");
			btnPrximo_3.setForeground(Color.BLACK);
			menuBar_4.add(btnPrximo_3);
			btnPrximo_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPrximo_3.setVisible(false);
			btnPrximo_3.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnPrximo_3.setMnemonic(KeyEvent.VK_P);
			btnPrximo_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JLabel lblDataDaEntrada = new JLabel("Data da Entrada");
			lblDataDaEntrada.setForeground(Color.BLACK);
			lblDataDaEntrada.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDataDaEntrada.setBounds(761, 155, 120, 26);
			panelAddproduto.add(lblDataDaEntrada);
			
			labelCodigo = new JLabel("C\u00F3digo");
			labelCodigo.setForeground(Color.BLACK);
			labelCodigo.setIcon(null);
			labelCodigo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCodigo.setBounds(26, 226, 80, 26);
			panelAddproduto.add(labelCodigo);
			
			labelValidade = new JLabel("Validade");
			labelValidade.setForeground(Color.BLACK);
			labelValidade.setIcon(null);
			labelValidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelValidade.setBounds(1018, 155, 80, 26);
			panelAddproduto.add(labelValidade);
			
			labelNotaFiscal = new JLabel("Nota Fiscal");
			labelNotaFiscal.setForeground(Color.BLACK);
			labelNotaFiscal.setIcon(null);
			labelNotaFiscal.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNotaFiscal.setBounds(280, 228, 80, 26);
			panelAddproduto.add(labelNotaFiscal);
			
			labelUnidade = new JLabel("Unidade");
			labelUnidade.setIcon(null);
			labelUnidade.setForeground(Color.BLACK);
			labelUnidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelUnidade.setBounds(670, 226, 80, 26);
			panelAddproduto.add(labelUnidade);
			
			labelLocalEstoque = new JLabel("Local de Estoque");
			labelLocalEstoque.setIcon(null);
			labelLocalEstoque.setForeground(Color.BLACK);
			labelLocalEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelLocalEstoque.setBounds(463, 226, 124, 26);
			panelAddproduto.add(labelLocalEstoque);
			
			labelDataCompra = new JLabel("Data da Compra");
			labelDataCompra.setIcon(null);
			labelDataCompra.setForeground(Color.BLACK);
			labelDataCompra.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelDataCompra.setBounds(888, 153, 120, 26);
			panelAddproduto.add(labelDataCompra);
			
			labelNumeroLote = new JLabel("N\u00BA do Lote");
			labelNumeroLote.setForeground(Color.BLACK);
			labelNumeroLote.setIcon(null);
			labelNumeroLote.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroLote.setBounds(153, 228, 80, 26);
			panelAddproduto.add(labelNumeroLote);
			
			labelFotoEstoque = new JLabel("(165x115)");
			labelFotoEstoque.setForeground(Color.BLACK);
			labelFotoEstoque.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_48px/1425606663_image-128.png")));
			labelFotoEstoque.setOpaque(true);
			labelFotoEstoque.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoEstoque.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoEstoque.setBackground(Color.WHITE);
			labelFotoEstoque.setBounds(1154, 183, 145, 95);
			panelAddproduto.add(labelFotoEstoque);
			
			labelFornecedor = new JLabel("Fornecedor");
			labelFornecedor.setForeground(Color.BLACK);
			labelFornecedor.setIcon(null);
			labelFornecedor.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelFornecedor.setBounds(53, 356, 80, 26);
			panelAddproduto.add(labelFornecedor);
			
			labelPreco = new JLabel("Pre\u00E7o Por:");
			labelPreco.setForeground(Color.BLACK);
			labelPreco.setIcon(null);
			labelPreco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelPreco.setBounds(344, 149, 74, 32);
			panelAddproduto.add(labelPreco);
			
			labelUnidade_1 = new JLabel("Unidade");
			labelUnidade_1.setForeground(Color.BLACK);
			labelUnidade_1.setIcon(null);
			labelUnidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelUnidade_1.setBounds(417, 149, 80, 32);
			panelAddproduto.add(labelUnidade_1);
			
			labelEstoqueMinimo = new JLabel("Estoque Minimo");
			labelEstoqueMinimo.setForeground(Color.BLACK);
			labelEstoqueMinimo.setIcon(null);
			labelEstoqueMinimo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEstoqueMinimo.setBounds(616, 149, 120, 32);
			panelAddproduto.add(labelEstoqueMinimo);
			
			labelQuantidade = new JLabel("Quantidade \u00E1 Adic.");
			labelQuantidade.setIcon(null);
			labelQuantidade.setForeground(Color.BLACK);
			labelQuantidade.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelQuantidade.setBounds(797, 221, 137, 32);
			panelAddproduto.add(labelQuantidade);
			
			labelEstoqueAtual = new JLabel("Estoque Atual");
			labelEstoqueAtual.setIcon(null);
			labelEstoqueAtual.setForeground(Color.BLACK);
			labelEstoqueAtual.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEstoqueAtual.setBounds(489, 149, 112, 32);
			panelAddproduto.add(labelEstoqueAtual);
			
			labelNome = new JLabel("Nome");
			labelNome.setForeground(Color.BLACK);
			labelNome.setIcon(null);
			labelNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNome.setBounds(363, 327, 49, 26);
			panelAddproduto.add(labelNome);
			
			lblItem = new JLabel("Selecione o item");
			lblItem.setForeground(Color.BLACK);
			lblItem.setFont(new Font("Kalinga", Font.BOLD, 14));
			lblItem.setBounds(26, 149, 143, 32);
			panelAddproduto.add(lblItem);
			
			lblOQueGostaria = new JLabel("O que gostaria de Inserir ?");
			lblOQueGostaria.setHorizontalAlignment(SwingConstants.CENTER);
			lblOQueGostaria.setForeground(Color.BLACK);
			lblOQueGostaria.setFont(new Font("Kalinga", Font.BOLD, 15));
			lblOQueGostaria.setBounds(313, 96, 228, 32);
			panelAddproduto.add(lblOQueGostaria);
			
			lblPor_1 = new JLabel("Por ?");
			lblPor_1.setVisible(false);
			lblPor_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblPor_1.setForeground(Color.BLACK);
			lblPor_1.setFont(new Font("Kalinga", Font.BOLD, 15));
			lblPor_1.setBounds(834, 61, 49, 32);
			panelAddproduto.add(lblPor_1);
			
			piscaTipo = new JLabel("");
			piscaTipo.setForeground(Color.BLACK);
			piscaTipo.setVisible(false);
			piscaTipo.setBackground(Color.ORANGE);
			piscaTipo.setBorder(new LineBorder(Color.RED, 2));
			piscaTipo.setBounds(550, 101, 209, 23);
			panelAddproduto.add(piscaTipo);
			
			piscaTipo2 = new JLabel("");
			piscaTipo2.setForeground(Color.BLACK);
			piscaTipo2.setVisible(false);
			piscaTipo2.setBorder(new LineBorder(Color.RED, 2));
			piscaTipo2.setBounds(895, 70, 167, 23);
			panelAddproduto.add(piscaTipo2);
			
			JLabel label_27 = new JLabel("Código");
			label_27.setForeground(Color.BLACK);
			label_27.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_27.setBounds(670, 327, 80, 26);
			panelAddproduto.add(label_27);
			
			JLabel lblIe = new JLabel("I.E.");
			lblIe.setForeground(Color.BLACK);
			lblIe.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblIe.setBounds(816, 327, 80, 26);
			panelAddproduto.add(lblIe);
			
			label_30 = new JLabel("");
			label_30.setForeground(Color.BLACK);
			label_30.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_30.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS DO ITEM \u00C1 SER ADICIONADO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_30.setBounds(10, 130, 1331, 179);
			panelAddproduto.add(label_30);
			
			label_31 = new JLabel("");
			label_31.setForeground(Color.BLACK);
			label_31.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_31.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS FORNECEDOR", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_31.setBounds(10, 315, 1331, 89);
			panelAddproduto.add(label_31);
			
			JLabel label_33 = new JLabel("");
			label_33.setForeground(Color.BLACK);
			label_33.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_33.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "INFORMA\u00C7\u00D5ES COMPLEMENTARES", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_33.setBounds(13, 407, 1328, 239);
			panelAddproduto.add(label_33);
			
			label = new JLabel("");
			label.setForeground(Color.BLACK);
			label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label.setBounds(10, 43, 1325, 89);
			panelAddproduto.add(label);
			
			labelFundoEstoque = new JLabel("");
			labelFundoEstoque.setForeground(Color.BLACK);
			labelFundoEstoque.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoEstoque.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelFundoEstoque.setVerticalAlignment(SwingConstants.TOP);
			labelFundoEstoque.setBounds(0, 0, 1358, 674);
			panelAddproduto.add(labelFundoEstoque);
			labelFundoEstoque.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			
			tabbedPaneSuprimentos.addTab("Produto ", new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					panelCadastrarProduto, null);
			
			caminho = new JTextField();
			caminho.setBounds(1315, 450, 5, 5);
			panelCadastrarProduto.add(caminho);
			caminho.setColumns(10);
			caminho.setVisible(false);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			/*
			 * 
			 * Panel Cadastrar Materia Prima
			 */
			panelCadastrarMateriaPrima = new JPanel();
			panelCadastrarMateriaPrima.setBackground(SystemColor.inactiveCaptionBorder);
			panelCadastrarMateriaPrima.setLayout(null);
			
			comboBox_3 = new JComboBox<String>();
			comboBox_3.setForeground(Color.BLACK);
			comboBox_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_3.setVisible(false);
			comboBox_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBox_3.setEditable(false);
			comboBox_3.setBounds(890, 78, 131, 32);
			panelCadastrarMateriaPrima.add(comboBox_3);
			comboBox_3.addItem("");
			comboBox_3.addItem("Código");
			comboBox_3.addItem("Nome");
			comboBox_3.addItem("Nota");
			comboBox_3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					tipoConsulta2 = item.toString();
					if (tipoConsulta2.equals("Código")) {
						codigo2.setEnabled(true);
						codigo2.requestFocus();
						codigo2.setEditable(true);
						codigo2.setBorder(new LineBorder(Color.BLUE));
						nome2.setEnabled(false);
						nome2.setEditable(false);
						nome2.setBorder(null);
						tipoConsultaMP.setEnabled(false);
						tipoConsultaMP.setBorder(null);
						
					}
					else if (tipoConsulta2.equals("Nome")) {
						
						nome2.setEnabled(true);
						nome2.setEditable(true);
						nome2.requestFocus();
						nome2.setBorder(new LineBorder(Color.BLUE));
						codigo2.setEnabled(false);
						codigo2.setEditable(false);
						codigo2.setBorder(null);
						tipoConsultaMP.setEnabled(false);
						tipoConsultaMP.setBorder(null);
						
					}
					else if (tipoConsulta2.equals("Nota")) {
						
						tipoConsultaMP.setEnabled(true);
						tipoConsultaMP.requestFocus();
						tipoConsultaMP.setBorder(new LineBorder(Color.BLUE));
						codigo2.setEnabled(false);
						codigo2.setEditable(false);
						codigo2.setBorder(null);
						nome2.setEnabled(false);
						nome2.setBorder(null);
					}
					else if (tipoConsulta2.equals(null)) {
						tipoConsultaMP.setBorder(null);
						codigo2.setBorder(null);
						nome2.setBorder(null);
					}
				}
			});
			
			rdbtnCadastrarMp = new JRadioButton("Cadastrar Mat\u00E9ria Prima");
			rdbtnCadastrarMp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnCadastrarMp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					rdbtnCadastrarMp.setSelected(true);
					rdbtnConsultarMP.setSelected(false);
					labelFotoMateriaPrima.setText("imagem");
					labelFotoMateriaPrima.setIcon(new ImageIcon(Suprimentos.class
							.getResource("/icones1_48px/1425606663_image-128.png")));
					btImagem.setVisible(true);
					atualizarImagemMP.setVisible(false);
					buttonConsultarMateriaPrima.setVisible(false);
					codigo2.setEnabled(false);
					salvarMP.setVisible(true);
					lblPor2.setVisible(false);
					comboBox_3.setVisible(false);
					
					Suprimentos.limparMP();
					Suprimentos.SetarMpEditavel();
					nome2.requestFocus();
					
					String sql2 = "select * from contadores";
					ResultSet rs3 = x.Consultar(sql2);
					try {
						codigo2.setFont(new Font("Kalinga", Font.PLAIN, 14));
						codigo2.setEditable(false);
						while (rs3.next()) {
							codigo2.setText(rs3.getString("codigoMateriaPrima"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			rdbtnCadastrarMp.setSelected(true);
			rdbtnCadastrarMp.setOpaque(false);
			rdbtnCadastrarMp.setHorizontalAlignment(SwingConstants.LEFT);
			rdbtnCadastrarMp.setForeground(Color.BLACK);
			rdbtnCadastrarMp.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnCadastrarMp.setBounds(422, 78, 203, 32);
			panelCadastrarMateriaPrima.add(rdbtnCadastrarMp);
			
			rdbtnConsultarMP = new JRadioButton("Consultar Mat\u00E9ria Prima");
			rdbtnConsultarMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnConsultarMP.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					rdbtnCadastrarMp.setSelected(false);
					rdbtnConsultarMP.setSelected(true);
					codigo2.setText("");
					salvarMP.setVisible(false);
					lblPor2.setVisible(true);
					comboBox_3.setVisible(true);
					comboBox_4.setVisible(false);
					estoqueMinimo2.setVisible(false);
					estoqueMinimoConsulta2.setVisible(true);
					tipoConsultaMP.setVisible(true);
					comboUnidade2.setVisible(false);
					unidadeconsulta2.setVisible(true);
					estoqueMinimoConsulta2.setVisible(true);
					unidadeconsulta2.setVisible(true);
					btnImagem.setVisible(false);
					atualizarImagemMP.setVisible(true);
					buttonConsultarMateriaPrima.setVisible(true);
					Suprimentos.limparMP();
					Suprimentos.SetarMpNaoEditavel();
				}
			});
			rdbtnConsultarMP.setOpaque(false);
			rdbtnConsultarMP.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarMP.setForeground(Color.BLACK);
			rdbtnConsultarMP.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnConsultarMP.setBounds(642, 78, 203, 32);
			panelCadastrarMateriaPrima.add(rdbtnConsultarMP);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			codigo2 = new JTextField();
			codigo2.setForeground(Color.BLACK);
			codigo2.setSelectionColor(SystemColor.textHighlight);
			codigo2.setHorizontalAlignment(SwingConstants.CENTER);
			codigo2.setEnabled(false);
			codigo2.setDisabledTextColor(Color.BLACK);
			codigo2.setColumns(10);
			codigo2.setBounds(31, 184, 173, 32);
			panelCadastrarMateriaPrima.add(codigo2);
			codigo2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codigo2.setEditable(false);
			
			sql21 = "select * from contadores";
			rs31 = x.Consultar(sql21);
			try {
				while (rs31.next()) {
					codigo2.setText(rs31.getString("codigoMateriaPrima"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			nome2 = new JTextField();
			nome2.setForeground(Color.BLACK);
			nome2.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nome2.setText(nome2.getText().replaceAll("[^0-9]",
					// ""));
					nome2.setText(nome2.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nome2.setSelectionColor(SystemColor.textHighlight);
			nome2.setHorizontalAlignment(SwingConstants.CENTER);
			nome2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nome2.setColumns(10);
			nome2.setBounds(214, 184, 381, 32);
			panelCadastrarMateriaPrima.add(nome2);
			
			tipoConsultaMP = new JTextField();
			tipoConsultaMP.setForeground(Color.BLACK);
			tipoConsultaMP.setSelectionColor(SystemColor.textHighlight);
			tipoConsultaMP.setVisible(false);
			
			localEstoque = new JTextField();
			localEstoque.setForeground(Color.BLACK);
			localEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// localEstoque.setText(localEstoque.getText().replaceAll("[^0-9]",
					// ""));
					localEstoque.setText(localEstoque.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			localEstoque.setSelectionColor(SystemColor.textHighlight);
			localEstoque.setHorizontalAlignment(SwingConstants.CENTER);
			localEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			localEstoque.setColumns(10);
			localEstoque.setBounds(605, 184, 140, 32);
			panelCadastrarMateriaPrima.add(localEstoque);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboBox_4 = new JComboBox<String>();
			comboBox_4.setForeground(Color.BLACK);
			comboBox_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBox_4.setEditable(false);
			comboBox_4.setBounds(755, 184, 172, 32);
			panelCadastrarMateriaPrima.add(comboBox_4);
			comboBox_4.addItem("");
			comboBox_4.addItem("Perecível");
			comboBox_4.addItem("Não Perecível");
			
			tipoConsultaMP.setHorizontalAlignment(SwingConstants.CENTER);
			tipoConsultaMP.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tipoConsultaMP.setColumns(10);
			tipoConsultaMP.setBounds(755, 184, 173, 32);
			panelCadastrarMateriaPrima.add(tipoConsultaMP);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboUnidade2 = new JComboBox<String>();
			comboUnidade2.setForeground(Color.BLACK);
			comboUnidade2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboUnidade2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboUnidade2.setEditable(false);
			comboUnidade2.setBounds(31, 259, 131, 32);
			comboUnidade2.addItem("");
			comboUnidade2.addItem("Caixa");
			comboUnidade2.addItem("Duzia");
			comboUnidade2.addItem("Litro");
			comboUnidade2.addItem("Metro");
			comboUnidade2.addItem("Metro quadrado");
			comboUnidade2.addItem("Pacote");
			comboUnidade2.addItem("Peça");
			comboUnidade2.addItem("Quilo");
			comboUnidade2.addItem("Unidade");
			panelCadastrarMateriaPrima.add(comboUnidade2);
			comboUnidade2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					lblUnidade.setText(evt.getItem().toString());
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			unidadeconsulta2 = new JTextField();
			unidadeconsulta2.setForeground(Color.BLACK);
			unidadeconsulta2.setSelectionColor(SystemColor.textHighlight);
			unidadeconsulta2.setVisible(false);
			unidadeconsulta2.setHorizontalAlignment(SwingConstants.CENTER);
			unidadeconsulta2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			unidadeconsulta2.setColumns(10);
			unidadeconsulta2.setBounds(31, 259, 131, 32);
			panelCadastrarMateriaPrima.add(unidadeconsulta2);
			
			numeroLote2 = new JTextField();
			numeroLote2.setForeground(Color.BLACK);
			numeroLote2.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroLote2.setText(numeroLote2.getText().replaceAll("[^0-9]", ""));
					// numeroLote2.setText(numeroLote2.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroLote2.setSelectionColor(SystemColor.textHighlight);
			numeroLote2.setHorizontalAlignment(SwingConstants.CENTER);
			numeroLote2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroLote2.setColumns(10);
			numeroLote2.setBounds(171, 259, 173, 32);
			panelCadastrarMateriaPrima.add(numeroLote2);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			estoqueMinimo2 = new JSpinner();
			estoqueMinimo2.setForeground(Color.BLACK);
			estoqueMinimo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			estoqueMinimo2.setModel(new SpinnerNumberModel(1, 1, 99999, 1));
			estoqueMinimo2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueMinimo2.setBounds(364, 259, 81, 32);
			panelCadastrarMateriaPrima.add(estoqueMinimo2);
			
			estoqueMinimoConsulta2 = new JTextField();
			estoqueMinimoConsulta2.setForeground(Color.BLACK);
			estoqueMinimoConsulta2.setSelectionColor(SystemColor.textHighlight);
			estoqueMinimoConsulta2.setHorizontalAlignment(SwingConstants.CENTER);
			estoqueMinimoConsulta2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estoqueMinimoConsulta2.setColumns(10);
			estoqueMinimoConsulta2.setBounds(364, 259, 81, 32);
			panelCadastrarMateriaPrima.add(estoqueMinimoConsulta2);
			
			precoPor2 = new JTextField();
			precoPor2.setForeground(Color.BLACK);
			precoPor2.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					precoPor2.setText(precoPor2.getText().replaceAll("[^0-9]", ""));
					// precoPor2.setText(precoPor2.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			precoPor2.setSelectionColor(SystemColor.textHighlight);
			precoPor2.setText("0,00");
			precoPor2.setHorizontalAlignment(SwingConstants.CENTER);
			precoPor2.setFont(new Font("Kalinga", Font.BOLD, 15));
			precoPor2.setColumns(10);
			precoPor2.setBounds(484, 259, 192, 32);
			panelCadastrarMateriaPrima.add(precoPor2);
			
			menuBar_2 = new JMenuBar();
			menuBar_2.setBounds(168, 0, 1014, 32);
			panelCadastrarMateriaPrima.add(menuBar_2);
			
			salvarMP = new JButton("Salvar");
			salvarMP.setForeground(Color.BLACK);
			menuBar_2.add(salvarMP);
			salvarMP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			salvarMP.setToolTipText("alt + Enter");
			salvarMP.setFont(new Font("Kalinga", Font.PLAIN, 14));
			salvarMP.setMnemonic(KeyEvent.VK_ENTER);
			salvarMP.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.salvarMP();
				}
			});
			salvarMP.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setForeground(Color.BLACK);
			menuBar_2.add(btnAtualizar);
			btnAtualizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.AtualizarMateriaPrima();
				}
			});
			btnAtualizar.setVisible(false);
			btnAtualizar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnAtualizar.setToolTipText("alt + Enter");
			btnAtualizar.setMnemonic(KeyEvent.VK_ENTER);
			btnAtualizar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			buttonConsultarMateriaPrima = new JButton("Consultar");
			buttonConsultarMateriaPrima.setForeground(Color.BLACK);
			menuBar_2.add(buttonConsultarMateriaPrima);
			buttonConsultarMateriaPrima.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.ConsultarMP();
				}
			});
			buttonConsultarMateriaPrima.setVisible(false);
			buttonConsultarMateriaPrima.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			buttonConsultarMateriaPrima.setMnemonic(KeyEvent.VK_P);
			buttonConsultarMateriaPrima.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnCancelar_1 = new JButton("Cancelar");
			btnCancelar_1.setForeground(Color.BLACK);
			menuBar_2.add(btnCancelar_1);
			btnCancelar_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.button_2.setEnabled(false);
					Suprimentos.button_11.setEnabled(false);
					Suprimentos.btnAnterior2.setEnabled(false);
					Suprimentos.btnProximo2.setEnabled(false);
					Suprimentos.SetarMpNaoEditavel();
					btnAtualizar.setVisible(false);
				}
			});
			btnCancelar_1.setToolTipText("alt + Delete");
			btnCancelar_1.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar_1.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar_1.setAlignmentX(0.5f);
			
			JButton limpar_2 = new JButton("Limpar");
			limpar_2.setForeground(Color.BLACK);
			menuBar_2.add(limpar_2);
			limpar_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			limpar_2.setToolTipText("alt + Backspace");
			limpar_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			limpar_2.setMnemonic(KeyEvent.VK_BACK_SPACE);
			limpar_2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.limparMP();
				}
			});
			limpar_2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			
			button_11 = new JButton("Alterar");
			button_11.setForeground(Color.BLACK);
			menuBar_2.add(button_11);
			button_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					comboUnidade2.setSelectedItem(unidadeconsulta2.getText());
					comboBox_4.setSelectedItem(tipoConsultaMP.getText());
					estoqueMinimo2.setValue(Integer.parseInt(estoqueMinimoConsulta2
							.getText()));
					Suprimentos.SetarMpEditavel();
					nome2.setEditable(true);
					btnAtualizar.setVisible(true);
				}
			});
			button_11.setEnabled(false);
			button_11.setToolTipText("alt + Space");
			button_11.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_11.setMnemonic(KeyEvent.VK_SPACE);
			button_11.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_11.setFocusTraversalPolicyProvider(true);
			button_11.setFocusCycleRoot(true);
			button_11.setAlignmentX(0.5f);
			
			button_2 = new JButton("Imprimir");
			button_2.setForeground(Color.BLACK);
			menuBar_2.add(button_2);
			button_2.setEnabled(false);
			button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// report.Suprimentos();
				}
			});
			button_2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_2.setToolTipText("alt + P");
			button_2.setMnemonic(KeyEvent.VK_P);
			button_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnAnterior2 = new JButton("Anterior");
			btnAnterior2.setForeground(Color.BLACK);
			menuBar_2.add(btnAnterior2);
			btnAnterior2.setEnabled(false);
			btnAnterior2.setToolTipText("alt + <");
			btnAnterior2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnAnterior2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			btnAnterior2.setMnemonic(KeyEvent.VK_KP_LEFT);
			btnAnterior2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnProximo2 = new JButton("Pr\u00F3ximo");
			btnProximo2.setForeground(Color.BLACK);
			menuBar_2.add(btnProximo2);
			btnProximo2.setEnabled(false);
			btnProximo2.setToolTipText("alt + >");
			btnProximo2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnProximo2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnProximo2.setMnemonic(KeyEvent.VK_KP_RIGHT);
			btnProximo2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnImagem = new JButton("Selecionar");
			btnImagem.setForeground(Color.BLACK);
			btnImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnImagem.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606659_678090-camera-128.png")));
			btnImagem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnImagem.setBounds(1007, 283, 145, 35);
			panelCadastrarMateriaPrima.add(btnImagem);
			btnImagem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SuprimentosController.SelecionarImagemMateriaPrima();
				}
			});
			
			atualizarImagemMP = new JButton("Atualizar Imagem");
			atualizarImagemMP.setForeground(Color.BLACK);
			atualizarImagemMP.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.atualizarImagemMP();
				}
			});
			atualizarImagemMP.setVisible(false);
			atualizarImagemMP.setFont(new Font("Kalinga", Font.PLAIN, 14));
			atualizarImagemMP.setBounds(1007, 283, 145, 35);
			panelCadastrarMateriaPrima.add(atualizarImagemMP);
			
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			scrollPane_2.setBounds(31, 335, 943, 59);
			panelCadastrarMateriaPrima.add(scrollPane_2);
			
			descricaoMateriaPrima2 = new JTextArea();
			descricaoMateriaPrima2.setForeground(Color.BLACK);
			descricaoMateriaPrima2.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// descricaoMateriaPrima2.setText(descricaoMateriaPrima2.getText().replaceAll("[^0-9]",
					// ""));
					descricaoMateriaPrima2.setText(descricaoMateriaPrima2.getText()
							.replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			descricaoMateriaPrima2.setSelectionColor(SystemColor.scrollbar);
			descricaoMateriaPrima2.setFont(new Font("Kalinga", Font.ITALIC, 18));
			scrollPane_2.setViewportView(descricaoMateriaPrima2);
			
			lblPor2 = new JLabel("Por ?");
			lblPor2.setVisible(false);
			lblPor2.setHorizontalAlignment(SwingConstants.CENTER);
			lblPor2.setForeground(Color.BLACK);
			lblPor2.setFont(new Font("Kalinga", Font.BOLD, 15));
			lblPor2.setBounds(845, 78, 38, 32);
			panelCadastrarMateriaPrima.add(lblPor2);
			
			JLabel lblNDoLote = new JLabel("N\u00BA do Lote");
			lblNDoLote.setForeground(Color.BLACK);
			lblNDoLote.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNDoLote.setBounds(171, 227, 80, 32);
			panelCadastrarMateriaPrima.add(lblNDoLote);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo");
			lblCdigo.setForeground(Color.BLACK);
			lblCdigo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCdigo.setBounds(31, 152, 80, 32);
			panelCadastrarMateriaPrima.add(lblCdigo);
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNome.setBounds(214, 152, 49, 32);
			panelCadastrarMateriaPrima.add(lblNome);
			
			JLabel lblNotaFiscal = new JLabel("Tipo");
			lblNotaFiscal.setForeground(Color.BLACK);
			lblNotaFiscal.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNotaFiscal.setBounds(755, 152, 80, 32);
			panelCadastrarMateriaPrima.add(lblNotaFiscal);
			
			JLabel lblUnidade_1 = new JLabel("Unidade");
			lblUnidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblUnidade_1.setForeground(Color.BLACK);
			lblUnidade_1.setBounds(31, 227, 80, 32);
			panelCadastrarMateriaPrima.add(lblUnidade_1);
			
			JLabel lblLocalDeEstoque = new JLabel("Local de Estoque");
			lblLocalDeEstoque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblLocalDeEstoque.setForeground(Color.BLACK);
			lblLocalDeEstoque.setBounds(605, 152, 131, 32);
			panelCadastrarMateriaPrima.add(lblLocalDeEstoque);
			
			labelFotoMateriaPrima = new JLabel("(165x115)");
			labelFotoMateriaPrima.setForeground(Color.BLACK);
			labelFotoMateriaPrima.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_48px/1425606663_image-128.png")));
			labelFotoMateriaPrima.setOpaque(true);
			labelFotoMateriaPrima.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoMateriaPrima.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoMateriaPrima.setBackground(Color.WHITE);
			labelFotoMateriaPrima.setBounds(1007, 184, 145, 95);
			panelCadastrarMateriaPrima.add(labelFotoMateriaPrima);
			
			JLabel lblPreo = new JLabel("Pre\u00E7o Por :");
			lblPreo.setForeground(Color.BLACK);
			lblPreo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblPreo.setBounds(484, 227, 86, 32);
			panelCadastrarMateriaPrima.add(lblPreo);
			
			JLabel lblEstoqueMinimo = new JLabel("Estoque Minimo");
			lblEstoqueMinimo.setForeground(Color.BLACK);
			lblEstoqueMinimo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblEstoqueMinimo.setBounds(354, 227, 120, 32);
			panelCadastrarMateriaPrima.add(lblEstoqueMinimo);
			
			lblUnidade = new JLabel("Unidade");
			lblUnidade.setHorizontalAlignment(SwingConstants.CENTER);
			lblUnidade.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			lblUnidade.setForeground(Color.BLACK);
			lblUnidade.setFont(new Font("Kalinga", Font.BOLD, 14));
			lblUnidade.setBounds(558, 227, 80, 32);
			panelCadastrarMateriaPrima.add(lblUnidade);
			
			lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio_1.setForeground(Color.BLACK);
			lblDescrio_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDescrio_1.setBounds(31, 302, 80, 32);
			panelCadastrarMateriaPrima.add(lblDescrio_1);
			
			JLabel label_26 = new JLabel("");
			label_26.setForeground(Color.BLACK);
			label_26.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_26.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS DA MAT\u00C9RIA PRIMA", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_26.setBounds(10, 121, 1331, 525);
			panelCadastrarMateriaPrima.add(label_26);
			
			label_12 = new JLabel("");
			label_12.setForeground(Color.BLACK);
			label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_12.setBounds(10, 60, 1325, 69);
			panelCadastrarMateriaPrima.add(label_12);
			
			labelFundoMateriaPrima = new JLabel("");
			labelFundoMateriaPrima.setForeground(Color.BLACK);
			labelFundoMateriaPrima.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoMateriaPrima.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoMateriaPrima.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelFundoMateriaPrima.setVerticalAlignment(SwingConstants.TOP);
			labelFundoMateriaPrima.setBounds(0, 0, 1358, 674);
			labelFundoMateriaPrima.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			panelCadastrarMateriaPrima.add(labelFundoMateriaPrima);
			
			caminho2 = new JTextField();
			caminho2.setColumns(10);
			caminho2.setBounds(916, 421, 122, 32);
			panelCadastrarMateriaPrima.add(caminho2);
			caminho2.setVisible(false);
			
			tabbedPaneSuprimentos.addTab("Matéria Prima ", new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					panelCadastrarMateriaPrima, null);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelFornecedor = new JPanel();
			tabbedPaneSuprimentos.addTab("Fornecedor ", new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606601_book-128.png")),
					panelFornecedor, null);
			panelFornecedor.setLayout(null);
			
			rdbtnCadastrarFornecedor = new JRadioButton("Cadastrar Fornecedor");
			rdbtnCadastrarFornecedor
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnCadastrarFornecedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					rdbtnCadastrarFornecedor.setSelected(true);
					rdbtnConsultarFornecedor.setSelected(false);
					lblPor3.setVisible(false);
					comboBox_1.setVisible(false);
					button_4.setVisible(true);
					btnSelecionar.setVisible(true);
					button_atualizarImagemForn.setVisible(false);
					buttonConsultarFornecedor.setVisible(false);
					
					String sql7 = "select * from contadores";
					ResultSet rs7 = x.Consultar(sql7);
					try {
						codigo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
						codigo5.setEditable(false);
						while (rs7.next()) {
							codigo5.setText(rs7.getString("codigoFornecedor"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
					Suprimentos.SetarFornEditavel();
					Suprimentos.limparFornecedor();
				}
			});
			rdbtnCadastrarFornecedor.setSelected(true);
			rdbtnCadastrarFornecedor.setOpaque(false);
			rdbtnCadastrarFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnCadastrarFornecedor.setForeground(Color.BLACK);
			rdbtnCadastrarFornecedor.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnCadastrarFornecedor.setBounds(422, 61, 203, 32);
			panelFornecedor.add(rdbtnCadastrarFornecedor);
			
			rdbtnConsultarFornecedor = new JRadioButton("Consultar Fornecedor");
			rdbtnConsultarFornecedor
					.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnConsultarFornecedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					rdbtnCadastrarFornecedor.setSelected(false);
					rdbtnConsultarFornecedor.setSelected(true);
					lblPor3.setVisible(true);
					comboBox_1.setVisible(true);
					codigo5.setText("");
					button_4.setVisible(false);
					btnSelecionar.setVisible(false);
					buttonConsultarFornecedor.setVisible(true);
					Suprimentos.SetarFornNaoEditavel();
					Suprimentos.limparFornecedor();
				}
			});
			rdbtnConsultarFornecedor.setOpaque(false);
			rdbtnConsultarFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarFornecedor.setForeground(Color.BLACK);
			rdbtnConsultarFornecedor.setFont(new Font("Khmer UI", Font.BOLD, 15));
			rdbtnConsultarFornecedor.setBounds(618, 61, 203, 32);
			panelFornecedor.add(rdbtnConsultarFornecedor);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setForeground(Color.BLACK);
			comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_1.setVisible(false);
			comboBox_1.setFont(new Font("Kalinga", Font.BOLD | Font.ITALIC, 14));
			comboBox_1.setEditable(false);
			comboBox_1.setBounds(866, 61, 131, 32);
			panelFornecedor.add(comboBox_1);
			comboBox_1.addItem(" ");
			comboBox_1.addItem("Código");
			comboBox_1.addItem("Nome");
			comboBox_1.addItem("Endereço");
			comboBox_1.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					tipoConsulta3 = item.toString();
					if (tipoConsulta3.equals("Código")) {
						
						codigo5.setEnabled(true);
						codigo5.requestFocus();
						codigo5.setEditable(true);
						codigo5.setBorder(new LineBorder(Color.BLUE));
						
						NomeFornecedor.setEnabled(false);
						NomeFornecedor.setBorder(null);
						
						endereco.setEnabled(false);
						endereco.setBorder(null);
						
					}
					else if (tipoConsulta3.equals("Nome")) {
						NomeFornecedor.setEnabled(true);
						NomeFornecedor.requestFocus();
						NomeFornecedor.setBorder(null);
						NomeFornecedor.setBorder(new LineBorder(Color.BLUE));
						
						codigo5.setEnabled(false);
						codigo5.setEditable(false);
						codigo5.setBorder(null);
						
						endereco.setEnabled(false);
						endereco.setBorder(null);
						
					}
					else if (tipoConsulta3.equals("Endereço")) {
						endereco.setBorder(new LineBorder(Color.BLUE));
						endereco.setEnabled(true);
						endereco.requestFocus();
						
						codigo5.setEnabled(false);
						codigo5.setEditable(false);
						codigo5.setBorder(null);
						
						NomeFornecedor.setEnabled(false);
						NomeFornecedor.setBorder(null);
					}
					else if (tipoConsulta3.equals(null)) {
						NomeFornecedor.setBorder(null);
						endereco.setBorder(null);
						codigo5.setBorder(null);
					}
				}
			});
			
			codigo5 = new JTextField();
			codigo5.setForeground(Color.BLACK);
			codigo5.setSelectionColor(SystemColor.textHighlight);
			codigo5.setHorizontalAlignment(SwingConstants.CENTER);
			codigo5.setFont(new Font("Kalinga", Font.BOLD, 15));
			codigo5.setEnabled(false);
			codigo5.setEditable(false);
			codigo5.setDisabledTextColor(Color.BLACK);
			codigo5.setColumns(10);
			codigo5.setBounds(28, 188, 173, 32);
			panelFornecedor.add(codigo5);
			codigo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
			codigo5.setEditable(false);
			
			ArrayList<String> valores1 = new ArrayList<String>();
			String sql211 = "SELECT * FROM `fornecedor`";
			ResultSet rs311 = x.Consultar(sql211);
			
			try {
				while (rs311.next()) {
					valores1.add(rs311.getString("nome"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			StringArrayLookAhead lookAhead1 = new StringArrayLookAhead(valores1);
			NomeFornecedor = new LookAheadTextField(20, lookAhead1);
			NomeFornecedor.setForeground(Color.BLACK);
			NomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// NomeFornecedor.setText(NomeFornecedor.getText().replaceAll("[^0-9]",
					// ""));
					NomeFornecedor.setText(NomeFornecedor.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			NomeFornecedor.setSelectionColor(SystemColor.textHighlight);
			NomeFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			NomeFornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NomeFornecedor.setBounds(211, 189, 355, 32);
			panelFornecedor.add(NomeFornecedor);
			
			vendedor = new JTextField();
			vendedor.setForeground(Color.BLACK);
			vendedor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// vendedor.setText(vendedor.getText().replaceAll("[^0-9]",
					// ""));
					vendedor.setText(vendedor.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			vendedor.setSelectionColor(SystemColor.textHighlight);
			vendedor.setHorizontalAlignment(SwingConstants.CENTER);
			vendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			vendedor.setColumns(10);
			vendedor.setBounds(578, 189, 318, 32);
			panelFornecedor.add(vendedor);
			
			endereco = new JTextField();
			endereco.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// endereco.setText(endereco.getText().replaceAll("[^0-9]",
					// ""));
					endereco.setText(endereco.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			endereco.setSelectionColor(SystemColor.textHighlight);
			endereco.setHorizontalAlignment(SwingConstants.CENTER);
			endereco.setForeground(Color.BLACK);
			endereco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			endereco.setColumns(10);
			endereco.setBounds(28, 420, 360, 32);
			panelFornecedor.add(endereco);
			
			numero = new JTextField();
			numero.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numero.setText(numero.getText().replaceAll("[^0-9]", ""));
					// numero.setText(numero.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numero.setSelectionColor(SystemColor.textHighlight);
			numero.setHorizontalAlignment(SwingConstants.CENTER);
			numero.setForeground(Color.BLACK);
			numero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numero.setColumns(10);
			numero.setBounds(400, 419, 64, 32);
			panelFornecedor.add(numero);
			
			complemento = new JTextField();
			complemento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// complemento.setText(complemento.getText().replaceAll("[^0-9]",
					// ""));
					complemento.setText(complemento.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			complemento.setSelectionColor(SystemColor.textHighlight);
			complemento.setHorizontalAlignment(SwingConstants.CENTER);
			complemento.setForeground(Color.BLACK);
			complemento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			complemento.setColumns(10);
			complemento.setBounds(474, 419, 259, 32);
			panelFornecedor.add(complemento);
			
			bairro = new JTextField();
			bairro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// bairro.setText(bairro.getText().replaceAll("[^0-9]",
					// ""));
					bairro.setText(bairro.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			bairro.setSelectionColor(SystemColor.textHighlight);
			bairro.setHorizontalAlignment(SwingConstants.CENTER);
			bairro.setForeground(Color.BLACK);
			bairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			bairro.setColumns(10);
			bairro.setBounds(745, 420, 165, 32);
			panelFornecedor.add(bairro);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboBox_estado = new JComboBox<String>();
			comboBox_estado.setForeground(Color.BLACK);
			comboBox_estado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_estado.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBox_estado.setEditable(false);
			comboBox_estado.setBounds(28, 500, 64, 32);
			panelFornecedor.add(comboBox_estado);
			
			comboBox_estado.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String estadoSupri = item.toString();
					try {
						comboBox_cidade.removeAllItems();
						String sql = "select * from tb_cidades where uf = '"
								+ estadoSupri + "'";
						ResultSet rs1 = x.Consultar(sql);
						comboBox_cidade.addItem("");
						while (rs1.next()) {
							comboBox_cidade.addItem(rs1.getString("nome"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			
			estado = new JTextField();
			estado.setVisible(false);
			estado.setSelectionColor(SystemColor.textHighlight);
			estado.setHorizontalAlignment(SwingConstants.CENTER);
			estado.setForeground(Color.BLACK);
			estado.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estado.setColumns(10);
			estado.setBorder(null);
			estado.setBounds(28, 500, 64, 32);
			panelFornecedor.add(estado);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboBox_cidade = new JComboBox<String>();
			comboBox_cidade.setForeground(Color.BLACK);
			comboBox_cidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBox_cidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBox_cidade.setEditable(false);
			comboBox_cidade.setBounds(102, 500, 221, 32);
			panelFornecedor.add(comboBox_cidade);
			
			cidade = new JTextField();
			cidade.setVisible(false);
			cidade.setSelectionColor(SystemColor.textHighlight);
			cidade.setHorizontalAlignment(SwingConstants.CENTER);
			cidade.setForeground(Color.BLACK);
			cidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cidade.setColumns(10);
			cidade.setBorder(null);
			cidade.setBounds(102, 500, 221, 32);
			panelFornecedor.add(cidade);
			
			cep = new JFormattedTextField((Object) null);
			try {
				cep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"#####-###")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			cep.setSelectionColor(SystemColor.textHighlight);
			cep.setHorizontalAlignment(SwingConstants.CENTER);
			cep.setForeground(Color.BLACK);
			cep.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cep.setColumns(10);
			cep.setBounds(333, 500, 170, 32);
			panelFornecedor.add(cep);
			
			cnpj = new JTextField();
			cnpj.setForeground(Color.BLACK);
			cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					cnpj.setText(cnpj.getText().replaceAll("[^0-9]", ""));
					// cnpj.setText(cnpj.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			cnpj.setSelectionColor(SystemColor.textHighlight);
			cnpj.setHorizontalAlignment(SwingConstants.CENTER);
			cnpj.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cnpj.setColumns(10);
			cnpj.setBounds(513, 500, 148, 32);
			panelFornecedor.add(cnpj);
			
			iE = new JTextField();
			iE.setForeground(Color.BLACK);
			iE.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					iE.setText(iE.getText().replaceAll("[^0-9]", ""));
					// iE.setText(iE.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			iE.setSelectionColor(SystemColor.textHighlight);
			iE.setHorizontalAlignment(SwingConstants.CENTER);
			iE.setFont(new Font("Kalinga", Font.PLAIN, 14));
			iE.setColumns(10);
			iE.setBounds(671, 500, 148, 32);
			panelFornecedor.add(iE);
			
			telefone1 = new JFormattedTextField();
			telefone1.setForeground(Color.BLACK);
			telefone1.setSelectionColor(SystemColor.textHighlight);
			try {
				telefone1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			telefone1.setText("");
			telefone1.setHorizontalAlignment(SwingConstants.CENTER);
			telefone1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone1.setColumns(10);
			telefone1.setBounds(28, 279, 143, 32);
			panelFornecedor.add(telefone1);
			
			telefone2 = new JFormattedTextField();
			telefone2.setForeground(Color.BLACK);
			telefone2.setSelectionColor(SystemColor.textHighlight);
			try {
				telefone2.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			telefone2.setText("");
			telefone2.setHorizontalAlignment(SwingConstants.CENTER);
			telefone2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone2.setColumns(10);
			telefone2.setBounds(181, 279, 144, 32);
			panelFornecedor.add(telefone2);
			
			celular1 = new JFormattedTextField();
			celular1.setForeground(Color.BLACK);
			celular1.setSelectionColor(SystemColor.textHighlight);
			try {
				celular1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)#####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			celular1.setHorizontalAlignment(SwingConstants.CENTER);
			celular1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular1.setColumns(10);
			celular1.setBounds(335, 279, 145, 32);
			panelFornecedor.add(celular1);
			
			celular2 = new JFormattedTextField();
			celular2.setForeground(Color.BLACK);
			celular2.setSelectionColor(SystemColor.textHighlight);
			try {
				celular2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)#####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			celular2.setHorizontalAlignment(SwingConstants.CENTER);
			celular2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular2.setColumns(10);
			celular2.setBounds(488, 279, 145, 32);
			panelFornecedor.add(celular2);
			String sql7 = "select * from contadores";
			ResultSet rs7 = x.Consultar(sql7);
			try {
				while (rs7.next()) {
					codigo5.setText(rs7.getString("codigoFornecedor"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			String sql11 = "select * from tb_estados";
			ResultSet rs11 = x.Consultar(sql11);
			try {
				if (Inicio.rd == 0) {
					comboBox_estado.addItem("");
					while (rs11.next()) {
						comboBox_estado.addItem(rs11.getString("uf"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			menuBar_3 = new JMenuBar();
			menuBar_3.setBounds(168, 0, 1015, 32);
			panelFornecedor.add(menuBar_3);
			
			button_4 = new JButton("Salvar");
			button_4.setForeground(Color.BLACK);
			menuBar_3.add(button_4);
			button_4.setToolTipText("alt + Enter");
			button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.salvarFornecedor();
				}
			});
			button_4.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			button_4.setMnemonic(KeyEvent.VK_ENTER);
			button_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnAtualizar_1 = new JButton("Atualizar");
			btnAtualizar_1.setForeground(Color.BLACK);
			menuBar_3.add(btnAtualizar_1);
			btnAtualizar_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.AtualizarFornecedor();
				}
			});
			btnAtualizar_1.setVisible(false);
			btnAtualizar_1.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnAtualizar_1.setToolTipText("alt + Enter");
			btnAtualizar_1.setMnemonic(KeyEvent.VK_ENTER);
			btnAtualizar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			buttonConsultarFornecedor = new JButton("Consultar");
			buttonConsultarFornecedor.setForeground(Color.BLACK);
			menuBar_3.add(buttonConsultarFornecedor);
			buttonConsultarFornecedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.ConsultarFornecedor();
				}
			});
			buttonConsultarFornecedor.setVisible(false);
			buttonConsultarFornecedor.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			buttonConsultarFornecedor.setMnemonic(KeyEvent.VK_P);
			buttonConsultarFornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnCancelar_2 = new JButton("Cancelar");
			btnCancelar_2.setForeground(Color.BLACK);
			menuBar_3.add(btnCancelar_2);
			btnCancelar_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					limparFornecedor();
				}
			});
			btnCancelar_2.setToolTipText("alt + Delete");
			btnCancelar_2.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar_2.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar_2.setAlignmentX(0.5f);
			
			JButton btnLimpar = new JButton("Limpar");
			btnLimpar.setForeground(Color.BLACK);
			menuBar_3.add(btnLimpar);
			btnLimpar.setToolTipText("alt + Backspace");
			btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLimpar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Suprimentos.limparFornecedor();
				}
			});
			btnLimpar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btnLimpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btnLimpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			button_13 = new JButton("Alterar");
			button_13.setForeground(Color.BLACK);
			menuBar_3.add(button_13);
			button_13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnAtualizar_1.setVisible(true);
					SetarFornEditavel();
					comboBox_estado.setSelectedItem(estado.getText());
					comboBox_cidade.setSelectedItem(cidade.getText());
				}
			});
			button_13.setEnabled(false);
			button_13.setToolTipText("alt + Space");
			button_13.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_13.setMnemonic(KeyEvent.VK_SPACE);
			button_13.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_13.setFocusTraversalPolicyProvider(true);
			button_13.setFocusCycleRoot(true);
			button_13.setAlignmentX(0.5f);
			
			button_5 = new JButton("Imprimir");
			button_5.setForeground(Color.BLACK);
			menuBar_3.add(button_5);
			button_5.setEnabled(false);
			button_5.setToolTipText("alt + P");
			button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// report.Suprimentos();
				}
			});
			button_5.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_5.setMnemonic(KeyEvent.VK_P);
			button_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			buttonAnteriorF = new JButton("Anterior");
			buttonAnteriorF.setForeground(Color.BLACK);
			menuBar_3.add(buttonAnteriorF);
			buttonAnteriorF.setEnabled(false);
			buttonAnteriorF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			buttonAnteriorF.setToolTipText("alt + <");
			buttonAnteriorF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buttonAnteriorF.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			buttonAnteriorF.setMnemonic(KeyEvent.VK_P);
			buttonAnteriorF.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnPrximoF = new JButton("Próximo");
			btnPrximoF.setForeground(Color.BLACK);
			menuBar_3.add(btnPrximoF);
			btnPrximoF.setEnabled(false);
			btnPrximoF.setToolTipText("alt + >");
			btnPrximoF.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPrximoF.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnPrximoF.setMnemonic(KeyEvent.VK_P);
			btnPrximoF.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnSelecionar = new JButton("Selecionar");
			btnSelecionar.setForeground(Color.BLACK);
			btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSelecionar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					SuprimentosController.SelecionarImagemFornecedor();
				}
			});
			btnSelecionar.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606659_678090-camera-128.png")));
			btnSelecionar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnSelecionar.setBounds(940, 276, 145, 35);
			panelFornecedor.add(btnSelecionar);
			
			button_atualizarImagemForn = new JButton("Imagem");
			button_atualizarImagemForn.setForeground(Color.BLACK);
			button_atualizarImagemForn.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606698_camera-128.png")));
			button_atualizarImagemForn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					SuprimentosController.atualizarImagemFornecedor();
				}
			});
			button_atualizarImagemForn.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_atualizarImagemForn.setBounds(940, 277, 145, 35);
			panelFornecedor.add(button_atualizarImagemForn);
			
			label_2 = new JLabel("Cel 2");
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_2.setBounds(488, 244, 41, 32);
			panelFornecedor.add(label_2);
			
			label_3 = new JLabel("CNPJ");
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_3.setBounds(513, 465, 49, 32);
			panelFornecedor.add(label_3);
			
			label_4 = new JLabel("I.E");
			label_4.setForeground(Color.BLACK);
			label_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_4.setBounds(672, 465, 41, 32);
			panelFornecedor.add(label_4);
			
			label_5 = new JLabel("Cel 1");
			label_5.setForeground(Color.BLACK);
			label_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_5.setBounds(335, 245, 41, 32);
			panelFornecedor.add(label_5);
			
			label_6 = new JLabel("Vendedor");
			label_6.setForeground(Color.BLACK);
			label_6.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_6.setBounds(578, 156, 94, 32);
			panelFornecedor.add(label_6);
			
			label_8 = new JLabel("Nome");
			label_8.setForeground(Color.BLACK);
			label_8.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_8.setBounds(211, 156, 49, 32);
			panelFornecedor.add(label_8);
			
			label_10 = new JLabel("Telefone 1");
			label_10.setForeground(Color.BLACK);
			label_10.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_10.setBounds(28, 245, 80, 32);
			panelFornecedor.add(label_10);
			
			label_11 = new JLabel("Telefone 2");
			label_11.setForeground(Color.BLACK);
			label_11.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_11.setBounds(181, 245, 80, 32);
			panelFornecedor.add(label_11);
			
			labelFotoFornecedor = new JLabel("(165x115)");
			labelFotoFornecedor.setForeground(Color.BLACK);
			labelFotoFornecedor.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_32px/1425606663_image-128.png")));
			labelFotoFornecedor.setOpaque(true);
			labelFotoFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoFornecedor.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoFornecedor.setBackground(Color.WHITE);
			labelFotoFornecedor.setBounds(940, 178, 145, 95);
			panelFornecedor.add(labelFotoFornecedor);
			
			JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
			lblCdigo_1.setForeground(Color.BLACK);
			lblCdigo_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCdigo_1.setBounds(28, 156, 80, 32);
			panelFornecedor.add(lblCdigo_1);
			
			JLabel lblEndereo = new JLabel("Logradouro");
			lblEndereo.setForeground(Color.BLACK);
			lblEndereo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblEndereo.setBounds(28, 386, 80, 32);
			panelFornecedor.add(lblEndereo);
			
			JLabel lblNmero = new JLabel("Numero");
			lblNmero.setForeground(Color.BLACK);
			lblNmero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNmero.setBounds(400, 384, 64, 32);
			panelFornecedor.add(lblNmero);
			
			JLabel label_21 = new JLabel("Complemento");
			label_21.setForeground(Color.BLACK);
			label_21.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_21.setBounds(474, 385, 104, 32);
			panelFornecedor.add(label_21);
			
			JLabel label_22 = new JLabel("CEP");
			label_22.setForeground(Color.BLACK);
			label_22.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_22.setBounds(334, 465, 41, 32);
			panelFornecedor.add(label_22);
			
			JLabel label_23 = new JLabel("Cidade");
			label_23.setForeground(Color.BLACK);
			label_23.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_23.setBounds(102, 465, 49, 32);
			panelFornecedor.add(label_23);
			
			JLabel label_24 = new JLabel("UF");
			label_24.setForeground(Color.BLACK);
			label_24.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_24.setBounds(28, 465, 49, 32);
			panelFornecedor.add(label_24);
			
			JLabel label_25 = new JLabel("Bairro");
			label_25.setForeground(Color.BLACK);
			label_25.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_25.setBounds(745, 385, 80, 32);
			panelFornecedor.add(label_25);
			
			lblPor3 = new JLabel("Por ?");
			lblPor3.setVisible(false);
			lblPor3.setHorizontalAlignment(SwingConstants.CENTER);
			lblPor3.setForeground(Color.BLACK);
			lblPor3.setFont(new Font("Kalinga", Font.BOLD, 15));
			lblPor3.setBounds(821, 61, 38, 32);
			panelFornecedor.add(lblPor3);
			
			label_28 = new JLabel("");
			label_28.setForeground(Color.BLACK);
			label_28.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_28.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS FORNECEDOR", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_28.setBounds(10, 122, 1331, 212);
			panelFornecedor.add(label_28);
			
			label_29 = new JLabel("");
			label_29.setForeground(Color.BLACK);
			label_29.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_29.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "ENDERE\u00C7O FORNECEDOR", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
			label_29.setBounds(10, 346, 1331, 300);
			panelFornecedor.add(label_29);
			
			label_16 = new JLabel("");
			label_16.setForeground(Color.BLACK);
			label_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_16.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_16.setBounds(10, 43, 1325, 69);
			panelFornecedor.add(label_16);
			
			labelFundoFornecedor = new JLabel("");
			labelFundoFornecedor.setForeground(Color.BLACK);
			labelFundoFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoFornecedor.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoFornecedor.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			labelFundoFornecedor.setVerticalAlignment(SwingConstants.TOP);
			labelFundoFornecedor.setBounds(0, 0, 1358, 674);
			panelFornecedor.add(labelFundoFornecedor);
			
			caminho3 = new JTextField();
			caminho3.setColumns(10);
			caminho3.setBounds(645, 614, 122, 32);
			panelFornecedor.add(caminho3);
			caminho3.setVisible(false);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			tabbedPaneSuprimentos
					.addTab(" Estoque ",
							new ImageIcon(
									Suprimentos.class
											.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
							panelAddproduto, null);
			
			panelPedidoCompra = new JPanel();
			panelPedidoCompra.setLayout(null);
			panelPedidoCompra.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelPedidoCompra.setBorder(null);
			
			JRadioButton rdbtnConsultarPedido = new JRadioButton("Consultar Pedido");
			rdbtnConsultarPedido.setForeground(Color.BLACK);
			rdbtnConsultarPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			rdbtnConsultarPedido.setOpaque(false);
			rdbtnConsultarPedido.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarPedido.setFont(new Font("Khmer UI", Font.BOLD, 14));
			rdbtnConsultarPedido.setBounds(665, 60, 173, 35);
			panelPedidoCompra.add(rdbtnConsultarPedido);
			
			JRadioButton rdbtnCadastrarPedido = new JRadioButton("Cadastrar Pedido");
			rdbtnCadastrarPedido.setForeground(Color.BLACK);
			rdbtnCadastrarPedido.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			rdbtnCadastrarPedido.setOpaque(false);
			rdbtnCadastrarPedido.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnCadastrarPedido.setFont(new Font("Khmer UI", Font.BOLD, 14));
			rdbtnCadastrarPedido.setBounds(479, 60, 173, 35);
			panelPedidoCompra.add(rdbtnCadastrarPedido);
			
			comboPor = new JComboBox<String>();
			comboPor.setForeground(Color.BLACK);
			comboPor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPor.setBounds(879, 61, 131, 32);
			panelPedidoCompra.add(comboPor);
			
			NumeroPedido = new JTextField();
			NumeroPedido.setForeground(Color.BLACK);
			NumeroPedido.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					NumeroPedido.setText(NumeroPedido.getText().replaceAll("[^0-9]", ""));
					// NumeroPedido.setText(NumeroPedido.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			NumeroPedido.setSelectionColor(SystemColor.textHighlight);
			NumeroPedido.setDisabledTextColor(SystemColor.textText);
			NumeroPedido.setHorizontalAlignment(SwingConstants.CENTER);
			NumeroPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumeroPedido.setColumns(10);
			NumeroPedido.setBounds(20, 178, 130, 32);
			panelPedidoCompra.add(NumeroPedido);
			
			Fornecedor = new JTextField();
			Fornecedor.setForeground(Color.BLACK);
			Fornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Fornecedor.setText(Fornecedor.getText().replaceAll("[^0-9]",
					// ""));
					Fornecedor.setText(Fornecedor.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			Fornecedor.setSelectionColor(SystemColor.textHighlight);
			Fornecedor.setDisabledTextColor(SystemColor.textText);
			Fornecedor.setHorizontalAlignment(SwingConstants.CENTER);
			Fornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Fornecedor.setColumns(10);
			Fornecedor.setBounds(160, 178, 381, 32);
			panelPedidoCompra.add(Fornecedor);
			
			DataPedido = new JFormattedTextField();
			DataPedido.setForeground(Color.BLACK);
			DataPedido.setSelectionColor(SystemColor.textHighlight);
			DataPedido.setDisabledTextColor(SystemColor.textText);
			try {
				DataPedido.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			DataPedido.setHorizontalAlignment(SwingConstants.CENTER);
			DataPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
			DataPedido.setColumns(10);
			DataPedido.setBounds(551, 178, 115, 32);
			panelPedidoCompra.add(DataPedido);
			
			PrazoRecebimento = new JFormattedTextField();
			PrazoRecebimento.setForeground(Color.BLACK);
			PrazoRecebimento.setSelectionColor(SystemColor.textHighlight);
			PrazoRecebimento.setDisabledTextColor(SystemColor.textText);
			try {
				PrazoRecebimento.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			PrazoRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
			PrazoRecebimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			PrazoRecebimento.setColumns(10);
			PrazoRecebimento.setBounds(676, 178, 115, 32);
			panelPedidoCompra.add(PrazoRecebimento);
			
			Produtos = new JComboBox<String>();
			Produtos.setForeground(Color.BLACK);
			Produtos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Produtos.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Produtos.setBounds(20, 306, 381, 32);
			panelPedidoCompra.add(Produtos);
			
			Quantidade = new JTextField();
			Quantidade.setForeground(Color.BLACK);
			Quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Quantidade.setText(Quantidade.getText().replaceAll("[^0-9]", ""));
					// Quantidade.setText(Quantidade.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Quantidade.setSelectionColor(SystemColor.textHighlight);
			Quantidade.setDisabledTextColor(SystemColor.textText);
			Quantidade.setText("0");
			Quantidade.setHorizontalAlignment(SwingConstants.CENTER);
			Quantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Quantidade.setColumns(10);
			Quantidade.setBounds(415, 306, 115, 32);
			panelPedidoCompra.add(Quantidade);
			
			PrecoUnitario = new JTextField();
			PrecoUnitario.setForeground(Color.BLACK);
			PrecoUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					PrecoUnitario.setText(PrecoUnitario.getText()
							.replaceAll("[^0-9]", ""));
					// PrecoUnitario.setText(PrecoUnitario.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			PrecoUnitario.setSelectionColor(SystemColor.textHighlight);
			PrecoUnitario.setDisabledTextColor(SystemColor.textText);
			PrecoUnitario.setText("0,00");
			PrecoUnitario.setHorizontalAlignment(SwingConstants.CENTER);
			PrecoUnitario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			PrecoUnitario.setColumns(10);
			PrecoUnitario.setBounds(546, 306, 115, 32);
			panelPedidoCompra.add(PrecoUnitario);
			
			JRadioButton rdbtnPrazo = new JRadioButton("À Prazo");
			rdbtnPrazo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnPrazo.setSelected(true);
			rdbtnPrazo.setOpaque(false);
			rdbtnPrazo.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnPrazo.setForeground(Color.BLACK);
			rdbtnPrazo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			rdbtnPrazo.setBounds(217, 443, 101, 32);
			panelPedidoCompra.add(rdbtnPrazo);
			
			JRadioButton radioButton_1 = new JRadioButton("À Vista");
			radioButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioButton_1.setSelected(true);
			radioButton_1.setOpaque(false);
			radioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
			radioButton_1.setForeground(Color.BLACK);
			radioButton_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioButton_1.setBounds(20, 443, 80, 32);
			panelPedidoCompra.add(radioButton_1);
			
			JComboBox<String> comboVista = new JComboBox<String>();
			comboVista.setForeground(Color.BLACK);
			comboVista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboVista.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboVista.setBounds(20, 472, 184, 32);
			panelPedidoCompra.add(comboVista);
			
			JComboBox<String> comboPrazo = new JComboBox<String>();
			comboPrazo.setForeground(Color.BLACK);
			comboPrazo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboPrazo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPrazo.setBounds(217, 472, 184, 32);
			panelPedidoCompra.add(comboPrazo);
			
			Vencimento = new JFormattedTextField();
			Vencimento.setForeground(Color.BLACK);
			Vencimento.setSelectionColor(SystemColor.scrollbar);
			Vencimento.setDisabledTextColor(SystemColor.textText);
			try {
				Vencimento.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Vencimento.setHorizontalAlignment(SwingConstants.CENTER);
			Vencimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Vencimento.setColumns(10);
			Vencimento.setBounds(415, 472, 115, 32);
			panelPedidoCompra.add(Vencimento);
			
			ValorParcela = new JTextField();
			ValorParcela.setForeground(Color.BLACK);
			ValorParcela.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					ValorParcela.setText(ValorParcela.getText().replaceAll("[^0-9]", ""));
					// ValorParcela.setText(ValorParcela.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			ValorParcela.setSelectionColor(SystemColor.textHighlight);
			ValorParcela.setDisabledTextColor(SystemColor.textText);
			ValorParcela.setText("0,00");
			ValorParcela.setHorizontalAlignment(SwingConstants.CENTER);
			ValorParcela.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ValorParcela.setColumns(10);
			ValorParcela.setBounds(546, 472, 115, 32);
			panelPedidoCompra.add(ValorParcela);
			
			Observacao = new JTextField();
			Observacao.setForeground(Color.BLACK);
			Observacao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Observacao.setText(Observacao.getText().replaceAll("[^0-9]",
					// ""));
					Observacao.setText(Observacao.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			Observacao.setSelectionColor(SystemColor.textHighlight);
			Observacao.setDisabledTextColor(SystemColor.textText);
			Observacao.setHorizontalAlignment(SwingConstants.CENTER);
			Observacao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Observacao.setColumns(10);
			Observacao.setBounds(681, 472, 410, 32);
			panelPedidoCompra.add(Observacao);
			
			menuBar_5 = new JMenuBar();
			menuBar_5.setBounds(410, 0, 531, 32);
			panelPedidoCompra.add(menuBar_5);
			
			button = new JButton("Salvar");
			button.setForeground(Color.BLACK);
			menuBar_5.add(button);
			button.setToolTipText("alt + Enter");
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			button.setMnemonic(KeyEvent.VK_ENTER);
			button.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			button_16 = new JButton("Excluir");
			button_16.setForeground(Color.BLACK);
			menuBar_5.add(button_16);
			button_16.setToolTipText("alt + Delete");
			button_16.setEnabled(false);
			button_16.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_16.setMnemonic(KeyEvent.VK_DELETE);
			button_16.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_16.setAlignmentX(0.5f);
			
			button_3 = new JButton("Limpar");
			button_3.setForeground(Color.BLACK);
			menuBar_5.add(button_3);
			button_3.setToolTipText("alt + Backspace");
			button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_3.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			button_3.setMnemonic(KeyEvent.VK_BACK_SPACE);
			button_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			button_17 = new JButton("Alterar");
			button_17.setForeground(Color.BLACK);
			menuBar_5.add(button_17);
			button_17.setToolTipText("alt + Space");
			button_17.setEnabled(false);
			button_17.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_17.setMnemonic(KeyEvent.VK_SPACE);
			button_17.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_17.setFocusTraversalPolicyProvider(true);
			button_17.setFocusCycleRoot(true);
			button_17.setAlignmentX(0.5f);
			
			button_8 = new JButton("Imprimir");
			button_8.setForeground(Color.BLACK);
			menuBar_5.add(button_8);
			button_8.setToolTipText("alt + P");
			button_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_8.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_8.setMnemonic(KeyEvent.VK_P);
			button_8.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			lblNumeroPedido = new JLabel("Numero Pedido");
			lblNumeroPedido.setForeground(Color.BLACK);
			lblNumeroPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNumeroPedido.setBounds(20, 146, 130, 32);
			panelPedidoCompra.add(lblNumeroPedido);
			
			lblFornecedor = new JLabel("Fornecedor");
			lblFornecedor.setForeground(Color.BLACK);
			lblFornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblFornecedor.setBounds(160, 146, 115, 32);
			panelPedidoCompra.add(lblFornecedor);
			
			lblDataPedido = new JLabel("Data Pedido");
			lblDataPedido.setForeground(Color.BLACK);
			lblDataPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDataPedido.setBounds(551, 146, 115, 32);
			panelPedidoCompra.add(lblDataPedido);
			
			lblPrazoDeRecebimento = new JLabel("Prazo de Recebimento");
			lblPrazoDeRecebimento.setForeground(Color.BLACK);
			lblPrazoDeRecebimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblPrazoDeRecebimento.setBounds(676, 146, 160, 32);
			panelPedidoCompra.add(lblPrazoDeRecebimento);
			
			lblProdutos = new JLabel("Produtos");
			lblProdutos.setForeground(Color.BLACK);
			lblProdutos.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblProdutos.setBounds(20, 274, 130, 32);
			panelPedidoCompra.add(lblProdutos);
			
			lblQuantidade_2 = new JLabel("Quantidade");
			lblQuantidade_2.setForeground(Color.BLACK);
			lblQuantidade_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblQuantidade_2.setBounds(415, 274, 115, 32);
			panelPedidoCompra.add(lblQuantidade_2);
			
			lblPreoUnitrio = new JLabel("Preço Unitário");
			lblPreoUnitrio.setForeground(Color.BLACK);
			lblPreoUnitrio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblPreoUnitrio.setBounds(546, 274, 115, 32);
			panelPedidoCompra.add(lblPreoUnitrio);
			
			label_17 = new JLabel("Forma de Pagamento");
			label_17.setHorizontalAlignment(SwingConstants.CENTER);
			label_17.setForeground(Color.BLACK);
			label_17.setFont(new Font("Khmer UI", Font.BOLD, 14));
			label_17.setBounds(91, 404, 160, 32);
			panelPedidoCompra.add(label_17);
			
			JLabel lblVencimento = new JLabel("Vencimento");
			lblVencimento.setForeground(Color.BLACK);
			lblVencimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblVencimento.setBounds(415, 440, 115, 32);
			panelPedidoCompra.add(lblVencimento);
			
			JLabel lblValorParcela = new JLabel("Valor Parcela");
			lblValorParcela.setForeground(Color.BLACK);
			lblValorParcela.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblValorParcela.setBounds(546, 440, 115, 32);
			panelPedidoCompra.add(lblValorParcela);
			
			JLabel lblObservao = new JLabel("Observação");
			lblObservao.setForeground(Color.BLACK);
			lblObservao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblObservao.setBounds(681, 440, 115, 32);
			panelPedidoCompra.add(lblObservao);
			
			JLabel labelPor = new JLabel("Por");
			labelPor.setForeground(Color.BLACK);
			labelPor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelPor.setBounds(844, 61, 38, 32);
			panelPedidoCompra.add(labelPor);
			
			JLabel label_1 = new JLabel("");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_1.setBounds(10, 111, 1331, 128);
			panelPedidoCompra.add(label_1);
			
			JLabel label_15 = new JLabel("");
			label_15.setForeground(Color.BLACK);
			label_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_15.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_15.setBounds(10, 250, 1331, 134);
			panelPedidoCompra.add(label_15);
			
			JLabel label_32 = new JLabel("");
			label_32.setForeground(Color.BLACK);
			label_32.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_32.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_32.setBounds(8, 395, 1333, 253);
			panelPedidoCompra.add(label_32);
			
			label_7 = new JLabel("");
			label_7.setForeground(Color.BLACK);
			label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_7.setBounds(10, 43, 1325, 69);
			panelPedidoCompra.add(label_7);
			
			labelFundoCompra = new JLabel("");
			labelFundoCompra.setForeground(Color.BLACK);
			labelFundoCompra.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			labelFundoCompra.setVerticalAlignment(SwingConstants.TOP);
			labelFundoCompra.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoCompra.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoCompra.setBounds(0, 0, 1358, 674);
			panelPedidoCompra.add(labelFundoCompra);
			
			tabbedPaneSuprimentos.addTab("Pedido de Compra", new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606565_calendar-128.png")),
					panelPedidoCompra, null);
			
			panelRelatorios = new JPanel();
			panelRelatorios.setLayout(null);
			panelRelatorios.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelRelatorios.setBorder(null);
			tabbedPaneSuprimentos.addTab("Relatórios", new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
					panelRelatorios, null);
			
			JMenuBar menuBar_6 = new JMenuBar();
			menuBar_6.setBounds(0, 0, 1351, 32);
			panelRelatorios.add(menuBar_6);
			
			JButton button_9 = new JButton("Grafico");
			button_9.setForeground(Color.BLACK);
			button_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultPieDataset pieDataset = new DefaultPieDataset();
					pieDataset.setValue("Caixa", new Integer(10));
					pieDataset.setValue("Duzia", new Integer(42));
					pieDataset.setValue("Litro", new Integer(55));
					pieDataset.setValue("Metro", new Integer(78));
					pieDataset.setValue("Metro quadrado", new Integer(63));
					pieDataset.setValue("Pacote", new Integer(02));
					pieDataset.setValue("Peça", new Integer(51));
					pieDataset.setValue("Quilo", new Integer(13));
					pieDataset.setValue("Unidade", new Integer(25));
					JFreeChart chart = ChartFactory.createPieChart3D("Qt. de Produtos",
							pieDataset, true, true, true);
					
					PiePlot3D plot = (PiePlot3D) chart.getPlot();
					plot.setStartAngle(290);
					plot.setDirection(Rotation.CLOCKWISE);
					plot.setForegroundAlpha(0.5f);
					plot.setNoDataMessage("No data to display");
					
					chart.getPlot();
					
					ChartFrame frame = new ChartFrame("% dos produtos", chart);
					frame.setVisible(true);
					frame.setBounds(8, 43, 655, 605);
					frame.setSize(400, 450);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
					
					barDataset.setValue(10, "Caixa", "Quantidade:");
					barDataset.setValue(42, "Duzia", "Quantidade:");
					barDataset.setValue(55, "Litro", "Quantidade:");
					barDataset.setValue(78, "Metro", "Quantidade:");
					barDataset.setValue(63, "Metro quadrado", "Quantidade:");
					barDataset.setValue(02, "Pacote", "Quantidade:");
					barDataset.setValue(51, "Peça", "Quantidade:");
					barDataset.setValue(13, "Quilo", "Quantidade:");
					barDataset.setValue(25, "Unidade", "Quantidade:");
					
					JFreeChart chart1 = ChartFactory.createBarChart3D("$ em estoque", "",
							"Faixa monetária", barDataset, PlotOrientation.VERTICAL,
							false, true, false);
					
					CategoryPlot p = chart1.getCategoryPlot();
					p.setRangeGridlinePaint(Color.black);
					ChartFrame frame1 = new ChartFrame("Histórico de Vendas", chart1);
					frame1.setVisible(true);
					frame1.setBounds(686, 43, 655, 605);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
				}
			});
			button_9.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/icones1_24px/1425606754_monitor-128.png")));
			button_9.setToolTipText("alt + G");
			button_9.setMnemonic(KeyEvent.VK_G);
			button_9.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar_6.add(button_9);
			
			label_49 = new JLabel("");
			label_49.setForeground(Color.BLACK);
			label_49.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_49.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "% dos produtos", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_49.setBounds(8, 43, 655, 605);
			panelRelatorios.add(label_49);
			
			label_34 = new JLabel("");
			label_34.setForeground(Color.BLACK);
			label_34.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_34.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "$ em estoque", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_34.setBounds(686, 43, 655, 605);
			panelRelatorios.add(label_34);
			
			label_50 = new JLabel("");
			label_50.setForeground(Color.BLACK);
			label_50.setIcon(new ImageIcon(Suprimentos.class
					.getResource("/papel_parede/03.jpg")));
			label_50.setVerticalAlignment(SwingConstants.TOP);
			label_50.setHorizontalTextPosition(SwingConstants.CENTER);
			label_50.setHorizontalAlignment(SwingConstants.CENTER);
			label_50.setBounds(0, 0, 1358, 674);
			panelRelatorios.add(label_50);
			
			this.setSize(new Dimension(1366, 768));
			// this.setSize(toolkit.getScreenSize());
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Suprimentos.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Suprimentos.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Suprimentos.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Suprimentos.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Métodos ligados á interface gráfica
	protected static void OcultarFornecedor() {
		radioNovo.setSelected(false);
		radioCadastro.setSelected(true);
		
		nomeEst.setEnabled(false);
	}
	
	private static void FichaTecnica() {
		modeloficha.removeRow(0);
	}
	
	protected static void SelecionarPapelParedeSuprimentos() {
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
			
			labelFundoProduto.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoMateriaPrima.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoFornecedor.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoEstoque.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoCompra.setIcon(new javax.swing.ImageIcon(diretorio));
			
			caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
					.replace("\\", "~").toString());
			System.out.print(diretorio);
		}
	}
	
	// Métodos ligados á aba Produto
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Produto
	protected static void SetarProdutoNaoEditavel() {
		comboBoxTipoProd.setVisible(false);
		tipoConsultaProd.setVisible(true);
		codigo1.setEnabled(false);
		nome1.setDisabledTextColor(Color.BLACK);
		nome1.setEnabled(false);
		descricaoProduto.setDisabledTextColor(Color.BLACK);
		descricaoProduto.setEnabled(false);
		validade1.setDisabledTextColor(Color.BLACK);
		validade1.setEnabled(false);
		estoqueMinimo1.setVisible(false);
		estoqueminconsulta.setVisible(true);
		numeroLote.setDisabledTextColor(Color.BLACK);
		numeroLote.setEnabled(false);
		tipoConsultaProd.setDisabledTextColor(Color.BLACK);
		tipoConsultaProd.setEnabled(false);
		comboUnidade.setVisible(false);
		unidadeconsulta.setVisible(true);
		localEstoque_1.setDisabledTextColor(Color.BLACK);
		localEstoque_1.setEnabled(false);
		dataCompra_1.setDisabledTextColor(Color.BLACK);
		dataCompra_1.setEnabled(false);
		margemLucro.setDisabledTextColor(Color.BLACK);
		margemLucro.setEnabled(false);
		precoCusto.setDisabledTextColor(Color.BLACK);
		precoCusto.setEnabled(false);
		precoVenda.setDisabledTextColor(Color.BLACK);
		precoVenda.setEnabled(false);
		btnAddItem.setVisible(false);
		btnRemItem.setVisible(false);
		scrollPane.setVisible(true);
		quantidade.setVisible(false);
		lblQuantidade.setVisible(false);
		comboBox.setVisible(false);
		lblMp.setVisible(false);
		ipi.setVisible(false);
		iss.setVisible(false);
		pis.setVisible(false);
		cofins.setVisible(false);
		icms.setVisible(false);
		fichaNao.setVisible(false);
		fichaSim.setVisible(false);
		btnCalcular.setVisible(false);
		System.out.println(contLinha);
	}
	
	protected static void SetarProdutoEditavel() {
		comboBoxTipoProd.setVisible(true);
		tipoConsultaProd.setVisible(false);
		nome1.setEnabled(true);
		descricaoProduto.setEnabled(true);
		estoqueMinimo1.setVisible(true);
		estoqueminconsulta.setVisible(false);
		numeroLote.setEnabled(true);
		validade1.setEnabled(true);
		tipoConsultaProd.setEnabled(true);
		comboUnidade.setVisible(true);
		unidadeconsulta.setVisible(false);
		localEstoque_1.setEnabled(true);
		localEstoque_1.setText(null);
		margemLucro.setEnabled(true);
		btnAddItem.setVisible(true);
		btnRemItem.setVisible(true);
		ipi.setVisible(true);
		iss.setVisible(true);
		pis.setVisible(true);
		cofins.setVisible(true);
		icms.setVisible(true);
		quantidade.setVisible(true);
		lblQuantidade.setVisible(true);
		comboBox.setVisible(true);
		lblMp.setVisible(true);
		btnCalcular.setVisible(true);
		fichaNao.setVisible(true);
		fichaSim.setVisible(true);
	}
	
	public static void limparProduto() {
		codigo1.setText(null);
		nome1.setText(null);
		descricaoProduto.setText(null);
		estoqueMinimo1.setValue(1);
		numeroLote.setText(null);
		tipoConsultaProd.setText(null);
		comboUnidade.setSelectedItem("");
		unidadeconsulta.setText(null);
		comboBox_2.setSelectedItem("");
		localEstoque_1.setText(null);
		dataCompra_1.setText(null);
		validade1.setText(null);
		precoCusto.setText("00.00");
		margemLucro.setText("0");
		fichaNao.setSelected(true);
		fichaSim.setSelected(false);
		btnAddItem.setVisible(false);
		btnRemItem.setVisible(false);
		scrollPane.setVisible(false);
		quantidade.setVisible(false);
		lblQuantidade.setVisible(false);
		comboBox.setVisible(false);
		lblMp.setVisible(false);
		ficha = "não";
		precoVenda.setText("00.00");
		ipi.setSelected(false);
		ipi_1.setText("0");
		ipi_1.setEnabled(false);
		iss.setSelected(false);
		iss_1.setText("0");
		iss_1.setEnabled(false);
		pis.setSelected(false);
		pis_1.setText("0");
		pis_1.setEnabled(false);
		cofins.setSelected(false);
		cofins_1.setText("0");
		cofins_1.setEnabled(false);
		icms.setSelected(false);
		icms_1.setText("0");
		icms_1.setEnabled(false);
		labelFotoProduto.setText("Imagem");
		labelFotoProduto.setIcon(new ImageIcon(Suprimentos.class
				.getResource("/icones1_48px/1425606663_image-128.png")));
		estoqueminconsulta.setText(null);
		Suprimentos.AlterarProduto.setEnabled(false);
		Suprimentos.button_1.setEnabled(false);
		Suprimentos.btnAnterior.setEnabled(false);
		Suprimentos.btnProximo.setEnabled(false);
		if (contLinha > 0) {
			for (int i = 0; i < contLinha; i++) {
				modeloficha.removeRow(0);
			}
			contLinha = 0;
			SuprimentosController.contLinha = 0;
		}
	}
	
	// Métodos ligados á aba Matéria prima
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Métodos ligados á aba "Matéria Prima"
	
	public static void limparMP() {
		nome2.setText(null);
		
		if (rdbtnConsultarMP.isSelected() == true) {
			codigo2.setText("");
			comboBox_3.requestFocus();
		}
		numeroLote2.setText(null);
		tipoConsultaMP.setText(null);
		comboUnidade2.setSelectedItem("");
		localEstoque.setText(null);
		descricaoMateriaPrima2.setText(null);
		comboBox_3.setSelectedItem("");
		precoPor2.setText(null);
		estoqueMinimo2.setValue(1);
		unidadeconsulta2.setText(null);
		estoqueMinimoConsulta2.setText(null);
		codigo2.setEnabled(false);
		labelFotoMateriaPrima.setText("imagem");
		labelFotoMateriaPrima.setIcon(new ImageIcon(Suprimentos.class
				.getResource("/icones1_48px/1425606663_image-128.png")));
	}
	
	protected static void SetarMpEditavel() {
		comboBox_4.setVisible(true);
		nome2.setEnabled(true);
		descricaoMateriaPrima2.setEnabled(true);
		localEstoque.setEnabled(true);
		estoqueMinimo2.setVisible(true);
		estoqueMinimoConsulta2.setVisible(false);
		numeroLote2.setEnabled(true);
		tipoConsultaMP.setVisible(false);
		comboUnidade2.setVisible(true);
		unidadeconsulta2.setVisible(false);
		comboUnidade2.setSelectedItem(" ");
		precoPor2.setEnabled(true);
		estoqueMinimoConsulta2.setVisible(false);
		unidadeconsulta2.setVisible(false);
	}
	
	protected static void SetarMpNaoEditavel() {
		nome2.setDisabledTextColor(Color.BLACK);
		nome2.setEnabled(false);
		descricaoMateriaPrima2.setDisabledTextColor(Color.BLACK);
		descricaoMateriaPrima2.setEnabled(false);
		localEstoque.setDisabledTextColor(Color.BLACK);
		localEstoque.setEnabled(false);
		numeroLote2.setDisabledTextColor(Color.BLACK);
		numeroLote2.setEnabled(false);
		tipoConsultaMP.setDisabledTextColor(Color.BLACK);
		tipoConsultaMP.setEnabled(false);
		precoPor2.setDisabledTextColor(Color.BLACK);
		precoPor2.setEnabled(false);
		estoqueMinimoConsulta2.setDisabledTextColor(Color.BLACK);
		estoqueMinimoConsulta2.setEnabled(false);
		unidadeconsulta2.setDisabledTextColor(Color.BLACK);
		unidadeconsulta2.setEnabled(false);
	}
	
	// Métodos ligados á aba Fornecedor
	
	public static void limparFornecedor() {
		NomeFornecedor.setText(null);
		vendedor.setText(null);
		endereco.setText(null);
		numero.setText(null);
		complemento.setText(null);
		bairro.setText(null);
		comboBox_estado.setSelectedItem("");
		comboBox_1.setSelectedItem("");
		estado.setText(null);
		cidade.setText(null);
		comboBox_cidade.setSelectedItem("");
		cep.setText(null);
		telefone1.setText(null);
		telefone2.setText(null);
		celular1.setText(null);
		celular2.setText(null);
		cnpj.setText(null);
		iE.setText(null);
		caminho3.setText(null);
		labelFotoFornecedor.setText(null);
		labelFotoFornecedor.setIcon(new ImageIcon(Suprimentos.class
				.getResource("/icones1_32px/1425606663_image-128.png")));
		Suprimentos.button_5.setEnabled(false);
		Suprimentos.buttonAnteriorF.setEnabled(false);
		Suprimentos.btnPrximoF.setEnabled(false);
		Suprimentos.button_13.setEnabled(false);
		btnAtualizar_1.setVisible(false);
	}
	
	protected static void SetarFornEditavel() {
		NomeFornecedor.setEnabled(true);
		
		vendedor.setEnabled(true);
		
		endereco.setEnabled(true);
		
		numero.setEnabled(true);
		
		complemento.setEnabled(true);
		
		bairro.setEnabled(true);
		
		comboBox_estado.setVisible(true);
		estado.setVisible(false);
		
		comboBox_cidade.setVisible(true);
		cidade.setVisible(false);
		
		cep.setEnabled(true);
		
		telefone1.setEnabled(true);
		
		telefone2.setEnabled(true);
		
		celular1.setEnabled(true);
		
		celular2.setEnabled(true);
		
		cnpj.setEnabled(true);
		
		iE.setEnabled(true);
	}
	
	protected static void SetarFornNaoEditavel() {
		NomeFornecedor.setDisabledTextColor(Color.BLACK);
		NomeFornecedor.setEnabled(false);
		
		vendedor.setDisabledTextColor(Color.BLACK);
		vendedor.setEnabled(false);
		
		endereco.setDisabledTextColor(Color.BLACK);
		endereco.setEnabled(false);
		
		numero.setDisabledTextColor(Color.BLACK);
		numero.setEnabled(false);
		
		complemento.setDisabledTextColor(Color.BLACK);
		complemento.setEnabled(false);
		
		bairro.setDisabledTextColor(Color.BLACK);
		bairro.setEnabled(false);
		
		comboBox_estado.setVisible(false);
		estado.setVisible(true);
		estado.setDisabledTextColor(Color.BLACK);
		estado.setEnabled(false);
		
		comboBox_cidade.setVisible(false);
		cidade.setVisible(true);
		cidade.setDisabledTextColor(Color.BLACK);
		cidade.setEnabled(false);
		
		cep.setDisabledTextColor(Color.BLACK);
		cep.setEnabled(false);
		
		telefone1.setDisabledTextColor(Color.BLACK);
		telefone1.setEnabled(false);
		
		telefone2.setDisabledTextColor(Color.BLACK);
		telefone2.setEnabled(false);
		
		celular1.setDisabledTextColor(Color.BLACK);
		celular1.setEnabled(false);
		
		celular2.setDisabledTextColor(Color.BLACK);
		celular2.setEnabled(false);
		
		cnpj.setDisabledTextColor(Color.BLACK);
		cnpj.setEnabled(false);
		
		iE.setDisabledTextColor(Color.BLACK);
		iE.setEnabled(false);
	}
	
	// Métodos ligados á aba Estoque
	
	// Métodos ligados á aba Estoque
	
	protected static void LimparFornecedorEst() {
		iE.setText(null);
		comboNomeEst.setSelectedItem("");
		nomeEst.setText(null);
		codigoFornecedorEst.setText(null);
		Suprimentos.OcultarFornecedor();
	}
	
	public static void limparEstoque() {
		if (contLinhaEst > 0) {
			for (int i = 0; i < contLinhaEst; i++) {
				modeloficha2.removeRow(0);
			}
			contLinhaEst = 0;
		}
		nomeItemEst.setText(null);
		precoUnidadeEst.setText(null);
		estoqueAtual.setText(null);
		estoqueMinimoEst.setText(null);
		unidadeEst.setText(null);
		descricaoEst.setText(null);
		labelFotoEstoque.setIcon(new ImageIcon(Suprimentos.class
				.getResource("/icones1_48px/1425606663_image-128.png")));
		labelFotoEstoque.setText("Imagem");
		codigoEst.setText(null);
		dataCompraEst.setText(null);
		numeroLoteEst.setText(null);
		validadeEst.setText(null);
		notaFiscalEst.setText(null);
		quantidadeAdicionada.setText(null);
		localEstoqueEst.setText(null);
		dataEntrada.setText(null);
		
		Suprimentos.LimparFornecedorEst();
		
		if (rdbtnCadastrar.isSelected() == true)
			dataEntrada.setText(formato.format(data));
	}
}
