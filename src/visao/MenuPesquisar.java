package visao;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.*;
import dados.*;

import java.util.*;

public class MenuPesquisar extends JDialog {

	private JPanel painelTabela;
	private JPanel painelPesquisa;
	private JTable tabela;
	private JTextField textFieldNomePesquisar;
	private JLabel labelNomePesquisar;
	
	public MenuPesquisar(ArrayList<Pessoa>conjuntoPessoas, String pesquisa) {
		setTitle("Resultados");
		criaPainelTabela(conjuntoPessoas,pesquisa);
	}
	
	public void criaPainelTabela(final ArrayList<Pessoa>conjuntoPessoas,String pesquisa){
		int total=0;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 320);
		getContentPane().setLayout(new BorderLayout(0, 0));
		painelTabela = new JPanel();
		painelTabela.setBackground(UIManager.getColor("Checkbox.select"));
		painelTabela.setBorder(UIManager.getBorder("Table.scrollPaneBorder"));
		setContentPane(painelTabela);
		painelTabela.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 24, 524, 150);
		painelTabela.add(scrollPane);

		tabela = new JTable();

		tabela.setColumnSelectionAllowed(false);
		tabela.setCellSelectionEnabled(false);
		scrollPane.setViewportView(tabela);

		JLabel lblQtdeMostrados = new JLabel("Quantidade de amostras:");
		lblQtdeMostrados.setAlignmentY(30.0f);
		lblQtdeMostrados.setAlignmentX(100.0f);
		lblQtdeMostrados.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblQtdeMostrados.setBounds(23, 195, 220, 14);
		painelTabela.add(lblQtdeMostrados);

		JLabel lblValorMostrados = new JLabel("0");
		lblValorMostrados.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblValorMostrados.setBounds(240, 195, 37, 14);
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
		
		JButton btnPesquisarNovamente = new JButton("Nova pesquisa");
		btnPesquisarNovamente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				MenuFormularioPesquisar newSearch = new MenuFormularioPesquisar(conjuntoPessoas);
				setVisible(false);
			}
		});
		btnPesquisarNovamente.setBounds(30, 220, 150, 50);
		painelTabela.add(btnPesquisarNovamente);
		
		JButton btnSair = new JButton("Cancelar");
		btnSair.setBounds(330, 220, 150, 50);
		painelTabela.add(btnSair);
	}

	public boolean isCellEditable(int row, int col){
		return false;
	}
}



