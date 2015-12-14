package Solid.model;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import Solid.view.RH;
@SuppressWarnings("unused")
public class ModelRH {
		
	private int codigo = 0;	
	private String nome=null;
	private String nascimento=null;
	private String nacionalidade = null;
	private String email;
	private String rg = null;
	private String cpf = null;
	private String carteiraTrabalho = null;
	private String funcao = null;
	private String estadoCivil = null;
	private String admissao;
	private String contrato;
	private String nomeMae = null;
	private String nomePai = null;
	private String dependentes = null;
	private double salario = 0.0;
	private static String fotografia = null;
	private String escolaridade = null;
	private String banco=null;
	private String conta=null;
	private String telefone1=null;
	private String telefone2=null;
	private String celular1=null;
	private String celular2=null;
	private String endereco=null;
	private String bairro=null;
	private String numero = "0";
	private String complemento=null;
	private String cep=null;
	private String estado=null;
	private String cidade=null;
	private String departamento = null;	
	private String usuario = null;
	private String senha = null;
	private String nivel = null;	

	public ModelRH() {
		
	}

	public static String getCodigo() {
		return RH.NumeroRegistro1.getText();
	}

	public static void setCodigo(String codigo) {
		RH.NumeroRegistro1.setText(codigo);
	}
	
	public static String getNome() {
		return RH.Nome1.getText();
	}
	

	public static void setNome(String nome) {
		RH.Nome1.setText(nome);
	}
	
	public static String getNascimento() {
		return RH.Nascimento1.getText();
	}

	public static void setNascimento(String nascimento) {
		RH.Nascimento1.setText(nascimento);
	}	
	
	public static String getNacionalidade() {
		return  RH.Nacionalidade1.getText();
	}

	public static void setNacionalidade(String nacionalidade) {
		RH.Nacionalidade1.setText(nacionalidade);
	}

	public static String getEmail() {
		return RH.Email1.getText();
	}

	public static void setEmail(String email) {
		RH.Email1.setText(email);
	}	

	public static String getRg() {
		return RH.Rg1.getText();
	}

	public static void setRg(String rg) {
		RH.Rg1.setText(rg);
	}

	public static String getCpf() {
		return RH.Cpf1.getText();
	}

	public static void setCpf(String cpf) {
		RH.Cpf1.setText(cpf);
	}

	public static String getCarteiraTrabalho() {
		return RH.Ctps1.getText();
	}

	public static void setCarteiraTrabalho(String carteiraTrabalho) {
		RH.Ctps1.setText(carteiraTrabalho);
	}

	public static String getEstadoCivil() {
		return RH.comboEstadoCivil.getSelectedItem().toString();
	}

	public static void setEstadoCivil(String estadoCivil) {
		RH.estadoCivil.setText(estadoCivil);
	}
	
	public static String getAdmissao() {
		return RH.Admissao1.getText();
	}

	public static void setAdmissao(String admissao) {
		RH.Admissao1.setText(admissao);
	}
	
	public static String getContrato() {
		return RH.comboContrato.getSelectedItem().toString();
	}

	public static void setContrato(String contrato) {
		RH.contrato.setText(contrato);
	}
	
	public static String getEscolaridade() {
		return RH.comboEscolaridade.getSelectedItem().toString();
	}

	public static void setEscolaridade(String escolaridade) {
		RH.escolaridade.setText(escolaridade);
	}
	
	public static String getNomePai() {
		return RH.NomePai1.getText();
	}

	public static void setNomePai(String nomePai) {
		 RH.NomePai1.setText(nomePai);
	}
	
	public static String getNomeMae() {
		return RH.NomeMae1.getText();
	}

	public static void setNomeMae(String nomeMae) {
		RH.NomeMae1.setText(nomeMae);
	}
	
	public static String getBanco() {
		return RH.comboBanco.getSelectedItem().toString();
	}

	public static void setBanco(String banco) {
		RH.banco.setText(banco);
	}

	public static String getConta() {
		return RH.Conta1.getText();
	}

