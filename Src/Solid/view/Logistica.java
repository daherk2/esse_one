package Solid.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import Solid.controller.LogisticaController;
import Solid.controller.Metodos;
import Solid.model.PPReport;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class Logistica extends JFrame {
	
	/**
	 * 
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 * @author Silvio Luiz
	 * @author Jhone Eleutério
	 * 
	 * 
	 */
	
	private static final long		serialVersionUID	= -1263139777540372610L;
	
	// instancia a classe do banco para conexão
	static BancoDados				x			= new BancoDados();
	
	// instancia a classe para impressao
	PPReport					report		= new PPReport();
	
	private JMenu				menuArquivo;
	private JMenu				menuConfiguracao;
	private JMenu				menuLogout;
	private JMenu				menuAjuda;
	private JMenuBar				menuBar;
	private JMenuItem				menu;
	private JMenuItem				sair;
	private JMenuItem				menuDefinirPapelParede;
	private JMenuItem				menuLogout2;
	private JMenuItem				menuAbrirAjuda;
	public static JTabbedPane		tabbedPane;
	public static JPanel			panelEntrega;
	public static JPanel			panelVeiculo, panelTransportadora;
	public static JTextField		licenciamento;
	public static JTextField		numeroChassi;
	public static JComboBox<String>	combustivel;
	public static JComboBox<String>	comboCategoria;
	public static JTextField		ipva;
	public static JTextField		kilometragem;
	public static JTextField		codigo;
	public static JTextField		modelo_1;
	public static JComboBox<String>	marca;
	public static JTextField		placa;
	public static JTextField		seguroObrigatorio;
	public static JTextField		numeroDocumento;
	public static JTextField		cor;
	public static JTextField		caminho;
	
	public static String			caminhoV, caminhoM;
	static NumberFormat			nf;
	public static JComboBox<String>	comboAnoFabricacao, comboCidade;
	static private JLabel			labelFundoEntregas;
	static private JLabel			labelFundoVeiculo;
	public static JLabel			labelFotoVeiculo;
	public static DefaultTableModel	modelo;
	static double				pv			= 0, precoUnidade, PrCusto = 0;
	private JButton				btSelecionarImagem;
	private JButton				btCancelar;
	public static JButton			btSalvar, buttonAtualizar1, btImprimir2;
	private JMenuItem				menuAbrirBatePapo;
	public static JPanel			panelMotorista;
	protected JLabel				labelPor;
	private static JLabel			labelFundoMotorista;
	private JButton				btnPesquisar2;
	private JButton				btnLimpar2;
	private JButton				btnPesquisar;
	public static JButton			btnLimpar, buttonAnterior;
	public static JTextField		NumeroRegistro;
	public static JTextField		Nome;
	public static JTextField		Nacionalidade;
	public static JTextField		Email;
	public static JFormattedTextField	Ctps;
	public static JTextField		NomePai;
	public static JTextField		Conta;
	private static JLabel			labelNomeMae;
	public static JTextField		NomeMae;
	private static JLabel			labelCelular1_1, label;
	public static JFormattedTextField	Celular1;
	public static JFormattedTextField	Celular2, telefone1;
	private static JLabel			labelCelular2_1;
	public static JTextField		Endereco;
	public static JTextField		Bairro;
	public static JTextField		Numero;
	public static JTextField		Complemento;
	public static JTextField		Salario;
	public static JTextField		razaoSocial;
	public static JTextField		anoFabricacao;
	public static JComboBox<String>	comboPor;
	public static JComboBox<String>	comboPor2, comboEscolaridade, comboUF;
	
	public static JComboBox<String>	comboContrato;
	private JRadioButton			radioConsultarVeiculo;
	protected JRadioButton			rdbtnConsultarMotorista;
	public static JFormattedTextField	Nascimento, celular1, celular2;
	private static JLabel			labelFundoTransportadora;
	public static JFormattedTextField	Rg;
	private static JLabel			labelFotoMotorista;
	public static JFormattedTextField	Cpf;
	public static JFormattedTextField	aquisicao;
	public static JRadioButton		rdbtnNacional;
	public static JRadioButton		rdbtnImportado;
	protected JRadioButton			rdbtnCadastrarMotorista;
	public static JFormattedTextField	Admissao;
	public static JFormattedTextField	Telefone1;
	public static JFormattedTextField	Telefone2;
	public static JFormattedTextField	Cep;
	public static JTextField		EstadoCivil;
	public static JTextField		ContratoPesq;
	public static JTextField		EscolaridadePesq;
	public static JTextField		BancoPesq;
	public static JTextField		UfPesq;
	public static JTextField		CidadePesq;
	public static JTextField		CargoPesq;
	public static JTextField		Departamento;
	private JButton				btnSelecionar;
	public static JButton			btImprimir;
	private JLabel				labelPor3;
	public static JComboBox<String>	comboPor3;
	public static JComboBox<String>	especie;
	public static JTextField		endereco;
	public static JTextField		bairro;
	public static JTextField		numero;
	public static JTextField		complemento;
	public static JComboBox<String>	tipo;
	private JLabel				Tipo;
	public static JTextField		tipoPesq;
	private JTextField			anoFabricacaoPesq;
	public static JTextField		combustivelPesq;
	public static JTextField		marcaPesq;
	public static JTextField		especiePesq;
	private static JButton			btExcluir;
	public static JButton			btAlterar;
	public static JButton			btnCancelar;
	public static JButton			btnAlterar, btnProximo;
	private JButton				btExcluir3;
	private JButton				btAlterar3;
	private JButton				btnExcluir2;
	private JButton				btnAlterar2;
	private static JButton			btnPesquisar_2;
	public static JComboBox<String>	cidade;
	public static JFormattedTextField	cep;
	public static JComboBox<String>	uf;
	public static JTextField		NumeroCnh;
	public static JFormattedTextField	DataVencimento, telefone2;
	public static JTextField		CategoriaPesq;
	private JRadioButton			radioCadastrar, radioConsultar;
	public static JButton			btPesquisar3, buttonAnterior1, buttonProximo1;
	public static JButton			btSalvar1, buttonSalvar2;
	public static JComboBox<String>	comboBanco;
	public static JComboBox<String>	comboCargo;
	public static String			Categoria		= null;
	public static JTextField		Cnpj;
	public static JTextField		InscricaoEstadual;
	public static JTextField		codigo1;
	private JLabel				label_13;
	private JLabel				label_20;
	private JTextField			agencia;
	private JLabel				label_21;
	private JLabel				label_23;
	private JLabel				label_25;
	private JLabel				label_26;
	private JSeparator			separator;
	private JPanel				panelRelatorios;
	private JMenuBar				menuBar_5;
	private JScrollPane			scrollPane;
	private JLabel				label_2;
	private JLabel				label_22;
	private JLabel				label_24;
	private JLabel				label_27;
	private JTable				table_1;
	private JLabel label_4;
	private JLabel label_12;
	private JLabel label_11;
	
	@SuppressWarnings("serial")
	public Logistica() {
		super();
		setResizable(false);
		// ----------------------------------------------------------------------------------------------------------------------------------------------------------------
		// Este try e catch é apenas para ficar mais "Bonitinho" a mensagem
		// com a resposta este código coloca o tema do i-mac
		try {
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			setIconImage(Toolkit
					.getDefaultToolkit()
					.getImage(Logistica.class
							.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			
			setTitle("LOGISTICA");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			getContentPane().setBackground(new Color(245, 245, 245));
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			@SuppressWarnings("unused")
			final Dimension scrnsize = toolkit.getScreenSize();
			
			BancoDados.conecta();
			
			nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			getContentPane().setLayout(null);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 1371, 32);
			getContentPane().add(menuBar);
			menuBar.setForeground(new Color(0, 0, 0));
			
			menuArquivo = new JMenu("Arquivo");
			menuArquivo.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
			menuArquivo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuArquivo);
			
			menu = new JMenuItem("Menu Principal");
			menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menu.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606621_678085-house-128.png")));
			menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int sair = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja sair?", "Fechamento de Programa",
							JOptionPane.YES_NO_OPTION);
					if (sair == 0) {
						// BD.desconecta();
						Logistica.this.dispose();
						new Menu();
					}
					UIManager.put("OptionPane.yesButtonText", "Sim");
					UIManager.put("OptionPane.noButtonText", "Não");
				}
			});
			menuArquivo.add(menu);
			
			sair = new JMenuItem("Sair");
			sair.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/desliga24px.png")));
			sair.setFont(new Font("Kalinga", Font.PLAIN, 14));
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Metodos.formWindowClosing(null);
				}
			});
			menuArquivo.add(sair);
			
			menuConfiguracao = new JMenu("Configura\u00E7\u00E3o");
			menuConfiguracao
					.setIcon(new ImageIcon(
							Logistica.class
									.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
			menuConfiguracao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuConfiguracao);
			
			menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
			menuDefinirPapelParede.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606663_image-128.png")));
			menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuDefinirPapelParede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Logistica.SelecionarPapelParedeLogistica();
				}
			});
			menuConfiguracao.add(menuDefinirPapelParede);
			
			menuAbrirBatePapo = new JMenuItem("Abrir Bate-Papo");
			menuAbrirBatePapo.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
			menuAbrirBatePapo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuAbrirBatePapo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// PPChat.main(null);
				}
			});
			menuConfiguracao.add(menuAbrirBatePapo);
			
			menuLogout = new JMenu("Logout");
			menuLogout.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
			menuLogout.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuLogout);
			
			menuLogout2 = new JMenuItem("Logout");
			menuLogout2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuLogout2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
			menuLogout2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logistica.this.dispose();
					new Login().setVisible(true);
				}
			});
			menuLogout.add(menuLogout2);
			
			menuAjuda = new JMenu("Ajuda");
			menuAjuda.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
			menuAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menuAjuda);
			
			menuAbrirAjuda = new JMenuItem("Abrir Ajuda");
			menuAbrirAjuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Ajuda ajuda = new Ajuda();
					// ajuda.contentPaneAjuda.setVisible(true);
				}
			});
			menuAbrirAjuda.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
			menuAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuAjuda.add(menuAbrirAjuda);
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Metodos.formWindowClosing(null);
					Logistica.this.dispose();
				}
			});
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Kalinga", Font.PLAIN, 13));
			tabbedPane.setBounds(0, 34, 1356, 695);
			getContentPane().add(tabbedPane);
			
			panelEntrega = new JPanel();
			panelEntrega.setBorder(null);
			panelEntrega.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelEntrega.setLayout(null);
			
			panelVeiculo = new JPanel();
			panelVeiculo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelVeiculo.setBorder(null);
			panelVeiculo.setLayout(null);
			
			comboAnoFabricacao = new JComboBox<String>();
			comboAnoFabricacao.setForeground(Color.BLACK);
			comboAnoFabricacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboAnoFabricacao.addItem("");
			comboAnoFabricacao.addItem("1986");
			comboAnoFabricacao.addItem("1987");
			comboAnoFabricacao.addItem("1988");
			comboAnoFabricacao.addItem("1989");
			comboAnoFabricacao.addItem("1990");
			comboAnoFabricacao.addItem("1991");
			comboAnoFabricacao.addItem("1992");
			comboAnoFabricacao.addItem("1993");
			comboAnoFabricacao.addItem("1994");
			comboAnoFabricacao.addItem("1995");
			comboAnoFabricacao.addItem("1996");
			comboAnoFabricacao.addItem("1997");
			comboAnoFabricacao.addItem("1998");
			comboAnoFabricacao.addItem("1999");
			comboAnoFabricacao.addItem("2000");
			comboAnoFabricacao.addItem("2001");
			comboAnoFabricacao.addItem("2002");
			comboAnoFabricacao.addItem("2003");
			comboAnoFabricacao.addItem("2004");
			comboAnoFabricacao.addItem("2005");
			comboAnoFabricacao.addItem("2006");
			comboAnoFabricacao.addItem("2007");
			comboAnoFabricacao.addItem("2008");
			comboAnoFabricacao.addItem("2009");
			comboAnoFabricacao.addItem("2010");
			comboAnoFabricacao.addItem("2011");
			comboAnoFabricacao.addItem("2012");
			comboAnoFabricacao.addItem("2013");
			comboAnoFabricacao.addItem("2014");
			comboAnoFabricacao.addItem("2015");
			comboAnoFabricacao.addItem("2016");
			comboAnoFabricacao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboAnoFabricacao.setEditable(false);
			comboAnoFabricacao.setBounds(208, 263, 120, 32);
			
			JRadioButton radioCadastrarVeiculo = new JRadioButton("Cadastrar Veiculo");
			radioCadastrarVeiculo.setForeground(Color.BLACK);
			radioCadastrarVeiculo.setMnemonic(KeyEvent.VK_6);
			radioCadastrarVeiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					radioConsultarVeiculo.setSelected(false);
					radioCadastrarVeiculo.setSelected(true);
					
					marcaPesq.setVisible(false);
					marca.setVisible(true);
					
					Logistica.SetarVeiculoEditavel();
					
					tipo.setVisible(true);
					
					btnPesquisar_2.setVisible(false);
					btSalvar.setVisible(true);
					
					especie.setVisible(true);
					combustivel.setVisible(true);
					combustivelPesq.setVisible(false);
					especiePesq.setVisible(false);
					
					label.setVisible(false);
					comboPor.setVisible(false);
				}
			});
			radioCadastrarVeiculo.setSelected(true);
			radioCadastrarVeiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			radioCadastrarVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
			radioCadastrarVeiculo.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioCadastrarVeiculo.setOpaque(false);
			radioCadastrarVeiculo.setBounds(496, 61, 173, 32);
			panelVeiculo.add(radioCadastrarVeiculo);
			
			radioConsultarVeiculo = new JRadioButton("Consultar Veiculo");
			radioConsultarVeiculo.setForeground(Color.BLACK);
			radioConsultarVeiculo.setMnemonic(KeyEvent.VK_7);
			radioConsultarVeiculo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					radioConsultarVeiculo.setSelected(true);
					radioCadastrarVeiculo.setSelected(false);
					
					Logistica.SetarVeiculoNaoEditavel();
					
					btnPesquisar_2.setVisible(true);
					btSalvar.setVisible(false);
					
					label.setVisible(true);
					comboPor.setVisible(true);
				}
			});
			radioConsultarVeiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			radioConsultarVeiculo.setOpaque(false);
			radioConsultarVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
			radioConsultarVeiculo.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioConsultarVeiculo.setBounds(682, 61, 173, 32);
			panelVeiculo.add(radioConsultarVeiculo);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboPor = new JComboBox<String>();
			comboPor.setForeground(Color.BLACK);
			comboPor.setVisible(false);
			comboPor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboPor.addItem("");
			comboPor.addItem("Codigo");
			comboPor.addItem("Modelo");
			comboPor.addItem("Placa");
			comboPor.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String tipoConsulta = item.toString();
					if (tipoConsulta.equals("Codigo")) {
						codigo.setEditable(true);
						codigo.setEnabled(true);
						codigo.setRequestFocusEnabled(true);
						codigo.setBorder(new LineBorder(Color.BLUE));
						codigo.requestFocus();
						
						modelo_1.setEditable(false);
						modelo_1.setEnabled(false);
						modelo_1.setBorder(null);
						
						placa.setEditable(false);
						placa.setEnabled(false);
						placa.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Modelo")) {
						codigo.setEditable(false);
						codigo.setEnabled(false);
						codigo.setBorder(null);
						
						modelo_1.setEditable(true);
						modelo_1.setEnabled(true);
						modelo_1.setRequestFocusEnabled(true);
						modelo_1.setBorder(new LineBorder(Color.BLUE));
						modelo_1.requestFocus();
						
						placa.setEditable(false);
						placa.setEnabled(false);
						placa.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Placa")) {
						codigo.setEditable(false);
						codigo.setEnabled(false);
						codigo.setBorder(null);
						
						modelo_1.setEditable(false);
						modelo_1.setEnabled(false);
						modelo_1.setBorder(null);
						
						placa.setEditable(true);
						placa.setEnabled(true);
						placa.setRequestFocusEnabled(true);
						placa.setBorder(new LineBorder(Color.BLUE));
						placa.requestFocus();
						
					}
					else if (tipoConsulta.equals("")) {
						codigo.setBorder(null);
						modelo_1.setBorder(null);
						placa.setBorder(null);
						
						codigo.setEditable(false);
						modelo_1.setEditable(false);
						placa.setEditable(false);
						
						codigo.setEnabled(false);
						modelo_1.setEnabled(false);
						placa.setEnabled(false);
					}
					
				}
			});
			comboPor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPor.setBounds(891, 61, 131, 32);
			panelVeiculo.add(comboPor);
			
			codigo = new JTextField();
			codigo.setForeground(Color.BLACK);
			codigo.setEnabled(false);
			codigo.setEditable(false);
			codigo.setSelectionColor(SystemColor.textHighlight);
			codigo.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			codigo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codigo.setHorizontalAlignment(SwingConstants.CENTER);
			codigo.setDisabledTextColor(Color.BLACK);
			codigo.setColumns(10);
			codigo.setBounds(25, 188, 173, 32);
			panelVeiculo.add(codigo);
			
			modelo_1 = new JTextField();
			modelo_1.setForeground(Color.BLACK);
			modelo_1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// modelo_1.setText(modelo_1.getText().replaceAll("[^0-9]",
					// ""));
					modelo_1.setText(modelo_1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			modelo_1.setDisabledTextColor(Color.BLACK);
			modelo_1.setSelectionColor(SystemColor.textHighlight);
			modelo_1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			modelo_1.setHorizontalAlignment(SwingConstants.CENTER);
			modelo_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			modelo_1.setColumns(10);
			modelo_1.setBounds(208, 188, 363, 32);
			panelVeiculo.add(modelo_1);
			
			numeroChassi = new JTextField();
			numeroChassi.setForeground(Color.BLACK);
			numeroChassi.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroChassi.setText(numeroChassi.getText().replaceAll("[^0-9]", ""));
					// numeroChassi.setText(numeroChassi.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroChassi.setDisabledTextColor(Color.BLACK);
			numeroChassi.setSelectionColor(SystemColor.textHighlight);
			numeroChassi.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			numeroChassi.setHorizontalAlignment(SwingConstants.CENTER);
			numeroChassi.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroChassi.setColumns(10);
			numeroChassi.setBounds(591, 188, 165, 32);
			panelVeiculo.add(numeroChassi);
			
			numeroDocumento = new JTextField();
			numeroDocumento.setForeground(Color.BLACK);
			numeroDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroDocumento.setText(numeroDocumento.getText().replaceAll(
							"[^0-9]", ""));
					// numeroDocumento.setText(numeroDocumento.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroDocumento.setDisabledTextColor(Color.BLACK);
			numeroDocumento.setSelectionColor(SystemColor.textHighlight);
			numeroDocumento.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			numeroDocumento.setHorizontalAlignment(SwingConstants.CENTER);
			numeroDocumento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroDocumento.setColumns(10);
			numeroDocumento.setBounds(766, 188, 187, 32);
			panelVeiculo.add(numeroDocumento);
			
			tipo = new JComboBox<String>();
			tipo.setForeground(Color.BLACK);
			tipo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String estado = item.toString();
					if (estado.equals("Moto")) {
						marca.removeAllItems();
						marca.addItem("");
						marca.addItem("BMW");
						marca.addItem("Dafra");
						marca.addItem("Harley-Davidson");
						marca.addItem("Honda");
						marca.addItem("Kasinski");
						marca.addItem("Kawasaki");
						marca.addItem("Suzuki");
						marca.addItem("Yamaha");
						
					}
					else if (estado.equals("Carro")) {
						marca.removeAllItems();
						marca.addItem("");
						marca.addItem("Agrale");
						marca.addItem("Aston Martin");
						marca.addItem("Audi");
						marca.addItem("Bentley");
						marca.addItem("BMW");
						marca.addItem("Changan");
						marca.addItem("Cherry");
						marca.addItem("Chevrolet");
						marca.addItem("Chrysler");
						marca.addItem("Citroën");
						marca.addItem("Dodge");
						marca.addItem("Ds");
						marca.addItem("Effa Motors");
						marca.addItem("Ferrari");
						marca.addItem("Fiat");
						marca.addItem("Ford");
						marca.addItem("Geely");
						marca.addItem("Honda");
						marca.addItem("Hyundai");
						marca.addItem("Iveco");
						marca.addItem("Jac");
						marca.addItem("Jaguar");
						marca.addItem("Jeep");
						marca.addItem("Jinbei");
						marca.addItem("Kia");
						marca.addItem("Lamborghini");
						marca.addItem("Land Rover");
						marca.addItem("Lexus");
						marca.addItem("Lifan");
						marca.addItem("Mahindra");
						marca.addItem("Maserati");
						marca.addItem("Mercedes-Benz");
						marca.addItem("Mini");
						marca.addItem("Mitsubishi");
						marca.addItem("Nissan");
						marca.addItem("Peugeot");
						marca.addItem("Porsche");
						marca.addItem("Ram");
						marca.addItem("Rely");
						marca.addItem("Renaut");
						marca.addItem("Rolls Royce");
						marca.addItem("Shineray");
						marca.addItem("Smart");
						marca.addItem("Ssangyoung");
						marca.addItem("Subaru");
						marca.addItem("Suzuki");
						marca.addItem("Tac");
						marca.addItem("Toyota");
						marca.addItem("Troller");
						marca.addItem("Volkswagen");
						marca.addItem("Volvo");
						
					}
					else if (estado.equals("Caminhão")) {
						marca.removeAllItems();
						marca.addItem("");
						marca.addItem("Fiat");
						marca.addItem("Ford");
						marca.addItem("Hafei");
						marca.addItem("Hyundai");
						marca.addItem("Iveco");
						marca.addItem("Jinbei");
						marca.addItem("Kia");
						marca.addItem("Mercedes-Benz");
						marca.addItem("Peugeot");
						marca.addItem("Renaut");
						marca.addItem("Scania");
						marca.addItem("Volkswagen");
						marca.addItem("Volvo");
						
					}
					else if (tipo.equals("")) {
						//
					}
				}
			});
			tipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tipo.addItem("");
			tipo.addItem("Moto");
			tipo.addItem("Carro");
			tipo.addItem("Caminhão");
			tipo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tipo.setBounds(965, 188, 165, 32);
			panelVeiculo.add(tipo);
			
			tipoPesq = new JTextField();
			tipoPesq.setForeground(Color.BLACK);
			tipoPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// tipoPesq.setText(tipoPesq.getText().replaceAll("[^0-9]",
					// ""));
					tipoPesq.setText(tipoPesq.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			tipoPesq.setDisabledTextColor(Color.BLACK);
			tipoPesq.setSelectionColor(SystemColor.textHighlight);
			tipoPesq.setHorizontalAlignment(SwingConstants.CENTER);
			tipoPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tipoPesq.setColumns(10);
			tipoPesq.setBounds(965, 188, 165, 32);
			panelVeiculo.add(tipoPesq);
			
			placa = new JTextField();
			placa.setForeground(Color.BLACK);
			placa.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// placa.setText(placa.getText().replaceAll("[^0-9]",
					// ""));
					// placa.setText(placa.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			placa.setDisabledTextColor(Color.BLACK);
			placa.setSelectionColor(SystemColor.textHighlight);
			placa.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			placa.setHorizontalAlignment(SwingConstants.CENTER);
			placa.setFont(new Font("Kalinga", Font.PLAIN, 14));
			placa.setColumns(10);
			placa.setBounds(25, 263, 173, 32);
			panelVeiculo.add(placa);
			panelVeiculo.add(comboAnoFabricacao);
			comboAnoFabricacao.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					// lblUnidade.setText(evt.getItem().toString());
				}
			});
			
			anoFabricacao = new JTextField();
			anoFabricacao.setForeground(Color.BLACK);
			anoFabricacao.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					anoFabricacao.setText(anoFabricacao.getText()
							.replaceAll("[^0-9]", ""));
					// anoFabricacao.setText(anoFabricacao.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			anoFabricacao.setDisabledTextColor(Color.BLACK);
			anoFabricacao.setSelectionColor(SystemColor.textHighlight);
			anoFabricacao.setHorizontalAlignment(SwingConstants.CENTER);
			anoFabricacao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			anoFabricacao.setColumns(10);
			anoFabricacao.setBounds(208, 263, 120, 32);
			panelVeiculo.add(anoFabricacao);
			
			anoFabricacaoPesq = new JTextField();
			anoFabricacaoPesq.setForeground(Color.BLACK);
			anoFabricacaoPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					anoFabricacaoPesq.setText(anoFabricacaoPesq.getText().replaceAll(
							"[^0-9]", ""));
					// anoFabricacaoPesq.setText(anoFabricacaoPesq.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			anoFabricacaoPesq.setDisabledTextColor(Color.BLACK);
			anoFabricacaoPesq.setSelectionColor(SystemColor.textHighlight);
			anoFabricacaoPesq.setHorizontalAlignment(SwingConstants.CENTER);
			anoFabricacaoPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			anoFabricacaoPesq.setColumns(10);
			anoFabricacaoPesq.setBounds(208, 263, 120, 32);
			panelVeiculo.add(anoFabricacaoPesq);
			
			licenciamento = new JTextField();
			licenciamento.setForeground(Color.BLACK);
			licenciamento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					licenciamento.setText(licenciamento.getText()
							.replaceAll("[^0-9]", ""));
					// licenciamento.setText(licenciamento.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			licenciamento.setDisabledTextColor(Color.BLACK);
			licenciamento.setSelectionColor(SystemColor.textHighlight);
			licenciamento.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			licenciamento.setHorizontalAlignment(SwingConstants.CENTER);
			licenciamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			licenciamento.setColumns(10);
			licenciamento.setBounds(338, 263, 109, 32);
			panelVeiculo.add(licenciamento);
			
			combustivel = new JComboBox<String>();
			combustivel.setForeground(Color.BLACK);
			combustivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			combustivel.addItem("");
			combustivel.addItem("Etanol");
			combustivel.addItem("Gasolina");
			combustivel.addItem("Flex");
			combustivel.addItem("Diesel");
			combustivel.addItem("Gás");
			combustivel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			combustivel.setBounds(457, 263, 300, 32);
			panelVeiculo.add(combustivel);
			
			combustivelPesq = new JTextField();
			combustivelPesq.setForeground(Color.BLACK);
			combustivelPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// combustivelPesq.setText(combustivelPesq.getText().replaceAll("[^0-9]",
					// ""));
					combustivelPesq.setText(combustivelPesq.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			combustivelPesq.setDisabledTextColor(Color.BLACK);
			combustivelPesq.setSelectionColor(SystemColor.textHighlight);
			combustivelPesq.setHorizontalAlignment(SwingConstants.CENTER);
			combustivelPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			combustivelPesq.setColumns(10);
			combustivelPesq.setBounds(457, 263, 299, 32);
			panelVeiculo.add(combustivelPesq);
			
			rdbtnNacional = new JRadioButton("Nacional");
			rdbtnNacional.setForeground(Color.BLACK);
			rdbtnNacional.setMnemonic(KeyEvent.VK_1);
			rdbtnNacional.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnNacional.setSelected(true);
					rdbtnImportado.setSelected(false);
					Categoria = "Nacional";
				}
			});
			rdbtnNacional.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnNacional.setFont(new Font("Kalinga", Font.BOLD, 14));
			rdbtnNacional.setOpaque(false);
			rdbtnNacional.setBounds(816, 263, 121, 32);
			panelVeiculo.add(rdbtnNacional);
			
			rdbtnImportado = new JRadioButton("Importado");
			rdbtnImportado.setForeground(Color.BLACK);
			rdbtnImportado.setMnemonic(KeyEvent.VK_2);
			rdbtnImportado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnNacional.setSelected(false);
					rdbtnImportado.setSelected(true);
					Categoria = "Importado";
				}
			});
			rdbtnImportado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rdbtnImportado.setFont(new Font("Kalinga", Font.BOLD, 14));
			rdbtnImportado.setOpaque(false);
			rdbtnImportado.setBounds(947, 263, 121, 32);
			panelVeiculo.add(rdbtnImportado);
			
			marca = new JComboBox<String>();
			marca.setForeground(Color.BLACK);
			marca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			marca.setFont(new Font("Kalinga", Font.PLAIN, 14));
			marca.setBounds(25, 340, 173, 32);
			panelVeiculo.add(marca);
			
			marcaPesq = new JTextField();
			marcaPesq.setForeground(Color.BLACK);
			marcaPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// marcaPesq.setText(marcaPesq.getText().replaceAll("[^0-9]",
					// ""));
					marcaPesq.setText(marcaPesq.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			marcaPesq.setDisabledTextColor(Color.BLACK);
			marcaPesq.setSelectionColor(SystemColor.textHighlight);
			marcaPesq.setHorizontalAlignment(SwingConstants.CENTER);
			marcaPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			marcaPesq.setColumns(10);
			marcaPesq.setBounds(25, 340, 173, 32);
			panelVeiculo.add(marcaPesq);
			
			kilometragem = new JTextField();
			kilometragem.setForeground(Color.BLACK);
			kilometragem.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					kilometragem.setText(kilometragem.getText().replaceAll("[^0-9]", ""));
					// kilometragem.setText(kilometragem.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			kilometragem.setDisabledTextColor(Color.BLACK);
			kilometragem.setSelectionColor(SystemColor.textHighlight);
			kilometragem.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			kilometragem.setHorizontalAlignment(SwingConstants.CENTER);
			kilometragem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			kilometragem.setColumns(10);
			kilometragem.setBounds(208, 340, 148, 32);
			panelVeiculo.add(kilometragem);
			
			cor = new JTextField();
			cor.setForeground(Color.BLACK);
			cor.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// cor.setText(cor.getText().replaceAll("[^0-9]",
					// ""));
					cor.setText(cor.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			cor.setDisabledTextColor(Color.BLACK);
			cor.setSelectionColor(SystemColor.textHighlight);
			cor.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			cor.setHorizontalAlignment(SwingConstants.CENTER);
			cor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cor.setColumns(10);
			cor.setBounds(368, 340, 272, 32);
			panelVeiculo.add(cor);
			
			especie = new JComboBox<String>();
			especie.setForeground(Color.BLACK);
			especie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			especie.addItem("");
			especie.addItem("Passeio");
			especie.addItem("Utilitario");
			especie.addItem("Carga");
			especie.setFont(new Font("Kalinga", Font.PLAIN, 14));
			especie.setBounds(658, 340, 148, 32);
			panelVeiculo.add(especie);
			
			especiePesq = new JTextField();
			especiePesq.setForeground(Color.BLACK);
			especiePesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// especiePesq.setText(especiePesq.getText().replaceAll("[^0-9]",
					// ""));
					especiePesq.setText(especiePesq.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			especiePesq.setDisabledTextColor(Color.BLACK);
			especiePesq.setSelectionColor(SystemColor.textHighlight);
			especiePesq.setHorizontalAlignment(SwingConstants.CENTER);
			especiePesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			especiePesq.setColumns(10);
			especiePesq.setBounds(658, 340, 148, 32);
			panelVeiculo.add(especiePesq);
			
			ipva = new JTextField();
			ipva.setForeground(Color.BLACK);
			ipva.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					ipva.setText(ipva.getText().replaceAll("[^0-9]", ""));
					// ipva.setText(ipva.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			ipva.setDisabledTextColor(Color.BLACK);
			ipva.setSelectionColor(SystemColor.textHighlight);
			ipva.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			ipva.setHorizontalAlignment(SwingConstants.CENTER);
			ipva.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ipva.setColumns(10);
			ipva.setBounds(827, 339, 144, 32);
			panelVeiculo.add(ipva);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			seguroObrigatorio = new JTextField();
			seguroObrigatorio.setForeground(Color.BLACK);
			seguroObrigatorio.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					seguroObrigatorio.setText(seguroObrigatorio.getText().replaceAll(
							"[^0-9]", ""));
					// seguroObrigatorio.setText(seguroObrigatorio.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			seguroObrigatorio.setDisabledTextColor(Color.BLACK);
			seguroObrigatorio.setSelectionColor(SystemColor.textHighlight);
			seguroObrigatorio.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			seguroObrigatorio.setHorizontalAlignment(SwingConstants.CENTER);
			seguroObrigatorio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			seguroObrigatorio.setColumns(10);
			seguroObrigatorio.setBounds(987, 340, 145, 32);
			panelVeiculo.add(seguroObrigatorio);
			
			aquisicao = new JFormattedTextField();
			aquisicao.setForeground(Color.BLACK);
			try {
				aquisicao.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			aquisicao.setDisabledTextColor(Color.BLACK);
			aquisicao.setSelectionColor(SystemColor.textHighlight);
			aquisicao.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			aquisicao.setHorizontalAlignment(SwingConstants.CENTER);
			aquisicao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			aquisicao.setColumns(10);
			aquisicao.setBounds(1144, 340, 145, 32);
			panelVeiculo.add(aquisicao);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			btSelecionarImagem = new JButton("Selecionar");
			btSelecionarImagem.setForeground(Color.BLACK);
			btSelecionarImagem.setMnemonic(KeyEvent.VK_F1);
			btSelecionarImagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btSelecionarImagem.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606663_image-128.png")));
			btSelecionarImagem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btSelecionarImagem.setBounds(1144, 267, 145, 35);
			panelVeiculo.add(btSelecionarImagem);
			btSelecionarImagem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Logistica.SelecionarFotoVeiculo();
				}
			});
			
			JMenuBar menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(176, 0, 999, 32);
			panelVeiculo.add(menuBar_1);
			
			btSalvar = new JButton("Salvar");
			btSalvar.setForeground(Color.BLACK);
			menuBar_1.add(btSalvar);
			btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogisticaController.SalvarVeiculo();
				}
			});
			
			btSalvar.setToolTipText("alt + Enter");
			btSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btSalvar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btSalvar.setMnemonic(KeyEvent.VK_ENTER);
			
			buttonAtualizar1 = new JButton("Salvar");
			buttonAtualizar1.setForeground(Color.BLACK);
			menuBar_1.add(buttonAtualizar1);
			buttonAtualizar1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.AtualizarVeiculo();
				}
			});
			buttonAtualizar1.setVisible(false);
			buttonAtualizar1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			buttonAtualizar1.setToolTipText("alt + Enter");
			buttonAtualizar1.setMnemonic(KeyEvent.VK_ENTER);
			buttonAtualizar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnPesquisar_2 = new JButton("Pesquisar");
			btnPesquisar_2.setForeground(Color.BLACK);
			menuBar_1.add(btnPesquisar_2);
			btnPesquisar_2.setVisible(false);
			btnPesquisar_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.ConsultarVeiculo();
				}
			});
			btnPesquisar_2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			btnPesquisar_2.setToolTipText("alt + P");
			btnPesquisar_2.setMnemonic(KeyEvent.VK_ENTER);
			btnPesquisar_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btExcluir = new JButton("Cancelar");
			btExcluir.setForeground(Color.BLACK);
			menuBar_1.add(btExcluir);
			btExcluir.setVisible(false);
			btExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logistica.SetarVeiculoNaoEditavel();
					btImprimir2.setVisible(false);
					buttonAtualizar1.setVisible(false);
				}
			});
			btExcluir.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btExcluir.setMnemonic(KeyEvent.VK_CANCEL);
			btExcluir.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btExcluir.setAlignmentX(0.5f);
			
			btCancelar = new JButton("Limpar");
			btCancelar.setForeground(Color.BLACK);
			menuBar_1.add(btCancelar);
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logistica.SetarVeiculoNaoEditavel();
					Logistica.limpaDados();
					buttonAtualizar1.setVisible(false);
					btImprimir2.setVisible(false);
				}
			});
			btCancelar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btCancelar.setToolTipText("alt + Backspace");
			btCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			// btCancelar.setIcon(new
			// ImageIcon(Logistica.class.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btCancelar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			
			btAlterar = new JButton("Alterar");
			btAlterar.setForeground(Color.BLACK);
			menuBar_1.add(btAlterar);
			btAlterar.setVisible(false);
			btAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Logistica.SetarVeiculoEditavel();
					buttonAtualizar1.setVisible(true);
					btExcluir.setVisible(true);
					tipo.setVisible(true);
					tipo.setSelectedItem(tipoPesq.getText());
					combustivel.setVisible(true);
					combustivel.setSelectedItem(combustivelPesq.getText());
					marca.setVisible(true);
					marca.setSelectedItem(marcaPesq.getText());
					especie.setVisible(true);
					especie.setSelectedItem(especiePesq.getText());
				}
			});
			btAlterar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			btAlterar.setMnemonic(KeyEvent.VK_SPACE);
			btAlterar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAlterar.setFocusTraversalPolicyProvider(true);
			btAlterar.setFocusCycleRoot(true);
			btAlterar.setAlignmentX(0.5f);
			
			btImprimir2 = new JButton("Imprimir");
			btImprimir2.setForeground(Color.BLACK);
			menuBar_1.add(btImprimir2);
			btImprimir2.setVisible(false);
			btImprimir2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btImprimir2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					report.Veiculos();
				}
			});
			btImprimir2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			btImprimir2.setToolTipText("alt + P");
			btImprimir2.setMnemonic(KeyEvent.VK_P);
			btImprimir2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			buttonAnterior1 = new JButton("Anterior");
			buttonAnterior1.setForeground(Color.BLACK);
			menuBar_1.add(buttonAnterior1);
			buttonAnterior1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.PesquisarVeiculoAnterior();
				}
			});
			buttonAnterior1.setVisible(false);
			buttonAnterior1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			buttonAnterior1.setToolTipText("alt + Enter");
			buttonAnterior1.setMnemonic(KeyEvent.VK_LEFT);
			buttonAnterior1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			buttonProximo1 = new JButton("Próximo");
			buttonProximo1.setForeground(Color.BLACK);
			menuBar_1.add(buttonProximo1);
			buttonProximo1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					LogisticaController.PesquisarVeiculoProximo();
				}
			});
			buttonProximo1.setVisible(false);
			buttonProximo1.setHorizontalTextPosition(SwingConstants.LEFT);
			buttonProximo1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			buttonProximo1.setToolTipText("alt + Enter");
			buttonProximo1.setMnemonic(KeyEvent.VK_RIGHT);
			buttonProximo1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JLabel labelLicenciamento = new JLabel("Licenciamento");
			labelLicenciamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelLicenciamento.setForeground(Color.BLACK);
			labelLicenciamento.setBounds(338, 231, 109, 32);
			panelVeiculo.add(labelLicenciamento);
			
			JLabel labelNumeroChassi = new JLabel("Nº Chassi");
			labelNumeroChassi.setForeground(Color.BLACK);
			labelNumeroChassi.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroChassi.setBounds(591, 156, 80, 32);
			panelVeiculo.add(labelNumeroChassi);
			
			JLabel labelFornecedor = new JLabel("Combustivel");
			labelFornecedor.setForeground(Color.BLACK);
			labelFornecedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelFornecedor.setBounds(457, 230, 120, 32);
			panelVeiculo.add(labelFornecedor);
			
			JLabel labelTelefone2 = new JLabel("IPVA");
			labelTelefone2.setForeground(Color.BLACK);
			labelTelefone2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone2.setBounds(827, 309, 104, 32);
			panelVeiculo.add(labelTelefone2);
			
			JLabel labelCnpj = new JLabel("Kilometragem");
			labelCnpj.setForeground(Color.BLACK);
			labelCnpj.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCnpj.setBounds(208, 309, 148, 32);
			panelVeiculo.add(labelCnpj);
			
			JLabel labelCodigo = new JLabel("Codigo");
			labelCodigo.setForeground(Color.BLACK);
			labelCodigo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCodigo.setBounds(25, 156, 80, 32);
			panelVeiculo.add(labelCodigo);
			
			JLabel labelModelo = new JLabel("Modelo");
			labelModelo.setForeground(Color.BLACK);
			labelModelo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelModelo.setBounds(208, 156, 76, 32);
			panelVeiculo.add(labelModelo);
			
			JLabel labelMarca = new JLabel("Marca");
			labelMarca.setForeground(Color.BLACK);
			labelMarca.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelMarca.setBounds(25, 308, 64, 32);
			panelVeiculo.add(labelMarca);
			
			JLabel labelPlaca = new JLabel("Placa");
			labelPlaca.setForeground(Color.BLACK);
			labelPlaca.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelPlaca.setBounds(25, 231, 76, 32);
			panelVeiculo.add(labelPlaca);
			
			JLabel labelCelular1 = new JLabel("Seguro Obrigatorio");
			labelCelular1.setForeground(Color.BLACK);
			labelCelular1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCelular1.setBounds(988, 309, 143, 32);
			panelVeiculo.add(labelCelular1);
			
			JLabel labelAnoFabricacao = new JLabel("Ano Fabricacao");
			labelAnoFabricacao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelAnoFabricacao.setForeground(Color.BLACK);
			labelAnoFabricacao.setBounds(208, 231, 120, 32);
			panelVeiculo.add(labelAnoFabricacao);
			
			JLabel labelNumeroDocumento = new JLabel("Nº Documento");
			labelNumeroDocumento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroDocumento.setForeground(Color.BLACK);
			labelNumeroDocumento.setBounds(766, 156, 146, 32);
			panelVeiculo.add(labelNumeroDocumento);
			
			JLabel labelVendedor = new JLabel("Cor");
			labelVendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelVendedor.setForeground(Color.BLACK);
			labelVendedor.setBounds(368, 310, 94, 32);
			panelVeiculo.add(labelVendedor);
			
			labelFotoVeiculo = new JLabel("(165x115)");
			labelFotoVeiculo.setForeground(Color.BLACK);
			labelFotoVeiculo.setFont(new Font("Khmer UI", Font.PLAIN, 14));
			// labelFotoVeiculo.setIcon(new
			// ImageIcon(Logistica.class.getResource("/icones1_48px/1425606804_pic-128.png")));
			labelFotoVeiculo.setOpaque(true);
			labelFotoVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoVeiculo.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoVeiculo.setBackground(Color.WHITE);
			labelFotoVeiculo.setBounds(1144, 168, 145, 95);
			panelVeiculo.add(labelFotoVeiculo);
			
			JLabel lblAquisio = new JLabel("Aquisição");
			lblAquisio.setForeground(Color.BLACK);
			lblAquisio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblAquisio.setBounds(1145, 309, 143, 32);
			panelVeiculo.add(lblAquisio);
			
			label = new JLabel("Por");
			label.setForeground(Color.BLACK);
			label.setVisible(false);
			label.setFont(new Font("Kalinga", Font.BOLD, 14));
			label.setBounds(861, 61, 38, 32);
			panelVeiculo.add(label);
			
			JLabel lblEspecie = new JLabel("Especie");
			lblEspecie.setForeground(Color.BLACK);
			lblEspecie.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblEspecie.setBounds(658, 309, 148, 32);
			panelVeiculo.add(lblEspecie);
			
			Tipo = new JLabel("Tipo");
			Tipo.setForeground(Color.BLACK);
			Tipo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Tipo.setBounds(965, 156, 146, 32);
			panelVeiculo.add(Tipo);
			
			label_23 = new JLabel("");
			label_23.setForeground(Color.BLACK);
			label_23.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_23.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DO VEICULO", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_23.setBounds(10, 137, 1341, 250);
			panelVeiculo.add(label_23);
			
			label_4 = new JLabel("");
			label_4.setForeground(Color.BLACK);
			label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_4.setBounds(10, 43, 1325, 69);
			panelVeiculo.add(label_4);
			labelFundoVeiculo = new JLabel("");
			labelFundoVeiculo.setForeground(Color.BLACK);
			labelFundoVeiculo.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoVeiculo.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoVeiculo.setIcon(new ImageIcon(Logistica.class
					.getResource("/papel_parede/05.jpg")));
			labelFundoVeiculo.setVerticalAlignment(SwingConstants.TOP);
			labelFundoVeiculo.setBounds(0, 0, 1360, 665);
			panelVeiculo.add(labelFundoVeiculo);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			panelMotorista = new JPanel();
			panelMotorista.setLayout(null);
			panelMotorista.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelMotorista.setBorder(null);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboPor2 = new JComboBox<String>();
			comboPor2.setForeground(Color.BLACK);
			comboPor2.setVisible(false);
			comboPor2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboPor2.addItem("");
			comboPor2.addItem("Nº de Registro");
			comboPor2.addItem("Nome");
			comboPor2.addItem("CPF");
			comboPor2.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String tipoConsulta = item.toString();
					if (tipoConsulta.equals("Nº de Registro")) {
						NumeroRegistro.setEditable(true);
						NumeroRegistro.setEnabled(true);
						NumeroRegistro.setRequestFocusEnabled(true);
						NumeroRegistro.setBorder(new LineBorder(Color.BLUE));
						NumeroRegistro.requestFocus();
						
						Nome.setEditable(false);
						Nome.setEnabled(false);
						Nome.setBorder(null);
						
						Cpf.setEditable(false);
						Cpf.setEnabled(false);
						Cpf.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Nome")) {
						NumeroRegistro.setEditable(false);
						NumeroRegistro.setEnabled(false);
						NumeroRegistro.setBorder(null);
						
						Nome.setEditable(true);
						Nome.setEnabled(true);
						Nome.setRequestFocusEnabled(true);
						Nome.setBorder(new LineBorder(Color.BLUE));
						
						Cpf.setEditable(false);
						Cpf.setEnabled(false);
						Cpf.setBorder(null);
						
					}
					else if (tipoConsulta.equals("CPF")) {
						NumeroRegistro.setEditable(false);
						NumeroRegistro.setEnabled(false);
						NumeroRegistro.setBorder(null);
						
						Nome.setEditable(false);
						Nome.setEnabled(false);
						Nome.setBorder(null);
						
						Cpf.setEditable(true);
						Cpf.setEnabled(true);
						Cpf.setRequestFocusEnabled(true);
						Cpf.setBorder(new LineBorder(Color.BLUE));
						
					}
					else if (tipoConsulta.equals("")) {
						NumeroRegistro.setBorder(null);
						Nome.setBorder(null);
						Cpf.setBorder(null);
						
						NumeroRegistro.setEditable(false);
						Nome.setEditable(false);
						Cpf.setEditable(false);
						
						NumeroRegistro.setEnabled(false);
						Nome.setEnabled(false);
						Cpf.setEnabled(false);
					}
					
				}
			});
			comboPor2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPor2.setBounds(913, 61, 131, 32);
			panelMotorista.add(comboPor2);
			
			NumeroRegistro = new JTextField();
			NumeroRegistro.setForeground(Color.BLACK);
			NumeroRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					NumeroRegistro.setText(NumeroRegistro.getText().replaceAll("[^0-9]",
							""));
					// NumeroRegistro.setText(NumeroRegistro.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			NumeroRegistro.setEnabled(false);
			NumeroRegistro.setSelectionColor(SystemColor.textHighlight);
			NumeroRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			NumeroRegistro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumeroRegistro.setDisabledTextColor(Color.BLACK);
			NumeroRegistro.setColumns(10);
			NumeroRegistro.setBounds(30, 158, 173, 32);
			panelMotorista.add(NumeroRegistro);
			
			Nome = new JTextField();
			Nome.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Nome.setText(Nome.getText().replaceAll("[^0-9]",
					// ""));
					Nome.setText(Nome.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Nome.setDisabledTextColor(Color.BLACK);
			Nome.setSelectionColor(SystemColor.textHighlight);
			Nome.setHorizontalAlignment(SwingConstants.CENTER);
			Nome.setForeground(Color.BLACK);
			Nome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nome.setColumns(10);
			Nome.setBounds(214, 158, 380, 32);
			panelMotorista.add(Nome);
			
			Nascimento = new JFormattedTextField((Object) null);
			try {
				Nascimento.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Nascimento.setDisabledTextColor(Color.BLACK);
			Nascimento.setSelectionColor(SystemColor.textHighlight);
			Nascimento.setHorizontalAlignment(SwingConstants.CENTER);
			Nascimento.setForeground(Color.BLACK);
			Nascimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nascimento.setColumns(10);
			Nascimento.setBounds(606, 158, 121, 32);
			panelMotorista.add(Nascimento);
			
			Nacionalidade = new JTextField();
			Nacionalidade.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Nacionalidade.setText(Nacionalidade.getText().replaceAll("[^0-9]",
					// ""));
					Nacionalidade.setText(Nacionalidade.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			Nacionalidade.setDisabledTextColor(Color.BLACK);
			Nacionalidade.setSelectionColor(SystemColor.textHighlight);
			Nacionalidade.setHorizontalAlignment(SwingConstants.CENTER);
			Nacionalidade.setForeground(Color.BLACK);
			Nacionalidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nacionalidade.setColumns(10);
			Nacionalidade.setBounds(30, 223, 173, 32);
			panelMotorista.add(Nacionalidade);
			
			Email = new JTextField();
			Email.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Email.setText(Email.getText().replaceAll("[^0-9]",
					// ""));
					// Email.setText(Email.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Email.setDisabledTextColor(Color.BLACK);
			Email.setSelectionColor(SystemColor.textHighlight);
			Email.setHorizontalAlignment(SwingConstants.CENTER);
			Email.setForeground(Color.BLACK);
			Email.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Email.setColumns(10);
			Email.setBounds(181, 282, 376, 32);
			panelMotorista.add(Email);
			
			Rg = new JFormattedTextField((Object) null);
			Rg.setDisabledTextColor(Color.BLACK);
			Rg.setSelectionColor(SystemColor.textHighlight);
			Rg.setHorizontalAlignment(SwingConstants.CENTER);
			Rg.setForeground(Color.BLACK);
			Rg.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Rg.setColumns(10);
			Rg.setBounds(214, 223, 173, 32);
			panelMotorista.add(Rg);
			
			Cpf = new JFormattedTextField();
			Cpf.setDisabledTextColor(Color.BLACK);
			Cpf.setSelectionColor(SystemColor.textHighlight);
			Cpf.setHorizontalAlignment(SwingConstants.CENTER);
			Cpf.setForeground(Color.BLACK);
			Cpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cpf.setColumns(10);
			Cpf.setBounds(397, 223, 160, 32);
			panelMotorista.add(Cpf);
			
			Ctps = new JFormattedTextField();
			Ctps.setForeground(Color.BLACK);
			Ctps.setDisabledTextColor(Color.BLACK);
			Ctps.setSelectionColor(SystemColor.textHighlight);
			Ctps.setHorizontalAlignment(SwingConstants.CENTER);
			Ctps.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Ctps.setColumns(10);
			Ctps.setBounds(567, 223, 160, 32);
			panelMotorista.add(Ctps);
			
			EstadoCivil = new JTextField();
			EstadoCivil.setForeground(Color.BLACK);
			EstadoCivil.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// EstadoCivil.setText(EstadoCivil.getText().replaceAll("[^0-9]",
					// ""));
					EstadoCivil.setText(EstadoCivil.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			EstadoCivil.setDisabledTextColor(Color.BLACK);
			EstadoCivil.setSelectionColor(SystemColor.textHighlight);
			EstadoCivil.setHorizontalAlignment(SwingConstants.CENTER);
			EstadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			EstadoCivil.setBounds(567, 282, 160, 32);
			panelMotorista.add(EstadoCivil);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			Admissao = new JFormattedTextField((Object) null);
			Admissao.setDisabledTextColor(Color.BLACK);
			Admissao.setSelectionColor(SystemColor.textHighlight);
			Admissao.setHorizontalAlignment(SwingConstants.CENTER);
			Admissao.setForeground(Color.BLACK);
			Admissao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Admissao.setColumns(10);
			Admissao.setBounds(937, 178, 82, 32);
			panelMotorista.add(Admissao);
			
			comboContrato = new JComboBox<String>();
			comboContrato.setForeground(Color.BLACK);
			comboContrato.setBounds(1029, 178, 127, 32);
			panelMotorista.add(comboContrato);
			comboContrato.addItem("");
			comboContrato.addItem("Temporário");
			comboContrato.addItem("Efetivo");
			comboContrato.addItem("Terceirizado");
			comboContrato.addItem("Experiencia");
			
			ContratoPesq = new JTextField();
			ContratoPesq.setForeground(Color.BLACK);
			ContratoPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// ContratoPesq.setText(ContratoPesq.getText().replaceAll("[^0-9]",
					// ""));
					ContratoPesq.setText(ContratoPesq.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			ContratoPesq.setEnabled(false);
			ContratoPesq.setVisible(false);
			ContratoPesq.setDisabledTextColor(Color.BLACK);
			ContratoPesq.setSelectionColor(SystemColor.textHighlight);
			ContratoPesq.setHorizontalAlignment(SwingConstants.CENTER);
			ContratoPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ContratoPesq.setBounds(1029, 178, 127, 32);
			panelMotorista.add(ContratoPesq);
			
			comboEscolaridade = new JComboBox<String>();
			comboEscolaridade.setForeground(Color.BLACK);
			comboEscolaridade.setBounds(30, 282, 141, 32);
			panelMotorista.add(comboEscolaridade);
			comboEscolaridade.addItem("");
			comboEscolaridade.addItem("1º Grau incompleto");
			comboEscolaridade.addItem("1º Grau completo");
			comboEscolaridade.addItem("2º Grau incompleto");
			comboEscolaridade.addItem("2º Grau completo");
			comboEscolaridade.addItem("Superior incompleto");
			comboEscolaridade.addItem("Superior completo");
			
			EscolaridadePesq = new JTextField();
			EscolaridadePesq.setForeground(Color.BLACK);
			EscolaridadePesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// EscolaridadePesq.setText(EscolaridadePesq.getText().replaceAll("[^0-9]",
					// ""));
					EscolaridadePesq.setText(EscolaridadePesq.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			EscolaridadePesq.setEnabled(false);
			EscolaridadePesq.setVisible(false);
			EscolaridadePesq.setDisabledTextColor(Color.BLACK);
			EscolaridadePesq.setSelectionColor(SystemColor.textHighlight);
			EscolaridadePesq.setHorizontalAlignment(SwingConstants.CENTER);
			EscolaridadePesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			EscolaridadePesq.setBounds(30, 282, 141, 32);
			panelMotorista.add(EscolaridadePesq);
			
			NomePai = new JTextField();
			NomePai.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// NomePai.setText(NomePai.getText().replaceAll("[^0-9]",
					// ""));
					NomePai.setText(NomePai.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			NomePai.setDisabledTextColor(Color.BLACK);
			NomePai.setSelectionColor(SystemColor.textHighlight);
			NomePai.setHorizontalAlignment(SwingConstants.CENTER);
			NomePai.setForeground(Color.BLACK);
			NomePai.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NomePai.setColumns(10);
			NomePai.setBounds(30, 352, 409, 32);
			panelMotorista.add(NomePai);
			
			NomeMae = new JTextField();
			NomeMae.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// NomeMae.setText(NomeMae.getText().replaceAll("[^0-9]",
					// ""));
					NomeMae.setText(NomeMae.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			NomeMae.setDisabledTextColor(Color.BLACK);
			NomeMae.setSelectionColor(SystemColor.textHighlight);
			NomeMae.setHorizontalAlignment(SwingConstants.CENTER);
			NomeMae.setForeground(Color.BLACK);
			NomeMae.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NomeMae.setColumns(10);
			NomeMae.setBounds(449, 352, 409, 32);
			panelMotorista.add(NomeMae);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboBanco = new JComboBox<String>();
			comboBanco.setForeground(Color.BLACK);
			comboBanco.setBounds(755, 450, 127, 32);
			panelMotorista.add(comboBanco);
			comboBanco.addItem("");
			comboBanco.addItem("Banco do Brasil");
			comboBanco.addItem("Bradesco");
			comboBanco.addItem("Caixa Economica");
			comboBanco.addItem("HSBC");
			comboBanco.addItem("Itaú");
			comboBanco.addItem("Santander");
			comboBanco.addItem("Bancoob");
			comboBanco.addItem("Banestes");
			comboBanco.addItem("Banpara");
			comboBanco.addItem("Banrisul");
			comboBanco.addItem("BCN");
			comboBanco.addItem("Bank Boston");
			comboBanco.addItem("Banco Brasilia");
			comboBanco.addItem("Banco do Nordeste");
			comboBanco.addItem("Citibank");
			comboBanco.addItem("Credisan");
			comboBanco.addItem("Nossa Caixa");
			comboBanco.addItem("Mercantil do Brasil");
			comboBanco.addItem("Real");
			comboBanco.addItem("Safra");
			comboBanco.addItem("Sicredi");
			comboBanco.addItem("Sudameris");
			comboBanco.addItem("Unibanco");
			comboBanco.addItem("Viacredi");
			comboBanco.addItem("Sicoob");
			comboBanco.addItem("Outro Banco...");
			
			BancoPesq = new JTextField();
			BancoPesq.setForeground(Color.BLACK);
			BancoPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// BancoPesq.setText(BancoPesq.getText().replaceAll("[^0-9]",
					// ""));
					BancoPesq.setText(BancoPesq.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			BancoPesq.setEnabled(false);
			BancoPesq.setDisabledTextColor(Color.BLACK);
			BancoPesq.setSelectionColor(SystemColor.textHighlight);
			BancoPesq.setHorizontalAlignment(SwingConstants.CENTER);
			BancoPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			BancoPesq.setBounds(755, 451, 127, 32);
			panelMotorista.add(BancoPesq);
			
			Conta = new JTextField();
			Conta.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Conta.setText(Conta.getText().replaceAll("[^0-9]", ""));
					// Conta.setText(Conta.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Conta.setDisabledTextColor(Color.BLACK);
			Conta.setSelectionColor(SystemColor.textHighlight);
			Conta.setHorizontalAlignment(SwingConstants.CENTER);
			Conta.setForeground(Color.BLACK);
			Conta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Conta.setColumns(10);
			Conta.setBounds(755, 512, 129, 32);
			panelMotorista.add(Conta);
			
			Telefone1 = new JFormattedTextField((Object) null);
			Telefone1.setDisabledTextColor(Color.BLACK);
			try {
				Telefone1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			
			agencia = new JTextField();
			agencia.setSelectionColor(SystemColor.textHighlight);
			agencia.setHorizontalAlignment(SwingConstants.CENTER);
			agencia.setForeground(Color.BLACK);
			agencia.setFont(new Font("Kalinga", Font.PLAIN, 14));
			agencia.setDisabledTextColor(Color.BLACK);
			agencia.setColumns(10);
			agencia.setBounds(755, 575, 129, 32);
			panelMotorista.add(agencia);
			Telefone1.setSelectionColor(SystemColor.textHighlight);
			Telefone1.setHorizontalAlignment(SwingConstants.CENTER);
			Telefone1.setForeground(Color.BLACK);
			Telefone1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Telefone1.setColumns(10);
			Telefone1.setBounds(27, 601, 129, 32);
			panelMotorista.add(Telefone1);
			
			Telefone2 = new JFormattedTextField((Object) null);
			Telefone2.setDisabledTextColor(Color.BLACK);
			try {
				Telefone2.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Telefone2.setSelectionColor(SystemColor.textHighlight);
			Telefone2.setHorizontalAlignment(SwingConstants.CENTER);
			Telefone2.setForeground(Color.BLACK);
			Telefone2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Telefone2.setColumns(10);
			Telefone2.setBounds(178, 599, 129, 32);
			panelMotorista.add(Telefone2);
			
			Celular1 = new JFormattedTextField((Object) null);
			Celular1.setDisabledTextColor(Color.BLACK);
			try {
				Celular1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)#####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Celular1.setSelectionColor(SystemColor.textHighlight);
			Celular1.setHorizontalAlignment(SwingConstants.CENTER);
			Celular1.setForeground(Color.BLACK);
			Celular1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Celular1.setColumns(10);
			Celular1.setBounds(456, 599, 129, 32);
			panelMotorista.add(Celular1);
			
			Celular2 = new JFormattedTextField((Object) null);
			Celular2.setDisabledTextColor(Color.BLACK);
			try {
				Celular2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)#####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Celular2.setSelectionColor(SystemColor.textHighlight);
			Celular2.setHorizontalAlignment(SwingConstants.CENTER);
			Celular2.setForeground(Color.BLACK);
			Celular2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Celular2.setColumns(10);
			Celular2.setBounds(317, 599, 129, 32);
			panelMotorista.add(Celular2);
			
			Endereco = new JTextField();
			Endereco.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Endereco.setText(Endereco.getText().replaceAll("[^0-9]",
					// ""));
					Endereco.setText(Endereco.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Endereco.setDisabledTextColor(Color.BLACK);
			Endereco.setSelectionColor(SystemColor.textHighlight);
			Endereco.setHorizontalAlignment(SwingConstants.CENTER);
			Endereco.setForeground(Color.BLACK);
			Endereco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Endereco.setColumns(10);
			Endereco.setBounds(30, 455, 379, 32);
			panelMotorista.add(Endereco);
			
			Bairro = new JTextField();
			Bairro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Bairro.setText(Bairro.getText().replaceAll("[^0-9]",
					// ""));
					Bairro.setText(Bairro.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Bairro.setDisabledTextColor(Color.BLACK);
			Bairro.setSelectionColor(SystemColor.textHighlight);
			Bairro.setHorizontalAlignment(SwingConstants.CENTER);
			Bairro.setForeground(Color.BLACK);
			Bairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Bairro.setColumns(10);
			Bairro.setBounds(493, 455, 165, 32);
			panelMotorista.add(Bairro);
			
			Numero = new JTextField();
			Numero.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Numero.setText(Numero.getText().replaceAll("[^0-9]", ""));
					// Numero.setText(Numero.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Numero.setDisabledTextColor(Color.BLACK);
			Numero.setSelectionColor(SystemColor.textHighlight);
			Numero.setHorizontalAlignment(SwingConstants.CENTER);
			Numero.setForeground(Color.BLACK);
			Numero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Numero.setColumns(10);
			Numero.setBounds(419, 455, 64, 32);
			panelMotorista.add(Numero);
			
			Complemento = new JTextField();
			Complemento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Complemento.setText(Complemento.getText().replaceAll("[^0-9]",
					// ""));
					Complemento.setText(Complemento.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			Complemento.setDisabledTextColor(Color.BLACK);
			Complemento.setSelectionColor(SystemColor.textHighlight);
			Complemento.setHorizontalAlignment(SwingConstants.CENTER);
			Complemento.setForeground(Color.BLACK);
			Complemento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Complemento.setColumns(10);
			Complemento.setBounds(493, 530, 203, 32);
			panelMotorista.add(Complemento);
			
			Cep = new JFormattedTextField((Object) null);
			try {
				Cep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Cep.setDisabledTextColor(Color.BLACK);
			Cep.setSelectionColor(SystemColor.textHighlight);
			Cep.setHorizontalAlignment(SwingConstants.CENTER);
			Cep.setForeground(Color.BLACK);
			Cep.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cep.setColumns(10);
			Cep.setBounds(30, 530, 170, 32);
			panelMotorista.add(Cep);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboUF = new JComboBox<String>();
			comboUF.setForeground(Color.BLACK);
			comboUF.setBounds(212, 530, 64, 32);
			panelMotorista.add(comboUF);
			String sql = "select * from tb_estados";
			ResultSet rs = x.Consultar(sql);
			try {
				
				comboUF.addItem("");
				while (rs.next()) {
					comboUF.addItem(rs.getString("uf"));
				}
				
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			comboUF.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String estado = item.toString();
					try {
						comboCidade.removeAllItems();
						String sql = "select * from tb_cidades where uf = '" + estado
								+ "'";
						ResultSet rs1 = x.Consultar(sql);
						comboCidade.addItem("");
						while (rs1.next()) {
							comboCidade.addItem(rs1.getString("nome"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			
			UfPesq = new JTextField();
			UfPesq.setForeground(Color.BLACK);
			UfPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// UfPesq.setText(UfPesq.getText().replaceAll("[^0-9]",
					// ""));
					UfPesq.setText(UfPesq.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			UfPesq.setVisible(false);
			UfPesq.setDisabledTextColor(Color.BLACK);
			UfPesq.setSelectionColor(SystemColor.textHighlight);
			UfPesq.setHorizontalAlignment(SwingConstants.CENTER);
			UfPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			UfPesq.setBounds(214, 532, 64, 32);
			panelMotorista.add(UfPesq);
			
			comboCidade = new JComboBox<String>();
			comboCidade.setForeground(Color.BLACK);
			comboCidade.setBounds(286, 530, 183, 32);
			panelMotorista.add(comboCidade);
			
			CidadePesq = new JTextField();
			CidadePesq.setForeground(Color.BLACK);
			CidadePesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// CidadePesq.setText(CidadePesq.getText().replaceAll("[^0-9]",
					// ""));
					CidadePesq.setText(CidadePesq.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			CidadePesq.setVisible(false);
			CidadePesq.setDisabledTextColor(Color.BLACK);
			CidadePesq.setSelectionColor(SystemColor.textHighlight);
			CidadePesq.setHorizontalAlignment(SwingConstants.CENTER);
			CidadePesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			CidadePesq.setBounds(290, 532, 181, 32);
			panelMotorista.add(CidadePesq);
			
			CargoPesq = new JTextField();
			CargoPesq.setForeground(Color.BLACK);
			CargoPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// CargoPesq.setText(CargoPesq.getText().replaceAll("[^0-9]",
					// ""));
					CargoPesq.setText(CargoPesq.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			CargoPesq.setEnabled(false);
			CargoPesq.setVisible(false);
			
			comboCargo = new JComboBox<String>();
			comboCargo.setForeground(Color.BLACK);
			comboCargo.setBounds(937, 260, 181, 32);
			panelMotorista.add(comboCargo);
			comboCargo.addItem("");
			comboCargo.addItem("Entregador");
			comboCargo.addItem("Motorista");
			comboCargo.addItem("Controlador de Estoque");
			comboCargo.addItem("Programador");
			
			CargoPesq.setDisabledTextColor(Color.BLACK);
			CargoPesq.setSelectionColor(SystemColor.textHighlight);
			CargoPesq.setHorizontalAlignment(SwingConstants.CENTER);
			CargoPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			CargoPesq.setBounds(937, 261, 181, 32);
			panelMotorista.add(CargoPesq);
			
			Salario = new JTextField();
			Salario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Salario.setText(Salario.getText().replaceAll("[^0-9]", ""));
					// Salario.setText(Salario.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Salario.setSelectionColor(SystemColor.textHighlight);
			Salario.setHorizontalAlignment(SwingConstants.CENTER);
			Salario.setForeground(Color.BLACK);
			Salario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Salario.setDisabledTextColor(Color.BLACK);
			Salario.setColumns(10);
			Salario.setBounds(1128, 260, 197, 32);
			panelMotorista.add(Salario);
			
			Departamento = new JTextField();
			Departamento.setForeground(Color.BLACK);
			Departamento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Departamento.setText(Departamento.getText().replaceAll("[^0-9]",
					// ""));
					Departamento.setText(Departamento.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			Departamento.setText("Logistica");
			Departamento.setEnabled(false);
			Departamento.setDisabledTextColor(Color.BLACK);
			Departamento.setSelectionColor(SystemColor.textHighlight);
			Departamento.setHorizontalAlignment(SwingConstants.CENTER);
			Departamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Departamento.setBounds(1166, 178, 159, 32);
			panelMotorista.add(Departamento);
			
			btnSelecionar = new JButton("Selecionar");
			btnSelecionar.setForeground(Color.BLACK);
			btnSelecionar.setMnemonic(KeyEvent.VK_F1);
			btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSelecionar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Logistica.SelecionarFotoMotorista();
				}
			});
			
			NumeroCnh = new JTextField();
			NumeroCnh.setForeground(Color.BLACK);
			NumeroCnh.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					NumeroCnh.setText(NumeroCnh.getText().replaceAll("[^0-9]", ""));
					// NumeroCnh.setText(NumeroCnh.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			NumeroCnh.setDisabledTextColor(Color.BLACK);
			NumeroCnh.setSelectionColor(SystemColor.textHighlight);
			NumeroCnh.setHorizontalAlignment(SwingConstants.CENTER);
			NumeroCnh.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumeroCnh.setBounds(937, 432, 181, 32);
			panelMotorista.add(NumeroCnh);
			
			DataVencimento = new JFormattedTextField();
			try {
				DataVencimento.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			DataVencimento.setSelectionColor(SystemColor.textHighlight);
			DataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
			DataVencimento.setForeground(Color.BLACK);
			DataVencimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			DataVencimento.setDisabledTextColor(Color.BLACK);
			DataVencimento.setColumns(10);
			DataVencimento.setBounds(1125, 434, 152, 32);
			panelMotorista.add(DataVencimento);
			
			CategoriaPesq = new JTextField();
			CategoriaPesq.setForeground(Color.BLACK);
			CategoriaPesq.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// CategoriaPesq.setText(CategoriaPesq.getText().replaceAll("[^0-9]",
					// ""));
					CategoriaPesq.setText(CategoriaPesq.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			CategoriaPesq.setEnabled(false);
			CategoriaPesq.setDisabledTextColor(Color.BLACK);
			CategoriaPesq.setVisible(false);
			
			comboCategoria = new JComboBox<String>();
			comboCategoria.setForeground(Color.BLACK);
			comboCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboCategoria.setBounds(937, 498, 181, 32);
			panelMotorista.add(comboCategoria);
			comboCategoria.addItem("");
			comboCategoria.addItem("Categoria A");
			comboCategoria.addItem("Categoria B");
			comboCategoria.addItem("Categoria C");
			comboCategoria.addItem("Categoria D");
			
			CategoriaPesq.setSelectionColor(SystemColor.textHighlight);
			CategoriaPesq.setHorizontalAlignment(SwingConstants.CENTER);
			CategoriaPesq.setFont(new Font("Kalinga", Font.PLAIN, 14));
			CategoriaPesq.setBounds(937, 499, 181, 32);
			panelMotorista.add(CategoriaPesq);
			
			btnSelecionar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606755_camera-alt-128.png")));
			btnSelecionar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnSelecionar.setBounds(751, 257, 145, 35);
			panelMotorista.add(btnSelecionar);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.setForeground(Color.BLACK);
			rdbtnCadastrarMotorista = new JRadioButton("Cadastrar Motorista");
			rdbtnCadastrarMotorista.setForeground(Color.BLACK);
			rdbtnCadastrarMotorista.setMnemonic(KeyEvent.VK_6);
			rdbtnCadastrarMotorista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelPor.setVisible(false);
					comboPor2.setVisible(false);
					
					rdbtnCadastrarMotorista.setSelected(true);
					rdbtnConsultarMotorista.setSelected(false);
					
					Logistica.SetarEditavel();
					
					comboCategoria.setVisible(true);
					CategoriaPesq.setVisible(false);
					
					btnPesquisar.setVisible(false);
					btnSalvar.setVisible(true);
					
					comboBanco.setVisible(true);
					BancoPesq.setVisible(false);
					comboContrato.setVisible(true);
					ContratoPesq.setVisible(false);
					comboEscolaridade.setVisible(true);
					EscolaridadePesq.setVisible(false);
					comboCargo.setVisible(true);
					CargoPesq.setVisible(false);
					comboUF.setVisible(true);
					UfPesq.setVisible(false);
					comboCidade.setVisible(true);
					CidadePesq.setVisible(false);
				}
			});
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			JMenuBar menuBar_2 = new JMenuBar();
			menuBar_2.setBounds(175, 0, 1000, 32);
			panelMotorista.add(menuBar_2);
			
			menuBar_2.add(btnSalvar);
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogisticaController.SalvarFuncionario();
				}
			});
			btnSalvar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnSalvar.setMnemonic(KeyEvent.VK_ENTER);
			btnSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnSalvar.setFocusTraversalPolicyProvider(true);
			btnSalvar.setFocusCycleRoot(true);
			btnSalvar.setAlignmentX(0.5f);
			
			buttonSalvar2 = new JButton("Salvar");
			buttonSalvar2.setForeground(Color.BLACK);
			menuBar_2.add(buttonSalvar2);
			buttonSalvar2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.AtualizarFuncionario();
					comboContrato.setVisible(false);
					comboEscolaridade.setVisible(false);
					comboBanco.setVisible(false);
					comboCargo.setVisible(false);
					comboUF.setVisible(false);
					comboCidade.setVisible(false);
					comboContrato.setVisible(false);
					comboCategoria.setVisible(false);
				}
			});
			buttonSalvar2.setVisible(false);
			buttonSalvar2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			buttonSalvar2.setMnemonic(KeyEvent.VK_ENTER);
			buttonSalvar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			buttonSalvar2.setFocusTraversalPolicyProvider(true);
			buttonSalvar2.setFocusCycleRoot(true);
			buttonSalvar2.setAlignmentX(0.5f);
			
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setForeground(Color.BLACK);
			menuBar_2.add(btnPesquisar);
			btnPesquisar.setVisible(false);
			btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPesquisar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					LogisticaController.PesquisarFuncionario();
				}
			});
			
			btnPesquisar.setToolTipText("alt + Enter");
			btnPesquisar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			btnPesquisar.setMnemonic(KeyEvent.VK_ENTER);
			btnPesquisar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			menuBar_2.add(btnCancelar);
			btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logistica.SetarEditavelFalso();
					comboContrato.setVisible(false);
					comboEscolaridade.setVisible(false);
					comboBanco.setVisible(false);
					comboCargo.setVisible(false);
					comboUF.setVisible(false);
					comboCidade.setVisible(false);
					comboContrato.setVisible(false);
					comboCategoria.setVisible(false);
					buttonSalvar2.setVisible(false);
				}
			});
			btnCancelar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar.setAlignmentX(0.5f);
			
			btnLimpar = new JButton("Limpar");
			btnLimpar.setForeground(Color.BLACK);
			menuBar_2.add(btnLimpar);
			btnLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogisticaController.LimparFuncionario();
					buttonSalvar2.setVisible(false);
				}
			});
			btnLimpar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLimpar.setToolTipText("alt + Backspace");
			btnLimpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btnLimpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAlterar = new JButton("Alterar");
			btnAlterar.setForeground(Color.BLACK);
			menuBar_2.add(btnAlterar);
			btnAlterar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Logistica.SetarEditavel();
					comboUF.setVisible(true);
					comboUF.setSelectedItem(UfPesq.getText());
					comboContrato.setVisible(true);
					comboContrato.setSelectedItem(ContratoPesq.getText());
					comboEscolaridade.setVisible(true);
					comboEscolaridade.setSelectedItem(EscolaridadePesq.getText());
					comboBanco.setVisible(true);
					comboBanco.setSelectedItem(BancoPesq.getText());
					comboCargo.setVisible(true);
					comboCargo.setSelectedItem(CargoPesq.getText());
					comboCategoria.setVisible(true);
					comboCategoria.setSelectedItem(CategoriaPesq.getText());
					btnCancelar.setVisible(true);
					buttonSalvar2.setVisible(true);
					comboCidade.setVisible(true);
					comboCidade.setSelectedItem(CidadePesq.getText());
				}
			});
			btnAlterar.setVisible(false);
			btnAlterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAlterar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			btnAlterar.setMnemonic(KeyEvent.VK_SPACE);
			btnAlterar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAlterar.setFocusTraversalPolicyProvider(true);
			btnAlterar.setFocusCycleRoot(true);
			btnAlterar.setAlignmentX(0.5f);
			
			btImprimir = new JButton("Imprimir");
			btImprimir.setForeground(Color.BLACK);
			menuBar_2.add(btImprimir);
			btImprimir.setVisible(false);
			btImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					report.Motorista();
				}
			});
			btImprimir.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			btImprimir.setToolTipText("alt + P");
			btImprimir.setMnemonic(KeyEvent.VK_P);
			btImprimir.setFont(new Font("Kalinga", Font.PLAIN, 14));
			buttonAnterior = new JButton("Anterior");
			buttonAnterior.setForeground(Color.BLACK);
			menuBar_2.add(buttonAnterior);
			buttonAnterior.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.PesquisarFuncionarioAnterior();
				}
			});
			buttonAnterior.setVisible(false);
			buttonAnterior.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			buttonAnterior.setMnemonic(KeyEvent.VK_LEFT);
			buttonAnterior.setFont(new Font("Kalinga", Font.PLAIN, 14));
			buttonAnterior.setFocusTraversalPolicyProvider(true);
			buttonAnterior.setFocusCycleRoot(true);
			buttonAnterior.setAlignmentX(0.5f);
			
			btnProximo = new JButton("Proximo");
			btnProximo.setForeground(Color.BLACK);
			menuBar_2.add(btnProximo);
			btnProximo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					LogisticaController.PesquisarFuncionarioProximo();
				}
			});
			btnProximo.setVisible(false);
			btnProximo.setHorizontalTextPosition(SwingConstants.LEFT);
			btnProximo.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnProximo.setMnemonic(KeyEvent.VK_RIGHT);
			btnProximo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnProximo.setFocusTraversalPolicyProvider(true);
			btnProximo.setFocusCycleRoot(true);
			btnProximo.setAlignmentX(0.5f);
			
			rdbtnCadastrarMotorista.setSelected(true);
			rdbtnCadastrarMotorista.setOpaque(false);
			rdbtnCadastrarMotorista.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnCadastrarMotorista.setFont(new Font("Khmer UI", Font.BOLD, 14));
			rdbtnCadastrarMotorista.setBounds(503, 61, 173, 32);
			panelMotorista.add(rdbtnCadastrarMotorista);
			
			rdbtnConsultarMotorista = new JRadioButton("Consultar Motorista");
			rdbtnConsultarMotorista.setForeground(Color.BLACK);
			rdbtnConsultarMotorista.setMnemonic(KeyEvent.VK_7);
			rdbtnConsultarMotorista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					labelPor.setVisible(true);
					comboPor2.setVisible(true);
					
					rdbtnCadastrarMotorista.setSelected(false);
					rdbtnConsultarMotorista.setSelected(true);
					
					comboCategoria.setVisible(false);
					CategoriaPesq.setVisible(true);
					
					Logistica.SetarEditavelFalso();
					
					CategoriaPesq.setVisible(true);
					CategoriaPesq.setEnabled(false);
					CategoriaPesq.setEditable(false);
					
					comboCategoria.setVisible(false);
					
					btnPesquisar.setVisible(true);
					btnSalvar.setVisible(false);
					
					comboBanco.setVisible(false);
					BancoPesq.setVisible(true);
					comboContrato.setVisible(false);
					ContratoPesq.setVisible(true);
					comboEscolaridade.setVisible(false);
					EscolaridadePesq.setVisible(true);
					comboCargo.setVisible(false);
					CargoPesq.setVisible(true);
					comboUF.setVisible(false);
					UfPesq.setVisible(true);
					comboCidade.setVisible(false);
					CidadePesq.setVisible(true);
				}
			});
			
			rdbtnConsultarMotorista.setOpaque(false);
			rdbtnConsultarMotorista.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtnConsultarMotorista.setFont(new Font("Khmer UI", Font.BOLD, 14));
			rdbtnConsultarMotorista.setBounds(689, 61, 173, 32);
			panelMotorista.add(rdbtnConsultarMotorista);
			JLabel labelNumeroRegistro = new JLabel("Nº De Registro");
			labelNumeroRegistro.setForeground(Color.BLACK);
			labelNumeroRegistro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroRegistro.setBounds(30, 126, 113, 32);
			panelMotorista.add(labelNumeroRegistro);
			
			JLabel labelNome = new JLabel("Nome");
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNome.setBounds(214, 126, 49, 32);
			panelMotorista.add(labelNome);
			
			JLabel labelNascimento = new JLabel("Nascimento");
			labelNascimento.setForeground(Color.BLACK);
			labelNascimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNascimento.setBounds(606, 129, 92, 26);
			panelMotorista.add(labelNascimento);
			
			JLabel labelNacionalidade = new JLabel("Nacionalidade");
			labelNacionalidade.setForeground(Color.BLACK);
			labelNacionalidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNacionalidade.setBounds(30, 191, 104, 32);
			panelMotorista.add(labelNacionalidade);
			
			JLabel labelEmail = new JLabel("E-mail");
			labelEmail.setForeground(Color.BLACK);
			labelEmail.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEmail.setBounds(181, 249, 54, 32);
			panelMotorista.add(labelEmail);
			
			JLabel labelEscolaridade = new JLabel("Escolaridade");
			labelEscolaridade.setForeground(Color.BLACK);
			labelEscolaridade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEscolaridade.setBounds(30, 252, 104, 32);
			panelMotorista.add(labelEscolaridade);
			
			JLabel labelContrato = new JLabel("Contrato");
			labelContrato.setForeground(Color.BLACK);
			labelContrato.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelContrato.setBounds(1031, 146, 69, 32);
			panelMotorista.add(labelContrato);
			
			JLabel labelAdmissao = new JLabel("Admissão");
			labelAdmissao.setForeground(Color.BLACK);
			labelAdmissao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelAdmissao.setBounds(937, 146, 80, 32);
			panelMotorista.add(labelAdmissao);
			
			JLabel labelEstadoCivil = new JLabel("Estado Civil");
			labelEstadoCivil.setForeground(Color.BLACK);
			labelEstadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEstadoCivil.setBounds(567, 252, 92, 32);
			panelMotorista.add(labelEstadoCivil);
			
			JLabel labelCtps = new JLabel("CTPS");
			labelCtps.setForeground(Color.BLACK);
			labelCtps.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCtps.setBounds(567, 193, 41, 32);
			panelMotorista.add(labelCtps);
			
			JLabel labelCpf = new JLabel("CPF");
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCpf.setBounds(397, 193, 41, 32);
			panelMotorista.add(labelCpf);
			
			JLabel labelRg = new JLabel("RG");
			labelRg.setForeground(Color.BLACK);
			labelRg.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelRg.setBounds(214, 193, 41, 32);
			panelMotorista.add(labelRg);
			
			JLabel labelNomePai = new JLabel("Nome do Pai");
			labelNomePai.setForeground(Color.BLACK);
			labelNomePai.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNomePai.setBounds(30, 319, 104, 32);
			panelMotorista.add(labelNomePai);
			
			JLabel labelTelefone1_1 = new JLabel("Telefone1");
			labelTelefone1_1.setForeground(Color.BLACK);
			labelTelefone1_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone1_1.setBounds(27, 564, 69, 32);
			panelMotorista.add(labelTelefone1_1);
			
			JLabel labelTelefone2_1 = new JLabel("Telefone 2");
			labelTelefone2_1.setForeground(Color.BLACK);
			labelTelefone2_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone2_1.setBounds(166, 564, 80, 32);
			panelMotorista.add(labelTelefone2_1);
			
			JLabel labelBanco = new JLabel("Banco");
			labelBanco.setForeground(Color.BLACK);
			labelBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelBanco.setBounds(755, 422, 54, 32);
			panelMotorista.add(labelBanco);
			
			JLabel labelConta = new JLabel("Conta");
			labelConta.setForeground(Color.BLACK);
			labelConta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelConta.setBounds(755, 484, 49, 26);
			panelMotorista.add(labelConta);
			
			labelNomeMae = new JLabel("Nome da Mãe");
			labelNomeMae.setForeground(Color.BLACK);
			labelNomeMae.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNomeMae.setBounds(449, 319, 104, 32);
			panelMotorista.add(labelNomeMae);
			
			labelCelular1_1 = new JLabel("Celular 1");
			labelCelular1_1.setForeground(Color.BLACK);
			labelCelular1_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCelular1_1.setBounds(444, 566, 69, 32);
			panelMotorista.add(labelCelular1_1);
			
			labelCelular2_1 = new JLabel("Celular 2");
			labelCelular2_1.setForeground(Color.BLACK);
			labelCelular2_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCelular2_1.setBounds(307, 568, 80, 32);
			panelMotorista.add(labelCelular2_1);
			
			JLabel labelEndereco_1 = new JLabel("Endereço");
			labelEndereco_1.setForeground(Color.BLACK);
			labelEndereco_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEndereco_1.setBounds(30, 423, 100, 32);
			panelMotorista.add(labelEndereco_1);
			
			JLabel labelBairro = new JLabel("Bairro");
			labelBairro.setForeground(Color.BLACK);
			labelBairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelBairro.setBounds(493, 423, 80, 32);
			panelMotorista.add(labelBairro);
			
			JLabel labelNumero = new JLabel("Número");
			labelNumero.setForeground(Color.BLACK);
			labelNumero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumero.setBounds(419, 423, 64, 32);
			panelMotorista.add(labelNumero);
			
			JLabel labelComplemento = new JLabel("Complemento");
			labelComplemento.setForeground(Color.BLACK);
			labelComplemento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelComplemento.setBounds(493, 498, 104, 32);
			panelMotorista.add(labelComplemento);
			
			JLabel labelCep = new JLabel("CEP");
			labelCep.setForeground(Color.BLACK);
			labelCep.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCep.setBounds(30, 498, 41, 32);
			panelMotorista.add(labelCep);
			
			JLabel labelUf = new JLabel("UF");
			labelUf.setForeground(Color.BLACK);
			labelUf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelUf.setBounds(212, 498, 49, 32);
			panelMotorista.add(labelUf);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			JLabel labelCidade = new JLabel("Cidade");
			labelCidade.setForeground(Color.BLACK);
			labelCidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCidade.setBounds(288, 498, 49, 32);
			panelMotorista.add(labelCidade);
			
			JLabel labelCargo = new JLabel("Cargo");
			labelCargo.setForeground(Color.BLACK);
			labelCargo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCargo.setBounds(937, 228, 94, 32);
			panelMotorista.add(labelCargo);
			
			JLabel labelSalario = new JLabel("Salário");
			labelSalario.setForeground(Color.BLACK);
			labelSalario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelSalario.setBounds(1128, 228, 94, 32);
			panelMotorista.add(labelSalario);
			
			JLabel labelDepartamento = new JLabel("Departamento");
			labelDepartamento.setForeground(Color.BLACK);
			labelDepartamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelDepartamento.setBounds(1166, 146, 129, 32);
			panelMotorista.add(labelDepartamento);
			
			labelFotoMotorista = new JLabel("(165x115)");
			labelFotoMotorista.setForeground(Color.BLACK);
			labelFotoMotorista.setFont(new Font("Khmer UI", Font.PLAIN, 14));
			labelFotoMotorista.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_48px/1425606663_image-128.png")));
			// labelFotoMotorista.setIcon(new
			// ImageIcon(Logistica.class.getResource("/icones1_48px/1425606804_pic-128.png")));
			labelFotoMotorista.setOpaque(true);
			labelFotoMotorista.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoMotorista.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoMotorista.setBackground(Color.WHITE);
			labelFotoMotorista.setBounds(751, 158, 145, 95);
			panelMotorista.add(labelFotoMotorista);
			
			labelPor = new JLabel("Por");
			labelPor.setForeground(Color.BLACK);
			labelPor.setVisible(false);
			labelPor.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelPor.setBounds(881, 61, 38, 32);
			panelMotorista.add(labelPor);
			
			JLabel lblNmeroCnh = new JLabel("N\u00FAmero CNH");
			lblNmeroCnh.setForeground(Color.BLACK);
			lblNmeroCnh.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNmeroCnh.setBounds(937, 400, 94, 32);
			panelMotorista.add(lblNmeroCnh);
			
			JLabel lblDataVencimento = new JLabel("Data Vencimento");
			lblDataVencimento.setForeground(Color.BLACK);
			lblDataVencimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDataVencimento.setBounds(1125, 402, 145, 32);
			panelMotorista.add(lblDataVencimento);
			
			JLabel lblCategoria = new JLabel("Categoria");
			lblCategoria.setForeground(Color.BLACK);
			lblCategoria.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCategoria.setBounds(937, 466, 129, 32);
			panelMotorista.add(lblCategoria);
			
			JLabel lblAgncia = new JLabel("Agência");
			lblAgncia.setForeground(Color.BLACK);
			lblAgncia.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblAgncia.setBounds(755, 547, 64, 26);
			panelMotorista.add(lblAgncia);
			
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(948, 352, 377, 2);
			panelMotorista.add(separator);
			
			JLabel label_2_1 = new JLabel("");
			label_2_1.setForeground(Color.BLACK);
			label_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS PESSOAIS", TitledBorder.LEFT, TitledBorder.TOP, null,
					Color.DARK_GRAY));
			label_2_1.setBounds(10, 111, 900, 282);
			panelMotorista.add(label_2_1);
			
			label_13 = new JLabel("");
			label_13.setForeground(Color.BLACK);
			label_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_13.setBounds(10, 401, 717, 246);
			panelMotorista.add(label_13);
			
			label_20 = new JLabel("");
			label_20.setForeground(Color.BLACK);
			label_20.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_20.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS BANC\u00C1RIOS", TitledBorder.LEFT, TitledBorder.TOP,
					null, new Color(64, 64, 64)));
			label_20.setBounds(727, 401, 183, 244);
			panelMotorista.add(label_20);
			
			label_21 = new JLabel("");
			label_21.setForeground(Color.BLACK);
			label_21.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_21.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DA FUN\u00C7\u00C3O", TitledBorder.LEFT,
					TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_21.setBounds(921, 111, 430, 536);
			panelMotorista.add(label_21);
			
			label_12 = new JLabel("");
			label_12.setForeground(Color.BLACK);
			label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_12.setBounds(10, 43, 1325, 69);
			panelMotorista.add(label_12);
			
			labelFundoMotorista = new JLabel("");
			labelFundoMotorista.setForeground(Color.BLACK);
			labelFundoMotorista.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoMotorista.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoMotorista.setIcon(new ImageIcon(Logistica.class
					.getResource("/papel_parede/05.jpg")));
			labelFundoMotorista.setVerticalAlignment(SwingConstants.TOP);
			labelFundoMotorista.setBounds(0, 0, 1361, 665);
			panelMotorista.add(labelFundoMotorista);
			
			/*
			 * panels com Ã­cones
			 */
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			panelTransportadora = new JPanel();
			panelTransportadora.setToolTipText(null);
			panelTransportadora.setLayout(null);
			panelTransportadora.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelTransportadora.setBorder(null);
			
			radioCadastrar = new JRadioButton("Cadastrar Transportadora");
			radioCadastrar.setMnemonic(KeyEvent.VK_6);
			radioCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					radioCadastrar.setSelected(true);
					radioConsultar.setSelected(false);
					razaoSocial.setVisible(true);
					btSalvar1.setVisible(true);
					btPesquisar3.setVisible(false);
					labelPor3.setVisible(false);
					comboPor3.setVisible(false);
				}
			});
			radioCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioCadastrar.setSelected(true);
			radioCadastrar.setOpaque(false);
			radioCadastrar.setForeground(Color.BLACK);
			radioCadastrar.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioCadastrar.setAlignmentX(0.5f);
			radioCadastrar.setBounds(474, 61, 213, 32);
			panelTransportadora.add(radioCadastrar);
			
			radioConsultar = new JRadioButton("Consultar Transportadora");
			radioConsultar.setMnemonic(KeyEvent.VK_7);
			radioConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					radioCadastrar.setSelected(false);
					radioConsultar.setSelected(true);
					razaoSocial.setVisible(false);
					labelPor3.setVisible(true);
					comboPor3.setVisible(true);
					btSalvar1.setVisible(false);
					btPesquisar3.setVisible(true);
				}
			});
			radioConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioConsultar.setOpaque(false);
			radioConsultar.setForeground(Color.BLACK);
			radioConsultar.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioConsultar.setAlignmentX(0.5f);
			radioConsultar.setBounds(694, 61, 213, 32);
			panelTransportadora.add(radioConsultar);
			
			comboPor3 = new JComboBox<String>();
			comboPor3.setForeground(Color.BLACK);
			comboPor3.setVisible(false);
			comboPor3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboPor3.addItem("");
			comboPor3.addItem("Codigo");
			comboPor3.addItem("Razão Social");
			comboPor3.addItem("CNPJ");
			comboPor3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String tipoConsulta = item.toString();
					if (tipoConsulta.equals("Codigo")) {
						codigo1.requestFocus();
						codigo1.setEnabled(true);
						codigo1.setEditable(true);
						codigo1.setBorder(new LineBorder(Color.BLUE));
						
					}
					else if (tipoConsulta.equals("Razão Social")) {
						
						razaoSocial.setBorder(null);
						
					}
					else if (tipoConsulta.equals("CNPJ")) {
						
					}
				}
			});
			comboPor3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPor3.setBounds(948, 61, 131, 32);
			panelTransportadora.add(comboPor3);
			
			codigo1 = new JTextField();
			codigo1.setForeground(Color.BLACK);
			codigo1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					codigo1.setText(codigo1.getText().replaceAll("[^0-9]", ""));
					// codigo1.setText(codigo1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			codigo1.setSelectionColor(SystemColor.textHighlight);
			codigo1.setHorizontalAlignment(SwingConstants.CENTER);
			codigo1.setFont(new Font("Kalinga", Font.BOLD, 15));
			codigo1.setEnabled(false);
			codigo1.setEditable(false);
			codigo1.setDisabledTextColor(Color.BLACK);
			codigo1.setColumns(10);
			codigo1.setBounds(46, 191, 173, 32);
			panelTransportadora.add(codigo1);
			
			razaoSocial = new JTextField();
			razaoSocial.setSelectionColor(SystemColor.textHighlight);
			razaoSocial.setForeground(Color.BLACK);
			razaoSocial.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// razaoSocial.setText(razaoSocial.getText().replaceAll("[^0-9]",
					// ""));
					razaoSocial.setText(razaoSocial.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			razaoSocial.setHorizontalAlignment(SwingConstants.CENTER);
			razaoSocial.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			razaoSocial.setFont(new Font("Kalinga", Font.PLAIN, 14));
			razaoSocial.setBounds(229, 191, 401, 32);
			panelTransportadora.add(razaoSocial);
			
			endereco = new JTextField();
			endereco.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// endereco.setText(endereco.getText().replaceAll("[^0-9]",
					// ""));
					endereco.setText(endereco.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			endereco.setDisabledTextColor(Color.BLACK);
			endereco.setSelectionColor(SystemColor.textHighlight);
			endereco.setHorizontalAlignment(SwingConstants.CENTER);
			endereco.setForeground(Color.BLACK);
			endereco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			endereco.setColumns(10);
			endereco.setBounds(54, 323, 379, 32);
			panelTransportadora.add(endereco);
			
			bairro = new JTextField();
			bairro.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// bairro.setText(bairro.getText().replaceAll("[^0-9]",
					// ""));
					bairro.setText(bairro.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			bairro.setDisabledTextColor(Color.BLACK);
			bairro.setSelectionColor(SystemColor.textHighlight);
			bairro.setHorizontalAlignment(SwingConstants.CENTER);
			bairro.setForeground(Color.BLACK);
			bairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			bairro.setColumns(10);
			bairro.setBounds(443, 323, 165, 32);
			panelTransportadora.add(bairro);
			
			numero = new JTextField();
			numero.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numero.setText(numero.getText().replaceAll("[^0-9]", ""));
					// numero.setText(numero.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numero.setDisabledTextColor(Color.BLACK);
			numero.setSelectionColor(SystemColor.textHighlight);
			numero.setHorizontalAlignment(SwingConstants.CENTER);
			numero.setForeground(Color.BLACK);
			numero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numero.setColumns(10);
			numero.setBounds(618, 323, 72, 32);
			panelTransportadora.add(numero);
			
			complemento = new JTextField();
			complemento.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// complemento.setText(complemento.getText().replaceAll("[^0-9]",
					// ""));
					complemento.setText(complemento.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			complemento.setDisabledTextColor(Color.BLACK);
			complemento.setSelectionColor(SystemColor.textHighlight);
			complemento.setHorizontalAlignment(SwingConstants.CENTER);
			complemento.setForeground(Color.BLACK);
			complemento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			complemento.setColumns(10);
			complemento.setBounds(54, 392, 203, 32);
			panelTransportadora.add(complemento);
			
			cep = new JFormattedTextField((Object) null);
			try {
				cep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"#####-###")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			cep.setDisabledTextColor(Color.BLACK);
			cep.setSelectionColor(SystemColor.textHighlight);
			cep.setHorizontalAlignment(SwingConstants.CENTER);
			cep.setForeground(Color.BLACK);
			cep.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cep.setColumns(10);
			cep.setBounds(267, 392, 170, 32);
			panelTransportadora.add(cep);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			uf = new JComboBox<String>();
			uf.setForeground(Color.BLACK);
			uf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			uf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			uf.setEditable(false);
			uf.setBounds(449, 392, 72, 32);
			panelTransportadora.add(uf);
			String sql2 = "select * from tb_estados";
			ResultSet rs2 = x.Consultar(sql2);
			try {
				
				uf.addItem("");
				while (rs2.next()) {
					uf.addItem(rs2.getString("uf"));
				}
				
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			uf.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String estado = item.toString();
					try {
						cidade.removeAllItems();
						String sql = "select * from tb_cidades where uf = '" + estado
								+ "'";
						ResultSet rs1 = x.Consultar(sql);
						cidade.addItem("");
						while (rs1.next()) {
							cidade.addItem(rs1.getString("nome"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			
			cidade = new JComboBox<String>();
			cidade.setForeground(Color.BLACK);
			cidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cidade.setEditable(false);
			cidade.setBounds(533, 391, 165, 32);
			panelTransportadora.add(cidade);
			
			Cnpj = new JTextField();
			Cnpj.setForeground(Color.BLACK);
			Cnpj.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Cnpj.setText(Cnpj.getText().replaceAll("[^0-9]", ""));
					// Cnpj.setText(Cnpj.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Cnpj.setSelectionColor(SystemColor.textHighlight);
			Cnpj.setHorizontalAlignment(SwingConstants.CENTER);
			Cnpj.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cnpj.setColumns(10);
			Cnpj.setBounds(642, 191, 261, 32);
			panelTransportadora.add(Cnpj);
			
			InscricaoEstadual = new JTextField();
			InscricaoEstadual.setForeground(Color.BLACK);
			InscricaoEstadual.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					InscricaoEstadual.setText(InscricaoEstadual.getText().replaceAll(
							"[^0-9]", ""));
					// InscricaoEstadual.setText(InscricaoEstadual.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			InscricaoEstadual.setSelectionColor(SystemColor.textHighlight);
			InscricaoEstadual.setHorizontalAlignment(SwingConstants.CENTER);
			InscricaoEstadual.setFont(new Font("Kalinga", Font.PLAIN, 14));
			InscricaoEstadual.setColumns(10);
			InscricaoEstadual.setBounds(919, 191, 250, 32);
			panelTransportadora.add(InscricaoEstadual);
			
			telefone1 = new JFormattedTextField((Object) null);
			telefone1.setForeground(Color.BLACK);
			try {
				Telefone1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			telefone1.setText("");
			telefone1.setSelectionColor(SystemColor.textHighlight);
			telefone1.setHorizontalAlignment(SwingConstants.CENTER);
			telefone1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone1.setColumns(10);
			telefone1.setBounds(54, 482, 143, 32);
			panelTransportadora.add(telefone1);
			
			telefone2 = new JFormattedTextField((Object) null);
			telefone2.setForeground(Color.BLACK);
			try {
				Telefone2.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			telefone2.setText("");
			telefone2.setSelectionColor(SystemColor.textHighlight);
			telefone2.setHorizontalAlignment(SwingConstants.CENTER);
			telefone2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone2.setColumns(10);
			telefone2.setBounds(208, 482, 144, 32);
			panelTransportadora.add(telefone2);
			
			celular1 = new JFormattedTextField((Object) null);
			celular1.setForeground(Color.BLACK);
			try {
				Celular1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			celular1.setSelectionColor(SystemColor.textHighlight);
			celular1.setHorizontalAlignment(SwingConstants.CENTER);
			celular1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular1.setColumns(10);
			celular1.setBounds(366, 482, 145, 32);
			panelTransportadora.add(celular1);
			
			celular2 = new JFormattedTextField((Object) null);
			celular2.setForeground(Color.BLACK);
			try {
				Celular2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"(##)####-####")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			celular2.setSelectionColor(SystemColor.textHighlight);
			celular2.setHorizontalAlignment(SwingConstants.CENTER);
			celular2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular2.setColumns(10);
			celular2.setBounds(520, 482, 145, 32);
			panelTransportadora.add(celular2);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			JMenuBar menuBar_3 = new JMenuBar();
			menuBar_3.setBounds(347, 0, 656, 32);
			panelTransportadora.add(menuBar_3);
			
			btSalvar1 = new JButton("Salvar");
			btSalvar1.setForeground(Color.BLACK);
			menuBar_3.add(btSalvar1);
			btSalvar1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LogisticaController.SalvarTransportadora();
				}
			});
			btSalvar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btSalvar1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btSalvar1.setMnemonic(KeyEvent.VK_ENTER);
			btSalvar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btPesquisar3 = new JButton("Pesquisar");
			btPesquisar3.setForeground(Color.BLACK);
			menuBar_3.add(btPesquisar3);
			btPesquisar3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					LogisticaController.ConsultarTransportadora();
				}
			});
			btPesquisar3.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			btPesquisar3.setMnemonic(KeyEvent.VK_ENTER);
			btPesquisar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btExcluir3 = new JButton("Excluir");
			btExcluir3.setForeground(Color.BLACK);
			menuBar_3.add(btExcluir3);
			btExcluir3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btExcluir3.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btExcluir3.setMnemonic(KeyEvent.VK_DELETE);
			btExcluir3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btExcluir3.setAlignmentX(0.5f);
			
			JButton btLimpar1 = new JButton("Limpar");
			btLimpar1.setForeground(Color.BLACK);
			menuBar_3.add(btLimpar1);
			btLimpar1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btLimpar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btLimpar1.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btLimpar1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btAlterar3 = new JButton("Alterar");
			btAlterar3.setForeground(Color.BLACK);
			menuBar_3.add(btAlterar3);
			btAlterar3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btAlterar3.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			btAlterar3.setMnemonic(KeyEvent.VK_SPACE);
			btAlterar3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAlterar3.setFocusTraversalPolicyProvider(true);
			btAlterar3.setFocusCycleRoot(true);
			btAlterar3.setAlignmentX(0.5f);
			
			JButton btImprimir1 = new JButton("Imprimir");
			btImprimir1.setForeground(Color.BLACK);
			menuBar_3.add(btImprimir1);
			btImprimir1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btImprimir1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btImprimir1.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			btImprimir1.setMnemonic(KeyEvent.VK_P);
			btImprimir1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btLimpar1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Logistica.LimparTransportadora();
				}
			});
			
			JLabel label_5 = new JLabel("CNPJ");
			label_5.setForeground(Color.BLACK);
			label_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_5.setBounds(642, 156, 324, 32);
			panelTransportadora.add(label_5);
			
			JLabel lblInscrioEstadual = new JLabel("Inscrição Estadual");
			lblInscrioEstadual.setForeground(Color.BLACK);
			lblInscrioEstadual.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblInscrioEstadual.setBounds(919, 156, 220, 32);
			panelTransportadora.add(lblInscrioEstadual);
			
			JLabel label_7 = new JLabel("Telefone 1");
			label_7.setForeground(Color.BLACK);
			label_7.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_7.setBounds(54, 451, 80, 32);
			panelTransportadora.add(label_7);
			
			JLabel label_8 = new JLabel("Telefone 2");
			label_8.setForeground(Color.BLACK);
			label_8.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_8.setBounds(208, 451, 80, 32);
			panelTransportadora.add(label_8);
			
			JLabel lblCelular = new JLabel("Celular 1");
			lblCelular.setForeground(Color.BLACK);
			lblCelular.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCelular.setBounds(366, 451, 145, 32);
			panelTransportadora.add(lblCelular);
			
			JLabel lblCelular_1 = new JLabel("Celular 2");
			lblCelular_1.setForeground(Color.BLACK);
			lblCelular_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCelular_1.setBounds(520, 451, 145, 32);
			panelTransportadora.add(lblCelular_1);
			
			JLabel label_14 = new JLabel("Código");
			label_14.setForeground(Color.BLACK);
			label_14.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_14.setBounds(46, 159, 80, 32);
			panelTransportadora.add(label_14);
			
			JLabel lblRazoSocial = new JLabel("Razão Social");
			lblRazoSocial.setForeground(Color.BLACK);
			lblRazoSocial.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblRazoSocial.setBounds(229, 159, 151, 32);
			panelTransportadora.add(lblRazoSocial);
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			labelPor3 = new JLabel("Por");
			labelPor3.setForeground(Color.BLACK);
			labelPor3.setVisible(false);
			labelPor3.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelPor3.setBounds(913, 61, 38, 32);
			panelTransportadora.add(labelPor3);
			
			JLabel label_3 = new JLabel("Endereço");
			label_3.setHorizontalTextPosition(SwingConstants.CENTER);
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_3.setBounds(54, 292, 100, 32);
			panelTransportadora.add(label_3);
			
			JLabel label_9 = new JLabel("Bairro");
			label_9.setHorizontalTextPosition(SwingConstants.CENTER);
			label_9.setForeground(Color.BLACK);
			label_9.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_9.setBounds(443, 292, 80, 32);
			panelTransportadora.add(label_9);
			
			JLabel label_15 = new JLabel("Número");
			label_15.setHorizontalTextPosition(SwingConstants.CENTER);
			label_15.setForeground(Color.BLACK);
			label_15.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_15.setBounds(618, 292, 64, 32);
			panelTransportadora.add(label_15);
			
			JLabel label_16 = new JLabel("Complemento");
			label_16.setHorizontalTextPosition(SwingConstants.CENTER);
			label_16.setForeground(Color.BLACK);
			label_16.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_16.setBounds(54, 361, 104, 32);
			panelTransportadora.add(label_16);
			
			JLabel label_17 = new JLabel("CEP");
			label_17.setHorizontalTextPosition(SwingConstants.CENTER);
			label_17.setForeground(Color.BLACK);
			label_17.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_17.setBounds(267, 361, 41, 32);
			panelTransportadora.add(label_17);
			
			JLabel label_18 = new JLabel("UF");
			label_18.setHorizontalTextPosition(SwingConstants.CENTER);
			label_18.setForeground(Color.BLACK);
			label_18.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_18.setBounds(449, 361, 49, 32);
			panelTransportadora.add(label_18);
			
			JLabel label_19 = new JLabel("Cidade");
			label_19.setHorizontalTextPosition(SwingConstants.CENTER);
			label_19.setForeground(Color.BLACK);
			label_19.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_19.setBounds(533, 361, 49, 32);
			panelTransportadora.add(label_19);
			
			label_25 = new JLabel("");
			label_25.setForeground(Color.BLACK);
			label_25.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_25.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_25.setBounds(10, 273, 1341, 261);
			panelTransportadora.add(label_25);
			
			label_26 = new JLabel("");
			label_26.setForeground(Color.BLACK);
			label_26.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_26.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DA TRANSPORTADORA", TitledBorder.LEFT,
					TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_26.setBounds(10, 142, 1341, 109);
			panelTransportadora.add(label_26);
			
			label_11 = new JLabel("");
			label_11.setForeground(Color.BLACK);
			label_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_11.setBounds(10, 43, 1325, 69);
			panelTransportadora.add(label_11);
			
			labelFundoTransportadora = new JLabel("");
			labelFundoTransportadora.setForeground(Color.BLACK);
			labelFundoTransportadora.setIcon(new ImageIcon(Logistica.class
					.getResource("/papel_parede/05.jpg")));
			labelFundoTransportadora.setVerticalAlignment(SwingConstants.TOP);
			labelFundoTransportadora.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoTransportadora.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoTransportadora.setBounds(0, 0, 1361, 665);
			panelTransportadora.add(labelFundoTransportadora);
			
			
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			modelo.removeRow(0);
			
			JMenuBar menuBar_4 = new JMenuBar();
			menuBar_4.setBounds(340, 0, 670, 32);
			panelEntrega.add(menuBar_4);
			
			JButton btOpcoes = new JButton("Opções");
			btOpcoes.setForeground(Color.BLACK);
			menuBar_4.add(btOpcoes);
			btOpcoes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btOpcoes.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606870_terminal-128.png")));
			btOpcoes.setMnemonic(KeyEvent.VK_TAB);
			btOpcoes.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnPesquisar2 = new JButton("Pesquisar");
			btnPesquisar2.setForeground(Color.BLACK);
			menuBar_4.add(btnPesquisar2);
			btnPesquisar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnPesquisar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnPesquisar2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			btnPesquisar2.setMnemonic(KeyEvent.VK_ENTER);
			btnPesquisar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnExcluir2 = new JButton("Excluir");
			btnExcluir2.setForeground(Color.BLACK);
			menuBar_4.add(btnExcluir2);
			btnExcluir2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnExcluir2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnExcluir2.setMnemonic(KeyEvent.VK_DELETE);
			btnExcluir2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnExcluir2.setAlignmentX(0.5f);
			
			btnLimpar2 = new JButton("Limpar");
			btnLimpar2.setForeground(Color.BLACK);
			menuBar_4.add(btnLimpar2);
			btnLimpar2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btnLimpar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnLimpar2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// btnLimpar_1.setIcon(new
			// ImageIcon(Logistica.class.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btnLimpar2.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btnLimpar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnAlterar2 = new JButton("Alterar");
			btnAlterar2.setForeground(Color.BLACK);
			menuBar_4.add(btnAlterar2);
			btnAlterar2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnAlterar2.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			btnAlterar2.setMnemonic(KeyEvent.VK_SPACE);
			btnAlterar2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAlterar2.setFocusTraversalPolicyProvider(true);
			btnAlterar2.setFocusCycleRoot(true);
			btnAlterar2.setAlignmentX(0.5f);
			
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.setForeground(Color.BLACK);
			menuBar_4.add(btnImprimir);
			btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					report.Transportadora();
				}
			});
			btnImprimir.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			btnImprimir.setMnemonic(KeyEvent.VK_P);
			btnImprimir.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			labelFundoEntregas = new JLabel("");
			labelFundoEntregas.setForeground(Color.BLACK);
			labelFundoEntregas.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoEntregas.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoEntregas.setIcon(new ImageIcon(Logistica.class
					.getResource("/papel_parede/05.jpg")));
			labelFundoEntregas.setVerticalAlignment(SwingConstants.TOP);
			labelFundoEntregas.setBounds(0, 0, 1361, 665);
			panelEntrega.add(labelFundoEntregas);
			
			tabbedPane.addTab("Veículo", new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606739_678100-tachometer-128.png")),
					panelVeiculo, null);
			tabbedPane.addTab(
					"Motorista",
					new ImageIcon(
							Logistica.class
									.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")),
					panelMotorista, null);
			tabbedPane.addTab("Transportadora", new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606771_678086-institution-128.png")),
					panelTransportadora, null);
			tabbedPane.addTab("Entregas ", new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606563_map-128.png")), panelEntrega,
					null);
			
			panelRelatorios = new JPanel();
			panelRelatorios.setLayout(null);
			panelRelatorios.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelRelatorios.setBackground(SystemColor.inactiveCaptionBorder);
			tabbedPane.addTab("Relatórios", new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
					panelRelatorios, null);
			
			menuBar_5 = new JMenuBar();
			menuBar_5.setBounds(615, 0, 120, 32);
			panelRelatorios.add(menuBar_5);
			
			JButton btnGerenciar = new JButton("Grafico");
			btnGerenciar.setForeground(Color.BLACK);
			menuBar_5.add(btnGerenciar);
			btnGerenciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultPieDataset pieDataset = new DefaultPieDataset();
					pieDataset.setValue("Total de Entregas", new Integer(40));
					pieDataset.setValue("Entregas Concluídas", new Integer(20));
					pieDataset.setValue("Aguardando", new Integer(10));
					pieDataset.setValue("Lucro Total", new Integer(100));
					JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart",
							pieDataset, true, true, true);
					
					PiePlot3D plot = (PiePlot3D) chart.getPlot();
					plot.setStartAngle(290);
					plot.setDirection(Rotation.CLOCKWISE);
					plot.setForegroundAlpha(0.5f);
					plot.setNoDataMessage("No data to display");
					
					chart.getPlot();
					
					ChartFrame frame = new ChartFrame("Pie Chart", chart);
					frame.setVisible(true);
					frame.setBounds(898, 43, 443, 272);
					// frame.setSize(450, 500);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
					
					barDataset.setValue(80, "Entregas Concluídas", "teste1");
					barDataset.setValue(50, "Entregas", "A Caminho");
					barDataset.setValue(75, "Entregas", "Aguardando Autorização");
					barDataset.setValue(95, "Entregas", "Retornou");
					JFreeChart chart1 = ChartFactory.createBarChart3D("Preço", "KM",
							"Frota", barDataset, PlotOrientation.VERTICAL, false,
							true, false);
					
					CategoryPlot p = chart1.getCategoryPlot();
					p.setRangeGridlinePaint(Color.black);
					ChartFrame frame1 = new ChartFrame("Bar Chart", chart1);
					frame1.setVisible(true);
					frame1.setBounds(10, 326, 1331, 320);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
				}
			});
			btnGerenciar.setIcon(new ImageIcon(Logistica.class
					.getResource("/icones1_24px/1425606754_monitor-128.png")));
			btnGerenciar.setFont(new Font("Kalinga", Font.PLAIN, 16));
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 65, 855, 238);
			panelRelatorios.add(scrollPane);
			
			table_1 = new JTable();
			table_1.setForeground(Color.BLACK);
			table_1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null,
					null }, }, new String[] { "Motorista", "CNH", "Ve\u00EDculo", "Tipo",
					"Placa" }));
			scrollPane.setViewportView(table_1);
			
			label_2 = new JLabel("");
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "RELA\u00C7\u00C3O MOTORISTA / VE\u00CDCULO",
					TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_2.setBounds(10, 43, 878, 272);
			panelRelatorios.add(label_2);
			
			label_22 = new JLabel("");
			label_22.setForeground(Color.BLACK);
			label_22.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_22.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENTREGAS", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_22.setBounds(10, 326, 1331, 320);
			panelRelatorios.add(label_22);
			
			label_24 = new JLabel("");
			label_24.setForeground(Color.BLACK);
			label_24.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_24.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENTREGAS", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_24.setBounds(898, 43, 443, 272);
			panelRelatorios.add(label_24);
			
			label_27 = new JLabel("");
			label_27.setIcon(new ImageIcon(Logistica.class
					.getResource("/papel_parede/05.jpg")));
			label_27.setVerticalAlignment(SwingConstants.TOP);
			label_27.setHorizontalTextPosition(SwingConstants.CENTER);
			label_27.setHorizontalAlignment(SwingConstants.CENTER);
			label_27.setForeground(Color.BLACK);
			label_27.setFont(new Font("Arial", Font.PLAIN, 12));
			label_27.setBounds(0, 0, 1348, 664);
			panelRelatorios.add(label_27);
			
			this.setSize(new Dimension(1366, 768));
			// this.setSize(toolkit.getScreenSize());
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Logistica.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Logistica.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Logistica.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Logistica.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
	}
	
	protected static void SetarVeiculoNaoEditavel() {
		
		tipo.setVisible(false);
		tipoPesq.setVisible(true);
		tipoPesq.setEditable(false);
		tipoPesq.setEnabled(false);
		
		combustivel.setEnabled(false);
		combustivel.setEditable(false);
		combustivel.setVisible(false);
		combustivelPesq.setVisible(true);
		combustivelPesq.setEditable(false);
		combustivelPesq.setEnabled(false);
		
		especie.setVisible(false);
		especiePesq.setVisible(true);
		especiePesq.setEditable(false);
		especiePesq.setEnabled(false);
		
		comboAnoFabricacao.setVisible(false);
		aquisicao.setEnabled(false);
		aquisicao.setEditable(false);
		marcaPesq.setEditable(false);
		marcaPesq.setEnabled(false);
		marcaPesq.setVisible(true);
		anoFabricacao.setVisible(true);
		modelo_1.setEnabled(false);
		numeroChassi.setEnabled(false);
		numeroDocumento.setEnabled(false);
		placa.setEnabled(false);
		anoFabricacao.setEnabled(false);
		licenciamento.setEnabled(false);
		combustivel.setEnabled(false);
		cor.setEnabled(false);
		Endereco.setEnabled(false);
		kilometragem.setEnabled(false);
		ipva.setEnabled(false);
		seguroObrigatorio.setEnabled(false);
		modelo_1.setEditable(false);
		numeroChassi.setEditable(false);
		numeroDocumento.setEditable(false);
		placa.setEditable(false);
		anoFabricacao.setEditable(false);
		licenciamento.setEditable(false);
		combustivel.setEditable(false);
		cor.setEditable(false);
		Endereco.setEditable(false);
		kilometragem.setEditable(false);
		ipva.setEditable(false);
		seguroObrigatorio.setEditable(false);
	}
	
	protected static void SetarVeiculoEditavel() {
		codigo.setBorder(null);
		modelo_1.setBorder(null);
		placa.setBorder(null);
		
		tipoPesq.setVisible(false);
		
		modelo_1.setEnabled(true);
		marca.setEnabled(true);
		numeroChassi.setEnabled(true);
		numeroDocumento.setEnabled(true);
		placa.setEnabled(true);
		comboAnoFabricacao.setVisible(true);
		comboAnoFabricacao.setEnabled(true);
		anoFabricacao.setVisible(false);
		licenciamento.setEnabled(true);
		combustivel.setEnabled(true);
		cor.setEnabled(true);
		Endereco.setEnabled(true);
		kilometragem.setEnabled(true);
		ipva.setEnabled(true);
		seguroObrigatorio.setEnabled(true);
		aquisicao.setEnabled(true);
		
		modelo_1.setEditable(true);
		marca.setEditable(false);
		numeroChassi.setEditable(true);
		numeroDocumento.setEditable(true);
		placa.setEditable(true);
		anoFabricacao.setEditable(true);
		licenciamento.setEditable(true);
		combustivel.setEditable(true);
		cor.setEditable(true);
		Endereco.setEditable(true);
		kilometragem.setEditable(true);
		ipva.setEditable(true);
		seguroObrigatorio.setEditable(true);
		aquisicao.setEditable(true);
		combustivel.setEditable(false);
		
	}
	
	protected static void SetarEditavelFalso() {
		Nome.setEditable(false);
		Nascimento.setEditable(false);
		Nacionalidade.setEditable(false);
		Email.setEditable(false);
		Rg.setEditable(false);
		Cpf.setEditable(false);
		Ctps.setEditable(false);
		EstadoCivil.setEditable(false);
		Admissao.setEditable(false);
		ContratoPesq.setEditable(false);
		EscolaridadePesq.setEditable(false);
		NomePai.setEditable(false);
		NomeMae.setEditable(false);
		BancoPesq.setEditable(false);
		Conta.setEditable(false);
		Telefone1.setEditable(false);
		Telefone2.setEditable(false);
		Celular1.setEditable(false);
		Celular2.setEditable(false);
		Endereco.setEditable(false);
		Bairro.setEditable(false);
		Numero.setEditable(false);
		Complemento.setEditable(false);
		Cep.setEditable(false);
		UfPesq.setEditable(false);
		CidadePesq.setEditable(false);
		CargoPesq.setEditable(false);
		Salario.setEditable(false);
		Departamento.setEditable(false);
		NumeroCnh.setEditable(false);
		DataVencimento.setEditable(false);
		comboCategoria.setEditable(false);
		
		Nome.setEnabled(false);
		Nascimento.setEnabled(false);
		Nacionalidade.setEnabled(false);
		Email.setEnabled(false);
		Rg.setEnabled(false);
		Cpf.setEnabled(false);
		Ctps.setEnabled(false);
		EstadoCivil.setEnabled(false);
		Admissao.setEnabled(false);
		ContratoPesq.setEnabled(false);
		EscolaridadePesq.setEnabled(false);
		NomePai.setEnabled(false);
		NomeMae.setEnabled(false);
		BancoPesq.setEnabled(false);
		Conta.setEnabled(false);
		Telefone1.setEnabled(false);
		Telefone2.setEnabled(false);
		Celular1.setEnabled(false);
		Celular2.setEnabled(false);
		Endereco.setEnabled(false);
		Bairro.setEnabled(false);
		Numero.setEnabled(false);
		Complemento.setEnabled(false);
		Cep.setEnabled(false);
		UfPesq.setEnabled(false);
		CidadePesq.setEnabled(false);
		CargoPesq.setEnabled(false);
		Salario.setEnabled(false);
		Departamento.setEnabled(false);
		NumeroCnh.setEnabled(false);
		DataVencimento.setEnabled(false);
		
	}
	
	protected static void SetarEditavel() {
		NumeroRegistro.setBorder(null);
		NumeroRegistro.setEnabled(false);
		Nome.setBorder(null);
		Cpf.setBorder(null);
		
		Nome.setEnabled(true);
		Nascimento.setEnabled(true);
		Nacionalidade.setEnabled(true);
		Email.setEnabled(true);
		Rg.setEnabled(true);
		Cpf.setEnabled(true);
		Ctps.setEnabled(true);
		EstadoCivil.setEnabled(true);
		Admissao.setEnabled(true);
		ContratoPesq.setEnabled(true);
		EscolaridadePesq.setEnabled(true);
		NomePai.setEnabled(true);
		NomeMae.setEnabled(true);
		BancoPesq.setEnabled(true);
		Conta.setEnabled(true);
		Telefone1.setEnabled(true);
		Telefone2.setEnabled(true);
		Celular1.setEnabled(true);
		Celular2.setEnabled(true);
		Endereco.setEnabled(true);
		Bairro.setEnabled(true);
		Numero.setEnabled(true);
		Complemento.setEnabled(true);
		Cep.setEnabled(true);
		UfPesq.setEnabled(true);
		CidadePesq.setEnabled(true);
		CargoPesq.setEnabled(true);
		Salario.setEnabled(true);
		Departamento.setEnabled(true);
		NumeroCnh.setEnabled(true);
		DataVencimento.setEnabled(true);
		comboCategoria.setEnabled(true);
		CategoriaPesq.setEnabled(true);
		Nome.setEditable(true);
		Nascimento.setEditable(true);
		Nacionalidade.setEditable(true);
		Email.setEditable(true);
		Rg.setEditable(true);
		Cpf.setEditable(true);
		Ctps.setEditable(true);
		EstadoCivil.setEditable(true);
		Admissao.setEditable(true);
		ContratoPesq.setEditable(true);
		EscolaridadePesq.setEditable(true);
		NomePai.setEditable(true);
		NomeMae.setEditable(true);
		BancoPesq.setEditable(true);
		Conta.setEditable(true);
		Telefone1.setEditable(true);
		Telefone2.setEditable(true);
		Celular1.setEditable(true);
		Celular2.setEditable(true);
		Endereco.setEditable(true);
		Bairro.setEditable(true);
		Numero.setEditable(true);
		Complemento.setEditable(true);
		Cep.setEditable(true);
		UfPesq.setEditable(true);
		CidadePesq.setEditable(true);
		CargoPesq.setEditable(true);
		Salario.setEditable(true);
		Departamento.setEditable(true);
		NumeroCnh.setEditable(true);
		DataVencimento.setEditable(true);
		comboCategoria.setEditable(true);
		
	}
	
	protected static void LimparTransportadora() {
		razaoSocial.setText(null);
		endereco.setText(null);
		bairro.setText(null);
		numero.setText(null);
		complemento.setText(null);
		cep.setText(null);
		uf.setSelectedItem(null);
		cidade.setSelectedItem(null);
		
	}
	
	protected static void limpaDados() {
		
		buttonAtualizar1.setVisible(false);
		btExcluir.setVisible(false);
		buttonAnterior1.setVisible(false);
		buttonProximo1.setVisible(false);
		btAlterar.setVisible(false);
		modelo_1.setText(null);
		numeroChassi.setText(null);
		placa.setText(null);
		comboAnoFabricacao.setSelectedItem(null);
		anoFabricacao.setText(null);
		numeroDocumento.setText(null);
		tipoPesq.setText(null);
		licenciamento.setText(null);
		combustivelPesq.setText(null);
		Endereco.setText(null);
		ipva.setText(null);
		marcaPesq.setText(null);
		seguroObrigatorio.setText(null);
		kilometragem.setText(null);
		especiePesq.setText(null);
		cor.setText(null);
		aquisicao.setText(null);
		labelFotoVeiculo.setIcon(null);
	}
	
	protected static void SelecionarFotoMotorista() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(135, 115,
					Image.SCALE_AREA_AVERAGING);
			labelFotoMotorista.setIcon(new javax.swing.ImageIcon(img));
			labelFotoMotorista.setText("");
			caminhoM = (diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
					.replace("\\", "~").toString());
			System.out.print(diretorio);
			
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
		
	}
	
	protected static void SelecionarFotoVeiculo() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(135, 115,
					Image.SCALE_AREA_AVERAGING);
			labelFotoVeiculo.setIcon(new javax.swing.ImageIcon(img));
			labelFotoVeiculo.setText("");
			caminhoV = (diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
					.replace("\\", "~").toString());
			System.out.print(diretorio);
			
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
	}
	
	protected static void SelecionarPapelParedeLogistica() {
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
			
			labelFundoVeiculo.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoMotorista.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoTransportadora.setIcon(new javax.swing.ImageIcon(diretorio));
			labelFundoEntregas.setIcon(new javax.swing.ImageIcon(diretorio));
			
			System.out.print(diretorio);
		}
	}
}
