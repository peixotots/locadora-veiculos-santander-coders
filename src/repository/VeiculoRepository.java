package repository;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.List;
import java.util.Optional;

public abstract class VeiculoRepository<T extends Veiculo> {
    public abstract T salvar(T veiculo);
    public abstract List<T> todos();
    public abstract T alterar(T veiculo) throws PlacaInvalidaException;
    public abstract Optional<T> buscarPor(String placa);
}
