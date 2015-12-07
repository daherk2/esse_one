package Solid.view;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import Solid.controller.BancoDados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cheque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNmeroCheque = new JLabel("N\u00FAmero Cheque : ");
	private final JTextField cheque = new JTextField();
	private final JTable table = new JTable();
	private final JButton btnSalvar = new JButton("Salvar");
	private final JScrollPane scrollPane = new JScrollPane();
	private DefaultTableModel model;
	private final JButton btnDel = new JButton("Del");

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cheque frame = new Cheque(0,"0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public Cheque(String qnt, String cod) {
		setAlwaysOnTop(true);
		
		setLocationRelativeTo(null);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 292, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNmeroCheque.setBounds(10, 11, 131, 26);
		contentPane.add(lblNmeroCheque);
		cheque.setBounds(10, 36, 263, 20);
		contentPane.add(cheque);
		cheque.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if(model.getRowCount() < Integer.parseInt(qnt)){	
			Object chk[] = new Object[1];
			chk[0]=cheque.getText();
			model.addRow(chk);
			}else{JOptionPane.showMessageDialog(null, "Quantidade de cheques esgotados!");}
			
			cheque.setText("");
			
			}
		});
		btnAdd.setBounds(10, 273, 89, 26);
		contentPane.add(btnAdd);
		scrollPane.setBounds(10, 67, 263, 195);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cheque N\u00BA"
			}
		));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BancoDados f = new BancoDados();
				for(int i=0; i<model.getRowCount();i++){
					BancoDados.conecta();
					f.grava("INSERT INTO cheque(cod, numero) VALUES('"+cod+"','"+table.getValueAt(i, 0)+"')");
				}
				

				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				
				JOptionPane.showMessageDialog(null, "Salvo com Sucesso.");
			
			}
		});
		btnSalvar.setBounds(184, 274, 89, 25);
		
		contentPane.add(btnSalvar);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			int sel = table.getSelectedRow();
			
			
			model.removeRow(sel);
			
			
			}
		});
		btnDel.setBounds(109, 273, 65, 26);
		contentPane.add(btnDel);
	}
}
