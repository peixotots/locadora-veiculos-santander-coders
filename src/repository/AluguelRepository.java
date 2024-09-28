package repository;

import model.aluguel.Aluguel;

import java.time.LocalDate;
import java.util.List;

public abstract class AluguelRepository<T extends Aluguel> {
    public abstract T salvar(T aluguel) ;
    public abstract LocalDate definirDataInicial();
    public abstract LocalDate definirDataDeDevolucaoPrevista(LocalDate dataInicial, int quantidadeDias);
    // public abstract List<T> listarAlugueis();
}
