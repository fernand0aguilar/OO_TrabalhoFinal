package dados;

import interface_programa.ChavePessoa;

import java.util.ArrayList;

public abstract class Pessoa implements ChavePessoa, Comparable<Pessoa>{
	private String nome;
	private String sexo;
	private String dataNascimento;
	private String numCPF;
	
	public Pessoa(String nome, String sexo,String numCPF, String dataNascimento){
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNumCPF() {
		return numCPF;
	}
	public void setNumCPF(String numCPF) {
		this.numCPF = numCPF;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean checkDuplicidadeCPF(ArrayList<Pessoa> totalPessoas, String numCPF) {
		boolean statusValida = true;
		
		for(int cont=0; cont<totalPessoas.size();cont++){
			if(totalPessoas.get(cont).getNumCPF().equals(numCPF)){
				statusValida=false;
				cont=0;
			}
		}
		return statusValida;
	}
	public int compareTo(Pessoa pessoa){
		
		return getNome().toString().toLowerCase().trim().compareTo(pessoa.getNome().toString().trim().toLowerCase()); 
	}
}
