package model.veiculo;

import java.math.BigDecimal;

public class Moto extends Veiculo {

    public BigDecimal valor = new BigDecimal("100");

    public Moto(String placa, String modelo, String marca, int valor) {
        super(placa, modelo, marca, valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

}