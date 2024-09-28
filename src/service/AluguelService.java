package service;

import model.aluguel.Aluguel;

import java.time.LocalDate;
import java.util.List;

public interface AluguelService<T extends Aluguel> {
    void criarAluguel(T aluguel);
    LocalDate definirDataInicial();
    LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias);
    List<T> getAlugueis();
}
