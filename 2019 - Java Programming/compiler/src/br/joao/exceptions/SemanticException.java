package br.joao.exceptions;

public class SemanticException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SemanticException(String msg) {
		super(msg);
	}
	
    public SemanticException(String msg, Throwable cause){
        super(msg, cause);
    }	

}
