package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.*;

import javax.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import dados.Pessoa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuFormularioPesquisar extends JFrame{

	private JTextField textFieldNomePesquisar;
	private JLabel labelNomePesquisar;
	private String nomePesquisar;
	
	public MenuFormularioPesquisar(ArrayList<Pessoa> conjuntoPessoas) {
		super("Pesquisar");
		criaMenuPesquisar(conjuntoPessoas);
	}

	private void criaMenuPesquisar(final ArrayList<Pessoa> conjuntoPessoas) {		
		setBounds(100, 100, 442, 127);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(242,250,251));
		getContentPane().setLayout(null);
		
		JLabel labelTituloPesquisar = new JLabel("Digite o nome que deseja pesquisar:");
		labelTituloPesquisar.setBounds(10, 0, 400, 50);
		getContentPane().add(labelTituloPesquisar);
		
		textFieldNomePesquisar = new JTextField();
		textFieldNomePesquisar.setBounds(80, 50, 200, 30);
		getContentPane().add(textFieldNomePesquisar);
		textFieldNomePesquisar.setColumns(10);
		
		labelNomePesquisar = new JLabel("Nome:");
		labelNomePesquisar.setBounds(20, 45, 200, 30);
		getContentPane().add(labelNomePesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(textFieldNomePesquisar.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Digite um nome para pesquisar.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				else{
					MenuPesquisar tabela = new MenuPesquisar(conjuntoPessoas, textFieldNomePesquisar.getText().trim());
					tabela.setVisible(true);
					setVisible(false);
				}
					
			}
		});
		btnPesquisar.setBounds(293, 52, 117, 25);
		getContentPane().add(btnPesquisar);
		
	}
}
