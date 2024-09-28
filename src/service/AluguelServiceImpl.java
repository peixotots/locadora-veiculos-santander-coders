package service;

import model.aluguel.Aluguel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AluguelServiceImpl<T extends Aluguel> implements AluguelService<T> {
    private final List<T> alugueis = new ArrayList<>();

    @Override
    public void criarAluguel(T aluguel) {
        alugueis.add(aluguel);
        aluguel.getVeiculo().setDisponivel(false);
    }

    @Override
    public LocalDate definirDataInicial() {
        LocalDate dataInicial = LocalDate.now();
        return formatarData(dataInicial);
    }

    @Override
    public LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias) {
        return dataInicial.plusDays(quantidadeDias);
    }

    @Override
    public List<T> getAlugueis() {
        return alugueis;
    }

    private LocalDate formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return LocalDate.parse(dataFormatada, formatter);
    }
}