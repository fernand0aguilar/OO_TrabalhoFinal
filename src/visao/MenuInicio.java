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

	private JFrame frameMenuInicio;
	
	/*Metodo construtor MenuInicio()*/
	public MenuInicio(ArrayList<Pessoa> conjuntoPessoas) {
		criaMenuInicio(conjuntoPessoas);
	}

	/*Inicializa o frame e seus conteudos*/
	private void criaMenuInicio(final ArrayList<Pessoa> conjuntoPessoas) {

		frameMenuInicio = new JFrame();
		frameMenuInicio.setBounds(270, 250, 810, 150);
		frameMenuInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuInicio.setTitle("Registro de vacinacao H1N1");
		frameMenuInicio.getContentPane().setLayout(null);
		frameMenuInicio.setVisible(true);
		
		/*Botao Cadastrar*/
		JButton buttonCadastro = new JButton("Cadastrar");
		buttonCadastro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameMenuInicio.setVisible(false);
				new MenuCadastro(conjuntoPessoas);
			}
		});
		buttonCadastro.setBounds(30, 50, 126, 32);
		frameMenuInicio.getContentPane().add(buttonCadastro);
		
		/*Botao Listagem todos os cadastros*/
		JButton buttonListagem = new JButton("Listar");
		buttonListagem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Visao.mostraDados(conjuntoPessoas);
			}
		});
		buttonListagem.setBounds(186, 50, 126, 32);
		frameMenuInicio.getContentPane().add(buttonListagem);
		
		/*Botao Consultar via CPF*/
		JButton buttonConsultar = new JButton("Consultar");
		buttonConsultar.setBounds(342, 50, 126, 32);
		buttonConsultar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameMenuInicio.setVisible(false);
				MenuConsultar janelaMenuConsultar = new MenuConsultar();
			}
		});
		frameMenuInicio.getContentPane().add(buttonConsultar);
		
		/*Botao Pesquisar via nome*/
		JButton buttonPesquisar = new JButton("Pesquisar");
		buttonPesquisar.setBounds(498, 50, 126, 32);
		frameMenuInicio.getContentPane().add(buttonPesquisar);
		
		/*Botao Sair da aplicacao*/
		JButton buttonSair = new JButton("Sair");
		buttonSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		buttonSair.setBounds(654, 50, 126, 32);
		frameMenuInicio.getContentPane().add(buttonSair);
		
		/*Label Titulo*/
		JLabel labelOpcao = DefaultComponentFactory.getInstance().createTitle("Escolha uma opção: ");
		labelOpcao.setBounds(12, 0, 300, 15);
		frameMenuInicio.getContentPane().add(labelOpcao);
	}
	
	public JFrame getFrame() {
		return this.frameMenuInicio;
	}

	public void setFrame(JFrame frame) {
		this.frameMenuInicio = frame;
	}
}
