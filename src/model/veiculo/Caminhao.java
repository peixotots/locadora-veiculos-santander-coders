package model.veiculo;

import java.math.BigDecimal;

public class Caminhao extends Veiculo {

    public BigDecimal valor = new BigDecimal("200");

    public Caminhao(String placa, String modelo, String marca, int valor) {
        super(placa, modelo, marca, valor);
    }
}
