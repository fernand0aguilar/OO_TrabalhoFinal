package dados;

public class Pessoa {
	private String nome;
	private Character sexo;
	private String dataNascimento;
	private String numCPF;
	
	public Pessoa(String nome, Character sexo,String numCPF, String dataNascimento){
		setNome(nome);
		setSexo(sexo);
		setNumCPF(numCPF);
		setDataNascimento(dataNascimento);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public String getNumCPF() {
		return numCPF;
	}
	public void setNumCPF(String numCPF2) {
		this.numCPF = numCPF2;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
