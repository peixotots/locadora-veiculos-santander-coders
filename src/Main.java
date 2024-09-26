import model.veiculo.Carro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();

        Carro carro = new Carro(placa, modelo, marca, 150);

        System.out.println(carro);
    }
}