	public static void setConta(String conta) {
		RH.Conta1.setText(conta);
	}
	
	public static String getAgencia() {
		return RH.agencia.getText();
	}

	public static void setAgencia(String agencia) {
		RH.agencia.setText(agencia);
	}
	
	public static String getTelefone1() {
		return RH.Telefone11.getText();
	}

	public static void setTelefone1(String telefone1) {
		RH.Telefone11.setText(telefone1);
	}

	public static String getTelefone2() {
		return RH.Telefone21.getText();
	}

	public static void setTelefone2(String telefone2) {
		RH.Telefone21.setText(telefone2);
	}

	public static String getCelular1() {
		return RH.Celular11.getText();
	}

	public static void setCelular1(String celular1) {
		RH.Celular11.setText(celular1);
	}

	public static String getCelular2() {
		return RH.Celular21.getText();
	}

	public static void setCelular2(String celular2) {
		RH.Celular21.setText(celular2);
	}
	
	public static String getEndereco() {
		return RH.Logradouro1.getText();
	}

	public static void setEndereco(String endereco) {
		RH.Logradouro1.setText(endereco);
	}

	public static String getBairro() {
		return RH.Bairro1.getText();
	}

	public static void setBairro(String bairro) {
		RH.Bairro1.setText(bairro);
	}

	public static String getNumero() {
		return RH.Numero1.getText();
	}

	public static void setNumero(String numero) {
		RH.Numero1.setText(numero);
	}

	public static String getComplemento() {
		return RH.Complemento1.getText();
	}

	public static void setComplemento(String complemento) {
		RH.Complemento1.setText(complemento);
	}

	public static String getCep() {
		return RH.Cep1.getText().toString();
	}

	public static void setCep(String cep) {
		RH.Cep1.setText(cep);
	}

	public static String getEstado() {
		return RH.comboUf.getSelectedItem().toString();
	}

	public static void setEstado(String estado) {
		RH.uf.setText(estado);
	}

	public static String getCidade() {
		return RH.comboCidade.getSelectedItem().toString(); 
			
	}

	public static void setCidade(String cidade) {
		RH.cidade.setText(cidade);
	}
		
	public static String getFuncao() {
		return RH.comboCargo.getSelectedItem().toString();
	}

	public static void setFuncao(String funcao) {
		RH.cargo_1.setText(funcao);
	}	

	public static String getSalario() {
		return RH.Salario1.getText();
	}

	public static void setSalario(String salario) {
		RH.Salario1.setText(salario);
	}

	public static String getDepartamento() {
		return RH.comboDepartamento.getSelectedItem().toString();
	}

	public static void setDepartamento(String departamento) {
		RH.departamento.setText(departamento);
	}
	
	public static String getDependentes() {
		return RH.Dependentes1.getText();
	}

	public static void setDependentes(String dependentes) {
		RH.Dependentes1.setText(dependentes);
	}
	
	public static String getUsuario() {
		return RH.Usuario1.getText();
	}

	public static void setUsuario(String usuario) {
		RH.Usuario1.setText(usuario);
	}

	@SuppressWarnings("deprecation")
	public static String getSenha() {
		return RH.Senha1.getText();
	}

	public static void setSenha(String senha) {
		RH.Senha1.setText(senha);
	}

	public static String getNivel() {
		return RH.comboNivel.getSelectedItem().toString();
	}

	public static void setNivel(String nivel) {
		RH.nivel.setText(nivel);
	}
	
	public static String getFotografia() {
		return RH.caminhof.getText();
	}
		
	public static void setFotografia(String fotografia) {
		ImageIcon imagem = new ImageIcon(fotografia.replace("~", "//"));
		Image img = imagem.getImage().getScaledInstance(138, 115,Image.SCALE_AREA_AVERAGING);
		RH.labelFotoFuncionario.setText("");
		RH.labelFotoFuncionario.setIcon(new javax.swing.ImageIcon(img));
		RH.caminhof.setText(fotografia.replace("~", "//"));
	}	
}


