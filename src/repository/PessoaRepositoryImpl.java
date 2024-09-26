package repository;

import model.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaRepositoryImpl<T extends Pessoa> extends PessoaRepository<T> {

    public List<T> bancoDadosPessoa;

    public PessoaRepositoryImpl() {
        bancoDadosPessoa = new ArrayList<>();
    }

    @Override
    public T salvar(T pessoa) {
        bancoDadosPessoa.add(pessoa);
        return pessoa;
    }

    @Override
    public List<T> todos() {
        return bancoDadosPessoa;
    }

    @Override
    public T alterar(T pessoa) {
        Optional<T> optionalPessoa = this.buscarPorNome(pessoa.getNome());
        if (optionalPessoa.isPresent()) {
            T pessoaBD = optionalPessoa.get();
            int index = this.bancoDadosPessoa.indexOf(pessoaBD);
            pessoaBD.setEndereco(pessoa.getEndereco());
            pessoaBD.setTelefone(pessoa.getTelefone());
            this.bancoDadosPessoa.set(index, pessoaBD);
            return pessoaBD;
        } else {
            System.err.println("Pessoa não encontrada.");
        }
        return null;
    }

    @Override
    public Optional<T> buscarPorNome(String nome) {
        return this.bancoDadosPessoa
                .stream()
                .filter(pessoa -> pessoa.getNome().contains(nome)).findFirst();
    }

    @Override
    public void remover(T pessoa) {
        if (bancoDadosPessoa.contains(pessoa)) {
            bancoDadosPessoa.remove(pessoa);
            System.out.println("Pessoa removida com sucesso.");
        } else {
            System.err.println("Pessoa não encontrada para remoção.");
        }
    }
}