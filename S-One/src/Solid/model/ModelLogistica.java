package Solid.model;

import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Solid.controller.BancoDados;
import Solid.view.Logistica;
import Solid.view.Logistica;

@SuppressWarnings("unused")
public class ModelLogistica {
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			//Metodos da aba "Motorista"
	private int codigo = 0;
	private static int gatilho;
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
	
	private String numeroCnh = null;
	private String dataVencimento = null;
	private String categoria = null;
	
	static BancoDados x	= new BancoDados();
	private int gatilho1=0;
	private static String Tipo;
	static ResultSet dados;

	public ModelLogistica() {

	}

	public static int getCodigo() {
		return Integer.parseInt(Logistica.NumeroRegistro.getText());
	}

	public static void setCodigo(String codigo) {
		Logistica.NumeroRegistro.setText(codigo);
	}
	
	public static String getNome() {
		return Logistica.Nome.getText();
	}
	

	public static void setNome(String nome) {
		Logistica.Nome.setText(nome);
	}
	
	public static String getNascimento() {
		return Logistica.Nascimento.getText();
	}

	public static void setNascimento(String nascimento) {
		Logistica.Nascimento.setText(nascimento);
	}	
	
	public static String getNacionalidade() {
		return  Logistica.Nacionalidade.getText();
	}

	public static void setNacionalidade(String nacionalidade) {
		Logistica.Nacionalidade.setText(nacionalidade);
	}

	public static String getEmail() {
		return Logistica.Email.getText();
	}

	public static void setEmail(String email) {
		Logistica.Email.setText(email);
	}	

	public static String getRg() {
		return Logistica.Rg.getText();
	}

	public static void setRg(String rg) {
		Logistica.Rg.setText(rg);
	}

	public static String getCpf() {
		return Logistica.Cpf.getText();
	}

	public static void setCpf(String cpf) {
		Logistica.Cpf.setText(cpf);
	}

	public static String getCarteiraTrabalho() {
		return Logistica.Ctps.getText();
	}

	public static void setCarteiraTrabalho(String carteiraTrabalho) {
		Logistica.Ctps.setText(carteiraTrabalho);
	}

	public static String getEstadoCivil() {
		return Logistica.EstadoCivil.getText();
	}

	public static void setEstadoCivil(String estadoCivil) {
		Logistica.EstadoCivil.setText(estadoCivil);
	}
	
	public static String getAdmissao() {
		return Logistica.Admissao.getText();
	}

	public static void setAdmissao(String admissao) {
		Logistica.Admissao.setText(admissao);
	}
	
	public static String getContrato() {
		return Logistica.comboContrato.getSelectedItem().toString();
	}

	public static void setContrato(String contrato) {
		Logistica.ContratoPesq.setText(contrato);
	}
	
	public static String getEscolaridade() {
		return Logistica.comboEscolaridade.getSelectedItem().toString();
	}

	public static void setEscolaridade(String escolaridade) {
		Logistica.EscolaridadePesq.setText(escolaridade);
	}
	
	public static String getNomePai() {
		return Logistica.NomePai.getText();
	}

	public static void setNomePai(String nomePai) {
		Logistica.NomePai.setText(nomePai);
	}
	
	public static String getNomeMae() {
		return Logistica.NomeMae.getText();
	}

	public static void setNomeMae(String nomeMae) {
		Logistica.NomeMae.setText(nomeMae);
	}
	
	public static String getBanco() {
		return Logistica.comboBanco.getSelectedItem().toString();
	}

	public static void setBanco(String banco) {
		Logistica.BancoPesq.setText(banco);
	}

	public static String getConta() {
		return Logistica.Conta.getText();
	}

	public static void setConta(String conta) {
		Logistica.Conta.setText(conta);
	}
	
	public static String getTelefone1() {
		return Logistica.Telefone1.getText();
	}

	public static void setTelefone1(String telefone1) {
		Logistica.Telefone1.setText(telefone1);
	}

	public static String getTelefone2() {
		return Logistica.Telefone2.getText();
	}

	public static void setTelefone2(String telefone2) {
		Logistica.Telefone2.setText(telefone2);
	}

	public static String getCelular1() {
		return Logistica.Celular1.getText();
	}

	public static void setCelular1(String celular1) {
		Logistica.Celular1.setText(celular1);
	}

	public static String getCelular2() {
		return Logistica.Celular2.getText();
	}

	public static void setCelular2(String celular2) {
		Logistica.Celular2.setText(celular2);
	}
	
	public static String getEndereco() {
		return Logistica.Endereco.getText();
	}

	public static void setEndereco(String endereco) {
		Logistica.Endereco.setText(endereco);
	}

	public static String getBairro() {
		return Logistica.Bairro.getText();
	}

