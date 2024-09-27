import controller.MenuPrincipal;
import model.agencia.Agencia;
import model.exception.OpcaoInvalidaException;
import model.veiculo.Carro;
import model.veiculo.Veiculo;
import repository.VeiculoRepositoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        try {
            menuPrincipal.selecionaOpcao();
        } catch (OpcaoInvalidaException e) {
            System.out.println(e.getMessage());
        }


    }
}