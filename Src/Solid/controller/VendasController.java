package Solid.controller;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Solid.model.ModelSuprimentos;
import Solid.model.ModelVendas;
import Solid.view.Menu;
import Solid.view.Vendas;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class VendasController {
	
	public static NumberFormat	nf;
	
	static BancoDados			x		= new BancoDados();
	static ResultSet			dados;
	static SimpleDateFormat		formato;
	static SimpleDateFormat		formato2;
	private static double		vlTotal1;
	private static double		valorT;
	private static double		parcela;
	private static double		troco;
	private static double		ValorF;
	protected static int		par;
	protected static int		M;
	public static int			gatilho1	= 0;
	public static int			contLinha	= 0, contLinha2 = 0;
	public static int			tipo;
	private static String		Tipo;
	public static double		pv		= 0, PrCusto = 0, estAtual;
	
	public static void AbrirVendas() {
		try {
			
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			new Vendas();
			SetarPaineis(Menu.painel);
			
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
	
	private static void SetarPaineis(int seq) {
		try {
			
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			if (seq == 1) {
				Vendas.tabbedPaneVendas.removeAll();
				Vendas.tabbedPaneVendas
						.addTab("Painel de Vendas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")),
								Vendas.panelPainelVendas, null);
				Vendas.tabbedPaneVendas
						.addTab("Gerenciador de mesas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),
								Vendas.panelGerencMesas, null);
				Vendas.tabbedPaneVendas
						.addTab("Clientes ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),
								Vendas.panelCadastrarCliente, null);
				Vendas.tabbedPaneVendas
						.addTab("Delivery ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),
								Vendas.panelDelivery, null);
				Vendas.tabbedPaneVendas
						.addTab("Relatórios",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Vendas.panelRelatorios, null);
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				
			}
			else if (seq == 2) {
				Vendas.tabbedPaneVendas.removeAll();
				Vendas.tabbedPaneVendas
						.addTab("Gerenciador de mesas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),
								Vendas.panelGerencMesas, null);
				Vendas.tabbedPaneVendas
						.addTab("Painel de Vendas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")),
								Vendas.panelPainelVendas, null);
				Vendas.tabbedPaneVendas
						.addTab("Clientes ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),
								Vendas.panelCadastrarCliente, null);
				Vendas.tabbedPaneVendas
						.addTab("Delivery ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),
								Vendas.panelDelivery, null);
				Vendas.tabbedPaneVendas
						.addTab("Relatórios",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Vendas.panelRelatorios, null);
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				
			}
			else if (seq == 3) {
				Vendas.tabbedPaneVendas.removeAll();
				Vendas.tabbedPaneVendas
						.addTab("Clientes ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),
								Vendas.panelCadastrarCliente, null);
				Vendas.tabbedPaneVendas
						.addTab("Painel de Vendas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")),
								Vendas.panelPainelVendas, null);
				Vendas.tabbedPaneVendas
						.addTab("Gerenciador de mesas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),
								Vendas.panelGerencMesas, null);
				Vendas.tabbedPaneVendas
						.addTab("Delivery ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),
								Vendas.panelDelivery, null);
				Vendas.tabbedPaneVendas
						.addTab("Relatórios",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Vendas.panelRelatorios, null);
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			}
			else if (seq == 4) {
				Vendas.tabbedPaneVendas.removeAll();
				Vendas.tabbedPaneVendas
						.addTab("Delivery ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),
								Vendas.panelDelivery, null);
				Vendas.tabbedPaneVendas
						.addTab("Painel de Vendas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")),
								Vendas.panelPainelVendas, null);
				Vendas.tabbedPaneVendas
						.addTab("Gerenciador de mesas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),
								Vendas.panelGerencMesas, null);
				Vendas.tabbedPaneVendas
						.addTab("Clientes ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),
								Vendas.panelCadastrarCliente, null);
				Vendas.tabbedPaneVendas
						.addTab("Relatórios",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Vendas.panelRelatorios, null);
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			}
			else if (seq == 5) {
				Vendas.tabbedPaneVendas.removeAll();
				Vendas.tabbedPaneVendas
						.addTab("Relatórios",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Vendas.panelRelatorios, null);
				Vendas.tabbedPaneVendas
						.addTab("Painel de Vendas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606602_678131-money-128.png")),
								Vendas.panelPainelVendas, null);
				Vendas.tabbedPaneVendas
						.addTab("Gerenciador de mesas ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606605_678077-computer-128.png")),
								Vendas.panelGerencMesas, null);
				Vendas.tabbedPaneVendas
						.addTab("Clientes ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606736_678130-profile-alt-4-128.png")),
								Vendas.panelCadastrarCliente, null);
				Vendas.tabbedPaneVendas
						.addTab("Delivery ",
								new ImageIcon(
										Vendas.class.getResource("/icones1_24px/1425606557_678111-map-marker-128.png")),
								Vendas.panelDelivery, null);
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			}
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
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Vendas"
	
	public static void AddItem() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		int linha = 0, achou = 0;
		
		if (ModelVendas.getItem1().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
		}
		
		else if (contLinha == linha) {
			int quant = (Integer.parseInt(ModelVendas.getQuant()));
			valorT = 0;
			valorT = quant * Vendas.precoUnitario;
			
			vlTotal1 = vlTotal1 + valorT;
			ModelVendas.setValortotal(String.valueOf(nf.format(vlTotal1)));
			contLinha++;
			Vendas.modelo.addRow(new String[] { String.valueOf(contLinha), Vendas.codProd,
					ModelVendas.getItem1(), ModelVendas.getQuant(),
					String.valueOf(Vendas.precoUnitario),
					String.valueOf(nf.format(valorT)) });
			Vendas.contitem1.setText(String.valueOf(contLinha));
			
			System.out.println("numero de linha" + contLinha);
			ModelVendas.setQuant(String.valueOf("1"));
		}
		
		else {
			for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
				if (ModelVendas.getItem1().equals((String) ModelVendas.getDescricao())) {
					int quant2 = (Integer.parseInt(ModelVendas.getQuant()))
							+ (Integer.parseInt((String) ModelVendas.getQuantidade()));
					valorT = 0;
					achou = 1;
					valorT = quant2 * Vendas.precoUnitario;
					vlTotal1 = vlTotal1 + valorT - Vendas.precoUnitario;
					ModelVendas.setValortotal(String.valueOf(nf.format(vlTotal1)));
					
					ModelVendas.setQuantidade(String.valueOf(nf.format(quant2)));
					ModelVendas.setTotal(String.valueOf(nf.format(valorT)));
					
					ModelVendas.setQuant(String.valueOf("1"));
					System.out.println(String.valueOf(valorT));
					System.out.println("numero da linha" + 1);
					CalcularParcela();
					CalcularParcelamento();
					CalcularTroco();
				}
			}
			if (achou == 0) {
				int quant = (Integer.parseInt(ModelVendas.getQuant()));
				valorT = 0;
				valorT = quant * Vendas.precoUnitario;
				
				vlTotal1 = vlTotal1 + valorT;
				ModelVendas.setValortotal(String.valueOf(nf.format(vlTotal1)));
				contLinha++;
				Vendas.modelo.addRow(new String[] { String.valueOf(contLinha),
						Vendas.codProd, ModelVendas.getItem1(), ModelVendas.getQuant(),
						String.valueOf(Vendas.precoUnitario),
						String.valueOf(nf.format(valorT)) });
				Vendas.contitem1.setText(String.valueOf(contLinha));
				
				System.out.println("numero de linhas" + contLinha);
				ModelVendas.setQuant(String.valueOf("1"));
				CalcularParcela();
				CalcularParcelamento();
				CalcularTroco();
			}
		}
		CalcularTotal();
		CalcularParcela();
		CalcularParcelamento();
		CalcularTroco();
		Vendas.labelIcone_4.setIcon(new ImageIcon(Vendas.class
				.getResource("/icones1_48px/1425606663_image-128.png")));
		ModelVendas.setQuant(String.valueOf("1"));
		ModelVendas.setItem1("");
		Vendas.str = "                       Bem vindo ao S-One !!!                       ";
	}
	
	public static void RemoverItem() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		M = 0;
		if (ModelVendas.getRemove().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
		}
		else {
			if (contLinha == 1) {
				if ((Integer) ModelVendas.getQuantRemove() > Integer
						.parseInt((String) Vendas.modelo.getValueAt(contLinha - 1, 3))) {
					JOptionPane.showMessageDialog(null,
							"Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
							JOptionPane.WARNING_MESSAGE);
					Vendas.QuantidadeRem.requestFocus();
					M = 1;
				}
				else if ((Integer) ModelVendas.getQuantRemove()
						- Integer.parseInt((String) Vendas.modelo.getValueAt(
								contLinha - 1, 3)) == 0
						&& M == 0) {
					contLinha--;
					Vendas.modelo.removeRow(contLinha);
					Vendas.labelIcone_4.setIcon(new ImageIcon(Vendas.class
							.getResource("/icones1_48px/1425606663_image-128.png")));
				}
				else {
					for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
						
						if (ModelVendas.getRemove().equals(ModelVendas.getDescricao())
								&& M == 0) {
							
							if ((Integer) ModelVendas.getQuantRemove() > Integer
									.parseInt((String) ModelVendas
											.getQuantidade())) {
								JOptionPane.showMessageDialog(
										null,
										"Quantidade Maior qua a existente na tabela!",
										"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
								Vendas.QuantidadeRem.requestFocus();
								M = 1;
							}
							else if ((Integer) ModelVendas.getQuantRemove()
									- Integer.parseInt((String) ModelVendas
											.getQuantidade()) == 0
									&& M == 0) {
								contLinha--;
								Vendas.modelo.removeRow(ModelVendas.linha);
							}
							else {
								ModelVendas.setQuantidade((String
										.valueOf(nf.format(Integer
												.parseInt((String) ModelVendas
														.getQuantidade())
												- (Integer) ModelVendas
														.getQuantRemove()))));
								ModelVendas.setTotal((String
										.valueOf(nf.format(Integer
												.parseInt((String) ModelVendas
														.getQuantidade())
												* (Double.parseDouble((String) ModelVendas
														.getPrecoUnitario()))))));
							}
						}
					}
				}
			}
			else {
				for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
					if (ModelVendas.getRemove().equals(ModelVendas.getDescricao())
							&& M == 0) {
						if ((Integer) ModelVendas.getQuantRemove() > Integer
								.parseInt((String) ModelVendas.getQuantidade())) {
							JOptionPane.showMessageDialog(
									null,
									"Quantidade Maior qua a existente na tabela!",
									"ATENCAO", JOptionPane.WARNING_MESSAGE);
							M = 1;
						}
					}
					if (ModelVendas.getRemove().equals(ModelVendas.getDescricao())
							&& M == 0) {
						
						if ((Integer) ModelVendas.getQuantRemove()
								- Integer.parseInt((String) ModelVendas
										.getQuantidade()) == 0
								&& M == 0) {
							contLinha--;
							Vendas.modelo.removeRow(ModelVendas.linha);
							for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
								Vendas.modelo.setValueAt(ModelVendas.linha + 1,
										ModelVendas.linha, 0);
							}
						}
						
						else {
							ModelVendas.setQuantidade((String.valueOf(nf
									.format(Integer.parseInt((String) ModelVendas
											.getQuantidade())
											- (Integer) ModelVendas
													.getQuantRemove()))));
							ModelVendas.setTotal((String.valueOf(nf.format(Integer
									.parseInt((String) ModelVendas
											.getQuantidade())
									* (Double.parseDouble((String) ModelVendas
											.getPrecoUnitario()))))));
						}
					}
				}
			}
			VendasController.CalcularTotal();
			VendasController.CalcularParcela();
			VendasController.CalcularParcelamento();
			VendasController.CalcularTroco();
			Vendas.QuantidadeRem.requestFocus();
			if (M == 0) {
				Vendas.internalFrame.setVisible(false);
				Vendas.QuantidadeRem.setValue(1);
			}
		}
	}
	
	public static void CalcularTroco() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		troco = 0;
		if (par <= 1)
			troco = ((Double.parseDouble(ModelVendas.getValorPago()) - ValorF));
		
		else
			troco = (Double.parseDouble(ModelVendas.getValorPago()) - parcela);
		
		ModelVendas.setTroco(String.valueOf(nf.format(troco)));
	}
	
	public static void CalcularTotal() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		valorT = 0;
		ValorF = 0;
		for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
			valorT = valorT
					+ (Double.parseDouble((String) ModelVendas.getPrecoUnitario()) * Integer
							.parseInt((String) ModelVendas.getQuantidade()));
			ValorF = (valorT - Double.parseDouble(ModelVendas.getDesconto()));
		}
		ModelVendas.setValortotal(String.valueOf(nf.format(valorT)));
		ModelVendas.setValorFinal(String.valueOf(nf.format(ValorF)));
	}
	
	public static void CalcularParcelamento() {
		
		nf.setMaximumFractionDigits(2);
		parcela = ValorF / par;
		ModelVendas.setValorParcelado(ModelVendas.getParcelamento() + " "
				+ String.valueOf((nf.format(parcela))));
		ModelVendas.setValorFinal(String.valueOf(nf.format(valorT
				- Double.parseDouble(ModelVendas.getDesconto()))));
	}
	
	public static void CalcularParcela() {
		if (ModelVendas.getParcelamento().equals("1x")) {
			par = 1;
		}
		else if (ModelVendas.getParcelamento().equals("2x")) {
			par = 2;
		}
		else if (ModelVendas.getParcelamento().equals("3x")) {
			par = 3;
		}
		else if (ModelVendas.getParcelamento().equals("4x")) {
			par = 4;
		}
		else if (ModelVendas.getParcelamento().equals("5x")) {
			par = 5;
		}
		else if (ModelVendas.getParcelamento().equals("6x")) {
			par = 6;
		}
		else if (ModelVendas.getParcelamento().equals("7x")) {
			par = 7;
		}
		else if (ModelVendas.getParcelamento().equals("8x")) {
			par = 8;
		}
		else if (ModelVendas.getParcelamento().equals("9x")) {
			par = 9;
		}
		else if (ModelVendas.getParcelamento().equals("10x")) {
			par = 10;
		}
		else if (ModelVendas.getParcelamento().equals("11x")) {
			par = 11;
		}
		else if (ModelVendas.getParcelamento().equals("12x")) {
			par = 12;
		}
	}
	
	public static void SalvarVenda() {
		if (contLinha > 0) {
			String comandosql = "INSERT INTO `erp`.`venda` (`numeroVenda`, `data`, `hora`, `vendedor`, `nomeCliente`, `cpf`, `telefone`, `formaPagamento`, `parcelamento`, `banco`, `numeroCheque`, `agencia`, `valorTotal`, `desconto`, `valorFinal`, `valorParcelado`, `valorPago`, `troco`, `localVenda`)"
					+ "VALUES('"
					+ ModelVendas.getNumeroVenda()
					+ "','"
					+ ModelVendas.getDataVenda()
					+ "','"
					+ ModelVendas.getHoraVenda()
					+ "','"
					+ ModelVendas.getVendedor()
					+ "','"
					+ ModelVendas.getNomecliente()
					+ "','"
					+ ModelVendas.getCpf()
					+ "','"
					+ ModelVendas.getTelefone()
					+ "','"
					+ ModelVendas.getFormaPagamento()
					+ "','"
					+ ModelVendas.getParcelamento()
					+ "','"
					+ ModelVendas.getBanco()
					+ "','"
					+ ModelVendas.getNumeroCheque()
					+ "','"
					+ ModelVendas.getAgencia()
					+ "','"
					+ ModelVendas.getValortotal()
					+ "','"
					+ ModelVendas.getDesconto()
					+ "','"
					+ ModelVendas.getValorParcelado()
					+ "','"
					+ ModelVendas.getValorFinal()
					+ "','"
					+ ModelVendas.getValorPago()
					+ "','" + ModelVendas.getTroco() + "','" + "Balcão" + "')";
			x.grava(comandosql);
			
			for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
				String comandosql7 = "INSERT INTO itensvenda(numeroVenda, item, codigoItem, descricao, quantidade, precoUnitario, total) "
						+ "VALUES('"
						+ ModelVendas.getNumeroVenda()
						+ "','"
						+ ModelVendas.getItem()
						+ "','"
						+ ModelVendas.getCodigoItem()
						+ "','"
						+ ModelVendas.getDescricao()
						+ "','"
						+ ModelVendas.getQuantidade()
						+ "','"
						+ ModelVendas.getPrecoUnitario()
						+ "','"
						+ ModelVendas.getTotal() + "')";
				x.grava(comandosql7);
			}
			
			int d = Integer.parseInt(ModelVendas.getNumeroVenda());
			d++;
			String comandosql4 = "UPDATE  `erp`.`contadores` SET  `numeroVenda` =  '"
					+ String.valueOf(d) + "' WHERE  `contadores`.`numeroVenda` =  '"
					+ ModelVendas.getNumeroVenda() + "'";
			x.grava(comandosql4);
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
					"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
			
			for (int i = 0; i < contLinha; i++) {
				Vendas.modelo.removeRow(0);
			}
			contLinha = 0;
			Vendas.valorTotal1.setText("0.0");
			Vendas.valorPago1.setText("0.0");
			Vendas.comboCliente.setSelectedItem("");
			Vendas.cpf1.setText("");
			Vendas.telefone1.setText("");
			Vendas.labelIcone_4.setIcon(new ImageIcon(Vendas.class
					.getResource("/icones1_48px/1425606663_image-128.png")));
			VendasController.CalcularParcela();
			VendasController.CalcularParcelamento();
			VendasController.CalcularTroco();
			
			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				Vendas.numeroVenda1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				Vendas.numeroVenda1.setEditable(false);
				
				while (rs3.next()) {
					Vendas.numeroVenda1.setText(rs3.getString("numeroVenda"));
				}
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Não há nenhum item selecionado!",
					"Mensagem do Sistema", JOptionPane.WARNING_MESSAGE);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Mesas"
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Cliente"
	
	public static void SalvarCliente() {
		String comandosql = "INSERT INTO clienteS(codigo, nome, dataNascimento, nacionalidade, rg, cpf, estadoCivil, email, nomePai, nomeMae, telefone1, telefone2, celular1, celular2, logradouro, numero, complemento, bairro, estado, cidade, cep, autorizacaoExtra) "
				+ "VALUES('"
				+ ModelVendas.getCodigoCliente()
				+ "','"
				+ ModelVendas.getNomeCliente()
				+ "','"
				+ ModelVendas.getDataNascimentoCliente()
				+ "','"
				+ ModelVendas.getNacionalidadeCliente()
				+ "','"
				+ ModelVendas.getRgCliente()
				+ "','"
				+ ModelVendas.getCpfCliente()
				+ "','"
				+ ModelVendas.getEstadoCivilCliente()
				+ "','"
				+ ModelVendas.getEmailCliente()
				+ "','"
				+ ModelVendas.getNomePaiCliente()
				+ "','"
				+ ModelVendas.getNomeMaeCliente()
				+ "','"
				+ ModelVendas.getTelefone1()
				+ "','"
				+ ModelVendas.getTelefone2()
				+ "','"
				+ ModelVendas.getCelular1()
				+ "','"
				+ ModelVendas.getCelular2()
				+ "','"
				+ ModelVendas.getLogradouroCliente()
				+ "','"
				+ ModelVendas.getNumero()
				+ "','"
				+ ModelVendas.getComplemento()
				+ "','"
				+ ModelVendas.getBairro()
				+ "','"
				+ ModelVendas.getEstado()
				+ "','"
				+ ModelVendas.getCidade()
				+ "','"
				+ ModelVendas.getCep() + "','" + ModelVendas.getAutorizacaoExtra() + "')";
		
		String aux = ModelVendas.getCodigoCliente();
		int d = Integer.parseInt(aux);
		d++;
		aux = String.valueOf(d);
		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoCliente` =  '" + aux
				+ "' WHERE " + " `contadores`.`codigoCliente` =  '"
				+ ModelVendas.getCodigoCliente() + "'";
		x.grava(comandosql4);
		
		x.grava(comandosql);
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
				"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
		
		Vendas.LimparCliente();
		
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			Vendas.codigoCliente3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			Vendas.codigoCliente3.setEditable(false);
			while (rs3.next()) {
				ModelVendas.setCodigoCliente(rs3.getString("codigoCliente"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void ConsultarCliente() {
		if (Vendas.comboBox.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, " Selecione um parâmetro para a consulta. ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if (Vendas.comboBox.getSelectedItem().toString().equals("Código de Cliente")) {
			dados = x.Consultar("select*from clientes where codigo = '"
					+ ModelVendas.getCodigoCliente() + "'");
			gatilho1 = 1;
			Tipo = "código";
		}
		else if (Vendas.comboBox.getSelectedItem().toString().equals("Telefone")) {
			dados = x.Consultar("select*from clientes where telefone1 = '"
					+ ModelSuprimentos.getNomeProduto() + "'");
			gatilho1 = 1;
			Tipo = "telefone";
		}
		else if (Vendas.comboBox.getSelectedItem().toString().equals("CPF")) {
			dados = x.Consultar("select*from clientes where cpf = '"
					+ ModelSuprimentos.getNumeroLoteProd() + "'");
			gatilho1 = 1;
			Tipo = "CPF";
		}
		
		if (gatilho1 == 1) {
			
			Vendas.LimparCliente();
			try { // while(dados.next())
				// {
				dados.next();
				ModelVendas.setNomeCliente(dados.getString("nome"));
				ModelVendas.setDataNascimentoCliente(dados.getString("dataNascimento"));
				ModelVendas.setNacionalidadeCliente(dados.getString("nacionalidade"));
				ModelVendas.setRgCliente(dados.getString("rg"));
				ModelVendas.setCpfCliente(dados.getString("cpf"));
				ModelVendas.setEstadoCivilCliente(dados.getString("estadoCivil"));
				ModelVendas.setEmailCliente(dados.getString("email"));
				ModelVendas.setNomePaiCliente(dados.getString("nomePai"));
				ModelVendas.setNomeMaeCliente(dados.getString("nomeMae"));
				ModelVendas.setTelefone1(dados.getString("telefone1"));
				ModelVendas.setTelefone2(dados.getString("telefone2"));
				ModelVendas.setCelular1(dados.getString("celular1"));
				ModelVendas.setCelular2(dados.getString("celular2"));
				ModelVendas.setLogradouroCliente(dados.getString("logradouro"));
				ModelVendas.setNumero(dados.getString("numero"));
				ModelVendas.setComplemento(dados.getString("complemento"));
				ModelVendas.setBairro(dados.getString("bairro"));
				ModelVendas.setEstado(dados.getString("estado"));
				ModelVendas.setCidade(dados.getString("cidade"));
				ModelVendas.setCep(dados.getString("cep"));
				ModelVendas.setAutorizacaoExtra(dados.getString("autorizacaoExtra"));
				ModelVendas.setCodigoCliente(dados.getString("codigo"));
				
				Vendas.button.setEnabled(true);
				Vendas.button_3.setEnabled(true);
				Vendas.button_7.setEnabled(true);
				Vendas.button_6.setEnabled(true);
				
			}
			catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro + " O " + Tipo
						+ " digitado não existe! Tente outro " + Tipo + "  ",
						"Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho1 = 0;
				
			}
		}
	}
	
	public static void AtualizarCliente() {
		String comandosql4 = "UPDATE `erp`.`clientes` SET `nome` = '"
				+ ModelVendas.getNomeCliente() + "', `dataNascimento` = '"
				+ ModelVendas.getDataNascimentoCliente() + "', `nacionalidade` = '"
				+ ModelVendas.getNacionalidadeCliente() + "', `rg` = '"
				+ ModelVendas.getRgCliente() + "', `cpf` = '" + ModelVendas.getCpfCliente()
				+ "', `estadoCivil` = '" + ModelVendas.getEstadoCivilCliente()
				+ "', `email` = '" + ModelVendas.getEmailCliente() + "', `nomePai` = '"
				+ ModelVendas.getNomePaiCliente() + "', `nomeMae` = '"
				+ ModelVendas.getNomeMaeCliente() + "', `telefone1` = '"
				+ ModelVendas.getTelefone1() + "', `telefone2` = '"
				+ ModelVendas.getTelefone2() + "', `celular1` = '"
				+ ModelVendas.getCelular1() + "', `celular2` = '"
				+ ModelVendas.getCelular2() + "', `logradouro` = '"
				+ ModelVendas.getLogradouroCliente() + "', `numero` = '"
				+ ModelVendas.getNumero() + "', `complemento` = '"
				+ ModelVendas.getComplemento() + "', `bairro` = '"
				+ ModelVendas.getBairro() + "', `estado` = '" + ModelVendas.getEstado()
				+ "', `cidade` = '" + ModelVendas.getCidade() + "', `cep` = '"
				+ ModelVendas.getCep() + "' WHERE `clientes`.`codigo` = '"
				+ ModelVendas.getCodigoCliente() + "'";
		x.grava(comandosql4);
		JOptionPane.showMessageDialog(null, " Dados Atualizados com sucesso !", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Delivery"
	
	public static void ClientDelivery() {
		ResultSet dados = x.Consultar("select*from clientes where telefone1 = '"
				+ ModelVendas.getTelefoneDel() + "'");
		try { // while(dados.next())
			// {
			dados.next();
			ModelVendas.setCpfDel(dados.getString("cpf"));
			ModelVendas.setNomeDel(dados.getString("nome"));
			ModelVendas.setEnderecoDel(dados.getString("logradouro"));
			ModelVendas.setNumeroDel(dados.getString("numero"));
			ModelVendas.setComplementoDel(dados.getString("complemento"));
			ModelVendas.setBairroDel(dados.getString("bairro"));
			ModelVendas.setCidadeDel(dados.getString("cidade"));
			ModelVendas.setCodigoDel(dados.getString("codigo"));
			
		}
		catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro
					+ " Cliente não Existente,\n         tente outro numero!    ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
			Vendas.telefone4.setText(null);
			Vendas.telefone4.requestFocus();
		}
	}
	
	public static void AddItemDelivery() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		int linha = 0, achou = 0;
		
		if (ModelVendas.getItemDelivery1().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
		}
		
		else if (contLinha2 == linha) {
			int quant = (Integer.parseInt(ModelVendas.getQuantDelivery()));
			valorT = 0;
			valorT = quant * Vendas.precoUnitario2;
			ModelVendas.setValorFinalDelivery(String
					.valueOf(nf.format(Double.parseDouble(Vendas.valorFinalDelivery
							.getText().replace(",", "."))
							+ (Integer.parseInt(ModelVendas.getQuantDelivery()) * Vendas.precoUnitario2))));
			contLinha2++;
			Vendas.modeloDelivery.addRow(new String[] { String.valueOf(contLinha2),
					Vendas.codProd2, ModelVendas.getItemDelivery1(),
					ModelVendas.getQuantDelivery(),
					String.valueOf(Vendas.precoUnitario2),
					String.valueOf(nf.format(valorT)) });
			// Vendas.contitem1.setText(String.valueOf(contLinha));
			
			System.out.println("numero de linha" + contLinha2);
			ModelVendas.setQuantDelivery(String.valueOf("1"));
		}
		
		else {
			for (ModelVendas.linha = 0; ModelVendas.linha < contLinha2; ModelVendas.linha++) {
				if (ModelVendas.getItemDelivery1().equals(
						(String) ModelVendas.getDescricaoDelivery())) {
					
					int quant2 = (Integer.parseInt(ModelVendas.getQuantDelivery()))
							+ (Integer.parseInt((String) ModelVendas
									.getQuantidadeDelivery()));
					valorT = 0;
					achou = 1;
					valorT = quant2 * Vendas.precoUnitario2;
					ModelVendas.setValorFinalDelivery(String
							.valueOf(nf.format(Double
									.parseDouble(Vendas.valorFinalDelivery
											.getText().replace(",", "."))
									+ (Integer.parseInt(ModelVendas
											.getQuantDelivery()) * Vendas.precoUnitario2))));
					ModelVendas.setQuantidadeDelivery(String.valueOf(nf.format(quant2)));
					ModelVendas.setTotalDelivery(String.valueOf(nf.format(valorT)));
					
					ModelVendas.setQuantDelivery(String.valueOf("1"));
					
					System.out.println("numero da linha" + 1);
					
					// CalcularParcela();
					// CalcularParcelamento();
					// CalcularTroco();
				}
				
			}
			if (achou == 0) {
				int quant = (Integer.parseInt(ModelVendas.getQuantDelivery()));
				valorT = 0;
				valorT = quant * Vendas.precoUnitario2;
				
				ModelVendas.setValorFinalDelivery(String
						.valueOf(nf.format(Double.parseDouble(Vendas.valorFinalDelivery
								.getText().replace(",", "."))
								+ (Integer.parseInt(ModelVendas.getQuantDelivery()) * Vendas.precoUnitario2))));
				contLinha2++;
				Vendas.modeloDelivery.addRow(new String[] { String.valueOf(contLinha2),
						Vendas.codProd2, ModelVendas.getItemDelivery1(),
						ModelVendas.getQuantDelivery(),
						String.valueOf(Vendas.precoUnitario2),
						String.valueOf(nf.format(valorT)) });
				// Vendas.contitem1.setText(String.valueOf(contLinha));
				
				System.out.println("numero de linhas" + contLinha2);
				ModelVendas.setQuantDelivery(String.valueOf("1"));
				// CalcularParcela();
				// CalcularParcelamento();
				// CalcularTroco();
			}
		}
		ModelVendas.setItemDelivery1("");
	}
	
	public static void RemoverItemDelivery() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		M = 0;
		if (ModelVendas.getRemoveDelivery().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
		}
		else {
			if (contLinha2 == 1) {
				if ((Integer) ModelVendas.getQuantRemoveDelivery() > Integer
						.parseInt((String) Vendas.modeloDelivery.getValueAt(
								contLinha2 - 1, 3))) {
					JOptionPane.showMessageDialog(null,
							"Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
							JOptionPane.WARNING_MESSAGE);
					Vendas.spinnerRemove.requestFocus();
					M = 1;
				}
				else if ((Integer) ModelVendas.getQuantRemoveDelivery()
						- Integer.parseInt((String) Vendas.modeloDelivery.getValueAt(
								contLinha2 - 1, 3)) == 0
						&& M == 0) {
					contLinha2--;
					Vendas.modeloDelivery.removeRow(contLinha2);
					ModelVendas.setValorFinalDelivery("0.00");
				}
				else {
					for (ModelVendas.linha = 0; ModelVendas.linha < contLinha2; ModelVendas.linha++) {
						if (ModelVendas.getRemoveDelivery().equals(
								ModelVendas.getDescricaoDelivery())
								&& M == 0) {
							if ((Integer) ModelVendas.getQuantRemoveDelivery() > Integer
									.parseInt((String) ModelVendas
											.getQuantidadeDelivery())) {
								JOptionPane.showMessageDialog(
										null,
										"Quantidade Maior qua a existente na tabela!",
										"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
								Vendas.spinnerRemove.requestFocus();
								M = 1;
							}
							else if ((Integer) ModelVendas.getQuantRemoveDelivery()
									- Integer.parseInt((String) ModelVendas
											.getQuantidadeDelivery()) == 0
									&& M == 0) {
								ModelVendas.setValorFinalDelivery(String
										.valueOf(Double.parseDouble(ModelVendas
												.getValorFinalDelivery())
												- ((Integer) ModelVendas
														.getQuantRemoveDelivery() * (Double
														.parseDouble((String) ModelVendas
																.getPrecoUnitarioDelivery()
																.replace(",",
																		"."))))));
								contLinha2--;
								Vendas.modeloDelivery.removeRow(ModelVendas.linha);
								
							}
							else {
								ModelVendas.setValorFinalDelivery(String
										.valueOf(Double.parseDouble(ModelVendas
												.getValorFinalDelivery()
												.replace(",", "."))
												- ((Integer) ModelVendas
														.getQuantRemoveDelivery() * (Double
														.parseDouble((String) ModelVendas
																.getPrecoUnitarioDelivery()
																.replace(",",
																		"."))))));
								
								ModelVendas.setQuantidadeDelivery((String
										.valueOf(nf.format(Integer
												.parseInt((String) ModelVendas
														.getQuantidadeDelivery())
												- (Integer) ModelVendas
														.getQuantRemoveDelivery()))));
								ModelVendas.setTotalDelivery((String
										.valueOf(nf.format(Integer
												.parseInt((String) ModelVendas
														.getQuantidadeDelivery())
												* (Double.parseDouble((String) ModelVendas
														.getPrecoUnitarioDelivery()))))));
								
							}
						}
					}
				}
			}
			else {
				for (ModelVendas.linha = 0; ModelVendas.linha < contLinha2; ModelVendas.linha++) {
					if (ModelVendas.getRemoveDelivery().equals(
							ModelVendas.getDescricaoDelivery())
							&& M == 0) {
						if ((Integer) ModelVendas.getQuantRemoveDelivery() > Integer
								.parseInt((String) ModelVendas
										.getQuantidadeDelivery())) {
							JOptionPane.showMessageDialog(
									null,
									"Quantidade Maior qua a existente na tabela!",
									"ATENCAO", JOptionPane.WARNING_MESSAGE);
							M = 1;
						}
					}
					if (ModelVendas.getRemoveDelivery().equals(
							ModelVendas.getDescricaoDelivery())
							&& M == 0) {
						
						if ((Integer) ModelVendas.getQuantRemoveDelivery()
								- Integer.parseInt((String) ModelVendas
										.getQuantidadeDelivery()) == 0
								&& M == 0) {
							ModelVendas.setValorFinalDelivery(String.valueOf(Double
									.parseDouble(ModelVendas
											.getValorFinalDelivery().replace(
													",", "."))
									- (Double.parseDouble(ModelVendas
											.getTotalDelivery().replace(",",
													".")))));
							contLinha2--;
							Vendas.modeloDelivery.removeRow(ModelVendas.linha);
							for (ModelVendas.linha = 0; ModelVendas.linha < contLinha2; ModelVendas.linha++) {
								Vendas.modeloDelivery.setValueAt(
										ModelVendas.linha + 1,
										ModelVendas.linha, 0);
							}
						}
						
						else {
							ModelVendas.setValorFinalDelivery(String
									.valueOf(Double.parseDouble(ModelVendas
											.getValorFinalDelivery().replace(
													",", "."))
											- ((Integer) ModelVendas
													.getQuantRemoveDelivery() * (Double
													.parseDouble((String) ModelVendas
															.getPrecoUnitarioDelivery()
															.replace(",",
																	"."))))));
							ModelVendas.setQuantidadeDelivery((String
									.valueOf(nf.format(Integer
											.parseInt((String) ModelVendas
													.getQuantidadeDelivery())
											- (Integer) ModelVendas
													.getQuantRemoveDelivery()))));
							ModelVendas.setTotalDelivery((String
									.valueOf(nf.format(Integer
											.parseInt((String) ModelVendas
													.getQuantidadeDelivery())
											* (Double.parseDouble((String) ModelVendas
													.getPrecoUnitarioDelivery()))))));
						}
					}
				}
			}
			
			Vendas.spinnerRemove.requestFocus();
			if (M == 0) {
				Vendas.internalFrame_3.setVisible(false);
				Vendas.spinnerRemove.setValue(1);
			}
		}
	}
	
	public static void CalcularTrocoDelivery() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		ModelVendas.setTrocoDelivery(String.valueOf(nf
				.format((Double.parseDouble(ModelVendas.getValorPagoDelivery().replace(",",
						".")))
						- (Double.parseDouble(ModelVendas.getValorFinalDelivery()
								.replace(",", "."))))));
		
	}
	
	public static void SalvarPedido() {
		formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date();
		
		formato2 = new SimpleDateFormat("hh:mm:ss");
		Date data2 = new Date();
		String comandosql = "INSERT INTO `erp`.`venda` (`numeroVenda`, `data`, `hora`, `vendedor`, `nomeCliente`, `cpf`, `telefone`, `formaPagamento`, `parcelamento`, `banco`, `numeroCheque`, `agencia`, `valorTotal`, `desconto`, `valorFinal`, `valorParcelado`, `valorPago`, `troco`, `localVenda`)"
				+ "VALUES('"
				+ ModelVendas.getNumeroVendaDel()
				+ "','"
				+ formato.format(data)
				+ "','"
				+ formato2.format(data2)
				+ "','"
				+ ModelVendas.getVendedor()
				+ "','"
				+ ModelVendas.getNomeDel()
				+ "','"
				+ ModelVendas.getCpfDel()
				+ "','"
				+ ModelVendas.getTelefoneDel()
				+ "','"
				+ ModelVendas.getFormaPagamento()
				+ "','"
				+ "Á vista" // Parcelamento
				+ "','"
				+ " *** " // Banco
				+ "','"
				+ " *** " // Numero Cheque
				+ "','"
				+ " *** " // Agencia
				+ "','"
				+ ModelVendas.getValorFinalDelivery()
				+ "','"
				+ " *** " // Desconto
				+ "','"
				+ ModelVendas.getValorFinalDelivery()
				+ "','"
				+ ModelVendas.getValorFinalDelivery()
				+ "','"
				+ ModelVendas.getValorPagoDelivery()
				+ "','"
				+ ModelVendas.getTrocoDelivery() + "','" + "Delivery" + "')";
		x.grava(comandosql);
		
		for (ModelVendas.linha = 0; ModelVendas.linha < contLinha; ModelVendas.linha++) {
			String comandosql7 = "INSERT INTO itensvenda(numeroVenda, item, codigoItem, descricao, quantidade, precoUnitario, total) "
					+ "VALUES('"
					+ ModelVendas.getNumeroVendaDel()
					+ "','"
					+ ModelVendas.getItemDelivery()
					+ "','"
					+ ModelVendas.getCodigoItemDelivery()
					+ "','"
					+ ModelVendas.getDescricaoDelivery()
					+ "','"
					+ ModelVendas.getQuantidadeDelivery()
					+ "','"
					+ ModelVendas.getPrecoUnitarioDelivery()
					+ "','"
					+ ModelVendas.getTotalDelivery() + "')";
			x.grava(comandosql7);
			
		}
	}
}
