package service;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.List;

public interface VeiculoService<T extends Veiculo> {

    T cadastrar(T veiculo);
    T alterar(T veiculo);
    T buscarPorPlaca(String placa) throws PlacaInvalidaException;
    List<T> listar();
    void remover(T veiculo);

}
