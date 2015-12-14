package Solid.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Solid.controller.BancoDados;
import Solid.controller.ChatController;
import Solid.controller.VendasController;
import Solid.model.ModelVendas;
import Solid.model.PPReport;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import javax.swing.JSeparator;

class PainelMesas extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long	serialVersionUID	= -1631294610371053947L;

	// instancia a classe do banco para conexão
	static BancoDados					x				= new BancoDados();

	// instancia a classe para impressao
	PPReport					report			= new PPReport();

	// variaveis do sistema
	private JMenu				menuArquivo, menuConfiguracao, menuAjuda;
	private JMenuBar			menuBar;
	private JMenuItem			menuAbrirAjuda;
	public static JTabbedPane	tabbedPaneVendas;
	protected static JScrollPane	scrollPaneTabela;
	protected DefaultTableModel	modelo;
	protected JSpinner			Quantidade2, quantidade;

	protected static JPanel		panelCadastrarCliente;
	protected static JPanel		panelPesquisarVenda;
	protected static JPanel		panelDelivery;
	protected static JPanel		panelPainelVendas;
	protected static JPanel		panelGerencMesas;

	private JTextField			numeroVenda;
	private JTextField			data1;
	private JTextField			vendedor;
	private JFormattedTextField	cpf1;
	private JFormattedTextField	telefone;
	private JTextField			numeroCheque;
	private JTextField			agencia;
	private JTextField			numeroConta;
	private JComboBox<String>	banco;
	private JTextField			contitem;
	private JTextField			valorFinal;
	private JTextField			desconto;
	private JTextField			troco1;
	private JTextField			valorTotal;
	private JTextField			valorPago;
	private JTextField			ultimoPedido;
	private JTextField			valorParcelado;
	private static JTextField	caminho;
	private JComboBox<String>	comboRemoveItem;
	private JComboBox<String>	comboFormaPagamento;
	private JComboBox<String>	comboProduto;
	private JComboBox<String>	comboNome;
	private JComboBox<String>	comboVezes;
	protected JLabel			carsalicon;
	protected JLabel			cel;
	protected JLabel			dnasc;
	protected JLabel			Rg;
	protected JLabel			Cpf;
	protected JLabel			Pess;
	protected JLabel			Ender;
	protected JLabel			Nom;
	protected JLabel			NumF;
	protected JLabel			User;
	protected JLabel			ec;
	protected JLabel			email;
	protected JLabel			cid;
	protected JLabel			num;
	protected JLabel			tel;
	protected JLabel			comp;
	protected JLabel			bairro;
	protected JLabel			uf;
	protected JLabel			cep;
	protected JLabel			sqlcon;
	protected JLabel			cubo;
	protected JLabel			Fundo;
	protected JLabel			logr;
	protected JLabel			dep_1;
	protected JLabel			logo1;
	protected JLabel			lblNomeDoPai;
	protected JLabel			lblNomeDoMe;
	protected JLabel			lblTelefone;
	protected JLabel			lblCel;
	protected static JLabel		labelFundoPainelMesas;
	protected JLabel			labelValorFinal;
	protected JLabel			labelFotoProduto;
	protected JLabel			labelDesconto;
	protected JLabel			labelTroco;
	protected JLabel			labelNumeroVenda;
	protected JLabel			labelData;
	protected JLabel			labelVendedor;
	protected JLabel			lblselecioneAOpo;
	protected JLabel			labelTelefone;
	protected JLabel			labelBanco;
	protected JLabel			labelNumeroCheque;
	protected JLabel			labelSelecioneCartao;
	protected JLabel			labelDadosCheque;
	protected JLabel			labelAgencia;
	protected JLabel			labelNumeroConta;
	protected JLabel			label_4;
	protected JLabel			labelQuantidade;
	protected JLabel			labelProduto;
	protected JLabel			labelMesaX;
	protected JLabel			labelAnimacao;
	private JButton			btAdicionarItem;
	private JButton			btRemoverItem;
	private JButton			btCancelar;
	private JButton			btFecharMesa;
	private JButton			btRemoverItem_1;
	private JButton			btRecalcularTroco;
	private JButton			btOcultarPainel;
	private JRadioButton		radioVisa;
	private JRadioButton		radioAmerican;
	private JRadioButton		radioMaster;
	private JRadioButton		radioVista;
	private JRadioButton		radioPrazo;
	private static String		cpf				= null;
	private String				codProd, str;
	private static String		form;
	static DefaultTableCellRenderer central = new DefaultTableCellRenderer();
	@SuppressWarnings("unused")
	private static String		vlInicial			= "0.0";
	private int				opc				= 0;
	private int				par;
	private int				contLinha			= 0;
	private int				M;
	private double				vlTotal1;
	private double				valorT;
	private double				parcela;
	private double				troco;
	private double				precoUnitario;
	private double				ValorF;
	protected static NumberFormat	nf;
	protected SimpleDateFormat	formato;
	protected SimpleDateFormat	formato2;
	private static JTable		Tabela_itens;
	private JInternalFrame		internalFrameRemove;
	private JMenuItem			menuDefinirPapelParede;
	private JMenuItem			menuAbrirBatePapo;
	private JMenuItem			menuSair;
	private JButton			btCancelarVenda;
	private JLabel				labelNome;
	private JLabel				labelQuantidade_1;
	private JLabel				labelCpf;
	private JLabel				labelValorPago;
	private JLabel				labelValorTotal;
	private JLabel				labelValorParcelado;
	private JLabel				labelUltimoPedido;
	private JButton btnCancelar;
	private JMenuBar menuBar_1;
	private JSeparator separator;
	static ResultSet dados;

	@SuppressWarnings("serial")
	protected PainelMesas() {
		super();
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();              
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				PainelMesas.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setName("vendas");
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		setTitle("VENDAS");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
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

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		menuBar = new JMenuBar();
		getContentPane().add(menuBar);
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setForeground(new Color(0, 0, 0));
		menuArquivo = new JMenu("Arquivo");
		menuArquivo.setFocusTraversalPolicyProvider(true);
		menuArquivo.setFocusPainted(true);
		menuArquivo.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
		menuArquivo.setForeground(new Color(0, 0, 0));
		menuArquivo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuArquivo);

		menuSair = new JMenuItem("Sair");
		menuSair.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuSair.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/desliga24px.png")));
		menuArquivo.add(menuSair);
		menuBar.setBounds(0, 0, 1356, 32);

		menuConfiguracao = new JMenu("Configurações");
		menuConfiguracao.setFocusTraversalPolicyProvider(true);
		menuConfiguracao.setFocusPainted(true);
		menuConfiguracao.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
		menuConfiguracao.setForeground(new Color(0, 0, 0));
		menuConfiguracao.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuBar.add(menuConfiguracao);

		menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
		menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuDefinirPapelParede.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606663_image-128.png")));
		menuDefinirPapelParede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelMesas.SelecionarPapelParedePainelMesas();
			}
		});
		menuConfiguracao.add(menuDefinirPapelParede);

		menuAbrirBatePapo = new JMenuItem("Abrir Bate-Papo");
		menuAbrirBatePapo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		menuAbrirBatePapo.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
		menuAbrirBatePapo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChatController.main(null);
			}
		});
		menuConfiguracao.add(menuAbrirBatePapo);

		menuAjuda = new JMenu("Ajuda");
		menuAjuda.setFocusTraversalPolicyProvider(true);
		menuAjuda.setFocusPainted(true);
		menuAjuda.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
		menuAjuda.setForeground(new Color(0, 0, 0));
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
		menuAbrirAjuda.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
		menuAjuda.add(menuAbrirAjuda);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		tabbedPaneVendas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneVendas.setFont(new Font("Kalinga", Font.PLAIN, 13));
		tabbedPaneVendas.setBounds(0, 33, 1356, 696);
		getContentPane().add(tabbedPaneVendas);

		/*
		 * 
		 * Panel Vendas
		 */

		panelPainelVendas = new JPanel();
		panelPainelVendas.setBackground(SystemColor.inactiveCaptionBorder);
		panelPainelVendas.setLayout(null);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboProduto = new JComboBox<String>();
		comboProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboProduto.setBounds(24, 246, 323, 32);
		String sql = "select * from produtos order by nome";
		ResultSet rs = x.Consultar(sql);
		try {
			comboProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			if (Inicio.rd == 0) {
				comboProduto.addItem("");
				while (rs.next()) {
					comboProduto.addItem(rs.getString("nome" + "" + ""));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		internalFrameRemove = new JInternalFrame("Remove Item");
		internalFrameRemove.setFrameIcon(new ImageIcon(PainelMesas.class
				.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		try {
			internalFrameRemove.setIcon(true);
		} catch (PropertyVetoException e1) {
			e1.printStackTrace();
		}
		internalFrameRemove.setClosable(true);
		internalFrameRemove.setBounds(495, 238, 360, 181);
		panelPainelVendas.add(internalFrameRemove);
		internalFrameRemove.getContentPane().setLayout(null);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboRemoveItem = new JComboBox<String>();
		comboRemoveItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboRemoveItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		comboRemoveItem.setBounds(13, 16, 317, 32);
		internalFrameRemove.getContentPane().add(comboRemoveItem);
		comboRemoveItem.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Quantidade2.requestFocus();
				Object item2 = evt.getItem();
				try {
					String sql = "select * from produtos where nome = '" + item2.toString() + "'";
					ResultSet rs1 = x.Consultar(sql);
					while (rs1.next()) {
						ImageIcon imagem = new ImageIcon(rs1.getString("imagem").replace("~", "\\"));
						Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
						labelFotoProduto.setIcon(new javax.swing.ImageIcon(img));
						labelFotoProduto.setText("");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		btCancelar = new JButton("Cancelar");
		btCancelar.setToolTipText("alt + Backspace");
		btCancelar.setMnemonic(KeyEvent.VK_BACK_SPACE);
		btCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Quantidade2.setValue(1);
				internalFrameRemove.setVisible(false);
			}
		});

		Quantidade2 = new JSpinner();
		Quantidade2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Quantidade2.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(5)));
		Quantidade2.setBounds(176, 60, 70, 32);
		internalFrameRemove.getContentPane().add(Quantidade2);
		btCancelar.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		btCancelar.setBounds(194, 105, 140, 35);
		internalFrameRemove.getContentPane().add(btCancelar);
		internalFrameRemove.setVisible(true);
		internalFrameRemove.setVisible(false);
		// remL.setVisible(false);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		btRemoverItem_1 = new JButton("Remover");
		btRemoverItem_1.setToolTipText("alt + Delete");
		btRemoverItem_1.setMnemonic(KeyEvent.VK_DELETE);
		btRemoverItem_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btRemoverItem_1.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/Gnome-edit-clear.png")));
		btRemoverItem_1.setBounds(10, 105, 140, 35);
		btRemoverItem_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				PainelMesas.this.RemoverItem();
			}
		});
		internalFrameRemove.getContentPane().add(btRemoverItem_1);

		labelQuantidade = new JLabel("Quantidade");
		labelQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		labelQuantidade.setForeground(new Color(0, 0, 0));
		labelQuantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelQuantidade.setBounds(67, 60, 99, 32);
		internalFrameRemove.getContentPane().add(labelQuantidade);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        
        central.setHorizontalAlignment(SwingConstants.CENTER);
		Tabela_itens = new JTable();
		Tabela_itens.setForeground(Color.BLACK);
		Tabela_itens.setBackground(new Color(248, 248, 255));
		Tabela_itens.setShowHorizontalLines(true);
		Tabela_itens.setShowVerticalLines(true);
		Tabela_itens.setRowMargin(1);
		Tabela_itens.setCellSelectionEnabled(true);
		Tabela_itens.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		Tabela_itens.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ITEM", "COD. ITEM", "DESCRI\u00C7\u00C3O", "QUANTIDADE", "PRE\u00C7O UNIT\u00C1RIO", "TOTAL"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tabela_itens.getColumnModel().getColumn(0).setPreferredWidth(25);
		Tabela_itens.getColumnModel().getColumn(1).setPreferredWidth(50);
		Tabela_itens.getColumnModel().getColumn(2).setPreferredWidth(330);
		Tabela_itens.getColumnModel().getColumn(3).setPreferredWidth(76);
		Tabela_itens.getColumnModel().getColumn(4).setPreferredWidth(90);
		Tabela_itens.getColumnModel().getColumn(0).setCellRenderer(central);
		Tabela_itens.getColumnModel().getColumn(1).setCellRenderer(central);
		Tabela_itens.getColumnModel().getColumn(2).setCellRenderer(central);
		Tabela_itens.getColumnModel().getColumn(3).setCellRenderer(central);
		Tabela_itens.getColumnModel().getColumn(4).setCellRenderer(central);
		Tabela_itens.getColumnModel().getColumn(5).setCellRenderer(central);
		
		Tabela_itens.setRowHeight(24);
		Tabela_itens.setAutoCreateRowSorter(true);
		Tabela_itens.setFont(new Font("Kalinga", Font.PLAIN, 15));
		Tabela_itens.setColumnSelectionAllowed(true);
		modelo = (DefaultTableModel) Tabela_itens.getModel();

		numeroVenda = new JTextField();
		numeroVenda.setSelectionColor(SystemColor.scrollbar);
		numeroVenda.setDisabledTextColor(Color.BLACK);
		numeroVenda.setEnabled(false);
		numeroVenda.setEditable(false);
		numeroVenda.setHorizontalAlignment(SwingConstants.CENTER);
		numeroVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		numeroVenda.setColumns(10);
		numeroVenda.setBounds(24, 84, 97, 32);
		panelPainelVendas.add(numeroVenda);

		formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();

		formato2 = new SimpleDateFormat("hh:mm:ss");
		Date data2 = new Date();

		data1 = new JTextField();
		data1.setSelectionColor(SystemColor.scrollbar);
		data1.setDisabledTextColor(Color.BLACK);
		data1.setEnabled(false);
		data1.setHorizontalAlignment(SwingConstants.CENTER);
		data1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		data1.setEditable(false);
		data1.setColumns(10);
		data1.setBounds(133, 84, 88, 32);
		data1.setText(formato.format(data));
		panelPainelVendas.add(data1);

		ultimoPedido = new JTextField();
		ultimoPedido.setSelectionColor(SystemColor.scrollbar);
		ultimoPedido.setText(formato2.format(data2));
		ultimoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		ultimoPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
		ultimoPedido.setEnabled(false);
		ultimoPedido.setEditable(false);
		ultimoPedido.setDisabledTextColor(Color.BLACK);
		ultimoPedido.setColumns(10);
		ultimoPedido.setBounds(232, 84, 80, 32);
		panelPainelVendas.add(ultimoPedido);

		vendedor = new JTextField("teste");
		vendedor.setSelectionColor(SystemColor.scrollbar);
		vendedor.setDisabledTextColor(Color.BLACK);
		vendedor.setHorizontalAlignment(SwingConstants.CENTER);
		vendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		vendedor.setEnabled(false);
		vendedor.setEditable(false);
		vendedor.setColumns(10);
		vendedor.setBounds(334, 84, 353, 32);
		panelPainelVendas.add(vendedor);
		vendedor.setText(Login.User);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboNome = new JComboBox<String>();
		comboNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
		comboNome.setBounds(24, 144, 382, 32);
		panelPainelVendas.add(comboNome);

		comboNome.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Object item = evt.getItem();
				cpf = item.toString();
				try {
					String sql = "select * from clientes where nome = '" + cpf + "'";
					ResultSet rs1 = x.Consultar(sql);
					while (rs1.next()) {
						cpf1.setText(rs1.getString("cpf"));
						telefone.setText(rs1.getString("telefone1"));
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		cpf1 = new JFormattedTextField("");
		cpf1.setSelectionColor(SystemColor.scrollbar);
		try {
			cpf1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		cpf1.setHorizontalAlignment(SwingConstants.CENTER);
		cpf1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		cpf1.setColumns(10);
		cpf1.setBounds(416, 144, 124, 32);
		panelPainelVendas.add(cpf1);

		telefone = new JFormattedTextField("");
		telefone.setSelectionColor(SystemColor.scrollbar);
		try {
			telefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		telefone.setHorizontalAlignment(SwingConstants.CENTER);
		telefone.setFont(new Font("Kalinga", Font.PLAIN, 14));
		telefone.setColumns(10);
		telefone.setBounds(550, 144, 124, 32);
		panelPainelVendas.add(telefone);
		panelPainelVendas.add(comboProduto);

		
		quantidade = new JSpinner();
		quantidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		quantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
		quantidade.setModel(new SpinnerNumberModel(1, 1, 200, 1));
		quantidade.setBounds(371, 246, 70, 32);
		panelPainelVendas.add(quantidade);

		scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setFont(new Font("Kalinga", Font.PLAIN, 14));
		scrollPaneTabela.setAutoscrolls(true);
		scrollPaneTabela.setBounds(24, 377, 794, 247);
		panelPainelVendas.add(scrollPaneTabela);
		// scrollPane.setVisible(false);
		scrollPaneTabela.setViewportView(Tabela_itens);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboProduto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Object item = evt.getItem();

				try {
					String sql = "select * from produtos where nome = '" + item.toString() + "'";
					ResultSet rs1 = x.Consultar(sql);
					while (rs1.next()) {
						precoUnitario = Double.parseDouble(rs1.getString("precoVenda").replace(",", "."));
						codProd = (rs1.getString("codigoProduto"));
						ImageIcon imagem = new ImageIcon(rs1.getString("imagem").replace("~", "\\"));
						Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
						labelFotoProduto.setIcon(new javax.swing.ImageIcon(img));
						labelFotoProduto.setText("");
						str = comboProduto.getSelectedItem().toString() + "          R$ "+ rs1.getString("precoVenda") + "          ";
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		String sql5 = "select * from clientes order by nome";
		ResultSet rs5 = x.Consultar(sql5);
		try {
			if (Inicio.rd == 0) {
				comboNome.addItem("");
				while (rs5.next()) {
					comboNome.addItem(rs5.getString("nome"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboFormaPagamento = new JComboBox<String>();
		comboFormaPagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboFormaPagamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
		comboFormaPagamento.setBounds(909, 103, 184, 32);
		panelPainelVendas.add(comboFormaPagamento);
		if (Inicio.rd == 0) {
			comboFormaPagamento.addItem("Dinheiro");
			comboFormaPagamento.addItem("Cheque");
			comboFormaPagamento.addItem("Cartão de Crédito");
		}

		comboFormaPagamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				Object item = evt.getItem();
				form = item.toString();
				PainelMesas.this.FormaPagamento();
			}
		});

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		comboVezes = new JComboBox<String>();
		comboVezes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboVezes.setFont(new Font("Kalinga", Font.PLAIN, 14));
		comboVezes.setBounds(1148, 103, 99, 32);
		panelPainelVendas.add(comboVezes);
		comboVezes.setVisible(false);

		if (Inicio.rd == 0) {
			comboVezes.addItem("1x");
			comboVezes.addItem("2x");
			comboVezes.addItem("3x");
			comboVezes.addItem("4x");
			comboVezes.addItem("5x");
			comboVezes.addItem("6x");
			comboVezes.addItem("7x");
			comboVezes.addItem("8x");
			comboVezes.addItem("9x");
			comboVezes.addItem("10x");
			comboVezes.addItem("11x");
			comboVezes.addItem("12x");
		}

		comboVezes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				PainelMesas.this.CalcularParcela();
				PainelMesas.this.CalcularParcelamento();
				PainelMesas.this.CalcularTroco();
			}
		});
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			if (Inicio.rd == 0) {
				while (rs3.next()) {
					numeroVenda.setText(rs3.getString("numeroVenda"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		// Tabela
		PainelMesas.this.TabelaVendas();
		
		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		agencia = new JTextField();
		agencia.setSelectionColor(SystemColor.scrollbar);
		agencia.setVisible(false);

		banco = new JComboBox<String>();
		banco.setVisible(false);
		banco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		banco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		banco.setBounds(1036, 174, 124, 32);
		banco.addItem("");
		banco.addItem("Banco do Brasil");
		banco.addItem("Bradesco");
		banco.addItem("Caixa Economica");
		banco.addItem("HSBC");
		banco.addItem("Itaú");
		banco.addItem("Santander");
		banco.addItem("Bancoob");
		banco.addItem("Banestes");
		banco.addItem("Banpara");
		banco.addItem("Banrisul");
		banco.addItem("BCN");
		banco.addItem("Bank Boston");
		banco.addItem("Banco Brasilia");
		banco.addItem("Banco do Nordeste");
		banco.addItem("Citibank");
		banco.addItem("Credisan");
		banco.addItem("Nossa Caixa");
		banco.addItem("Mercantil do Brasil");
		banco.addItem("Real");
		banco.addItem("Safra");
		banco.addItem("Sicredi");
		banco.addItem("Sudameris");
		banco.addItem("Unibanco");
		banco.addItem("Viacredi");
		banco.addItem("Sicoob");
		banco.addItem("Outro Banco...");
		panelPainelVendas.add(banco);

		numeroCheque = new JTextField();
		numeroCheque.setSelectionColor(SystemColor.scrollbar);
		numeroCheque.setVisible(false);

		numeroCheque.setHorizontalAlignment(SwingConstants.CENTER);
		numeroCheque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numeroCheque.setColumns(10);
		numeroCheque.setBounds(1036, 217, 124, 32);
		panelPainelVendas.add(numeroCheque);
		agencia.setHorizontalAlignment(SwingConstants.CENTER);
		agencia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agencia.setColumns(10);
		agencia.setBounds(1036, 260, 124, 32);
		panelPainelVendas.add(agencia);

		numeroConta = new JTextField();
		numeroConta.setSelectionColor(SystemColor.scrollbar);
		numeroConta.setVisible(false);
		numeroConta.setHorizontalAlignment(SwingConstants.CENTER);
		numeroConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numeroConta.setColumns(10);
		numeroConta.setBounds(1036, 303, 124, 32);
		panelPainelVendas.add(numeroConta);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");

		btAdicionarItem = new JButton("Adicionar");
		btAdicionarItem.setToolTipText("alt + Insert");
		btAdicionarItem.setMnemonic(KeyEvent.VK_INSERT);
		btAdicionarItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btAdicionarItem.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
		btAdicionarItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				PainelMesas.this.AddItem();
			}
		});

		valorTotal = new JTextField();
		valorTotal.setSelectionColor(SystemColor.scrollbar);
		valorTotal.setForeground(new Color(0, 0, 0));
		valorTotal.setEditable(false);
		valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotal.setFont(new Font("Kalinga", Font.BOLD, 18));
		valorTotal.setColumns(10);
		valorTotal.setBounds(867, 442, 150, 32);
		valorTotal.setText("0,00");
		panelPainelVendas.add(valorTotal);

		desconto = new JTextField();
		desconto.setSelectionColor(SystemColor.scrollbar);
		desconto.setForeground(new Color(0, 0, 0));
		desconto.setHorizontalAlignment(SwingConstants.CENTER);
		desconto.setFont(new Font("Kalinga", Font.BOLD, 18));
		desconto.setColumns(10);
		desconto.setBounds(867, 517, 150, 32);
		desconto.setText("0,00");
		panelPainelVendas.add(desconto);

		valorFinal = new JTextField();
		valorFinal.setSelectionColor(SystemColor.scrollbar);
		valorFinal.setForeground(new Color(0, 0, 0));
		valorFinal.setEditable(false);
		valorFinal.setHorizontalAlignment(SwingConstants.CENTER);
		valorFinal.setFont(new Font("Kalinga", Font.BOLD, 18));
		valorFinal.setColumns(10);
		valorFinal.setBounds(1173, 592, 150, 32);
		valorFinal.setText("0,00");
		panelPainelVendas.add(valorFinal);

		valorParcelado = new JTextField();
		valorParcelado.setEditable(false);
		valorParcelado.setSelectionColor(SystemColor.scrollbar);
		valorParcelado.setForeground(new Color(0, 0, 0));
		valorParcelado.setText("0,00");
		valorParcelado.setHorizontalAlignment(SwingConstants.CENTER);
		valorParcelado.setFont(new Font("Kalinga", Font.BOLD, 18));
		valorParcelado.setColumns(10);
		valorParcelado.setBounds(867, 592, 150, 32);
		panelPainelVendas.add(valorParcelado);

		valorPago = new JTextField();
		valorPago.setSelectionColor(SystemColor.scrollbar);
		valorPago.setForeground(new Color(0, 0, 0));
		valorPago.setHorizontalAlignment(SwingConstants.CENTER);
		valorPago.setFont(new Font("Kalinga", Font.BOLD, 18));
		valorPago.setColumns(10);
		valorPago.setBounds(1173, 442, 150, 32);
		valorPago.setText("0,00");
		panelPainelVendas.add(valorPago);

		troco1 = new JTextField();
		troco1.setSelectionColor(SystemColor.scrollbar);
		troco1.setForeground(new Color(0, 0, 0));
		troco1.setEditable(false);
		troco1.setHorizontalAlignment(SwingConstants.CENTER);
		troco1.setFont(new Font("Kalinga", Font.BOLD, 18));
		troco1.setColumns(10);
		troco1.setText("0,00");
		troco1.setBounds(1173, 517, 150, 32);

		panelPainelVendas.add(troco1);

		radioVista = new JRadioButton("À Vista");
		radioVista.setForeground(SystemColor.textText);
		radioVista.setHorizontalAlignment(SwingConstants.CENTER);
		radioVista.setFont(new Font("Kalinga", Font.PLAIN, 14));
		radioVista.setOpaque(false);
		radioVista.setBounds(993, 69, 80, 32);
		panelPainelVendas.add(radioVista);
		radioVista.setSelected(true);

		radioVista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opc = 0;
				if (opc == 0) {
					comboVezes.setSelectedItem("1x");
					comboVezes.setVisible(false);
					radioPrazo.setSelected(false);
					radioVista.setSelected(true);
					valorParcelado.setText("1x" + " " + valorFinal.getText());
				}
			}
		});

		radioPrazo = new JRadioButton("À Prazo");
		radioPrazo.setForeground(SystemColor.textText);
		radioPrazo.setHorizontalAlignment(SwingConstants.CENTER);
		radioPrazo.setFont(new Font("Kalinga", Font.PLAIN, 14));
		radioPrazo.setOpaque(false);
		radioPrazo.setBounds(1082, 69, 87, 32);
		panelPainelVendas.add(radioPrazo);

		radioPrazo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opc = 1;
				if (opc == 1) {
					comboVezes.setVisible(true);
					radioVista.setSelected(false);
					radioPrazo.setSelected(true);
					valorParcelado.setText(comboVezes.getSelectedItem().toString() + " " + valorFinal.getText());
				}
			}
		});

		radioVisa = new JRadioButton("Visa");
		radioVisa.setIcon(null);
		radioVisa.setOpaque(false);
		radioVisa.setFont(new Font("Kalinga", Font.PLAIN, 14));
		radioVisa.setForeground(SystemColor.textText);
		radioVisa.setVisible(false);

		radioMaster = new JRadioButton("Master");
		radioMaster.setIcon(null);
		radioMaster.setForeground(SystemColor.textText);
		radioMaster.setOpaque(false);
		radioMaster.setFont(new Font("Kalinga", Font.PLAIN, 14));
		radioMaster.setVisible(false);
		radioMaster.setBounds(1049, 184, 98, 32);
		panelPainelVendas.add(radioMaster);
		radioVisa.setBounds(1055, 222, 87, 32);
		panelPainelVendas.add(radioVisa);

		radioAmerican = new JRadioButton("American");
		radioAmerican.setIcon(null);
		radioAmerican.setOpaque(false);
		radioAmerican.setFont(new Font("Kalinga", Font.PLAIN, 14));
		radioAmerican.setForeground(SystemColor.textText);
		radioAmerican.setVisible(false);
		radioAmerican.setBounds(1049, 260, 99, 32);
		panelPainelVendas.add(radioAmerican);
		
		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		
		menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(450, 0, 451, 32);
		panelPainelVendas.add(menuBar_1);
		
				btFecharMesa = new JButton("Finalizar");
				menuBar_1.add(btFecharMesa);
				btFecharMesa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btFecharMesa.setToolTipText("alt + Enter");
				btFecharMesa.setMnemonic(KeyEvent.VK_ENTER);
				btFecharMesa.setFont(new Font("Kalinga", Font.PLAIN, 14));
				btFecharMesa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(Inicio.caixa.equals("fechado")){
							JOptionPane.showMessageDialog(null,"É necessário efetuar a abertura do caixa !","Atenção", JOptionPane.WARNING_MESSAGE);
							new Caixa();
						}
						else{
						PainelMesas.this.FecharMesa();
						PainelMesas.this.dispose();
						}
					}
				});
				btFecharMesa.setIcon(new ImageIcon(PainelMesas.class
						.getResource("/icones1_24px/1425606546_678134-sign-check-128.png")));
				
				btnCancelar = new JButton("Cancelar");
				menuBar_1.add(btnCancelar);
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
						System.out.println(Inicio.mesasAbertas);
						PainelMesas.this.CancelarVenda();
						PainelMesas.this.SetarValor2();
						PainelMesas.this.dispose();
					}
				});
				btnCancelar.setToolTipText("alt + Delete");
				btnCancelar.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
				btnCancelar.setMnemonic(KeyEvent.VK_DELETE);
				btnCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
				btnCancelar.setAlignmentX(0.5f);
				
						btCancelarVenda = new JButton("Limpar");
						menuBar_1.add(btCancelarVenda);
						btCancelarVenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btCancelarVenda.setToolTipText("alt + Backspace");
						btCancelarVenda.setMnemonic(KeyEvent.VK_BACK_SPACE);
						btCancelarVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
						btCancelarVenda.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								PainelMesas.this.CancelarVenda();

							}
						});
						btCancelarVenda.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/Gnome-edit-clear.png")));
						btOcultarPainel = new JButton("Ocultar");
						menuBar_1.add(btOcultarPainel);
						btOcultarPainel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btOcultarPainel.setToolTipText("alt + End");
						btOcultarPainel.setMnemonic(KeyEvent.VK_END);
						btOcultarPainel.setIcon(new ImageIcon(PainelMesas.class
								.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
						btOcultarPainel.setAlignmentX(Component.CENTER_ALIGNMENT);
						btOcultarPainel.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								PainelMesas.this.SetarValor();
								PainelMesas.this.ocultarMesa();
								PainelMesas.this.dispose();
							}
						});
						btOcultarPainel.setForeground(new Color(0, 0, 0));
						btOcultarPainel.setFont(new Font("Kalinga", Font.PLAIN, 14));
						btOcultarPainel.setBackground(UIManager.getColor("Button.background"));
		btAdicionarItem.setBounds(481, 205, 140, 35);
		panelPainelVendas.add(btAdicionarItem);
		// addL.setVisible(false);

		btRemoverItem = new JButton("Remover");
		btRemoverItem.setToolTipText("alt + Delete");
		btRemoverItem.setMnemonic(KeyEvent.VK_DELETE);
		btRemoverItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btRemoverItem.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		btRemoverItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				comboRemoveItem.removeAllItems();
				comboRemoveItem.addItem("");
				for (int i = 0; i < contLinha; i++) {
					comboRemoveItem.addItem((String) modelo.getValueAt(i, 2));
				}
				internalFrameRemove.setVisible(true);
			}
		});
		btRemoverItem.setBounds(481, 248, 140, 35);
		panelPainelVendas.add(btRemoverItem);

		labelNome = new JLabel("Nome");
		labelNome.setForeground(new Color(0, 0, 0));
		labelNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelNome.setBounds(24, 111, 49, 32);
		panelPainelVendas.add(labelNome);

		labelQuantidade_1 = new JLabel("Quantidade");
		labelQuantidade_1.setForeground(new Color(0, 0, 0));
		labelQuantidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelQuantidade_1.setBounds(371, 215, 99, 32);
		panelPainelVendas.add(labelQuantidade_1);

		labelValorFinal = new JLabel("Valor Final");
		labelValorFinal.setForeground(new Color(0, 0, 0));
		labelValorFinal.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606730_678082-tag-128.png")));
		labelValorFinal.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelValorFinal.setBounds(1173, 560, 150, 32);
		panelPainelVendas.add(labelValorFinal);

		labelDesconto = new JLabel("Desconto");
		labelDesconto.setForeground(new Color(0, 0, 0));
		labelDesconto.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/1425606555_star-128.png")));
		labelDesconto.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelDesconto.setBounds(867, 485, 120, 32);
		panelPainelVendas.add(labelDesconto);

		labelTroco = new JLabel("Troco");
		labelTroco.setForeground(new Color(0, 0, 0));
		labelTroco.setIcon(new ImageIcon(PainelMesas.class.getResource("/icones1_24px/1425606619_notepad-128.png")));
		labelTroco.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelTroco.setBounds(1173, 485, 120, 32);
		panelPainelVendas.add(labelTroco);

		labelNumeroVenda = new JLabel("Nº da Venda");
		labelNumeroVenda.setForeground(new Color(0, 0, 0));
		labelNumeroVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelNumeroVenda.setBounds(24, 52, 99, 32);
		panelPainelVendas.add(labelNumeroVenda);

		labelData = new JLabel("Data");
		labelData.setForeground(new Color(0, 0, 0));
		labelData.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelData.setBounds(133, 52, 64, 32);
		panelPainelVendas.add(labelData);

		labelVendedor = new JLabel("Vendedor");
		labelVendedor.setForeground(new Color(0, 0, 0));
		labelVendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelVendedor.setBounds(334, 52, 87, 32);
		panelPainelVendas.add(labelVendedor);

		labelCpf = new JLabel("CPF");
		labelCpf.setForeground(new Color(0, 0, 0));
		labelCpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelCpf.setBounds(416, 111, 39, 32);
		panelPainelVendas.add(labelCpf);

		labelValorPago = new JLabel("Valor Pago");
		labelValorPago.setForeground(new Color(0, 0, 0));
		labelValorPago.setBorder(null);
		labelValorPago.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606602_678131-money-128.png")));
		labelValorPago.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelValorPago.setBounds(1173, 410, 120, 32);
		panelPainelVendas.add(labelValorPago);

		labelValorTotal = new JLabel("Valor Total");
		labelValorTotal.setForeground(new Color(0, 0, 0));
		labelValorTotal.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606602_678131-money-128.png")));
		labelValorTotal.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelValorTotal.setBounds(867, 410, 150, 32);
		panelPainelVendas.add(labelValorTotal);

		labelValorParcelado = new JLabel("Valor Parcelado");
		labelValorParcelado.setForeground(new Color(0, 0, 0));
		labelValorParcelado.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_24px/1425606770_file-excel-alt-128.png")));
		labelValorParcelado.setFont(new Font("Kalinga", Font.BOLD, 16));
		labelValorParcelado.setBounds(867, 560, 160, 32);
		panelPainelVendas.add(labelValorParcelado);

		labelSelecioneCartao = new JLabel("Selecione o Cartão");
		labelSelecioneCartao.setHorizontalAlignment(SwingConstants.CENTER);
		labelSelecioneCartao.setForeground(new Color(0, 0, 0));
		labelSelecioneCartao.setVisible(false);
		labelSelecioneCartao.setFont(new Font("Khmer UI", Font.BOLD, 14));
		labelSelecioneCartao.setBounds(1006, 132, 184, 32);
		panelPainelVendas.add(labelSelecioneCartao);

		labelDadosCheque = new JLabel("Dados do Cheque");
		labelDadosCheque.setHorizontalAlignment(SwingConstants.CENTER);
		labelDadosCheque.setForeground(new Color(0, 0, 0));
		labelDadosCheque.setVisible(false);
		labelDadosCheque.setFont(new Font("Khmer UI", Font.BOLD, 14));
		labelDadosCheque.setBounds(1020, 132, 157, 32);
		panelPainelVendas.add(labelDadosCheque);

		labelAgencia = new JLabel("Agência");
		labelAgencia.setForeground(new Color(0, 0, 0));
		labelAgencia.setVisible(false);
		labelAgencia.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelAgencia.setBounds(1070, 260, 56, 32);
		panelPainelVendas.add(labelAgencia);

		labelNumeroConta = new JLabel("Nº Conta");
		labelNumeroConta.setVisible(false);
		labelNumeroConta.setForeground(new Color(0, 0, 0));
		labelNumeroConta.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelNumeroConta.setBounds(1066, 303, 64, 32);
		panelPainelVendas.add(labelNumeroConta);

		labelTelefone = new JLabel("Telefone");
		labelTelefone.setForeground(new Color(0, 0, 0));
		labelTelefone.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelTelefone.setBounds(550, 111, 81, 32);
		panelPainelVendas.add(labelTelefone);

		labelBanco = new JLabel("Banco");
		labelBanco.setForeground(new Color(0, 0, 0));
		labelBanco.setVisible(false);
		labelBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelBanco.setBounds(1070, 174, 56, 32);
		panelPainelVendas.add(labelBanco);

		labelNumeroCheque = new JLabel("Nº Cheque");
		labelNumeroCheque.setVisible(false);
		labelNumeroCheque.setForeground(new Color(0, 0, 0));
		labelNumeroCheque.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelNumeroCheque.setBounds(1058, 217, 80, 32);
		panelPainelVendas.add(labelNumeroCheque);

		labelFotoProduto = new JLabel("(165x115)");
		labelFotoProduto.setForeground(new Color(0, 0, 0));
		labelFotoProduto.setIcon(new ImageIcon(PainelMesas.class
				.getResource("/icones1_48px/1425606663_image-128.png")));
		labelFotoProduto.setOpaque(true);
		labelFotoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		labelFotoProduto.setBorder(new LineBorder(Color.LIGHT_GRAY));
		labelFotoProduto.setBackground(Color.WHITE);
		labelFotoProduto.setBounds(645, 183, 145, 95);
		panelPainelVendas.add(labelFotoProduto);

		labelProduto = new JLabel("Produto");
		labelProduto.setForeground(new Color(0, 0, 0));
		labelProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelProduto.setBounds(24, 215, 70, 32);
		panelPainelVendas.add(labelProduto);

		labelUltimoPedido = new JLabel("Ultimo Pedido");
		labelUltimoPedido.setForeground(new Color(0, 0, 0));
		labelUltimoPedido.setFont(new Font("Kalinga", Font.PLAIN, 14));
		labelUltimoPedido.setBounds(223, 52, 99, 32);
		panelPainelVendas.add(labelUltimoPedido);

		McWinLookAndFeel.setCurrentTheme(props);
        UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		labelAnimacao = new JLabel("");
		labelAnimacao.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		labelAnimacao.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnimacao.setForeground(new Color(0, 0, 0));
		labelAnimacao.setFont(new Font("Agency FB", Font.ITALIC, 38));
		labelAnimacao.setBounds(24, 298, 794, 60);
		panelPainelVendas.add(labelAnimacao);

		str = "                   Bem vindo ao S-One !!!                   ";

		PainelMesas.this.Animacao();

		labelMesaX = new JLabel("MESA X");
		labelMesaX.setHorizontalAlignment(SwingConstants.CENTER);
		labelMesaX.setForeground(new Color(0, 0, 0));
		labelMesaX.setFont(new Font("Khmer UI", Font.BOLD, 15));
		labelMesaX.setBounds(618, 41, 115, 32);
		panelPainelVendas.add(labelMesaX);
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "DADOS DA VENDA", TitledBorder.LEFT, TitledBorder.TOP, null, Color.DARK_GRAY));
		label.setBounds(10, 31, 830, 615);
		panelPainelVendas.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "FORMA DE PAGAMENTO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		label_1.setBounds(852, 31, 492, 327);
		panelPainelVendas.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		label_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "PAGAMENTO", TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		label_2.setBounds(852, 369, 492, 277);
		panelPainelVendas.add(label_2);
		
		separator = new JSeparator();
		separator.setBounds(24, 197, 597, 2);
		panelPainelVendas.add(separator);

		labelFundoPainelMesas = new JLabel("");
		labelFundoPainelMesas.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoPainelMesas.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoPainelMesas.setIcon(new ImageIcon(PainelMesas.class.getResource("/papel_parede/blank.png")));
		labelFundoPainelMesas.setBounds(0, 0, 1359, 661);
		panelPainelVendas.add(labelFundoPainelMesas);

		/*
		 * panels com ícones
		 */

		tabbedPaneVendas.addTab("Painel de Vendas ",
				new ImageIcon(PainelMesas.class.getResource("/icones1_24px/1425606608_pencil-128.png")),
				panelPainelVendas, null);

		contitem = new JTextField();
		contitem.setEditable(false);
		contitem.setBounds(811, 618, 29, 28);
		panelPainelVendas.add(contitem);
		contitem.setColumns(10);
		contitem.setText("0");
		
				btRecalcularTroco = new JButton("Recalcular");
				btRecalcularTroco.setBounds(1027, 444, 129, 30);
				panelPainelVendas.add(btRecalcularTroco);
				btRecalcularTroco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btRecalcularTroco.setToolTipText("alt + = ");
				btRecalcularTroco.setMnemonic(KeyEvent.VK_EQUALS);
				btRecalcularTroco.setFont(new Font("Kalinga", Font.PLAIN, 14));
				btRecalcularTroco.setIcon(new ImageIcon(PainelMesas.class
						.getResource("/icones1_24px/1425606619_notepad-128.png")));
				btRecalcularTroco.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PainelMesas.this.CalcularTotal();
						PainelMesas.this.CalcularParcela();
						PainelMesas.this.CalcularParcelamento();
						PainelMesas.this.CalcularTroco();
					}
				});

		this.setSize(toolkit.getScreenSize());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PainelMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PainelMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PainelMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PainelMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}

	protected void CancelarVenda() {
		if (contLinha > 0) {
			String comandosql7 = "UPDATE `erp`.`mesas` SET " + " `numeroVenda` = '" + null + "', `data` = '" + null
					+ "', `ultimoPedido` = '" + null + "', `vendedor` = '" + null + "', `nomeCliente` = '" + null
					+ "', `cpf` = '" + null + "', `telefone` = '" + null + "', `formaPagamento` = '" + null
					+ "', `quantidade` = '" + null + "', `valorTotal` = '" + null + "', `desconto` = '" + null
					+ "', `valorFinal` = '" + null + "', `valorParcelado` = '" + null + "', `valorPago` = '"
					+ null + "', `status` = '" + "Final" + "', `motivo` = '" + "cancelada"
					+ "'WHERE `mesas`.`numeroMesa` = '" + labelMesaX.getText() + "'";

			x.grava(comandosql7);
			for (int i = 0; i < contLinha; i++) {
				modelo.removeRow(0);
				String comandosql = ("DELETE from itens_mesa where numeroVenda = '" + numeroVenda.getText() + "'");
				x.grava(comandosql);
			}
			contLinha = 0;
			valorTotal.setText("0.0");
			valorT = 0.0;
			ValorF = 0.0;
			labelFotoProduto.setIcon(null);
			PainelMesas.this.CalcularParcela();
			PainelMesas.this.CalcularParcelamento();
			PainelMesas.this.CalcularTroco();
			PainelMesas.this.SetarValor2();
			PainelMesas.this.dispose();
			Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
			System.out.println(Inicio.mesasAbertas);
		} else {
			PainelMesas.this.SetarValor2();
			Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
			System.out.println(Inicio.mesasAbertas);
			PainelMesas.this.dispose();
		}
	}

	private void Animacao() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					char c = str.charAt(0);
					String rest = str.substring(1);
					str = rest + c;
					labelAnimacao.setText(str);
					try {
						Thread.sleep(750);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	protected void FecharMesa() {
		if (contLinha > 0) {
			String comandosql = "INSERT INTO `erp`.`venda` (`numeroVenda`, `data`, `hora`, `vendedor`, `nomeCliente`, `cpf`, `telefone`, `formaPagamento`, `parcelamento`, `banco`, `numeroCheque`, `agencia`, `valorTotal`, `desconto`, `valorFinal`, `valorParcelado`, `valorPago`, `troco`, `localVenda`)"
					+ "VALUES('"
					+ numeroVenda.getText()
					+ "','"
					+ data1.getText()
					+ "','"
					+ ultimoPedido.getText()
					+ "','"
					+ vendedor.getText()
					+ "','"
					+ comboNome.getSelectedItem().toString()
					+ "','"
					+ cpf1.getText()
					+ "','"
					+ telefone.getText()
					+ "','"
					+ comboFormaPagamento.getSelectedItem().toString()
					+ "','"
					+ comboVezes.getSelectedItem().toString()
					+ "','"
					+ banco.getSelectedItem()
					+ "','"
					+ numeroCheque.getText()
					+ "','"
					+ agencia.getText()
					+ "','"
					+ valorTotal.getText()
					+ "','"
					+ desconto.getText()
					+ "','"
					+ valorParcelado.getText()
					+ "','"
					+ valorFinal.getText()
					+ "','"
					+ valorPago.getText() + "','" + troco1.getText() + "','" + "Mesa" + "')";
			x.grava(comandosql);

			for (int i = 0; i < contLinha; i++) {
				String comandosql7 = "INSERT INTO itensvenda(numeroVenda,Cliente,data, item, codigoItem, descricao, quantidade, precoUnitario, total) "
						+ "VALUES('"
						+ numeroVenda.getText()
						+ "','"
						+ "***"//Cliente
						+ "','"
						+ "***"//Data
						+ "','"
						+ modelo.getValueAt(i, 0).toString()
						+ "','"
						+ modelo.getValueAt(i, 1).toString()
						+ "','"
						+ modelo.getValueAt(i, 2).toString()
						+ "','"
						+ modelo.getValueAt(i, 3).toString()
						+ "','"
						+ modelo.getValueAt(i, 4).toString()
						+ "','"
						+ modelo.getValueAt(i, 5).toString() + "')";
				x.grava(comandosql7);
			}
			
			String comandosql21 = "INSERT INTO `erp`.`caixa` (`usuario`, `data`, `hora`, `valor`, `saldoInicial`, `saldoFinal`, `entradas`)"
					+ "VALUES('"
					+ Login.User
					+ "','"
					+ data1.getText()
					+ "','"
					+ ultimoPedido.getText()
					+ "','"
					+ valorFinal.getText().replace(",", ".")
					+ "','"
					+ VendasController.saldo //Saldo Inicial
					+ "','"
					+ String.valueOf(nf.format(VendasController.saldo+Double.parseDouble(valorFinal.getText().replace(",", "."))))
					+ "','"
					+ "Venda" + "')";
			x.grava(comandosql21);
			VendasController.saldo=VendasController.saldo+Double.parseDouble(valorFinal.getText().replace(",", "."));
			VendasController.entrada=VendasController.entrada+Double.parseDouble(valorPago.getText().replace(",", "."));
			VendasController.saida=VendasController.saida+Double.parseDouble(troco1.getText().replace(",", "."));

			int d = Integer.parseInt(numeroVenda.getText());
			d++;
			String comandosql4 = "UPDATE  `erp`.`contadores` SET  `numeroVenda` =  '" + String.valueOf(d)
					+ "' WHERE  `contadores`.`numeroVenda` =  '" + numeroVenda.getText() + "'";
			x.grava(comandosql4);
			
			AbaterEstoque();
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);

			for (int i = 0; i < contLinha; i++) {
				modelo.removeRow(0);
			}
			contLinha = 0;
			valorTotal.setText("0.0");
			valorT = 0.0;
			ValorF = 0.0;
			labelFotoProduto.setIcon(null);
			PainelMesas.this.CalcularParcela();
			PainelMesas.this.CalcularParcelamento();
			PainelMesas.this.CalcularTroco();
			PainelMesas.this.SetarValor2();
			Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
			System.out.println(Inicio.mesasAbertas);
			PainelMesas.this.dispose();

			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				numeroVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
				numeroVenda.setEditable(false);

				while (rs3.next()) {
					numeroVenda.setText(rs3.getString("numeroVenda"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else{
		PainelMesas.this.SetarValor2();
		Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
		System.out.println(Inicio.mesasAbertas);
		JOptionPane.showMessageDialog(null, "Não há nenhum item selecionado!", "Mensagem do Sistema",JOptionPane.WARNING_MESSAGE);
		}
	}

	private void AbaterEstoque() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		for (int i = 0; i< contLinha; i++) {			 
		dados = x.Consultar("select*from produtos where codigoProduto = '" + this. modelo.getValueAt(i, 1).toString() + "'");
		try {
			dados.next();
			double quantDescontar=Double.parseDouble(dados.getString("estoqueAtual").replace(",", "."));	
			quantDescontar = quantDescontar- Double.parseDouble(this.modelo.getValueAt(i, 3).toString().replace(",", "."));		
			String comandosql4 = "UPDATE  `erp`.`produtos` SET  `estoqueAtual` =  '" + String.valueOf(nf.format(quantDescontar).replace(",", "."))
					+ "' WHERE  `produtos`.`codigoProduto` =  '" + this.modelo.getValueAt(i, 1).toString()+ "'";
			x.grava(comandosql4);
			if(Double.parseDouble(dados.getString("estoqueAtual").replace(",", "."))<Double.parseDouble(dados.getString("estoqueMinimo").replace(",", "."))){
				JOptionPane.showMessageDialog(null, "O Produto ["+dados.getString("nome")+"] está abaixo do Estoque MINIMO", "Mensagem do Sistema",
						JOptionPane.WARNING_MESSAGE);
			}
			String comandosql = "INSERT INTO estoque_produto(codigo, dataMovimento, dataCompra, validade, numeroLote, notaFiscal,"
					+ " quantidade, movimento, localEstoque, codigoFornecedor,usuario) VALUES('"
					+ ModelVendas.getCodigoItem()+ "','"
					+ ModelVendas.getDataVenda()+ "','"
					+ "**/**/****"				+ "','"//Data da Compra
					+ "**/**/****"				+ "','"//Data de Validade
					+ "****"					+ "','"//Lote
					+ "****"					+ "','"//Nota Fiscal
					+ String.valueOf(nf.format(Double.parseDouble(ModelVendas.getQuantidade())))
					+ "','"
					+ "Saida"					+ "','"
					+ "Mesa"				+ "','"//Local de estoque
					+ "Vazio"					+ "','"//Fornecedor
					+ Login.User				+ "')";//Fornecedor
			x.grava(comandosql);
			} catch (SQLException ex) {
			ex.printStackTrace();
		}	
		try {
			if(dados.getString("fichaTecnica").equals("sim")){
				
				ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '" + this.modelo.getValueAt(i, 1).toString() + "'");
				while (dados2.next()) {
					dados = x.Consultar("select*from materia_p where codigo = '" + dados2.getString("codigomp")+ "'");
					
					double quantDescontar=Double.parseDouble(dados2.getString("quantidade"));	
					dados.next();
					quantDescontar = Double.parseDouble(dados.getString("estoqueAtual").replace(",", "."))-(quantDescontar* Double.parseDouble( modelo.getValueAt(i, 3).toString())) ;		
					System.out.println("Desconto " +quantDescontar);
					String comandosql4 = "UPDATE  `erp`.`materia_p` SET  `estoqueAtual` =  '" + String.valueOf(nf.format(quantDescontar).replace(",", "."))
							+ "' WHERE  `materia_p`.`codigo` =  '" + dados2.getString("codigomp")+ "'";
					x.grava(comandosql4);
					
					if(Double.parseDouble(dados.getString("estoqueAtual").replace(",", "."))<Double.parseDouble(dados.getString("estoqueMinimo").replace(",", "."))){
						JOptionPane.showMessageDialog(null, "A Materia Prima ["+dados.getString("nome")+"] está abaixo do Estoque MINIMO!", "Mensagem do Sistema",
								JOptionPane.WARNING_MESSAGE);
					}
					String comandosql = "INSERT INTO estoque_mp(codigo, dataMovimento, dataCompra, validade, numeroLote, notaFiscal,"
							+ " quantidade, movimento, localEstoque, codigoFornecedor,usuario) VALUES('"
							+ dados2.getString("codigomp")+ "','"
							+ ModelVendas.getDataVenda()+ "','"
							+ "**/**/****"				+ "','"//Data da Compra
							+ "**/**/****"				+ "','"//Data de Validade
							+ "****"					+ "','"//Lote
							+ "****"					+ "','"//Nota Fiscal
							+ String.valueOf(nf.format(Double.parseDouble(dados2.getString("quantidade"))*Double.parseDouble(ModelVendas.getQuantidade())))
							+ "','"
							+ "Saida"					+ "','"
							+ "Mesa"					+ "','"//Local de estoque
							+ "****"					+ "','"//Fornecedor
							+ Login.User				+ "')";//Fornecedor
					x.grava(comandosql);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}		
	}

	private void SetarValor2() {
		String Ms = labelMesaX.getText();
		if (Ms.equals("* MESA 1")) {
			Vendas.lbMs1.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa1.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn1 = 0;
		} else if (Ms.equals("* MESA 2")) {
			Vendas.lbMs2.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa2.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn2 = 0;
		} else if (Ms.equals("* MESA 3")) {
			Vendas.lbMs3.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa3.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn3 = 0;
		} else if (Ms.equals("* MESA 4")) {
			Vendas.lbMs4.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa4.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn4 = 0;
		} else if (Ms.equals("* MESA 5")) {
			Vendas.lbMs4.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa5.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn5 = 0;
		} else if (Ms.equals("* MESA 6")) {
			Vendas.lbMs6.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa6.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn6 = 0;
		} else if (Ms.equals("* MESA 7")) {
			Vendas.lbMs7.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa7.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn7 = 0;
		} else if (Ms.equals("* MESA 8")) {
			Vendas.lbMs8.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa8.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn8 = 0;
		} else if (Ms.equals("* MESA 9")) {
			Vendas.lbMs9.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa9.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn9 = 0;
		} else if (Ms.equals("* MESA 10")) {
			Vendas.lbMs10.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa10
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn10 = 0;
		} else if (Ms.equals("* MESA 11")) {
			Vendas.lbMs11.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa11
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn11 = 0;
		} else if (Ms.equals("* MESA 12")) {
			Vendas.lbMs12.setText("R$ " + this.valorFinal.getText());
			Vendas.btn12 = 0;
		} else if (Ms.equals("* MESA 13")) {
			Vendas.lbMs13.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa13
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn13 = 0;
		} else if (Ms.equals("* MESA 14")) {
			Vendas.lbMs14.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa14
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn14 = 0;
		} else if (Ms.equals("* MESA 15")) {
			Vendas.lbMs15.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa15
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn15 = 0;
		} else if (Ms.equals("* MESA 16")) {
			Vendas.lbMs16.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa16
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn16 = 0;
		} else if (Ms.equals("* MESA 17")) {
			Vendas.lbMs17.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa17
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn17 = 0;
		} else if (Ms.equals("* MESA 18")) {
			Vendas.lbMs18.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa18
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn18 = 0;
		} else if (Ms.equals("* MESA 19")) {
			Vendas.lbMs19.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa19.setIcon(new ImageIcon(Vendas.class.getResource("")));
			Vendas.btn19 = 0;
		} else if (Ms.equals("* MESA 20")) {
			Vendas.lbMs20.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa20
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn20 = 0;
		} else if (Ms.equals("* MESA 21")) {
			Vendas.lbMs21.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa21
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn21 = 0;
		} else if (Ms.equals("* MESA 22")) {
			Vendas.lbMs22.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa22
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn22 = 0;
		} else if (Ms.equals("* MESA 23")) {
			Vendas.lbMs23.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa23
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn23 = 0;
		} else if (Ms.equals("* MESA 24")) {
			Vendas.lbMs24.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa24
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn24 = 0;
		} else if (Ms.equals("* MESA 25")) {
			Vendas.lbMs25.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa25
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn25 = 0;
		} else if (Ms.equals("* MESA 26")) {
			Vendas.lbMs26.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa26
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn26 = 0;
		} else if (Ms.equals("* MESA 27")) {
			Vendas.lbMs27.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa27
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn27 = 0;
		} else if (Ms.equals("* MESA 28")) {
			Vendas.lbMs28.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa28
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn28 = 0;
		} else if (Ms.equals("* MESA 29")) {
			Vendas.lbMs29.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa29
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn29 = 0;
		} else if (Ms.equals("* MESA 30")) {
			Vendas.lbMs30.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa30
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn30 = 0;
		} else if (Ms.equals("* MESA 31")) {
			Vendas.lbMs31.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa31
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn31 = 0;
		} else if (Ms.equals("* MESA 32")) {
			Vendas.lbMs32.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa32
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn32 = 0;
		} else if (Ms.equals("* MESA 33")) {
			Vendas.lbMs33.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa33
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn33 = 0;
		} else if (Ms.equals("* MESA 34")) {
			Vendas.lbMs34.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa34
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn34 = 0;
		} else if (Ms.equals("* MESA 35")) {
			Vendas.lbMs35.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa35
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn35 = 0;
		} else if (Ms.equals("* MESA 36")) {
			Vendas.lbMs36.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa36
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn36 = 0;
		} else if (Ms.equals("* MESA 37")) {
			Vendas.lbMs37.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa37
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn37 = 0;
		} else if (Ms.equals("* MESA 38")) {
			Vendas.lbMs38.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa38
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn38 = 0;
		} else if (Ms.equals("* MESA 39")) {
			Vendas.lbMs39.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa39
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn39 = 0;
		} else if (Ms.equals("* MESA 40")) {
			Vendas.lbMs40.setText("R$ " + this.valorFinal.getText());
			Vendas.btMesa40
					.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_40px.png")));
			Vendas.btn40 = 0;
		}

	}

	protected void SetarValor() {
		String Ms = labelMesaX.getText();
		if (Ms.equals("* MESA 1")) {
			Vendas.lbMs1.setText("R$ " + this.valorFinal.getText());
			Vendas.btn1 = 0;
		} else if (Ms.equals("* MESA 2")) {
			Vendas.lbMs2.setText("R$ " + this.valorFinal.getText());
			Vendas.btn2 = 0;
		} else if (Ms.equals("* MESA 3")) {
			Vendas.lbMs3.setText("R$ " + this.valorFinal.getText());
			Vendas.btn3 = 0;
		} else if (Ms.equals("* MESA 4")) {
			Vendas.lbMs4.setText("R$ " + this.valorFinal.getText());
			Vendas.btn4 = 0;
		} else if (Ms.equals("* MESA 5")) {
			Vendas.lbMs5.setText("R$ " + this.valorFinal.getText());
			Vendas.btn5 = 0;
		} else if (Ms.equals("* MESA 6")) {
			Vendas.lbMs6.setText("R$ " + this.valorFinal.getText());
			Vendas.btn6 = 0;
		} else if (Ms.equals("* MESA 7")) {
			Vendas.lbMs7.setText("R$ " + this.valorFinal.getText());
			Vendas.btn7 = 0;
		} else if (Ms.equals("* MESA 8")) {
			Vendas.lbMs8.setText("R$ " + this.valorFinal.getText());
			Vendas.btn8 = 0;
		} else if (Ms.equals("* MESA 9")) {
			Vendas.lbMs9.setText("R$ " + this.valorFinal.getText());
			Vendas.btn9 = 0;
		} else if (Ms.equals("* MESA 10")) {
			Vendas.lbMs10.setText("R$ " + this.valorFinal.getText());
			Vendas.btn10 = 0;
		} else if (Ms.equals("* MESA 11")) {
			Vendas.lbMs11.setText("R$ " + this.valorFinal.getText());
			Vendas.btn11 = 0;
		} else if (Ms.equals("* MESA 12")) {
			Vendas.lbMs12.setText("R$ " + this.valorFinal.getText());
			Vendas.btn12 = 0;
		} else if (Ms.equals("* MESA 13")) {
			Vendas.lbMs13.setText("R$ " + this.valorFinal.getText());
			Vendas.btn13 = 0;
		} else if (Ms.equals("* MESA 14")) {
			Vendas.lbMs14.setText("R$ " + this.valorFinal.getText());
			Vendas.btn14 = 0;
		} else if (Ms.equals("* MESA 15")) {
			Vendas.lbMs15.setText("R$ " + this.valorFinal.getText());
			Vendas.btn15 = 0;
		} else if (Ms.equals("* MESA 16")) {
			Vendas.lbMs16.setText("R$ " + this.valorFinal.getText());
			Vendas.btn16 = 0;
		} else if (Ms.equals("* MESA 17")) {
			Vendas.lbMs17.setText("R$ " + this.valorFinal.getText());
			Vendas.btn17 = 0;
		} else if (Ms.equals("* MESA 18")) {
			Vendas.lbMs18.setText("R$ " + this.valorFinal.getText());
			Vendas.btn18 = 0;
		} else if (Ms.equals("* MESA 19")) {
			Vendas.lbMs19.setText("R$ " + this.valorFinal.getText());
			Vendas.btn19 = 0;
		} else if (Ms.equals("* MESA 20")) {
			Vendas.lbMs20.setText("R$ " + this.valorFinal.getText());
			Vendas.btn20 = 0;
		} else if (Ms.equals("* MESA 21")) {
			Vendas.lbMs21.setText("R$ " + this.valorFinal.getText());
			Vendas.btn21 = 0;
		} else if (Ms.equals("* MESA 22")) {
			Vendas.lbMs22.setText("R$ " + this.valorFinal.getText());
			Vendas.btn22 = 0;
		} else if (Ms.equals("* MESA 23")) {
			Vendas.lbMs23.setText("R$ " + this.valorFinal.getText());
			Vendas.btn23 = 0;
		} else if (Ms.equals("* MESA 24")) {
			Vendas.lbMs24.setText("R$ " + this.valorFinal.getText());
			Vendas.btn24 = 0;
		} else if (Ms.equals("* MESA 25")) {
			Vendas.lbMs25.setText("R$ " + this.valorFinal.getText());
			Vendas.btn25 = 0;
		} else if (Ms.equals("* MESA 26")) {
			Vendas.lbMs26.setText("R$ " + this.valorFinal.getText());
			Vendas.btn26 = 0;
		} else if (Ms.equals("* MESA 27")) {
			Vendas.lbMs27.setText("R$ " + this.valorFinal.getText());
			Vendas.btn27 = 0;
		} else if (Ms.equals("* MESA 28")) {
			Vendas.lbMs28.setText("R$ " + this.valorFinal.getText());
			Vendas.btn28 = 0;
		} else if (Ms.equals("* MESA 29")) {
			Vendas.lbMs29.setText("R$ " + this.valorFinal.getText());
			Vendas.btn29 = 0;
		} else if (Ms.equals("* MESA 30")) {
			Vendas.lbMs30.setText("R$ " + this.valorFinal.getText());
			Vendas.btn30 = 0;
		} else if (Ms.equals("* MESA 31")) {
			Vendas.lbMs31.setText("R$ " + this.valorFinal.getText());
			Vendas.btn31 = 0;
		} else if (Ms.equals("* MESA 32")) {
			Vendas.lbMs32.setText("R$ " + this.valorFinal.getText());
			Vendas.btn32 = 0;
		} else if (Ms.equals("* MESA 33")) {
			Vendas.lbMs33.setText("R$ " + this.valorFinal.getText());
			Vendas.btn33 = 0;
		} else if (Ms.equals("* MESA 34")) {
			Vendas.lbMs34.setText("R$ " + this.valorFinal.getText());
			Vendas.btn34 = 0;
		} else if (Ms.equals("* MESA 35")) {
			Vendas.lbMs35.setText("R$ " + this.valorFinal.getText());
			Vendas.btn35 = 0;
		} else if (Ms.equals("* MESA 36")) {
			Vendas.lbMs36.setText("R$ " + this.valorFinal.getText());
			Vendas.btn36 = 0;
		} else if (Ms.equals("* MESA 37")) {
			Vendas.lbMs37.setText("R$ " + this.valorFinal.getText());
			Vendas.btn37 = 0;
		} else if (Ms.equals("* MESA 38")) {
			Vendas.lbMs38.setText("R$ " + this.valorFinal.getText());
			Vendas.btn38 = 0;
		} else if (Ms.equals("* MESA 39")) {
			Vendas.lbMs39.setText("R$ " + this.valorFinal.getText());
			Vendas.btn39 = 0;
		} else if (Ms.equals("* MESA 40")) {
			Vendas.lbMs40.setText("R$ " + this.valorFinal.getText());
			Vendas.btn40 = 0;
		}

	}

	private void RemoverItem() {
		this.M = 0;
		if (this.comboRemoveItem.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
		} else {
			if (this.contLinha == 1) {
				if ((Integer) this.Quantidade2.getValue() > Integer.parseInt((String) this.modelo.getValueAt(
						contLinha - 1, 3))) {
					JOptionPane.showMessageDialog(null, "Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
							JOptionPane.WARNING_MESSAGE);
					this.Quantidade2.requestFocus();
					this.M = 1;
				}

				if ((Integer) this.Quantidade2.getValue()
						- Integer.parseInt((String) this.modelo.getValueAt(this.contLinha - 1, 3)) == 0
						&& this.M == 0) {
					this.contLinha--;
					this.modelo.removeRow(this.contLinha);
				}

				else {
					for (int i = 0; i < this.contLinha; i++) {

						if (this.comboRemoveItem.getSelectedItem().toString()
								.equals((String) this.modelo.getValueAt(i, 2))
								&& this.M == 0) {
							if ((Integer) this.Quantidade2.getValue() > Integer.parseInt((String) this.modelo
									.getValueAt(i, 3))) {
								JOptionPane.showMessageDialog(null,
										"Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
										JOptionPane.WARNING_MESSAGE);
								this.Quantidade2.requestFocus();
								this.M = 1;
							}

							if ((Integer) this.Quantidade2.getValue()
									- Integer.parseInt((String) this.modelo.getValueAt(i, 3)) == 0
									&& this.M == 0) {
								this.contLinha--;
								this.modelo.removeRow(i);
							}

							else {
								this.modelo.setValueAt((String.valueOf(nf.format(Integer
										.parseInt((String) this.modelo.getValueAt(i, 3))
										- (Integer) this.Quantidade2.getValue()))), i, 3);
								this.modelo.setValueAt((String.valueOf(nf.format(Integer
										.parseInt((String) this.modelo.getValueAt(i, 3))
										* (Double.parseDouble((String) this.modelo.getValueAt(i, 4)))))), i,
										5);
							}
						}
					}
				}
			} else {
				for (int i = 0; i < this.contLinha; i++) {
					if (this.comboRemoveItem.getSelectedItem().toString()
							.equals((String) this.modelo.getValueAt(i, 2))
							&& this.M == 0) {
						if ((Integer) this.Quantidade2.getValue() > Integer.parseInt((String) this.modelo
								.getValueAt(i, 3))) {
							JOptionPane.showMessageDialog(null, "Quantidade Maior qua a existente na tabela!",
									"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
							this.M = 1;
						}
					}
					if (this.comboRemoveItem.getSelectedItem().toString()
							.equals((String) this.modelo.getValueAt(i, 2))
							&& this.M == 0) {

						if ((Integer) this.Quantidade2.getValue()
								- Integer.parseInt((String) this.modelo.getValueAt(i, 3)) == 0) {
							this.contLinha--;
							this.modelo.removeRow(i);
							for (i = 0; i < contLinha; i++) {
								this.modelo.setValueAt(i + 1, i, 0);
							}
						}

						else {
							this.modelo.setValueAt(
									(String.valueOf(nf.format(Integer.parseInt((String) this.modelo
											.getValueAt(i, 3)) - (Integer) this.Quantidade2.getValue()))),
									i, 3);
							this.modelo.setValueAt((String.valueOf(nf.format(Integer
									.parseInt((String) this.modelo.getValueAt(i, 3))
									* (Double.parseDouble((String) modelo.getValueAt(i, 4)))))), i, 5);
						}
					}
				}
			}
			PainelMesas.this.CalcularTotal();
			PainelMesas.this.CalcularParcela();
			PainelMesas.this.CalcularParcelamento();
			PainelMesas.this.CalcularTroco();
			Quantidade2.requestFocus();

			if (M == 0) {
				internalFrameRemove.setVisible(false);
				Quantidade2.setValue(1);
			}

		}
	}

	private void AddItem() {
		int linha = 0, achou = 0;
		if (this.comboProduto.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
		}
		else if (this.contLinha == linha) {
			int quant = (Integer) this.quantidade.getValue();
			this.valorT = 0;
			this.valorT = quant * this.precoUnitario;

			this.vlTotal1 = this.vlTotal1 + this.valorT;
			this.valorTotal.setText(String.valueOf(this.vlTotal1));
			this.contLinha++;
			this.modelo.addRow(new String[] { String.valueOf(this.contLinha), this.codProd,
					this.comboProduto.getSelectedItem().toString(),
					(String) this.quantidade.getValue().toString(), String.valueOf(this.precoUnitario),
					String.valueOf(nf.format(this.valorT)) });
			this.contitem.setText(String.valueOf(this.contLinha));

			System.out.println("numero de linha" + this.contLinha);
			this.quantidade.setValue(1);
		}

		else {
			for (int i = 0; i < this.contLinha; i++) {
				if (this.comboProduto.getSelectedItem().toString().equals((String) this.modelo.getValueAt(i, 2))) {
					int quant2 = (Integer) this.quantidade.getValue()
							+ (Integer.parseInt((String) this.modelo.getValueAt(i, 3)));
					this.valorT = 0;
					achou = 1;
					this.valorT = quant2 * this.precoUnitario;
					this.vlTotal1 = this.vlTotal1 + this.valorT - this.precoUnitario;
					this.valorTotal.setText(String.valueOf(this.vlTotal1));

					this.modelo.setValueAt((String.valueOf(nf.format(quant2))), i, 3);
					this.modelo.setValueAt((String.valueOf(nf.format(valorT))), i, 5);

					this.quantidade.setValue(1);
					System.out.println(String.valueOf(this.valorT));
					System.out.println("numero da linha" + this.contLinha);
					PainelMesas.this.CalcularParcela();
					PainelMesas.this.CalcularParcelamento();
					PainelMesas.this.CalcularTroco();
				}
			}
			if (achou == 0) {
				int quant = (Integer) this.quantidade.getValue();
				this.valorT = 0;
				this.valorT = quant * this.precoUnitario;

				this.vlTotal1 = this.vlTotal1 + this.valorT;
				this.valorTotal.setText(String.valueOf(this.vlTotal1));
				this.contLinha++;
				this.modelo.addRow(new String[] { String.valueOf(this.contLinha), this.codProd,
						this.comboProduto.getSelectedItem().toString(),
						(String) this.quantidade.getValue().toString(), String.valueOf(this.precoUnitario),
						String.valueOf(nf.format(this.valorT)) });
				this.contitem.setText(String.valueOf(this.contLinha));

				System.out.println("numero de linhas" + this.contLinha);
				this.quantidade.setValue(1);
				PainelMesas.this.CalcularParcela();
				PainelMesas.this.CalcularParcelamento();
				PainelMesas.this.CalcularTroco();
			}
		}
		PainelMesas.this.CalcularTotal();
		PainelMesas.this.CalcularParcela();
		PainelMesas.this.CalcularParcelamento();
		PainelMesas.this.CalcularTroco();

		this.quantidade.setValue(1);
		this.comboProduto.setSelectedItem("");
		this.str = "                   Bem vindo ao S-One !!!                   ";

	}

	private void CalcularTroco() {
		this.troco = 0;
		if (this.par <= 1)
			troco = ((Double.parseDouble(this.valorPago.getText()) - this.ValorF));
		else
			this.troco = (Double.parseDouble(this.valorPago.getText().replace(",", ".")) - this.parcela);
		this.troco1.setText(String.valueOf(nf.format(this.troco)));
	}

	private void CalcularTotal() {
		this.valorT = 0;
		this.ValorF = 0;
		for (int i = 0; i < contLinha; i++) {

			this.valorT = this.valorT
					+ ((Double.parseDouble((String) this.modelo.getValueAt(i, 4)) * Integer
							.parseInt((String) this.modelo.getValueAt(i, 3))));
			this.ValorF = (this.valorT - Double.parseDouble(this.desconto.getText()));
		}

		this.valorTotal.setText(String.valueOf(nf.format(this.valorT)));
		this.valorFinal.setText(String.valueOf(this.ValorF));
	}

	private void CalcularParcelamento() {
		this.parcela = this.ValorF / this.par;
		this.valorParcelado.setText(this.comboVezes.getSelectedItem().toString() + " "
				+ String.valueOf((nf.format(this.parcela))));
		this.valorFinal.setText(String.valueOf(nf.format(this.valorT - Double.parseDouble(this.desconto.getText().replace(",", ".")))));
	}

	private void TabelaVendas() {
		modelo.removeRow(0);
	}

	private void CalcularParcela() {
		if (this.comboVezes.getSelectedItem().equals("1x")) {
			this.par = 1;
		}
		else if (this.comboVezes.getSelectedItem().equals("2x")) {
			this.par = 2;
		}
		else if (this.comboVezes.getSelectedItem().equals("3x")) {
			this.par = 3;
		}
		else if (this.comboVezes.getSelectedItem().equals("4x")) {
			this.par = 4;
		}
		else if (this.comboVezes.getSelectedItem().equals("5x")) {
			this.par = 5;
		}
		else if (this.comboVezes.getSelectedItem().equals("6x")) {
			this.par = 6;
		}
		else if (this.comboVezes.getSelectedItem().equals("7x")) {
			this.par = 7;
		}
		else if (this.comboVezes.getSelectedItem().equals("8x")) {
			this.par = 8;
		}
		else if (this.comboVezes.getSelectedItem().equals("9x")) {
			this.par = 9;
		}
		else if (this.comboVezes.getSelectedItem().equals("10x")) {
			this.par = 10;
		}
		else if (this.comboVezes.getSelectedItem().equals("11x")) {
			this.par = 11;
		}
		else if (this.comboVezes.getSelectedItem().equals("12x")) {
			this.par = 12;
		}
		}

	protected void FormaPagamento() {
		if (form.equals("Cartão de Crédito")) {
			radioAmerican.setVisible(true);
			radioMaster.setVisible(true);
			radioVisa.setVisible(true);
			labelSelecioneCartao.setVisible(true);
			labelBanco.setVisible(false);
			numeroCheque.setVisible(false);
			labelNumeroCheque.setVisible(false);
			banco.setVisible(false);
			labelAgencia.setVisible(false);
			agencia.setVisible(false);
			labelNumeroConta.setVisible(false);
			numeroConta.setVisible(false);
			labelDadosCheque.setVisible(false);
		} else if (form.equals("Cheque")) {
			labelBanco.setVisible(true);
			numeroCheque.setVisible(true);
			labelNumeroCheque.setVisible(true);
			banco.setVisible(true);
			labelAgencia.setVisible(true);
			agencia.setVisible(true);
			labelNumeroConta.setVisible(true);
			numeroConta.setVisible(true);
			labelDadosCheque.setVisible(true);
			radioAmerican.setVisible(false);
			radioMaster.setVisible(false);
			radioVisa.setVisible(false);
			labelSelecioneCartao.setVisible(false);
		} else {
			radioAmerican.setVisible(false);
			radioMaster.setVisible(false);
			radioVisa.setVisible(false);
			labelSelecioneCartao.setVisible(false);
			labelBanco.setVisible(false);
			numeroCheque.setVisible(false);
			labelNumeroCheque.setVisible(false);
			banco.setVisible(false);
			labelAgencia.setVisible(false);
			agencia.setVisible(false);
			labelNumeroConta.setVisible(false);
			numeroConta.setVisible(false);
			labelDadosCheque.setVisible(false);
		}

	}

	protected void SetarMesa(String mes) {
		labelMesaX.setText(mes);
		//this.btOcultarPainel.setText("Ocultar " + mes);
		setTitle(mes);
	}

	protected void ocultarMesa() {
		if (this.contLinha > 0) {
			String comandosql = "UPDATE `erp`.`mesas` SET" 
					+ " `numeroVenda` = '" + numeroVenda.getText()
					+ "', `data` = '" + data1.getText() 
					+ "', `ultimoPedido` = '"+ ultimoPedido.getText().toString() 
					+ "', `vendedor` = '" + vendedor.getText()
					+ "', `nomeCliente` = '" + comboNome.getSelectedItem().toString() 
					+ "', `cpf` = '"+ cpf1.getText() 
					+ "', `telefone` = '" + telefone.getText() 
					+ "', `formaPagamento` = '"+ comboFormaPagamento.getSelectedItem().toString() 
					+ "', `quantidade` = '"+ comboVezes.getSelectedItem().toString() 
					+ "', `valorTotal` = '" + valorTotal.getText()
					+ "', `desconto` = '" + desconto.getText() 
					+ "', `valorFinal` = '" + valorFinal.getText()
					+ "', `valorParcelado` = '" + valorParcelado.getText()
					+ "', `valorPago` = '"+ valorPago.getText()
					+ "', `valorTroco` = '"	+ troco1.getText()
					+ "', `status` = '" + "Temporário" + "', `motivo` = '" + "Ativo"
					+ "'WHERE `mesas`.`numeroMesa` = '" + labelMesaX.getText() + "'";

			x.grava(comandosql);

			for (int i = 0; i < contLinha; i++) {
				String comandosql7 = "INSERT INTO itens_mesa(numeroVenda,item,codigoItem,descricao,quantidade,precoUnitario,total) "
						+ "VALUES('"
						+ numeroVenda.getText()
						+ "','"
						+ modelo.getValueAt(i, 0).toString()
						+ "','"
						+ modelo.getValueAt(i, 1).toString()
						+ "','"
						+ modelo.getValueAt(i, 2).toString()
						+ "','"
						+ modelo.getValueAt(i, 3).toString()
						+ "','"
						+ modelo.getValueAt(i, 4).toString()
						+ "','"
						+ modelo.getValueAt(i, 5).toString() + "')";
				x.grava(comandosql7);
			}

			int d = Integer.parseInt(numeroVenda.getText());
			d++;
			String comandosql4 = "UPDATE  `erp`.`contadores` SET " + " `numeroVenda` =  '" + String.valueOf(d)
					+ "' WHERE  `contadores`.`numeroVenda` =  '" + numeroVenda.getText() + "'";
			x.grava(comandosql4);

			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",
					JOptionPane.PLAIN_MESSAGE);

			for (int i = 0; i < contLinha; i++) {
				modelo.removeRow(0);
			}
			contLinha = 0;
			valorTotal.setText("0.0");
			valorT = 0.0;
			ValorF = 0.0;
			labelFotoProduto.setIcon(null);
			comboNome.setSelectedItem("");
			cpf1.setText("");
			telefone.setText("");
			PainelMesas.this.CalcularParcela();
			PainelMesas.this.CalcularParcelamento();
			PainelMesas.this.CalcularTroco();
			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				numeroVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
				numeroVenda.setEditable(false);

				while (rs3.next()) {
					numeroVenda.setText(rs3.getString("numeroVenda"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} else {
			Inicio.mesasAbertas = Inicio.mesasAbertas - 1;
			System.out.println(Inicio.mesasAbertas);
			PainelMesas.this.SetarValor2();
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "Mensagem do Sistema",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void CarregarMesa(String mesa) {
		labelMesaX.setText(mesa);
		this.btOcultarPainel.setText("Ocultar " + mesa);
		setTitle(mesa);
		ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '" + mesa + "'");
		try {
			dados.next();
			numeroVenda.setText(dados.getString("numeroVenda"));
			data1.setText(dados.getString("data"));
			vendedor.setText(dados.getString("vendedor"));
			ultimoPedido.setText(dados.getString("ultimoPedido"));
			comboNome.setSelectedItem(dados.getString("nomeCliente"));
			cpf1.setText(dados.getString("cpf"));
			telefone.setText(dados.getString("telefone"));
			valorTotal.setText(dados.getString("valorTotal"));
			desconto.setText(dados.getString("desconto"));
			valorFinal.setText(dados.getString("valorFinal"));
			valorParcelado.setText(dados.getString("valorParcelado"));
			valorPago.setText(dados.getString("valorPago"));
			troco1.setText(dados.getString("valorTroco"));

			ResultSet dados2 = x.Consultar("select*from itens_mesa where numeroVenda = '"
					+ dados.getString("numeroVenda") + "'");
			while (dados2.next()) {
				this.modelo.addRow(new String[] { dados2.getString("item"), dados2.getString("codigoItem"),
						dados2.getString("descricao"), dados2.getString("quantidade"),
						dados2.getString("precoUnitario"), dados2.getString("total") });
				contLinha++;

				String comandosql = ("DELETE from itens_mesa where numeroVenda = '"
						+ dados.getString("numeroVenda") + "'");
				x.grava(comandosql);
				System.out.println("numero da linha" + this.contLinha);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	protected static void SelecionarPapelParedePainelMesas() {
		JFileChooser selecionarArquivo = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG E BMP", "jpg", "gif", "png",
				"bmp");
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
			// a abertura do JFileChooser, então não existe uma classe "Pai"
			// que
			// eu possa guardar a variável caminhoUltimoArquivo, mas se você
			// está precisando utilizar o JFileChooser, obviamente tem uma(s)
			// janela(s) pai(s) para fazer esse controle.

			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			// caminhoUltimoArquivo =
			// diretorio.substring(0,diretorio.lastIndexOf("\\"));

			// estou fazendo um SubString, pegando esse caminho completo da
			// primeira letra até a ultima barra encontrada,
			// desta forma conseguimos pegar somente a pasta do arquivo
			// selecionado.

			labelFundoPainelMesas.setIcon(new javax.swing.ImageIcon(diretorio));
			caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~")
					.toString());
			System.out.print(diretorio);
		}
	}
}
