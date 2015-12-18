package Solid.view;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.fast.FastLookAndFeel;

public class MainSolid1 {
	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */
	public static void main(String[] args) {
		
		try {
			// here you can put the selected theme class name in JTattoo
			Properties props = new Properties();
			props.put("logoString", "Solid - One");
			FastLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// inicia o programa S-One
			new Inicio();

		}
		catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainSolid1.class.getName()).log(
			            java.util.logging.Level.SEVERE, null, ex);
		}
		
		/*
		
		File file = new File("conf/database.bin");
		if(file.exists()){
			System.out.println("Existe");
		}else{
			System.out.println("Não Existe");
		}
		
		*/
		
	}
}