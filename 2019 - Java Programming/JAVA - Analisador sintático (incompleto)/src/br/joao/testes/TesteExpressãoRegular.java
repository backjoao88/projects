package br.joao.testes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteExpressãoRegular {
	
	public static void main(String[] args) {
		
		String identificador = "122121.2323";
		
		//String regexStr =  "[a-zA-Z]+([a-zA-Z0-9])*";
		//String regexInteger =  "([0-9])*";
		String regexReal =  "([0-9])+\\.([0-9])+";
		
		Pattern pattern = Pattern.compile(regexReal);
		
		Matcher mat = pattern.matcher(identificador);
		
		System.out.println(mat.matches());
	
		
		
	}

}
