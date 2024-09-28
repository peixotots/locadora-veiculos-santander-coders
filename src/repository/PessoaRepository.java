package repository;

import model.pessoa.Pessoa;

import java.util.List;
import java.util.Optional;

public abstract class PessoaRepository{
    public abstract Pessoa salvar(Pessoa pessoa);
    public abstract List<Pessoa> todos();
    public abstract Pessoa alterar(Pessoa pessoa);
    public abstract Optional<Pessoa> buscarPorNome(String nome);
    public abstract void remover(Pessoa pessoa);
}
