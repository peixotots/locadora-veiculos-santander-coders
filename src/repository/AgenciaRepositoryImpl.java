package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AgenciaRepositoryImpl<T> extends AgenciaRepository<T> {

    private final List<T> bancoDadosAgencia;

    public AgenciaRepositoryImpl() {
        this.bancoDadosAgencia = new ArrayList<>();
    }

    @Override
    public T salvar(T agencia) {
        Optional<T> agenciaExistente = bancoDadosAgencia.stream()
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
    public List<T> todos() {
        return bancoDadosAgencia;
    }

    @Override
    public List<T> buscarPorNomeOuEndereco(String termo) {
        return bancoDadosAgencia.stream()
                .filter(agencia -> agencia.toString().contains(termo))
                .collect(Collectors.toList());
    }

    @Override
    public T alterar(T agencia) {
        Optional<T> optionalAgencia = bancoDadosAgencia.stream()
                .filter(a -> a.equals(agencia))
                .findFirst();
        if (optionalAgencia.isPresent()) {
            T agenciaBD = optionalAgencia.get();
            int index = bancoDadosAgencia.indexOf(agenciaBD);
            bancoDadosAgencia.set(index, agencia);
            return agenciaBD;
        } else {
            System.err.println("Agência não encontrada.");
        }
        return null;
    }
}