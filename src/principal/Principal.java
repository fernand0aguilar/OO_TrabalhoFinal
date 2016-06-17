package principal;

import java.awt.*;

import dados.ColecaoPessoas;

import visao.*;;

/*
 *Síntese:
 *	Objetivo: Fazer o cadastramento e controle de vacinações contra H1N1
 * 	Entradas: Nome, Data de Nascimento, Numero de CPF, Sexo, Quantidade de vacinas tomadas ou se já foi vacinada.
 * 	Saidas:	Nome, Data de Nascimento, Numero de CPF, Sexo, quantidade de vacinas ou se já foi vacinada
 */

public class Principal {

	public static void main(String[] args) {
		/*Coloca requisicao na thread do swing*/
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColecaoPessoas conjuntoPessoas = new ColecaoPessoas();
					MenuBoasVindas novaJanelaBoasVindas = new MenuBoasVindas(conjuntoPessoas.getPessoas());
				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
	}
}
