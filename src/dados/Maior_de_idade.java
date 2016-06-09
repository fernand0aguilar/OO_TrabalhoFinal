package dados;

import java.util.ArrayList;

public class Maior_de_idade extends Pessoa{
	private boolean vacinada;

	public boolean isVacinada() {
		return vacinada;
	}

	public void setFoiVacinada(boolean foiVacinada) {
		this.vacinada = foiVacinada;
	}

	public Maior_de_idade(String nome, Character sexo, String numCPF, String dataNascimento, boolean foiVacinada) {
		super(nome, sexo, numCPF, dataNascimento);
		setFoiVacinada(foiVacinada);
	}
	
	public String toString(){
		String foiVacinadaAUX;
		String sexoCompleto;
		
		if(this.getSexo() == 'M')
			sexoCompleto = "Masculino";
		else
			sexoCompleto = "Feminino";
		if(this.isVacinada() == false)
			foiVacinadaAUX = "Não";
		else 
			foiVacinadaAUX = "Sim";
		
		return this.getNome() + "\t" + this.getNumCPF() + "\t\t" + this.getDataNascimento() + "\t\t" 
		+ sexoCompleto + "\t\t" + foiVacinadaAUX +"\t\t"+ "---"; 
	}
}
