package visao;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import dados.ColecaoPessoas;
import dados.Pessoa;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import servicos.Validacao;

public class MenuConsultar extends JFrame{

	private JFrame frameMenuConsultar;
	private JTextField textFieldCPF;
	private JButton btnConsultar;
	private JButton btnSair;
	private JLabel labelErroCPF;

	
	public MenuConsultar(ArrayList<Pessoa> conjuntoPessoas) {
		criaMenuConsultar(conjuntoPessoas);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void criaMenuConsultar(final ArrayList<Pessoa> conjuntoPessoas) {
		frameMenuConsultar = new JFrame();
		frameMenuConsultar.setFont(new Font("Century Schoolbook L", Font.PLAIN, 12));
		frameMenuConsultar.setTitle("Consultar uma pessoa via CPF");
		frameMenuConsultar.setBounds(100, 100, 450, 200);
		frameMenuConsultar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuConsultar.getContentPane().setLayout(null);
		frameMenuConsultar.setVisible(true);
		
		JLabel titleTitulocpf = DefaultComponentFactory.getInstance().createTitle("Preencha o campo abaixo com o dado solicitado.");
		titleTitulocpf.setBounds(12, 0, 398, 50);
		frameMenuConsultar.getContentPane().add(titleTitulocpf);
		
		JLabel labelCPF = DefaultComponentFactory.getInstance().createLabel("CPF: ");
		labelCPF.setBounds(12, 80, 130, 15);
		frameMenuConsultar.getContentPane().add(labelCPF);
		textFieldCPF = new JTextField();
		textFieldCPF.setText("###.###.###-##");
		textFieldCPF.setBounds(12, 100, 150, 30);
		frameMenuConsultar.getContentPane().add(textFieldCPF);
		textFieldCPF.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				textFieldCPF.setText("");
			}
		});
		textFieldCPF.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean status = false;
				String numCPF = textFieldCPF.getText().trim();
				if(Validacao.validaCPF(numCPF) == false){
					status = false;
					labelErroCPF.setVisible(true);
				}
				else if(Validacao.validaCPF(numCPF)){
					labelErroCPF.setVisible(false);
					status = true;
				}
				if(status == true){
					boolean statusPesquisa = false;
					for(int aux = 0; aux<conjuntoPessoas.size(); aux++){
						Pessoa pessoa = conjuntoPessoas.get(aux);
						if(pessoa.getNumCPF().equals(numCPF)){
							statusPesquisa = true;
							String mensagem = "Nome: " + pessoa.getNome() + "\nData de Nacimento: " + pessoa.getDataNascimento() + "\nCPF:" + pessoa.getNumCPF() + "\nSexo: " + pessoa.getSexo();
							JOptionPane.showMessageDialog(null, mensagem, pessoa.getNome(),JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
					if(statusPesquisa == false){
						JOptionPane.showMessageDialog(null, "Nenhum registro existente com este CPF");
					}
				}
				
			}
		});
		btnConsultar.setBounds(198, 102, 117, 25);
		frameMenuConsultar.getContentPane().add(btnConsultar);
		
		btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frameMenuConsultar.setVisible(false);
				MenuInicio janelaMenuInicial = new MenuInicio(conjuntoPessoas);
			}
		});
		btnSair.setBounds(331, 102, 82, 25);
		frameMenuConsultar.getContentPane().add(btnSair);
		
		labelErroCPF = new JLabel("Favor informar um CPF válido e existente.");
		labelErroCPF.setVisible(false);
		labelErroCPF.setIcon(new ImageIcon(MenuConsultar.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		labelErroCPF.setBounds(22, 133, 400, 30);
		frameMenuConsultar.getContentPane().add(labelErroCPF);

	}
}
