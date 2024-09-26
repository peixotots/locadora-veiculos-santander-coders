package model.veiculo;

import java.math.BigDecimal;

public class Carro extends Veiculo {

    public BigDecimal valor = new BigDecimal("150");

    public Carro(String placa, String modelo, String marca, int valor) {
        super(placa, modelo, marca, valor);
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
