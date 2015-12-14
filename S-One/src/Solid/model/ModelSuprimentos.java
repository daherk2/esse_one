package Solid.model;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Solid.controller.BancoDados;
import Solid.view.RH;
import Solid.view.Suprimentos;
@SuppressWarnings("unused")
public class ModelSuprimentos {
	
	public static int linha=0;		
	//Dados Produto
	private String codigoProduto;
	private String nomeProduto;
	private String numeroLoteProd;
	private String estoqueMin;
	private String tipoProduto;
	private String unidadeProduto;
	private String dataCadastro;
	private String validadeCadastro;
	private String localEstoqueProd;
	private String descricao;
	private String fichaProduto;
	private String ProdutoAdd;
	private String QuantAdd;
	private static double precoUnidadeF;
	private static String unidadeF;
	private static String codigoF;
	private String numeroItem;
	private String codigoMp;
	private String nomeMp;
	private String unidadeMp;
	private String precoMp;
	private String quantMp;
	private String custoAgregado;
	private String pis;
	private String iss;
	private String ipi;
	private String cofins;
	private String icms;
	private String precoCustoProd;
	private String margemLucro;
	private String precoVenda;
	private String removerMp;
	private String quantRemover;
	private String imagemProduto;
	
	//Dados Materia Prima
	private String codigoMateriaPrima;
	private String nomeMateriaPrima;
	private String localEstoqueMp;
	private String tipoMp;
	private String unidadeMateriaPrima;
	private String loteMp;
	private String estoqueMinMp;
	private String precoUnidade;
	private String descricaoMp;
	private String imagemMp;
	
	//Dados Fornecedor
	private String codigoFornecedor;
	private String nomeFornecedor;
	private String logradouroFornecedor;
	private String nomeroFornecedor;
	private String complementoFornecedor;
	private String bairroFornecedor;
	private String ufFornecedor;
	private String cidadeFornecedor;
	private String cepFornecedor;
	private String cnpjFornecedor;
	private String ieFornecedor;
	private String telefone1;
	private String telefone2;
	private String celular1;
	private String celular2;
	private String imagemFornecedor;
	
	//DadosEstoque
	private static String tipoItem;
	private String item;
	private String estoqueAtual;
	private String dataEntrada;
	private String dataCompra;
	private String validade;
	private String codigo;
	private String lote;
	private String notaFiscal;
	private String localEstoque;
	private String quantidadeEst;
	private String codigoFornc;

	public ModelSuprimentos() {
		
	}
	
	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//PRODUTO
	public static String getCodigoProduto() {
		return Suprimentos.codigo1.getText();
	}

	public static void setCodigoProduto(String codigoProduto) {
		Suprimentos.codigo1.setText(codigoProduto);
	}

	public static String getNomeProduto() {
		return Suprimentos.nome1.getText();
	}

	public static void setNomeProduto(String nomeProduto) {
		Suprimentos.nome1.setText(nomeProduto);
	}

	public static String getNumeroLoteProd() {
		return Suprimentos.numeroLote.getText();
	}

	public static void setNumeroLoteProd(String numeroLoteProd) {
		Suprimentos.numeroLote.setText(numeroLoteProd);
	}

	public static String getEstoqueMin() {
		return Suprimentos.estoqueMinimo1.getValue().toString();
	}

	public static void setEstoqueMin(String estoqueMin) {
		Suprimentos.estoqueminconsulta.setText(estoqueMin);
	}

	public static String getTipoProduto() {
		return Suprimentos.comboBoxTipoProd.getSelectedItem().toString();
	}

	public static void setTipoProduto(String tipoProduto) {
		Suprimentos.tipoConsultaProd.setText(tipoProduto);
	}

	public static String getUnidadeProduto() {
		return Suprimentos.comboUnidade.getSelectedItem().toString();
	}

	public static void setUnidadeProduto(String unidadeProduto) {
		Suprimentos.unidadeconsulta.setText(unidadeProduto);
	}

	public static String getDataCadastro() {
		return Suprimentos.dataCompra_1.getText();
	}

	public static void setDataCadastro(String dataCadastro) {
		Suprimentos.dataCompra_1.setText(dataCadastro);
	}

	public static String getValidadeCadastro() {
		return Suprimentos.validade1.getText();
	}

