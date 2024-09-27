package repository;

import model.agencia.Agencia;

import java.util.List;
import java.util.Optional;

public abstract class AgenciaRepository {
    public abstract Agencia salvar(Agencia agencia);
    public abstract List<Agencia> todos();
    public abstract List<Agencia> buscarPorNomeOuEndereco(String termo); // Modified to return a list
    public abstract Agencia alterar(Agencia agencia);
}