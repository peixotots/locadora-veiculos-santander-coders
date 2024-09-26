package model.exception;

public class OpcaoInvalidaException extends Exception{
    public OpcaoInvalidaException(){
        super("Opção digitada inválida");
    }
}
