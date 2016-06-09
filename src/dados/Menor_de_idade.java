package dados;

import java.util.ArrayList;

public class Menor_de_idade extends Pessoa{
	private Integer quantVacinas;
	
	public Menor_de_idade(String nome, Character sexo, String numCPF, String dataNascimento, Integer quantVacinas) {
		super(nome, sexo, numCPF, dataNascimento);
		setQuantVacinas(quantVacinas);
	}
	
	public Integer getQuantVacinas() {
		return this.quantVacinas;
	}

	public void setQuantVacinas(Integer quantVacinas) {
		this.quantVacinas = quantVacinas;
	}
	public String toString(){
		String sexoCompleto;
		String foiVacinadaAUX;
		
		if(this.getSexo() == 'M')
			sexoCompleto = "Masculino";
		else
			sexoCompleto = "Feminino";
		if(this.getQuantVacinas() == 0)
			foiVacinadaAUX = "Nao";
		else
			foiVacinadaAUX = "Sim";
		
		return this.getNome() + "\t\t" + this.getNumCPF() + "\t\t" + this.getDataNascimento() + "\t\t" 
				+ sexoCompleto + "\t\t" + foiVacinadaAUX +"\t\t"+ this.getQuantVacinas(); 
	}	
}
