package br.joao.exceptions;

public class InvalidStateTokenException extends Exception{
	
    private static final long serialVersionUID = 1149241039409861914L;

    // constrói um objeto NumeroNegativoException com a mensagem passada por parâmetro
    public InvalidStateTokenException(String msg){
        super(msg);
    }

    // contrói um objeto NumeroNegativoException com mensagem e a causa dessa exceção, utilizado para encadear exceptions
    public InvalidStateTokenException(String msg, Throwable cause){
        super(msg, cause);
    }
}
