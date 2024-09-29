package exception;

public class DadoInvalidoException extends Exception {
    public DadoInvalidoException() {
        super("Dado digitado inválido");
    }
}
