package repository;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryImpl<T extends Veiculo> extends VeiculoRepository<T> {

    public List<T> bancoDadosVeiculo;

    public VeiculoRepositoryImpl() {
        bancoDadosVeiculo = new ArrayList<>();
    }

    @Override
    public T salvar(T veiculo) {
        bancoDadosVeiculo.add(veiculo);
        return veiculo;
    }

    @Override
    public List<T> todos() {
        return bancoDadosVeiculo;
    }

    @Override
    public T alterar(T veiculo) throws PlacaInvalidaException {
        Optional<T> optionalVeiculo = this.buscarPor(veiculo.getPlaca());
        if (optionalVeiculo.isPresent()) {
            T veiculoBD = optionalVeiculo.get();
            int index = this.bancoDadosVeiculo.indexOf(veiculoBD);
            veiculoBD.setMarca(veiculo.getMarca());
            veiculoBD.setModelo(veiculo.getModelo());
            this.bancoDadosVeiculo.set(index, veiculoBD);
            return veiculoBD;
        } else throw new PlacaInvalidaException();
    }

    @Override
    public Optional<T> buscarPor(String placa) {
        return this.bancoDadosVeiculo
                .stream()
                .filter(veiculo -> veiculo.getPlaca().contains(placa)).findFirst();
    }
}
