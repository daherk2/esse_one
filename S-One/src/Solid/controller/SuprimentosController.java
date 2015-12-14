package Solid.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.jtattoo.plaf.fast.FastLookAndFeel;

import Solid.model.ModelSuprimentos;
import Solid.view.Login;
import Solid.view.Menu;
import Solid.view.Suprimentos;

public class SuprimentosController {

	
//Variaveis de controle

	public static int gatilho1=0;
	static int	sn = 0;
	public static int contLinha = 0;
	static int tipo;
	static double pv = 0, PrCusto = 0,estAtual;
	public static NumberFormat nf;
	static BancoDados x	= new BancoDados();
	static ResultSet dados;
	private static String Tipo;
	private static int obrigatorios = 0,indice=0;
	
	public static void AbrirSuprimentos(){
		new Suprimentos();		
		SetarPaineis(Menu.painel);	
	}
	
	public static void SetarPaineis(int seq) {		
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");     
	
		if (seq == 1) {
			Suprimentos.tabbedPaneSuprimentos.removeAll();
			Suprimentos.tabbedPaneSuprimentos.addTab("Produto ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					Suprimentos.panelCadastrarProduto, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Matéria Prima ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					Suprimentos.panelCadastrarMateriaPrima, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Fornecedor ",	new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606601_book-128.png")),
					Suprimentos.panelFornecedor,null);
			Suprimentos.tabbedPaneSuprimentos.addTab(" Estoque ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
					Suprimentos.panelAddproduto,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Relatórios",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606565_calendar-128.png")),
					Suprimentos.panelRelatorios, null);

		} else if (seq == 2) {
			Suprimentos.tabbedPaneSuprimentos.removeAll();
			Suprimentos.tabbedPaneSuprimentos.addTab("Matéria Prima ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					Suprimentos.panelCadastrarMateriaPrima, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Produto ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					Suprimentos.panelCadastrarProduto, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Fornecedor ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606601_book-128.png")),
					Suprimentos.panelFornecedor,null);
			Suprimentos.tabbedPaneSuprimentos.addTab(" Estoque ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
					Suprimentos.panelAddproduto,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Relatórios",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606565_calendar-128.png")),
					Suprimentos.panelRelatorios, null);

		} else if (seq == 3) {
			Suprimentos.tabbedPaneSuprimentos.removeAll();
			Suprimentos.tabbedPaneSuprimentos.addTab("Fornecedor ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606601_book-128.png")),
					Suprimentos.panelFornecedor,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Produto ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					Suprimentos.panelCadastrarProduto, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Matéria Prima ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					Suprimentos.panelCadastrarMateriaPrima, null);
			Suprimentos.tabbedPaneSuprimentos.addTab(" Estoque ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
					Suprimentos.panelAddproduto,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Relatórios",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606565_calendar-128.png")),
					Suprimentos.panelRelatorios, null);

		} else if (seq == 4) {
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			Suprimentos.tabbedPaneSuprimentos.removeAll();
			Suprimentos.tabbedPaneSuprimentos.addTab(" Estoque ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
					Suprimentos.panelAddproduto,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Produto ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					Suprimentos.panelCadastrarProduto, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Matéria Prima ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					Suprimentos.panelCadastrarMateriaPrima, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Fornecedor ",	new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606601_book-128.png")),
					Suprimentos.panelFornecedor,null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Relatórios",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606565_calendar-128.png")),
					Suprimentos.panelRelatorios, null);
		}else if (seq == 5) {
			Suprimentos.tabbedPaneSuprimentos.removeAll();
			Suprimentos.tabbedPaneSuprimentos.addTab("Relatórios",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606565_calendar-128.png")),
					Suprimentos.panelRelatorios, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Produto ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606650_678112-bag-128.png")),
					Suprimentos.panelCadastrarProduto, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Matéria Prima ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606655_file-powerpoint-128.png")),
					Suprimentos.panelCadastrarMateriaPrima, null);
			Suprimentos.tabbedPaneSuprimentos.addTab("Fornecedor ",	new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606601_book-128.png")),
					Suprimentos.panelFornecedor,null);			
			Suprimentos.tabbedPaneSuprimentos.addTab(" Estoque ",new ImageIcon(Suprimentos.class.getResource("/icones1_24px/1425606821_678065-file-bookmark-128.png")),
					Suprimentos.panelAddproduto,null);
		}
		
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger( Suprimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger( Suprimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger( Suprimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger( Suprimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }	
		
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Produtos"		
	public static void addItem() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
			int linha2 = 0, achou = 0;
			PrCusto = 0;
			if (ModelSuprimentos.getProdutoAdd().equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
			}
			else if (ModelSuprimentos.getQuantAdd().equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Digite a quantidade á adicionar !", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
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
				Suprimentos.modeloficha.addRow(new String[] { 
						String.valueOf(contLinha),
						ModelSuprimentos.getCodigoF(),
						ModelSuprimentos.getProdutoAdd(),
						ModelSuprimentos.getUnidadeF(),
						String.valueOf(Suprimentos.precoUnidade),
						(String) ModelSuprimentos.getQuantAdd(),
						String.valueOf(nf.format(valorT).replace(",", ".")) });
				ModelSuprimentos.setQuantAdd("");
				System.out.println("numero de linha" + contLinha);			
			}

			else {
				for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
					if (ModelSuprimentos.getProdutoAdd().equals((String)ModelSuprimentos.getNomeMp())) {
						
					double quant2 = Double.parseDouble(ModelSuprimentos.getQuantAdd())+ (Double.parseDouble((String) ModelSuprimentos.getQuantMp()));
					double valorT = 0;
					achou = 1;
					valorT = quant2 * Suprimentos.precoUnidade;
					PrCusto = PrCusto + valorT;
					
					ModelSuprimentos.setPrecoCustoProd(String.valueOf(PrCusto).replace(",", "."));					
					ModelSuprimentos.setQuantMp(String.valueOf(quant2).replace(",", "."));
					ModelSuprimentos.setCustoAgregado(String.valueOf(nf.format(PrCusto).replace(",", ".")));
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
					ModelSuprimentos.setPrecoCustoProd(String.valueOf(PrCusto).replace(",", "."));
					contLinha++;
					Suprimentos.contLinha++;
					Suprimentos.modeloficha.addRow(new String[] {
							String.valueOf(contLinha),
							ModelSuprimentos.getCodigoF(),
							ModelSuprimentos.getProdutoAdd(),
							ModelSuprimentos.getUnidadeF(),
							String.valueOf(Suprimentos.precoUnidade),
							(String) ModelSuprimentos.getQuantAdd(),
							String.valueOf(nf.format(valorT).replace(",", ".")) });
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
		System.out.println("contLinha = "+contLinha);
			int M = 0;
			if (ModelSuprimentos.getRemoverMp().equals("")) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Nenhum item selecionado!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
			} else {
				
				if (contLinha == 1) {
					if (Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", ".")) > Double.parseDouble((String) Suprimentos.modeloficha.getValueAt(contLinha - 1, 5))) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Quantidade Maior qua a existente na tabela!", "ATENÇÃO",JOptionPane.WARNING_MESSAGE);
						Suprimentos.quantR.requestFocus();
						M = 1;
					}

					if (Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", "."))- Double.parseDouble((String) Suprimentos.modeloficha.getValueAt(contLinha - 1, 5)) == 0
							&& M == 0) {
						contLinha--;
						Suprimentos.modeloficha.removeRow(contLinha);
						Suprimentos.contLinha--;
					}

					else {
						for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
							if (ModelSuprimentos.getRemoverMp().equals(ModelSuprimentos.getNomeMp())	&& M == 0) {
								if ((Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", "."))) > Double.parseDouble((String) ModelSuprimentos.getQuantMp())) {
									Toolkit.getDefaultToolkit().beep();
									JOptionPane.showMessageDialog(null,
											"Quantidade Maior qua a existente na tabela!", "ATENÇÃO",
											JOptionPane.WARNING_MESSAGE);
									Suprimentos.quantR.requestFocus();
									M = 1;
								}

								if (Double.parseDouble(ModelSuprimentos.getQuantRemover())- Double.parseDouble((String)ModelSuprimentos.getQuantMp()) == 0	&& M == 0) {
									contLinha--;
									Suprimentos.modeloficha.removeRow(ModelSuprimentos.linha);
									Suprimentos.contLinha--;
								}

								else {
ModelSuprimentos.setQuantMp((String.valueOf(nf.format((Double.parseDouble(ModelSuprimentos.getQuantMp())-Double.parseDouble(ModelSuprimentos.getQuantRemover())))).replace(",", ".")));
ModelSuprimentos.setCustoAgregado(((String.valueOf(nf.format(Double.parseDouble((String) ModelSuprimentos.getQuantMp())* (Double.parseDouble(ModelSuprimentos.getPrecoMp()))))).replace(",", ".")));
								}
							}
						}
					}
				} else {
					for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
						if (ModelSuprimentos.getRemoverMp().equals((String)ModelSuprimentos.getNomeMp())&& M == 0) {
							if (Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", ".")) > Double.parseDouble((String) Suprimentos.modeloficha.getValueAt(contLinha - 1, 5))) {
								Toolkit.getDefaultToolkit().beep();
								JOptionPane.showMessageDialog(null, "Quantidade Maior qua a existente na tabela!","ATENÇÃO", JOptionPane.WARNING_MESSAGE);
								M = 1;
							}
						}
						if (ModelSuprimentos.getRemoverMp().equals(ModelSuprimentos.getNomeMp())&& M == 0) {

							if (Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", "."))- Double.parseDouble(ModelSuprimentos.getQuantMp()) == 0) {
								contLinha--;
								Suprimentos.contLinha--;
								Suprimentos.modeloficha.removeRow(ModelSuprimentos.linha);
								for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
									Suprimentos.modeloficha.setValueAt(ModelSuprimentos.linha + 1, ModelSuprimentos.linha, 0);
								}
							}

							else {
	ModelSuprimentos.setQuantMp((String.valueOf(nf.format((Double.parseDouble(ModelSuprimentos.getQuantMp())- Double.parseDouble(ModelSuprimentos.getQuantRemover().replace(",", "."))))).replace(",", ".")));
	ModelSuprimentos.setCustoAgregado(((String.valueOf(nf.format(Double.parseDouble((String) ModelSuprimentos.getQuantMp())* (Double.parseDouble(ModelSuprimentos.getPrecoMp()))))).replace(",", ".")));
							}
						}
					}
				}
				Suprimentos.quantR.requestFocus();
				CalcularCusto();
				if (M == 0) {
					Suprimentos.internalFrame.setVisible(false);
					Suprimentos.quantR.setText("0.0");
				}
			}
		}
		
	public static void CalcularCusto() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
			Double valorT = 0.0;
			for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
			valorT = valorT	+ ((Double.parseDouble((String) ModelSuprimentos.getQuantMp()) * Double.parseDouble((String) ModelSuprimentos.getPrecoMp())));
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

			double imposto = (ipi / 100) + (iss / 100) + (pis / 100) + (cofins / 100) + (icms / 100);

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
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
				Suprimentos.labelFotoProduto.setText("");
				Suprimentos.labelFotoProduto.setIcon(new ImageIcon(img));
				Suprimentos.caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
		
			} else {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"Nenhum arquivo selecionado.");
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
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
				Suprimentos.labelFotoProduto.setText("");
				Suprimentos.labelFotoProduto.setIcon(new ImageIcon(img));
				Suprimentos.caminho.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
				JOptionPane.showMessageDialog(null, "Imagem atualizada com sucesso!", "Atualizar Imagem",JOptionPane.PLAIN_MESSAGE);
			} else {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"Nenhum arquivo selecionado.");
			}
				System.out.print(diretorio);
				String comandosql4 = "UPDATE  `erp`.`produtos` SET  `imagem` =  '" + ModelSuprimentos.getImagemProduto()
						+ "' WHERE  `produtos`.`codigoProduto` = '" + ModelSuprimentos.getCodigoProduto() + "'";
				x.grava(comandosql4);
			
		}
		
	public static void SalvarProduto() {
		VerificarCamposObrigatoriosProd();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
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

			String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoProduto` =  '" + String.valueOf(d)
					+ "' WHERE  `contadores`.`codigoProduto` =  '" + ModelSuprimentos.getCodigoProduto() + "'";
			x.grava(comandosql4);

			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);

			Suprimentos.limparProduto();
			Suprimentos.nome1.requestFocus();

			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			try {
				Suprimentos.codigo1.setEditable(false);
				while (rs3.next()) {
					ModelSuprimentos.setCodigoProduto(rs3.getString("codigoProduto"));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		  }
		}

	private static void VerificarCamposObrigatoriosProd() {
		obrigatorios=0;
		
		if(ModelSuprimentos.getCodigoProduto().toString().equals("")){
			obrigatorios++;
			Suprimentos.codigo1.setBorder(new LineBorder(Color.BLUE));
		}
		else Suprimentos.codigo1.setBorder(null);
		
		if(ModelSuprimentos.getNomeProduto().toString().equals("")){
			Suprimentos.nome1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.nome1.setBorder(null);
			
		if(ModelSuprimentos.getNumeroLoteProd().equals("")){
			Suprimentos.numeroLote.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.numeroLote.setBorder(null);
			
		if(ModelSuprimentos.getTipoProduto().toString().equals("")){
			Suprimentos.comboBoxTipoProd.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboBoxTipoProd.setBorder(null);
		
		if(ModelSuprimentos.getUnidadeProduto().equals("")){
			Suprimentos.comboUnidade.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboUnidade.setBorder(null);
				
		if(ModelSuprimentos.getDataCadastro().toString().equals("  /  /    ")){
			Suprimentos.dataCompra_1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.dataCompra_1.setBorder(null);		
		
		if(ModelSuprimentos.getValidadeCadastro().toString().equals("  /  /    ")){
			Suprimentos.validade1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.validade1.setBorder(null);
		
		if(ModelSuprimentos.getLocalEstoqueProd().toString().equals("")){
			Suprimentos.localEstoque_1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.localEstoque_1.setBorder(null);
		
		if(ModelSuprimentos.getEstoqueMin().equals("")){
			Suprimentos.estoqueMinimo1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.estoqueMinimo1.setBorder(null);
		
		if(ModelSuprimentos.getDescricao().toString().equals("")){
			Suprimentos.descricaoProduto.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.descricaoProduto.setBorder(null);
		
		if(ModelSuprimentos.getPrecoCustoProd().toString().equals("0,00")){
			Suprimentos.precoCusto.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.precoCusto.setBorder(null);
		
		if(ModelSuprimentos.getMargemLucro() .toString().equals("0")){
			Suprimentos.margemLucro.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.margemLucro.setBorder(null);
		
		if(ModelSuprimentos.getPrecoVenda().toString().equals("0,00")){
			Suprimentos.precoVenda.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.precoVenda.setBorder(null);
		
		if(Suprimentos.fichaSim.isSelected()==true&&contLinha<=0){
			JOptionPane.showMessageDialog(null,"Nenhuma MP foi adicionada á Ficha Técnica do Produto. ","Atenção", JOptionPane.WARNING_MESSAGE);
			obrigatorios++;
		}
	}
	
	public static void SetarBordaProdNull(){
		Suprimentos.precoVenda.setBorder(null);
		Suprimentos.margemLucro.setBorder(null);
		Suprimentos.precoCusto.setBorder(null);
		Suprimentos.descricaoProduto.setBorder(null);
		Suprimentos.estoqueMinimo1.setBorder(null);
		Suprimentos.localEstoque_1.setBorder(null);
		Suprimentos.validade1.setBorder(null);
		Suprimentos.dataCompra_1.setBorder(null);		
		Suprimentos.comboUnidade.setBorder(null);
		Suprimentos.comboBoxTipoProd.setBorder(null);
		Suprimentos.numeroLote.setBorder(null);
		Suprimentos.nome1.setBorder(null);
		Suprimentos.codigo1.setBorder(null);
	}

	public static void ConsultarProduto() {
			if(Suprimentos.comboBox_2.getSelectedItem().toString().equals("")){
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
				}
				else if(Suprimentos.comboBox_2.getSelectedItem().toString().equals("Código")){
				dados = x.Consultar("select*from produtos where codigoProduto = '" + ModelSuprimentos.getCodigoProduto() + "'");
				gatilho1=1;
				Tipo="código";
				}
				else if(Suprimentos.comboBox_2.getSelectedItem().toString().equals("Nome")){
				dados = x.Consultar("select*from produtos where nome = '" +  ModelSuprimentos.getNomeProduto()+ "'");
				gatilho1=1;
				Tipo="nome";
				}
				else if(Suprimentos.comboBox_2.getSelectedItem().toString().equals("Lote")){
					dados = x.Consultar("select*from produtos where numeroLote = '" + ModelSuprimentos.getNumeroLoteProd() + "'");
					gatilho1=1;
					Tipo="lote";
				}
				
				if(gatilho1==1){					
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
						ModelSuprimentos.setImagemProduto(dados.getString("imagem").replace("~", "\\"));
						Suprimentos.atualizarImagem.setVisible(true);
						ModelSuprimentos.setDescricao(dados.getString("descricaoProduto"));						
						if(dados.getString("codigoProduto").equals(ModelSuprimentos.getCodigoProduto())){
						Suprimentos.AlterarProduto.setEnabled(true);
						Suprimentos.button_1.setEnabled(true);
						Suprimentos.btnAnterior.setEnabled(true);
						Suprimentos.btnProximo.setEnabled(true);
						}
							if (dados.getString("fichaTecnica").equals("sim")) {
								Suprimentos.ficha = "sim";
								ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ dados.getString("codigoProduto") + "'");
								while (dados2.next()) {
									Suprimentos.modeloficha.addRow(new String[] { dados2.getString("numeroitem"),
											dados2.getString("codigomp"), dados2.getString("nome"),
											dados2.getString("unidade"), dados2.getString("preco"),
											dados2.getString("quantidade"),
											dados2.getString("custoagregado") });
									Suprimentos.contLinha++;
									contLinha++;
								}
								Suprimentos.scrollPane.setVisible(true);
								
							} else {
								Toolkit.getDefaultToolkit().beep();
								JOptionPane.showMessageDialog(null,"O produto consultado não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
								
							}
							
							ModelSuprimentos.setPrecoCustoProd(dados.getString("precoCusto"));
							ModelSuprimentos.setIpi(dados.getString("ipi"));
							ModelSuprimentos.setIss(dados.getString("iss"));
							ModelSuprimentos.setPis(dados.getString("pis"));
							ModelSuprimentos.setCofins(dados.getString("cofins"));
							ModelSuprimentos.setIcms(dados.getString("icms"));
							ModelSuprimentos.setMargemLucro(dados.getString("margemLucro"));
							ModelSuprimentos.setPrecoVenda(dados.getString("precoVenda"));							
						
					} catch (SQLException erro) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null," O "+Tipo+" digitado não existe! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
						gatilho1=0;					
				}
			}
		}
		
	public static void ConsultarProxProd(){
		if(ModelSuprimentos.getCodigoProduto().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo1.requestFocus();
		}
		else{
			dados = x.Consultar("select*from produtos where codigoProduto = '" + String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoProduto())+1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){					
				
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
					ModelSuprimentos.setImagemProduto(dados.getString("imagem").replace("~", "\\"));
					Suprimentos.atualizarImagem.setVisible(true);
					ModelSuprimentos.setDescricao(dados.getString("descricaoProduto"));						
					if(dados.getString("codigoProduto").equals(ModelSuprimentos.getCodigoProduto())){
					Suprimentos.AlterarProduto.setEnabled(true);
					Suprimentos.button_1.setEnabled(true);
					Suprimentos.btnAnterior.setEnabled(true);
					Suprimentos.btnProximo.setEnabled(true);
					}
						if (dados.getString("fichaTecnica").equals("sim")) {
							Suprimentos.ficha = "sim";
							Suprimentos.fichaSim.setSelected(true);
							Suprimentos.fichaNao.setSelected(false);
							ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ dados.getString("codigoProduto") + "'");
							while (dados2.next()) {
								Suprimentos.modeloficha.addRow(new String[] { dados2.getString("numeroitem"),
										dados2.getString("codigomp"), dados2.getString("nome"),
										dados2.getString("unidade"), dados2.getString("preco"),
										dados2.getString("quantidade"),
										dados2.getString("custoagregado") });
								Suprimentos.contLinha++;
								contLinha++;
							}
							Suprimentos.scrollPane.setVisible(true);
							
						} else {
							Suprimentos.fichaSim.setSelected(false);
							Suprimentos.fichaNao.setSelected(true);
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(null,"O produto consultado não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
							if (Suprimentos.contLinha > 0) {
								for (int i = 0; i < Suprimentos.contLinha; i++) {
									Suprimentos.modeloficha.removeRow(0);
								}
								Suprimentos.contLinha = 0;
								SuprimentosController.contLinha = 0;
								Suprimentos.scrollPane.setVisible(false);
							}
						}
						
						ModelSuprimentos.setPrecoCustoProd(dados.getString("precoCusto"));
						ModelSuprimentos.setIpi(dados.getString("ipi"));
						ModelSuprimentos.setIss(dados.getString("iss"));
						ModelSuprimentos.setPis(dados.getString("pis"));
						ModelSuprimentos.setCofins(dados.getString("cofins"));
						ModelSuprimentos.setIcms(dados.getString("icms"));
						ModelSuprimentos.setMargemLucro(dados.getString("margemLucro"));
						ModelSuprimentos.setPrecoVenda(dados.getString("precoVenda"));
						
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;				
			}
		  }
		}
	}

	public static void ConsultarProdAnterior(){
		if(ModelSuprimentos.getCodigoProduto().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo1.requestFocus();
		}
		else if(Integer.parseInt(ModelSuprimentos.getCodigoProduto())>0){
			dados = x.Consultar("select*from produtos where codigoProduto = '" + String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoProduto())-1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){					
				
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
					ModelSuprimentos.setImagemProduto(dados.getString("imagem").replace("~", "\\"));
					Suprimentos.atualizarImagem.setVisible(true);
					ModelSuprimentos.setDescricao(dados.getString("descricaoProduto"));						
					if(dados.getString("codigoProduto").equals(ModelSuprimentos.getCodigoProduto())){
					Suprimentos.AlterarProduto.setEnabled(true);
					Suprimentos.button_1.setEnabled(true);
					Suprimentos.btnAnterior.setEnabled(true);
					Suprimentos.btnProximo.setEnabled(true);
					}
						if (dados.getString("fichaTecnica").equals("sim")) {
							Suprimentos.ficha = "sim";
							ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ dados.getString("codigoProduto") + "'");
							while (dados2.next()) {
								Suprimentos.modeloficha.addRow(new String[] { dados2.getString("numeroitem"),
										dados2.getString("codigomp"), dados2.getString("nome"),
										dados2.getString("unidade"), dados2.getString("preco"),
										dados2.getString("quantidade"),
										dados2.getString("custoagregado") });
								Suprimentos.contLinha++;
								contLinha++;
							}
							Suprimentos.scrollPane.setVisible(true);
							
						} else {
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(null,"O produto consultado não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
							if (Suprimentos.contLinha > 0) {
								for (int i = 0; i < Suprimentos.contLinha; i++) {
									Suprimentos.modeloficha.removeRow(0);
								}
								Suprimentos.contLinha = 0;
								SuprimentosController.contLinha = 0;
								Suprimentos.scrollPane.setVisible(false);
							}
						}
						
						ModelSuprimentos.setPrecoCustoProd(dados.getString("precoCusto"));
						ModelSuprimentos.setIpi(dados.getString("ipi"));
						ModelSuprimentos.setIss(dados.getString("iss"));
						ModelSuprimentos.setPis(dados.getString("pis"));
						ModelSuprimentos.setCofins(dados.getString("cofins"));
						ModelSuprimentos.setIcms(dados.getString("icms"));
						ModelSuprimentos.setMargemLucro(dados.getString("margemLucro"));
						ModelSuprimentos.setPrecoVenda(dados.getString("precoVenda"));
						
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;				
			}
		  }
		}
	}
	
	public static void AtualizarProduto(){
		VerificarCamposObrigatoriosProd();
		if(obrigatorios>0){
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
		String comandosql4 = "UPDATE `erp`.`produtos` SET `nome` = '" + ModelSuprimentos.getNomeProduto()
				  + "', `localEstoque` = '" + ModelSuprimentos.getLocalEstoqueProd()
				  + "', `tipo` = '" + ModelSuprimentos.getTipoProduto()
				  + "', `unidade` = '" + ModelSuprimentos.getUnidadeProduto()
				  + "', `dataCompra` = '" + ModelSuprimentos.getDataCadastro()
				  + "', `validade` = '" +  ModelSuprimentos.getValidadeCadastro()
				  + "', `numeroLote` = '" + ModelSuprimentos.getNumeroLoteProd()
				  + "', `estoqueMinimo` = '" + ModelSuprimentos.getEstoqueMin()
				  + "', `imagem` = '" + ModelSuprimentos.getImagemProduto()
				  + "', `descricaoProduto` = '" +  ModelSuprimentos.getDescricao()
				  + "', `fichaTecnica` = '" + ModelSuprimentos.getFichaProduto()
				  + "', `precoCusto` = '" + ModelSuprimentos.getPrecoCustoProd()
				  + "', `ipi` = '" + ModelSuprimentos.getIpi()
				  + "', `iss` = '" + ModelSuprimentos.getIss()
				  + "', `pis` = '" + ModelSuprimentos.getPis()
				  + "', `cofins` = '" + ModelSuprimentos.getCofins()
				  + "', `icms` = '" + ModelSuprimentos.getIcms()
				  + "', `margemLucro` = '" + ModelSuprimentos.getMargemLucro() 
				  + "', `precoVenda` = '" + ModelSuprimentos.getPrecoVenda()
				  + "' WHERE `produtos`.`codigoProduto` = '" + ModelSuprimentos.getCodigoProduto()+ "'";
		x.grava(comandosql4);
		
		if (Suprimentos.ficha.equals("sim")) {
			for (ModelSuprimentos.linha = 0; ModelSuprimentos.linha < contLinha; ModelSuprimentos.linha++) {
				String comandosql5 = "UPDATE `erp`.`fichatecnica` SET `quantidade` = '" + ModelSuprimentos.getQuantMp()
						 + "', `custoagregado` = '" + ModelSuprimentos.getCustoAgregado()
						 + "' WHERE `fichatecnica`.`codigomp` = '" + ModelSuprimentos.getCodigoMp()+ "'";
				x.grava(comandosql5);
			}			
		}
		JOptionPane.showMessageDialog(null," Dados Atualizados com sucesso !","Salvar", JOptionPane.INFORMATION_MESSAGE);
		Suprimentos.btnAtualizr.setEnabled(false);
		Suprimentos.btnCancelar.setEnabled(false);
		Suprimentos.SetarProdutoNaoEditavel();
		}
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Materia Prima"
	
	public static void SelecionarImagemMateriaPrima() {
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
			Suprimentos.caminho2.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
			Suprimentos.labelFotoMateriaPrima.setText(null);
			Suprimentos.labelFotoMateriaPrima.setIcon(new ImageIcon(img));
		} else {
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
			
			ImageIcon imagem = new ImageIcon(diretorio);
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
			Suprimentos.caminho2.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
			Suprimentos.labelFotoMateriaPrima.setText(null);
			Suprimentos.labelFotoMateriaPrima.setIcon(new ImageIcon(img));
			String comandosql4 = "UPDATE  `erp`.`materia_p` SET  `imagem` =  '" + ModelSuprimentos.getImagemMp() 
					+ "' WHERE  `materia_p`.`codigo` = '" + ModelSuprimentos.getCodigoMateriaPrima() + "'";
			x.grava(comandosql4);
			JOptionPane.showMessageDialog(null, "Imagem atualizada com sucesso!", "Atualizar Imagem",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public static void salvarMP() {
		VerificarCamposObrigatoriosMP();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
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
		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoMateriaPrima` =  '" + String.valueOf(d)
				+ "' WHERE  `contadores`.`codigoMateriaPrima` =  '" + ModelSuprimentos.getCodigoMateriaPrima() + "'";
		x.grava(comandosql4);

		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
		
		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			while (rs3.next()) {
				ModelSuprimentos.setCodigoMateriaPrima(rs3.getString("codigoMateriaPrima"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
	}

	public static void ConsultarMP(){
		if(Suprimentos.comboBox_3.getSelectedItem().toString().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
			}
			else if(Suprimentos.comboBox_3.getSelectedItem().toString().equals("Código")){
			dados = x.Consultar("select*from materia_p where codigo = '" + ModelSuprimentos.getCodigoMateriaPrima() + "'");
			gatilho1=1;
			Tipo="código";
			}
			else if(Suprimentos.comboBox_3.getSelectedItem().toString().equals("Nome")){
			dados = x.Consultar("select*from materia_p where nome = '" +  ModelSuprimentos.getNomeMateriaPrima()+ "'");
			gatilho1=1;
			Tipo="nome";
			}
						
			if(gatilho1==1){				
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
					Suprimentos.atualizarImagemMP.setVisible(true);
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null," O "+Tipo+" digitado não existe! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;					
				}
			}
	}

	public static void ConsultarProxMP(){
		if(ModelSuprimentos.getCodigoMateriaPrima().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo2.requestFocus();
		}
		else{
			dados = x.Consultar("select*from materia_p where codigo = '" + String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoMateriaPrima())+1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){				
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
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;				
				}
			}
		}
	}
	
	public static void ConsultarMPAnterior(){
		if(ModelSuprimentos.getCodigoMateriaPrima().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo2.requestFocus();
		}
		else if(Integer.parseInt(ModelSuprimentos.getCodigoMateriaPrima())>0){
			dados = x.Consultar("select*from materia_p where codigo = '" + String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoMateriaPrima())-1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){				
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
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;				
				}
			}
		}
	}
	
	public static void AtualizarMateriaPrima(){
		VerificarCamposObrigatoriosMP();
		if(obrigatorios>0){
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
		String comandosql4 = "UPDATE `erp`.`materia_p` SET `nome` = '" + ModelSuprimentos.getNomeMateriaPrima()
				  + "', `localEstoque` = '" + ModelSuprimentos.getLocalEstoqueMp()
				  + "', `tipo` = '" + ModelSuprimentos.getTipoMp()
				  + "', `unidade` = '" + ModelSuprimentos.getUnidadeMateriaPrima()
				  + "', `numeroLote` = '" + ModelSuprimentos.getLoteMp()				  
				  + "', `estoqueMinimo` = '" + ModelSuprimentos.getEstoqueMinMp()
				  + "', `precoUnidade` = '" + ModelSuprimentos.getPrecoUnidade()				
				  + "', `descricaoMateriaPrima` = '" +  ModelSuprimentos.getDescricaoMp()
				  + "' WHERE `materia_p`.`codigo` = '" + ModelSuprimentos.getCodigoMateriaPrima()+ "'";
		x.grava(comandosql4);
		Suprimentos.btnAtualizar.setEnabled(false);
		Suprimentos.btnCancelar_1.setEnabled(false);
		JOptionPane.showMessageDialog(null," Dados Atualizados com sucesso !","Atualizar", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	
	private static void VerificarCamposObrigatoriosMP(){
		obrigatorios=0;
		
		if(ModelSuprimentos.getCodigoMateriaPrima().toString().equals("")){
			obrigatorios++;
			Suprimentos.codigo2.setBorder(new LineBorder(Color.BLUE));
		}
		else Suprimentos.codigo2.setBorder(null);
		
		if(ModelSuprimentos.getNomeMateriaPrima().toString().equals("")){
			Suprimentos.nome2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.nome2.setBorder(null);
			
		if(ModelSuprimentos.getLocalEstoqueMp().equals("")){
			Suprimentos.localEstoque.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.localEstoque.setBorder(null);
			
		if(ModelSuprimentos.getTipoMp().toString().equals("")){
			Suprimentos.comboBox_4.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboBox_4.setBorder(null);
		
		if(ModelSuprimentos.getUnidadeMateriaPrima().equals("")){
			Suprimentos.comboUnidade2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboUnidade2.setBorder(null);
				
		if(ModelSuprimentos.getLoteMp().toString().equals("")){
			Suprimentos.numeroLote2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.numeroLote2.setBorder(null);		
		
		if(ModelSuprimentos.getEstoqueMinMp().toString().equals("")){
			Suprimentos.estoqueMinimo2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.estoqueMinimo2.setBorder(null);
		
		if(ModelSuprimentos.getPrecoUnidade().toString().equals("0,00")){
			Suprimentos.precoPor2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.precoPor2.setBorder(null);
		
		if(ModelSuprimentos.getDescricaoMp().equals("")){
			Suprimentos.descricaoMateriaPrima2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.descricaoMateriaPrima2.setBorder(null);
		
	}
	
	public static void SetarBordaMPNull(){
		Suprimentos.descricaoMateriaPrima2.setBorder(null);
		Suprimentos.precoPor2.setBorder(null);
		Suprimentos.estoqueMinimo2.setBorder(null);
		Suprimentos.numeroLote2.setBorder(null);		
		Suprimentos.comboUnidade2.setBorder(null);
		Suprimentos.comboBox_4.setBorder(null);
		Suprimentos.localEstoque.setBorder(null);
		Suprimentos.nome2.setBorder(null);
		Suprimentos.codigo2.setBorder(null);
	}
		
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Fornecedor"	
	public static void SelecionarImagemFornecedor() {
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
			Suprimentos.caminho3.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
			Suprimentos.labelFotoFornecedor.setText(null);
			Suprimentos.labelFotoFornecedor.setIcon(new ImageIcon(img));
		} else {
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
			Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
			Suprimentos.labelFotoFornecedor.setText("");
			Suprimentos.labelFotoFornecedor.setIcon(new javax.swing.ImageIcon(img));			
			Suprimentos.caminho3.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath().replace("\\", "~").toString());
			System.out.print(diretorio);
			String comandosql4 = "UPDATE  `erp`.`fornecedor` SET  `imagem` =  '" + ModelSuprimentos.getImagemFornecedor()
					+ "' WHERE  `fornecedor`.`codigoFornecedor` = '" + ModelSuprimentos.getCodigoFornecedor()+ "'";
			x.grava(comandosql4);
			JOptionPane.showMessageDialog(null, "Imagem atualizada com sucesso!", "Atualizar Imagem",JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void VerificarCamposObrigatoriosForn(){
		obrigatorios=0;
		if(ModelSuprimentos.getCodigoFornecedor().toString().equals("")){
			obrigatorios++;
			Suprimentos.codigo5.setBorder(new LineBorder(Color.BLUE));
		}
		else Suprimentos.codigo5.setBorder(null);
		
		if(ModelSuprimentos.getNomeFornecedor().toString().equals("")){
			Suprimentos.NomeFornecedor.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.NomeFornecedor.setBorder(null);
			
		if(ModelSuprimentos.getVendedor().equals("")){
			Suprimentos.vendedor.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.vendedor.setBorder(null);
			
		if(ModelSuprimentos.getTelefone1().toString().equals("(  )    -    ")){
			Suprimentos.telefone1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.telefone1.setBorder(null);
		
		if(ModelSuprimentos.getTelefone2().equals("(  )    -    ")){
			Suprimentos.telefone2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.telefone2.setBorder(null);
				
		if(ModelSuprimentos.getCelular1().toString().equals("(  )     -    ")){
			Suprimentos.celular1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.celular1.setBorder(null);		
		
		if(ModelSuprimentos.getCelular2().toString().equals("(  )     -    ")){
			Suprimentos.celular2.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.celular2.setBorder(null);
		
		if(ModelSuprimentos.getLogradouroFornecedor().toString().equals("")){
			Suprimentos.endereco.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.endereco.setBorder(null);
		
		if(ModelSuprimentos.getNumeroFornecedor().equals("")){
			Suprimentos.numero.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.numero.setBorder(null);
		
		if(ModelSuprimentos.getComplementoFornecedor().toString().equals("")){
			Suprimentos.complemento.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.complemento.setBorder(null);
		
		if(ModelSuprimentos.getBairroFornecedor().toString().equals("")){
			Suprimentos.bairro.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.bairro.setBorder(null);
		
		if(ModelSuprimentos.getUfFornecedor().toString().equals("")){
			Suprimentos.comboBox_estado.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboBox_estado.setBorder(null);
		
		if(ModelSuprimentos.getCidadeFornecedor().toString().equals("")){
			Suprimentos.comboBox_cidade.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboBox_cidade.setBorder(null);
		
		if(ModelSuprimentos.getCepFornecedor().toString().equals("     -   ")){
			Suprimentos.cep.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.cep.setBorder(null);
		
		if(ModelSuprimentos.getCnpjFornecedor().toString().equals("")){
			Suprimentos.cnpj.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.cnpj.setBorder(null);
		
		if(ModelSuprimentos.getIeFornecedor().toString().equals("")){
			Suprimentos.iE.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.iE.setBorder(null);
		
	}
	
	public static void salvarFornecedor() {
		VerificarCamposObrigatoriosForn();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
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
				+ ModelSuprimentos.getImagemFornecedor()
				+ "')";
		x.grava(comandosql);

		int d = Integer.parseInt(ModelSuprimentos.getCodigoFornecedor());
		d++;
		pv = 0;

		String comandosql4 = "UPDATE  `erp`.`contadores` SET  `codigoFornecedor` =  '" + String.valueOf(d)
				+ "' WHERE  `contadores`.`codigoFornecedor` =  '" + ModelSuprimentos.getCodigoFornecedor() + "'";
		x.grava(comandosql4);

		JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",
				JOptionPane.PLAIN_MESSAGE);

		String sql2 = "select * from contadores";
		ResultSet rs3 = x.Consultar(sql2);
		try {
			while (rs3.next()) {
				ModelSuprimentos.setCodigoFornecedor(rs3.getString("codigoFornecedor"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		Suprimentos.limparFornecedor();
		Suprimentos.NomeFornecedor.requestFocus();
		}
	}

	public static void ConsultarFornecedor(){
		if(Suprimentos.comboBox_1.getSelectedItem().toString().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
			}
			else if(Suprimentos.comboBox_1.getSelectedItem().toString().equals("Código")){
			dados = x.Consultar("select*from fornecedor where codigoFornecedor = '" + ModelSuprimentos.getCodigoFornecedor() + "'");
			gatilho1=1;
			Tipo="código";
			}
			else if(Suprimentos.comboBox_1.getSelectedItem().toString().equals("Nome")){
			dados = x.Consultar("select*from fornecedor where nome = '" +  ModelSuprimentos.getNomeFornecedor()+ "'");
			gatilho1=1;
			Tipo="nome";
			}
			else if(Suprimentos.comboBox_1.getSelectedItem().toString().equals("Lote")){
				dados = x.Consultar("select*from fornecedor where endereco = '" + ModelSuprimentos.getLogradouroFornecedor() + "'");
				gatilho1=1;
				Tipo="endereço";
			}			
				if(gatilho1==1){				
					Suprimentos.limparFornecedor();
					try { // while(dados.next())
							// {
						dados.next();
						ModelSuprimentos.setCodigoFornecedor(dados.getString("codigoFornecedor"));
						ModelSuprimentos.setNomeFornecedor(dados.getString("nome"));
						ModelSuprimentos.setVendedor(dados.getString("vendedor"));
						ModelSuprimentos.setLogradouroFornecedor(dados.getString("endereco"));
						ModelSuprimentos.setNumeroFornecedor(dados.getString("numero"));
						ModelSuprimentos.setComplementoFornecedor(dados.getString("complemento"));
						ModelSuprimentos.setBairroFornecedor(dados.getString("bairro"));
						ModelSuprimentos.setCidadeFornecedor(dados.getString("cidade"));
						ModelSuprimentos.setUfFornecedor(dados.getString("estado"));
						ModelSuprimentos.setCepFornecedor(dados.getString("cep"));
						ModelSuprimentos.setTelefone1(dados.getString("Telefone1"));
						ModelSuprimentos.setTelefone2(dados.getString("Telefone2"));
						ModelSuprimentos.setCelular1(dados.getString("celular1"));
						ModelSuprimentos.setCelular2(dados.getString("celular2"));
						ModelSuprimentos.setCnpjFornecedor(dados.getString("cnpj"));
						ModelSuprimentos.setIeFornecedor(dados.getString("inscricaoEstadual"));
						Suprimentos.labelFotoFornecedor.setText("");
						ModelSuprimentos.setImagemFornecedor(dados.getString("imagem").replace("~", "\\"));
						Suprimentos.button_atualizarImagemForn.setVisible(true);					
						
						Suprimentos.button_5.setEnabled(true);
						Suprimentos.buttonAnteriorF.setEnabled(true);
						Suprimentos.btnPrximoF.setEnabled(true);
						Suprimentos.button_13.setEnabled(true);
						Suprimentos.button_atualizarImagemForn.setVisible(true);
						
					} catch (SQLException erro) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null," O "+Tipo+" digitado não existe! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
						gatilho1=0;					
					}
				}			
	}
	
	public static void ConsultarProxForn(){
		if(ModelSuprimentos.getCodigoFornecedor().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo5.requestFocus();
		}
		else{
			dados = x.Consultar("select*from fornecedor where codigoFornecedor = '" 
					+ String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoFornecedor())+1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){				
				try { // while(dados.next())
						// {
					dados.next();
					ModelSuprimentos.setCodigoFornecedor(dados.getString("codigoFornecedor"));
					ModelSuprimentos.setNomeFornecedor(dados.getString("nome"));
					ModelSuprimentos.setVendedor(dados.getString("vendedor"));
					ModelSuprimentos.setLogradouroFornecedor(dados.getString("endereco"));
					ModelSuprimentos.setNumeroFornecedor(dados.getString("numero"));
					ModelSuprimentos.setComplementoFornecedor(dados.getString("complemento"));
					ModelSuprimentos.setBairroFornecedor(dados.getString("bairro"));
					ModelSuprimentos.setCidadeFornecedor(dados.getString("cidade"));
					ModelSuprimentos.setUfFornecedor(dados.getString("estado"));
					ModelSuprimentos.setCepFornecedor(dados.getString("cep"));
					ModelSuprimentos.setTelefone1(dados.getString("Telefone1"));
					ModelSuprimentos.setTelefone2(dados.getString("Telefone2"));
					ModelSuprimentos.setCelular1(dados.getString("celular1"));
					ModelSuprimentos.setCelular2(dados.getString("celular2"));
					ModelSuprimentos.setCnpjFornecedor(dados.getString("cnpj"));
					ModelSuprimentos.setIeFornecedor(dados.getString("inscricaoEstadual"));
					Suprimentos.labelFotoFornecedor.setText("");
					ModelSuprimentos.setImagemFornecedor(dados.getString("imagem").replace("~", "\\"));
					Suprimentos.button_atualizarImagemForn.setVisible(true);					
					
					Suprimentos.button_5.setEnabled(true);
					Suprimentos.buttonAnteriorF.setEnabled(true);
					Suprimentos.btnPrximoF.setEnabled(true);
					Suprimentos.button_13.setEnabled(true);
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;					
				}
			}
		}
	}
	
	public static void ConsultarFornAnterior(){
		if(ModelSuprimentos.getCodigoFornecedor().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.codigo5.requestFocus();
		}
		else if(Integer.parseInt(ModelSuprimentos.getCodigoFornecedor())>0){
			dados = x.Consultar("select*from fornecedor where codigoFornecedor = '" 
					+ String.valueOf(Integer.parseInt(ModelSuprimentos.getCodigoFornecedor())-1) + "'");
			gatilho1=1;
			Tipo="código";
			if(gatilho1==1){				
				try { // while(dados.next())
						// {
					dados.next();
					ModelSuprimentos.setCodigoFornecedor(dados.getString("codigoFornecedor"));
					ModelSuprimentos.setNomeFornecedor(dados.getString("nome"));
					ModelSuprimentos.setVendedor(dados.getString("vendedor"));
					ModelSuprimentos.setLogradouroFornecedor(dados.getString("endereco"));
					ModelSuprimentos.setNumeroFornecedor(dados.getString("numero"));
					ModelSuprimentos.setComplementoFornecedor(dados.getString("complemento"));
					ModelSuprimentos.setBairroFornecedor(dados.getString("bairro"));
					ModelSuprimentos.setCidadeFornecedor(dados.getString("cidade"));
					ModelSuprimentos.setUfFornecedor(dados.getString("estado"));
					ModelSuprimentos.setCepFornecedor(dados.getString("cep"));
					ModelSuprimentos.setTelefone1(dados.getString("Telefone1"));
					ModelSuprimentos.setTelefone2(dados.getString("Telefone2"));
					ModelSuprimentos.setCelular1(dados.getString("celular1"));
					ModelSuprimentos.setCelular2(dados.getString("celular2"));
					ModelSuprimentos.setCnpjFornecedor(dados.getString("cnpj"));
					ModelSuprimentos.setIeFornecedor(dados.getString("inscricaoEstadual"));
					Suprimentos.labelFotoFornecedor.setText("");
					ModelSuprimentos.setImagemFornecedor(dados.getString("imagem").replace("~", "\\"));
					Suprimentos.button_atualizarImagemForn.setVisible(true);					
					
					Suprimentos.button_5.setEnabled(true);
					Suprimentos.buttonAnteriorF.setEnabled(true);
					Suprimentos.btnPrximoF.setEnabled(true);
					Suprimentos.button_13.setEnabled(true);
					
				} catch (SQLException erro) {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho1=0;						
				}
			}
		}
	}
	
	public static void SetarBordaFornNull(){
		Suprimentos.iE.setBorder(null);
		Suprimentos.cnpj.setBorder(null);
		Suprimentos.cep.setBorder(null);
		Suprimentos.comboBox_cidade.setBorder(null);
		Suprimentos.comboBox_estado.setBorder(null);
		Suprimentos.bairro.setBorder(null);
		Suprimentos.complemento.setBorder(null);
		Suprimentos.numero.setBorder(null);
		Suprimentos.endereco.setBorder(null);
		Suprimentos.celular2.setBorder(null);
		Suprimentos.celular1.setBorder(null);		
		Suprimentos.telefone2.setBorder(null);
		Suprimentos.telefone1.setBorder(null);
		Suprimentos.vendedor.setBorder(null);
		Suprimentos.NomeFornecedor.setBorder(null);
		Suprimentos.codigo5.setBorder(null);
	}
	
	public static void AtualizarFornecedor(){
		VerificarCamposObrigatoriosForn();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else{
		String comandosql4 = "UPDATE `erp`.`fornecedor` SET `nome` = '" + ModelSuprimentos.getNomeFornecedor()
				  + "', `vendedor` = '" + ModelSuprimentos.getVendedor()
				  + "', `endereco` = '" + ModelSuprimentos.getLogradouroFornecedor()
				  + "', `complemento` = '" + ModelSuprimentos.getComplementoFornecedor()
				  + "', `bairro` = '" + ModelSuprimentos.getBairroFornecedor()				  
				  + "', `estado` = '" + ModelSuprimentos.getUfFornecedor()
				  + "', `cidade` = '" + ModelSuprimentos.getCidadeFornecedor()				
				  + "', `cep` = '" +  ModelSuprimentos.getCepFornecedor()
				  + "', `telefone1` = '" +  ModelSuprimentos.getTelefone1()
				  + "', `telefone2` = '" +  ModelSuprimentos.getTelefone2()
				  + "', `celular1` = '" +  ModelSuprimentos.getCelular1()
				  + "', `celular2` = '" +  ModelSuprimentos.getCelular2()
				  + "', `cnpj` = '" +  ModelSuprimentos.getCnpjFornecedor()
				  + "', `inscricaoEstadual` = '" +  ModelSuprimentos.getIeFornecedor()
				  + "' WHERE `fornecedor`.`codigoFornecedor` = '" + ModelSuprimentos.getCodigoFornecedor()+ "'";
		x.grava(comandosql4);
		JOptionPane.showMessageDialog(null," Dados Atualizados com sucesso !","Atualizar", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Estoque"
	
	public static void InserirEstoque() {
				
		if (Suprimentos.radioMateriaPrima.isSelected() == false && Suprimentos.radioProduto.isSelected() == false) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Selecione o que gostaria de Inserir no estoque.","Atenção", JOptionPane.WARNING_MESSAGE);
			Suprimentos.piscaTipo.setVisible(true);
		}	
		else{
		VerificarCamposObrigatoriosEstoque();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Atenção",JOptionPane.PLAIN_MESSAGE);
		}
		else if (Suprimentos.radioProduto.isSelected() == true){		
		
		String comandosql = "INSERT INTO estoque_produto(codigo, dataMovimento, dataCompra, validade, numeroLote, notaFiscal,"
				+ " quantidade, movimento, localEstoque, codigoFornecedor,usuario) VALUES('"
				+ ModelSuprimentos.getCodigo()		+ "','"
				+ ModelSuprimentos.getDataEntrada()	+ "','"
				+ ModelSuprimentos.getDataCompra()	+ "','"
				+ ModelSuprimentos.getValidade()	+ "','"
				+ ModelSuprimentos.getLote()		+ "','"
				+ ModelSuprimentos.getNotaFiscal()	+ "','"
				+ ModelSuprimentos.getQuantidade()	+ "','"
				+ "Entrada"							+ "','"
				+ ModelSuprimentos.getLocalEstoque()+ "','" 				
				+ ModelSuprimentos.getCodigoFornc()	+ "','"
				+ Login.User						+ "')";
		x.grava(comandosql);		
		AtualizarQuantEstoque();
		JOptionPane.showMessageDialog(null, "Inserção efetuada com sucesso!", "Inserir no Estoque",JOptionPane.PLAIN_MESSAGE);
		Suprimentos.piscaTipo.setVisible(false);
		Suprimentos.piscaTipo2.setVisible(false);
		SetarBordaEstNull();
		}
		else{
			String comandosql = "INSERT INTO estoque_mp(codigo, dataMovimento, dataCompra, validade, numeroLote, notaFiscal,"
				+ " quantidade, movimento, localEstoque, codigoFornecedor,usuario) VALUES('"
				+ ModelSuprimentos.getCodigo()		+ "','"
				+ ModelSuprimentos.getDataEntrada()	+ "','"
				+ ModelSuprimentos.getDataCompra()	+ "','"
				+ ModelSuprimentos.getValidade()	+ "','"
				+ ModelSuprimentos.getLote()		+ "','"
				+ ModelSuprimentos.getNotaFiscal()	+ "','"
				+ ModelSuprimentos.getQuantidade()	+ "','"
				+ "Entrada"							+ "','"
				+ ModelSuprimentos.getLocalEstoque()+ "','" 
				+ ModelSuprimentos.getCodigoFornc()	+ "','"
				+ Login.User						+ "')";
		x.grava(comandosql);		
		AtualizarQuantEstoque();
		JOptionPane.showMessageDialog(null, "Inserção efetuada com sucesso!", "Inserir no Estoque",JOptionPane.PLAIN_MESSAGE);
		Suprimentos.piscaTipo.setVisible(false);
		Suprimentos.piscaTipo2.setVisible(false);
		SetarBordaEstNull();
		}
	  }
	}
	
	public static void VerificarCamposObrigatoriosEstoque(){
		obrigatorios=0;
		if(ModelSuprimentos.getItem().toString().equals("")){
			obrigatorios++;
			Suprimentos.comboDesejaAdicionar.setBorder(new LineBorder(Color.BLUE));
		}
		else Suprimentos.comboDesejaAdicionar.setBorder(null);
		
		if(ModelSuprimentos.getDataCompra().toString().equals("  /  /    ")){
			Suprimentos.dataCompraEst.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.dataCompraEst.setBorder(null);
			
		if(ModelSuprimentos.getValidade().equals("  /  /    ")){
			Suprimentos.validadeEst.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.validadeEst.setBorder(null);
			
		if(ModelSuprimentos.getLote().toString().equals("")){
			Suprimentos.numeroLoteEst.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.numeroLoteEst.setBorder(null);
		
		if(ModelSuprimentos.getNotaFiscal().equals("")){
			Suprimentos.notaFiscalEst.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.notaFiscalEst.setBorder(null);
				
		if(ModelSuprimentos.getLocalEstoque().toString().equals("")){
			Suprimentos.comboLocalEstoque4.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboLocalEstoque4.setBorder(null);		
		
		if(ModelSuprimentos.getQuantidade().toString().equals("0")||ModelSuprimentos.getQuantidade().toString().equals("")){
			Suprimentos.quantidadeAdicionada.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.quantidadeAdicionada.setBorder(null);
		
		if(ModelSuprimentos.getNomeFornc().toString().equals("")){
			Suprimentos.comboNomeFornecedorEst.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else Suprimentos.comboNomeFornecedorEst.setBorder(null);		
	}
	
	public static void SetarBordaEstNull(){
		Suprimentos.comboNomeFornecedorEst.setBorder(null);
		Suprimentos.quantidadeAdicionada.setBorder(null);
		Suprimentos.comboLocalEstoque4.setBorder(null);		
		Suprimentos.notaFiscalEst.setBorder(null);
		Suprimentos.numeroLoteEst.setBorder(null);
		Suprimentos.validadeEst.setBorder(null);
		Suprimentos.dataCompraEst.setBorder(null);
		Suprimentos.comboDesejaAdicionar.setBorder(null);
	}
	
	public static void ConsultarProdEstoque() {
		indice=0;
		 if(Suprimentos.radioButton.isSelected() == true){
			dados = x.Consultar("select*from produtos where codigoProduto = '" + ModelSuprimentos.getCodigo() + "'");			
			Tipo="código";
			}
			else {
			dados = x.Consultar("select*from produtos where nome = '" + ModelSuprimentos.getNomeEstoque() + "'");			
			Tipo="nome";
			}
			Suprimentos.limparEstoque();
			try { // while(dados.next())
					// {
				dados.next();				
				ModelSuprimentos.setItem(dados.getString("nome"));
				ModelSuprimentos.setCodigo(dados.getString("codigoProduto"));
				Suprimentos.precoUnidadeEst.setText(dados.getString("precoVenda"));
				ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
				Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
				Suprimentos.unidadeEst.setText(dados.getString("unidade"));
				Suprimentos.descricaoEst.setText(dados.getString("descricaoProduto"));
				Suprimentos.labelFotoEstoque.setText("");
				ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
				
				if (dados.getString("fichaTecnica").equals("sim")) {
					ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ dados.getString("codigoProduto") + "'");
					while (dados2.next()) {
						Suprimentos.modeloficha2.addRow(new String[] { dados2.getString("numeroitem"),
								dados2.getString("codigomp"), dados2.getString("nome"),
								dados2.getString("unidade"), dados2.getString("preco"),
								dados2.getString("quantidade"), dados2.getString("custoagregado") });
						Suprimentos.contLinhaEst++;
					}						
				} else {
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "Este produto não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
					
				}	
				
					if (Double.parseDouble(ModelSuprimentos.getEstoqueAtual())<= 0) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Este produto encontra-se Zerado no estoque !", "Atenção",JOptionPane.WARNING_MESSAGE);
					}
					
						ResultSet dados3 = x.Consultar("select*from estoque_produto where codigo = '"+ModelSuprimentos.getCodigo()+ "'");
						dados3.next();						
						ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
							ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
							ModelSuprimentos.setValidade(dados3.getString("validade"));
							ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
							ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
							ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
							ModelSuprimentos.setMovimento(dados3.getString("movimento"));
							ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
							ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
							ModelSuprimentos.setUsuario(dados3.getString("usuario"));
							indice=dados3.getInt("indice");
							
							if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
								System.out.println("Entrou");
							ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
							dados33.next();
							Suprimentos.nomeEst.setText(dados33.getString("nome"));
							Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
							Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));
							}					
					Suprimentos.button_6.setEnabled(true);
					Suprimentos.button_7.setEnabled(true);
					Suprimentos.btnPrximo_3.setEnabled(true);					
			} catch (SQLException erro) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null," Não há movimentações de estoque para o "+Tipo+" digitado! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
			}					
	}
	
	public static void ConsultarProxProdEstoque(){
		ResultSet dados3 = x.Consultar("select*from estoque_produto where indice = '"+(indice+1)+ "'");		
		try {
			dados3.next();	
			if(dados3.getString("codigo").equals(ModelSuprimentos.getCodigo())){
			ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
			ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
			ModelSuprimentos.setValidade(dados3.getString("validade"));
			ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
			ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
			ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
			ModelSuprimentos.setMovimento(dados3.getString("movimento"));
			ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
			ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
			ModelSuprimentos.setUsuario(dados3.getString("usuario"));
			ModelSuprimentos.setCodigo(dados3.getString("codigo"));
			indice=dados3.getInt("indice");
			
			if(ModelSuprimentos.getCodigoFornc()!="****"){
			ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
			dados33.next();
			Suprimentos.nomeEst.setText(dados33.getString("nome"));
			Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
			Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));			
			}			
						
			dados = x.Consultar("select*from produtos where codigoProduto = '" + ModelSuprimentos.getCodigo() + "'");
			dados.next();				
			ModelSuprimentos.setItem(dados.getString("nome"));
			ModelSuprimentos.setCodigo(dados.getString("codigoProduto"));
			Suprimentos.precoUnidadeEst.setText(dados.getString("precoVenda"));
			ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
			Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
			Suprimentos.unidadeEst.setText(dados.getString("unidade"));
			Suprimentos.descricaoEst.setText(dados.getString("descricaoProduto"));
			Suprimentos.labelFotoEstoque.setText("");
			ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
			
			if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
				ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ ModelSuprimentos.getCodigo()+ "'");
				while (dados2.next()) {
					Suprimentos.modeloficha2.addRow(new String[] { dados2.getString("numeroitem"),
							dados2.getString("codigomp"), dados2.getString("nome"),
							dados2.getString("unidade"), dados2.getString("preco"),
							dados2.getString("quantidade"), dados2.getString("custoagregado") });
					Suprimentos.contLinhaEst++;
				}
				
			} else {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Este produto não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				indice++;
				ConsultarProxProdEstoque();
			}
		} catch (SQLException e) {
			indice=indice-2;
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			System.out.println(e);
		}	
	}
	
	public static void ConsultarProdAntEstoque(){
		if(indice>0){
		ResultSet dados3 = x.Consultar("select*from estoque_produto where indice = '"+(indice-1)+ "'");		
		try {
			dados3.next();	
			if(dados3.getString("codigo").equals(ModelSuprimentos.getCodigo())){
			ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
			ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
			ModelSuprimentos.setValidade(dados3.getString("validade"));
			ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
			ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
			ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
			ModelSuprimentos.setMovimento(dados3.getString("movimento"));
			ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
			ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
			ModelSuprimentos.setUsuario(dados3.getString("usuario"));
			ModelSuprimentos.setCodigo(dados3.getString("codigo"));
			indice=dados3.getInt("indice");
			
			if(ModelSuprimentos.getCodigoFornc()!="****"){
			ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
			dados33.next();
			Suprimentos.nomeEst.setText(dados33.getString("nome"));
			Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
			Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));			
			}			
						
			dados = x.Consultar("select*from produtos where codigoProduto = '" + ModelSuprimentos.getCodigo() + "'");
			dados.next();				
			ModelSuprimentos.setItem(dados.getString("nome"));
			ModelSuprimentos.setCodigo(dados.getString("codigoProduto"));
			Suprimentos.precoUnidadeEst.setText(dados.getString("precoVenda"));
			ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
			Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
			Suprimentos.unidadeEst.setText(dados.getString("unidade"));
			Suprimentos.descricaoEst.setText(dados.getString("descricaoProduto"));
			Suprimentos.labelFotoEstoque.setText("");
			ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
			
			if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
				ResultSet dados2 = x.Consultar("select*from fichatecnica where codigoproduto = '"+ ModelSuprimentos.getCodigo()+ "'");
				while (dados2.next()) {
					Suprimentos.modeloficha2.addRow(new String[] { dados2.getString("numeroitem"),
							dados2.getString("codigomp"), dados2.getString("nome"),
							dados2.getString("unidade"), dados2.getString("preco"),
							dados2.getString("quantidade"), dados2.getString("custoagregado") });
					Suprimentos.contLinhaEst++;
				}
				
			} else {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Este produto não possui ficha tecnica !", "Atenção",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				indice--;
				ConsultarProdAntEstoque();
			}
		} catch (SQLException e) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			System.out.println(e);
		}
		}
		else{
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void ConsultarMPEstoque() {
		indice=0;
		 if(Suprimentos.radioButton.isSelected() == true){
				dados = x.Consultar("select * from materia_p where codigo = '" + ModelSuprimentos.getCodigo() + "'");				
				Tipo="código";
				}
				else {
				dados = x.Consultar("select * from materia_p where nome = '" + ModelSuprimentos.getNomeEstoque() + "'");				
				Tipo="nome";
				}
		
		 Suprimentos.limparEstoque();
			try { // while(dados.next())
					// {
				dados.next();				
				ModelSuprimentos.setItem(dados.getString("nome"));
				ModelSuprimentos.setCodigo(dados.getString("codigo"));
				Suprimentos.precoUnidadeEst.setText("Não vendável");
				ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
				Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
				Suprimentos.unidadeEst.setText(dados.getString("unidade"));
				Suprimentos.descricaoEst.setText(dados.getString("descricaoMateriaPrima"));
				Suprimentos.labelFotoEstoque.setText("");
				ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));
				
					if (Double.parseDouble(ModelSuprimentos.getEstoqueAtual())<= 0) {
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(null, "Esta MP encontra-se Zerado no estoque !", "Atenção",JOptionPane.WARNING_MESSAGE);
					}
					
						ResultSet dados3 = x.Consultar("select*from estoque_mp where codigo = '"+ModelSuprimentos.getCodigo()+ "'");
						dados3.next();						
						ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
							ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
							ModelSuprimentos.setValidade(dados3.getString("validade"));
							ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
							ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
							ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
							ModelSuprimentos.setMovimento(dados3.getString("movimento"));
							ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
							ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
							ModelSuprimentos.setUsuario(dados3.getString("usuario"));
							indice=dados3.getInt("indice");
							
							if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
							ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
							dados33.next();
							Suprimentos.nomeEst.setText(dados33.getString("nome"));
							Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
							Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));						
							}					
						
					Suprimentos.button_6.setEnabled(true);
					Suprimentos.button_7.setEnabled(true);
					Suprimentos.btnPrximo_3.setEnabled(true);
			} catch (SQLException erro) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null," Não há movimentações de estoque para o "+Tipo+" digitado! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);				
			}
	}

	public static void ConsultarProxMPEstoque(){
		ResultSet dados3 = x.Consultar("select*from estoque_mp where indice = '"+(indice+1)+ "'");		
		try {
			dados3.next();	
			if(dados3.getString("codigo").equals(ModelSuprimentos.getCodigo())){
			ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
			ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
			ModelSuprimentos.setValidade(dados3.getString("validade"));
			ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
			ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
			ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
			ModelSuprimentos.setMovimento(dados3.getString("movimento"));
			ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
			ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
			ModelSuprimentos.setUsuario(dados3.getString("usuario"));
			ModelSuprimentos.setCodigo(dados3.getString("codigo"));
			indice=dados3.getInt("indice");
			
			if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
			ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
			dados33.next();
			Suprimentos.nomeEst.setText(dados33.getString("nome"));
			Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
			Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));			
			}			
						
			dados = x.Consultar("select*from materia_p where codigo = '" + ModelSuprimentos.getCodigo() + "'");
			dados.next();				
			ModelSuprimentos.setItem(dados.getString("nome"));
			ModelSuprimentos.setCodigo(dados.getString("codigo"));
			Suprimentos.precoUnidadeEst.setText("Não vendável");
			ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
			Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
			Suprimentos.unidadeEst.setText(dados.getString("unidade"));
			Suprimentos.descricaoEst.setText(dados.getString("descricaoMateriaPrima"));
			Suprimentos.labelFotoEstoque.setText("");
			ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));	
			 
			}
			else{
				indice++;
				ConsultarProxMPEstoque();
			}
		} catch (SQLException e) {
			indice=indice-2;
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			System.out.println(e);
		}	
	}
	
	public static void ConsultarMPAntEstoque(){
		if(indice>0){
			ResultSet dados3 = x.Consultar("select*from estoque_mp where indice = '"+(indice-1)+ "'");		
			try {
				dados3.next();	
				if(dados3.getString("codigo").equals(ModelSuprimentos.getCodigo())){
				ModelSuprimentos.setDataEntrada(dados3.getString("dataMovimento"));
				ModelSuprimentos.setDataCompra(dados3.getString("dataCompra"));
				ModelSuprimentos.setValidade(dados3.getString("validade"));
				ModelSuprimentos.setLote(dados3.getString("numeroLote"));							
				ModelSuprimentos.setNotaFiscal(dados3.getString("notaFiscal"));
				ModelSuprimentos.setQuantidade(dados3.getString("quantidade"));
				ModelSuprimentos.setMovimento(dados3.getString("movimento"));
				ModelSuprimentos.setLocalEstoque(dados3.getString("localEstoque"));							
				ModelSuprimentos.setCodigoFornc(dados3.getString("codigoFornecedor"));
				ModelSuprimentos.setUsuario(dados3.getString("usuario"));
				ModelSuprimentos.setCodigo(dados3.getString("codigo"));
				indice=dados3.getInt("indice");
				
				if(!(ModelSuprimentos.getCodigoFornc()).equals("Vazio")){
				ResultSet dados33 = x.Consultar("select*from fornecedor where codigoFornecedor = '"+ ModelSuprimentos.getCodigoFornc() + "'");
				dados33.next();
				Suprimentos.nomeEst.setText(dados33.getString("nome"));
				Suprimentos.codigoFornecedorEst.setText(dados33.getString("codigoFornecedor"));
				Suprimentos.ieEstoque.setText(dados33.getString("inscricaoEstadual"));			
				}			
							
				dados = x.Consultar("select*from materia_p where codigo = '" + ModelSuprimentos.getCodigo() + "'");
				dados.next();				
				ModelSuprimentos.setItem(dados.getString("nome"));
				ModelSuprimentos.setCodigo(dados.getString("codigo"));
				Suprimentos.precoUnidadeEst.setText("Não vendável");
				ModelSuprimentos.setEstoqueAtual(dados.getString("estoqueAtual"));
				Suprimentos.estoqueMinimoEst.setText(dados.getString("estoqueMinimo"));
				Suprimentos.unidadeEst.setText(dados.getString("unidade"));
				Suprimentos.descricaoEst.setText(dados.getString("descricaoMateriaPrima"));
				Suprimentos.labelFotoEstoque.setText("");
				ModelSuprimentos.setImagemEstoque(dados.getString("imagem").replace("~", "\\"));				
				}
				else{
					indice--;
					ConsultarMPAntEstoque();
				}
			} catch (SQLException e) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
				System.out.println(e);
			}
			}
			else{
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			}
	}
	
	protected static void AtualizarQuantEstoque(){
		estAtual=0.0;
		if (Suprimentos.radioProduto.isSelected() == true){
			dados = x.Consultar("select*from produtos where codigoProduto = '" + ModelSuprimentos.getCodigo() + "'");
			try {
				dados.next();
				estAtual=Double.parseDouble(dados.getString("estoqueAtual"));
			} catch (SQLException e) {				
				JOptionPane.showMessageDialog(null, e, "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if(Suprimentos.radioMateriaPrima.isSelected() == true){			
			dados = x.Consultar("select*from materia_p where codigo = '" + ModelSuprimentos.getCodigo() + "'");
			try {
				dados.next();
				estAtual=Double.parseDouble(dados.getString("estoqueAtual"));
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e, "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
			}
		}
		System.out.println(estAtual);
		double d = (Double.parseDouble(ModelSuprimentos.getQuantidade())+estAtual);
				
		if (Suprimentos.radioProduto.isSelected() == true){
			String comandosql4 = "UPDATE  `erp`.`produtos` SET  `estoqueAtual` =  '" + String.valueOf(d).replace(",", ".")
					+ "' WHERE  `produtos`.`codigoProduto` =  '" + ModelSuprimentos.getCodigo() + "'";
			x.grava(comandosql4);
		}
		else if(Suprimentos.radioMateriaPrima.isSelected() == true){
			String comandosql4 = "UPDATE  `erp`.`materia_p` SET  `estoqueAtual` =  '" + String.valueOf(d).replace(",", ".")
					+ "' WHERE  `materia_p`.`codigo` =  '" + ModelSuprimentos.getCodigo() + "'";
			x.grava(comandosql4);
		}
	}

}
