package service;

import model.pessoa.Pessoa;
import repository.PessoaRepository;
import repository.PessoaRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class PessoaServiceImpl<T extends Pessoa> implements PessoaService<T> {

    private final PessoaRepository<T> pessoaRepository;

    public PessoaServiceImpl() {
        this.pessoaRepository = new PessoaRepositoryImpl<>();
    }

    @Override
    public T cadastrar(T pessoa) {
        Optional<T> pessoaExistente = this.pessoaRepository.buscarPorNome(pessoa.getNome());
        if (pessoaExistente.isPresent()) {
            System.err.println("Pessoa já cadastrada.");
        } else {
            return this.pessoaRepository.salvar(pessoa);
        }
        return pessoa;
    }

    @Override
    public T alterar(T pessoa) {
        try {
            return this.pessoaRepository.alterar(pessoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public T buscarPorNome(String nome) {
        Optional<T> pessoaEncontrada = this.pessoaRepository.buscarPorNome(nome);
        if (pessoaEncontrada.isPresent()) {
            return pessoaEncontrada.get();
        } else {
            System.err.println("Pessoa não encontrada.");
            return null;
        }
    }

    @Override
    public List<T> listar() {
        return this.pessoaRepository.todos();
    }

    @Override
    public void remover(T pessoa) {
        this.pessoaRepository.remover(pessoa);
    }
}
