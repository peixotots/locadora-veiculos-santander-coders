package service;

import java.util.List;

public interface AgenciaService<T> {
    T cadastrar(T agencia);
    List<T> buscarPorNomeOuEndereco(String termo);
    List<T> listar();
    T alterar(T agencia);
}