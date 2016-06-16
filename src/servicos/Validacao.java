package servicos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

import visao.Visao;

import dados.Pessoa;

public class Validacao {
	
	public static boolean validaNome(String nome){
		return !nome.isEmpty() ? true : false;
	}
	public static boolean validaInt(Integer inteiro){
		return (inteiro>=0) ? true : false;
	}
	
	/*Validacao de data utilizando SimpleDateFormat*/
	public static boolean validaData(String data){
		if (data.isEmpty())
			return false;
		
		DateFormat validadorData = new SimpleDateFormat("dd/MM/yyyy");
		validadorData.setLenient(false); 
		/*false - Nao tolerante a erros*/
		Integer ano = Visao.getAnoStringData(data);
		try{
			validadorData.parse(data);
			if(ano > 2016)
				return false;
			return true;
		}
		catch(ParseException erro){
			return false;
		}
	}
	
	public static boolean validaCPF(String numeroCPF){
		int numero,primDig, segDig, soma1 = 0, soma2 = 0, peso = 10;
		int resto1;
		int resto2;
		int index;
		
		if (numeroCPF.isEmpty())
			return false;
		
		if (numeroCPF.equals("00000000000") || numeroCPF.equals("11111111111") ||
				numeroCPF.equals("22222222222") || numeroCPF.equals("33333333333") ||
				numeroCPF.equals("44444444444") || numeroCPF.equals("55555555555") ||
				numeroCPF.equals("66666666666") || numeroCPF.equals("77777777777") ||
				numeroCPF.equals("88888888888") || numeroCPF.equals("99999999999") ||
				(numeroCPF.length() != 11))
			return(false);

		
		primDig = (numeroCPF.charAt(9)-48);
		segDig = (numeroCPF.charAt(10)-48);
		/*tabela asc2 -> 0 = 48*/
		
		try{
			/*Calculo do primeiro Digito Verificador*/
			for(index=0; index<9; index++){
				numero =  (int) (numeroCPF.charAt(index) - 48);
				soma1 += numero*peso;
				peso -= 1;
			}
			/*Calculo do segundo digito verificador*/
			peso = 11;
			for(index = 0; index < 10; index++){
				numero = (int) (numeroCPF.charAt(index) - 48);
				soma2 += numero*peso;
				peso -= 1;
			}
			resto1 = ((soma1*10) % 11);
			resto2 = ((soma2*10) %11);
			
			if (resto1 == 10)
				resto1 = 0;
			if (resto2 == 10)
				resto2 = 0;
			
			if(resto1 == primDig && resto2 == segDig){
				return true;
			}
			else return false;
		}

		catch(InputMismatchException erro){
			return (false);
		}
	}
	public static boolean checkDuplicidadeCPF(ArrayList<Pessoa> totalPessoas, String numCPF) {
		boolean statusValida = true;
		
		for(int cont=0; cont<totalPessoas.size();cont++){
			if(totalPessoas.get(cont).getNumCPF().equals(numCPF)){
				statusValida=false;
				cont=0;
			}
		}
		return statusValida;
	}
}