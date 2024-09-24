package model.veiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    private BigDecimal valor = new BigDecimal("150");

    public Carro(String placa, String modelo, String marca, Boolean disponivel) {
        super(placa, modelo, marca, disponivel);
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "valor=" + valor +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