	public static void setValidadeCadastro(String validadeCadastro) {
		Suprimentos.validade1.setText(validadeCadastro);
	}

	public static String getLocalEstoqueProd() {
		return Suprimentos.localEstoque_1.getText();
	}

	public static void setLocalEstoqueProd(String localEstoqueProd) {
		Suprimentos.localEstoque_1.setText(localEstoqueProd);
	}

	public static String getDescricao() {
		return Suprimentos.descricaoProduto.getText();
	}

	public static void setDescricao(String descricao) {
		Suprimentos.descricaoProduto.setText(descricao);
	}

	public static String getFichaProduto() {
		return Suprimentos.ficha;
	}

	protected static void setFichaProduto(String fichaProduto) {
		if(fichaProduto.equals("sim")){
			Suprimentos.fichaSim.setSelected(true);
		}
		else if(fichaProduto.equals("não")){
			Suprimentos.fichaNao.setSelected(true);
		}
	}
	
	public static String getProdutoAdd() {
		return Suprimentos.comboBox.getSelectedItem().toString();
	}

	public static void setProdutoAdd(String produtoAdd) {
		Suprimentos.comboBox.setSelectedItem(produtoAdd);
	}

	public static String getQuantAdd() {
		return Suprimentos.quantidade.getText().replace(",", ".");
	}

	public static void setQuantAdd(String quantAdd) {
		Suprimentos.quantidade.setText(quantAdd);
	}
	
	public static String getUnidadeF() {
		return  unidadeF=Suprimentos.unidade;
	}

	protected static void setUnidadeF(String unidadeF) {
		ModelSuprimentos.unidadeF = unidadeF;
	}

	public static String getCodigoF() {
		return codigoF=Suprimentos.codprod;
	}

	protected static void setCodigoF(String codigoF) {
		ModelSuprimentos.codigoF = codigoF;
	}

	public static double getPrecoUnidadeF() {
		return precoUnidadeF=Suprimentos.precoUnidade;
	}

	@SuppressWarnings("static-access")
	protected void setPrecoUnidadeF(double precoUnidadeF) {
		this.precoUnidadeF = precoUnidadeF;
	}
	
	public static String getNumeroItem() {		
		return Suprimentos.modeloficha.getValueAt(linha, 0).toString();
	}

	protected void setNumeroItem(String numeroItem) {
		Suprimentos.modeloficha.setValueAt(numeroItem, linha, 0);
	}

	public static String getCodigoMp() {
		return Suprimentos.modeloficha.getValueAt(linha, 1).toString();
	}

	protected void setCodigoMp(String codigoMp) {
		Suprimentos.modeloficha.setValueAt(codigoMp, linha, 1);
	}

	public static String getNomeMp() {
		return (String) Suprimentos.modeloficha.getValueAt(linha, 2);
	}

	protected void setNomeMp(String nomeMp) {
		Suprimentos.modeloficha.setValueAt(nomeMp, linha, 2);
	}

	public static String getUnidadeMp() {
		return (String) Suprimentos.modeloficha.getValueAt(linha, 3);
	}

	protected void setUnidadeMp(String unidadeMp) {
		Suprimentos.modeloficha.setValueAt(unidadeMp, linha, 3);
	}

	public static String getPrecoMp() {
		return Suprimentos.modeloficha.getValueAt(linha, 4).toString().replace(",", ".");
	}

	protected void setPrecoMp(String precoMp) {
		Suprimentos.modeloficha.setValueAt((String.valueOf(precoMp).replace(",", ".")), linha, 4);
	}

	public static String getQuantMp() {
		return Suprimentos.modeloficha.getValueAt(linha, 5).toString().replace(",", ".");
	}

	public static void setQuantMp(String quantMp) {
		Suprimentos.modeloficha.setValueAt((String.valueOf(quantMp).replace(",", ".")), linha, 5);
	}

	public static String getCustoAgregado() {
		return Suprimentos.modeloficha.getValueAt(linha, 6).toString().replace(",", ".");
	}

	public static void setCustoAgregado(String custoAgregado) {
		Suprimentos.modeloficha.setValueAt((String.valueOf(custoAgregado).replace(",", ".")), linha, 6);
	}

	public static String getPis() {
		return Suprimentos.pis_1.getText();
	}

	public static void setPis(String pis) {
		Suprimentos.pis_1.setText(pis);
	}

