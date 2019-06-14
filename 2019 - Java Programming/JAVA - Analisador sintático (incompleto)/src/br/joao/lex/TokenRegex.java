package br.joao.lex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TokenRegex {
	
	NEW_LINE("[\\r\\n]"),
	SPACE("[\\s]+"),
	EPISILON("\\$"),
	IF ("if"),
	EITHER ("either"),
	FUNC("func"),
	WHILE("while"),
	PUT("put"),
	SCAN("scan"),
	INT("int"),
	VOID("void"),
	BOOL("bool"),
	STR("str"),
	REAL("real"),
	CHARAC("charac"),
	TRUE("true"),
	FALSE("false"),
	RETURN("return"),
	OPEN_BRACKETS ("\\("),
	CLOSE_BRACKETS("\\)"),
	OPEN_BLOCK ("\\{"),
	CLOSE_BLOCK("\\}"),
	OPEN_HOOK("\\["),
	CLOSE_HOOK("\\]"),
	OP_COMP("=="),
	OP_ATR("="),
	OP_MULT("\\*"),
	OP_ADD("\\+"),
	OP_SUB("\\-"),
	OP_DIV("\\/"),
	OP_GREATEROREQUAL(">="),
	OP_MINOROREQUAL("<="),
	OP_GREATER(">"),
	OP_MINOR("<"),
	OP_AND("&&"),
	OP_OR("\\|\\|"),
	OP_NEG("!"),
	OP_CONCATSTR("\\.\\."),
	OP_DOT("\\."),
	OP_EOF(";"),
	OP_COMMA(","),
	
    LITERAL_STRING ("\"[^\"]+\""), // reconhece todos os caracteres, menos aspas duplas.
    LITERAL_STRING_BLANK("\"\""), // duas aspas duplas.
    LITERAL_CHARAC("'[^\']+'"), // reconhece todos os caracteres, menos aspas simples.
    LITERAL_CHARAC_BLANK("''"), // duas aspas simples.
    CONSTANT ("\\d+"), // reconhece qualquer inteiro de 0  a 9
    IDENTIFIER ("\\w+"); // reconhece um alfanumérico
	
	private Pattern pattern;
	
	TokenRegex(String regex) {
		pattern = Pattern.compile("^"+regex);
    }

    public int sizeOfLexem(String s) {
        Matcher m = pattern.matcher(s);
        
        if (m.find()) {
        //	System.out.println(m.find());
            return m.end();
        }
        return -1;
    }
}
