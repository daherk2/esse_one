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
import Solid.view.Logistica;
import Solid.view.RH;

public class PPReport {
	
	/*
	 * RH
	 */
	
	public void Funcionarios() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "select*from funcionarios where numeroRegistro = '"
					+ RH.NumeroRegistro1.getText() + "'";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
					.getClassLoader().getResource("report1.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex);
		}
		
	}
	
	/*
	 * Suprimentos
	 */
	
	public void Suprimentos() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios ;";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
					.getClassLoader().getResource("report1.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex);
		}
		
	}
	
	/*
	 * Vendas
	 */
	
	public void Vendas() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios ;";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
					.getClassLoader().getResource("report1.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex);
		}
		
	}
	
	/*
	 * Financeiro
	 */
	
	public void FluxoCaixa() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM funcionarios ;";
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(getClass()
					.getClassLoader().getResource("report1.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatório" + ex);
		}
		
	}
	
	/*
	 * Logistica
	 */
	public void Veiculos() {
		
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM veiculo WHERE codigo = '"
					+ String.valueOf(Logistica.codigo.getText()) + "';";
			JasperReport relatorio = (JasperReport) JRLoader
					.loadObjectFromFile(("report_Veiculo.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatorio" + ex);
			
		}
	}
	
	public void Transportadora() {
		
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM transportadora WHERE codigo = '"
					+ String.valueOf(Logistica.codigo.getText()) + "';";
			JasperReport relatorio = (JasperReport) JRLoader
					.loadObjectFromFile(("report_Transportadora.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatorio" + ex);
			
		}
		
	}
	
	public void Motorista() {
		try {
			BancoDados x = new BancoDados();
			BancoDados.conecta();
			String comandosql = "SELECT * FROM motorista WHERE numeroRegistro = '"
					+ String.valueOf(Logistica.NumeroRegistro.getText()) + "';";
			JasperReport relatorio = (JasperReport) JRLoader
					.loadObjectFromFile(("report_Funcionario.jasper"));
			JRResultSetDataSource con = new JRResultSetDataSource(x.Consultar(comandosql));
			JasperPrint jrp = JasperFillManager.fillReport(relatorio, null, con);
			JasperViewer jrviewer = new JasperViewer(jrp, false);
			jrviewer.setVisible(true);
			jrviewer.toFront();
		}
		catch (JRException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao imprimir relatorio" + ex);
			
		}
		
	}
	
}
