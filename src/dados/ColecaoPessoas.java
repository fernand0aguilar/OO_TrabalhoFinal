package dados;

import java.util.Vector;

public class ColecaoPessoas {
	private Vector<Pessoa> pessoas;
	
	public ColecaoPessoas(){
		this.pessoas = new Vector<Pessoa>();
	}

	public Vector<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
}
