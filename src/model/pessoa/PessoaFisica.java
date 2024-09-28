package model.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;

    public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String gerarComprovanteAluguel() {
        return "Comprovante de Aluguel - Pessoa Física: " + getNome() + ", CPF: " + cpf;
    }

    @Override
    public String gerarComprovanteDevolucao() {
        return "Comprovante de Devolução - Pessoa Física: " + getNome() + ", CPF: " + cpf;
    }

    @Override
    public String toString() {
        return "Pessoa Fisica: " + getNome() +
                "cpf= " + cpf;
    }
}

