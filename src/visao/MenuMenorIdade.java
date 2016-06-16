package visao;

/**
 *	Objetivo: Apresentar um menu que informa a quantidade de vacinas tomadas pela pessoa. 
 *	Entrada: Quantidade de vacinas tomadas.
 */

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dados.PessoaMenorIdade;
import dados.Pessoa;

public class MenuMenorIdade extends JFrame{

	private Integer quantVezes;
	
	/*Metodo Construtor*/
	public MenuMenorIdade(ArrayList<Pessoa> conjuntoPessoas, String nomePessoa,String sexo, String numCPF, String dataNascimento) {
		criaMenuMenorIdade(conjuntoPessoas, nomePessoa, sexo, numCPF, dataNascimento);
	}
	
	/*Inicializa o frame e seus conteudos*/
	private void criaMenuMenorIdade(final ArrayList<Pessoa> conjuntoPessoas,final String nomePessoa, final String sexo, final String numCPF, final String dataNascimento) {
		setTitle("Quantidade de vacinas.");
		setBounds(270, 250, 450, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		
		/*Box com os valores a selecionar*/
		final JComboBox boxValores = new JComboBox();
		boxValores.setMinimumSize(new Dimension(40, 30));
		boxValores.setSize(new Dimension(10, 10));
		boxValores.setModel(new DefaultComboBoxModel(new Integer[] {null,0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
		boxValores.setMaximumRowCount(25);
		boxValores.setBounds(138, 20, 59, 24);
		getContentPane().add(boxValores);
		
		/*Label Erro casa nenhum selecionado*/
		final JLabel labelErroSelect = new JLabel("");
		labelErroSelect.setToolTipText("Campo obrigatorio, favor selecionar um valor.");
		labelErroSelect.setIcon(new ImageIcon(MenuMenorIdade.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		labelErroSelect.setBounds(107, 20, 70, 20);
		getContentPane().add(labelErroSelect);
		labelErroSelect.setVisible(false);
		
		/*Botao 'Ok' para enviar os dados*/
		JButton buttonOk = new JButton("Ok");
		buttonOk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				quantVezes = (Integer) boxValores.getSelectedItem();
				boolean status = false;
				if(quantVezes == null){
					labelErroSelect.setVisible(true);
					status = false;
				}
				else if(quantVezes != null){
					labelErroSelect.setVisible(false);
					status = true;
				}
				if(status == true){
					setQuantVezes(quantVezes);
					PessoaMenorIdade pessoaMenor = new PessoaMenorIdade(nomePessoa, sexo, numCPF, dataNascimento, getQuantVezes());
					conjuntoPessoas.add(pessoaMenor);	
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					new MenuInicio(conjuntoPessoas);
				}
			}
		});
		buttonOk.setBounds(233, 20, 117, 25);
		getContentPane().add(buttonOk);
		
		JLabel labelQuantVezes = new JLabel("Quantas vacinas a pessoa cadastrada já tomou?");
		labelQuantVezes.setBounds(12, 0, 374, 15);
		getContentPane().add(labelQuantVezes);


	}
	/*Getters and setters*/
	public Integer getQuantVezes() {
		return quantVezes;
	}

	public void setQuantVezes(Integer quantVezes) {
		this.quantVezes = quantVezes;
	}
}
