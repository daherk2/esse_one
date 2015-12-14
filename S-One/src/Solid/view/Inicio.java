package Solid.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import Solid.controller.BancoDados;
import Solid.controller.LoginController;

import com.jgoodies.animation.Animation;
import com.jgoodies.animation.AnimationEvent;
import com.jgoodies.animation.AnimationListener;
import com.jgoodies.animation.Animations;
import com.jgoodies.animation.Animator;
import com.jgoodies.animation.swing.animations.BasicTextAnimation;
import com.jgoodies.animation.swing.components.BasicTextLabel;

public class Inicio extends JFrame {

	/**
	 * @author Rafael Miranda
	 * @author Luiz Gustavo Silvestre
	 */

	private static final long serialVersionUID = 4554045523886324940L;

	// instancia a classe do banco para conexão
	BancoDados                x                = new BancoDados();

	// variaveis do sistema
	public static String caixa="fechado";
	public static int         mesasAbertas     = 0,janelaLista=0,janelaCaixa=0;
	static int                c                = 0, ctrl = 0, rd = 0;
	BasicTextLabel            textMensagem;
	private JLabel            labelFundoRH;
	private JLabel            labelFundoSuprimentos;
	private JLabel            labelFundoVendas;
	private JLabel            labelFundoLogistica;
	private JLabel            labelFundoFinanceiro;

	private Animation createAnimation() {

		// texto de apresentação do sistema

		// Animation a1 = BasicTextAnimation.defaultSpace(textMensagem, 00,
		// "",Color.ORANGE);
		Animation a2 = BasicTextAnimation.defaultSpace(textMensagem, 500, "S-One ERP",
		            Color.WHITE);
		Animation a3 = BasicTextAnimation.defaultScale(textMensagem, 500, "SOLUÇÃO",
		            Color.WHITE);
		Animation a4 = BasicTextAnimation.defaultScale(textMensagem, 500, "EM", Color.WHITE);
		Animation a5 = BasicTextAnimation
		            .defaultSpace(textMensagem, 500, "GESTÃO", Color.WHITE);
		Animation a6 = BasicTextAnimation.defaultSpace(textMensagem, 500, "EMPRESARIAL !!",
		            Color.WHITE);
		Animation a7 = BasicTextAnimation.defaultSpace(textMensagem, 500, "", Color.WHITE);

		Animation allSeq = Animations.sequential(new Animation[] {

		Animations.pause(200), a2, Animations.pause(200), a3, Animations.pause(200), a4,
		            Animations.pause(200), a5, Animations.pause(200), a6,
		            Animations.pause(200), a7,

		});

		return Animations.parallel(allSeq, a2);
	}

