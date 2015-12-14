package Solid.controller;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.jtattoo.plaf.fast.FastLookAndFeel;

import Solid.model.ModelRH;
import Solid.view.*;

public class RHController {
	static Solid.controller.BancoDados x	= new Solid.controller.BancoDados();
	private static String Tipo;
	static ResultSet dados;
	private static int gatilho,lo;
	private static int obrigatorios = 0;
	
	public static void AbrirRH(){				
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            
         // inicia o programa S-One
            new RH();		
    		SetarPaineis(Menu.painel);
 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
				
	}
	
	public static void SalvarFuncionario() {
		VerificarCamposObrigatorios();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
		}
		else{
		try{
				String comandosql = "INSERT INTO funcionarios(numeroRegistro, nome, nascimento, nacionalidade, rg, cpf, ctps, estadoCivil, email,"
						+ " nomePai, nomeMae, quantidadeDependente, escolaridade, telefone1, telefone2, celular1, celular2, dataAdmissao,"
						+ "tipoContrato, numeroContaBancaria, banco,agencia, logradouro, numeroCasa, complemento, bairro, estado, cidade, cep, cargo"
						+ ", salario, departamento,imagem) "
						+ "VALUES('"
					+ ModelRH.getCodigo()
					+ "','"
					+ ModelRH.getNome()
					+ "','"
					+ ModelRH.getNascimento()
					+ "','"
					+ ModelRH.getNacionalidade()
					+ "','"					
					+ ModelRH.getRg()
					+ "','"
					+ ModelRH.getCpf()
					+ "','"
					+ ModelRH.getCarteiraTrabalho()
					+ "','"
					+ ModelRH.getEstadoCivil()
					+ "','"
					+ ModelRH.getEmail()
					+ "','"
					+ ModelRH.getNomePai()
					+ "','"
					+ ModelRH.getNomeMae()
					+ "','"
					+ ModelRH.getDependentes()
					+ "','"
					+ ModelRH.getEscolaridade()
					+ "','"					
					+ ModelRH.getTelefone1()
					+ "','"
					+ ModelRH.getTelefone2()
					+ "','"
					+ ModelRH.getCelular1()
					+ "','"
					+ ModelRH.getCelular2()
					+ "','"
					+ ModelRH.getAdmissao()
					+ "','"
					+ ModelRH.getContrato()
					+ "','"
					+ ModelRH.getConta()
					+ "','"
					+ ModelRH.getBanco()
					+ "','"
					+ ModelRH.getAgencia()
					+ "','"					
					+ ModelRH.getEndereco()
					+ "','"
					+ ModelRH.getNumero()
					+ "','"
					+ ModelRH.getComplemento()
					+ "','"
					+ ModelRH.getBairro()
					+ "','"
					+ ModelRH.getEstado()
					+ "','"
					+ ModelRH.getCidade()
					+ "','"					
					+ ModelRH.getCep()
					+ "','"					
					+ ModelRH.getFuncao()
					+ "','"
					+ ModelRH.getSalario()
					+ "','"
					+ ModelRH.getDepartamento()
					+ "','"
					+ ModelRH.getFotografia()
					+ "')";
			
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
						+ ModelRH.getNivel()
						+ "')";
				x.grava(comandosql1);
			}

			int d = Integer.parseInt(RH.NumeroRegistro1.getText());
			d++;

			String comandosql4 = "UPDATE  `erp`.`contadores` SET  `numeroRegistro` =  '" + String.valueOf(d)+ "' WHERE  `contadores`.`numeroRegistro` =  '" + ModelRH.getCodigo() + "'";
			x.grava(comandosql4);
			
			RH.LimparDados();

			String sql2 = "select * from contadores";
			ResultSet rs3 = x.Consultar(sql2);			
				RH.NumeroRegistro1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				RH.NumeroRegistro1.setEditable(false);
				rs3.next();
				RH.NumeroRegistro1.setText(rs3.getString("numeroRegistro"));
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException ex) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, ex+"Erro", "Mensagem do Sistema",JOptionPane.WARNING_MESSAGE);
				ex.printStackTrace();
			}
		}			
	}
	
	private static void VerificarCamposObrigatorios() {
		obrigatorios=0;
		
		if(ModelRH.getCodigo().toString().equals("")){
			obrigatorios++;
			RH.NumeroRegistro1.setBorder(new LineBorder(Color.BLUE));
		}
		else RH.NumeroRegistro1.setBorder(null);
		
		if(ModelRH.getNome().toString().equals("")){
			RH.Nome1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Nome1.setBorder(null);
			
		if(ModelRH.getNascimento().toString().equals("  /  /    ")){
			RH.Nascimento1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Nascimento1.setBorder(null);
		
		if(ModelRH.getNacionalidade().toString().equals("")){
			RH.Nacionalidade1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Nacionalidade1.setBorder(null);
		
		if(ModelRH.getRg().toString().equals("  .   .   - ")){
			RH.Rg1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Rg1.setBorder(null);
				
		if(ModelRH.getCpf().toString().equals("   .   .   -  ")){
			RH.Cpf1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Cpf1.setBorder(null);
		
		
		if(ModelRH.getCarteiraTrabalho().toString().equals("")){
			RH.Ctps1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Ctps1.setBorder(null);
		
		if(ModelRH.getEstadoCivil().toString().equals("")){
			RH.comboEstadoCivil.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboEstadoCivil.setBorder(null);
		
		if(ModelRH.getEmail().toString().equals("")){
			RH.Email1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Email1.setBorder(null);
		
		if(ModelRH.getAdmissao().toString().equals("")){
			RH.Admissao1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Admissao1.setBorder(null);
		
		if(ModelRH.getNomePai().toString().equals("")){
			RH.NomePai1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.NomePai1.setBorder(null);
		
		if(ModelRH.getNomeMae().toString().equals("")){
			RH.NomeMae1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.NomeMae1.setBorder(null);
		
		if(ModelRH.getDependentes().toString().equals("")){
			RH.Dependentes1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Dependentes1.setBorder(null);
		
		if(ModelRH.getEscolaridade().toString().equals("")){
			RH.comboEscolaridade.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboEscolaridade.setBorder(null);
		
		if(ModelRH.getTelefone1().toString().equals("(  )    -    ")){
			RH.Telefone11.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Telefone11.setBorder(null);
		
		if(ModelRH.getTelefone2().toString().equals("(  )    -    ")){
			RH.Telefone21.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Telefone21.setBorder(null);
		
		if(ModelRH.getCelular1().toString().equals("(  )     -    ")){
			RH.Celular11.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Celular11.setBorder(null);
		
		if(ModelRH.getCelular2().toString().equals("(  )     -    ")){
			RH.Celular21.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Celular21.setBorder(null);
		
		if(ModelRH.getAdmissao().toString().equals("  /  /    ")){
			RH.Admissao1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Admissao1.setBorder(null);
		
		if(ModelRH.getContrato().toString().equals("")){
			RH.comboContrato.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboContrato.setBorder(null);;
		
		if(ModelRH.getConta().toString().equals("")){
			RH.Conta1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Conta1.setBorder(null);
		
		if(ModelRH.getBanco().toString().equals("")){
			RH.comboBanco.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboBanco.setBorder(null);

		if(ModelRH.getAgencia().toString().equals("")){
			RH.agencia.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.agencia.setBorder(null);
		
		if(ModelRH.getEndereco().toString().equals("")){
			RH.Logradouro1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Logradouro1.setBorder(null);
		
		if(ModelRH.getNumero().toString().equals("")){
			RH.Numero1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Numero1.setBorder(null);
		
		if(ModelRH.getComplemento().toString().equals("")){
			RH.Complemento1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Complemento1.setBorder(null);
		
		if(ModelRH.getBairro().toString().equals("")){
			RH.Bairro1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Bairro1.setBorder(null);
		
		if(ModelRH.getEstado().toString().equals("")){
			RH.comboUf.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboUf.setBorder(null);
		
		if(ModelRH.getCidade().toString().equals("")){
			RH.comboCidade.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboCidade.setBorder(null);
		
		if(ModelRH.getCep().toString().equals("     -   ")){
			RH.Cep1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Cep1.setBorder(null);
		
		if(ModelRH.getFuncao().toString().equals("")){
			RH.comboCargo.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboCargo.setBorder(null);
		
		if(ModelRH.getSalario().toString().equals("")){
			RH.Salario1.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.Salario1.setBorder(null);
		
		if(ModelRH.getDepartamento().toString().equals("")){
			RH.comboDepartamento.setBorder(new LineBorder(Color.BLUE));
			obrigatorios++;
		}
		else RH.comboDepartamento.setBorder(null);
			
		if (RH.sn == 1) {
			if(ModelRH.getUsuario().toString().equals("")){
				RH.Usuario1.setBorder(new LineBorder(Color.BLUE));
				obrigatorios++;
			}
			else RH.Usuario1.setBorder(null);
			
			if(ModelRH.getSenha().toString().equals("")){
				RH.Senha1.setBorder(new LineBorder(Color.BLUE));
				obrigatorios++;
			}
			else RH.Senha1.setBorder(null);
			
			if(ModelRH.getNivel().toString().equals("")){
				RH.comboNivel.setBorder(new LineBorder(Color.BLUE));
				obrigatorios++;
			}
			else RH.comboNivel.setBorder(null);
		}
	}
	
	public static void ConsultarFuncionario() {
		if(RH.comboPor.getSelectedItem().toString().equals("")){
			Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null," Selecione um parâmetro para a consulta. ","Atenção", JOptionPane.WARNING_MESSAGE);
		}
		else if(RH.comboPor.getSelectedItem().toString().equals("Numero de Registro")){
		dados = x.Consultar("select*from funcionarios where numeroRegistro = '" + ModelRH.getCodigo() + "'");
		gatilho=1;
		Tipo="numero de registro";
		}
		else if(RH.comboPor.getSelectedItem().toString().equals("Nome")){
		dados = x.Consultar("select*from funcionarios where nome = '" +  ModelRH.getNome()+ "'");
		gatilho=1;
		Tipo="nome";
		}
		else if(RH.comboPor.getSelectedItem().toString().equals("CPF")){
			dados = x.Consultar("select*from funcionarios where cpf = '" + ModelRH.getCpf() + "'");
			gatilho=1;
			Tipo="CPF";
		}
		
		if(gatilho==1){
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
			ModelRH.setAgencia(dados.getString("agencia"));
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
			ModelRH.setFotografia(dados.getString("imagem"));
			lo = 1;
			gatilho=0;
			RH.AtualizarIMG.setVisible(true);
			if(ModelRH.getCodigo().equals(dados.getString("numeroRegistro"))){
				
				RH.button_2.setEnabled(true);
				RH.btnImprimir.setEnabled(true);	
				RH.btnAnterior.setEnabled(true);
				RH.btnPrximo.setEnabled(true);
			}
			
		} catch (SQLException erro) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null," O "+Tipo+" digitado não existe! Tente outro "+Tipo+"  ","Atenção", JOptionPane.WARNING_MESSAGE);
			gatilho=0;
		}
		if (lo == 1) {
			ResultSet dadosl = x.Consultar("select*from login1 where registro = '" + ModelRH.getCodigo() + "'");
			try {
				dadosl.next();
				if (ModelRH.getCodigo().equals(dadosl.getString("registro"))) {
					RH.sn=1;
					ModelRH.setUsuario(dadosl.getString("usuario"));
					ModelRH.setSenha(dadosl.getString("senha"));
					ModelRH.setNivel(dadosl.getString("nivel"));
				}
				else{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null," O funcionario consultado não possui Lgin de rede! ","Atenção", JOptionPane.WARNING_MESSAGE);
					gatilho=0;
					RH.NumeroRegistro1.setText(null);
					RH.NumeroRegistro1.requestFocus();
				}
			} catch (SQLException erro) {
				
			}
		}
		lo = 0;
		}
	}
		
	public static void AtualizarFuncionario() {
		VerificarCamposObrigatorios();
		if(obrigatorios>0){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null, "Há "+obrigatorios+" campos obrigatórios que faltam ser preenchidos .", "Mensagem do Sistema",JOptionPane.PLAIN_MESSAGE);
		}
		else{
		String comandosql4 = "UPDATE `erp`.`funcionarios` SET `nome` = '" + ModelRH.getNome()
												  + "', `nascimento` = '" + ModelRH.getNascimento()
												  + "', `nacionalidade` = '" +ModelRH.getNacionalidade()
												  + "', `escolaridade` = '" +ModelRH.getEscolaridade()
												  + "', `rg` = '" + ModelRH.getRg()
												  + "', `cpf` = '" + ModelRH.getCpf()
												  + "', `ctps` = '" + ModelRH.getCarteiraTrabalho()  
												  + "', `estadoCivil` = '" + ModelRH.getEstadoCivil()
												  + "', `email` = '" + ModelRH.getEmail()
												  + "', `nomePai` = '" + ModelRH.getNomePai()
												  + "', `nomeMae` = '" + ModelRH.getNomeMae()
												  + "', `quantidadeDependente` = '" + ModelRH.getDependentes()
												  + "', `telefone1` = '" + ModelRH.getTelefone1() 
												  + "', `telefone2` = '" + ModelRH.getTelefone2()
												  + "', `celular1` = '" + ModelRH.getCelular1() 
												  + "', `celular2` = '" + ModelRH.getCelular2()
												  + "', `dataAdmissao` = '" + ModelRH.getAdmissao()
												  + "', `tipoContrato` = '" + ModelRH.getContrato() 
												  + "', `numeroContaBancaria` = '" + ModelRH.getConta()
												  + "', `banco` = '" + ModelRH.getBanco()
												  + "', `agencia` = '" + ModelRH.getAgencia()
												  + "', `logradouro` = '" + ModelRH.getEndereco()
												  + "', `numeroCasa` = '" + ModelRH.getNumero()
												  + "', `complemento` = '" + ModelRH.getComplemento()
												  + "', `bairro` = '" + ModelRH.getBairro()
												  + "', `estado` = '" + ModelRH.getEstado()
												  + "', `cidade` = '" + ModelRH.getCidade()
												  + "', `cep` = '" + ModelRH.getCep()												 
												  + "', `cargo` = '" + ModelRH.getFuncao()											   
												  + "', `salario` = '" + ModelRH.getSalario()
												  + "', `departamento` = '" + ModelRH.getDepartamento()		
												  + "', `imagem` = '" + ModelRH.getFotografia()	
												  + "' WHERE `funcionarios`.`numeroRegistro` = '" + ModelRH.getCodigo()+ "'";
		x.grava(comandosql4);
		
		if (RH.sn == 1) {		
		String comandosql5 = "UPDATE `erp`.`login1` SET `cpf` = '" + ModelRH.getCpf()
				 								 + "', `usuario` = '" + ModelRH.getUsuario()
				 								 + "', `senha` = '" + ModelRH.getSenha()
				 								 + "', `nivel` = '" + ModelRH.getNivel()												  
				 								 + "' WHERE `login1`.`registro` = '" + ModelRH.getCodigo()+ "'";
		x.grava(comandosql5);
		}		
		JOptionPane.showMessageDialog(null," Dados Atualizados com sucesso !","Atualizar", JOptionPane.INFORMATION_MESSAGE);
		}
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
			Image img = imagem.getImage().getScaledInstance(138, 115,
			            Image.SCALE_AREA_AVERAGING);
			RH.labelFotoFuncionario.setIcon(new javax.swing.ImageIcon(img));
			RH.labelFotoFuncionario.setText("");
			RH.caminhof.setText(diretorio = selecionarArquivo.getSelectedFile().getAbsolutePath()
			            .replace("\\", "~").toString());
			JOptionPane.showMessageDialog(null, "Imagem atualizada com sucesso!", "Atualizar Imagem",JOptionPane.PLAIN_MESSAGE);
			System.out.print(diretorio);		
						
		} else {
			// JOptionPane.showMessageDialog(null,"Você não selecionou nenhum arquivo.");
		}

	}
		
	public static void SetarPaineis(int seq) {		
		try {
            //here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");		
		if (seq == 1) {
			RH.tabbedPaneRH.removeAll();
			RH.tabbedPaneRH.addTab("Funcionário ",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606657_user-128.png")),RH.panelFuncionario, null);
			RH.tabbedPaneRH.addTab("Cargos / Salários",
					new ImageIcon(RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),RH.panelCargoSalario, null);
			RH.tabbedPaneRH.addTab("Treinamento / Desenvolvimento",
				new ImageIcon(RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),RH.panelTreinamentos, null);
			RH.tabbedPaneRH.addTab("Relatórios",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),RH.panelRelatorios, null);

		} else if (seq == 2) {			
			RH.tabbedPaneRH.removeAll();
			RH.tabbedPaneRH.addTab("Cargos / Salários",
					new ImageIcon(RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),RH.panelCargoSalario, null);
			RH.tabbedPaneRH.addTab("Funcionário ",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606657_user-128.png")),RH.panelFuncionario, null);			
			RH.tabbedPaneRH.addTab("Treinamento / Desenvolvimento",
				new ImageIcon(RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),RH.panelTreinamentos, null);
			RH.tabbedPaneRH.addTab("Relatórios",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),RH.panelRelatorios, null);
		} else if (seq == 3) {			
			RH.tabbedPaneRH.removeAll();
			RH.tabbedPaneRH.addTab("Treinamento / Desenvolvimento",
					new ImageIcon(RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),RH.panelTreinamentos, null);
			RH.tabbedPaneRH.addTab("Funcionário ",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606657_user-128.png")),RH.panelFuncionario, null);
			RH.tabbedPaneRH.addTab("Cargos / Salários",
					new ImageIcon(RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),RH.panelCargoSalario, null);			
			RH.tabbedPaneRH.addTab("Relatórios",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),RH.panelRelatorios, null);
		} 	
		else if (seq == 4) {			
			RH.tabbedPaneRH.removeAll();
			RH.tabbedPaneRH.addTab("Relatórios",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606695_678135-sticky-note-128.png")),RH.panelRelatorios, null);
			RH.tabbedPaneRH.addTab("Funcionário ",
		            new ImageIcon(RH.class.getResource("/icones1_24px/1425606657_user-128.png")),RH.panelFuncionario, null);
			RH.tabbedPaneRH.addTab("Cargos / Salários",
					new ImageIcon(RH.class.getResource("/icones1_24px/1425606647_678126-box-in-128.png")),RH.panelCargoSalario, null);
			RH.tabbedPaneRH.addTab("Treinamento / Desenvolvimento",
				new ImageIcon(RH.class.getResource("/icones1_24px/1425606809_wrench-128.png")),RH.panelTreinamentos, null);			
		} 
		
		} catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger( RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger( RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger( RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger( RH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }	
	}
	
	public static void ConsultarProxFuncionario() {
		if(ModelRH.getCodigo().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			RH.NumeroRegistro1.requestFocus();
		}
		else{
		dados = x.Consultar("select*from funcionarios where numeroRegistro = '" + String.valueOf(Integer.parseInt(ModelRH.getCodigo())+1) + "'");
		gatilho=1;
		Tipo="numero de registro";
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
			ModelRH.setAgencia(dados.getString("agencia"));
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
			ModelRH.setFotografia(dados.getString("imagem"));
			lo = 1;
			gatilho=0;
			RH.AtualizarIMG.setVisible(true);
					
		} catch (SQLException erro) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			gatilho=0;
		}
		if (lo == 1) {
			ResultSet dadosl = x.Consultar("select*from login1 where registro = '" + ModelRH.getCodigo() + "'");
			try {
				dadosl.next();
				if (ModelRH.getCodigo().equals(dadosl.getString("registro"))) {

					ModelRH.setUsuario(dadosl.getString("usuario"));
					ModelRH.setSenha(dadosl.getString("senha"));
					ModelRH.setNivel(dadosl.getString("nivel"));
				}
			} catch (SQLException erro) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null," O funcionario consultado não possui Lgin de rede! ","Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho=0;
				RH.NumeroRegistro1.setText(null);
				RH.NumeroRegistro1.requestFocus();
			}
		}
		lo = 0;
		}
	}
	
	public static void ConsultarFuncAnterior() {
		if(ModelRH.getCodigo().equals("")){
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Digite um código para a consulta !","Atenção", JOptionPane.WARNING_MESSAGE);
			RH.NumeroRegistro1.requestFocus();
		}
		else if(Integer.parseInt(ModelRH.getCodigo())>0){		
		dados = x.Consultar("select*from funcionarios where numeroRegistro = '" + String.valueOf(Integer.parseInt(ModelRH.getCodigo())-1) + "'");
		gatilho=1;
		Tipo="numero de registro";
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
			ModelRH.setAgencia(dados.getString("agencia"));
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
			ModelRH.setFotografia(dados.getString("imagem"));
			lo = 1;
			gatilho=0;
			RH.AtualizarIMG.setVisible(true);
					
		} catch (SQLException erro) {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
			gatilho=0;
		}
		if (lo == 1) {
			ResultSet dadosl = x.Consultar("select*from login1 where registro = '" + ModelRH.getCodigo() + "'");
			try {
				dadosl.next();
				if (ModelRH.getCodigo().equals(dadosl.getString("registro"))) {

					ModelRH.setUsuario(dadosl.getString("usuario"));
					ModelRH.setSenha(dadosl.getString("senha"));
					ModelRH.setNivel(dadosl.getString("nivel"));
				}
			} catch (SQLException erro) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null," O funcionario consultado não possui Login de rede! ","Atenção", JOptionPane.WARNING_MESSAGE);
				gatilho=0;
				RH.NumeroRegistro1.setText(null);
				RH.NumeroRegistro1.requestFocus();
			}
		}
		lo = 0;
		}
		else {
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(null,"Não existem mais itens nesta direção !","Atenção", JOptionPane.WARNING_MESSAGE);
		}
	}	
}
