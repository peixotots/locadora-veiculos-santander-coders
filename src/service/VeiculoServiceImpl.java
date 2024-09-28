package service;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;
import repository.VeiculoRepository;
import repository.VeiculoRepositoryImpl;

import java.util.List;

public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoServiceImpl() {
        this.veiculoRepository = VeiculoRepositoryImpl.getInstancia();
    }

    @Override
    public Veiculo cadastrar(Veiculo veiculo)  {
        if (this.veiculoRepository.buscarPor(veiculo.getPlaca()).isPresent()) {
            System.err.println("Placa já cadastrada.");
        } else return this.veiculoRepository.salvar(veiculo);
        return veiculo;
    }

    @Override
    public Veiculo alterar(Veiculo veiculo) {
        try {
            return this.veiculoRepository.alterar(veiculo);
        } catch (PlacaInvalidaException e){
            System.out.println(e.getMessage());
        };
        return null;
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) throws PlacaInvalidaException {
        if(this.veiculoRepository.buscarPor(placa).isPresent()) {
            return this.veiculoRepository.buscarPor(placa).get();
        } else throw new PlacaInvalidaException();
    }

    @Override
    public List<Veiculo> listar() {
        return this.veiculoRepository.todos();
    }

    @Override
    public void remover(Veiculo veiculo) {

    }
}

