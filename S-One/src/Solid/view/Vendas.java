package Solid.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
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
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
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
import Solid.controller.VendasController;
import Solid.model.ModelVendas;
import Solid.model.PPReport;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class Vendas extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long         serialVersionUID = 5196501071185049653L;

	// instancia a classe do banco para conexão
	static BancoDados                 x                = new BancoDados();

	// instancia a classe para impressao
	PPReport                          report           = new PPReport();

	// variaveis do sistema
	public static DefaultTableModel modeloGerencPed, modeloGerencPed2;
	private JMenu                     Menu, mnConfigurao, menu_2, mnAjuda;
	private JMenu 					  menu_1;
	private JMenuBar 				  menuBar_4;
	private JMenuBar                  menuBar_1;
	private JMenuBar                  menuBar_2;
	private JMenuBar                  menuBar_3;
	private JMenuBar                  menuBar;
	private JMenuItem                 menu, sair, menuItem_1, mntmAbrirAjuda;	
	private JMenuItem 				  menuItem;
	private JMenuItem                 menuDefinirPapelParede;
	private JMenuItem                 menuItem_3;
	
	public static JTabbedPane         tabbedPaneVendas;
	
	private static JScrollPane        scrollPaneTabela;
	private static JScrollPane        scrollPane1;
	private static JScrollPane 		  scrollPane_2;
	
	public static DefaultTableModel   modelo, modeloDelivery, modeloHistDelivery;
	public static DefaultTableModel          modelo2;
	
	private JTable                    tablePedido;
	private JTable                    table;
	public static JTable              conv;
	public static JTable              Tabela_itens;
	public static JTable              Tabela_hist;
	private JTable 					  table_1;
	
	public static JSpinner            QuantidadeRem, spinnerRemove;
	public static JSpinner            quantidade1, spinnerQuantDelivery;
	
	public static JPanel              panelCadastrarCliente;
	public static JPanel              panelRelatorios;
	public static JPanel              panelDelivery;
	public static JPanel              panelPainelVendas;
	public static JPanel              panelGerencMesas;
	public static JPanel              panelHistoricoVenda;
	
	public static JTextField          codigoCliente3;
	public static JTextField          nome3;	
	public static JTextField          nacionalidade3;	
	public static JTextField          nomePai3;
	public static JTextField          nomeMae3;
	public static JTextField          autorizados3;	
	public static JTextField          logradouro3;
	public static JTextField          numero3;
	public static JTextField          complemento3;
	public static JTextField          bairro3;
	public static JTextField          email3;	
	public static JTextField          contitem1;
	public static JTextField          valorFinal1;
	public static JTextField          desconto1;
	public static JTextField          troco1;
	public static JTextField          valorTotal1;
	public static JTextField          valorPago1;
	public static JTextField          numeroVenda1;
	public static JTextField          vendedor1;
	public static JTextField          valorParcelado1;
	public static JTextField          agencia1;
	public static JTextField          numeroConta1;
	public static JTextField          numeroCheque1;
	public static JTextField          nome4;	
	public static JTextField          logradouro4;	
	public static JTextField          numero4;
	public static JTextField          complemento4;
	public static JTextField          bairro4;
	public static JTextField          cidade4;
	public static JTextField          cpf4;
	public static JTextField          caminho;
	public static JTextField          estadoCivilConsulta;
	public static JTextField          ufConsulta;
	public static JTextField          cidadeConsulta;
	public static JTextField          valorFinalDelivery;	
	public static JTextField          codDelivery;	
	public static JTextField          valorPagoDelivery;
	public static JTextField          trocoDelivery;
	public static JTextField          numeroVendaDelivery;
	public static JTextField 		  textFieldCodCliente;
	public static JTextField 		  caminhoC;
	
	public static JFormattedTextField nascimento3;
	public static JFormattedTextField rg3;
	public static JFormattedTextField cpf3;
	public static JFormattedTextField telefone3;
	public static JFormattedTextField celular3;
	public static JFormattedTextField telefone23;
	public static JFormattedTextField celular23;
	public static JFormattedTextField cep3;
	public static JFormattedTextField data1;	
	public static JFormattedTextField cpf1;
	public static JFormattedTextField telefone1;
	public static JFormattedTextField telefone4;
	public static JFormattedTextField hora1;
	
	public static JComboBox<String>   banco1;	
	public static JComboBox<String>   comboEstadoCivil;
	public static JComboBox<String>   comboUf3;
	public static JComboBox<String>   comboCidade3, comboProduto3;
	public static JComboBox<String>   comboRemoveItem;
	public static JComboBox<String>   comboFormaPagamento;
	public static JComboBox<String>   comboProduto;
	public static JComboBox<String>   comboCliente;
	public static JComboBox<String>   comboVezes, comboBox, comboBoxRemoveDelivery;
	
	static JLabel                     cel;
	static JLabel                     dnasc;
	static JLabel                     Rg;
	static JLabel                     Cpf;
	static JLabel                     Nom;
	static JLabel                     NumF;
	static JLabel                     ec;
	static JLabel                     email;
	static JLabel                     cid;
	static JLabel                     num;
	static JLabel                     tel;
	static JLabel                     comp;
	static JLabel                     bairro;
	static JLabel                     uf;
	static JLabel                     cep;
	static JLabel                     Fundo;
	static JLabel                     logr;
	static JLabel                     dep_1;
	static JLabel                     lblNomeDoPai;
	static JLabel                     lblNomeDoMe;
	static JLabel                     lblTelefone;
	static JLabel                     lblCel;
	static JLabel                     labelFundo1;
	static JLabel                     labelValorFinal;
	public static JLabel              labelIcone_4;
	static JLabel                     labelDesconto;
	static JLabel                     labelTroco;
	static JLabel                     labelNumeroVenda;
	static JLabel                     labelData;
	static JLabel                     labelVendedor;
	static JLabel                     labelTelefone;
	static JLabel                     labelBanco;
	static JLabel                     labelNumeroCheque;
	static JLabel                     labelSelecionarCartao;
	static JLabel                     labelDadosCheque;
	static JLabel                     labelAgencia;
	static JLabel                     labelNumeroConta;
	static JLabel                     labelQuantidade;
	private static JLabel             labelFundo1_1;
	private static JLabel             labelProduto;
	private static JLabel             lblTelefone_1;
	private static JLabel             lblNome;
	private static JLabel             lblLogradouro;
	private static JLabel             label_6;
	private static JLabel             label_7;
	private static JLabel             label_8;
	private static JLabel             lblcadastrarDependentes;
	private static JLabel             labelAnime;
	protected static JLabel           lbMs1;
	protected static JLabel           lbMs2;
	protected static JLabel           lbMs3;
	protected static JLabel           lbMs4;
	protected static JLabel           lbMs5;
	protected static JLabel           lbMs6;
	protected static JLabel           lbMs7;
	protected static JLabel           lbMs8;
	protected static JLabel           lbMs9;
	protected static JLabel           lbMs10;
	protected static JLabel           lbMs11;
	protected static JLabel           lbMs12;
	protected static JLabel           lbMs13;
	protected static JLabel           lbMs14;
	protected static JLabel           lbMs15;
	protected static JLabel           lbMs16;
	protected static JLabel           lbMs17;
	protected static JLabel           lbMs18;
	protected static JLabel           lbMs19;
	protected static JLabel           lbMs20;
	protected static JLabel           lbMs21;
	protected static JLabel           lbMs22;
	protected static JLabel           lbMs23;
	protected static JLabel           lbMs24;
	protected static JLabel           lbMs25;
	protected static JLabel           lbMs26;
	protected static JLabel           lbMs27;
	protected static JLabel           lbMs28;
	protected static JLabel           lbMs29;
	protected static JLabel           lbMs30;
	protected static JLabel           lbMs31;
	protected static JLabel           lbMs32;
	protected static JLabel           lbMs33;
	protected static JLabel           lbMs34;
	protected static JLabel           lbMs35;
	protected static JLabel           lbMs36;
	protected static JLabel           lbMs37;
	protected static JLabel           lbMs38;
	protected static JLabel           lbMs39;
	protected static JLabel           lbMs40;
	private JLabel                    labelNome;
	private JLabel                    labelQuantidade_1;
	private JLabel                    labelCpf;
	private JLabel                    labelValorPago;
	private JLabel                    labelValorTotal;
	private JLabel                    labelValorParcelado;
	private JLabel                    labelHora;	
	private JLabel                    label_1;
	private JLabel                    label_2;
	private JLabel                    label_5;	
	private static JLabel             lblPor;	
	private JLabel                    label_9;
	public static JLabel                    fotoCliente;
	private JLabel                    label_10;
	private JLabel                    label_11;
	private JLabel                    label_3;
	private JLabel                    label_4;
	private JLabel                    lblCod;
	private JLabel                    label_12;
	public static JLabel                    label_18,label_16;	
	private JLabel 					  label_21;
	
	public static JButton             limpar, button_4, button_5;
	public static JButton             salvar;
	public static JButton             btconsultar;
	public static JButton             btAdicionarItem;
	public static JButton             btRemoverItem_1;
	public static JButton             btCancelar_1;
	protected static JButton          btFinalizarVenda;
	protected static JButton          btRemoverItem;
	protected static JButton          btRecalcularTroco;
	protected static JButton          btMesa1;
	protected static JButton          btMesa2;
	protected static JButton          btMesa3;
	protected static JButton          btMesa4;
	protected static JButton          btnMesa4;
	protected static JButton          btMesa5;
	protected static JButton          btMesa6;
	static JButton                    btMesa7;
	static JButton                    btMesa8;
	static JButton                    btMesa9;
	static JButton                    btMesa10;
	static JButton                    btMesa11;
	static JButton                    btMesa12;
	static JButton                    btMesa13;
	static JButton                    btMesa14;
	static JButton                    btMesa15;
	static JButton                    btMesa16;
	static JButton                    btMesa17;
	static JButton                    btMesa18;
	static JButton                    btMesa19;
	static JButton                    btMesa20;
	static JButton                    btMesa21;
	static JButton                    btMesa22;
	static JButton                    btMesa23;
	static JButton                    btMesa24;
	static JButton                    btMesa25;
	static JButton                    btMesa26;
	static JButton                    btMesa27;
	static JButton                    btMesa28;
	static JButton                    btMesa29;
	static JButton                    btMesa30;
	static JButton                    btMesa31;
	static JButton                    btMesa32;
	static JButton                    btMesa33;
	static JButton                    btMesa34;
	static JButton                    btMesa35;
	static JButton                    btMesa36;
	static JButton                    btMesa37;
	static JButton                    btMesa38;
	static JButton                    btMesa39;
	static JButton                    btMesa40;
	private JButton                   btPesquisar;
	private JButton                   btAddItem;
	private JButton                   btRemItem;
	public static JButton             button;
	private JButton                   button_1;
	private JButton                   btnCancelar_1;
	public static JButton             button_3;
	private JButton                   btnCancelar;
	private JButton                   btnCalcular;
	public static JButton             button_6;
	public static JButton             button_7, btnAtualizar;	
	private JButton                   button_FotoCliente;

	public static JButton btnAtualizarFoto;
	private JButton 				  btnFinalizarEntrega;
	
	protected static String           mesa;
	protected static String           estado           = null;
	protected static String           conC;
	protected static String           aux1;
	protected static String           cpf              = null;
	public static String              codProd, codProd2;
	protected static String           form;
	protected static String           vlInicial        = "0.0";
	public static String              str;
	
	private static JRadioButton       radioSim;
	private static JRadioButton       radioNao;
	private static JRadioButton       cadastro;
	private static JRadioButton       consulta;
	private static JRadioButton       radioVisa;
	private static JRadioButton       radioAmerican;
	private static JRadioButton       radioMaster;
	private static JRadioButton       radioVista;
	private static JRadioButton       radioPrazo;
	private static JRadioButton       AbrirMesa;
	private static JRadioButton       ReservarMesa;
	private static JRadioButton       FecharMesa;
	
	protected static int              sn               = 0;
	protected static int              con;
	protected static int              opc              = 0;
	protected static int              par;
	protected static int              contLinha        = 0;
	public static int 				  contEntrega=-1;
	protected static int              contEntrega2=0;
	protected static int              M;
	protected static int              ms               = 0;
	protected static int              btn1             = 0;
	protected static int              btn2             = 0;
	protected static int              btn3             = 0;
	protected static int              btn4             = 0;
	protected static int              btn5             = 0;
	protected static int              btn6             = 0;
	protected static int              btn7             = 0;
	protected static int              btn8             = 0;
	protected static int              btn9             = 0;
	protected static int              btn10            = 0;
	protected static int              btn11            = 0;
	protected static int              btn12            = 0;
	protected static int              btn13            = 0;
	protected static int              btn14            = 0;
	protected static int              btn15            = 0;
	protected static int              btn16            = 0;
	protected static int              btn17            = 0;
	protected static int              btn18            = 0;
	protected static int              btn19            = 0;
	protected static int              btn20            = 0;
	protected static int              btn21            = 0;
	protected static int              btn22            = 0;
	protected static int              btn23            = 0;
	protected static int              btn24            = 0;
	protected static int              btn25            = 0;
	protected static int              btn26            = 0;
	protected static int              btn27            = 0;
	protected static int              btn28            = 0;
	protected static int              btn29            = 0;
	protected static int              btn30            = 0;
	protected static int              btn31            = 0;
	protected static int              btn32            = 0;
	protected static int              btn33            = 0;
	protected static int              btn34            = 0;
	protected static int              btn35            = 0;
	protected static int              btn36            = 0;
	protected static int              btn37            = 0;
	protected static int              btn38            = 0;
	protected static int              btn39            = 0;
	protected static int              btn40            = 0;
	
	public static double              precoUnitario, precoUnitario2;
	
	static NumberFormat               nf;
	
	static SimpleDateFormat           formato;
	static SimpleDateFormat           formato2;
	
	static Date                       data2;
	
	public static JInternalFrame      internalFrame;
	public static JInternalFrame      internalFrame_2, internalFrame_3;	
	
	static DefaultTableCellRenderer   central          = new DefaultTableCellRenderer();
	
	private JSeparator                separator;
	
	private static Properties		  props;
	

	@SuppressWarnings("serial")
	public Vendas() {
		super();
		setResizable(false);
		try {
			// here you can put the selected theme class name in JTattoo
			props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel"); 
			setIconImage(Toolkit.getDefaultToolkit().getImage(Vendas.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));

			setName("vendas");
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

			setTitle("VENDAS");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			getContentPane().setBackground(new Color(245, 245, 245));
			getContentPane().setLayout(null);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.getScreenSize();

			nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);

			/*
			 * 
			 * Menu Janela
			 */

			menuBar = new JMenuBar();
			getContentPane().add(menuBar);
			menuBar.setForeground(new Color(0, 0, 0));

			Menu = new JMenu("Arquivo");
			Menu.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606738_678125-folder-house-128.png")));
			Menu.setForeground(Color.BLACK);
			Menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(Menu);
			menuBar.setBounds(0, 0, 1360, 32);

			menu = new JMenuItem("Menu Principal");
			menu.setForeground(Color.BLACK);
			menu.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menu.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606621_678085-house-128.png")));
			menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int sair = JOptionPane.showConfirmDialog(null,
					            "Tem certeza que deseja sair?", "Fechamento de Programa",
					            JOptionPane.YES_NO_OPTION);
					if (sair == 0) {
						// BD.desconecta();
						Vendas.this.dispose();
						new Menu();
					}
					UIManager.put("OptionPane.yesButtonText", "Sim");
					UIManager.put("OptionPane.noButtonText", "Não");
				}
			});
			Menu.add(menu);

			sair = new JMenuItem("Sair");
			sair.setForeground(Color.BLACK);
			sair.setFont(new Font("Kalinga", Font.PLAIN, 14));
			sair.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/desliga24px.png")));
			Menu.add(sair);
			sair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Metodos.formWindowClosing(null);
				}
			});

			mnConfigurao = new JMenu("Configurações");
			mnConfigurao.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606625_678124-wrench-screwdriver-128.png")));
			mnConfigurao.setForeground(Color.BLACK);
			mnConfigurao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(mnConfigurao);

			menuDefinirPapelParede = new JMenuItem("Definir Papel de Parede");
			menuDefinirPapelParede.setForeground(Color.BLACK);
			menuDefinirPapelParede.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuDefinirPapelParede.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606663_image-128.png")));
			menuDefinirPapelParede.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Vendas.SelecionarPapelParedeVendas();
				}
			});
			mnConfigurao.add(menuDefinirPapelParede);

			menuItem_3 = new JMenuItem("Abrir Bate-Papo");
			menuItem_3.setForeground(Color.BLACK);
			menuItem_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem_3.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606720_bubbles-alt-128.png")));
			menuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ChatController.main(null);
				}
			});
			mnConfigurao.add(menuItem_3);

			menu_2 = new JMenu("Logout");
			menu_2.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")));
			menu_2.setForeground(Color.BLACK);
			menu_2.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(menu_2);

			menuItem_1 = new JMenuItem("Logout");
			menuItem_1.setForeground(Color.BLACK);
			menuItem_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem_1.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
			menuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Inicio.caixa.equals("fechado")){
						if (Inicio.mesasAbertas <= 0) {
							int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fazer Log-Off?", "Logoff",
									JOptionPane.YES_NO_OPTION);
							if (sair == 0) {
								Vendas.this.dispose();
								new Login().setVisible(true);
							}
							UIManager.put("OptionPane.yesButtonText", "Sim");
							UIManager.put("OptionPane.noButtonText", "Não");
						} else{
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(null, "Ainda há mesas abertas. Feche-as antes de fazer Log-Off!",
									"Atenção", JOptionPane.WARNING_MESSAGE);
						}
					}
						else {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(null, "É necessário fechar o caixa antes de fazer Log-Off!",
								"Atenção", JOptionPane.WARNING_MESSAGE);
						}
				}
			});
			menu_2.add(menuItem_1);
			
			menu_1 = new JMenu("Caixa");
			menu_1.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")));
			menu_1.setForeground(Color.BLACK);
			menu_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menu_1.setFocusTraversalPolicyProvider(true);
			menu_1.setFocusPainted(true);
			menuBar.add(menu_1);
			
			menuItem = new JMenuItem("Abrir / Fechar Caixa");
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Inicio.janelaCaixa==0){
					Inicio.janelaCaixa=1;
					new Caixa();					
					}
				}
			});
			menuItem.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")));
			menuItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuItem.setFocusable(true);
			menuItem.setFocusTraversalPolicyProvider(true);
			menuItem.setFocusPainted(true);
			menu_1.add(menuItem);

			mnAjuda = new JMenu("Ajuda");
			mnAjuda.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606598_678110-sign-info-128.png")));
			mnAjuda.setForeground(Color.BLACK);
			mnAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			menuBar.add(mnAjuda);

			mntmAbrirAjuda = new JMenuItem("Abrir Ajuda");
			mntmAbrirAjuda.setForeground(Color.BLACK);
			mntmAbrirAjuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ajuda ajuda = new Ajuda();
					ajuda.contentPaneAjuda.setVisible(true);
				}
			});
			mntmAbrirAjuda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			mntmAbrirAjuda.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606599_678078-light-bulb-128.png")));
			mnAjuda.add(mntmAbrirAjuda);

			tabbedPaneVendas = new JTabbedPane(JTabbedPane.TOP);
			tabbedPaneVendas.setBackground(new Color(240, 240, 240));
			tabbedPaneVendas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			tabbedPaneVendas.setFont(new Font("Kalinga", Font.PLAIN, 13));
			tabbedPaneVendas.setBounds(0, 34, 1360, 706);
			getContentPane().add(tabbedPaneVendas);

			/*
			 * 
			 * Panel Painel Vendas
			 */

			panelPainelVendas = new JPanel();
			panelPainelVendas.setBackground(SystemColor.inactiveCaptionBorder);
			panelPainelVendas.setLayout(null);

			internalFrame = new JInternalFrame("Remover Item");
			internalFrame.setClosable(true);
			internalFrame.setFocusTraversalPolicyProvider(true);
			internalFrame.setFrameIcon(new ImageIcon(Vendas.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			internalFrame.setBorder(null);
			internalFrame.setFont(new Font("Kalinga", Font.PLAIN, 14));
			internalFrame.setBounds(490, 243, 375, 181);
			panelPainelVendas.add(internalFrame);
			internalFrame.getContentPane().setLayout(null);
			try {
				internalFrame.setSelected(true);
			}
			catch (PropertyVetoException e4) {
				e4.printStackTrace();
			}
			try {
				internalFrame.setIcon(true);
			}
			catch (PropertyVetoException e4) {
				e4.printStackTrace();
			}
			
			comboRemoveItem = new JComboBox<String>();
			comboRemoveItem.setForeground(Color.BLACK);
			comboRemoveItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboRemoveItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboRemoveItem.setBounds(29, 16, 317, 32);
			internalFrame.getContentPane().add(comboRemoveItem);
			comboRemoveItem.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					QuantidadeRem.requestFocus();
					Object item2 = evt.getItem();
					try {
						String sql = "select * from produtos where nome = '"+ item2.toString() + "'";
						ResultSet rs1 = x.Consultar(sql);
						while (rs1.next()) {
							labelIcone_4.setText("");
							ImageIcon imagem = new ImageIcon(rs1.getString("imagem").replace("~", "\\"));
							Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
							labelIcone_4.setIcon(new javax.swing.ImageIcon(img));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			btCancelar_1 = new JButton("Cancelar");
			btCancelar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btCancelar_1.setForeground(Color.BLACK);
			btCancelar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btCancelar_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					QuantidadeRem.setValue(1);
					internalFrame.setVisible(false);
				}
			});

			QuantidadeRem = new JSpinner();
			QuantidadeRem.setForeground(Color.BLACK);
			QuantidadeRem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			QuantidadeRem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			QuantidadeRem.setModel(new SpinnerNumberModel(1, 1, 10000, 1));
			QuantidadeRem.setBounds(194, 61, 70, 32);
			internalFrame.getContentPane().add(QuantidadeRem);
			btCancelar_1.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btCancelar_1.setBounds(206, 109, 140, 35);
			internalFrame.getContentPane().add(btCancelar_1);
			internalFrame.setVisible(true);
			internalFrame.setVisible(false);
			// remL.setVisible(false);

			btRemoverItem = new JButton("Remover");
			btRemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btRemoverItem.setForeground(Color.BLACK);
			btRemoverItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btRemoverItem.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/Gnome-edit-clear.png")));
			btRemoverItem.setBounds(29, 109, 140, 35);
			btRemoverItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					VendasController.RemoverItem();
				}
			});
			internalFrame.getContentPane().add(btRemoverItem);

			labelQuantidade = new JLabel("Quantidade");
			labelQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
			labelQuantidade.setForeground(Color.BLACK);
			labelQuantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelQuantidade.setBounds(85, 61, 99, 32);
			internalFrame.getContentPane().add(labelQuantidade);

			comboProduto = new JComboBox<String>();
			comboProduto.setForeground(Color.BLACK);
			comboProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboProduto.setBounds(32, 286, 337, 32);
			panelPainelVendas.add(comboProduto);
			comboProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			AtualizarItensVendaveis();
			
			comboProduto.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					try {
						String sql = "select * from produtos where nome = '"+ item.toString() + "'";
						ResultSet rs1 = x.Consultar(sql);
						while (rs1.next()) {
							precoUnitario = Double.parseDouble(rs1.getString("precoVenda").replace(",", "."));
							codProd = (rs1.getString("codigoProduto"));
							ImageIcon imagem = new ImageIcon(rs1.getString("imagem").replace("~", "\\"));
							Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
							labelIcone_4.setIcon(new javax.swing.ImageIcon(img));
							labelIcone_4.setText("");
							str = comboProduto.getSelectedItem().toString()+ "           R$ "+ rs1.getString("precoVenda") + "           ";
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			numeroVenda1 = new JTextField();
			numeroVenda1.setForeground(Color.BLACK);
			numeroVenda1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroVenda1.setText(numeroVenda1.getText().replaceAll("[^0-9]", ""));
					// numeroVenda1.setText(numeroVenda1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroVenda1.setSelectionColor(SystemColor.textHighlight);
			numeroVenda1.setDisabledTextColor(Color.BLACK);
			numeroVenda1.setEnabled(false);
			numeroVenda1.setEditable(false);
			numeroVenda1.setHorizontalAlignment(SwingConstants.CENTER);
			numeroVenda1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroVenda1.setColumns(10);
			numeroVenda1.setBounds(32, 112, 88, 32);
			panelPainelVendas.add(numeroVenda1);
			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				if (Inicio.rd == 0) {
					while (rs3.next()) {
						numeroVenda1.setText(rs3.getString("numeroVenda"));

					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			formato = new SimpleDateFormat("dd/MM/yyyy");
			Date data = new Date();

			formato2 = new SimpleDateFormat("hh:mm:ss");
			Date data2 = new Date();

			data1 = new JFormattedTextField("##/##/####");
			data1.setForeground(Color.BLACK);
			data1.setSelectionColor(SystemColor.textHighlight);
			data1.setDisabledTextColor(Color.BLACK);
			data1.setEnabled(false);
			data1.setHorizontalAlignment(SwingConstants.CENTER);
			data1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			data1.setEditable(false);
			data1.setColumns(10);
			data1.setBounds(141, 112, 88, 32);
			data1.setText(formato.format(data));
			panelPainelVendas.add(data1);

			hora1 = new JFormattedTextField("##:##:##");
			hora1.setForeground(Color.BLACK);
			hora1.setSelectionColor(SystemColor.textHighlight);
			hora1.setDisabledTextColor(Color.BLACK);
			hora1.setEnabled(false);
			hora1.setEditable(false);
			hora1.setHorizontalAlignment(SwingConstants.CENTER);
			hora1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			hora1.setColumns(10);
			hora1.setBounds(240, 112, 80, 32);
			hora1.setText(formato2.format(data2));
			panelPainelVendas.add(hora1);

			vendedor1 = new JTextField(Login.User);
			vendedor1.setForeground(Color.BLACK);
			vendedor1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// vendedor1.setText(vendedor1.getText().replaceAll("[^0-9]",
					// ""));
					vendedor1.setText(vendedor1.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			vendedor1.setSelectionColor(SystemColor.textHighlight);
			vendedor1.setDisabledTextColor(Color.BLACK);
			vendedor1.setHorizontalAlignment(SwingConstants.CENTER);
			vendedor1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			vendedor1.setEnabled(false);
			vendedor1.setEditable(false);
			vendedor1.setColumns(10);
			vendedor1.setBounds(332, 112, 389, 32);
			panelPainelVendas.add(vendedor1);

			comboCliente = new JComboBox<String>();
			comboCliente.setForeground(Color.BLACK);
			comboCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboCliente.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboCliente.setBounds(32, 184, 382, 32);
			panelPainelVendas.add(comboCliente);
			String sql5 = "select * from clientes order by nome";
			ResultSet rs5 = x.Consultar(sql5);
			try {
				if (Inicio.rd == 0) {
					comboCliente.addItem("");
					while (rs5.next()) {
						comboCliente.addItem(rs5.getString("nome"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			comboCliente.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					cpf = item.toString();
					try {
						String sql = "select * from clientes where nome = '" + cpf
						            + "'";
						ResultSet rs1 = x.Consultar(sql);
						while (rs1.next()) {
							cpf1.setText(rs1.getString("cpf"));
							telefone1.setText(rs1.getString("telefone1"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			cpf1 = new JFormattedTextField("");
			cpf1.setForeground(Color.BLACK);
			cpf1.setSelectionColor(SystemColor.textHighlight);
			try {
				cpf1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
			}
			catch (ParseException e3) {
				e3.printStackTrace();
			}
			cpf1.setHorizontalAlignment(SwingConstants.CENTER);
			cpf1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cpf1.setColumns(10);
			cpf1.setBounds(424, 184, 124, 32);
			panelPainelVendas.add(cpf1);

			telefone1 = new JFormattedTextField("");
			telefone1.setForeground(Color.BLACK);
			telefone1.setSelectionColor(SystemColor.textHighlight);
			try {
				telefone1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			telefone1.setHorizontalAlignment(SwingConstants.CENTER);
			telefone1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone1.setColumns(10);
			telefone1.setBounds(558, 184, 124, 32);
			panelPainelVendas.add(telefone1);

			comboFormaPagamento = new JComboBox<String>();
			comboFormaPagamento.setForeground(Color.BLACK);
			comboFormaPagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboFormaPagamento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboFormaPagamento.setBounds(912, 102, 184, 32);
			if (Inicio.rd == 0) {
				comboFormaPagamento.addItem("Dinheiro");
				comboFormaPagamento.addItem("Cheque");
				comboFormaPagamento.addItem("Cartao de Credito");
			}

			quantidade1 = new JSpinner();
			quantidade1.setForeground(Color.BLACK);
			quantidade1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			quantidade1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			quantidade1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null,new Integer(1)));
			quantidade1.setBounds(379, 286, 84, 32);
			panelPainelVendas.add(quantidade1);
			quantidade1.setValue(1);
			panelPainelVendas.add(comboFormaPagamento);

			comboFormaPagamento.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					form = item.toString();
					Vendas.FormaPagamento();
				}
			});

			comboVezes = new JComboBox<String>();
			comboVezes.setForeground(Color.BLACK);
			comboVezes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboVezes.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboVezes.setBounds(1151, 102, 99, 32);
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
					VendasController.CalcularParcela();
					VendasController.CalcularParcelamento();
					VendasController.CalcularTroco();
				}
			});

			agencia1 = new JTextField();
			agencia1.setForeground(Color.BLACK);
			agencia1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					agencia1.setText(agencia1.getText().replaceAll("[^0-9]", ""));
					// agencia1.setText(agencia1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			agencia1.setSelectionColor(SystemColor.textHighlight);
			agencia1.setVisible(false);

			banco1 = new JComboBox<String>();
			banco1.setForeground(Color.BLACK);
			banco1.setVisible(false);
			banco1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			banco1.addItem("");
			banco1.addItem("Banco do Brasil");
			banco1.addItem("Bradesco");
			banco1.addItem("Caixa Economica");
			banco1.addItem("HSBC");
			banco1.addItem("Itaú");
			banco1.addItem("Santander");
			banco1.addItem("Bancoob");
			banco1.addItem("Banestes");
			banco1.addItem("Banpara");
			banco1.addItem("Banrisul");
			banco1.addItem("BCN");
			banco1.addItem("Bank Boston");
			banco1.addItem("Banco Brasilia");
			banco1.addItem("Banco do Nordeste");
			banco1.addItem("Citibank");
			banco1.addItem("Credisan");
			banco1.addItem("Nossa Caixa");
			banco1.addItem("Mercantil do Brasil");
			banco1.addItem("Real");
			banco1.addItem("Safra");
			banco1.addItem("Sicredi");
			banco1.addItem("Sudameris");
			banco1.addItem("Unibanco");
			banco1.addItem("Viacredi");
			banco1.addItem("Sicoob");
			banco1.addItem("Outro Banco...");
			banco1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			banco1.setBounds(1043, 183, 124, 32);
			panelPainelVendas.add(banco1);

			numeroCheque1 = new JTextField();
			numeroCheque1.setForeground(Color.BLACK);
			numeroCheque1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroCheque1.setText(numeroCheque1.getText().replaceAll("[^0-9]", ""));
					// numeroCheque1.setText(numeroCheque1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroCheque1.setSelectionColor(SystemColor.textHighlight);
			numeroCheque1.setVisible(false);

			numeroCheque1.setHorizontalAlignment(SwingConstants.CENTER);
			numeroCheque1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			numeroCheque1.setColumns(10);
			numeroCheque1.setBounds(1043, 226, 124, 32);
			panelPainelVendas.add(numeroCheque1);
			agencia1.setHorizontalAlignment(SwingConstants.CENTER);
			agencia1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			agencia1.setColumns(10);
			agencia1.setBounds(1043, 269, 124, 32);
			panelPainelVendas.add(agencia1);

			numeroConta1 = new JTextField();
			numeroConta1.setForeground(Color.BLACK);
			numeroConta1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroConta1.setText(numeroConta1.getText().replaceAll("[^0-9]", ""));
					// numeroConta1.setText(numeroConta1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroConta1.setSelectionColor(SystemColor.textHighlight);
			numeroConta1.setVisible(false);
			numeroConta1.setHorizontalAlignment(SwingConstants.CENTER);
			numeroConta1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			numeroConta1.setColumns(10);
			numeroConta1.setBounds(1043, 312, 124, 32);
			panelPainelVendas.add(numeroConta1);

			/*
			 * 
			 * Panel Gerenciador de Mesas
			 */

			panelGerencMesas = new JPanel();
			panelGerencMesas.setBackground(SystemColor.inactiveCaptionBorder);
			panelGerencMesas.setLayout(null);

			btMesa1 = new JButton("MESA 1");
			btMesa1.setBorderPainted(false);
			btMesa1.setFocusTraversalPolicyProvider(true);
			btMesa1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa1.setName("mesa1");
			btMesa1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn1 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 1'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 1");
								btn1 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});

			internalFrame_2 = new JInternalFrame("O que deseja fazer?");
			internalFrame_2.setFocusTraversalPolicyProvider(true);
			try {
				internalFrame_2.setIcon(true);
			}
			catch (PropertyVetoException e4) {
				e4.printStackTrace();
			}
			try {
				internalFrame_2.setSelected(true);
			}
			catch (PropertyVetoException e3) {
				e3.printStackTrace();
			}
			internalFrame_2.setClosable(true);
			internalFrame_2.setFrameIcon(new ImageIcon(Vendas.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			internalFrame_2.setBounds(522, 192, 300, 250);
			panelGerencMesas.add(internalFrame_2);
			internalFrame_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,TitledBorder.TOP, null, null));
			internalFrame_2.setBackground(Color.BLACK);
			internalFrame_2.getContentPane().setBackground(new Color(240, 240, 240));
			internalFrame_2.getContentPane().setLayout(null);

			AbrirMesa = new JRadioButton("Abrir Mesa");
			AbrirMesa.setToolTipText("alt + 1");
			AbrirMesa.setMnemonic(KeyEvent.VK_1);
			AbrirMesa.setOpaque(false);
			AbrirMesa.setForeground(Color.BLACK);
			AbrirMesa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			AbrirMesa.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ms = 1;
					Inicio.mesasAbertas = Inicio.mesasAbertas + 1;
					System.out.println(Inicio.mesasAbertas);
					AbrirMesa.setSelected(true);
					ReservarMesa.setSelected(false);
					FecharMesa.setSelected(false);
					Vendas.PegaMesa();
				}
			});
			AbrirMesa.setFont(new Font("Kalinga", Font.PLAIN, 13));
			AbrirMesa.setBounds(92, 51, 137, 32);
			internalFrame_2.getContentPane().add(AbrirMesa);

			ReservarMesa = new JRadioButton("Reservar Mesa");
			ReservarMesa.setToolTipText("alt + 2");
			ReservarMesa.setMnemonic(KeyEvent.VK_2);
			ReservarMesa.setOpaque(false);
			ReservarMesa.setForeground(Color.BLACK);
			ReservarMesa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ReservarMesa.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ms = 2;
					AbrirMesa.setSelected(false);
					ReservarMesa.setSelected(true);
					FecharMesa.setSelected(false);
					// new PainelMesas();
					Vendas.PegaMesa();
				}
			});
			ReservarMesa.setFont(new Font("Kalinga", Font.PLAIN, 13));
			ReservarMesa.setBounds(92, 86, 137, 32);
			internalFrame_2.getContentPane().add(ReservarMesa);

			FecharMesa = new JRadioButton("Fechar Mesa");
			FecharMesa.setToolTipText("alt + 3");
			FecharMesa.setMnemonic(KeyEvent.VK_3);
			FecharMesa.setOpaque(false);
			FecharMesa.setForeground(Color.BLACK);
			FecharMesa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			FecharMesa.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ms = 3;
					AbrirMesa.setSelected(false);
					ReservarMesa.setSelected(false);
					FecharMesa.setSelected(true);
					// new PainelMesas();
					Vendas.PegaMesa();
				}
			});
			FecharMesa.setFont(new Font("Kalinga", Font.PLAIN, 13));
			FecharMesa.setBounds(92, 119, 137, 32);
			internalFrame_2.getContentPane().add(FecharMesa);

			JButton btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					internalFrame_2.setVisible(false);
				}
			});

			btCancelar.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btCancelar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			btCancelar.setBackground(UIManager.getColor("Button.background"));
			btCancelar.setForeground(Color.BLACK);
			btCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btCancelar.setBounds(80, 178, 130, 35);
			internalFrame_2.getContentPane().add(btCancelar);

			JLabel lblSelecioneAOpo = new JLabel("Selecione a opção :");
			lblSelecioneAOpo.setForeground(Color.BLACK);
			lblSelecioneAOpo.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelecioneAOpo.setFont(new Font("Khmer UI", Font.BOLD, 14));
			lblSelecioneAOpo.setBounds(49, 6, 200, 34);
			internalFrame_2.getContentPane().add(lblSelecioneAOpo);

			label_6 = new JLabel("");
			label_6.setHorizontalAlignment(SwingConstants.CENTER);
			label_6.setForeground(Color.BLACK);
			label_6.setFont(new Font("Arial", Font.PLAIN, 12));
			label_6.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/abrir_24px.png")));
			label_6.setBounds(49, 51, 32, 32);
			internalFrame_2.getContentPane().add(label_6);

			label_7 = new JLabel("");
			label_7.setHorizontalAlignment(SwingConstants.CENTER);
			label_7.setForeground(Color.BLACK);
			label_7.setFont(new Font("Arial", Font.PLAIN, 12));
			label_7.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/reservar_24px.png")));
			label_7.setBounds(49, 86, 32, 32);
			internalFrame_2.getContentPane().add(label_7);

			label_8 = new JLabel("");
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			label_8.setForeground(Color.BLACK);
			label_8.setFont(new Font("Arial", Font.PLAIN, 12));
			label_8.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/fechar_24px.png")));
			label_8.setBounds(49, 119, 32, 32);
			internalFrame_2.getContentPane().add(label_8);

			btMesa1.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa1.setForeground(Color.BLACK);
			btMesa1.setVerticalTextPosition(SwingConstants.TOP);
			btMesa1.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa1.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa1.setVerticalAlignment(SwingConstants.TOP);
			btMesa1.setBounds(198, 59, 90, 75);
			panelGerencMesas.add(btMesa1);

			btMesa2 = new JButton("MESA 2");
			btMesa2.setBorderPainted(false);
			btMesa2.setFocusTraversalPolicyProvider(true);
			btMesa2.setBackground(UIManager.getColor("Button.background"));
			btMesa2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa2.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa2.setForeground(Color.BLACK);
			btMesa2.setVerticalTextPosition(SwingConstants.TOP);
			btMesa2.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa2.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa2.setVerticalAlignment(SwingConstants.TOP);
			btMesa2.setBounds(298, 59, 90, 75);
			btMesa2.setName("mesa2");
			btMesa2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn2 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 2'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 2");
								btn2 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panelGerencMesas.add(btMesa2);

			btMesa4 = new JButton("MESA 4");
			btMesa4.setBorderPainted(false);
			btMesa4.setFocusTraversalPolicyProvider(true);
			btMesa4.setBackground(UIManager.getColor("Button.background"));
			btMesa4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa4.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa4.setForeground(Color.BLACK);
			btMesa4.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa4.setVerticalTextPosition(SwingConstants.TOP);
			btMesa4.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa4.setVerticalAlignment(SwingConstants.TOP);
			btMesa4.setBounds(498, 59, 90, 75);
			btMesa4.setName("mesa4");
			btMesa4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn4 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 4'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 4");
								btn4 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panelGerencMesas.add(btMesa4);

			btMesa3 = new JButton("MESA 3");
			btMesa3.setBorderPainted(false);
			btMesa3.setFocusTraversalPolicyProvider(true);
			btMesa3.setBackground(UIManager.getColor("Button.background"));
			btMesa3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa3.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa3.setForeground(Color.BLACK);
			btMesa3.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa3.setVerticalTextPosition(SwingConstants.TOP);
			btMesa3.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa3.setVerticalAlignment(SwingConstants.TOP);
			btMesa3.setBounds(398, 59, 90, 75);
			btMesa3.setName("mesa3");
			btMesa3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn3 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 3'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 3");
								btn3 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			panelGerencMesas.add(btMesa3);

			btMesa8 = new JButton("MESA 8");
			btMesa8.setBorderPainted(false);
			btMesa8.setFocusTraversalPolicyProvider(true);
			btMesa8.setBackground(UIManager.getColor("Button.background"));
			btMesa8.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa8.setName("mesa8");
			btMesa8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn8 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 8'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 8");
								btn8 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa8.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa8.setForeground(Color.BLACK);
			btMesa8.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa8.setVerticalTextPosition(SwingConstants.TOP);
			btMesa8.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa8.setVerticalAlignment(SwingConstants.TOP);
			btMesa8.setBounds(898, 59, 90, 75);
			panelGerencMesas.add(btMesa8);

			btMesa5 = new JButton("MESA 5");
			btMesa5.setBorderPainted(false);
			btMesa5.setFocusTraversalPolicyProvider(true);
			btMesa5.setBackground(UIManager.getColor("Button.background"));
			btMesa5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa5.setName("mesa5");
			btMesa5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn5 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 5'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 5");
								btn5 = 1;
							}

						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa5.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa5.setForeground(Color.BLACK);
			btMesa5.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa5.setVerticalTextPosition(SwingConstants.TOP);
			btMesa5.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa5.setVerticalAlignment(SwingConstants.TOP);
			btMesa5.setBounds(598, 59, 90, 75);
			panelGerencMesas.add(btMesa5);

			btMesa6 = new JButton("MESA 6");
			btMesa6.setBorderPainted(false);
			btMesa6.setFocusTraversalPolicyProvider(true);
			btMesa6.setBackground(UIManager.getColor("Button.background"));
			btMesa6.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa6.setName("mesa6");
			btMesa6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn6 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 6'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 6");
								btn6 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa6.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa6.setForeground(Color.BLACK);
			btMesa6.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa6.setVerticalTextPosition(SwingConstants.TOP);
			btMesa6.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa6.setVerticalAlignment(SwingConstants.TOP);
			btMesa6.setBounds(698, 59, 90, 75);
			panelGerencMesas.add(btMesa6);

			btMesa7 = new JButton("MESA 7");
			btMesa7.setBorderPainted(false);
			btMesa7.setFocusTraversalPolicyProvider(true);
			btMesa7.setBackground(UIManager.getColor("Button.background"));
			btMesa7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa7.setName("mesa7");
			btMesa7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn7 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 7'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 7");
								btn7 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa7.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa7.setForeground(Color.BLACK);
			btMesa7.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa7.setVerticalTextPosition(SwingConstants.TOP);
			btMesa7.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa7.setVerticalAlignment(SwingConstants.TOP);
			btMesa7.setBounds(798, 59, 90, 75);
			panelGerencMesas.add(btMesa7);

			btMesa9 = new JButton("MESA 9");
			btMesa9.setBorderPainted(false);
			btMesa9.setFocusTraversalPolicyProvider(true);
			btMesa9.setBackground(UIManager.getColor("Button.background"));
			btMesa9.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btMesa9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa9.setName("mesa9");
			btMesa9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn9 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 9'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 9");
								btn9 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa9.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa9.setForeground(Color.BLACK);
			btMesa9.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa9.setVerticalTextPosition(SwingConstants.TOP);
			btMesa9.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa9.setVerticalAlignment(SwingConstants.TOP);
			btMesa9.setBounds(998, 59, 90, 75);
			panelGerencMesas.add(btMesa9);

			btMesa10 = new JButton("MESA 10");
			btMesa10.setBorderPainted(false);
			btMesa10.setFocusTraversalPolicyProvider(true);
			btMesa10.setBackground(UIManager.getColor("Button.background"));
			btMesa10.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa10.setName("mesa10");
			btMesa10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn10 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 10'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 10");
								btn10 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa10.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa10.setForeground(Color.BLACK);
			btMesa10.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa10.setVerticalTextPosition(SwingConstants.TOP);
			btMesa10.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa10.setVerticalAlignment(SwingConstants.TOP);
			btMesa10.setBounds(1098, 59, 90, 75);
			panelGerencMesas.add(btMesa10);

			btMesa20 = new JButton("MESA 20");
			btMesa20.setBorderPainted(false);
			btMesa20.setFocusTraversalPolicyProvider(true);
			btMesa20.setBackground(UIManager.getColor("Button.background"));
			btMesa20.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa20.setName("mesa20");
			btMesa20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn20 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 20'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 20");
								btn20 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa20.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa20.setForeground(Color.BLACK);
			btMesa20.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa20.setVerticalTextPosition(SwingConstants.TOP);
			btMesa20.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa20.setVerticalAlignment(SwingConstants.TOP);
			btMesa20.setBounds(1098, 189, 90, 75);
			panelGerencMesas.add(btMesa20);

			btMesa19 = new JButton("MESA 19");
			btMesa19.setBorderPainted(false);
			btMesa19.setFocusTraversalPolicyProvider(true);
			btMesa19.setBackground(UIManager.getColor("Button.background"));
			btMesa19.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa19.setName("mesa19");
			btMesa19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn19 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 19'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 19");
								btn19 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa19.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa19.setForeground(Color.BLACK);
			btMesa19.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa19.setVerticalTextPosition(SwingConstants.TOP);
			btMesa19.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa19.setVerticalAlignment(SwingConstants.TOP);
			btMesa19.setBounds(998, 189, 90, 75);
			panelGerencMesas.add(btMesa19);

			btMesa18 = new JButton("MESA 18");
			btMesa18.setBorderPainted(false);
			btMesa18.setFocusTraversalPolicyProvider(true);
			btMesa18.setBackground(UIManager.getColor("Button.background"));
			btMesa18.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa18.setName("mesa18");
			btMesa18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn18 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 18'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 18");
								btn18 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa18.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa18.setForeground(Color.BLACK);
			btMesa18.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa18.setVerticalTextPosition(SwingConstants.TOP);
			btMesa18.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa18.setVerticalAlignment(SwingConstants.TOP);
			btMesa18.setBounds(898, 189, 90, 75);
			panelGerencMesas.add(btMesa18);

			btMesa17 = new JButton("MESA 17");
			btMesa17.setBorderPainted(false);
			btMesa17.setFocusTraversalPolicyProvider(true);
			btMesa17.setBackground(UIManager.getColor("Button.background"));
			btMesa17.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa17.setName("mesa17");
			btMesa17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn17 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 17'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 17");
								btn17 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa17.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa17.setForeground(Color.BLACK);
			btMesa17.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa17.setVerticalTextPosition(SwingConstants.TOP);
			btMesa17.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa17.setVerticalAlignment(SwingConstants.TOP);
			btMesa17.setBounds(798, 191, 90, 75);
			panelGerencMesas.add(btMesa17);

			btMesa16 = new JButton("MESA 16");
			btMesa16.setBorderPainted(false);
			btMesa16.setFocusTraversalPolicyProvider(true);
			btMesa16.setBackground(UIManager.getColor("Button.background"));
			btMesa16.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa16.setName("mesa16");
			btMesa16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn16 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 16'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 16");
								btn16 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa16.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa16.setForeground(Color.BLACK);
			btMesa16.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa16.setVerticalTextPosition(SwingConstants.TOP);
			btMesa16.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa16.setVerticalAlignment(SwingConstants.TOP);
			btMesa16.setBounds(698, 191, 90, 75);
			panelGerencMesas.add(btMesa16);

			btMesa15 = new JButton("MESA 15");
			btMesa15.setBorderPainted(false);
			btMesa15.setFocusTraversalPolicyProvider(true);
			btMesa15.setBackground(UIManager.getColor("Button.background"));
			btMesa15.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa15.setName("mesa15");
			btMesa15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn15 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 15'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 15");
								btn15 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa15.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa15.setForeground(Color.BLACK);
			btMesa15.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa15.setVerticalTextPosition(SwingConstants.TOP);
			btMesa15.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa15.setVerticalAlignment(SwingConstants.TOP);
			btMesa15.setBounds(598, 191, 90, 75);
			panelGerencMesas.add(btMesa15);

			btMesa14 = new JButton("MESA 14");
			btMesa14.setBorderPainted(false);
			btMesa14.setFocusTraversalPolicyProvider(true);
			btMesa14.setBackground(UIManager.getColor("Button.background"));
			btMesa14.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa14.setName("mesa14");
			btMesa14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn14 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 14'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 14");
								btn14 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa14.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa14.setForeground(Color.BLACK);
			btMesa14.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa14.setVerticalTextPosition(SwingConstants.TOP);
			btMesa14.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa14.setVerticalAlignment(SwingConstants.TOP);
			btMesa14.setBounds(498, 191, 90, 75);
			panelGerencMesas.add(btMesa14);

			btMesa13 = new JButton("MESA 13");
			btMesa13.setBorderPainted(false);
			btMesa13.setFocusTraversalPolicyProvider(true);
			btMesa13.setBackground(UIManager.getColor("Button.background"));
			btMesa13.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa13.setName("mesa13");
			btMesa13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn13 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 13'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 13");
								btn13 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa13.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa13.setForeground(Color.BLACK);
			btMesa13.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa13.setVerticalTextPosition(SwingConstants.TOP);
			btMesa13.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa13.setVerticalAlignment(SwingConstants.TOP);
			btMesa13.setBounds(398, 191, 90, 75);
			panelGerencMesas.add(btMesa13);

			btMesa12 = new JButton("MESA 12");
			btMesa12.setBorderPainted(false);
			btMesa12.setFocusTraversalPolicyProvider(true);
			btMesa12.setBackground(UIManager.getColor("Button.background"));
			btMesa12.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa12.setName("mesa12");
			btMesa12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn12 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 12'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 12");
								btn12 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa12.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa12.setForeground(Color.BLACK);
			btMesa12.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa12.setVerticalTextPosition(SwingConstants.TOP);
			btMesa12.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa12.setVerticalAlignment(SwingConstants.TOP);
			btMesa12.setBounds(298, 191, 90, 75);
			panelGerencMesas.add(btMesa12);

			btMesa11 = new JButton("MESA 11");
			btMesa11.setBorderPainted(false);
			btMesa11.setFocusTraversalPolicyProvider(true);
			btMesa11.setBackground(UIManager.getColor("Button.background"));
			btMesa11.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa11.setName("mesa11");
			btMesa11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn11 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 11'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 11");
								btn11 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa11.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa11.setForeground(Color.BLACK);
			btMesa11.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa11.setVerticalTextPosition(SwingConstants.TOP);
			btMesa11.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa11.setVerticalAlignment(SwingConstants.TOP);
			btMesa11.setBounds(198, 189, 90, 75);
			panelGerencMesas.add(btMesa11);

			btMesa30 = new JButton("MESA 30");
			btMesa30.setBorderPainted(false);
			btMesa30.setFocusTraversalPolicyProvider(true);
			btMesa30.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa30.setName("mesa30");
			btMesa30.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn30 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 30'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 30");
								btn30 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa30.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa30.setForeground(Color.BLACK);
			btMesa30.setBackground(UIManager.getColor("Button.background"));
			btMesa30.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa30.setVerticalTextPosition(SwingConstants.TOP);
			btMesa30.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa30.setVerticalAlignment(SwingConstants.TOP);
			btMesa30.setBounds(1098, 318, 90, 75);
			panelGerencMesas.add(btMesa30);

			btMesa29 = new JButton("MESA 29");
			btMesa29.setBorderPainted(false);
			btMesa29.setFocusTraversalPolicyProvider(true);
			btMesa29.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa29.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa29.setName("mesa29");
			btMesa29.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn29 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 29'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 29");
								btn29 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa29.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa29.setForeground(Color.BLACK);
			btMesa29.setBackground(UIManager.getColor("Button.background"));
			btMesa29.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa29.setVerticalTextPosition(SwingConstants.TOP);
			btMesa29.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa29.setVerticalAlignment(SwingConstants.TOP);
			btMesa29.setBounds(998, 318, 90, 75);
			panelGerencMesas.add(btMesa29);

			btMesa28 = new JButton("MESA 28");
			btMesa28.setBorderPainted(false);
			btMesa28.setFocusTraversalPolicyProvider(true);
			btMesa28.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa28.setName("mesa28");
			btMesa28.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn28 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x.Consultar("select*from mesas where numeroMesa = '* MESA 28'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 28");
								btn28 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa28.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa28.setForeground(Color.BLACK);
			btMesa28.setBackground(UIManager.getColor("Button.background"));
			btMesa28.setIcon(new ImageIcon(Vendas.class.getResource("/imagens_principais/mesa_40px.png")));
			btMesa28.setVerticalTextPosition(SwingConstants.TOP);
			btMesa28.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa28.setVerticalAlignment(SwingConstants.TOP);
			btMesa28.setBounds(898, 318, 90, 75);
			panelGerencMesas.add(btMesa28);

			btMesa27 = new JButton("MESA 27");
			btMesa27.setBorderPainted(false);
			btMesa27.setFocusTraversalPolicyProvider(true);
			btMesa27.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,null));
			btMesa27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa27.setName("mesa27");
			btMesa27.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn27 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 27'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 27");
								btn27 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa27.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa27.setForeground(Color.BLACK);
			btMesa27.setBackground(UIManager.getColor("Button.background"));
			btMesa27.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa27.setVerticalTextPosition(SwingConstants.TOP);
			btMesa27.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa27.setVerticalAlignment(SwingConstants.TOP);
			btMesa27.setBounds(798, 318, 90, 75);
			panelGerencMesas.add(btMesa27);

			btMesa26 = new JButton("MESA 26");
			btMesa26.setBorderPainted(false);
			btMesa26.setFocusTraversalPolicyProvider(true);
			btMesa26.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa26.setName("mesa26");
			btMesa26.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn26 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 26'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 26");
								btn26 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa26.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa26.setForeground(Color.BLACK);
			btMesa26.setBackground(UIManager.getColor("Button.background"));
			btMesa26.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa26.setVerticalTextPosition(SwingConstants.TOP);
			btMesa26.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa26.setVerticalAlignment(SwingConstants.TOP);
			btMesa26.setBounds(698, 318, 90, 75);
			panelGerencMesas.add(btMesa26);

			btMesa25 = new JButton("MESA 25");
			btMesa25.setBorderPainted(false);
			btMesa25.setFocusTraversalPolicyProvider(true);
			btMesa25.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa25.setName("mesa25");
			btMesa25.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn25 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 25'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 25");
								btn25 = 1;
							}

						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa25.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa25.setForeground(Color.BLACK);
			btMesa25.setBackground(UIManager.getColor("Button.background"));
			btMesa25.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa25.setVerticalTextPosition(SwingConstants.TOP);
			btMesa25.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa25.setVerticalAlignment(SwingConstants.TOP);
			btMesa25.setBounds(598, 318, 90, 75);
			panelGerencMesas.add(btMesa25);

			btMesa24 = new JButton("MESA 24");
			btMesa24.setBorderPainted(false);
			btMesa24.setFocusTraversalPolicyProvider(true);
			btMesa24.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa24.setName("mesa24");
			btMesa24.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn24 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 24'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 24");
								btn24 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa24.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa24.setForeground(Color.BLACK);
			btMesa24.setBackground(UIManager.getColor("Button.background"));
			btMesa24.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa24.setVerticalTextPosition(SwingConstants.TOP);
			btMesa24.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa24.setVerticalAlignment(SwingConstants.TOP);
			btMesa24.setBounds(498, 318, 90, 75);
			panelGerencMesas.add(btMesa24);

			btMesa23 = new JButton("MESA 23");
			btMesa23.setBorderPainted(false);
			btMesa23.setFocusTraversalPolicyProvider(true);
			btMesa23.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa23.setName("mesa23");
			btMesa23.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn23 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 23'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 23");
								btn23 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa23.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa23.setForeground(Color.BLACK);
			btMesa23.setBackground(UIManager.getColor("Button.background"));
			btMesa23.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa23.setVerticalTextPosition(SwingConstants.TOP);
			btMesa23.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa23.setVerticalAlignment(SwingConstants.TOP);
			btMesa23.setBounds(398, 318, 90, 75);
			panelGerencMesas.add(btMesa23);

			btMesa22 = new JButton("MESA 22");
			btMesa22.setBorderPainted(false);
			btMesa22.setFocusTraversalPolicyProvider(true);
			btMesa22.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa22.setName("mesa22");
			btMesa22.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn22 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 22'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 22");
								btn22 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa22.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa22.setForeground(Color.BLACK);
			btMesa22.setBackground(UIManager.getColor("Button.background"));
			btMesa22.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa22.setVerticalTextPosition(SwingConstants.TOP);
			btMesa22.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa22.setVerticalAlignment(SwingConstants.TOP);
			btMesa22.setBounds(298, 318, 90, 75);
			panelGerencMesas.add(btMesa22);

			btMesa21 = new JButton("MESA 21");
			btMesa21.setBorderPainted(false);
			btMesa21.setFocusTraversalPolicyProvider(true);
			btMesa21.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa21.setName("mesa21");
			btMesa21.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn21 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 21'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 21");
								btn21 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa21.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa21.setForeground(Color.BLACK);
			btMesa21.setBackground(UIManager.getColor("Button.background"));
			btMesa21.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa21.setVerticalTextPosition(SwingConstants.TOP);
			btMesa21.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa21.setVerticalAlignment(SwingConstants.TOP);
			btMesa21.setBounds(198, 318, 90, 75);
			panelGerencMesas.add(btMesa21);

			btMesa31 = new JButton("MESA 31");
			btMesa31.setBorderPainted(false);
			btMesa31.setFocusTraversalPolicyProvider(true);
			btMesa31.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa31.setName("mesa31");
			btMesa31.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn31 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 31'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 31");
								btn31 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa31.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa31.setForeground(Color.BLACK);
			btMesa31.setBackground(UIManager.getColor("Button.background"));
			btMesa31.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa31.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa31.setVerticalTextPosition(SwingConstants.TOP);
			btMesa31.setVerticalAlignment(SwingConstants.TOP);
			btMesa31.setBounds(198, 448, 90, 75);
			panelGerencMesas.add(btMesa31);

			btMesa32 = new JButton("MESA 32");
			btMesa32.setBorderPainted(false);
			btMesa32.setFocusTraversalPolicyProvider(true);
			btMesa32.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa32.setName("mesa32");
			btMesa32.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn32 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 32'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 32");
								btn32 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa32.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa32.setForeground(Color.BLACK);
			btMesa32.setBackground(UIManager.getColor("Button.background"));
			btMesa32.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa32.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa32.setVerticalTextPosition(SwingConstants.TOP);
			btMesa32.setVerticalAlignment(SwingConstants.TOP);
			btMesa32.setBounds(298, 448, 90, 75);
			panelGerencMesas.add(btMesa32);

			btMesa33 = new JButton("MESA 33");
			btMesa33.setBorderPainted(false);
			btMesa33.setFocusTraversalPolicyProvider(true);
			btMesa33.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa33.setName("mesa33");
			btMesa33.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn33 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 33'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 33");
								btn33 = 1;
							}

						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa33.setForeground(Color.BLACK);
			btMesa33.setBackground(UIManager.getColor("Button.background"));
			btMesa33.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa33.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa33.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa33.setVerticalTextPosition(SwingConstants.TOP);
			btMesa33.setVerticalAlignment(SwingConstants.TOP);
			btMesa33.setBounds(398, 448, 90, 75);
			panelGerencMesas.add(btMesa33);

			btMesa34 = new JButton("MESA 34");
			btMesa34.setBorderPainted(false);
			btMesa34.setFocusTraversalPolicyProvider(true);
			btMesa34.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa34.setName("mesa34");
			btMesa34.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn34 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 34'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 34");
								btn34 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa34.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa34.setForeground(Color.BLACK);
			btMesa34.setBackground(UIManager.getColor("Button.background"));
			btMesa34.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa34.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa34.setVerticalTextPosition(SwingConstants.TOP);
			btMesa34.setVerticalAlignment(SwingConstants.TOP);
			btMesa34.setBounds(498, 448, 90, 75);
			panelGerencMesas.add(btMesa34);

			btMesa35 = new JButton("MESA 35");
			btMesa35.setBorderPainted(false);
			btMesa35.setFocusTraversalPolicyProvider(true);
			btMesa35.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa35.setName("mesa35");
			btMesa35.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn35 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 35'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 35");
								btn35 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa35.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa35.setForeground(Color.BLACK);
			btMesa35.setBackground(UIManager.getColor("Button.background"));
			btMesa35.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa35.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa35.setVerticalTextPosition(SwingConstants.TOP);
			btMesa35.setVerticalAlignment(SwingConstants.TOP);
			btMesa35.setBounds(598, 448, 90, 75);
			panelGerencMesas.add(btMesa35);

			btMesa36 = new JButton("MESA 36");
			btMesa36.setBorderPainted(false);
			btMesa36.setFocusTraversalPolicyProvider(true);
			btMesa36.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa36.setName("mesa36");
			btMesa36.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn36 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 36'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 36");
								btn36 = 1;
							}

						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa36.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa36.setForeground(Color.BLACK);
			btMesa36.setBackground(UIManager.getColor("Button.background"));
			btMesa36.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa36.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa36.setVerticalTextPosition(SwingConstants.TOP);
			btMesa36.setVerticalAlignment(SwingConstants.TOP);
			btMesa36.setBounds(698, 448, 90, 75);
			panelGerencMesas.add(btMesa36);

			btMesa37 = new JButton("MESA 37");
			btMesa37.setBorderPainted(false);
			btMesa37.setFocusTraversalPolicyProvider(true);
			btMesa37.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa37.setName("mesa37");
			btMesa37.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn37 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 37'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 37");
								btn37 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa37.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa37.setForeground(Color.BLACK);
			btMesa37.setBackground(UIManager.getColor("Button.background"));
			btMesa37.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa37.setVerticalTextPosition(SwingConstants.TOP);
			btMesa37.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa37.setVerticalAlignment(SwingConstants.TOP);
			btMesa37.setBounds(798, 448, 90, 75);
			panelGerencMesas.add(btMesa37);

			btMesa38 = new JButton("MESA 38");
			btMesa38.setBorderPainted(false);
			btMesa38.setFocusTraversalPolicyProvider(true);
			btMesa38.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa38.setName("mesa38");
			btMesa38.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn38 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 38'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 38");
								btn38 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa38.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa38.setForeground(Color.BLACK);
			btMesa38.setBackground(UIManager.getColor("Button.background"));
			btMesa38.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa38.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa38.setVerticalTextPosition(SwingConstants.TOP);
			btMesa38.setVerticalAlignment(SwingConstants.TOP);
			btMesa38.setBounds(898, 448, 90, 75);
			panelGerencMesas.add(btMesa38);

			btMesa39 = new JButton("MESA 39");
			btMesa39.setBorderPainted(false);
			btMesa39.setFocusTraversalPolicyProvider(true);
			btMesa39.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa39.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa39.setName("mesa39");
			btMesa39.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn39 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 39'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 39");
								btn39 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa39.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa39.setForeground(Color.BLACK);
			btMesa39.setBackground(UIManager.getColor("Button.background"));
			btMesa39.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa39.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa39.setVerticalTextPosition(SwingConstants.TOP);
			btMesa39.setVerticalAlignment(SwingConstants.TOP);
			btMesa39.setBounds(998, 448, 90, 75);
			panelGerencMesas.add(btMesa39);

			btMesa40 = new JButton("MESA 40");
			btMesa40.setBorderPainted(false);
			btMesa40.setFocusTraversalPolicyProvider(true);
			btMesa40.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null,
			            null));
			btMesa40.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btMesa40.setName("mesa40");
			btMesa40.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn40 == 0) {
						System.out.println(((Component) e.getSource()).getName());
						mesa = ((Component) e.getSource()).getName();
						ResultSet dados = x
						            .Consultar("select*from mesas where numeroMesa = '* MESA 40'");
						try {
							dados.next();
							if (dados.getString("numeroVenda").equals("null")) {
								internalFrame_2.setVisible(true);
							}
							else {
								PainelMesas ob = new PainelMesas();
								ob.CarregarMesa("* MESA 40");
								btn40 = 1;
							}
						}
						catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			btMesa40.setFont(new Font("Kalinga", Font.BOLD, 12));
			btMesa40.setForeground(Color.BLACK);
			btMesa40.setBackground(UIManager.getColor("Button.background"));
			btMesa40.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/mesa_40px.png")));
			btMesa40.setHorizontalTextPosition(SwingConstants.CENTER);
			btMesa40.setVerticalTextPosition(SwingConstants.TOP);
			btMesa40.setVerticalAlignment(SwingConstants.TOP);
			btMesa40.setBounds(1098, 448, 90, 75);
			panelGerencMesas.add(btMesa40);

			JLabel lblmapaDeMesas = new JLabel("Mapa de Mesas");
			lblmapaDeMesas.setHorizontalAlignment(SwingConstants.CENTER);
			lblmapaDeMesas.setForeground(Color.BLACK);
			lblmapaDeMesas.setFont(new Font("Khmer UI", Font.BOLD, 22));
			lblmapaDeMesas.setBounds(582, 9, 181, 38);
			panelGerencMesas.add(lblmapaDeMesas);

			lbMs1 = new JLabel("R$ 0,00");
			lbMs1.setInheritsPopupMenu(false);
			lbMs1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs1.setOpaque(true);
			lbMs1.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs1.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs1.setBorder(null);
			lbMs1.setBackground(UIManager.getColor("Button.background"));
			lbMs1.setForeground(Color.BLACK);
			lbMs1.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs1.setBounds(198, 134, 90, 32);
			panelGerencMesas.add(lbMs1);

			lbMs2 = new JLabel("R$ 0,00");
			lbMs2.setInheritsPopupMenu(false);
			lbMs2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs2.setOpaque(true);
			lbMs2.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs2.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs2.setBorder(null);
			lbMs2.setBackground(UIManager.getColor("Button.background"));
			lbMs2.setForeground(Color.BLACK);
			lbMs2.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs2.setBounds(298, 134, 90, 32);
			panelGerencMesas.add(lbMs2);

			lbMs3 = new JLabel("R$ 0,00");
			lbMs3.setInheritsPopupMenu(false);
			lbMs3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs3.setOpaque(true);
			lbMs3.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs3.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs3.setBorder(null);
			lbMs3.setBackground(UIManager.getColor("Button.background"));
			lbMs3.setForeground(Color.BLACK);
			lbMs3.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs3.setBounds(398, 134, 90, 32);
			panelGerencMesas.add(lbMs3);

			lbMs4 = new JLabel("R$ 0,00");
			lbMs4.setInheritsPopupMenu(false);
			lbMs4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs4.setOpaque(true);
			lbMs4.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs4.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs4.setBorder(null);
			lbMs4.setBackground(UIManager.getColor("Button.background"));
			lbMs4.setForeground(Color.BLACK);
			lbMs4.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs4.setBounds(498, 134, 90, 32);
			panelGerencMesas.add(lbMs4);

			lbMs5 = new JLabel("R$ 0,00");
			lbMs5.setInheritsPopupMenu(false);
			lbMs5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs5.setOpaque(true);
			lbMs5.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs5.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs5.setBorder(null);
			lbMs5.setBackground(UIManager.getColor("Button.background"));
			lbMs5.setForeground(Color.BLACK);
			lbMs5.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs5.setBounds(598, 134, 90, 32);
			panelGerencMesas.add(lbMs5);

			lbMs6 = new JLabel("R$ 0,00");
			lbMs6.setInheritsPopupMenu(false);
			lbMs6.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs6.setOpaque(true);
			lbMs6.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs6.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs6.setBorder(null);
			lbMs6.setBackground(UIManager.getColor("Button.background"));
			lbMs6.setForeground(Color.BLACK);
			lbMs6.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs6.setBounds(698, 134, 90, 32);
			panelGerencMesas.add(lbMs6);

			lbMs7 = new JLabel("R$ 0,00");
			lbMs7.setInheritsPopupMenu(false);
			lbMs7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs7.setOpaque(true);
			lbMs7.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs7.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs7.setBorder(null);
			lbMs7.setBackground(UIManager.getColor("Button.background"));
			lbMs7.setForeground(Color.BLACK);
			lbMs7.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs7.setBounds(798, 134, 90, 32);
			panelGerencMesas.add(lbMs7);

			lbMs8 = new JLabel("R$ 0,00");
			lbMs8.setInheritsPopupMenu(false);
			lbMs8.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs8.setOpaque(true);
			lbMs8.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs8.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs8.setBorder(null);
			lbMs8.setBackground(UIManager.getColor("Button.background"));
			lbMs8.setForeground(Color.BLACK);
			lbMs8.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs8.setBounds(898, 134, 90, 32);
			panelGerencMesas.add(lbMs8);

			lbMs9 = new JLabel("R$ 0,00");
			lbMs9.setInheritsPopupMenu(false);
			lbMs9.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs9.setOpaque(true);
			lbMs9.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs9.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs9.setBorder(null);
			lbMs9.setBackground(UIManager.getColor("Button.background"));
			lbMs9.setForeground(Color.BLACK);
			lbMs9.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs9.setBounds(998, 134, 90, 32);
			panelGerencMesas.add(lbMs9);

			lbMs10 = new JLabel("R$ 0,00");
			lbMs10.setInheritsPopupMenu(false);
			lbMs10.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs10.setOpaque(true);
			lbMs10.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs10.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs10.setBorder(null);
			lbMs10.setBackground(UIManager.getColor("Button.background"));
			lbMs10.setForeground(Color.BLACK);
			lbMs10.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs10.setBounds(1098, 134, 90, 32);
			panelGerencMesas.add(lbMs10);

			lbMs20 = new JLabel("R$ 0,00");
			lbMs20.setInheritsPopupMenu(false);
			lbMs20.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs20.setOpaque(true);
			lbMs20.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs20.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs20.setBorder(null);
			lbMs20.setBackground(UIManager.getColor("Button.background"));
			lbMs20.setForeground(Color.BLACK);
			lbMs20.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs20.setBounds(1098, 264, 90, 32);
			panelGerencMesas.add(lbMs20);

			lbMs19 = new JLabel("R$ 0,00");
			lbMs19.setInheritsPopupMenu(false);
			lbMs19.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs19.setOpaque(true);
			lbMs19.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs19.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs19.setBorder(null);
			lbMs19.setBackground(UIManager.getColor("Button.background"));
			lbMs19.setForeground(Color.BLACK);
			lbMs19.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs19.setBounds(998, 264, 90, 32);
			panelGerencMesas.add(lbMs19);

			lbMs18 = new JLabel("R$ 0,00");
			lbMs18.setInheritsPopupMenu(false);
			lbMs18.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs18.setOpaque(true);
			lbMs18.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs18.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs18.setBorder(null);
			lbMs18.setBackground(UIManager.getColor("Button.background"));
			lbMs18.setForeground(Color.BLACK);
			lbMs18.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs18.setBounds(898, 264, 90, 32);
			panelGerencMesas.add(lbMs18);

			lbMs17 = new JLabel("R$ 0,00");
			lbMs17.setInheritsPopupMenu(false);
			lbMs17.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs17.setOpaque(true);
			lbMs17.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs17.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs17.setBorder(null);
			lbMs17.setBackground(UIManager.getColor("Button.background"));
			lbMs17.setForeground(Color.BLACK);
			lbMs17.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs17.setBounds(798, 264, 90, 32);
			panelGerencMesas.add(lbMs17);

			lbMs16 = new JLabel("R$ 0,00");
			lbMs16.setInheritsPopupMenu(false);
			lbMs16.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs16.setOpaque(true);
			lbMs16.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs16.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs16.setBorder(null);
			lbMs16.setBackground(UIManager.getColor("Button.background"));
			lbMs16.setForeground(Color.BLACK);
			lbMs16.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs16.setBounds(698, 264, 90, 32);
			panelGerencMesas.add(lbMs16);

			lbMs11 = new JLabel("R$ 0,00");
			lbMs11.setInheritsPopupMenu(false);
			lbMs11.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs11.setOpaque(true);
			lbMs11.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs11.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs11.setBorder(null);
			lbMs11.setBackground(UIManager.getColor("Button.background"));
			lbMs11.setForeground(Color.BLACK);
			lbMs11.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs11.setBounds(198, 264, 90, 32);
			panelGerencMesas.add(lbMs11);

			lbMs12 = new JLabel("R$ 0,00");
			lbMs12.setInheritsPopupMenu(false);
			lbMs12.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs12.setOpaque(true);
			lbMs12.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs12.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs12.setBorder(null);
			lbMs12.setBackground(UIManager.getColor("Button.background"));
			lbMs12.setForeground(Color.BLACK);
			lbMs12.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs12.setBounds(298, 264, 90, 32);
			panelGerencMesas.add(lbMs12);

			lbMs13 = new JLabel("R$ 0,00");
			lbMs13.setInheritsPopupMenu(false);
			lbMs13.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs13.setOpaque(true);
			lbMs13.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs13.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs13.setBorder(null);
			lbMs13.setBackground(UIManager.getColor("Button.background"));
			lbMs13.setForeground(Color.BLACK);
			lbMs13.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs13.setBounds(398, 264, 90, 32);
			panelGerencMesas.add(lbMs13);

			lbMs14 = new JLabel("R$ 0,00");
			lbMs14.setInheritsPopupMenu(false);
			lbMs14.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs14.setOpaque(true);
			lbMs14.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs14.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs14.setBorder(null);
			lbMs14.setBackground(UIManager.getColor("Button.background"));
			lbMs14.setForeground(Color.BLACK);
			lbMs14.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs14.setBounds(498, 264, 90, 32);
			panelGerencMesas.add(lbMs14);

			lbMs15 = new JLabel("R$ 0,00");
			lbMs15.setInheritsPopupMenu(false);
			lbMs15.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs15.setOpaque(true);
			lbMs15.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs15.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs15.setBorder(null);
			lbMs15.setBackground(UIManager.getColor("Button.background"));
			lbMs15.setForeground(Color.BLACK);
			lbMs15.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs15.setBounds(598, 264, 90, 32);
			panelGerencMesas.add(lbMs15);

			lbMs30 = new JLabel("R$ 0,00");
			lbMs30.setInheritsPopupMenu(false);
			lbMs30.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs30.setOpaque(true);
			lbMs30.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs30.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs30.setBorder(null);
			lbMs30.setBackground(UIManager.getColor("Button.background"));
			lbMs30.setForeground(Color.BLACK);
			lbMs30.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs30.setBounds(1098, 393, 90, 32);
			panelGerencMesas.add(lbMs30);

			lbMs29 = new JLabel("R$ 0,00");
			lbMs29.setInheritsPopupMenu(false);
			lbMs29.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs29.setOpaque(true);
			lbMs29.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs29.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs29.setBorder(null);
			lbMs29.setBackground(UIManager.getColor("Button.background"));
			lbMs29.setForeground(Color.BLACK);
			lbMs29.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs29.setBounds(998, 393, 90, 32);
			panelGerencMesas.add(lbMs29);

			lbMs28 = new JLabel("R$ 0,00");
			lbMs28.setInheritsPopupMenu(false);
			lbMs28.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs28.setOpaque(true);
			lbMs28.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs28.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs28.setBorder(null);
			lbMs28.setBackground(UIManager.getColor("Button.background"));
			lbMs28.setForeground(Color.BLACK);
			lbMs28.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs28.setBounds(898, 393, 90, 32);
			panelGerencMesas.add(lbMs28);

			lbMs27 = new JLabel("R$ 0,00");
			lbMs27.setInheritsPopupMenu(false);
			lbMs27.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs27.setOpaque(true);
			lbMs27.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs27.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs27.setBorder(null);
			lbMs27.setBackground(UIManager.getColor("Button.background"));
			lbMs27.setForeground(Color.BLACK);
			lbMs27.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs27.setBounds(798, 393, 90, 32);
			panelGerencMesas.add(lbMs27);

			lbMs26 = new JLabel("R$ 0,00");
			lbMs26.setInheritsPopupMenu(false);
			lbMs26.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs26.setOpaque(true);
			lbMs26.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs26.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs26.setBorder(null);
			lbMs26.setBackground(UIManager.getColor("Button.background"));
			lbMs26.setForeground(Color.BLACK);
			lbMs26.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs26.setBounds(698, 393, 90, 32);
			panelGerencMesas.add(lbMs26);

			lbMs21 = new JLabel("R$ 0,00");
			lbMs21.setInheritsPopupMenu(false);
			lbMs21.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs21.setOpaque(true);
			lbMs21.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs21.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs21.setBorder(null);
			lbMs21.setBackground(UIManager.getColor("Button.background"));
			lbMs21.setForeground(Color.BLACK);
			lbMs21.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs21.setBounds(198, 393, 90, 32);
			panelGerencMesas.add(lbMs21);

			lbMs22 = new JLabel("R$ 0,00");
			lbMs22.setInheritsPopupMenu(false);
			lbMs22.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs22.setOpaque(true);
			lbMs22.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs22.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs22.setBorder(null);
			lbMs22.setBackground(UIManager.getColor("Button.background"));
			lbMs22.setForeground(Color.BLACK);
			lbMs22.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs22.setBounds(298, 393, 90, 32);
			panelGerencMesas.add(lbMs22);

			lbMs23 = new JLabel("R$ 0,00");
			lbMs23.setInheritsPopupMenu(false);
			lbMs23.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs23.setOpaque(true);
			lbMs23.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs23.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs23.setBorder(null);
			lbMs23.setBackground(UIManager.getColor("Button.background"));
			lbMs23.setForeground(Color.BLACK);
			lbMs23.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs23.setBounds(398, 393, 90, 32);
			panelGerencMesas.add(lbMs23);

			lbMs24 = new JLabel("R$ 0,00");
			lbMs24.setInheritsPopupMenu(false);
			lbMs24.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs24.setOpaque(true);
			lbMs24.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs24.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs24.setBorder(null);
			lbMs24.setBackground(UIManager.getColor("Button.background"));
			lbMs24.setForeground(Color.BLACK);
			lbMs24.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs24.setBounds(498, 393, 90, 32);
			panelGerencMesas.add(lbMs24);

			lbMs25 = new JLabel("R$ 0,00");
			lbMs25.setInheritsPopupMenu(false);
			lbMs25.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs25.setOpaque(true);
			lbMs25.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs25.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs25.setBorder(null);
			lbMs25.setBackground(UIManager.getColor("Button.background"));
			lbMs25.setForeground(Color.BLACK);
			lbMs25.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs25.setBounds(598, 393, 90, 32);
			panelGerencMesas.add(lbMs25);

			lbMs31 = new JLabel("R$ 0,00");
			lbMs31.setInheritsPopupMenu(false);
			lbMs31.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs31.setOpaque(true);
			lbMs31.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs31.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs31.setBorder(null);
			lbMs31.setBackground(UIManager.getColor("Button.background"));
			lbMs31.setForeground(Color.BLACK);
			lbMs31.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs31.setBounds(198, 521, 90, 32);
			panelGerencMesas.add(lbMs31);

			lbMs32 = new JLabel("R$ 0,00");
			lbMs32.setInheritsPopupMenu(false);
			lbMs32.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs32.setOpaque(true);
			lbMs32.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs32.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs32.setBorder(null);
			lbMs32.setBackground(UIManager.getColor("Button.background"));
			lbMs32.setForeground(Color.BLACK);
			lbMs32.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs32.setBounds(298, 521, 90, 32);
			panelGerencMesas.add(lbMs32);

			lbMs33 = new JLabel("R$ 0,00");
			lbMs33.setInheritsPopupMenu(false);
			lbMs33.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs33.setOpaque(true);
			lbMs33.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs33.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs33.setBorder(null);
			lbMs33.setBackground(UIManager.getColor("Button.background"));
			lbMs33.setForeground(Color.BLACK);
			lbMs33.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs33.setBounds(398, 521, 90, 32);
			panelGerencMesas.add(lbMs33);

			lbMs34 = new JLabel("R$ 0,00");
			lbMs34.setInheritsPopupMenu(false);
			lbMs34.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs34.setOpaque(true);
			lbMs34.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs34.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs34.setBorder(null);
			lbMs34.setBackground(UIManager.getColor("Button.background"));
			lbMs34.setForeground(Color.BLACK);
			lbMs34.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs34.setBounds(498, 521, 90, 32);
			panelGerencMesas.add(lbMs34);

			lbMs35 = new JLabel("R$ 0,00");
			lbMs35.setInheritsPopupMenu(false);
			lbMs35.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs35.setOpaque(true);
			lbMs35.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs35.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs35.setBorder(null);
			lbMs35.setBackground(UIManager.getColor("Button.background"));
			lbMs35.setForeground(Color.BLACK);
			lbMs35.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs35.setBounds(598, 521, 90, 32);
			panelGerencMesas.add(lbMs35);

			lbMs36 = new JLabel("R$ 0,00");
			lbMs36.setInheritsPopupMenu(false);
			lbMs36.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs36.setOpaque(true);
			lbMs36.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs36.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs36.setBorder(null);
			lbMs36.setBackground(UIManager.getColor("Button.background"));
			lbMs36.setForeground(Color.BLACK);
			lbMs36.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs36.setBounds(698, 521, 90, 32);
			panelGerencMesas.add(lbMs36);

			lbMs37 = new JLabel("R$ 0,00");
			lbMs37.setInheritsPopupMenu(false);
			lbMs37.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs37.setOpaque(true);
			lbMs37.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs37.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs37.setBorder(null);
			lbMs37.setBackground(UIManager.getColor("Button.background"));
			lbMs37.setForeground(Color.BLACK);
			lbMs37.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs37.setBounds(798, 521, 90, 32);
			panelGerencMesas.add(lbMs37);

			lbMs38 = new JLabel("R$ 0,00");
			lbMs38.setInheritsPopupMenu(false);
			lbMs38.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs38.setOpaque(true);
			lbMs38.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs38.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs38.setBorder(null);
			lbMs38.setBackground(UIManager.getColor("Button.background"));
			lbMs38.setForeground(Color.BLACK);
			lbMs38.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs38.setBounds(898, 521, 90, 32);
			panelGerencMesas.add(lbMs38);

			lbMs39 = new JLabel("R$ 0,00");
			lbMs39.setInheritsPopupMenu(false);
			lbMs39.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs39.setOpaque(true);
			lbMs39.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs39.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs39.setBorder(null);
			lbMs39.setBackground(UIManager.getColor("Button.background"));
			lbMs39.setForeground(Color.BLACK);
			lbMs39.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs39.setBounds(998, 521, 90, 32);
			panelGerencMesas.add(lbMs39);

			lbMs40 = new JLabel("R$ 0,00");
			lbMs40.setInheritsPopupMenu(false);
			lbMs40.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			lbMs40.setOpaque(true);
			lbMs40.setHorizontalTextPosition(SwingConstants.CENTER);
			lbMs40.setHorizontalAlignment(SwingConstants.CENTER);
			lbMs40.setBorder(null);
			lbMs40.setBackground(UIManager.getColor("Button.background"));
			lbMs40.setForeground(Color.BLACK);
			lbMs40.setFont(new Font("Kalinga", Font.PLAIN, 15));
			lbMs40.setBounds(1098, 521, 90, 32);
			panelGerencMesas.add(lbMs40);

			JLabel lblLivre = new JLabel("Livre");
			lblLivre.setHorizontalAlignment(SwingConstants.CENTER);
			lblLivre.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/abrir_40px.png")));
			lblLivre.setForeground(Color.BLACK);
			lblLivre.setFont(new Font("Khmer UI", Font.BOLD, 15));
			lblLivre.setBounds(482, 565, 120, 40);
			panelGerencMesas.add(lblLivre);

			JLabel lblReservada = new JLabel("Reservada");
			lblReservada.setHorizontalAlignment(SwingConstants.CENTER);
			lblReservada.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/reservar_40px.png")));
			lblReservada.setForeground(Color.BLACK);
			lblReservada.setFont(new Font("Khmer UI", Font.BOLD, 15));
			lblReservada.setBounds(612, 565, 120, 40);
			panelGerencMesas.add(lblReservada);

			JLabel lblOcupada = new JLabel("Ocupada");
			lblOcupada.setHorizontalAlignment(SwingConstants.CENTER);
			lblOcupada.setIcon(new ImageIcon(Vendas.class
			            .getResource("/imagens_principais/fechar_40px.png")));
			lblOcupada.setForeground(Color.BLACK);
			lblOcupada.setFont(new Font("Khmer UI", Font.BOLD, 15));
			lblOcupada.setBounds(742, 565, 120, 40);
			panelGerencMesas.add(lblOcupada);

			JLabel label = new JLabel("");
			label.setOpaque(true);
			label.setForeground(Color.BLACK);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			label.setHorizontalTextPosition(SwingConstants.CENTER);
			label.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 0, 1355, 668);
			panelGerencMesas.add(label);

			/*
			 * 
			 * Panel Cadastrar Cliente
			 */

			panelCadastrarCliente = new JPanel();
			panelCadastrarCliente.setToolTipText("");
			panelCadastrarCliente.setBackground(SystemColor.inactiveCaptionBorder);

			comboUf3 = new JComboBox<String>();
			comboUf3.setForeground(Color.BLACK);
			comboUf3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboUf3.setBounds(204, 582, 81, 32);
			comboUf3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboUf3.setEditable(false);

			String sql1 = "select * from tb_estados";
			ResultSet rs1 = x.Consultar(sql1);
			try {
				if (Inicio.rd == 0) {
					comboUf3.addItem("");
					while (rs1.next()) {
						comboUf3.addItem(rs1.getString("uf"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			comboUf3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					estado = item.toString();
					try {
						comboCidade3.removeAllItems();
						String sql = "select * from tb_cidades where uf = '" + estado
						            + "'";
						ResultSet rs1 = x.Consultar(sql);
						comboCidade3.addItem("");
						while (rs1.next()) {
							comboCidade3.addItem(rs1.getString("nome"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			// Tabela
			scrollPane1 = new JScrollPane();
			scrollPane1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			scrollPane1.setAutoscrolls(true);
			scrollPane1.setFocusable(false);
			scrollPane1.setBounds(879, 227, 448, 141);
			panelCadastrarCliente.add(scrollPane1);
			scrollPane1.setVisible(false);

			final String[] colunas1 = { "NOME", "CPF" };
			final Object[][] dados1 = { { null, null }, };

			conv = new JTable(dados1, colunas1);
			conv.setForeground(Color.BLACK);
			conv.setSelectionBackground(SystemColor.scrollbar);
			conv.setShowHorizontalLines(true);
			conv.setShowVerticalLines(true);
			conv.setRowMargin(1);
			conv.setCellSelectionEnabled(true);
			conv.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			conv.setModel(new DefaultTableModel(new Object[][] { { null, null }, },
			            new String[] { "NOME", "CPF" }));
			conv.getColumnModel().getColumn(0).setPreferredWidth(250);
			conv.getColumnModel().getColumn(1).setPreferredWidth(82);
			conv.setRowHeight(24);
			conv.setAutoCreateRowSorter(true);
			conv.setFont(new Font("Kalinga", Font.PLAIN, 14));
			conv.setColumnSelectionAllowed(true);
			final DefaultTableModel modelo1 = (DefaultTableModel) conv.getModel();
			scrollPane1.setViewportView(conv);

			codigoCliente3 = new JTextField();
			codigoCliente3.setForeground(Color.BLACK);
			codigoCliente3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					codigoCliente3.setText(codigoCliente3.getText().replaceAll("[^0-9]",
					            ""));
					// codigoCliente3.setText(codigoCliente3.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			codigoCliente3.setSelectionColor(SystemColor.textHighlight);
			codigoCliente3.setDisabledTextColor(Color.BLACK);
			codigoCliente3.setEnabled(false);
			codigoCliente3.setHorizontalAlignment(SwingConstants.CENTER);
			codigoCliente3.setBounds(34, 163, 173, 32);
			codigoCliente3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codigoCliente3.setColumns(10);
			codigoCliente3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			codigoCliente3.setEditable(false);
			codigoCliente3.requestFocus();
			panelCadastrarCliente.add(codigoCliente3);

			String sql21 = "select * from contadores";
			ResultSet rs31 = x.Consultar(sql21);
			try {
				if (Inicio.rd == 0) {
					while (rs31.next()) {
						codigoCliente3.setText(rs31.getString("codigoCliente"));
						aux1 = codigoCliente3.getText();
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			ArrayList<String> valores = new ArrayList<String>();
			String sql211 = "SELECT * FROM `clientes`";
			ResultSet rs311 = x.Consultar(sql211);

			try {
				while (rs311.next()) {
					valores.add(rs311.getString("nome"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			nome3 = new JTextField();
			nome3.setForeground(Color.BLACK);
			nome3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nome3.setText(nome3.getText().replaceAll("[^0-9]",
					// ""));
					nome3.setText(nome3.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nome3.setSelectionColor(SystemColor.textHighlight);
			nome3.setHorizontalAlignment(SwingConstants.CENTER);
			nome3.setBounds(217, 163, 380, 32);
			nome3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nome3.setColumns(10);
			nome3.requestFocus();
			panelCadastrarCliente.add(nome3);

			nascimento3 = new JFormattedTextField("");
			nascimento3.setForeground(Color.BLACK);
			nascimento3.setSelectionColor(SystemColor.textHighlight);
			try {
				nascimento3.setFormatterFactory(new DefaultFormatterFactory(
				            new MaskFormatter("##/##/####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			nascimento3.setHorizontalAlignment(SwingConstants.CENTER);
			nascimento3.setBounds(607, 163, 85, 32);
			nascimento3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nascimento3.setColumns(10);
			panelCadastrarCliente.add(nascimento3);

			nacionalidade3 = new JTextField();
			nacionalidade3.setForeground(Color.BLACK);
			nacionalidade3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nacionalidade3.setText(nacionalidade3.getText().replaceAll("[^0-9]",
					// ""));
					nacionalidade3.setText(nacionalidade3.getText().replaceAll(
					            "[^A-Z | ^a-z]", ""));
				}
			});
			nacionalidade3.setSelectionColor(SystemColor.textHighlight);
			nacionalidade3.setHorizontalAlignment(SwingConstants.CENTER);
			nacionalidade3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nacionalidade3.setColumns(10);
			nacionalidade3.setBounds(34, 226, 173, 32);
			panelCadastrarCliente.add(nacionalidade3);

			email3 = new JTextField();
			email3.setForeground(Color.BLACK);
			email3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// email3.setText(email3.getText().replaceAll("[^0-9]",
					// ""));
					// email3.setText(email3.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			email3.setSelectionColor(SystemColor.textHighlight);
			email3.setHorizontalAlignment(SwingConstants.CENTER);
			email3.setBounds(34, 291, 238, 32);
			email3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			email3.setColumns(10);
			panelCadastrarCliente.add(email3);

			rg3 = new JFormattedTextField("");
			rg3.setForeground(Color.BLACK);
			rg3.setSelectionColor(SystemColor.textHighlight);
			try {
				rg3.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
				            "##.###.###-#")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			rg3.setHorizontalAlignment(SwingConstants.CENTER);
			rg3.setBounds(217, 226, 173, 32);
			rg3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			rg3.setColumns(10);
			panelCadastrarCliente.add(rg3);

			cpf3 = new JFormattedTextField("");
			cpf3.setForeground(Color.BLACK);
			cpf3.setSelectionColor(SystemColor.textHighlight);
			try {
				cpf3.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
				            "###.###.###-##")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			cpf3.setHorizontalAlignment(SwingConstants.CENTER);
			cpf3.setBounds(400, 226, 160, 32);
			cpf3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cpf3.setColumns(10);
			panelCadastrarCliente.add(cpf3);

			comboEstadoCivil = new JComboBox<String>();
			comboEstadoCivil.setForeground(Color.BLACK);
			comboEstadoCivil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboEstadoCivil.setBounds(289, 291, 160, 32);
			comboEstadoCivil.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboEstadoCivil.setEditable(false);
			panelCadastrarCliente.add(comboEstadoCivil);

			estadoCivilConsulta = new JTextField();
			estadoCivilConsulta.setForeground(Color.BLACK);
			estadoCivilConsulta.setDisabledTextColor(Color.BLACK);
			estadoCivilConsulta.setEnabled(false);
			estadoCivilConsulta.setEditable(false);
			estadoCivilConsulta.setSelectionColor(SystemColor.textHighlight);
			estadoCivilConsulta.setHorizontalAlignment(SwingConstants.CENTER);
			estadoCivilConsulta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			estadoCivilConsulta.setColumns(10);
			estadoCivilConsulta.setBounds(289, 291, 160, 32);
			panelCadastrarCliente.add(estadoCivilConsulta);

			nomePai3 = new JTextField();
			nomePai3.setForeground(Color.BLACK);
			nomePai3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nomePai3.setText(nomePai3.getText().replaceAll("[^0-9]",
					// ""));
					nomePai3.setText(nomePai3.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nomePai3.setSelectionColor(SystemColor.textHighlight);
			nomePai3.setHorizontalAlignment(SwingConstants.CENTER);
			nomePai3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nomePai3.setColumns(10);
			nomePai3.setBounds(34, 356, 300, 32);
			panelCadastrarCliente.add(nomePai3);

			nomeMae3 = new JTextField();
			nomeMae3.setForeground(Color.BLACK);
			nomeMae3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nomeMae3.setText(nomeMae3.getText().replaceAll("[^0-9]",
					// ""));
					nomeMae3.setText(nomeMae3.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nomeMae3.setSelectionColor(SystemColor.textHighlight);
			nomeMae3.setHorizontalAlignment(SwingConstants.CENTER);
			nomeMae3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nomeMae3.setColumns(10);
			nomeMae3.setBounds(344, 356, 290, 32);
			panelCadastrarCliente.add(nomeMae3);

			telefone3 = new JFormattedTextField("");
			telefone3.setForeground(Color.BLACK);
			telefone3.setSelectionColor(SystemColor.textHighlight);
			try {
				telefone3.setFormatterFactory(new DefaultFormatterFactory(
				            new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			telefone3.setHorizontalAlignment(SwingConstants.CENTER);
			telefone3.setBounds(34, 416, 129, 32);
			telefone3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone3.setColumns(10);
			panelCadastrarCliente.add(telefone3);

			telefone23 = new JFormattedTextField("");
			telefone23.setForeground(Color.BLACK);
			telefone23.setSelectionColor(SystemColor.textHighlight);
			try {
				telefone23.setFormatterFactory(new DefaultFormatterFactory(
				            new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			telefone23.setHorizontalAlignment(SwingConstants.CENTER);
			telefone23.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone23.setColumns(10);
			telefone23.setBounds(173, 416, 129, 32);
			panelCadastrarCliente.add(telefone23);

			celular3 = new JFormattedTextField("");
			celular3.setForeground(Color.BLACK);
			celular3.setSelectionColor(SystemColor.textHighlight);
			celular3.setHorizontalAlignment(SwingConstants.CENTER);
			try {
				celular3.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
				            "(##)#####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			celular3.setBounds(312, 416, 129, 32);
			celular3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular3.setColumns(10);
			panelCadastrarCliente.add(celular3);

			celular23 = new JFormattedTextField("");
			celular23.setForeground(Color.BLACK);
			celular23.setSelectionColor(SystemColor.textHighlight);
			celular23.setHorizontalAlignment(SwingConstants.CENTER);
			try {
				celular23.setFormatterFactory(new DefaultFormatterFactory(
				            new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			celular23.setFont(new Font("Kalinga", Font.PLAIN, 14));
			celular23.setColumns(10);
			celular23.setBounds(451, 416, 129, 32);
			panelCadastrarCliente.add(celular23);

			logradouro3 = new JTextField();
			logradouro3.setForeground(Color.BLACK);
			logradouro3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// logradouro3.setText(logradouro3.getText().replaceAll("[^0-9]",
					// ""));
					logradouro3.setText(logradouro3.getText().replaceAll("[^A-Z | ^a-z]",
					            ""));
				}
			});
			logradouro3.setSelectionColor(SystemColor.textHighlight);
			logradouro3.setHorizontalAlignment(SwingConstants.CENTER);
			logradouro3.setBounds(33, 516, 379, 32);
			logradouro3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			logradouro3.setColumns(10);
			panelCadastrarCliente.add(logradouro3);

			bairro3 = new JTextField();
			bairro3.setForeground(Color.BLACK);
			bairro3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// bairro3.setText(bairro3.getText().replaceAll("[^0-9]",
					// ""));
					bairro3.setText(bairro3.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			bairro3.setSelectionColor(SystemColor.textHighlight);
			bairro3.setHorizontalAlignment(SwingConstants.CENTER);
			bairro3.setBounds(422, 516, 165, 32);
			bairro3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			bairro3.setColumns(10);
			panelCadastrarCliente.add(bairro3);

			numero3 = new JTextField();
			numero3.setForeground(Color.BLACK);
			numero3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numero3.setText(numero3.getText().replaceAll("[^0-9]", ""));
					// numero3.setText(numero3.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numero3.setSelectionColor(SystemColor.textHighlight);
			numero3.setHorizontalAlignment(SwingConstants.CENTER);
			numero3.setBounds(597, 516, 64, 32);
			numero3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numero3.setColumns(10);
			panelCadastrarCliente.add(numero3);

			cep3 = new JFormattedTextField("");
			cep3.setForeground(Color.BLACK);
			cep3.setSelectionColor(SystemColor.textHighlight);
			try {
				cep3.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter(
				            "#####-###")));
			}
			catch (ParseException e2) {
				e2.printStackTrace();
			}
			cep3.setHorizontalAlignment(SwingConstants.CENTER);
			cep3.setBounds(549, 582, 170, 32);
			cep3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cep3.setColumns(10);
			panelCadastrarCliente.add(cep3);

			complemento3 = new JTextField();
			complemento3.setForeground(Color.BLACK);
			complemento3.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// complemento3.setText(complemento3.getText().replaceAll("[^0-9]",
					// ""));
					complemento3.setText(complemento3.getText().replaceAll(
					            "[^A-Z | ^a-z]", ""));
				}
			});
			complemento3.setSelectionColor(SystemColor.textHighlight);
			complemento3.setHorizontalAlignment(SwingConstants.CENTER);
			complemento3.setBounds(32, 582, 160, 32);
			complemento3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			complemento3.setColumns(10);
			panelCadastrarCliente.add(complemento3);
			panelCadastrarCliente.add(comboUf3);

			ufConsulta = new JTextField();
			ufConsulta.setForeground(Color.BLACK);
			ufConsulta.setEnabled(false);
			ufConsulta.setEditable(false);
			ufConsulta.setDisabledTextColor(Color.BLACK);
			ufConsulta.setVisible(false);
			ufConsulta.setSelectionColor(SystemColor.textHighlight);
			ufConsulta.setHorizontalAlignment(SwingConstants.CENTER);
			ufConsulta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ufConsulta.setColumns(10);
			ufConsulta.setBounds(204, 582, 79, 32);
			panelCadastrarCliente.add(ufConsulta);

			comboCidade3 = new JComboBox<String>();
			comboCidade3.setForeground(Color.BLACK);
			comboCidade3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboCidade3.setBounds(309, 582, 221, 32);
			comboCidade3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboCidade3.setEditable(false);
			panelCadastrarCliente.add(comboCidade3);

			if (Inicio.rd == 0) {
				comboEstadoCivil.addItem("");
				comboEstadoCivil.addItem("Solteiro");
				comboEstadoCivil.addItem("Casado");
				comboEstadoCivil.addItem("Divorciado");
				comboEstadoCivil.addItem("Vi�vo");
			}

			panelCadastrarCliente.setLayout(null);

			autorizados3 = new JTextField();
			autorizados3.setForeground(Color.BLACK);
			autorizados3.setSelectionColor(SystemColor.textHighlight);
			autorizados3.setDisabledTextColor(Color.BLACK);
			autorizados3.setEnabled(false);
			autorizados3.setHorizontalAlignment(SwingConstants.CENTER);
			autorizados3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			autorizados3.setEditable(false);
			autorizados3.setBounds(979, 398, 49, 32);
			autorizados3.setVisible(false);

			cidadeConsulta = new JTextField();
			cidadeConsulta.setForeground(Color.BLACK);
			cidadeConsulta.setEnabled(false);
			cidadeConsulta.setEditable(false);
			cidadeConsulta.setDisabledTextColor(Color.BLACK);
			cidadeConsulta.setVisible(false);
			cidadeConsulta.setSelectionColor(SystemColor.textHighlight);
			cidadeConsulta.setHorizontalAlignment(SwingConstants.CENTER);
			cidadeConsulta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cidadeConsulta.setColumns(10);
			cidadeConsulta.setBounds(309, 582, 220, 32);
			panelCadastrarCliente.add(cidadeConsulta);
			autorizados3.setText("0");
			panelCadastrarCliente.add(autorizados3);

			/*
			 * 
			 * Panel Delivery
			 */

			panelDelivery = new JPanel();
			panelDelivery.setBackground(SystemColor.inactiveCaptionBorder);
			panelDelivery.setLayout(null);

			internalFrame_3 = new JInternalFrame("Remover Item");
			internalFrame_3.setClosable(true);
			internalFrame_3.setFrameIcon(new ImageIcon(Vendas.class
			            .getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
			internalFrame_3.setBounds(490, 243, 375, 181);
			panelDelivery.add(internalFrame_3);
			internalFrame_3.getContentPane().setLayout(null);

			comboBoxRemoveDelivery = new JComboBox<String>();
			comboBoxRemoveDelivery.setForeground(Color.BLACK);
			comboBoxRemoveDelivery.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboBoxRemoveDelivery.setBounds(26, 12, 317, 32);
			internalFrame_3.getContentPane().add(comboBoxRemoveDelivery);

			spinnerRemove = new JSpinner();
			spinnerRemove.setModel(new SpinnerNumberModel(1, 1, 50000, 1));
			spinnerRemove.setFont(new Font("Kalinga", Font.PLAIN, 14));
			spinnerRemove.setBounds(191, 57, 70, 32);
			internalFrame_3.getContentPane().add(spinnerRemove);

			button_4 = new JButton("Remover");
			button_4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					VendasController.RemoverItemDelivery();
				}
			});
			button_4.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/Gnome-edit-clear.png")));
			button_4.setForeground(Color.BLACK);
			button_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_4.setBounds(26, 105, 140, 35);
			internalFrame_3.getContentPane().add(button_4);

			button_5 = new JButton("Cancelar");
			button_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					internalFrame_3.setVisible(false);
				}
			});
			button_5.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			button_5.setForeground(Color.BLACK);
			button_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_5.setBounds(203, 105, 140, 35);
			internalFrame_3.getContentPane().add(button_5);

			JLabel label_17 = new JLabel("Quantidade");
			label_17.setHorizontalAlignment(SwingConstants.CENTER);
			label_17.setForeground(Color.BLACK);
			label_17.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_17.setBounds(82, 57, 99, 32);
			internalFrame_3.getContentPane().add(label_17);

			telefone4 = new JFormattedTextField();
			telefone4.setForeground(Color.BLACK);
			telefone4.setSelectionColor(SystemColor.textHighlight);
			telefone4.setHorizontalAlignment(SwingConstants.CENTER);
			telefone4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			telefone4.setColumns(10);
			telefone4.setBounds(139, 68, 124, 32);
			panelDelivery.add(telefone4);
			try {
				telefone4.setFormatterFactory(new DefaultFormatterFactory(
				            new MaskFormatter("(##)####-####")));
			}
			catch (ParseException e1) {
				e1.printStackTrace();
			}

			numeroVendaDelivery = new JTextField();
			numeroVendaDelivery.setForeground(Color.BLACK);
			numeroVendaDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numeroVendaDelivery.setText(numeroVendaDelivery.getText().replaceAll(
					            "[^0-9]", ""));
					// numeroVendaDelivery.setText(numeroVendaDelivery.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numeroVendaDelivery.setSelectionColor(SystemColor.textHighlight);
			numeroVendaDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			numeroVendaDelivery.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numeroVendaDelivery.setEnabled(false);
			numeroVendaDelivery.setEditable(false);
			numeroVendaDelivery.setDisabledTextColor(Color.BLACK);
			numeroVendaDelivery.setColumns(10);
			numeroVendaDelivery.setBounds(30, 68, 97, 32);
			panelDelivery.add(numeroVendaDelivery);

			cpf4 = new JTextField();
			cpf4.setForeground(Color.BLACK);
			cpf4.setSelectionColor(SystemColor.textHighlight);
			cpf4.setHorizontalAlignment(SwingConstants.CENTER);
			cpf4.setDisabledTextColor(Color.BLACK);
			cpf4.setEnabled(false);
			cpf4.setEditable(false);
			cpf4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cpf4.setColumns(10);
			cpf4.setBounds(273, 68, 199, 32);
			panelDelivery.add(cpf4);

			nome4 = new JTextField();
			nome4.setForeground(Color.BLACK);
			nome4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// nome4.setText(nome4.getText().replaceAll("[^0-9]",
					// ""));
					nome4.setText(nome4.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			nome4.setSelectionColor(SystemColor.textHighlight);
			nome4.setDisabledTextColor(Color.BLACK);
			nome4.setHorizontalAlignment(SwingConstants.CENTER);
			nome4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			nome4.setColumns(10);
			nome4.setBounds(139, 128, 333, 32);
			panelDelivery.add(nome4);

			logradouro4 = new JTextField();
			logradouro4.setForeground(Color.BLACK);
			logradouro4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// logradouro4.setText(logradouro4.getText().replaceAll("[^0-9]",
					// ""));
					logradouro4.setText(logradouro4.getText().replaceAll("[^A-Z | ^a-z]",
					            ""));
				}
			});
			logradouro4.setSelectionColor(SystemColor.textHighlight);
			logradouro4.setDisabledTextColor(Color.BLACK);
			logradouro4.setHorizontalAlignment(SwingConstants.CENTER);
			logradouro4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			logradouro4.setEnabled(false);
			logradouro4.setEditable(false);
			logradouro4.setColumns(10);
			logradouro4.setBounds(30, 190, 254, 32);
			panelDelivery.add(logradouro4);

			bairro4 = new JTextField();
			bairro4.setForeground(Color.BLACK);
			bairro4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// bairro4.setText(bairro4.getText().replaceAll("[^0-9]",
					// ""));
					bairro4.setText(bairro4.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			bairro4.setSelectionColor(SystemColor.textHighlight);
			bairro4.setHorizontalAlignment(SwingConstants.CENTER);
			bairro4.setEnabled(false);
			bairro4.setEditable(false);
			bairro4.setDisabledTextColor(Color.BLACK);
			bairro4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			bairro4.setColumns(10);
			bairro4.setBounds(30, 255, 144, 32);
			panelDelivery.add(bairro4);

			numero4 = new JTextField();
			numero4.setForeground(Color.BLACK);
			numero4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					numero4.setText(numero4.getText().replaceAll("[^0-9]", ""));
					// numero4.setText(numero4.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			numero4.setSelectionColor(SystemColor.textHighlight);
			numero4.setDisabledTextColor(Color.BLACK);
			numero4.setEditable(false);
			numero4.setEnabled(false);
			numero4.setHorizontalAlignment(SwingConstants.CENTER);
			numero4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			numero4.setColumns(10);
			numero4.setBounds(184, 255, 64, 32);
			panelDelivery.add(numero4);

			cidade4 = new JTextField();
			cidade4.setForeground(Color.BLACK);
			cidade4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// cidade4.setText(cidade4.getText().replaceAll("[^0-9]",
					// ""));
					cidade4.setText(cidade4.getText().replaceAll("[^A-Z | ^a-z]", ""));
				}
			});
			cidade4.setSelectionColor(SystemColor.textHighlight);
			cidade4.setHorizontalAlignment(SwingConstants.CENTER);
			cidade4.setEnabled(false);
			cidade4.setEditable(false);
			cidade4.setDisabledTextColor(Color.BLACK);
			cidade4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cidade4.setColumns(10);
			cidade4.setBounds(258, 255, 214, 32);
			panelDelivery.add(cidade4);

			complemento4 = new JTextField();
			complemento4.setForeground(Color.BLACK);
			complemento4.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					// complemento4.setText(complemento4.getText().replaceAll("[^0-9]",
					// ""));
					complemento4.setText(complemento4.getText().replaceAll(
					            "[^A-Z | ^a-z]", ""));
				}
			});
			complemento4.setSelectionColor(SystemColor.textHighlight);
			complemento4.setHorizontalAlignment(SwingConstants.CENTER);
			complemento4.setDisabledTextColor(Color.BLACK);
			complemento4.setEditable(false);
			complemento4.setEnabled(false);
			complemento4.setFont(new Font("Kalinga", Font.PLAIN, 14));
			complemento4.setColumns(10);
			complemento4.setBounds(294, 190, 178, 32);
			panelDelivery.add(complemento4);

			comboProduto3 = new JComboBox<String>();
			comboProduto3.setForeground(Color.BLACK);
			comboProduto3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			comboProduto3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comboProduto3.setBounds(30, 422, 341, 32);
			panelDelivery.add(comboProduto3);
			
			AtualizarItensVendaveisDelivery();
			
			comboProduto3.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					try {
						String sql = "select * from produtos where nome = '"
						            + item.toString() + "'";
						ResultSet rs1 = x.Consultar(sql);
						while (rs1.next()) {
							precoUnitario2 = Double.parseDouble(rs1.getString(
							            "precoVenda").replace(",", "."));
							codProd2 = (rs1.getString("codigoProduto"));
						}
					}
					catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			});

			spinnerQuantDelivery = new JSpinner();
			spinnerQuantDelivery.setForeground(Color.BLACK);
			spinnerQuantDelivery.setModel(new SpinnerNumberModel(1, 1, 5000, 1));
			spinnerQuantDelivery.setFont(new Font("Kalinga", Font.PLAIN, 14));
			spinnerQuantDelivery.setBounds(419, 422, 84, 32);
			panelDelivery.add(spinnerQuantDelivery);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 465, 473, 101);
			panelDelivery.add(scrollPane);

			tablePedido = new JTable();
			tablePedido.setForeground(Color.BLACK);
			tablePedido.setRowHeight(22);
			tablePedido.setFont(new Font("Kalinga", Font.PLAIN, 16));
			tablePedido.setModel(new DefaultTableModel(new Object[][] { { null, null, null,
			            null, null, null }, }, new String[] { "Item", "C\u00F3d",
			            "Descri\u00E7\u00E3o", "Quant", "Pre\u00E7o Unit.", "Valor" }) {
				boolean[] columnEditables = new boolean[] { true, true, true, true, true,
				                                      false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tablePedido.getColumnModel().getColumn(0).setPreferredWidth(44);
			tablePedido.getColumnModel().getColumn(1).setPreferredWidth(46);
			tablePedido.getColumnModel().getColumn(2).setPreferredWidth(250);
			tablePedido.getColumnModel().getColumn(0).setCellRenderer(central);
			tablePedido.getColumnModel().getColumn(1).setCellRenderer(central);
			tablePedido.getColumnModel().getColumn(2).setCellRenderer(central);
			tablePedido.getColumnModel().getColumn(3).setCellRenderer(central);
			tablePedido.getColumnModel().getColumn(4).setCellRenderer(central);
			tablePedido.getColumnModel().getColumn(5).setCellRenderer(central);
			scrollPane.setViewportView(tablePedido);
			modeloDelivery = (DefaultTableModel) tablePedido.getModel();

			codDelivery = new JTextField();
			codDelivery.setForeground(Color.BLACK);
			codDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					codDelivery.setText(codDelivery.getText().replaceAll("[^0-9]", ""));
					// codDelivery.setText(codDelivery.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(707, 35, 619, 595);
			panelDelivery.add(scrollPane_1);

			table = new JTable();
			table.setRowHeight(22);
			table.setFont(new Font("Tahoma", Font.PLAIN, 17));
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
				},
				new String[] {
					"Data da Compra", "Descri\u00E7\u00E3o", "Quantidade", "Pre\u00E7o Unit.", "Total"
				}
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(99);
			table.getColumnModel().getColumn(1).setPreferredWidth(276);
			table.getColumnModel().getColumn(2).setPreferredWidth(66);
			table.getColumnModel().getColumn(4).setPreferredWidth(63);
			table.getColumnModel().getColumn(0).setCellRenderer(central);
			table.getColumnModel().getColumn(1).setCellRenderer(central);
			table.getColumnModel().getColumn(2).setCellRenderer(central);
			table.getColumnModel().getColumn(3).setCellRenderer(central);
			table.getColumnModel().getColumn(4).setCellRenderer(central);
			
			scrollPane_1.setViewportView(table);		
			modeloHistDelivery = (DefaultTableModel) table.getModel();
			modeloHistDelivery.removeRow(0);
			
			codDelivery.setSelectionColor(SystemColor.textHighlight);
			codDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			codDelivery.setFont(new Font("Kalinga", Font.PLAIN, 14));
			codDelivery.setEnabled(false);
			codDelivery.setEditable(false);
			codDelivery.setDisabledTextColor(Color.BLACK);
			codDelivery.setColumns(10);
			codDelivery.setBounds(30, 128, 99, 32);
			panelDelivery.add(codDelivery);

			valorFinalDelivery = new JTextField();
			valorFinalDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorFinalDelivery.setText(valorFinalDelivery.getText().replaceAll("[^0-9]", ""));
					// valorFinalDelivery.setText(valorFinalDelivery.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			valorFinalDelivery.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorFinalDelivery.getText().equalsIgnoreCase("0,00"))
						valorFinalDelivery.setText("");
					valorFinalDelivery.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorFinalDelivery.getText().equalsIgnoreCase(""))
						valorFinalDelivery.setText("0,00");
					valorFinalDelivery.requestFocus(false);
				}

			});
			valorFinalDelivery.setText("0,00");
			valorFinalDelivery.setSelectionColor(SystemColor.textHighlight);
			valorFinalDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			valorFinalDelivery.setForeground(Color.BLACK);
			valorFinalDelivery.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorFinalDelivery.setEnabled(false);
			valorFinalDelivery.setEditable(false);
			valorFinalDelivery.setDisabledTextColor(Color.BLACK);
			valorFinalDelivery.setColumns(10);
			valorFinalDelivery.setBounds(40, 598, 141, 32);
			panelDelivery.add(valorFinalDelivery);

			valorPagoDelivery = new JTextField();
			valorPagoDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorPagoDelivery.setText(valorPagoDelivery.getText().replaceAll("[^0-9]", ""));
					// valorPagoDelivery.setText(valorPagoDelivery.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			
			valorPagoDelivery.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorPagoDelivery.getText().equalsIgnoreCase("0,00"))
						valorPagoDelivery.setText("");
					valorPagoDelivery.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorPagoDelivery.getText().equalsIgnoreCase(""))
						valorPagoDelivery.setText("0,00");
					valorPagoDelivery.requestFocus(false);
				}

			});
			valorPagoDelivery.setText("0,00");
			valorPagoDelivery.setSelectionColor(SystemColor.textHighlight);
			valorPagoDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			valorPagoDelivery.setForeground(Color.BLACK);
			valorPagoDelivery.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorPagoDelivery.setDisabledTextColor(Color.BLACK);
			valorPagoDelivery.setColumns(10);
			valorPagoDelivery.setBounds(196, 598, 141, 32);
			panelDelivery.add(valorPagoDelivery);

			trocoDelivery = new JTextField();
			trocoDelivery.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//trocoDelivery.setText(trocoDelivery.getText().replaceAll("[^0-9]", ""));
					// trocoDelivery.setText(trocoDelivery.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});
			
			trocoDelivery.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (trocoDelivery.getText().equalsIgnoreCase("0,00"))
						trocoDelivery.setText("");
					trocoDelivery.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (trocoDelivery.getText().equalsIgnoreCase(""))
						trocoDelivery.setText("0,00");
					trocoDelivery.requestFocus(false);
				}

			});
			trocoDelivery.setText("0,00");
			trocoDelivery.setSelectionColor(SystemColor.textHighlight);
			trocoDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			trocoDelivery.setForeground(Color.BLACK);
			trocoDelivery.setFont(new Font("Kalinga", Font.BOLD, 20));
			trocoDelivery.setDisabledTextColor(Color.BLACK);
			trocoDelivery.setColumns(10);
			trocoDelivery.setBounds(349, 598, 141, 32);
			panelDelivery.add(trocoDelivery);

			btPesquisar = new JButton("Pesquisar");
			btPesquisar.setForeground(Color.BLACK);
			btPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btPesquisar.setMnemonic(KeyEvent.VK_ENTER);
			btPesquisar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VendasController.ClientDelivery();
					VendasController.HistoricoPedido();
				}
			});
			btPesquisar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606561_search-128.png")));
			btPesquisar.setToolTipText("alt + Enter");
			btPesquisar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btPesquisar.setBounds(268, 298, 150, 40);
			panelDelivery.add(btPesquisar);

			btAddItem = new JButton("Adicionar");
			btAddItem.setForeground(Color.BLACK);
			btAddItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					VendasController.AddItemDelivery();
				}
			});
			btAddItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAddItem.setToolTipText("alt + Insert");
			btAddItem.setMnemonic(KeyEvent.VK_INSERT);
			btAddItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAddItem.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			btAddItem.setBounds(524, 428, 126, 40);
			panelDelivery.add(btAddItem);

			btRemItem = new JButton("Remover");
			btRemItem.setForeground(Color.BLACK);
			btRemItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btRemItem.setToolTipText("alt + Delete");
			btRemItem.setMnemonic(KeyEvent.VK_DELETE);
			btRemItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btRemItem.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btRemItem.setBounds(524, 471, 126, 40);
			panelDelivery.add(btRemItem);
			btRemItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					comboBoxRemoveDelivery.removeAllItems();
					comboBoxRemoveDelivery.addItem("");
					for (int i = 0; i < VendasController.contLinha2; i++) {
						comboBoxRemoveDelivery.addItem((String) modeloDelivery
						            .getValueAt(i, 2));
					}
					internalFrame_3.setVisible(true);
				}
			});

			btnCalcular = new JButton("Calcular");
			btnCalcular.setForeground(Color.BLACK);
			btnCalcular.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					VendasController.CalcularTrocoDelivery();
				}
			});
			btnCalcular.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606619_notepad-128.png")));
			btnCalcular.setToolTipText("alt + Delete");
			btnCalcular.setMnemonic(KeyEvent.VK_DELETE);
			btnCalcular.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCalcular.setBounds(524, 590, 126, 40);
			panelDelivery.add(btnCalcular);

			JButton btnSalvar = new JButton("Salvar");
			btnSalvar.setForeground(Color.BLACK);
			btnSalvar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(Inicio.caixa.equals("fechado")){
						JOptionPane.showMessageDialog(null,"É necessário efetuar a abertura do caixa !","Atenção", JOptionPane.WARNING_MESSAGE);
						new Caixa();
					}
					else {
						VendasController.GerirPedido();
						VendasController.ArmazenarPedido();
						VendasController.SalvarPedido();
						AtualizarItensVendaveisDelivery();
						AtualizarItensVendaveis();
						label_16.setText("(Cliente)");
						label_16.setIcon(new ImageIcon(Vendas.class
						            .getResource("/icones1_48px/1425606663_image-128.png")));
						contEntrega++;
					}
				}
			});
			btnSalvar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606570_floppy-128.png")));
			btnSalvar.setToolTipText("alt + Delete");
			btnSalvar.setMnemonic(KeyEvent.VK_DELETE);
			btnSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnSalvar.setBounds(524, 514, 126, 40);
			panelDelivery.add(btnSalvar);
			sql2 = "select * from contadores";
			rs3 = x.Consultar(sql2);
			try {
				if (Inicio.rd == 0) {
					while (rs3.next()) {
						numeroVendaDelivery.setText(rs3.getString("numeroVenda"));
					}
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}

			label_16 = new JLabel("(Cliente)");
			label_16.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_48px/1425606663_image-128.png")));
			label_16.setOpaque(true);
			label_16.setHorizontalAlignment(SwingConstants.CENTER);
			label_16.setForeground(Color.BLACK);
			label_16.setBorder(new LineBorder(Color.LIGHT_GRAY));
			label_16.setBackground(Color.WHITE);
			label_16.setBounds(492, 68, 145, 95);
			panelDelivery.add(label_16);

			lblTelefone_1 = new JLabel("Telefone");
			lblTelefone_1.setForeground(Color.BLACK);
			lblTelefone_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblTelefone_1.setBounds(139, 35, 81, 32);
			panelDelivery.add(lblTelefone_1);

			lblNome = new JLabel("Nome");
			lblNome.setForeground(Color.BLACK);
			lblNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNome.setBounds(139, 97, 49, 32);
			panelDelivery.add(lblNome);

			lblLogradouro = new JLabel("Endereço");
			lblLogradouro.setForeground(Color.BLACK);
			lblLogradouro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblLogradouro.setBounds(30, 159, 94, 32);
			panelDelivery.add(lblLogradouro);

			JLabel lblNmero = new JLabel("Número");
			lblNmero.setForeground(Color.BLACK);
			lblNmero.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNmero.setBounds(184, 222, 64, 32);
			panelDelivery.add(lblNmero);

			JLabel lblComplemento = new JLabel("Complemento");
			lblComplemento.setForeground(Color.BLACK);
			lblComplemento.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblComplemento.setBounds(294, 158, 139, 32);
			panelDelivery.add(lblComplemento);

			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setForeground(Color.BLACK);
			lblBairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblBairro.setBounds(30, 222, 64, 32);
			panelDelivery.add(lblBairro);

			JLabel lblCidade = new JLabel("Cidade");
			lblCidade.setForeground(Color.BLACK);
			lblCidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCidade.setBounds(258, 222, 49, 32);
			panelDelivery.add(lblCidade);

			JLabel label_14 = new JLabel("CPF");
			label_14.setForeground(Color.BLACK);
			label_14.setFont(new Font("Kalinga", Font.PLAIN, 14));
			label_14.setBounds(273, 35, 41, 32);
			panelDelivery.add(label_14);

			JLabel lblProduto = new JLabel("Produto");
			lblProduto.setForeground(Color.BLACK);
			lblProduto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblProduto.setBounds(30, 392, 70, 32);
			panelDelivery.add(lblProduto);

			JLabel lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setForeground(Color.BLACK);
			lblQuantidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblQuantidade.setBounds(419, 392, 84, 32);
			panelDelivery.add(lblQuantidade);

			lblCod = new JLabel("Cod. do Cliente");
			lblCod.setForeground(Color.BLACK);
			lblCod.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCod.setBounds(30, 94, 99, 32);
			panelDelivery.add(lblCod);

			JLabel lblValorPago = new JLabel("Valor Pago");
			lblValorPago.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606602_678131-money-128.png")));
			lblValorPago.setHorizontalAlignment(SwingConstants.CENTER);
			lblValorPago.setForeground(Color.BLACK);
			lblValorPago.setFont(new Font("Kalinga", Font.BOLD, 16));
			lblValorPago.setBounds(196, 565, 141, 32);
			panelDelivery.add(lblValorPago);

			JLabel label_15 = new JLabel("Valor Final");
			label_15.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606730_678082-tag-128.png")));
			label_15.setHorizontalAlignment(SwingConstants.CENTER);
			label_15.setForeground(Color.BLACK);
			label_15.setFont(new Font("Kalinga", Font.BOLD, 16));
			label_15.setBounds(40, 565, 141, 32);
			panelDelivery.add(label_15);

			JLabel lblNVenda = new JLabel("Nº Venda");
			lblNVenda.setForeground(Color.BLACK);
			lblNVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNVenda.setBounds(30, 35, 81, 32);
			panelDelivery.add(lblNVenda);

			JLabel lblTroco = new JLabel("Troco");
			lblTroco.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606619_notepad-128.png")));
			lblTroco.setHorizontalAlignment(SwingConstants.CENTER);
			lblTroco.setForeground(Color.BLACK);
			lblTroco.setFont(new Font("Kalinga", Font.BOLD, 16));
			lblTroco.setBounds(349, 565, 141, 32);
			panelDelivery.add(lblTroco);

			label_3 = new JLabel("");
			label_3.setForeground(Color.BLACK);
			label_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "CLIENTE", TitledBorder.LEFT, TitledBorder.TOP, null,
			            new Color(64, 64, 64)));
			label_3.setBounds(10, 12, 667, 347);
			panelDelivery.add(label_3);

			label_4 = new JLabel("");
			label_4.setForeground(Color.BLACK);
			label_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "PEDIDO", TitledBorder.LEFT, TitledBorder.TOP, null,
			            new Color(64, 64, 64)));
			label_4.setBounds(10, 370, 667, 274);
			panelDelivery.add(label_4);

			JLabel label_13 = new JLabel("");
			label_13.setForeground(Color.BLACK);
			label_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_13.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "HIST\u00D3RICO DE COMPRAS", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_13.setBounds(687, 12, 658, 632);
			panelDelivery.add(label_13);

			JLabel FundoDelivery = new JLabel("");
			FundoDelivery.setOpaque(true);
			FundoDelivery.setHorizontalTextPosition(SwingConstants.CENTER);
			FundoDelivery.setForeground(Color.BLACK);
			FundoDelivery.setFont(new Font("Arial", Font.PLAIN, 12));
			FundoDelivery.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			FundoDelivery.setHorizontalAlignment(SwingConstants.CENTER);
			FundoDelivery.setBounds(0, 0, 1361, 668);
			panelDelivery.add(FundoDelivery);

			/*
			 * 
			 * Panel Historico de Vendas
			 */

			panelRelatorios = new JPanel();
			panelRelatorios.setBackground(SystemColor.inactiveCaptionBorder);

			formato2 = new SimpleDateFormat("hh:mm:ss");
			data2 = new Date();

			valorPago1 = new JTextField();
			valorPago1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			valorPago1.setBounds(1177, 408, 162, 32);
			valorPago1.setText("0,00");
			valorPago1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorPago1.setText(valorPago1.getText().replaceAll("[^0-9]", ""));
					// valorPago1.setText(valorPago1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			valorPago1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorPago1.getText().equalsIgnoreCase("0,00"))
						valorPago1.setText("");
					valorPago1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorPago1.getText().equalsIgnoreCase(""))
						valorPago1.setText("0,00");
					valorPago1.requestFocus(false);
				}

			});

			valorPago1.setSelectionColor(SystemColor.textHighlight);
			valorPago1.setForeground(Color.BLACK);
			valorPago1.setHorizontalAlignment(SwingConstants.CENTER);
			valorPago1.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorPago1.setColumns(10);
			panelPainelVendas.add(valorPago1);

			troco1 = new JTextField();
			troco1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			troco1.setBounds(1177, 486, 162, 32);
			troco1.setText("0,00");
			troco1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//troco1.setText(troco1.getText().replaceAll("[^0-9]", ""));
					// troco1.setText(troco1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			troco1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (troco1.getText().equalsIgnoreCase("0,00"))
						troco1.setText("");
					troco1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (troco1.getText().equalsIgnoreCase(""))
						troco1.setText("0,00");
					troco1.requestFocus(false);
				}

			});
			troco1.setSelectionColor(SystemColor.textHighlight);
			troco1.setForeground(Color.BLACK);
			troco1.setEditable(false);
			troco1.setHorizontalAlignment(SwingConstants.CENTER);
			troco1.setFont(new Font("Kalinga", Font.BOLD, 20));
			troco1.setColumns(10);
			panelPainelVendas.add(troco1);

			valorFinal1 = new JTextField();
			valorFinal1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			valorFinal1.setBounds(1177, 562, 162, 32);
			valorFinal1.setText("0,00");
			valorFinal1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorFinal1.setText(valorFinal1.getText().replaceAll("[^0-9]", ""));
					// valorFinal1.setText(valorFinal1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			valorFinal1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorFinal1.getText().equalsIgnoreCase("0,00"))
						valorFinal1.setText("");
					valorFinal1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorFinal1.getText().equalsIgnoreCase(""))
						valorFinal1.setText("0,00");
					valorFinal1.requestFocus(false);
				}

			});

			valorFinal1.setDisabledTextColor(Color.BLACK);
			valorFinal1.setEnabled(false);
			valorFinal1.setSelectionColor(SystemColor.textHighlight);
			valorFinal1.setForeground(Color.BLACK);
			valorFinal1.setEditable(false);
			valorFinal1.setHorizontalAlignment(SwingConstants.CENTER);
			valorFinal1.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorFinal1.setColumns(10);
			panelPainelVendas.add(valorFinal1);

			valorTotal1 = new JTextField();
			valorTotal1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			valorTotal1.setBounds(875, 409, 162, 32);
			valorTotal1.setText("0,00");
			valorTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorTotal1.setText(valorTotal1.getText().replaceAll("[^0-9]", ""));
					// valorTotal1.setText(valorTotal1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			valorTotal1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorTotal1.getText().equalsIgnoreCase("0,00"))
						valorTotal1.setText("");
					valorTotal1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorTotal1.getText().equalsIgnoreCase(""))
						valorTotal1.setText("0,00");
					valorTotal1.requestFocus(false);
				}

			});
			valorTotal1.setDisabledTextColor(Color.BLACK);
			valorTotal1.setEnabled(false);
			valorTotal1.setSelectionColor(SystemColor.textHighlight);
			valorTotal1.setForeground(Color.BLACK);
			valorTotal1.setEditable(false);
			valorTotal1.setHorizontalAlignment(SwingConstants.CENTER);
			valorTotal1.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorTotal1.setColumns(10);
			panelPainelVendas.add(valorTotal1);

			desconto1 = new JTextField();
			desconto1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			desconto1.setBounds(875, 487, 162, 32);
			desconto1.setText("0,00");
			desconto1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//desconto1.setText(desconto1.getText().replaceAll("[^0-9]", ""));
					// desconto1.setText(desconto1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			desconto1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (desconto1.getText().equalsIgnoreCase("0,00"))
						desconto1.setText("");
					desconto1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (desconto1.getText().equalsIgnoreCase(""))
						desconto1.setText("0,00");
					desconto1.requestFocus(false);
				}

			});

			desconto1.setSelectionColor(SystemColor.textHighlight);
			desconto1.setForeground(Color.BLACK);
			desconto1.setHorizontalAlignment(SwingConstants.CENTER);
			desconto1.setFont(new Font("Kalinga", Font.BOLD, 20));
			desconto1.setColumns(10);
			panelPainelVendas.add(desconto1);

			valorParcelado1 = new JTextField();
			valorParcelado1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			valorParcelado1.setBounds(875, 563, 162, 32);
			valorParcelado1.setText("0,00");
			valorParcelado1.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent evt) {
					//valorParcelado1.setText(valorParcelado1.getText().replaceAll("[^0-9]", ""));
					// valorParcelado1.setText(valorParcelado1.getText().replaceAll("[^A-Z | ^a-z]",
					// ""));
				}
			});

			valorParcelado1.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					if (valorParcelado1.getText().equalsIgnoreCase("0,00"))
						valorParcelado1.setText("");
					valorParcelado1.requestFocus(true);

				}

				@Override
				public void mouseExited(MouseEvent e) {
					if (valorParcelado1.getText().equalsIgnoreCase(""))
						valorParcelado1.setText("0,00");
					valorParcelado1.requestFocus(false);
				}

			});
			valorParcelado1.setDisabledTextColor(Color.BLACK);
			valorParcelado1.setEnabled(false);
			valorParcelado1.setEditable(false);
			valorParcelado1.setSelectionColor(SystemColor.textHighlight);
			valorParcelado1.setForeground(Color.BLACK);
			valorParcelado1.setHorizontalAlignment(SwingConstants.CENTER);
			valorParcelado1.setFont(new Font("Kalinga", Font.BOLD, 20));
			valorParcelado1.setColumns(10);
			panelPainelVendas.add(valorParcelado1);
			
			textFieldCodCliente = new JTextField();
			textFieldCodCliente.setSelectionColor(SystemColor.textHighlight);
			textFieldCodCliente.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCodCliente.setForeground(Color.BLACK);
			textFieldCodCliente.setFont(new Font("Dialog", Font.PLAIN, 14));
			textFieldCodCliente.setEnabled(false);
			textFieldCodCliente.setEditable(false);
			textFieldCodCliente.setDisabledTextColor(Color.BLACK);
			textFieldCodCliente.setColumns(10);
			textFieldCodCliente.setBounds(692, 184, 88, 32);
			panelPainelVendas.add(textFieldCodCliente);

			scrollPaneTabela = new JScrollPane();
			scrollPaneTabela.setOpaque(false);
			scrollPaneTabela.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
			            TitledBorder.TOP, null, null));
			scrollPaneTabela.setFont(new Font("Kalinga", Font.PLAIN, 14));
			scrollPaneTabela.setAutoscrolls(true);
			scrollPaneTabela.setFocusable(false);
			scrollPaneTabela.setBounds(32, 400, 805, 221);
			panelPainelVendas.add(scrollPaneTabela);

			central.setHorizontalAlignment(SwingConstants.CENTER);
			Tabela_itens = new JTable();
			Tabela_itens.setSelectionBackground(SystemColor.scrollbar);
			Tabela_itens.setOpaque(false);
			Tabela_itens.setForeground(Color.BLACK);
			Tabela_itens.setShowHorizontalLines(true);
			Tabela_itens.setShowVerticalLines(true);
			Tabela_itens.setRowMargin(1);
			Tabela_itens.setCellSelectionEnabled(true);
			Tabela_itens.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			Tabela_itens.setModel(new DefaultTableModel(new Object[][] { { null, null, null,
			            null, null, null }, }, new String[] { "ITEM", "COD. ITEM",
			            "DESCRI\u00C7\u00C3O", "QUANTIDADE", "PRE\u00C7O UNIT\u00C1RIO",
			            "TOTAL" }));
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

			// Tabela
			Vendas.TabelaVendas();

			// scrollPane.setVisible(false);
			scrollPaneTabela.setViewportView(Tabela_itens);

			radioVista = new JRadioButton("À Vista");
			radioVista.setHorizontalAlignment(SwingConstants.CENTER);
			radioVista.setForeground(Color.BLACK);
			radioVista.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioVista.setOpaque(false);
			radioVista.setBounds(996, 68, 80, 32);
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
						valorParcelado1.setText("1x" + " " + valorFinal1.getText());
					}
				}
			});

			radioPrazo = new JRadioButton("À Prazo");
			radioPrazo.setHorizontalAlignment(SwingConstants.CENTER);
			radioPrazo.setForeground(Color.BLACK);
			radioPrazo.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioPrazo.setOpaque(false);
			radioPrazo.setBounds(1085, 68, 87, 32);
			panelPainelVendas.add(radioPrazo);

			radioPrazo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					opc = 1;
					if (opc == 1) {
						comboVezes.setVisible(true);
						radioVista.setSelected(false);
						radioPrazo.setSelected(true);
						valorParcelado1.setText(comboVezes.getSelectedItem().toString()
						            + " " + valorFinal1.getText());
					}
				}
			});

			radioVisa = new JRadioButton("Visa");
			radioVisa.setHorizontalAlignment(SwingConstants.LEFT);
			radioVisa.setOpaque(false);
			radioVisa.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioVisa.setForeground(Color.BLACK);
			radioVisa.setVisible(false);

			radioMaster = new JRadioButton("Master");
			radioMaster.setIcon(null);
			radioMaster.setHorizontalAlignment(SwingConstants.LEFT);
			radioMaster.setForeground(Color.BLACK);
			radioMaster.setOpaque(false);
			radioMaster.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioMaster.setVisible(false);
			radioMaster.setBounds(1056, 193, 98, 32);
			panelPainelVendas.add(radioMaster);
			radioVisa.setBounds(1070, 231, 70, 32);
			panelPainelVendas.add(radioVisa);

			radioAmerican = new JRadioButton("American");
			radioAmerican.setHorizontalAlignment(SwingConstants.LEFT);
			radioAmerican.setOpaque(false);
			radioAmerican.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioAmerican.setForeground(Color.BLACK);
			radioAmerican.setVisible(false);
			radioAmerican.setBounds(1049, 269, 112, 32);
			panelPainelVendas.add(radioAmerican);

			menuBar_3 = new JMenuBar();
			menuBar_3.setBounds(584, 0, 189, 32);
			panelPainelVendas.add(menuBar_3);

			btFinalizarVenda = new JButton("Salvar");
			menuBar_3.add(btFinalizarVenda);
			btFinalizarVenda.setToolTipText("alt + Enter");
			btFinalizarVenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btFinalizarVenda.setMnemonic(KeyEvent.VK_ENTER);
			btFinalizarVenda.setForeground(Color.BLACK);
			btFinalizarVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btFinalizarVenda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Inicio.caixa.equals("fechado")){
						JOptionPane.showMessageDialog(null,"É necessário efetuar a abertura do caixa !","Atenção", JOptionPane.WARNING_MESSAGE);
						new Caixa();
					}
					else {
						VendasController.SalvarVenda();
						AtualizarItensVendaveisDelivery();
						AtualizarItensVendaveis();
					}
				}
			});
			btFinalizarVenda.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606570_floppy-128.png")));

			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.BLACK);
			menuBar_3.add(btnCancelar);
			btnCancelar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Vendas.LimparVenda();
				}
			});
			btnCancelar.setToolTipText("alt + Delete");
			btnCancelar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar.setAlignmentX(0.5f);

			btAdicionarItem = new JButton("Adicionar");
			btAdicionarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAdicionarItem.setMnemonic(KeyEvent.VK_INSERT);
			btAdicionarItem.setForeground(Color.BLACK);
			btAdicionarItem.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAdicionarItem.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			btAdicionarItem.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					VendasController.AddItem();
				}
			});
			btAdicionarItem.setBounds(489, 245, 140, 35);
			panelPainelVendas.add(btAdicionarItem);
			// addL.setVisible(false);

			btRemoverItem_1 = new JButton("Remover");
			btRemoverItem_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btRemoverItem_1.setMnemonic(KeyEvent.VK_DELETE);
			btRemoverItem_1.setForeground(Color.BLACK);
			btRemoverItem_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btRemoverItem_1.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btRemoverItem_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					comboRemoveItem.removeAllItems();
					comboRemoveItem.addItem("");
					for (int i = 0; i < VendasController.contLinha; i++) {
						comboRemoveItem.addItem((String) modelo.getValueAt(i, 2));
					}
					internalFrame.setVisible(true);
				}
			});
			btRemoverItem_1.setBounds(489, 288, 140, 35);
			panelPainelVendas.add(btRemoverItem_1);

			btRecalcularTroco = new JButton("Recalcular");
			btRecalcularTroco.setBounds(1043, 590, 129, 32);
			panelPainelVendas.add(btRecalcularTroco);
			btRecalcularTroco.setMnemonic(KeyEvent.VK_EQUALS);
			btRecalcularTroco.setToolTipText("alt + =");
			btRecalcularTroco.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btRecalcularTroco.setForeground(Color.BLACK);
			btRecalcularTroco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btRecalcularTroco.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606619_notepad-128.png")));
			btRecalcularTroco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VendasController.CalcularTotal();
					VendasController.CalcularParcela();
					VendasController.CalcularParcelamento();
					VendasController.CalcularTroco();
				}
			});

			labelValorPago = new JLabel("Valor Pago");
			labelValorPago.setBounds(1177, 374, 115, 32);
			panelPainelVendas.add(labelValorPago);
			labelValorPago.setForeground(Color.BLACK);
			labelValorPago.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606602_678131-money-128.png")));
			labelValorPago.setFont(new Font("Dialog", Font.BOLD, 15));

			labelTroco = new JLabel("Troco");
			labelTroco.setBounds(1177, 452, 115, 32);
			panelPainelVendas.add(labelTroco);
			labelTroco.setForeground(Color.BLACK);
			labelTroco.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606619_notepad-128.png")));
			labelTroco.setFont(new Font("Dialog", Font.BOLD, 15));

			labelValorFinal = new JLabel("Valor Final");
			labelValorFinal.setBounds(1177, 524, 162, 32);
			panelPainelVendas.add(labelValorFinal);
			labelValorFinal.setForeground(Color.BLACK);
			labelValorFinal.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606730_678082-tag-128.png")));
			labelValorFinal.setFont(new Font("Dialog", Font.BOLD, 15));

			labelValorTotal = new JLabel("Valor Total");
			labelValorTotal.setBounds(875, 374, 162, 32);
			panelPainelVendas.add(labelValorTotal);
			labelValorTotal.setForeground(Color.BLACK);
			labelValorTotal.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606602_678131-money-128.png")));
			labelValorTotal.setFont(new Font("Dialog", Font.BOLD, 15));

			labelDesconto = new JLabel("Desconto");
			labelDesconto.setBounds(875, 452, 115, 32);
			panelPainelVendas.add(labelDesconto);
			labelDesconto.setHorizontalAlignment(SwingConstants.LEFT);
			labelDesconto.setForeground(Color.BLACK);
			labelDesconto.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606555_star-128.png")));
			labelDesconto.setFont(new Font("Dialog", Font.BOLD, 15));

			labelValorParcelado = new JLabel("Valor Parcelado");
			labelValorParcelado.setBounds(875, 524, 162, 32);
			panelPainelVendas.add(labelValorParcelado);
			labelValorParcelado.setForeground(Color.BLACK);
			labelValorParcelado.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606770_file-excel-alt-128.png")));
			labelValorParcelado.setFont(new Font("Dialog", Font.BOLD, 15));

			labelNome = new JLabel("Nome");
			labelNome.setForeground(Color.BLACK);
			labelNome.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNome.setBounds(32, 151, 49, 32);
			panelPainelVendas.add(labelNome);

			labelQuantidade_1 = new JLabel("Quantidade");
			labelQuantidade_1.setForeground(Color.BLACK);
			labelQuantidade_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelQuantidade_1.setBounds(379, 255, 99, 32);
			panelPainelVendas.add(labelQuantidade_1);

			labelNumeroVenda = new JLabel("Nº da Venda");
			labelNumeroVenda.setForeground(Color.BLACK);
			labelNumeroVenda.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroVenda.setBounds(32, 80, 99, 32);
			panelPainelVendas.add(labelNumeroVenda);

			labelData = new JLabel("Data");
			labelData.setForeground(Color.BLACK);
			labelData.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelData.setBounds(141, 80, 64, 32);
			panelPainelVendas.add(labelData);

			labelVendedor = new JLabel("Vendedor");
			labelVendedor.setForeground(Color.BLACK);
			labelVendedor.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelVendedor.setBounds(332, 80, 87, 32);
			panelPainelVendas.add(labelVendedor);

			labelCpf = new JLabel("CPF");
			labelCpf.setForeground(Color.BLACK);
			labelCpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelCpf.setBounds(424, 151, 39, 32);
			panelPainelVendas.add(labelCpf);

			labelSelecionarCartao = new JLabel("Selecione o Cartão");
			labelSelecionarCartao.setHorizontalAlignment(SwingConstants.CENTER);
			labelSelecionarCartao.setForeground(Color.BLACK);
			labelSelecionarCartao.setIcon(null);
			labelSelecionarCartao.setVisible(false);
			labelSelecionarCartao.setFont(new Font("Khmer UI", Font.BOLD, 14));
			labelSelecionarCartao.setBounds(1013, 141, 184, 32);
			panelPainelVendas.add(labelSelecionarCartao);

			labelDadosCheque = new JLabel("Dados do Cheque");
			labelDadosCheque.setHorizontalAlignment(SwingConstants.CENTER);
			labelDadosCheque.setForeground(Color.BLACK);
			labelDadosCheque.setVisible(false);
			labelDadosCheque.setFont(new Font("Khmer UI", Font.BOLD, 14));
			labelDadosCheque.setBounds(1027, 141, 157, 32);
			panelPainelVendas.add(labelDadosCheque);

			labelAgencia = new JLabel("Agência");
			labelAgencia.setForeground(Color.BLACK);
			labelAgencia.setVisible(false);
			labelAgencia.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelAgencia.setBounds(977, 269, 56, 32);
			panelPainelVendas.add(labelAgencia);

			labelNumeroConta = new JLabel("Nº Conta");
			labelNumeroConta.setVisible(false);
			labelNumeroConta.setForeground(Color.BLACK);
			labelNumeroConta.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroConta.setBounds(969, 312, 64, 32);
			panelPainelVendas.add(labelNumeroConta);

			labelTelefone = new JLabel("Telefone");
			labelTelefone.setForeground(Color.BLACK);
			labelTelefone.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelTelefone.setBounds(558, 151, 81, 32);
			panelPainelVendas.add(labelTelefone);

			labelBanco = new JLabel("Banco");
			labelBanco.setForeground(Color.BLACK);
			labelBanco.setVisible(false);
			labelBanco.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelBanco.setBounds(977, 184, 56, 32);
			panelPainelVendas.add(labelBanco);

			labelNumeroCheque = new JLabel("Nº Cheque");
			labelNumeroCheque.setVisible(false);
			labelNumeroCheque.setForeground(Color.BLACK);
			labelNumeroCheque.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelNumeroCheque.setBounds(953, 226, 80, 32);
			panelPainelVendas.add(labelNumeroCheque);

			labelIcone_4 = new JLabel("(165x115)");
			labelIcone_4.setForeground(Color.BLACK);
			labelIcone_4.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_48px/1425606663_image-128.png")));
			labelIcone_4.setOpaque(true);
			labelIcone_4.setHorizontalAlignment(SwingConstants.CENTER);
			labelIcone_4.setBorder(UIManager.getBorder("TitledBorder.border"));
			labelIcone_4.setBackground(Color.WHITE);
			labelIcone_4.setBounds(649, 223, 145, 95);
			panelPainelVendas.add(labelIcone_4);

			labelProduto = new JLabel("Selecione o Produto");
			labelProduto.setForeground(Color.BLACK);
			labelProduto.setFont(new Font("Kalinga", Font.BOLD, 14));
			labelProduto.setBounds(32, 255, 173, 32);
			panelPainelVendas.add(labelProduto);

			labelHora = new JLabel("Hora");
			labelHora.setForeground(Color.BLACK);
			labelHora.setFont(new Font("Kalinga", Font.PLAIN, 14));
			labelHora.setBounds(240, 80, 64, 32);
			panelPainelVendas.add(labelHora);

			str = "                      Bem vindo ao S-One !!!                      ";
			labelAnime = new JLabel("");
			labelAnime.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
			            TitledBorder.TOP, null, null));
			labelAnime.setHorizontalAlignment(SwingConstants.CENTER);
			labelAnime.setForeground(Color.BLACK);
			labelAnime.setFont(new Font("Agency FB", Font.ITALIC, 38));
			labelAnime.setBounds(32, 329, 805, 60);
			panelPainelVendas.add(labelAnime);

			Vendas.Animacao();

			label_1 = new JLabel("");
			label_1.setForeground(Color.BLACK);
			label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "DADOS DA VENDA", TitledBorder.LEFT, TitledBorder.TOP, null,
			            Color.BLACK));
			label_1.setBounds(10, 46, 843, 588);
			panelPainelVendas.add(label_1);

			label_2 = new JLabel("");
			label_2.setForeground(Color.BLACK);
			label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "FORMA DE PAGAMENTO", TitledBorder.LEFT, TitledBorder.TOP,
			            null, Color.BLACK));
			label_2.setBounds(865, 46, 480, 317);
			panelPainelVendas.add(label_2);

			label_5 = new JLabel("");
			label_5.setForeground(Color.BLACK);
			label_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "PAGAMENTO", TitledBorder.LEFT, TitledBorder.TOP, null,
			            Color.BLACK));
			label_5.setBounds(865, 361, 480, 273);
			panelPainelVendas.add(label_5);

			separator = new JSeparator();
			separator.setBounds(32, 238, 597, 2);
			panelPainelVendas.add(separator);
			
			JLabel lblCodDoCliente = new JLabel("Cod. do Cliente");
			lblCodDoCliente.setForeground(Color.BLACK);
			lblCodDoCliente.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblCodDoCliente.setBounds(692, 152, 99, 32);
			panelPainelVendas.add(lblCodDoCliente);

			labelFundo1 = new JLabel("");
			labelFundo1.setOpaque(true);
			labelFundo1.setForeground(Color.BLACK);
			labelFundo1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundo1.setBackground(new Color(240, 240, 240));
			labelFundo1.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundo1.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			labelFundo1.setBounds(0, 0, 1355, 668);
			panelPainelVendas.add(labelFundo1);

			contitem1 = new JTextField();
			contitem1.setVisible(false);
			contitem1.setBounds(808, 589, 29, 32);
			panelPainelVendas.add(contitem1);
			contitem1.setColumns(10);
			contitem1.setText("0");

			final JButton btAdicionar = new JButton("Adicionar ");
			btAdicionar.setForeground(Color.BLACK);
			btAdicionar.setToolTipText("alt + Insert");
			btAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btAdicionar.setMnemonic(KeyEvent.VK_INSERT);
			btAdicionar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btAdicionar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606548_678092-sign-add-128.png")));
			btAdicionar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					modelo1.addRow(new String[] { " ", "" });
					String aux = autorizados3.getText();
					int d = Integer.parseInt(aux);
					d++;
					aux = String.valueOf(d);
					autorizados3.setText(aux);
				}
			});
			
			final JButton brRemover = new JButton("Remover");
			brRemover.setForeground(Color.BLACK);
			brRemover.setToolTipText("alt + Delete");
			brRemover.setMnemonic(KeyEvent.VK_DELETE);
			brRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			brRemover.setFont(new Font("Kalinga", Font.PLAIN, 14));
			brRemover.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			brRemover.setBounds(1148, 453, 129, 40);
			panelCadastrarCliente.add(brRemover);
			brRemover.setVisible(false);
			brRemover.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String aux = autorizados3.getText();
					int d = Integer.parseInt(aux);
					d--;
					if (d >= 1) {
						modelo1.removeRow(d);
						aux = String.valueOf(d);
						autorizados3.setText(aux);
					}
				}
			});

			comboBox = new JComboBox<String>();
			comboBox.setForeground(Color.BLACK);
			comboBox.setVisible(false);
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBox.setEditable(false);
			comboBox.setBounds(926, 61, 112, 32);
			comboBox.addItem("");
			comboBox.addItem("Código de Cliente");
			comboBox.addItem("Telefone");
			comboBox.addItem("CPF");
			panelCadastrarCliente.add(comboBox);
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent evt) {
					Object item = evt.getItem();
					String tipoConsulta = item.toString();
					if (tipoConsulta.equals("Código de Cliente")) {
						codigoCliente3.setEnabled(true);
						codigoCliente3.setEditable(true);
						codigoCliente3.setRequestFocusEnabled(true);
						codigoCliente3.setBorder(new LineBorder(Color.BLUE));
						codigoCliente3.requestFocus();

						telefone3.setEnabled(false);
						telefone3.setEditable(false);
						telefone3.setBorder(null);

						cpf3.setEnabled(false);
						cpf3.setEditable(false);
						cpf3.setBorder(null);

					}
					else if (tipoConsulta.equals("Telefone")) {
						codigoCliente3.setEnabled(false);
						codigoCliente3.setEditable(false);
						codigoCliente3.setBorder(null);

						telefone3.setEnabled(true);
						telefone3.setEditable(true);
						telefone3.setRequestFocusEnabled(true);
						telefone3.setBorder(new LineBorder(Color.BLUE));
						telefone3.requestFocus();

						cpf3.setEnabled(false);
						cpf3.setEditable(false);
						cpf3.setBorder(null);

					}
					else if (tipoConsulta.equals("CPF")) {
						codigoCliente3.setEnabled(false);
						codigoCliente3.setEditable(false);
						codigoCliente3.setBorder(null);

						telefone3.setEnabled(false);
						telefone3.setEditable(false);
						telefone3.setBorder(null);

						cpf3.setEnabled(true);
						cpf3.setEditable(true);
						cpf3.setRequestFocusEnabled(true);
						cpf3.setBorder(new LineBorder(Color.BLUE));
						cpf3.requestFocus();
					}
				}
			});

			radioSim = new JRadioButton("Sim");
			radioSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioSim.setForeground(Color.BLACK);
			radioSim.setOpaque(false);
			radioSim.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioSim.setBounds(1061, 169, 55, 32);
			panelCadastrarCliente.add(radioSim);

			radioSim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sn = 1;
					if (sn == 1) {
						scrollPane1.setVisible(true);
						brRemover.setVisible(true);
						btAdicionar.setVisible(true);
						dep_1.setVisible(true);
						autorizados3.setVisible(true);
						radioNao.setSelected(false);
						radioSim.setSelected(true);
						autorizados3.setText("1");
					}
				}
			});

			radioNao = new JRadioButton("Não");
			radioNao.setSelected(true);
			radioNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			radioNao.setForeground(Color.BLACK);
			radioNao.setOpaque(false);
			radioNao.setFont(new Font("Kalinga", Font.PLAIN, 14));
			radioNao.setBounds(1118, 169, 64, 32);
			panelCadastrarCliente.add(radioNao);

			radioNao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sn = 0;
					if (sn == 0) {
						scrollPane1.setVisible(false);
						brRemover.setVisible(false);
						btAdicionar.setVisible(false);
						dep_1.setVisible(false);
						autorizados3.setVisible(false);
						radioSim.setSelected(false);
						radioNao.setSelected(true);
						autorizados3.setText("0");
					}
				}
			});

			cadastro = new JRadioButton("Cadastrar Cliente");
			cadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cadastro.setMnemonic(KeyEvent.VK_F1);
			cadastro.setHorizontalAlignment(SwingConstants.CENTER);
			cadastro.setOpaque(false);
			cadastro.setForeground(Color.BLACK);
			cadastro.setFont(new Font("Khmer UI", Font.BOLD, 14));
			cadastro.setSelected(true);
			cadastro.setBounds(488, 61, 173, 32);
			panelCadastrarCliente.add(cadastro);

			cadastro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblPor.setVisible(false);
					comboBox.setVisible(false);
					consulta.setSelected(false);
					cadastro.setSelected(true);
					Vendas.SetarEditavelTrue();
					LimparCliente();
					salvar.setVisible(true);
					codigoCliente3.setText(aux1);
					Vendas.btnAtualizarFoto.setVisible(false);
					lblcadastrarDependentes.setText("*AUTORIZAÇÃO EXTRA ?");
					button_FotoCliente.setVisible(true);
					fotoCliente.setText("Fotografia");
					fotoCliente.setIcon(new ImageIcon(Vendas.class
				            .getResource("/icones1_48px/1425606663_image-128.png")));
				}
			});

			consulta = new JRadioButton("Consultar Cliente");
			consulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			consulta.setMnemonic(KeyEvent.VK_F2);
			consulta.setHorizontalAlignment(SwingConstants.CENTER);
			consulta.setOpaque(false);
			consulta.setForeground(Color.BLACK);
			consulta.setFont(new Font("Khmer UI", Font.BOLD, 14));
			consulta.setBounds(682, 61, 166, 32);
			panelCadastrarCliente.add(consulta);

			consulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					cadastro.setSelected(false);
					consulta.setSelected(true);
					codigoCliente3.setText(null);
					LimparCliente();
					lblPor.setVisible(true);
					comboBox.setVisible(true);
					Vendas.SetarEditavelFalso();
					btconsultar.setEnabled(true);
					button_FotoCliente.setVisible(false);
					fotoCliente.setText("Fotografia");
					fotoCliente.setIcon(new ImageIcon(Vendas.class
				            .getResource("/icones1_48px/1425606663_image-128.png")));
				}
			});

			menuBar_2 = new JMenuBar();
			menuBar_2.setBounds(244, 0, 869, 32);
			panelCadastrarCliente.add(menuBar_2);

			salvar = new JButton("Salvar");
			salvar.setForeground(Color.BLACK);
			menuBar_2.add(salvar);
			salvar.setMnemonic(KeyEvent.VK_ENTER);
			salvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			salvar.setToolTipText("alt + Enter");
			salvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			salvar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606570_floppy-128.png")));

			btnAtualizar = new JButton("Atualizar");
			btnAtualizar.setEnabled(false);
			btnAtualizar.setForeground(Color.BLACK);
			menuBar_2.add(btnAtualizar);
			btnAtualizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					VendasController.AtualizarCliente();
				}
			});
			btnAtualizar.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606696_678121-cloud-sync-128.png")));
			btnAtualizar.setToolTipText("alt + Enter");
			btnAtualizar.setMnemonic(KeyEvent.VK_ENTER);
			btnAtualizar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			
			btconsultar = new JButton("Pesquisar");
			btconsultar.setEnabled(false);
			btconsultar.setForeground(Color.BLACK);
			menuBar_2.add(btconsultar);
			
			btconsultar.setToolTipText("alt + Enter");
			btconsultar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btconsultar.setMnemonic(KeyEvent.VK_ENTER);
			btconsultar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606561_search-128.png")));

			btnCancelar_1 = new JButton("Cancelar");
			btnCancelar_1.setEnabled(false);
			btnCancelar_1.setForeground(Color.BLACK);
			menuBar_2.add(btnCancelar_1);
			btnCancelar_1.setToolTipText("alt + Delete");
			btnCancelar_1.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
			btnCancelar_1.setMnemonic(KeyEvent.VK_DELETE);
			btnCancelar_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnCancelar_1.setAlignmentX(0.5f);

			limpar = new JButton("Limpar");
			limpar.setForeground(Color.BLACK);
			menuBar_2.add(limpar);
			limpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			limpar.setToolTipText("alt + Backspace");
			limpar.setFont(new Font("Kalinga", Font.PLAIN, 14));
			limpar.setMnemonic(KeyEvent.VK_BACK_SPACE);
			limpar.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/Gnome-edit-clear.png")));
			limpar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Vendas.LimparCliente();
				}
			});
			

			button_3 = new JButton("Alterar");
			button_3.setForeground(Color.BLACK);
			menuBar_2.add(button_3);
			button_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Vendas.SetarEditavelTrue();
					comboEstadoCivil.setSelectedItem(estadoCivilConsulta.getText());
					comboUf3.setSelectedItem(ufConsulta.getText());
					comboCidade3.setSelectedItem(cidadeConsulta.getText());
					btnAtualizar.setVisible(true);
				}
			});
			button_3.setToolTipText("alt + Space");
			button_3.setEnabled(false);
			button_3.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606608_pencil-128.png")));
			button_3.setMnemonic(KeyEvent.VK_SPACE);
			button_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_3.setFocusTraversalPolicyProvider(true);
			button_3.setFocusCycleRoot(true);
			button_3.setAlignmentX(0.5f);

			button = new JButton("Imprimir");
			button.setForeground(Color.BLACK);
			menuBar_2.add(button);
			button.setEnabled(false);
			button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					report.Cliente();
				}
			});
			button.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button.setToolTipText("alt + P");
			button.setMnemonic(KeyEvent.VK_P);
			button.setFont(new Font("Kalinga", Font.PLAIN, 14));

			button_7 = new JButton("Anterior");
			button_7.setForeground(Color.BLACK);
			menuBar_2.add(button_7);
			button_7.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425605893_arrow_left.png")));
			button_7.setMnemonic(KeyEvent.VK_P);
			button_7.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_7.setEnabled(false);
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VendasController.ConsultarClienteAnt();
				}
			});

			button_6 = new JButton("Próximo");
			button_6.setForeground(Color.BLACK);
			menuBar_2.add(button_6);
			button_6.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425605875_arrow_right.png")));
			button_6.setMnemonic(KeyEvent.VK_P);
			button_6.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_6.setEnabled(false);			
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VendasController.ConsultarProxCliente();
				}
			});
			
			
			btconsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VendasController.ConsultarCliente();
				}
			});
			salvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VendasController.SalvarCliente();
				}
			});
			btAdicionar.setBounds(1009, 453, 129, 40);
			panelCadastrarCliente.add(btAdicionar);
			btAdicionar.setVisible(false);

			/*
			 * 
			 * labels
			 */
					
			button_FotoCliente = new JButton("Selecionar");
			button_FotoCliente.setForeground(Color.BLACK);
			button_FotoCliente.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606659_678090-camera-128.png")));
			button_FotoCliente.setFont(new Font("Kalinga", Font.PLAIN, 14));
			button_FotoCliente.setFocusTraversalPolicyProvider(true);
			button_FotoCliente.setBounds(702, 236, 146, 35);
			panelCadastrarCliente.add(button_FotoCliente);
			button_FotoCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Vendas.SelecionarFotoCliente();					
				}				
			});	

			btnAtualizarFoto = new JButton("Atualizar");
			btnAtualizarFoto.setVisible(false);						
			btnAtualizarFoto.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606696_678121-cloud-sync-128.png")));
			btnAtualizarFoto.setForeground(Color.BLACK);
			btnAtualizarFoto.setFont(new Font("Kalinga", Font.PLAIN, 14));
			btnAtualizarFoto.setFocusTraversalPolicyProvider(true);
			btnAtualizarFoto.setBounds(702, 236, 146, 35);
			panelCadastrarCliente.add(btnAtualizarFoto);
			btnAtualizarFoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Vendas.AtualizarFotoCliente();					
				}				
			});	

			num = new JLabel("Número");
			num.setFont(new Font("Kalinga", Font.PLAIN, 14));
			num.setBounds(597, 483, 64, 32);
			num.setForeground(Color.BLACK);
			panelCadastrarCliente.add(num);

			comp = new JLabel("Complemento");
			comp.setFont(new Font("Kalinga", Font.PLAIN, 14));
			comp.setBounds(32, 549, 102, 32);
			comp.setForeground(Color.BLACK);
			panelCadastrarCliente.add(comp);

			bairro = new JLabel("Bairro");
			bairro.setFont(new Font("Kalinga", Font.PLAIN, 14));
			bairro.setBounds(422, 483, 80, 32);
			bairro.setForeground(Color.BLACK);
			panelCadastrarCliente.add(bairro);

			uf = new JLabel("UF");
			uf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			uf.setBounds(204, 554, 49, 32);
			uf.setForeground(Color.BLACK);
			panelCadastrarCliente.add(uf);

			cid = new JLabel("Cidade");
			cid.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cid.setBounds(309, 554, 49, 32);
			cid.setForeground(Color.BLACK);
			panelCadastrarCliente.add(cid);

			JLabel lblNacionalidade = new JLabel("Nacionalidade");
			lblNacionalidade.setForeground(Color.BLACK);
			lblNacionalidade.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNacionalidade.setBounds(34, 195, 104, 32);
			panelCadastrarCliente.add(lblNacionalidade);

			lblNomeDoPai = new JLabel("Nome de Pai");
			lblNomeDoPai.setForeground(Color.BLACK);
			lblNomeDoPai.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNomeDoPai.setBounds(34, 324, 105, 32);
			panelCadastrarCliente.add(lblNomeDoPai);

			lblNomeDoMe = new JLabel("Nome da Mãe");
			lblNomeDoMe.setForeground(Color.BLACK);
			lblNomeDoMe.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblNomeDoMe.setBounds(344, 324, 105, 32);
			panelCadastrarCliente.add(lblNomeDoMe);

			lblTelefone = new JLabel("Telefone 2");
			lblTelefone.setForeground(Color.BLACK);
			lblTelefone.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblTelefone.setBounds(173, 384, 80, 32);
			panelCadastrarCliente.add(lblTelefone);

			lblCel = new JLabel("Cel 2");
			lblCel.setForeground(Color.BLACK);
			lblCel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			lblCel.setBounds(451, 383, 41, 32);
			panelCadastrarCliente.add(lblCel);

			lblcadastrarDependentes = new JLabel("Autorização Extra?");
			lblcadastrarDependentes.setHorizontalAlignment(SwingConstants.CENTER);
			lblcadastrarDependentes.setForeground(Color.BLACK);
			lblcadastrarDependentes.setFont(new Font("Khmer UI", Font.BOLD, 14));
			lblcadastrarDependentes.setBounds(1009, 135, 209, 32);
			panelCadastrarCliente.add(lblcadastrarDependentes);

			NumF = new JLabel("Nº de Registro");
			NumF.setForeground(Color.BLACK);
			NumF.setFont(new Font("Kalinga", Font.PLAIN, 14));
			NumF.setBounds(34, 129, 104, 32);
			panelCadastrarCliente.add(NumF);

			Nom = new JLabel("Nome");
			Nom.setForeground(Color.BLACK);
			Nom.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Nom.setBounds(217, 129, 49, 32);
			panelCadastrarCliente.add(Nom);

			dnasc = new JLabel("Nascimento");
			dnasc.setForeground(Color.BLACK);
			dnasc.setFont(new Font("Kalinga", Font.PLAIN, 14));
			dnasc.setBounds(607, 129, 92, 32);
			panelCadastrarCliente.add(dnasc);

			Rg = new JLabel("RG");
			Rg.setForeground(Color.BLACK);
			Rg.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Rg.setBounds(217, 195, 41, 32);
			panelCadastrarCliente.add(Rg);

			Cpf = new JLabel("CPF");
			Cpf.setForeground(Color.BLACK);
			Cpf.setFont(new Font("Kalinga", Font.PLAIN, 14));
			Cpf.setBounds(396, 195, 41, 32);
			panelCadastrarCliente.add(Cpf);

			dep_1 = new JLabel("Autorizados");
			dep_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			dep_1.setBounds(893, 398, 87, 32);
			dep_1.setForeground(Color.BLACK);
			dep_1.setVisible(false);
			panelCadastrarCliente.add(dep_1);

			tel = new JLabel("Telefone1");
			tel.setForeground(Color.BLACK);
			tel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			tel.setBounds(34, 384, 69, 32);
			panelCadastrarCliente.add(tel);

			cel = new JLabel("Cel 1");
			cel.setForeground(Color.BLACK);
			cel.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cel.setBounds(312, 384, 41, 32);
			panelCadastrarCliente.add(cel);

			ec = new JLabel("Estado Civil");
			ec.setFont(new Font("Kalinga", Font.PLAIN, 14));
			ec.setBounds(289, 259, 92, 32);
			ec.setForeground(Color.BLACK);
			panelCadastrarCliente.add(ec);

			email = new JLabel("E-mail");
			email.setFont(new Font("Kalinga", Font.PLAIN, 14));
			email.setBounds(34, 259, 54, 32);
			email.setForeground(Color.BLACK);
			panelCadastrarCliente.add(email);

			logr = new JLabel("Endereço");
			logr.setFont(new Font("Kalinga", Font.PLAIN, 14));
			logr.setBounds(33, 483, 104, 32);
			logr.setForeground(Color.BLACK);
			panelCadastrarCliente.add(logr);

			fotoCliente = new JLabel("(Fotografia)");			
			fotoCliente.setForeground(Color.BLACK);
			fotoCliente.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_48px/1425606663_image-128.png")));
			fotoCliente.setOpaque(true);
			fotoCliente.setHorizontalAlignment(SwingConstants.CENTER);
			fotoCliente.setBorder(new LineBorder(Color.LIGHT_GRAY));
			fotoCliente.setBackground(Color.WHITE);
			fotoCliente.setBounds(702, 135, 145, 95);
			panelCadastrarCliente.add(fotoCliente);

			cep = new JLabel("CEP");
			cep.setFont(new Font("Kalinga", Font.PLAIN, 14));
			cep.setBounds(548, 549, 41, 32);
			cep.setForeground(Color.BLACK);
			panelCadastrarCliente.add(cep);

			lblPor = new JLabel("Por?");
			lblPor.setVisible(false);
			lblPor.setHorizontalAlignment(SwingConstants.CENTER);
			lblPor.setForeground(Color.BLACK);
			lblPor.setFont(new Font("Khmer UI", Font.BOLD, 15));
			lblPor.setBounds(876, 61, 49, 32);
			panelCadastrarCliente.add(lblPor);

			label_9 = new JLabel("");
			label_9.setForeground(Color.BLACK);
			label_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "DADOS PESSOAIS", TitledBorder.LEFT, TitledBorder.TOP, null,
			            Color.DARK_GRAY));
			label_9.setBounds(11, 108, 853, 352);
			panelCadastrarCliente.add(label_9);

			label_10 = new JLabel("");
			label_10.setForeground(Color.BLACK);
			label_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_10.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "ENDERE\u00C7O", TitledBorder.LEFT, TitledBorder.TOP, null,
			            new Color(64, 64, 64)));
			label_10.setBounds(11, 469, 853, 165);
			panelCadastrarCliente.add(label_10);

			label_11 = new JLabel("");
			label_11.setForeground(Color.BLACK);
			label_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "AUTORIZA\u00C7\u00C3O EXTRA", TitledBorder.LEFT,
			            TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_11.setBounds(865, 108, 476, 526);
			panelCadastrarCliente.add(label_11);

			label_18 = new JLabel("");
			label_18.setForeground(Color.BLACK);
			label_18.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			label_18.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
			            null), "SELECIONAR A\u00C7\u00C3O", TitledBorder.CENTER,
			            TitledBorder.TOP, null, new Color(64, 64, 64)));
			label_18.setBounds(10, 43, 1331, 69);
			panelCadastrarCliente.add(label_18);

			// Inicio.rd=1;
			Fundo = new JLabel("");
			Fundo.setOpaque(true);
			Fundo.setHorizontalTextPosition(SwingConstants.CENTER);
			Fundo.setForeground(Color.BLACK);
			Fundo.setFont(new Font("Arial", Font.PLAIN, 12));
			Fundo.setHorizontalAlignment(SwingConstants.CENTER);
			Fundo.setBounds(0, 0, 1355, 668);
			Fundo.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			panelCadastrarCliente.add(Fundo);

			panelRelatorios.setLayout(null);

			Vendas.TabelaHistorico();

			menuBar_1 = new JMenuBar();
			menuBar_1.setBounds(564, 0, 223, 32);
			panelRelatorios.add(menuBar_1);

			button_1 = new JButton("Imprimir");
			menuBar_1.add(button_1);
			button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			button_1.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			button_1.setToolTipText("alt + P");
			button_1.setMnemonic(KeyEvent.VK_P);
			button_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
			JButton btnGraficos = new JButton("Grafico");
			menuBar_1.add(btnGraficos);
			btnGraficos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGraficos.setIcon(new ImageIcon(Vendas.class
			            .getResource("/icones1_24px/1425606754_monitor-128.png")));
			btnGraficos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					/**
					 * ----------------------------------------------
					 * ---------------------------- *
					 */

					DefaultPieDataset pieDataset = new DefaultPieDataset();
					pieDataset.setValue("Produto 1", new Integer(10));
					pieDataset.setValue("Produto 2", new Integer(20));
					pieDataset.setValue("Produto 3", new Integer(30));
					pieDataset.setValue("Produto 4", new Integer(40));
					JFreeChart chart = ChartFactory.createPieChart3D(
					            "Produtos mais vendidos", pieDataset, true, true, true);

					PiePlot3D plot = (PiePlot3D) chart.getPlot();
					plot.setStartAngle(290);
					plot.setDirection(Rotation.CLOCKWISE);
					plot.setForegroundAlpha(0.5f);
					plot.setNoDataMessage("No data to display");

					chart.getPlot();

					ChartFrame frame = new ChartFrame("Histórico de Vendas", chart);
					frame.setVisible(true);
					frame.setBounds(885, 11, 975, 578);
					frame.setSize(400, 450);

					/**
					 * ----------------------------------------------
					 * ---------------------------- *
					 */

					DefaultCategoryDataset barDataset = new DefaultCategoryDataset();

					barDataset.setValue(20, "Produto 1", "Quantidade:");
					barDataset.setValue(40, "Produto 2", "Quantidade:");
					barDataset.setValue(60, "Produto 3", "Quantidade:");
					barDataset.setValue(80, "Produto 4", "Quantidade:");
					JFreeChart chart1 = ChartFactory.createBarChart3D(
					            "Produtos mais vendidos na semana", "KM",
					            "Qt. Produtos Vendidos", barDataset,
					            PlotOrientation.VERTICAL, false, true, false);

					CategoryPlot p = chart1.getCategoryPlot();
					p.setRangeGridlinePaint(Color.black);
					ChartFrame frame1 = new ChartFrame("Histórico de Vendas", chart1);
					frame1.setVisible(true);
					frame1.setBounds(10, 78, 845, 500);

					/**
					 * ----------------------------------------------
					 * ---------------------------- *
					 */

				}
			});
			btnGraficos.setToolTipText("alt + G");
			btnGraficos.setMnemonic(KeyEvent.VK_G);
			btnGraficos.setFont(new Font("Kalinga", Font.PLAIN, 14));

			JLabel lblGrafico = new JLabel("");
			lblGrafico.setForeground(Color.BLACK);
			lblGrafico.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
			            "PRODUTOS MAIS VENDIDOS", TitledBorder.LEADING, TitledBorder.TOP,
			            null, new Color(0, 0, 0)));
			lblGrafico.setBounds(10, 43, 667, 601);
			panelRelatorios.add(lblGrafico);

			label_12 = new JLabel("");
			label_12.setForeground(Color.BLACK);
			label_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
			            "HISTORICO DE VENDAS", TitledBorder.LEADING, TitledBorder.TOP, null,
			            new Color(0, 0, 0)));
			label_12.setBounds(687, 43, 658, 601);
			panelRelatorios.add(label_12);

			labelFundo1_1 = new JLabel("");
			labelFundo1_1.setOpaque(true);
			labelFundo1_1.setForeground(Color.BLACK);
			labelFundo1_1.setHorizontalTextPosition(SwingConstants.CENTER);
			labelFundo1_1.setHorizontalAlignment(SwingConstants.CENTER);
			labelFundo1_1.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			labelFundo1_1.setBounds(0, 0, 1355, 668);
			panelRelatorios.add(labelFundo1_1);

			/*
			 * panels com ícones
			 */
						
			panelHistoricoVenda = new JPanel();
			panelHistoricoVenda.setLayout(null);
			panelHistoricoVenda.setBackground(SystemColor.inactiveCaptionBorder);
			
			
			menuBar_4 = new JMenuBar();
			menuBar_4.setBounds(534, 0, 223, 32);
			panelHistoricoVenda.add(menuBar_4);
			
			JButton btnImprimir = new JButton("Imprimir");
			menuBar_4.add(btnImprimir);
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnImprimir.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
			
			JButton btnGrafico = new JButton("Grafico");
			menuBar_4.add(btnGrafico);
			btnGrafico.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606754_monitor-128.png")));
			
			JScrollPane scrollPane_3 = new JScrollPane();
			scrollPane_3.setOpaque(false);
			scrollPane_3.setBorder(new TitledBorder(null, "ENTREGAS EM ABERTO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_3.setBounds(10, 63, 845, 198);
			panelHistoricoVenda.add(scrollPane_3);
			
			Tabela_hist = new JTable();
			Tabela_hist.setRowHeight(22);
			Tabela_hist.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, false},
				},
				new String[] {
					"N\u00BA VENDA", "HOR\u00C1RIO", "CLIENTE", "TELEFONE", "ENDERE\u00C7O", "VALOR", "ENTREGA"
				}
			) {
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
				};
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			}) ;
			Tabela_hist.getColumnModel().getColumn(0).setMinWidth(20);
			Tabela_hist.getColumnModel().getColumn(2).setPreferredWidth(250);
			Tabela_hist.getColumnModel().getColumn(3).setPreferredWidth(95);
			Tabela_hist.getColumnModel().getColumn(3).setMinWidth(18);
			Tabela_hist.getColumnModel().getColumn(4).setPreferredWidth(245);
			Tabela_hist.getColumnModel().getColumn(5).setPreferredWidth(99);
			scrollPane_3.setViewportView(Tabela_hist);
			modeloGerencPed = (DefaultTableModel) Tabela_hist.getModel();
			
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setBorder(new TitledBorder(null, "ENTREGAS FINALIZADAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane_2.setOpaque(false);
			scrollPane_2.setBounds(10, 311, 845, 198);
			panelHistoricoVenda.add(scrollPane_2);
			
			table_1 = new JTable();
			table_1.setRowHeight(22);
			table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
					"N\u00BA VENDA", "HOR\u00C1RIO", "CLIENTE", "TELEFONE", "ENDERE\u00C7O", "VALOR"
				}
			));
			table_1.getColumnModel().getColumn(0).setMinWidth(20);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(250);
			table_1.getColumnModel().getColumn(3).setPreferredWidth(95);
			table_1.getColumnModel().getColumn(3).setMinWidth(18);
			table_1.getColumnModel().getColumn(4).setPreferredWidth(245);
			table_1.getColumnModel().getColumn(5).setPreferredWidth(99);
			scrollPane_2.setViewportView(table_1);
			modeloGerencPed2 = (DefaultTableModel) table_1.getModel();
			
			modeloGerencPed.removeRow(0);
			modeloGerencPed2.removeRow(0);
			
			btnFinalizarEntrega = new JButton("Finalizar Entrega");
			btnFinalizarEntrega.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int remov=contEntrega;					
					for (int i=remov; i>=0;i--){
						System.out.println("Numero da linha removida = "+i+"/n Valor pego na tabela = "+modeloGerencPed.getValueAt(i,6).toString());
						if(modeloGerencPed.getValueAt(i,6).toString().equals("true")){
							modeloGerencPed2.addRow(new String[] { modeloGerencPed.getValueAt(i,0).toString(), modeloGerencPed.getValueAt(i,1).toString(),
									modeloGerencPed.getValueAt(i,2).toString(), modeloGerencPed.getValueAt(i,3).toString(),
									modeloGerencPed.getValueAt(i,4).toString(), modeloGerencPed.getValueAt(i,5).toString()});
							formato2 = new SimpleDateFormat("hh:mm:ss");
							Date data2 = new Date();
							String comandosql4 = "UPDATE `erp`.`delivery` SET `status` = '" + "Fechado"
									  + "', `horario` = '" + formato2.format(data2)
									  + "' WHERE `delivery`.`numeroVenda` = '" + modeloGerencPed.getValueAt(i,0).toString()+ "'";
							x.grava(comandosql4);
							modeloGerencPed.removeRow(i);
							contEntrega--;							
						}
						else {
							
						}
					}
				}
			});
			
			btnFinalizarEntrega.setIcon(new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606685_678117-window-system-128.png")));
			btnFinalizarEntrega.setBounds(704, 272, 151, 32);
			panelHistoricoVenda.add(btnFinalizarEntrega);
			
			label_21 = new JLabel("");
			label_21.setIcon(new ImageIcon(Vendas.class.getResource("/papel_parede/(2).png")));
			label_21.setOpaque(true);
			label_21.setHorizontalTextPosition(SwingConstants.CENTER);
			label_21.setHorizontalAlignment(SwingConstants.CENTER);
			label_21.setForeground(Color.BLACK);
			label_21.setBounds(0, 0, 1355, 668);
			panelHistoricoVenda.add(label_21);
			
			tabbedPaneVendas.addTab("Painel de Vendas ",
			        new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")), panelPainelVendas, null);
			tabbedPaneVendas.addTab("Gerenciador de mesas ",
			        new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),panelGerencMesas, null);
			tabbedPaneVendas.addTab("Clientes ",
					new ImageIcon( Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),panelCadastrarCliente, null);			
			
			caminhoC = new JTextField();
			caminhoC.setVisible(false);
			caminhoC.setSelectionColor(SystemColor.textHighlight);
			caminhoC.setHorizontalAlignment(SwingConstants.CENTER);
			caminhoC.setForeground(Color.BLACK);
			caminhoC.setFont(new Font("Kalinga", Font.PLAIN, 14));
			caminhoC.setColumns(10);
			caminhoC.setBounds(34, 631, 64, 32);
			panelCadastrarCliente.add(caminhoC);
			tabbedPaneVendas.addTab("Delivery ",
					new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),panelDelivery, null);
			tabbedPaneVendas.addTab("Gerenciamento de Entregas",
					new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606844_file-zip-128.png")), panelHistoricoVenda, null);
			tabbedPaneVendas.addTab("Relatórios", 
					new ImageIcon(Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),panelRelatorios, null);

			VendasController.contLinha = 0;
			VendasController.valorT = 0.0;
			VendasController.ValorF = 0.0;
			
			//this.setSize(new Dimension(1366, 768));
			this.setSize(toolkit.getScreenSize());
			this.setVisible(true);
			this.setLocationRelativeTo(null);

		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Vendas.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Vendas.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Vendas.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Vendas.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
	}
	
	protected static void AtualizarFotoCliente() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);

		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
			Vendas.fotoCliente.setIcon(new javax.swing.ImageIcon(img));
			Vendas.fotoCliente.setText("");
			Vendas.caminhoC.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
			            .replace("\\", "~").toString());
			System.out.print(diretorio);
			String comandosql4 = "UPDATE `erp`.`clientes` SET `imagem` = '" +Vendas.caminhoC.getText()	
					  + "' WHERE `clientes`.`codigo` = '" + ModelVendas.getCodigoCliente()+ "'";
			x.grava(comandosql4);
			JOptionPane.showMessageDialog(null, "Imagem atualizada com sucesso!", "Atualizar Imagem",JOptionPane.PLAIN_MESSAGE);			
		}	
		
	}

	protected static void SelecionarFotoCliente() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);

		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
			Vendas.fotoCliente.setIcon(new javax.swing.ImageIcon(img));
			Vendas.fotoCliente.setText("");
			Vendas.caminhoC.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
			            .replace("\\", "~").toString());
			System.out.print(diretorio);
			
		}			
	}

	private void AtualizarItensVendaveis() {
		comboProduto.removeAllItems();
		String sql = "select * from produtos order by nome";
		ResultSet rs = x.Consultar(sql);
		try {
			if (Inicio.rd == 0) {
				comboProduto.addItem("");
				while (rs.next()) {
					if(Double.parseDouble(rs.getString("estoqueAtual"))>0){
					comboProduto.addItem(rs.getString("nome"));
					}
				}
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	private void AtualizarItensVendaveisDelivery() {
		comboProduto3.removeAllItems();
		String sql = "select * from produtos order by nome";
		ResultSet rs = x.Consultar(sql);
		try {			
			comboProduto3.addItem("");
			while (rs.next()) {
				if(Double.parseDouble(rs.getString("estoqueAtual"))>0)
				comboProduto3.addItem(rs.getString("nome"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	protected static void SetarEditavelTrue() {
		lblPor.setVisible(false);
		comboBox.setVisible(false);

		nome3.setEnabled(true);
		nome3.setEditable(true);
		nascimento3.setEnabled(true);
		nascimento3.setEditable(true);
		nacionalidade3.setEnabled(true);
		nacionalidade3.setEditable(true);
		rg3.setEnabled(true);
		rg3.setEditable(true);
		cpf3.setEnabled(true);
		cpf3.setEditable(true);
		comboEstadoCivil.setVisible(true);
		email3.setEnabled(true);
		email3.setEditable(true);
		nomePai3.setEnabled(true);
		nomePai3.setEditable(true);
		nomeMae3.setEnabled(true);
		nomeMae3.setEditable(true);
		telefone3.setEnabled(true);
		telefone3.setEditable(true);
		telefone23.setEnabled(true);
		telefone23.setEditable(true);
		celular3.setEnabled(true);
		celular3.setEditable(true);
		celular23.setEnabled(true);
		celular23.setEditable(true);
		logradouro3.setEnabled(true);
		logradouro3.setEditable(true);
		numero3.setEnabled(true);
		numero3.setEditable(true);
		complemento3.setEnabled(true);
		complemento3.setEditable(true);
		bairro3.setEnabled(true);
		bairro3.setEditable(true);
		comboUf3.setVisible(true);
		comboCidade3.setVisible(true);
		cep3.setEnabled(true);
		cep3.setEditable(true);
		autorizados3.setEnabled(true);
		autorizados3.setEditable(true);
		autorizados3.setVisible(false);
		radioSim.setVisible(true);
		radioNao.setVisible(true);

		btconsultar.setEnabled(false);
		scrollPane1.setVisible(false);

	}
	
	protected static void SetarEditavelFalso() {
		lblPor.setVisible(true);
		comboBox.setVisible(true);
		codigoCliente3.setDisabledTextColor(Color.BLACK);
		codigoCliente3.setEnabled(false);
		codigoCliente3.setEditable(false);
		nome3.setDisabledTextColor(Color.BLACK);
		nome3.setEnabled(false);
		nome3.setEditable(false);
		nascimento3.setDisabledTextColor(Color.BLACK);
		nascimento3.setEnabled(false);
		nascimento3.setEditable(false);
		nacionalidade3.setDisabledTextColor(Color.BLACK);
		nacionalidade3.setEnabled(false);
		nacionalidade3.setEditable(false);
		rg3.setDisabledTextColor(Color.BLACK);
		rg3.setEnabled(false);
		rg3.setEditable(false);
		cpf3.setDisabledTextColor(Color.BLACK);
		cpf3.setEnabled(false);
		cpf3.setEditable(false);
		comboEstadoCivil.setVisible(false);
		email3.setDisabledTextColor(Color.BLACK);
		email3.setEnabled(false);
		email3.setEditable(false);
		nomePai3.setDisabledTextColor(Color.BLACK);
		nomePai3.setEnabled(false);
		nomePai3.setEditable(false);
		nomeMae3.setDisabledTextColor(Color.BLACK);
		nomeMae3.setEnabled(false);
		nomeMae3.setEditable(false);
		telefone3.setDisabledTextColor(Color.BLACK);
		telefone3.setEnabled(false);
		telefone3.setEditable(false);
		telefone23.setDisabledTextColor(Color.BLACK);
		telefone23.setEnabled(false);
		telefone23.setEditable(false);
		celular3.setDisabledTextColor(Color.BLACK);
		celular3.setEnabled(false);
		celular3.setEditable(false);
		celular23.setDisabledTextColor(Color.BLACK);
		celular23.setEnabled(false);
		celular23.setEditable(false);
		logradouro3.setDisabledTextColor(Color.BLACK);
		logradouro3.setEnabled(false);
		logradouro3.setEditable(false);
		numero3.setDisabledTextColor(Color.BLACK);
		numero3.setEnabled(false);
		numero3.setEditable(false);
		complemento3.setDisabledTextColor(Color.BLACK);
		complemento3.setEnabled(false);
		complemento3.setEditable(false);
		bairro3.setDisabledTextColor(Color.BLACK);
		bairro3.setEnabled(false);
		bairro3.setEditable(false);
		comboUf3.setVisible(false);
		ufConsulta.setVisible(true);
		cidadeConsulta.setVisible(true);
		comboCidade3.setVisible(false);
		cep3.setDisabledTextColor(Color.BLACK);
		cep3.setEnabled(false);
		cep3.setEditable(false);
		autorizados3.setVisible(true);
		autorizados3.setDisabledTextColor(Color.BLACK);
		autorizados3.setEnabled(false);
		autorizados3.setEditable(false);
		radioSim.setVisible(false);
		radioNao.setVisible(false);
		salvar.setEnabled(false);
		btconsultar.setEnabled(true);
		lblcadastrarDependentes.setText("*AUTORIZADOS");
		scrollPane1.setVisible(true);
	}
	
	protected static void LimparVenda() {
		valorTotal1.setText("0.0");
		valorPago1.setText("0.0");
		comboCliente.setSelectedItem("");
		cpf1.setText("");
		telefone1.setText("");
		labelIcone_4.setIcon(new ImageIcon(Vendas.class
		            .getResource("/icones1_48px/1425606663_image-128.png")));
		for (int i = 0; i < VendasController.contLinha; i++) {
			modelo.removeRow(0);
		}
		VendasController.contLinha = 0;
		VendasController.CalcularTotal();
		VendasController.CalcularParcela();
		VendasController.CalcularParcelamento();
		VendasController.CalcularTroco();
	}
	
	private static void Animacao() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					char c = str.charAt(0);
					String rest = str.substring(1);
					str = rest + c;
					labelAnime.setText("                 " + str + "                 ");
					try {
						Thread.sleep(750);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	protected static void TabelaVendas() {
		modelo.removeRow(0);
		modeloDelivery.removeRow(0);
	}
	
	protected static void PegaMesa() {
		if (mesa.equals("mesa1")) {
			if (ms == 1) {
				btMesa1.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn1 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 1");
			}
			else if (ms == 2) {
				btMesa1.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa1.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}

			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa2")) {
			if (ms == 1) {
				btMesa2.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn2 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 2");
			}

			else if (ms == 2) {
				btMesa2.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa2.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa3")) {
			if (ms == 1) {
				btMesa3.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn3 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 3");
			}

			else if (ms == 2) {
				btMesa3.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa3.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa4")) {
			if (ms == 1) {
				btMesa4.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn4 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 4");
			}

			else if (ms == 2) {
				btMesa4.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa4.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa5")) {
			if (ms == 1) {
				btMesa5.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn5 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 5");
			}

			else if (ms == 2) {
				btMesa5.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa5.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa6")) {
			if (ms == 1) {
				btMesa6.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn6 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 6");
			}

			else if (ms == 2) {
				btMesa6.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa6.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa7")) {
			if (ms == 1) {
				btMesa7.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn7 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 7");
			}

			else if (ms == 2) {
				btMesa7.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa7.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa8")) {
			if (ms == 1) {
				btMesa8.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn8 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 8");
			}

			else if (ms == 2) {
				btMesa8.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa8.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa9")) {
			if (ms == 1) {
				btMesa9.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn9 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 9");
			}

			else if (ms == 2) {
				btMesa9.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa9.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa10")) {
			if (ms == 1) {
				btMesa10.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn10 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 10");
			}

			else if (ms == 2) {
				btMesa10.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa10.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa11")) {
			if (ms == 1) {
				btMesa11.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn11 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 11");
			}

			else if (ms == 2) {
				btMesa11.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa11.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa12")) {
			if (ms == 1) {
				btMesa12.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn12 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 12");
			}

			else if (ms == 2) {
				btMesa12.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa12.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa13")) {
			if (ms == 1) {
				btMesa13.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn13 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 13");
			}

			else if (ms == 2) {
				btMesa13.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa13.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa14")) {
			if (ms == 1) {
				btMesa14.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn14 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 14");
			}

			else if (ms == 2) {
				btMesa14.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa14.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa15")) {
			if (ms == 1) {
				btMesa15.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn15 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 15");
			}

			else if (ms == 2) {
				btMesa15.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa15.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa16")) {
			if (ms == 1) {
				btMesa16.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn16 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 16");
			}

			else if (ms == 2) {
				btMesa16.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa16.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa17")) {
			if (ms == 1) {
				btMesa17.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn17 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 17");
			}

			else if (ms == 2) {
				btMesa17.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa17.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa18")) {
			if (ms == 1) {
				btMesa18.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn18 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 18");
			}

			else if (ms == 2) {
				btMesa18.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa18.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa19")) {
			if (ms == 1) {
				btMesa19.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn19 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 19");
			}

			else if (ms == 2) {
				btMesa19.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa19.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa20")) {
			if (ms == 1) {
				btMesa20.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn20 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 20");
			}

			else if (ms == 2) {
				btMesa20.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa20.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa21")) {
			if (ms == 1) {
				btMesa21.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn1 = 21;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 21");
			}

			else if (ms == 2) {
				btMesa21.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa21.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa22")) {
			if (ms == 1) {
				btMesa22.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn22 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 22");
			}

			else if (ms == 2) {
				btMesa22.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa22.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa23")) {
			if (ms == 1) {
				btMesa23.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn23 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 23");
			}

			else if (ms == 2) {
				btMesa23.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa23.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa24")) {
			if (ms == 1) {
				btMesa24.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn24 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 24");
			}

			else if (ms == 2) {
				btMesa24.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa24.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa25")) {
			if (ms == 1) {
				btMesa25.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn25 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 25");
			}

			else if (ms == 2) {
				btMesa25.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa25.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa26")) {
			if (ms == 1) {
				btMesa26.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn26 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 26");
			}

			else if (ms == 2) {
				btMesa26.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa26.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa27")) {
			if (ms == 1) {
				btMesa27.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn27 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 27");
			}

			else if (ms == 2) {
				btMesa27.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa27.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa28")) {
			if (ms == 1) {
				btMesa28.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn28 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 28");
			}

			else if (ms == 2) {
				btMesa28.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa28.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa29")) {
			if (ms == 1) {
				btMesa29.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn29 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 29");
			}

			else if (ms == 2) {
				btMesa29.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa29.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa30")) {
			if (ms == 1) {
				btMesa30.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn30 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 30");
			}

			else if (ms == 2) {
				btMesa30.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa30.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa31")) {
			if (ms == 1) {
				btMesa31.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn31 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 31");
			}

			else if (ms == 2) {
				btMesa31.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa31.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa32")) {
			if (ms == 1) {
				btMesa32.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn32 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 32");
			}

			else if (ms == 2) {
				btMesa32.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa32.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa33")) {
			if (ms == 1) {
				btMesa33.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn33 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 33");
			}

			else if (ms == 2) {
				btMesa33.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa33.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa34")) {
			if (ms == 1) {
				btMesa34.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn34 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 34");
			}

			else if (ms == 2) {
				btMesa34.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa34.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa35")) {
			if (ms == 1) {
				btMesa35.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn35 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 35");
			}

			else if (ms == 2) {
				btMesa35.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa35.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa36")) {
			if (ms == 1) {
				btMesa36.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn36 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 36");
			}

			else if (ms == 2) {
				btMesa36.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa36.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa37")) {
			if (ms == 1) {
				btMesa37.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn37 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 37");
			}

			else if (ms == 2) {
				btMesa37.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa37.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa38")) {
			if (ms == 1) {
				btMesa38.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn38 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 38");
			}

			else if (ms == 2) {
				btMesa38.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa38.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa39")) {
			if (ms == 1) {
				btMesa39.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn39 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 39");
			}

			else if (ms == 2) {
				btMesa39.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa39.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}

		else if (mesa.equals("mesa40")) {
			if (ms == 1) {
				btMesa40.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/fechar_40px.png")));
				btn40 = 1;
				PainelMesas ob = new PainelMesas();
				ob.SetarMesa("* MESA 40");
			}

			else if (ms == 2) {
				btMesa40.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/reservar_40px.png")));
			}

			else if (ms == 3) {
				btMesa40.setIcon(new ImageIcon(Vendas.class
				            .getResource("/imagens_principais/abrir_40px.png")));
			}
			internalFrame_2.dispose();
		}
		AbrirMesa.setSelected(false);
		ReservarMesa.setSelected(false);
		FecharMesa.setSelected(false);
	}	/*
	
	 * protected static void MapsInterno() {
	 * 
	 * Browser browser = BrowserFactory.createBrowser();
	 * internalFrame_1.getContentPane().add(browser.getComponent(),
	 * BorderLayout.CENTER); browser.navigate("http://maps.google.com.br");
	 * 
	 * }
	 */
	public static void LimparCliente() {
		comboBox.setSelectedItem("");
		codigoCliente3.setText("");
		nome3.setText("");
		nascimento3.setText("");
		nacionalidade3.setText("");
		rg3.setText("");
		cpf3.setText("");
		comboEstadoCivil.setSelectedItem("");
		email3.setText("");
		nomePai3.setText("");
		nomeMae3.setText("");
		autorizados3.setText("");
		telefone3.setText("");
		celular3.setText("");
		telefone23.setText("");
		celular23.setText("");
		logradouro3.setText("");
		numero3.setText("");
		complemento3.setText("");
		bairro3.setText("");
		comboUf3.setSelectedItem("");
		comboCidade3.setSelectedItem("");
		cep3.setText("");
		autorizados3.setText("");

		Vendas.button.setEnabled(false);
		Vendas.button_3.setEnabled(false);
		Vendas.button_7.setEnabled(false);
		Vendas.button_6.setEnabled(false);
		btnAtualizar.setEnabled(false);
	}
	
	
	
	private static void TabelaHistorico() {
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(707, 66, 621, 558);
		panelRelatorios.add(scrollPane_1);

		Tabela_hist = new JTable();
		Tabela_hist.setForeground(Color.BLACK);
		Tabela_hist.setSelectionBackground(SystemColor.scrollbar);
		Tabela_hist.setFont(new Font("Kalinga", Font.PLAIN, 14));
		Tabela_hist.setSurrendersFocusOnKeystroke(true);
		Tabela_hist.setShowVerticalLines(true);
		Tabela_hist.setShowHorizontalLines(true);
		Tabela_hist.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null,
		            null, null, null, null }, }, new String[] { "LOCAL", "N DA VENDA", "DATA ",
		            "HORA", "VENDEDOR", "CLIENTE", "FORM. PAG.", "VALOR" }) {
			/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { true, false, true, true, true, true,
			                                      true, true };

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
	
	protected static void FormaPagamento() {
		if (form.equals("Cartao de Credito")) {
			radioAmerican.setVisible(true);
			radioMaster.setVisible(true);
			radioVisa.setVisible(true);
			labelSelecionarCartao.setVisible(true);
			labelBanco.setVisible(false);
			numeroCheque1.setVisible(false);
			labelNumeroCheque.setVisible(false);
			banco1.setVisible(false);
			labelAgencia.setVisible(false);
			agencia1.setVisible(false);
			labelNumeroConta.setVisible(false);
			numeroConta1.setVisible(false);
			labelDadosCheque.setVisible(false);
		}
		else if (form.equals("Cheque")) {
			labelBanco.setVisible(true);
			numeroCheque1.setVisible(true);
			labelNumeroCheque.setVisible(true);
			banco1.setVisible(true);
			labelAgencia.setVisible(true);
			agencia1.setVisible(true);
			labelNumeroConta.setVisible(true);
			numeroConta1.setVisible(true);
			labelDadosCheque.setVisible(true);
			radioAmerican.setVisible(false);
			radioMaster.setVisible(false);
			radioVisa.setVisible(false);
			labelSelecionarCartao.setVisible(false);
		}
		else {
			radioAmerican.setVisible(false);
			radioMaster.setVisible(false);
			radioVisa.setVisible(false);
			labelSelecionarCartao.setVisible(false);
			labelBanco.setVisible(false);
			numeroCheque1.setVisible(false);
			labelNumeroCheque.setVisible(false);
			banco1.setVisible(false);
			labelAgencia.setVisible(false);
			agencia1.setVisible(false);
			labelNumeroConta.setVisible(false);
			numeroConta1.setVisible(false);
			labelDadosCheque.setVisible(false);
		}
	}

	protected static void SelecionarPapelParedeVendas() {
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

			// labelFundoAbrirCaixa.setIcon(new
			// javax.swing.ImageIcon(diretorio));
			caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
			            .replace("\\", "~").toString());
			System.out.print(diretorio);
		}
	}
}
