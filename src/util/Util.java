package util;

import model.exception.DadoInvalidoException;
import model.exception.OpcaoInvalidaException;
import model.exception.PlacaInvalidaException;

import java.util.Objects;
import java.util.Scanner;

public class Util {

    private static Scanner entrada = new Scanner(System.in);

    public static String lerTexto(String pergunta) throws DadoInvalidoException {
        System.out.println(pergunta);
        String texto = entrada.nextLine();
        while (texto.isEmpty()){
            System.err.println("Entrada inválida. Digite texto válido.");
            texto = entrada.nextLine();
        }
        return texto;
    }


    public static int lerNumeroInteiro(String pergunta) throws OpcaoInvalidaException {
        System.out.println(pergunta);
        String texto = entrada.nextLine();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new OpcaoInvalidaException();
        }
    }

    public static boolean validaPlaca(String placa) throws PlacaInvalidaException {
        String regex = "^[A-Z]{3}\\d{3}$";
        if (!placa.matches(regex)) {
            throw new PlacaInvalidaException();
        } else return true;
    }
}
