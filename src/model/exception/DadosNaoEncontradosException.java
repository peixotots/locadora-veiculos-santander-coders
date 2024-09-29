package model.exception;

public class DadosNaoEncontradosException extends RuntimeException {
    public DadosNaoEncontradosException() {
        super("Dados não encontrados no sistema.");
    }
}
