package service;

import model.agencia.Agencia;

import java.util.List;

public interface AgenciaService {
    Agencia cadastrar(Agencia agencia);
    List<Agencia> buscarPorNomeOuEndereco(String termo); // Modified to return a list
    List<Agencia> listar();
    Agencia alterar(Agencia agencia);
}