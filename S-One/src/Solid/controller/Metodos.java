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
import Solid.view.Vendas;

public class Metodos extends javax.swing.JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long	serialVersionUID	= -4169426125318691593L;

	protected int				ctr;
	static BancoDados					x				= new BancoDados();

	public Metodos() {
		
	}

	/*----------------------------------------------------*/

	public static void formWindowClosing(java.awt.event.WindowEvent evt) {
		// TODO add your handling code here:
		
		if(Inicio.caixa.equals("fechado")){
			if(Vendas.contEntrega>-1){
				JOptionPane.showMessageDialog(null, "Ainda há ENTREGAS em aberto. Feche-as antes de sair do programa!",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			}
			else if (Inicio.mesasAbertas <= 0) {
			int sair = JOptionPane.showConfirmDialog(null, "      Tem certeza que deseja sair?\n"
														 + "Todos os dados não salvos serão perdidos.", "Fechamento de Programa",JOptionPane.YES_NO_OPTION);
			if (sair == 0) {
				if(VendasController.passou==1){
				String comandosql4 = "TRUNCATE TABLE `delivery`";            			
    			x.grava(comandosql4);
    			}
				System.exit(0);
			}
			UIManager.put("OptionPane.yesButtonText", "Sim");
			UIManager.put("OptionPane.noButtonText", "Não");
		} else
			JOptionPane.showMessageDialog(null, "Ainda há MESAS abertas. Feche-as antes de sair do programa!",
					"Atenção", JOptionPane.WARNING_MESSAGE);
	}
		else JOptionPane.showMessageDialog(null, "É necessário FECHAR o CAIXA antes de sair!",
				"Atenção", JOptionPane.WARNING_MESSAGE);
	}
	

	/*----------------------------------------------------*/
	
	
	
	/*----------------------------------------------------*/

	public static void verifcaCPF() {

	}

	/*----------------------------------------------------*/

	public static class RedimensionarImagem {
		public static void main(String[] args) throws IOException {

			JFileChooser selecionarArquivo = new JFileChooser();

			BufferedImage imagem = ImageIO.read(RedimensionarImagem.class.getResourceAsStream("koala.jpg"));

			File file = new File(String.valueOf("C:"));
			selecionarArquivo.setCurrentDirectory(file);

			int new_w = 165, new_h = 115;
			BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = new_img.createGraphics();
			g.drawImage(imagem, 0, 0, new_w, new_h, null);
			ImageIO.write(new_img, "JPG", new File("back.jpg"));
		}
	}

	
	/*----------------------------------------------------*/

}