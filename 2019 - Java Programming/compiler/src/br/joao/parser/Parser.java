package br.joao.parser;

import br.joao.exceptions.ParserException;
import br.joao.exceptions.TokenNotFoundException;
import br.joao.lex.Lexer;
import br.joao.lex.Token;
import br.joao.lex.TokenRegex;
import br.joao.semantic.Symbol;
import br.joao.semantic.SymbolTable;

public class Parser {

	public int escopo;
	public String escopoAtual;
	public SymbolTable st;
	public Symbol symbol;
	private Lexer lex;
	private Token currentToken;
	private Token previousToken;

	public Parser(Lexer lex) {
		this.lex = lex;
		this.st = SymbolTable.getInstance();
		this.escopo = 0;
		symbol = new Symbol();
	}

	public Lexer getLex() {
		return lex;
	}

	public void setLex(Lexer lex) {
		this.lex = lex;
	}

	public Token getCurrentToken() {
		return currentToken;
	}

	public void setCurrentToken(Token currentToken) {
		this.currentToken = currentToken;
	}

	public Token getPreviousToken() {
		return previousToken;
	}

	public void setPreviousToken(Token previousToken) {
		this.previousToken = previousToken;
	}

	public boolean parse() {
		try {

			currentToken = lex.nextToken();

			if (currentToken.getToken().equals(TokenRegex.NEW_LINE)
					|| currentToken.getToken().equals(TokenRegex.SPACE)) {
				do {
					currentToken = lex.nextToken();
				} while (currentToken != null && (currentToken.getToken().equals(TokenRegex.NEW_LINE)
						|| currentToken.getToken().equals(TokenRegex.SPACE)));
			}

			previousToken = currentToken;
			start();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void start() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case FUNC:
			func_declaration();
			start();
			break;
		case EPISILON:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void func_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case FUNC:
			check(TokenRegex.FUNC);
			func_types_declaration();
			symbol.setCategoria(Symbol.Categoria.FUNCAO);
			symbol.setEscopo(escopo);
			symbol.setInicioDecl(currentToken.getLine());
			symbol.setNome(currentToken.getLexem());
			
			Symbol symbFunc = new Symbol();
			symbFunc.setCategoria(symbol.getCategoria());
			symbFunc.setEscopo(escopo);
			symbFunc.setInicioDecl(symbol.getInicioDecl());
			symbFunc.setNome(symbol.getNome());
			symbFunc.setTipo(symbol.getTipo());
			
			symbol = new Symbol();
			
			
			check(TokenRegex.IDENTIFIER);
			check(TokenRegex.OPEN_BRACKETS);
			parameters();
			check(TokenRegex.CLOSE_BRACKETS);
			check(TokenRegex.OPEN_BLOCK);
			blocks();
			return_block();
			
			symbFunc.setFimDecl(currentToken.getLine());
			
			st.add(symbFunc.getNome(), symbFunc);
			
			check(TokenRegex.CLOSE_BLOCK);

			break;
		default:
			break;
		}
	}

