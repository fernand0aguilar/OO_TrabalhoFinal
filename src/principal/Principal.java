package principal;

import java.awt.*;

import visao.*;;

public class Principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicio window = new MenuInicio();
					window.getFrame().setVisible(true);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
	}
}
