package repository;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public abstract class VeiculoRepository {
    public abstract Veiculo salvar(Veiculo veiculo);
    public abstract List<Veiculo> todos();
    public abstract Veiculo alterar(Veiculo veiculo) throws PlacaInvalidaException;
    public abstract Optional<Veiculo> buscarPor(String placa);
}
