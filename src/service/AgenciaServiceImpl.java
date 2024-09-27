package service;

import model.agencia.Agencia;
import repository.AgenciaRepository;
import repository.AgenciaRepositoryImpl;

import java.util.List;

public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaRepository agenciaRepository;

    public AgenciaServiceImpl() {
        this.agenciaRepository = new AgenciaRepositoryImpl();
    }

    @Override
    public Agencia cadastrar(Agencia agencia) {
        return this.agenciaRepository.salvar(agencia);
    }

    @Override
    public List<Agencia> buscarPorNomeOuEndereco(String termo) {
        return this.agenciaRepository.buscarPorNomeOuEndereco(termo);
    }

    @Override
    public List<Agencia> listar() {
        return this.agenciaRepository.todos();
    }

    @Override
    public Agencia alterar(Agencia agencia) {
        return this.agenciaRepository.alterar(agencia);
    }
}