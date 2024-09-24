package model.veiculo;

import java.math.BigDecimal;

public class Caminhao extends Veiculo {

    private BigDecimal valor = new BigDecimal("200");

    public Caminhao(String placa, String modelo, String marca, Boolean disponivel) {
        super(placa, modelo, marca, disponivel);
    }
}
