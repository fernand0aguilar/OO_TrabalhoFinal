package visao;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.List;

import javax.swing.table.*;
import dados.*;

import java.util.*;

public class MenuPesquisar extends JDialog {

	private JPanel painelTabela;
	private JTable tabela;

	
	public MenuPesquisar(ArrayList<Pessoa>variasPessoas,String pesquisa) {
		setTitle("Resultados");
		setModal(true);
		criaTabela(variasPessoas,pesquisa);
	}

	public void criaTabela(final ArrayList<Pessoa>conjuntoPessoas,String pesquisa){
		int total=0;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		painelTabela = new JPanel();
		painelTabela.setBackground(Color.BLUE);
		painelTabela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelTabela);
		painelTabela.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 30, 385, 145);
		painelTabela.add(scrollPane);

		tabela = new JTable();

		tabela.setColumnSelectionAllowed(false);
		tabela.setCellSelectionEnabled(false);
		scrollPane.setViewportView(tabela);

		JLabel lblQtdeMostrados = new JLabel("Quantidade de amostras:");
		lblQtdeMostrados.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblQtdeMostrados.setBounds(23, 195, 161, 14);
		painelTabela.add(lblQtdeMostrados);

		JLabel lblValorMostrados = new JLabel("0");
		lblValorMostrados.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblValorMostrados.setBounds(194, 195, 37, 14);
		painelTabela.add(lblValorMostrados);

		DefaultTableModel tabelaMdl = new DefaultTableModel(){
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		tabelaMdl.addColumn("Nome");
		tabelaMdl.addColumn("Data de Nascimento");
		tabelaMdl.addColumn("CPF");
		tabelaMdl.addColumn("Sexo");
		tabelaMdl.addColumn("É vacinada");
		tabelaMdl.addColumn("Quant.Vacinas");

		List<Pessoa> listaNova = new ArrayList<Pessoa>();

		for(int cont=0; cont<conjuntoPessoas.size(); cont++){
			listaNova.add(conjuntoPessoas.get(cont));
		}
		
		Collections.sort(listaNova);
		
		total = Visao.adicionaObjetosTabelaPesquisados(conjuntoPessoas, listaNova, pesquisa, tabelaMdl, total);
		

		lblValorMostrados.setText(String.valueOf(total));
		tabela.setModel(tabelaMdl);

	}

	public boolean isCellEditable(int row, int col){
		return false;
	}
}


