package visao;

/**
 *	Objetivo: Apresentar um menu que informa a quantidade de vacinas tomadas pela pessoa. 
 *	Entrada: Quantidade de vacinas tomadas.
 */

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuMenorIdade {

	private JFrame framQuantVezes;
	private Integer quantVezes;
	
	/*Metodo Construtor*/
	public MenuMenorIdade() {
		menuMenorIdade();
	}
	
	/*Inicializa o frame e seus conteudos*/
	private void menuMenorIdade() {
		framQuantVezes = new JFrame();
		framQuantVezes.setTitle("Quantas vezes a pessoa ja foi vacinada contra H1N1?");
		framQuantVezes.setBounds(270, 250, 450, 100);
		framQuantVezes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framQuantVezes.getContentPane().setLayout(null);
		framQuantVezes.setVisible(true);
		
		/*Box com os valores a selecionar*/
		final JComboBox boxValores = new JComboBox();
		boxValores.setMinimumSize(new Dimension(40, 30));
		boxValores.setSize(new Dimension(10, 10));
		boxValores.setModel(new DefaultComboBoxModel(new Integer[] {null,0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
		boxValores.setMaximumRowCount(25);
		boxValores.setBounds(138, 12, 59, 24);
		framQuantVezes.getContentPane().add(boxValores);
		
		/*Label Erro casa nenhum selecionado*/
		final JLabel labelErroSelect = new JLabel("");
		labelErroSelect.setToolTipText("Campo obrigatorio, favor selecionar um valor.");
		labelErroSelect.setIcon(new ImageIcon(MenuMenorIdade.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		labelErroSelect.setBounds(107, 12, 70, 20);
		framQuantVezes.getContentPane().add(labelErroSelect);
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
				if(status){
					setQuantVezes(quantVezes);
					framQuantVezes.setVisible(false);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		buttonOk.setBounds(233, 12, 117, 25);
		framQuantVezes.getContentPane().add(buttonOk);


	}
	/*Getters and setters*/
	public Integer getQuantVezes() {
		return quantVezes;
	}

	public void setQuantVezes(Integer quantVezes) {
		this.quantVezes = quantVezes;
	}
}
