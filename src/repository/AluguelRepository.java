package repository;

import model.aluguel.Aluguel;
import model.pessoa.Pessoa;

import java.time.LocalDate;
import java.util.List;

public abstract class AluguelRepository{
    public abstract Aluguel salvar(Aluguel aluguel) ;
    public abstract LocalDate definirDataInicial();
    public abstract LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias);
    // public abstract List<Veiculo> listarAlugueis();
}
