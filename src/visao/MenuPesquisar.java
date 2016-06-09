package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import dados.Pessoa;

public class MenuPesquisar extends JFrame{

	private JFrame frameMenuPesquisar;
	private JTextField textField;
	private JLabel labelNomePesquisar;
	private JTable tabela;

	/**
	 * Create the application.
	 */
	public MenuPesquisar(ArrayList<Pessoa> conjuntoPessoas) {
		criaMenuPesquisar(conjuntoPessoas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void criaMenuPesquisar(ArrayList<Pessoa> conjuntoPessoas) {
		frameMenuPesquisar = new JFrame();
		frameMenuPesquisar.setTitle("Pesquisar uma pessoa pelo Nome");
		frameMenuPesquisar.setBounds(100, 100, 450, 300);
		frameMenuPesquisar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuPesquisar.getContentPane().setLayout(null);
		
		JLabel labelTituloPesquisar = new JLabel("Digite o nome que deseja pesquisar:");
		labelTituloPesquisar.setBounds(10, 0, 400, 50);
		frameMenuPesquisar.getContentPane().add(labelTituloPesquisar);
		
		textField = new JTextField();
		textField.setBounds(80, 50, 200, 30);
		frameMenuPesquisar.getContentPane().add(textField);
		textField.setColumns(10);
		
		labelNomePesquisar = new JLabel("Nome:");
		labelNomePesquisar.setBounds(20, 45, 200, 30);
		frameMenuPesquisar.getContentPane().add(labelNomePesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(293, 52, 117, 25);
		frameMenuPesquisar.getContentPane().add(btnPesquisar);
		
		tabela = new JTable();
		tabela.setBounds(30, 247, 400, -159);
		frameMenuPesquisar.getContentPane().add(tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 92, 392, 158);
		frameMenuPesquisar.getContentPane().add(scrollPane);
	}
}
