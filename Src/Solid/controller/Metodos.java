package Solid.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Solid.view.Inicio;

public class Metodos extends javax.swing.JFrame {
	
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	
	private static final long	serialVersionUID	= -4169426125318691593L;
	
	protected int			ctr;
	static BancoDados			x			= new BancoDados();
	
	public Metodos() {
	}
	
	/*----------------------------------------------------*/
	
	public static void formWindowClosing(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		
		if (Inicio.mesasAbertas <= 0) {
			int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?",
					"Fechamento de Programa", JOptionPane.YES_NO_OPTION);
			if (sair == 0) {
				System.exit(0);
			}
			UIManager.put("OptionPane.yesButtonText", "Sim");
			UIManager.put("OptionPane.noButtonText", "Não");
		}
		else
			JOptionPane.showMessageDialog(null,
					"Ainda há mesas abertas. Feche-as antes de sair do programa!",
					"Atenção", JOptionPane.WARNING_MESSAGE);
		
	}
	
	/*----------------------------------------------------*/
	
	public static void verifcaCPF() {
		
	}
	
	/*----------------------------------------------------*/
	
	public static class RedimensionarImagem {
		public static void main(String[] args) throws IOException {
			
			JFileChooser selecionarArquivo = new JFileChooser();
			
			BufferedImage imagem = ImageIO.read(RedimensionarImagem.class
					.getResourceAsStream("koala.jpg"));
			
			File file = new File(String.valueOf("C:"));
			selecionarArquivo.setCurrentDirectory(file);
			
			int new_w = 165, new_h = 115;
			BufferedImage new_img = new BufferedImage(new_w, new_h,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = new_img.createGraphics();
			g.drawImage(imagem, 0, 0, new_w, new_h, null);
			ImageIO.write(new_img, "JPG", new File("back.jpg"));
		}
	}
	
	/*----------------------------------------------------*/
	
	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Fast".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Metodos.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Metodos().setVisible(true);
				
			}
		});
	}
	
	/*----------------------------------------------------*/
	
}