	public static void setBairro(String bairro) {
		Logistica.Bairro.setText(bairro);
	}

	public static String getNumero() {
		return Logistica.Numero.getText();
	}

	public static void setNumero(String numero) {
		Logistica.Numero.setText(numero);
	}

	public static String getComplemento() {
		return Logistica.Complemento.getText();
	}

	public static void setComplemento(String complemento) {
		Logistica.Complemento.setText(complemento);
	}

	public static String getCep() {
		return Logistica.Cep.getText();
	}

	public static void setCep(String cep) {
		Logistica.Cep.setText(cep);
	}

	public static String getEstado() {
		return Logistica.comboUF.getSelectedItem().toString();
	}

	public static String getCidade() {
		return Logistica.comboCidade.getSelectedItem().toString();
	}
		
	public static String getFuncao() {
		return Logistica.comboCargo.getSelectedItem().toString();
	}

	public static void setFuncao(String funcao) {
		Logistica.CargoPesq.setText(funcao);
	}	

	public static String getSalario() {
		return Logistica.Salario.getText();
	}

	public static void setSalario(String salario) {
		Logistica.Salario.setText(salario);
	}

	public static String getDepartamento() {
		return Logistica.Departamento.getText();
	}

	public static void setDepartamento(String departamento) {
		Logistica.Departamento.setText(departamento);
	}
	
	public static String getNumeroCnh() {
		return Logistica.NumeroCnh.getText();
	}

	public static void setNumeroCnh(String numeroCnh) {
		Logistica.NumeroCnh.setText(numeroCnh);
	}

	public static String getDataVencimento() {
		return Logistica.DataVencimento.getText();
	}

	public static void setDataVencimento(String dataVencimento) {
		Logistica.DataVencimento.setText(dataVencimento);
	}

	public static String getCategoria() {
		return Logistica.comboCategoria.getSelectedItem().toString();
	}

	public static void setCategoria(String categoria) {
		Logistica.CategoriaPesq.setText(categoria);
	}
	
	public static String getFotografia() {
		return fotografia;
	}
		
