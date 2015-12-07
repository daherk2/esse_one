package Solid.view;

import java.awt.Color;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
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
import Solid.controller.Metodos;
import Solid.controller.RHController;
import Solid.model.PPReport;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class RH extends JFrame {
	
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	private static final long		serialVersionUID	= -6461750771897416894L;
	
	// instancia a classe do banco para conexão
	static BancoDados				x			= new BancoDados();
	
	// instancia a classe para impressao
	PPReport					report		= new PPReport();
	
	// variaveis do sistema
	private JMenu				Menu;
	private JMenu				mnConfigurao;
	private JMenu				menu_2;
	private JMenu				menu_3;
	private JMenuBar				menuBar;
	private JMenuItem				menu;
	private JMenuItem				sair;
	private JMenuItem				menuItem_1;
	private JMenuItem				mntmAbrirAjuda;
	public static JTabbedPane		tabbedPaneRH;
	public static JPanel			panelFuncionario;
	public static JPanel			panelCargoSalario;
	public static JTextField		NumeroRegistro1;
	public static JTextField		Nome1;
	public static JFormattedTextField	Nascimento1;
	public static JTextField		Nacionalidade1;
	public static JFormattedTextField	Rg1;
	public static JFormattedTextField	Cpf1;
	public static JTextField		Ctps1;
	public static JTextField		Email1;
	public static JTextField		NomePai1;
	public static JTextField		NomeMae1;
	public static JTextField		Dependentes1;
	public static JFormattedTextField	Telefone11;
	public static JFormattedTextField	Celular11;
	public static JFormattedTextField	Telefone21;
	public static JFormattedTextField	Celular21;
	public static JFormattedTextField	Admissao1;
	public static JTextField		Conta1;
	public static JTextField		Logradouro1;
	public static JTextField		Numero1;
	public static JTextField		Complemento1;
	public static JTextField		Bairro1;
	public static JFormattedTextField	Cep1;
	public static JTextField		Salario1;
	public static JTextField		Usuario1;
	public static JPasswordField		Senha1;
	public static JRadioButton		radioCadastrar;
	public static JRadioButton		radioConsultar;
	static public JComboBox<String>	comboEscolaridade;
	static public JComboBox<String>	comboEstadoCivil;
	static public JComboBox<String>	comboContrato;
	static public JComboBox<String>	comboUf;
	static public JComboBox<String>	comboCidade;
	static public JComboBox<String>	comboCargo;
	static public JComboBox<String>	comboDepartamento;
	static public JComboBox<String>	comboNivel;
	static public JComboBox<String>	comboBanco;
	private JLabel				labelCelular;
	private JLabel				labelNascimento;
	private JLabel				labelRg_1;
	private JLabel				labelCpf;
	private JLabel				labelCtps_1;
	private JLabel				labelEndereco_1;
	private JLabel				labelNome;
	private JLabel				labelNumeroRegistro;
	private JLabel				labelEstadoCivil;
	private JLabel				labelSalario;
	private JLabel				labelEmail_1;
	private JLabel				labelCidade_1;
	private JLabel				labelNumero;
	private JLabel				labelCargo;
	private JLabel				labelTelefone_1;
	private JLabel				labelComplemento_1;
	private JLabel				labelBairro_1;
	private JLabel				labelUf_1;
	private JLabel				labelCep_1;
	private static JLabel			labelLogin;
	private static JLabel			labelFundoFuncionario;
	private static JLabel			labelFundoHolerite;
	private static JLabel			labelUsuario_1;
	private JLabel				labelDepartamento;
	private static JLabel			labelSenha;
	private static JLabel			labelNivel;
	private JLabel				labelDependentes_2;
	private JLabel				labelNomePai;
	private JLabel				labelNomeMae;
	private JLabel				labelTelefone2;
	private JLabel				labelAdmissao;
	private JLabel				labelCelular2;
	private JLabel				labelContrato;
	private JLabel				labelConta;
	private JLabel				labelBanco;
	private static JButton			btConsultar;
	protected JTable				tabbleDependentes;
	static private JButton			btLimpar;
	static private JButton			btSalvar;
	static private JRadioButton		radioSim2;
	static private JRadioButton		radioNao2;
	static private JRadioButton		radioSim;
	static private JRadioButton		radioNao;
	static private String			estado		= null;
	static private String			cargo			= null;
	public static int				sn			= 0;
	static ResultSet				dados;
	private JMenuItem				menuItem;
	private JMenuItem				menuItem_3;
	private JButton				btAdicionarDependente;
	public static JButton			btRemoverDependente, btnPrximo;
	private JLabel				labelNacionalidade;
	private JLabel				labelEscolaridade;
	private JLabel				labelDependentes_1;
	public JTextField				CadastrarCargo;
	public JTextField				CadastrarSalario;
	private JLabel				labelCadastrarCargo;
	private JLabel				labelCadastrarSalario;
	public JComboBox<String>		comboDepartamento1;
	private JLabel				labelCadastrarDepartamento;
	private JButton				btLimpar_1;
	private JButton				btSalvar_1;
	public static JTextField		escolaridade;
	public static JTextField		contrato;
	public static JTextField		banco;
	public static JTextField		estadoCivil;
	public static JTextField		cidade;
	public static JTextField		uf;
	public static JTextField		cargo_1;
	public static JTextField		departamento;
	public static JTextField		nivel;
	private JButton				button_1;
	public static JComboBox<String>	comboPor;
	private static JLabel			lblPor;
	public static JLabel			labelFotoFuncionario;
	public static JButton			button_2;
	public static JButton			button_3, btnImprimir;
	public static JButton			button_4;
	public static JPanel			panelTreinamentos;
	public static JButton			button_5, btnAnterior;
	public static JButton			button_6;
	public static JButton			button_7;
	public static JButton			button_8;
	public static JButton			button_9;
	private JLabel				label_5;
	public static JPanel			panelRelatorios;
	private JButton				button_10;
	private JButton				button_11;
	private JButton				button_12;
	private JButton				button_13;
	private JButton				button_14;
	private JLabel				label_2;
	private JTextArea				DescricaoAtividade;
	private JLabel				label_11;
	private JLabel				label_12;
	private JTextField			agencia;
	private JButton				btnAtualizar;
	private JTextField			textField;
	private JTextField			textField_1;
	private JComboBox<String>		comboBox;
	private JTextArea				textArea;
	private JLabel				lblSelecionarFuncionrio;
	private JLabel				lblDataTreinamento;
	private JLabel				lblData;
	private JLabel				label_15;
	private JLabel				label_16;
	private JTable				table;
	private JMenuBar menuBar_2;
	private JMenuBar menuBar_3;
	private JMenuBar menuBar_4;
	
	public RH() {
		super();
		setResizable(false);
		
		try {
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					RH.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			
			setTitle("RECURSOS HUMANOS");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			getContentPane().setBackground(new Color(245, 245, 245));
			
			@SuppressWarnings("unused")
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			
			BancoDados.conecta();
			
			getContentPane().setLayout(null);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			menuBar = new JMenuBar();
			menuBar.setForeground(new Color(0, 0, 0));
			menuBar.setBounds(0, 0, 1356, 32);
			getContentPane().add(menuBar);
			
			Menu = new JMenu("Arquivo");
			Menu.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
			Menu.setForeground(Color.BLACK);
			Menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(Menu);
			
			menu = new JMenuItem("Menu Principal");
			menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menu.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606621_678085-house-128.png")));
			menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int sair = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja sair?", "Fechamento de Programa",
							JOptionPane.YES_NO_OPTION);
					if (sair == 0) {
						// BD.desconecta();
						RH.this.dispose();
						new Menu();
					}
					UIManager.put("OptionPane.yesButtonText", "Sim");
					UIManager.put("OptionPane.noButtonText", "Não");
				}
			});
			Menu.add(menu);
			
			sair = new JMenuItem("Sair");
			sair.setFont(new Font("Kalinga", Font.PLAIN, 14));
			sair.setIcon(new ImageIcon(RH.class.getResource("/icones1_24px/desliga24px.png")));
			Menu.add(sair);
			
			mnConfigurao = new JMenu("Configurações");
			mnConfigurao.setIcon(new ImageIcon(
					RH.class.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
			mnConfigurao.setForeground(Color.BLACK);
			mnConfigurao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(mnConfigurao);
			
			menuItem = new JMenuItem("Definir Papel de Parede");
			menuItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606663_image-128.png")));
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// RH.SelecionarPapelParedeRH();
				}
			});
			mnConfigurao.add(menuItem);
			
			menuItem_3 = new JMenuItem("Abrir Bate-Papo");
			menuItem_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem_3.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
			menuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// PPChat.main(null);
				}
			});
			mnConfigurao.add(menuItem_3);
			
			menu_2 = new JMenu("Logout");
			menu_2.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
			menu_2.setForeground(Color.BLACK);
			menu_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menu_2);
			
			menuItem_1 = new JMenuItem("Logout");
			menuItem_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem_1.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RH.this.dispose();
					new Login().setVisible(true);
				}
			});
			menu_2.add(menuItem_1);
			
			menu_3 = new JMenu("Help");
			menu_3.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
			menu_3.setForeground(Color.BLACK);
			menu_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menu_3);
			
			mntmAbrirAjuda = new JMenuItem("Abrir Ajuda");
			mntmAbrirAjuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ajuda ajuda = new Ajuda();
					ajuda.contentPaneAjuda.setVisible(true);
				}
			});
			mntmAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			mntmAbrirAjuda.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
			menu_3.add(mntmAbrirAjuda);
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Metodos.formWindowClosing(null);
				}
			});
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			tabbedPaneRH = new JTabbedPane(JTabbedPane.TOP);
			tabbedPaneRH.setBounds(0, 34, 1356, 695);
			tabbedPaneRH.setFont(new Font("Kalinga", Font.PLAIN, 13));
			getContentPane().add(tabbedPaneRH);
			
			/*
			 * 
			 * Panel Cadastrar Funcionario
			 */
			
			panelFuncionario = new JPanel();
			panelFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			panelFuncionario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboEscolaridade = new JComboBox<String>();
			comboEscolaridade.setForeground(Color.BLACK);
			comboEscolaridade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboEscolaridade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboEscolaridade.setBounds(30, 283, 173, 32);
			if (Inicio.rd == 0) {
				comboEscolaridade.addItem("");
				comboEscolaridade.addItem("2º Grau incompleto");
				comboEscolaridade.addItem("2º Grau completo");
				comboEscolaridade.addItem("Superior incompleto");
				comboEscolaridade.addItem("Superior completo");
			}
			
			NumeroRegistro1 = new JTextField();
			NumeroRegistro1.setForeground(Color.BLACK);
			NumeroRegistro1.setSelectionColor(SystemColor.textHighlight);
			NumeroRegistro1.setDisabledTextColor(Color.BLACK);
			NumeroRegistro1.setEnabled(false);
			NumeroRegistro1.setHorizontalAlignment(SwingConstants.CENTER);
			NumeroRegistro1.setBounds(30, 161, 173, 32);
			NumeroRegistro1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumeroRegistro1.setColumns(10);
			NumeroRegistro1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			NumeroRegistro1.setEditable(false);
			NumeroRegistro1.requestFocus();
			panelFuncionario.add(NumeroRegistro1);
			
			String sql21 = "select * from contadores";
			ResultSet rs31 = x.Consultar(sql21);
			try {
				if (Inicio.rd == 0) {
					while (rs31.next()) {
						NumeroRegistro1.setText(rs31.getString("numeroRegistro"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			Nome1 = new JTextField();
			Nome1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Nome1.setText(Nome1.getText().replaceAll("[^0-9]",
					// ""));
					Nome1.setText(Nome1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Nome1.setDisabledTextColor(Color.BLACK);
			Nome1.setHorizontalAlignment(SwingConstants.CENTER);
			Nome1.setSelectionColor(SystemColor.textHighlight);
			Nome1.setForeground(Color.BLACK);
			Nome1.setBounds(214, 161, 384, 32);
			Nome1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nome1.setColumns(10);
			Nome1.requestFocus();
			panelFuncionario.add(Nome1);
			
			ArrayList<String> valores = new ArrayList<String>();
			String sql2 = "SELECT * FROM `funcionarios`";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				while (rs3.next()) {
					valores.add(rs3.getString("nome"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			Nascimento1 = new JFormattedTextField("");
			Nascimento1.setDisabledTextColor(Color.BLACK);
			try {
				Nascimento1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Nascimento1.setSelectionColor(SystemColor.textHighlight);
			Nascimento1.setForeground(Color.BLACK);
			Nascimento1.setHorizontalAlignment(SwingConstants.CENTER);
			Nascimento1.setBounds(614, 161, 92, 32);
			Nascimento1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nascimento1.setColumns(10);
			panelFuncionario.add(Nascimento1);
			
			Nacionalidade1 = new JTextField();
			Nacionalidade1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Nacionalidade1.setText(Nacionalidade1.getText().replaceAll("[^0-9]",
					// ""));
					Nacionalidade1.setText(Nacionalidade1.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			Nacionalidade1.setDisabledTextColor(Color.BLACK);
			Nacionalidade1.setHorizontalAlignment(SwingConstants.CENTER);
			Nacionalidade1.setSelectionColor(SystemColor.textHighlight);
			Nacionalidade1.setForeground(Color.BLACK);
			Nacionalidade1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nacionalidade1.setColumns(10);
			Nacionalidade1.setBounds(30, 223, 173, 32);
			panelFuncionario.add(Nacionalidade1);
			
			Email1 = new JTextField();
			Email1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Email1.setText(Email1.getText().replaceAll("[^0-9]",
					// ""));
					// Email1.setText(Email1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Email1.setDisabledTextColor(Color.BLACK);
			Email1.setHorizontalAlignment(SwingConstants.CENTER);
			Email1.setSelectionColor(SystemColor.textHighlight);
			Email1.setForeground(Color.BLACK);
			Email1.setBounds(214, 283, 344, 32);
			Email1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Email1.setColumns(10);
			panelFuncionario.add(Email1);
			
			Rg1 = new JFormattedTextField("");
			Rg1.setDisabledTextColor(Color.BLACK);
			try {
				Rg1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"##.###.###-#")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Rg1.setHorizontalAlignment(SwingConstants.CENTER);
			Rg1.setSelectionColor(SystemColor.textHighlight);
			Rg1.setForeground(Color.BLACK);
			Rg1.setBounds(214, 223, 173, 32);
			Rg1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Rg1.setColumns(10);
			panelFuncionario.add(Rg1);
			
			Cpf1 = new JFormattedTextField();
			Cpf1.setDisabledTextColor(Color.BLACK);
			try {
				Cpf1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"###.###.###-##")));
			}
			catch (ParseException e2) {
				
				e2.printStackTrace();
			}
			Cpf1.setHorizontalAlignment(SwingConstants.CENTER);
			Cpf1.setSelectionColor(SystemColor.textHighlight);
			Cpf1.setForeground(Color.BLACK);
			Cpf1.setBounds(398, 223, 160, 32);
			Cpf1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cpf1.setColumns(10);
			panelFuncionario.add(Cpf1);
			
			Ctps1 = new JTextField();
			Ctps1.setForeground(Color.BLACK);
			Ctps1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Ctps1.setText(Ctps1.getText().replaceAll("[^0-9]", ""));
					// Ctps1.setText(Ctps1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Ctps1.setDisabledTextColor(Color.BLACK);
			Ctps1.setHorizontalAlignment(SwingConstants.CENTER);
			Ctps1.setSelectionColor(SystemColor.textHighlight);
			Ctps1.setBounds(568, 223, 138, 32);
			Ctps1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Ctps1.setColumns(10);
			panelFuncionario.add(Ctps1);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboEstadoCivil = new JComboBox<String>();
			comboEstadoCivil.setForeground(Color.BLACK);
			comboEstadoCivil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboEstadoCivil.setBounds(568, 283, 138, 32);
			comboEstadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboEstadoCivil.setEditable(false);
			panelFuncionario.add(comboEstadoCivil);
			
			estadoCivil = new JTextField();
			estadoCivil.setDisabledTextColor(Color.BLACK);
			estadoCivil.setRequestFocusEnabled(false);
			estadoCivil.setVisible(false);
			estadoCivil.setSelectionColor(SystemColor.textHighlight);
			estadoCivil.setHorizontalAlignment(SwingConstants.CENTER);
			estadoCivil.setForeground(Color.BLACK);
			estadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estadoCivil.setColumns(10);
			estadoCivil.setBorder(null);
			estadoCivil.setBounds(568, 283, 138, 32);
			panelFuncionario.add(estadoCivil);
			
			Admissao1 = new JFormattedTextField("");
			Admissao1.setDisabledTextColor(Color.BLACK);
			try {
				Admissao1.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Admissao1.setHorizontalAlignment(SwingConstants.CENTER);
			Admissao1.setSelectionColor(SystemColor.textHighlight);
			Admissao1.setForeground(Color.BLACK);
			Admissao1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Admissao1.setColumns(10);
			Admissao1.setBounds(918, 368, 82, 32);
			panelFuncionario.add(Admissao1);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboContrato = new JComboBox<String>();
			comboContrato.setForeground(Color.BLACK);
			comboContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboContrato.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboContrato.setEditable(false);
			comboContrato.setBounds(1010, 368, 130, 32);
			panelFuncionario.add(comboContrato);
			comboContrato.addItem("");
			comboContrato.addItem("Temporário");
			comboContrato.addItem("Efetivo");
			comboContrato.addItem("Terceirizado");
			comboContrato.addItem("Experiencia");
			
			contrato = new JTextField();
			contrato.setDisabledTextColor(Color.BLACK);
			contrato.setRequestFocusEnabled(false);
			contrato.setVisible(false);
			contrato.setSelectionColor(SystemColor.textHighlight);
			contrato.setHorizontalAlignment(SwingConstants.CENTER);
			contrato.setForeground(Color.BLACK);
			contrato.setFont(new Font("Kalinga", Font.PLAIN, 14));
			contrato.setColumns(10);
			contrato.setBorder(null);
			contrato.setBounds(1010, 368, 130, 32);
			panelFuncionario.add(contrato);
			panelFuncionario.add(comboEscolaridade);
			
			comboUf = new JComboBox<String>();
			comboUf.setForeground(Color.BLACK);
			comboUf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboUf.setBounds(212, 514, 64, 32);
			comboUf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboUf.setEditable(false);
			
			String sql = "select * from tb_estados";
			ResultSet rs = x.Consultar(sql);
			try {
				if (Inicio.rd == 0) {
					comboUf.addItem("");
					while (rs.next()) {
						comboUf.addItem(rs.getString("uf"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			comboUf.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					estado = item.toString();
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
			
			escolaridade = new JTextField();
			escolaridade.setDisabledTextColor(Color.BLACK);
			escolaridade.setRequestFocusEnabled(false);
			escolaridade.setVisible(false);
			escolaridade.setSelectionColor(SystemColor.textHighlight);
			escolaridade.setHorizontalAlignment(SwingConstants.CENTER);
			escolaridade.setForeground(Color.BLACK);
			escolaridade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			escolaridade.setColumns(10);
			escolaridade.setBorder(null);
			escolaridade.setBounds(30, 283, 173, 32);
			panelFuncionario.add(escolaridade);
			
			NomePai1 = new JTextField();
			NomePai1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// NomePai1.setText(NomePai1.getText().replaceAll("[^0-9]",
					// ""));
					NomePai1.setText(NomePai1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			NomePai1.setDisabledTextColor(Color.BLACK);
			NomePai1.setHorizontalAlignment(SwingConstants.CENTER);
			NomePai1.setSelectionColor(SystemColor.textHighlight);
			NomePai1.setForeground(Color.BLACK);
			NomePai1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NomePai1.setColumns(10);
			NomePai1.setBounds(30, 342, 409, 32);
			panelFuncionario.add(NomePai1);
			
			NomeMae1 = new JTextField();
			NomeMae1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// NomeMae1.setText(NomeMae1.getText().replaceAll("[^0-9]",
					// ""));
					NomeMae1.setText(NomeMae1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			NomeMae1.setDisabledTextColor(Color.BLACK);
			NomeMae1.setHorizontalAlignment(SwingConstants.CENTER);
			NomeMae1.setSelectionColor(SystemColor.textHighlight);
			NomeMae1.setForeground(Color.BLACK);
			NomeMae1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NomeMae1.setColumns(10);
			NomeMae1.setBounds(461, 342, 409, 32);
			panelFuncionario.add(NomeMae1);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboBanco = new JComboBox<String>();
			comboBanco.setForeground(Color.BLACK);
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
			comboBanco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBanco.setEditable(false);
			comboBanco.setBounds(732, 452, 120, 32);
			
			panelFuncionario.add(comboBanco);
			comboBanco.addItem("");
			comboBanco.addItem("CEF");
			comboBanco.addItem("Santander");
			comboBanco.addItem("Itau");
			comboBanco.addItem("Bradesco");
			
			banco = new JTextField();
			banco.setDisabledTextColor(Color.BLACK);
			banco.setRequestFocusEnabled(false);
			banco.setVisible(false);
			banco.setSelectionColor(SystemColor.textHighlight);
			banco.setHorizontalAlignment(SwingConstants.CENTER);
			banco.setForeground(Color.BLACK);
			banco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			banco.setColumns(10);
			banco.setBorder(null);
			banco.setBounds(732, 452, 120, 32);
			panelFuncionario.add(banco);
			
			Conta1 = new JTextField();
			Conta1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Conta1.setText(Conta1.getText().replaceAll("[^0-9]", ""));
					// Conta1.setText(Conta1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Conta1.setDisabledTextColor(Color.BLACK);
			Conta1.setHorizontalAlignment(SwingConstants.CENTER);
			Conta1.setSelectionColor(SystemColor.textHighlight);
			Conta1.setForeground(Color.BLACK);
			Conta1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Conta1.setColumns(10);
			Conta1.setBounds(732, 514, 120, 32);
			panelFuncionario.add(Conta1);
			
			Telefone11 = new JFormattedTextField("");
			Telefone11.setDisabledTextColor(Color.BLACK);
			try {
				Telefone11.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Telefone11.setHorizontalAlignment(SwingConstants.CENTER);
			Telefone11.setSelectionColor(SystemColor.textHighlight);
			Telefone11.setForeground(Color.BLACK);
			Telefone11.setBounds(30, 589, 129, 32);
			Telefone11.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Telefone11.setColumns(10);
			panelFuncionario.add(Telefone11);
			
			Telefone21 = new JFormattedTextField("");
			Telefone21.setDisabledTextColor(Color.BLACK);
			try {
				Telefone21.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Telefone21.setHorizontalAlignment(SwingConstants.CENTER);
			Telefone21.setSelectionColor(SystemColor.textHighlight);
			Telefone21.setForeground(Color.BLACK);
			Telefone21.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Telefone21.setColumns(10);
			Telefone21.setBounds(171, 589, 129, 32);
			panelFuncionario.add(Telefone21);
			
			Celular11 = new JFormattedTextField("");
			Celular11.setDisabledTextColor(Color.BLACK);
			try {
				Celular11.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)#####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Celular11.setHorizontalAlignment(SwingConstants.CENTER);
			Celular11.setSelectionColor(SystemColor.textHighlight);
			Celular11.setForeground(Color.BLACK);
			Celular11.setBounds(310, 589, 129, 32);
			Celular11.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Celular11.setColumns(10);
			panelFuncionario.add(Celular11);
			
			Celular21 = new JFormattedTextField("");
			Celular21.setDisabledTextColor(Color.BLACK);
			try {
				Celular21.setFormatterFactory(new DefaultFormatterFactory(
						new MaskFormatter("(##)#####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Celular21.setHorizontalAlignment(SwingConstants.CENTER);
			Celular21.setSelectionColor(SystemColor.textHighlight);
			Celular21.setForeground(Color.BLACK);
			Celular21.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Celular21.setColumns(10);
			Celular21.setBounds(451, 589, 129, 32);
			panelFuncionario.add(Celular21);
			
			Logradouro1 = new JTextField();
			Logradouro1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Logradouro1.setText(Logradouro1.getText().replaceAll("[^0-9]",
					// ""));
					Logradouro1.setText(Logradouro1.getText().replaceAll("[^A-Z | ^a-z]",
							""));
				}
			});
			Logradouro1.setDisabledTextColor(Color.BLACK);
			Logradouro1.setHorizontalAlignment(SwingConstants.CENTER);
			Logradouro1.setSelectionColor(SystemColor.textHighlight);
			Logradouro1.setForeground(Color.BLACK);
			Logradouro1.setBounds(30, 452, 379, 32);
			Logradouro1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Logradouro1.setColumns(10);
			panelFuncionario.add(Logradouro1);
			
			Bairro1 = new JTextField();
			Bairro1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Bairro1.setText(Bairro1.getText().replaceAll("[^0-9]",
					// ""));
					Bairro1.setText(Bairro1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Bairro1.setDisabledTextColor(Color.BLACK);
			Bairro1.setHorizontalAlignment(SwingConstants.CENTER);
			Bairro1.setSelectionColor(SystemColor.textHighlight);
			Bairro1.setForeground(Color.BLACK);
			Bairro1.setBounds(493, 452, 165, 32);
			Bairro1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Bairro1.setColumns(10);
			panelFuncionario.add(Bairro1);
			
			Numero1 = new JTextField();
			Numero1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					Numero1.setText(Numero1.getText().replaceAll("[^0-9]", ""));
					// Numero1.setText(Numero1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			Numero1.setDisabledTextColor(Color.BLACK);
			Numero1.setSelectionColor(SystemColor.textHighlight);
			Numero1.setForeground(Color.BLACK);
			Numero1.setHorizontalAlignment(SwingConstants.CENTER);
			Numero1.setBounds(419, 452, 64, 32);
			Numero1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Numero1.setColumns(10);
			panelFuncionario.add(Numero1);
			
			Complemento1 = new JTextField();
			Complemento1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Complemento1.setText(Complemento1.getText().replaceAll("[^0-9]",
					// ""));
					Complemento1.setText(Complemento1.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			Complemento1.setDisabledTextColor(Color.BLACK);
			Complemento1.setHorizontalAlignment(SwingConstants.CENTER);
			Complemento1.setSelectionColor(SystemColor.textHighlight);
			Complemento1.setForeground(Color.BLACK);
			Complemento1.setBounds(503, 514, 165, 32);
			Complemento1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Complemento1.setColumns(10);
			panelFuncionario.add(Complemento1);
			
			Cep1 = new JFormattedTextField("");
			Cep1.setDisabledTextColor(Color.BLACK);
			try {
				Cep1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
						"#####-###")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			Cep1.setSelectionColor(SystemColor.textHighlight);
			Cep1.setForeground(Color.BLACK);
			Cep1.setHorizontalAlignment(SwingConstants.CENTER);
			Cep1.setBounds(30, 514, 170, 32);
			Cep1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cep1.setColumns(10);
			panelFuncionario.add(Cep1);
			panelFuncionario.add(comboUf);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			uf = new JTextField();
			uf.setDisabledTextColor(Color.BLACK);
			uf.setRequestFocusEnabled(false);
			uf.setVisible(false);
			uf.setSelectionColor(SystemColor.textHighlight);
			uf.setHorizontalAlignment(SwingConstants.CENTER);
			uf.setForeground(Color.BLACK);
			uf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			uf.setColumns(10);
			uf.setBorder(null);
			uf.setBounds(214, 514, 62, 32);
			panelFuncionario.add(uf);
			
			comboCidade = new JComboBox<String>();
			comboCidade.setForeground(Color.BLACK);
			comboCidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboCidade.setBounds(288, 514, 181, 32);
			comboCidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboCidade.setEditable(false);
			panelFuncionario.add(comboCidade);
			
			if (Inicio.rd == 0) {
				comboEstadoCivil.addItem("");
				comboEstadoCivil.addItem("Solteiro");
				comboEstadoCivil.addItem("Casado");
				comboEstadoCivil.addItem("Divorciado");
				comboEstadoCivil.addItem("Viúvo");
			}
			
			comboCargo = new JComboBox<String>();
			comboCargo.setForeground(Color.BLACK);
			comboCargo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboCargo.setBounds(918, 428, 165, 32);
			comboCargo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboCargo.setEditable(false);
			
			String sql1 = "select * from cargo_salario";
			ResultSet rs2 = x.Consultar(sql1);
			try {
				if (Inicio.rd == 0) {
					comboCargo.addItem("");
					while (rs2.next()) {
						comboCargo.addItem(rs2.getString("cargo"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
			
			comboCargo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item1 = evt.getItem();
					cargo = item1.toString();
					try {
						Salario1.removeAll();
						String sql = "select * from cargo_salario where cargo = '"
								+ cargo + "'";
						ResultSet rs3 = x.Consultar(sql);
						while (rs3.next()) {
							Salario1.setText(rs3.getString("salario"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});
			
			cidade = new JTextField();
			cidade.setDisabledTextColor(Color.BLACK);
			cidade.setRequestFocusEnabled(false);
			cidade.setVisible(false);
			cidade.setSelectionColor(SystemColor.textHighlight);
			cidade.setHorizontalAlignment(SwingConstants.CENTER);
			cidade.setForeground(Color.BLACK);
			cidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cidade.setColumns(10);
			cidade.setBorder(null);
			cidade.setBounds(288, 514, 177, 32);
			panelFuncionario.add(cidade);
			panelFuncionario.add(comboCargo);
			
			cargo_1 = new JTextField();
			cargo_1.setDisabledTextColor(Color.BLACK);
			cargo_1.setRequestFocusEnabled(false);
			cargo_1.setVisible(false);
			cargo_1.setSelectionColor(SystemColor.textHighlight);
			cargo_1.setHorizontalAlignment(SwingConstants.CENTER);
			cargo_1.setForeground(Color.BLACK);
			cargo_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cargo_1.setColumns(10);
			cargo_1.setBorder(null);
			cargo_1.setBounds(918, 428, 165, 32);
			panelFuncionario.add(cargo_1);
			
			Salario1 = new JTextField();
			Salario1.setSelectionColor(SystemColor.textHighlight);
			Salario1.setForeground(Color.BLACK);
			Salario1.setDisabledTextColor(Color.BLACK);
			Salario1.setEnabled(false);
			Salario1.setBounds(1154, 428, 165, 32);
			Salario1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Salario1.setEditable(false);
			Salario1.setColumns(10);
			panelFuncionario.add(Salario1);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboDepartamento = new JComboBox<String>();
			comboDepartamento.setForeground(Color.BLACK);
			comboDepartamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboDepartamento.setBounds(1154, 368, 165, 32);
			comboDepartamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboDepartamento.setEditable(false);
			panelFuncionario.add(comboDepartamento);
			
			if (Inicio.rd == 0) {
				comboDepartamento.addItem("");
				comboDepartamento.addItem("TI");
				comboDepartamento.addItem("RH");
				comboDepartamento.addItem("Vendas");
				comboDepartamento.addItem("Logistica");
				comboDepartamento.addItem("Financeiro");
			}
			
			comboNivel = new JComboBox<String>();
			comboNivel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboNivel.setForeground(Color.BLACK);
			comboNivel.setBorder(null);
			comboNivel.setBounds(918, 596, 165, 32);
			comboNivel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboNivel.setEditable(false);
			comboNivel.addItem("");
			comboNivel.addItem("Administrador");
			comboNivel.addItem("Usuário");
			
			departamento = new JTextField();
			departamento.setDisabledTextColor(Color.BLACK);
			departamento.setRequestFocusEnabled(false);
			departamento.setVisible(false);
			departamento.setSelectionColor(SystemColor.textHighlight);
			departamento.setHorizontalAlignment(SwingConstants.CENTER);
			departamento.setForeground(Color.BLACK);
			departamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			departamento.setColumns(10);
			departamento.setBorder(null);
			departamento.setBounds(1154, 368, 165, 32);
			panelFuncionario.add(departamento);
			
			Usuario1 = new JTextField();
			Usuario1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// Usuario1.setText(Usuario1.getText().replaceAll("[^0-9]",
					// ""));
					Usuario1.setText(Usuario1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			Usuario1.setDisabledTextColor(Color.BLACK);
			Usuario1.setHorizontalAlignment(SwingConstants.CENTER);
			Usuario1.setSelectionColor(SystemColor.textHighlight);
			Usuario1.setForeground(Color.BLACK);
			Usuario1.setBounds(918, 533, 165, 32);
			Usuario1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Usuario1.setColumns(10);
			panelFuncionario.add(Usuario1);
			
			Senha1 = new JPasswordField();
			Senha1.setDisabledTextColor(Color.BLACK);
			Senha1.setHorizontalAlignment(SwingConstants.CENTER);
			Senha1.setSelectionColor(SystemColor.textHighlight);
			Senha1.setForeground(Color.BLACK);
			Senha1.setBounds(1154, 533, 165, 32);
			Senha1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Senha1.setColumns(10);
			panelFuncionario.add(Senha1);
			panelFuncionario.add(comboNivel);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			try {
			}
			catch (Exception e) {
				System.out.println("error " + e.getMessage());
			}
			panelFuncionario.setLayout(null);
			
			nivel = new JTextField();
			nivel.setDisabledTextColor(Color.BLACK);
			nivel.setRequestFocusEnabled(false);
			nivel.setVisible(false);
			nivel.setSelectionColor(SystemColor.textHighlight);
			nivel.setHorizontalAlignment(SwingConstants.CENTER);
			nivel.setForeground(Color.BLACK);
			nivel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nivel.setColumns(10);
			nivel.setBorder(null);
			nivel.setBounds(918, 597, 165, 32);
			panelFuncionario.add(nivel);
			
			Dependentes1 = new JTextField();
			Dependentes1.setForeground(Color.BLACK);
			Dependentes1.setVisible(false);
			Dependentes1.setSelectionColor(SystemColor.textHighlight);
			Dependentes1.setDisabledTextColor(Color.BLACK);
			Dependentes1.setEnabled(false);
			Dependentes1.setHorizontalAlignment(SwingConstants.CENTER);
			Dependentes1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Dependentes1.setEditable(false);
			Dependentes1.setBounds(947, 265, 49, 32);
			panelFuncionario.add(Dependentes1);
			Dependentes1.setText("0");
			
			agencia = new JTextField();
			agencia.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					agencia.setText(agencia.getText().replaceAll("[^0-9]", ""));
					// agencia.setText(agencia.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			agencia.setSelectionColor(SystemColor.textHighlight);
			agencia.setHorizontalAlignment(SwingConstants.CENTER);
			agencia.setForeground(Color.BLACK);
			agencia.setFont(new Font("Kalinga", Font.PLAIN, 14));
			agencia.setDisabledTextColor(Color.BLACK);
			agencia.setColumns(10);
			agencia.setBounds(732, 576, 120, 32);
			panelFuncionario.add(agencia);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// Tabela
			final JScrollPane scrollPaneDependentes_1 = new JScrollPane();
			scrollPaneDependentes_1
					.setForeground(UIManager.getColor("ScrollPane.background"));
			scrollPaneDependentes_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			scrollPaneDependentes_1.setAutoscrolls(true);
			scrollPaneDependentes_1.setFocusable(false);
			scrollPaneDependentes_1.setBounds(918, 163, 400, 78);
			panelFuncionario.add(scrollPaneDependentes_1);
			scrollPaneDependentes_1.setVisible(false);
			
			final String[] colunas = { "NOME DO DEPENDENTE", "PARENTESCO" };
			final Object[][] dados = { { "", "Esposa" }, };
			
			tabbleDependentes = new JTable(dados, colunas);
			tabbleDependentes.setSelectionBackground(SystemColor.scrollbar);
			tabbleDependentes.setForeground(Color.BLACK);
			tabbleDependentes.setGridColor(UIManager.getColor("TabbedPane.light"));
			tabbleDependentes.setShowHorizontalLines(true);
			tabbleDependentes.setShowVerticalLines(true);
			tabbleDependentes.setRowMargin(1);
			tabbleDependentes.setCellSelectionEnabled(true);
			tabbleDependentes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tabbleDependentes.setModel(new DefaultTableModel(
					new Object[][] { { "", "Esposa" }, }, new String[] {
							"NOME DO DEPENDENTE", "PARENTESCO" }));
			tabbleDependentes.getColumnModel().getColumn(0).setPreferredWidth(250);
			tabbleDependentes.getColumnModel().getColumn(1).setPreferredWidth(82);
			tabbleDependentes.setRowHeight(24);
			tabbleDependentes.setAutoCreateRowSorter(true);
			tabbleDependentes.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tabbleDependentes.setColumnSelectionAllowed(true);
			final DefaultTableModel modelo = (DefaultTableModel) tabbleDependentes.getModel();
			
			scrollPaneDependentes_1.setViewportView(tabbleDependentes);
			
			btAdicionarDependente = new JButton("Adicionar");
			btAdicionarDependente.setForeground(Color.BLACK);
			btAdicionarDependente.setToolTipText("alt + Insert");
			btAdicionarDependente.setMnemonic(KeyEvent.VK_INSERT);
			btAdicionarDependente.setFocusTraversalPolicyProvider(true);
			btAdicionarDependente.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			btAdicionarDependente.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAdicionarDependente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAdicionarDependente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					modelo.addRow(new String[] { " ", "Filho" });
					
					int d = Integer.parseInt(Dependentes1.getText());
					d++;
					Dependentes1.setText(String.valueOf(d));
				}
			});
			
			comboPor = new JComboBox<String>();
			comboPor.setForeground(Color.BLACK);
			comboPor.setVisible(false);
			comboPor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboPor.addItem("");
			comboPor.addItem("Numero de Registro");
			comboPor.addItem("Nome");
			comboPor.addItem("CPF");
			comboPor.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String tipoConsulta = item.toString();
					if (tipoConsulta.equals("Numero de Registro")) {
						NumeroRegistro1.setEnabled(true);
						NumeroRegistro1.setEditable(true);
						NumeroRegistro1.setRequestFocusEnabled(true);
						NumeroRegistro1.setBorder(new LineBorder(Color.BLUE));
						
						Nome1.setEnabled(true);
						Nome1.setEditable(true);
						Nome1.setBorder(null);
						
						Cpf1.setEnabled(true);
						Cpf1.setEditable(true);
						Cpf1.setBorder(null);
						
					}
					else if (tipoConsulta.equals("Nome")) {
						NumeroRegistro1.setEnabled(false);
						NumeroRegistro1.setEditable(false);
						NumeroRegistro1.setBorder(null);
						
						Nome1.setEnabled(true);
						Nome1.setEditable(true);
						Nome1.setRequestFocusEnabled(true);
						// Nome1.setBorder(new
						// LineBorder(Color.BLUE));
						
						Cpf1.setEnabled(false);
						Cpf1.setEditable(false);
						Cpf1.setBorder(null);
						
					}
					else if (tipoConsulta.equals("CPF")) {
						NumeroRegistro1.setEnabled(false);
						NumeroRegistro1.setEditable(false);
						NumeroRegistro1.setBorder(null);
						
						Nome1.setEnabled(false);
						Nome1.setEditable(false);
						// Nome1.setBorder(null);
						
						Cpf1.setEnabled(true);
						Cpf1.setEditable(true);
						Cpf1.setRequestFocusEnabled(true);
						Cpf1.setBorder(new LineBorder(Color.BLUE));
					}
				}
			});
			
			comboPor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboPor.setBounds(917, 61, 131, 32);
			panelFuncionario.add(comboPor);
			
			radioSim = new JRadioButton("Sim");
			radioSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioSim.setFocusTraversalPolicyProvider(true);
			radioSim.setOpaque(false);
			radioSim.setForeground(Color.BLACK);
			radioSim.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioSim.setBounds(1157, 143, 63, 32);
			panelFuncionario.add(radioSim);
			
			radioSim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sn = 1;
					if (sn == 1) {
						radioNao.setSelected(false);
						radioSim.setSelected(true);
						scrollPaneDependentes_1.setVisible(true);
						btRemoverDependente.setVisible(true);
						btAdicionarDependente.setVisible(true);
						labelDependentes_2.setVisible(true);
						Dependentes1.setVisible(true);
						Dependentes1.setText("1");
					}
				}
			});
			
			radioNao = new JRadioButton("Não");
			radioNao.setSelected(true);
			radioNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioNao.setFocusTraversalPolicyProvider(true);
			radioNao.setOpaque(false);
			radioNao.setForeground(Color.BLACK);
			radioNao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioNao.setBounds(1221, 143, 64, 32);
			panelFuncionario.add(radioNao);
			
			radioNao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sn = 0;
					if (sn == 0) {
						radioSim.setSelected(false);
						radioNao.setSelected(true);
						scrollPaneDependentes_1.setVisible(false);
						btRemoverDependente.setVisible(false);
						btAdicionarDependente.setVisible(false);
						labelDependentes_2.setVisible(false);
						Dependentes1.setVisible(false);
						Dependentes1.setText("0");
						comboNivel.setVisible(false);
						nivel.setVisible(false);
					}
				}
			});
			
			radioSim2 = new JRadioButton("Sim");
			radioSim2.setForeground(Color.BLACK);
			radioSim2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					radioNao2.setSelected(false);
					radioSim2.setSelected(true);
					labelUsuario_1.setVisible(true);
					labelSenha.setVisible(true);
					labelNivel.setVisible(true);
					Usuario1.setVisible(true);
					Senha1.setVisible(true);
					comboNivel.setVisible(true);
				}
			});
			radioSim2.setHorizontalAlignment(SwingConstants.CENTER);
			radioSim2.setOpaque(false);
			radioSim2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioSim2.setBounds(1150, 483, 64, 32);
			radioSim2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panelFuncionario.add(radioSim2);
			
			radioNao2 = new JRadioButton("Não");
			radioNao2.setForeground(Color.BLACK);
			radioNao2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					radioNao2.setSelected(true);
					radioSim2.setSelected(false);
					labelUsuario_1.setVisible(false);
					labelSenha.setVisible(false);
					labelNivel.setVisible(false);
					Usuario1.setVisible(false);
					Senha1.setVisible(false);
					comboNivel.setVisible(false);
				}
			});
			radioNao2.setHorizontalAlignment(SwingConstants.CENTER);
			radioNao2.setOpaque(false);
			radioNao2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioNao2.setBounds(1216, 483, 64, 32);
			radioNao2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			panelFuncionario.add(radioNao2);
			
			radioCadastrar = new JRadioButton("Cadastrar Funcionário");
			radioCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioCadastrar.setSelected(true);
			radioCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						// here you can put the selected theme class
						// name
						// in JTattoo
						Properties props = new Properties();
						props.put("logoString", "Solid - One");
						McWinLookAndFeel.setCurrentTheme(props);
						UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
						
						RH.SetarEditavel();
						RH.LimparDados();
						RH.button_2.setEnabled(false);
						RH.btnImprimir.setEnabled(false);
						RH.btnAnterior.setEnabled(false);
						RH.btnPrximo.setEnabled(false);
						btnAtualizar.setVisible(false);
						
						String sql21 = "select * from contadores";
						ResultSet rs31 = x.Consultar(sql21);
						try {
							if (Inicio.rd == 0) {
								while (rs31.next()) {
									NumeroRegistro1.setText(rs31
											.getString("numeroRegistro"));
								}
							}
						}
						catch (SQLException ex) {
							ex.printStackTrace();
						}
						
					}
					catch (ClassNotFoundException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
				}
			});
			radioCadastrar.setOpaque(false);
			radioCadastrar.setForeground(Color.BLACK);
			radioCadastrar.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioCadastrar.setAlignmentX(0.5f);
			radioCadastrar.setBounds(468, 61, 200, 32);
			panelFuncionario.add(radioCadastrar);
			
			radioConsultar = new JRadioButton("Consultar Funcionário");
			radioConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					RH.SetarEditavelFalso();
					lblPor.setVisible(true);
					comboPor.setVisible(true);
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
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (InstantiationException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (IllegalAccessException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
					catch (javax.swing.UnsupportedLookAndFeelException ex) {
						java.util.logging.Logger.getLogger(RH.class.getName()).log(
								java.util.logging.Level.SEVERE, null, ex);
					}
				}
			});
			radioConsultar.setOpaque(false);
			radioConsultar.setForeground(Color.BLACK);
			radioConsultar.setFont(new Font("Khmer UI", Font.BOLD, 14));
			radioConsultar.setAlignmentX(0.5f);
			radioConsultar.setBounds(688, 61, 200, 32);
			panelFuncionario.add(radioConsultar);
			btAdicionarDependente.setBounds(1024, 261, 146, 35);
			panelFuncionario.add(btAdicionarDependente);
			btAdicionarDependente.setVisible(false);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			btRemoverDependente = new JButton("Remover");
			btRemoverDependente.setForeground(Color.BLACK);
			btRemoverDependente.setToolTipText("alt + Delete");
			btRemoverDependente.setMnemonic(KeyEvent.VK_DELETE);
			btRemoverDependente.setFocusTraversalPolicyProvider(true);
			btRemoverDependente.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btRemoverDependente.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btRemoverDependente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btRemoverDependente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int d = Integer.parseInt(Dependentes1.getText());
					d--;
					if (d >= 1) {
						modelo.removeRow(d);
						Dependentes1.setText(String.valueOf(d));
					}
				}
			});
			btRemoverDependente.setBounds(1172, 261, 146, 35);
			panelFuncionario.add(btRemoverDependente);
			btRemoverDependente.setVisible(false);
			
			if (sn == 0) {
				Usuario1.setVisible(false);
				Senha1.setVisible(false);
				comboNivel.setVisible(false);
				radioSim2.setSelected(false);
				radioNao2.setSelected(true);
				
				radioSim2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sn = 1;
						if (sn == 1) {
							Usuario1.setVisible(true);
							Senha1.setVisible(true);
							comboNivel.setVisible(true);
							labelUsuario_1.setVisible(true);
							labelSenha.setVisible(true);
							labelNivel.setVisible(true);
							Usuario1.setEditable(true);
							Senha1.setEditable(true);
							radioNao2.setSelected(false);
							radioSim2.setSelected(true);
						}
					}
				});
				
				radioNao2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sn = 0;
						if (sn == 0) {
							comboNivel.setSelectedItem(null);
							Usuario1.setVisible(false);
							Senha1.setVisible(false);
							comboNivel.setVisible(false);
							labelUsuario_1.setVisible(false);
							labelSenha.setVisible(false);
							labelNivel.setVisible(false);
							Usuario1.setEditable(false);
							Senha1.setEditable(false);
							radioSim2.setSelected(false);
							radioNao2.setSelected(true);
						}
					}
				});
			}
			
			/*
			 * 
			 * Panel Holerite
			 */
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelCargoSalario = new JPanel();
			panelCargoSalario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelCargoSalario.setBackground(SystemColor.inactiveCaptionBorder);
			panelCargoSalario.setLayout(null);
			
			JButton btnSelecionar = new JButton("Selecionar");
			btnSelecionar.setForeground(Color.BLACK);
			btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSelecionar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					RHController.SelecionarFotoFuncionario();
				}
			});
			btnSelecionar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606755_camera-alt-128.png")));
			btnSelecionar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnSelecionar.setBounds(716, 243, 146, 35);
			panelFuncionario.add(btnSelecionar);
			
			JMenuBar menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(180, 0, 990, 32);
			panelFuncionario.add(menuBar_1);
			
			btSalvar = new JButton("Salvar");
			btSalvar.setForeground(Color.BLACK);
			menuBar_1.add(btSalvar);
			btSalvar.setToolTipText("alt + Enter");
			btSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btSalvar.setMnemonic(KeyEvent.VK_ENTER);
			btSalvar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			
			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setForeground(Color.BLACK);
			menuBar_1.add(btnAtualizar);
			btnAtualizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					RHController.AtualizarFuncionario();
				}
			});
			btnAtualizar.setVisible(false);
			btnAtualizar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnAtualizar.setToolTipText("alt + Enter");
			btnAtualizar.setMnemonic(KeyEvent.VK_ENTER);
			btnAtualizar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btConsultar = new JButton("Consultar");
			btConsultar.setForeground(Color.BLACK);
			btConsultar.setToolTipText("alt + Enter");
			menuBar_1.add(btConsultar);
			btConsultar.setVisible(false);
			btConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RHController.ConsultarFuncionario();
				}
			});
			btConsultar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606561_search-128.png")));
			btConsultar.setMnemonic(KeyEvent.VK_ENTER);
			btConsultar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			menuBar_1.add(btnCancelar);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RH.SetarEditavelFalso();
					RH.button_2.setEnabled(false);
					RH.btnImprimir.setEnabled(false);
					RH.btnAnterior.setEnabled(false);
					RH.btnPrximo.setEnabled(false);
				}
			});
			btnCancelar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar.setToolTipText("alt + Space");
			btnCancelar.setMnemonic(KeyEvent.VK_SPACE);
			btnCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar.setFocusTraversalPolicyProvider(true);
			btnCancelar.setFocusCycleRoot(true);
			btnCancelar.setAlignmentX(0.5f);
			
			btLimpar = new JButton("Limpar");
			btLimpar.setForeground(Color.BLACK);
			menuBar_1.add(btLimpar);
			btLimpar.setToolTipText("alt + Backspace");
			btLimpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btLimpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btLimpar.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			
			button_2 = new JButton("Alterar");
			button_2.setForeground(Color.BLACK);
			menuBar_1.add(button_2);
			button_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					RH.SetarEditavel();
					comboEscolaridade.setSelectedItem(escolaridade.getText());
					comboEstadoCivil.setSelectedItem(estadoCivil.getText());
					comboUf.setSelectedItem(uf.getText());
					comboCidade.setSelectedItem(cidade.getText());
					comboBanco.setSelectedItem(banco.getText());
					comboContrato.setSelectedItem(contrato.getText());
					comboDepartamento.setSelectedItem(departamento.getText());
					comboCargo.setSelectedItem(cargo_1.getText());
					comboNivel.setSelectedItem(nivel.getText());
					btnAtualizar.setVisible(true);
				}
			});
			button_2.setEnabled(false);
			button_2.setToolTipText("alt + Space");
			button_2.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_2.setMnemonic(KeyEvent.VK_SPACE);
			button_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_2.setFocusTraversalPolicyProvider(true);
			button_2.setFocusCycleRoot(true);
			button_2.setAlignmentX(0.5f);
			
			btnImprimir = new JButton("Imprimir");
			btnImprimir.setForeground(Color.BLACK);
			menuBar_1.add(btnImprimir);
			btnImprimir.setEnabled(false);
			btnImprimir.setToolTipText("alt + P");
			btnImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					report.Funcionarios();
				}
			});
			btnImprimir.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			btnImprimir.setMnemonic(KeyEvent.VK_P);
			btnImprimir.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btnAnterior = new JButton("Anterior");
			btnAnterior.setForeground(Color.BLACK);
			menuBar_1.add(btnAnterior);
			btnAnterior.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425605893_arrow_left.png")));
			btnAnterior.setToolTipText("alt + ←");
			btnAnterior.setMnemonic(KeyEvent.VK_P);
			btnAnterior.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAnterior.setEnabled(false);
			
			btnPrximo = new JButton("Próximo");
			btnPrximo.setForeground(Color.BLACK);
			menuBar_1.add(btnPrximo);
			btnPrximo.setHorizontalTextPosition(SwingConstants.LEFT);
			btnPrximo.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425605875_arrow_right.png")));
			btnPrximo.setToolTipText("alt + →");
			btnPrximo.setMnemonic(KeyEvent.VK_SPACE);
			btnPrximo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnPrximo.setFocusTraversalPolicyProvider(true);
			btnPrximo.setFocusCycleRoot(true);
			btnPrximo.setEnabled(false);
			btnPrximo.setAlignmentX(0.5f);
			btLimpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RH.LimparDados();
				}
			});
			btSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RHController.SalvarFuncionario();
				}
			});
			
			JSeparator separator = new JSeparator();
			separator.setBounds(928, 482, 360, 2);
			panelFuncionario.add(separator);
			
			labelFotoFuncionario = new JLabel("(165x115)");
			labelFotoFuncionario.setForeground(Color.BLACK);
			labelFotoFuncionario.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_48px/1425606663_image-128.png")));
			labelFotoFuncionario.setOpaque(true);
			labelFotoFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
			labelFotoFuncionario.setBorder(new LineBorder(Color.LIGHT_GRAY));
			labelFotoFuncionario.setBackground(Color.WHITE);
			labelFotoFuncionario.setBounds(717, 143, 145, 95);
			panelFuncionario.add(labelFotoFuncionario);
			
			labelNumero = new JLabel("Número");
			labelNumero.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNumero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumero.setBounds(419, 421, 64, 32);
			labelNumero.setForeground(Color.BLACK);
			panelFuncionario.add(labelNumero);
			
			labelComplemento_1 = new JLabel("Complemento");
			labelComplemento_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelComplemento_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelComplemento_1.setBounds(503, 483, 104, 32);
			labelComplemento_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelComplemento_1);
			
			labelBairro_1 = new JLabel("Bairro");
			labelBairro_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelBairro_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelBairro_1.setBounds(493, 421, 80, 32);
			labelBairro_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelBairro_1);
			
			labelUf_1 = new JLabel("UF");
			labelUf_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelUf_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelUf_1.setBounds(212, 483, 49, 32);
			labelUf_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelUf_1);
			
			labelCidade_1 = new JLabel("Cidade");
			labelCidade_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCidade_1.setBounds(288, 483, 49, 32);
			labelCidade_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelCidade_1);
			
			labelNacionalidade = new JLabel("Nacionalidade");
			labelNacionalidade.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNacionalidade.setForeground(Color.BLACK);
			labelNacionalidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNacionalidade.setBounds(30, 190, 104, 32);
			panelFuncionario.add(labelNacionalidade);
			
			labelNomePai = new JLabel("Nome do Pai");
			labelNomePai.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNomePai.setForeground(Color.BLACK);
			labelNomePai.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNomePai.setBounds(30, 313, 104, 32);
			panelFuncionario.add(labelNomePai);
			
			labelNomeMae = new JLabel("Nome da Mãe");
			labelNomeMae.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNomeMae.setForeground(Color.BLACK);
			labelNomeMae.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNomeMae.setBounds(461, 313, 119, 32);
			panelFuncionario.add(labelNomeMae);
			
			labelTelefone2 = new JLabel("Telefone 2");
			labelTelefone2.setHorizontalTextPosition(SwingConstants.CENTER);
			labelTelefone2.setForeground(Color.BLACK);
			labelTelefone2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone2.setBounds(171, 559, 80, 32);
			panelFuncionario.add(labelTelefone2);
			
			labelCelular2 = new JLabel("Cel 2");
			labelCelular2.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCelular2.setForeground(Color.BLACK);
			labelCelular2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCelular2.setBounds(451, 559, 41, 32);
			panelFuncionario.add(labelCelular2);
			
			labelAdmissao = new JLabel("Admissão");
			labelAdmissao.setHorizontalTextPosition(SwingConstants.CENTER);
			labelAdmissao.setForeground(Color.BLACK);
			labelAdmissao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelAdmissao.setBounds(918, 338, 80, 32);
			panelFuncionario.add(labelAdmissao);
			
			labelContrato = new JLabel("Contrato");
			labelContrato.setHorizontalTextPosition(SwingConstants.CENTER);
			labelContrato.setForeground(Color.BLACK);
			labelContrato.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelContrato.setBounds(1010, 338, 69, 32);
			panelFuncionario.add(labelContrato);
			
			labelConta = new JLabel("Conta");
			labelConta.setHorizontalTextPosition(SwingConstants.CENTER);
			labelConta.setForeground(Color.BLACK);
			labelConta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelConta.setBounds(732, 486, 49, 26);
			panelFuncionario.add(labelConta);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			labelBanco = new JLabel("Banco");
			labelBanco.setHorizontalTextPosition(SwingConstants.CENTER);
			labelBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelBanco.setForeground(Color.BLACK);
			labelBanco.setBounds(732, 421, 54, 32);
			panelFuncionario.add(labelBanco);
			
			labelEscolaridade = new JLabel("Escolaridade");
			labelEscolaridade.setHorizontalTextPosition(SwingConstants.CENTER);
			labelEscolaridade.setForeground(Color.BLACK);
			labelEscolaridade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEscolaridade.setBounds(30, 253, 104, 32);
			panelFuncionario.add(labelEscolaridade);
			
			labelDependentes_1 = new JLabel("Cadastrar Dependentes?");
			labelDependentes_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelDependentes_1.setIcon(null);
			labelDependentes_1.setForeground(Color.BLACK);
			labelDependentes_1.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelDependentes_1.setBounds(950, 132, 209, 32);
			panelFuncionario.add(labelDependentes_1);
			
			labelNumeroRegistro = new JLabel("Nº de Registro");
			labelNumeroRegistro.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNumeroRegistro.setForeground(Color.BLACK);
			labelNumeroRegistro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroRegistro.setBounds(30, 132, 113, 32);
			panelFuncionario.add(labelNumeroRegistro);
			
			labelNome = new JLabel("Nome");
			labelNome.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNome.setBounds(214, 129, 49, 32);
			panelFuncionario.add(labelNome);
			
			labelNascimento = new JLabel("Nascimento");
			labelNascimento.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNascimento.setForeground(Color.BLACK);
			labelNascimento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNascimento.setBounds(614, 135, 92, 26);
			panelFuncionario.add(labelNascimento);
			
			labelRg_1 = new JLabel("RG");
			labelRg_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelRg_1.setForeground(Color.BLACK);
			labelRg_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelRg_1.setBounds(214, 190, 41, 32);
			panelFuncionario.add(labelRg_1);
			
			labelCpf = new JLabel("CPF");
			labelCpf.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCpf.setBounds(398, 190, 41, 32);
			panelFuncionario.add(labelCpf);
			
			labelCtps_1 = new JLabel("CTPS");
			labelCtps_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCtps_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCtps_1.setBounds(568, 190, 41, 32);
			labelCtps_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelCtps_1);
			
			labelDependentes_2 = new JLabel("Dependentes");
			labelDependentes_2.setHorizontalTextPosition(SwingConstants.CENTER);
			labelDependentes_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelDependentes_2.setBounds(919, 238, 104, 32);
			labelDependentes_2.setForeground(Color.BLACK);
			labelDependentes_2.setVisible(false);
			panelFuncionario.add(labelDependentes_2);
			
			labelTelefone_1 = new JLabel("Telefone");
			labelTelefone_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelTelefone_1.setForeground(Color.BLACK);
			labelTelefone_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone_1.setBounds(30, 557, 69, 32);
			panelFuncionario.add(labelTelefone_1);
			
			labelCelular = new JLabel("Cel");
			labelCelular.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCelular.setForeground(Color.BLACK);
			labelCelular.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCelular.setBounds(310, 559, 41, 32);
			panelFuncionario.add(labelCelular);
			
			labelEstadoCivil = new JLabel("Estado Civil");
			labelEstadoCivil.setHorizontalTextPosition(SwingConstants.CENTER);
			labelEstadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEstadoCivil.setBounds(568, 253, 92, 32);
			labelEstadoCivil.setForeground(Color.BLACK);
			panelFuncionario.add(labelEstadoCivil);
			
			labelEmail_1 = new JLabel("E-mail");
			labelEmail_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelEmail_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelEmail_1.setBounds(214, 251, 54, 32);
			labelEmail_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelEmail_1);
			
			labelEndereco_1 = new JLabel("Logradouro");
			labelEndereco_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelEndereco_1.setBounds(30, 421, 100, 32);
			labelEndereco_1.setForeground(Color.BLACK);
			labelEndereco_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelFuncionario.add(labelEndereco_1);
			
			labelCep_1 = new JLabel("CEP");
			labelCep_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCep_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCep_1.setBounds(30, 483, 41, 32);
			labelCep_1.setForeground(Color.BLACK);
			panelFuncionario.add(labelCep_1);
			
			labelLogin = new JLabel("Cadastrar Login de Rede?");
			labelLogin.setHorizontalTextPosition(SwingConstants.CENTER);
			labelLogin.setBounds(938, 483, 187, 32);
			labelLogin.setForeground(Color.BLACK);
			labelLogin.setFont(new Font("Kalinga", Font.BOLD, 14));
			panelFuncionario.add(labelLogin);
			
			labelCargo = new JLabel("Cargo");
			labelCargo.setHorizontalTextPosition(SwingConstants.CENTER);
			labelCargo.setForeground(Color.BLACK);
			labelCargo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCargo.setBounds(918, 398, 94, 32);
			labelCargo.setIcon(new ImageIcon(RH.class.getResource("")));
			panelFuncionario.add(labelCargo);
			
			labelUsuario_1 = new JLabel("Usuário");
			labelUsuario_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelUsuario_1.setForeground(Color.BLACK);
			labelUsuario_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelUsuario_1.setBounds(918, 509, 104, 32);
			labelUsuario_1.setIcon(new ImageIcon(RH.class.getResource("")));
			labelUsuario_1.setVisible(false);
			panelFuncionario.add(labelUsuario_1);
			
			labelSalario = new JLabel("Salário");
			labelSalario.setHorizontalTextPosition(SwingConstants.CENTER);
			labelSalario.setForeground(Color.BLACK);
			labelSalario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelSalario.setBounds(1154, 398, 94, 32);
			labelSalario.setIcon(new ImageIcon(RH.class.getResource("")));
			panelFuncionario.add(labelSalario);
			
			labelSenha = new JLabel("Senha");
			labelSenha.setHorizontalTextPosition(SwingConstants.CENTER);
			labelSenha.setForeground(Color.BLACK);
			labelSenha.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelSenha.setBounds(1154, 509, 104, 32);
			labelSenha.setIcon(new ImageIcon(RH.class.getResource("")));
			labelSenha.setVisible(false);
			panelFuncionario.add(labelSenha);
			
			labelDepartamento = new JLabel("Departamento");
			labelDepartamento.setHorizontalTextPosition(SwingConstants.CENTER);
			labelDepartamento.setForeground(Color.BLACK);
			labelDepartamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelDepartamento.setBounds(1154, 338, 129, 32);
			labelDepartamento.setIcon(null);
			panelFuncionario.add(labelDepartamento);
			
			labelNivel = new JLabel("Nível");
			labelNivel.setForeground(Color.BLACK);
			labelNivel.setHorizontalTextPosition(SwingConstants.CENTER);
			labelNivel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNivel.setBounds(919, 566, 104, 32);
			labelNivel.setIcon(null);
			labelNivel.setVisible(false);
			panelFuncionario.add(labelNivel);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			lblPor = new JLabel("Por ?");
			lblPor.setForeground(Color.BLACK);
			lblPor.setVisible(false);
			
			JLabel lblAgncia = new JLabel("Agência");
			lblAgncia.setHorizontalTextPosition(SwingConstants.CENTER);
			lblAgncia.setForeground(Color.BLACK);
			lblAgncia.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblAgncia.setBounds(732, 548, 57, 26);
			panelFuncionario.add(lblAgncia);
			lblPor.setFont(new Font("Kalinga", Font.BOLD, 14));
			lblPor.setBounds(874, 61, 38, 32);
			panelFuncionario.add(lblPor);
			
			JLabel label_8 = new JLabel("");
			label_8.setForeground(Color.BLACK);
			label_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS PESSOAIS", TitledBorder.LEFT, TitledBorder.TOP, null,
					Color.DARK_GRAY));
			label_8.setBounds(10, 116, 878, 272);
			panelFuncionario.add(label_8);
			
			JLabel label_9 = new JLabel("");
			label_9.setForeground(Color.BLACK);
			label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_9.setBounds(10, 394, 677, 252);
			panelFuncionario.add(label_9);
			
			JLabel label_10 = new JLabel("");
			label_10.setForeground(Color.BLACK);
			label_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_10.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DEPENDENTES", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_10.setBounds(893, 116, 442, 195);
			panelFuncionario.add(label_10);
			
			label_11 = new JLabel("");
			label_11.setForeground(Color.BLACK);
			label_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DO CARGO", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_11.setBounds(893, 321, 442, 325);
			panelFuncionario.add(label_11);
			
			label_12 = new JLabel("");
			label_12.setForeground(Color.BLACK);
			label_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_12.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS BANC\u00C1RIOS", TitledBorder.LEFT, TitledBorder.TOP,
					null, new Color(64, 64, 64)));
			label_12.setBounds(696, 394, 192, 252);
			panelFuncionario.add(label_12);
			
			JLabel label_7 = new JLabel("");
			label_7.setForeground(Color.BLACK);
			label_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_7.setBounds(10, 43, 1325, 69);
			panelFuncionario.add(label_7);
			
			// Inicio.rd=1;
			
			labelFundoFuncionario = new JLabel("");
			labelFundoFuncionario.setForeground(Color.BLACK);
			labelFundoFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoFuncionario.setBounds(0, 0, 1366, 768);
			labelFundoFuncionario.setIcon(new ImageIcon(RH.class
					.getResource("/papel_parede/04.jpg")));
			panelFuncionario.add(labelFundoFuncionario);
			
			CadastrarCargo = new JTextField();
			CadastrarCargo.setForeground(Color.BLACK);
			CadastrarCargo.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// CadastrarCargo.setText(CadastrarCargo.getText().replaceAll("[^0-9]",
					// ""));
					CadastrarCargo.setText(CadastrarCargo.getText().replaceAll(
							"[^A-Z | ^a-z]", ""));
				}
			});
			CadastrarCargo.setSelectionColor(SystemColor.textHighlight);
			CadastrarCargo.setDisabledTextColor(SystemColor.textText);
			CadastrarCargo.setHorizontalAlignment(SwingConstants.CENTER);
			CadastrarCargo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			CadastrarCargo.setBounds(24, 199, 325, 32);
			panelCargoSalario.add(CadastrarCargo);
			CadastrarCargo.setColumns(10);
			
			CadastrarSalario = new JTextField();
			CadastrarSalario.setForeground(Color.BLACK);
			CadastrarSalario.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					CadastrarSalario.setText(CadastrarSalario.getText().replaceAll(
							"[^0-9]", ""));
					// CadastrarSalario.setText(CadastrarSalario.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			CadastrarSalario.setSelectionColor(SystemColor.textHighlight);
			CadastrarSalario.setDisabledTextColor(SystemColor.textText);
			CadastrarSalario.setHorizontalAlignment(SwingConstants.CENTER);
			CadastrarSalario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			CadastrarSalario.setColumns(10);
			CadastrarSalario.setBounds(375, 199, 120, 32);
			panelCargoSalario.add(CadastrarSalario);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			comboDepartamento1 = new JComboBox<String>();
			comboDepartamento1.setForeground(Color.BLACK);
			comboDepartamento1.addItem("");
			comboDepartamento1.addItem("RH");
			comboDepartamento1.addItem("Suprimentos");
			comboDepartamento1.addItem("Vendas");
			comboDepartamento1.addItem("Logistica");
			comboDepartamento1.addItem("Financeiro");
			comboDepartamento1.addItem("Outro..");
			comboDepartamento1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboDepartamento1.setBounds(522, 199, 120, 32);
			panelCargoSalario.add(comboDepartamento1);
			
			DescricaoAtividade = new JTextArea();
			DescricaoAtividade.setForeground(Color.BLACK);
			DescricaoAtividade.setSelectionColor(SystemColor.textHighlight);
			DescricaoAtividade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			DescricaoAtividade.setDisabledTextColor(Color.BLACK);
			DescricaoAtividade.setColumns(10);
			DescricaoAtividade.setBounds(24, 290, 618, 218);
			panelCargoSalario.add(DescricaoAtividade);
			
			menuBar_2 = new JMenuBar();
			menuBar_2.setBounds(180, 0, 990, 32);
			panelCargoSalario.add(menuBar_2);
			
			btSalvar_1 = new JButton("Salvar");
			btSalvar_1.setBounds(134, 57, 100, 32);
			panelCargoSalario.add(btSalvar_1);
			btSalvar_1.setForeground(Color.BLACK);
			btSalvar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btSalvar_1.setToolTipText("alt + Enter");
			btSalvar_1.setBorder(null);
			btSalvar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btSalvar_1.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			btSalvar_1.setMnemonic(KeyEvent.VK_ENTER);
			
			button_3 = new JButton("Excluir");
			button_3.setBounds(350, 57, 105, 32);
			panelCargoSalario.add(button_3);
			button_3.setForeground(Color.BLACK);
			button_3.setToolTipText("alt + Delete");
			button_3.setEnabled(false);
			button_3.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_3.setMnemonic(KeyEvent.VK_DELETE);
			button_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_3.setAlignmentX(0.5f);
			
			btLimpar_1 = new JButton("Limpar");
			btLimpar_1.setBounds(602, 57, 100, 32);
			panelCargoSalario.add(btLimpar_1);
			btLimpar_1.setForeground(Color.BLACK);
			btLimpar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btLimpar_1.setToolTipText("alt + Backspace");
			btLimpar_1.setBorder(null);
			btLimpar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btLimpar_1.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btLimpar_1.setMnemonic(KeyEvent.VK_BACK_SPACE);
			
			button_4 = new JButton("Alterar");
			button_4.setBounds(824, 57, 105, 32);
			panelCargoSalario.add(button_4);
			button_4.setForeground(Color.BLACK);
			button_4.setToolTipText("alt + Space");
			button_4.setEnabled(false);
			button_4.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_4.setMnemonic(KeyEvent.VK_SPACE);
			button_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_4.setFocusTraversalPolicyProvider(true);
			button_4.setFocusCycleRoot(true);
			button_4.setAlignmentX(0.5f);
			
			button_1 = new JButton("Imprimir");
			button_1.setBounds(1074, 57, 115, 32);
			panelCargoSalario.add(button_1);
			button_1.setForeground(Color.BLACK);
			button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_1.setToolTipText("alt + P");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					report.Funcionarios();
				}
			});
			button_1.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_1.setMnemonic(KeyEvent.VK_P);
			button_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			labelCadastrarCargo = new JLabel("Cadastrar Cargo");
			labelCadastrarCargo.setForeground(Color.BLACK);
			labelCadastrarCargo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCadastrarCargo.setBounds(24, 167, 129, 32);
			panelCargoSalario.add(labelCadastrarCargo);
			
			labelCadastrarSalario = new JLabel("Cadastrar Salário");
			labelCadastrarSalario.setForeground(Color.BLACK);
			labelCadastrarSalario.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCadastrarSalario.setBounds(375, 167, 120, 32);
			panelCargoSalario.add(labelCadastrarSalario);
			
			/*
			 * panels com ícones
			 */
			
			tabbedPaneRH.addTab("Funcionário ", new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606657_user-128.png")),
					panelFuncionario, null);
			tabbedPaneRH.addTab("Cargos / Salários", new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),
					panelCargoSalario, null);
			
			labelCadastrarDepartamento = new JLabel("Selecionar Departamento");
			labelCadastrarDepartamento.setForeground(Color.BLACK);
			labelCadastrarDepartamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCadastrarDepartamento.setBounds(522, 167, 189, 32);
			panelCargoSalario.add(labelCadastrarDepartamento);
			
			JLabel lblDescrio = new JLabel("Descrição da Atividade");
			lblDescrio.setForeground(Color.BLACK);
			lblDescrio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDescrio.setBounds(24, 258, 284, 32);
			panelCargoSalario.add(lblDescrio);
			
			JLabel label_6 = new JLabel("");
			label_6.setForeground(Color.BLACK);
			label_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DA FUN\u00C7\u00C3O", TitledBorder.LEFT,
					TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_6.setBounds(10, 140, 729, 387);
			panelCargoSalario.add(label_6);
			
			labelFundoHolerite = new JLabel("");
			labelFundoHolerite.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundoHolerite.setForeground(Color.BLACK);
			labelFundoHolerite.setFont(new Font("Arial", Font.PLAIN, 12));
			labelFundoHolerite.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundoHolerite.setVerticalAlignment(SwingConstants.TOP);
			labelFundoHolerite.setBounds(0, 0, 1348, 664);
			panelCargoSalario.add(labelFundoHolerite);
			labelFundoHolerite.setIcon(new ImageIcon(RH.class
					.getResource("/papel_parede/04.jpg")));
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelTreinamentos = new JPanel();
			panelTreinamentos.setLayout(null);
			panelTreinamentos.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelTreinamentos.setBackground(SystemColor.inactiveCaptionBorder);
			tabbedPaneRH.addTab("Treinamento / Desenvolvimento", new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606809_wrench-128.png")),
					panelTreinamentos, null);
			
			menuBar_3 = new JMenuBar();
			menuBar_3.setBounds(180, 0, 990, 32);
			panelTreinamentos.add(menuBar_3);
			
			button_6 = new JButton("Salvar");
			button_6.setBounds(131, 43, 100, 32);
			panelTreinamentos.add(button_6);
			button_6.setForeground(Color.BLACK);
			button_6.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			button_6.setToolTipText("alt + Enter");
			button_6.setMnemonic(KeyEvent.VK_ENTER);
			button_6.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_6.setBorder(null);
			
			button_8 = new JButton("Excluir");
			button_8.setBounds(347, 43, 105, 30);
			panelTreinamentos.add(button_8);
			button_8.setForeground(Color.BLACK);
			button_8.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_8.setMnemonic(KeyEvent.VK_BACK_SPACE);
			button_8.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_8.setEnabled(false);
			button_8.setAlignmentX(0.5f);
			
			button_5 = new JButton("Limpar");
			button_5.setBounds(599, 43, 100, 32);
			panelTreinamentos.add(button_5);
			button_5.setForeground(Color.BLACK);
			button_5.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			button_5.setToolTipText("alt + Backspace");
			button_5.setMnemonic(KeyEvent.VK_BACK_SPACE);
			button_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_5.setBorder(null);
			
			button_9 = new JButton("Alterar");
			button_9.setBounds(821, 43, 105, 32);
			panelTreinamentos.add(button_9);
			button_9.setForeground(Color.BLACK);
			button_9.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_9.setMnemonic(KeyEvent.VK_ENTER);
			button_9.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_9.setFocusTraversalPolicyProvider(true);
			button_9.setFocusCycleRoot(true);
			button_9.setEnabled(false);
			button_9.setAlignmentX(0.5f);
			
			button_7 = new JButton("Imprimir");
			button_7.setBounds(1071, 43, 115, 32);
			panelTreinamentos.add(button_7);
			button_7.setForeground(Color.BLACK);
			button_7.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_7.setToolTipText("alt + P");
			button_7.setMnemonic(KeyEvent.VK_P);
			button_7.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			textField = new JTextField();
			textField.setForeground(Color.BLACK);
			textField.setSelectionColor(SystemColor.textHighlight);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Kalinga", Font.PLAIN, 14));
			textField.setDisabledTextColor(Color.BLACK);
			textField.setColumns(10);
			textField.setBounds(521, 149, 110, 32);
			panelTreinamentos.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setForeground(Color.BLACK);
			textField_1.setSelectionColor(SystemColor.textHighlight);
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			textField_1.setDisabledTextColor(Color.BLACK);
			textField_1.setColumns(10);
			textField_1.setBounds(375, 149, 120, 32);
			panelTreinamentos.add(textField_1);
			
			comboBox = new JComboBox<String>();
			comboBox.setForeground(Color.BLACK);
			comboBox.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBox.setBounds(24, 148, 325, 32);
			panelTreinamentos.add(comboBox);
			
			textArea = new JTextArea();
			textArea.setForeground(Color.BLACK);
			textArea.setSelectionColor(SystemColor.textHighlight);
			textArea.setFont(new Font("Kalinga", Font.PLAIN, 14));
			textArea.setDisabledTextColor(Color.BLACK);
			textArea.setColumns(10);
			textArea.setBounds(24, 240, 699, 218);
			panelTreinamentos.add(textArea);
			
			lblSelecionarFuncionrio = new JLabel("Funcionário");
			lblSelecionarFuncionrio.setForeground(Color.BLACK);
			lblSelecionarFuncionrio.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblSelecionarFuncionrio.setBounds(24, 117, 129, 32);
			panelTreinamentos.add(lblSelecionarFuncionrio);
			
			lblDataTreinamento = new JLabel("Treinamento");
			lblDataTreinamento.setForeground(Color.BLACK);
			lblDataTreinamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblDataTreinamento.setBounds(375, 117, 120, 32);
			panelTreinamentos.add(lblDataTreinamento);
			
			lblData = new JLabel("Data");
			lblData.setForeground(Color.BLACK);
			lblData.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblData.setBounds(521, 117, 189, 32);
			panelTreinamentos.add(lblData);
			
			label_15 = new JLabel("Descrição da Atividade");
			label_15.setForeground(Color.BLACK);
			label_15.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_15.setBounds(24, 208, 284, 32);
			panelTreinamentos.add(label_15);
			
			label_16 = new JLabel("");
			label_16.setForeground(Color.BLACK);
			label_16.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_16.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "DADOS DA FUN\u00C7\u00C3O", TitledBorder.LEFT,
					TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_16.setBounds(10, 90, 729, 387);
			panelTreinamentos.add(label_16);
			
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(RH.class.getResource("/papel_parede/04.jpg")));
			label_5.setVerticalAlignment(SwingConstants.TOP);
			label_5.setHorizontalTextPosition(SwingConstants.CENTER);
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setForeground(Color.BLACK);
			label_5.setFont(new Font("Arial", Font.PLAIN, 12));
			label_5.setBounds(0, 0, 1348, 664);
			panelTreinamentos.add(label_5);
			
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			panelRelatorios = new JPanel();
			panelRelatorios.setLayout(null);
			panelRelatorios.setFont(new Font("Kalinga", Font.PLAIN, 14));
			panelRelatorios.setBackground(SystemColor.inactiveCaptionBorder);
			tabbedPaneRH.addTab("Relatórios", new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
					panelRelatorios, null);
			
			menuBar_4 = new JMenuBar();
			menuBar_4.setBounds(180, 0, 990, 32);
			panelRelatorios.add(menuBar_4);
			
			button_11 = new JButton("Salvar");
			button_11.setBounds(87, 372, 100, 32);
			panelRelatorios.add(button_11);
			button_11.setForeground(Color.BLACK);
			button_11.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606570_floppy-128.png")));
			button_11.setToolTipText("alt + Enter");
			button_11.setMnemonic(KeyEvent.VK_ENTER);
			button_11.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_11.setBorder(null);
			
			button_13 = new JButton("Excluir");
			button_13.setBounds(266, 372, 105, 32);
			panelRelatorios.add(button_13);
			button_13.setForeground(Color.BLACK);
			button_13.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_13.setMnemonic(KeyEvent.VK_BACK_SPACE);
			button_13.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_13.setEnabled(false);
			button_13.setAlignmentX(0.5f);
			
			button_10 = new JButton("Limpar");
			button_10.setBounds(481, 372, 100, 32);
			panelRelatorios.add(button_10);
			button_10.setForeground(Color.BLACK);
			button_10.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/Gnome-edit-clear.png")));
			button_10.setToolTipText("alt + Backspace");
			button_10.setMnemonic(KeyEvent.VK_BACK_SPACE);
			button_10.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_10.setBorder(null);
			
			button_14 = new JButton("Alterar");
			button_14.setBounds(666, 372, 105, 32);
			panelRelatorios.add(button_14);
			button_14.setForeground(Color.BLACK);
			button_14.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_14.setMnemonic(KeyEvent.VK_ENTER);
			button_14.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_14.setFocusTraversalPolicyProvider(true);
			button_14.setFocusCycleRoot(true);
			button_14.setEnabled(false);
			button_14.setAlignmentX(0.5f);
			
			button_12 = new JButton("Imprimir");
			button_12.setBounds(879, 372, 115, 32);
			panelRelatorios.add(button_12);
			button_12.setForeground(Color.BLACK);
			button_12.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_12.setToolTipText("alt + P");
			button_12.setMnemonic(KeyEvent.VK_P);
			button_12.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JButton button = new JButton("Grafico");
			button.setBounds(1104, 372, 110, 32);
			panelRelatorios.add(button);
			button.setForeground(Color.BLACK);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultPieDataset pieDataset = new DefaultPieDataset();
					pieDataset.setValue("Homens", new Integer(45));
					pieDataset.setValue("Mulheres", new Integer(55));
					
					JFreeChart chart = ChartFactory.createPieChart3D(
							"Qt. de Funcionários", pieDataset, true, true, true);
					
					PiePlot3D plot = (PiePlot3D) chart.getPlot();
					plot.setStartAngle(290);
					plot.setDirection(Rotation.CLOCKWISE);
					plot.setForegroundAlpha(0.5f);
					plot.setNoDataMessage("No data to display");
					
					chart.getPlot();
					
					ChartFrame frame = new ChartFrame("% dos funcionários", chart);
					frame.setVisible(true);
					frame.setBounds(898, 43, 443, 272);
					frame.setSize(400, 450);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
					DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
					
					barDataset.setValue(566.80, "Janeiro", "Quantidade:");
					barDataset.setValue(1080.60, "Fevereiro", "Quantidade:");
					barDataset.setValue(1200.80, "Março", "Quantidade:");
					barDataset.setValue(1500.80, "Abril", "Quantidade:");
					barDataset.setValue(2000.90, "Maio", "Quantidade:");
					barDataset.setValue(2500.80, "Junho", "Quantidade:");
					barDataset.setValue(2800.10, "Julho", "Quantidade:");
					barDataset.setValue(2900.30, "Agosto", "Quantidade:");
					barDataset.setValue(3200.80, "Setembro", "Quantidade:");
					barDataset.setValue(4500.20, "Outubro", "Quantidade:");
					barDataset.setValue(5000.80, "Novembro", "Quantidade:");
					barDataset.setValue(5200.20, "Dezembro", "Quantidade:");
					JFreeChart chart1 = ChartFactory.createBarChart3D(
							"Custo com salário / remuneração", "", "Faixa salarial",
							barDataset, PlotOrientation.VERTICAL, false, true, false);
					
					CategoryPlot p = chart1.getCategoryPlot();
					p.setRangeGridlinePaint(Color.black);
					ChartFrame frame1 = new ChartFrame("Histórico de Vendas", chart1);
					frame1.setVisible(true);
					frame1.setBounds(10, 326, 1331, 320);
					
					/**
					 * -------------------------------------------------------------------------- *
					 */
					
				}
			});
			button.setIcon(new ImageIcon(RH.class
					.getResource("/icones1_24px/1425606754_monitor-128.png")));
			button.setToolTipText("alt + G");
			button.setMnemonic(KeyEvent.VK_G);
			button.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 65, 855, 238);
			panelRelatorios.add(scrollPane);
			
			table = new JTable();
			table.setForeground(Color.BLACK);
			table.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null }, }, new String[] {
							"Nome", "Departamento", "Sal\u00E1rio", "Contrato" }));
			table.getColumnModel().getColumn(1).setPreferredWidth(101);
			scrollPane.setViewportView(table);
			
			JLabel label_1 = new JLabel("");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "GRADE DE FUNCION\u00C1RIOS", TitledBorder.LEFT,
					TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_1.setBounds(10, 43, 878, 272);
			panelRelatorios.add(label_1);
			
			JLabel label_4 = new JLabel("");
			label_4.setForeground(Color.BLACK);
			label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "CUSTO COM SAL\u00C1RIO / REMUNERA\u00C7\u00C3O",
					TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_4.setBounds(10, 326, 1331, 320);
			panelRelatorios.add(label_4);
			
			JLabel label_3 = new JLabel("");
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
					null), "% SEXO", TitledBorder.LEFT, TitledBorder.TOP, null,
					new Color(64, 64, 64)));
			label_3.setBounds(898, 43, 443, 272);
			panelRelatorios.add(label_3);
			
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(RH.class.getResource("/papel_parede/04.jpg")));
			label_2.setVerticalAlignment(SwingConstants.TOP);
			label_2.setHorizontalTextPosition(SwingConstants.CENTER);
			label_2.setHorizontalAlignment(SwingConstants.CENTER);
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Arial", Font.PLAIN, 12));
			label_2.setBounds(0, 0, 1348, 664);
			panelRelatorios.add(label_2);
			
			this.setSize(new Dimension(1366, 768));
			// this.setSize(toolkit.getScreenSize());
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			
		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RH.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RH.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RH.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RH.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
	}
	
	protected static void SetarEditavelFalso() {
		lblPor.setVisible(true);
		comboPor.setVisible(true);
		Dependentes1.setVisible(true);
		radioCadastrar.setSelected(false);
		radioNao.setVisible(false);
		radioSim.setVisible(false);
		radioNao2.setVisible(false);
		radioSim2.setVisible(false);
		NumeroRegistro1.setEnabled(true);
		NumeroRegistro1.setEditable(true);
		NumeroRegistro1.setText(null);
		Nome1.setEnabled(false);
		Nascimento1.setEnabled(false);
		Nacionalidade1.setEnabled(false);
		Rg1.setEnabled(false);
		Cpf1.setEnabled(false);
		Ctps1.setEnabled(false);
		comboEstadoCivil.setVisible(false);
		Email1.setEnabled(false);
		NomePai1.setEnabled(false);
		NomeMae1.setEnabled(false);
		Telefone11.setEnabled(false);
		Telefone21.setEnabled(false);
		Celular11.setEnabled(false);
		Celular21.setEnabled(false);
		Admissao1.setEnabled(false);
		comboContrato.setVisible(false);
		Conta1.setEnabled(false);
		comboBanco.setVisible(false);
		comboEscolaridade.setVisible(false);
		Dependentes1.setEnabled(false);
		Logradouro1.setEnabled(false);
		Numero1.setEnabled(false);
		Complemento1.setEnabled(false);
		Bairro1.setEnabled(false);
		comboUf.setVisible(false);
		comboCidade.setVisible(false);
		Cep1.setEnabled(false);
		comboCargo.setVisible(false);
		Salario1.setEnabled(false);
		comboDepartamento.setVisible(false);
		Usuario1.setEnabled(false);
		Senha1.setEnabled(false);
		comboNivel.setVisible(false);
		escolaridade.setEnabled(false);
		contrato.setEnabled(false);
		banco.setEnabled(false);
		estadoCivil.setEnabled(false);
		cidade.setEnabled(false);
		uf.setEnabled(false);
		cargo_1.setEnabled(false);
		departamento.setEnabled(false);
		nivel.setEnabled(false);
		escolaridade.setVisible(true);
		contrato.setVisible(true);
		banco.setVisible(true);
		estadoCivil.setVisible(true);
		cidade.setVisible(true);
		uf.setVisible(true);
		cargo_1.setVisible(true);
		departamento.setVisible(true);
		nivel.setVisible(true);
		Senha1.setVisible(true);
		Usuario1.setVisible(true);
		labelLogin.setVisible(false);
		comboNivel.setVisible(false);
		labelUsuario_1.setVisible(true);
		labelSenha.setVisible(true);
		labelNivel.setVisible(true);
		btSalvar.setVisible(false);
		btConsultar.setVisible(true);
	}
	
	protected static void SetarEditavel() {
		Nome1.setVisible(true);
		NumeroRegistro1.setBorder(null);
		Dependentes1.setVisible(false);
		Nome1.setBorder(null);
		Cpf1.setBorder(null);
		lblPor.setVisible(false);
		comboPor.setVisible(false);
		radioConsultar.setSelected(false);
		radioNao.setVisible(true);
		radioSim.setVisible(true);
		NumeroRegistro1.setEnabled(false);
		Nome1.setEnabled(true);
		Nascimento1.setEnabled(true);
		Nacionalidade1.setEnabled(true);
		Rg1.setEnabled(true);
		Cpf1.setEnabled(true);
		Ctps1.setEnabled(true);
		comboEstadoCivil.setVisible(true);
		Email1.setEnabled(true);
		NomePai1.setEnabled(true);
		NomeMae1.setEnabled(true);
		Telefone11.setEnabled(true);
		Telefone21.setEnabled(true);
		Celular11.setEnabled(true);
		Celular21.setEnabled(true);
		Admissao1.setEnabled(true);
		comboContrato.setVisible(true);
		Conta1.setEnabled(true);
		comboBanco.setVisible(true);
		comboEscolaridade.setVisible(true);
		Dependentes1.setEnabled(true);
		Logradouro1.setEnabled(true);
		Numero1.setEnabled(true);
		Complemento1.setEnabled(true);
		Bairro1.setEnabled(true);
		comboUf.setVisible(true);
		comboCidade.setVisible(true);
		Cep1.setEnabled(true);
		comboCargo.setVisible(true);
		Salario1.setEnabled(true);
		comboDepartamento.setVisible(true);
		Usuario1.setEnabled(true);
		Senha1.setEnabled(true);
		comboNivel.setVisible(true);
		nivel.setVisible(false);
		radioNao2.setVisible(true);
		radioSim2.setVisible(true);
		labelLogin.setVisible(true);
		comboNivel.setVisible(true);
		labelLogin.setVisible(true);
		comboNivel.setVisible(false);
		Usuario1.setVisible(false);
		Senha1.setVisible(false);
		labelUsuario_1.setVisible(false);
		labelSenha.setVisible(false);
		labelNivel.setVisible(false);
		Nome1.setVisible(true);
		radioNao2.setSelected(true);
		radioSim2.setSelected(false);
		btSalvar.setVisible(true);
		btConsultar.setVisible(false);
		
	}
	
	public static void LimparDados() {
		NumeroRegistro1.setText(null);
		Nome1.setText(null);
		Nascimento1.setText(null);
		Nacionalidade1.setText(null);
		Rg1.setText(null);
		Cpf1.setText(null);
		Ctps1.setText(null);
		comboEstadoCivil.setSelectedItem(null);
		estadoCivil.setText(null);
		Email1.setText(null);
		NomePai1.setText(null);
		NomeMae1.setText(null);
		Dependentes1.setText(null);
		comboEscolaridade.setSelectedItem(null);
		escolaridade.setText(null);
		Telefone11.setText(null);
		Celular11.setText(null);
		Telefone21.setText(null);
		Celular21.setText(null);
		Admissao1.setText(null);
		comboContrato.setSelectedItem(null);
		contrato.setText(null);
		Conta1.setText(null);
		comboBanco.setSelectedItem(null);
		Logradouro1.setText(null);
		Numero1.setText(null);
		Complemento1.setText(null);
		Bairro1.setText(null);
		comboUf.setSelectedItem(null);
		uf.setText(null);
		comboCidade.setSelectedItem(null);
		cidade.setText(null);
		Cep1.setText(null);
		comboCargo.setSelectedItem(null);
		cargo_1.setText(null);
		Salario1.setText("");
		comboDepartamento.setSelectedItem(null);
		departamento.setText(null);
		Usuario1.setText(null);
		Senha1.setText(null);
		comboNivel.setSelectedItem(null);
		labelFotoFuncionario = new JLabel("(165x115)");
		labelFotoFuncionario.setIcon(new ImageIcon(RH.class
				.getResource("/icones1_48px/1425606804_pic-128.png")));
	}
}
