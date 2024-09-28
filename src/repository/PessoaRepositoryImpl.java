package repository;

import model.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaRepositoryImpl extends PessoaRepository{

    public static List<Pessoa> bancoDadosPessoa;

    public PessoaRepositoryImpl() {
        bancoDadosPessoa = new ArrayList<>();
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        bancoDadosPessoa.add(pessoa);
        return pessoa;
    }

    @Override
    public List<Pessoa> todos() {
        return bancoDadosPessoa;
    }

    @Override
    public Pessoa alterar(Pessoa pessoa) {
        Optional<Pessoa> optionalPessoa = this.buscarPorNome(pessoa.getNome());
        if (optionalPessoa.isPresent()) {
            Pessoa pessoaBD = optionalPessoa.get();
            int index = bancoDadosPessoa.indexOf(pessoaBD);
            pessoaBD.setEndereco(pessoa.getEndereco());
            pessoaBD.setTelefone(pessoa.getTelefone());
            bancoDadosPessoa.set(index, pessoaBD);
            return pessoaBD;
        } else {
            System.err.println("Pessoa não encontrada.");
        }
        return null;
    }

    @Override
    public Optional<Pessoa> buscarPorNome(String nome) {
        return bancoDadosPessoa
                .stream()
                .filter(pessoa -> pessoa.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    @Override
    public void remover(Pessoa pessoa) {
        if (bancoDadosPessoa.contains(pessoa)) {
            bancoDadosPessoa.remove(pessoa);
            System.out.println("Pessoa removida com sucesso.");
        } else {
            System.err.println("Pessoa não encontrada para remoção.");
        }
    }
}