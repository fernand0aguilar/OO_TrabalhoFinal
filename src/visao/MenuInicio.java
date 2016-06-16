package visao;

/**
 * Menu inicial, controla toda a aplicacao
 * Objetivo: Escolha das opcoes.
 */

import javax.swing.*;

import java.awt.Menu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

import dados.Pessoa;
import java.awt.Color;

public class MenuInicio extends JFrame{

	/*Metodo construtor MenuInicio()*/	
	public MenuInicio(ArrayList<Pessoa> conjuntoPessoas) {
		super("Registro de vacinacao H1N1");
		criaMenuInicio(conjuntoPessoas);
	}

	/*Inicializa o frame e seus conteudos*/
	private void criaMenuInicio(final ArrayList<Pessoa> conjuntoPessoas) {


		setBounds(270, 250, 800, 330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro de vacinacao H1N1");
		getContentPane().setBackground(new Color(242,250,251));
		getContentPane().setLayout(null);
		setVisible(true);

		/*Botao Cadastrar*/
		JButton buttonCadastro = new JButton("Cadastrar");
		buttonCadastro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new MenuCadastro(conjuntoPessoas);
			}
		});
		buttonCadastro.setBounds(30, 50, 120, 30);
		getContentPane().add(buttonCadastro);

		/*Botao Listagem todos os cadastros*/
		JButton buttonListagem = new JButton("Listar");
		buttonListagem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Visao.mostraDados(conjuntoPessoas);
			}
		});
		buttonListagem.setBounds(180, 50, 120, 30);
		getContentPane().add(buttonListagem);

		/*Botao Consultar via CPF*/
		JButton buttonConsultar = new JButton("Consultar");
		buttonConsultar.setBounds(330, 50, 120, 30);
		buttonConsultar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(conjuntoPessoas.size() == 0){
					JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				else{
					setVisible(false);
					MenuConsultar janelaMenuConsultar = new MenuConsultar(conjuntoPessoas);
				}
			}
		});
		getContentPane().add(buttonConsultar);

		/*Botao Pesquisar via nome*/
		JButton buttonPesquisar = new JButton("Pesquisar");
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(conjuntoPessoas.size() == 0){
					JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				else{
					MenuFormularioPesquisar janelaMenuPesquisar = new MenuFormularioPesquisar(conjuntoPessoas);
					janelaMenuPesquisar.setVisible(true);
				}
			}
		});
		buttonPesquisar.setBounds(480, 50, 120, 30);
		getContentPane().add(buttonPesquisar);

		/*Botao Sair da aplicacao*/
		JButton buttonSair = new JButton("Sair");
		buttonSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		buttonSair.setBounds(630, 50, 120, 30);
		getContentPane().add(buttonSair);

		/*Label Titulo*/
		JLabel labelOpcao = new JLabel("Escolha uma opção: ");
		labelOpcao.setBounds(12, 0, 300, 15);
		getContentPane().add(labelOpcao);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 128, 128));
		lblNewLabel.setIcon(new ImageIcon("/home/Aguilar/UNB/OO/TrabalhoFinal_TF1 (2)/imagens/h1n1_2.jpg"));
		lblNewLabel.setBounds(60, 108, 675, 137);
		getContentPane().add(lblNewLabel);
	}
}
