package visao;

/**
 * Objetivo: Apresentar um menu que define se a pessoa foi vacinada ou nao.
 */
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

import dados.ColecaoPessoas;
import dados.PessoaMaiorIdade;
import dados.Pessoa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuMaiorIdade extends JDialog{
	
	private boolean foiVacinada, statusClick = false;
	private final static JButton buttonSim = new JButton("Sim\n");

	/*Metodo Construtor*/
	public MenuMaiorIdade(ArrayList<Pessoa> conjuntoPessoas, String nomePessoa, String sexo, String numCPF, String dataNascimento) {
		criaMenuMaiorIdade(conjuntoPessoas, nomePessoa, sexo, numCPF, dataNascimento);
	}
	
	/*Inicializa o frame e seus conteudos*/
	private void criaMenuMaiorIdade(final ArrayList<Pessoa> conjuntoPessoas, final String nomePessoa, final String sexo, final String numCPF, final String dataNascimento) {
		setBounds(270, 250, 500, 80);
		getContentPane().setBackground(new Color(242,250,251));
		setTitle("A pessoa registrada foi vacinada contra H1N1 anteriormente?");
		setVisible(true);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		buttonSim.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*Se o botao for clicado com o mouse no botao SIM*/
				setFoiVacinada(true);
				PessoaMaiorIdade pessoaMaior = new PessoaMaiorIdade(nomePessoa, sexo, numCPF, dataNascimento, foiVacinada);
				conjuntoPessoas.add(pessoaMaior);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				MenuInicio janelaMenuInicio = new MenuInicio(conjuntoPessoas);
			}
		});
		getContentPane().add(buttonSim);

		JButton buttonNao = new JButton("Nao");
		buttonNao.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				/*Se o botao for clicado com o mouse no botao NAO*/
				setFoiVacinada(false);
				PessoaMaiorIdade pessoaMaior = new PessoaMaiorIdade(nomePessoa, sexo, numCPF, dataNascimento, getFoiVacinada());
				conjuntoPessoas.add(pessoaMaior);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				new MenuInicio(conjuntoPessoas);
			}
		});
		getContentPane().add(buttonNao);
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