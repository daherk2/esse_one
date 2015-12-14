package Solid.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Solid.controller.BancoDados;

import java.awt.SystemColor;

public class ListaCompra extends JFrame {
	
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	public static final long	serialVersionUID	= 1908718949326704455L;
	
	public JPanel			contentPaneAjuda;
	private JTable			tableListaCompra;
	private static JTextField		textTotal;
	public static DefaultTableModel   TabelaListaCompra;
	static BancoDados x	= new BancoDados();
	public static int contLinhaLista=0;
	static DefaultTableCellRenderer   central          = new DefaultTableCellRenderer();
	public static NumberFormat        nf;
			
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public ListaCompra() {
		setResizable(false);
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				ListaCompra.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		
		setTitle("LISTA DE COMPRAS");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(187, 71, 900, 636);
		contentPaneAjuda = new JPanel();
		contentPaneAjuda.setBackground(Color.WHITE);
		contentPaneAjuda.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneAjuda);
		contentPaneAjuda.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBorderPainted(false);
		menuBar.setBounds(293, 0, 308, 32);
		contentPaneAjuda.add(menuBar);
		
		JButton btnSalvar = new JButton("E-mail");
		menuBar.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "A lista foi enviada para o seu E-mail !", "Lista Compra", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSalvar.setIcon(new ImageIcon(ListaCompra.class.getResource("/icones1_24px/1425606665_678071-address-book-alt-128.png")));
		btnSalvar.setToolTipText("");
		btnSalvar.setMnemonic(KeyEvent.VK_ENTER);
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		JButton btnImprimir = new JButton("Imprimir");
		menuBar.add(btnImprimir);
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimir.setIcon(new ImageIcon(ListaCompra.class
				.getResource("/icones1_24px/1425606647_678126-box-in-128.png")));
		btnImprimir.setToolTipText("");
		btnImprimir.setMnemonic(KeyEvent.VK_ENTER);
		btnImprimir.setForeground(Color.BLACK);
		btnImprimir.setFont(new Font("Kalinga", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.setIcon(new ImageIcon(ListaCompra.class.getResource("/icones1_24px/1425606718_678075-sign-ban-128.png")));
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.janelaLista=0;
				ListaCompra.this.dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 874, 437);
		contentPaneAjuda.add(scrollPane);
		
		central.setHorizontalAlignment(SwingConstants.CENTER);
		tableListaCompra = new JTable();
		tableListaCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableListaCompra.setRowHeight(22);
		tableListaCompra.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, Boolean.FALSE},
			},
			new String[] {
				"ITEM", "TIPO", "PRE\u00C7O", "EST. ATUAL", "EST. MINIMO", "ADICIONAR"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableListaCompra.getColumnModel().getColumn(0).setPreferredWidth(284);
		tableListaCompra.getColumnModel().getColumn(1).setPreferredWidth(112);
		tableListaCompra.getColumnModel().getColumn(3).setPreferredWidth(95);
		tableListaCompra.getColumnModel().getColumn(0).setCellRenderer(central);
		tableListaCompra.getColumnModel().getColumn(1).setCellRenderer(central);
		tableListaCompra.getColumnModel().getColumn(2).setCellRenderer(central);
		tableListaCompra.getColumnModel().getColumn(3).setCellRenderer(central);
		tableListaCompra.getColumnModel().getColumn(4).setCellRenderer(central);
		
		scrollPane.setViewportView(tableListaCompra);
		TabelaListaCompra = (DefaultTableModel) tableListaCompra.getModel();
		TabelaListaCompra.removeRow(0);
		
		JLabel lblNewLabel = new JLabel("Itens abaixo do estoque minimo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 31, 365, 32);
		contentPaneAjuda.add(lblNewLabel);
		
		JLabel lblR = new JLabel("R$");
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setFont(new Font("Kalinga", Font.BOLD | Font.ITALIC, 16));
		lblR.setBounds(684, 559, 48, 40);
		contentPaneAjuda.add(lblR);
		
		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setFont(new Font("Kalinga", Font.BOLD, 18));
		textTotal.setText("0,00");
		textTotal.setBounds(684, 559, 200, 40);
		contentPaneAjuda.add(textTotal);
		textTotal.setColumns(10);
		
		JLabel lblTotalDaLista = new JLabel("Total da Lista");
		lblTotalDaLista.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalDaLista.setFont(new Font("Kalinga", Font.PLAIN, 18));
		lblTotalDaLista.setBounds(684, 509, 200, 50);
		contentPaneAjuda.add(lblTotalDaLista);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ListaCompra.class
				.getResource("/imagens_principais/menu.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 894, 32);
		contentPaneAjuda.add(label);
		
		JLabel labelFundo = new JLabel("");
		labelFundo.setIcon(new ImageIcon(ListaCompra.class.getResource("/papel_parede/(7).png")));
		labelFundo.setBounds(0, 0, 900, 622);
		contentPaneAjuda.add(labelFundo);			
		
		ListaCompra.SetarListaProd();
		
		this.setLocationRelativeTo(null);		
	}

	public static void SetarListaProd() {
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		
		System.out.println("Tamanho array produto = "+Menu.Produtos.size());
			
			try { // while(dados.next())
				// {
			for(int i=0;i<Menu.Produtos.size();i++){
			ResultSet dados = x.Consultar("select*from produtos where nome = '" +Menu.Produtos.get(i)+ "'");
			dados.next();			
			if(dados.getString("fichaTecnica").equals("não")){				
			TabelaListaCompra.addRow(new Object[] { Menu.Produtos.get(i),"Produto",
					dados.getString("precoCusto"), dados.getString("estoqueAtual"), 
					dados.getString("estoqueMinimo"),false});
			contLinhaLista++;
			textTotal.setText(String.valueOf(nf.format(Double.parseDouble(textTotal.getText().replace(",", "."))+Double.parseDouble(dados.getString("precoCusto").replace(",", ".")))));
			}
			}
			for(int i=0;i<Menu.MateriaPrima.size();i++){
				ResultSet	dados = x.Consultar("select*from materia_p where nome = '" +Menu.MateriaPrima.get(i)+ "'");				
				dados.next();
				TabelaListaCompra.addRow(new Object[] { Menu.MateriaPrima.get(i),"Matéria Prima",
						dados.getString("precoUnidade"), dados.getString("estoqueAtual"), 
						dados.getString("estoqueMinimo"),false});
				contLinhaLista++;
				textTotal.setText(String.valueOf(nf.format(Double.parseDouble(textTotal.getText().replace(",", "."))+Double.parseDouble(dados.getString("precoUnidade").replace(",", ".")))));
				}
				} catch (SQLException erro) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,erro,"Erro", JOptionPane.WARNING_MESSAGE);									
			}
				
	}
	
	
}