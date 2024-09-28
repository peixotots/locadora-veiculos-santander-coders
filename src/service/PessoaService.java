package service;

import model.pessoa.Pessoa;
import java.util.List;

public interface PessoaService {

    Pessoa cadastrar(Pessoa pessoa);
    Pessoa alterar(Pessoa pessoa);
    Pessoa buscarPorNome(String nome);
    List<Pessoa> listar();
    void remover(Pessoa pessoa);
}