	private void return_block() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case RETURN:
			check(TokenRegex.RETURN);
			exp_or();
			check(TokenRegex.OP_EOF);
			break;
		case CLOSE_BLOCK:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void parameters() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case INT:
		case REAL:
		case STR:
		case CHARAC:
		case BOOL:
		case VOID:
			type_declaration();
			identifier();
			parameter();
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void type_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case INT:
			symbol.setTipo(Symbol.TipoDado.INT);
			check(TokenRegex.INT);
			break;
		case REAL:
			symbol.setTipo(Symbol.TipoDado.REAL);
			check(TokenRegex.REAL);
			break;
		case STR:
			symbol.setTipo(Symbol.TipoDado.STR);
			check(TokenRegex.STR);
			break;
		case CHARAC:
			symbol.setTipo(Symbol.TipoDado.CHARAC);
			check(TokenRegex.CHARAC);
			break;
		case BOOL:
			symbol.setTipo(Symbol.TipoDado.BOOL);
			check(TokenRegex.BOOL);
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void parameter() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_COMMA:
			check(TokenRegex.OP_COMMA);
			type_declaration();
			identifier();
			parameter();
			break;
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void func_invocation() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OPEN_BRACKETS:
			check(TokenRegex.OPEN_BRACKETS);
			arguments();
			check(TokenRegex.CLOSE_BRACKETS);
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void arguments() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_DOT:
			exp_or();
			argument();
			break;
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void argument() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_COMMA:
			check(TokenRegex.OP_COMMA);
			exp_or();
			argument();
			break;
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}

	}

	private void func_types_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case INT:
			symbol.setTipo(Symbol.TipoDado.INT);
			check(TokenRegex.INT);
			break;
		case REAL:
			symbol.setTipo(Symbol.TipoDado.REAL);
			check(TokenRegex.REAL);
			break;
		case STR:
			symbol.setTipo(Symbol.TipoDado.STR);
			check(TokenRegex.STR);
			break;
		case CHARAC:
			symbol.setTipo(Symbol.TipoDado.CHARAC);
			check(TokenRegex.CHARAC);
			break;
		case BOOL:
			symbol.setTipo(Symbol.TipoDado.BOOL);
			check(TokenRegex.BOOL);
			break;
		case VOID:
			symbol.setTipo(Symbol.TipoDado.VOID);
			check(TokenRegex.VOID);
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void identifier() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
			check(TokenRegex.IDENTIFIER);
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void if_stmt() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case IF:
			check(TokenRegex.IF);
			check(TokenRegex.OPEN_BRACKETS);
			exp_or();
			check(TokenRegex.CLOSE_BRACKETS);
			check(TokenRegex.OPEN_BLOCK);
			blocks();
			check(TokenRegex.CLOSE_BLOCK);
			either();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_or() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_NEG:
			exp_and();
			exp_or_operator();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_or_operator() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_OR:
			check(TokenRegex.OP_OR);
			exp_or();
			break;
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_and() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_NEG:
			exp_others_relational();
			exp_and_operator();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_and_operator() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case OP_AND:
			check(TokenRegex.OP_AND);
			exp_and();
			break;
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_OR:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_others_relational() throws ParserException, TokenNotFoundException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_DOT:
		case OP_NEG:
			exp_relational();
			exp_others_relational_operators();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_others_relational_operators() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_COMP:
			check(TokenRegex.OP_COMP);
			exp_others_relational();
			break;
		case OP_NEG:
			check(TokenRegex.OP_NEG);
			exp_others_relational();
			break;
		// fechar_par, fechar_col, op_or, op_and, eof, comma - episilon
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_OR:
		case OP_AND:
		case OP_EOF:
		case OP_COMMA:
			break;
		default:
			throw new ParserException("Erro sintático. Token: " + currentToken);
		}
	}

	private void exp_relational() throws ParserException, TokenNotFoundException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_DOT:
		case OP_NEG:
			// <exp_addsub> <exp_relational_operators>;
			exp_addsub();
			exp_relational_operators();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_relational_operators() throws TokenNotFoundException, ParserException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OP_GREATER:
			check(TokenRegex.OP_GREATER);
			exp_relational();
			break;
		case OP_MINOR:
			check(TokenRegex.OP_MINOR);
			exp_relational();
			break;
		case OP_GREATEROREQUAL:
			check(TokenRegex.OP_GREATEROREQUAL);
			exp_relational();
			break;
		case OP_MINOROREQUAL:
			check(TokenRegex.OP_MINOROREQUAL);
			exp_relational();
			break;
		// fechar_par, fechar_col, op_or, op_and, op_comp, op_dif, eof, comma - episilon
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_addsub() throws ParserException, TokenNotFoundException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_NEG:
			// <exp_addsub> <exp_relational_operators>;
			exp_multdiv();
			expaddsub_operators();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void expaddsub_operators() throws TokenNotFoundException, ParserException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OP_ADD:
			check(TokenRegex.OP_ADD);
			exp_addsub();
			break;
		case OP_SUB:
			check(TokenRegex.OP_SUB);
			exp_addsub();
			break;
		// fechar_par, fechar_col, op_maior, op_menor, op_maiorigual, op_menorigual,
		// op_or, op_and, op_comp, op_dif, eof, comma
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_GREATER:
		case OP_MINOR:
		case OP_GREATEROREQUAL:
		case OP_MINOROREQUAL:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void exp_multdiv() throws ParserException, TokenNotFoundException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OPEN_BRACKETS:
		case OP_DOT:
		case OP_NEG:
			// <exp_addsub> <exp_relational_operators>;
			higher_exp();
			expmultdiv_operators();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void expmultdiv_operators() throws TokenNotFoundException, ParserException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OP_MULT:
			check(TokenRegex.OP_MULT);
			exp_multdiv();
			break;
		case OP_DIV:
			check(TokenRegex.OP_DIV);
			exp_multdiv();
			break;
		// fechar_par, fechar_col, op_maior, op_menor, op_maiorigual, op_menorigual,
		// op_or, op_and, op_comp, op_dif, eof, comma
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_GREATER:
		case OP_MINOR:
		case OP_GREATEROREQUAL:
		case OP_MINOROREQUAL:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
		case OP_ADD:
		case OP_SUB:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void higher_exp() throws ParserException, TokenNotFoundException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OPEN_BRACKETS:
			check(TokenRegex.OPEN_BRACKETS);
			exp_or();
			check(TokenRegex.CLOSE_BRACKETS);
			break;
		// literal constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, dot
		case IDENTIFIER:
			identifier();
			identifier_array();
			break;
		case OP_NEG:
			check(TokenRegex.OP_NEG);
			higher_exp();
			break;
		case CONSTANT:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case TRUE:
		case FALSE:
		case OP_DOT:
			// <exp_addsub> <exp_relational_operators>;
			literal();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

