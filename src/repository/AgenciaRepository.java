package repository;

import java.util.List;

public abstract class AgenciaRepository<T> {
    public abstract T salvar(T agencia);
    public abstract List<T> todos();
    public abstract List<T> buscarPorNomeOuEndereco(String termo);
    public abstract T alterar(T agencia);
}