package br.joao.testes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteMatcher {

	public static void main(String[] args) {
		
		
		String regex = "if"; // \"[^\"]+\"
		String entrada = "if(x<y)if {}";
		
		Pattern pattern = Pattern.compile("^"+regex); // o ^ significa inicio da string, então a string começa e depois é necessário vir o que está 
		// em regex.
		
		Matcher m = pattern.matcher(entrada);

		
		if(m.find()) {
			System.out.println(m.end());
		}
	

	}

}
