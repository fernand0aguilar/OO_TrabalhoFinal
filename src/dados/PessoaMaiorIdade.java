package dados;

import java.util.ArrayList;

public class PessoaMaiorIdade extends Pessoa{
	private boolean vacinada;

	public boolean isVacinada() {
		return vacinada;
	}

	public void setFoiVacinada(boolean foiVacinada) {
		this.vacinada = foiVacinada;
	}

	public PessoaMaiorIdade(String nome, String sexo, String numCPF, String dataNascimento, boolean foiVacinada) {
		super(nome, sexo, numCPF, dataNascimento);
		setFoiVacinada(foiVacinada);
	}
	
	public String toString(){
		String foiVacinadaAUX;
		String sexoCompleto;
		
		if(this.isVacinada() == false)
			foiVacinadaAUX = "Não";
		else 
			foiVacinadaAUX = "Sim";
		
		return this.getNome() + "\t" + this.getNumCPF() + "\t\t" + this.getDataNascimento() + "\t\t" 
		+ this.getSexo() + "\t\t" + foiVacinadaAUX +"\t\t"+ "---"; 
	}
}
