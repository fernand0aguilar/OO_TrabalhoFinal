package visao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import dados.PessoaMaiorIdade;
import dados.PessoaMenorIdade;
import dados.Pessoa;

public class Visao {

	public static int getAnoStringData(String dataNascimento){
		String anoSubString;
		try {
			anoSubString = dataNascimento.substring(6);
			Integer ano = Integer.parseInt(anoSubString);
			return ano;
		} catch (NumberFormatException erro) {
			return 0;

		}catch(StringIndexOutOfBoundsException erro){
			return 0;
		}
	}

	public static void mostraDados(ArrayList<Pessoa> conjuntoPessoas){
		int maiorIdade = 0, menorIdade = 0;

		if(conjuntoPessoas.size() == 0){
			System.out.println("Nao foi realizado nenhum cadastro ainda.");
		}
		else {
			limpar_tela(5);
			System.out.println("Nome\t\t\t\tCPF\t\tData de Nascimento\t\tSexo\t\tFoi vacinada?\t\tQuantidade de vacinas tomadas");
			for(int index = 0; index<conjuntoPessoas.size(); index++){
				System.out.println(conjuntoPessoas.get(index));
				Integer ano = getAnoStringData(conjuntoPessoas.get(index).getDataNascimento());
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

	public static void limpar_tela(int num){
		for(int index = 0; index < num; index++)
			System.out.println();
	}


	public static int adicionaObjetosTabelaPesquisados(ArrayList<Pessoa> conjuntoPessoas, List<Pessoa> novaListaAuxiliar, String pesquisa, DefaultTableModel tabelaPesquisadosModel, int total){
		Integer ano;

		for(int index = 0; index < conjuntoPessoas.size(); index++){
			if(novaListaAuxiliar.get(index).getNome().toLowerCase().contains(pesquisa.toLowerCase())){
				ano = getAnoStringData(novaListaAuxiliar.get(index).getDataNascimento());
				String statusIsVacinada;


				if(2016-ano >= 18){
					if(((PessoaMaiorIdade) novaListaAuxiliar.get(index)).isVacinada()){
						statusIsVacinada = "Sim";
					}
					else
						statusIsVacinada = "Nao";
					tabelaPesquisadosModel.addRow(new String[]{novaListaAuxiliar.get(index).getNome(),
							novaListaAuxiliar.get(index).getDataNascimento(),
							novaListaAuxiliar.get(index).getNumCPF(),
							String.valueOf(novaListaAuxiliar.get(index).getSexo())
							,statusIsVacinada, "---"});
				}
				else{
					tabelaPesquisadosModel.addRow(new String[]{novaListaAuxiliar.get(index).getNome(),
							novaListaAuxiliar.get(index).getDataNascimento(),
							novaListaAuxiliar.get(index).getNumCPF(),
							String.valueOf(novaListaAuxiliar.get(index).getSexo()),"---",
							((PessoaMenorIdade)novaListaAuxiliar.get(index)).getQuantVacinas().toString()});
				}
				total++;
			}
		}
		return total;
	}
}
