package br.joao.exceptions;

public class InvalidStateTokenException extends Exception{
	
    private static final long serialVersionUID = 1149241039409861914L;

    // constr�i um objeto NumeroNegativoException com a mensagem passada por par�metro
    public InvalidStateTokenException(String msg){
        super(msg);
    }

    // contr�i um objeto NumeroNegativoException com mensagem e a causa dessa exce��o, utilizado para encadear exceptions
    public InvalidStateTokenException(String msg, Throwable cause){
        super(msg, cause);
    }
}
