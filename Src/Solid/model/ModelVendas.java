package Solid.model;

import Solid.view.Vendas;

public class ModelVendas {
	
	// Variaveis de controle
	public static int		linha	= 0;
	
	// Variaveis Venda
	public static String	numeroVenda;
	public static String	dataVenda;
	public static String	horaVenda;
	public static String	vendedor;
	public static String	nomecliente;
	public static String	cpf;
	public static String	telefone;
	public static String	formaPagamento;
	public static String	parcelamento;
	public static String	cartao;
	public static String	numeroCartao;
	public static String	banco;
	public static String	numeroCheque;
	public static String	agencia;
	public static String	valortotal;
	public static String	desconto;
	public static String	valorFinal;
	public static String	valorParcelado;
	public static String	valorPago;
	public static String	troco;
	public static String	localVenda;
	public static String	numeroVenda2;
	public static String	item;
	public static String	codigoItem;
	public static String	descricao;
	public static String	quantidade;
	public static String	precoUnitario;
	public static String	total;
	
	public ModelVendas() {
		
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Painel de Vendas
	
	public static String getNumeroVenda() {
		return Vendas.numeroVenda1.getText();
	}
	
	public static void setNumeroVenda(String numeroVenda) {
		Vendas.numeroVenda1.setText(numeroVenda);
	}
	
	public static String getDataVenda() {
		return Vendas.data1.getText();
	}
	
	public static void setDataVenda(String dataVenda) {
		Vendas.data1.setText(dataVenda);
	}
	
	public static String getHoraVenda() {
		return Vendas.hora1.getText();
	}
	
	public static void setHoraVenda(String horaVenda) {
		Vendas.hora1.setText(horaVenda);
	}
	
	public static String getVendedor() {
		return Vendas.vendedor1.getText();
	}
	
	public static void setVendedor(String vendedor) {
		Vendas.vendedor1.setText(vendedor);
	}
	
	public static String getNomecliente() {
		return Vendas.comboCliente.getSelectedItem().toString();
	}
	
	public static void setNomecliente(String nomecliente) {
		ModelVendas.nomecliente = nomecliente;
	}
	
	public static String getCpf() {
		return Vendas.cpf1.getText();
	}
	
	public static void setCpf(String cpf) {
		Vendas.cpf1.setText(cpf);
	}
	
	public static String getTelefone() {
		return Vendas.telefone1.getText();
	}
	
	public static void setTelefone(String telefone) {
		Vendas.telefone1.setText(telefone);
	}
	
	public static String getFormaPagamento() {
		return Vendas.comboFormaPagamento.getSelectedItem().toString();
	}
	
	public static void setFormaPagamento(String formaPagamento) {
		ModelVendas.formaPagamento = formaPagamento;
	}
	
	public static String getParcelamento() {
		return Vendas.comboVezes.getSelectedItem().toString();
	}
	
	public static void setParcelamento(String parcelamento) {
		ModelVendas.parcelamento = parcelamento;
	}
	
	public static String getCartao() {
		return cartao;
	}
	
	public static void setCartao(String cartao) {
		ModelVendas.cartao = cartao;
	}
	
	public static String getNumeroCartao() {
		return numeroCartao;
	}
	
	public static void setNumeroCartao(String numeroCartao) {
		ModelVendas.numeroCartao = numeroCartao;
	}
	
	public static String getBanco() {
		return Vendas.banco1.getSelectedItem().toString();
	}
	
	public static void setBanco(String banco) {
		ModelVendas.banco = banco;
	}
	
	public static String getNumeroCheque() {
		return Vendas.numeroCheque1.getText();
	}
	
	public static void setNumeroCheque(String numeroCheque) {
		Vendas.numeroCheque1.setText(numeroCheque);
	}
	
	public static String getAgencia() {
		return Vendas.agencia1.getText();
	}
	
	public static void setAgencia(String agencia) {
		Vendas.agencia1.setText(agencia);
	}
	
	public static String getValortotal() {
		return Vendas.valorTotal1.getText();
	}
	
	public static void setValortotal(String valortotal) {
		Vendas.valorTotal1.setText(valortotal);
	}
	
	public static String getDesconto() {
		return Vendas.desconto1.getText();
	}
	
	public static void setDesconto(String desconto) {
		Vendas.desconto1.setText(desconto);
	}
	
	public static String getValorFinal() {
		return Vendas.valorFinal1.getText();
	}
	
	public static void setValorFinal(String valorFinal) {
		Vendas.valorFinal1.setText(valorFinal);
	}
	
	public static String getValorParcelado() {
		return Vendas.valorParcelado1.getText();
	}
	
	public static void setValorParcelado(String valorParcelado) {
		Vendas.valorParcelado1.setText(valorParcelado);
	}
	
	public static String getValorPago() {
		return Vendas.valorPago1.getText();
	}
	
	public static void setValorPago(String valorPago) {
		Vendas.valorPago1.setText(valorPago);
	}
	
	public static String getTroco() {
		return Vendas.troco1.getText();
	}
	
	public static void setTroco(String troco) {
		Vendas.troco1.setText(troco);
	}
	
	public static String getLocalVenda() {
		return "Balcão";
	}
	
	public static void setLocalVenda(String localVenda) {
		ModelVendas.localVenda = localVenda;
	}
	
	public static String getItem1() {
		return Vendas.comboProduto.getSelectedItem().toString();
	}
	
	public static void setItem1(String item) {
		Vendas.comboProduto.setSelectedItem(item);
	}
	
	public static String getQuant() {
		return Vendas.quantidade1.getValue().toString();
	}
	
	public static void setQuant(String item) {
		Vendas.quantidade1.setValue(Integer.parseInt(item));
	}
	
	public static String getItem() {
		return Vendas.modelo.getValueAt(linha, 0).toString();
	}
	
	public static void setItem(String item) {
		Vendas.modelo.setValueAt(item, linha, 0);
	}
	
	public static String getCodigoItem() {
		return Vendas.modelo.getValueAt(linha, 1).toString();
	}
	
	public static void setCodigoItem(String codigoItem) {
		Vendas.modelo.setValueAt(codigoItem, linha, 1);
	}
	
	public static String getDescricao() {
		return Vendas.modelo.getValueAt(linha, 2).toString();
	}
	
	public static void setDescricao(String descricao) {
		Vendas.modelo.setValueAt(codigoItem, linha, 2);
	}
	
	public static String getQuantidade() {
		return Vendas.modelo.getValueAt(linha, 3).toString();
	}
	
	public static void setQuantidade(String quantidade) {
		Vendas.modelo.setValueAt(quantidade, linha, 3);
	}
	
	public static String getPrecoUnitario() {
		return Vendas.modelo.getValueAt(linha, 4).toString();
	}
	
	public static void setPrecoUnitario(String precoUnitario) {
		Vendas.modelo.setValueAt(precoUnitario, linha, 4);
	}
	
	public static String getTotal() {
		return Vendas.modelo.getValueAt(linha, 5).toString();
	}
	
	public static void setTotal(String total) {
		Vendas.modelo.setValueAt(total, linha, 5);
	}
	
	public static String getRemove() {
		return Vendas.comboRemoveItem.getSelectedItem().toString();
	}
	
	public static void setRemove(String remove) {
		ModelVendas.parcelamento = remove;
	}
	
	public static int getQuantRemove() {
		return (int) Vendas.QuantidadeRem.getValue();
	}
	
	public static void setQuantRemove(String parcelamento) {
		ModelVendas.parcelamento = parcelamento;
	}
	
	public static int getLinha() {
		return linha;
	}
	
	public static void setLinha(int linha) {
		ModelVendas.linha = linha;
	}
	
	public static String getNumeroVenda2() {
		return numeroVenda2;
	}
	
	public static void setNumeroVenda2(String numeroVenda2) {
		ModelVendas.numeroVenda2 = numeroVenda2;
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Cliente
	
	// Variaveis Cliente
	public static String	codigoCliente;
	public static String	nomeCliente;
	public static String	dataNascimentoCliente;
	public static String	nacionalidadeCliente;
	public static String	emailCliente;
	public static String	rgCliente;
	public static String	cpfCliente;
	public static String	estadoCivilCliente;
	public static String	nomePaiCliente;
	public static String	NomeMaeCliente;
	public static String	telefone1;
	public static String	telefone2;
	public static String	celular1;
	public static String	celular2;
	public static String	logradouroCliente;
	public static String	bairro;
	public static String	numero;
	public static String	cep;
	public static String	complemento;
	public static String	estado;
	public static String	cidade;
	public static String	autorizacaoExtra;
	
	public static String getCodigoCliente() {
		return Vendas.codigoCliente3.getText();
	}
	
	public static void setCodigoCliente(String codigoCliente) {
		Vendas.codigoCliente3.setText(codigoCliente);
	}
	
	public static String getNomeCliente() {
		return Vendas.nome3.getText();
	}
	
	public static void setNomeCliente(String nomeCliente) {
		Vendas.nome3.setText(nomeCliente);
	}
	
	public static String getDataNascimentoCliente() {
		return Vendas.nascimento3.getText();
	}
	
	public static void setDataNascimentoCliente(String dataNascimentoCliente) {
		Vendas.nascimento3.setText(dataNascimentoCliente);
	}
	
	public static String getNacionalidadeCliente() {
		return Vendas.nacionalidade3.getText();
	}
	
	public static void setNacionalidadeCliente(String nacionalidadeCliente) {
		Vendas.nacionalidade3.setText(nacionalidadeCliente);
	}
	
	public static String getEmailCliente() {
		return Vendas.email3.getText();
	}
	
	public static void setEmailCliente(String emailCliente) {
		Vendas.email3.setText(emailCliente);
	}
	
	public static String getRgCliente() {
		return Vendas.rg3.getText();
	}
	
	public static void setRgCliente(String rgCliente) {
		Vendas.rg3.setText(rgCliente);
	}
	
	public static String getCpfCliente() {
		return Vendas.cpf3.getText();
	}
	
	public static void setCpfCliente(String cpfCliente) {
		Vendas.cpf3.setText(cpfCliente);
	}
	
	public static String getEstadoCivilCliente() {
		return Vendas.comboEstadoCivil.getSelectedItem().toString();
	}
	
	public static void setEstadoCivilCliente(String estadoCivilCliente) {
		Vendas.estadoCivilConsulta.setText(estadoCivilCliente);
	}
	
	public static String getNomePaiCliente() {
		return Vendas.nomePai3.getText();
	}
	
	public static void setNomePaiCliente(String nomePaiCliente) {
		Vendas.nomePai3.setText(nomePaiCliente);
	}
	
	public static String getNomeMaeCliente() {
		return Vendas.nomeMae3.getText();
	}
	
	public static void setNomeMaeCliente(String nomeMaeCliente) {
		Vendas.nomeMae3.setText(nomeMaeCliente);
	}
	
	public static String getTelefone1() {
		return Vendas.telefone3.getText();
	}
	
	public static void setTelefone1(String telefone1) {
		Vendas.telefone3.setText(telefone1);
	}
	
	public static String getTelefone2() {
		return Vendas.telefone23.getText();
	}
	
	public static void setTelefone2(String telefone2) {
		Vendas.telefone23.setText(telefone2);
	}
	
	public static String getCelular1() {
		return Vendas.celular3.getText();
	}
	
	public static void setCelular1(String celular1) {
		Vendas.celular3.setText(celular1);
	}
	
	public static String getCelular2() {
		return Vendas.celular23.getText();
	}
	
	public static void setCelular2(String celular2) {
		Vendas.celular23.setText(celular2);
	}
	
	public static String getLogradouroCliente() {
		return Vendas.logradouro3.getText();
	}
	
	public static void setLogradouroCliente(String logradouroCliente) {
		Vendas.logradouro3.setText(logradouroCliente);
	}
	
	public static String getBairro() {
		return Vendas.bairro3.getText();
	}
	
	public static void setBairro(String bairro) {
		Vendas.bairro3.setText(bairro);
	}
	
	public static String getNumero() {
		return Vendas.numero3.getText();
	}
	
	public static void setNumero(String numero) {
		Vendas.numero3.setText(numero);
	}
	
	public static String getCep() {
		return Vendas.cep3.getText();
	}
	
	public static void setCep(String cep) {
		Vendas.cep3.setText(cep);
	}
	
	public static String getComplemento() {
		return Vendas.complemento3.getText();
	}
	
	public static void setComplemento(String complemento) {
		Vendas.complemento3.setText(complemento);
	}
	
	public static String getEstado() {
		return Vendas.comboUf3.getSelectedItem().toString();
	}
	
	public static void setEstado(String estado) {
		Vendas.ufConsulta.setText(estado);
	}
	
	public static String getCidade() {
		return Vendas.comboCidade3.getSelectedItem().toString();
	}
	
	public static void setCidade(String cidade) {
		Vendas.cidadeConsulta.setText(cidade);
	}
	
	public static String getAutorizacaoExtra() {
		return Vendas.autorizados3.getText();
	}
	
	public static void setAutorizacaoExtra(String autorizacaoExtra) {
		Vendas.autorizados3.setText(autorizacaoExtra);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	// Delivery
	
	// Variaveis Delivery
	public static String	numeroVendaDel;
	public static String	telefoneDel;
	public static String	cpfDel;
	public static String	nomeDel;
	public static String	enderecoDel;
	public static String	bairroDel;
	public static String	numeroDel;
	public static String	cidadeDel;
	public static String	complementoDel;
	public static String	codigoDel;
	
	public static String getNumeroVendaDel() {
		return Vendas.numeroVendaDelivery.getText();
	}
	
	public static void setNumeroVendaDel(String venda) {
		Vendas.numeroVendaDelivery.setText(venda);
	}
	
	public static String getTelefoneDel() {
		return Vendas.telefone4.getText();
	}
	
	public static void setTelefoneDel(String telefoneDel) {
		Vendas.telefone4.setText(telefoneDel);
	}
	
	public static String getCpfDel() {
		return Vendas.cpf4.getText();
	}
	
	public static void setCpfDel(String cpfDel) {
		Vendas.cpf4.setText(cpfDel);
	}
	
	public static String getNomeDel() {
		return Vendas.nome4.getText();
	}
	
	public static void setNomeDel(String nomeDel) {
		Vendas.nome4.setText(nomeDel);
	}
	
	public static String getEnderecoDel() {
		return Vendas.logradouro4.getText();
	}
	
	public static void setEnderecoDel(String enderecoDel) {
		Vendas.logradouro4.setText(enderecoDel);
	}
	
	public static String getBairroDel() {
		return Vendas.bairro4.getText();
	}
	
	public static void setBairroDel(String bairroDel) {
		Vendas.bairro4.setText(bairroDel);
	}
	
	public static String getNumeroDel() {
		return Vendas.numero4.getText();
	}
	
	public static void setNumeroDel(String numeroDel) {
		Vendas.numero4.setText(numeroDel);
	}
	
	public static String getCidadeDel() {
		return Vendas.cidade4.getText();
	}
	
	public static void setCidadeDel(String cidadeDel) {
		Vendas.cidade4.setText(cidadeDel);
	}
	
	public static String getComplementoDel() {
		return Vendas.complemento4.getText();
	}
	
	public static void setComplementoDel(String complementoDel) {
		Vendas.complemento4.setText(complementoDel);
	}
	
	public static String getCodigoDel() {
		return Vendas.codDelivery.getText();
	}
	
	public static void setCodigoDel(String codigoDel) {
		Vendas.codDelivery.setText(codigoDel);
	}
	
	public static String getItemDelivery1() {
		return Vendas.comboProduto3.getSelectedItem().toString();
	}
	
	public static void setItemDelivery1(String item) {
		Vendas.comboProduto3.setSelectedItem(item);
	}
	
	public static String getQuantDelivery() {
		return Vendas.spinnerQuantDelivery.getValue().toString();
	}
	
	public static void setQuantDelivery(String item) {
		Vendas.spinnerQuantDelivery.setValue(Integer.parseInt(item));
	}
	
	public static String getItemDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 0).toString();
	}
	
	public static void setItemDelivery(String item) {
		Vendas.modeloDelivery.setValueAt(item, linha, 0);
	}
	
	public static String getCodigoItemDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 1).toString();
	}
	
	public static void setCodigoItemDelivery(String codigoItem) {
		Vendas.modeloDelivery.setValueAt(codigoItem, linha, 1);
	}
	
	public static String getDescricaoDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 2).toString();
	}
	
	public static void setDescricaoDelivery(String descricao) {
		Vendas.modeloDelivery.setValueAt(descricao, linha, 2);
	}
	
	public static String getQuantidadeDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 3).toString();
	}
	
	public static void setQuantidadeDelivery(String quantidade) {
		Vendas.modeloDelivery.setValueAt(quantidade, linha, 3);
	}
	
	public static String getPrecoUnitarioDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 4).toString();
	}
	
	public static void setPrecoUnitarioDelivery(String precoUnitario) {
		Vendas.modeloDelivery.setValueAt(precoUnitario, linha, 4);
	}
	
	public static String getTotalDelivery() {
		return Vendas.modeloDelivery.getValueAt(linha, 5).toString();
	}
	
	public static void setTotalDelivery(String total) {
		Vendas.modeloDelivery.setValueAt(total, linha, 5);
	}
	
	public static String getValorFinalDelivery() {
		return Vendas.valorFinalDelivery.getText();
	}
	
	public static void setValorFinalDelivery(String valorFinal) {
		Vendas.valorFinalDelivery.setText(valorFinal);
	}
	
	public static String getValorPagoDelivery() {
		return Vendas.valorPagoDelivery.getText();
	}
	
	public static void setValorPagoDelivery(String valorPago) {
		Vendas.valorPagoDelivery.setText(valorPago);
	}
	
	public static String getTrocoDelivery() {
		return Vendas.trocoDelivery.getText();
	}
	
	public static void setTrocoDelivery(String troco) {
		Vendas.trocoDelivery.setText(troco);
	}
	
	public static String getRemoveDelivery() {
		return Vendas.comboBoxRemoveDelivery.getSelectedItem().toString();
	}
	
	public static int getQuantRemoveDelivery() {
		return (int) Vendas.spinnerRemove.getValue();
	}
}
