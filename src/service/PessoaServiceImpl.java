package service;

import model.pessoa.Pessoa;
import repository.PessoaRepository;
import repository.PessoaRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl() {
        this.pessoaRepository = PessoaRepositoryImpl.getInstancia();
    }

    @Override
    public Pessoa cadastrar(Pessoa pessoa) {
        Optional<Pessoa> pessoaExistente = this.pessoaRepository.buscarPorNome(pessoa.getNome());
        if (pessoaExistente.isPresent()) {
            System.err.println("Pessoa já cadastrada.");
        } else {
            return this.pessoaRepository.salvar(pessoa);
        }
        return pessoa;
    }

    @Override
    public Pessoa alterar(Pessoa pessoa) {
        try {
            return this.pessoaRepository.alterar(pessoa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Pessoa buscarPorNome(String nome) {
        Optional<Pessoa> pessoaEncontrada = this.pessoaRepository.buscarPorNome(nome);
        if (pessoaEncontrada.isPresent()) {
            return pessoaEncontrada.get();
        } else {
            System.err.println("Pessoa não encontrada.");
            return null;
        }
    }

    @Override
    public List<Pessoa> listar() {
        return this.pessoaRepository.todos();
    }

    @Override
    public void remover(Pessoa pessoa) {
        this.pessoaRepository.remover(pessoa);
    }
}
