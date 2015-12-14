package Solid.model;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Solid.controller.BancoDados;

public class PPReport {

	/*
	 * RH ****************************************************************************************
	 */
	
	public void Funcionario() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios WHERE numeroRegistro = '"+ ModelRH.getCodigo() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Funcionario.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);			
		}

	}
	
	public void CargoSalario() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM cargo_salario";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_CargoSalario.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void TreinamentoDesenvolvimento() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM desenvolvimento_RH";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_TreinamentoDesenvolvimento.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	

	/*
	 * Suprimentos ****************************************************************************************
	 */

	public void Produto() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM produtos WHERE codigoProduto = '"+ ModelSuprimentos.getCodigoProduto() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Produto.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void MateriaPrima() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM materia_p WHERE codigo = '"+ ModelSuprimentos.getCodigoMateriaPrima() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_MateriaPrima.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Fornecedor() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM fornecedor WHERE codigoFornecedor = '"+  ModelSuprimentos.getCodigoFornecedor() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Fornecedor.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Estoque() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM estoque";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Estoque.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void PedidoCompra() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_PedidoCompra.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	


	/*
	 * Vendas ****************************************************************************************
	 */

	public void Cliente() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM clientes WHERE codigo = '"+ ModelVendas.getCodigoCliente()+ "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Cliente.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Entregas() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM delivery WHERE status = '"+ "Aberto"+ "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Entregas.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	


	/* 
	 * Logistica ****************************************************************************************
	 */
	
	public void Veiculo() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM veiculos WHERE codigo = '"+ ModelLogistica.getCodigo1() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Veiculo.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Motorista() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM motorista WHERE numeroRegistro = '"+ ModelLogistica.getCodigo() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObjectFromFile("report_Motorista.jasper");
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Transportadora() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM transportadora WHERE codigoTransportadora = '"+ ModelLogistica.getCodigoTransportadora()+ "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
			            .getClassLoader().getResource("report_Transportadora.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	

	
	/*
	 * Financeiro ****************************************************************************************
	 */
	
	public void FluxoCaixa() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
			            .getClassLoader().getResource("report_FluxoCaixa.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void GiroEstoque() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
			            .getClassLoader().getResource("report_GiroEstoque.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public void Contas() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass().getClassLoader().getResource("report_Contas.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex, "Atenção", JOptionPane.ERROR_MESSAGE);
		}

	}



}
