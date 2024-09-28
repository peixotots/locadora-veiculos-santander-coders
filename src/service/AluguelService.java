package service;

import model.aluguel.Aluguel;
import model.exception.DadosNaoEncontradosException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AluguelService<T extends Aluguel> {
    private List<T> alugueis = new ArrayList<>();

    public void criarAluguel(T aluguel) {
        alugueis.add(aluguel);
        aluguel.getVeiculo().setDisponivel(false);
    }

    public LocalDate formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        return LocalDate.parse(dataFormatada, formatter);
    }

    public LocalDate definirDataInicial() {
        LocalDate dataInicial = LocalDate.now();
        formatarData(dataInicial);
        return dataInicial;
    }

    public LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias) {
        return dataInicial.plusDays(quantidadeDias);
    }

    public List<T> getAlugueis() {
        return alugueis;
    }

    public void encerrarAluguel(Aluguel aluguel) {
        if (alugueis.contains(aluguel)) {
            alugueis.remove(aluguel);
            aluguel.getVeiculo().setDisponivel(true);
        } else {
          throw new DadosNaoEncontradosException();
        }
    }
}
