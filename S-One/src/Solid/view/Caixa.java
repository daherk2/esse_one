package Solid.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Solid.controller.BancoDados;
import Solid.controller.VendasController;

import java.awt.Cursor;

import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

public class Caixa extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long	serialVersionUID	= 1L;

	// instancia a classe do banco para conexão
	static BancoDados					x				= new BancoDados();

	// variaveis do sistema
	private static JPanel				tabbedPaneAbrirFecharCX;
	int						v				= 0;
	private static JTabbedPane tabbedPane ;
	private static JPanel Abrir,Fechar;
	public static NumberFormat nf;
	
	public static JFormattedTextField formattedTextField_5,formattedTextField_6,formattedTextField_7;
	public static JTextField UserCx;
	public static JTextField UserCx2;
	public static JFormattedTextField DataCx, HoraCx, ValorCx;

	public Caixa() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Caixa.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		setBackground(SystemColor.inactiveCaptionBorder);
		setVisible(true);
		setName("");
		setResizable(false);
		setTitle("ABRIR / FECHAR CAIXA");
		setBounds(100, 100, 753, 453);

		/*
		 * 
		 * Panel Alterar Senha
		 */

		tabbedPaneAbrirFecharCX = new JPanel();
		tabbedPaneAbrirFecharCX.setBackground(SystemColor.inactiveCaptionBorder);
		tabbedPaneAbrirFecharCX.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tabbedPaneAbrirFecharCX);
		tabbedPaneAbrirFecharCX.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabbedPane.setBounds(10, 27, 734, 313);
		tabbedPaneAbrirFecharCX.add(tabbedPane);
		
		Abrir = new JPanel();
		Abrir.setOpaque(false);
		Abrir.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tabbedPane.addTab("ABRIR CAIXA", new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606602_678131-money-128.png")), Abrir, null);
		Abrir.setLayout(null);
		
		DataCx = new JFormattedTextField();
		DataCx.setText("21/11/2014");
		DataCx.setSelectionColor(SystemColor.scrollbar);
		DataCx.setHorizontalAlignment(SwingConstants.CENTER);
		DataCx.setForeground(Color.WHITE);
		DataCx.setFont(new Font("Kalinga", Font.PLAIN, 14));
		DataCx.setFocusTraversalPolicyProvider(true);
		DataCx.setEnabled(false);
		DataCx.setEditable(false);
		DataCx.setDisabledTextColor(Color.BLACK);
		DataCx.setColumns(10);
		DataCx.setAutoscrolls(false);
		DataCx.setBounds(10, 44, 87, 32);
		Abrir.add(DataCx);
		
		HoraCx = new JFormattedTextField();
		HoraCx.setText("02:43:02");
		HoraCx.setSelectionColor(SystemColor.scrollbar);
		HoraCx.setHorizontalAlignment(SwingConstants.CENTER);
		HoraCx.setForeground(Color.WHITE);
		HoraCx.setFont(new Font("Kalinga", Font.PLAIN, 14));
		HoraCx.setFocusTraversalPolicyProvider(true);
		HoraCx.setEnabled(false);
		HoraCx.setEditable(false);
		HoraCx.setDisabledTextColor(Color.BLACK);
		HoraCx.setColumns(10);
		HoraCx.setAutoscrolls(false);
		HoraCx.setBounds(138, 44, 87, 32);
		Abrir.add(HoraCx);
		
		UserCx = new JTextField("");
		UserCx.setSelectionColor(SystemColor.scrollbar);
		UserCx.setHorizontalAlignment(SwingConstants.CENTER);
		UserCx.setForeground(Color.WHITE);
		UserCx.setFont(new Font("Kalinga", Font.PLAIN, 14));
		UserCx.setFocusTraversalPolicyProvider(true);
		UserCx.setEnabled(false);
		UserCx.setEditable(false);
		UserCx.setDisabledTextColor(Color.BLACK);
		UserCx.setColumns(10);
		UserCx.setAutoscrolls(false);
		UserCx.setBounds(273, 44, 389, 32);
		UserCx.setText(Login.User);
		Abrir.add(UserCx);
		
		ValorCx = new JFormattedTextField();
		ValorCx.setText("0,00");
		ValorCx.setSelectionColor(SystemColor.scrollbar);
		ValorCx.setHorizontalAlignment(SwingConstants.CENTER);
		ValorCx.setForeground(Color.BLACK);
		ValorCx.setFont(new Font("Kalinga", Font.BOLD, 18));
		ValorCx.setFocusTraversalPolicyProvider(true);
		ValorCx.setDisabledTextColor(Color.BLACK);
		ValorCx.setColumns(10);
		ValorCx.setAutoscrolls(false);
		ValorCx.setBounds(10, 149, 150, 40);
		ValorCx.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				//ValorCx.setText(ValorCx.getText().replaceAll("[^0-9]", ""));
				// valorTotal1.setText(valorTotal1.getText().replaceAll("[^A-Z | ^a-z]",
				// ""));
			}
		});

		ValorCx.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if (ValorCx.getText().equalsIgnoreCase("0,00"))
					ValorCx.setText("");
				ValorCx.requestFocus(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (ValorCx.getText().equalsIgnoreCase(""))
					ValorCx.setText("0,00");
				ValorCx.requestFocus(false);
			}

		});
		Abrir.add(ValorCx);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setText("02:43:02");
		formattedTextField_3.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_3.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_3.setForeground(Color.WHITE);
		formattedTextField_3.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_3.setFocusTraversalPolicyProvider(true);
		formattedTextField_3.setEnabled(false);
		formattedTextField_3.setEditable(false);
		formattedTextField_3.setDisabledTextColor(Color.BLACK);
		formattedTextField_3.setColumns(10);
		formattedTextField_3.setAutoscrolls(false);
		formattedTextField_3.setBounds(346, 149, 87, 32);
		Abrir.add(formattedTextField_3);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setText("02:43:02");
		formattedTextField_4.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_4.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_4.setForeground(Color.WHITE);
		formattedTextField_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_4.setFocusTraversalPolicyProvider(true);
		formattedTextField_4.setEnabled(false);
		formattedTextField_4.setEditable(false);
		formattedTextField_4.setDisabledTextColor(Color.BLACK);
		formattedTextField_4.setColumns(10);
		formattedTextField_4.setAutoscrolls(false);
		formattedTextField_4.setBounds(501, 149, 87, 32);
		Abrir.add(formattedTextField_4);
		
		JLabel label_1 = new JLabel("Hora");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_1.setAlignmentX(0.5f);
		label_1.setBounds(138, 11, 87, 32);
		Abrir.add(label_1);
		
		JLabel label = new JLabel("Data");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label.setAlignmentX(0.5f);
		label.setBounds(10, 11, 87, 32);
		Abrir.add(label);
		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setForeground(Color.BLACK);
		lblUsurio.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblUsurio.setAlignmentX(0.5f);
		lblUsurio.setBounds(273, 11, 87, 32);
		Abrir.add(lblUsurio);
		
		JLabel lblSaldoInicialR = new JLabel("Saldo Inicial R$");
		lblSaldoInicialR.setForeground(Color.BLACK);
		lblSaldoInicialR.setFont(new Font("Kalinga", Font.BOLD, 18));
		lblSaldoInicialR.setAlignmentX(0.5f);
		lblSaldoInicialR.setBounds(10, 115, 150, 32);
		Abrir.add(lblSaldoInicialR);
		
		JLabel label_4 = new JLabel("Primeiro Movimento");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_4.setAlignmentX(0.5f);
		label_4.setBounds(346, 115, 150, 32);
		Abrir.add(label_4);
		
		JLabel label_5 = new JLabel("Último Movimento");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_5.setAlignmentX(0.5f);
		label_5.setBounds(501, 115, 150, 32);
		Abrir.add(label_5);
		
		JButton btnAb = new JButton("Abrir");
		btnAb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasController.AbrirCaixa();
				Caixa.this.dispose();
				Inicio.janelaCaixa=0;
			}
		});
		btnAb.setIcon(new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606546_678134-sign-check-128.png")));
		btnAb.setToolTipText("alt + Enter");
		btnAb.setMnemonic(KeyEvent.VK_ENTER);
		btnAb.setForeground(Color.BLACK);
		btnAb.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btnAb.setBounds(304, 224, 120, 40);
		Abrir.add(btnAb);
		
		Fechar = new JPanel();
		Fechar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		Fechar.setOpaque(false);
		tabbedPane.addTab("FECHAR CAIXA", new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606733_678080-shield-error-128.png")), Fechar, null);
		Fechar.setLayout(null);
		
		formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setEditable(false);
		formattedTextField_7.setText("0,00");
		formattedTextField_7.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_7.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_7.setForeground(Color.BLACK);
		formattedTextField_7.setFont(new Font("Kalinga", Font.BOLD, 18));
		formattedTextField_7.setFocusTraversalPolicyProvider(true);
		formattedTextField_7.setDisabledTextColor(Color.BLACK);
		formattedTextField_7.setColumns(10);
		formattedTextField_7.setAutoscrolls(false);
		formattedTextField_7.setBounds(10, 149, 150, 40);
		formattedTextField_7.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				//formattedTextField_7.setText(formattedTextField_7.getText().replaceAll("[^0-9]", ""));
				// valorTotal1.setText(valorTotal1.getText().replaceAll("[^A-Z | ^a-z]",
				// ""));
			}
		});

		formattedTextField_7.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if (formattedTextField_7.getText().equalsIgnoreCase("0,00"))
					formattedTextField_7.setText("");
				formattedTextField_7.requestFocus(true);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (formattedTextField_7.getText().equalsIgnoreCase(""))
					formattedTextField_7.setText("0,00");
				formattedTextField_7.requestFocus(false);
			}

		});
		Fechar.add(formattedTextField_7);
		
		JFormattedTextField formattedTextField_8 = new JFormattedTextField();
		formattedTextField_8.setText("21/11/2014");
		formattedTextField_8.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_8.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_8.setForeground(Color.WHITE);
		formattedTextField_8.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_8.setFocusTraversalPolicyProvider(true);
		formattedTextField_8.setEnabled(false);
		formattedTextField_8.setEditable(false);
		formattedTextField_8.setDisabledTextColor(Color.BLACK);
		formattedTextField_8.setColumns(10);
		formattedTextField_8.setAutoscrolls(false);
		formattedTextField_8.setBounds(10, 44, 87, 32);
		Fechar.add(formattedTextField_8);
		
		JFormattedTextField formattedTextField_9 = new JFormattedTextField();
		formattedTextField_9.setText("02:43:02");
		formattedTextField_9.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_9.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_9.setForeground(Color.WHITE);
		formattedTextField_9.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_9.setFocusTraversalPolicyProvider(true);
		formattedTextField_9.setEnabled(false);
		formattedTextField_9.setEditable(false);
		formattedTextField_9.setDisabledTextColor(Color.BLACK);
		formattedTextField_9.setColumns(10);
		formattedTextField_9.setAutoscrolls(false);
		formattedTextField_9.setBounds(138, 44, 87, 32);
		Fechar.add(formattedTextField_9);
		
		UserCx2 = new JTextField("");
		UserCx2.setSelectionColor(SystemColor.scrollbar);
		UserCx2.setHorizontalAlignment(SwingConstants.CENTER);
		UserCx2.setForeground(Color.WHITE);
		UserCx2.setFont(new Font("Kalinga", Font.PLAIN, 14));
		UserCx2.setFocusTraversalPolicyProvider(true);
		UserCx2.setEnabled(false);
		UserCx2.setEditable(false);
		UserCx2.setDisabledTextColor(Color.BLACK);
		UserCx2.setColumns(10);
		UserCx2.setAutoscrolls(false);
		UserCx2.setBounds(273, 44, 389, 32);
		UserCx2.setText(Login.User);
		Fechar.add(UserCx2);
		
		
		JFormattedTextField formattedTextField_10 = new JFormattedTextField();
		formattedTextField_10.setText("02:43:02");
		formattedTextField_10.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_10.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_10.setForeground(Color.WHITE);
		formattedTextField_10.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_10.setFocusTraversalPolicyProvider(true);
		formattedTextField_10.setEnabled(false);
		formattedTextField_10.setEditable(false);
		formattedTextField_10.setDisabledTextColor(Color.BLACK);
		formattedTextField_10.setColumns(10);
		formattedTextField_10.setAutoscrolls(false);
		formattedTextField_10.setBounds(346, 149, 87, 32);
		Fechar.add(formattedTextField_10);
		
		JFormattedTextField formattedTextField_11 = new JFormattedTextField();
		formattedTextField_11.setText("02:43:02");
		formattedTextField_11.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_11.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_11.setForeground(Color.WHITE);
		formattedTextField_11.setFont(new Font("Kalinga", Font.PLAIN, 14));
		formattedTextField_11.setFocusTraversalPolicyProvider(true);
		formattedTextField_11.setEnabled(false);
		formattedTextField_11.setEditable(false);
		formattedTextField_11.setDisabledTextColor(Color.BLACK);
		formattedTextField_11.setColumns(10);
		formattedTextField_11.setAutoscrolls(false);
		formattedTextField_11.setBounds(501, 149, 87, 32);
		Fechar.add(formattedTextField_11);
		
		JLabel lblSaldoFinal = new JLabel("Saldo Final R$");
		lblSaldoFinal.setForeground(Color.BLACK);
		lblSaldoFinal.setFont(new Font("Kalinga", Font.BOLD, 18));
		lblSaldoFinal.setAlignmentX(0.5f);
		lblSaldoFinal.setBounds(10, 115, 150, 32);
		Fechar.add(lblSaldoFinal);
		
		JLabel label_9 = new JLabel("Data");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_9.setAlignmentX(0.5f);
		label_9.setBounds(10, 11, 87, 32);
		Fechar.add(label_9);
		
		JLabel label_10 = new JLabel("Hora");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_10.setAlignmentX(0.5f);
		label_10.setBounds(138, 11, 87, 32);
		Fechar.add(label_10);
		
		JLabel lblUsurio_1 = new JLabel("Usuário");
		lblUsurio_1.setForeground(Color.BLACK);
		lblUsurio_1.setFont(new Font("Kalinga", Font.PLAIN, 14));
		lblUsurio_1.setAlignmentX(0.5f);
		lblUsurio_1.setBounds(273, 11, 87, 32);
		Fechar.add(lblUsurio_1);
		
		JLabel label_12 = new JLabel("Primeiro Movimento");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_12.setAlignmentX(0.5f);
		label_12.setBounds(346, 115, 150, 32);
		Fechar.add(label_12);
		
		JLabel label_13 = new JLabel("Último Movimento");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Kalinga", Font.PLAIN, 14));
		label_13.setAlignmentX(0.5f);
		label_13.setBounds(501, 115, 150, 32);
		Fechar.add(label_13);
		
		JButton btnSalvar = new JButton("Fechar");
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendasController.FecharCaixa();
				Caixa.this.dispose();
			}
		});
		btnSalvar.setIcon(new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606572_678069-sign-error-128.png")));
		btnSalvar.setToolTipText("alt + Enter");
		btnSalvar.setMnemonic(KeyEvent.VK_ENTER);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		btnSalvar.setBounds(304, 224, 120, 40);
		Fechar.add(btnSalvar);
		
		formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setText("0,00");
		formattedTextField_5.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_5.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_5.setForeground(Color.BLACK);
		formattedTextField_5.setFont(new Font("Kalinga", Font.BOLD, 16));
		formattedTextField_5.setFocusTraversalPolicyProvider(true);
		formattedTextField_5.setEnabled(false);
		formattedTextField_5.setEditable(false);
		formattedTextField_5.setDisabledTextColor(Color.BLACK);
		formattedTextField_5.setColumns(10);
		formattedTextField_5.setAutoscrolls(false);
		formattedTextField_5.setBounds(261, 385, 107, 32);
		tabbedPaneAbrirFecharCX.add(formattedTextField_5);
		
		formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setText("0,00");
		formattedTextField_6.setSelectionColor(SystemColor.scrollbar);
		formattedTextField_6.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField_6.setForeground(Color.BLACK);
		formattedTextField_6.setFont(new Font("Kalinga", Font.BOLD, 16));
		formattedTextField_6.setFocusTraversalPolicyProvider(true);
		formattedTextField_6.setEnabled(false);
		formattedTextField_6.setEditable(false);
		formattedTextField_6.setDisabledTextColor(Color.BLACK);
		formattedTextField_6.setColumns(10);
		formattedTextField_6.setAutoscrolls(false);
		formattedTextField_6.setBounds(395, 385, 107, 32);
		tabbedPaneAbrirFecharCX.add(formattedTextField_6);
		
		JLabel label_6 = new JLabel("Entradas");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Kalinga", Font.BOLD, 16));
		label_6.setAlignmentX(0.5f);
		label_6.setBounds(261, 351, 87, 32);
		tabbedPaneAbrirFecharCX.add(label_6);
		
		JLabel label_7 = new JLabel("Saídas");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Kalinga", Font.BOLD, 16));
		label_7.setAlignmentX(0.5f);
		label_7.setBounds(395, 351, 87, 32);
		tabbedPaneAbrirFecharCX.add(label_7);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(SystemColor.inactiveCaptionBorder);
				lblNewLabel.setOpaque(true);
				lblNewLabel.setIcon(new ImageIcon(Caixa.class.getResource("/papel_parede/(3).png")));
				lblNewLabel.setBounds(0, 0, 747, 425);
				tabbedPaneAbrirFecharCX.add(lblNewLabel);

				SetarPaineis();
				
		// janelza centralizada
		this.setLocationRelativeTo(null);
	}

	private void SetarPaineis() {
		Caixa.tabbedPane.removeAll();
		if(Inicio.caixa.equals("fechado")){
			tabbedPane.addTab("ABRIR CAIXA", new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606602_678131-money-128.png")), Abrir, null);
		}
		else{
			nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			tabbedPane.addTab("FECHAR CAIXA", new ImageIcon(Caixa.class.getResource("/icones1_24px/1425606733_678080-shield-error-128.png")), Fechar, null);
			formattedTextField_7.setText(String.valueOf(nf.format(VendasController.saldo)));
			formattedTextField_5.setText(String.valueOf(nf.format(VendasController.entrada)));
			formattedTextField_6.setText(String.valueOf(nf.format(VendasController.saida)));
		}
		
	}
}