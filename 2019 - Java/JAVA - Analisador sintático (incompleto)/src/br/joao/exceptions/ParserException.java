package br.joao.exceptions;

public class ParserException extends Exception {

	private static final long serialVersionUID = -8769436007370258618L;

	/**
	 * 
	 */
	
    public ParserException(String msg){
        super(msg);
    }

    public ParserException(String msg, Throwable cause){
        super(msg, cause);
    }

}
