package visao;

/**
 * Objetivo: Apresentar um menu que define se a pessoa foi vacinada ou nao.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuMaiorIdade {
	private boolean foiVacinada;
	private static JFrame frameMaiorIdade;
	private final static JButton buttonSim = new JButton("Sim\n");

	/*Metodo Construtor*/
	public MenuMaiorIdade() {
		menuMaiorIdade();
	}
	
	/*Inicializa o frame e seus conteudos*/
	private void menuMaiorIdade() {
		frameMaiorIdade = new JFrame();
		frameMaiorIdade.setTitle("A pessoa registrada foi vacinada contra H1N1 anteriormente?");
		frameMaiorIdade.setBounds(270, 250, 500, 80);
		frameMaiorIdade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMaiorIdade.setVisible(true);
		frameMaiorIdade.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		buttonSim.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*Se o botao for clicado com o mouse no botao SIM*/
				setFoiVacinada(true);
				frameMaiorIdade.setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				new MenuInicio();
			}
		});
		frameMaiorIdade.getContentPane().add(buttonSim);

		JButton buttonNao = new JButton("Nao");
		buttonNao.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*Se o botao for clicado com o mouse no botao NAO*/
				setFoiVacinada(false);
				frameMaiorIdade.setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				new MenuInicio();
			}
		});
		frameMaiorIdade.getContentPane().add(buttonNao);
	}
	/*Getters and Setters*/
	public boolean getFoiVacinada() {
		return foiVacinada;
	}

	public void setFoiVacinada(boolean foiVacinada) {
		this.foiVacinada = foiVacinada;
	}
}