package service;

import model.aluguel.Aluguel;
import model.veiculo.Veiculo;

import java.time.LocalDate;

public interface AluguelService{
    void criarAluguel(Aluguel aluguel);
    LocalDate definirDataInicial();
    LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias);
    Aluguel salvar(Aluguel aluguel);
    Aluguel buscarAluguel(String placa);
    void deletarAluguel(Aluguel aluguel);
    boolean verificarDisponibilidade(Veiculo veiculo);
}
