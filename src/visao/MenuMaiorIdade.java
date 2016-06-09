package visao;

/**
 * Objetivo: Apresentar um menu que define se a pessoa foi vacinada ou nao.
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;

import dados.ColecaoPessoas;
import dados.Maior_de_idade;
import dados.Pessoa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuMaiorIdade extends JFrame{
	private boolean foiVacinada, statusClick = false;
	private static JFrame frameMaiorIdade;
	private final static JButton buttonSim = new JButton("Sim\n");

	/*Metodo Construtor*/
	public MenuMaiorIdade(ArrayList<Pessoa> conjuntoPessoas) {
		criaMenuMaiorIdade(conjuntoPessoas);
	}
	
	/*Inicializa o frame e seus conteudos*/
	private void criaMenuMaiorIdade(final ArrayList<Pessoa> conjuntoPessoas) {
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
				Maior_de_idade pessoaMaior = new Maior_de_idade(MenuCadastro.getNomePessoa(), MenuCadastro.getSexo(), MenuCadastro.getNumCPF(), MenuCadastro.getDataNascimento(), foiVacinada);
				conjuntoPessoas.add(pessoaMaior);
				frameMaiorIdade.setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				MenuInicio janelaMenuInicio = new MenuInicio(conjuntoPessoas);
			}
		});
		frameMaiorIdade.getContentPane().add(buttonSim);

		JButton buttonNao = new JButton("Nao");
		buttonNao.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*Se o botao for clicado com o mouse no botao NAO*/
				setFoiVacinada(false);
				Maior_de_idade pessoaMaior = new Maior_de_idade(MenuCadastro.getNomePessoa(), MenuCadastro.getSexo(), MenuCadastro.getNumCPF(), MenuCadastro.getDataNascimento(), getFoiVacinada());
				conjuntoPessoas.add(pessoaMaior);
				frameMaiorIdade.setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				new MenuInicio(conjuntoPessoas);
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
	public boolean getStatusClick() {
		return statusClick;
	}

	public void setStatusClick(boolean statusClick) {
		this.statusClick = statusClick;
	}
}