	public static String getIss() {
		return Suprimentos.iss_1.getText();
	}

	public static void setIss(String iss) {
		Suprimentos.iss_1.setText(iss);
	}

	public static String getIpi() {
		return Suprimentos.ipi_1.getText();
	}

	public static void setIpi(String ipi) {
		Suprimentos.ipi_1.setText(ipi);
	}

	public static String getCofins() {
		return Suprimentos.cofins_1.getText();
	}

	public static void setCofins(String cofins) {
		Suprimentos.cofins_1.setText(cofins);
	}

	public static String getIcms() {
		return Suprimentos.icms_1.getText();
	}

	public static void setIcms(String icms) {
		Suprimentos.icms_1.setText(icms);
	}

	public static String getPrecoCustoProd() {
		return Suprimentos.precoCusto.getText().replace(",", ".");
	}

	public static void setPrecoCustoProd(String precoCustoProd) {
		Suprimentos.precoCusto.setText(precoCustoProd);
	}

	public static String getMargemLucro() {
		return Suprimentos.margemLucro.getText();
	}

	public static void setMargemLucro(String margemLucro) {
		Suprimentos.margemLucro.setText(margemLucro);
	}

	public static String getPrecoVenda() {
		return Suprimentos.precoVenda.getText();
	}

	public static void setPrecoVenda(String precoVenda) {
		Suprimentos.precoVenda.setText(precoVenda);
	}
	
	public static String getRemoverMp() {
		return Suprimentos.comboremoveItem1.getSelectedItem().toString();
	}

	protected void setRemoverMp(String removerMp) {
		this.removerMp = removerMp;
	}

	public static String getQuantRemover() {
		return Suprimentos.quantR.getText();
	}

	protected void setQuantRemover(String quantRemover) {
		this.quantRemover = quantRemover;
	}

	public static String getImagemProduto() {
		return Suprimentos.caminho.getText().replace("\\", "~");
	}

