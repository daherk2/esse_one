package Solid.controller;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Solid.model.ModelRH;
import Solid.view.Menu;
import Solid.view.RH;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class RHController {
	static Solid.controller.BancoDados	x	= new Solid.controller.BancoDados();
	private static String			Tipo;
	static ResultSet				dados;
	private static int			gatilho, lo;
	
	public static void AbrirRH() {
		
		new RH();
		SetarPaineis(Menu.painel);
	}
	
	public static void SalvarFuncionario() {
		
		try {
			
			String comandosql = "INSERT INTO funcionarios(numeroRegistro, nome, nascimento, nacionalidade, rg, cpf, ctps, estadoCivil, email,"
					+ " nomePai, nomeMae, quantidadeDependente, escolaridade, telefone1, telefone2, celular1, celular2, dataAdmissao,"
					+ "tipoContrato, numeroContaBancaria, banco, logradouro, numeroCasa, complemento, bairro, estado, cidade, cep, cargo"
					+ ", salario, departamento) " + "VALUES('"
					+ ModelRH.getCodigo()
					+ "','"
					+ ModelRH.getNome()
					+ "','"
					+ ModelRH.getNascimento()
					+ "','"
					+ ModelRH.getNacionalidade()
					+ "','"
					+ ModelRH.getEmail()
					+ "','"
					+ ModelRH.getRg()
					+ "','"
					+ ModelRH.getCpf()
					+ "','"
					+ ModelRH.getCarteiraTrabalho()
					+ "','"
					+ ModelRH.getEstadoCivil()
					+ "','"
					+ ModelRH.getAdmissao()
					+ "','"
					+ ModelRH.getContrato()
					+ "','"
					+ ModelRH.getEscolaridade()
					+ "','"
					+ ModelRH.getNomePai()
					+ "','"
					+ ModelRH.getNomeMae()
					+ "','"
					+ ModelRH.getDependentes()
					+ "','"
					+ ModelRH.getBanco()
					+ "','"
					+ ModelRH.getConta()
					+ "','"
					+ ModelRH.getTelefone1()
					+ "','"
					+ ModelRH.getTelefone2()
					+ "','"
					+ ModelRH.getCelular1()
					+ "','"
					+ ModelRH.getCelular2()
					+ "','"
					+ ModelRH.getEndereco()
					+ "','"
					+ ModelRH.getBairro()
					+ "','"
					+ ModelRH.getNumero()
					+ "','"
					+ ModelRH.getComplemento()
					+ "','"
					+ ModelRH.getCep()
					+ "','"
					+ ModelRH.getEstado()
					+ "','"
					+ ModelRH.getCidade()
					+ "','"
					+ ModelRH.getFuncao()
					+ "','"
					+ ModelRH.getSalario()
					+ "','"
					+ ModelRH.getDepartamento() + "')";
			
			x.grava(comandosql);
			
			if (RH.sn == 1) {
				
				String comandosql1 = "INSERT INTO login1(registro, cpf, usuario, senha, nivel) VALUES('"
						+ ModelRH.getCodigo()
						+ "','"
						+ ModelRH.getCpf()
						+ "','"
						+ ModelRH.getUsuario()
						+ "','"
						+ ModelRH.getSenha()
						+ "','"
						+ ModelRH.getNivel() + "')";
				x.grava(comandosql1);
			}
			
			int d = Integer.parseInt(RH.NumeroRegistro1.getText());
			d++;
			
			String comandosql4 = "UPDATE  `erp`.`contadores` SET  `numeroRegistro` =  '"
					+ String.valueOf(d) + "' WHERE  `contadores`.`numeroRegistro` =  '"
					+ ModelRH.getCodigo() + "'";
			x.grava(comandosql4);
			x.grava(comandosql);
			
			RH.LimparDados();
			
			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);
			RH.NumeroRegistro1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			RH.NumeroRegistro1.setEditable(false);
			RH.NumeroRegistro1.setText(rs3.getString("numeroRegistro"));
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!",
					"Mensagem do Sistema", JOptionPane.PLAIN_MESSAGE);
			
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex + "Erro", "Mensagem do Sistema",
					JOptionPane.PLAIN_MESSAGE);
			ex.printStackTrace();
		}
		
	}
	
	public static void ConsultarFuncionario() {
		
		if (RH.comboPor.getSelectedItem().toString().equals("")) {
			JOptionPane.showMessageDialog(null, " Selecione um parâmetro para a consulta. ",
					"Atenção", JOptionPane.WARNING_MESSAGE);
			
		}
		else if (RH.comboPor.getSelectedItem().toString().equals("Numero de Registro")) {
			dados = x.Consultar("select*from funcionarios where numeroRegistro = '"
					+ ModelRH.getCodigo() + "'");
			gatilho = 1;
			Tipo = "numero de registro";
			
		}
		else if (RH.comboPor.getSelectedItem().toString().equals("Nome")) {
			dados = x.Consultar("select*from funcionarios where nome = '" + ModelRH.getNome()
					+ "'");
			gatilho = 1;
			Tipo = "nome";
			
		}
		else if (RH.comboPor.getSelectedItem().toString().equals("CPF")) {
			dados = x.Consultar("select*from funcionarios where cpf = '" + ModelRH.getCpf()
					+ "'");
			gatilho = 1;
			Tipo = "CPF";
		}
		
		if (gatilho == 1) {
			
			try {
				
				dados.next();
				
				ModelRH.setCodigo(dados.getString("numeroRegistro"));
				ModelRH.setNome(dados.getString("nome"));
				ModelRH.setNascimento(dados.getString("nascimento"));
				ModelRH.setNacionalidade(dados.getString("nacionalidade"));
				ModelRH.setEmail(dados.getString("email"));
				ModelRH.setRg(dados.getString("rg"));
				ModelRH.setCpf(dados.getString("cpf"));
				ModelRH.setCarteiraTrabalho(dados.getString("ctps"));
				ModelRH.setEstadoCivil(dados.getString("estadoCivil"));
				ModelRH.setAdmissao(dados.getString("dataAdmissao"));
				ModelRH.setContrato(dados.getString("tipoContrato"));
				ModelRH.setEscolaridade(dados.getString("escolaridade"));
				ModelRH.setNomePai(dados.getString("nomePai"));
				ModelRH.setNomeMae(dados.getString("nomeMae"));
				ModelRH.setBanco(dados.getString("banco"));
				ModelRH.setDependentes(dados.getString("quantidadeDependente"));
				ModelRH.setConta(dados.getString("numeroContaBancaria"));
				ModelRH.setTelefone1(dados.getString("telefone1"));
				ModelRH.setTelefone2(dados.getString("telefone2"));
				ModelRH.setCelular1(dados.getString("Celular1"));
				ModelRH.setCelular2(dados.getString("Celular2"));
				ModelRH.setEndereco(dados.getString("logradouro"));
				ModelRH.setBairro(dados.getString("bairro"));
				ModelRH.setNumero(dados.getString("numeroCasa"));
				ModelRH.setComplemento(dados.getString("Complemento"));
				ModelRH.setCep(dados.getString("cep"));
				ModelRH.setEstado(dados.getString("estado"));
				ModelRH.setCidade(dados.getString("cidade"));
				ModelRH.setFuncao(dados.getString("cargo"));
				ModelRH.setSalario(dados.getString("salario"));
				ModelRH.setDepartamento(dados.getString("departamento"));
				lo = 1;
				gatilho = 0;
				
				if (ModelRH.getCodigo().equals(dados.getString("numeroRegistro"))) {
					RH.button_2.setEnabled(true);
					RH.btnImprimir.setEnabled(true);
					RH.btnAnterior.setEnabled(true);
					RH.btnPrximo.setEnabled(true);
				}
				
			}
			catch (SQLException erro) {
				
				JOptionPane.showMessageDialog(null, " O " + Tipo
						+ " digitado não existe! Tente outro " + Tipo + "  ",
						"Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho = 0;
			}
			
			if (lo == 1) {
				
				ResultSet dadosl = x.Consultar("select*from login1 where registro = '"
						+ ModelRH.getCodigo() + "'");
				
				try {
					dadosl.next();
					
					if (ModelRH.getCodigo().equals(dadosl.getString("registro"))) {
						
						ModelRH.setUsuario(dadosl.getString("usuario"));
						ModelRH.setSenha(dadosl.getString("senha"));
						ModelRH.setNivel(dadosl.getString("nivel"));
						
					}
					
				}
				catch (SQLException erro) {
					
					JOptionPane.showMessageDialog(null,
							" O funcionario consultado não possui Lgin de rede! ",
							"Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho = 0;
					RH.NumeroRegistro1.setText(null);
					RH.NumeroRegistro1.requestFocus();
				}
			}
			lo = 0;
		}
	}
	
	public static void AtualizarFuncionario() {
		
		String comandosql4 = "UPDATE `erp`.`funcionarios` SET `nome` = '" + ModelRH.getNome()
				+ "', `nascimento` = '" + ModelRH.getNascimento()
				+ "', `nacionalidade` = '" + ModelRH.getNacionalidade() + "', `rg` = '"
				+ ModelRH.getRg() + "', `cpf` = '" + ModelRH.getCpf() + "', `ctps` = '"
				+ ModelRH.getCarteiraTrabalho() + "', `estadoCivil` = '"
				+ ModelRH.getEstadoCivil() + "', `email` = '" + ModelRH.getEmail()
				+ "', `nomePai` = '" + ModelRH.getNomePai() + "', `nomeMae` = '"
				+ ModelRH.getNomeMae() + "', `quantidadeDependente` = '"
				+ ModelRH.getDependentes() + "', `telefone1` = '" + ModelRH.getTelefone1()
				+ "', `telefone2` = '" + ModelRH.getTelefone2() + "', `celular1` = '"
				+ ModelRH.getCelular1() + "', `celular2` = '" + ModelRH.getCelular2()
				+ "', `dataAdmissao` = '" + ModelRH.getAdmissao() + "', `tipoContrato` = '"
				+ ModelRH.getContrato() + "', `numeroContaBancaria` = '"
				+ ModelRH.getConta() + "', `banco` = '" + ModelRH.getBanco()
				+ "', `logradouro` = '" + ModelRH.getEndereco() + "', `numeroCasa` = '"
				+ ModelRH.getNumero() + "', `complemento` = '" + ModelRH.getComplemento()
				+ "', `bairro` = '" + ModelRH.getBairro() + "', `estado` = '"
				+ ModelRH.getEstado() + "', `cidade` = '" + ModelRH.getCidade()
				+ "', `cep` = '" + ModelRH.getCep() + "', `cargo` = '"
				+ ModelRH.getFuncao() + "', `salario` = '" + ModelRH.getSalario()
				+ "', `departamento` = '" + ModelRH.getDepartamento()
				+ "' WHERE `funcionarios`.`numeroRegistro` = '" + ModelRH.getCodigo() + "'";
		
		x.grava(comandosql4);
		
		if (RH.sn == 1) {
			
			String comandosql5 = "UPDATE `erp`.`login1` SET `cpf` = '" + ModelRH.getCpf()
					+ "', `usuario` = '" + ModelRH.getUsuario() + "', `senha` = '"
					+ ModelRH.getSenha() + "', `nivel` = '" + ModelRH.getNivel()
					+ "' WHERE `login1`.`numeroRegistro` = '" + ModelRH.getCodigo() + "'";
			x.grava(comandosql5);
		}
		
		JOptionPane.showMessageDialog(null, " Dados Atualizados com sucesso !", "Atenção",
				JOptionPane.WARNING_MESSAGE);
	}
	
	public static void SelecionarFotoFuncionario() {
		
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
			RH.labelFotoFuncionario.setIcon(new javax.swing.ImageIcon(img));
			RH.labelFotoFuncionario.setText("");
			
		}
		else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}
		
	}
	
	public static void SetarPaineis(int seq) {
		
		try {
			
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			
			if (seq == 1) {
				RH.tabbedPaneRH.removeAll();
				RH.tabbedPaneRH.addTab("Cadastrar Funcionário ", new ImageIcon(RH.class
						.getResource("/icones1_24px/1425606608_pencil-128.png")),
						RH.panelFuncionario, null);
				RH.tabbedPaneRH
						.addTab("Holerite",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),
								RH.panelCargoSalario, null);
				RH.tabbedPaneRH
						.addTab("Treinamento / Desenvolvimento",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),
								RH.panelTreinamentos, null);
				RH.tabbedPaneRH
						.addTab("Relatórios",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								RH.panelRelatorios, null);
				
			}
			else if (seq == 2) {
				
				RH.tabbedPaneRH.removeAll();
				RH.tabbedPaneRH
						.addTab("Holerite",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),
								RH.panelCargoSalario, null);
				RH.tabbedPaneRH.addTab("Cadastrar Funcionário ", new ImageIcon(RH.class
						.getResource("/icones1_24px/1425606608_pencil-128.png")),
						RH.panelFuncionario, null);
				RH.tabbedPaneRH
						.addTab("Treinamento / Desenvolvimento",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),
								RH.panelTreinamentos, null);
				RH.tabbedPaneRH
						.addTab("Relatórios",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								RH.panelRelatorios, null);
			}
			
			else if (seq == 3) {
				
				RH.tabbedPaneRH.removeAll();
				RH.tabbedPaneRH
						.addTab("Treinamento / Desenvolvimento",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),
								RH.panelTreinamentos, null);
				RH.tabbedPaneRH
						.addTab("Holerite",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),
								RH.panelCargoSalario, null);
				RH.tabbedPaneRH.addTab("Cadastrar Funcionário ", new ImageIcon(RH.class
						.getResource("/icones1_24px/1425606608_pencil-128.png")),
						RH.panelFuncionario, null);
				RH.tabbedPaneRH
						.addTab("Relatórios",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								RH.panelRelatorios, null);
			}
			
			else if (seq == 4) {
				
				RH.tabbedPaneRH.removeAll();
				RH.tabbedPaneRH
						.addTab("Relatórios",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),
								RH.panelRelatorios, null);
				RH.tabbedPaneRH.addTab("Cadastrar Funcionário ", new ImageIcon(RH.class
						.getResource("/icones1_24px/1425606608_pencil-128.png")),
						RH.panelFuncionario, null);
				RH.tabbedPaneRH
						.addTab("Holerite",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),
								RH.panelCargoSalario, null);
				RH.tabbedPaneRH
						.addTab("Treinamento / Desenvolvimento",
								new ImageIcon(
										RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),
								RH.panelTreinamentos, null);
				
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
	
}
