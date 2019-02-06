package br.joao.exceptions;

public class TokenNotFoundException extends Exception{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5159765832366897001L;

	public TokenNotFoundException(String msg){
        super(msg);
    }

    public TokenNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

}