	public Inicio() {

		// metodo construtor
		super();
		setUndecorated(true);
		setRootPaneCheckingEnabled(false);
		setFocusCycleRoot(false);
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setTitle("BEM VINDO AO S-1");

		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
		            Inicio.class.getResource("/logos_solid/SimboloPSemFundo - Copia.png")));
		getContentPane().setFont(new Font("Kalinga", Font.PLAIN, 14));

		setResizable(false);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setName("inicio");
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);

		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBorderPainted(false);
		progressBar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(0, 452, 784, 25);
		getContentPane().add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setStringPainted(true);

		textMensagem = new BasicTextLabel();
		textMensagem.setFocusable(false);
		textMensagem.setFocusTraversalKeysEnabled(false);
		textMensagem.setFont(new Font("Kalinga", Font.BOLD, 40));
		textMensagem.setColor(Color.WHITE);
		textMensagem.setBounds(142, 60, 500, 90);
		getContentPane().add(textMensagem);

		labelFundoRH = new JLabel("");
		labelFundoRH.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoRH.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoRH.setBackground(SystemColor.inactiveCaptionBorder);
		labelFundoRH.setBounds(0, 0, 784, 506);
		getContentPane().add(labelFundoRH);
		labelFundoRH.setIcon(new ImageIcon(Inicio.class
		            .getResource("/imagens_principais/rh_editado.jpg")));

		labelFundoSuprimentos = new JLabel("");
		labelFundoSuprimentos.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoSuprimentos.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoSuprimentos.setBounds(0, 0, 784, 506);
		getContentPane().add(labelFundoSuprimentos);
		labelFundoSuprimentos.setIcon(new ImageIcon(Inicio.class
		            .getResource("/imagens_principais/suprimentos_editado.jpg")));

		labelFundoVendas = new JLabel("");
		labelFundoVendas.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoVendas.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoVendas.setBounds(0, 0, 784, 506);
		getContentPane().add(labelFundoVendas);
		labelFundoVendas.setIcon(new ImageIcon(Inicio.class
		            .getResource("/imagens_principais/vendas2_editado.jpg")));

		labelFundoLogistica = new JLabel("");
		labelFundoLogistica.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoLogistica.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoLogistica.setBounds(0, 0, 784, 506);
		getContentPane().add(labelFundoLogistica);
		labelFundoLogistica.setIcon(new ImageIcon(Inicio.class
		            .getResource("/imagens_principais/logistica_editado.jpg")));

		labelFundoFinanceiro = new JLabel("");
		labelFundoFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		labelFundoFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		labelFundoFinanceiro.setBounds(0, 0, 784, 506);
		getContentPane().add(labelFundoFinanceiro);
		labelFundoFinanceiro.setIcon(new ImageIcon(Inicio.class
		            .getResource("/imagens_principais/financeiro_editado.jpg")));

		this.setSize(785, 505);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		new Thread(new Runnable() {
			public void run() {
				try {
					progressBar.setValue(progressBar.getMinimum());
					progressBar.setStringPainted(true);
					int valor = progressBar.getValue();
					// BancoDados.conecta();
					for (int i = 0; i <= 100; i++) {

						progressBar.setValue(valor + i);

						if (i == 0) {
							labelFundoRH.setVisible(true);
							labelFundoSuprimentos.setVisible(false);
							labelFundoVendas.setVisible(false);
							labelFundoLogistica.setVisible(false);
							labelFundoFinanceiro.setVisible(false);
						}
						if (i == 20) {
							labelFundoRH.setVisible(false);
							labelFundoSuprimentos.setVisible(true);
							labelFundoVendas.setVisible(false);
							labelFundoLogistica.setVisible(false);
							labelFundoFinanceiro.setVisible(false);
						}
						if (i == 40) {
							labelFundoRH.setVisible(false);
							labelFundoSuprimentos.setVisible(false);
							labelFundoVendas.setVisible(true);
							labelFundoLogistica.setVisible(false);
							labelFundoFinanceiro.setVisible(false);
						}
						if (i == 60) {
							labelFundoRH.setVisible(false);
							labelFundoSuprimentos.setVisible(false);
							labelFundoVendas.setVisible(false);
							labelFundoLogistica.setVisible(true);
							labelFundoFinanceiro.setVisible(false);
						}
						if (i == 80) {
							labelFundoRH.setVisible(false);
							labelFundoSuprimentos.setVisible(false);
							labelFundoVendas.setVisible(false);
							labelFundoLogistica.setVisible(false);
							labelFundoFinanceiro.setVisible(true);
						}
						if (i == 100) {

							Inicio.this.dispose();
							LoginController.IniciarLogin();

						}
						Thread.sleep(40);

					}

				}
				catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null, "Erro na thread" + e.getMessage());
				}
			}
		}).start();

		Animation animation = createAnimation();
		AnimationListener al;
		al = new AnimationListener() {
			public void animationStopped(AnimationEvent arg0) {
			}

			public void animationStarted(AnimationEvent arg0) {
				synchronized ("A") {
					"A".notify();
				}
			}
		};
		animation.addAnimationListener(al);
		Animator animator = new Animator(animation, 30);
		animator.start();

		synchronized ("A") {
			try {
				"A".wait();
			}
			catch (InterruptedException e) {

			}
		}
	}
}
