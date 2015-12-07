package Solid.controller;

import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Solid.model.ModelSuprimentos;
import Solid.view.Menu;
import Solid.view.Suprimentos;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class SuprimentosController {
	
	// Variaveis de controle
	
	public static int			gatilho1	= 0;
	static int				sn		= 0;
	public static int			contLinha	= 0;
	static int				tipo;
	static double			pv		= 0, PrCusto = 0, estAtual;
	public static NumberFormat	nf;
	static BancoDados			x		= new BancoDados();
	static ResultSet			dados;
	private static String		Tipo;
	
	public static void AbrirSuprimentos() {
		new Suprimentos();
		SetarPaineis(Menu.painel);
	}
	
	public static void SetarPaineis(int seq) {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			if (seq == 1) {
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
				
			}
			else if (seq == 2) {
				
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
				
			}
			else if (seq == 3) {
				
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
				
			}
			else if (seq == 4) {
				
				props.put("logoString", "Solid - One");
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
			}
			
			else if (seq == 5) {
				props.put("logoString", "Solid - One");
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
			}
			
			else if (seq == 6) {
				props.put("logoString", "Solid - One");
				FastLookAndFeel.setCurrentTheme(props);
				UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
				Suprimentos.tabbedPaneSuprimentos.removeAll();
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Relatórios",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								Suprimentos.panelRelatorios, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab(" Estoque ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
								Suprimentos.panelAddproduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Produto ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
								Suprimentos.panelCadastrarProduto, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Matéria Prima ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
								Suprimentos.panelCadastrarMateriaPrima, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Fornecedor ",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606601_book-128.png")),
								Suprimentos.panelFornecedor, null);
				Suprimentos.tabbedPaneSuprimentos
						.addTab("Pedido de Compra",
								new ImageIcon(
										Suprimentos.class
												.getResource("/icones1_24px/1425606565_calendar-128.png")),
								Suprimentos.panelPedidoCompra, null);
				
			}
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
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Produtos"
	
	public static void addItem() {
		
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		int linha2 = 0, achou = 0;
		PrCusto = 0;
		
		if (ModelSuprimentos.getProdutoAdd().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
			
		}
		else if (ModelSuprimentos.getQuantAdd().equals("")) {
			
			JOptionPane.showMessageDialog(null, "Digite a quantidade á adicionar !",
					"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
			
		}
		else if (contLinha == linha2) {
			
			double quant = Double.parseDouble(ModelSuprimentos.getQuantAdd());
			double valorT = 0;
			valorT = quant * ModelSuprimentos.getPrecoUnidadeF();
			PrCusto = PrCusto + valorT;
			System.out.println(ModelSuprimentos.getPrecoUnidadeF());
			ModelSuprimentos.setPrecoCustoProd(String.valueOf(PrCusto));
			contLinha++;
			Suprimentos.contLinha++;
			Suprimentos.modeloficha.addRow(new String[] { String.valueOf(contLinha),
					ModelSuprimentos.getCodigoF(), ModelSuprimentos.getProdutoAdd(),
					ModelSuprimentos.getUnidadeF(),
					String.valueOf(Suprimentos.precoUnidade),
					(String) ModelSuprimentos.getQuantAdd(),
					String.valueOf(valorT).replace(",", ".") });
			ModelSuprimentos.setQuantAdd("");
			System.out.println("numero de linha" + contLinha);
		}
		
		else {
			
			for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
				
				if (ModelSuprimentos.getProdutoAdd().equals(
						(String) ModelSuprimentos.getNomeMp())) {
					
					double quant2 = Double.parseDouble(ModelSuprimentos.getQuantAdd())
							+ (Double.parseDouble((String) ModelSuprimentos
									.getQuantMp()));
					double valorT = 0;
					achou = 1;
					valorT = quant2 * Suprimentos.precoUnidade;
					PrCusto = PrCusto + valorT;
					
					ModelSuprimentos.setPrecoCustoProd(String.valueOf(PrCusto).replace(
							",", "."));
					ModelSuprimentos.setQuantMp(String.valueOf(quant2).replace(",", "."));
					ModelSuprimentos.setCustoAgregado(String.valueOf(PrCusto).replace(
							",", "."));
					ModelSuprimentos.setQuantAdd("");
					System.out.println(String.valueOf(valorT));
					System.out.println("numero da linha" + 1);
				}
			}
			
			if (achou == 0) {
				double quant = Double.parseDouble(ModelSuprimentos.getQuantAdd());
				double valorT = 0;
				valorT = quant * Suprimentos.precoUnidade;
				
				PrCusto = PrCusto + valorT;
				ModelSuprimentos.setPrecoCustoProd(String.valueOf(PrCusto)
						.replace(",", "."));
				contLinha++;
				Suprimentos.contLinha++;
				Suprimentos.modeloficha.addRow(new String[] { String.valueOf(contLinha),
						ModelSuprimentos.getCodigoF(),
						ModelSuprimentos.getProdutoAdd(),
						ModelSuprimentos.getUnidadeF(),
						String.valueOf(Suprimentos.precoUnidade),
						(String) ModelSuprimentos.getQuantAdd(),
						String.valueOf(valorT).replace(",", ".") });
				ModelSuprimentos.setQuantAdd("");
				System.out.println("numero de linhas" + contLinha);
			}
		}
		CalcularCusto();
		ModelSuprimentos.setQuantAdd("");
		ModelSuprimentos.setProdutoAdd("");
		
	}
	
	public static void RemItem() {
		
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		int M = 0;
		if (ModelSuprimentos.getRemoverMp().equals("")) {
			JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO",
					JOptionPane.WARNING_MESSAGE);
		}
		else {
			
			if (contLinha == 1) {
				if (Double.parseDouble(ModelSuprimentos.getQuantRemover()) > Double
						.parseDouble((String) Suprimentos.modeloficha.getValueAt(
								contLinha - 1, 5))) {
					JOptionPane.showMessageDialog(null,
							"Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
							JOptionPane.WARNING_MESSAGE);
					Suprimentos.quantR.requestFocus();
					M = 1;
				}
				
				if (Double.parseDouble(ModelSuprimentos.getQuantRemover())
						- Double.parseDouble((String) Suprimentos.modeloficha
								.getValueAt(contLinha - 1, 5)) == 0
						&& M == 0) {
					contLinha--;
					Suprimentos.modeloficha.removeRow(contLinha);
					Suprimentos.contLinha--;
				}
				
				else {
					for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
						if (ModelSuprimentos.getRemoverMp().equals(
								ModelSuprimentos.getNomeMp())
								&& M == 0) {
							if ((Double.parseDouble(ModelSuprimentos
									.getQuantRemover())) > Double
									.parseDouble((String) ModelSuprimentos
											.getQuantMp())) {
								JOptionPane.showMessageDialog(
										null,
										"Quantidade Maior qua a existente na tabela!",
										"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
								Suprimentos.quantR.requestFocus();
								M = 1;
							}
							
							if (Double.parseDouble(ModelSuprimentos.getQuantRemover())
									- Double.parseDouble((String) ModelSuprimentos
											.getQuantMp()) == 0
									&& M == 0) {
								contLinha--;
								Suprimentos.modeloficha
										.removeRow(ModelSuprimentos.linha);
								Suprimentos.contLinha--;
							}
							
							else {
								ModelSuprimentos
										.setQuantMp((String
												.valueOf(nf.format((Double
														.parseDouble(ModelSuprimentos
																.getQuantMp()) - Double
														.parseDouble(ModelSuprimentos
																.getQuantRemover()))))
												.replace(",", ".")));
								ModelSuprimentos
										.setCustoAgregado(((String
												.valueOf(nf.format(Double
														.parseDouble((String) ModelSuprimentos
																.getQuantMp())
														* (Double.parseDouble(ModelSuprimentos
																.getPrecoMp())))))
												.replace(",", ".")));
							}
						}
					}
				}
			}
			else {
				for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
					if (ModelSuprimentos.getRemoverMp().equals(
							(String) ModelSuprimentos.getNomeMp())
							&& M == 0) {
						if (Double.parseDouble(ModelSuprimentos.getQuantRemover()) > Double
								.parseDouble((String) Suprimentos.modeloficha
										.getValueAt(contLinha - 1, 5))) {
							
							JOptionPane.showMessageDialog(
									null,
									"Quantidade Maior qua a existente na tabela!",
									"ATENÇÃO", JOptionPane.WARNING_MESSAGE);
							M = 1;
						}
					}
					if (ModelSuprimentos.getRemoverMp().equals(
							ModelSuprimentos.getNomeMp())
							&& M == 0) {
						
						if (Double.parseDouble(ModelSuprimentos.getQuantRemover())
								- Double.parseDouble(ModelSuprimentos.getQuantMp()) == 0) {
							contLinha--;
							Suprimentos.contLinha--;
							Suprimentos.modeloficha.removeRow(ModelSuprimentos.linha);
							for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
								Suprimentos.modeloficha.setValueAt(
										ModelSuprimentos.linha + 1,
										ModelSuprimentos.linha, 0);
							}
						}
						
						else {
							ModelSuprimentos
									.setQuantMp((String
											.valueOf(nf.format((Double
													.parseDouble(ModelSuprimentos
															.getQuantMp()) - Double
													.parseDouble(ModelSuprimentos
															.getQuantRemover()))))
											.replace(",", ".")));
							ModelSuprimentos
									.setCustoAgregado(((String
											.valueOf(nf.format(Double
													.parseDouble((String) ModelSuprimentos
															.getQuantMp())
													* (Double.parseDouble(ModelSuprimentos
															.getPrecoMp())))))
											.replace(",", ".")));
						}
					}
				}
			}
			Suprimentos.quantR.requestFocus();
			CalcularCusto();
			if (M == 0) {
				Suprimentos.internalFrame.setVisible(false);
				Suprimentos.quantR.setText("00.00");
			}
		}
	}
	
	public static void CalcularCusto() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		Double valorT = 0.0;
		for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
			valorT = valorT
					+ ((Double.parseDouble((String) ModelSuprimentos.getQuantMp()) * Double
							.parseDouble((String) ModelSuprimentos.getPrecoMp())));
		}
		ModelSuprimentos.setPrecoCustoProd(String.valueOf(nf.format(valorT).replace(",", ".")));
	}
	
	public static void CalcularPreco() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double ipi = Double.parseDouble(ModelSuprimentos.getIpi());
		
		double iss = Double.parseDouble(ModelSuprimentos.getIss());
		
		double pis = Double.parseDouble(ModelSuprimentos.getPis());
		
		double cofins = Double.parseDouble(ModelSuprimentos.getCofins());
		
		double icms = Double.parseDouble(ModelSuprimentos.getIcms());
		
		double custo = Double.parseDouble(ModelSuprimentos.getPrecoCustoProd());
		
		double mLucro = Double.parseDouble(ModelSuprimentos.getMargemLucro());
		
		double imposto = (ipi / 100) + (iss / 100) + (pis / 100) + (cofins / 100)
				+ (icms / 100);
		
		custo = ((custo * imposto) + custo);
		
		pv = (custo * (mLucro / 100)) + custo;
		
		ModelSuprimentos.setPrecoVenda(String.valueOf(nf.format(pv)));
	}
	
	public static void SelecionarFotoProduto() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			Suprimentos.caminho.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,
					Image.SCALE_AREA_AVERAGING);
			Suprimentos.labelFotoProduto.setText(null);
			Suprimentos.labelFotoProduto.setIcon(new ImageIcon(img));
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
		
	}
	
	public static void atualizarImagem() {
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
			Suprimentos.labelFotoProduto.setIcon(new javax.swing.ImageIcon(img));
			Suprimentos.labelFotoProduto.setText("");
			Suprimentos.caminho.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			System.out.print(diretorio);
			String comandosql4 = "UPDATE  `erp`.`produtos` SET  `imagem` =  '"
					+ ModelSuprimentos.getImagemProduto()
					+ "' WHERE  `produtos`.`codigoProduto` = '"
					+ ModelSuprimentos.getCodigoProduto() + "'";
			x.grava(comandosql4);
		}
	}
	
	public static void SalvarProduto() {
		String comandosql = "INSERT INTO produtos(codigoProduto, nome,localEstoque,"
				+ "tipo,unidade,dataCompra,validade,numeroLote,estoqueMinimo,"
				+ "imagem,descricaoproduto,fichaTecnica,precoCusto,ipi,iss,pis,cofins,icms,"
				+ "margemLucro,precoVenda) " + "VALUES('"
				+ ModelSuprimentos.getCodigoProduto()
				+ "','"
				+ ModelSuprimentos.getNomeProduto()
				+ "','"
				+ ModelSuprimentos.getLocalEstoqueProd()
				+ "','"
				+ ModelSuprimentos.getTipoProduto()
				+ "','"
				+ ModelSuprimentos.getUnidadeProduto()
				+ "','"
				+ ModelSuprimentos.getDataCadastro()
				+ "','"
				+ ModelSuprimentos.getValidadeCadastro()
				+ "','"
				+ ModelSuprimentos.getNumeroLoteProd()
				+ "','"
				+ ModelSuprimentos.getEstoqueMin()
				+ "','"
				+ ModelSuprimentos.getImagemProduto()
				+ "','"
				+ ModelSuprimentos.getDescricao()
				+ "','"
				+ ModelSuprimentos.getFichaProduto()
				+ "','"
				+ ModelSuprimentos.getPrecoCustoProd()
				+ "','"
				+ ModelSuprimentos.getIpi()
				+ "','"
				+ ModelSuprimentos.getIss()
				+ "','"
				+ ModelSuprimentos.getPis()
				+ "','"
				+ ModelSuprimentos.getCofins()
				+ "','"
				+ ModelSuprimentos.getIcms()
				+ "','"
				+ ModelSuprimentos.getMargemLucro()
				+ "','"
				+ ModelSuprimentos.getPrecoVenda() + "')";
		
		if (ModelSuprimentos.getFichaProduto().equals("sim")) {
			for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
				String comandosql7 = "INSERT INTO fichatecnica(codigoproduto, numeroitem, codigomp, nome, unidade, preco,quantidade,custoagregado) "
						+ "VALUES('"
						+ ModelSuprimentos.getCodigoProduto()
						+ "','"
						+ ModelSuprimentos.getNumeroItem()
						+ "','"
						+ ModelSuprimentos.getCodigoMp()
						+ "','"
						+ ModelSuprimentos.getNomeMp()
						+ "','"
						+ ModelSuprimentos.getUnidadeMp()
						+ "','"
						+ ModelSuprimentos.getPrecoMp()
						+ "','"
						+ ModelSuprimentos.getQuantMp()
						+ "','"
						+ ModelSuprimentos.getCustoAgregado() + "')";
				x.grava(comandosql7);
			}
		}
		x.grava(comandosql);
		
		int d = Integer.parseInt(ModelSuprimentos.getCodigoProduto());
		d++;
		pv = 0;
		
		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoProduto` =  '"
				+ String.valueOf(d) + "' WHERE  `contadores`.`codigoProduto` =  '"
				+ ModelSuprimentos.getCodigoProduto() + "'";
		x.grava(comandosql4);
		
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
				"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
		
		Suprimentos.limparProduto();
		Suprimentos.nome1.requestFocus();
		
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			Suprimentos.codigo1.setEditable(false);
			while (rs3.next()) {
				ModelSuprimentos.setCodigoProduto(rs3.getString("codigoProduto"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void ConsultarProduto() {
		if (Suprimentos.comboBox_2.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, " Selecione um parâmetro para a consulta. ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if (Suprimentos.comboBox_2.getSelectedItem().toString().equals("Código")) {
			dados = x.Consultar("select*from produtos where codigoProduto = '"
					+ ModelSuprimentos.getCodigoProduto() + "'");
			gatilho1 = 1;
			Tipo = "código";
		}
		else if (Suprimentos.comboBox_2.getSelectedItem().toString().equals("Nome")) {
			dados = x.Consultar("select*from produtos where nome = '"
					+ ModelSuprimentos.getNomeProduto() + "'");
			gatilho1 = 1;
			Tipo = "nome";
		}
		else if (Suprimentos.comboBox_2.getSelectedItem().toString().equals("Lote")) {
			dados = x.Consultar("select*from produtos where numeroLote = '"
					+ ModelSuprimentos.getNumeroLoteProd() + "'");
			gatilho1 = 1;
			Tipo = "lote";
		}
		
		if (gatilho1 == 1) {
			
			Suprimentos.limparProduto();
			try { // while(dados.next())
				// {
				dados.next();
				ModelSuprimentos.setCodigoProduto(dados.getString("codigoProduto"));
				ModelSuprimentos.setNomeProduto(dados.getString("nome"));
				ModelSuprimentos.setLocalEstoqueProd(dados.getString("localEstoque"));
				ModelSuprimentos.setTipoProduto(dados.getString("tipo"));
				ModelSuprimentos.setUnidadeProduto(dados.getString("unidade"));
				ModelSuprimentos.setDataCadastro(dados.getString("dataCompra"));
				ModelSuprimentos.setValidadeCadastro(dados.getString("validade"));
				ModelSuprimentos.setNumeroLoteProd(dados.getString("numeroLote"));
				ModelSuprimentos.setEstoqueMin(dados.getString("estoqueMinimo"));
				Suprimentos.labelFotoProduto.setText("");
				ModelSuprimentos.setImagemProduto(dados.getString("imagem").replace("~",
						"\\"));
				Suprimentos.atualizarImagem.setVisible(true);
				ModelSuprimentos.setDescricao(dados.getString("descricaoProduto"));
				if (dados.getString("codigoProduto").equals(
						ModelSuprimentos.getCodigoProduto())) {
					Suprimentos.AlterarProduto.setEnabled(true);
					Suprimentos.button_1.setEnabled(true);
					Suprimentos.btnAnterior.setEnabled(true);
					Suprimentos.btnProximo.setEnabled(true);
				}
				if (dados.getString("fichaTecnica").equals("sim")) {
					Suprimentos.ficha = "sim";
					ResultSet dados2 = x
							.Consultar("select*from fichatecnica where codigoproduto = '"
									+ dados.getString("codigoProduto") + "'");
					while (dados2.next()) {
						Suprimentos.modeloficha.addRow(new String[] {
								dados2.getString("numeroitem"),
								dados2.getString("codigomp"),
								dados2.getString("nome"),
								dados2.getString("unidade"),
								dados2.getString("preco"),
								dados2.getString("quantidade"),
								dados2.getString("custoagregado") });
						Suprimentos.contLinha++;
						contLinha++;
					}
					Suprimentos.scrollPane.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null,
							"O produto consultado não possui ficha tecnica !",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					
				}
				
				ModelSuprimentos.setPrecoCustoProd(dados.getString("precoCusto"));
				ModelSuprimentos.setIpi(dados.getString("ipi"));
				ModelSuprimentos.setIss(dados.getString("iss"));
				ModelSuprimentos.setPis(dados.getString("pis"));
				ModelSuprimentos.setCofins(dados.getString("cofins"));
				ModelSuprimentos.setIcms(dados.getString("icms"));
				ModelSuprimentos.setMargemLucro(dados.getString("margemLucro"));
				ModelSuprimentos.setPrecoVenda(dados.getString("precoVenda"));
				
			}
			catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, " O " + Tipo
						+ " digitado não existe! Tente outro " + Tipo + "  ",
						"Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho1 = 0;
			}
		}
	}
	
	public static void AtualizarProduto() {
		String comandosql4 = "UPDATE `erp`.`produtos` SET `nome` = '"
				+ ModelSuprimentos.getNomeProduto() + "', `localEstoque` = '"
				+ ModelSuprimentos.getLocalEstoqueProd() + "', `tipo` = '"
				+ ModelSuprimentos.getTipoProduto() + "', `unidade` = '"
				+ ModelSuprimentos.getUnidadeProduto() + "', `dataCompra` = '"
				+ ModelSuprimentos.getDataCadastro() + "', `validade` = '"
				+ ModelSuprimentos.getValidadeCadastro() + "', `numeroLote` = '"
				+ ModelSuprimentos.getNumeroLoteProd() + "', `estoqueMinimo` = '"
				+ ModelSuprimentos.getEstoqueMin() + "', `imagem` = '"
				+ ModelSuprimentos.getImagemProduto() + "', `descricaoProduto` = '"
				+ ModelSuprimentos.getDescricao() + "', `fichaTecnica` = '"
				+ ModelSuprimentos.getFichaProduto() + "', `precoCusto` = '"
				+ ModelSuprimentos.getPrecoCustoProd() + "', `ipi` = '"
				+ ModelSuprimentos.getIpi() + "', `iss` = '" + ModelSuprimentos.getIss()
				+ "', `pis` = '" + ModelSuprimentos.getPis() + "', `cofins` = '"
				+ ModelSuprimentos.getCofins() + "', `icms` = '"
				+ ModelSuprimentos.getIcms() + "', `margemLucro` = '"
				+ ModelSuprimentos.getMargemLucro() + "', `precoVenda` = '"
				+ ModelSuprimentos.getPrecoVenda()
				+ "' WHERE `produtos`.`codigoProduto` = '"
				+ ModelSuprimentos.getCodigoProduto() + "'";
		x.grava(comandosql4);
		
		if (Suprimentos.ficha.equals("sim")) {
			for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
				String comandosql5 = "UPDATE `erp`.`fichatecnica` SET `quantidade` = '"
						+ ModelSuprimentos.getQuantMp() + "', `custoagregado` = '"
						+ ModelSuprimentos.getCustoAgregado()
						+ "' WHERE `fichatecnica`.`codigomp` = '"
						+ ModelSuprimentos.getCodigoMp() + "'";
				x.grava(comandosql5);
			}
		}
		JOptionPane.showMessageDialog(null, " Dados Atualizados com sucesso !", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Materia Prima"
	
	public static void SelecionarImagemMateriaPrima() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			Suprimentos.caminho2.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,
					Image.SCALE_AREA_AVERAGING);
			Suprimentos.labelFotoMateriaPrima.setText(null);
			Suprimentos.labelFotoMateriaPrima.setIcon(new ImageIcon(img));
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
	}
	
	public static void atualizarImagemMP() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			Suprimentos.labelFotoMateriaPrima.setIcon(new javax.swing.ImageIcon(diretorio));
			Suprimentos.labelFotoMateriaPrima.setText("");
			Suprimentos.caminho2.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			System.out.print(diretorio);
			String comandosql4 = "UPDATE  `erp`.`materia_p` SET  `imagem` =  '"
					+ ModelSuprimentos.getImagemMp()
					+ "' WHERE  `materia_p`.`codigo` = '"
					+ ModelSuprimentos.getCodigoMateriaPrima() + "'";
			
			x.grava(comandosql4);
		}
	}
	
	public static void salvarMP() {
		String comandosql = "INSERT INTO materia_p(codigo, nome,localEstoque, tipo, unidade, numeroLote,estoqueAtual, estoqueMinimo, precoUnidade,imagem,descricaoMateriaPrima) "
				+ "VALUES('"
				+ ModelSuprimentos.getCodigoMateriaPrima()
				+ "','"
				+ ModelSuprimentos.getNomeMateriaPrima()
				+ "','"
				+ ModelSuprimentos.getLocalEstoqueMp()
				+ "','"
				+ ModelSuprimentos.getTipoMp()
				+ "','"
				+ ModelSuprimentos.getUnidadeMateriaPrima()
				+ "','"
				+ ModelSuprimentos.getLoteMp()
				+ "','"
				+ "00.00"
				+ "','"
				+ ModelSuprimentos.getEstoqueMinMp()
				+ "','"
				+ ModelSuprimentos.getPrecoUnidade()
				+ "','"
				+ ModelSuprimentos.getImagemMp()
				+ "','"
				+ ModelSuprimentos.getDescricaoMp() + "')";
		x.grava(comandosql);
		
		int d = Integer.parseInt(ModelSuprimentos.getCodigoMateriaPrima());
		d++;
		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoMateriaPrima` =  '"
				+ String.valueOf(d) + "' WHERE  `contadores`.`codigoMateriaPrima` =  '"
				+ ModelSuprimentos.getCodigoMateriaPrima() + "'";
		x.grava(comandosql4);
		
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
				"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
		
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			while (rs3.next()) {
				ModelSuprimentos.setCodigoMateriaPrima(rs3.getString("codigoMateriaPrima"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void ConsultarMP() {
		if (Suprimentos.comboBox_3.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, " Selecione um parâmetro para a consulta. ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if (Suprimentos.comboBox_3.getSelectedItem().toString().equals("Código")) {
			dados = x.Consultar("select*from materia_p where codigo = '"
					+ ModelSuprimentos.getCodigoMateriaPrima() + "'");
			gatilho1 = 1;
			Tipo = "código";
		}
		else if (Suprimentos.comboBox_3.getSelectedItem().toString().equals("Nome")) {
			dados = x.Consultar("select*from materia_p where nome = '"
					+ ModelSuprimentos.getNomeMateriaPrima() + "'");
			gatilho1 = 1;
			Tipo = "nome";
		}
		
		if (gatilho1 == 1) {
			Suprimentos.limparMP();
			try { // while(dados.next())
				// {
				dados.next();
				ModelSuprimentos.setCodigoMateriaPrima(dados.getString("codigo"));
				ModelSuprimentos.setNomeMateriaPrima(dados.getString("nome"));
				ModelSuprimentos.setLocalEstoqueMp(dados.getString("localEstoque"));
				ModelSuprimentos.setTipoMp(dados.getString("tipo"));
				ModelSuprimentos.setUnidadeMateriaPrima(dados.getString("unidade"));
				ModelSuprimentos.setLoteMp(dados.getString("numeroLote"));
				ModelSuprimentos.setEstoqueMinMp(dados.getString("estoqueMinimo"));
				Suprimentos.lblUnidade.setText(dados.getString("unidade"));
				ModelSuprimentos.setPrecoUnidade(dados.getString("precoUnidade"));
				Suprimentos.labelFotoMateriaPrima.setText("");
				ModelSuprimentos.setImagemMp(dados.getString("imagem").replace("~", "\\"));
				Suprimentos.atualizarImagemMP.setVisible(true);
				ModelSuprimentos.setDescricaoMp(dados.getString("descricaoMateriaPrima"));
				
				Suprimentos.button_2.setEnabled(true);
				Suprimentos.button_11.setEnabled(true);
				Suprimentos.btnAnterior2.setEnabled(true);
				Suprimentos.btnProximo2.setEnabled(true);
				
			}
			catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, " O " + Tipo
						+ " digitado não existe! Tente outro " + Tipo + "  ",
						"Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho1 = 0;
			}
		}
	}
	
	public static void AtualizarMateriaPrima() {
		String comandosql4 = "UPDATE `erp`.`materia_p` SET `nome` = '"
				+ ModelSuprimentos.getNomeMateriaPrima() + "', `localEstoque` = '"
				+ ModelSuprimentos.getLocalEstoqueMp() + "', `tipo` = '"
				+ ModelSuprimentos.getTipoMp() + "', `unidade` = '"
				+ ModelSuprimentos.getUnidadeMateriaPrima() + "', `numeroLote` = '"
				+ ModelSuprimentos.getLoteMp() + "', `estoqueMinimo` = '"
				+ ModelSuprimentos.getEstoqueMinMp() + "', `precoUnidade` = '"
				+ ModelSuprimentos.getPrecoUnidade() + "', `descricaoMateriaPrima` = '"
				+ ModelSuprimentos.getDescricaoMp() + "' WHERE `materia_p`.`codigo` = '"
				+ ModelSuprimentos.getCodigoMateriaPrima() + "'";
		x.grava(comandosql4);
		JOptionPane.showMessageDialog(null, " Dados Atualizados com sucesso !", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Fornecedor"
	
	public static void SelecionarImagemFornecedor() {
		JFileChooser selecionarArquivo = new JFileChooser();
		selecionarArquivo.setDialogTitle("Selecione a Imagem");
		String diretorio = "C:";
		File file = new File(String.valueOf("C:"));
		selecionarArquivo.setCurrentDirectory(file);
		
		int retorno = selecionarArquivo.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath();
			Suprimentos.caminho3.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,
					Image.SCALE_AREA_AVERAGING);
			Suprimentos.labelFotoFornecedor.setText(null);
			Suprimentos.labelFotoFornecedor.setIcon(new ImageIcon(img));
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
	}
	
	public static void atualizarImagemFornecedor() {
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
			Suprimentos.labelFotoFornecedor.setText("");
			Suprimentos.labelFotoFornecedor.setIcon(new javax.swing.ImageIcon(img));
			Suprimentos.caminho3.setText(diretorio = selecionarArquivo.getSelectedFile()
					.getAbsolutePath().replace("\\", "~").toString());
			System.out.print(diretorio);
			String comandosql4 = "UPDATE  `erp`.`fornecedor` SET  `imagem` =  '"
					+ ModelSuprimentos.getImagemFornecedor()
					+ "' WHERE  `produtos`.`codigoFornecedor` = '"
					+ ModelSuprimentos.getCodigoFornecedor() + "'";
			
			x.grava(comandosql4);
		}
	}
	
	public static void salvarFornecedor() {
		String comandosql = "INSERT INTO fornecedor(codigoFornecedor, nome,vendedor, endereco, numero, complemento, bairro,estado,cidade,cep,telefone1,telefone2,celular1,celular2,cnpj,inscricaoEstadual,imagem) "
				+ "VALUES('"
				+ ModelSuprimentos.getCodigoFornecedor()
				+ "','"
				+ ModelSuprimentos.getNomeFornecedor()
				+ "','"
				+ ModelSuprimentos.getVendedor()
				+ "','"
				+ ModelSuprimentos.getLogradouroFornecedor()
				+ "','"
				+ ModelSuprimentos.getNumeroFornecedor()
				+ "','"
				+ ModelSuprimentos.getComplementoFornecedor()
				+ "','"
				+ ModelSuprimentos.getBairroFornecedor()
				+ "','"
				+ ModelSuprimentos.getUfFornecedor()
				+ "','"
				+ ModelSuprimentos.getCidadeFornecedor()
				+ "','"
				+ ModelSuprimentos.getCepFornecedor()
				+ "','"
				+ ModelSuprimentos.getTelefone1()
				+ "','"
				+ ModelSuprimentos.getTelefone2()
				+ "','"
				+ ModelSuprimentos.getCelular1()
				+ "','"
				+ ModelSuprimentos.getCelular2()
				+ "','"
				+ ModelSuprimentos.getCnpjFornecedor()
				+ "','"
				+ ModelSuprimentos.getIeFornecedor()
				+ "','"
				+ ModelSuprimentos.getImagemFornecedor() + "')";
		x.grava(comandosql);
		
		int d = Integer.parseInt(ModelSuprimentos.getCodigoFornecedor());
		d++;
		pv = 0;
		
		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoFornecedor` =  '"
				+ String.valueOf(d) + "' WHERE  `contadores`.`codigoFornecedor` =  '"
				+ ModelSuprimentos.getCodigoFornecedor() + "'";
		x.grava(comandosql4);
		
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
				"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
		
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			while (rs3.next()) {
				ModelSuprimentos.setCodigoFornecedor(rs3.getString("codigoFornecedor"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
		Suprimentos.limparFornecedor();
		Suprimentos.NomeFornecedor.requestFocus();
	}
	
	public static void ConsultarFornecedor() {
		if (Suprimentos.comboBox_1.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, " Selecione um parâmetro para a consulta. ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if (Suprimentos.comboBox_1.getSelectedItem().toString().equals("Código")) {
			dados = x.Consultar("select*from fornecedor where codigoFornecedor = '"
					+ ModelSuprimentos.getCodigoFornecedor() + "'");
			gatilho1 = 1;
			Tipo = "código";
		}
		else if (Suprimentos.comboBox_1.getSelectedItem().toString().equals("Nome")) {
			dados = x.Consultar("select*from fornecedor where nome = '"
					+ ModelSuprimentos.getNomeFornecedor() + "'");
			gatilho1 = 1;
			Tipo = "nome";
		}
		else if (Suprimentos.comboBox_1.getSelectedItem().toString().equals("Lote")) {
			dados = x.Consultar("select*from fornecedor where endereco = '"
					+ ModelSuprimentos.getLogradouroFornecedor() + "'");
			gatilho1 = 1;
			Tipo = "endereço";
		}
		
		if (gatilho1 == 1) {
			if (gatilho1 == 1) {
				Suprimentos.limparFornecedor();
				try { // while(dados.next())
					// {
					dados.next();
					ModelSuprimentos.setCodigoFornecedor(dados
							.getString("codigoFornecedor"));
					ModelSuprimentos.setNomeFornecedor(dados.getString("nome"));
					ModelSuprimentos.setVendedor(dados.getString("vendedor"));
					ModelSuprimentos.setLogradouroFornecedor(dados.getString("endereco"));
					ModelSuprimentos.setNumeroFornecedor(dados.getString("numero"));
					ModelSuprimentos.setComplementoFornecedor(dados
							.getString("complemento"));
					ModelSuprimentos.setBairroFornecedor(dados.getString("bairro"));
					ModelSuprimentos.setCidadeFornecedor(dados.getString("cidade"));
					ModelSuprimentos.setUfFornecedor(dados.getString("estado"));
					ModelSuprimentos.setCepFornecedor(dados.getString("cep"));
					ModelSuprimentos.setTelefone1(dados.getString("Telefone1"));
					ModelSuprimentos.setTelefone2(dados.getString("Telefone2"));
					ModelSuprimentos.setCelular1(dados.getString("celular1"));
					ModelSuprimentos.setCelular2(dados.getString("celular2"));
					ModelSuprimentos.setCnpjFornecedor(dados.getString("cnpj"));
					ModelSuprimentos
							.setIeFornecedor(dados.getString("inscricaoEstadual"));
					Suprimentos.labelFotoFornecedor.setText("");
					ModelSuprimentos.setImagemMp(dados.getString("imagem").replace("~",
							"\\"));
					Suprimentos.button_atualizarImagemForn.setVisible(true);
					
					Suprimentos.button_5.setEnabled(true);
					Suprimentos.buttonAnteriorF.setEnabled(true);
					Suprimentos.btnPrximoF.setEnabled(true);
					Suprimentos.button_13.setEnabled(true);
					
				}
				catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, " O " + Tipo
							+ " digitado não existe! Tente outro " + Tipo + "  ",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1 = 0;
				}
			}
		}
	}
	
	public static void AtualizarFornecedor() {
		String comandosql4 = "UPDATE `erp`.`fornecedor` SET `nome` = '"
				+ ModelSuprimentos.getNomeFornecedor() + "', `vendedor` = '"
				+ ModelSuprimentos.getVendedor() + "', `endereco` = '"
				+ ModelSuprimentos.getLogradouroFornecedor() + "', `complemento` = '"
				+ ModelSuprimentos.getComplementoFornecedor() + "', `bairro` = '"
				+ ModelSuprimentos.getBairroFornecedor() + "', `estado` = '"
				+ ModelSuprimentos.getUfFornecedor() + "', `cidade` = '"
				+ ModelSuprimentos.getCidadeFornecedor() + "', `cep` = '"
				+ ModelSuprimentos.getCepFornecedor() + "', `telefone1` = '"
				+ ModelSuprimentos.getTelefone1() + "', `telefone2` = '"
				+ ModelSuprimentos.getTelefone2() + "', `celular1` = '"
				+ ModelSuprimentos.getCelular1() + "', `celular2` = '"
				+ ModelSuprimentos.getCelular2() + "', `cnpj` = '"
				+ ModelSuprimentos.getCnpjFornecedor() + "', `inscricaoEstadual` = '"
				+ ModelSuprimentos.getIeFornecedor()
				+ "' WHERE `fornecedor`.`codigoFornecedor` = '"
				+ ModelSuprimentos.getCodigoFornecedor() + "'";
		x.grava(comandosql4);
		JOptionPane.showMessageDialog(null, " Dados Atualizados com sucesso !", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Metodos da aba "Estoque"
	
	public static void InserirEstoque() {
		String comandosql = "INSERT INTO estoque(codigo, tipo, dataCompra, numeroLote, validade, notaFiscal, quantidade, localEstoque, dataEntrada,codigoFornecedor) "
				+ "VALUES('"
				+ ModelSuprimentos.getCodigo()
				+ "','"
				+ ModelSuprimentos.getTipoItem()
				+ "','"
				+ ModelSuprimentos.getDataEntrada()
				+ "','"
				+ ModelSuprimentos.getLote()
				+ "','"
				+ ModelSuprimentos.getValidade()
				+ "','"
				+ ModelSuprimentos.getNotaFiscal()
				+ "','"
				+ ModelSuprimentos.getQuantidade()
				+ "','"
				+ ModelSuprimentos.getLocalEstoque()
				+ "','"
				+ ModelSuprimentos.getDataEntrada()
				+ "','"
				+ ModelSuprimentos.getCodigoFornc() + "')";
		x.grava(comandosql);
		
		AtualizarQuantEstoque();
		
		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
				"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
	}
	
	public static void ConsultarProdEstoque() {
		if (Suprimentos.radioButton.isSelected() == true) {
			dados = x.Consultar("select*from produtos where codigoProduto = '"
					+ ModelSuprimentos.getCodigo() + "'");
			Tipo = "código";
		}
		else {
			dados = x.Consultar("select*from produtos where nome = '"
					+ ModelSuprimentos.getNomeEstoque() + "'");
			Tipo = "nome";
		}
		
		Suprimentos.limparEstoque();
		
		try { // while(dados.next())
			// {
			dados.next();
			
			ModelSuprimentos.setItem(dados.getString("nome"));
			Suprimentos.precoUnidadeEst.setText(dados.getString("precoVenda"));
			ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
			Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
			Suprimentos.unidadeEst.setText(dados.getString("unidade"));
			Suprimentos.descricaoEst.setText(dados.getString("descricaoProduto"));
			Suprimentos.labelFotoEstoque.setText("");
			ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
			
			if (Double.parseDouble(ModelSuprimentos.getEstoqueAtual()) > Double
					.parseDouble(dados.getString("estoqueMinimo"))) {
				ResultSet dados3 = x.Consultar("select*from estoque where codigo = '"
						+ dados.getString("codigoProduto") + "'");
				dados3.next();
				if (dados3.getString("tipo").equals("produto")) {
					ModelSuprimentos.setCodigo(dados3.getString("codigo"));
					ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
					ModelSuprimentos.setLote(dados3.getString("numeroLote"));
					ModelSuprimentos.setValidade(dados3.getString("validade"));
					ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
					ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
					ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));
					ModelSuprimentos.setDataEntrada(dados3.getString("dataEntrada"));
					ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
					
					dados3 = x.Consultar("select*from fornecedor where codigoFornecedor = '"
							+ ModelSuprimentos.getCodigoFornc() + "'");
					dados3.next();
					ModelSuprimentos.setNomeFornc(dados3.getString("nome"));
					
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"Este produto encontra-se abaixo do estoque minimo !",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			
			if (dados.getString("fichaTecnica").equals("sim")) {
				ResultSet dados2 = x
						.Consultar("select*from fichatecnica where codigoproduto = '"
								+ dados.getString("codigoProduto") + "'");
				while (dados2.next()) {
					Suprimentos.modeloficha2.addRow(new String[] {
							dados2.getString("numeroitem"),
							dados2.getString("codigomp"), dados2.getString("nome"),
							dados2.getString("unidade"), dados2.getString("preco"),
							dados2.getString("quantidade"),
							dados2.getString("custoagregado") });
					Suprimentos.contLinhaEst++;
				}
			}
			else {
				JOptionPane.showMessageDialog(null,
						"Este produto não possui ficha tecnica !", "Atenção",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}
		catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, " O " + Tipo
					+ " digitado não existe! Tente outro " + Tipo + "  ", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	public static void ConsultarMPEstoque() {
		if (Suprimentos.radioButton.isSelected() == true) {
			dados = x.Consultar("select * from materia_p where codigo = '"
					+ ModelSuprimentos.getCodigo() + "'");
			Tipo = "código";
		}
		else {
			dados = x.Consultar("select * from materia_p where nome = '"
					+ ModelSuprimentos.getNomeEstoque() + "'");
			Tipo = "nome";
		}
		
		Suprimentos.limparEstoque();
		
		try { // while(dados.next())
			// {
			dados.next();
			ModelSuprimentos.setItem(dados.getString("nome"));
			Suprimentos.precoUnidadeEst.setText(dados.getString("precoUnidade"));
			ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
			Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
			Suprimentos.unidadeEst.setText(dados.getString("unidade"));
			Suprimentos.descricaoEst.setText(dados.getString("descricaoMateriaPrima"));
			Suprimentos.labelFotoEstoque.setText("");
			ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
			
			if (Double.parseDouble(ModelSuprimentos.getEstoqueAtual()) > Double
					.parseDouble(dados.getString("estoqueMinimo"))) {
				ResultSet dados3 = x.Consultar("select*from estoque where codigo = '"
						+ dados.getString("codigo") + "'");
				dados3.next();
				if (dados3.getString("tipo").equals("materiaPrima")) {
					ModelSuprimentos.setCodigo(dados3.getString("codigo"));
					ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
					ModelSuprimentos.setLote(dados3.getString("numeroLote"));
					ModelSuprimentos.setValidade(dados3.getString("validade"));
					ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
					ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
					ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));
					ModelSuprimentos.setDataEntrada(dados3.getString("dataEntrada"));
					ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
					
					dados3 = x.Consultar("select*from fornecedor where codigoFornecedor = '"
							+ ModelSuprimentos.getCodigoFornc() + "'");
					dados3.next();
					ModelSuprimentos.setNomeFornc(dados3.getString("nome"));
					
				}
			}
			else
				JOptionPane.showMessageDialog(null,
						"Este produto encontra-se abaixo do estoque minimo !",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			
		}
		catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, erro + " O " + Tipo
					+ " digitado não existe! Tente outro " + Tipo + "  ", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	protected static void AtualizarQuantEstoque() {
		if (ModelSuprimentos.getTipoItem().equals("produto")) {
			dados = x.Consultar("select*from produtos where codigoProduto = '"
					+ ModelSuprimentos.getCodigo() + "'");
			try {
				dados.next();
				estAtual = Double.parseDouble(dados.getString("estoqueAtual"));
			}
			catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, e, "Mensagem do Sistema",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if (ModelSuprimentos.getTipoItem().equals("materiaPrima")) {
			
			dados = x.Consultar("select*from materia_p where codigo = '"
					+ ModelSuprimentos.getCodigo() + "'");
			try {
				dados.next();
				estAtual = Double.parseDouble(dados.getString("estoqueAtual"));
			}
			catch (SQLException e) {
				
				JOptionPane.showMessageDialog(null, e, "Mensagem do Sistema",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		System.out.println(estAtual);
		double d = Double.parseDouble(ModelSuprimentos.getQuantidade().replace(",", "."));
		d = d + estAtual;
		
		if (ModelSuprimentos.getTipoItem().equals("produto")) {
			String comandosql4 = "UPDATE  `erp`.`produtos` SET  `estoqueAtual` =  '"
					+ String.valueOf(d) + "' WHERE  `produtos`.`codigoProduto` =  '"
					+ ModelSuprimentos.getCodigo() + "'";
			x.grava(comandosql4);
		}
		else if (ModelSuprimentos.getTipoItem().equals("materiaPrima")) {
			String comandosql4 = "UPDATE  `erp`.`materia_p` SET  `estoqueAtual` =  '"
					+ String.valueOf(d) + "' WHERE  `materia_p`.`codigo` =  '"
					+ ModelSuprimentos.getCodigo() + "'";
			x.grava(comandosql4);
		}
	}
	
}
