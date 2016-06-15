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
import com.jgoodies.forms.factories.DefaultComponentFactory;

import dados.ColecaoPessoas;
import dados.Pessoa;

public class MenuInicio extends JFrame{

	private MenuPesquisar janelaMenuPesquisar;
	/*Metodo construtor MenuInicio()*/
	
	public MenuInicio(ArrayList<Pessoa> conjuntoPessoas) {
		super("Registro de vacinacao H1N1");
		criaMenuInicio(conjuntoPessoas);
	}

	/*Inicializa o frame e seus conteudos*/
	private void criaMenuInicio(final ArrayList<Pessoa> conjuntoPessoas) {

		
		setBounds(270, 250, 210, 326);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro de vacinacao H1N1");
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
		buttonCadastro.setBounds(30, 50, 126, 32);
		getContentPane().add(buttonCadastro);
		
		/*Botao Listagem todos os cadastros*/
		JButton buttonListagem = new JButton("Listar");
		buttonListagem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Visao.mostraDados(conjuntoPessoas);
			}
		});
		buttonListagem.setBounds(30, 94, 126, 32);
		getContentPane().add(buttonListagem);
		
		/*Botao Consultar via CPF*/
		JButton buttonConsultar = new JButton("Consultar");
		buttonConsultar.setBounds(30, 138, 126, 32);
		buttonConsultar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MenuConsultar janelaMenuConsultar = new MenuConsultar(conjuntoPessoas);
			}
		});
		getContentPane().add(buttonConsultar);
		
		/*Botao Pesquisar via nome*/
		JButton buttonPesquisar = new JButton("Pesquisar");
		buttonPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				frameMenuInicio.setVisible(false);
				janelaMenuPesquisar = new MenuPesquisar(conjuntoPessoas);
				janelaMenuPesquisar.setVisible(true);
			}
		});
		buttonPesquisar.setBounds(30, 187, 126, 32);
		getContentPane().add(buttonPesquisar);
		
		/*Botao Sair da aplicacao*/
		JButton buttonSair = new JButton("Sair");
		buttonSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		buttonSair.setBounds(30, 231, 126, 32);
		getContentPane().add(buttonSair);
		
		/*Label Titulo*/
		JLabel labelOpcao = DefaultComponentFactory.getInstance().createTitle("Escolha uma opção: ");
		labelOpcao.setBounds(12, 0, 300, 15);
		getContentPane().add(labelOpcao);
	}
	
}
