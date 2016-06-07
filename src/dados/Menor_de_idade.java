package dados;

public class Menor_de_idade extends Pessoa{
	private Integer quantVacinas;
	
	public Menor_de_idade(String nome, Character sexo, String numCPF, String dataNascimento, Integer quantVacinas) {
		super(nome, sexo, numCPF, dataNascimento);
		setQuantVacinas(quantVacinas);
	}
	
	public Integer getQuantVacinas() {
		return quantVacinas;
	}

	public void setQuantVacinas(Integer quantVacinas) {
		this.quantVacinas = quantVacinas;
	}

}
