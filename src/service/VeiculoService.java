package service;

import exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.List;

public interface VeiculoService{

    Veiculo cadastrar(Veiculo veiculo);
    Veiculo alterar(Veiculo veiculo);
    Veiculo buscarPorPlaca(String placa) throws PlacaInvalidaException;
    List<Veiculo> listar();
    void remover(Veiculo veiculo);

}
