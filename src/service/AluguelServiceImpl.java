package service;

import model.aluguel.Aluguel;
import repository.AluguelRepository;
import java.time.LocalDate;

public class AluguelServiceImpl implements AluguelService{

    private AluguelRepository aluguelRepository;

    @Override
    public void criarAluguel(Aluguel aluguel) {
        aluguelRepository.salvar(aluguel);
        aluguel.getVeiculo().setDisponivel(false);
    }

    @Override
    public LocalDate definirDataInicial() {
        return aluguelRepository.definirDataInicial();
    }

    @Override
    public LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias) {
        return aluguelRepository.definirDataDeDevolucaoPrevista(dataInicial, quantidadeDias);
    }

    @Override
    public Aluguel salvar(Aluguel aluguel) {
        return aluguelRepository.salvar(aluguel);
    }
}