	@SuppressWarnings("static-access")
	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}	

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			//Metodos da aba "Veiculo"
	
	
	private static int gatilhoV;
	private static String modelo = null;
	private String numeroChassi = null;
	private String numeroDocumento = null;
	private static String tipo = null;
	private static String placa = null;
	private static Date anoFabricacao ;
	private static String licenciamento = null;
	private static String combustivel =null;
	private static String categoria1 = null;
	private static String marca = null;
	private static String kilometragem = null;
	private static String cor = null;
	private static String especie = null;
	private static String ipva = null;
	private static String seguro = null;
	private String aquisicao = null;
	private String imagem = null;	
	private Date dataAquisicao = null;
	
		
	public static int getCodigo1() {
		return Integer.parseInt(Logistica.codigo.getText());
	}

	public static void setCodigo1(String codigo) {
		Logistica.codigo.setText(codigo);
	}

	public static String getModelo() {
		return Logistica.modelo_1.getText();
	}

	public static void setModelo(String modelo) {
		Logistica.modelo_1.setText(modelo);
	}

	public static String getNumeroChassi() {
		return Logistica.numeroChassi.getText();
	}

	public static void setNumeroChassi(String numeroChassi) {
		Logistica.numeroChassi.setText(numeroChassi);
	}

	public static String getNumeroDocumento() {
		return Logistica.numeroDocumento.getText();
	}

	public static void setNumeroDocumento(String numeroDocumento) {
		Logistica.numeroDocumento.setText(numeroDocumento);
	}

	public static String getTipo() {
		return Logistica.tipo.getSelectedItem().toString();
	}

	public static void setTipo(String tipo) {
		Logistica.tipoPesq.setText(tipo);
	}

	public static String getPlaca() {
		return Logistica.placa.getText();
	}

	public static void setPlaca(String placa) {
		Logistica.placa.setText(placa);
	}
	
	public static String getAnoFabricacao() {
		return Logistica.comboAnoFabricacao.getSelectedItem().toString();
	}

	public static void setAnoFabricacao(String anoFabricacao) {
		Logistica.anoFabricacao.setText(anoFabricacao);
	}

	public static String getLicenciamento() {
		return Logistica.licenciamento.getText();
	}

	public static void setLicenciamento(String licenciamento) {
		Logistica.licenciamento.setText(licenciamento);
	}

	public static String getCombustivel() {
		return Logistica.combustivel.getSelectedItem().toString();
	}

	public static void setCombustivel(String combustivel) {
		Logistica.combustivelPesq.setText(combustivel);
	}

	public static String getCategoria1() {
		
		return Logistica.Categoria;
	}

	public static void setCategoria1(String categoria) {
		if(categoria.equals("Nacional")){
			Logistica.rdbtnNacional.setSelected(true);
		}
		else if (categoria.equals("Importado")){
			Logistica.rdbtnImportado.setSelected(true);
		}
	}

	public static String getMarca() {
		return Logistica.marca.getSelectedItem().toString();
	}

	public static void setMarca(String marca) {
		Logistica.marcaPesq.setText(marca);
	}

	public static String getKilometragem() {
		return Logistica.kilometragem.getText();
	}

	public static void setKilometragem(String kilometragem) {
		Logistica.kilometragem.setText(kilometragem);
	}

	public static String getCor() {
		return Logistica.cor.getText();
	}

	public static void setCor(String cor) {
		Logistica.cor.setText(cor);
	}

	public static String getEspecie() {
		return Logistica.especie.getSelectedItem().toString();
	}

	public static void setEspecie(String especie) {
		Logistica.especiePesq.setText(especie);
	}

	public static String getIpva() {
		return Logistica.ipva.getText();
	}

	public static void setIpva(String ipva) {
		Logistica.ipva.setText(ipva);
	}

	public static String getSeguro() {
		return Logistica.seguroObrigatorio.getText();
	}

	public static void setSeguro(String seguro) {
		Logistica.seguroObrigatorio.setText(seguro);
	}

	public static String getAquisicao() {
		return Logistica.aquisicao.getText();
	}

	public static void setAquisicao(String aquisicao) {
		Logistica.aquisicao.setText(aquisicao);
	}

	public static String getImagem() {
		return  Logistica.caminhoV;
	}

	public static void setImagem(String imagem) {
		ImageIcon imagem2 = new ImageIcon(imagem);
		Logistica.caminhoV=imagem;
		Image img = imagem2.getImage().getScaledInstance(135, 115,Image.SCALE_AREA_AVERAGING);
		Logistica.labelFotoVeiculo.setText("");
		Logistica.labelFotoVeiculo.setIcon(new javax.swing.ImageIcon(img));
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
		
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Metodos da aba "Transportadora"
	
		
	public static int getCodigoTransportadora() {
		return Integer.parseInt(Logistica.codigo1.getText());
	}

	public static void setCodigoTransportadora(String codigoTransportadora) {
		Logistica.codigo1.setText(codigoTransportadora);
		}

	public static String getRazaoSocial() {
		return Logistica.razaoSocial.getText();
	}

	public static void setRazaoSocial(String razaoSocial) {
		Logistica.razaoSocial.setText(razaoSocial);
		 }

	public static String getEndereco1() {
		return Logistica.endereco.getText();
	}

	public static void setEndereco1(String endereco) {
		Logistica.endereco.setText(endereco);
	}

	public static String getBairro1() {
		return Logistica.bairro.getText();
	}

	public static void setBairro1(String bairro) {
		Logistica.bairro.setText(bairro);
	}

	public static String getNumero1() {
		return Logistica.numero.getText();
	}

	public static void setNumero1(String numero) {
		Logistica.numero.setText(numero);
	}

	public static String getComplemento1() {
		return Logistica.complemento.getText();
	}

	public static void setComplemento1(String complemento) {
		Logistica.complemento.setText(complemento);
	}

	public static String getCep1() {
		return Logistica.cep.getText();
	}

	public static void setCep1(String cep) {
		Logistica.cep.setText(cep);
	}

	public static String getEstado1() {
		return Logistica.uf.getSelectedItem().toString();
	}

	public static void setEstado1(String estado) {
		Logistica.uf.setSelectedItem(estado);
	}

	public static String getCidade1() {
		return Logistica.cidade.getSelectedItem().toString();
	}

	public static void setCidade1(String cidade) {
		Logistica.cidade.setSelectedItem(cidade);
	}

	public static String getTelefone11() {
		return Logistica.telefone1.getText();
	}

	public static void setTelefone11(String telefone1) {
		Logistica.telefone1.setText(telefone1);
	}

	public static String getTelefone21() {
		return  Logistica.telefone2.getText();
	}

	public static void setTelefone21(String telefone2) {
		Logistica.telefone1.setText(telefone2);
	}

	public static String getCelular11() {
		return Logistica.celular1.getText();
	}

	public static void setCelular11(String celular1) {
		Logistica.celular1.setText(celular1);
	}

	public static String getCelular21() {
		return Logistica.celular2.getText();
	}

	public static void setCelular21(String celular2) {
		Logistica.celular2.setText(celular2);
	}

	public static String getCnpj() {
		return Logistica.Cnpj.getText();
	}

	public static void setCnpj(String cnpj) {
		Logistica.Cnpj.setText(cnpj);
	}

	public static String getIe() {
		return Logistica.InscricaoEstadual.getText();
	}

	public static void setIe(String ie) {
		Logistica.InscricaoEstadual.setText(ie);
	}
	
	
	
}
