package repository;

import model.pessoa.Pessoa;

import java.util.List;
import java.util.Optional;

public abstract class PessoaRepository<T extends Pessoa> {
    public abstract T salvar(T pessoa);
    public abstract List<T> todos();
    public abstract T alterar(T pessoa);
    public abstract Optional<T> buscarPorNome(String nome);
    public abstract void remover(T pessoa);
}
