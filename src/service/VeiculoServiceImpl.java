package service;

import model.exception.PlacaInvalidaException;
import model.veiculo.Veiculo;
import repository.VeiculoRepository;
import repository.VeiculoRepositoryImpl;

import java.util.List;

public class VeiculoServiceImpl<T extends Veiculo> implements VeiculoService<T> {

    private final VeiculoRepository<T> veiculoRepository;

    public VeiculoServiceImpl() {
        this.veiculoRepository = new VeiculoRepositoryImpl<>();
    }

    @Override
    public T cadastrar(T veiculo)  {
        if (this.veiculoRepository.buscarPor(veiculo.getPlaca()).isPresent()) {
            System.err.println("Placa já cadastrada.");
        } else return this.veiculoRepository.salvar(veiculo);
        return veiculo;
    }

    @Override
    public T alterar(T veiculo) {
        try {
            return this.veiculoRepository.alterar(veiculo);
        } catch (PlacaInvalidaException e){
            System.out.println(e.getMessage());
        };
        return null;
    }

    @Override
    public T buscarPorPlaca(String placa) throws PlacaInvalidaException {
        if(this.veiculoRepository.buscarPor(placa).isPresent()) {
            return this.veiculoRepository.buscarPor(placa).get();
        } else throw new PlacaInvalidaException();
    }

    @Override
    public List<T> listar() {
        return (List<T>) this.veiculoRepository.todos();
    }

    @Override
    public void remover(T veiculo) {

    }
}

