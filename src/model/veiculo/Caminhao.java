package model.veiculo;

import java.math.BigDecimal;

public class Caminhao extends Veiculo {

    public Caminhao(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
        this.valor = new BigDecimal("200");
    }

    public Caminhao() {
        this.valor = new BigDecimal("200");
    }

    @Override
    public String toString() {
        return "CAMINHÃO" +
                "\nPlaca: " + placa +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nDisponivel: " + disponivel +
                "\nValor: R$" + valor;
    }
}
