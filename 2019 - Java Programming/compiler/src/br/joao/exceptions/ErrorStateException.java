package br.joao.exceptions;

public class ErrorStateException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public ErrorStateException(String msg){
        super(msg);
    }

    public ErrorStateException(String msg, Throwable cause){
        super(msg, cause);
    }

}
