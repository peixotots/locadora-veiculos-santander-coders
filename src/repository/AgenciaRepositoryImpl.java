package repository;

import model.agencia.Agencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgenciaRepositoryImpl extends AgenciaRepository{

    private static AgenciaRepositoryImpl instancia;
    private List<Agencia> bancoDadosAgencia;

    private AgenciaRepositoryImpl() {
        bancoDadosAgencia = new ArrayList<>();
    }

    public static AgenciaRepositoryImpl getInstancia() {
        if (instancia == null) {
            instancia = new AgenciaRepositoryImpl();
        }
        return instancia;
    }

    @Override
    public Agencia salvar(Agencia agencia) {
        Optional<Agencia> agenciaExistente = bancoDadosAgencia.stream()
                .filter(a -> a.equals(agencia))
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
                .filter(agencia -> agencia.toString().contains(termo))
                .collect(Collectors.toList());
    }

    @Override
    public Agencia alterar(Agencia agencia) {
        Optional<Agencia> optionalAgencia = bancoDadosAgencia.stream()
                .filter(a -> a.equals(agencia))
                .findFirst();
        if (optionalAgencia.isPresent()) {
            Agencia agenciaBD = optionalAgencia.get();
            int index = bancoDadosAgencia.indexOf(agenciaBD);
            bancoDadosAgencia.set(index, agencia);
            return agenciaBD;
        } else {
            System.err.println("Agência não encontrada.");
        }
        return null;
    }
}