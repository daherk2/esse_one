package Solid.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

import Solid.model.ModelLogistica;
import Solid.view.Logistica;
import Solid.view.MainSolid1;
import Solid.view.Menu;
import Solid.view.Vendas;


public class LogisticaController {
	
	static BancoDados x	= new BancoDados();
	private static int gatilho=0;
	private static String Tipo;
	static ResultSet dados;
	
	public static void AbrirLogistica() {
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();              
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            new Logistica();		
    		SetarPaineis(Menu.painel);	
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }			
	}

	private static void SetarPaineis(int seq) {
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();              
			props.put("logoString", "Solid - One");
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		
		if (seq == 1) {			
			Logistica.tabbedPane.removeAll();
			Logistica.tabbedPane.addTab("Veículo",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606739_678100-tachometer-128.png")),Logistica.panelVeiculo, null);
			Logistica.tabbedPane.addTab("Motorista",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")),Logistica.panelMotorista, null);
			Logistica.tabbedPane.addTab("Transportadora",	new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606771_678086-institution-128.png")),Logistica.panelTransportadora, null);
			Logistica.tabbedPane.addTab("Entregas ",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606563_map-128.png")),Logistica.panelEntrega, null);
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		}
		else if (seq == 2) {			
			Logistica.tabbedPane.removeAll();
			Logistica.tabbedPane.addTab("Motorista",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")),Logistica.panelMotorista, null);
			Logistica.tabbedPane.addTab("Veículo",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606739_678100-tachometer-128.png")),Logistica.panelVeiculo, null);
			Logistica.tabbedPane.addTab("Transportadora",	new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606771_678086-institution-128.png")),Logistica.panelTransportadora, null);
			Logistica.tabbedPane.addTab("Entregas ",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606563_map-128.png")),Logistica.panelEntrega, null);
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		}
		else if (seq == 3) {			
			Logistica.tabbedPane.removeAll();
			Logistica.tabbedPane.addTab("Transportadora",	new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606771_678086-institution-128.png")),Logistica.panelTransportadora, null);
			Logistica.tabbedPane.addTab("Motorista",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")),Logistica.panelMotorista, null);
			Logistica.tabbedPane.addTab("Veículo",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606739_678100-tachometer-128.png")),Logistica.panelVeiculo, null);
			Logistica.tabbedPane.addTab("Entregas ",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606563_map-128.png")),Logistica.panelEntrega, null);
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		}
		else if (seq == 4) {			
			Logistica.tabbedPane.removeAll();
			Logistica.tabbedPane.addTab("Entregas ",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606563_map-128.png")),Logistica.panelEntrega, null);
			Logistica.tabbedPane.addTab("Motorista",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606648_678109-profile-group-128.png")),Logistica.panelMotorista, null);
			Logistica.tabbedPane.addTab("Veículo",new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606739_678100-tachometer-128.png")),Logistica.panelVeiculo, null);
			Logistica.tabbedPane.addTab("Transportadora",	new ImageIcon(Logistica.class.getResource("/icones1_24px/1425606771_678086-institution-128.png")),Logistica.panelTransportadora, null);
			McWinLookAndFeel.setCurrentTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		}
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		//Metodos da aba "Motorista"	
	public static void SalvarFuncionario() {
		String comandosql = "INSERT INTO motorista( nome, nascimento, nacionalidade, email, rg, cpf, ctps, estadoCivil, dataAdmissao, tipoContrato, escolaridade,"
				                                 + "nomePai, nomeMae, banco, numeroContaBancaria, telefone1, telefone2, celular1, celular2, logradouro, bairro,"
				                                 + "numeroCasa, complemento, cep, estado, cidade, cargo, salario, departamento, numeroCnh, dataVencimento, Categoria) "
			+ "VALUES('"
			+ ModelLogistica.getNome()
			+ "','"
			+ ModelLogistica.getNascimento()
			+ "','"
			+ ModelLogistica.getNacionalidade()
			+ "','"
			+ ModelLogistica.getEmail()
			+ "','"
			+ ModelLogistica.getRg()
			+ "','"
			+ ModelLogistica.getCpf()
			+ "','"
			+ ModelLogistica.getCarteiraTrabalho()
			+ "','"
			+ ModelLogistica.getEstadoCivil()
			+ "','"
			+ ModelLogistica.getAdmissao()
			+ "','"
			+ ModelLogistica.getContrato()
			+ "','"
			+ ModelLogistica.getEscolaridade()
			+ "','"
			+ ModelLogistica.getNomePai()
			+ "','"
			+ ModelLogistica.getNomeMae()
			+ "','"
			+ ModelLogistica.getBanco()
			+ "','"
			+ ModelLogistica.getConta()
			+ "','"
			+ ModelLogistica.getTelefone1()
			+ "','"
			+ ModelLogistica.getTelefone2()
			+ "','"
			+ ModelLogistica.getCelular1()
			+ "','"
			+ ModelLogistica.getCelular2()
			+ "','"
			+ ModelLogistica.getEndereco()
			+ "','"
			+ ModelLogistica.getBairro()
			+ "','"
			+ ModelLogistica.getNumero()
			+ "','"
			+ ModelLogistica.getComplemento()
			+ "','"
			+ ModelLogistica.getCep()
			+ "','"
			+ ModelLogistica.getEstado()
			+ "','"
			+ ModelLogistica.getCidade()
			+ "','"
			+ ModelLogistica.getFuncao()
			+ "','"
			+ ModelLogistica.getSalario()
			+ "','"
			+ ModelLogistica.getDepartamento()
			+ "','"
			+ ModelLogistica.getNumeroCnh()
			+ "','"
			+ ModelLogistica.getDataVencimento()
			+ "','"
			+ ModelLogistica.getCategoria()
			+ "')";
	
	x.grava(comandosql);

	JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
	
}

	public static void PesquisarFuncionario() {
		if(Logistica.comboPor2.getSelectedItem().toString().equals("")){
		JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if(Logistica.comboPor2.getSelectedItem().toString().equals("Nº de Registro")){
		dados = x.Consultar("select*from motorista where numeroRegistro = '" + ModelLogistica.getCodigo() + "'");
		gatilho=1;
		Tipo="numero de registro";
		}
		else if(Logistica.comboPor2.getSelectedItem().toString().equals("Nome")){
		dados = x.Consultar("select*from motorista where nome = '" + ModelLogistica.getNome() + "'");
		gatilho=1;
		Tipo="nome";
		}
		else if(Logistica.comboPor2.getSelectedItem().toString().equals("CPF")){
			dados = x.Consultar("select*from motorista where cpf = '" + ModelLogistica.getCpf() + "'");
			gatilho=1;
			Tipo="CPF";
		}
		
		if(gatilho==1){
		try {
			dados.next();			
			ModelLogistica.setCodigo(dados.getString("numeroRegistro"));
			ModelLogistica.setNome(dados.getString("nome"));
			ModelLogistica.setNascimento(dados.getString("nascimento"));
			ModelLogistica.setNacionalidade(dados.getString("nacionalidade"));
			ModelLogistica.setEmail(dados.getString("email"));
			ModelLogistica.setRg(dados.getString("rg"));
			ModelLogistica.setCpf(dados.getString("cpf"));
			ModelLogistica.setCarteiraTrabalho(dados.getString("ctps"));
			ModelLogistica.setEstadoCivil(dados.getString("estadoCivil"));
			ModelLogistica.setAdmissao(dados.getString("dataAdmissao"));
			ModelLogistica.setContrato(dados.getString("tipoContrato"));
			ModelLogistica.setEscolaridade(dados.getString("escolaridade"));
			ModelLogistica.setNomePai(dados.getString("nomePai"));
			ModelLogistica.setNomeMae(dados.getString("nomeMae"));
			ModelLogistica.setBanco(dados.getString("banco"));
			ModelLogistica.setConta(dados.getString("numeroContaBancaria"));
			ModelLogistica.setTelefone1(dados.getString("telefone1"));
			ModelLogistica.setTelefone2(dados.getString("telefone2"));
			ModelLogistica.setCelular1(dados.getString("Celular1"));
			ModelLogistica.setCelular2(dados.getString("Celular2"));
			ModelLogistica.setEndereco(dados.getString("logradouro"));
			ModelLogistica.setBairro(dados.getString("bairro"));
			ModelLogistica.setNumero(dados.getString("numeroCasa"));
			ModelLogistica.setComplemento(dados.getString("Complemento"));
			ModelLogistica.setCep(dados.getString("cep"));
			ModelLogistica.setFuncao(dados.getString("cargo"));
			ModelLogistica.setSalario(dados.getString("salario"));
			ModelLogistica.setDepartamento(dados.getString("departamento"));
			ModelLogistica.setNumeroCnh(dados.getString("numeroCnh"));
			ModelLogistica.setDataVencimento(dados.getString("dataVencimento"));
			ModelLogistica.setCategoria(dados.getString("categoria"));
			gatilho=0;
			if(ModelLogistica.getCodigo()==Integer.parseInt(dados.getString("numeroRegistro"))){
				Logistica.btnAlterar.setVisible(true);
				Logistica.buttonAnterior.setVisible(true);
				Logistica.btnProximo.setVisible(true);
				Logistica.btImprimir.setVisible(true);				
			}
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null," O "+Tipo+" digitado não existe! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
			gatilho=0;
		}
		}
	}

	public static void PesquisarFuncionarioAnterior() {
		ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()-1));
		ResultSet dados = x.Consultar("select*from motorista where numeroRegistro = '" + (ModelLogistica.getCodigo()) + "'");
		try {
			dados.next();		
					
			if(ModelLogistica.getCodigo()==Integer.parseInt(dados.getString("numeroRegistro"))){
				PesquisarFuncionario();
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null," Não há mais registros nesta direção! ","Atenção", JOptionPane.WARNING_MESSAGE);
			ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()+1));
		}		
	}
	
	public static void PesquisarFuncionarioProximo() {
		ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()+1));
		ResultSet dados = x.Consultar("select*from motorista where numeroRegistro = '" + (ModelLogistica.getCodigo()) + "'");
		try {
			dados.next();		
					
			if(ModelLogistica.getCodigo()==Integer.parseInt(dados.getString("numeroRegistro"))){
				PesquisarFuncionario();
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null," Não há mais registros nesta direção! ","Atenção", JOptionPane.WARNING_MESSAGE);
			ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()-1));
		}			
	}
	
	public static void AtualizarFuncionario() {
		String comandosql4 = "UPDATE `logistica`.`motorista` SET `nome` = '" + ModelLogistica.getNome()+ "', `nascimento` = '" + ModelLogistica.getNascimento()
												  + "', `nacionalidade` = '" + ModelLogistica.getNacionalidade() + "', `email` = '" + ModelLogistica.getEmail()
												  + "', `rg` = '" + ModelLogistica.getRg()+ "', `cpf` = '" + ModelLogistica.getCpf()  + "', `ctps` = '" +ModelLogistica.getCarteiraTrabalho()
												  + "', `estadoCivil` = '" + ModelLogistica.getEstadoCivil()+ "', `dataAdmissao` = '" + ModelLogistica.getAdmissao()
												  + "', `tipoContrato` = '" + ModelLogistica.getContrato() + "', `escolaridade` = '" + ModelLogistica.getEscolaridade()
												  + "', `nomePai` = '" + ModelLogistica.getNomePai()+ "', `nomeMae` = '" + ModelLogistica.getNomeMae()
												  + "', `telefone1` = '" + ModelLogistica.getTelefone1() + "', `telefone2` = '" + ModelLogistica.getTelefone2()
												  + "', `celular1` = '" + ModelLogistica.getCelular1() + "', `celular2` = '" + ModelLogistica.getCelular2()
												  + "', `logradouro` = '" + ModelLogistica.getEndereco()+ "', `bairro` = '" + ModelLogistica.getBairro()
												  + "', `numeroCasa` = '" + ModelLogistica.getNumero()+ "', `complemento` = '" + ModelLogistica.getComplemento()
												  + "', `cep` = '" + ModelLogistica.getCep()+ "', `estado` = '" + ModelLogistica.getEstado()
												  + "', `cidade` = '" + ModelLogistica.getCidade() + "', `salario` = '" + ModelLogistica.getSalario()
												  + "', `numeroCnh` = '" + ModelLogistica.getNumeroCnh() + "', `dataVencimento` = '" + ModelLogistica.getDataVencimento()
												  + "' WHERE `motorista`.`numeroRegistro` = '" + ModelLogistica.getCodigo()+ "'";
		x.grava(comandosql4);
		
	}
			
	public static void LimparFuncionario() {
		Logistica.NumeroRegistro.setText("");
		Logistica.Nome.setText("");
		Logistica.Nascimento.setText("");
		Logistica.Nacionalidade.setText("");
		Logistica.Email.setText("");
		Logistica.Rg.setText("");
		Logistica.Cpf.setText("");
		Logistica.Ctps.setText("");
		Logistica.EstadoCivil.setText("");
		Logistica.Admissao.setText("");
		Logistica.comboContrato.setSelectedItem("");
		Logistica.ContratoPesq.setText("");
		Logistica.comboEscolaridade.setSelectedItem("");
		Logistica.EscolaridadePesq.setText("");
		Logistica.NomePai.setText("");
		Logistica.NomeMae.setText("");
		Logistica.comboBanco.setSelectedItem("");
		Logistica.BancoPesq.setText("");
		Logistica.Conta.setText("");
		Logistica.Telefone1.setText("");
		Logistica.Telefone2.setText("");
		Logistica.Celular1.setText("");
		Logistica.Celular2.setText("");
		Logistica.Endereco.setText("");
		Logistica.Bairro.setText("");
		Logistica.Numero.setText("");
		Logistica.Complemento.setText("");
		Logistica.Cep.setText("");
		Logistica.comboUF.setSelectedItem("");
		Logistica.comboCidade.setSelectedItem("");
		Logistica.comboCargo.setSelectedItem("");
		Logistica.CargoPesq.setText("");
		Logistica.Salario.setText("");
		Logistica.Departamento.setText("Logistica");
		Logistica.NumeroCnh.setText("");
		Logistica.DataVencimento.setText("");
		Logistica.comboCategoria.setSelectedItem("");
		Logistica.CategoriaPesq.setText("");
		Logistica.btnAlterar.setVisible(false);
		Logistica.buttonAnterior.setVisible(false);
		Logistica.btnProximo.setVisible(false);
		Logistica.btnCancelar.setVisible(false);
		Logistica.comboPor2.setSelectedItem("");
		
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Veiculo"	
	public static void SalvarVeiculo() {
		String comandosql = "INSERT INTO veiculos(modelo, chassi, documento, tipo, placa, anoFabricacao, licenciamento, combustivel, categoria, marca,kilometragem, cor, especie, ipva, numeroSeguro, aquisiçao,imagem) "
				+ "VALUES('"
				+ ModelLogistica.getModelo()
				+ "','"
				+ ModelLogistica.getNumeroChassi()
				+ "','"
				+ ModelLogistica.getNumeroDocumento()
				+ "','"
				+ ModelLogistica.getTipo()
				+ "','"
				+ ModelLogistica.getPlaca()
				+ "','"
				+ ModelLogistica.getAnoFabricacao()
				+ "','"
				+ ModelLogistica.getLicenciamento()
				+ "','"
				+ ModelLogistica.getCombustivel()
				+ "','"
				+ ModelLogistica.getCategoria()
				+ "','"
				+ ModelLogistica.getMarca()
				+ "','"
				+ ModelLogistica.getKilometragem()
				+ "','"
				+ ModelLogistica.getCor()
				+ "','"
				+ ModelLogistica.getEspecie()
				+ "','"
				+ ModelLogistica.getIpva()
				+ "','"
				+ ModelLogistica.getSeguro()
				+ "','"
				+ ModelLogistica.getAquisicao()
				+ "','"
				+ ModelLogistica.getImagem() 
				+ "')";		
		x.grava(comandosql);
		JOptionPane.showMessageDialog(null,"Dados Salvos com sucesso !!","Salvar", JOptionPane.INFORMATION_MESSAGE);

	} 
	
	public static void ConsultarVeiculo() {
		if(Logistica.comboPor.getSelectedItem().toString().equals("")){
			JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
			}
			else if(Logistica.comboPor.getSelectedItem().toString().equals("Codigo")){
				dados = x.Consultar("select*from veiculos where codigo = '" + ModelLogistica.getCodigo1() + "'");
			gatilho=1;
			Tipo="O código";
			}
			else if(Logistica.comboPor.getSelectedItem().toString().equals("Modelo")){
				dados = x.Consultar("select*from veiculos where modelo = '" + ModelLogistica.getModelo() + "'");
			gatilho=1;
			Tipo="O modelo";
			}
			else if(Logistica.comboPor.getSelectedItem().toString().equals("Placa")){
				dados = x.Consultar("select*from veiculos where placa = '" + ModelLogistica.getPlaca() + "'");
				gatilho=1;
				Tipo="A placa";
			}
			
			if(gatilho==1){
		 	try {
			dados.next();
			if( ModelLogistica.getCodigo1()==Integer.parseInt(dados.getString("codigo"))){
				ModelLogistica.setCodigo1(dados.getString("codigo"));
				ModelLogistica.setModelo(dados.getString("modelo"));
				ModelLogistica.setNumeroChassi(dados.getString("numeroChassi"));
				ModelLogistica.setNumeroDocumento(dados.getString("numeroDocumento"));
				ModelLogistica.setPlaca(dados.getString("placa"));
				ModelLogistica.setAnoFabricacao(dados.getString("anoFabricacao"));
				ModelLogistica.setLicenciamento(dados.getString("licenciamento"));
				ModelLogistica.setCombustivel(dados.getString("combustivel"));
				ModelLogistica.setTipo(dados.getString("tipo"));
				ModelLogistica.setMarca(dados.getString("marca"));
				ModelLogistica.setKilometragem(dados.getString("kilometragem"));
				ModelLogistica.setEspecie(dados.getString("especie"));								
				ModelLogistica.setCor(dados.getString("cor"));				
				ModelLogistica.setIpva(dados.getString("ipva"));
				ModelLogistica.setSeguro(dados.getString("seguroObrigatorio"));
				ModelLogistica.setAquisicao(dados.getString("aquisicao"));
				ModelLogistica.setCategoria(dados.getString("categoria"));
				ModelLogistica.setImagem(dados.getString("imagem").replace("~", "\\"));
				Logistica.AtualizarIMG.setVisible(true);
				
			gatilho=0;
			}
			if(ModelLogistica.getCodigo1()==Integer.parseInt(dados.getString("codigo"))){
				Logistica.btAlterar.setVisible(true);
				Logistica.buttonAnterior1.setVisible(true);
				Logistica.buttonProximo1.setVisible(true);
				Logistica.btImprimir2.setVisible(true);				
			}
			

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null,erro+ Tipo+" digitado não existe! Tente outro.    ","Atenção", JOptionPane.WARNING_MESSAGE);
			gatilho=0;
		}
		}
	}

	public static void AtualizarVeiculo() {
		String comandosql4 = "UPDATE `erp`.`veiculos` SET `modelo` = '" + ModelLogistica.getModelo()+ "', `numeroChassi` = '" + ModelLogistica.getNumeroChassi()
				  + "', `numeroDocumento` = '" + ModelLogistica.getNumeroDocumento() + "', `tipo` = '" + ModelLogistica.getTipo()
				  + "', `placa` = '" + ModelLogistica.getPlaca()+ "', `anoFabricacao` = '" + ModelLogistica.getAnoFabricacao()  + "', `licenciamento` = '" +ModelLogistica.getLicenciamento()
				  + "', `combustivel` = '" + ModelLogistica.getCombustivel()+ "', `categoria` = '" + ModelLogistica.getCategoria()
				  + "', `marca` = '" + ModelLogistica.getMarca() + "', `kilometragem` = '" + ModelLogistica.getKilometragem()
				  + "', `cor` = '" + ModelLogistica.getCor()+ "', `especie` = '" + ModelLogistica.getEspecie()
				  + "', `ipva` = '" + ModelLogistica.getIpva()+ "', `seguroObrigatorio` = '" + ModelLogistica.getSeguro()
				  + "', `aquisicao` = '" +ModelLogistica.getAquisicao()
				  + "', `imagem` = '" +ModelLogistica.getImagem()
				  + "' WHERE `veiculos`.`codigo` = '" + ModelLogistica.getCodigo1()+ "'";
		x.grava(comandosql4);
		JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso !!","Atualização", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public static void PesquisarVeiculoAnterior() {
		ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()-1));
		ResultSet dados = x.Consultar("select*from veiculos where codigo = '" + ModelLogistica.getCodigo1() + "'");
		try {
			dados.next();		
					
			if(ModelLogistica.getCodigo1()==Integer.parseInt(dados.getString("codigo"))){
				ConsultarVeiculo();
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null," Não há mais registros nesta direção! ","Atenção", JOptionPane.WARNING_MESSAGE);
			ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo1()+1));
		}
		
	}

	public static void PesquisarVeiculoProximo() {
		ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo()+1));
		ResultSet dados = x.Consultar("select*from veiculos where codigo = '" + ModelLogistica.getCodigo1() + "'");
		try {
			dados.next();		
					
			if(ModelLogistica.getCodigo1()==Integer.parseInt(dados.getString("codigo"))){
				ConsultarVeiculo();
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null," Não há mais registros nesta direção! ","Atenção", JOptionPane.WARNING_MESSAGE);
			ModelLogistica.setCodigo(String.valueOf(ModelLogistica.getCodigo1()-1));
		}		
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Transportadora"	
	public static void SalvarTransportadora() {
		String comandosql = "INSERT INTO transportadora (razaoSocial, endereco, bairro, numero, complemento, cep, uf, cidade, cnpj, inscricaoEstadual) "
				+ "VALUES('"
				+ ModelLogistica.getRazaoSocial()
				+ "','"
				+ ModelLogistica.getEndereco1()
				+ "','"
				+ ModelLogistica.getBairro1()
				+ "','"
				+ ModelLogistica.getNumero1()
				+ "','"
				+ ModelLogistica.getComplemento1()
				+ "','"
				+ ModelLogistica.getCep1()
				+ "','"
				+ ModelLogistica.getEstado1()
				+ "','"
				+ ModelLogistica.getCidade1()
				+ "','"
				+ ModelLogistica.getCnpj()
				+ "','"
				+  ModelLogistica.getIe() 
				+ "')";			
		x.grava(comandosql);		
}

	public static void ConsultarTransportadora() {
	if(Logistica.comboPor3.getSelectedItem().toString().equals("")){
		JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if(Logistica.comboPor3.getSelectedItem().toString().equals("Codigo")){
			dados = x.Consultar("select*from transportadora where codigoTransportadora = '" + ModelLogistica.getCodigoTransportadora() + "'");
		gatilho=1;
		Tipo="O código";
		}
		else if(Logistica.comboPor3.getSelectedItem().toString().equals("Razão Social")){
			dados = x.Consultar("select*from transportadora where razaoSocial = '" + ModelLogistica.getRazaoSocial()+ "'");
		gatilho=1;
		Tipo="A razão social";
		}
		else if(Logistica.comboPor3.getSelectedItem().toString().equals("CNPJ")){
			dados = x.Consultar("select*from transportadora where cnpj = '" + ModelLogistica.getCnpj() + "'");
			gatilho=1;
			Tipo="O cnpj";
		}
		
		if(gatilho==1){
	 	try {
		dados.next();
		
		ModelLogistica.setCodigoTransportadora(dados.getString("codigo"));
		ModelLogistica.setRazaoSocial(dados.getString("razaoSocial"));
		ModelLogistica.setEndereco1(dados.getString("endereco"));
		ModelLogistica.setBairro1(dados.getString("bairro"));
		ModelLogistica.setNumero1(dados.getString("numero"));
		ModelLogistica.setComplemento1(dados.getString("complemento"));
		ModelLogistica.setCep1(dados.getString("cep"));
		ModelLogistica.setEstado1(dados.getString("uf"));
		ModelLogistica.setCidade1(dados.getString("cidade"));
		ModelLogistica.setCnpj(dados.getString("cnpj"));
		ModelLogistica.setIe(dados.getString("inscricaoEstadual"));
		
		gatilho=0;	

	} catch (SQLException erro) {
		JOptionPane.showMessageDialog(null, Tipo+" digitado não existe! Tente outro.    ","Atenção", JOptionPane.WARNING_MESSAGE);
		gatilho=0;
	}
	}
	
}
	
}
