package principal;

import java.awt.*;

import dados.ColecaoPessoas;

import visao.*;;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColecaoPessoas conjuntoPessoas = new ColecaoPessoas();
					MenuInicio window = new MenuInicio(conjuntoPessoas.getPessoas());
					window.getFrame().setVisible(true);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
	}
}
