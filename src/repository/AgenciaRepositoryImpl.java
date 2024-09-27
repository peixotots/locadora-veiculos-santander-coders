package repository;

import model.agencia.Agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgenciaRepositoryImpl extends AgenciaRepository {

    private final List<Agencia> bancoDadosAgencia;

    public AgenciaRepositoryImpl() {
        this.bancoDadosAgencia = new ArrayList<>();
    }

    @Override
    public Agencia salvar(Agencia agencia) {
        Optional<Agencia> agenciaExistente = bancoDadosAgencia.stream()
                .filter(a -> a.getNome().equals(agencia.getNome()) &&
                             a.getEndereco().equals(agencia.getEndereco()) &&
                             a.getIdentificador() == agencia.getIdentificador())
                .findFirst();

        if (agenciaExistente.isPresent()) {
            System.err.println("Agência já cadastrada.");
            return null;
        } else {
            bancoDadosAgencia.add(agencia);
            return agencia;
        }
    }

    @Override
    public List<Agencia> todos() {
        return bancoDadosAgencia;
    }

    @Override
    public List<Agencia> buscarPorNomeOuEndereco(String termo) {
        return bancoDadosAgencia.stream()
                .filter(agencia -> agencia.getNome().contains(termo) || agencia.getEndereco().contains(termo))
                .collect(Collectors.toList());
    }

    @Override
    public Agencia alterar(Agencia agencia) {
        Optional<Agencia> optionalAgencia = bancoDadosAgencia.stream()
                .filter(a -> a.getIdentificador() == agencia.getIdentificador())
                .findFirst();
        if (optionalAgencia.isPresent()) {
            Agencia agenciaBD = optionalAgencia.get();
            int index = bancoDadosAgencia.indexOf(agenciaBD);
            agenciaBD.setNome(agencia.getNome());
            agenciaBD.setEndereco(agencia.getEndereco());
            bancoDadosAgencia.set(index, agenciaBD);
            return agenciaBD;
        } else {
            System.err.println("Agência não encontrada.");
        }
        return null;
    }
}