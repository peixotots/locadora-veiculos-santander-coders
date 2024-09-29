package repository;

import model.aluguel.Aluguel;
import model.pessoa.Pessoa;
import model.veiculo.Veiculo;

import java.time.LocalDate;
import java.util.List;

public abstract class AluguelRepository{
    public abstract Aluguel salvar(Aluguel aluguel) ;
    public abstract LocalDate definirDataInicial();
    public abstract LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias);
    public abstract Aluguel buscarAluguel(String placa);
    public abstract void deletarAluguel(Aluguel aluguel);
    public abstract boolean verificarDisponibilidade(Veiculo veiculo);
}
