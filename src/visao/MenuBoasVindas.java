package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import dados.Pessoa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuBoasVindas {

	private JFrame frameMenuBoasVindas;

	public MenuBoasVindas(ArrayList<Pessoa> conjuntoPessoas) {
		criarMenuBoasVindas(conjuntoPessoas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void criarMenuBoasVindas(final ArrayList<Pessoa> conjuntoPessoas) {
		frameMenuBoasVindas = new JFrame();
		frameMenuBoasVindas.setTitle("Registro de vacinação gripe H1N1");
		frameMenuBoasVindas.setBounds(100, 100, 640, 427);
		frameMenuBoasVindas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuBoasVindas.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>Cadastro de vacinação contra a gripe A (H1N1)<br/><br/><br/>\n\n <font size=\"4\">Para proseguir pro menu Inicial</font><br/><br/><br/>\n\n<font size= \"5\" color=\"red\"align =center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLIQUE AQUI</font></html>");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 10));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 122, 242, 172);
		frameMenuBoasVindas.getContentPane().add(lblNewLabel);
		
		JButton buttonMenuPrincipal = new JButton("");
		buttonMenuPrincipal.setVerticalAlignment(SwingConstants.TOP);
		buttonMenuPrincipal.setFont(new Font("Serif", Font.PLAIN, 12));
		buttonMenuPrincipal.setForeground(new Color(0, 0, 0));
		buttonMenuPrincipal.setBackground(new Color(255, 255, 0));
		buttonMenuPrincipal.setBounds(280, 122, 242, 172);
		frameMenuBoasVindas.getContentPane().add(buttonMenuPrincipal);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frameMenuBoasVindas.setVisible(false);
				MenuInicio janelaMenuInicial = new MenuInicio(conjuntoPessoas);
			}
		});
		
		JLabel imageH1N1 = new JLabel("");
		imageH1N1.setIcon(new ImageIcon("/home/Aguilar/UNB/OO/TrabalhoFinal_TF1/Imagens/gripe-H1N1.jpg"));
		imageH1N1.setBounds(0, 0, 640, 427);
		frameMenuBoasVindas.getContentPane().add(imageH1N1);
	}

	public JFrame getFrameMenuBoasVindas() {
		return frameMenuBoasVindas;
	}

	public void setFrameMenuBoasVindas(JFrame frameMenuBoasVindas) {
		this.frameMenuBoasVindas = frameMenuBoasVindas;
	}

}
