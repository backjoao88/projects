package br.joao.testes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TesteMatcher {

	public static void main(String[] args) {
		
		
		String regex = "if"; // \"[^\"]+\"
		String entrada = "if(x<y)if {}";
		
		Pattern pattern = Pattern.compile("^"+regex); // o ^ significa inicio da string, ent�o a string come�a e depois � necess�rio vir o que est� 
		// em regex.
		
		Matcher m = pattern.matcher(entrada);

		
		if(m.find()) {
			System.out.println(m.end());
		}
	

	}

}
