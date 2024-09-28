package service;

import repository.AgenciaRepository;
import repository.AgenciaRepositoryImpl;

import java.util.List;

public class AgenciaServiceImpl<T> implements AgenciaService<T> {

    private final AgenciaRepository<T> agenciaRepository;

    public AgenciaServiceImpl() {
        this.agenciaRepository = new AgenciaRepositoryImpl<>();
    }

    @Override
    public T cadastrar(T agencia) {
        return this.agenciaRepository.salvar(agencia);
    }

    @Override
    public List<T> buscarPorNomeOuEndereco(String termo) {
        return this.agenciaRepository.buscarPorNomeOuEndereco(termo);
    }

    @Override
    public List<T> listar() {
        return this.agenciaRepository.todos();
    }

    @Override
    public T alterar(T agencia) {
        return this.agenciaRepository.alterar(agencia);
    }
}