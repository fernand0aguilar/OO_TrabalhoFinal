package dados;

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
}
