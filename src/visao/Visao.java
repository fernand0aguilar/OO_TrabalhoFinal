package visao;

import java.util.ArrayList;

import dados.Pessoa;

public class Visao {
	public static void mostraDados(ArrayList<Pessoa> conjuntoPessoas){
		int maiorIdade = 0, menorIdade = 0;
		
		if(conjuntoPessoas.size() == 0){
			System.out.println("Nao foi realizado nenhum cadastro ainda.");
		}
		else {
			String anoSubString;
			
			System.out.println("Nome\t\t\t\tCPF\t\tData de Nascimento\t\tSexo\t\tFoi vacinada?\t\tQuantidade de vacinas tomadas");
			for(int index = 0; index<conjuntoPessoas.size(); index++){
				System.out.println(conjuntoPessoas.get(index));
				anoSubString = conjuntoPessoas.get(index).getDataNascimento().substring(6);
				Integer ano = Integer.parseInt(anoSubString);
				if(2016-ano >= 18)
					maiorIdade++;
				else if(2016-ano <= 18)
					menorIdade++;
			}
			System.out.println("Quantidade de pessoas maiores de 18 anos: "+ maiorIdade);
			System.out.println("Quantidade de pessoas menores de 18 anos: "+ menorIdade);
			System.out.println("Quantidade total de pessoas: " + conjuntoPessoas.size());
		}
	}
}
