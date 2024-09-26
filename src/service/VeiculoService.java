package service;

import model.veiculo.Veiculo;

import java.util.List;

public interface VeiculoService<T extends Veiculo> {

    T cadastrar(T veiculo, int tipo);
    T alterar(T veiculo);
    T buscarPorPlaca(String placa);
    List<T> listar();
    void remover(T veiculo);

}
