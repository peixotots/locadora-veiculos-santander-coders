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
    public T cadastrar(T veiculo, int tipo) {
        if (veiculo.getPlaca().length() != 6) {
            throw new IllegalArgumentException("A placa deve conter 6 dígitos");
        }
        if (veiculo.getModelo().isEmpty()) {
            throw new IllegalArgumentException("O modelo não pode ser vazio");
        }
        if (veiculo.getMarca().isEmpty()) {
            throw new IllegalArgumentException("A marca não pode ser vazia");
        }

        return this.VeiculoRepository.salvar(veiculo);
    }

    @Override
    public T alterar(T veiculo) {
        //regras

        return this.VeiculoRepository.alterar(veiculo);
    }

    @Override
    public T buscarPorPlaca(String placa) {
        if(this.veiculoRepository.buscarPor(placa).isPresent())
            return (T) this.veiculoRepository.buscarPor(placa).get();

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

