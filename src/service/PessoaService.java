package service;

import model.pessoa.Pessoa;
import java.util.List;

public interface PessoaService<T extends Pessoa> {

    T cadastrar(T pessoa);
    T alterar(T pessoa);
    T buscarPorNome(String nome);
    List<T> listar();
    void remover(T pessoa);
}
