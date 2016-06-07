package visao;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

import servicos.Validacao;

public class MenuConsultar {

	private JFrame frameMenuConsultar;
	private JTextField textFieldCPF;
	private JButton btnConsultar;
	private JButton btnLimpar;
	private JLabel labelErroCPF;

	
	public MenuConsultar() {
		menuConsultar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void menuConsultar() {
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
					
				}
				
			}
		});
		btnConsultar.setBounds(198, 102, 117, 25);
		frameMenuConsultar.getContentPane().add(btnConsultar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldCPF.setText("");
			}
		});
		btnLimpar.setBounds(331, 102, 82, 25);
		frameMenuConsultar.getContentPane().add(btnLimpar);
		
		labelErroCPF = new JLabel("Favor informar um CPF válido e existente.");
		labelErroCPF.setVisible(false);
		labelErroCPF.setIcon(new ImageIcon(MenuConsultar.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		labelErroCPF.setBounds(22, 133, 400, 30);
		frameMenuConsultar.getContentPane().add(labelErroCPF);

	}
}
