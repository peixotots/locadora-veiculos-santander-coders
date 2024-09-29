import controller.MenuPrincipal;
import model.exception.OpcaoInvalidaException;

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