//	private void higher_exp_factor() throws TokenNotFoundException, ParserException {
//		switch (currentToken.getToken()) {
//		case OPEN_BRACKETS:
//			func_invocation();
//			break;
//		case OPEN_HOOK:
//			identifier_array();
//			break;
//		case CLOSE_BRACKETS:
//		case CLOSE_HOOK:
//		case OP_GREATER:
//		case OP_MINOR:
//		case OP_GREATEROREQUAL:
//		case OP_MINOROREQUAL:
//		case OP_ADD:
//		case OP_SUB:
//		case OP_MULT:
//		case OP_DIV:
//		case OP_OR:
//		case OP_AND:
//		case OP_COMP:
//		case OP_EOF:
//		case OP_COMMA:
//		case OP_CONCATSTR:
//			break;
//		default:
//			throw new ParserException("Erro sintático. Token: " + currentToken.toString());
//		}
//	}

	private void identifier_array() throws TokenNotFoundException, ParserException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			exp_or();
			check(TokenRegex.CLOSE_HOOK);
			identifier_array_factor();
			break;
		// fechar_par, fechar_col, op_maior, op_menor, op_maiorigual, op_menorigual,
		// op_adicao, op_subtracao, op_mult, op_div, op_or, op_and, op_comp, op_dif,
		// eof, comma
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_GREATER:
		case OP_MINOR:
		case OP_GREATEROREQUAL:
		case OP_MINOROREQUAL:
		case OP_ADD:
		case OP_SUB:
		case OP_MULT:
		case OP_DIV:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
			break;
		default:
			throw new ParserException("Erro sintático. Token: " + currentToken.toString());
		}
	}

	private void identifier_array_factor() throws TokenNotFoundException, ParserException {
		// identificador, constante, valor_literal_str, valor_literal_str_vazio,
		// valor_literal_charac, true, false, abrir_par, dot
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			exp_or();
			check(TokenRegex.CLOSE_HOOK);
			identifier_array();
			break;
		// fechar_par, fechar_col, op_maior, op_menor, op_maiorigual, op_menorigual,
		// op_adicao, op_subtracao, op_mult, op_div, op_or, op_and, op_comp, op_dif,
		// eof, comma
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case OP_GREATER:
		case OP_MINOR:
		case OP_GREATEROREQUAL:
		case OP_MINOROREQUAL:
		case OP_ADD:
		case OP_SUB:
		case OP_MULT:
		case OP_DIV:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
		case OP_CONCATSTR:
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void literal() throws ParserException, TokenNotFoundException {
		// constante, valor_literal_str, valor_literal_str_vazio, valor_literal_charac,
		// true, false, dot
		switch (currentToken.getToken()) {
		case CONSTANT:
			integer_literal();
			break;
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
			charac_literal();
			break;
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
			str_literal();
			break;
		case TRUE:
		case FALSE:
			bool_literal();
			break;
		case CLOSE_BLOCK:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void charac_literal() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case LITERAL_CHARAC:
			check(TokenRegex.LITERAL_CHARAC);
			break;
		case LITERAL_CHARAC_BLANK:
			check(TokenRegex.LITERAL_CHARAC_BLANK);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void bool_literal() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case TRUE:
			check(TokenRegex.TRUE);
			break;
		case FALSE:
			check(TokenRegex.FALSE);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void str_literal() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case LITERAL_STRING:
			check(TokenRegex.LITERAL_STRING);
			break;
		case LITERAL_STRING_BLANK:
			check(TokenRegex.LITERAL_STRING_BLANK);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void integer_literal() throws TokenNotFoundException, ParserException {
		// constante, valor_literal_str, valor_literal_str_vazio, valor_literal_charac,
		// true, false, dot
		switch (currentToken.getToken()) {
		case CONSTANT:
			check(TokenRegex.CONSTANT);
			factor_integer_literal();
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void factor_integer_literal() throws TokenNotFoundException, ParserException {
		// constante, valor_literal_str, valor_literal_str_vazio, valor_literal_charac,
		// true, false, dot
		switch (currentToken.getToken()) {
		case OP_DOT:
			check(TokenRegex.OP_DOT);
			real_literal();
			break;
		// fechar_par, fechar_bloco, fechar_col, op_maior, op_menor, op_maiorigual,
		// op_menorigual, op_adicao, op_subtracao, op_mult, op_div, op_or, op_and,
		// op_comp, op_dif, eof, comma
		case CLOSE_BRACKETS:
		case CLOSE_HOOK:
		case CLOSE_BLOCK:
		case OP_GREATER:
		case OP_MINOR:
		case OP_GREATEROREQUAL:
		case OP_MINOROREQUAL:
		case OP_ADD:
		case OP_SUB:
		case OP_MULT:
		case OP_DIV:
		case OP_OR:
		case OP_AND:
		case OP_COMP:
		case OP_NEG:
		case OP_EOF:
		case OP_COMMA:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void real_literal() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case CONSTANT:
			check(TokenRegex.CONSTANT);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void blocks() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case IF:
		case PUT:
		case IDENTIFIER:
		case INT:
		case BOOL:
		case STR:
		case REAL:
		case CHARAC:
		case WHILE:
		case SCAN:
			block();
			blocks();
			break;
		case RETURN:
		case CLOSE_BLOCK:
			break; // episilon
		default:
			throw new ParserException("Erro sintático. Token: " + currentToken);
		}
	}

	public void block() throws TokenNotFoundException, ParserException {
		escopo++;
		switch (currentToken.getToken()) {
		case IF:
			escopoAtual = escopoAtual + "_if"+escopo;
			if_stmt();
			break;
		case PUT:
			put_declaration();
			break;
		case IDENTIFIER:
			check(TokenRegex.IDENTIFIER);
			factor_func_block();
			check(TokenRegex.OP_EOF);
			break;
		case INT:
		case BOOL:
		case STR:
		case REAL:
		case CHARAC:
			type_declaration();
			factor_block_var();
			break;
		case WHILE:
			escopoAtual = escopoAtual + "_while"+escopo;
			while_stmt();
			break;
		case SCAN:
			scan_declaration();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
		escopo--;
	}

	private void factor_block_var() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
			var_declaration();
			break;
		case OPEN_HOOK:
			array_variable_declaration();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void array_variable_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			dimension_values();
			check(TokenRegex.CLOSE_HOOK);
			array_variable_declaration_factor();
			check(TokenRegex.IDENTIFIER);
			vet_atribution();
			check(TokenRegex.OP_EOF);
			break;
		default:
			throw new ParserException("Erro sintático");
		}
	}

	private void vet_atribution() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_ATR:
			check(TokenRegex.OP_ATR);
			check(TokenRegex.OPEN_BLOCK);
			array_values();
			check(TokenRegex.CLOSE_BLOCK);
		case OP_EOF:
			break;
		default:
			throw new ParserException("Erro sintático");
		}

	}

	private void array_values() throws ParserException, TokenNotFoundException {

		switch (currentToken.getToken()) {

		case CONSTANT:
		case LITERAL_CHARAC:
		case LITERAL_CHARAC_BLANK:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
		case TRUE:
		case FALSE:
			literal();
			array_values_factor();
			break;
		case OPEN_BLOCK:
			check(TokenRegex.OPEN_BLOCK);
			array_values();
			check(TokenRegex.CLOSE_BLOCK);
			array_values_factor();
			break;
		case CLOSE_BLOCK:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void array_values_factor() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_COMMA:
			check(TokenRegex.OP_COMMA);
			array_values();
			break;
		case CLOSE_BLOCK:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void array_variable_declaration_factor() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			dimension_values();
			check(TokenRegex.CLOSE_HOOK);
			break;
		case IDENTIFIER:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void dimension_values() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case CONSTANT:
			check(TokenRegex.CONSTANT);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void scan_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case SCAN:
			check(TokenRegex.SCAN);
			check(TokenRegex.OPEN_BRACKETS);
			scan_arguments();
			check(TokenRegex.CLOSE_BRACKETS);
			check(TokenRegex.OP_EOF);
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void scan_arguments() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
			identifier();
			identifier_array();
			scan_argument();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void scan_argument() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_COMMA:
			check(TokenRegex.OP_COMMA);
			identifier();
			identifier_array();
			scan_argument();
			break;
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void put_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case PUT:
			check(TokenRegex.PUT);
			check(TokenRegex.OPEN_BRACKETS);
			put_arguments();
			check(TokenRegex.CLOSE_BRACKETS);
			check(TokenRegex.OP_EOF);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void put_arguments() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
			put_argument();
			factor_put_arguments();
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void factor_put_arguments() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case OP_CONCATSTR:
			check(TokenRegex.OP_CONCATSTR);
			put_argument();
			factor_put_arguments();
			break;
		case CLOSE_BRACKETS:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void put_argument() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case LITERAL_STRING:
		case LITERAL_STRING_BLANK:
			str_literal();
			break;
		case IDENTIFIER:
			identifier();
			identifier_array();
			break;
		default:
			throw new ParserException("Erro sintático.");
		}
	}

	private void while_stmt() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case WHILE:
			check(TokenRegex.WHILE);
			check(TokenRegex.OPEN_BRACKETS);
			exp_or();
			check(TokenRegex.CLOSE_BRACKETS);
			check(TokenRegex.OPEN_BLOCK);
			blocks();
			check(TokenRegex.CLOSE_BLOCK);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void is_array() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			exp_or();
			check(TokenRegex.CLOSE_HOOK);
			is_array_factor();
			break;
		case OP_ATR:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}

	}

	private void is_array_factor() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OPEN_HOOK:
			check(TokenRegex.OPEN_HOOK);
			exp_or();
			check(TokenRegex.CLOSE_HOOK);
			is_array();
			break;
		case OP_ATR:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void var_declaration() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case IDENTIFIER:
			symbol.setNome(currentToken.getLexem());
			symbol.setCategoria(Symbol.Categoria.IDENTIFICADOR);
			symbol.setInicioDecl(currentToken.getLine());
			symbol.setFimDecl(currentToken.getLine());
			symbol.setEscopo(escopo);
			st.add(currentToken.getLexem(), symbol);
			symbol = new Symbol();
			check(TokenRegex.IDENTIFIER);
			possible_values();
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void possible_values() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case OP_EOF:
			check(TokenRegex.OP_EOF);
			break;
		case OP_ATR:
			check(TokenRegex.OP_ATR);
			exp_or();
			check(TokenRegex.OP_EOF);
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void factor_func_block() throws ParserException, TokenNotFoundException {
		switch (currentToken.getToken()) {
		case OPEN_BRACKETS:
			func_invocation();
			break;
		case OPEN_HOOK:
		case OP_ATR:
			atribution();
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void atribution() throws TokenNotFoundException, ParserException {
		switch (currentToken.getToken()) {
		case OP_ATR:
		case OPEN_HOOK:
			is_array();
			check(TokenRegex.OP_ATR);
			exp_or();
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void either() throws ParserException, TokenNotFoundException {
		// identificador, int, bool, str, real, charac, return, fechar_bloco, if, while,
		// put, scan
		switch (currentToken.getToken()) {
		case EITHER:
			check(TokenRegex.EITHER);
			check(TokenRegex.OPEN_BLOCK);
			blocks();
			check(TokenRegex.CLOSE_BLOCK);
			break;
		case IDENTIFIER:
		case INT:
		case BOOL:
		case STR:
		case REAL:
		case CHARAC:
		case RETURN:
		case CLOSE_BLOCK:
		case IF:
		case WHILE:
		case PUT:
		case SCAN:
			break;
		default:
			throw new ParserException("Parser exception. Token" + currentToken.getToken());
		}
	}

	private void check(TokenRegex expectedTypeToken) throws TokenNotFoundException {
		if (expectedTypeToken.equals(currentToken.getToken())) {
			previousToken = currentToken;
			currentToken = lex.nextToken();

			if (currentToken.getToken().equals(TokenRegex.NEW_LINE)
					|| currentToken.getToken().equals(TokenRegex.SPACE)) {
				do {
					currentToken = lex.nextToken();
				} while (currentToken != null && (currentToken.getToken().equals(TokenRegex.NEW_LINE)
						|| currentToken.getToken().equals(TokenRegex.SPACE)));
			}

			if (currentToken == null) {
				currentToken = new Token();
				currentToken.setFinalPosition(0);
				currentToken.setInitialPosition(0);
				currentToken.setLexem("$");
				currentToken.setToken(TokenRegex.EPISILON);
			}
		} else {
			throw new TokenNotFoundException("Token not found");
		}
	}
}
