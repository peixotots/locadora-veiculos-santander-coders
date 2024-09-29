package repository;

import exception.PlacaInvalidaException;
import model.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VeiculoRepositoryImpl extends VeiculoRepository {

    private static VeiculoRepositoryImpl instancia;
    private List<Veiculo> bancoDadosVeiculo;

    private VeiculoRepositoryImpl() {
        bancoDadosVeiculo = new ArrayList<>();
    }

    public static VeiculoRepositoryImpl getInstancia() {
        if (instancia == null) {
            instancia = new VeiculoRepositoryImpl();
        }
        return instancia;
    }

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        bancoDadosVeiculo.add(veiculo);
        return veiculo;
    }

    @Override
    public List<Veiculo> todos() {
        return bancoDadosVeiculo;
    }

    @Override
    public Veiculo alterar(Veiculo veiculo) throws PlacaInvalidaException {
        Optional<Veiculo> optionalVeiculo = this.buscarPor(veiculo.getPlaca());
        if (optionalVeiculo.isPresent()) {
            Veiculo veiculoBD = optionalVeiculo.get();
            int index = this.bancoDadosVeiculo.indexOf(veiculoBD);
            veiculoBD.setMarca(veiculo.getMarca());
            veiculoBD.setModelo(veiculo.getModelo());
            bancoDadosVeiculo.set(index, veiculoBD);
            return veiculoBD;
        } else throw new PlacaInvalidaException();
    }

    @Override
    public Optional<Veiculo> buscarPor(String placa) {
        return bancoDadosVeiculo
                .stream()
                .filter(veiculo -> veiculo.getPlaca().contains(placa)).findFirst();
    }
}
