package visao;

/**
 * Objetivo: Cadastrar uma nova pessoa
 * Entradas: Nome, CPF, Data Nascimento, Sexo, Quantidade de vacinas tomadas. 
 */

import javax.swing.*;

import servicos.Validacao;


import dados.Pessoa;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


import java.text.*;
import java.util.ArrayList;

public class MenuCadastro extends JDialog{

	private static JTextField textField_Nome;
	private static JTextField textField_CPF;
	private static JTextField textField_Data;

	/*VARIAVEIS SALVAR*/
	private String nomePessoa;
	private String numCPF;
	private String dataNascimento;
	private String sexo;

	/*Metodo Construtor da classe*/
	public MenuCadastro(ArrayList<Pessoa> conjuntoPessoas){
		criaMenuCadastro(conjuntoPessoas);
	}

	/*Inicializacao dos conteudos da frame*/

	public void criaMenuCadastro(final ArrayList<Pessoa> conjuntoPessoas){
		/*set da janela de cadastro*/
		setBounds(300, 200, 600, 300);
		getContentPane().setBackground(new Color(242,250,251));
		getContentPane().setLayout(null);
		setTitle("Cadastro de um novo registro de vacinação");
		/*Label inicial*/
		JLabel tituloCadastroPessoa = new JLabel("Preencha os campos abaixo com os dados solicitados.");
		tituloCadastroPessoa.setBounds(15, 0, 400, 30);
		getContentPane().add(tituloCadastroPessoa);

		/*Set dos fields para realizar cadastro*/
		/*Field nome*/
		JLabel labelNome = new JLabel("NOME: ");
		labelNome.setVerticalAlignment(SwingConstants.TOP);
		labelNome.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNome.setToolTipText("Nome da pessoa a ser cadastrada");
		labelNome.setBounds(15, 30, 50, 15);
		getContentPane().add(labelNome);
		textField_Nome = new JTextField();
		labelNome.setLabelFor(textField_Nome);
		textField_Nome.setBounds(15, 50, 300, 30);
		getContentPane().add(textField_Nome);
		textField_Nome.setColumns(10);

		/*Field CPF*/
		JLabel labelCPF = new JLabel("CPF: ");
		labelCPF.setBounds(15, 90, 130, 15);
		getContentPane().add(labelCPF);
		textField_CPF = new JTextField();
		textField_CPF.setText("###########");
		textField_CPF.setBounds(15, 110, 150, 30);
		getContentPane().add(textField_CPF);
		textField_CPF.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				textField_CPF.setText("");
			}
		});
		textField_CPF.setColumns(10);

		/*Field data nascimento*/
		JLabel labelData = new JLabel("DATA DE NASCIMENTO: ");
		labelData.setBounds(15, 150, 170, 15);
		getContentPane().add(labelData);
		
		textField_Data = new JTextField();
		
		textField_Data.setText("DD/MM/AAAA");
		textField_Data.setColumns(10);
		textField_Data.setBounds(15, 170, 150, 30);
		textField_Data.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				textField_Data.setText("");
			}
		});
		getContentPane().add(textField_Data);

		/*Field sexo*/
		JLabel labelSexo = new JLabel("SEXO:");
		labelSexo.setBounds(15, 210, 130, 15);
		getContentPane().add(labelSexo);
		/*botoes de sexo*/
		ButtonGroup grupo = new ButtonGroup();
		final JRadioButton buttonFeminino = new JRadioButton("Feminino");
		buttonFeminino.setBounds(15, 230, 149, 23);
		getContentPane().add(buttonFeminino);

		final JRadioButton buttonMasculino = new JRadioButton("Masculino");
		buttonMasculino.setBounds(195, 230, 149, 23);
		getContentPane().add(buttonMasculino);
		setVisible(true);

		grupo.add(buttonFeminino);
		grupo.add(buttonMasculino);

		/*labels de erros com icones*/
		final JLabel erroNome = new JLabel("Campo Obrigatório!");
		erroNome.setToolTipText("Campo de nome vazio");
		erroNome.setIcon(new ImageIcon(MenuCadastro.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		erroNome.setBounds(333, 50, 239, 30);
		erroNome.setVisible(false);
		getContentPane().add(erroNome);

		final JLabel erroCPF = new JLabel("CPF invalido, digite um numero valido");
		erroCPF.setIcon(new ImageIcon(MenuCadastro.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		erroCPF.setBounds(187, 110, 300, 50);
		erroCPF.setVisible(false);
		getContentPane().add(erroCPF);

		final JLabel erroDATA = new JLabel("Data invalida, digite novamente");
		erroDATA.setIcon(new ImageIcon(MenuCadastro.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		erroDATA.setBounds(197, 159, 300, 50);
		erroDATA.setVisible(false);
		getContentPane().add(erroDATA);

		final JLabel erroSEXO = new JLabel("Campo obrigatorio");
		erroSEXO.setIcon(new ImageIcon(MenuCadastro.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
		erroSEXO.setBounds(75, 210, 250, 20);
		erroSEXO.setVisible(false);
		getContentPane().add(erroSEXO);

		/*Botao de Enviar para dar save no cadastro*/
		JButton buttonOk = new JButton("Enviar");
		buttonOk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean statusNome = false,statusCPF = false,statusData = false, statusSexo = false;
				/*Obtendo os valores*/
				nomePessoa = textField_Nome.getText().trim();
				numCPF = textField_CPF.getText().trim();
				dataNascimento = textField_Data.getText().trim();
				if(buttonFeminino.isSelected())
					sexo = "Feminino";
				if(buttonMasculino.isSelected())
					sexo = "Masculino";

				/*VALIDA NOME*/
				if(Validacao.validaNome(nomePessoa) == false){
					statusNome = false;
					erroNome.setVisible(true);
				}
				else if(Validacao.validaNome(nomePessoa)){
					erroNome.setVisible(false);
					statusNome = true;
				}
				/*VALIDA CPF*/
				if(!Validacao.validaCPF(numCPF) || !Validacao.checkDuplicidadeCPF(conjuntoPessoas, numCPF)){
					statusCPF = false;
					erroCPF.setVisible(true);
				}
				else if(Validacao.validaCPF(numCPF) && Validacao.checkDuplicidadeCPF(conjuntoPessoas, numCPF)){
					erroCPF.setVisible(false);
					statusCPF = true;
				}
				/*VALIDA DATA*/
				if(Validacao.validaData(dataNascimento) == false){
					statusData = false;
					erroDATA.setVisible(true);
				}
				else if(Validacao.validaData(dataNascimento)){
					statusData = true;
					erroDATA.setVisible(false);
				}
				/*VALIDA SEXO*/
				if(!buttonFeminino.isSelected() &&  !buttonMasculino.isSelected()){
					statusSexo = false;
					erroSEXO.setVisible(true);
				}
				else if(buttonFeminino.isSelected() || buttonMasculino.isSelected()){
					statusSexo = true;
					erroSEXO.setVisible(false);
				}

				/*Menu maior ou menor de idade*/
				if(statusNome == true && statusCPF == true && statusData == true && statusSexo == true){
					Integer ano = Visao.getAnoStringData(dataNascimento);
					
					if(2016-ano >= 18){
						/*Se for maior de idade*/
						setVisible(false);
						MenuMaiorIdade JanelaMenuMaiorIdade = new MenuMaiorIdade(conjuntoPessoas, nomePessoa, sexo, numCPF, dataNascimento);						
					}
					else if(2016-ano <= 18){
						/*Se for menor de idade*/
						setVisible(false);
						MenuMenorIdade JanelaMenuMenorIdade  = new MenuMenorIdade(conjuntoPessoas, nomePessoa, sexo, numCPF, dataNascimento);
					}
				}
			}
		});
		buttonOk.setBounds(350, 200, 120, 25);
		getContentPane().add(buttonOk);

		JButton btnSair = new JButton("Cancelar");
		btnSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MenuInicio janelaMenuInicial = new MenuInicio(conjuntoPessoas);
			}
		});
		btnSair.setBounds(480, 200, 100, 25);
		getContentPane().add(btnSair);

	}
}
