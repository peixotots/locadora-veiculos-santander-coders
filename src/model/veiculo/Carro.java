package model.veiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    public Carro(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
        this.valor = new BigDecimal("150");

    }

    public Carro() {
        this.valor = new BigDecimal("150");
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "CARRO: " +
                "Valor: R$" + valor +
                ", Placa: " + placa +
                ", Modelo: " + modelo +
                ", Marca: " + marca +
                ", Está disponível? " + disponivel;
    }
}
