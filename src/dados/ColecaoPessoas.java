package dados;

import java.util.ArrayList;

public class ColecaoPessoas {
	private ArrayList<Pessoa> pessoas;
	
	public ColecaoPessoas(){
		this.pessoas = new ArrayList<Pessoa>();
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
}
