package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import dados.Pessoa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuBoasVindas extends JFrame{


	public MenuBoasVindas(ArrayList<Pessoa> conjuntoPessoas) {
		super("Registro de vacinação gripe H1N1");
		criarMenuBoasVindas(conjuntoPessoas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void criarMenuBoasVindas(final ArrayList<Pessoa> conjuntoPessoas) {
		
		setBounds(100, 100, 640, 427);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
//		JLabel lblNewLabel = new JLabel();
////		lblNewLabel.setText("<html>Cadastro de vacinação contra a gripe A (H1N1)<br/><br/><br/>\n\n <font size=\"4\">Para proseguir pro menu Inicial</font><br/><br/><br/>\n\n<font size= \"5\" color=\"red\"align =center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLIQUE AQUI</font></html>");
////		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 10));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(280, 122, 242, 172);
//		getContentPane().add(lblNewLabel);
		
		JButton buttonMenuPrincipal = new JButton("<html>Cadastro de vacinação contra a gripe A (H1N1)<br/><br/><br/>\n\n <font size=\"4\">Para proseguir pro menu Inicial,</font><br/><br/><br/>\n\n<font size= \"5\" color=\"red\"align =center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CLIQUE AQUI</font></html>");
		buttonMenuPrincipal.setVerticalAlignment(SwingConstants.TOP);
		buttonMenuPrincipal.setFont(new Font("Serif", Font.PLAIN, 12));
		buttonMenuPrincipal.setForeground(new Color(0, 0, 0));
		buttonMenuPrincipal.setBackground(new Color(255, 255, 0));
		buttonMenuPrincipal.setBounds(284, 122, 238, 172);
		getContentPane().add(buttonMenuPrincipal);
		setVisible(true);
		
		buttonMenuPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MenuInicio janelaMenuInicial = new MenuInicio(conjuntoPessoas);
			}
		});
		
		JLabel imageH1N1 = new JLabel("");
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/gripeImg1.jpg"));
		imageH1N1.setIcon(icon);
		imageH1N1.setBounds(0, 0, 640, 427);
		getContentPane().add(imageH1N1);
	}
}
