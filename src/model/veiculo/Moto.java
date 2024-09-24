package model.veiculo;

import java.math.BigDecimal;

public class Moto extends Veiculo {

    private BigDecimal valor = new BigDecimal("100");

    public Moto(String placa, String modelo, String marca, Boolean disponivel) {
        super(placa, modelo, marca, disponivel);
    }
}