	public static void setImagemProduto(String imagemProduto) {
		Suprimentos.caminho.setText(imagemProduto.replace("~", "\\"));
		ImageIcon imagem = new ImageIcon(imagemProduto);
		Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
		Suprimentos.labelFotoProduto.setIcon(new javax.swing.ImageIcon(img));
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//MATÉRIA PRIMA
	public static String getCodigoMateriaPrima() {
		return Suprimentos.codigo2.getText();
	}

	public static void setCodigoMateriaPrima(String codigoMateriaPrima) {
		Suprimentos.codigo2.setText(codigoMateriaPrima);
	}

	public static String getNomeMateriaPrima() {
		return Suprimentos.nome2.getText();
	}

	public static void setNomeMateriaPrima(String nomeMateriaPrima) {
		Suprimentos.nome2.setText(nomeMateriaPrima);
	}

	public static String getLocalEstoqueMp() {
		return Suprimentos.localEstoque.getText();
	}

	public static void setLocalEstoqueMp(String localEstoqueMp) {
		Suprimentos.localEstoque.setText(localEstoqueMp);
	}

	public static String getTipoMp() {
		return Suprimentos.comboBox_4.getSelectedItem().toString();
	}

	public static void setTipoMp(String tipoMp) {
		Suprimentos.tipoConsultaMP.setText(tipoMp);
	}

	public static String getUnidadeMateriaPrima() {
		return Suprimentos.comboUnidade2.getSelectedItem().toString();
	}

	public static void setUnidadeMateriaPrima(String unidadeMateriaPrima) {
		Suprimentos.unidadeconsulta2.setText(unidadeMateriaPrima);
	}

	public static String getLoteMp() {
		return Suprimentos.numeroLote2.getText();
	}

	public static void setLoteMp(String loteMp) {
		Suprimentos.numeroLote2.setText(loteMp);
	}

	public static String getEstoqueMinMp() {
		return Suprimentos.estoqueMinimo2.getValue().toString();
	}

	public static void setEstoqueMinMp(String estoqueMinMp) {
		Suprimentos.estoqueMinimoConsulta2.setText(estoqueMinMp);
	}

	public static String getPrecoUnidade() {
		return Suprimentos.precoPor2.getText();
	}

	public static void setPrecoUnidade(String precoUnidade) {
		Suprimentos.precoPor2.setText(precoUnidade);
	}

	public static String getDescricaoMp() {
		return Suprimentos.descricaoMateriaPrima2.getText();
	}

	public static void setDescricaoMp(String descricaoMp) {
		Suprimentos.descricaoMateriaPrima2.setText(descricaoMp);
	}

	public static String getImagemMp() {
		return Suprimentos.caminho2.getText();
	}

	public static void setImagemMp(String imagemMp) {
		ImageIcon imagem = new ImageIcon(imagemMp);
		Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
		Suprimentos.labelFotoMateriaPrima.setIcon(new javax.swing.ImageIcon(img));
	}

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//FORNECEDOR
	public static String getCodigoFornecedor() {
		return Suprimentos.codigo5.getText();
	}

	public static void setCodigoFornecedor(String codigoFornecedor) {
		Suprimentos.codigo5.setText(codigoFornecedor);
	}

	public static String getNomeFornecedor() {
		return Suprimentos.NomeFornecedor.getText();
	}

	public static void setNomeFornecedor(String nomeFornecedor) {
		Suprimentos.NomeFornecedor.setText(nomeFornecedor);
	}
	
	public static String getVendedor() {
		return Suprimentos.vendedor.getText();
	}

	public static void setVendedor(String vendedor) {
		Suprimentos.vendedor.setText(vendedor);
	}

	public static String getLogradouroFornecedor() {
		return Suprimentos.endereco.getText();
	}

	public static void setLogradouroFornecedor(String logradouroFornecedor) {
		Suprimentos.endereco.setText(logradouroFornecedor);
	}

	public static String getNumeroFornecedor() {
		return Suprimentos.numero.getText();
	}

	public static void setNumeroFornecedor(String numeroFornecedor) {
		Suprimentos.numero.setText(numeroFornecedor);
	}

	public static String getComplementoFornecedor() {
		return Suprimentos.complemento.getText();
	}

	public static void setComplementoFornecedor(String complementoFornecedor) {
		Suprimentos.complemento.setText(complementoFornecedor);
	}

	public static String getBairroFornecedor() {
		return Suprimentos.bairro.getText();
	}

	public static void setBairroFornecedor(String bairroFornecedor) {
		Suprimentos.bairro.setText(bairroFornecedor);
	}

	public static String getUfFornecedor() {
		return Suprimentos.comboBox_estado.getSelectedItem().toString();
	}

	public static void setUfFornecedor(String ufFornecedor) {
		Suprimentos.estado.setText(ufFornecedor);
	}

	public static String getCidadeFornecedor() {
		return Suprimentos.comboBox_cidade.getSelectedItem().toString();
	}

	public static void setCidadeFornecedor(String cidadeFornecedor) {
		Suprimentos.cidade.setText(cidadeFornecedor);
	}

	public static String getCepFornecedor() {
		return Suprimentos.cep.getText();
	}

	public static void setCepFornecedor(String cepFornecedor) {
		Suprimentos.cep.setText(cepFornecedor);
	}

	public static String getCnpjFornecedor() {
		return Suprimentos.cnpj.getText();
	}

	public static void setCnpjFornecedor(String cnpjFornecedor) {
		Suprimentos.cnpj.setText(cnpjFornecedor);
	}

	public static String getIeFornecedor() {
		return Suprimentos.iE.getText();
	}

	public static void setIeFornecedor(String ieFornecedor) {
		Suprimentos.iE.setText(ieFornecedor);
	}

	public static String getTelefone1() {
		return Suprimentos.telefone1.getText();
	}

	public static void setTelefone1(String telefone1) {
		Suprimentos.telefone1.setText(telefone1);
	}

	public static String getTelefone2() {
		return Suprimentos.telefone2.getText();
	}

	public static void setTelefone2(String telefone2) {
		Suprimentos.telefone2.setText(telefone2);
	}

	public static String getCelular1() {
		return Suprimentos.celular1.getText();
	}

	public static void setCelular1(String celular1) {
		Suprimentos.celular1.setText(celular1);
	}

	public static String getCelular2() {
		return Suprimentos.celular2.getText();
	}

	public static void setCelular2(String celular2) {
		Suprimentos.celular2.setText(celular2);
	}

	public static String getImagemFornecedor() {
		return Suprimentos.caminho3.getText();
	}

	public static void setImagemFornecedor(String imagemFornecedor) {
		ImageIcon imagem = new ImageIcon(imagemFornecedor);
		Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
		Suprimentos.labelFotoFornecedor.setIcon(new javax.swing.ImageIcon(img));
	}

	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//INSERIR ESTOQUE
	public static String getTipoItem() {
		return tipoItem=Suprimentos.tipoInsereEstoque;
	}

	public static void setTipoItem(String tipoItem) {
		if (tipoItem.equals("produto")){
			Suprimentos.radioProduto.setSelected(true);
		}
		else if(tipoItem.equals("materiaPrima")){
			Suprimentos.radioMateriaPrima.setSelected(true);
		}
	}

	public static String getItem() {
		return Suprimentos.comboDesejaAdicionar.getSelectedItem().toString();
	}

	public static void setItem(String item) {
		Suprimentos.nomeItemEst.setText(item);
	}
	
	public static String getNomeEstoque() {
		return Suprimentos.nomeItemEst.getText();
	}
	
	public static String getEstoqueAtual() {
		return Suprimentos.estoqueAtual.getText();
	}

	public static void setEstoqueAtual(String estoqueAtual) {
		Suprimentos.estoqueAtual.setText(estoqueAtual);
	}

	public static String getDataEntrada() {
		return Suprimentos.dataEntrada.getText();
	}

	public static void setDataEntrada(String dataEntrada) {
		Suprimentos.dataEntrada.setText(dataEntrada);
	}

	public static String getDataCompra() {
		return Suprimentos.dataCompraEst.getText();
	}

	public static void setDataCompra(String dataCompra) {
		Suprimentos.dataCompraEst.setText(dataCompra);
	}

	public static String getValidade() {
		return Suprimentos.validadeEst.getText();
	}

	public static void setValidade(String validade) {
		Suprimentos.validadeEst.setText(validade);
	}

	public static String getCodigo() {
		return Suprimentos.codigoEst.getText();
	}

	public static void setCodigo(String codigo) {
		Suprimentos.codigoEst.setText(codigo);
	}

	public static String getLote() {
		return Suprimentos.numeroLoteEst.getText();
	}

	public static void setLote(String lote) {
		Suprimentos.numeroLoteEst.setText(lote);
	}

	public static String getNotaFiscal() {
		return Suprimentos.notaFiscalEst.getText();
	}

	public static void setNotaFiscal(String notaFiscal) {
		Suprimentos.notaFiscalEst.setText(notaFiscal);
	}

	public static String getLocalEstoque() {
		return Suprimentos.comboLocalEstoque4.getSelectedItem().toString();
	}

	public static void setLocalEstoque(String localEstoque) {
		Suprimentos.localEstoqueEst.setText(localEstoque);
	}

	public static String getQuantidade() {
		return Suprimentos.quantidadeAdicionada.getText();
	}

	public static void setQuantidade(String quantidade) {
		Suprimentos.quantidadeAdicionada.setText(quantidade);
	}

	public static String getCodigoFornc() {
		return Suprimentos.codigoFornecedorEst.getText();
	}

	public static void setCodigoFornc(String codigoFornc) {
		Suprimentos.codigoFornecedorEst.setText(codigoFornc);
	}
	
	public static String getNomeFornc() {
		return Suprimentos.comboNomeFornecedorEst.getSelectedItem().toString();
	}
	
	public static void setNomeFornc(String codigoFornc) {
		Suprimentos.nomeEst.setText(codigoFornc);
	}
	
	public static void setImagemEstoque(String imagemEstoque) {
		ImageIcon imagem = new ImageIcon(imagemEstoque);
		Image img = imagem.getImage().getScaledInstance(155, 115,Image.SCALE_AREA_AVERAGING);
		Suprimentos.labelFotoEstoque.setIcon(new javax.swing.ImageIcon(img));
	}

	
	public static String getInformaçoesFornc() {
		return Suprimentos.descricaoEst.getText();
	}

	public static void setInformaçoesFornc(String informacao) {
		Suprimentos.descricaoEst.setText(informacao);
	}
	
	public static void setMovimento(String movimento) {
		Suprimentos.movimento.setText(movimento);		
	}
	
	public static void setUsuario(String usuario) {
		Suprimentos.usuario.setText(usuario);		
	}
}
