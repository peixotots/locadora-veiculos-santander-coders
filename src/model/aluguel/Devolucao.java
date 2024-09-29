package model.aluguel;

import model.veiculo.Caminhao;
import model.veiculo.Carro;
import model.veiculo.Moto;
import model.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Devolucao {

    private Aluguel aluguel;

    public Devolucao(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public void devolver(LocalDate data, String tipoPessoa) {
        long quantidadeDeDias = ChronoUnit.DAYS.between(aluguel.getDataInicio(), data);

        double valorDiaria;
        if (aluguel.getVeiculo() instanceof Carro) {
            valorDiaria = 150.0;
        } else if (aluguel.getVeiculo() instanceof Moto) {
            valorDiaria = 100.0;
        } else if (aluguel.getVeiculo() instanceof Caminhao) {
            valorDiaria = 200.0;
        } else {
            throw new IllegalArgumentException("Tipo de veículo desconhecido.");
        }

        double valorTotal = quantidadeDeDias * valorDiaria;
        double desconto = 0.0;

        if (tipoPessoa.equalsIgnoreCase("fisica") && quantidadeDeDias > 5) {
            desconto = 0.05;
        } else if (tipoPessoa.equalsIgnoreCase("juridica") && quantidadeDeDias > 3) {
            desconto = 0.10;
        }
        double valorComDesconto = valorTotal * (1 - desconto);

        System.out.printf("Valor total a ser pago: R$ %.2f%n", valorComDesconto);
    }

    public void disponibilizarVeiculo(Veiculo veiculo) {
        veiculo.setDisponivel(true);
    }
}