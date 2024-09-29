package model.veiculo;

import java.math.BigDecimal;

public class Moto extends Veiculo {

    public Moto(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
        this.valor = new BigDecimal("100");
    }

    public Moto() {
        this.valor = new BigDecimal("100");
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "MOTO" +
                "\nPlaca: " + placa +
                "\nModelo: " + modelo +
                "\nMarca: " + marca +
                "\nDisponivel: " + disponivel +
                "\nValor: R$" + valor;
    }
}