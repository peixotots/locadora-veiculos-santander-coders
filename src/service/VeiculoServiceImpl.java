package service;

import model.veiculo.Veiculo;
import repository.VeiculoRepository;
import repository.VeiculoRepositoryImpl;

import java.util.List;

public class VeiculoServiceImpl<T extends Veiculo> implements VeiculoService<T> {

    private VeiculoRepository<T> VeiculoRepository;
    private repository.VeiculoRepository<Veiculo> veiculoRepository;

    public VeiculoServiceImpl() {
        this.VeiculoRepository = new VeiculoRepositoryImpl<>();
    }

    @Override
    public T cadastrar(T veiculo) {
        //regras aqui
        return this.VeiculoRepository.salvar(veiculo);
    }

    @Override
    public T alterar(T veiculo) {
        return this.VeiculoRepository.alterar(veiculo);
    }

    @Override
    public T buscarPorNome(String nome) {
        return null;
    }

    @Override
    public List<T> listar() {
        return (List<T>) this.veiculoRepository.todos();
    }

    @Override
    public void remover(T veiculo) {

    }
}

